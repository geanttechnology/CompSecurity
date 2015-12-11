// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.customviews;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import com.poshmark.analytics.Analytics;
import com.poshmark.application.PMApplication;
import com.poshmark.controllers.GlobalDbController;
import com.poshmark.http.api.PMApi;
import com.poshmark.http.api.PMApiRequest;
import com.poshmark.http.api.PMApiResponse;
import com.poshmark.http.api.PMApiResponseHandler;
import com.poshmark.notifications.PMNotificationManager;

public class BrandFollowButtonLayout extends FrameLayout
{

    String brandName;
    Button followButton;
    int followingButtonColor;
    int followingButtonDrawable;
    boolean isFollowing;
    boolean isSetupComplete;
    ProgressBar progressSpinner;
    String screenNameForAnalytics;

    public BrandFollowButtonLayout(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        brandName = null;
        isFollowing = false;
        isSetupComplete = false;
        followingButtonColor = 0x7f090040;
        followingButtonDrawable = 0x7f02000c;
        screenNameForAnalytics = null;
    }

    private void fireBrandStatusChangedNotification()
    {
        Bundle bundle = new Bundle();
        bundle.putString("BRAND", brandName);
        PMNotificationManager.fireNotification("com.poshmark.intents.BRAND_FOLLOW_STATUS_CHANGED", bundle);
    }

    private void setButtonVisibility(boolean flag)
    {
        if (flag)
        {
            followButton.setVisibility(0);
            progressSpinner.setVisibility(4);
            return;
        } else
        {
            followButton.setVisibility(4);
            progressSpinner.setVisibility(0);
            return;
        }
    }

    private void setFollowButton()
    {
        followButton.setBackgroundDrawable(PMApplication.getContext().getResources().getDrawable(0x7f020007));
        followButton.setTextColor(PMApplication.getContext().getResources().getColor(0x7f090040));
        followButton.setText(PMApplication.getContext().getResources().getString(0x7f06012f));
    }

    private void setFollowingButton()
    {
        followButton.setBackgroundDrawable(PMApplication.getContext().getResources().getDrawable(followingButtonDrawable));
        followButton.setTextColor(PMApplication.getContext().getResources().getColor(followingButtonColor));
        followButton.setText(PMApplication.getContext().getResources().getString(0x7f060134));
    }

    private void setup()
    {
        if (!isSetupComplete)
        {
            isSetupComplete = true;
            followButton = (Button)findViewById(0x7f0c0060);
            progressSpinner = (ProgressBar)findViewById(0x7f0c0061);
            followButton.setOnClickListener(new android.view.View.OnClickListener() {

                final BrandFollowButtonLayout this$0;

                public void onClick(View view)
                {
                    setButtonVisibility(false);
                    if (!isFollowing)
                    {
                        if (screenNameForAnalytics != null)
                        {
                            Analytics.getInstance().trackEvent(screenNameForAnalytics, "brand", "brand_followed", null);
                        }
                        PMApi.followBrand(brandName, new PMApiResponseHandler() {

                            final _cls1 this$1;

                            public void handleResponse(PMApiResponse pmapiresponse)
                            {
                                if (!pmapiresponse.hasError())
                                {
                                    String s = brandName.replace("/", "%2F");
                                    if (pmapiresponse.apiRequest.url.contains(Uri.encode(s)))
                                    {
                                        isFollowing = true;
                                        setFollowingButton();
                                        GlobalDbController.getGlobalDbController().followBrand(brandName);
                                        fireBrandStatusChangedNotification();
                                    }
                                } else
                                {
                                    setFollowButton();
                                }
                                setButtonVisibility(true);
                            }

            
            {
                this$1 = _cls1.this;
                super();
            }
                        });
                        return;
                    }
                    if (screenNameForAnalytics != null)
                    {
                        Analytics.getInstance().trackEvent(screenNameForAnalytics, "brand", "brand_unfollowed", null);
                    }
                    PMApi.unFollowBrand(brandName, new PMApiResponseHandler() {

                        final _cls1 this$1;

                        public void handleResponse(PMApiResponse pmapiresponse)
                        {
                            if (!pmapiresponse.hasError())
                            {
                                String s = brandName.replace("/", "%2F");
                                if (pmapiresponse.apiRequest.url.contains(Uri.encode(s)))
                                {
                                    isFollowing = false;
                                    setFollowButton();
                                    GlobalDbController.getGlobalDbController().unFollowBrand(brandName);
                                    fireBrandStatusChangedNotification();
                                }
                            } else
                            {
                                setFollowingButton();
                            }
                            setButtonVisibility(true);
                        }

            
            {
                this$1 = _cls1.this;
                super();
            }
                    });
                }

            
            {
                this$0 = BrandFollowButtonLayout.this;
                super();
            }
            });
        }
    }

    protected void onAttachedToWindow()
    {
    }

    protected void onDetachedFromWindow()
    {
    }

    public void setBrand(String s)
    {
        setup();
        brandName = s;
        if (GlobalDbController.getGlobalDbController().isFollowingBrand(brandName))
        {
            isFollowing = true;
            setFollowingButton();
            return;
        } else
        {
            isFollowing = false;
            setFollowButton();
            return;
        }
    }

    public void setFollowingButtonColor(int i, int j)
    {
        followingButtonDrawable = i;
        followingButtonColor = j;
    }

    public void setParentScreenNameForAnalytics(String s)
    {
        screenNameForAnalytics = s;
    }




}
