package lendoxlsx;

import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
 
public class Email
{
        
    private static String senha;
    private static String email;
   
 
   
      public void enviar(Alunos aluno) {
          
         
            Properties props = new Properties();
            /** Parâmetros de conexão com servidor Gmail */
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.socketFactory.port", "465");
            props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.port", "465");
 
            Session session = Session.getDefaultInstance(props,
                        new javax.mail.Authenticator() {
                             protected PasswordAuthentication getPasswordAuthentication() 
                             {
                                   return new PasswordAuthentication(email,senha);
                             }
                        });
 
            /** Ativa Debug para sessão */
            session.setDebug(true);
 
            try {
 
                  Message message = new MimeMessage(session);
                  message.setFrom(new InternetAddress(email)); //Remetente
 
                  Address[] toUser = InternetAddress //Destinatário(s)
                             .parse(aluno.email);  
 
                  message.setRecipients(Message.RecipientType.TO, toUser);
                  message.setSubject("Resultado - Avaliação de suas Habilidades de Estudo");//Assunto
                  if(aluno.pontosTotal >= 50){
                  message.setText("Aluno(a): "+aluno.nome+"\nSua Avaliação Geral como Estudante\nPontuação: "+aluno.pontosTotal+"\nNota: 10\nVocê é excepcionalmente competente"
                          + "\n\nSua Avaliação por Área pessoal que influencia no Estudo\nMotivação: "+aluno.pontosMotivacao+"\nAuto-Estima: "+aluno.pontosAE+"\nAutoconfiança: "
                          +aluno.pontosAC+"\nOrganização: "+aluno.pontosOr+"\nProjeto de Vida: "+aluno.pontosProj);
                   
                  }else if(aluno.pontosTotal >= 40 && aluno.pontosTotal <= 49){
                       message.setText("Aluno(a): "+aluno.nome+"\nSua Avaliação Geral como Estudante\nPontuação: "+aluno.pontosTotal+"\nNota: 9\nVocê é extraordinariamente competente"
                          + "\n\nSua Avaliação por Área pessoal que influencia no Estudo\nMotivação: "+aluno.pontosMotivacao+"\nAuto-Estima: "+aluno.pontosAE+"\nAutoconfiança: "
                          +aluno.pontosAC+"\nOrganização: "+aluno.pontosOr+"\nProjeto de Vida: "+aluno.pontosProj);
                      
                  }else if(aluno.pontosTotal >= 30 && aluno.pontosTotal <= 39){
                       message.setText("Aluno(a): "+aluno.nome+"\nSua Avaliação Geral como Estudante\nPontuação: "+aluno.pontosTotal+"\nNota: 8\nVocê é notavelmente competente"
                          + "\n\nSua Avaliação por Área pessoal que influencia no Estudo\nMotivação: "+aluno.pontosMotivacao+"\nAuto-Estima: "+aluno.pontosAE+"\nAutoconfiança: "
                          +aluno.pontosAC+"\nOrganização: "+aluno.pontosOr+"\nProjeto de Vida: "+aluno.pontosProj);
                  }else if(aluno.pontosTotal >= 20 && aluno.pontosTotal <= 29){
                      message.setText("Aluno(a): "+aluno.nome+"\nSua Avaliação Geral como Estudante\nPontuação: "+aluno.pontosTotal+"\nNota: 7\nVocê é francamente competente"
                          + "\n\nSua Avaliação por Área pessoal que influencia no Estudo\nMotivação: "+aluno.pontosMotivacao+"\nAuto-Estima: "+aluno.pontosAE+"\nAutoconfiança: "
                          +aluno.pontosAC+"\nOrganização: "+aluno.pontosOr+"\nProjeto de Vida: "+aluno.pontosProj);  
                  }else if(aluno.pontosTotal >= 10 && aluno.pontosTotal <= 19){
                      message.setText("Aluno(a): "+aluno.nome+"\nSua Avaliação Geral como Estudante\nPontuação: "+aluno.pontosTotal+"\nNota: 6\nVocê é moderadamente competente"
                          + "\n\nSua Avaliação por Área pessoal que influencia no Estudo\nMotivação: "+aluno.pontosMotivacao+"\nAuto-Estima: "+aluno.pontosAE+"\nAutoconfiança: "
                          +aluno.pontosAC+"\nOrganização: "+aluno.pontosOr+"\nProjeto de Vida: "+aluno.pontosProj);
                  }else if(aluno.pontosTotal >= 1 && aluno.pontosTotal <= 9){
                      message.setText("Aluno(a): "+aluno.nome+"\nSua Avaliação Geral como Estudante\nPontuação: "+aluno.pontosTotal+"\nNota: 5\nVocê é tenuemente competente"
                          + "\n\nSua Avaliação por Área pessoal que influencia no Estudo\nMotivação: "+aluno.pontosMotivacao+"\nAuto-Estima: "+aluno.pontosAE+"\nAutoconfiança: "
                          +aluno.pontosAC+"\nOrganização: "+aluno.pontosOr+"\nProjeto de Vida: "+aluno.pontosProj);
                  }else if(aluno.pontosTotal <= 0 && aluno.pontosTotal >= -9){
                      message.setText("Aluno(a): "+aluno.nome+"\nSua Avaliação Geral como Estudante\nPontuação: "+aluno.pontosTotal+"\nNota: 4\nVocê é tenuemente incompetente"
                          + "\n\nSua Avaliação por Área pessoal que influencia no Estudo\nMotivação: "+aluno.pontosMotivacao+"\nAuto-Estima: "+aluno.pontosAE+"\nAutoconfiança: "
                          +aluno.pontosAC+"\nOrganização: "+aluno.pontosOr+"\nProjeto de Vida: "+aluno.pontosProj);
                      
                  }else if(aluno.pontosTotal <= -10 && aluno.pontosTotal <= -19){
                      message.setText("Aluno(a): "+aluno.nome+"\nSua Avaliação Geral como Estudante\nPontuação: "+aluno.pontosTotal+"\nNota: 3\nVocê é moderedamente incompetente"
                          + "\n\nSua Avaliação por Área pessoal que influencia no Estudo\nMotivação: "+aluno.pontosMotivacao+"\nAuto-Estima: "+aluno.pontosAE+"\nAutoconfiança: "
                          +aluno.pontosAC+"\nOrganização: "+aluno.pontosOr+"\nProjeto de Vida: "+aluno.pontosProj);
                  }else if(aluno.pontosTotal <= -20 && aluno.pontosTotal <= -29){
                      message.setText("Aluno(a): "+aluno.nome+"\nSua Avaliação Geral como Estudante\nPontuação: "+aluno.pontosTotal+"\nNota: 2\nVocê é francamente incompetente"
                          + "\n\nSua Avaliação por Área pessoal que influencia no Estudo\nMotivação: "+aluno.pontosMotivacao+"\nAuto-Estima: "+aluno.pontosAE+"\nAutoconfiança: "
                          +aluno.pontosAC+"\nOrganização: "+aluno.pontosOr+"\nProjeto de Vida: "+aluno.pontosProj);
                  }else if(aluno.pontosTotal <= -30 && aluno.pontosTotal <= -39){
                      message.setText("Aluno(a): "+aluno.nome+"\nSua Avaliação Geral como Estudante\nPontuação: "+aluno.pontosTotal+"\nNota: 1\nVocê é extraordinariamente incompetente"
                          + "\n\nSua Avaliação por Área pessoal que influencia no Estudo\nMotivação: "+aluno.pontosMotivacao+"\nAuto-Estima: "+aluno.pontosAE+"\nAutoconfiança: "
                          +aluno.pontosAC+"\nOrganização: "+aluno.pontosOr+"\nProjeto de Vida: "+aluno.pontosProj);
                  }else {
                      message.setText("Aluno(a): "+aluno.nome+"\nSua Avaliação Geral como Estudante\nPontuação: "+aluno.pontosTotal+"\nNota: 0\nVocê é redondamente incompetente"
                          + "\n\nSua Avaliação por Área pessoal que influencia no Estudo\nMotivação: "+aluno.pontosMotivacao+"\nAuto-Estima: "+aluno.pontosAE+"\nAutoconfiança: "
                          +aluno.pontosAC+"\nOrganização: "+aluno.pontosOr+"\nProjeto de Vida: "+aluno.pontosProj);
                  }
                  
                  /**Método para enviar a mensagem criada*/
                  Transport.send(message);
                  
                  
                  
                  
 
             } catch (MessagingException e) {
                 
              
               
               Interface3 erro = new Interface3();
                 erro.setResizable(false);
                 erro.setLocation(550, 200);
                 erro.setVisible(true);
                  throw new RuntimeException(e);
           
            }
            
            
           
      }

    public static String getSenha() {
        return senha;
    }

    public static void setSenha(String senha) {
        Email.senha = senha;
    }

    public static String getEmail() {
        return email;
    }

    public static void setEmail(String email) {
        Email.email = email;
    }
      
}