// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.a;

import com.shazam.f.a.a;
import com.shazam.f.a.b;
import com.shazam.f.a.e;
import com.shazam.f.a.f;
import com.shazam.f.a.g;
import com.shazam.f.a.h;
import com.shazam.f.a.i;
import com.shazam.h.j;
import com.shazam.h.k;
import com.shazam.h.o;
import com.shazam.h.r;
import com.shazam.j.c;
import com.shazam.model.configuration.AuthConfiguration;
import com.shazam.model.configuration.InstallationIdRepository;
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

// Referenced classes of package com.shazam.a:
//            a, f

public final class d
    implements com.shazam.a.a
{

    private final AuthConfiguration a;
    private final com.shazam.h.i b;
    private final InstallationIdRepository c;
    private final com.shazam.a.f d;

    public d(AuthConfiguration authconfiguration, com.shazam.h.i l, InstallationIdRepository installationidrepository, com.shazam.a.f f1)
    {
        a = authconfiguration;
        b = l;
        c = installationidrepository;
        d = f1;
    }

    private void a(o o1, Exception exception)
    {
        if (d.a(o1))
        {
            throw new i("Request unauthorized: Auth token expired?");
        } else
        {
            throw exception;
        }
    }

    public final o a(String s)
    {
        Object obj;
        obj = a.a(s);
        s = (new StringBuilder("Could not register upgrade via ")).append(obj).toString();
        obj = b.b(((java.net.URL) (obj)));
        ((o) (obj)).a;
        JVM INSTR lookupswitch 2: default 106
    //                   200: 104
    //                   456: 88;
           goto _L1 _L2 _L3
_L1:
        throw new h(s);
_L3:
        try
        {
            a(((o) (obj)), ((Exception) (new h(s))));
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new h(s, ((Exception) (obj)));
        }
          goto _L1
_L2:
        return ((o) (obj));
    }

    public final FacebookAuthentication a(FacebookAuthenticationRequest facebookauthenticationrequest)
    {
        String s;
        java.net.URL url;
        url = a.c();
        s = (new StringBuilder("Error performing auth with Facebook via ")).append(url).toString();
        facebookauthenticationrequest = (FacebookAuthentication)b.a(url, facebookauthenticationrequest, r.a, com/shazam/server/response/account/FacebookAuthentication);
        return facebookauthenticationrequest;
        facebookauthenticationrequest;
        facebookauthenticationrequest.a().a;
        JVM INSTR tableswitch 456 456: default 76
    //                   456 86;
           goto _L1 _L2
_L1:
        throw new com.shazam.f.a.d(s, facebookauthenticationrequest);
_L2:
        a(facebookauthenticationrequest.a(), ((Exception) (new com.shazam.f.a.d(s, facebookauthenticationrequest))));
        if (true) goto _L1; else goto _L3
_L3:
        facebookauthenticationrequest;
        throw new com.shazam.f.a.d(s, facebookauthenticationrequest);
    }

    public final EmailValidation a(EmailValidationRequest emailvalidationrequest)
    {
        String s;
        java.net.URL url;
        url = a.d();
        s = (new StringBuilder("Error validating email via ")).append(url).toString();
        emailvalidationrequest = (EmailValidation)b.a(url, emailvalidationrequest, r.a, com/shazam/server/response/auth/EmailValidation);
        return emailvalidationrequest;
        emailvalidationrequest;
        emailvalidationrequest.a().a;
        JVM INSTR tableswitch 456 456: default 76
    //                   456 86;
           goto _L1 _L2
_L1:
        throw new com.shazam.f.a.c(s, emailvalidationrequest);
_L2:
        a(emailvalidationrequest.a(), ((Exception) (new com.shazam.f.a.c(s, emailvalidationrequest))));
        if (true) goto _L1; else goto _L3
_L3:
        emailvalidationrequest;
        throw new com.shazam.f.a.c(s, emailvalidationrequest);
    }

    public final Registration a()
    {
        Object obj;
        String s;
        obj = a.a();
        s = (new StringBuilder("Could not register app via ")).append(obj).toString();
        if (c.a())
        {
            com.shazam.server.request.account.RegisterRequest registerrequest = com.shazam.server.request.account.RegisterRequest.Builder.registerRequest().withInid(c.b()).build();
            return (Registration)b.a(((java.net.URL) (obj)), registerrequest, r.a, com/shazam/server/response/auth/Registration);
        }
        obj = (Registration)b.c(((java.net.URL) (obj)), com/shazam/server/response/auth/Registration);
        return ((Registration) (obj));
        Object obj1;
        obj1;
_L2:
        throw new g(s, ((Exception) (obj1)));
        obj1;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public final Registration a(DeauthorizeRequest deauthorizerequest)
    {
        String s;
        java.net.URL url;
        url = a.h();
        s = (new StringBuilder("Error deauthorizing via ")).append(url).toString();
        deauthorizerequest = (Registration)b.a(url, deauthorizerequest, r.a, com/shazam/server/response/auth/Registration);
        return deauthorizerequest;
        deauthorizerequest;
        deauthorizerequest.a().a;
        JVM INSTR tableswitch 456 456: default 76
    //                   456 86;
           goto _L1 _L2
_L1:
        throw new a(s, deauthorizerequest);
_L2:
        a(deauthorizerequest.a(), ((Exception) (new a(s, deauthorizerequest))));
        if (true) goto _L1; else goto _L3
_L3:
        deauthorizerequest;
        throw new a(s, deauthorizerequest);
    }

    public final void a(EmailAuthenticationRequest emailauthenticationrequest)
    {
        String s;
        java.net.URL url;
        url = a.b();
        s = (new StringBuilder("Error authenticating email via ")).append(url).toString();
        emailauthenticationrequest = b.b(url, emailauthenticationrequest, r.a);
        ((o) (emailauthenticationrequest)).a;
        JVM INSTR lookupswitch 2: default 113
    //                   200: 112
    //                   456: 92;
           goto _L1 _L2 _L3
_L1:
        throw new b(s);
_L3:
        try
        {
            a(((o) (emailauthenticationrequest)), ((Exception) (new b(s))));
            continue; /* Loop/switch isn't completed */
        }
        // Misplaced declaration of an exception variable
        catch (EmailAuthenticationRequest emailauthenticationrequest) { }
        // Misplaced declaration of an exception variable
        catch (EmailAuthenticationRequest emailauthenticationrequest) { }
        throw new b(s, emailauthenticationrequest);
_L2:
        return;
        if (true) goto _L1; else goto _L4
_L4:
    }

    public final void a(LinkThirdPartyRequest linkthirdpartyrequest)
    {
        String s;
        java.net.URL url;
        url = a.e();
        s = (new StringBuilder("Error linking third party via ")).append(url).toString();
        linkthirdpartyrequest = b.b(url, linkthirdpartyrequest, r.a);
        ((o) (linkthirdpartyrequest)).a;
        JVM INSTR lookupswitch 2: default 113
    //                   204: 112
    //                   456: 92;
           goto _L1 _L2 _L3
_L1:
        throw new e(s);
_L3:
        try
        {
            a(((o) (linkthirdpartyrequest)), ((Exception) (new e(s))));
            continue; /* Loop/switch isn't completed */
        }
        // Misplaced declaration of an exception variable
        catch (LinkThirdPartyRequest linkthirdpartyrequest) { }
        // Misplaced declaration of an exception variable
        catch (LinkThirdPartyRequest linkthirdpartyrequest) { }
        throw new e(s, linkthirdpartyrequest);
_L2:
        return;
        if (true) goto _L1; else goto _L4
_L4:
    }

    public final void a(UnlinkThirdPartyRequest unlinkthirdpartyrequest)
    {
        String s;
        java.net.URL url;
        url = a.f();
        s = (new StringBuilder("Error unlinking third party via ")).append(url).toString();
        unlinkthirdpartyrequest = b.b(url, unlinkthirdpartyrequest, r.a);
        ((o) (unlinkthirdpartyrequest)).a;
        JVM INSTR lookupswitch 2: default 113
    //                   204: 112
    //                   456: 92;
           goto _L1 _L2 _L3
_L1:
        throw new com.shazam.f.a.j(s);
_L3:
        try
        {
            a(((o) (unlinkthirdpartyrequest)), ((Exception) (new com.shazam.f.a.j(s))));
            continue; /* Loop/switch isn't completed */
        }
        // Misplaced declaration of an exception variable
        catch (UnlinkThirdPartyRequest unlinkthirdpartyrequest) { }
        // Misplaced declaration of an exception variable
        catch (UnlinkThirdPartyRequest unlinkthirdpartyrequest) { }
        throw new com.shazam.f.a.j(s, unlinkthirdpartyrequest);
_L2:
        return;
        if (true) goto _L1; else goto _L4
_L4:
    }

    public final User b()
    {
        String s;
        Object obj;
        obj = a.i();
        s = (new StringBuilder("Error retrieving user details via ")).append(obj).toString();
        obj = (User)b.a(((java.net.URL) (obj)), com/shazam/server/response/user/User);
        return ((User) (obj));
        j j1;
        j1;
        j1.a().a;
        JVM INSTR tableswitch 456 456: default 72
    //                   456 82;
           goto _L1 _L2
_L1:
        throw new com.shazam.f.i.a(s, j1);
_L2:
        a(j1.a(), new com.shazam.f.i.a(s, j1));
        if (true) goto _L1; else goto _L3
_L3:
    }

    public final void b(String s)
    {
        String s1;
        java.net.URL url;
        url = a.g();
        s1 = (new StringBuilder("Error logging out via ")).append(url).toString();
        com.shazam.h.l.a a1 = new com.shazam.h.l.a();
        a1.e = k.b;
        a1.a = url;
        if (com.shazam.b.e.a.c(s))
        {
            a1.a(com.shazam.o.k.a("X-Shazam-AMPKey", s));
        }
        s = b.a(a1.a());
        ((o) (s)).a;
        JVM INSTR lookupswitch 2: default 153
    //                   200: 152
    //                   456: 136;
           goto _L1 _L2 _L3
_L1:
        throw new f(s1);
_L3:
        try
        {
            a(s, new f(s1));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new f(s1, s);
        }
          goto _L1
_L2:
    }
}
