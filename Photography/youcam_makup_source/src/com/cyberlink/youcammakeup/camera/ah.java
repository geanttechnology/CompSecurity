// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.camera;

import android.app.Activity;
import android.media.AudioManager;
import android.media.SoundPool;
import com.cyberlink.youcammakeup.Globals;

public class ah
{

    private static final int a[] = {
        0x7f060004, 0x7f060003, 0x7f060002, 0x7f060001, 0x7f060000
    };
    private SoundPool b;
    private AudioManager c;
    private int d[];
    private int e;
    private boolean f;

    public ah(Activity activity)
    {
        f = true;
        activity.setVolumeControlStream(1);
        c = (AudioManager)activity.getSystemService("audio");
        b = new SoundPool(a.length, 1, 0);
        b.setOnLoadCompleteListener(new android.media.SoundPool.OnLoadCompleteListener() {

            final ah a;

            public void onLoadComplete(SoundPool soundpool, int j, int k)
            {
                if (k == 0 && ah.a(a) == j)
                {
                    float f1 = ah.b(a);
                    soundpool.play(j, f1, f1, 1, 0, 1.0F);
                    ah.a(a, -1);
                }
            }

            
            {
                a = ah.this;
                super();
            }
        });
        d = new int[a.length];
        for (int i = 0; i < d.length; i++)
        {
            d[i] = -1;
        }

        e = -1;
    }

    static int a(ah ah1)
    {
        return ah1.e;
    }

    static int a(ah ah1, int i)
    {
        ah1.e = i;
        return i;
    }

    private float b()
    {
        return (float)c.getStreamVolume(1) / (float)c.getStreamMaxVolume(1);
    }

    static float b(ah ah1)
    {
        return ah1.b();
    }

    public void a()
    {
        b.release();
    }

    public void a(int i)
    {
        this;
        JVM INSTR monitorenter ;
        if (i < 0)
        {
            break MISSING_BLOCK_LABEL_14;
        }
        if (i < a.length)
        {
            break MISSING_BLOCK_LABEL_46;
        }
        throw new RuntimeException((new StringBuilder()).append("Unknown sound requested: ").append(i).toString());
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        boolean flag = f;
        if (flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
label0:
        {
            if (d[i] != -1)
            {
                break label0;
            }
            e = b.load(Globals.d(), a[i], 1);
            d[i] = e;
        }
          goto _L1
        float f1 = b();
        b.play(d[i], f1, f1, 1, 0, 1.0F);
          goto _L1
    }

    public void a(boolean flag)
    {
        f = flag;
    }

}
