package com.model.operations;
import com.model.*;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class BusinessLevelOperations implements FileInterface  {
	List<String> retrieve= new ArrayList<String>();
	File[] files = new File("C:\\Users\\Hewlett - Packard\\eclipse-workspace\\Phase 1 FSD Project").listFiles();
	@Override
	public void showAllFiles() {
		// TODO Auto-generated method stub
		for(File file : files) {
			if(file.isFile()) {
				retrieve.add(file.getName());
				//System.out.println(file.getName());
			}
		}
		retrieve.forEach(System.out::println);
		
	}

	//@Override
	public void addFile() {
		// TODO Auto-generated method stub
		System.out.println("Enter the file which you want to add:");
		//sc.next();
		Scanner scan =new Scanner(System.in);
		String filename= scan.nextLine();
		File F= new File(filename);
		try {
			if(F.createNewFile()) {
				System.out.println(filename+" file is added to the directory");
				Desktop.getDesktop().edit(F);
			}
			else {
				System.out.println("This file is already there");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}

	@Override
	public void deleteFile() {
		// TODO Auto-generated method stub
		System.out.println("Enter the file which you want to delete:");
		//sc.next();
		Scanner scan=new Scanner(System.in);
		String filename=scan.nextLine();
		File F= new File(filename);
		if(F.delete())
			System.out.println(filename+" got Deleted");
		else
			System.out.println("File Not Found");
	}

	@Override
	public void searchFile() {
		// TODO Auto-generated method stub
		try {	
			Scanner scan= new Scanner(System.in);
			File directory = new File("C:\\\\Users\\\\Hewlett - Packard\\\\eclipse-workspace\\\\Phase 1 FSD Project");
			System.out.println("Enter the file name which you want to search:");
			String fileName=scan.nextLine();
            File[] files=directory.listFiles();
            int flag=0;
            for (File file : files) {
                String name = file.getName();
                if (name.equals(fileName)) {
                       // System.out.println("The filename "+fileName+" is present in the directory");
        				File f= new File(fileName);
        				Scanner sc1 = new Scanner(f);
        				while(sc1.hasNextLine()) {
        				System.out.println(sc1.nextLine());
        				}
        			flag=1;	
                }
			}
        if(flag==0) {
        	System.out.println("File not found");
        }
        	
		}catch(FileNotFoundException ex) {
			System.out.println("file not found");
		}
		
	}

}
