// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.images;


public final class Size
{

    private final int zznQ;
    private final int zznR;

    public Size(int i, int j)
    {
        zznQ = i;
        zznR = j;
    }

    public static Size parseSize(String s)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("string must not be null");
        }
        int j = s.indexOf('*');
        int i = j;
        if (j < 0)
        {
            i = s.indexOf('x');
        }
        if (i < 0)
        {
            throw zzch(s);
        }
        Size size;
        try
        {
            size = new Size(Integer.parseInt(s.substring(0, i)), Integer.parseInt(s.substring(i + 1)));
        }
        catch (NumberFormatException numberformatexception)
        {
            throw zzch(s);
        }
        return size;
    }

    private static NumberFormatException zzch(String s)
    {
        throw new NumberFormatException((new StringBuilder("Invalid Size: \"")).append(s).append("\"").toString());
    }

    public final boolean equals(Object obj)
    {
        if (obj != null)
        {
            if (this == obj)
            {
                return true;
            }
            if (obj instanceof Size)
            {
                obj = (Size)obj;
                if (zznQ == ((Size) (obj)).zznQ && zznR == ((Size) (obj)).zznR)
                {
                    return true;
                }
            }
        }
        return false;
    }

    public final int getHeight()
    {
        return zznR;
    }

    public final int getWidth()
    {
        return zznQ;
    }

    public final int hashCode()
    {
        return zznR ^ (zznQ << 16 | zznQ >>> 16);
    }

    public final String toString()
    {
        return (new StringBuilder()).append(zznQ).append("x").append(zznR).toString();
    }
}
