// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.b;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.h;
import android.support.v4.app.i;
import com.facebook.k;

// Referenced classes of package com.facebook.b:
//            p, v, t, l

public final class j extends h
{

    public Dialog aj;

    public j()
    {
    }

    private void a(Bundle bundle, com.facebook.h h1)
    {
        i i1 = getActivity();
        bundle = p.a(i1.getIntent(), bundle, h1);
        byte byte0;
        if (h1 == null)
        {
            byte0 = -1;
        } else
        {
            byte0 = 0;
        }
        i1.setResult(byte0, bundle);
        i1.finish();
    }

    static void a(j j1, Bundle bundle)
    {
        i i1 = j1.getActivity();
        Intent intent = new Intent();
        j1 = bundle;
        if (bundle == null)
        {
            j1 = new Bundle();
        }
        intent.putExtras(j1);
        i1.setResult(-1, intent);
        i1.finish();
    }

    static void a(j j1, Bundle bundle, com.facebook.h h1)
    {
        j1.a(bundle, h1);
    }

    public final Dialog a(Bundle bundle)
    {
        if (aj == null)
        {
            a(((Bundle) (null)), ((com.facebook.h) (null)));
            super.d = false;
        }
        return aj;
    }

    public final void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
        if (aj instanceof v)
        {
            ((v)aj).a();
        }
    }

    public final void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (aj != null) goto _L2; else goto _L1
_L1:
        Bundle bundle1;
        bundle = getActivity();
        bundle1 = p.a(bundle.getIntent());
        if (bundle1.getBoolean("is_fallback", false)) goto _L4; else goto _L3
_L3:
        String s;
        s = bundle1.getString("action");
        bundle1 = bundle1.getBundle("params");
        if (!t.a(s)) goto _L6; else goto _L5
_L5:
        t.a();
        bundle.finish();
_L2:
        return;
_L6:
        bundle = new v.a(bundle, s, bundle1);
        bundle.d = new v.c() {

            final j a;

            public final void a(Bundle bundle2, com.facebook.h h1)
            {
                j.a(a, bundle2, h1);
            }

            
            {
                a = j.this;
                super();
            }
        };
        bundle = bundle.a();
_L8:
        aj = bundle;
        return;
_L4:
        String s1 = bundle1.getString("url");
        if (t.a(s1))
        {
            t.a();
            bundle.finish();
            return;
        }
        bundle = new l(bundle, s1, String.format("fb%s://bridge/", new Object[] {
            k.j()
        }));
        bundle.b = new v.c() {

            final j a;

            public final void a(Bundle bundle2, com.facebook.h h1)
            {
                j.a(a, bundle2);
            }

            
            {
                a = j.this;
                super();
            }
        };
        if (true) goto _L8; else goto _L7
_L7:
    }

    public final void onDestroyView()
    {
        if (super.f != null && getRetainInstance())
        {
            super.f.setDismissMessage(null);
        }
        super.onDestroyView();
    }
}
