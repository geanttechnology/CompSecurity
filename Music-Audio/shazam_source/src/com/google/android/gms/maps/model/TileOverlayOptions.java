// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.model.a.i;

// Referenced classes of package com.google.android.gms.maps.model:
//            t, e

public final class TileOverlayOptions
    implements SafeParcelable
{

    public static final t CREATOR = new t();
    final int a;
    i b;
    boolean c;
    float d;
    boolean e;
    private e f;

    public TileOverlayOptions()
    {
        c = true;
        e = true;
        a = 1;
    }

    TileOverlayOptions(int i, IBinder ibinder, boolean flag, float f1, boolean flag1)
    {
        c = true;
        e = true;
        a = i;
        b = com.google.android.gms.maps.model.a.i.a.a(ibinder);
        if (b == null)
        {
            ibinder = null;
        } else
        {
            ibinder = new e() {

                final TileOverlayOptions a;
                private final i c;

            
            {
                a = TileOverlayOptions.this;
                super();
                c = TileOverlayOptions.a(a);
            }
            };
        }
        f = ibinder;
        c = flag;
        d = f1;
        e = flag1;
    }

    static i a(TileOverlayOptions tileoverlayoptions)
    {
        return tileoverlayoptions.b;
    }

    public final int describeContents()
    {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        t.a(this, parcel);
    }

}
