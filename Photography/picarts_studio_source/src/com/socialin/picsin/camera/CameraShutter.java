// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.picsin.camera;

import android.content.Context;
import android.media.SoundPool;
import android.os.Handler;
import android.os.Message;
import java.util.HashMap;

// Referenced classes of package com.socialin.picsin.camera:
//            l, k, h, j, 
//            i

public final class CameraShutter
    implements android.os.Handler.Callback
{

    ShutterMode a;
    i b;
    i c;
    h d;
    j e;
    boolean f;
    boolean g;
    SoundPool h;
    boolean i;
    boolean j;
    private int k;
    private HashMap l;
    private Handler m;

    public CameraShutter(Context context, j j1)
    {
        a = ShutterMode.NORMAL;
        f = false;
        g = false;
        k = -1;
        i = true;
        m = new Handler(this);
        j = false;
        b = new l();
        c = new k(this);
        d = new h(this);
        e = j1;
        h = new SoundPool(2, 3, 100);
        l = new HashMap();
        l.put(Integer.valueOf(0), Integer.valueOf(h.load(context, 0x7f070001, 1)));
        l.put(Integer.valueOf(1), Integer.valueOf(h.load(context, 0x7f070000, 1)));
    }

    public final void a()
    {
        if (e == null)
        {
            throw new IllegalStateException("shot callback must not be null");
        }
        if (a != ShutterMode.NORMAL) goto _L2; else goto _L1
_L1:
        e.f();
_L4:
        if (a == ShutterMode.BURST)
        {
            if (d.b() <= 0)
            {
                break; /* Loop/switch isn't completed */
            }
            if (!j)
            {
                f = true;
                if (d.b() > 0)
                {
                    e.a(d);
                }
                d.a(d.b() - 1);
                e.f();
            }
        }
        return;
_L2:
        if (a == ShutterMode.TIMER)
        {
            if (b.b() == 0)
            {
                e.a(b);
                e.f();
                f = false;
            } else
            {
                f = true;
                m.removeMessages(1);
                Message message = m.obtainMessage(1);
                message.obj = b;
                m.sendMessageDelayed(message, 1000L);
                e.a(b);
            }
        } else
        if (a == ShutterMode.TIME_LAPSE)
        {
            if (c.b() == 0)
            {
                e.a(c);
                e.f();
                c.a();
            } else
            {
                f = true;
                m.removeMessages(1);
                Message message1 = m.obtainMessage(1);
                message1.obj = c;
                m.sendMessageDelayed(message1, 1000L);
                e.a(c);
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
        f = false;
        e.a(d);
        d.a();
        return;
    }

    public final void a(ShutterMode shuttermode)
    {
        a = shuttermode;
        j = false;
        f = false;
        g = false;
        b();
    }

    public final void b()
    {
        if (a == ShutterMode.TIMER)
        {
            b.a();
        } else
        {
            if (a == ShutterMode.TIME_LAPSE)
            {
                c.a();
                return;
            }
            if (a == ShutterMode.BURST)
            {
                d.a();
                return;
            }
        }
    }

    public final void c()
    {
        if (m.hasMessages(1))
        {
            m.removeMessages(1);
            j = true;
        }
        if (a == ShutterMode.BURST)
        {
            j = true;
        }
    }

    public final void d()
    {
        if (a == ShutterMode.TIMER)
        {
            e.a(b);
        } else
        {
            if (a == ShutterMode.TIME_LAPSE)
            {
                e.a(c);
                return;
            }
            if (a == ShutterMode.BURST)
            {
                e.a(d);
                return;
            }
        }
    }

    public final void e()
    {
        j = false;
        g = false;
    }

    public final boolean handleMessage(Message message)
    {
        switch (message.what)
        {
        default:
            return false;

        case 1: // '\001'
            message = (i)message.obj;
            break;
        }
        if (i)
        {
            int i1 = message.b();
            if (k != -1)
            {
                h.pause(k);
            }
            if (i1 <= 3)
            {
                k = h.play(((Integer)l.get(Integer.valueOf(1))).intValue(), 1.0F, 1.0F, 1, 0, 1.0F);
            } else
            {
                k = h.play(((Integer)l.get(Integer.valueOf(0))).intValue(), 1.0F, 1.0F, 1, 0, 1.0F);
            }
        }
        message.a(message.b() - 1);
        a();
        return false;
    }

    private class ShutterMode extends Enum
    {

        private static final ShutterMode $VALUES[];
        public static final ShutterMode BURST;
        public static final ShutterMode NORMAL;
        public static final ShutterMode STABLE;
        public static final ShutterMode TIMER;
        public static final ShutterMode TIME_LAPSE;

        public static ShutterMode valueOf(String s)
        {
            return (ShutterMode)Enum.valueOf(com/socialin/picsin/camera/CameraShutter$ShutterMode, s);
        }

        public static ShutterMode[] values()
        {
            return (ShutterMode[])$VALUES.clone();
        }

        static 
        {
            NORMAL = new ShutterMode("NORMAL", 0);
            TIMER = new ShutterMode("TIMER", 1);
            BURST = new ShutterMode("BURST", 2);
            TIME_LAPSE = new ShutterMode("TIME_LAPSE", 3);
            STABLE = new ShutterMode("STABLE", 4);
            $VALUES = (new ShutterMode[] {
                NORMAL, TIMER, BURST, TIME_LAPSE, STABLE
            });
        }

        private ShutterMode(String s, int i1)
        {
            super(s, i1);
        }
    }

}
