// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.content.Context;
import android.content.Intent;
import com.smule.android.b;
import com.smule.android.c;
import com.smule.android.d;
import com.smule.android.f.g;
import com.smule.android.notifications.a;
import com.smule.pianoandroid.utils.o;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            MagicApplication, StartupActivity

public class ah
    implements b
{

    static final String a = com/smule/pianoandroid/magicpiano/ah.getName();
    private static long b = 10000L;
    private Context c;
    private long d;

    public ah()
    {
        d = 0L;
        c = MagicApplication.getContext().getApplicationContext();
    }

    public String a()
    {
        return c.getString(0x7f0c00fc);
    }

    public String a(c c1)
    {
        class _cls1
        {

            static final int a[];

            static 
            {
                a = new int[com.smule.android.c.values().length];
                try
                {
                    a[c.a.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[c.b.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (com.smule.pianoandroid.magicpiano._cls1.a[c1.ordinal()])
        {
        default:
            return null;

        case 1: // '\001'
            return MagicApplication.getContext().getString(0x7f0c00ba);

        case 2: // '\002'
            return "530749395806";
        }
    }

    public String a(boolean flag)
    {
        return com.smule.android.f.g.a(c, flag);
    }

    public void a(String s)
    {
        ((MagicApplication)(MagicApplication)c.getApplicationContext()).showToast(s, 0);
    }

    public boolean a(d d1)
    {
        if (d1.b == null)
        {
            Intent intent = new Intent(d1.a, com/smule/pianoandroid/magicpiano/StartupActivity);
            com.smule.android.notifications.a.a().a(d1.a, d1.e, d1.d, intent);
            return true;
        } else
        {
            return false;
        }
    }

    public String b()
    {
        return MagicApplication.getAppUID();
    }

    public String c()
    {
        return com.smule.android.f.g.a(c);
    }

    public String d()
    {
        return com.smule.android.f.g.b(c);
    }

    public Context e()
    {
        return c;
    }

    public String f()
    {
        return "bef48860d623238cee2cf096d9e0e298c3fb8740";
    }

    public String g()
    {
        return MagicApplication.getContext().getString(0x7f0c0248);
    }

    public String h()
    {
        return MagicApplication.getContext().getString(0x7f0c002f);
    }

    public Set i()
    {
        return com.smule.pianoandroid.magicpiano.a.g.a().d();
    }

    public List j()
    {
        return com.smule.pianoandroid.data.db.a.a;
    }

    public List k()
    {
        return com.smule.pianoandroid.data.db.a.b;
    }

    public List l()
    {
        return com.smule.pianoandroid.data.db.a.c;
    }

    public List m()
    {
        return Arrays.asList(new String[] {
            "piandroid.offers", "piandroid.userMessages", "piandroid.sharebutton", "piandroid.adConfig", "piandroid.xp", "piandroid.progression", "sectionBarUids", "piandroid.subscriptions", "piandroid.suggestions", "piandroid.chooseRewards", 
            "latency", "piandroid.purchasePage", "piandroid.tutorial", "piandroid.notifications"
        });
    }

    public String n()
    {
        return "piandroid";
    }

    public String o()
    {
        return "magic_piano_prefs";
    }

    public void p()
    {
        long l1 = System.currentTimeMillis();
        if (l1 - d < b)
        {
            return;
        } else
        {
            d = l1;
            com.smule.pianoandroid.utils.o.c();
            return;
        }
    }

}
