// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.content.Intent;
import android.content.res.Resources;
import android.widget.Toast;
import com.crittercism.app.Crittercism;
import com.smule.android.c.a;
import com.smule.android.c.aa;
import com.smule.android.d.c;
import com.smule.android.d.f;
import com.smule.android.d.g;
import com.smule.android.network.managers.ap;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            ap, n, MagicApplication

public class aq
    implements c
{

    final com.smule.pianoandroid.magicpiano.ap a;

    public aq(com.smule.pianoandroid.magicpiano.ap ap1)
    {
        a = ap1;
        super();
    }

    public void a(f f1)
    {
        if (f1 == f.a)
        {
            aa.c(ap.d(), "purchase request was successfully sent to server");
        } else
        if (f1 == f.b)
        {
            aa.c(ap.d(), "user canceled purchase");
            ap.e();
        } else
        {
            aa.c(ap.d(), "purchase request failed!");
            Toast.makeText(a, a.getResources().getString(0x7f0c01f9), 1).show();
            ap.e();
        }
        com.smule.pianoandroid.magicpiano.ap.g(a);
    }

    public void a(f f1, String s)
    {
label0:
        {
            if (com.smule.pianoandroid.magicpiano.ap.a(a) != null)
            {
                break label0;
            }
            aa.b(ap.d(), "mLastSubClicked is null, this should not happen.  Analytics event will be missing some parameters.");
            Iterator iterator = ap.b(a).iterator();
            com.smule.android.network.models.f f2;
            do
            {
                if (!iterator.hasNext())
                {
                    break label0;
                }
                f2 = (com.smule.android.network.models.f)iterator.next();
            } while (!f2.sku.equals(s));
            com.smule.pianoandroid.magicpiano.ap.a(a, f2);
        }
        Object obj = com.smule.pianoandroid.utils.c.a((new StringBuilder()).append("US; ").append(com.smule.pianoandroid.magicpiano.ap.a(a).a).toString());
        String s4 = com.smule.pianoandroid.magicpiano.ap.a(a).period;
        com.smule.android.c.a.a(s, s4, ((String) (obj)), f1.name());
        if (f1.equals(f.b))
        {
            f1 = a.getResources().getString(0x7f0c027e);
            String s1 = a.getResources().getString(0x7f0c027c);
            String s2 = a.getResources().getString(0x7f0c027d);
            String s3 = a.getResources().getString(0x7f0c027f);
            s = new Runnable(s, s4, ((String) (obj))) {

                final String a;
                final String b;
                final String c;
                final aq d;

                public void run()
                {
                    if (com.smule.pianoandroid.magicpiano.ap.c(d.a) > 0)
                    {
                        Crittercism.a((new Exception()).initCause(ap.d(d.a)));
                        return;
                    }
                    ap.e(d.a);
                    com.smule.pianoandroid.magicpiano.ap.a(d.a, new Exception());
                    try
                    {
                        com.smule.pianoandroid.magicpiano.ap.f(d.a).b(a);
                        com.smule.android.c.a.a(a, b, c);
                        return;
                    }
                    catch (IllegalStateException illegalstateexception)
                    {
                        aa.b(ap.d(), (new StringBuilder()).append("Failed to purchase subscription ").append(a).toString(), illegalstateexception);
                        Crittercism.a(illegalstateexception);
                        return;
                    }
                }

            
            {
                d = aq.this;
                a = s;
                b = s1;
                c = s2;
                super();
            }
            };
            obj = new Runnable() {

                final aq a;

                public void run()
                {
                    com.smule.pianoandroid.magicpiano.ap.a(a.a, null);
                }

            
            {
                a = aq.this;
                super();
            }
            };
            com.smule.pianoandroid.magicpiano.n.a(a, 0x7f020120, f1, null, s1, s2, s3, ((Runnable) (obj)), s).show();
        }
    }

    public void a(boolean flag)
    {
        if (flag)
        {
            Intent intent = a.getIntent();
            String s = null;
            if (intent.hasExtra("DESIRED_SUBSCRIPTION"))
            {
                s = intent.getStringExtra("DESIRED_SUBSCRIPTION");
            }
            com.smule.pianoandroid.magicpiano.ap.a(a, s);
        } else
        {
            a.showDialog(2);
        }
        com.smule.pianoandroid.magicpiano.ap.a(a, Boolean.valueOf(flag));
    }

    public void a(boolean flag, String s)
    {
        if (!flag)
        {
            aa.b(ap.d(), (new StringBuilder()).append("unexpected purchase state for ").append(s).toString());
            return;
        }
        aa.a(ap.d(), (new StringBuilder()).append("purchase state success for ").append(s).toString());
        MagicApplication.getInstance().showToast(a.getResources().getString(0x7f0c01fb), 1);
        if (ap.a().b(s) == null)
        {
            aa.b(ap.d(), (new StringBuilder()).append("no data found for sku: ").append(s).toString());
            return;
        } else
        {
            ap.h(a);
            return;
        }
    }

    public void b(f f1)
    {
        aa.a(ap.d(), (new StringBuilder()).append("doRestorePurchases returned with responseCode: ").append(f1.name()).toString());
    }
}
