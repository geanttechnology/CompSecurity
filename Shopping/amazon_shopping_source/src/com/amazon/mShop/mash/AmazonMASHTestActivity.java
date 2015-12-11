// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.mash;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.TitleProvider;
import com.amazon.mShop.util.ActivityUtils;
import com.amazon.mShop.web.MShopWebActivity;
import com.amazon.mobile.mash.constants.WebConstants;

public class AmazonMASHTestActivity extends AmazonActivity
{
    private class MASHTestView extends ScrollView
        implements android.view.View.OnClickListener, TitleProvider
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
            return (String)getResources().getText(com.amazon.mShop.android.lib.R.string.mash_api_test);
        }

        public void onClick(View view)
        {
            if (view.getId() == com.amazon.mShop.android.lib.R.id.mash_api_1_1_test_button)
            {
                startMASHTestActivity(mash11Url.getText().toString());
            } else
            {
                if (view.getId() == com.amazon.mShop.android.lib.R.id.mash_api_1_2_test_button)
                {
                    startMASHTestActivity(mash12Url.getText().toString());
                    return;
                }
                if (view.getId() == com.amazon.mShop.android.lib.R.id.mash_api_1_3_test_button)
                {
                    startMASHTestActivity(mash13Url.getText().toString());
                    return;
                }
                if (view.getId() == com.amazon.mShop.android.lib.R.id.mash_api_1_4_test_button)
                {
                    startMASHTestActivity(mash14Url.getText().toString());
                    return;
                }
                if (view.getId() == com.amazon.mShop.android.lib.R.id.mash_api_1_5_test_button)
                {
                    startMASHTestActivity(mash15Url.getText().toString());
                    return;
                }
                if (view.getId() == com.amazon.mShop.android.lib.R.id.mash_api_1_6_test_button)
                {
                    startMASHTestActivity(mash16Url.getText().toString());
                    return;
                }
                if (view.getId() == com.amazon.mShop.android.lib.R.id.mash_cookie_test_button)
                {
                    startMASHTestActivity(mashCookieUrl.getText().toString());
                    return;
                }
            }
        }


        public MASHTestView(AmazonMASHTestActivity amazonmashtestactivity1)
        {
            this$0 = AmazonMASHTestActivity.this;
            super(amazonmashtestactivity1);
            mAmazonMASHTestActivity = amazonmashtestactivity1;
            amazonmashtestactivity1 = View.inflate(amazonmashtestactivity1, com.amazon.mShop.android.lib.R.layout.mash_api_test, null);
            addView(amazonmashtestactivity1);
            mash11Url = (EditText)amazonmashtestactivity1.findViewById(com.amazon.mShop.android.lib.R.id.mash_api_1_1_url_edit_text);
            mash11Url.setText("https://mash-test.integ.amazon.com/mash-api-11.html");
            mash11Test = (Button)amazonmashtestactivity1.findViewById(com.amazon.mShop.android.lib.R.id.mash_api_1_1_test_button);
            mash11Test.setOnClickListener(this);
            mash12Url = (EditText)amazonmashtestactivity1.findViewById(com.amazon.mShop.android.lib.R.id.mash_api_1_2_url_edit_text);
            mash12Url.setText("https://mash-test.integ.amazon.com/mash-api-12.html");
            mash12Test = (Button)amazonmashtestactivity1.findViewById(com.amazon.mShop.android.lib.R.id.mash_api_1_2_test_button);
            mash12Test.setOnClickListener(this);
            mash13Url = (EditText)amazonmashtestactivity1.findViewById(com.amazon.mShop.android.lib.R.id.mash_api_1_3_url_edit_text);
            mash13Url.setText("https://mash-test.integ.amazon.com/mash-api-13.html");
            mash13Test = (Button)amazonmashtestactivity1.findViewById(com.amazon.mShop.android.lib.R.id.mash_api_1_3_test_button);
            mash13Test.setOnClickListener(this);
            mash14Url = (EditText)amazonmashtestactivity1.findViewById(com.amazon.mShop.android.lib.R.id.mash_api_1_4_url_edit_text);
            mash14Url.setText("https://mash-test.integ.amazon.com/mash-api-14.html");
            mash14Test = (Button)amazonmashtestactivity1.findViewById(com.amazon.mShop.android.lib.R.id.mash_api_1_4_test_button);
            mash14Test.setOnClickListener(this);
            mash15Url = (EditText)amazonmashtestactivity1.findViewById(com.amazon.mShop.android.lib.R.id.mash_api_1_5_url_edit_text);
            mash15Url.setText("https://mash-test.integ.amazon.com/mash-api-15.html");
            mash15Test = (Button)amazonmashtestactivity1.findViewById(com.amazon.mShop.android.lib.R.id.mash_api_1_5_test_button);
            mash15Test.setOnClickListener(this);
            mash16Url = (EditText)amazonmashtestactivity1.findViewById(com.amazon.mShop.android.lib.R.id.mash_api_1_6_url_edit_text);
            mash16Url.setText("https://mash-test.integ.amazon.com/mash-api-16.html");
            mash16Test = (Button)amazonmashtestactivity1.findViewById(com.amazon.mShop.android.lib.R.id.mash_api_1_6_test_button);
            mash16Test.setOnClickListener(this);
            mashCookieUrl = (EditText)amazonmashtestactivity1.findViewById(com.amazon.mShop.android.lib.R.id.mash_cookie_url_edit_text);
            mashCookieUrl.setText("https://mash-test.integ.amazon.com/MASHCookie.html");
            mashCookieTest = (Button)amazonmashtestactivity1.findViewById(com.amazon.mShop.android.lib.R.id.mash_cookie_test_button);
            mashCookieTest.setOnClickListener(this);
            mashTestHomeUrl = (EditText)amazonmashtestactivity1.findViewById(com.amazon.mShop.android.lib.R.id.mash_test_home_url_edit_text);
            mashTestHomeUrl.setText("https://mash-test.integ.amazon.com/mash-test-home.html");
            mashTestHome = (Button)amazonmashtestactivity1.findViewById(com.amazon.mShop.android.lib.R.id.mash_test_home_button);
            mashTestHome.setOnClickListener(new _cls1());
        }
    }


    private final String MASH11_TEST_PAGE_URL = "https://mash-test.integ.amazon.com/mash-api-11.html";
    private final String MASH12_TEST_PAGE_URL = "https://mash-test.integ.amazon.com/mash-api-12.html";
    private final String MASH13_TEST_PAGE_URL = "https://mash-test.integ.amazon.com/mash-api-13.html";
    private final String MASH14_TEST_PAGE_URL = "https://mash-test.integ.amazon.com/mash-api-14.html";
    private final String MASH15_TEST_PAGE_URL = "https://mash-test.integ.amazon.com/mash-api-15.html";
    private final String MASH16_TEST_PAGE_URL = "https://mash-test.integ.amazon.com/mash-api-16.html";
    private final String MASH_COOKIE_TEST_PAGE_URL = "https://mash-test.integ.amazon.com/MASHCookie.html";
    private final String MASH_TEST_HOME_PAGE_URL = "https://mash-test.integ.amazon.com/mash-test-home.html";
    private Button mash11Test;
    private EditText mash11Url;
    private Button mash12Test;
    private EditText mash12Url;
    private Button mash13Test;
    private EditText mash13Url;
    private Button mash14Test;
    private EditText mash14Url;
    private Button mash15Test;
    private EditText mash15Url;
    private Button mash16Test;
    private EditText mash16Url;
    private Button mashCookieTest;
    private EditText mashCookieUrl;
    private Button mashTestHome;
    private EditText mashTestHomeUrl;

    public AmazonMASHTestActivity()
    {
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setRootView(new MASHTestView(this));
    }



