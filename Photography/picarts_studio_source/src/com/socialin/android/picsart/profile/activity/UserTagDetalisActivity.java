// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.picsart.profile.activity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import com.socialin.android.apiv3.model.ViewerUser;
import com.socialin.android.d;
import com.socialin.android.picsart.profile.fragment.bx;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.socialin.android.picsart.profile.activity:
//            TagPhotosActivity

public class UserTagDetalisActivity extends TagPhotosActivity
{

    private ViewerUser c;
    private List d;
    private boolean e;

    public UserTagDetalisActivity()
    {
        c = null;
        e = false;
    }

    protected void onCreate(Bundle bundle)
    {
        int i;
        super.onCreate(bundle);
        setContentView(0x7f030230);
        findViewById(0x7f10068c).setVisibility(8);
        Object obj;
        StringBuilder stringbuilder;
        StringBuilder stringbuilder1;
        if (getIntent().getExtras() != null)
        {
            bundle = getIntent().getExtras();
        }
        a = bundle.getString("key.tag");
        c = (ViewerUser)bundle.getParcelable("key.user");
        d = bundle.getParcelableArrayList("key.items");
        i = bundle.getInt("key.items.count");
        bundle = bundle.getString("key.location");
        if (!TextUtils.isEmpty(bundle) && !"null".equals(bundle))
        {
            if (TextUtils.isEmpty(a))
            {
                a = bundle;
            }
            e = true;
        }
_L1:
        boolean flag;
        if (!e)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        b = flag;
        obj = getSupportActionBar();
        if (obj != null)
        {
            ((ActionBar) (obj)).setIcon(getResources().getDrawable(0x7f020417));
            ((ActionBar) (obj)).setDisplayHomeAsUpEnabled(true);
            bundle = null;
            if (c != null)
            {
                bundle = c.username;
            }
            if (bundle == null)
            {
                bundle = "";
            }
            if (!TextUtils.isEmpty(bundle) && !TextUtils.isEmpty(a))
            {
                bundle = (new StringBuilder()).append(bundle).append(" - ").toString();
            } else
            {
                bundle = (new StringBuilder()).append(bundle).append("'s ").append(getString(0x7f0805c1).toLowerCase()).toString();
            }
            stringbuilder = (new StringBuilder()).append(bundle);
            if (a != null)
            {
                stringbuilder1 = new StringBuilder();
                if (e)
                {
                    bundle = "";
                } else
                {
                    bundle = Character.valueOf('#');
                }
                bundle = stringbuilder1.append(bundle).append(a).toString();
            } else
            {
                bundle = "";
            }
            ((ActionBar) (obj)).setTitle(stringbuilder.append(bundle).toString());
        }
        bundle = getFragmentManager().findFragmentByTag("UserTagDetailsFragment");
        if (bundle == null || !bundle.isAdded())
        {
            bundle = new Bundle();
            bundle.putBoolean("key.is.location", e);
            bundle.putParcelableArrayList("key.items", (ArrayList)d);
            if (a != null)
            {
                bundle.putString("key.tag", a);
            }
            if (c != null)
            {
                bundle.putParcelable("key.user", c);
            }
            bundle.putInt("key.items.count", i);
            obj = new bx();
            ((bx) (obj)).setArguments(bundle);
            ((bx) (obj)).setRetainInstance(true);
            getFragmentManager().beginTransaction().add(0x7f10013a, ((Fragment) (obj)), "UserTagDetailsFragment").commit();
            return;
        } else
        {
            getFragmentManager().beginTransaction().show(bundle).commit();
            return;
        }
        bundle;
        i = 0;
_L2:
        com.socialin.android.d.a("UserTagDetalisActivity", bundle);
          goto _L1
        bundle;
          goto _L2
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        if (menuitem.getItemId() == 0x102002c)
        {
            finish();
        }
        return super.onOptionsItemSelected(menuitem);
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        Bundle bundle1 = bundle;
        if (bundle == null)
        {
            bundle1 = new Bundle();
        }
        bundle1.putParcelableArrayList("key.items", (ArrayList)d);
        if (c != null)
        {
            bundle1.putParcelable("key.user", c);
        }
        if (a != null)
        {
            bundle1.putString("key.tag", a);
        }
        super.onSaveInstanceState(bundle1);
    }
}
