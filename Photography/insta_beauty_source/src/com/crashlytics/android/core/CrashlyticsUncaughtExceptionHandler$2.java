// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.crashlytics.android.core;

import java.io.File;
import java.util.Comparator;

final class 
    implements Comparator
{

    public int compare(File file, File file1)
    {
        return file1.getName().compareTo(file.getName());
    }

    public volatile int compare(Object obj, Object obj1)
    {
        return compare((File)obj, (File)obj1);
    }

    ()
    {
    }
}
