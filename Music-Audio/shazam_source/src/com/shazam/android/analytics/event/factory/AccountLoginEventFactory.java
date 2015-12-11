// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.analytics.event.factory;

import com.shazam.android.analytics.event.BeaconErrorCode;
import com.shazam.android.analytics.event.Event;
import com.shazam.model.analytics.event.DefinedEventParameterKey;

// Referenced classes of package com.shazam.android.analytics.event.factory:
//            UserEventEventFactory

public class AccountLoginEventFactory
{
    public static final class AccountLoginProviderName extends Enum
    {

        private static final AccountLoginProviderName $VALUES[];
        public static final AccountLoginProviderName EMAIL;
        public static final AccountLoginProviderName FACEBOOK;
        private final String name;

        public static AccountLoginProviderName valueOf(String s)
        {
            return (AccountLoginProviderName)Enum.valueOf(com/shazam/android/analytics/event/factory/AccountLoginEventFactory$AccountLoginProviderName, s);
        }

        public static AccountLoginProviderName[] values()
        {
            return (AccountLoginProviderName[])$VALUES.clone();
        }

        public final String getName()
        {
            return name;
        }

        static 
        {
            FACEBOOK = new AccountLoginProviderName("FACEBOOK", 0, "fb");
            EMAIL = new AccountLoginProviderName("EMAIL", 1, "email");
            $VALUES = (new AccountLoginProviderName[] {
                FACEBOOK, EMAIL
            });
        }

        private AccountLoginProviderName(String s, int i, String s1)
        {
            super(s, i);
            name = s1;
        }
    }


    public AccountLoginEventFactory()
    {
    }

    public static Event cancel()
    {
        return eventWithAction("cancel");
    }

    public static Event cancel(AccountLoginProviderName accountloginprovidername, String s)
    {
        return eventWithProviderOriginAndAction(accountloginprovidername, s, "cancel");
    }

    public static Event checkEmail()
    {
        return eventWithAction("checkemail");
    }

    private static com.shazam.android.analytics.event.EventParameters.Builder commonEventParametersWith(String s, String s1)
    {
        return com.shazam.android.analytics.event.EventParameters.Builder.eventParameters().putNotEmptyOrNullParameter(DefinedEventParameterKey.TYPE, "accountlogin").putNotEmptyOrNullParameter(DefinedEventParameterKey.SCREEN_NAME, s1).putNotEmptyOrNullParameter(DefinedEventParameterKey.ACTION, s);
    }

    private static com.shazam.android.analytics.event.EventParameters.Builder commonEventParametersWithAction(String s)
    {
        return com.shazam.android.analytics.event.EventParameters.Builder.eventParameters().putNotEmptyOrNullParameter(DefinedEventParameterKey.TYPE, "accountlogin").putNotEmptyOrNullParameter(DefinedEventParameterKey.ACTION, s);
    }

    public static Event confirm(String s)
    {
        return UserEventEventFactory.aUserEventWith(commonEventParametersWithAction("confirm").putNotEmptyOrNullParameter(DefinedEventParameterKey.ORIGIN, s).build());
    }

    public static Event done()
    {
        return eventWithAction("done");
    }

    public static Event error(AccountLoginProviderName accountloginprovidername, BeaconErrorCode beaconerrorcode, String s)
    {
        return error(accountloginprovidername, beaconerrorcode, null, s);
    }

    public static Event error(AccountLoginProviderName accountloginprovidername, BeaconErrorCode beaconerrorcode, String s, String s1)
    {
        return UserEventEventFactory.aUserEventWith(commonEventParametersWithAction("error").putNotEmptyOrNullParameter(DefinedEventParameterKey.PROVIDER_NAME, accountloginprovidername.getName()).putNotEmptyOrNullParameter(DefinedEventParameterKey.ERROR_CODE, beaconerrorcode.getErrorCode()).putNotEmptyOrNullParameter(DefinedEventParameterKey.SCREEN_NAME, s1).putNotEmptyOrNullParameter(DefinedEventParameterKey.ORIGIN, s).build());
    }

    public static Event eventWith(String s, String s1)
    {
        return UserEventEventFactory.aUserEventWith(commonEventParametersWith(s, s1).build());
    }

    public static Event eventWithAction(String s)
    {
        return UserEventEventFactory.aUserEventWith(commonEventParametersWithAction(s).build());
    }

    private static Event eventWithProviderOriginAndAction(AccountLoginProviderName accountloginprovidername, String s, String s1)
    {
        return UserEventEventFactory.aUserEventWith(commonEventParametersWithAction(s1).putNotEmptyOrNullParameter(DefinedEventParameterKey.PROVIDER_NAME, accountloginprovidername.getName()).putNotEmptyOrNullParameter(DefinedEventParameterKey.ORIGIN, s).build());
    }

    public static Event logIn(AccountLoginProviderName accountloginprovidername)
    {
        return UserEventEventFactory.aUserEventWith(commonEventParametersWithAction("login").putNotEmptyOrNullParameter(DefinedEventParameterKey.PROVIDER_NAME, accountloginprovidername.getName()).build());
    }

    public static Event newInid(String s)
    {
        return UserEventEventFactory.aUserEventWith(commonEventParametersWithAction("newinid").putNotEmptyOrNullParameter(DefinedEventParameterKey.NEW_INID, s).build());
    }

    public static Event retry()
    {
        return eventWithAction("retry");
    }

    public static Event sendAgain(String s)
    {
        return eventWith("sendagain", s);
    }

    public static Event signUp(AccountLoginProviderName accountloginprovidername)
    {
        return UserEventEventFactory.aUserEventWith(commonEventParametersWithAction("signup").putNotEmptyOrNullParameter(DefinedEventParameterKey.PROVIDER_NAME, accountloginprovidername.getName()).build());
    }

    public static Event signUp(AccountLoginProviderName accountloginprovidername, String s)
    {
        return eventWithProviderOriginAndAction(accountloginprovidername, s, "signup");
    }

    public static Event signUpLaunched(boolean flag)
    {
        com.shazam.android.analytics.event.EventParameters.Builder builder = commonEventParametersWithAction("signuplaunched");
        DefinedEventParameterKey definedeventparameterkey = DefinedEventParameterKey.FORCED_CONFIG;
        String s;
        if (flag)
        {
            s = "1";
        } else
        {
            s = "0";
        }
        return UserEventEventFactory.aUserEventWith(builder.putNotEmptyOrNullParameter(definedeventparameterkey, s).build());
    }

    public static Event signUpLogInInitiated()
    {
        return eventWithAction("signuplogininitiated");
    }

    public static Event signUpLogInInitiated(AccountLoginProviderName accountloginprovidername)
    {
        return eventWithProviderOriginAndAction(accountloginprovidername, null, "signuplogininitiated");
    }

    public static Event skip()
    {
        return eventWithAction("skip");
    }

    public static Event success(AccountLoginProviderName accountloginprovidername)
    {
        return success(accountloginprovidername, null);
    }

    public static Event success(AccountLoginProviderName accountloginprovidername, String s)
    {
        return UserEventEventFactory.aUserEventWith(commonEventParametersWithAction("success").putNotEmptyOrNullParameter(DefinedEventParameterKey.PROVIDER_NAME, accountloginprovidername.getName()).putNotEmptyOrNullParameter(DefinedEventParameterKey.ORIGIN, s).build());
    }

    public static Event userStateChanged()
    {
        return eventWithAction("usc");
    }
}
