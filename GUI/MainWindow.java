package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import Entity.*;
import File.*;

public class MainWindow extends JFrame implements ActionListener {
     Font font15 = new Font( "Consoles" , Font.BOLD , 15 );
     JLabel titleLabel , genreLabel , episodesLabel , statusLabel , ratingLabel;
     JLabel AnimeLabel;

     JButton addButton , removeButton , updateButton , showButton , saveButton , clearButton;

     JTextField titleField , genreField , episodesField , statusField , ratingField;
       
     JTextArea displayArea;

      JLabel createLabel(int x,int y, int w, int h,String text){
		JLabel c = new JLabel(text);
		c.setBounds(x,y,w,h);
		c.setFont(font15);
		
		c.setForeground(Color.WHITE);
		this.add(c);
		return c;
	}
    
	JTextField createTextField(int x,int y, int w, int h,String text){
		JTextField c = new JTextField(text);
		c.setBounds(x,y,w,h);
		c.setFont(font15);
		c.addActionListener(this);
		this.add(c);
		return c;
	}
    

    JButton createButton(int x,int y, int w, int h,String text){
		JButton c = new JButton(text);
		c.setBounds(x,y,w,h);
		c.setFont(font15);
		c.setBackground(new Color(66, 245, 179));
		//c.setForeground(Color.WHITE);
		c.addActionListener(this);
		this.add(c);
		return c;
	}


    Watchlist watchlist = new Watchlist();

     public MainWindow() {
         setTitle("Anime Watchlist");
         this.setSize(800, 600);
         this.setLocation(200 , 50);
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         this.setResizable(false);
         this.setIconImage(new ImageIcon("./images/animate.png").getImage());
         this.setLayout(null);

         
         
         FileIO.loadFromFile(watchlist);

        

         AnimeLabel = createLabel (10 , 40 , 190 , 30 , "YOUR ANIME WATCHLIST" );
        JLabel AnimeLabelIamge = new JLabel(new ImageIcon("./images/otaku.png"));

        AnimeLabelIamge.setBounds(200 , 40 , 30 , 30);
        AnimeLabelIamge.setOpaque(true);
        this.add(AnimeLabelIamge);


         clearButton = new JButton(new ImageIcon("./images/refresh.png"));
         clearButton.setBounds(280 , 40 , 30 , 30);
         clearButton.addActionListener(this);
         this.add(clearButton);

        titleLabel = createLabel(10 , 80 , 150 , 30 , "Anime Name :" );
        titleField = createTextField(160 , 80 , 150 , 30 , "" );
        genreLabel = createLabel(10 , 120 , 150 , 30 , "Genre :" );
        genreField = createTextField(160 , 120 , 150 , 30 , "" );
        episodesLabel = createLabel(10 , 160 , 150 , 30 , "Episodes :" );
        episodesField = createTextField(160 , 160 , 150 , 30 , "" );
        statusLabel = createLabel(10 , 200 , 150 , 30 , "Status :" );
        statusField = createTextField(160 , 200 , 150 , 30 , "" );
        ratingLabel = createLabel(10 , 240 , 150 , 30 , "Rating :" );
        ratingField = createTextField(160 , 240 , 150 , 30 , "" );


        updateButton = createButton(10 , 280 , 150 , 30 , "Update" );
        //updateButton.setOpaque(true);
        //updateButton.setContentAreaFilled(true);
        //updateButton.setBorderPainted(false);
        updateButton.setBackground(new Color(255 , 187 , 59  ));
        updateButton.setForeground(Color.WHITE);

        addButton = createButton(170 , 280 , 150 , 30 , "Add" );
        //addButton.setOpaque(true);
        //addButton.setContentAreaFilled(true);
        //addButton.setBorderPainted(false);
        addButton.setBackground(new Color(255 , 110 , 64   ));
        addButton.setForeground(Color.WHITE);

        showButton = createButton(10 , 320 , 150 , 30 ,  "Show" );
        //showButton.setOpaque(true);
        //showButton.setContentAreaFilled(true);
        //showButton.setBorderPainted(false);
        showButton.setBackground(new Color(70 , 88 , 64  ));
        showButton.setForeground(Color.WHITE);

        removeButton = createButton(170 , 320 , 150 , 30 , "Remove" );
        //removeButton.setOpaque(true);
        //removeButton.setContentAreaFilled(true);
        //removeButton.setBorderPainted(false);
        removeButton.setBackground(new Color(215 , 55 , 55 ));
        removeButton.setForeground(Color.WHITE);

        saveButton = createButton(10 , 360 , 150 , 30 , "Save" );
        saveButton.setOpaque(true);
        //saveButton.setContentAreaFilled(true);
        //saveButton.setBorderPainted(false);
        //saveButton.setBackground(new Color(255 , 110 , 64  ));
        saveButton.setForeground(Color.WHITE);

         displayArea = new JTextArea();
         displayArea.setBounds(330, 80, 440, 400 );
         displayArea.setFont(font15);
         JScrollPane scrollPane = new JScrollPane(displayArea);
         scrollPane.setBounds(330, 80, 440, 400);
         this.add(scrollPane);
         updateDisplayArea();

         JLabel background = new JLabel(new ImageIcon("./images/illustration-anime-city.jpg"));
         background.setBounds(0,0,800,600);
         this.add(background);
         this.setVisible(true);
   
     }

