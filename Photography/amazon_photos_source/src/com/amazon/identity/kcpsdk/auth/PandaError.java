// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.kcpsdk.auth;


public final class PandaError extends Enum
{

    private static final PandaError $VALUES[];
    public static final PandaError PandaErrorChallengeException;
    public static final PandaError PandaErrorCredentialError;
    public static final PandaError PandaErrorInvalidValue;
    public static final PandaError PandaErrorMissingValue;
    public static final PandaError PandaErrorServerError;
    public static final PandaError PandaErrorServiceUnavailable;
    public static final PandaError PandaErrorUnknown;
    private final String mErrorString;

    private PandaError(String s, int i, String s1)
    {
        super(s, i);
        mErrorString = s1;
    }

    public static PandaError valueOf(String s)
    {
        return (PandaError)Enum.valueOf(com/amazon/identity/kcpsdk/auth/PandaError, s);
    }

    public static PandaError[] values()
    {
        return (PandaError[])$VALUES.clone();
    }

    public String getErrorString()
    {
        return mErrorString;
    }

    public String toString()
    {
        return (new StringBuilder("[")).append(name()).append(" ").append(mErrorString).append("]").toString();
    }

    static 
    {
        PandaErrorMissingValue = new PandaError("PandaErrorMissingValue", 0, "One or more required values are missing");
        PandaErrorInvalidValue = new PandaError("PandaErrorInvalidValue", 1, "One or more required valeus are invalid");
        PandaErrorCredentialError = new PandaError("PandaErrorCredentialError", 2, "Invalid credentials. The provided email or phone number and password did not match our records.");
        PandaErrorServerError = new PandaError("PandaErrorServerError", 3, "The server has encountered a runtime error");
        PandaErrorServiceUnavailable = new PandaError("PandaErrorServiceUnavailable", 4, "The service is temporarily overloaded or unavailable, try again later");
        PandaErrorUnknown = new PandaError("PandaErrorUnknown", 5, "Unknown error");
        PandaErrorChallengeException = new PandaError("PandaErrorChallengeException", 6, "Additional credentials are required");
        $VALUES = (new PandaError[] {
            PandaErrorMissingValue, PandaErrorInvalidValue, PandaErrorCredentialError, PandaErrorServerError, PandaErrorServiceUnavailable, PandaErrorUnknown, PandaErrorChallengeException
        });
    }
}