/*
    static EditText access$002(AmazonMASHTestActivity amazonmashtestactivity, EditText edittext)
    {
        amazonmashtestactivity.mash11Url = edittext;
        return edittext;
    }

*/




/*
    static EditText access$1002(AmazonMASHTestActivity amazonmashtestactivity, EditText edittext)
    {
        amazonmashtestactivity.mash16Url = edittext;
        return edittext;
    }

*/


/*
    static Button access$102(AmazonMASHTestActivity amazonmashtestactivity, Button button)
    {
        amazonmashtestactivity.mash11Test = button;
        return button;
    }

*/



/*
    static Button access$1102(AmazonMASHTestActivity amazonmashtestactivity, Button button)
    {
        amazonmashtestactivity.mash16Test = button;
        return button;
    }

*/



/*
    static EditText access$1202(AmazonMASHTestActivity amazonmashtestactivity, EditText edittext)
    {
        amazonmashtestactivity.mashCookieUrl = edittext;
        return edittext;
    }

*/



/*
    static Button access$1302(AmazonMASHTestActivity amazonmashtestactivity, Button button)
    {
        amazonmashtestactivity.mashCookieTest = button;
        return button;
    }

*/



/*
    static EditText access$1402(AmazonMASHTestActivity amazonmashtestactivity, EditText edittext)
    {
        amazonmashtestactivity.mashTestHomeUrl = edittext;
        return edittext;
    }

*/



/*
    static Button access$1502(AmazonMASHTestActivity amazonmashtestactivity, Button button)
    {
        amazonmashtestactivity.mashTestHome = button;
        return button;
    }

*/



/*
    static EditText access$202(AmazonMASHTestActivity amazonmashtestactivity, EditText edittext)
    {
        amazonmashtestactivity.mash12Url = edittext;
        return edittext;
    }

*/



/*
    static Button access$302(AmazonMASHTestActivity amazonmashtestactivity, Button button)
    {
        amazonmashtestactivity.mash12Test = button;
        return button;
    }

*/



/*
    static EditText access$402(AmazonMASHTestActivity amazonmashtestactivity, EditText edittext)
    {
        amazonmashtestactivity.mash13Url = edittext;
        return edittext;
    }

*/



/*
    static Button access$502(AmazonMASHTestActivity amazonmashtestactivity, Button button)
    {
        amazonmashtestactivity.mash13Test = button;
        return button;
    }

*/



/*
    static EditText access$602(AmazonMASHTestActivity amazonmashtestactivity, EditText edittext)
    {
        amazonmashtestactivity.mash14Url = edittext;
        return edittext;
    }

*/



/*
    static Button access$702(AmazonMASHTestActivity amazonmashtestactivity, Button button)
    {
        amazonmashtestactivity.mash14Test = button;
        return button;
    }

*/



/*
    static EditText access$802(AmazonMASHTestActivity amazonmashtestactivity, EditText edittext)
    {
        amazonmashtestactivity.mash15Url = edittext;
        return edittext;
    }

*/



/*
    static Button access$902(AmazonMASHTestActivity amazonmashtestactivity, Button button)
    {
        amazonmashtestactivity.mash15Test = button;
        return button;
    }

*/

    // Unreferenced inner class com/amazon/mShop/mash/AmazonMASHTestActivity$MASHTestView$1

/* anonymous class */
    class MASHTestView._cls1
        implements android.view.View.OnClickListener
    {

        final MASHTestView this$1;
        final AmazonMASHTestActivity val$this$0;

        public void onClick(View view)
        {
            startMASHTestActivity(mashTestHomeUrl.getText().toString());
        }

            
            {
                this$1 = final_mashtestview;
                this$0 = AmazonMASHTestActivity.this;
                super();
            }
    }

}
