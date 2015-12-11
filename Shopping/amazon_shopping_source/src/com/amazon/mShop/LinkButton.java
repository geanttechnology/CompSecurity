// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import com.amazon.mShop.navigation.AppNavigator;
import com.amazon.mShop.net.RefMarkerObserver;
import com.amazon.mShop.util.ConfigUtils;
import com.amazon.mShop.util.WebUtils;

// Referenced classes of package com.amazon.mShop:
//            AmazonActivity, StandardView, StandardViewWithTextContent, StandardViewWithUrlContent

public class LinkButton extends Button
    implements android.view.View.OnClickListener
{

    private final int mConfigId;
    private final int mHtmlContentId;
    private final String mLinkClassName;
    private final int mLinkLayoutId;
    private String mNavigationTarget;
    private String mStringUrl;
    private final int mTextContentId;
    private final int mTitleResourceId;
    private final int mUrlContentId;
    private final boolean mUrlUseExternalBrowser;

    public LinkButton(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mLinkLayoutId = attributeset.getAttributeResourceValue(null, "amazon_linkLayoutId", 0);
        mLinkClassName = attributeset.getAttributeValue(null, "amazon_linkClassName");
        mTitleResourceId = attributeset.getAttributeResourceValue(null, "amazon_titleResourceId", 0);
        mTextContentId = attributeset.getAttributeResourceValue(null, "amazon_textContentId", 0);
        mHtmlContentId = attributeset.getAttributeResourceValue(null, "amazon_htmlContentId", 0);
        mUrlContentId = attributeset.getAttributeResourceValue(null, "amazon_urlContentId", 0);
        mUrlUseExternalBrowser = attributeset.getAttributeBooleanValue(null, "amazon_urlUseExternalBrowser", false);
        mNavigationTarget = attributeset.getAttributeValue(null, "amazon_navigationTarget");
        mConfigId = attributeset.getAttributeResourceValue(null, "amazon_configId", 0);
        if (mConfigId != 0 && !ConfigUtils.isEnabled(getContext(), mConfigId))
        {
            setVisibility(8);
        }
        mStringUrl = null;
    }

    public void initLinkButton(String s, String s1)
    {
        setText(s);
        mStringUrl = s1;
        setOnClickListener(this);
    }

    public void onClick(View view)
    {
        AmazonActivity amazonactivity = (AmazonActivity)getContext();
        if (mLinkLayoutId == 0) goto _L2; else goto _L1
_L1:
        amazonactivity.pushView(mLinkLayoutId);
_L4:
        return;
_L2:
        if (mLinkClassName == null)
        {
            break; /* Loop/switch isn't completed */
        }
        view = null;
        Object obj = StandardView.createStandardView(mLinkClassName, amazonactivity, mTitleResourceId);
        view = ((View) (obj));
_L5:
        if (view != null)
        {
            amazonactivity.pushView(view);
            return;
        }
        if (true) goto _L4; else goto _L3
        Exception exception;
        exception;
        Log.e("AmazonActivity", exception.toString());
          goto _L5
_L3:
        if (mTextContentId == 0 && mHtmlContentId == 0)
        {
            break; /* Loop/switch isn't completed */
        }
        int i;
        boolean flag;
        if (mTextContentId != 0)
        {
            i = mTextContentId;
            flag = false;
        } else
        {
            i = mHtmlContentId;
            flag = true;
        }
        view = null;
        exception = new StandardViewWithTextContent(amazonactivity, Integer.valueOf(mTitleResourceId), i, flag);
        view = exception;
_L7:
        if (view != null)
        {
            amazonactivity.pushView(view);
            return;
        }
        if (true) goto _L4; else goto _L6
        exception;
        Log.e("AmazonActivity", exception.toString());
          goto _L7
_L6:
        if (mUrlContentId == 0)
        {
            break MISSING_BLOCK_LABEL_345;
        }
        view = Uri.parse(getResources().getString(mUrlContentId));
        if ("tel".equalsIgnoreCase(view.getScheme()))
        {
            view = new Intent("android.intent.action.DIAL", view);
            getContext().startActivity(view);
            if (mUrlContentId == com.amazon.mShop.android.lib.R.string.help_call_customer_service_url)
            {
                RefMarkerObserver.logRefMarker("mr_ca_cs");
                return;
            }
            continue; /* Loop/switch isn't completed */
        }
        if ("mailto".equals(view.getScheme()))
        {
            WebUtils.handleMailtoLink(amazonactivity, view.toString());
            return;
        }
        if (!mUrlUseExternalBrowser) goto _L9; else goto _L8
_L8:
        view = new Intent("android.intent.action.VIEW", view);
        getContext().startActivity(view);
_L11:
        if (mUrlContentId == com.amazon.mShop.android.lib.R.string.help_email_customer_service_url)
        {
            RefMarkerObserver.logRefMarker("mr_em_cs");
            return;
        }
        continue; /* Loop/switch isn't completed */
_L9:
        view = null;
        exception = new StandardViewWithUrlContent(amazonactivity, Integer.valueOf(mTitleResourceId), mUrlContentId);
        view = exception;
_L12:
        if (view != null)
        {
            amazonactivity.pushView(view);
        }
        if (true) goto _L11; else goto _L10
_L10:
        exception;
        Log.e("AmazonActivity", exception.toString());
          goto _L12
        if (mStringUrl == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        view = Uri.parse(mStringUrl);
        if (mUrlUseExternalBrowser)
        {
            view = new Intent("android.intent.action.VIEW", view);
            getContext().startActivity(view);
            return;
        }
        view = null;
        exception = new StandardViewWithUrlContent(amazonactivity, getText().toString(), mStringUrl);
        view = exception;
_L14:
        if (view != null)
        {
            amazonactivity.pushView(view);
            return;
        }
        if (true) goto _L4; else goto _L13
_L13:
        exception;
        Log.e("AmazonActivity", exception.toString());
          goto _L14
        if (TextUtils.isEmpty(mNavigationTarget)) goto _L4; else goto _L15
_L15:
        AppNavigator.navigate(amazonactivity, com.amazon.mShop.navigation.AppNavigator.Target.from(mNavigationTarget));
        return;
    }

    protected void onFinishInflate()
    {
        super.onFinishInflate();
        if (mLinkClassName != null || mLinkLayoutId != 0 || mTextContentId != 0 || mHtmlContentId != 0 || mUrlContentId != 0 || !TextUtils.isEmpty(mNavigationTarget))
        {
            setOnClickListener(this);
        }
    }
}
