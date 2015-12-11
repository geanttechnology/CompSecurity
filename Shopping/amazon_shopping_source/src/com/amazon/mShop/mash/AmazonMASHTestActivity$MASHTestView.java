// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.mash;

import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import com.amazon.mShop.TitleProvider;
import com.amazon.mShop.util.ActivityUtils;
import com.amazon.mShop.web.MShopWebActivity;
import com.amazon.mobile.mash.constants.WebConstants;

// Referenced classes of package com.amazon.mShop.mash:
//            AmazonMASHTestActivity

private class _cls1.this._cls1 extends ScrollView
    implements android.view.TestView, TitleProvider
{

    private AmazonMASHTestActivity mAmazonMASHTestActivity;
    final AmazonMASHTestActivity this$0;

    private void startMASHTestActivity(String s)
    {
        Intent intent = ActivityUtils.getStartActivityIntent(mAmazonMASHTestActivity, com/amazon/mShop/web/MShopWebActivity, -1);
        intent.putExtra(WebConstants.getWebViewUrlKey(), s);
        startActivity(intent);
    }

    public volatile CharSequence getTitle()
    {
        return getTitle();
    }

    public String getTitle()
    {
        return (String)getResources().getText(com.amazon.mShop.android.lib.urces);
    }

    public void onClick(View view)
    {
        if (view.getId() == com.amazon.mShop.android.lib.urces)
        {
            startMASHTestActivity(AmazonMASHTestActivity.access$000(AmazonMASHTestActivity.this).getText().toString());
        } else
        {
            if (view.getId() == com.amazon.mShop.android.lib.SHTestActivity)
            {
                startMASHTestActivity(AmazonMASHTestActivity.access$200(AmazonMASHTestActivity.this).getText().toString());
                return;
            }
            if (view.getId() == com.amazon.mShop.android.lib.SHTestActivity)
            {
                startMASHTestActivity(AmazonMASHTestActivity.access$400(AmazonMASHTestActivity.this).getText().toString());
                return;
            }
            if (view.getId() == com.amazon.mShop.android.lib.SHTestActivity)
            {
                startMASHTestActivity(AmazonMASHTestActivity.access$600(AmazonMASHTestActivity.this).getText().toString());
                return;
            }
            if (view.getId() == com.amazon.mShop.android.lib.SHTestActivity)
            {
                startMASHTestActivity(AmazonMASHTestActivity.access$800(AmazonMASHTestActivity.this).getText().toString());
                return;
            }
            if (view.getId() == com.amazon.mShop.android.lib.SHTestActivity)
            {
                startMASHTestActivity(AmazonMASHTestActivity.access$1000(AmazonMASHTestActivity.this).getText().toString());
                return;
            }
            if (view.getId() == com.amazon.mShop.android.lib.SHTestActivity)
            {
                startMASHTestActivity(AmazonMASHTestActivity.access$1200(AmazonMASHTestActivity.this).getText().toString());
                return;
            }
        }
    }


    public _cls1.val.this._cls0(AmazonMASHTestActivity amazonmashtestactivity)
    {
        this.this$0 = AmazonMASHTestActivity.this;
        super(amazonmashtestactivity);
        mAmazonMASHTestActivity = amazonmashtestactivity;
        amazonmashtestactivity = View.inflate(amazonmashtestactivity, com.amazon.mShop.android.lib.MASHTestActivity, null);
        addView(amazonmashtestactivity);
        AmazonMASHTestActivity.access$002(AmazonMASHTestActivity.this, (EditText)amazonmashtestactivity.findViewById(com.amazon.mShop.android.lib.));
        AmazonMASHTestActivity.access$000(AmazonMASHTestActivity.this).setText("https://mash-test.integ.amazon.com/mash-api-11.html");
        AmazonMASHTestActivity.access$102(AmazonMASHTestActivity.this, (Button)amazonmashtestactivity.findViewById(com.amazon.mShop.android.lib.));
        AmazonMASHTestActivity.access$100(AmazonMASHTestActivity.this).setOnClickListener(this);
        AmazonMASHTestActivity.access$202(AmazonMASHTestActivity.this, (EditText)amazonmashtestactivity.findViewById(com.amazon.mShop.android.lib.));
        AmazonMASHTestActivity.access$200(AmazonMASHTestActivity.this).setText("https://mash-test.integ.amazon.com/mash-api-12.html");
        AmazonMASHTestActivity.access$302(AmazonMASHTestActivity.this, (Button)amazonmashtestactivity.findViewById(com.amazon.mShop.android.lib.));
        AmazonMASHTestActivity.access$300(AmazonMASHTestActivity.this).setOnClickListener(this);
        AmazonMASHTestActivity.access$402(AmazonMASHTestActivity.this, (EditText)amazonmashtestactivity.findViewById(com.amazon.mShop.android.lib.));
        AmazonMASHTestActivity.access$400(AmazonMASHTestActivity.this).setText("https://mash-test.integ.amazon.com/mash-api-13.html");
        AmazonMASHTestActivity.access$502(AmazonMASHTestActivity.this, (Button)amazonmashtestactivity.findViewById(com.amazon.mShop.android.lib.));
        AmazonMASHTestActivity.access$500(AmazonMASHTestActivity.this).setOnClickListener(this);
        AmazonMASHTestActivity.access$602(AmazonMASHTestActivity.this, (EditText)amazonmashtestactivity.findViewById(com.amazon.mShop.android.lib.));
        AmazonMASHTestActivity.access$600(AmazonMASHTestActivity.this).setText("https://mash-test.integ.amazon.com/mash-api-14.html");
        AmazonMASHTestActivity.access$702(AmazonMASHTestActivity.this, (Button)amazonmashtestactivity.findViewById(com.amazon.mShop.android.lib.));
        AmazonMASHTestActivity.access$700(AmazonMASHTestActivity.this).setOnClickListener(this);
        AmazonMASHTestActivity.access$802(AmazonMASHTestActivity.this, (EditText)amazonmashtestactivity.findViewById(com.amazon.mShop.android.lib.));
        AmazonMASHTestActivity.access$800(AmazonMASHTestActivity.this).setText("https://mash-test.integ.amazon.com/mash-api-15.html");
        AmazonMASHTestActivity.access$902(AmazonMASHTestActivity.this, (Button)amazonmashtestactivity.findViewById(com.amazon.mShop.android.lib.));
        AmazonMASHTestActivity.access$900(AmazonMASHTestActivity.this).setOnClickListener(this);
        AmazonMASHTestActivity.access$1002(AmazonMASHTestActivity.this, (EditText)amazonmashtestactivity.findViewById(com.amazon.mShop.android.lib.));
        AmazonMASHTestActivity.access$1000(AmazonMASHTestActivity.this).setText("https://mash-test.integ.amazon.com/mash-api-16.html");
        AmazonMASHTestActivity.access$1102(AmazonMASHTestActivity.this, (Button)amazonmashtestactivity.findViewById(com.amazon.mShop.android.lib.));
        AmazonMASHTestActivity.access$1100(AmazonMASHTestActivity.this).setOnClickListener(this);
        AmazonMASHTestActivity.access$1202(AmazonMASHTestActivity.this, (EditText)amazonmashtestactivity.findViewById(com.amazon.mShop.android.lib.));
        AmazonMASHTestActivity.access$1200(AmazonMASHTestActivity.this).setText("https://mash-test.integ.amazon.com/MASHCookie.html");
        AmazonMASHTestActivity.access$1302(AmazonMASHTestActivity.this, (Button)amazonmashtestactivity.findViewById(com.amazon.mShop.android.lib.));
        AmazonMASHTestActivity.access$1300(AmazonMASHTestActivity.this).setOnClickListener(this);
        AmazonMASHTestActivity.access$1402(AmazonMASHTestActivity.this, (EditText)amazonmashtestactivity.findViewById(com.amazon.mShop.android.lib.));
        AmazonMASHTestActivity.access$1400(AmazonMASHTestActivity.this).setText("https://mash-test.integ.amazon.com/mash-test-home.html");
        AmazonMASHTestActivity.access$1502(AmazonMASHTestActivity.this, (Button)amazonmashtestactivity.findViewById(com.amazon.mShop.android.lib.));
        AmazonMASHTestActivity.access$1500(AmazonMASHTestActivity.this).setOnClickListener(new android.view.View.OnClickListener() {

            final AmazonMASHTestActivity.MASHTestView this$1;
            final AmazonMASHTestActivity val$this$0;

            public void onClick(View view)
            {
                startMASHTestActivity(AmazonMASHTestActivity.access$1400(AmazonMASHTestActivity.MASHTestView.this.this$0).getText().toString());
            }

            
            {
                this$1 = AmazonMASHTestActivity.MASHTestView.this;
                this$0 = amazonmashtestactivity;
                super();
            }
        });
    }
}
