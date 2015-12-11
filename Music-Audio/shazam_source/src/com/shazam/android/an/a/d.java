// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.an.a;

import com.shazam.android.persistence.n.b;
import com.shazam.b.e.a;
import com.shazam.model.rdio.RdioConnectionState;
import com.shazam.model.rdio.RdioCredentials;
import com.shazam.model.rdio.RdioLegacyCredentials;
import com.shazam.model.rdio.RdioPlaylistInfo;
import com.shazam.model.streaming.SubscriptionType;

public final class d
    implements RdioConnectionState
{

    private final b a;

    public d(b b1)
    {
        a = b1;
    }

    private String a(String s)
    {
        return a.h(s);
    }

    private transient void a(String as[])
    {
        int j = as.length;
        for (int i = 0; i < j; i++)
        {
            String s = as[i];
            a.i(s);
        }

    }

    public final void a(RdioCredentials rdiocredentials)
    {
        a.b("pk_rdio_v3_access_token", rdiocredentials.accessToken);
        a.b("pk_rdio_v3_refresh_token", rdiocredentials.refreshToken);
        rdiocredentials = rdiocredentials.expirationTime;
        if (rdiocredentials != null)
        {
            a.a("pk_rdio_v3_expiration_time", rdiocredentials.longValue());
            return;
        } else
        {
            a.i("pk_rdio_v3_expiration_time");
            return;
        }
    }

    public final void a(RdioPlaylistInfo rdioplaylistinfo)
    {
        a.b("pk_rdio_playlist_key", rdioplaylistinfo.key);
        a.b("pk_rdio_playlist_uri", (new StringBuilder("rdio://")).append(rdioplaylistinfo.url).toString());
    }

    public final void a(SubscriptionType subscriptiontype)
    {
        a.b("pk_rdio_subscription_type", subscriptiontype.name());
    }

    public final boolean a()
    {
        return com.shazam.b.e.a.c(b().accessToken);
    }

    public final RdioCredentials b()
    {
        com.shazam.model.rdio.RdioCredentials.Builder builder = com.shazam.model.rdio.RdioCredentials.Builder.a();
        builder.accessToken = a("pk_rdio_v3_access_token");
        builder.refreshToken = a("pk_rdio_v3_refresh_token");
        builder.expirationTime = a.e("pk_rdio_v3_expiration_time");
        return builder.b();
    }

    public final boolean c()
    {
        com.shazam.model.rdio.RdioLegacyCredentials.Builder builder = com.shazam.model.rdio.RdioLegacyCredentials.Builder.a();
        builder.accessToken = a("pk_rdio_access_token");
        builder.accessTokenSecret = a("pk_rdio_access_token_secret");
        return com.shazam.b.e.a.c((new RdioLegacyCredentials(builder, null)).accessToken);
    }

    public final void d()
    {
        a(new String[] {
            "pk_rdio_access_token", "pk_rdio_access_token_secret", "pk_rdio_v3_access_token", "pk_rdio_v3_refresh_token", "pk_rdio_v3_expiration_time"
        });
        a(new String[] {
            "pk_rdio_playlist_key", "pk_rdio_playlist_uri"
        });
        a(new String[] {
            "pk_rdio_subscription_type"
        });
    }

    public final String f()
    {
        return a("pk_rdio_playlist_key");
    }

    public final SubscriptionType g()
    {
        return SubscriptionType.from(a.h("pk_rdio_subscription_type"));
    }
}
