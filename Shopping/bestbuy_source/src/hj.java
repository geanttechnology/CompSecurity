// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v4.app.FragmentManager;
import android.view.View;
import com.bestbuy.android.activities.browseproduct.pdp.PDPBundledItemsFragment;
import com.bestbuy.android.activities.browseproduct.plp.PLPBundledProductFragment;
import com.bestbuy.android.activities.browseproduct.plp.PLPFragment;
import com.bestbuy.android.activities.cart.MyCartFragment;
import com.bestbuy.android.activities.home.HomeActivity;
import com.bestbuy.android.activities.registry.ScannedItemActivity;
import com.bestbuy.android.activities.registry.ScannedItemFragment;
import com.bestbuy.android.base.BBYBaseFragment;
import java.util.ArrayList;

public class hj extends ka
{

    private static int l = 0;
    boolean a;
    private ArrayList j;
    private ArrayList k;

    public hj(Activity activity, BBYBaseFragment bbybasefragment, View view, ArrayList arraylist)
    {
        super(activity, bbybasefragment);
        a = false;
        g = view;
        k = arraylist;
    }

    static Activity a(hj hj1)
    {
        return hj1.f;
    }

    static Activity b(hj hj1)
    {
        return hj1.f;
    }

    static Activity c(hj hj1)
    {
        return hj1.f;
    }

    static Activity d(hj hj1)
    {
        return hj1.f;
    }

    static BBYBaseFragment e(hj hj1)
    {
        return hj1.i;
    }

    private void f()
    {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(f);
        builder.setCancelable(true);
        builder.setMessage(0x7f0802e9);
        builder.setNeutralButton(0x7f080283, new android.content.DialogInterface.OnClickListener() {

            final hj a;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                hj.e(a).getFragmentManager().popBackStackImmediate();
            }

            
            {
                a = hj.this;
                super();
            }
        });
        builder.create().show();
    }

    public void a()
    {
        j = fs.a(k);
    }

    public void b()
    {
        if (g != null)
        {
            g.setVisibility(8);
        }
        if (j != null && (j == null || !j.isEmpty())) goto _L2; else goto _L1
_L1:
        if (!(i instanceof ScannedItemFragment)) goto _L4; else goto _L3
_L3:
        f();
_L6:
        return;
_L4:
        c();
        return;
_L2:
        l = 0;
        if ((i instanceof PDPBundledItemsFragment) && i.isAdded())
        {
            ((PDPBundledItemsFragment)i).a(j);
            return;
        }
        if ((i instanceof MyCartFragment) && i.isAdded())
        {
            ((MyCartFragment)i).a(j);
            return;
        }
        if ((i instanceof PLPFragment) && i.isAdded())
        {
            ((PLPFragment)i).a(j, true);
            return;
        }
        if ((i instanceof ScannedItemFragment) && i.isAdded())
        {
            ((ScannedItemFragment)i).a(j);
            return;
        }
        if ((i instanceof PLPBundledProductFragment) && i.isAdded())
        {
            ((PLPBundledProductFragment)i).a(j);
            return;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public void c()
    {
        if (g != null)
        {
            g.setVisibility(8);
        }
        if ((i instanceof PDPBundledItemsFragment) && i.isAdded())
        {
            ((PDPBundledItemsFragment)i).b();
            return;
        } else
        {
            nm.a(f, new no() {

                final hj a;

                public void a()
                {
                    a.d();
                }

            
            {
                a = hj.this;
                super();
            }
            }, new nn() {

                final hj a;

                public void a()
                {
                    if (hj.a(a) instanceof HomeActivity)
                    {
                        ((HomeActivity)hj.b(a)).onBackPressed();
                    } else
                    if (hj.c(a) instanceof ScannedItemActivity)
                    {
                        ((ScannedItemActivity)hj.d(a)).onBackPressed();
                        return;
                    }
                }

            
            {
                a = hj.this;
                super();
            }
            }, e, l);
            return;
        }
    }

    public void d()
    {
        l++;
        (new hj(f, i, g, k)).executeOnExecutor(nb.h, new Void[0]);
    }

    public void e()
    {
        if (g != null)
        {
            g.setVisibility(0);
        }
        j = new ArrayList();
    }

}
