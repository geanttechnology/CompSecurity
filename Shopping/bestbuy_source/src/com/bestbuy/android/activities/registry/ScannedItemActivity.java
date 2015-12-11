// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.registry;

import android.app.ActionBar;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.bestbuy.android.base.BBYBaseFragmentActivity;
import lu;

// Referenced classes of package com.bestbuy.android.activities.registry:
//            ScannedItemFragment

public class ScannedItemActivity extends BBYBaseFragmentActivity
{

    private String a;
    private String b;
    private String c;
    private String d;

    public ScannedItemActivity()
    {
    }

    private void a()
    {
        getActionBar().setBackgroundDrawable(new ColorDrawable(0xff00385f));
        getActionBar().setTitle("");
        getActionBar().setDisplayShowHomeEnabled(false);
        Object obj = getIntent().getExtras();
        if (obj != null && ((Bundle) (obj)).containsKey("skuid"))
        {
            b = ((Bundle) (obj)).getString("skuid");
        }
        if (obj != null && ((Bundle) (obj)).containsKey("uuid"))
        {
            c = ((Bundle) (obj)).getString("uuid");
        }
        if (obj != null && ((Bundle) (obj)).containsKey("type"))
        {
            d = ((Bundle) (obj)).getString("type");
        }
        if (obj != null && ((Bundle) (obj)).containsKey("FragmentName"))
        {
            a = ((Bundle) (obj)).getString("FragmentName");
        }
        obj = getSupportFragmentManager().beginTransaction();
        if (a == null || a.equals("ScannedItemFragment"))
        {
            ScannedItemFragment scanneditemfragment = new ScannedItemFragment(this, b, c, d);
            getActionBar().hide();
            ((FragmentTransaction) (obj)).add(0x7f0c0182, scanneditemfragment, "ScannedItemFragment");
            ((FragmentTransaction) (obj)).commit();
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030101);
        a();
    }

    protected void onPause()
    {
        super.onPause();
        lu.a();
    }

    public void onResume()
    {
        super.onResume();
        lu.a(this);
    }
}
