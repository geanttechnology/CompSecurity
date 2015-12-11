// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.recommendations;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.ViewAnimator;
import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.control.recommendations.RecommendationsController;
import com.amazon.mShop.model.auth.User;
import com.amazon.mShop.net.NetInfo;
import com.amazon.mShop.platform.AppLocale;
import com.amazon.mShop.sso.SSOUtil;
import com.amazon.mShop.util.ActivityUtils;
import com.amazon.mShop.util.Maps;
import com.amazon.mShop.util.UIUtils;

// Referenced classes of package com.amazon.mShop.recommendations:
//            RecommendationsResultsView, RecommendationsExplanationView

public class RecommendationsActivity extends AmazonActivity
{

    public RecommendationsActivity()
    {
    }

    public String constructUserUniqueInfo()
    {
        String s = "";
        if (User.getUser() != null)
        {
            s = (new StringBuilder()).append(User.getUser().getFullName()).append("_").append(AppLocale.getInstance().getCurrentLocaleName()).toString();
        }
        return s;
    }

    public boolean dispatchKeyEvent(KeyEvent keyevent)
    {
        boolean flag;
        if (menuDispatchedKeyEvent(keyevent))
        {
            flag = true;
        } else
        if (getViewAnimator() != null && 4 == keyevent.getKeyCode() && keyevent.getAction() == 0 && getViewAnimator().getChildCount() - 2 >= 0)
        {
            android.view.View view = getViewAnimator().getChildAt(getViewAnimator().getChildCount() - 2);
            boolean flag1 = super.dispatchKeyEvent(keyevent);
            flag = flag1;
            if (view instanceof RecommendationsResultsView)
            {
                flag = flag1;
                if (needShowErrorInfo())
                {
                    ((RecommendationsResultsView)view).showErrorDialog();
                    return flag1;
                }
            }
        } else
        {
            return super.dispatchKeyEvent(keyevent);
        }
        return flag;
    }

    public boolean needShowErrorInfo()
    {
        String s = constructUserUniqueInfo();
        return RecommendationsController.getInstance().isLastRatingRequestError(s);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setTitle(com.amazon.mShop.android.lib.R.string.homeitems);
        setStopBehavior(2);
        bundle = getIntent().getStringExtra("BROWSE_NODE");
        String s = getIntent().getStringExtra("CATEGORY_DISPLAY_NAME");
        if (ActivityUtils.isHTMLRecommendationsEnabled())
        {
            ActivityUtils.startRecommendationsActivity(this, Maps.of("BROWSE_NODE", bundle, "CATEGORY_DISPLAY_NAME", s));
            finish();
        }
    }

    public void onPause()
    {
        super.onPause();
        String s = constructUserUniqueInfo();
        RecommendationsController.getInstance().sendRecsRatingsForUser(s);
    }

    public void onResume()
    {
        super.onResume();
        if (needShowErrorInfo())
        {
            android.view.View view = getCurrentView();
            if (view instanceof RecommendationsResultsView)
            {
                ((RecommendationsResultsView)view).showErrorDialog();
            }
        }
    }

    protected void onStart()
    {
        super.onStart();
        String s = getIntent().getStringExtra("BROWSE_NODE");
        String s1 = getIntent().getStringExtra("CATEGORY_DISPLAY_NAME");
        if (User.isLoggedIn())
        {
            swapView(new RecommendationsResultsView(this, s, s1));
        } else
        {
            if (SSOUtil.isSSOSupported(this) && SSOUtil.hasAmazonAccount())
            {
                swapView(new RecommendationsResultsView(this, s, s1));
                return;
            }
            swapView(new RecommendationsExplanationView(this));
            if (!NetInfo.hasNetworkConnection())
            {
                UIUtils.info(this, com.amazon.mShop.android.lib.R.string.error_network_no_connection_message);
                return;
            }
        }
    }
}
