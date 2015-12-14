// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.library.content;


// Referenced classes of package com.aviary.android.feather.library.content:
//            FeatherIntent

public static final class I
{

    public static final int TYPE_ALL = 7;
    public static final int TYPE_BORDER = 4;
    public static final int TYPE_FILTER = 1;
    public static final int TYPE_STICKER = 2;

    public static String getName(int i)
    {
        if (isFilter(i))
        {
            return "filter";
        }
        if (isSticker(i))
        {
            return "sticker";
        }
        if (isBorder(i))
        {
            return "border";
        } else
        {
            return null;
        }
    }

    public static boolean isBorder(int i)
    {
        return typeof(i, 4);
    }

    public static boolean isFilter(int i)
    {
        return typeof(i, 1);
    }

    public static boolean isSticker(int i)
    {
        return typeof(i, 2);
    }

    public static boolean isTypeOf(int i, int j)
    {
        return typeof(i, j);
    }

    static boolean typeof(int i, int j)
    {
        return (i & j) == j;
    }

    public I()
    {
    }
}
