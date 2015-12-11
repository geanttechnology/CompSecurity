// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import com.poshmark.analytics.Analytics;
import com.poshmark.application.PMApplicationSession;
import com.poshmark.config.NewRelicWrapper;
import com.poshmark.notifications.PMNotificationManager;
import com.poshmark.ui.PMActivity;
import com.poshmark.utils.NewRelicCustomInteractions;

// Referenced classes of package com.poshmark.ui.fragments:
//            MappPageFragment

public class NewsPageFragment extends MappPageFragment
{

    public NewsPageFragment()
    {
    }

    public String getTrackingLabel()
    {
        return "nw";
    }

    public void launchWebView(String s, String s1)
    {
        Bundle bundle = new Bundle();
        bundle.putString("URL", s);
        bundle.putString("ANALYTICS_PAGE_NAME", s1);
        ((PMActivity)getActivity()).launchFragmentInNewActivity(bundle, com/poshmark/ui/fragments/MappPageFragment, null);
    }

    protected void loadComplete(WebView webview)
    {
        PMNotificationManager.fireNotification("com.poshmark.intents.CLEAR_NEWS_BADGE");
        hideProgressDialog();
    }

    public void onActivityCreated(Bundle bundle)
    {
        Object obj = (new StringBuilder()).append("/mapp/users/").append(PMApplicationSession.GetPMSession().getUserId()).append("/notifications?pageName=NEWS_ROOT").toString();
        url = (new StringBuilder()).append("https://www.poshmark.com").append(((String) (obj))).toString();
        obj = Uri.parse(url);
        authority = ((Uri) (obj)).getEncodedAuthority();
        path = ((Uri) (obj)).getEncodedPath();
        lastPathSegment = ((Uri) (obj)).getLastPathSegment();
        pageName = "NEWS_ROOT";
        NewRelicWrapper.startCustomInteraction(NewRelicCustomInteractions.NEWS_FEED_REFRESH);
        super.onActivityCreated(bundle);
    }

    public void setViewNameForAnalytics()
    {
        viewNameForAnalytics = "news_feed_screen";
    }

    public void setupActionBar()
    {
        super.setupActionBar();
        if (bShowRefreshButton)
        {
            setTitle(0x7f0601cb);
            showFindPeopleButton(false);
            showRefreshButton(true);
            setRefreshActionButtonListener(new android.view.View.OnClickListener() {

                final NewsPageFragment this$0;

                public void onClick(View view)
                {
                    NewRelicWrapper.startCustomInteraction(NewRelicCustomInteractions.NEWS_FEED_REFRESH);
                    webView.reload();
                    PMNotificationManager.fireNotification("com.poshmark.intents.CLEAR_NEWS_BADGE");
                    Analytics.getInstance().trackEvent(viewNameForAnalytics, "user", "refresh_news_clicked", null);
                }

            
            {
                this$0 = NewsPageFragment.this;
                super();
            }
            });
        }
    }
}
