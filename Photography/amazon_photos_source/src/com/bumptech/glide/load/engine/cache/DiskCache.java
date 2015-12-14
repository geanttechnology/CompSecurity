// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.engine.cache;

import com.bumptech.glide.load.Key;
import java.io.File;

public interface DiskCache
{
    public static interface Factory
    {

        public abstract DiskCache build();
    }

    public static interface Writer
    {

        public abstract boolean write(File file);
    }


    public abstract void delete(Key key);

    public abstract File get(Key key);

    public abstract void put(Key key, Writer writer);
}
