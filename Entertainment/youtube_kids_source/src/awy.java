// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.SparseArray;

public final class awy extends j
    implements ak, android.content.DialogInterface.OnCancelListener
{

    private int W;
    private avq X;
    private final Handler Y = new Handler(Looper.getMainLooper());
    final SparseArray a = new SparseArray();
    private boolean b;

    public awy()
    {
        W = -1;
    }

    public static awy a(m m1)
    {
label0:
        {
            if (Looper.myLooper() != Looper.getMainLooper())
            {
                throw new IllegalStateException("Must be called from main thread of process");
            }
            t t = m1.b;
            awy awy1;
            try
            {
                awy1 = (awy)t.a("GmsSupportLifecycleFragment");
            }
            // Misplaced declaration of an exception variable
            catch (m m1)
            {
                throw new IllegalStateException("Fragment with tag GmsSupportLifecycleFragment is not a SupportLifecycleFragment", m1);
            }
            if (awy1 != null)
            {
                m1 = awy1;
                if (!((j) (awy1)).p)
                {
                    break label0;
                }
            }
            m1 = new awy();
            t.a().a(m1, "GmsSupportLifecycleFragment").a();
            t.b();
        }
        return m1;
    }

    private void a(int i, avq avq1)
    {
        Log.w("GmsSupportLifecycleFragment", "Unresolved error while connecting client. Stopping auto-manage.");
        Object obj = (axa)a.get(i);
        if (obj != null)
        {
            f().a(i);
            a.remove(i);
            obj = ((axa) (obj)).b;
            if (obj != null)
            {
                ((avt) (obj)).a(avq1);
            }
        }
        m();
    }

    static void a(awy awy1)
    {
        awy1.m();
    }

    static void a(awy awy1, int i, avq avq1)
    {
        awy1.a(i, avq1);
    }

    private void m()
    {
        b = false;
        W = -1;
        X = null;
        aj aj1 = f();
        for (int i = 0; i < a.size(); i++)
        {
            int k = a.keyAt(i);
            awz awz1 = b(k);
            if (awz1 != null && awz1.g)
            {
                awz1.g = false;
                if (((bu) (awz1)).c && !((bu) (awz1)).d)
                {
                    awz1.f.a();
                }
            }
            aj1.a(k, null, this);
        }

    }

    public final bu a(int i)
    {
        return new awz(super.w, ((axa)a.get(i)).a);
    }

    public final void a(int i, int k)
    {
        boolean flag = true;
        i;
        JVM INSTR tableswitch 1 2: default 24
    //                   1 50
    //                   2 35;
           goto _L1 _L2 _L3
_L1:
        i = 0;
_L5:
        if (i != 0)
        {
            m();
            return;
        } else
        {
            a(W, X);
            return;
        }
_L3:
        if (avw.a(super.w) != 0) goto _L1; else goto _L4
_L4:
        i = ((flag) ? 1 : 0);
          goto _L5
_L2:
        if (k != -1) goto _L1; else goto _L6
_L6:
        i = ((flag) ? 1 : 0);
          goto _L5
    }

    public final void a(Activity activity)
    {
        super.a(activity);
        int i = 0;
        while (i < a.size()) 
        {
            int k = a.keyAt(i);
            activity = b(k);
            if (activity != null && ((axa)a.valueAt(i)).a != ((awz) (activity)).f)
            {
                f().b(k, null, this);
            } else
            {
                f().a(k, null, this);
            }
            i++;
        }
    }

    public final void a(Bundle bundle)
    {
        super.a(bundle);
        if (bundle != null)
        {
            b = bundle.getBoolean("resolving_error", false);
            W = bundle.getInt("failed_client_id", -1);
            if (W >= 0)
            {
                X = new avq(bundle.getInt("failed_status"), (PendingIntent)bundle.getParcelable("failed_resolution"));
            }
        }
    }

    public final void a(bu bu1)
    {
        if (bu1.a == W)
        {
            m();
        }
    }

    public final void a(bu bu1, Object obj)
    {
        obj = (avq)obj;
        boolean flag;
        if (((avq) (obj)).c == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            if (bu1.a == W)
            {
                m();
            }
        } else
        {
            int i = bu1.a;
            if (!b)
            {
                b = true;
                W = i;
                X = ((avq) (obj));
                Y.post(new axb(this, i, ((avq) (obj))));
                return;
            }
        }
    }

    final awz b(int i)
    {
        awz awz1;
        try
        {
            awz1 = (awz)f().b(i);
        }
        catch (ClassCastException classcastexception)
        {
            throw new IllegalStateException("Unknown loader in SupportLifecycleFragment", classcastexception);
        }
        return awz1;
    }

    public final void b()
    {
        super.b();
        if (!b)
        {
            for (int i = 0; i < a.size(); i++)
            {
                f().a(a.keyAt(i), null, this);
            }

        }
    }

    public final void e(Bundle bundle)
    {
        super.e(bundle);
        bundle.putBoolean("resolving_error", b);
        if (W >= 0)
        {
            bundle.putInt("failed_client_id", W);
            bundle.putInt("failed_status", X.c);
            bundle.putParcelable("failed_resolution", X.b);
        }
    }

    public final void onCancel(DialogInterface dialoginterface)
    {
        a(W, X);
    }
}
