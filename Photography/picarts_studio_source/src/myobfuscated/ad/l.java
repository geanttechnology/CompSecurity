// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.ad;

import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import com.bumptech.glide.k;
import java.util.HashMap;
import java.util.Map;
import myobfuscated.aj.j;

// Referenced classes of package myobfuscated.ad:
//            b, f, j, o

public final class l
    implements android.os.Handler.Callback
{

    private static final l a = new l();
    private volatile k b;
    private Map c;
    private Map d;
    private final Handler e = new Handler(Looper.getMainLooper(), this);

    l()
    {
        c = new HashMap();
        d = new HashMap();
    }

    public static l a()
    {
        return a;
    }

    private k b(Context context)
    {
        if (b != null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorenter ;
        if (b == null)
        {
            b = new k(context.getApplicationContext(), new b(), new f());
        }
        this;
        JVM INSTR monitorexit ;
_L2:
        return b;
        context;
        this;
        JVM INSTR monitorexit ;
        throw context;
    }

    private static void b(Activity activity)
    {
        if (android.os.Build.VERSION.SDK_INT >= 17 && activity.isDestroyed())
        {
            throw new IllegalArgumentException("You cannot start a load for a destroyed activity");
        } else
        {
            return;
        }
    }

    public final k a(Activity activity)
    {
        k k1;
        if (j.c() || android.os.Build.VERSION.SDK_INT < 11)
        {
            k1 = a(activity.getApplicationContext());
        } else
        {
            b(activity);
            myobfuscated.ad.j j1 = a(activity.getFragmentManager(), ((Fragment) (null)));
            k k2 = j1.c;
            k1 = k2;
            if (k2 == null)
            {
                activity = new k(activity, j1.a, j1.b);
                j1.c = activity;
                return activity;
            }
        }
        return k1;
    }

    public final k a(Context context)
    {
        do
        {
            if (context == null)
            {
                throw new IllegalArgumentException("You cannot start a load on a null Context");
            }
            if (!j.b() || (context instanceof Application))
            {
                break;
            }
            if (context instanceof FragmentActivity)
            {
                return a((FragmentActivity)context);
            }
            if (context instanceof Activity)
            {
                return a((Activity)context);
            }
            if (!(context instanceof ContextWrapper))
            {
                break;
            }
            context = ((ContextWrapper)context).getBaseContext();
        } while (true);
        return b(context);
    }

    public final k a(FragmentActivity fragmentactivity)
    {
        k k1;
        if (j.c())
        {
            k1 = a(fragmentactivity.getApplicationContext());
        } else
        {
            b(fragmentactivity);
            o o1 = a(fragmentactivity.getSupportFragmentManager(), ((android.support.v4.app.Fragment) (null)));
            k k2 = o1.c;
            k1 = k2;
            if (k2 == null)
            {
                fragmentactivity = new k(fragmentactivity, o1.a, o1.b);
                o1.c = fragmentactivity;
                return fragmentactivity;
            }
        }
        return k1;
    }

    final myobfuscated.ad.j a(FragmentManager fragmentmanager, Fragment fragment)
    {
        myobfuscated.ad.j j1 = (myobfuscated.ad.j)fragmentmanager.findFragmentByTag("com.bumptech.glide.manager");
        fragment = j1;
        if (j1 == null)
        {
            myobfuscated.ad.j j2 = (myobfuscated.ad.j)c.get(fragmentmanager);
            fragment = j2;
            if (j2 == null)
            {
                fragment = new myobfuscated.ad.j();
                fragment.d = null;
                c.put(fragmentmanager, fragment);
                fragmentmanager.beginTransaction().add(fragment, "com.bumptech.glide.manager").commitAllowingStateLoss();
                e.obtainMessage(1, fragmentmanager).sendToTarget();
            }
        }
        return fragment;
    }

    final o a(android.support.v4.app.FragmentManager fragmentmanager, android.support.v4.app.Fragment fragment)
    {
        o o1 = (o)fragmentmanager.findFragmentByTag("com.bumptech.glide.manager");
        fragment = o1;
        if (o1 == null)
        {
            o o2 = (o)d.get(fragmentmanager);
            fragment = o2;
            if (o2 == null)
            {
                fragment = new o();
                fragment.d = null;
                d.put(fragmentmanager, fragment);
                fragmentmanager.beginTransaction().add(fragment, "com.bumptech.glide.manager").commitAllowingStateLoss();
                e.obtainMessage(2, fragmentmanager).sendToTarget();
            }
        }
        return fragment;
    }

    public final boolean handleMessage(Message message)
    {
        Object obj1;
        boolean flag;
        obj1 = null;
        flag = true;
        message.what;
        JVM INSTR tableswitch 1 2: default 32
    //                   1 82
    //                   2 104;
           goto _L1 _L2 _L3
_L1:
        Object obj;
        flag = false;
        obj = null;
        message = obj1;
_L5:
        if (flag && obj == null && Log.isLoggable("RMRetriever", 5))
        {
            Log.w("RMRetriever", (new StringBuilder("Failed to remove expected request manager fragment, manager: ")).append(message).toString());
        }
        return flag;
_L2:
        message = (FragmentManager)message.obj;
        obj = c.remove(message);
        continue; /* Loop/switch isn't completed */
_L3:
        message = (android.support.v4.app.FragmentManager)message.obj;
        obj = d.remove(message);
        if (true) goto _L5; else goto _L4
_L4:
    }

}
