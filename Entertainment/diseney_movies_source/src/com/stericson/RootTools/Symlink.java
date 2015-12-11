// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.stericson.RootTools;

import java.io.File;

public class Symlink
{

    protected final File file;
    protected final File symlinkPath;

    Symlink(File file1, File file2)
    {
        file = file1;
        symlinkPath = file2;
    }

    public File getFile()
    {
        return file;
    }

    public File getSymlinkPath()
    {
        return symlinkPath;
    }
}
