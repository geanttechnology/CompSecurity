// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.tape;

import java.io.File;
import java.io.IOException;

public class FileException extends RuntimeException
{

    private final File file;

    public FileException(String s, IOException ioexception, File file1)
    {
        super(s, ioexception);
        file = file1;
    }
}
