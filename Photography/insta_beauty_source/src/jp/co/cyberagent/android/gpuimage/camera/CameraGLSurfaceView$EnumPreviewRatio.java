// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jp.co.cyberagent.android.gpuimage.camera;


public final class  extends Enum
{

    private static final Ratio_four2three $VALUES[];
    public static final Ratio_four2three Ratio_four2three;
    public static final Ratio_four2three Ratio_none;
    public static final Ratio_four2three Ratio_one2one;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(jp/co/cyberagent/android/gpuimage/camera/CameraGLSurfaceView$EnumPreviewRatio, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        Ratio_none = new <init>("Ratio_none", 0);
        Ratio_one2one = new <init>("Ratio_one2one", 1);
        Ratio_four2three = new <init>("Ratio_four2three", 2);
        $VALUES = (new .VALUES[] {
            Ratio_none, Ratio_one2one, Ratio_four2three
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
