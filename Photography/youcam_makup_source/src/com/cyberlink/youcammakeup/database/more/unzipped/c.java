// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.database.more.unzipped;

import android.content.ContentValues;
import java.io.File;

public abstract class c
{

    protected final File d;
    protected final int e;

    public c(File file, int i)
    {
        d = file;
        e = i;
    }

    public abstract void a(ContentValues contentvalues);

    public File b()
    {
        return d;
    }

    public int c()
    {
        return e;
    }
}
