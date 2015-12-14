// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.imgop;

import android.util.Log;
import java.nio.ByteBuffer;

// Referenced classes of package com.socialin.android.photo.imgop:
//            ImageOpCommon

public class ImageResize
{

    public static boolean a;

    public ImageResize()
    {
    }

    public static native ByteBuffer allocNativeBuffer(long l);

    public static native void freeNativeBuffer(ByteBuffer bytebuffer);

    public static native ByteBuffer load(String s, int i, int j, int k, int ai[]);

    public static native void resize(ByteBuffer bytebuffer, int i, int j, ByteBuffer bytebuffer1, int k, int l, int i1);

    static 
    {
        boolean flag = true;
        try
        {
            System.loadLibrary("imageresize");
        }
        catch (UnsatisfiedLinkError unsatisfiedlinkerror)
        {
            try
            {
                System.load((new StringBuilder("/data/data/")).append(System.getProperty("packageName")).append("/lib/imageresize.so").toString());
            }
            catch (UnsatisfiedLinkError unsatisfiedlinkerror1)
            {
                Log.e(com/socialin/android/photo/imgop/ImageOpCommon.getSimpleName(), "Can't load \"imageresize\" library.");
                Log.e(com/socialin/android/photo/imgop/ImageOpCommon.getSimpleName(), unsatisfiedlinkerror1.getMessage());
                flag = false;
            }
        }
        Log.e("ex1", (new StringBuilder("ImageResize libraryLoaded = ")).append(flag).toString());
        a = flag;
    }
}
