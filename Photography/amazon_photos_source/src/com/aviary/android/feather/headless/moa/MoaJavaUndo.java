// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.headless.moa;

import android.graphics.Bitmap;
import android.util.Log;

public class MoaJavaUndo
{
    public static class MoaUndoBitmap
    {

        private static final String TAG = "MoaUndoBitmap";
        public Bitmap bitmap;
        public long ptr;

        public boolean isEmpty()
        {
            Log.d("MoaUndoBitmap", String.format("ptr: 0x%x, bitmap: %s", new Object[] {
                Long.valueOf(ptr), bitmap
            }));
            return bitmap == null;
        }

        public String toString()
        {
            return String.format("MoaUndoBitmap{ptr:0x%x, bitmap:%s}", new Object[] {
                Long.valueOf(ptr), bitmap
            });
        }

        public MoaUndoBitmap()
        {
        }
    }


    private static final String TAG = "MoaJavaUndo";
    private long ptr;

    public MoaJavaUndo(boolean flag)
    {
        ptr = 0L;
        Log.i("MoaJavaUndo", (new StringBuilder()).append("enabled: ").append(flag).toString());
        if (flag)
        {
            ptr = nativeCtor();
        }
    }

    static native long nativeBytesCount(long l);

    static native boolean nativeCanRedo(long l);

    static native boolean nativeCanUndo(long l);

    static native void nativeClear(long l);

    static native long nativeCtor();

    static native void nativeDispose(long l);

    static native long nativePush(long l, Bitmap bitmap);

    static native boolean nativeRedo(long l, MoaUndoBitmap moaundobitmap);

    static native int nativeSize(long l);

    static native boolean nativeUndo(long l, MoaUndoBitmap moaundobitmap);

    public boolean canRedo()
    {
        if (ptr > 0L)
        {
            return nativeCanRedo(ptr);
        } else
        {
            return false;
        }
    }

    public boolean canUndo()
    {
        if (ptr > 0L)
        {
            return nativeCanUndo(ptr);
        } else
        {
            return false;
        }
    }

    public void clearAll()
    {
        if (ptr > 0L)
        {
            nativeClear(ptr);
        }
    }

    public void dispose()
    {
        if (ptr > 0L)
        {
            nativeDispose(ptr);
            ptr = 0L;
        }
    }

    public boolean enabled()
    {
        return ptr > 0L;
    }

    public long getBytesCount()
    {
        long l = 0L;
        if (ptr > 0L)
        {
            l = nativeBytesCount(ptr);
        }
        return l;
    }

    public long load(Bitmap bitmap)
    {
        long l = 0L;
        if (ptr > 0L)
        {
            nativeClear(ptr);
            l = push(bitmap);
        }
        return l;
    }

    public long push(Bitmap bitmap)
    {
        long l = 0L;
        if (ptr > 0L)
        {
            l = nativePush(ptr, bitmap);
        }
        return l;
    }

    public MoaUndoBitmap redo()
    {
        if (ptr > 0L && canRedo())
        {
            MoaUndoBitmap moaundobitmap = new MoaUndoBitmap();
            boolean flag = nativeRedo(ptr, moaundobitmap);
            Log.d("MoaJavaUndo", (new StringBuilder()).append("redo result: ").append(flag).append(", output: ").append(moaundobitmap).toString());
            if (flag && !moaundobitmap.isEmpty())
            {
                return moaundobitmap;
            }
        }
        return null;
    }

    public int size()
    {
        if (ptr > 0L)
        {
            return nativeSize(ptr);
        } else
        {
            return 0;
        }
    }

    public MoaUndoBitmap undo()
    {
        if (ptr > 0L && canUndo())
        {
            MoaUndoBitmap moaundobitmap = new MoaUndoBitmap();
            boolean flag = nativeUndo(ptr, moaundobitmap);
            Log.d("MoaJavaUndo", (new StringBuilder()).append("undo result: ").append(flag).append(", output: ").append(moaundobitmap).toString());
            if (flag && !moaundobitmap.isEmpty())
            {
                return moaundobitmap;
            }
        }
        return null;
    }
}
