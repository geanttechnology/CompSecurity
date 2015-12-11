// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.analytics.java.util;

import java.util.List;

public interface FileIo
{
    public static interface FileError
    {

        public abstract void onError(Throwable throwable);
    }

    public static interface FileReadListener
        extends FileError
    {

        public abstract void onItemsRead(List list);
    }

    public static interface FileWriteListener
        extends FileError
    {

        public abstract void onItemsWritten();
    }

}
