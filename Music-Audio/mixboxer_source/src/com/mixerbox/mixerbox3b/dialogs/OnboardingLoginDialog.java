// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b.dialogs;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

public class OnboardingLoginDialog extends android.app.AlertDialog.Builder
{

    private Context ctx;

    public OnboardingLoginDialog(Context context)
    {
        super(context);
        ctx = context;
        getContent();
    }

    private void getContent()
    {
        View view = LayoutInflater.from(ctx).inflate(0x7f030029, null);
        setView(view);
        ((TextView)view.findViewById(0x7f070063)).setText(ctx.getResources().getString(0x7f08012a));
        setTitle(ctx.getResources().getString(0x7f080129));
        setCancelable(false);
        setPositiveButton(ctx.getResources().getString(0x7f08007e), new _cls1());
        setNegativeButton(ctx.getResources().getString(0x7f080063), new _cls2());
    }


    private class _cls1
        implements android.content.DialogInterface.OnClickListener
    {

        final OnboardingLoginDialog this$0;

        public void onClick(DialogInterface dialoginterface, int i)
        {
            if (((MainPage)ctx).rlVideoPlayer.getVisibility() == 0)
            {
                ((MainPage)ctx).shouldSendNoti = false;
                ((MainPage)ctx).closePlayer();
            }
            ((MainPage)ctx).fragmentSignUp.checkLoginType = 0;
            ((MainPage)ctx).fragmentSignUp.loginButton.performClick();
        }

        _cls1()
        {
            this$0 = OnboardingLoginDialog.this;
            super();
        }
    }


    private class _cls2
        implements android.content.DialogInterface.OnClickListener
    {

        final OnboardingLoginDialog this$0;

        public void onClick(DialogInterface dialoginterface, int i)
        {
            MixerBoxSharedPreferences.putOnboardingFinish(ctx, true);
            ((MainPage)ctx).onboardingPlayMusic();
        }

        _cls2()
        {
            this$0 = OnboardingLoginDialog.this;
            super();
        }
    }

}
