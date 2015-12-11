// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.client;

import co.vine.android.api.VineUser;

public class Session
{
    public static final class LoginStatus extends Enum
    {

        private static final LoginStatus $VALUES[];
        public static final LoginStatus LOGGED_IN;
        public static final LoginStatus LOGGED_OUT;
        public static final LoginStatus LOGGING_IN;
        public static final LoginStatus LOGGING_OUT;

        public static LoginStatus valueOf(String s)
        {
            return (LoginStatus)Enum.valueOf(co/vine/android/client/Session$LoginStatus, s);
        }

        public static LoginStatus[] values()
        {
            return (LoginStatus[])$VALUES.clone();
        }

        static 
        {
            LOGGED_OUT = new LoginStatus("LOGGED_OUT", 0);
            LOGGING_IN = new LoginStatus("LOGGING_IN", 1);
            LOGGED_IN = new LoginStatus("LOGGED_IN", 2);
            LOGGING_OUT = new LoginStatus("LOGGING_OUT", 3);
            $VALUES = (new LoginStatus[] {
                LOGGED_OUT, LOGGING_IN, LOGGED_IN, LOGGING_OUT
            });
        }

        private LoginStatus(String s, int i)
        {
            super(s, i);
        }
    }


    private String mAvatarUrl;
    private long mLastLogin;
    private String mLoginEmail;
    private LoginStatus mLoginStatus;
    private String mName;
    private String mSessionKey;
    private VineUser mUser;
    private long mUserId;

    public Session(String s, long l, String s1, String s2, String s3)
    {
        mSessionKey = s;
        mUserId = l;
        mName = s1;
        mLoginStatus = LoginStatus.LOGGED_OUT;
        mAvatarUrl = s2;
    }

    public String getAvatarUrl()
    {
        return mAvatarUrl;
    }

    public String getLoginEmail()
    {
        return mLoginEmail;
    }

    public LoginStatus getLoginStatus()
    {
        return mLoginStatus;
    }

    public String getName()
    {
        return mName;
    }

    public String getSessionKey()
    {
        return mSessionKey;
    }

    public long getUserId()
    {
        return mUserId;
    }

    public boolean isLoggedIn()
    {
        return mLoginStatus.equals(LoginStatus.LOGGED_IN);
    }

    public void logout()
    {
        mLoginEmail = null;
        mSessionKey = null;
        mName = null;
        mUserId = 0L;
        mAvatarUrl = null;
        mLoginStatus = LoginStatus.LOGGED_OUT;
    }

    public void setAvatarUrl(String s)
    {
        mAvatarUrl = s;
    }

    public void setLoginEmail(String s)
    {
        mLoginEmail = s;
    }

    public void setLoginStatus(LoginStatus loginstatus)
    {
        mLoginStatus = loginstatus;
    }

    public void setName(String s)
    {
        mName = s;
    }

    public void setSessionKey(String s)
    {
        mSessionKey = s;
    }

    public void setUserId(long l)
    {
        mUserId = l;
    }
}
