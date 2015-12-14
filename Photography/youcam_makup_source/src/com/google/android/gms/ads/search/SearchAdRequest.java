// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.search;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.internal.at;

public final class SearchAdRequest
{

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
    private final at ks;
    private final int tc;
    private final int td;
    private final int te;
    private final int tf;
    private final int tg;
    private final int th;
    private final int ti;
    private final int tj;
    private final String tk;
    private final int tl;
    private final String tm;
    private final int tn;
    private final int to;
    private final String tp;

    private SearchAdRequest(Builder builder)
    {
        tc = Builder.a(builder);
        td = Builder.b(builder);
        te = Builder.c(builder);
        tf = Builder.d(builder);
        tg = Builder.e(builder);
        th = Builder.f(builder);
        ti = Builder.g(builder);
        tj = Builder.h(builder);
        tk = Builder.i(builder);
        tl = Builder.j(builder);
        tm = Builder.k(builder);
        tn = Builder.l(builder);
        to = Builder.m(builder);
        tp = Builder.n(builder);
        ks = new at(Builder.o(builder), this);
    }

    SearchAdRequest(Builder builder, _cls1 _pcls1)
    {
        this(builder);
    }

    at T()
    {
        return ks;
    }

    public int getAnchorTextColor()
    {
        return tc;
    }

    public int getBackgroundColor()
    {
        return td;
    }

    public int getBackgroundGradientBottom()
    {
        return te;
    }

    public int getBackgroundGradientTop()
    {
        return tf;
    }

    public int getBorderColor()
    {
        return tg;
    }

    public int getBorderThickness()
    {
        return th;
    }

    public int getBorderType()
    {
        return ti;
    }

    public int getCallButtonColor()
    {
        return tj;
    }

    public String getCustomChannels()
    {
        return tk;
    }

    public Bundle getCustomEventExtrasBundle(Class class1)
    {
        return ks.getCustomEventExtrasBundle(class1);
    }

    public int getDescriptionTextColor()
    {
        return tl;
    }

    public String getFontFace()
    {
        return tm;
    }

    public int getHeaderTextColor()
    {
        return tn;
    }

    public int getHeaderTextSize()
    {
        return to;
    }

    public Location getLocation()
    {
        return ks.getLocation();
    }

    public NetworkExtras getNetworkExtras(Class class1)
    {
        return ks.getNetworkExtras(class1);
    }

    public Bundle getNetworkExtrasBundle(Class class1)
    {
        return ks.getNetworkExtrasBundle(class1);
    }

    public String getQuery()
    {
        return tp;
    }

    public boolean isTestDevice(Context context)
    {
        return ks.isTestDevice(context);
    }

    static 
    {
        DEVICE_ID_EMULATOR = at.DEVICE_ID_EMULATOR;
    }

    /* member class not found */
    class Builder {}

}
