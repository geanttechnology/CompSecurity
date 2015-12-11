// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.kcpsdk.auth;


// Referenced classes of package com.amazon.identity.kcpsdk.auth:
//            PandaError

public final class AuthenticateAccountError extends Enum
{

    private static final AuthenticateAccountError $VALUES[];
    public static final AuthenticateAccountError AuthenticateAccountErrorChallengeException;
    public static final AuthenticateAccountError AuthenticateAccountErrorCredentialError;
    public static final AuthenticateAccountError AuthenticateAccountErrorInvalidValue;
    public static final AuthenticateAccountError AuthenticateAccountErrorMissingValue;
    public static final AuthenticateAccountError AuthenticateAccountErrorServerError;
    public static final AuthenticateAccountError AuthenticateAccountErrorServiceUnavailable;
    public static final AuthenticateAccountError AuthenticateAccountErrorUnknown;
    private final PandaError mBaseError;

    private AuthenticateAccountError(String s, int i, PandaError pandaerror)
    {
        super(s, i);
        mBaseError = pandaerror;
    }

    public static AuthenticateAccountError fromPandaError(PandaError pandaerror)
    {
        AuthenticateAccountError aauthenticateaccounterror[] = values();
        int j = aauthenticateaccounterror.length;
        for (int i = 0; i < j; i++)
        {
            AuthenticateAccountError authenticateaccounterror = aauthenticateaccounterror[i];
            if (authenticateaccounterror.mBaseError == pandaerror)
            {
                return authenticateaccounterror;
            }
        }

        return null;
    }

    public static AuthenticateAccountError valueOf(String s)
    {
        return (AuthenticateAccountError)Enum.valueOf(com/amazon/identity/kcpsdk/auth/AuthenticateAccountError, s);
    }

    public static AuthenticateAccountError[] values()
    {
        return (AuthenticateAccountError[])$VALUES.clone();
    }

    public String getErrorString()
    {
        return mBaseError.getErrorString();
    }

    public String toString()
    {
        return (new StringBuilder("[")).append(name()).append(" ").append(mBaseError.getErrorString()).append("]").toString();
    }

    static 
    {
        AuthenticateAccountErrorMissingValue = new AuthenticateAccountError("AuthenticateAccountErrorMissingValue", 0, PandaError.PandaErrorMissingValue);
        AuthenticateAccountErrorInvalidValue = new AuthenticateAccountError("AuthenticateAccountErrorInvalidValue", 1, PandaError.PandaErrorInvalidValue);
        AuthenticateAccountErrorCredentialError = new AuthenticateAccountError("AuthenticateAccountErrorCredentialError", 2, PandaError.PandaErrorCredentialError);
        AuthenticateAccountErrorServerError = new AuthenticateAccountError("AuthenticateAccountErrorServerError", 3, PandaError.PandaErrorServerError);
        AuthenticateAccountErrorServiceUnavailable = new AuthenticateAccountError("AuthenticateAccountErrorServiceUnavailable", 4, PandaError.PandaErrorServiceUnavailable);
        AuthenticateAccountErrorUnknown = new AuthenticateAccountError("AuthenticateAccountErrorUnknown", 5, PandaError.PandaErrorUnknown);
        AuthenticateAccountErrorChallengeException = new AuthenticateAccountError("AuthenticateAccountErrorChallengeException", 6, PandaError.PandaErrorChallengeException);
        $VALUES = (new AuthenticateAccountError[] {
            AuthenticateAccountErrorMissingValue, AuthenticateAccountErrorInvalidValue, AuthenticateAccountErrorCredentialError, AuthenticateAccountErrorServerError, AuthenticateAccountErrorServiceUnavailable, AuthenticateAccountErrorUnknown, AuthenticateAccountErrorChallengeException
        });
    }
}
