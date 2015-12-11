// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.net.Uri;
import android.os.ConditionVariable;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Pair;
import android.util.SparseIntArray;
import java.util.concurrent.TimeUnit;

public final class bdi
    implements bgh
{

    public final String a;
    private final Context b;
    private final bmr c;
    private final bmr d;
    private final ckt e;
    private final bmi f;
    private volatile ats g;
    private volatile Pair h;
    private long i;

    public bdi(Context context, ckt ckt1, String s, String s1, String s2)
    {
        this(context, ckt1, s, s1, s2, null, 0L);
    }

    private bdi(Context context, ckt ckt1, String s, String s1, String s2, bmi bmi1, long l)
    {
        b = (Context)b.a(context);
        b.a(s);
        b.a(s1);
        b.a(s2);
        f = null;
        boolean flag;
        if (0L >= 0L)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        b.a(flag);
        i = 0L;
        h = null;
        e = (ckt)b.a(ckt1);
        context = String.valueOf("a.");
        ckt1 = String.valueOf(s);
        if (ckt1.length() != 0)
        {
            context = context.concat(ckt1);
        } else
        {
            context = new String(context);
        }
        a = context;
        c = new bdj(this, s1, s2);
        d = new bdk(this);
    }

    static ats a(bdi bdi1, ats ats1)
    {
        bdi1.g = ats1;
        return ats1;
    }

    static void a(bdi bdi1)
    {
        if (android.os.Build.VERSION.SDK_INT >= 16 || Looper.myLooper() == Looper.getMainLooper())
        {
            bdi1.g = new ats(bdi1.a, bdi1.b);
            return;
        } else
        {
            ConditionVariable conditionvariable = new ConditionVariable();
            (new Handler(Looper.getMainLooper())).post(new bdl(bdi1, conditionvariable));
            conditionvariable.block();
            return;
        }
    }

    static ats b(bdi bdi1)
    {
        return bdi1.g;
    }

    static bmr c(bdi bdi1)
    {
        return bdi1.c;
    }

    private String d()
    {
        Object obj;
        try
        {
            obj = (ats)c.b_();
            Context context = b;
            obj = ((ats) (obj)).a.c(ayk.a(context));
        }
        catch (RemoteException remoteexception)
        {
            bmo.d("RemoteException when using AdShieldClient.getAdRequestSignals()", remoteexception);
            return "13";
        }
        return ((String) (obj));
    }

    static String d(bdi bdi1)
    {
        return bdi1.a;
    }

    static Context e(bdi bdi1)
    {
        return bdi1.b;
    }

    public final String a()
    {
        if (f == null)
        {
            return d();
        }
        Pair pair = h;
        String s;
        long l;
        if (pair != null)
        {
            s = (String)pair.first;
        } else
        {
            s = null;
        }
        if (pair != null)
        {
            l = ((Long)pair.second).longValue();
        } else
        {
            l = 0L;
        }
        if (s != null)
        {
            long l1 = f.b();
            if (l1 > l && l1 <= l + i)
            {
                return s;
            }
        }
        s = d();
        h = Pair.create(s, Long.valueOf(f.b()));
        return s;
    }

    public final boolean a(Uri uri)
    {
        boolean flag;
        try
        {
            ats ats1 = (ats)c.b_();
            uri = ayk.a(uri);
            flag = ats1.a.a(uri);
        }
        // Misplaced declaration of an exception variable
        catch (Uri uri)
        {
            bmo.d("RemoteException when using AdShieldClient.isAdRequestAdSense()", uri);
            return false;
        }
        return flag;
    }

    public final String b()
    {
        return (String)d.b_();
    }

    public String c()
    {
        int j = e.a(false).a.a;
        j = bdn.a.get(j);
        if (j == 0)
        {
            bmo.b("Could not select a stream, defaulting to itag 36");
            return "36";
        } else
        {
            return String.valueOf(j);
        }
    }

    static 
    {
        TimeUnit.SECONDS.toMillis(60L);
    }
}
