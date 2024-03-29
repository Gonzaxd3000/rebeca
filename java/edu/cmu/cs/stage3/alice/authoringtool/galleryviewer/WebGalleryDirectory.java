/*
 * Copyright (c) 1999-2003, Carnegie Mellon University. All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 * 
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 * 
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 * 
 * 3. Products derived from the software may not be called "Alice",
 *    nor may "Alice" appear in their name, without prior written
 *    permission of Carnegie Mellon University.
 * 
 * 4. All advertising materials mentioning features or use of this software
 *    must display the following acknowledgement:
 *    "This product includes software developed by Carnegie Mellon University"
 */

package edu.cmu.cs.stage3.alice.authoringtool.galleryviewer;

public class WebGalleryDirectory extends WebGalleryObject {

    protected GalleryViewer.DirectoryStructure directoryData;
    protected boolean isTopLevelDirectory = false;
   
								

    protected static java.awt.Color webDirColor = new java.awt.Color(189,184,139);

    protected String getToolTipString(){
        return java.util.ResourceBundle.getBundle("edu/cmu/cs/stage3/alice/authoringtool/galleryviewer/WebGalleryDirectory").getString("<html><body><p>Group_of_Objects</p><p>Click_to_open_this_group.</p></body></html>");
    }

    public void set(GalleryViewer.ObjectXmlData dataIn) throws java.lang.IllegalArgumentException{
        if (dataIn != null){
            directoryData = dataIn.directoryData;
            super.set(dataIn);
        }
    }
    
	protected String getClassName(){
		return " ";
	}


    protected void guiInit(){
        super.guiInit();
        this.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        this.setBackground(webDirColor);
        this.setDragEnabled(false);
        this.remove(grip);
    }

    protected void updateGUI(){
        super.updateGUI();
    }

    public void setImage(javax.swing.ImageIcon imageIcon){
        if (imageIcon == GalleryViewer.noImageIcon){
            super.setImage(GalleryViewer.noFolderImageIcon);
        }
        else{
            super.setImage(imageIcon);
        }
    }

    public void respondToMouse(){
        if (mainViewer != null){
        	int dialogVal = -1;
        	if (!GalleryViewer.alreadyEnteredWebGallery && mainViewer.shouldShowWebWarning()){
				dialogVal = edu.cmu.cs.stage3.swing.DialogManager.showConfirmDialog(java.util.ResourceBundle.getBundle("edu/cmu/cs/stage3/alice/authoringtool/galleryviewer/WebGalleryDirectory").getString("You_are_about_to_enter_the_online_gallery._This_is_accessed_through_the_internet\n")
				+" "+java.util.ResourceBundle.getBundle("edu/cmu/cs/stage3/alice/authoringtool/galleryviewer/WebGalleryDirectory").getString("_and_is_potentially_slow_depending_on_your_connection."), java.util.ResourceBundle.getBundle("edu/cmu/cs/stage3/alice/authoringtool/galleryviewer/WebGalleryDirectory").getString("Web_gallery_may_be_slow"), javax.swing.JOptionPane.WARNING_MESSAGE);
				if (dialogVal == javax.swing.JOptionPane.YES_OPTION){
					GalleryViewer.enteredWebGallery();
					mainViewer.changeDirectory(directoryData);
				}
        	}
        	else {
				GalleryViewer.enteredWebGallery();
				mainViewer.changeDirectory(directoryData);
        	}
        }
    }


    public void galleryMouseExited(){
       /* if (mouseOver){
            mouseOver = false;
            this.repaint();
        }*/
    }

    public void galleryMouseEntered(){
       /* if (!mouseOver){
            mouseOver = true;
            this.repaint();
        }*/
    }

}