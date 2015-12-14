// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.shop;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

// Referenced classes of package com.picsart.shop:
//            m

public class ShopItemActivity extends AppCompatActivity
{

    private com.socialin.android.apiv3.model.ShopItemsListResponse.ShopItem a;
    private m b;
    private ActionBar c;

    public ShopItemActivity()
    {
        a = null;
        b = null;
    }

    public final void a(int i)
    {
        if (a != null && a.data.bannersCount > 0)
        {
            ((TextView)findViewById(0x7f100186)).setTextColor(Color.argb(i, 255, 255, 255));
        }
    }

    public final void a(com.socialin.android.apiv3.model.ShopItemsListResponse.ShopItem shopitem)
    {
        a = shopitem;
        if (shopitem != null)
        {
            if (shopitem.data.bannersCount > 0)
            {
                b(0);
                a(0);
                findViewById(0x7f10013a).setPadding(0, 0, 0, 0);
            } else
            {
                findViewById(0x7f10017b).measure(0, 0);
                findViewById(0x7f10017b).setBackgroundColor(getResources().getColor(0x7f0f00c0));
                findViewById(0x7f10013a).setPadding(0, findViewById(0x7f10017b).getMeasuredHeight(), 0, 0);
                a(255);
            }
            shopitem = shopitem.data.name;
            ((TextView)findViewById(0x7f100186)).setText(shopitem);
            c.setTitle("");
        }
    }

    public final void b(int i)
    {
label0:
        {
            if (c != null)
            {
                if (a == null || a.data.bannersCount <= 0)
                {
                    break label0;
                }
                c.setBackgroundDrawable(new ColorDrawable(Color.argb(i, 29, 29, 29)));
            }
            return;
        }
        c.setBackgroundDrawable(new ColorDrawable(Color.argb(255, 29, 29, 29)));
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
        if (b != null)
        {
            b.onActivityResult(i, j, intent);
        }
    }

    public void onBackPressed()
    {
        Intent intent = new Intent();
        if (b != null && b.a)
        {
            intent.putExtra("needUpdate", true);
        }
        setResult(-1, intent);
        finish();
        super.onBackPressed();
    }

    protected void onCreate(Bundle bundle)
    {
        getWindow().requestFeature(9);
        super.onCreate(bundle);
        setContentView(0x7f030029);
        a = (com.socialin.android.apiv3.model.ShopItemsListResponse.ShopItem)getIntent().getParcelableExtra("selectedShopItem");
        bundle = getFragmentManager().beginTransaction();
        Bundle bundle1 = new Bundle();
        bundle1.putParcelable("selectedShopItem", a);
        bundle1.putString("fromSource", "shopItem");
        b = new m();
        b.setArguments(bundle1);
        bundle.replace(0x7f10013a, b, "shopFragment");
        bundle.commitAllowingStateLoss();
        setSupportActionBar((Toolbar)findViewById(0x7f10017b));
        c = getSupportActionBar();
        c.setDisplayHomeAsUpEnabled(false);
        a(a);
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        c.setDisplayShowHomeEnabled(false);
        c.setDisplayHomeAsUpEnabled(true);
        c.setDisplayUseLogoEnabled(false);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        if (menuitem.getItemId() == 0x102002c)
        {
            onBackPressed();
        }
        return super.onOptionsItemSelected(menuitem);
    }
}
