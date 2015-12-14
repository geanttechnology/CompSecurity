// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.facebook;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import com.facebook.AccessToken;
import com.picsart.studio.utils.ItemControl;
import com.socialin.android.activity.BaseActivity;
import com.socialin.android.adapter.a;
import myobfuscated.cr.d;
import myobfuscated.cr.f;
import myobfuscated.cr.h;
import myobfuscated.f.m;

// Referenced classes of package com.socialin.android.facebook:
//            FacebookWallPostActivity, n, FacebookPageObject, k, 
//            h

public class FacebookPageListActivity extends BaseActivity
    implements a
{

    n a;
    private k b;
    private f c;

    public FacebookPageListActivity()
    {
    }

    static void a(FacebookPageListActivity facebookpagelistactivity)
    {
        facebookpagelistactivity.c.a(m.a(facebookpagelistactivity, 0x7f080276));
    }

    public final transient void a(int i, ItemControl itemcontrol, Object aobj[])
    {
        itemcontrol = new Intent(this, com/socialin/android/facebook/FacebookWallPostActivity);
        itemcontrol.putExtras(getIntent().getExtras());
        aobj = ((FacebookPageObject)a.getItem(i)).getId();
        String s = ((FacebookPageObject)a.getItem(i)).getTitle();
        itemcontrol.putExtra("fbPageId", ((String) (aobj)));
        itemcontrol.putExtra("fbPageName", s);
        itemcontrol.putExtra("access_token", ((FacebookPageObject)a.getItem(i)).getAccessToken());
        startActivity(itemcontrol);
        finish();
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f0300f8);
        b = new k();
        bundle = new com.socialin.android.facebook.h();
        bundle.a = "me/accounts";
        bundle.b = AccessToken.getCurrentAccessToken();
        b.a = com/socialin/android/facebook/FacebookPageObject;
        b.setRequestParams(bundle);
        a = new n(this);
        c = f.a(a, myobfuscated.cr.a.a(b, a));
        bundle = c;
        h h1 = new h(getResources());
        h1.e = getResources().getColor(0x7f0f000b);
        h1.j = (int)getResources().getDimension(0x7f0b011b);
        h1.d = 2;
        h1.k = false;
        h1.b = 1;
        bundle.a(h1.a(new com.socialin.android.adapter.RecyclerViewAdapter.ViewStyle[] {
            com.socialin.android.adapter.RecyclerViewAdapter.ViewStyle.GRID
        }).b());
        a.setOnItemClickListener(this);
        c.k = new d() {

            private FacebookPageListActivity a;

            public final void a()
            {
                if (a.a != null && a.a.isEmpty())
                {
                    com.socialin.android.facebook.FacebookPageListActivity.a(a);
                }
            }

            public final void b()
            {
                com.socialin.android.facebook.FacebookPageListActivity.a(a);
            }

            
            {
                a = FacebookPageListActivity.this;
                super();
            }
        };
        bundle = getFragmentManager().beginTransaction();
        bundle.add(0x7f100500, c);
        bundle.commitAllowingStateLoss();
    }

    protected void onResume()
    {
        super.onResume();
        if (c != null && a != null && a.isEmpty())
        {
            c.a(false, true, true);
        }
    }
}
