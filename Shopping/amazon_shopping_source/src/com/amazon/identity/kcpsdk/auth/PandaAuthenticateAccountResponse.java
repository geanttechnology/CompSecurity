// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.kcpsdk.auth;


// Referenced classes of package com.amazon.identity.kcpsdk.auth:
//            AuthenticateAccountError, AuthenticationChallenge, PandaError

public class PandaAuthenticateAccountResponse
{

    private final String mAccessToken;
    private final AuthenticationChallenge mChallenge;
    private final String mDirectedId;
    private final AuthenticateAccountError mError;

    public PandaAuthenticateAccountResponse(AuthenticateAccountError authenticateaccounterror)
    {
        this(null, null, null, authenticateaccounterror);
    }

    public PandaAuthenticateAccountResponse(AuthenticationChallenge authenticationchallenge)
    {
        this(null, null, authenticationchallenge, AuthenticateAccountError.AuthenticateAccountErrorChallengeException);
    }

    public PandaAuthenticateAccountResponse(PandaError pandaerror)
    {
        this(AuthenticateAccountError.fromPandaError(pandaerror));
    }

    public PandaAuthenticateAccountResponse(String s, String s1)
    {
        this(s, s1, null, null);
    }

    private PandaAuthenticateAccountResponse(String s, String s1, AuthenticationChallenge authenticationchallenge, AuthenticateAccountError authenticateaccounterror)
    {
        mDirectedId = s;
        mAccessToken = s1;
        mChallenge = authenticationchallenge;
        mError = authenticateaccounterror;
    }

    public String getAccessToken()
    {
        return mAccessToken;
    }

    public AuthenticationChallenge getChallenge()
    {
        return mChallenge;
    }

    public String getDirectedId()
    {
        return mDirectedId;
    }

    public AuthenticateAccountError getError()
    {
        return mError;
    }

    public String toString()
    {
        if (mError != null)
        {
            return (new StringBuilder("[PandaAuthenticateAccountResponse Error: ")).append(mError).append("]").toString();
        } else
        {
            return (new StringBuilder("[PandaAuthenticateAccountResponse Success: DirectedId=")).append(mDirectedId).append("]").toString();
        }
    }
}
