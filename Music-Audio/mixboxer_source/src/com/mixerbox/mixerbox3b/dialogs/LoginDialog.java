// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b.dialogs;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.flurry.android.FlurryAgent;
import java.util.HashMap;
import java.util.Map;

public class LoginDialog extends android.app.AlertDialog.Builder
{

    private Context ctx;
    int type;

    public LoginDialog(Context context, int i)
    {
        super(context);
        ctx = context;
        type = i;
        getContent();
    }

    private void getContent()
    {
        Object obj = LayoutInflater.from(ctx).inflate(0x7f030028, null);
        setView(((View) (obj)));
        obj = (TextView)((View) (obj)).findViewById(0x7f070063);
        if (type == 1)
        {
            ((TextView) (obj)).setText(ctx.getResources().getString(0x7f08004e));
            setTitle(ctx.getResources().getString(0x7f08004d));
            obj = new HashMap();
            ((Map) (obj)).put("action", "tabPlaylists");
            FlurryAgent.logEvent("action:login_ask", ((Map) (obj)));
        } else
        if (type == 2)
        {
            ((TextView) (obj)).setText(ctx.getResources().getString(0x7f080050));
            setTitle(ctx.getResources().getString(0x7f08004f));
            obj = new HashMap();
            ((Map) (obj)).put("action", "addMusic");
            FlurryAgent.logEvent("action:login_ask", ((Map) (obj)));
        } else
        if (type == 3)
        {
            ((TextView) (obj)).setText(ctx.getResources().getString(0x7f08004e));
            setTitle(ctx.getResources().getString(0x7f08004d));
            obj = new HashMap();
            ((Map) (obj)).put("action", "createAutoPlaylist");
            FlurryAgent.logEvent("action:login_ask", ((Map) (obj)));
        } else
        if (type == 4)
        {
            ((TextView) (obj)).setText(ctx.getResources().getString(0x7f080052));
            setTitle(ctx.getResources().getString(0x7f080051));
            obj = new HashMap();
            ((Map) (obj)).put("action", "subsOverDefault");
            FlurryAgent.logEvent("action:login_ask", ((Map) (obj)));
        } else
        if (type == 8)
        {
            ((TextView) (obj)).setText(ctx.getResources().getString(0x7f0800ff));
            setTitle(ctx.getResources().getString(0x7f0800fe));
            obj = new HashMap();
            ((Map) (obj)).put("action", "shareLocalPlaylist");
            FlurryAgent.logEvent("action:login_ask", ((Map) (obj)));
        } else
        if (type == 9)
        {
            ((TextView) (obj)).setText(ctx.getResources().getString(0x7f080105));
            setTitle(ctx.getResources().getString(0x7f080104));
            obj = new HashMap();
            ((Map) (obj)).put("action", "followDJ");
            FlurryAgent.logEvent("action:login_ask", ((Map) (obj)));
        } else
        {
            ((TextView) (obj)).setText(ctx.getResources().getString(0x7f080050));
            setTitle(ctx.getResources().getString(0x7f08004f));
            obj = new HashMap();
            ((Map) (obj)).put("action", "createPlaylist");
            FlurryAgent.logEvent("action:login_ask", ((Map) (obj)));
        }
        setPositiveButton(ctx.getResources().getString(0x7f08007e), new _cls1());
        setNegativeButton(ctx.getResources().getString(0x7f080063), new _cls2());
    }


    private class _cls1
        implements android.content.DialogInterface.OnClickListener
    {

        final LoginDialog this$0;

        public void onClick(DialogInterface dialoginterface, int i)
        {
            if (type == 1)
            {
                dialoginterface = new HashMap();
                dialoginterface.put("action", "tabPlaylists");
                FlurryAgent.logEvent("action:login_aft_ask", dialoginterface);
            } else
            if (type == 2)
            {
                dialoginterface = new HashMap();
                dialoginterface.put("action", "addMusic");
                FlurryAgent.logEvent("action:login_aft_ask", dialoginterface);
            } else
            if (type == 3)
            {
                dialoginterface = new HashMap();
                dialoginterface.put("action", "createAutoPlaylist");
                FlurryAgent.logEvent("action:login_aft_ask", dialoginterface);
            } else
            if (type == 4)
            {
                dialoginterface = new HashMap();
                dialoginterface.put("action", "subsOverDefault");
                FlurryAgent.logEvent("action:login_aft_ask", dialoginterface);
            } else
            if (type == 8)
            {
                dialoginterface = new HashMap();
                dialoginterface.put("action", "shareLocalPlaylist");
                FlurryAgent.logEvent("action:login_aft_ask", dialoginterface);
            } else
            if (type == 9)
            {
                dialoginterface = new HashMap();
                dialoginterface.put("action", "followDJ");
                FlurryAgent.logEvent("action:login_aft_ask", dialoginterface);
            } else
            {
                dialoginterface = new HashMap();
                dialoginterface.put("action", "createPlaylist");
                FlurryAgent.logEvent("action:login_aft_ask", dialoginterface);
            }
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
            this$0 = LoginDialog.this;
            super();
        }
    }


    private class _cls2
        implements android.content.DialogInterface.OnClickListener
    {

        final LoginDialog this$0;

        public void onClick(DialogInterface dialoginterface, int i)
        {
        }

        _cls2()
        {
            this$0 = LoginDialog.this;
            super();
        }
    }

}
