// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.jpush.android.api;

import android.app.Activity;
import android.app.TabActivity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import cn.jpush.android.util.a;
import cn.jpush.android.util.ai;
import cn.jpush.android.util.x;
import java.util.HashMap;

// Referenced classes of package cn.jpush.android.api:
//            k, e

final class l
    implements android.app.Application.ActivityLifecycleCallbacks
{

    private static final String z[];

    l()
    {
    }

    public final void onActivityCreated(Activity activity, Bundle bundle)
    {
    }

    public final void onActivityDestroyed(Activity activity)
    {
    }

    public final void onActivityPaused(Activity activity)
    {
label0:
        {
            k.c(activity.getClass().getName());
            if (ai.a(k.f()))
            {
                cn.jpush.android.api.k.a(activity.getClass().getName());
            }
            if (android.os.Build.VERSION.SDK_INT >= 14 && cn.jpush.android.api.k.a)
            {
                if (!cn.jpush.android.api.e.a && e.b().a())
                {
                    k.c().put(k.f(), Integer.valueOf(0));
                    if (!ai.a(k.d()) && k.d().equals(k.f()))
                    {
                        a.b(activity, k.e(), k.f(), 0);
                    }
                }
                if (!(activity instanceof TabActivity))
                {
                    break label0;
                }
                x.e();
            }
            return;
        }
        cn.jpush.android.api.e.a = false;
    }

    public final void onActivityResumed(Activity activity)
    {
label0:
        {
label1:
            {
                cn.jpush.android.api.k.a(activity.getClass().getName());
                if (android.os.Build.VERSION.SDK_INT >= 14 && cn.jpush.android.api.k.a)
                {
                    if (!cn.jpush.android.api.k.a())
                    {
                        break label0;
                    }
                    Intent intent = new Intent(z[2]);
                    intent.setPackage(activity.getPackageName());
                    intent.addCategory(z[1]);
                    activity = activity.getPackageManager().resolveActivity(intent, 0);
                    if (activity != null)
                    {
                        break label1;
                    }
                    x.d(z[3], z[0]);
                }
                return;
            }
            k.b(((ResolveInfo) (activity)).activityInfo.name);
            cn.jpush.android.api.k.a(false);
            return;
        }
        if (!e.b && e.b().a() && k.b() != null)
        {
            if (k.c().containsKey(k.b()))
            {
                k.c().put(k.b(), Integer.valueOf(2));
                if (!ai.a(k.d()) && k.d().equals(k.b()))
                {
                    a.b(activity, k.e(), k.b(), 2);
                }
            } else
            {
                k.c().put(k.b(), Integer.valueOf(1));
                if (!ai.a(k.d()) && k.d().equals(k.b()))
                {
                    a.b(activity, k.e(), k.b(), 1);
                }
            }
        }
        if (activity instanceof TabActivity)
        {
            x.e();
            return;
        } else
        {
            e.b = false;
            return;
        }
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle)
    {
    }

    public final void onActivityStarted(Activity activity)
    {
    }

    public final void onActivityStopped(Activity activity)
    {
    }

    static 
    {
        Object obj;
        String as2[];
        int i;
        int j;
        as2 = new String[4];
        obj = "]$+g~Ae\021geP+,'Pv\021\021F_j\b\031@_\025$6m1|+,l\177Ak\033HEp\002\027[Hj\t\031\\_v\r\035[";
        i = -1;
        j = 0;
_L10:
        String as[];
        int i1;
        int j1;
        int k1;
        int l1;
        as = as2;
        obj = ((String) (obj)).toCharArray();
        i1 = obj.length;
        if (i1 > 1)
        {
            break MISSING_BLOCK_LABEL_298;
        }
        j1 = 0;
        k1 = j;
        l1 = i;
_L9:
        j = j1;
_L7:
        char ac[];
        int i2;
        ac = ((char []) (obj));
        i2 = ac[j1];
        j % 5;
        JVM INSTR tableswitch 0 3: default 92
    //                   0 270
    //                   1 277
    //                   2 284
    //                   3 291;
           goto _L1 _L2 _L3 _L4 _L5
_L2:
        break; /* Loop/switch isn't completed */
_L1:
        i = 17;
_L11:
label0:
        {
            ac[j1] = (char)(i ^ i2);
            j++;
            if (i1 != 0)
            {
                break label0;
            }
            j1 = i1;
        }
        if (true) goto _L7; else goto _L6
        String as1[];
        int j2;
        i = i1;
        as1 = as;
        j2 = k1;
        ac = ((char []) (obj));
        i2 = l1;
_L12:
        l1 = i2;
        obj = ac;
        k1 = j2;
        as = as1;
        i1 = i;
        j1 = j;
        if (i > j) goto _L9; else goto _L8
_L8:
        obj = (new String(ac)).intern();
        switch (i2)
        {
        default:
            as1[j2] = ((String) (obj));
            obj = "T+<{~\\!v`\177A 6}?V$,lvZ7!']t\020\026JYp\027";
            j = 1;
            i = 0;
            break;

        case 0: // '\0'
            as1[j2] = ((String) (obj));
            obj = "T+<{~\\!v`\177A 6}?T&,`~[k\025HX{";
            j = 2;
            i = 1;
            break;

        case 1: // '\001'
            as1[j2] = ((String) (obj));
            j = 3;
            obj = "y,>lRL&4lRT)4kpV.+";
            i = 2;
            break;

        case 2: // '\002'
            as1[j2] = ((String) (obj));
            z = as2;
            return;
        }
          goto _L10
_L6:
        i = 53;
          goto _L11
_L3:
        i = 69;
          goto _L11
_L4:
        i = 88;
          goto _L11
_L5:
        i = 9;
          goto _L11
        boolean flag = false;
        i2 = i;
        ac = ((char []) (obj));
        j2 = j;
        as1 = as;
        i = i1;
        j = ((flag) ? 1 : 0);
          goto _L12
    }
}
