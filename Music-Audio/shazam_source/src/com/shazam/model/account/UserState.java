// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.model.account;

import com.shazam.b.e.a;

public final class UserState extends Enum
{

    private static final UserState $VALUES[];
    public static final UserState ANONYMOUS;
    public static final UserState EMAIL_VALIDATED;
    public static final UserState EMAIL_VALIDATED_AWAITING_CONFIG;
    public static final UserState FACEBOOK_VALIDATED;
    public static final UserState LOGGING_OUT;
    public static final UserState MIGRATED_AWAITING_CONFIG;
    public static final UserState MIGRATION_CANDIDATE;
    public static final UserState NEW;
    public static final UserState PENDING_EMAIL_VALIDATION;
    public static final UserState REGISTERED;
    public static final UserState UNAUTHORIZED;
    private final String userStateCode;

    private UserState(String s, int i, String s1)
    {
        super(s, i);
        userStateCode = s1;
    }

    public static UserState fromString(String s)
    {
        if (!a.a(s)) goto _L2; else goto _L1
_L1:
        UserState userstate = NEW;
_L4:
        return userstate;
_L2:
        UserState auserstate[] = values();
        int j = auserstate.length;
        int i = 0;
label0:
        do
        {
label1:
            {
                if (i >= j)
                {
                    break label1;
                }
                UserState userstate1 = auserstate[i];
                userstate = userstate1;
                if (userstate1.name().equalsIgnoreCase(s))
                {
                    break label0;
                }
                i++;
            }
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
        return NEW;
    }

    public static UserState valueOf(String s)
    {
        return (UserState)Enum.valueOf(com/shazam/model/account/UserState, s);
    }

    public static UserState[] values()
    {
        return (UserState[])$VALUES.clone();
    }

    public final String getUserStateCode()
    {
        return userStateCode;
    }

    static 
    {
        NEW = new UserState("NEW", 0, "0");
        REGISTERED = new UserState("REGISTERED", 1, "1");
        PENDING_EMAIL_VALIDATION = new UserState("PENDING_EMAIL_VALIDATION", 2, "2");
        EMAIL_VALIDATED = new UserState("EMAIL_VALIDATED", 3, "3");
        EMAIL_VALIDATED_AWAITING_CONFIG = new UserState("EMAIL_VALIDATED_AWAITING_CONFIG", 4, "4");
        FACEBOOK_VALIDATED = new UserState("FACEBOOK_VALIDATED", 5, "5");
        ANONYMOUS = new UserState("ANONYMOUS", 6, "6");
        MIGRATION_CANDIDATE = new UserState("MIGRATION_CANDIDATE", 7, "7");
        MIGRATED_AWAITING_CONFIG = new UserState("MIGRATED_AWAITING_CONFIG", 8, "8");
        LOGGING_OUT = new UserState("LOGGING_OUT", 9, "9");
        UNAUTHORIZED = new UserState("UNAUTHORIZED", 10, "10");
        $VALUES = (new UserState[] {
            NEW, REGISTERED, PENDING_EMAIL_VALIDATION, EMAIL_VALIDATED, EMAIL_VALIDATED_AWAITING_CONFIG, FACEBOOK_VALIDATED, ANONYMOUS, MIGRATION_CANDIDATE, MIGRATED_AWAITING_CONFIG, LOGGING_OUT, 
            UNAUTHORIZED
        });
    }
}
