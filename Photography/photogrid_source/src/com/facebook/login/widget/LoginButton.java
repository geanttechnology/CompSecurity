// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.login.widget;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookButtonBase;
import com.facebook.FacebookCallback;
import com.facebook.FacebookSdk;
import com.facebook.internal.Utility;
import com.facebook.login.DefaultAudience;
import com.facebook.login.LoginBehavior;
import com.facebook.login.LoginManager;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;

// Referenced classes of package com.facebook.login.widget:
//            ToolTipPopup

public class LoginButton extends FacebookButtonBase
{

    private static final int DEFAULT_REQUEST_CODE;
    private static final String TAG = com/facebook/login/widget/LoginButton.getName();
    private AccessTokenTracker accessTokenTracker;
    private boolean confirmLogout;
    private String loginLogoutEventName;
    private LoginManager loginManager;
    private String loginText;
    private String logoutText;
    private LoginButtonProperties properties;
    private boolean toolTipChecked;
    private long toolTipDisplayTime;
    private ToolTipMode toolTipMode;
    private ToolTipPopup toolTipPopup;
    private ToolTipPopup.Style toolTipStyle;

    public LoginButton(Context context)
    {
        super(context, null, 0, 0, "fb_login_button_create", DEFAULT_REQUEST_CODE);
        properties = new LoginButtonProperties();
        loginLogoutEventName = "fb_login_view_usage";
        toolTipStyle = ToolTipPopup.Style.BLUE;
        toolTipDisplayTime = 6000L;
    }

    public LoginButton(Context context, AttributeSet attributeset)
    {
        super(context, attributeset, 0, 0, "fb_login_button_create", DEFAULT_REQUEST_CODE);
        properties = new LoginButtonProperties();
        loginLogoutEventName = "fb_login_view_usage";
        toolTipStyle = ToolTipPopup.Style.BLUE;
        toolTipDisplayTime = 6000L;
    }

