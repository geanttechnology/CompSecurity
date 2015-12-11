// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.widget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.support.v4.app.Fragment;
import android.util.AttributeSet;
import android.widget.Button;
import com.facebook.FacebookException;
import com.facebook.Request;
import com.facebook.Session;
import com.facebook.SessionDefaultAudience;
import com.facebook.SessionLoginBehavior;
import com.facebook.internal.SessionTracker;
import com.facebook.internal.Utility;
import com.facebook.model.GraphUser;
import java.util.List;

public class LoginButton extends Button
{

    private static final String TAG = com/facebook/widget/LoginButton.getName();
    private String applicationId;
    private boolean confirmLogout;
    private boolean fetchUserInfo;
    private String loginText;
    private String logoutText;
    private Fragment parentFragment;
    private LoginButtonProperties properties;
    private SessionTracker sessionTracker;
    private GraphUser user;
    private UserInfoChangedCallback userInfoChangedCallback;
    private Session userInfoSession;

    public LoginButton(Context context)
    {
        super(context);
        applicationId = null;
        user = null;
        userInfoSession = null;
        properties = new LoginButtonProperties();
        initializeActiveSessionWithCachedToken(context);
        finishInit();
    }

    public LoginButton(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        applicationId = null;
        user = null;
        userInfoSession = null;
        properties = new LoginButtonProperties();
        if (attributeset.getStyleAttribute() == 0)
        {
            setTextColor(getResources().getColor(com.facebook.android.R.color.com_facebook_loginview_text_color));
            setTextSize(0, getResources().getDimension(com.facebook.android.R.dimen.com_facebook_loginview_text_size));
            setPadding(getResources().getDimensionPixelSize(com.facebook.android.R.dimen.com_facebook_loginview_padding_left), getResources().getDimensionPixelSize(com.facebook.android.R.dimen.com_facebook_loginview_padding_top), getResources().getDimensionPixelSize(com.facebook.android.R.dimen.com_facebook_loginview_padding_right), getResources().getDimensionPixelSize(com.facebook.android.R.dimen.com_facebook_loginview_padding_bottom));
            setWidth(getResources().getDimensionPixelSize(com.facebook.android.R.dimen.com_facebook_loginview_width));
            setHeight(getResources().getDimensionPixelSize(com.facebook.android.R.dimen.com_facebook_loginview_height));
            setGravity(17);
            if (isInEditMode())
            {
                setBackgroundColor(getResources().getColor(com.facebook.android.R.color.com_facebook_blue));
                loginText = "Log in";
            } else
            {
                setBackgroundResource(com.facebook.android.R.drawable.com_facebook_loginbutton_blue);
            }
        }
        parseAttributes(attributeset);
        if (!isInEditMode())
        {
            initializeActiveSessionWithCachedToken(context);
        }
    }

    public LoginButton(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        applicationId = null;
        user = null;
        userInfoSession = null;
        properties = new LoginButtonProperties();
        parseAttributes(attributeset);
        initializeActiveSessionWithCachedToken(context);
    }

    private void fetchUserInfo()
    {
        if (fetchUserInfo)
        {
            final Session currentSession = sessionTracker.getOpenSession();
            if (currentSession != null)
            {
                if (currentSession != userInfoSession)
                {
                    Request.executeBatchAsync(new Request[] {
                        Request.newMeRequest(currentSession, new _cls1())
                    });
                    userInfoSession = currentSession;
                }
            } else
            {
                user = null;
                if (userInfoChangedCallback != null)
                {
                    userInfoChangedCallback.onUserInfoFetched(user);
                    return;
                }
            }
        }
    }

    private void finishInit()
    {
        setOnClickListener(new LoginClickListener(null));
        setButtonText();
        if (!isInEditMode())
        {
            sessionTracker = new SessionTracker(getContext(), new LoginButtonCallback(null), null, false);
            fetchUserInfo();
        }
    }

