// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes.ui;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.livemixtapes.App;

// Referenced classes of package com.livemixtapes.ui:
//            SlideAnimation, ProgressHUD

public class BaseActivity extends FragmentActivity
{

    protected App app;
    ProgressHUD hud;
    protected LinearLayout layoutBack;
    protected TextView textViewBack;
    protected TextView textViewTitle;

    public BaseActivity()
    {
        textViewTitle = null;
        hud = null;
    }

    protected void afterAppear()
    {
    }

    protected void attachEvent()
    {
    }

    protected void finishScreen()
    {
        finish();
    }

    public FragmentTransaction getAnimatedFragmentTransaction()
    {
        FragmentTransaction fragmenttransaction = getFragmentManager().beginTransaction();
        fragmenttransaction.setCustomAnimations(SlideAnimation.FRAGMENT_START_ENTER, SlideAnimation.FRAGMENT_START_LEAVE, SlideAnimation.FRAGMENT_FINISH_LEAVE, SlideAnimation.FRAGMENT_FINISH_ENTER);
        return fragmenttransaction;
    }

    public void hideProgressBar()
    {
        if (hud != null)
        {
            hud.hide();
        }
    }

    public void onBackPressed()
    {
        super.onBackPressed();
        SlideAnimation.startCloseAnimation(this);
    }

    protected void onCreate(Bundle bundle, int i)
    {
        requestWindowFeature(1);
        super.onCreate(bundle);
        setContentView(i);
        app = (App)getApplication();
        app.currentActivity = this;
        synthesize();
        attachEvent();
        afterAppear();
        SlideAnimation.startOpenAnimation(this);
    }

    public volatile View onCreateView(View view, String s, Context context, AttributeSet attributeset)
    {
        return super.onCreateView(view, s, context, attributeset);
    }

    public volatile View onCreateView(String s, Context context, AttributeSet attributeset)
    {
        return super.onCreateView(s, context, attributeset);
    }

    protected void onResume()
    {
        super.onResume();
    }

    protected void setBackButtonTitle(String s)
    {
        if (textViewBack != null)
        {
            textViewBack.setText(s);
        }
    }

    protected void setTitle(String s)
    {
        if (textViewTitle != null)
        {
            textViewTitle.setText(s);
        }
    }

    public void showErrorMessage(String s)
    {
        (new android.app.AlertDialog.Builder(this)).setIcon(0x1080027).setTitle(getResources().getString(0x7f0a003a)).setMessage(s).setPositiveButton("OK", new android.content.DialogInterface.OnClickListener() {

            final BaseActivity this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
            }

            
            {
                this$0 = BaseActivity.this;
                super();
            }
        }).show();
    }

    public void showProgressBar(String s)
    {
        hud = ProgressHUD.show(this, s, true, false, null);
    }

    protected void synthesize()
    {
        layoutBack = (LinearLayout)findViewById(0x7f08006d);
        textViewBack = (TextView)findViewById(0x7f08006f);
        textViewTitle = (TextView)findViewById(0x7f08006c);
    }
}
