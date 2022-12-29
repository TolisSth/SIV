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
import java.util.ArrayList;

public class ImageViewer{
    //This class handles the display of the image, it reads the filename give to the constructor and spawns a JFrame
    // with the image attached on it.
    private final String filename;
    private final ArrayList<Integer> dimensionsOfImage = new ArrayList<Integer>(2);

    public void displayImage(){
        //loading the image
        ImageIcon img = new ImageIcon(filename);
        Image image = img.getImage();

        dimensionsOfImage.add(image.getWidth(null)); //calculating width
        dimensionsOfImage.add(image.getHeight(null)); //calculating height

        JFrame frame = new JFrame(); // create a new frame
        ImagePanel panel = new ImagePanel(image); // create a new panel

        //setting sized to both JFrame and JPanel
        panel.setMinimumSize(new Dimension(dimensionsOfImage.get(0),dimensionsOfImage.get(1)));
        frame.setMinimumSize(new Dimension(dimensionsOfImage.get(0), dimensionsOfImage.get(1)));

        //panel settings
        panel.setBackground(Color.DARK_GRAY);
        panel.setLayout(new BorderLayout());

        //frame settings
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // set the default close operation
        frame.setTitle("SIV ~ " + filename); // set the frame title

        frame.add(panel);
        frame.pack(); // resize the frame to fit the image
        frame.setVisible(true); // make the frame visible
    }
    public ImageViewer(String f){
        filename = f;
    }
}