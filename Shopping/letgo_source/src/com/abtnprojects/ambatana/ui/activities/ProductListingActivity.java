// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.ui.activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.i;
import android.support.v4.app.m;
import android.support.v7.aqo;
import android.support.v7.du;
import android.support.v7.dw;
import android.support.v7.gh;
import android.support.v7.gi;
import android.support.v7.ie;
import android.support.v7.is;
import android.support.v7.iv;
import android.view.Menu;
import com.abtnprojects.ambatana.LetgoApplication;
import com.abtnprojects.ambatana.datasource.entities.mapper.AddressMapper;
import com.abtnprojects.ambatana.location.GeocodeIntentService;
import com.abtnprojects.ambatana.models.CurrentUserLocation;
import com.abtnprojects.ambatana.models.LatitudeLongitude;
import com.abtnprojects.ambatana.models.LetgoAddress;
import com.abtnprojects.ambatana.ui.fragments.ProductListFragment;

// Referenced classes of package com.abtnprojects.ambatana.ui.activities:
//            e

public class ProductListingActivity extends e
    implements com.abtnprojects.ambatana.ui.widgets.SellButtonLayout.a
{
    static interface a
    {

        public abstract void a();

        public abstract void b();
    }


    private ie A;
    private AlertDialog B;
    private AlertDialog C;
    public gi n;

    public ProductListingActivity()
    {
    }

    private ProductListFragment D()
    {
        return (ProductListFragment)f().a(com/abtnprojects/ambatana/ui/fragments/ProductListFragment.getSimpleName());
    }

    private void E()
    {
        ProductListFragment productlistfragment = D();
        if (productlistfragment != null)
        {
            productlistfragment.X();
            return;
        } else
        {
            n();
            return;
        }
    }

    private void F()
    {
        if (is.g(this))
        {
            Object obj = LetgoApplication.i();
            q = new dw(this, new AddressMapper());
            Object obj1 = q.a();
            LatitudeLongitude latitudelongitude;
            if (obj1 == null)
            {
                latitudelongitude = null;
            } else
            {
                latitudelongitude = ((LetgoAddress) (obj1)).getPoint();
            }
            if (obj != null && obj1 != null)
            {
                obj1 = new Location("");
                ((Location) (obj1)).setLatitude(((CurrentUserLocation) (obj)).getLatitude());
                ((Location) (obj1)).setLongitude(((CurrentUserLocation) (obj)).getLongitude());
                obj = new Location("");
                ((Location) (obj)).setLatitude(latitudelongitude.getLatitude());
                ((Location) (obj)).setLongitude(latitudelongitude.getLongitude());
                float f = ((Location) (obj1)).distanceTo(((Location) (obj)));
                aqo.a("distance %f", new Object[] {
                    Float.valueOf(f)
                });
                if (f >= 1000F)
                {
                    B = a(0x7f090146, 0x1040013, 0x1040009, new a() {

                        final ProductListingActivity a;

                        public void a()
                        {
                            ProductListingActivity.a(a);
                        }

                        public void b()
                        {
                            ProductListingActivity.a(a, ProductListingActivity.a(a, 0x7f090144, 0x7f090145, 0x1040000, new a(this) {

                                final _cls1 a;

                                public void a()
                                {
                                    ProductListingActivity.a(a.a);
                                }

                                public void b()
                                {
                                }

            
            {
                a = _pcls1;
                super();
            }
                            }));
                            ProductListingActivity.b(a).show();
                        }

            
            {
                a = ProductListingActivity.this;
                super();
            }
                    });
                    B.show();
                }
            }
        }
    }

    private void G()
    {
        is.d(this, false);
        Object obj = LetgoApplication.i();
        if (obj != null)
        {
            Location location = new Location(((CurrentUserLocation) (obj)).getProvider());
            location.setLatitude(((CurrentUserLocation) (obj)).getLatitude());
            location.setLongitude(((CurrentUserLocation) (obj)).getLongitude());
            location.setTime(((CurrentUserLocation) (obj)).getLastUpdated());
            GeocodeIntentService.a(this, location, false);
        }
        LetgoApplication.f();
        obj = (ProductListFragment)f().a(com/abtnprojects/ambatana/ui/fragments/ProductListFragment.getSimpleName());
        if (obj != null && ((ProductListFragment) (obj)).n())
        {
            ((ProductListFragment) (obj)).X();
        }
    }

    private AlertDialog a(int j, int k, int i1, a a1)
    {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
        builder.setPositiveButton(getString(k), new android.content.DialogInterface.OnClickListener(a1) {

            final a a;
            final ProductListingActivity b;

            public void onClick(DialogInterface dialoginterface, int j1)
            {
                dialoginterface.dismiss();
                a.a();
            }

            
            {
                b = ProductListingActivity.this;
                a = a1;
                super();
            }
        });
        builder.setNegativeButton(getString(i1), new android.content.DialogInterface.OnClickListener(a1) {

            final a a;
            final ProductListingActivity b;

            public void onClick(DialogInterface dialoginterface, int j1)
            {
                dialoginterface.dismiss();
                a.b();
            }

            
            {
                b = ProductListingActivity.this;
                a = a1;
                super();
            }
        });
        a1 = builder.create();
        a1.setMessage(getString(j));
        a1.setCancelable(false);
        return a1;
    }

    static AlertDialog a(ProductListingActivity productlistingactivity, int j, int k, int i1, a a1)
    {
        return productlistingactivity.a(j, k, i1, a1);
    }

    static AlertDialog a(ProductListingActivity productlistingactivity, AlertDialog alertdialog)
    {
        productlistingactivity.C = alertdialog;
        return alertdialog;
    }

    static void a(ProductListingActivity productlistingactivity)
    {
        productlistingactivity.G();
    }

    static AlertDialog b(ProductListingActivity productlistingactivity)
    {
        return productlistingactivity.C;
    }

    public void l()
    {
        if (A != null)
        {
            A.a();
        }
    }

    protected boolean m()
    {
        boolean flag1 = false;
        Object obj = getIntent().getExtras();
        boolean flag = flag1;
        if (obj != null)
        {
            flag = flag1;
            if (((Bundle) (obj)).containsKey("referral"))
            {
                obj = ((Bundle) (obj)).getString("referral");
                flag = flag1;
                if (obj != null)
                {
                    flag = flag1;
                    if ("sold".equals(obj))
                    {
                        flag = flag1;
                        if (!z())
                        {
                            flag = true;
                        }
                    }
                }
            }
        }
        return flag;
    }

    protected void n()
    {
        f().a().a(0x7f100082, ProductListFragment.Y(), com/abtnprojects/ambatana/ui/fragments/ProductListFragment.getSimpleName()).a();
    }

    public void o()
    {
        E();
    }

    protected void onActivityResult(int j, int k, Intent intent)
    {
        super.onActivityResult(j, k, intent);
        intent = D();
        j;
        JVM INSTR tableswitch 2 5: default 44
    //                   2 54
    //                   3 44
    //                   4 70
    //                   5 45;
           goto _L1 _L2 _L1 _L3 _L4
_L1:
        return;
_L4:
        if (intent == null)
        {
            n();
            return;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        if (intent != null && k == -1)
        {
            setTitle("");
            return;
        }
        continue; /* Loop/switch isn't completed */
_L3:
        if (k == -1)
        {
            t();
            return;
        }
        if (true) goto _L1; else goto _L5
_L5:
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        A = new ie(this);
        n = new gh();
        n.a(this);
        n();
        iv.a(this);
        F();
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        super.onCreateOptionsMenu(menu);
        return true;
    }

    protected void onDestroy()
    {
        iv.b(this);
        ProductListFragment productlistfragment = D();
        if (productlistfragment != null)
        {
            productlistfragment.c();
        }
        super.onDestroy();
    }

    protected void onPause()
    {
        super.onPause();
        iv.a(B);
        iv.a(C);
    }

    protected void onResume()
    {
        super.onResume();
        a("");
        c("");
        ProductListFragment productlistfragment = (ProductListFragment)f().a(com/abtnprojects/ambatana/ui/fragments/ProductListFragment.getSimpleName());
        if (productlistfragment != null && is.f(this))
        {
            is.c(this, false);
            productlistfragment.X();
        }
    }

    protected void onStart()
    {
        super.onStart();
    }

    protected void q()
    {
    }

    protected void t()
    {
        E();
    }

    protected long y()
    {
        Object obj = getIntent().getExtras();
        if (obj != null && ((Bundle) (obj)).containsKey("referral"))
        {
            obj = ((Bundle) (obj)).getString("referral");
            if (obj != null && "sold".equals(obj))
            {
                return super.y() + 1L;
            }
        }
        return super.y();
    }
}
