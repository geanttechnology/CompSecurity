// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.filters;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.util.Log;
import com.socialin.android.photo.imgop.ImageOp;
import com.socialin.android.photo.imgop.ImageOpCommon;
import com.socialin.android.util.ModernAsyncTask;
import com.socialin.android.util.c;
import com.socialin.android.util.w;
import java.nio.ByteBuffer;
import java.util.HashMap;
import myobfuscated.ay.e;

// Referenced classes of package com.picsart.filters:
//            c, FilterActivity, a

public abstract class FilterAsyncTask extends ModernAsyncTask
{

    Activity a;
    TaskMode b;
    a c;
    HashMap d;
    String e;
    int f;
    int g;
    int h;
    ByteBuffer i;
    Bitmap j;
    Bitmap k;
    Point l;
    com.picsart.filters.c m;
    ByteBuffer n;
    int o;
    int p;
    boolean q;
    public int r;
    private boolean s;

    public FilterAsyncTask()
    {
        l = new Point();
        q = false;
        s = false;
        r = -1;
    }

    private Bitmap a()
    {
        if (d != null)
        {
            o = ((Integer)d.get("width")).intValue();
            p = ((Integer)d.get("height")).intValue();
            Bitmap bitmap = w.a(d, g, 0);
            if (bitmap != null && !bitmap.isRecycled())
            {
                o = bitmap.getWidth();
                p = bitmap.getHeight();
            }
            return bitmap;
        }
        Bitmap bitmap1 = w.b(e, g, f);
        o = bitmap1.getWidth();
        p = bitmap1.getHeight();
        return bitmap1;
        Exception exception;
        exception;
_L2:
        exception.printStackTrace();
        return bitmap1;
        exception;
        bitmap1 = null;
        if (true) goto _L2; else goto _L1
_L1:
    }

    private void a(ByteBuffer bytebuffer, ByteBuffer bytebuffer1, int i1, int j1, boolean flag, int k1)
    {
        if (q)
        {
            return;
        } else
        {
            System.currentTimeMillis();
            s = m.a(bytebuffer, bytebuffer1, i1, j1, flag, k1);
            System.currentTimeMillis();
            return;
        }
    }

    private void b()
    {
        if (j != null && !j.isRecycled())
        {
            com.socialin.android.util.c.a(j);
        }
        j = null;
        if (n != null)
        {
            FilterActivity.a(n);
        }
        if (i != null)
        {
            FilterActivity.a(i);
        }
        i = null;
    }

