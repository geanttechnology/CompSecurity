// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b.fragments;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.Session;
import com.facebook.SessionState;
import com.facebook.UiLifecycleHelper;
import com.mixerbox.mixerbox3b.MainPage;
import com.mixerbox.mixerbox3b.classes.MyFbLoginButton;
import com.mixerbox.mixerbox3b.utils.MixerBoxSharedPreferences;
import com.mixerbox.mixerbox3b.utils.MixerBoxUtils;
import java.util.Arrays;

public class SignUpFragment extends Fragment
{

    private static boolean pendingAnnounce = false;
    private com.facebook.Session.StatusCallback callback;
    public int checkLoginType;
    public MyFbLoginButton loginButton;
    private UiLifecycleHelper uiHelper;
    View v;

    public SignUpFragment()
    {
        checkLoginType = 1;
        callback = new _cls1();
    }

    private void onSessionStateChange(Session session, SessionState sessionstate, Exception exception)
    {
        if (sessionstate.isOpened() && !pendingAnnounce && !((MainPage)getActivity()).isLogIn)
        {
            pendingAnnounce = true;
            MixerBoxSharedPreferences.putFacebookToken(getActivity(), session.getAccessToken());
            MixerBoxUtils.toastMsg(getActivity(), getActivity().getResources().getString(0x7f080074), 1);
            MixerBoxUtils.laterLoginInit(getActivity(), session, null);
            MixerBoxUtils.logMsg("SESSION IS OPEN");
        } else
        if (sessionstate.isClosed())
        {
            MixerBoxUtils.logMsg("SESSION IS NOT OPEN");
            return;
        }
    }

    public void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
        uiHelper.onActivityResult(i, j, intent);
        Session.getActiveSession().onActivityResult(getActivity(), i, j, intent);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        checkLoginType = 1;
        uiHelper = new UiLifecycleHelper(getActivity(), callback);
        uiHelper.onCreate(bundle);
        pendingAnnounce = false;
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        v = layoutinflater.inflate(0x7f030035, viewgroup, false);
        loginButton = (MyFbLoginButton)v.findViewById(0x7f070090);
        loginButton.setFragment(this);
        loginButton.setReadPermissions(Arrays.asList(new String[] {
            "user_likes", "email", "read_stream"
        }));
        layoutinflater = loginButton;
        viewgroup = loginButton;
        viewgroup.getClass();
        layoutinflater.setOnClickListener(new _cls2(viewgroup));
        if (((MainPage)getActivity()).shouldLogin)
        {
            ((MainPage)getActivity()).shouldLogin = false;
            checkLoginType = 0;
            ((MainPage)getActivity()).canPlay = true;
            loginButton.performClick();
        }
        return v;
    }

    public void onDestroy()
    {
        super.onDestroy();
        uiHelper.onDestroy();
    }

    public void onPause()
    {
        super.onPause();
        uiHelper.onPause();
    }

    public void onResume()
    {
        super.onResume();
        Session session = Session.getActiveSession();
        if (session != null && (session.isOpened() || session.isClosed()))
        {
            onSessionStateChange(session, session.getState(), null);
        }
        uiHelper.onResume();
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        uiHelper.onSaveInstanceState(bundle);
    }



    private class _cls1
        implements com.facebook.Session.StatusCallback
    {

        final SignUpFragment this$0;

        public void call(Session session, SessionState sessionstate, Exception exception)
        {
            onSessionStateChange(session, sessionstate, exception);
        }

        _cls1()
        {
            this$0 = SignUpFragment.this;
            super();
        }
    }


    private class _cls2 extends com.mixerbox.mixerbox3b.classes.MyFbLoginButton.LoginClickListener
    {

        final SignUpFragment this$0;

        public void onClick(View view)
        {
            ((MainPage)getActivity()).canSetLocalNotification = false;
            ((MainPage)getActivity()).shouldSendNoti = false;
            ((MainPage)getActivity()).shouldPlayAfterReady = false;
            ((MainPage)getActivity()).closePlayer();
            if (checkLoginType == 1)
            {
                FlurryAgent.logEvent("action:djs_page_login");
            }
            checkLoginType = 1;
            super.onClick(view);
        }

        _cls2(MyFbLoginButton myfbloginbutton)
        {
            this$0 = SignUpFragment.this;
            myfbloginbutton.getClass();
            super(myfbloginbutton);
        }
    }

}
