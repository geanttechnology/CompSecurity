// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.jniproxy;


// Referenced classes of package com.cyberlink.youcammakeup.jniproxy:
//            aq

public final class UIImageFormat extends Enum
{

    public static final UIImageFormat a;
    public static final UIImageFormat b;
    public static final UIImageFormat c;
    public static final UIImageFormat d;
    public static final UIImageFormat e;
    public static final UIImageFormat f;
    public static final UIImageFormat g;
    private static final UIImageFormat h[];
    private final int swigValue = aq.a();

    private UIImageFormat(String s, int i)
    {
        super(s, i);
    }

    public static UIImageFormat a(int i)
    {
        UIImageFormat auiimageformat[] = (UIImageFormat[])com/cyberlink/youcammakeup/jniproxy/UIImageFormat.getEnumConstants();
        if (i < auiimageformat.length && i >= 0 && auiimageformat[i].swigValue == i)
        {
            return auiimageformat[i];
        }
        int k = auiimageformat.length;
        for (int j = 0; j < k; j++)
        {
            UIImageFormat uiimageformat = auiimageformat[j];
            if (uiimageformat.swigValue == i)
            {
                return uiimageformat;
            }
        }

        throw new IllegalArgumentException((new StringBuilder()).append("No enum ").append(com/cyberlink/youcammakeup/jniproxy/UIImageFormat).append(" with value ").append(i).toString());
    }

    public static UIImageFormat valueOf(String s)
    {
        return (UIImageFormat)Enum.valueOf(com/cyberlink/youcammakeup/jniproxy/UIImageFormat, s);
    }

    public static UIImageFormat[] values()
    {
        return (UIImageFormat[])h.clone();
    }

    public final int a()
    {
        return swigValue;
    }

    static 
    {
        a = new UIImageFormat("FORMAT_UNKNOWN", 0);
        b = new UIImageFormat("FORMAT_JPEG", 1);
        c = new UIImageFormat("FORMAT_TIFF", 2);
        d = new UIImageFormat("FORMAT_RAW", 3);
        e = new UIImageFormat("FORMAT_ARGB", 4);
        f = new UIImageFormat("FORMAT_PNG", 5);
        g = new UIImageFormat("FORMAT_BMP", 6);
        h = (new UIImageFormat[] {
            a, b, c, d, e, f, g
        });
    }
}
