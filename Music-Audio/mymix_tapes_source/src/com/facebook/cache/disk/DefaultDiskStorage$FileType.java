// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.cache.disk;


// Referenced classes of package com.facebook.cache.disk:
//            DefaultDiskStorage

private static final class extension extends Enum
{

    private static final TEMP $VALUES[];
    public static final TEMP CONTENT;
    public static final TEMP TEMP;
    public final String extension;

    public static extension fromExtension(String s)
    {
        if (".cnt".equals(s))
        {
            return CONTENT;
        }
        if (".tmp".equals(s))
        {
            return TEMP;
        } else
        {
            return null;
        }
    }

    public static TEMP valueOf(String s)
    {
        return (TEMP)Enum.valueOf(com/facebook/cache/disk/DefaultDiskStorage$FileType, s);
    }

    public static TEMP[] values()
    {
        return (TEMP[])$VALUES.clone();
    }

    static 
    {
        CONTENT = new <init>("CONTENT", 0, ".cnt");
        TEMP = new <init>("TEMP", 1, ".tmp");
        $VALUES = (new .VALUES[] {
            CONTENT, TEMP
        });
    }

    private _cls9(String s, int i, String s1)
    {
        super(s, i);
        extension = s1;
    }
}
