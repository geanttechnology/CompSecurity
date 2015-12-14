// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.ViewGroup;
import com.picsart.studio.utils.c;
import com.socialin.android.ads.SocialinAdManager;
import com.socialin.android.ads.SocialinAdView;
import com.socialin.android.ads.b;
import com.socialin.android.ads.d;
import com.socialin.android.apiv3.util.Inventory;
import com.socialin.android.picsart.profile.invite.i;

public abstract class a extends Fragment
{

    protected SocialinAdView a;
    public boolean b;

    public a()
    {
        b = false;
    }

    protected void a(Boolean boolean1)
    {
    }

    protected final boolean a()
    {
        boolean flag2 = false;
        ViewGroup viewgroup = b();
        boolean flag;
        boolean flag1;
        if (!Inventory.isEditorAdsEnabled())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        flag1 = flag2;
        if (viewgroup != null)
        {
            if (!Inventory.isAdsEnabled())
            {
                viewgroup.setVisibility(8);
                flag1 = flag2;
            } else
            if (flag)
            {
                i.a(getActivity(), viewgroup, true);
                flag1 = flag2;
            } else
            {
                viewgroup.setVisibility(0);
                SocialinAdManager.a(viewgroup, getActivity(), com.socialin.android.ads.b.a(com.picsart.studio.utils.c.d(getActivity())), new d() {

                    private a a;

                    public final void a(SocialinAdView socialinadview)
                    {
                        a.a = socialinadview;
                    }

            
            {
                a = a.this;
                super();
            }
                });
                flag1 = true;
            }
        }
        a(Boolean.valueOf(flag));
        return flag1;
    }

    protected abstract ViewGroup b();

    public void c()
    {
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        b = false;
    }

    public void onDestroy()
    {
        getActivity();
        SocialinAdManager.a(a);
        super.onDestroy();
    }

    public void onPause()
    {
        getActivity();
        super.onPause();
    }

    public void onResume()
    {
        super.onResume();
        ViewGroup viewgroup = b();
        if (viewgroup != null && !Inventory.isAdsEnabled())
        {
            viewgroup.setVisibility(8);
        }
        a(null);
        getActivity();
    }

    public void onStart()
    {
        super.onStart();
        a();
    }
}
