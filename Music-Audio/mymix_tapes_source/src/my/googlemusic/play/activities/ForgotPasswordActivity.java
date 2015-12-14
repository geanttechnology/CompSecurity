// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.activities;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import my.googlemusic.play.application.App;
import my.googlemusic.play.interfaces.Server;
import my.googlemusic.play.internet.Connection;
import my.googlemusic.play.internet.Response;
import my.googlemusic.play.utils.CompatibilityUtil;
import my.googlemusic.play.utils.animations.AnimationBackgroundView;
import my.googlemusic.play.utils.appbar.AppBar;
import my.googlemusic.play.utils.toast.Toast;
import my.googlemusic.play.utils.toast.ToastCreator;

public class ForgotPasswordActivity extends ActionBarActivity
    implements android.view.View.OnClickListener, android.view.View.OnLongClickListener, android.view.View.OnTouchListener, my.googlemusic.play.utils.appbar.AppBar.OnAppBarListener
{
    static class ViewHolder
    {

        AppBar appBar;
        View background;
        View backgroundTransition;
        EditText email;
        Button submit;

        ViewHolder()
        {
        }
    }


    static final boolean $assertionsDisabled;
    private AnimationBackgroundView animationBackgroundView;
    private ViewHolder mHolder;
    private Server mServer;

    public ForgotPasswordActivity()
    {
    }

    private void initView()
    {
        if (CompatibilityUtil.getSdkVersion() >= 19)
        {
            getWindow().setFlags(0x4000000, 0x4000000);
        }
        mHolder = new ViewHolder();
        mHolder.submit = (Button)findViewById(0x7f0d0252);
        mHolder.email = (EditText)findViewById(0x7f0d0251);
        mHolder.background = findViewById(0x7f0d024f);
        mHolder.backgroundTransition = findViewById(0x7f0d0250);
        mHolder.appBar = AppBar.with(findViewById(0x7f0d0074), this).title("Forgot Password").back();
        mHolder.appBar.background(getResources().getColor(0x106000d));
        mHolder.submit.setOnClickListener(this);
        mHolder.email.setOnTouchListener(this);
        mHolder.email.setOnLongClickListener(this);
        if (CompatibilityUtil.getSdkVersion() > 15)
        {
            animationBackgroundView = new AnimationBackgroundView(mHolder.background, mHolder.backgroundTransition);
        }
    }

    private void setButtonEnabled(boolean flag)
    {
        String s;
        int i;
        if (flag)
        {
            s = "Recover";
        } else
        {
            s = "Loading";
        }
        if (flag)
        {
            i = getResources().getColor(0x106000b);
        } else
        {
            i = 0xff888888;
        }
        mHolder.submit.setText(s);
        mHolder.submit.setBackgroundColor(i);
        mHolder.submit.setEnabled(flag);
    }

    public void onAppBarClick(my.googlemusic.play.utils.appbar.AppBar.OnAppBarListener.Action action)
    {
        if (action == my.googlemusic.play.utils.appbar.AppBar.OnAppBarListener.Action.BACK)
        {
            super.onBackPressed();
        }
    }

    public void onClick(View view)
    {
label0:
        {
            if (view == mHolder.submit)
            {
                if (Connection.with(this).isConnected())
                {
                    break label0;
                }
                Toast.with(this).message("No connection.").show();
            }
            return;
        }
        view = mHolder.email.getText();
        if (!$assertionsDisabled && view == null)
        {
            throw new AssertionError();
        }
        if (view.toString().isEmpty())
        {
            Toast.with(this).message("Please, insert email.").show();
            return;
        }
        if (!view.toString().contains("@") || !view.toString().contains("."))
        {
            Toast.with(this).message("Format email invalid.").show();
            return;
        }
        if (view.toString().contains("#"))
        {
            Toast.with(this).message("Format email invalid.").show();
            return;
        }
        if (view.toString().contains("&"))
        {
            Toast.with(this).message("Format email invalid.").show();
            return;
        }
        if (view.toString().contains("/"))
        {
            Toast.with(this).message("Format email invalid.").show();
            return;
        }
        if (view.toString().contains("$"))
        {
            Toast.with(this).message("Format email invalid.").show();
            return;
        }
        if (view.toString().contains("%"))
        {
            Toast.with(this).message("Format email invalid.").show();
            return;
        }
        if (view.toString().contains("?"))
        {
            Toast.with(this).message("Format email invalid.").show();
            return;
        } else
        {
            setButtonEnabled(false);
            mServer.recoverPassword(view.toString(), new my.googlemusic.play.interfaces.Server.Callback() {

                final ForgotPasswordActivity this$0;

                public void onFailure(Response response)
                {
                    if (response.getStatus() == 7)
                    {
                        Toast.with(ForgotPasswordActivity.this).message(response.getContent()).show();
                    }
                    setButtonEnabled(true);
                }

                public void onProgress(int i)
                {
                }

                public void onSuccess(Object obj)
                {
                    Toast.with(ForgotPasswordActivity.this).message("Email sent successfully.").show();
                    setButtonEnabled(true);
                }

            
            {
                this$0 = ForgotPasswordActivity.this;
                super();
            }
            });
            return;
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        getSupportActionBar().hide();
        setContentView(0x7f03006c);
        initView();
        mServer = ((App)getApplication()).getServer();
    }

    public boolean onLongClick(View view)
    {
        return true;
    }

    protected void onPause()
    {
        super.onPause();
        if (CompatibilityUtil.getSdkVersion() > 15)
        {
            animationBackgroundView.setAnimationActive(Boolean.valueOf(false));
        }
    }

    protected void onResume()
    {
        super.onResume();
        if (CompatibilityUtil.getSdkVersion() > 15)
        {
            animationBackgroundView.setAnimationActive(Boolean.valueOf(true));
            animationBackgroundView.animatedBackground(1, 0);
        }
    }

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        view.requestFocus();
        ((InputMethodManager)getSystemService("input_method")).showSoftInput(view, 1);
        return true;
    }

    static 
    {
        boolean flag;
        if (!my/googlemusic/play/activities/ForgotPasswordActivity.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        $assertionsDisabled = flag;
    }

}
