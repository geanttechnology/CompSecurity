// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

// Referenced classes of package com.squareup.okhttp.internal:
//            DiskLruCache

final class <init>
{

    private final File cleanFiles[];
    private  currentEditor;
    private final File dirtyFiles[];
    private final String key;
    private final long lengths[];
    private boolean readable;
    private long sequenceNumber;
    final DiskLruCache this$0;

    private IOException invalidLengths(String as[])
    {
        throw new IOException((new StringBuilder()).append("unexpected journal line: ").append(Arrays.toString(as)).toString());
    }

    private void setLengths(String as[])
    {
        if (as.length != DiskLruCache.access$2100(DiskLruCache.this))
        {
            throw invalidLengths(as);
        }
        int i = 0;
        do
        {
            try
            {
                if (i >= as.length)
                {
                    break;
                }
                lengths[i] = Long.parseLong(as[i]);
            }
            catch (NumberFormatException numberformatexception)
            {
                throw invalidLengths(as);
            }
            i++;
        } while (true);
    }

    public String getLengths()
    {
        StringBuilder stringbuilder = new StringBuilder();
        long al[] = lengths;
        int j = al.length;
        for (int i = 0; i < j; i++)
        {
            long l = al[i];
            stringbuilder.append(' ').append(l);
        }

        return stringbuilder.toString();
    }







/*
    static long access$1402( , long l)
    {
        .sequenceNumber = l;
        return l;
    }

*/



/*
    static boolean access$602(sequenceNumber sequencenumber, boolean flag)
    {
        sequencenumber.readable = flag;
        return flag;
    }

*/



/*
    static  access$702( ,  1)
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
        lengths = new long[DiskLruCache.access$2100(DiskLruCache.this)];
        cleanFiles = new File[DiskLruCache.access$2100(DiskLruCache.this)];
        dirtyFiles = new File[DiskLruCache.access$2100(DiskLruCache.this)];
        s = (new StringBuilder(s)).append('.');
        int j = s.length();
        for (int i = 0; i < DiskLruCache.access$2100(DiskLruCache.this); i++)
        {
            s.append(i);
            cleanFiles[i] = new File(DiskLruCache.access$2200(DiskLruCache.this), s.toString());
            s.append(".tmp");
            dirtyFiles[i] = new File(DiskLruCache.access$2200(DiskLruCache.this), s.toString());
            s.setLength(j);
        }

    }

    ._cls2200(String s, ._cls2200 _pcls2200)
    {
        this(s);
    }
}
