// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.jniproxy;


// Referenced classes of package com.cyberlink.youcammakeup.jniproxy:
//            ar

public final class UIImageOrientation extends Enum
{

    public static final UIImageOrientation a;
    public static final UIImageOrientation b;
    public static final UIImageOrientation c;
    public static final UIImageOrientation d;
    public static final UIImageOrientation e;
    public static final UIImageOrientation f;
    public static final UIImageOrientation g;
    public static final UIImageOrientation h;
    public static final UIImageOrientation i;
    private static final UIImageOrientation j[];
    private final int swigValue;

    private UIImageOrientation(String s, int k, int l)
    {
        super(s, k);
        swigValue = l;
        ar.a(l + 1);
    }

    public static UIImageOrientation a(int k)
    {
        UIImageOrientation auiimageorientation[] = (UIImageOrientation[])com/cyberlink/youcammakeup/jniproxy/UIImageOrientation.getEnumConstants();
        if (k < auiimageorientation.length && k >= 0 && auiimageorientation[k].swigValue == k)
        {
            return auiimageorientation[k];
        }
        int i1 = auiimageorientation.length;
        for (int l = 0; l < i1; l++)
        {
            UIImageOrientation uiimageorientation = auiimageorientation[l];
            if (uiimageorientation.swigValue == k)
            {
                return uiimageorientation;
            }
        }

        throw new IllegalArgumentException((new StringBuilder()).append("No enum ").append(com/cyberlink/youcammakeup/jniproxy/UIImageOrientation).append(" with value ").append(k).toString());
    }

    public static UIImageOrientation valueOf(String s)
    {
        return (UIImageOrientation)Enum.valueOf(com/cyberlink/youcammakeup/jniproxy/UIImageOrientation, s);
    }

    public static UIImageOrientation[] values()
    {
        return (UIImageOrientation[])j.clone();
    }

    public final int a()
    {
        return swigValue;
    }

    static 
    {
        a = new UIImageOrientation("ImageUnknownOrientation", 0, 0);
        b = new UIImageOrientation("ImageRotate0", 1, 1);
        c = new UIImageOrientation("ImageFlipHorizontal", 2, 2);
        d = new UIImageOrientation("ImageRotate180", 3, 3);
        e = new UIImageOrientation("ImageFlipVertical", 4, 4);
        f = new UIImageOrientation("ImageRotate90AndFlipHorizontal", 5, 5);
        g = new UIImageOrientation("ImageRotate90", 6, 6);
        h = new UIImageOrientation("ImageRotate270AndFlipHorizontal", 7, 7);
        i = new UIImageOrientation("ImageRotate270", 8, 8);
        j = (new UIImageOrientation[] {
            a, b, c, d, e, f, g, h, i
        });
    }
}
