// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.collages;

import java.io.Serializable;
import java.util.HashMap;

public class CollageImage
    implements Serializable
{

    private HashMap bufferData;
    private int degree;
    private boolean isFromBuffer;
    private String path;

    public CollageImage()
    {
        isFromBuffer = false;
        path = null;
        bufferData = null;
        degree = 0;
    }

    public CollageImage(boolean flag, String s, HashMap hashmap, int i)
    {
        isFromBuffer = false;
        path = null;
        bufferData = null;
        degree = 0;
        bufferData = hashmap;
        isFromBuffer = flag;
        path = s;
        degree = i;
    }

    public HashMap getBufferData()
    {
        return bufferData;
    }

    public int getDegree()
    {
        return degree;
    }

    public String getPath()
    {
        return path;
    }

    public boolean isFromBuffer()
    {
        return isFromBuffer;
    }

    public void set(CollageImage collageimage)
    {
        isFromBuffer = collageimage.isFromBuffer;
        bufferData = collageimage.bufferData;
        path = collageimage.path;
        degree = collageimage.degree;
    }

    public void setBufferData(HashMap hashmap)
    {
        bufferData = hashmap;
    }

    public void setDegree(int i)
    {
        degree = i;
    }

    public void setFromBuffer(boolean flag)
    {
        isFromBuffer = flag;
    }

    public void setPath(String s)
    {
        path = s;
    }
}
