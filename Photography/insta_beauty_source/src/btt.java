// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.io.File;
import java.util.Comparator;

public final class btt
    implements Comparator
{

    public btt()
    {
    }

    public int a(File file, File file1)
    {
        return (int)(file.lastModified() - file1.lastModified());
    }

    public int compare(Object obj, Object obj1)
    {
        return a((File)obj, (File)obj1);
    }
}
