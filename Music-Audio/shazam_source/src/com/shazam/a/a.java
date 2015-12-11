// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.a;

import com.shazam.h.o;
import com.shazam.server.request.account.EmailAuthenticationRequest;
import com.shazam.server.request.account.FacebookAuthenticationRequest;
import com.shazam.server.request.account.LinkThirdPartyRequest;
import com.shazam.server.request.account.UnlinkThirdPartyRequest;
import com.shazam.server.request.auth.DeauthorizeRequest;
import com.shazam.server.request.auth.EmailValidationRequest;
import com.shazam.server.response.account.FacebookAuthentication;
import com.shazam.server.response.auth.EmailValidation;
import com.shazam.server.response.auth.Registration;
import com.shazam.server.response.user.User;

public interface a
{

    public abstract o a(String s);

    public abstract FacebookAuthentication a(FacebookAuthenticationRequest facebookauthenticationrequest);

    public abstract EmailValidation a(EmailValidationRequest emailvalidationrequest);

    public abstract Registration a();

    public abstract Registration a(DeauthorizeRequest deauthorizerequest);

    public abstract void a(EmailAuthenticationRequest emailauthenticationrequest);

    public abstract void a(LinkThirdPartyRequest linkthirdpartyrequest);

    public abstract void a(UnlinkThirdPartyRequest unlinkthirdpartyrequest);

    public abstract User b();

    public abstract void b(String s);
}
