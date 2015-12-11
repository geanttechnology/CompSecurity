// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.openx.sdk.browser;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Handler;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import com.openx.common.utils.constants.Constants;
import com.openx.common.utils.helpers.Utils;
import com.openx.core.sdk.OXMManagersResolver;
import com.openx.sdk.event.OXMEventsHandler;
import com.openx.sdk.event.OXMEventsListener;

// Referenced classes of package com.openx.sdk.browser:
//            BrowserControlsEventsListener

final class BrowserControls extends TableLayout
{

    private Button mBackBtn;
    private BrowserControlsEventsListener mBrowserControlsEventsListener;
    private Button mCloseBtn;
    private OXMEventsHandler mCloseEventsListener;
    private Button mForthBtn;
    private LinearLayout mLeftPart;
    private Button mOpenInExternalBrowserBtn;
    private Button mRefreshBtn;
    private LinearLayout mRightPart;
    private Handler mUIHandler;

    public BrowserControls(Context context, BrowserControlsEventsListener browsercontrolseventslistener)
    {
        super(context);
        init(context.getResources(), browsercontrolseventslistener);
    }

    private void bindEventListeners()
    {
        mCloseBtn.setOnClickListener(new _cls2());
        mBackBtn.setOnClickListener(new _cls3());
        mForthBtn.setOnClickListener(new _cls4());
        mRefreshBtn.setOnClickListener(new _cls5());
        mOpenInExternalBrowserBtn.setOnClickListener(new _cls6());
    }

    private void init(Resources resources, BrowserControlsEventsListener browsercontrolseventslistener)
    {
        mUIHandler = new Handler();
        mBrowserControlsEventsListener = browsercontrolseventslistener;
        resources = new TableRow(getContext());
        mLeftPart = new LinearLayout(getContext());
        mRightPart = new LinearLayout(getContext());
        mLeftPart.setVisibility(8);
        mRightPart.setGravity(5);
        setBackgroundColor(Constants.BROWSER_CONTROLS_PANEL_COLOR);
        setAllButtons();
        bindEventListeners();
        mLeftPart.addView(mBackBtn);
        mLeftPart.addView(mForthBtn);
        mLeftPart.addView(mRefreshBtn);
        mLeftPart.addView(mOpenInExternalBrowserBtn);
        mRightPart.addView(mCloseBtn);
        resources.addView(mLeftPart, new android.widget.TableRow.LayoutParams(-1, -1, 3F));
        resources.addView(mRightPart, new android.widget.TableRow.LayoutParams(-1, -1, 5F));
        addView(resources);
        setCloseEventListener();
        OXMManagersResolver.getInstance().getEventsManager().registerEventListener(com.openx.sdk.event.OXMEvent.OXMEventType.CLOSE_ACTIVE_INTERNAL_WINDOW, mCloseEventsListener);
    }

    private void setAllButtons()
    {
        mCloseBtn = new Button(getContext());
        setButtonDefaultSize(mCloseBtn);
        mCloseBtn.setBackgroundResource(com.openx.android_sdk_openx.R.drawable.openx_res_close);
        mBackBtn = new Button(getContext());
        setButtonDefaultSize(mBackBtn);
        mBackBtn.setBackgroundResource(com.openx.android_sdk_openx.R.drawable.openx_res_back_inactive);
        mForthBtn = new Button(getContext());
        setButtonDefaultSize(mForthBtn);
        mForthBtn.setBackgroundResource(com.openx.android_sdk_openx.R.drawable.openx_res_forth_inactive);
        mRefreshBtn = new Button(getContext());
        setButtonDefaultSize(mRefreshBtn);
        mRefreshBtn.setBackgroundResource(com.openx.android_sdk_openx.R.drawable.openx_res_refresh);
        mOpenInExternalBrowserBtn = new Button(getContext());
        setButtonDefaultSize(mOpenInExternalBrowserBtn);
        mOpenInExternalBrowserBtn.setBackgroundResource(com.openx.android_sdk_openx.R.drawable.openx_res_open_in_browser);
    }

    private void setButtonDefaultSize(Button button)
    {
        button.setHeight((int)(Utils.DENSITY * 50F));
        button.setWidth((int)(Utils.DENSITY * 50F));
    }

    private void setCloseEventListener()
    {
        mCloseEventsListener = new _cls7();
    }

    public void dispose()
    {
        OXMManagersResolver.getInstance().getEventsManager().unregisterEventListener(com.openx.sdk.event.OXMEvent.OXMEventType.CLOSE_ACTIVE_INTERNAL_WINDOW, mCloseEventsListener);
    }

    public void hideNavigationControls()
    {
        mLeftPart.setVisibility(8);
    }

    public void openURLInExternalBrowser(String s)
    {
        Utils.log(this, String.format(Utils.getLogMessage("starting_external_browser_with"), new Object[] {
            s
        }));
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(s));
        intent.addFlags(0x10000000);
        try
        {
            getContext().startActivity(intent);
            Utils.log(this, Utils.getLogMessage("browser_has_started"));
            return;
        }
        catch (ActivityNotFoundException activitynotfoundexception)
        {
            Utils.log(this, String.format(Utils.getLogMessage("could_not_handle_intent"), new Object[] {
                s
            }));
        }
    }

    public void showNavigationControls()
    {
        mLeftPart.setVisibility(0);
    }

    public void updateNavigationButtonsState()
    {
        mUIHandler.post(new _cls1());
    }




    /* member class not found */
    class _cls2 {}


    /* member class not found */
    class _cls3 {}


    /* member class not found */
    class _cls4 {}


    /* member class not found */
    class _cls5 {}


    /* member class not found */
    class _cls6 {}


    /* member class not found */
    class _cls7 {}


    /* member class not found */
    class _cls1 {}

}
