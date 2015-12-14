// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.foundation.image;

import java.io.Serializable;

public class Dimension
    implements Serializable, Cloneable
{

    public int height;
    public int width;

    public Dimension()
    {
        this(0, 0);
    }

    public Dimension(int i, int j)
    {
        width = i;
        height = j;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (obj == null || getClass() != obj.getClass())
            {
                return false;
            }
            obj = (Dimension)obj;
            if (height != ((Dimension) (obj)).height || width != ((Dimension) (obj)).width)
            {
                return false;
            }
        }
        return true;
    }

    public int getHeight()
    {
        return height;
    }

    public int getWidth()
    {
        return width;
    }

    public int hashCode()
    {
        int i = width + height;
        return ((i + 1) * i) / 2 + width;
    }

    public String toString()
    {
        return String.format("width: %s, height: %s", new Object[] {
            Integer.valueOf(width), Integer.valueOf(height)
        });
    }
}
