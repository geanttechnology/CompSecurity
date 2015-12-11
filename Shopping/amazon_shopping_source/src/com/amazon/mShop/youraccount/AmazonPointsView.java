// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.youraccount;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.LinkButton;
import com.amazon.mShop.TaskCallbackFactory;
import com.amazon.mShop.TitleProvider;
import com.amazon.mShop.control.account.AmazonPointsSummaryController;
import com.amazon.mShop.control.account.AmazonPointsSummarySubscriber;
import com.amazon.mShop.model.auth.User;
import com.amazon.mShop.util.AmazonErrorUtils;
import com.amazon.rio.j2me.client.services.ServiceCall;
import java.util.List;

// Referenced classes of package com.amazon.mShop.youraccount:
//            AmazonPointsSummaryView

public class AmazonPointsView extends ScrollView
    implements TitleProvider, AmazonPointsSummarySubscriber
{

    private final AmazonActivity activity;
    private final TaskCallbackFactory callBackFactory;
    private final AmazonPointsSummaryController controller = new AmazonPointsSummaryController(this);

    public AmazonPointsView(AmazonActivity amazonactivity)
    {
        super(amazonactivity);
        activity = amazonactivity;
        callBackFactory = new TaskCallbackFactory(amazonactivity);
        LayoutInflater.from(getContext()).inflate(com.amazon.mShop.android.lib.R.layout.amazonpoints, this, true);
        initSummary();
        initAbout();
    }

    private void doGetPointsSummary()
    {
        controller.doGetPointsSummary(callBackFactory.getPopViewTaskCallback(controller, activity, com.amazon.mShop.android.lib.R.string.ya_my_point_summary));
    }

    private void initAbout()
    {
        LinearLayout linearlayout = (LinearLayout)findViewById(com.amazon.mShop.android.lib.R.id.amazonpoints_about);
        linearlayout.setVisibility(0);
        String as[] = getResources().getStringArray(com.amazon.mShop.android.lib.R.array.ya_points_help_map);
        for (int i = 0; i < as.length; i += 2)
        {
            LinkButton linkbutton = (LinkButton)(LinkButton)LayoutInflater.from(getContext()).inflate(com.amazon.mShop.android.lib.R.layout.amazonpoints_link_button, null, false);
            linkbutton.initLinkButton(as[i], as[i + 1]);
            linearlayout.addView(linkbutton);
            LayoutInflater.from(getContext()).inflate(com.amazon.mShop.android.lib.R.layout.separator, linearlayout, true);
        }

    }

    private void updateSummary(List list)
    {
        AmazonPointsSummaryView amazonpointssummaryview = (AmazonPointsSummaryView)findViewById(com.amazon.mShop.android.lib.R.id.amazonpoints_summary_table);
        if (list.size() > 0)
        {
            amazonpointssummaryview.setVisibility(0);
            amazonpointssummaryview.update(list);
            return;
        } else
        {
            amazonpointssummaryview.setVisibility(8);
            return;
        }
    }

    public volatile CharSequence getTitle()
    {
        return getTitle();
    }

    public String getTitle()
    {
        return getResources().getString(com.amazon.mShop.android.lib.R.string.ya_points_title);
    }

    public void initSummary()
    {
        Button button = (Button)findViewById(com.amazon.mShop.android.lib.R.id.amazonpoints_sign_in_to_check_points);
        ((AmazonPointsSummaryView)findViewById(com.amazon.mShop.android.lib.R.id.amazonpoints_summary_table)).setVisibility(8);
        if (User.isLoggedIn())
        {
            button.setVisibility(8);
            doGetPointsSummary();
            return;
        } else
        {
            button.setVisibility(0);
            button.setOnClickListener(new android.view.View.OnClickListener() {

                final AmazonPointsView this$0;

                public void onClick(View view)
                {
                    activity.authenticateUser(null, null);
                }

            
            {
                this$0 = AmazonPointsView.this;
                super();
            }
            });
            return;
        }
    }

    public void onError(Exception exception, ServiceCall servicecall)
    {
        servicecall = new com.amazon.mShop.error.AmazonErrorBox.AmazonErrorBoxActionListener() {

            final AmazonPointsView this$0;

            public void onActionButtonClick(int i)
            {
                doGetPointsSummary();
            }

            
            {
                this$0 = AmazonPointsView.this;
                super();
            }
        };
        AmazonErrorUtils.reportMShopServerError(activity, servicecall, this, exception);
    }

    public void onReceiveAmazonPointsSummary(List list)
    {
        if (list != null)
        {
            updateSummary(list);
        }
    }

    public void onRequiresUserLogin(com.amazon.mShop.model.auth.UserSubscriber.Callback callback)
    {
        com.amazon.mShop.model.auth.UserSubscriber.Callback callback1 = new com.amazon.mShop.model.auth.UserSubscriber.Callback() {

            final AmazonPointsView this$0;

            public void userCancelledSignIn()
            {
            }

            public void userSuccessfullySignedIn()
            {
            }

            
            {
                this$0 = AmazonPointsView.this;
                super();
            }
        };
        activity.authenticateUser(callback, callback1);
    }


}
