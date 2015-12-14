// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.picsart.profile.activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import com.melnykov.fab.FloatingActionButton;
import com.picsart.studio.utils.a;
import com.socialin.android.activity.BaseActivity;
import com.socialin.android.apiv3.model.Adress;
import com.socialin.android.d;
import com.socialin.android.picsart.profile.fragment.aw;
import com.socialin.android.picsart.profile.util.GalleryUtils;

// Referenced classes of package com.socialin.android.picsart.profile.activity:
//            BottomSheetActivity

public class PhotosByLocationActivity extends BaseActivity
    implements a
{

    private Adress a;
    private aw b;
    private FloatingActionButton c;

    public PhotosByLocationActivity()
    {
    }

    public final void a()
    {
        c.a(true, true, false);
    }

    public final void b()
    {
        c.a(false, true, false);
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        bundle = getSupportActionBar();
        if (bundle != null)
        {
            bundle.setIcon(0x7f0203a8);
            bundle.setDisplayHomeAsUpEnabled(true);
        }
        setContentView(0x7f030180);
        c = (FloatingActionButton)findViewById(0x7f1006cd);
        c.setOnClickListener(new android.view.View.OnClickListener() {

            private PhotosByLocationActivity a;

            public final void onClick(View view)
            {
                view = new Intent(a, com/socialin/android/picsart/profile/activity/BottomSheetActivity);
                a.startActivity(view);
            }

            
            {
                a = PhotosByLocationActivity.this;
                super();
            }
        });
        bundle = getIntent();
        if (bundle.hasExtra("location"))
        {
            try
            {
                a = (Adress)bundle.getExtras().getParcelable("location");
            }
            // Misplaced declaration of an exception variable
            catch (Bundle bundle)
            {
                d.a("PhotosByLocationActivity", bundle);
                a = null;
            }
        }
        if (a != null)
        {
            bundle = GalleryUtils.a(a);
        } else
        {
            bundle = null;
        }
        if (!TextUtils.isEmpty(bundle))
        {
            getSupportActionBar().setTitle(bundle);
        }
        bundle = getFragmentManager().beginTransaction();
        try
        {
            b = (aw)getFragmentManager().findFragmentByTag("PhotosByLocationFragment");
        }
        catch (Exception exception)
        {
            d.a("PhotosByLocationActivity", exception);
            b = null;
        }
        if (b == null)
        {
            Bundle bundle1 = new Bundle();
            bundle1.putParcelable("location", a);
            b = new aw();
            b.setArguments(bundle1);
            bundle.add(0x7f100752, b, "PhotosByLocationFragment");
        } else
        {
            bundle.show(b);
        }
        bundle.commit();
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        if (menuitem.getItemId() == 0x102002c)
        {
            finish();
        }
        return true;
    }
}
