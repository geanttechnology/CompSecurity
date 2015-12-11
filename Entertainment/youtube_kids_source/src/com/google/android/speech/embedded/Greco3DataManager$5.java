// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.speech.embedded;

import java.io.File;
import java.io.FileFilter;

final class 
    implements FileFilter
{

    public final boolean accept(File file)
    {
        return file.isDirectory();
    }

    ()
    {
    }
}
