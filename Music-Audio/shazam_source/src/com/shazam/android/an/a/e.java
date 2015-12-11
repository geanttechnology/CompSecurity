// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.an.a;

import android.content.Context;
import android.content.Intent;
import com.rdio.android.core.RdioApiRequestArg;
import com.rdio.android.sdk.OAuth2Credential;
import com.rdio.android.sdk.Rdio;
import com.rdio.android.sdk.RdioListener;
import com.rdio.android.sdk.RdioService;
import com.shazam.android.activities.RdioSignInActivity;
import com.shazam.android.ar.b;
import com.shazam.android.service.player.o;
import com.shazam.android.service.player.z;
import com.shazam.k.a;
import com.shazam.model.account.Account;
import com.shazam.model.account.EmailAddressAccessor;
import com.shazam.model.configuration.RdioConfiguration;
import com.shazam.model.rdio.RdioCallback;
import com.shazam.model.rdio.RdioCredentials;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// Referenced classes of package com.shazam.android.an.a:
//            o, q

public final class e
    implements RdioListener, com.shazam.android.an.a.o
{

    private static Rdio a;
    private final Context b;
    private final RdioConfiguration c;
    private final o d;
    private final String e;
    private final com.shazam.b.a.a f;
    private final com.shazam.b.a.a g;
    private final com.shazam.b.a.a h;
    private final com.shazam.b.a.a i;
    private final EmailAddressAccessor j;
    private final a k;
    private final com.shazam.b.a.a l;
    private q m;
    private RdioService n;

    public e(Context context, RdioConfiguration rdioconfiguration, o o1, String s, com.shazam.b.a.a a1, com.shazam.b.a.a a2, com.shazam.b.a.a a3, 
            com.shazam.b.a.a a4, com.shazam.b.a.a a5, EmailAddressAccessor emailaddressaccessor, a a6)
    {
        m = com.shazam.android.an.a.q.a;
        b = context;
        c = rdioconfiguration;
        d = o1;
        e = s;
        f = a1;
        g = a2;
        h = a3;
        i = a4;
        j = emailaddressaccessor;
        k = a6;
        l = a5;
    }

    public final Intent a()
    {
        String s;
        String s1;
        Intent intent;
        String s2;
        try
        {
            intent = new Intent(b, com/shazam/android/activities/RdioSignInActivity);
            s2 = a.getAuthUrl(e);
            s1 = k.a().email;
        }
        catch (IOException ioexception)
        {
            throw new com.shazam.android.ar.a("Could not create authorization intent for Rdio", ioexception);
        }
        s = s1;
        if (com.shazam.b.e.a.a(s1))
        {
            s = j.a();
        }
        intent.putExtra("authUrl", (new StringBuilder()).append(s2).append("&email=").append(s).toString());
        intent.putExtra("redirectUri", e);
        return intent;
    }

    public final com.shazam.android.service.player.a a(String s)
    {
        return new z(a.getPlayerManager(), s);
    }

    public final void a(int i1, Intent intent)
    {
        if (i1 == -1)
        {
            n.processWebViewActivity(intent, e);
            a.prepareForPlayback();
        } else
        {
            if (i1 == 0)
            {
                m.c();
                return;
            }
            if (i1 == -2)
            {
                m.e();
                return;
            }
        }
    }

    public final void a(RdioCallback rdiocallback)
    {
        n.getPlaylists(null, false, Collections.singletonList("trackKeys"), false, null, new b(rdiocallback, i));
    }

    public final void a(RdioCredentials rdiocredentials, boolean flag, q q1)
    {
        m = q1;
        if (a == null && c.a() && flag)
        {
            a = new Rdio("f2hyepoju5fpdj4zrt3dmbkfam", "PbK761k7zAC478asLxVYLQ", new OAuth2Credential(rdiocredentials.accessToken, rdiocredentials.refreshToken, rdiocredentials.expirationTime), b, this);
        }
        if (a != null)
        {
            a.requestApiService();
        }
    }

    public final void a(String s, String s1, RdioCallback rdiocallback)
    {
        n.createPlaylist(s, s1, Collections.singletonList(""), 0, false, Collections.singletonList(""), false, new Object(), new b(rdiocallback, f));
    }

    public final void a(String s, List list, RdioCallback rdiocallback)
    {
        List list1;
label0:
        {
            if (list != null)
            {
                list1 = list;
                if (!list.isEmpty())
                {
                    break label0;
                }
            }
            list1 = Collections.singletonList("");
        }
        n.addToPlaylist(s, list1, new b(rdiocallback, g));
    }

    public final void b(RdioCallback rdiocallback)
    {
        n.currentUser(Arrays.asList(new String[] {
            "isTrial", "isUnlimited", "futureTimelineInfo"
        }), false, new Object(), new b(rdiocallback, h));
    }

    public final boolean b()
    {
        return a.isReady();
    }

    public final void c()
    {
        a.prepareForPlayback();
    }

    public final void c(RdioCallback rdiocallback)
    {
        RdioApiRequestArg rdioapirequestarg = new RdioApiRequestArg("method", "createMobileTrial");
        RdioService rdioservice = n;
        rdiocallback = new b(rdiocallback, l);
        rdioservice.postRequest(new RdioApiRequestArg[] {
            rdioapirequestarg
        }, rdiocallback);
    }

    public final void onApiServiceReady(RdioService rdioservice)
    {
        n = rdioservice;
    }

    public final void onError(com.rdio.android.sdk.Rdio.RdioError rdioerror, String s)
    {
        static final class _cls1
        {

            static final int a[];

            static 
            {
                a = new int[com.rdio.android.sdk.Rdio.RdioError.values().length];
                try
                {
                    a[com.rdio.android.sdk.Rdio.RdioError.AUTHORIZATION.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror) { }
            }
        }

        switch (com.shazam.android.an.a._cls1.a[rdioerror.ordinal()])
        {
        default:
            (new StringBuilder("Rdio failure: ")).append(rdioerror);
            return;

        case 1: // '\001'
            m.d();
            break;
        }
    }

    public final void onRdioAuthorised(OAuth2Credential oauth2credential)
    {
        String s = oauth2credential.accessToken;
        String s1 = oauth2credential.refreshToken;
        if (com.shazam.b.e.a.c(s) && com.shazam.b.e.a.c(s1))
        {
            q q1 = m;
            com.shazam.model.rdio.RdioCredentials.Builder builder = com.shazam.model.rdio.RdioCredentials.Builder.a();
            builder.accessToken = s;
            builder.refreshToken = s1;
            builder.expirationTime = oauth2credential.expirationTimeMSec;
            q1.a(builder.b());
            a.prepareForPlayback();
        }
    }

    public final void onRdioReadyForPlayback()
    {
    }

    public final void onRdioUserPlayingElsewhere()
    {
        d.a();
    }
}
