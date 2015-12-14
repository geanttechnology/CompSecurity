// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.cast;

import com.google.android.gms.common.internal.zzx;

// Referenced classes of package com.google.android.gms.cast:
//            CastRemoteDisplay, CastDevice

public static final class Builder
    implements com.google.android.gms.common.api.r
{
    public static final class Builder
    {

        CastDevice zzTj;
        CastRemoteDisplay.CastRemoteDisplaySessionCallbacks zzTx;

        public CastRemoteDisplay.CastRemoteDisplayOptions build()
        {
            return new CastRemoteDisplay.CastRemoteDisplayOptions(this, null);
        }

        public Builder(CastDevice castdevice, CastRemoteDisplay.CastRemoteDisplaySessionCallbacks castremotedisplaysessioncallbacks)
        {
            zzx.zzb(castdevice, "CastDevice parameter cannot be null");
            zzTj = castdevice;
            zzTx = castremotedisplaysessioncallbacks;
        }
    }


    final CastDevice zzTg;
    final allbacks zzTw;

    private Builder(Builder builder)
    {
        zzTg = builder.zzTj;
        zzTw = builder.zzTx;
    }

    Builder(Builder builder, Builder builder1)
    {
        this(builder);
    }
}
