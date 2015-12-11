// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps.model;

import aks;
import android.os.IBinder;
import android.os.Parcel;
import ann;
import aoy;
import aoz;
import app;
import apq;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class TileOverlayOptions
    implements SafeParcelable
{

    public static final app CREATOR = new app();
    private final int a;
    private aoy b;
    private ann c;
    private boolean d;
    private float e;
    private boolean f;

    public TileOverlayOptions()
    {
        d = true;
        f = true;
        a = 1;
    }

    public TileOverlayOptions(int i, IBinder ibinder, boolean flag, float f1, boolean flag1)
    {
        d = true;
        f = true;
        a = i;
        b = aoz.a(ibinder);
        if (b == null)
        {
            ibinder = null;
        } else
        {
            ibinder = new ann() {

                final TileOverlayOptions a;
                private final aoy c;

            
            {
                a = TileOverlayOptions.this;
                super();
                c = TileOverlayOptions.a(a);
            }
            };
        }
        c = ibinder;
        d = flag;
        e = f1;
        f = flag1;
    }

    static aoy a(TileOverlayOptions tileoverlayoptions)
    {
        return tileoverlayoptions.b;
    }

    public int a()
    {
        return a;
    }

    public IBinder b()
    {
        return b.asBinder();
    }

    public float c()
    {
        return e;
    }

    public boolean d()
    {
        return d;
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean e()
    {
        return f;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        if (aks.a())
        {
            apq.a(this, parcel, i);
            return;
        } else
        {
            app.a(this, parcel, i);
            return;
        }
    }

}
