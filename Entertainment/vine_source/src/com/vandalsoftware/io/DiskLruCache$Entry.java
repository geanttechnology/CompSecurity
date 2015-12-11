// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.vandalsoftware.io;

import java.io.File;

// Referenced classes of package com.vandalsoftware.io:
//            DiskLruCache

public final class <init>
{

    private  currentEditor;
    private final String key;
    private final long lengths[];
    private boolean readable;
    final DiskLruCache this$0;

    public File getCleanFile(int i)
    {
        return new File(DiskLruCache.access$1600(DiskLruCache.this), (new StringBuilder()).append(key).append(".").append(i).toString());
    }

    public File getDirtyFile(int i)
    {
        return new File(DiskLruCache.access$1600(DiskLruCache.this), (new StringBuilder()).append(key).append(".").append(i).append(".tmp").toString());
    }



/*
    static boolean access$502( , boolean flag)
    {
        .readable = flag;
        return flag;
    }

*/



/*
    static  access$602( ,  1)
    {
        .currentEditor = 1;
        return 1;
    }

*/



    private currentEditor(String s)
    {
        this$0 = DiskLruCache.this;
        super();
        key = s;
        lengths = new long[DiskLruCache.access$1500(DiskLruCache.this)];
    }

    ._cls1500(String s, ._cls1500 _pcls1500)
    {
        this(s);
    }
}
