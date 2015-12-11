// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Handler;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

final class jr
{

    final Context a;
    final Handler b = new Handler();
    boolean c;
    final BroadcastReceiver d = new js(this);
    final Runnable e = new jt(this);
    private final ju f;
    private final PackageManager g;
    private final ArrayList h = new ArrayList();

    public jr(Context context, ju ju1)
    {
        a = context;
        f = ju1;
        g = context.getPackageManager();
    }

    private int a(String s, String s1)
    {
        int j = h.size();
        boolean flag;
        for (int i = 0; i < j; i++)
        {
            jk jk1 = (jk)h.get(i);
            if (jk1.j.getPackageName().equals(s) && jk1.j.getClassName().equals(s1))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                return i;
            }
        }

        return -1;
    }

    static void a(jr jr1)
    {
        if (jr1.c)
        {
            Object obj = new Intent("android.media.MediaRouteProviderService");
            obj = jr1.g.queryIntentServices(((Intent) (obj)), 0).iterator();
            int i = 0;
            do
            {
                if (!((Iterator) (obj)).hasNext())
                {
                    break;
                }
                Object obj1 = ((ResolveInfo)((Iterator) (obj)).next()).serviceInfo;
                if (obj1 != null)
                {
                    int l = jr1.a(((ServiceInfo) (obj1)).packageName, ((ServiceInfo) (obj1)).name);
                    if (l < 0)
                    {
                        obj1 = new jk(jr1.a, new ComponentName(((ServiceInfo) (obj1)).packageName, ((ServiceInfo) (obj1)).name));
                        ((jk) (obj1)).a();
                        jr1.h.add(i, obj1);
                        jr1.f.a(((ii) (obj1)));
                        i++;
                    } else
                    if (l >= i)
                    {
                        Object obj2 = (jk)jr1.h.get(l);
                        ((jk) (obj2)).a();
                        if (((jk) (obj2)).l == null && ((jk) (obj2)).c())
                        {
                            ((jk) (obj2)).e();
                            ((jk) (obj2)).d();
                        }
                        obj2 = jr1.h;
                        int j = i + 1;
                        Collections.swap(((List) (obj2)), l, i);
                        i = j;
                    }
                }
            } while (true);
            if (i < jr1.h.size())
            {
                for (int k = jr1.h.size() - 1; k >= i; k--)
                {
                    jk jk1 = (jk)jr1.h.get(k);
                    jr1.f.b(jk1);
                    jr1.h.remove(jk1);
                    if (!jk1.k)
                    {
                        continue;
                    }
                    if (jk.i)
                    {
                        (new StringBuilder()).append(jk1).append(": Stopping");
                    }
                    jk1.k = false;
                    jk1.b();
                }

            }
        }
    }
}
