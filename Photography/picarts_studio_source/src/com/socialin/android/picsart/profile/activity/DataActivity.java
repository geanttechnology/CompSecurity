// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.picsart.profile.activity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.MenuItem;
import android.view.View;
import com.google.android.gms.common.api.GoogleApiClient;
import com.melnykov.fab.FloatingActionButton;
import com.picsart.studio.utils.a;
import com.socialin.android.activity.BaseActivity;
import com.socialin.android.picsart.profile.fragment.ax;
import com.socialin.android.picsart.profile.fragment.bi;
import com.socialin.android.picsart.profile.fragment.bz;
import myobfuscated.f.m;

// Referenced classes of package com.socialin.android.picsart.profile.activity:
//            BottomSheetActivity

public class DataActivity extends BaseActivity
    implements a
{

    private String a;
    private FloatingActionButton b;
    private GoogleApiClient c;

    public DataActivity()
    {
        a = "photos_fragment";
    }

    public final void a()
    {
        b.a(true, true, false);
    }

    public final void b()
    {
        b.a(false, true, false);
    }

    protected void onCreate(Bundle bundle)
    {
        FragmentTransaction fragmenttransaction;
        Object obj;
        super.onCreate(bundle);
        setContentView(0x7f030180);
        b = (FloatingActionButton)findViewById(0x7f1006cd);
        b.setOnClickListener(new android.view.View.OnClickListener() {

            private DataActivity a;

            public final void onClick(View view)
            {
                view = new Intent(a, com/socialin/android/picsart/profile/activity/BottomSheetActivity);
                a.startActivity(view);
            }

            
            {
                a = DataActivity.this;
                super();
            }
        });
        bundle = getSupportActionBar();
        if (bundle != null)
        {
            bundle.setDisplayHomeAsUpEnabled(true);
            bundle.setDisplayShowHomeEnabled(true);
        }
        if (getIntent() != null && getIntent().hasExtra("data_type"))
        {
            a = getIntent().getStringExtra("data_type");
        }
        bundle = a;
        obj = getFragmentManager();
        fragmenttransaction = ((FragmentManager) (obj)).beginTransaction();
        obj = ((FragmentManager) (obj)).findFragmentByTag(bundle);
        if (obj == null || !((Fragment) (obj)).isAdded()) goto _L2; else goto _L1
_L1:
        fragmenttransaction.show(((Fragment) (obj)));
_L4:
        fragmenttransaction.commit();
        c = m.a(this);
        return;
_L2:
        if ("photos_fragment".equals(bundle))
        {
            fragmenttransaction.add(0x7f100752, new ax(), bundle);
        } else
        if ("tags_fragment".equals(bundle))
        {
            fragmenttransaction.add(0x7f100752, new bi(), bundle);
        } else
        if ("users_fragment".equals(bundle))
        {
            fragmenttransaction.add(0x7f100752, new bz(), bundle);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        if (menuitem.getItemId() == 0x102002c)
        {
            finish();
        }
        return super.onOptionsItemSelected(menuitem);
    }

    protected void onStart()
    {
        String s;
        byte byte0;
        super.onStart();
        c.connect();
        s = a;
        byte0 = -1;
        s.hashCode();
        JVM INSTR lookupswitch 3: default 56
    //                   -392786866: 85
    //                   372035239: 113
    //                   1169714102: 99;
           goto _L1 _L2 _L3 _L4
_L1:
        break; /* Loop/switch isn't completed */
_L3:
        break MISSING_BLOCK_LABEL_113;
_L5:
        switch (byte0)
        {
        default:
            return;

        case 0: // '\0'
            m.a(c, "http://schema.org/ViewAction", getString(0x7f0804d0), "android-app://com.picsart.studio/picsart/photos");
            return;

        case 1: // '\001'
            m.a(c, "http://schema.org/ViewAction", getString(0x7f0805f0), "android-app://com.picsart.studio/picsart/tags");
            return;

        case 2: // '\002'
            m.a(c, "http://schema.org/ViewAction", getString(0x7f08065a), "android-app://com.picsart.studio/picsart/users");
            break;
        }
        break MISSING_BLOCK_LABEL_180;
_L2:
        if (s.equals("photos_fragment"))
        {
            byte0 = 0;
        }
          goto _L5
_L4:
        if (s.equals("tags_fragment"))
        {
            byte0 = 1;
        }
          goto _L5
        if (s.equals("users_fragment"))
        {
            byte0 = 2;
        }
          goto _L5
    }

    protected void onStop()
    {
        String s;
        byte byte0;
        super.onStop();
        c.disconnect();
        s = a;
        byte0 = -1;
        s.hashCode();
        JVM INSTR lookupswitch 3: default 56
    //                   -392786866: 85
    //                   372035239: 113
    //                   1169714102: 99;
           goto _L1 _L2 _L3 _L4
_L1:
        break; /* Loop/switch isn't completed */
_L3:
        break MISSING_BLOCK_LABEL_113;
_L5:
        switch (byte0)
        {
        default:
            return;

        case 0: // '\0'
            m.b(c, "http://schema.org/ViewAction", getString(0x7f0804d0), "android-app://com.picsart.studio/picsart/photos");
            return;

        case 1: // '\001'
            m.b(c, "http://schema.org/ViewAction", getString(0x7f0805f0), "android-app://com.picsart.studio/picsart/tags");
            return;

        case 2: // '\002'
            m.b(c, "http://schema.org/ViewAction", getString(0x7f08065a), "android-app://com.picsart.studio/picsart/users");
            break;
        }
        break MISSING_BLOCK_LABEL_180;
_L2:
        if (s.equals("photos_fragment"))
        {
            byte0 = 0;
        }
          goto _L5
_L4:
        if (s.equals("tags_fragment"))
        {
            byte0 = 1;
        }
          goto _L5
        if (s.equals("users_fragment"))
        {
            byte0 = 2;
        }
          goto _L5
    }
}
