// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.sdk;


// Referenced classes of package com.rdio.android.sdk:
//            RdioService, OAuth2Credential

public interface RdioListener
{

    public abstract void onApiServiceReady(RdioService rdioservice);

    public abstract void onError(Rdio.RdioError rdioerror, String s);

    public abstract void onRdioAuthorised(OAuth2Credential oauth2credential);

    public abstract void onRdioReadyForPlayback();

    public abstract void onRdioUserPlayingElsewhere();
}
