// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.activity;

import android.os.Bundle;
import android.view.ViewGroup;
import com.picsart.studio.utils.c;
import com.socialin.android.ads.SocialinAdManager;
import com.socialin.android.ads.SocialinAdView;
import com.socialin.android.ads.a;
import com.socialin.android.ads.b;
import com.socialin.android.ads.d;
import com.socialin.android.apiv3.util.Inventory;

// Referenced classes of package com.socialin.android.activity:
//            BaseActivity

public abstract class AdBaseActivity extends BaseActivity
{

    public boolean showEnjoyDialog;
    protected SocialinAdView socialinAdView;

    public AdBaseActivity()
    {
        showEnjoyDialog = false;
    }

    public void checkForInviteDialogs(Boolean boolean1)
    {
    }

    public void executeInviteNotificaionAction()
    {
    }

    public abstract ViewGroup getAdLayout();

    protected a getAdLoader()
    {
        return b.a(c.d(getApplicationContext()));
    }

    public void hideAdWithAnimation()
    {
        ViewGroup viewgroup = getAdLayout();
        if (viewgroup != null)
        {
            viewgroup.setVisibility(8);
        }
    }

    public boolean initAd()
    {
        boolean flag2 = false;
        ViewGroup viewgroup = getAdLayout();
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
                hideAdWithAnimation();
                flag1 = flag2;
            } else
            {
                viewgroup.setVisibility(0);
                SocialinAdManager.a(viewgroup, this, getAdLoader(), new d() {

                    private AdBaseActivity a;

                    public final void a(SocialinAdView socialinadview)
                    {
                        a.socialinAdView = socialinadview;
                    }

            
            {
                a = AdBaseActivity.this;
                super();
            }
                });
                flag1 = true;
            }
        }
        checkForInviteDialogs(Boolean.valueOf(flag));
        return flag1;
    }

    public boolean isShowEnjoyDialog()
    {
        return showEnjoyDialog;
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        showEnjoyDialog = false;
    }

    public void onDestroy()
    {
        SocialinAdManager.a(socialinAdView);
        super.onDestroy();
    }

    public void onPause()
    {
        super.onPause();
    }

    public void onResume()
    {
        super.onResume();
        ViewGroup viewgroup = getAdLayout();
        if (viewgroup != null)
        {
            if (!Inventory.isAdsEnabled())
            {
                viewgroup.setVisibility(8);
            }
            checkForInviteDialogs(null);
        }
    }
}
