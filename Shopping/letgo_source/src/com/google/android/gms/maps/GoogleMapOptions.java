// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.support.v7.yx;
import android.util.AttributeSet;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.model.CameraPosition;

// Referenced classes of package com.google.android.gms.maps:
//            h

public final class GoogleMapOptions
    implements SafeParcelable
{

    public static final h CREATOR = new h();
    private final int a;
    private Boolean b;
    private Boolean c;
    private int d;
    private CameraPosition e;
    private Boolean f;
    private Boolean g;
    private Boolean h;
    private Boolean i;
    private Boolean j;
    private Boolean k;
    private Boolean l;
    private Boolean m;

    public GoogleMapOptions()
    {
        d = -1;
        a = 1;
    }

    GoogleMapOptions(int i1, byte byte0, byte byte1, int j1, CameraPosition cameraposition, byte byte2, byte byte3, 
            byte byte4, byte byte5, byte byte6, byte byte7, byte byte8, byte byte9)
    {
        d = -1;
        a = i1;
        b = yx.a(byte0);
        c = yx.a(byte1);
        d = j1;
        e = cameraposition;
        f = yx.a(byte2);
        g = yx.a(byte3);
        h = yx.a(byte4);
        i = yx.a(byte5);
        j = yx.a(byte6);
        k = yx.a(byte7);
        l = yx.a(byte8);
        m = yx.a(byte9);
    }

    public static GoogleMapOptions a(Context context, AttributeSet attributeset)
    {
        if (attributeset == null)
        {
            return null;
        }
        TypedArray typedarray = context.getResources().obtainAttributes(attributeset, android.support.v7.ks.c.MapAttrs);
        GoogleMapOptions googlemapoptions = new GoogleMapOptions();
        if (typedarray.hasValue(android.support.v7.ks.c.MapAttrs_mapType))
        {
            googlemapoptions.a(typedarray.getInt(android.support.v7.ks.c.MapAttrs_mapType, -1));
        }
        if (typedarray.hasValue(android.support.v7.ks.c.MapAttrs_zOrderOnTop))
        {
            googlemapoptions.a(typedarray.getBoolean(android.support.v7.ks.c.MapAttrs_zOrderOnTop, false));
        }
        if (typedarray.hasValue(android.support.v7.ks.c.MapAttrs_useViewLifecycle))
        {
            googlemapoptions.b(typedarray.getBoolean(android.support.v7.ks.c.MapAttrs_useViewLifecycle, false));
        }
        if (typedarray.hasValue(android.support.v7.ks.c.MapAttrs_uiCompass))
        {
            googlemapoptions.d(typedarray.getBoolean(android.support.v7.ks.c.MapAttrs_uiCompass, true));
        }
        if (typedarray.hasValue(android.support.v7.ks.c.MapAttrs_uiRotateGestures))
        {
            googlemapoptions.h(typedarray.getBoolean(android.support.v7.ks.c.MapAttrs_uiRotateGestures, true));
        }
        if (typedarray.hasValue(android.support.v7.ks.c.MapAttrs_uiScrollGestures))
        {
            googlemapoptions.e(typedarray.getBoolean(android.support.v7.ks.c.MapAttrs_uiScrollGestures, true));
        }
        if (typedarray.hasValue(android.support.v7.ks.c.MapAttrs_uiTiltGestures))
        {
            googlemapoptions.g(typedarray.getBoolean(android.support.v7.ks.c.MapAttrs_uiTiltGestures, true));
        }
        if (typedarray.hasValue(android.support.v7.ks.c.MapAttrs_uiZoomGestures))
        {
            googlemapoptions.f(typedarray.getBoolean(android.support.v7.ks.c.MapAttrs_uiZoomGestures, true));
        }
        if (typedarray.hasValue(android.support.v7.ks.c.MapAttrs_uiZoomControls))
        {
            googlemapoptions.c(typedarray.getBoolean(android.support.v7.ks.c.MapAttrs_uiZoomControls, true));
        }
        if (typedarray.hasValue(android.support.v7.ks.c.MapAttrs_liteMode))
        {
            googlemapoptions.i(typedarray.getBoolean(android.support.v7.ks.c.MapAttrs_liteMode, false));
        }
        if (typedarray.hasValue(android.support.v7.ks.c.MapAttrs_uiMapToolbar))
        {
            googlemapoptions.j(typedarray.getBoolean(android.support.v7.ks.c.MapAttrs_uiMapToolbar, true));
        }
        googlemapoptions.a(CameraPosition.a(context, attributeset));
        typedarray.recycle();
        return googlemapoptions;
    }

    int a()
    {
        return a;
    }

    public GoogleMapOptions a(int i1)
    {
        d = i1;
        return this;
    }

    public GoogleMapOptions a(CameraPosition cameraposition)
    {
        e = cameraposition;
        return this;
    }

    public GoogleMapOptions a(boolean flag)
    {
        b = Boolean.valueOf(flag);
        return this;
    }

    byte b()
    {
        return yx.a(b);
    }

    public GoogleMapOptions b(boolean flag)
    {
        c = Boolean.valueOf(flag);
        return this;
    }

    byte c()
    {
        return yx.a(c);
    }

    public GoogleMapOptions c(boolean flag)
    {
        f = Boolean.valueOf(flag);
        return this;
    }

    byte d()
    {
        return yx.a(f);
    }

    public GoogleMapOptions d(boolean flag)
    {
        g = Boolean.valueOf(flag);
        return this;
    }

    public int describeContents()
    {
        return 0;
    }

    byte e()
    {
        return yx.a(g);
    }

    public GoogleMapOptions e(boolean flag)
    {
        h = Boolean.valueOf(flag);
        return this;
    }

    byte f()
    {
        return yx.a(h);
    }

    public GoogleMapOptions f(boolean flag)
    {
        i = Boolean.valueOf(flag);
        return this;
    }

    byte g()
    {
        return yx.a(i);
    }

    public GoogleMapOptions g(boolean flag)
    {
        j = Boolean.valueOf(flag);
        return this;
    }

    byte h()
    {
        return yx.a(j);
    }

    public GoogleMapOptions h(boolean flag)
    {
        k = Boolean.valueOf(flag);
        return this;
    }

    byte i()
    {
        return yx.a(k);
    }

    public GoogleMapOptions i(boolean flag)
    {
        l = Boolean.valueOf(flag);
        return this;
    }

    byte j()
    {
        return yx.a(l);
    }

    public GoogleMapOptions j(boolean flag)
    {
        m = Boolean.valueOf(flag);
        return this;
    }

    byte k()
    {
        return yx.a(m);
    }

    public int l()
    {
        return d;
    }

    public CameraPosition m()
    {
        return e;
    }

    public void writeToParcel(Parcel parcel, int i1)
    {
        com.google.android.gms.maps.h.a(this, parcel, i1);
    }

}
