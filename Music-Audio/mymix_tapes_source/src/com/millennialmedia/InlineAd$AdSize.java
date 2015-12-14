// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia;


// Referenced classes of package com.millennialmedia:
//            InlineAd

public static class height
{

    public static final int AUTO_HEIGHT = 0;
    public static final int AUTO_WIDTH = 0;
    public static final height BANNER = new <init>(320, 50);
    public static final <init> FULL_BANNER = new <init>(468, 60);
    public static final <init> LARGE_BANNER = new <init>(320, 100);
    public static final <init> LEADERBOARD = new <init>(728, 90);
    public static final <init> MEDIUM_RECTANGLE = new <init>(300, 250);
    public static final <init> SMART_BANNER = new <init>(0, 0);
    public final int height;
    public final int width;

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (obj == null || getClass() != obj.getClass())
            {
                return false;
            }
            if (!(obj instanceof height))
            {
                return false;
            }
            obj = (height)obj;
            if (width != ((width) (obj)).width || height != ((height) (obj)).height)
            {
                return false;
            }
        }
        return true;
    }

    public int hashCode()
    {
        return width * 31 + height;
    }

    public String toString()
    {
        return (new StringBuilder()).append("Inline ad of size ").append(width).append(" by ").append(height).toString();
    }


    public (int i, int j)
    {
        if (i <= 0)
        {
            i = 0;
        }
        width = i;
        if (j <= 0)
        {
            j = 0;
        }
        height = j;
    }
}
