// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.recommendations;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.TitleProvider;

// Referenced classes of package com.amazon.mShop.recommendations:
//            RecommendationsResultsView

public class RecommendationsExplanationView extends LinearLayout
    implements TitleProvider, com.amazon.mShop.model.auth.UserSubscriber.Callback
{

    private AmazonActivity mActivity;
    private Button mButton;

    public RecommendationsExplanationView(final AmazonActivity activity)
    {
        super(activity);
        mActivity = activity;
        LayoutInflater.from(activity).inflate(com.amazon.mShop.android.lib.R.layout.recs_explanation, this, true);
        mButton = (Button)findViewById(com.amazon.mShop.android.lib.R.id.recommendations_explanation_button);
        mButton.setOnClickListener(new android.view.View.OnClickListener() {

            final RecommendationsExplanationView this$0;
            final AmazonActivity val$activity;

            public void onClick(View view)
            {
                activity.authenticateUser(RecommendationsExplanationView.this, null);
            }

            
            {
                this$0 = RecommendationsExplanationView.this;
                activity = amazonactivity;
                super();
            }
        });
        ((Button)findViewById(com.amazon.mShop.android.lib.R.id.recommendations_create_new_account)).setOnClickListener(new android.view.View.OnClickListener() {

            final RecommendationsExplanationView this$0;
            final AmazonActivity val$activity;

            public void onClick(View view)
            {
                activity.authenticateUser(RecommendationsExplanationView.this, null, true);
            }

            
            {
                this$0 = RecommendationsExplanationView.this;
                activity = amazonactivity;
                super();
            }
        });
    }

    public volatile CharSequence getTitle()
    {
        return getTitle();
    }

    public String getTitle()
    {
        return getContext().getString(com.amazon.mShop.android.lib.R.string.recommendations_title);
    }

    public void userCancelledSignIn()
    {
    }

    public void userSuccessfullySignedIn()
    {
        mActivity.setRootView(new RecommendationsResultsView(mActivity, null, null));
    }
}