    protected transient Object doInBackground(Object aobj[])
    {
        final class _cls1
        {

            static final int a[];

            static 
            {
                a = new int[TaskMode.values().length];
                try
                {
                    a[TaskMode.Init.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    a[TaskMode.Free.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[TaskMode.ApplyFilter.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[TaskMode.ApplyOrigSizeAndSave.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1.a[b.ordinal()];
        JVM INSTR tableswitch 1 4: default 40
    //                   1 42
    //                   2 409
    //                   3 416
    //                   4 444;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        return null;
_L2:
        aobj = k;
        Point point;
        if (aobj == null || ((Bitmap) (aobj)).isRecycled())
        {
            aobj = a();
        } else
        {
            o = k.getWidth();
            p = k.getHeight();
        }
        if (aobj == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (aobj != null)
        {
            Log.e("ex1", (new StringBuilder("FiltersActivity maxSizeBitmap w = ")).append(((Bitmap) (aobj)).getWidth()).append(" h = ").append(((Bitmap) (aobj)).getHeight()).toString());
        }
        l.x = o;
        l.y = p;
        if (o <= h && p <= h) goto _L7; else goto _L6
_L6:
        point = myobfuscated.ay.e.a(o, p, h);
        j = com.socialin.android.util.c.a(((Bitmap) (aobj)), point.x, point.y, true);
        if (aobj != k)
        {
            com.socialin.android.util.c.a(((Bitmap) (aobj)));
        }
_L8:
        if (j != null)
        {
            j = myobfuscated.ay.e.a(j);
            if (j != null)
            {
                i = FilterActivity.a(j.getWidth() * j.getHeight() * 4);
                i.position(0);
                j.copyPixelsToBuffer(i);
                ImageOpCommon.changeBufferAlphaChannelWithAlpha(i, j.getWidth() * j.getHeight(), 255);
                i.position(0);
                j.copyPixelsFromBuffer(i);
                i.position(0);
                n = FilterActivity.a(j.getWidth() * j.getHeight() * 4);
            }
        }
        continue; /* Loop/switch isn't completed */
_L7:
        j = ((Bitmap) (aobj));
        if (j == k)
        {
            j = com.socialin.android.util.c.a(k, android.graphics.Bitmap.Config.ARGB_8888);
        }
        if (true) goto _L8; else goto _L3
_L3:
        b();
        continue; /* Loop/switch isn't completed */
_L4:
        a(i, n, o, p, true, r);
        if (true) goto _L1; else goto _L5
_L5:
        if (j.getWidth() == l.x && j.getHeight() == l.y)
        {
            myobfuscated.ay.e.a(a);
        } else
        {
            aobj = a();
            if (aobj != null)
            {
                aobj = myobfuscated.ay.e.a(((Bitmap) (aobj)));
                if (aobj != null)
                {
                    ByteBuffer bytebuffer = FilterActivity.a(o * p * 4);
                    bytebuffer.position(0);
                    ByteBuffer bytebuffer1 = FilterActivity.a(o * p * 4);
                    ((Bitmap) (aobj)).copyPixelsToBuffer(bytebuffer);
                    a(bytebuffer, bytebuffer1, o, p, false, -1);
                    FilterActivity.a(bytebuffer);
                    bytebuffer1.position(0);
                    ((Bitmap) (aobj)).copyPixelsFromBuffer(bytebuffer1);
                    FilterActivity.a(bytebuffer1);
                    if (s)
                    {
                        return ((Object) (aobj));
                    } else
                    {
                        return null;
                    }
                }
            }
        }
        return null;
    }

    protected void onCancelled(Object obj)
    {
        switch (_cls1.a[b.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            b();
            break;
        }
    }

    protected void onPostExecute(Object obj)
    {
        _cls1.a[b.ordinal()];
        JVM INSTR tableswitch 1 3: default 36
    //                   1 37
    //                   2 36
    //                   3 70;
           goto _L1 _L2 _L1 _L3
_L1:
        return;
_L2:
        if (c != null)
        {
            c.a(j, i, n, l);
            return;
        }
        continue; /* Loop/switch isn't completed */
_L3:
        if (c != null && !q)
        {
            c.a(n);
        }
        if (r >= 0)
        {
            ImageOp.a(r);
            r = -1;
            return;
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    protected void onPreExecute()
    {
        if (b == TaskMode.ApplyFilter)
        {
            r = ImageOp.a();
        }
    }

    private class TaskMode extends Enum
    {

        private static final TaskMode $VALUES[];
        public static final TaskMode ApplyFilter;
        public static final TaskMode ApplyOrigSizeAndSave;
        public static final TaskMode Free;
        public static final TaskMode Init;

        public static TaskMode valueOf(String s1)
        {
            return (TaskMode)Enum.valueOf(com/picsart/filters/FilterAsyncTask$TaskMode, s1);
        }

        public static TaskMode[] values()
        {
            return (TaskMode[])$VALUES.clone();
        }

        static 
        {
            Init = new TaskMode("Init", 0);
            ApplyFilter = new TaskMode("ApplyFilter", 1);
            Free = new TaskMode("Free", 2);
            ApplyOrigSizeAndSave = new TaskMode("ApplyOrigSizeAndSave", 3);
            $VALUES = (new TaskMode[] {
                Init, ApplyFilter, Free, ApplyOrigSizeAndSave
            });
        }

        private TaskMode(String s1, int i1)
        {
            super(s1, i1);
        }
    }

}
