// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.search;

import android.content.Context;
import android.graphics.Color;
import android.location.Location;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.internal.af;

public final class SearchAdRequest
{
    public static final class Builder
    {

        private final com.google.android.gms.internal.af.a dX = new com.google.android.gms.internal.af.a();
        private int jj;
        private int jk;
        private int jl;
        private int jm;
        private int jn;
        private int jo;
        private int jp;
        private int jq;
        private String jr;
        private int js;
        private String jt;
        private int ju;
        private int jv;
        private String jw;

        static int a(Builder builder)
        {
            return builder.jj;
        }

        static int b(Builder builder)
        {
            return builder.jk;
        }

        static int c(Builder builder)
        {
            return builder.jl;
        }

        static int d(Builder builder)
        {
            return builder.jm;
        }

        static int e(Builder builder)
        {
            return builder.jn;
        }

        static int f(Builder builder)
        {
            return builder.jo;
        }

        static int g(Builder builder)
        {
            return builder.jp;
        }

        static int h(Builder builder)
        {
            return builder.jq;
        }

        static String i(Builder builder)
        {
            return builder.jr;
        }

        static int j(Builder builder)
        {
            return builder.js;
        }

        static String k(Builder builder)
        {
            return builder.jt;
        }

        static int l(Builder builder)
        {
            return builder.ju;
        }

        static int m(Builder builder)
        {
            return builder.jv;
        }

        static String n(Builder builder)
        {
            return builder.jw;
        }

        static com.google.android.gms.internal.af.a o(Builder builder)
        {
            return builder.dX;
        }

        public Builder addNetworkExtras(NetworkExtras networkextras)
        {
            dX.a(networkextras);
            return this;
        }

        public Builder addTestDevice(String s)
        {
            dX.h(s);
            return this;
        }

        public SearchAdRequest build()
        {
            return new SearchAdRequest(this);
        }

        public Builder setAnchorTextColor(int i1)
        {
            jj = i1;
            return this;
        }

        public Builder setBackgroundColor(int i1)
        {
            jk = i1;
            jl = Color.argb(0, 0, 0, 0);
            jm = Color.argb(0, 0, 0, 0);
            return this;
        }

        public Builder setBackgroundGradient(int i1, int j1)
        {
            jk = Color.argb(0, 0, 0, 0);
            jl = j1;
            jm = i1;
            return this;
        }

        public Builder setBorderColor(int i1)
        {
            jn = i1;
            return this;
        }

        public Builder setBorderThickness(int i1)
        {
            jo = i1;
            return this;
        }

        public Builder setBorderType(int i1)
        {
            jp = i1;
            return this;
        }

        public Builder setCallButtonColor(int i1)
        {
            jq = i1;
            return this;
        }

        public Builder setCustomChannels(String s)
        {
            jr = s;
            return this;
        }

        public Builder setDescriptionTextColor(int i1)
        {
            js = i1;
            return this;
        }

        public Builder setFontFace(String s)
        {
            jt = s;
            return this;
        }

        public Builder setHeaderTextColor(int i1)
        {
            ju = i1;
            return this;
        }

        public Builder setHeaderTextSize(int i1)
        {
            jv = i1;
            return this;
        }

        public Builder setLocation(Location location)
        {
            dX.a(location);
            return this;
        }

        public Builder setQuery(String s)
        {
            jw = s;
            return this;
        }

        public Builder tagForChildDirectedTreatment(boolean flag)
        {
            dX.e(flag);
            return this;
        }

        public Builder()
        {
            jp = 0;
        }
    }


    public static final int BORDER_TYPE_DASHED = 1;
    public static final int BORDER_TYPE_DOTTED = 2;
    public static final int BORDER_TYPE_NONE = 0;
    public static final int BORDER_TYPE_SOLID = 3;
    public static final int CALL_BUTTON_COLOR_DARK = 2;
    public static final int CALL_BUTTON_COLOR_LIGHT = 0;
    public static final int CALL_BUTTON_COLOR_MEDIUM = 1;
    public static final String DEVICE_ID_EMULATOR;
    public static final int ERROR_CODE_INTERNAL_ERROR = 0;
    public static final int ERROR_CODE_INVALID_REQUEST = 1;
    public static final int ERROR_CODE_NETWORK_ERROR = 2;
    public static final int ERROR_CODE_NO_FILL = 3;
    private final af dW;
    private final int jj;
    private final int jk;
    private final int jl;
    private final int jm;
    private final int jn;
    private final int jo;
    private final int jp;
    private final int jq;
    private final String jr;
    private final int js;
    private final String jt;
    private final int ju;
    private final int jv;
    private final String jw;

    private SearchAdRequest(Builder builder)
    {
        jj = Builder.a(builder);
        jk = Builder.b(builder);
        jl = Builder.c(builder);
        jm = Builder.d(builder);
        jn = Builder.e(builder);
        jo = Builder.f(builder);
        jp = Builder.g(builder);
        jq = Builder.h(builder);
        jr = Builder.i(builder);
        js = Builder.j(builder);
        jt = Builder.k(builder);
        ju = Builder.l(builder);
        jv = Builder.m(builder);
        jw = Builder.n(builder);
        dW = new af(Builder.o(builder), this);
    }


    public int getAnchorTextColor()
    {
        return jj;
    }

    public int getBackgroundColor()
    {
        return jk;
    }

    public int getBackgroundGradientBottom()
    {
        return jl;
    }

    public int getBackgroundGradientTop()
    {
        return jm;
    }

    public int getBorderColor()
    {
        return jn;
    }

    public int getBorderThickness()
    {
        return jo;
    }

    public int getBorderType()
    {
        return jp;
    }

    public int getCallButtonColor()
    {
        return jq;
    }

    public String getCustomChannels()
    {
        return jr;
    }

    public int getDescriptionTextColor()
    {
        return js;
    }

    public String getFontFace()
    {
        return jt;
    }

    public int getHeaderTextColor()
    {
        return ju;
    }

    public int getHeaderTextSize()
    {
        return jv;
    }

    public Location getLocation()
    {
        return dW.getLocation();
    }

    public NetworkExtras getNetworkExtras(Class class1)
    {
        return dW.getNetworkExtras(class1);
    }

    public String getQuery()
    {
        return jw;
    }

    public boolean isTestDevice(Context context)
    {
        return dW.isTestDevice(context);
    }

    af v()
    {
        return dW;
    }

    static 
    {
        DEVICE_ID_EMULATOR = af.DEVICE_ID_EMULATOR;
    }
}
