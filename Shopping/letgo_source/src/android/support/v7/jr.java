// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.f;
import android.support.v4.app.g;
import com.facebook.h;
import com.facebook.k;

// Referenced classes of package android.support.v7:
//            jx, kb, jt, kd

public class jr extends f
{

    private Dialog aj;

    public jr()
    {
    }

    private void a(Bundle bundle, h h)
    {
        g g1 = j();
        bundle = jx.a(g1.getIntent(), bundle, h);
        byte byte0;
        if (h == null)
        {
            byte0 = -1;
        } else
        {
            byte0 = 0;
        }
        g1.setResult(byte0, bundle);
        g1.finish();
    }

    static void a(jr jr1, Bundle bundle)
    {
        jr1.l(bundle);
    }

    static void a(jr jr1, Bundle bundle, h h)
    {
        jr1.a(bundle, h);
    }

    private void l(Bundle bundle)
    {
        g g1 = j();
        Intent intent = new Intent();
        Bundle bundle1 = bundle;
        if (bundle == null)
        {
            bundle1 = new Bundle();
        }
        intent.putExtras(bundle1);
        g1.setResult(-1, intent);
        g1.finish();
    }

    public void a(Dialog dialog)
    {
        aj = dialog;
    }

    public void a(Bundle bundle)
    {
        super.a(bundle);
        if (aj != null) goto _L2; else goto _L1
_L1:
        Bundle bundle1;
        bundle = j();
        bundle1 = jx.d(bundle.getIntent());
        if (bundle1.getBoolean("is_fallback", false)) goto _L4; else goto _L3
_L3:
        String s;
        s = bundle1.getString("action");
        bundle1 = bundle1.getBundle("params");
        if (!kb.a(s)) goto _L6; else goto _L5
_L5:
        kb.a("FacebookDialogFragment", "Cannot start a WebDialog with an empty/missing 'actionName'");
        bundle.finish();
_L2:
        return;
_L6:
        bundle = (new kd.a(bundle, s, bundle1)).a(new kd.c() {

            final jr a;

            public void a(Bundle bundle2, h h)
            {
                jr.a(a, bundle2, h);
            }

            
            {
                a = jr.this;
                super();
            }
        }).a();
_L8:
        aj = bundle;
        return;
_L4:
        String s1 = bundle1.getString("url");
        if (kb.a(s1))
        {
            kb.a("FacebookDialogFragment", "Cannot start a fallback WebDialog with an empty/missing 'url'");
            bundle.finish();
            return;
        }
        bundle = new jt(bundle, s1, String.format("fb%s://bridge/", new Object[] {
            k.i()
        }));
        bundle.a(new kd.c() {

            final jr a;

            public void a(Bundle bundle2, h h)
            {
                jr.a(a, bundle2);
            }

            
            {
                a = jr.this;
                super();
            }
        });
        if (true) goto _L8; else goto _L7
_L7:
    }

    public Dialog c(Bundle bundle)
    {
        if (aj == null)
        {
            a(((Bundle) (null)), ((h) (null)));
            b(false);
        }
        return aj;
    }

    public void g()
    {
        if (b() != null && r())
        {
            b().setDismissMessage(null);
        }
        super.g();
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
        if (aj instanceof kd)
        {
            ((kd)aj).d();
        }
    }
}
