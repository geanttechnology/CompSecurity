// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.facebook.FacebookActivity;
import com.facebook.h;
import com.facebook.k;
import java.util.UUID;

// Referenced classes of package android.support.v7:
//            ji, jo, jx, kc, 
//            kb

public class jp
{
    public static interface a
    {

        public abstract Bundle a();

        public abstract Bundle b();
    }


    public static void a(ji ji1)
    {
        a(ji1, new h("Unable to show the provided content via the web or the installed version of the Facebook app. Some dialogs are only supported starting API 14."));
    }

    public static void a(ji ji1, Activity activity)
    {
        activity.startActivityForResult(ji1.b(), ji1.d());
        ji1.e();
    }

    public static void a(ji ji1, Fragment fragment)
    {
        fragment.a(ji1.b(), ji1.d());
        ji1.e();
    }

    public static void a(ji ji1, a a1, jo jo1)
    {
        android.content.Context context = k.f();
        String s = jo1.a();
        int i = b(jo1);
        if (i == -1)
        {
            throw new h("Cannot present this dialog. This likely means that the Facebook app is not installed.");
        }
        if (jx.a(i))
        {
            a1 = a1.a();
        } else
        {
            a1 = a1.b();
        }
        jo1 = a1;
        if (a1 == null)
        {
            jo1 = new Bundle();
        }
        a1 = jx.a(context, ji1.c().toString(), s, i, jo1);
        if (a1 == null)
        {
            throw new h("Unable to create Intent; this likely means theFacebook app is not installed.");
        } else
        {
            ji1.a(a1);
            return;
        }
    }

    public static void a(ji ji1, h h1)
    {
        b(ji1, h1);
    }

    public static void a(ji ji1, String s, Bundle bundle)
    {
        kc.b(k.f());
        kc.a(k.f());
        Bundle bundle1 = new Bundle();
        bundle1.putString("action", s);
        bundle1.putBundle("params", bundle);
        bundle = new Intent();
        jx.a(bundle, ji1.c().toString(), s, jx.a(), bundle1);
        bundle.setClass(k.f(), com/facebook/FacebookActivity);
        bundle.setAction("FacebookDialogFragment");
        ji1.a(bundle);
    }

    public static boolean a(jo jo1)
    {
        return b(jo1) != -1;
    }

    private static int[] a(String s, String s1, jo jo1)
    {
        s = kb.a(s, s1, jo1.name());
        if (s != null)
        {
            return s.c();
        } else
        {
            return (new int[] {
                jo1.b()
            });
        }
    }

    public static int b(jo jo1)
    {
        String s = k.i();
        String s1 = jo1.a();
        return jx.a(s1, a(s, s1, jo1));
    }

    public static void b(ji ji1, h h1)
    {
        if (h1 == null)
        {
            return;
        } else
        {
            kc.b(k.f());
            Intent intent = new Intent();
            intent.setClass(k.f(), com/facebook/FacebookActivity);
            intent.setAction(FacebookActivity.n);
            jx.a(intent, ji1.c().toString(), null, jx.a(), jx.a(h1));
            ji1.a(intent);
            return;
        }
    }
}
