// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.util.AttributeSet;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.a.l;
import com.google.android.gms.maps.model.CameraPosition;

// Referenced classes of package com.google.android.gms.maps:
//            g

public final class GoogleMapOptions
    implements SafeParcelable
{

    public static final g CREATOR = new g();
    final int a;
    Boolean b;
    Boolean c;
    int d;
    CameraPosition e;
    Boolean f;
    Boolean g;
    Boolean h;
    Boolean i;
    Boolean j;
    Boolean k;
    Boolean l;
    Boolean m;

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
        b = com.google.android.gms.maps.a.l.a(byte0);
        c = com.google.android.gms.maps.a.l.a(byte1);
        d = j1;
        e = cameraposition;
        f = com.google.android.gms.maps.a.l.a(byte2);
        g = com.google.android.gms.maps.a.l.a(byte3);
        h = com.google.android.gms.maps.a.l.a(byte4);
        i = com.google.android.gms.maps.a.l.a(byte5);
        j = com.google.android.gms.maps.a.l.a(byte6);
        k = com.google.android.gms.maps.a.l.a(byte7);
        l = com.google.android.gms.maps.a.l.a(byte8);
        m = com.google.android.gms.maps.a.l.a(byte9);
    }

    public static GoogleMapOptions a(Context context, AttributeSet attributeset)
    {
        if (attributeset == null)
        {
            return null;
        }
        TypedArray typedarray = context.getResources().obtainAttributes(attributeset, com.google.android.gms.a.c.MapAttrs);
        GoogleMapOptions googlemapoptions = new GoogleMapOptions();
        if (typedarray.hasValue(com.google.android.gms.a.c.MapAttrs_mapType))
        {
            googlemapoptions.d = typedarray.getInt(com.google.android.gms.a.c.MapAttrs_mapType, -1);
        }
        if (typedarray.hasValue(com.google.android.gms.a.c.MapAttrs_zOrderOnTop))
        {
            googlemapoptions.b = Boolean.valueOf(typedarray.getBoolean(com.google.android.gms.a.c.MapAttrs_zOrderOnTop, false));
        }
        if (typedarray.hasValue(com.google.android.gms.a.c.MapAttrs_useViewLifecycle))
        {
            googlemapoptions.c = Boolean.valueOf(typedarray.getBoolean(com.google.android.gms.a.c.MapAttrs_useViewLifecycle, false));
        }
        if (typedarray.hasValue(com.google.android.gms.a.c.MapAttrs_uiCompass))
        {
            googlemapoptions.g = Boolean.valueOf(typedarray.getBoolean(com.google.android.gms.a.c.MapAttrs_uiCompass, true));
        }
        if (typedarray.hasValue(com.google.android.gms.a.c.MapAttrs_uiRotateGestures))
        {
            googlemapoptions.k = Boolean.valueOf(typedarray.getBoolean(com.google.android.gms.a.c.MapAttrs_uiRotateGestures, true));
        }
        if (typedarray.hasValue(com.google.android.gms.a.c.MapAttrs_uiScrollGestures))
        {
            googlemapoptions.h = Boolean.valueOf(typedarray.getBoolean(com.google.android.gms.a.c.MapAttrs_uiScrollGestures, true));
        }
        if (typedarray.hasValue(com.google.android.gms.a.c.MapAttrs_uiTiltGestures))
        {
            googlemapoptions.j = Boolean.valueOf(typedarray.getBoolean(com.google.android.gms.a.c.MapAttrs_uiTiltGestures, true));
        }
        if (typedarray.hasValue(com.google.android.gms.a.c.MapAttrs_uiZoomGestures))
        {
            googlemapoptions.i = Boolean.valueOf(typedarray.getBoolean(com.google.android.gms.a.c.MapAttrs_uiZoomGestures, true));
        }
        if (typedarray.hasValue(com.google.android.gms.a.c.MapAttrs_uiZoomControls))
        {
            googlemapoptions.f = Boolean.valueOf(typedarray.getBoolean(com.google.android.gms.a.c.MapAttrs_uiZoomControls, true));
        }
        if (typedarray.hasValue(com.google.android.gms.a.c.MapAttrs_liteMode))
        {
            googlemapoptions.l = Boolean.valueOf(typedarray.getBoolean(com.google.android.gms.a.c.MapAttrs_liteMode, false));
        }
        if (typedarray.hasValue(com.google.android.gms.a.c.MapAttrs_uiMapToolbar))
        {
            googlemapoptions.m = Boolean.valueOf(typedarray.getBoolean(com.google.android.gms.a.c.MapAttrs_uiMapToolbar, true));
        }
        googlemapoptions.e = CameraPosition.a(context, attributeset);
        typedarray.recycle();
        return googlemapoptions;
    }

    public final int describeContents()
    {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i1)
    {
        com.google.android.gms.maps.g.a(this, parcel, i1);
    }

}
