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
import com.poshmark.application.PMApplication;
import com.poshmark.http.api.PMApi;
import com.poshmark.http.api.PMApiRequest;
import com.poshmark.http.api.PMApiResponse;
import com.poshmark.http.api.PMApiResponseHandler;
import com.poshmark.notifications.PMNotificationManager;

public class UserFollowButtonLayout extends FrameLayout
{
    public static final class DisplayMode extends Enum
    {

        private static final DisplayMode $VALUES[];
        public static final DisplayMode SINGLE_MODE;

        public static DisplayMode valueOf(String s)
        {
            return (DisplayMode)Enum.valueOf(com/poshmark/ui/customviews/UserFollowButtonLayout$DisplayMode, s);
        }

        public static DisplayMode[] values()
        {
            return (DisplayMode[])$VALUES.clone();
        }

        static 
        {
            SINGLE_MODE = new DisplayMode("SINGLE_MODE", 0);
            $VALUES = (new DisplayMode[] {
                SINGLE_MODE
            });
        }

        private DisplayMode(String s, int i)
        {
            super(s, i);
        }
    }

    public static interface UserFollowButtonListener
    {

        public abstract void onFollowClick();

        public abstract void onFollowingClick();
    }


    DisplayMode displayMode;
    boolean fireAndForgetMode;
    Button followButton;
    private PMApiResponseHandler followCallHandler;
    private PMApiResponseHandler followingCallHandler;
    boolean isFollowing;
    boolean isSetupComplete;
    UserFollowButtonListener listener;
    ProgressBar progressSpinner;
    String userId;

    public UserFollowButtonLayout(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        userId = null;
        isFollowing = false;
        isSetupComplete = false;
        fireAndForgetMode = false;
        listener = null;
        displayMode = DisplayMode.SINGLE_MODE;
        followCallHandler = new PMApiResponseHandler() {

            final UserFollowButtonLayout this$0;

            public void handleResponse(PMApiResponse pmapiresponse)
            {
                if (!pmapiresponse.hasError())
                {
                    if (pmapiresponse.apiRequest.url.contains(Uri.encode(userId)))
                    {
                        setFollowingButton();
                        isFollowing = true;
                        fireUserFollowingStatusChangedNotification();
                        if (listener != null)
                        {
                            listener.onFollowClick();
                        }
                    }
                } else
                {
                    setFollowingButton();
                }
                setButtonVisibility(true);
            }

            
            {
                this$0 = UserFollowButtonLayout.this;
                super();
            }
        };
        followingCallHandler = new PMApiResponseHandler() {

            final UserFollowButtonLayout this$0;

            public void handleResponse(PMApiResponse pmapiresponse)
            {
                if (!pmapiresponse.hasError())
                {
                    if (pmapiresponse.apiRequest.url.contains(Uri.encode(userId)))
                    {
                        setFollowButton();
                        isFollowing = false;
                        fireUserFollowingStatusChangedNotification();
                        if (listener != null)
                        {
                            listener.onFollowingClick();
                        }
                    }
                } else
                {
                    setFollowButton();
                }
                setButtonVisibility(true);
            }

            
            {
                this$0 = UserFollowButtonLayout.this;
                super();
            }
        };
    }

    private void fireUserFollowingStatusChangedNotification()
    {
        Bundle bundle = new Bundle();
        bundle.putString("USER", userId);
        bundle.putBoolean("IS_FOLLOWING", isFollowing);
        PMNotificationManager.fireNotification("com.poshmark.intents.USER_FOLLOW_STATUS_CHANGED", bundle);
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
        followButton.setBackgroundDrawable(PMApplication.getContext().getResources().getDrawable(0x7f020005));
        followButton.setTextColor(PMApplication.getContext().getResources().getColor(0x7f090040));
        followButton.setText(PMApplication.getContext().getResources().getString(0x7f06012f));
    }

    private void setFollowingButton()
    {
        followButton.setBackgroundDrawable(PMApplication.getContext().getResources().getDrawable(0x7f02000c));
        followButton.setTextColor(PMApplication.getContext().getResources().getColor(0x7f090040));
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

                final UserFollowButtonLayout this$0;

                public void onClick(View view)
                {
                    Object obj;
                    Object obj1;
                    obj1 = null;
                    obj = null;
                    if (isFollowing) goto _L2; else goto _L1
_L1:
                    if (fireAndForgetMode) goto _L4; else goto _L3
_L3:
                    view = followCallHandler;
                    setButtonVisibility(false);
_L5:
                    PMApi.followUser(userId, view);
                    return;
_L4:
                    setFollowingButton();
                    view = obj;
                    if (listener != null)
                    {
                        listener.onFollowClick();
                        view = obj;
                    }
                    if (true) goto _L5; else goto _L2
_L2:
                    if (fireAndForgetMode) goto _L7; else goto _L6
_L6:
                    view = followingCallHandler;
                    setButtonVisibility(false);
_L9:
                    PMApi.unFollowUser(userId, view);
                    return;
_L7:
                    setFollowButton();
                    view = obj1;
                    if (listener != null)
                    {
                        listener.onFollowingClick();
                        view = obj1;
                    }
                    if (true) goto _L9; else goto _L8
_L8:
                }

            
            {
                this$0 = UserFollowButtonLayout.this;
                super();
            }
            });
            setButtonVisibility(true);
        }
    }

    protected void onAttachedToWindow()
    {
    }

    protected void onDetachedFromWindow()
    {
    }

    public void setDisplayMode(DisplayMode displaymode)
    {
        displayMode = displaymode;
    }

    public void setListener(UserFollowButtonListener userfollowbuttonlistener)
    {
        listener = userfollowbuttonlistener;
    }

    public void setUser(String s, boolean flag)
    {
        setup();
        userId = s;
        if (flag)
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






}
