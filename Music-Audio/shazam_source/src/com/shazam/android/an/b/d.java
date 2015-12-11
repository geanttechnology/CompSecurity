// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.an.b;

import android.app.Activity;
import android.content.Intent;
import com.shazam.android.a;
import com.spotify.sdk.android.authentication.AuthenticationClient;
import com.spotify.sdk.android.authentication.AuthenticationResponse;

// Referenced classes of package com.shazam.android.an.b:
//            ab

public final class d
    implements ab
{

    public d()
    {
    }

    public final AuthenticationResponse a(int i, Intent intent)
    {
        return AuthenticationClient.getResponse(i, intent);
    }

    public final void a(Activity activity)
    {
        AuthenticationClient.openLoginActivity(activity, 1024, (new com.spotify.sdk.android.authentication.AuthenticationRequest.Builder("f87c03896d274ecf9d80f86e942202e1", com.spotify.sdk.android.authentication.AuthenticationResponse.Type.CODE, "shazam-spotifyoauth://spotifylogincallback/free")).setScopes(a.e).setCustomParam("utm_source", "shazam_android").setCustomParam("utm_medium", "partner_mgmt").setCustomParam("utm_campaign", "activation_shazam_all").setCustomParam("utm_content", "all501443").setCustomParam("utm_term", "mobile").build());
    }
}
