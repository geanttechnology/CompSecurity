// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.model.rdio;

import com.shazam.model.streaming.StreamingConnectionState;

// Referenced classes of package com.shazam.model.rdio:
//            RdioCredentials, RdioPlaylistInfo

public interface RdioConnectionState
    extends StreamingConnectionState
{

    public abstract void a(RdioCredentials rdiocredentials);

    public abstract void a(RdioPlaylistInfo rdioplaylistinfo);

    public abstract RdioCredentials b();

    public abstract boolean c();

    public abstract void d();
}
