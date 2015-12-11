// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.googlecode.javacpp;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

// Referenced classes of package com.googlecode.javacpp:
//            Loader

static final class  extends Thread
{

    public void run()
    {
        if (Loader.tempDir == null)
        {
            return;
        }
        try
        {
            LinkedList linkedlist = new LinkedList();
            linkedlist.add((new StringBuilder()).append(System.getProperty("java.home")).append("/bin/java").toString());
            linkedlist.add("-classpath");
            linkedlist.add(System.getProperty("java.class.path"));
            linkedlist.add(com/googlecode/javacpp/Loader.getName());
            linkedlist.add(Loader.tempDir.getAbsolutePath());
            (new ProcessBuilder(linkedlist)).start();
            return;
        }
        catch (IOException ioexception)
        {
            throw new RuntimeException(ioexception);
        }
    }

    ()
    {
    }
}
