// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse.signpost;

import com.parse.signpost.exception.OAuthCommunicationException;
import com.parse.signpost.exception.OAuthExpectationFailedException;
import com.parse.signpost.exception.OAuthMessageSignerException;
import com.parse.signpost.http.HttpParameters;
import com.parse.signpost.http.HttpRequest;
import com.parse.signpost.signature.OAuthMessageSigner;
import com.parse.signpost.signature.SigningStrategy;
import java.io.Serializable;

public interface OAuthConsumer
    extends Serializable
{

    public abstract String getConsumerKey();

    public abstract String getConsumerSecret();

    public abstract HttpParameters getRequestParameters();

    public abstract String getToken();

    public abstract String getTokenSecret();

    public abstract void setAdditionalParameters(HttpParameters httpparameters);

    public abstract void setMessageSigner(OAuthMessageSigner oauthmessagesigner);

    public abstract void setSendEmptyTokens(boolean flag);

    public abstract void setSigningStrategy(SigningStrategy signingstrategy);

    public abstract void setTokenWithSecret(String s, String s1);

    public abstract HttpRequest sign(HttpRequest httprequest)
        throws OAuthMessageSignerException, OAuthExpectationFailedException, OAuthCommunicationException;

    public abstract HttpRequest sign(Object obj)
        throws OAuthMessageSignerException, OAuthExpectationFailedException, OAuthCommunicationException;

    public abstract String sign(String s)
        throws OAuthMessageSignerException, OAuthExpectationFailedException, OAuthCommunicationException;
}
