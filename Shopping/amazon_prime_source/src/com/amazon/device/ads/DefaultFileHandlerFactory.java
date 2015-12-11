// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import java.io.File;

// Referenced classes of package com.amazon.device.ads:
//            FileHandlerFactory, FileInputHandler, FileOutputHandler

class DefaultFileHandlerFactory
    implements FileHandlerFactory
{

    DefaultFileHandlerFactory()
    {
    }

    public FileInputHandler createFileInputHandler(File file)
    {
        FileInputHandler fileinputhandler = new FileInputHandler();
        fileinputhandler.setFile(file);
        return fileinputhandler;
    }

    public FileInputHandler createFileInputHandler(File file, String s)
    {
        FileInputHandler fileinputhandler = new FileInputHandler();
        fileinputhandler.setFile(file, s);
        return fileinputhandler;
    }

    public FileInputHandler createFileInputHandler(String s)
    {
        FileInputHandler fileinputhandler = new FileInputHandler();
        fileinputhandler.setFile(s);
        return fileinputhandler;
    }

    public FileOutputHandler createFileOutputHandler(File file)
    {
        FileOutputHandler fileoutputhandler = new FileOutputHandler();
        fileoutputhandler.setFile(file);
        return fileoutputhandler;
    }

    public FileOutputHandler createFileOutputHandler(File file, String s)
    {
        FileOutputHandler fileoutputhandler = new FileOutputHandler();
        fileoutputhandler.setFile(file, s);
        return fileoutputhandler;
    }

    public FileOutputHandler createFileOutputHandler(String s)
    {
        FileOutputHandler fileoutputhandler = new FileOutputHandler();
        fileoutputhandler.setFile(s);
        return fileoutputhandler;
    }
}
