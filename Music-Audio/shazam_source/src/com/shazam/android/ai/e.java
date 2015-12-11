// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.ai;

import android.app.Activity;
import android.os.Message;
import android.util.Pair;
import com.moodstocks.android.MoodstocksError;
import com.moodstocks.android.Result;
import com.moodstocks.android.Scanner;
import com.moodstocks.android.advanced.Image;
import com.moodstocks.android.advanced.Tools;
import com.shazam.android.visual.VisualShazamSurfaceViewContainer;
import com.shazam.android.visual.i;
import com.shazam.android.visual.l;
import com.shazam.android.visual.q;
import com.shazam.android.visual.t;
import com.shazam.android.visual.v;
import com.shazam.model.visual.VisualShazamProvider;

// Referenced classes of package com.shazam.android.ai:
//            d, c

public final class e extends l
{
    private final class a
        implements c.b
    {

        final e a;

        public final void a(Result result)
        {
            result.getType();
            JVM INSTR tableswitch -2147483648 -2147483648: default 24
        //                       -2147483648 77;
               goto _L1 _L2
_L1:
            com.shazam.android.visual.x.b b1 = null;
_L4:
            if (b1 != null)
            {
                com.shazam.android.visual.x.a a1 = new com.shazam.android.visual.x.a();
                a1.c = VisualShazamProvider.MOODSTOCKS;
                a1.b = b1;
                a1.a = result.getValue();
                result = a1.a();
                a.a.a(result);
            }
            return;
_L2:
            b1 = com.shazam.android.visual.x.b.b;
            if (true) goto _L4; else goto _L3
_L3:
        }

        private a()
        {
            a = e.this;
            super();
        }

        a(byte byte0)
        {
            this();
        }
    }

    private static final class b extends Enum
    {

        public static final b a;
        public static final b b;
        public static final b c;
        public static final b d;
        private static final b e[];

        public static b valueOf(String s)
        {
            return (b)Enum.valueOf(com/shazam/android/ai/e$b, s);
        }

        public static b[] values()
        {
            return (b[])e.clone();
        }

        static 
        {
            a = new b("LOADING", 0);
            b = new b("LOADED", 1);
            c = new b("FAILED", 2);
            d = new b("UNAVAILABLE", 3);
            e = (new b[] {
                a, b, c, d
            });
        }

        private b(String s, int j)
        {
            super(s, j);
        }
    }


    v a;
    public q b;
    public b c;
    public boolean d;
    public boolean e;
    private c f;
    private final d g;

    public e(d d1)
    {
        a = v.c;
        b = q.a;
        c = b.a;
        g = d1;
    }

    public final void a()
    {
        c = b.d;
        if (e)
        {
            b.c(this);
        }
    }

    public final void a(Activity activity, VisualShazamSurfaceViewContainer visualshazamsurfaceviewcontainer, v v1)
    {
        a = v1;
        try
        {
            activity = Scanner.get();
            g.a();
            f = new c(activity, new a((byte)0));
            f.d = 1;
            f.c = 0x80000000;
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            throw new t(activity);
        }
    }

    public final void a(i j)
    {
        if (f == null) goto _L2; else goto _L1
_L1:
        c c1;
        byte abyte0[];
        int k;
        int i1;
        int j1;
        c1 = f;
        abyte0 = j.a;
        k = j.b;
        i1 = j.c;
        j1 = j.d;
        Image image = new Image(abyte0, k, i1, j1);
        j = null;
_L10:
        if (image == null) goto _L4; else goto _L3
_L3:
        if ((c1.c & 0x80000000) == 0) goto _L6; else goto _L5
_L5:
        Result result = c1.a.search(image, c1.d, 0);
_L8:
        Result result1;
        result1 = result;
        if (result != null)
        {
            break MISSING_BLOCK_LABEL_125;
        }
        result1 = result;
        if ((c1.c & 0xf) != 0)
        {
            result1 = c1.a.decode(image, c1.c, 0);
        }
        result = result1;
_L11:
        try
        {
            image.release();
        }
        // Misplaced declaration of an exception variable
        catch (i j)
        {
            return;
        }
_L9:
        if (j == null)
        {
            break MISSING_BLOCK_LABEL_147;
        }
        c1.obtainMessage(0, j).sendToTarget();
        return;
        if (result == null)
        {
            break MISSING_BLOCK_LABEL_192;
        }
        if (!c1.e)
        {
            break MISSING_BLOCK_LABEL_192;
        }
        j = Tools.convertNV21ToBitmap(abyte0, k, i1, j1);
_L7:
        c1.obtainMessage(1, new Pair(result, j)).sendToTarget();
        return;
        j = null;
          goto _L7
_L6:
        result = null;
          goto _L8
_L4:
        result = null;
          goto _L9
_L2:
        return;
          goto _L8
        j;
        image = null;
          goto _L10
        j;
        result = null;
          goto _L11
    }

    public final void a(q q1)
    {
        b = q1;
        if (d)
        {
            q1.a(this);
            return;
        }
        static final class _cls1
        {

            static final int a[];

            static 
            {
                a = new int[b.values().length];
                try
                {
                    a[b.b.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[b.c.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[b.d.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1.a[c.ordinal()])
        {
        default:
            e = true;
            return;

        case 1: // '\001'
            q1.a(this);
            return;

        case 2: // '\002'
            q1.b(this);
            return;

        case 3: // '\003'
            q1.c(this);
            break;
        }
    }

    public final void b()
    {
        b = q.a;
    }

    public final void d()
    {
        i();
        f = null;
        a = v.c;
    }

    public final boolean e()
    {
        return f != null;
    }

    public final boolean f()
    {
        return d || c == b.b;
    }

    public final String h()
    {
        return VisualShazamProvider.MOODSTOCKS.getStringRepresentation();
    }

    public final void i()
    {
        if (f != null)
        {
            f.b = false;
        }
    }

    public final void l_()
    {
        if (f != null)
        {
            f.b = true;
        }
    }
}
