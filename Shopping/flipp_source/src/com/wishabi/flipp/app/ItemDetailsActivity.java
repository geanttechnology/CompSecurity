// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.app;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.bd;
import android.support.v4.app.dd;
import android.view.MenuItem;
import android.widget.FrameLayout;

// Referenced classes of package com.wishabi.flipp.app:
//            dm, cw, FlippApplication, n, 
//            CouponDetailsActivity, cx, dl, de

public class ItemDetailsActivity extends Activity
    implements dm
{

    private String a;
    private cx b;
    private final de c = new cw(this);

    public ItemDetailsActivity()
    {
    }

    public static Intent a(long l, float f, String s)
    {
        Bundle bundle = new Bundle();
        bundle.putLong("item_id", l);
        bundle.putFloat("item_ratio", f);
        bundle.putString("item_subtitle", s);
        s = FlippApplication.b();
        if (s == null)
        {
            return null;
        } else
        {
            s = new Intent(s, com/wishabi/flipp/app/ItemDetailsActivity);
            s.putExtra("item_details_activity_params", bundle);
            return s;
        }
    }

    static String a(ItemDetailsActivity itemdetailsactivity)
    {
        return itemdetailsactivity.a;
    }

    public final void a(Class class1, Bundle bundle)
    {
        Intent intent = null;
        if (class1 == com/wishabi/flipp/app/n)
        {
            intent = CouponDetailsActivity.a(bundle);
        }
        if (intent == null)
        {
            return;
        } else
        {
            startActivity(intent);
            overridePendingTransition(0x7f040001, 0x7f040002);
            return;
        }
    }

    public final void a(String s)
    {
    }

    public final boolean a()
    {
        return false;
    }

    public void onBackPressed()
    {
        super.onBackPressed();
        overridePendingTransition(0x7f040000, 0x7f040003);
    }

    protected void onCreate(Bundle bundle)
    {
        long l = 0L;
        float f = 1.0F;
        super.onCreate(bundle);
        setContentView(new FrameLayout(this), new android.widget.FrameLayout.LayoutParams(-1, -1));
        setTitle("");
        Bundle bundle1 = getIntent().getBundleExtra("item_details_activity_params");
        if (bundle1 != null)
        {
            l = bundle1.getLong("item_id", 0L);
            f = bundle1.getFloat("item_ratio", 1.0F);
            a = bundle1.getString("item_subtitle");
        }
        if (bundle == null)
        {
            b = cx.b(l, f);
            getFragmentManager().beginTransaction().add(0x1020002, b).commit();
        } else
        {
            b = (cx)getFragmentManager().getFragment(bundle, "item_details_fragment");
        }
        if (b != null)
        {
            b.a = c;
            b.b = this;
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        if (menuitem.getItemId() == 0x102002c)
        {
            menuitem = bd.a(this);
            if (android.os.Build.VERSION.SDK_INT >= 16 && bd.a(this, menuitem))
            {
                dd.a(this).a(this).a();
            } else
            {
                finish();
                overridePendingTransition(0x7f040000, 0x7f040003);
            }
            return true;
        } else
        {
            return super.onOptionsItemSelected(menuitem);
        }
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        if (b != null)
        {
            getFragmentManager().putFragment(bundle, "item_details_fragment", b);
        }
    }
}
