// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.support.v7.aae;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// Referenced classes of package com.google.android.gms.maps.model:
//            u, f

public final class TileOverlayOptions
    implements SafeParcelable
{

    public static final u CREATOR = new u();
    private final int a;
    private aae b;
    private f c;
    private boolean d;
    private float e;
    private boolean f;

    public TileOverlayOptions()
    {
        d = true;
        f = true;
        a = 1;
    }

    TileOverlayOptions(int i, IBinder ibinder, boolean flag, float f1, boolean flag1)
    {
        d = true;
        f = true;
        a = i;
        b = android.support.v7.aae.a.a(ibinder);
        if (b == null)
        {
            ibinder = null;
        } else
        {
            ibinder = new f() {

                final TileOverlayOptions a;
                private final aae c;

            
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

    static aae a(TileOverlayOptions tileoverlayoptions)
    {
        return tileoverlayoptions.b;
    }

    int a()
    {
        return a;
    }

    IBinder b()
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
        u.a(this, parcel, i);
    }

}
