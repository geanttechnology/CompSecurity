// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games;

import android.os.Bundle;
import java.util.ArrayList;

// Referenced classes of package com.google.android.gms.games:
//            Games

public static final class Builder
    implements com.google.android.gms.common.api.onal
{
    public static final class Builder
    {

        String zzarA;
        ArrayList zzarB;
        boolean zzarv;
        boolean zzarw;
        int zzarx;
        boolean zzary;
        int zzarz;

        public Games.GamesOptions build()
        {
            return new Games.GamesOptions(this, null);
        }

        public Builder setSdkVariant(int i)
        {
            zzarz = i;
            return this;
        }

        public Builder setShowConnectingPopup(boolean flag)
        {
            zzarw = flag;
            zzarx = 17;
            return this;
        }

        public Builder setShowConnectingPopup(boolean flag, int i)
        {
            zzarw = flag;
            zzarx = i;
            return this;
        }

        private Builder()
        {
            zzarv = false;
            zzarw = true;
            zzarx = 17;
            zzary = false;
            zzarz = 4368;
            zzarA = null;
            zzarB = new ArrayList();
        }

        Builder(Games._cls1 _pcls1)
        {
            this();
        }
    }


    public final String zzarA;
    public final ArrayList zzarB;
    public final boolean zzarv;
    public final boolean zzarw;
    public final int zzarx;
    public final boolean zzary;
    public final int zzarz;

    public static Builder builder()
    {
        return new Builder(null);
    }

    public Bundle zzsQ()
    {
        Bundle bundle = new Bundle();
        bundle.putBoolean("com.google.android.gms.games.key.isHeadless", zzarv);
        bundle.putBoolean("com.google.android.gms.games.key.showConnectingPopup", zzarw);
        bundle.putInt("com.google.android.gms.games.key.connectingPopupGravity", zzarx);
        bundle.putBoolean("com.google.android.gms.games.key.retryingSignIn", zzary);
        bundle.putInt("com.google.android.gms.games.key.sdkVariant", zzarz);
        bundle.putString("com.google.android.gms.games.key.forceResolveAccountKey", zzarA);
        bundle.putStringArrayList("com.google.android.gms.games.key.proxyApis", zzarB);
        return bundle;
    }

    private Builder()
    {
        zzarv = false;
        zzarw = true;
        zzarx = 17;
        zzary = false;
        zzarz = 4368;
        zzarA = null;
        zzarB = new ArrayList();
    }

    zzarB(zzarB zzarb)
    {
        this();
    }

    private Builder(Builder builder1)
    {
        zzarv = builder1.zzarv;
        zzarw = builder1.zzarw;
        zzarx = builder1.zzarx;
        zzary = builder1.zzary;
        zzarz = builder1.zzarz;
        zzarA = builder1.zzarA;
        zzarB = builder1.zzarB;
    }

    Builder(Builder builder1, Builder builder2)
    {
        this(builder1);
    }
}
