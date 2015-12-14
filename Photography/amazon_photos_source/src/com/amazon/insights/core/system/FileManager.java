// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.insights.core.system;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Set;

public interface FileManager
{

    public abstract File createDirectory(String s);

    public abstract File createFile(File file)
        throws IOException;

    public abstract boolean deleteFile(File file);

    public abstract File getDirectory(String s);

    public abstract Set listFilesInDirectory(File file);

    public abstract InputStream newInputStream(File file)
        throws FileNotFoundException;

    public abstract OutputStream newOutputStream(File file, boolean flag)
        throws FileNotFoundException;
}
