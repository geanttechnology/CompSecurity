// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a9.vs.mobile.library.impl.jni;


public final class ImageFormat extends Enum
{
    private static class SwigNext
    {

        private static int next = 0;



/*
        static int access$002(int i)
        {
            next = i;
            return i;
        }

*/


/*
        static int access$008()
        {
            int i = next;
            next = i + 1;
            return i;
        }

*/

        private SwigNext()
        {
        }
    }


    private static final ImageFormat $VALUES[];
    public static final ImageFormat BGR;
    public static final ImageFormat BGRA;
    public static final ImageFormat RGB565;
    public static final ImageFormat UNKNOWN_FORMAT;
    public static final ImageFormat YUV420_NV12;
    public static final ImageFormat YUV420_NV21;
    private final int swigValue;

    private ImageFormat(String s, int i)
    {
        super(s, i);
        swigValue = int i = 
// JavaClassFileOutputException: get_constant: invalid tag

    private ImageFormat(String s, int i, int j)
    {
        Enum(s, i);
        swigValue = j;
        SwigNext.next = j + 1;
    }

    private ImageFormat(String s, int i, ImageFormat imageformat)
    {
        Enum(s, i);
        swigValue = imageformat.swigValue;
        SwigNext.next = swigValue + 1;
    }

    public static ImageFormat swigToEnum(int i)
    {
        ImageFormat aimageformat[] = (ImageFormat[])com/a9/vs/mobile/library/impl/jni/ImageFormat.getEnumConstants();
        if (i >= aimageformat.length || i < 0 || aimageformat[i].swigValue != i) goto _L2; else goto _L1
_L1:
        ImageFormat imageformat = aimageformat[i];
_L4:
        return imageformat;
_L2:
        int k = aimageformat.length;
        int j = 0;
label0:
        do
        {
label1:
            {
                if (j >= k)
                {
                    break label1;
                }
                ImageFormat imageformat1 = aimageformat[j];
                imageformat = imageformat1;
                if (imageformat1.swigValue == i)
                {
                    break label0;
                }
                j++;
            }
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
        throw new IllegalArgumentException((new StringBuilder()).append("No enum ").append(com/a9/vs/mobile/library/impl/jni/ImageFormat).append(" with value ").append(i).toString());
    }

    public static ImageFormat valueOf(String s)
    {
        return (ImageFormat)Enum.valueOf(com/a9/vs/mobile/library/impl/jni/ImageFormat, s);
    }

    public static ImageFormat[] values()
    {
        return (ImageFormat[])$VALUES.clone();
    }

    public final int swigValue()
    {
        return swigValue;
    }

    static 
    {
        YUV420_NV21 = new ImageFormat("YUV420_NV21", 0, 0);
        YUV420_NV12 = new ImageFormat("YUV420_NV12", 1);
        BGRA = new ImageFormat("BGRA", 2);
        RGB565 = new ImageFormat("RGB565", 3);
        BGR = new ImageFormat("BGR", 4);
        UNKNOWN_FORMAT = new ImageFormat("UNKNOWN_FORMAT", 5);
        $VALUES = (new ImageFormat[] {
            YUV420_NV21, YUV420_NV12, BGRA, RGB565, BGR, UNKNOWN_FORMAT
        });
    }
}
