// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games;


// Referenced classes of package com.google.android.gms.games:
//            Games

public static final class Builder
    implements com.google.android.gms.common.api.Options
{
    public static final class Builder
    {

        boolean ta;
        boolean tb;
        int tc;
        int td;

        public Games.GamesOptions build()
        {
            return new Games.GamesOptions(this, null);
        }

        public Builder setSdkVariant(int i)
        {
            td = i;
            return this;
        }

        public Builder setShowConnectingPopup(boolean flag)
        {
            tb = flag;
            tc = 17;
            return this;
        }

        public Builder setShowConnectingPopup(boolean flag, int i)
        {
            tb = flag;
            tc = i;
            return this;
        }

        private Builder()
        {
            ta = false;
            tb = true;
            tc = 17;
            td = 4368;
        }

        Builder(Games._cls1 _pcls1)
        {
            this();
        }
    }


    final boolean ta;
    final boolean tb;
    final int tc;
    final int td;

    public static Builder builder()
    {
        return new Builder(null);
    }

    private Builder()
    {
        ta = false;
        tb = true;
        tc = 17;
        td = 4368;
    }

    td(td td1)
    {
        this();
    }

    private Builder(Builder builder1)
    {
        ta = builder1.ta;
        tb = builder1.tb;
        tc = builder1.tc;
        td = builder1.td;
    }

    Builder(Builder builder1, Builder builder2)
    {
        this(builder1);
    }
}
