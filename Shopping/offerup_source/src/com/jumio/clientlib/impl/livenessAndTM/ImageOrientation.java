// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jumio.clientlib.impl.livenessAndTM;


// Referenced classes of package com.jumio.clientlib.impl.livenessAndTM:
//            jniLivenessAndTMJNI

public final class ImageOrientation
{

    public static final ImageOrientation IMAGE_ORIENTATION_LANDSCAPE;
    public static final ImageOrientation IMAGE_ORIENTATION_PORTRAIT;
    public static final ImageOrientation IMAGE_ORIENTATION_REVERSE_LANDSCAPE;
    public static final ImageOrientation IMAGE_ORIENTATION_REVERSE_PORTRAIT;
    private static ImageOrientation a[];
    private static int b = 0;
    private final int c;
    private final String d;

    private ImageOrientation(String s)
    {
        d = s;
        int i = b;
        b = i + 1;
        c = i;
    }

    private ImageOrientation(String s, int i)
    {
        d = s;
        c = i;
        b = i + 1;
    }

    public static ImageOrientation swigToEnum(int i)
    {
        if (i < a.length && i >= 0 && a[i].c == i)
        {
            return a[i];
        }
        for (int j = 0; j < a.length; j++)
        {
            if (a[j].c == i)
            {
                return a[j];
            }
        }

        throw new IllegalArgumentException((new StringBuilder("No enum ")).append(com/jumio/clientlib/impl/livenessAndTM/ImageOrientation).append(" with value ").append(i).toString());
    }

    public final int swigValue()
    {
        return c;
    }

    public final String toString()
    {
        return d;
    }

    static 
    {
        IMAGE_ORIENTATION_LANDSCAPE = new ImageOrientation("IMAGE_ORIENTATION_LANDSCAPE", jniLivenessAndTMJNI.IMAGE_ORIENTATION_LANDSCAPE_get());
        IMAGE_ORIENTATION_PORTRAIT = new ImageOrientation("IMAGE_ORIENTATION_PORTRAIT");
        IMAGE_ORIENTATION_REVERSE_LANDSCAPE = new ImageOrientation("IMAGE_ORIENTATION_REVERSE_LANDSCAPE");
        IMAGE_ORIENTATION_REVERSE_PORTRAIT = new ImageOrientation("IMAGE_ORIENTATION_REVERSE_PORTRAIT");
        a = (new ImageOrientation[] {
            IMAGE_ORIENTATION_LANDSCAPE, IMAGE_ORIENTATION_PORTRAIT, IMAGE_ORIENTATION_REVERSE_LANDSCAPE, IMAGE_ORIENTATION_REVERSE_PORTRAIT
        });
    }
}
