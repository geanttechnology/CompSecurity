// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.jniproxy;


// Referenced classes of package com.cyberlink.youcammakeup.jniproxy:
//            bg

public final class UIThumbnailType extends Enum
{

    public static final UIThumbnailType a;
    public static final UIThumbnailType b;
    public static final UIThumbnailType c;
    private static final UIThumbnailType d[];
    private final int swigValue = bg.a();

    private UIThumbnailType(String s, int i)
    {
        super(s, i);
    }

    public static UIThumbnailType a(int i)
    {
        UIThumbnailType auithumbnailtype[] = (UIThumbnailType[])com/cyberlink/youcammakeup/jniproxy/UIThumbnailType.getEnumConstants();
        if (i < auithumbnailtype.length && i >= 0 && auithumbnailtype[i].swigValue == i)
        {
            return auithumbnailtype[i];
        }
        int k = auithumbnailtype.length;
        for (int j = 0; j < k; j++)
        {
            UIThumbnailType uithumbnailtype = auithumbnailtype[j];
            if (uithumbnailtype.swigValue == i)
            {
                return uithumbnailtype;
            }
        }

        throw new IllegalArgumentException((new StringBuilder()).append("No enum ").append(com/cyberlink/youcammakeup/jniproxy/UIThumbnailType).append(" with value ").append(i).toString());
    }

    public static UIThumbnailType valueOf(String s)
    {
        return (UIThumbnailType)Enum.valueOf(com/cyberlink/youcammakeup/jniproxy/UIThumbnailType, s);
    }

    public static UIThumbnailType[] values()
    {
        return (UIThumbnailType[])d.clone();
    }

    static 
    {
        a = new UIThumbnailType("THUMBNAIL_UNDEFINED", 0);
        b = new UIThumbnailType("THUMBNAIL_JPEG", 1);
        c = new UIThumbnailType("THUMBNAIL_UNCOMPRESSED_BUFFER", 2);
        d = (new UIThumbnailType[] {
            a, b, c
        });
    }
}