     public void updateDisplayArea() {
         displayArea.setText(watchlist.getWatchlist());
        
         displayArea.setEditable(false);
     }

     @Override
     public void actionPerformed(ActionEvent e){
          if (e.getSource() == addButton){
       
        String title = titleField.getText();
        String genre = genreField.getText();
        String status = statusField.getText();
        
        try {
            int episodes = Integer.parseInt(episodesField.getText());
            double rating = Double.parseDouble(ratingField.getText());
            
            if (rating < 0 || rating > 10) {
                JOptionPane.showMessageDialog(this, "Rating must be between 0 and 10.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if(!title.isEmpty() && !genre.isEmpty() && episodes > 0 && !status.isEmpty()) {
                Anime anime = new Anime(title, genre, episodes, status, rating);
                watchlist.addAnime(anime);
                updateDisplayArea();
            } else {
                JOptionPane.showMessageDialog(this, "Please fill in all fields correctly." , "Warning" , JOptionPane.WARNING_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid input for episodes or rating.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (title.isEmpty() || genre.isEmpty() || status.isEmpty() ) {
        JOptionPane.showMessageDialog(this, "All fields must be filled in.", "Warning", JOptionPane.WARNING_MESSAGE);
        return;

            }

        }
    

            else if(e.getSource() == removeButton){
            String title = titleField.getText();
            if(!title.isEmpty()) {
                watchlist.removeAnime(title);
                updateDisplayArea();
            } else {
                JOptionPane.showMessageDialog(this, "Please enter a title to remove." , "Warning" , JOptionPane.WARNING_MESSAGE);
            }
            }

            else if(e.getSource() == updateButton){
            String title = titleField.getText();
            String genre = genreField.getText();
            String status = statusField.getText();
            try {
                int episodes = Integer.parseInt(episodesField.getText());
                double rating = Double.parseDouble(ratingField.getText());
                
                if (rating < 0 || rating > 10) {
                    JOptionPane.showMessageDialog(this, "Rating must be between 0 and 10.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if(!title.isEmpty() && !genre.isEmpty() && episodes > 0 && !status.isEmpty()) {
                    Anime anime = new Anime(title, genre, episodes, status, rating);
                    watchlist.updateAnime(title, genre, episodes, status, rating);
                    updateDisplayArea();
                } else {
                    JOptionPane.showMessageDialog(this, "Please fill in all fields correctly." , "Warning" , JOptionPane.WARNING_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid input for episodes or rating.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            }

    else if(e.getSource() == showButton){
        if (watchlist.getWatchlist().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Watchlist is empty.", "Info", JOptionPane.INFORMATION_MESSAGE);
        } else {
            updateDisplayArea();
        }
    }

    else if(e.getSource() == saveButton){
            if (watchlist.getWatchlist().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Watchlist is empty. Nothing to save.", "Warning", JOptionPane.WARNING_MESSAGE);
            } else {
            FileIO.saveToFile(watchlist);
            JOptionPane.showMessageDialog(this, "Watchlist saved to file.", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
            }

            else if(e.getSource() == clearButton){
                titleField.setText("");
                genreField.setText("");
                episodesField.setText("");
                statusField.setText("");
                ratingField.setText("");
            }

            

        }



    
}
