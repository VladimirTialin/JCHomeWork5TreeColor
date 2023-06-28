package ru.geekbrains.lesson5;

import java.io.File;

public class Tree {
    private static final String colorDir="\u001B[32m";
    private static final String colorFile="\u001B[34m";
    private static final String colorNone="\u001B[0m";

    /**
     * TODO: Доработать метод print, необходимо распечатывать директории и файлы
     * @param file
     * @param indent
     * @param isLast
     */
    public static void print(File file, String indent, boolean isLast){

        System.out.print(indent); // рисуем отступ
        if (isLast){
            System.out.print("└─");
            indent += "  ";
        }
        else {
            System.out.print("├─");
            indent += "│ ";
        }
        // Не оптимизировал код, решил просто доработать то, что есть:)
        // добавил цветной вывод
        if (file.isDirectory()) {
            System.out.println(colorDir+file.getName()+colorNone);
        }
        else {
                System.out.println(colorFile+file.getName()+colorNone);
            }

        File[] files = file.listFiles();
        if (files == null)
            return;

        int subDirTotal = 0, subFileTotal = 0; // subFileTotal счетчик файлов
        for (int i = 0; i < files.length; i++){
           if (files[i].isDirectory())
               subDirTotal++;
           if(files[i].isFile())
               subFileTotal++;
        }

        int subDirCounter = 0;
        for (int i = 0; i < files.length; i++){
            if (files[i].isDirectory()){
                print(files[i], indent, subDirCounter  == subDirTotal - 1);
                subDirCounter++;
            }
            // проверяем является ли наш объект файлом и печатаем его
            if (files[i].isFile()){
                print(files[i],indent,subDirCounter==subFileTotal-1);
            }
        }
    }


}
