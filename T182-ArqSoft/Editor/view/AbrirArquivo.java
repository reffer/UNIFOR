package br.unifor.view;
import java.util.List;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;
	
public class AbrirArquivo extends AbstractAction {

	private JTextArea texto;

	//construtor: recebe o texto inserido pelo usuário no textarea da janela
	public AbrirArquivo(JTextArea texto) {		
		super("Abrir");	
		this.texto = texto;
		this.putValue(Action.SHORT_DESCRIPTION, "Abrir arquivo java");		
	}
	
	private void putValue(String shortDescription, String string) {
		// TODO Auto-generated method stub
		
	}

	public void actionPerformed(ActionEvent ev) {
		String caminhoArquivo = "";
        JFileChooser arquivo = new JFileChooser();
        arquivo.setAcceptAllFileFilterUsed(false);
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.Java", "java");
        arquivo.setFileFilter(filtro);	
       
        int retorno = arquivo.showOpenDialog(null);
        if(retorno == JFileChooser.APPROVE_OPTION){
        	File arquivoJava = arquivo.getSelectedFile();
        	Path path = Paths.get(arquivoJava.getAbsolutePath());
        	Charset cs = Charset.forName("UTF-8");
        	try {
				List<String> conteudo = Files.readAllLines(path,cs);
				texto.setText(conteudo.toString());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
         //      caminhoArquivo = arquivo.getSelectedFile().getAbsolutePath();
           //    JOptionPane.showMessageDialog(null, caminhoArquivo);
         }else{
               //não abriu
         }
   }
}

