// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.view.View;
import com.bestbuy.android.activities.askexpert.HelpMenuActivity;
import com.bestbuy.android.activities.blueassist.BlueAssistStoreSelectionActivity;
import com.bestbuy.android.api.lib.models.blueshirt.FeatureFlagResponse;
import com.bestbuy.android.base.BBYBaseFragment;

public class hx extends ka
{

    private String a;
    private String j;
    private FeatureFlagResponse k;
    private BBYBaseFragment l;
    private View m;
    private String n;
    private int o;

    public hx(Activity activity, BBYBaseFragment bbybasefragment, View view, String s, String s1, String s2)
    {
        o = 0;
        f = activity;
        l = bbybasefragment;
        m = view;
        a = s;
        j = s1;
        n = s2;
    }

    static int a(hx hx1)
    {
        int i = hx1.o;
        hx1.o = i + 1;
        return i;
    }

    static int a(hx hx1, int i)
    {
        hx1.o = i;
        return i;
    }

    static Activity b(hx hx1)
    {
        return hx1.f;
    }

    static BBYBaseFragment c(hx hx1)
    {
        return hx1.l;
    }

    static View d(hx hx1)
    {
        return hx1.m;
    }

    static String e(hx hx1)
    {
        return hx1.a;
    }

    static String f(hx hx1)
    {
        return hx1.j;
    }

    static String g(hx hx1)
    {
        return hx1.n;
    }

    static Activity h(hx hx1)
    {
        return hx1.f;
    }

    public void a()
    {
        k = fs.a(f, a, j, n);
    }

    public void b()
    {
label0:
        {
label1:
            {
                if (m != null)
                {
                    m.setVisibility(8);
                }
                if (k == null)
                {
                    break label0;
                }
                if (f instanceof HelpMenuActivity)
                {
                    ((HelpMenuActivity)f).a(k);
                }
                if (f instanceof BlueAssistStoreSelectionActivity)
                {
                    if (!k.isBookABlueShirt())
                    {
                        break label1;
                    }
                    ((BlueAssistStoreSelectionActivity)f).a(k.getBookABlueShirtStores());
                }
                return;
            }
            ((BlueAssistStoreSelectionActivity)f).a();
            return;
        }
        if (f instanceof BlueAssistStoreSelectionActivity)
        {
            ((BlueAssistStoreSelectionActivity)f).a();
            return;
        } else
        {
            c();
            return;
        }
    }

    public void c()
    {
        if (m != null)
        {
            m.setVisibility(8);
        }
        nm.a(f, new no() {

            final hx a;

            public void a()
            {
                hx.a(a);
                (new hx(hx.b(a), hx.c(a), hx.d(a), hx.e(a), hx.f(a), hx.g(a))).execute(new Void[0]);
            }

            
            {
                a = hx.this;
                super();
            }
        }, new nn() {

            final hx a;

            public void a()
            {
                hx.a(a, 0);
                hx.h(a).finish();
            }

            
            {
                a = hx.this;
                super();
            }
        }, e, o);
    }
}
