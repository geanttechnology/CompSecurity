// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.jniproxy;


// Referenced classes of package com.cyberlink.youcammakeup.jniproxy:
//            ao

public final class UIImageCodecErrorCode extends Enum
{

    public static final UIImageCodecErrorCode a;
    public static final UIImageCodecErrorCode b;
    public static final UIImageCodecErrorCode c;
    public static final UIImageCodecErrorCode d;
    public static final UIImageCodecErrorCode e;
    public static final UIImageCodecErrorCode f;
    public static final UIImageCodecErrorCode g;
    public static final UIImageCodecErrorCode h;
    public static final UIImageCodecErrorCode i;
    public static final UIImageCodecErrorCode j;
    private static final UIImageCodecErrorCode k[];
    private final int swigValue;

    private UIImageCodecErrorCode(String s, int l)
    {
        super(s, l);
        swigValue = ao.a();
    }

    private UIImageCodecErrorCode(String s, int l, int i1)
    {
        super(s, l);
        swigValue = i1;
        ao.a(i1 + 1);
    }

    public static UIImageCodecErrorCode a(int l)
    {
        UIImageCodecErrorCode auiimagecodecerrorcode[] = (UIImageCodecErrorCode[])com/cyberlink/youcammakeup/jniproxy/UIImageCodecErrorCode.getEnumConstants();
        if (l < auiimagecodecerrorcode.length && l >= 0 && auiimagecodecerrorcode[l].swigValue == l)
        {
            return auiimagecodecerrorcode[l];
        }
        int j1 = auiimagecodecerrorcode.length;
        for (int i1 = 0; i1 < j1; i1++)
        {
            UIImageCodecErrorCode uiimagecodecerrorcode = auiimagecodecerrorcode[i1];
            if (uiimagecodecerrorcode.swigValue == l)
            {
                return uiimagecodecerrorcode;
            }
        }

        throw new IllegalArgumentException((new StringBuilder()).append("No enum ").append(com/cyberlink/youcammakeup/jniproxy/UIImageCodecErrorCode).append(" with value ").append(l).toString());
    }

    public static UIImageCodecErrorCode valueOf(String s)
    {
        return (UIImageCodecErrorCode)Enum.valueOf(com/cyberlink/youcammakeup/jniproxy/UIImageCodecErrorCode, s);
    }

    public static UIImageCodecErrorCode[] values()
    {
        return (UIImageCodecErrorCode[])k.clone();
    }

    public final int a()
    {
        return swigValue;
    }

    static 
    {
        a = new UIImageCodecErrorCode("UIIMGCODEC_NOERROR", 0, 0);
        b = new UIImageCodecErrorCode("UIIMGCODEC_DECODE_ERROR", 1);
        c = new UIImageCodecErrorCode("UIIMGCODEC_UNSUPPORT_HALF_DECODE", 2);
        d = new UIImageCodecErrorCode("UIIMGCODEC_DECODE_CANCEL", 3);
        e = new UIImageCodecErrorCode("UIIMGCODEC_ENCODE_ERROR", 4);
        f = new UIImageCodecErrorCode("UIIMGCODEC_ENCODE_CANCEL", 5);
        g = new UIImageCodecErrorCode("UIIMGCODEC_FILE_NOT_FOUND", 6);
        h = new UIImageCodecErrorCode("UIIMGCODEC_FILE_BEING_USED", 7);
        i = new UIImageCodecErrorCode("UIIMGCODEC_OUT_OF_MEMORY", 8);
        j = new UIImageCodecErrorCode("UIIMGCODEC_DISK_FULL", 9);
        k = (new UIImageCodecErrorCode[] {
            a, b, c, d, e, f, g, h, i, j
        });
    }
}
