// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.collages;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.PersistableBundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.picsart.shop.ShopItemActivity;
import com.socialin.android.activity.AdBaseActivity;
import com.socialin.android.apiv3.util.Inventory;
import com.socialin.android.picsart.profile.invite.i;
import com.socialin.android.util.a;

// Referenced classes of package com.picsart.collages:
//            e, d

public class CollagesActivity extends AdBaseActivity
{

    public final Handler a = new Handler();
    private e b;
    private a c;
    private String d;
    private d e;

    public CollagesActivity()
    {
        b = null;
    }

    protected void checkForInviteDialogs(Boolean boolean1)
    {
        showEnjoyDialog = i.a(this, boolean1);
    }

    public void executeInviteNotificaionAction()
    {
        String s;
        if (getIntent() != null && getIntent().hasExtra("from"))
        {
            s = getIntent().getStringExtra("from");
        } else
        {
            s = "";
        }
        if (s == null || !"editor".equals(s))
        {
            i.a(this);
        }
    }

    protected ViewGroup getAdLayout()
    {
        return (RelativeLayout)findViewById(0x7f100128);
    }

    protected void hideAdWithAnimation()
    {
        i.a(this, getAdLayout(), true);
    }

    protected boolean initAd()
    {
        boolean flag1 = super.initAd();
        boolean flag = Inventory.isEditorAdsEnabled();
        View view = findViewById(0x7f100128);
        if (!flag)
        {
            i.a(this, view, true);
        } else
        if (!flag1)
        {
            i.a(this, view, false);
        } else
        {
            view.setVisibility(0);
            if (c.c("PicsartMainRunCount") < 6 && c.c("PicsartMainRunCount") > 2)
            {
                Button button = (Button)findViewById(0x7f1006c8);
                if (!isFinishing())
                {
                    a.postDelayed(new Runnable(button) {

                        final Button a;
                        final CollagesActivity b;

                        public final void run()
                        {
                            if (a != null)
                            {
                                a.setVisibility(0);
                                a.startAnimation(AnimationUtils.loadAnimation(b, 0x7f04000b));
                                b.a.postDelayed(new Runnable(this) {

                                    private _cls1 a;

                                    public final void run()
                                    {
                                        a.a.startAnimation(AnimationUtils.loadAnimation(a.b, 0x7f04000a));
                                        a.a.setVisibility(8);
                                    }

            
            {
                a = _pcls1;
                super();
            }
                                }, 7000L);
                            }
                        }

            
            {
                b = CollagesActivity.this;
                a = button;
                super();
            }
                    }, 3000L);
                }
                if (button != null)
                {
                    button.setOnClickListener(new android.view.View.OnClickListener() {

                        private CollagesActivity a;

                        public final void onClick(View view1)
                        {
                            view1 = new Intent(a, com/picsart/shop/ShopItemActivity);
                            view1.putExtra("selectedShopItemId", "ad_remover");
                            a.startActivityForResult(view1, 114);
                        }

            
            {
                a = CollagesActivity.this;
                super();
            }
                    });
                }
                c.a("PicsartMainRunCount");
            }
        }
        if (!flag)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        checkForInviteDialogs(Boolean.valueOf(flag));
        return flag1;
    }

    protected void onActivityResult(int j, int k, Intent intent)
    {
        super.onActivityResult(j, k, intent);
        if (k != -1) goto _L2; else goto _L1
_L1:
        j;
        JVM INSTR lookupswitch 5: default 64
    //                   49: 71
    //                   1124: 65
    //                   1230: 71
    //                   1231: 71
    //                   1234: 84;
           goto _L2 _L3 _L4 _L3 _L3 _L5
_L2:
        return;
_L4:
        initAd();
        return;
_L3:
        runOnUiThread(new Runnable() {

            private CollagesActivity a;

            public final void run()
            {
                Toast.makeText(a, a.getString(0x7f08027c), 0).show();
            }

            
            {
                a = CollagesActivity.this;
                super();
            }
        });
        return;
_L5:
        runOnUiThread(new Runnable() {

            private CollagesActivity a;

            public final void run()
            {
                Toast.makeText(a, a.getString(0x7f0805af), 0).show();
            }

            
            {
                a = CollagesActivity.this;
                super();
            }
        });
        return;
    }

    public void onBackPressed()
    {
        if (b != null)
        {
            b.a();
        }
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
        if (b != null)
        {
            b.onConfigurationChanged(configuration);
        }
        initAd();
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f03006a);
        e = new d(this, (byte)0);
        registerReceiver(e, new IntentFilter("update.adds.enabled.action"));
        if (bundle == null)
        {
            if (getIntent() != null)
            {
                d = getIntent().getStringExtra("session_id");
            }
        } else
        {
            d = bundle.getString("session_id");
        }
        c = new a(this);
        bundle = getFragmentManager();
        FragmentManager.enableDebugLogging(true);
        b = (e)bundle.findFragmentByTag("collagesFragment");
        bundle = bundle.beginTransaction();
        if (b != null) goto _L2; else goto _L1
_L1:
        b = new e();
        b.setRetainInstance(true);
        bundle.add(0x7f10028f, b, "collagesFragment");
        bundle.commitAllowingStateLoss();
_L4:
        b.b = d;
        i.b(this);
        return;
_L2:
        if (!b.isVisible())
        {
            bundle.show(b);
            bundle.commitAllowingStateLoss();
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected void onDestroy()
    {
        if (e != null)
        {
            unregisterReceiver(e);
        }
        super.onDestroy();
    }

    public boolean onKeyDown(int j, KeyEvent keyevent)
    {
        if (j == 4)
        {
            i.a(this).edit().putBoolean("is_editor_active", false).apply();
            if (b != null)
            {
                b.a();
            }
            return true;
        } else
        {
            return super.onKeyDown(j, keyevent);
        }
    }

    protected void onResume()
    {
        super.onResume();
        i.a(this).edit().putBoolean("is_editor_active", true).apply();
    }

    public void onSaveInstanceState(Bundle bundle, PersistableBundle persistablebundle)
    {
        super.onSaveInstanceState(bundle, persistablebundle);
        bundle.putString("session_id", d);
    }

    protected void onStart()
    {
        super.onStart();
        initAd();
    }
}