    private boolean initializeActiveSessionWithCachedToken(Context context)
    {
        if (context != null)
        {
            Session session = Session.getActiveSession();
            if (session != null)
            {
                return session.isOpened();
            }
            if (Utility.getMetadataApplicationId(context) != null && Session.openActiveSessionFromCache(context) != null)
            {
                return true;
            }
        }
        return false;
    }

    private void parseAttributes(AttributeSet attributeset)
    {
        attributeset = getContext().obtainStyledAttributes(attributeset, com.facebook.android.R.styleable.com_facebook_login_view);
        confirmLogout = attributeset.getBoolean(0, true);
        fetchUserInfo = attributeset.getBoolean(1, true);
        loginText = attributeset.getString(2);
        logoutText = attributeset.getString(3);
        attributeset.recycle();
    }

    private void setButtonText()
    {
        if (sessionTracker != null && sessionTracker.getOpenSession() != null)
        {
            String s;
            if (logoutText != null)
            {
                s = logoutText;
            } else
            {
                s = getResources().getString(com.facebook.android.R.string.com_facebook_loginview_log_out_button);
            }
            setText(s);
            return;
        }
        String s1;
        if (loginText != null)
        {
            s1 = loginText;
        } else
        {
            s1 = getResources().getString(com.facebook.android.R.string.com_facebook_loginview_log_in_button);
        }
        setText(s1);
    }

    public void clearPermissions()
    {
        properties.clearPermissions();
    }

    public SessionDefaultAudience getDefaultAudience()
    {
        return properties.getDefaultAudience();
    }

    public SessionLoginBehavior getLoginBehavior()
    {
        return properties.getLoginBehavior();
    }

    public OnErrorListener getOnErrorListener()
    {
        return properties.getOnErrorListener();
    }

    List getPermissions()
    {
        return properties.getPermissions();
    }

    public com.facebook.Session.StatusCallback getSessionStatusCallback()
    {
        return properties.getSessionStatusCallback();
    }

    public UserInfoChangedCallback getUserInfoChangedCallback()
    {
        return userInfoChangedCallback;
    }

    void handleError(Exception exception)
    {
label0:
        {
            if (properties.onErrorListener != null)
            {
                if (!(exception instanceof FacebookException))
                {
                    break label0;
                }
                properties.onErrorListener.onError((FacebookException)exception);
            }
            return;
        }
        properties.onErrorListener.onError(new FacebookException(exception));
    }

    public boolean onActivityResult(int i, int j, Intent intent)
    {
        Session session = sessionTracker.getSession();
        if (session != null)
        {
            return session.onActivityResult((Activity)getContext(), i, j, intent);
        } else
        {
            return false;
        }
    }

    protected void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        if (sessionTracker != null && !sessionTracker.isTracking())
        {
            sessionTracker.startTracking();
            fetchUserInfo();
            setButtonText();
        }
    }

    protected void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        if (sessionTracker != null)
        {
            sessionTracker.stopTracking();
        }
    }

    public void onFinishInflate()
    {
        super.onFinishInflate();
        finishInit();
    }

    public void setApplicationId(String s)
    {
        applicationId = s;
    }

    public void setDefaultAudience(SessionDefaultAudience sessiondefaultaudience)
    {
        properties.setDefaultAudience(sessiondefaultaudience);
    }

    public void setFragment(Fragment fragment)
    {
        parentFragment = fragment;
    }

    public void setLoginBehavior(SessionLoginBehavior sessionloginbehavior)
    {
        properties.setLoginBehavior(sessionloginbehavior);
    }

    public void setOnErrorListener(OnErrorListener onerrorlistener)
    {
        properties.setOnErrorListener(onerrorlistener);
    }

    void setProperties(LoginButtonProperties loginbuttonproperties)
    {
        properties = loginbuttonproperties;
    }

    public void setPublishPermissions(List list)
    {
        properties.setPublishPermissions(list, sessionTracker.getSession());
    }

    public void setReadPermissions(List list)
    {
        properties.setReadPermissions(list, sessionTracker.getSession());
    }

    public void setSession(Session session)
    {
        sessionTracker.setSession(session);
        fetchUserInfo();
        setButtonText();
    }

    public void setSessionStatusCallback(com.facebook.Session.StatusCallback statuscallback)
    {
        properties.setSessionStatusCallback(statuscallback);
    }

    public void setUserInfoChangedCallback(UserInfoChangedCallback userinfochangedcallback)
    {
        userInfoChangedCallback = userinfochangedcallback;
    }








