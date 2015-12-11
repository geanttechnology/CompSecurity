// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.braintreepayments.api.threedsecure;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;
import com.braintreepayments.api.models.ThreeDSecureAuthenticationResponse;
import com.braintreepayments.api.models.ThreeDSecureLookup;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Stack;

// Referenced classes of package com.braintreepayments.api.threedsecure:
//            ThreeDSecureWebView

public class ThreeDSecureWebViewActivity extends Activity
{

    public static final String EXTRA_THREE_D_SECURE_LOOKUP = "com.braintreepayments.api.EXTRA_THREE_D_SECURE_LOOKUP";
    public static final String EXTRA_THREE_D_SECURE_RESULT = "com.braintreepayments.api.EXTRA_THREE_D_SECURE_RESULT";
    private ActionBar mActionBar;
    private FrameLayout mRootView;
    private Stack mThreeDSecureWebViews;

    public ThreeDSecureWebViewActivity()
    {
    }

    private void setupActionBar()
    {
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            mActionBar = getActionBar();
            if (mActionBar != null)
            {
                setActionBarTitle("");
                mActionBar.setDisplayHomeAsUpEnabled(true);
            }
        }
    }

    protected void finishWithResult(ThreeDSecureAuthenticationResponse threedsecureauthenticationresponse)
    {
        setResult(-1, (new Intent()).putExtra("com.braintreepayments.api.EXTRA_THREE_D_SECURE_RESULT", threedsecureauthenticationresponse));
        finish();
    }

    public void onBackPressed()
    {
        if (((ThreeDSecureWebView)mThreeDSecureWebViews.peek()).canGoBack())
        {
            ((ThreeDSecureWebView)mThreeDSecureWebViews.peek()).goBack();
            return;
        }
        if (mThreeDSecureWebViews.size() > 1)
        {
            popCurrentWebView();
            return;
        } else
        {
            super.onBackPressed();
            return;
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        requestWindowFeature(2);
        bundle = (ThreeDSecureLookup)getIntent().getParcelableExtra("com.braintreepayments.api.EXTRA_THREE_D_SECURE_LOOKUP");
        if (bundle == null)
        {
            throw new IllegalArgumentException((new StringBuilder("A ThreeDSecureLookup must be specified with ")).append(com/braintreepayments/api/models/ThreeDSecureLookup.getSimpleName()).append(".EXTRA_THREE_D_SECURE_LOOKUP extra").toString());
        }
        setupActionBar();
        mThreeDSecureWebViews = new Stack();
        mRootView = (FrameLayout)findViewById(0x1020002);
        StringBuilder stringbuilder = new StringBuilder();
        ThreeDSecureWebView threedsecurewebview;
        try
        {
            stringbuilder.append("PaReq=");
            stringbuilder.append(URLEncoder.encode(bundle.getPareq(), "UTF-8"));
            stringbuilder.append("&MD=");
            stringbuilder.append(URLEncoder.encode(bundle.getMd(), "UTF-8"));
            stringbuilder.append("&TermUrl=");
            stringbuilder.append(URLEncoder.encode(bundle.getTermUrl(), "UTF-8"));
        }
        catch (UnsupportedEncodingException unsupportedencodingexception)
        {
            finish();
        }
        threedsecurewebview = new ThreeDSecureWebView(this);
        threedsecurewebview.init(this);
        threedsecurewebview.postUrl(bundle.getAcsUrl(), stringbuilder.toString().getBytes());
        pushNewWebView(threedsecurewebview);
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        if (menuitem.getItemId() == 0x102002c)
        {
            setResult(0);
            finish();
            return true;
        } else
        {
            return super.onOptionsItemSelected(menuitem);
        }
    }

    protected void popCurrentWebView()
    {
        mThreeDSecureWebViews.pop();
        pushNewWebView((ThreeDSecureWebView)mThreeDSecureWebViews.pop());
    }

    protected void pushNewWebView(ThreeDSecureWebView threedsecurewebview)
    {
        mThreeDSecureWebViews.push(threedsecurewebview);
        mRootView.removeAllViews();
        mRootView.addView(threedsecurewebview);
    }

    protected void setActionBarTitle(String s)
    {
        if (mActionBar != null)
        {
            mActionBar.setTitle(s);
        }
    }
}
