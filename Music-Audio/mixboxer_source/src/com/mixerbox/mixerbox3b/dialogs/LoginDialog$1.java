// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b.dialogs;

import android.content.DialogInterface;
import android.widget.RelativeLayout;
import com.flurry.android.FlurryAgent;
import com.mixerbox.mixerbox3b.MainPage;
import com.mixerbox.mixerbox3b.classes.MyFbLoginButton;
import com.mixerbox.mixerbox3b.fragments.SignUpFragment;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.mixerbox.mixerbox3b.dialogs:
//            LoginDialog

class this._cls0
    implements android.content.e.OnClickListener
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
        if (((MainPage)LoginDialog.access$000(LoginDialog.this)).rlVideoPlayer.getVisibility() == 0)
        {
            ((MainPage)LoginDialog.access$000(LoginDialog.this)).shouldSendNoti = false;
            ((MainPage)LoginDialog.access$000(LoginDialog.this)).closePlayer();
        }
        ((MainPage)LoginDialog.access$000(LoginDialog.this)).fragmentSignUp.checkLoginType = 0;
        ((MainPage)LoginDialog.access$000(LoginDialog.this)).fragmentSignUp.loginButton.performClick();
    }

    n()
    {
        this$0 = LoginDialog.this;
        super();
    }
}
