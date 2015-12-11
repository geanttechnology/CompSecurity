// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digimarc.dms.imagereader;


// Referenced classes of package com.digimarc.dms.imagereader:
//            DMSCameraOptimizer

public static final class  extends Enum
{

    private static final RGBA8888 $VALUES[];
    public static final RGBA8888 RGB888;
    public static final RGBA8888 RGBA8888;
    public static final RGBA8888 YUV420;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/digimarc/dms/imagereader/DMSCameraOptimizer$CaptureFormat, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        YUV420 = new <init>("YUV420", 0);
        RGB888 = new <init>("RGB888", 1);
        RGBA8888 = new <init>("RGBA8888", 2);
        $VALUES = (new .VALUES[] {
            YUV420, RGB888, RGBA8888
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
