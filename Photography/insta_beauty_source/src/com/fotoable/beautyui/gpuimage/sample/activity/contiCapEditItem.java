// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.beautyui.gpuimage.sample.activity;

import java.io.Serializable;

public class contiCapEditItem
    implements Serializable
{

    private static final long serialVersionUID = 0x1e408L;
    public int filterFlag;
    public float h2w;
    public boolean hasBeautyed;
    public boolean isChecked;
    public boolean isFrontFace;
    public boolean needCache;
    public boolean needCacheBig;
    public float softLevel;
    public String urlStr;

    public contiCapEditItem()
    {
        isFrontFace = true;
        isChecked = false;
        hasBeautyed = false;
        softLevel = 0.7F;
        h2w = 1.0F;
        needCache = false;
        needCacheBig = false;
    }
}
