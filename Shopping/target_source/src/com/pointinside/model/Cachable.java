// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.model;

import android.content.Context;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

interface Cachable
{

    public abstract int cacheSize();

    public abstract File getCacheFile(File file);

    public abstract InputStream getContentAsStream(Context context);

    public abstract Object read(File file)
        throws IOException;

    public abstract List tryUpdate(File file)
        throws IOException;
}
