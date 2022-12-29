/*
Simple image viewer and manipulator written in Java using the Swing GUI library
Copyright (C) 2022 Apostolos Halis

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program.  If not, see <https://www.gnu.org/licenses/>.
*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class OpenFile extends JFrame {
    private String filename;
    public OpenFile() {
        //initialize JFrame and JPanel
        JFrame window = new JFrame();
        JPanel panel = new JPanel();
        //set layouts for both 'window' and 'frame'
        window.setLayout(new BorderLayout());
        window.add(panel, BorderLayout.CENTER);
        panel.setLayout(new BorderLayout());
//       set background color for the JPanel
        panel.setBackground(Color.DARK_GRAY);

//create the button and add it to the bottom of the screen
// TODO: change the layout so the button can be in the center of the screen

        JButton openFileButton = new JButton("Open File");
        panel.add(openFileButton, BorderLayout.SOUTH);

        openFileButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    filename = selectedFile.getName();
                    ImageViewer imageV = new ImageViewer(filename);
                }
            }
        });
        window.setVisible(true);
    }
}
