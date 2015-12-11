// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.content.Context;
import android.content.SharedPreferences;
import com.smule.android.c.aa;
import com.smule.android.f.h;
import com.smule.android.f.p;
import com.smule.android.network.managers.e;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            MagicApplication, ab

public class ac
{

    private static ac a;
    private Map b;

    private ac()
    {
        b = new HashMap();
        Observer observer = new Observer() {

            final ac a;

            public void update(Observable observable, Object obj)
            {
                observable = e.a().f();
                if (observable != null && !e.a().a(observable).started.booleanValue())
                {
                    ac.a().a("NOTIFICATION_CHALLENGE", 1);
                }
            }

            
            {
                a = ac.this;
                super();
            }
        };
        h.a().a("CONTEST_STATE_MIGHT_HAVE_CHANGED", observer);
        observer = new Observer() {

            final ac a;

            public void update(Observable observable, Object obj)
            {
                int i = ((Integer)obj).intValue();
                ac.a().b("NOTIFICATION_ACHIEVEMENTS", i);
                ac.a().a("NOTIFICATION_CHALLENGE", 0);
            }

            
            {
                a = ac.this;
                super();
            }
        };
        h.a().a("game.achievement.loaded", observer);
        c();
    }

    public static ac a()
    {
        com/smule/pianoandroid/magicpiano/ac;
        JVM INSTR monitorenter ;
        ac ac1;
        if (a == null)
        {
            a = new ac();
        }
        ac1 = a;
        com/smule/pianoandroid/magicpiano/ac;
        JVM INSTR monitorexit ;
        return ac1;
        Exception exception;
        exception;
        throw exception;
    }

    private void c()
    {
        boolean flag = true;
        Object obj = MagicApplication.getContext().getSharedPreferences("magic_piano_prefs", 0);
        if (((SharedPreferences) (obj)).getBoolean("SHOW_CHALLENGE_NOTIFICATIONS", true))
        {
            try
            {
                b.put("NOTIFICATION_CHALLENGE", Integer.valueOf(((SharedPreferences) (obj)).getInt("NOTIFICATION_CHALLENGE", 0)));
            }
            catch (ClassCastException classcastexception)
            {
                boolean flag1 = ((SharedPreferences) (obj)).getBoolean("NOTIFICATION_CHALLENGE", false);
                Map map = b;
                int i;
                if (flag1)
                {
                    i = 1;
                } else
                {
                    i = 0;
                }
                map.put("NOTIFICATION_CHALLENGE", Integer.valueOf(i));
            }
        } else
        {
            b.put("NOTIFICATION_CHALLENGE", Integer.valueOf(0));
        }
        boolean flag2;
        try
        {
            b.put("NOTIFICATION_ACHIEVEMENTS", Integer.valueOf(((SharedPreferences) (obj)).getInt("NOTIFICATION_ACHIEVEMENTS", 0)));
            return;
        }
        catch (ClassCastException classcastexception1)
        {
            flag2 = ((SharedPreferences) (obj)).getBoolean("NOTIFICATION_ACHIEVEMENTS", false);
        }
        obj = b;
        int j;
        if (flag2)
        {
            j = ((flag) ? 1 : 0);
        } else
        {
            j = 0;
        }
        ((Map) (obj)).put("NOTIFICATION_ACHIEVEMENTS", Integer.valueOf(j));
    }

    public int a(String s)
    {
        s = (Integer)b.get(s);
        if (s != null)
        {
            return s.intValue();
        } else
        {
            return 0;
        }
    }

    public void a(String s, int i)
    {
        aa.a(com.smule.pianoandroid.magicpiano.ab.h(), (new StringBuilder()).append("Incrementing notification ").append(s).append(" with ").append(i).toString());
        SharedPreferences sharedpreferences = MagicApplication.getContext().getSharedPreferences("magic_piano_prefs", 0);
        if (!b.containsKey(s))
        {
            b.put(s, Integer.valueOf(0));
        }
        int j = ((Integer)b.get(s)).intValue();
        if (s.equals("NOTIFICATION_CHALLENGE"))
        {
            boolean flag = sharedpreferences.getBoolean("SHOW_CHALLENGE_NOTIFICATIONS", true);
            Map map = b;
            if (!flag)
            {
                i = 0;
            }
            map.put(s, Integer.valueOf(i));
        } else
        {
            b.put(s, Integer.valueOf(j + i));
        }
        p.a(sharedpreferences.edit().putInt(s, ((Integer)b.get(s)).intValue()));
        h.a().a("BADGE_NOTIFICATION", new Object[0]);
    }

    public void a(boolean flag)
    {
        p.a(MagicApplication.getContext().getSharedPreferences("magic_piano_prefs", 0).edit().putBoolean("SHOW_CHALLENGE_NOTIFICATIONS", flag));
        if (!flag)
        {
            a().a("NOTIFICATION_CHALLENGE", 0);
        }
    }

    public int b()
    {
        Iterator iterator = b.values().iterator();
        int i = 0;
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Integer integer = (Integer)iterator.next();
            if (integer.intValue() > 0)
            {
                i = integer.intValue() + i;
            }
        } while (true);
        return i;
    }

    public void b(String s, int i)
    {
        p.a(MagicApplication.getContext().getSharedPreferences("magic_piano_prefs", 0).edit().putInt(s, i));
        b.put(s, Integer.valueOf(i));
    }
}
