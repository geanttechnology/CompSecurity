// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jp.co.cyberagent.android.gpuimage;


public final class A extends Enum
{

    private static final GPUImageRender_RGB $VALUES[];
    public static final GPUImageRender_RGB GPUImageRender_RGB;
    public static final GPUImageRender_RGB GPUImageRender_YUV420SP;

    public static A valueOf(String s)
    {
        return (A)Enum.valueOf(jp/co/cyberagent/android/gpuimage/OpenGlUtils$GPURenderType, s);
    }

    public static A[] values()
    {
        return (A[])$VALUES.clone();
    }

    static 
    {
        GPUImageRender_YUV420SP = new <init>("GPUImageRender_YUV420SP", 0);
        GPUImageRender_RGB = new <init>("GPUImageRender_RGB", 1);
        $VALUES = (new .VALUES[] {
            GPUImageRender_YUV420SP, GPUImageRender_RGB
        });
    }

    private A(String s, int i)
    {
        super(s, i);
    }
}
