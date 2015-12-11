// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.products;


// Referenced classes of package com.pointinside.products:
//            ImageInfo

public static final class  extends Enum
{

    private static final full $VALUES[];
    public static final full full;
    public static final full large;
    public static final full thumbnail;
    public static final full unknown;

    public static  byString(String s)
    {
         a[] = values();
        int j = a.length;
        for (int i = 0; i < j; i++)
        {
              = a[i];
            if (.toString().equals(s))
            {
                return ;
            }
        }

        return null;
    }

    public static toString valueOf(String s)
    {
        return (toString)Enum.valueOf(com/pointinside/products/ImageInfo$PIProductsImageInfoType, s);
    }

    public static toString[] values()
    {
        return (toString[])$VALUES.clone();
    }

    static 
    {
        unknown = new <init>("unknown", 0);
        thumbnail = new <init>("thumbnail", 1);
        large = new <init>("large", 2);
        full = new <init>("full", 3);
        $VALUES = (new .VALUES[] {
            unknown, thumbnail, large, full
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
