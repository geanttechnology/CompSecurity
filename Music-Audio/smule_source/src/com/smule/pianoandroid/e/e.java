// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.e;

import android.content.SharedPreferences;
import com.crittercism.app.Crittercism;
import com.fasterxml.jackson.databind.JsonNode;
import com.smule.android.c.aa;
import com.smule.android.f.h;
import com.smule.android.f.p;
import com.smule.android.network.core.o;
import com.smule.pianoandroid.a.z;
import com.smule.pianoandroid.data.model.GameReward;
import com.smule.pianoandroid.data.model.LevelConfig;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

// Referenced classes of package com.smule.pianoandroid.e:
//            c

public class e
{

    public static final String a = com/smule/pianoandroid/e/e.getName();
    private static e b = null;
    private int c;
    private long d;

    private e()
    {
        g();
        Observer observer = new Observer() {

            final e a;

            public void update(Observable observable, Object obj)
            {
                observable = (Map)obj;
                e.a(a, (o)observable.get("game.data.param"), false);
            }

            
            {
                a = e.this;
                super();
            }
        };
        h.a().a("game.data.sync", observer);
        observer = new Observer() {

            final e a;

            public void update(Observable observable, Object obj)
            {
                observable = (Map)obj;
                e.a(a, (o)observable.get("game.data.param"), true);
                h.a().b("game.data.available", this);
            }

            
            {
                a = e.this;
                super();
            }
        };
        h.a().a("game.data.available", observer);
    }

    public static e a()
    {
        com/smule/pianoandroid/e/e;
        JVM INSTR monitorenter ;
        e e1;
        if (b == null)
        {
            b = new e();
        }
        e1 = b;
        com/smule/pianoandroid/e/e;
        JVM INSTR monitorexit ;
        return e1;
        Exception exception;
        exception;
        throw exception;
    }

    private void a(int i)
    {
        if (d > 0x30d40L || d < 0L)
        {
            Crittercism.a(new Exception((new StringBuilder()).append("LevelManager.save: invalid xp : ").append(d).append(" caller context: ").append(i).toString()));
        }
        p.a(z.a().c().putInt("game.data.level", c).putLong("game.data.xp", d));
    }

    private void a(o o1, boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        if (o1 != null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        g();
        if (!o1.j.has("xp") || !o1.j.has("level")) goto _L1; else goto _L3
_L3:
        int i;
        long l;
        l = o1.j.get("xp").asLong();
        i = o1.j.get("level").asInt();
        if (!flag) goto _L5; else goto _L4
_L4:
        d = l;
        c = i;
        a(1);
        h.a().a("game.level.update", Boolean.TRUE);
          goto _L1
        o1;
        throw o1;
_L5:
        if (i == c && d == l) goto _L1; else goto _L6
_L6:
        d = l;
        c = i;
        a(2);
        h.a().a("game.level.update", Boolean.FALSE);
          goto _L1
    }

    static void a(e e1, o o1, boolean flag)
    {
        e1.a(o1, flag);
    }

    private void g()
    {
        c = z.a().b().getInt("game.data.level", 1);
        d = z.a().b().getLong("game.data.xp", 0L);
        aa.c(a, String.format("Loaded user level: %d, xp: %d.", new Object[] {
            Integer.valueOf(c), Long.valueOf(d)
        }));
    }

    public float a(long l)
    {
        return a(l, c);
    }

    public float a(long l, int i)
    {
        LevelConfig levelconfig;
        for (levelconfig = com.smule.pianoandroid.e.c.a().a(i); levelconfig == null || levelconfig.xp == 0L;)
        {
            return 0.0F;
        }

        return (float)l / (float)levelconfig.xp;
    }

    public float b()
    {
        return a(d);
    }

    public void b(long l)
    {
        int i;
        d = d + l;
        aa.c(a, String.format("Earned %d experience, total is now %d.", new Object[] {
            Long.valueOf(l), Long.valueOf(d)
        }));
        i = c;
_L6:
        l = com.smule.pianoandroid.e.c.a().a(c).xp;
        if (l != 0L && d >= l) goto _L2; else goto _L1
_L1:
        Iterator iterator;
        if (i == c)
        {
            break MISSING_BLOCK_LABEL_259;
        }
        aa.c(a, String.format("Advanced to level %d, with xp %d", new Object[] {
            Integer.valueOf(c), Long.valueOf(d)
        }));
        h.a().a("game.level.update", Boolean.FALSE);
        iterator = com.smule.pianoandroid.e.c.a().a(c).rewards.iterator();
_L4:
        if (!iterator.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        Object obj = (GameReward)iterator.next();
        class _cls3
        {

            static final int a[];

            static 
            {
                a = new int[com.smule.pianoandroid.data.model.GameReward.Type.values().length];
                try
                {
                    a[com.smule.pianoandroid.data.model.GameReward.Type.COINS.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[com.smule.pianoandroid.data.model.GameReward.Type.PRODUCT.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls3.a[((GameReward) (obj)).getRewardType().ordinal()])
        {
        case 1: // '\001'
            obj = ((GameReward) (obj)).value;
            // fall through

        default:
            if (false)
            {
            }
            break;

        case 2: // '\002'
            obj = ((GameReward) (obj)).value;
            break;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        c = c + 1;
        d = d - l;
        continue; /* Loop/switch isn't completed */
        if (true) goto _L4; else goto _L3
_L3:
        a(3);
        a(4);
        return;
        if (true) goto _L6; else goto _L5
_L5:
    }

    public void c()
    {
        if (c != 1)
        {
            aa.b(a, "unexpected state, player is not level 1!");
            return;
        } else
        {
            b(com.smule.pianoandroid.e.c.a().a(c).xp - d);
            return;
        }
    }

    public void d()
    {
        d = 0L;
        aa.c(a, "Reseting level and xp to 0");
        c = 0;
        a(5);
    }

    public long e()
    {
        return d;
    }

    public int f()
    {
        return c;
    }

}
