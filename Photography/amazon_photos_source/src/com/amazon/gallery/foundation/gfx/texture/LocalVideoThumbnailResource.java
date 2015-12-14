// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.foundation.gfx.texture;


public class LocalVideoThumbnailResource
{

    public final Object key;
    public final String localPath;
    public final String name;

    public LocalVideoThumbnailResource(Object obj, String s, String s1)
    {
        key = obj;
        localPath = s;
        name = s1;
    }

    public String getLocalPath()
    {
        return localPath;
    }

    public Object getTextureKey()
    {
        return key;
    }
}
