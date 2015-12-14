// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.model.media;


public class Frame
{

    private String localPath;

    public Frame(String s)
    {
        localPath = s;
    }

    public boolean equals(Object obj)
    {
        if (obj instanceof Frame)
        {
            return ((Frame)obj).localPath.equals(localPath);
        } else
        {
            return false;
        }
    }

    public String getLocalPath()
    {
        return localPath;
    }

    public String toString()
    {
        return localPath;
    }
}