    public LoginButton(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i, 0, "fb_login_button_create", DEFAULT_REQUEST_CODE);
        properties = new LoginButtonProperties();
        loginLogoutEventName = "fb_login_view_usage";
        toolTipStyle = ToolTipPopup.Style.BLUE;
        toolTipDisplayTime = 6000L;
    }

    private void checkToolTipSettings()
    {
        switch (_cls3..SwitchMap.com.facebook.login.widget.LoginButton.ToolTipMode[toolTipMode.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            final String appId = Utility.getMetadataApplicationId(getContext());
            FacebookSdk.getExecutor().execute(new _cls1());
            return;

        case 2: // '\002'
            displayToolTip(getResources().getString(com.facebook.R.string.com_facebook_tooltip_default));
            break;
        }
    }

    private void displayToolTip(String s)
    {
        toolTipPopup = new ToolTipPopup(s, this);
        toolTipPopup.setStyle(toolTipStyle);
        toolTipPopup.setNuxDisplayTime(toolTipDisplayTime);
        toolTipPopup.show();
    }

    private int measureButtonWidth(String s)
    {
        return measureTextWidth(s) + (getCompoundPaddingLeft() + getCompoundDrawablePadding()) + getCompoundPaddingRight();
    }

    private void parseLoginButtonAttributes(Context context, AttributeSet attributeset, int i, int j)
    {
        toolTipMode = ToolTipMode.DEFAULT;
        context = context.getTheme().obtainStyledAttributes(attributeset, com.facebook.R.styleable.com_facebook_login_view, i, j);
        confirmLogout = context.getBoolean(com.facebook.R.styleable.com_facebook_login_view_confirm_logout, true);
        loginText = context.getString(com.facebook.R.styleable.com_facebook_login_view_login_text);
        logoutText = context.getString(com.facebook.R.styleable.com_facebook_login_view_logout_text);
        toolTipMode = ToolTipMode.fromInt(context.getInt(com.facebook.R.styleable.com_facebook_login_view_tooltip_mode, ToolTipMode.DEFAULT.getValue()));
        context.recycle();
        return;
        attributeset;
        context.recycle();
        throw attributeset;
    }

    private void setButtonText()
    {
        Resources resources = getResources();
        if (AccessToken.getCurrentAccessToken() != null)
        {
            String s;
            if (logoutText != null)
            {
                s = logoutText;
            } else
            {
                s = resources.getString(com.facebook.R.string.com_facebook_loginview_log_out_button);
            }
            setText(s);
            return;
        }
        if (loginText != null)
        {
            setText(loginText);
            return;
        }
        String s2 = resources.getString(com.facebook.R.string.com_facebook_loginview_log_in_button_long);
        int i = getWidth();
        String s1 = s2;
        if (i != 0)
        {
            s1 = s2;
            if (measureButtonWidth(s2) > i)
            {
                s1 = resources.getString(com.facebook.R.string.com_facebook_loginview_log_in_button);
            }
        }
        setText(s1);
    }

    private void showToolTipPerSettings(com.facebook.internal.Utility.FetchedAppSettings fetchedappsettings)
    {
        if (fetchedappsettings != null && fetchedappsettings.getNuxEnabled() && getVisibility() == 0)
        {
            displayToolTip(fetchedappsettings.getNuxContent());
        }
    }

    public void clearPermissions()
    {
        properties.clearPermissions();
    }

    protected void configureButton(Context context, AttributeSet attributeset, int i, int j)
    {
        super.configureButton(context, attributeset, i, j);
        setInternalOnClickListener(new LoginClickListener(null));
        parseLoginButtonAttributes(context, attributeset, i, j);
        if (isInEditMode())
        {
            setBackgroundColor(getResources().getColor(com.facebook.R.color.com_facebook_blue));
            loginText = "Log in with Facebook";
        } else
        {
            accessTokenTracker = new _cls2();
        }
        setButtonText();
    }

    public void dismissToolTip()
    {
        if (toolTipPopup != null)
        {
            toolTipPopup.dismiss();
            toolTipPopup = null;
        }
    }

    public DefaultAudience getDefaultAudience()
    {
        return properties.getDefaultAudience();
    }

    protected int getDefaultStyleResource()
    {
        return com.facebook.R.style.com_facebook_loginview_default_style;
    }

    public LoginBehavior getLoginBehavior()
    {
        return properties.getLoginBehavior();
    }

    LoginManager getLoginManager()
    {
        if (loginManager == null)
        {
            loginManager = LoginManager.getInstance();
        }
        return loginManager;
    }

    List getPermissions()
    {
        return properties.getPermissions();
    }

    public long getToolTipDisplayTime()
    {
        return toolTipDisplayTime;
    }

    public ToolTipMode getToolTipMode()
    {
        return toolTipMode;
    }

    protected void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        if (accessTokenTracker != null && !accessTokenTracker.isTracking())
        {
            accessTokenTracker.startTracking();
            setButtonText();
        }
    }

    protected void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        if (accessTokenTracker != null)
        {
            accessTokenTracker.stopTracking();
        }
        dismissToolTip();
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        if (!toolTipChecked && !isInEditMode())
        {
            toolTipChecked = true;
            checkToolTipSettings();
        }
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l)
    {
        super.onLayout(flag, i, j, k, l);
        setButtonText();
    }

    protected void onMeasure(int i, int j)
    {
        Object obj = getPaint().getFontMetrics();
        j = getCompoundPaddingTop();
        float f = Math.abs(((android.graphics.Paint.FontMetrics) (obj)).top);
        int k = (int)Math.ceil(Math.abs(((android.graphics.Paint.FontMetrics) (obj)).bottom) + f);
        int l = getCompoundPaddingBottom();
        Resources resources = getResources();
        String s = loginText;
        obj = s;
        if (s == null)
        {
            obj = resources.getString(com.facebook.R.string.com_facebook_loginview_log_in_button_long);
            int i1 = measureButtonWidth(((String) (obj)));
            if (resolveSize(i1, i) < i1)
            {
                obj = resources.getString(com.facebook.R.string.com_facebook_loginview_log_in_button);
            }
        }
        int j1 = measureButtonWidth(((String) (obj)));
        s = logoutText;
        obj = s;
        if (s == null)
        {
            obj = resources.getString(com.facebook.R.string.com_facebook_loginview_log_out_button);
        }
        setMeasuredDimension(resolveSize(Math.max(j1, measureButtonWidth(((String) (obj)))), i), l + (k + j));
    }

    protected void onVisibilityChanged(View view, int i)
    {
        super.onVisibilityChanged(view, i);
        if (i != 0)
        {
            dismissToolTip();
        }
    }

    public void registerCallback(CallbackManager callbackmanager, FacebookCallback facebookcallback)
    {
        getLoginManager().registerCallback(callbackmanager, facebookcallback);
    }

    public void registerCallback(CallbackManager callbackmanager, FacebookCallback facebookcallback, int i)
    {
        setRequestCode(i);
        registerCallback(callbackmanager, facebookcallback);
    }

    public void setDefaultAudience(DefaultAudience defaultaudience)
    {
        properties.setDefaultAudience(defaultaudience);
    }

    public void setLoginBehavior(LoginBehavior loginbehavior)
    {
        properties.setLoginBehavior(loginbehavior);
    }

    void setLoginManager(LoginManager loginmanager)
    {
        loginManager = loginmanager;
    }

    void setProperties(LoginButtonProperties loginbuttonproperties)
    {
        properties = loginbuttonproperties;
    }

    public void setPublishPermissions(List list)
    {
        properties.setPublishPermissions(list);
    }

    public transient void setPublishPermissions(String as[])
    {
        properties.setPublishPermissions(Arrays.asList(as));
    }

    public void setReadPermissions(List list)
    {
        properties.setReadPermissions(list);
    }

    public transient void setReadPermissions(String as[])
    {
        properties.setReadPermissions(Arrays.asList(as));
    }

    public void setToolTipDisplayTime(long l)
    {
        toolTipDisplayTime = l;
    }

    public void setToolTipMode(ToolTipMode tooltipmode)
    {
        toolTipMode = tooltipmode;
    }

    public void setToolTipStyle(ToolTipPopup.Style style)
    {
        toolTipStyle = style;
    }

    static 
    {
        DEFAULT_REQUEST_CODE = com.facebook.internal.CallbackManagerImpl.RequestCodeOffset.Login.toRequestCode();
    }











    private class LoginButtonProperties
    {

        private LoginAuthorizationType authorizationType;
        private DefaultAudience defaultAudience;
        private LoginBehavior loginBehavior;
        private List permissions;

        private boolean validatePermissions(List list, LoginAuthorizationType loginauthorizationtype)
        {
            if (LoginAuthorizationType.PUBLISH.equals(loginauthorizationtype) && Utility.isNullOrEmpty(list))
            {
                throw new IllegalArgumentException("Permissions for publish actions cannot be null or empty.");
            }
            loginauthorizationtype = AccessToken.getCurrentAccessToken();
            if (loginauthorizationtype != null && !Utility.isSubset(list, loginauthorizationtype.getPermissions()))
            {
                Log.e(LoginButton.TAG, "Cannot set additional permissions with existing AccessToken.");
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

        public DefaultAudience getDefaultAudience()
        {
            return defaultAudience;
        }

        public LoginBehavior getLoginBehavior()
        {
            return loginBehavior;
        }

        List getPermissions()
        {
            return permissions;
        }

        public void setDefaultAudience(DefaultAudience defaultaudience)
        {
            defaultAudience = defaultaudience;
        }

        public void setLoginBehavior(LoginBehavior loginbehavior)
        {
            loginBehavior = loginbehavior;
        }

        public void setPublishPermissions(List list)
        {
            if (LoginAuthorizationType.READ.equals(authorizationType))
            {
                throw new UnsupportedOperationException("Cannot call setPublishPermissions after setReadPermissions has been called.");
            }
            if (validatePermissions(list, LoginAuthorizationType.PUBLISH))
            {
                permissions = list;
                authorizationType = LoginAuthorizationType.PUBLISH;
            }
        }

        public void setReadPermissions(List list)
        {
            if (LoginAuthorizationType.PUBLISH.equals(authorizationType))
            {
                throw new UnsupportedOperationException("Cannot call setReadPermissions after setPublishPermissions has been called.");
            }
            if (validatePermissions(list, LoginAuthorizationType.READ))
            {
                permissions = list;
                authorizationType = LoginAuthorizationType.READ;
            }
        }



        LoginButtonProperties()
        {
            defaultAudience = DefaultAudience.FRIENDS;
            permissions = Collections.emptyList();
            authorizationType = null;
            loginBehavior = LoginBehavior.SSO_WITH_FALLBACK;
        }
    }


    private class _cls3
    {

        static final int $SwitchMap$com$facebook$login$widget$LoginButton$ToolTipMode[];

        static 
        {
            $SwitchMap$com$facebook$login$widget$LoginButton$ToolTipMode = new int[ToolTipMode.values().length];
            try
            {
                $SwitchMap$com$facebook$login$widget$LoginButton$ToolTipMode[ToolTipMode.AUTOMATIC.ordinal()] = 1;
            }
            catch (NoSuchFieldError nosuchfielderror2) { }
            try
            {
                $SwitchMap$com$facebook$login$widget$LoginButton$ToolTipMode[ToolTipMode.DISPLAY_ALWAYS.ordinal()] = 2;
            }
            catch (NoSuchFieldError nosuchfielderror1) { }
            try
            {
                $SwitchMap$com$facebook$login$widget$LoginButton$ToolTipMode[ToolTipMode.NEVER_DISPLAY.ordinal()] = 3;
            }
            catch (NoSuchFieldError nosuchfielderror)
            {
                return;
            }
        }
    }


    private class ToolTipMode extends Enum
    {

        private static final ToolTipMode $VALUES[];
        public static final ToolTipMode AUTOMATIC;
        public static ToolTipMode DEFAULT;
        public static final ToolTipMode DISPLAY_ALWAYS;
        public static final ToolTipMode NEVER_DISPLAY;
        private int intValue;
        private String stringValue;

        public static ToolTipMode fromInt(int i)
        {
            ToolTipMode atooltipmode[] = values();
            int k = atooltipmode.length;
            for (int j = 0; j < k; j++)
            {
                ToolTipMode tooltipmode = atooltipmode[j];
                if (tooltipmode.getValue() == i)
                {
                    return tooltipmode;
                }
            }

            return null;
        }

        public static ToolTipMode valueOf(String s)
        {
            return (ToolTipMode)Enum.valueOf(com/facebook/login/widget/LoginButton$ToolTipMode, s);
        }

        public static ToolTipMode[] values()
        {
            return (ToolTipMode[])$VALUES.clone();
        }

        public final int getValue()
        {
            return intValue;
        }

        public final String toString()
        {
            return stringValue;
        }

        static 
        {
            AUTOMATIC = new ToolTipMode("AUTOMATIC", 0, "automatic", 0);
            DISPLAY_ALWAYS = new ToolTipMode("DISPLAY_ALWAYS", 1, "display_always", 1);
            NEVER_DISPLAY = new ToolTipMode("NEVER_DISPLAY", 2, "never_display", 2);
            $VALUES = (new ToolTipMode[] {
                AUTOMATIC, DISPLAY_ALWAYS, NEVER_DISPLAY
            });
            DEFAULT = AUTOMATIC;
        }

        private ToolTipMode(String s, int i, String s1, int j)
        {
            super(s, i);
            stringValue = s1;
            intValue = j;
        }
    }


    private class _cls1
        implements Runnable
    {

        final LoginButton this$0;
        final String val$appId;

        public void run()
        {
            final com.facebook.internal.Utility.FetchedAppSettings settings = Utility.queryAppSettings(appId, false);
            class _cls1
                implements Runnable
            {

                final _cls1 this$1;
                final com.facebook.internal.Utility.FetchedAppSettings val$settings;

                public void run()
                {
                    showToolTipPerSettings(settings);
                }

                _cls1()
                {
                    this$1 = _cls1.this;
                    settings = fetchedappsettings;
                    super();
                }
            }

            getActivity().runOnUiThread(new _cls1());
        }

        _cls1()
        {
            this$0 = LoginButton.this;
            appId = s;
            super();
        }
    }


    private class LoginClickListener
        implements android.view.View.OnClickListener
    {

        final LoginButton this$0;

        public void onClick(View view)
        {
            Object obj2 = getContext();
            AccessToken accesstoken = AccessToken.getCurrentAccessToken();
            int i;
            if (accesstoken != null)
            {
                if (confirmLogout)
                {
                    Object obj1 = getResources().getString(com.facebook.R.string.com_facebook_loginview_log_out_action);
                    String s = getResources().getString(com.facebook.R.string.com_facebook_loginview_cancel_action);
                    Object obj = Profile.getCurrentProfile();
                    class _cls1
                        implements android.content.DialogInterface.OnClickListener
                    {

                        final LoginClickListener this$1;

                        public void onClick(DialogInterface dialoginterface, int j)
                        {
                            getLoginManager().logOut();
                        }

                _cls1()
                {
                    this$1 = LoginClickListener.this;
                    super();
                }
                    }

                    if (obj != null && ((Profile) (obj)).getName() != null)
                    {
                        obj = String.format(getResources().getString(com.facebook.R.string.com_facebook_loginview_logged_in_as), new Object[] {
                            ((Profile) (obj)).getName()
                        });
                    } else
                    {
                        obj = getResources().getString(com.facebook.R.string.com_facebook_loginview_logged_in_using_facebook);
                    }
                    obj2 = new android.app.AlertDialog.Builder(((Context) (obj2)));
                    ((android.app.AlertDialog.Builder) (obj2)).setMessage(((CharSequence) (obj))).setCancelable(true).setPositiveButton(((CharSequence) (obj1)), new _cls1()).setNegativeButton(s, null);
                    ((android.app.AlertDialog.Builder) (obj2)).create().show();
                } else
                {
                    getLoginManager().logOut();
                }
            } else
            {
                LoginManager loginmanager = getLoginManager();
                loginmanager.setDefaultAudience(getDefaultAudience());
                loginmanager.setLoginBehavior(getLoginBehavior());
                if (LoginAuthorizationType.PUBLISH.equals(properties.authorizationType))
                {
                    if (getFragment() != null)
                    {
                        loginmanager.logInWithPublishPermissions(getFragment(), properties.permissions);
                    } else
                    {
                        loginmanager.logInWithPublishPermissions(getActivity(), properties.permissions);
                    }
                } else
                if (getFragment() != null)
                {
                    loginmanager.logInWithReadPermissions(getFragment(), properties.permissions);
                } else
                {
                    loginmanager.logInWithReadPermissions(getActivity(), properties.permissions);
                }
            }
            obj = AppEventsLogger.newLogger(getContext());
            obj1 = new Bundle();
            if (accesstoken != null)
            {
                i = 0;
            } else
            {
                i = 1;
            }
            ((Bundle) (obj1)).putInt("logging_in", i);
            ((AppEventsLogger) (obj)).logSdkEvent(loginLogoutEventName, null, ((Bundle) (obj1)));
            callExternalOnClickListener(view);
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


    private class _cls2 extends AccessTokenTracker
    {

        final LoginButton this$0;

        protected void onCurrentAccessTokenChanged(AccessToken accesstoken, AccessToken accesstoken1)
        {
            setButtonText();
        }

        _cls2()
        {
            this$0 = LoginButton.this;
            super();
        }
    }

}
