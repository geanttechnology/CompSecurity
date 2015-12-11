// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.services;


public class ApplicationException extends Exception
{

    public static final String AGE_NOT_DECLARED = "Age_Not_Declared".intern();
    public static final String BLACK_CURTAIN = "Black_Curtain".intern();
    public static final String CLIENT_UPGRADE_REQUIRED = "Client_Upgrade_Required".intern();
    private static final String CODES[] = {
        AGE_NOT_DECLARED, BLACK_CURTAIN, CLIENT_UPGRADE_REQUIRED, DOB_REQUIRED, INTERNAL_ERROR, OPERATION_NO_LONGER_SUPPORTED, USER_NOT_AUTHENTICATED
    };
    public static final String DOB_REQUIRED = "DOB_Required".intern();
    private static final String EXPLANATIONS[] = {
        "Must declare age.", "Must be an adult", "App must be upgraded to the new version", "Must provide a date of birth", "Request could not be fulfilled", "Operation is disabled", "User not authenticated"
    };
    public static final String INTERNAL_ERROR = "Internal_Error".intern();
    public static final String OPERATION_NO_LONGER_SUPPORTED = "Operation_No_Longer_Supported".intern();
    public static final String USER_NOT_AUTHENTICATED = "User_Not_Authenticated".intern();
    private final String errorCode;

    public ApplicationException(String s, String s1)
    {
        super(s1);
        if (s1 == null)
        {
            throw new IllegalArgumentException("Message cannot be null");
        } else
        {
            errorCode = s.intern();
            return;
        }
    }

    private static final String explanationFromCode(String s)
    {
        for (int i = 0; i < CODES.length; i++)
        {
            if (s == CODES[i])
            {
                return EXPLANATIONS[i];
            }
        }

        return "<Unrecognized code>";
    }

    public String getErrorCode()
    {
        return errorCode;
    }

    public String toString()
    {
        String s = getMessage();
        StringBuilder stringbuilder = (new StringBuilder()).append(getClass().getName()).append(": ").append(explanationFromCode(getErrorCode()));
        if (s.equals(""))
        {
            s = "";
        } else
        {
            s = (new StringBuilder()).append(" - ").append(s).toString();
        }
        return stringbuilder.append(s).toString();
    }

}
