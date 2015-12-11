// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import java.io.File;

// Referenced classes of package com.amazon.device.ads:
//            FileInputHandler, FileOutputHandler

interface FileHandlerFactory
{

    public abstract FileInputHandler createFileInputHandler(File file);

    public abstract FileInputHandler createFileInputHandler(File file, String s);

    public abstract FileInputHandler createFileInputHandler(String s);

    public abstract FileOutputHandler createFileOutputHandler(File file);

    public abstract FileOutputHandler createFileOutputHandler(File file, String s);

    public abstract FileOutputHandler createFileOutputHandler(String s);
}
