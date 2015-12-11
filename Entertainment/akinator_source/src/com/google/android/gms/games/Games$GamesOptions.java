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

        boolean zzatS;
        boolean zzatT;
        int zzatU;
        boolean zzatV;
        int zzatW;
        String zzatX;
        ArrayList zzatY;

        public Games.GamesOptions build()
        {
            return new Games.GamesOptions(this, null);
        }

        public Builder setSdkVariant(int i)
        {
            zzatW = i;
            return this;
        }

        public Builder setShowConnectingPopup(boolean flag)
        {
            zzatT = flag;
            zzatU = 17;
            return this;
        }

        public Builder setShowConnectingPopup(boolean flag, int i)
        {
            zzatT = flag;
            zzatU = i;
            return this;
        }

        private Builder()
        {
            zzatS = false;
            zzatT = true;
            zzatU = 17;
            zzatV = false;
            zzatW = 4368;
            zzatX = null;
            zzatY = new ArrayList();
        }

        Builder(Games._cls1 _pcls1)
        {
            this();
        }
    }


    public final boolean zzatS;
    public final boolean zzatT;
    public final int zzatU;
    public final boolean zzatV;
    public final int zzatW;
    public final String zzatX;
    public final ArrayList zzatY;

    public static Builder builder()
    {
        return new Builder(null);
    }

    public Bundle zztD()
    {
        Bundle bundle = new Bundle();
        bundle.putBoolean("com.google.android.gms.games.key.isHeadless", zzatS);
        bundle.putBoolean("com.google.android.gms.games.key.showConnectingPopup", zzatT);
        bundle.putInt("com.google.android.gms.games.key.connectingPopupGravity", zzatU);
        bundle.putBoolean("com.google.android.gms.games.key.retryingSignIn", zzatV);
        bundle.putInt("com.google.android.gms.games.key.sdkVariant", zzatW);
        bundle.putString("com.google.android.gms.games.key.forceResolveAccountKey", zzatX);
        bundle.putStringArrayList("com.google.android.gms.games.key.proxyApis", zzatY);
        return bundle;
    }

    private Builder()
    {
        zzatS = false;
        zzatT = true;
        zzatU = 17;
        zzatV = false;
        zzatW = 4368;
        zzatX = null;
        zzatY = new ArrayList();
    }

    zzatY(zzatY zzaty)
    {
        this();
    }

    private Builder(Builder builder1)
    {
        zzatS = builder1.zzatS;
        zzatT = builder1.zzatT;
        zzatU = builder1.zzatU;
        zzatV = builder1.zzatV;
        zzatW = builder1.zzatW;
        zzatX = builder1.zzatX;
        zzatY = builder1.zzatY;
    }

    Builder(Builder builder1, Builder builder2)
    {
        this(builder1);
    }
}
