// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps;

import aji;
import ajj;
import akr;
import aks;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.util.AttributeSet;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.model.CameraPosition;

public final class GoogleMapOptions
    implements SafeParcelable
{

    public static final aji CREATOR = new aji();
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

    public GoogleMapOptions(int i1, byte byte0, byte byte1, int j1, CameraPosition cameraposition, byte byte2, byte byte3, 
            byte byte4, byte byte5, byte byte6, byte byte7, byte byte8, byte byte9)
    {
        d = -1;
        a = i1;
        b = akr.a(byte0);
        c = akr.a(byte1);
        d = j1;
        e = cameraposition;
        f = akr.a(byte2);
        g = akr.a(byte3);
        h = akr.a(byte4);
        i = akr.a(byte5);
        j = akr.a(byte6);
        k = akr.a(byte7);
        l = akr.a(byte8);
        m = akr.a(byte9);
    }

    public static GoogleMapOptions a(Context context, AttributeSet attributeset)
    {
        if (attributeset == null)
        {
            return null;
        }
        TypedArray typedarray = context.getResources().obtainAttributes(attributeset, com.google.android.gms.R.styleable.MapAttrs);
        GoogleMapOptions googlemapoptions = new GoogleMapOptions();
        if (typedarray.hasValue(com.google.android.gms.R.styleable.MapAttrs_mapType))
        {
            googlemapoptions.a(typedarray.getInt(com.google.android.gms.R.styleable.MapAttrs_mapType, -1));
        }
        if (typedarray.hasValue(com.google.android.gms.R.styleable.MapAttrs_zOrderOnTop))
        {
            googlemapoptions.a(typedarray.getBoolean(com.google.android.gms.R.styleable.MapAttrs_zOrderOnTop, false));
        }
        if (typedarray.hasValue(com.google.android.gms.R.styleable.MapAttrs_useViewLifecycle))
        {
            googlemapoptions.b(typedarray.getBoolean(com.google.android.gms.R.styleable.MapAttrs_useViewLifecycle, false));
        }
        if (typedarray.hasValue(com.google.android.gms.R.styleable.MapAttrs_uiCompass))
        {
            googlemapoptions.d(typedarray.getBoolean(com.google.android.gms.R.styleable.MapAttrs_uiCompass, true));
        }
        if (typedarray.hasValue(com.google.android.gms.R.styleable.MapAttrs_uiRotateGestures))
        {
            googlemapoptions.h(typedarray.getBoolean(com.google.android.gms.R.styleable.MapAttrs_uiRotateGestures, true));
        }
        if (typedarray.hasValue(com.google.android.gms.R.styleable.MapAttrs_uiScrollGestures))
        {
            googlemapoptions.e(typedarray.getBoolean(com.google.android.gms.R.styleable.MapAttrs_uiScrollGestures, true));
        }
        if (typedarray.hasValue(com.google.android.gms.R.styleable.MapAttrs_uiTiltGestures))
        {
            googlemapoptions.g(typedarray.getBoolean(com.google.android.gms.R.styleable.MapAttrs_uiTiltGestures, true));
        }
        if (typedarray.hasValue(com.google.android.gms.R.styleable.MapAttrs_uiZoomGestures))
        {
            googlemapoptions.f(typedarray.getBoolean(com.google.android.gms.R.styleable.MapAttrs_uiZoomGestures, true));
        }
        if (typedarray.hasValue(com.google.android.gms.R.styleable.MapAttrs_uiZoomControls))
        {
            googlemapoptions.c(typedarray.getBoolean(com.google.android.gms.R.styleable.MapAttrs_uiZoomControls, true));
        }
        if (typedarray.hasValue(com.google.android.gms.R.styleable.MapAttrs_liteMode))
        {
            googlemapoptions.i(typedarray.getBoolean(com.google.android.gms.R.styleable.MapAttrs_liteMode, false));
        }
        if (typedarray.hasValue(com.google.android.gms.R.styleable.MapAttrs_uiMapToolbar))
        {
            googlemapoptions.j(typedarray.getBoolean(com.google.android.gms.R.styleable.MapAttrs_uiMapToolbar, true));
        }
        googlemapoptions.a(CameraPosition.a(context, attributeset));
        typedarray.recycle();
        return googlemapoptions;
    }

    public int a()
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

    public byte b()
    {
        return akr.a(b);
    }

    public GoogleMapOptions b(boolean flag)
    {
        c = Boolean.valueOf(flag);
        return this;
    }

    public byte c()
    {
        return akr.a(c);
    }

    public GoogleMapOptions c(boolean flag)
    {
        f = Boolean.valueOf(flag);
        return this;
    }

    public byte d()
    {
        return akr.a(f);
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

    public byte e()
    {
        return akr.a(g);
    }

    public GoogleMapOptions e(boolean flag)
    {
        h = Boolean.valueOf(flag);
        return this;
    }

    public byte f()
    {
        return akr.a(h);
    }

    public GoogleMapOptions f(boolean flag)
    {
        i = Boolean.valueOf(flag);
        return this;
    }

    public byte g()
    {
        return akr.a(i);
    }

    public GoogleMapOptions g(boolean flag)
    {
        j = Boolean.valueOf(flag);
        return this;
    }

    public byte h()
    {
        return akr.a(j);
    }

    public GoogleMapOptions h(boolean flag)
    {
        k = Boolean.valueOf(flag);
        return this;
    }

    public byte i()
    {
        return akr.a(k);
    }

    public GoogleMapOptions i(boolean flag)
    {
        l = Boolean.valueOf(flag);
        return this;
    }

    public byte j()
    {
        return akr.a(l);
    }

    public GoogleMapOptions j(boolean flag)
    {
        m = Boolean.valueOf(flag);
        return this;
    }

    public byte k()
    {
        return akr.a(m);
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
        if (aks.a())
        {
            ajj.a(this, parcel, i1);
            return;
        } else
        {
            aji.a(this, parcel, i1);
            return;
        }
    }

}