/*
    static GraphUser access$402(LoginButton loginbutton, GraphUser graphuser)
    {
        loginbutton.user = graphuser;
        return graphuser;
    }

*/






    private class LoginButtonProperties
    {

        private SessionAuthorizationType authorizationType;
        private SessionDefaultAudience defaultAudience;
        private SessionLoginBehavior loginBehavior;
        private OnErrorListener onErrorListener;
        private List permissions;
        private com.facebook.Session.StatusCallback sessionStatusCallback;

        private boolean validatePermissions(List list, SessionAuthorizationType sessionauthorizationtype, Session session)
        {
            if (SessionAuthorizationType.PUBLISH.equals(sessionauthorizationtype) && Utility.isNullOrEmpty(list))
            {
                throw new IllegalArgumentException("Permissions for publish actions cannot be null or empty.");
            }
            if (session != null && session.isOpened() && !Utility.isSubset(list, session.getPermissions()))
            {
                String _tmp = LoginButton.TAG;
                return false;
            } else
            {
                return true;
            }
        }

        public void clearPermissions()
        {
            permissions = null;
            authorizationType = null;
        }

        public SessionDefaultAudience getDefaultAudience()
        {
            return defaultAudience;
        }

        public SessionLoginBehavior getLoginBehavior()
        {
            return loginBehavior;
        }

        public OnErrorListener getOnErrorListener()
        {
            return onErrorListener;
        }

        List getPermissions()
        {
            return permissions;
        }

        public com.facebook.Session.StatusCallback getSessionStatusCallback()
        {
            return sessionStatusCallback;
        }

        public void setDefaultAudience(SessionDefaultAudience sessiondefaultaudience)
        {
            defaultAudience = sessiondefaultaudience;
        }

        public void setLoginBehavior(SessionLoginBehavior sessionloginbehavior)
        {
            loginBehavior = sessionloginbehavior;
        }

        public void setOnErrorListener(OnErrorListener onerrorlistener)
        {
            onErrorListener = onerrorlistener;
        }

        public void setPublishPermissions(List list, Session session)
        {
            if (SessionAuthorizationType.READ.equals(authorizationType))
            {
                throw new UnsupportedOperationException("Cannot call setPublishPermissions after setReadPermissions has been called.");
            }
            if (validatePermissions(list, SessionAuthorizationType.PUBLISH, session))
            {
                permissions = list;
                authorizationType = SessionAuthorizationType.PUBLISH;
            }
        }

        public void setReadPermissions(List list, Session session)
        {
            if (SessionAuthorizationType.PUBLISH.equals(authorizationType))
            {
                throw new UnsupportedOperationException("Cannot call setReadPermissions after setPublishPermissions has been called.");
            }
            if (validatePermissions(list, SessionAuthorizationType.READ, session))
            {
                permissions = list;
                authorizationType = SessionAuthorizationType.READ;
            }
        }

        public void setSessionStatusCallback(com.facebook.Session.StatusCallback statuscallback)
        {
            sessionStatusCallback = statuscallback;
        }







        LoginButtonProperties()
        {
            defaultAudience = SessionDefaultAudience.FRIENDS;
            permissions = Collections.emptyList();
            authorizationType = null;
            loginBehavior = SessionLoginBehavior.SSO_WITH_FALLBACK;
        }
    }


    private class _cls1
        implements com.facebook.Request.GraphUserCallback
    {

        final LoginButton this$0;
        final Session val$currentSession;

        public void onCompleted(GraphUser graphuser, Response response)
        {
            if (currentSession == sessionTracker.getOpenSession())
            {
                user = graphuser;
                if (userInfoChangedCallback != null)
                {
                    userInfoChangedCallback.onUserInfoFetched(user);
                }
            }
            if (response.getError() != null)
            {
                handleError(response.getError().getException());
            }
        }

        _cls1()
        {
            this$0 = LoginButton.this;
            currentSession = session;
            super();
        }
    }


    private class UserInfoChangedCallback
    {

        public abstract void onUserInfoFetched(GraphUser graphuser);
    }


    private class LoginClickListener
        implements android.view.View.OnClickListener
    {

        final LoginButton this$0;

        public void onClick(View view)
        {
            final Session openSession;
            Object obj;
            obj = getContext();
            openSession = sessionTracker.getOpenSession();
            if (openSession == null) goto _L2; else goto _L1
_L1:
            if (!confirmLogout) goto _L4; else goto _L3
_L3:
            String s = getResources().getString(com.facebook.android.R.string.com_facebook_loginview_log_out_action);
            String s1 = getResources().getString(com.facebook.android.R.string.com_facebook_loginview_cancel_action);
            class _cls1
                implements android.content.DialogInterface.OnClickListener
            {

                final LoginClickListener this$1;
                final Session val$openSession;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    openSession.closeAndClearTokenInformation();
                }

                _cls1()
                {
                    this$1 = LoginClickListener.this;
                    openSession = session;
                    super();
                }
            }

            if (user != null && user.getName() != null)
            {
                view = String.format(getResources().getString(com.facebook.android.R.string.com_facebook_loginview_logged_in_as), new Object[] {
                    user.getName()
                });
            } else
            {
                view = getResources().getString(com.facebook.android.R.string.com_facebook_loginview_logged_in_using_facebook);
            }
            obj = new android.app.AlertDialog.Builder(((Context) (obj)));
            ((android.app.AlertDialog.Builder) (obj)).setMessage(view).setCancelable(true).setPositiveButton(s, new _cls1()).setNegativeButton(s1, null);
            ((android.app.AlertDialog.Builder) (obj)).create().show();
_L6:
            return;
_L4:
            openSession.closeAndClearTokenInformation();
            return;
_L2:
            view = sessionTracker.getSession();
            if (view != null)
            {
                openSession = view;
                if (!view.getState().isClosed())
                {
                    continue; /* Loop/switch isn't completed */
                }
            }
            sessionTracker.setSession(null);
            openSession = (new com.facebook.Session.Builder(((Context) (obj)))).setApplicationId(applicationId).build();
            Session.setActiveSession(openSession);
            if (openSession.isOpened()) goto _L6; else goto _L5
_L5:
            if (parentFragment != null)
            {
                view = new com.facebook.Session.OpenRequest(parentFragment);
            } else
            if (obj instanceof Activity)
            {
                view = new com.facebook.Session.OpenRequest((Activity)obj);
            } else
            {
                view = null;
            }
            if (view != null)
            {
                view.setDefaultAudience(properties.defaultAudience);
                view.setPermissions(properties.permissions);
                view.setLoginBehavior(properties.loginBehavior);
                if (SessionAuthorizationType.PUBLISH.equals(properties.authorizationType))
                {
                    openSession.openForPublish(view);
                    return;
                } else
                {
                    openSession.openForRead(view);
                    return;
                }
            }
            if (true) goto _L6; else goto _L7
_L7:
        }

        private LoginClickListener()
        {
            this$0 = LoginButton.this;
            super();
        }

        LoginClickListener(_cls1 _pcls1)
        {
            this();
        }
    }


    private class LoginButtonCallback
        implements com.facebook.Session.StatusCallback
    {

        final LoginButton this$0;

        public void call(Session session, SessionState sessionstate, Exception exception)
        {
            fetchUserInfo();
            setButtonText();
            if (exception != null)
            {
                handleError(exception);
            }
            if (properties.sessionStatusCallback != null)
            {
                properties.sessionStatusCallback.call(session, sessionstate, exception);
            }
        }

        private LoginButtonCallback()
        {
            this$0 = LoginButton.this;
            super();
        }

        LoginButtonCallback(_cls1 _pcls1)
        {
            this();
        }
    }


    private class OnErrorListener
    {

        public abstract void onError(FacebookException facebookexception);
    }

}
