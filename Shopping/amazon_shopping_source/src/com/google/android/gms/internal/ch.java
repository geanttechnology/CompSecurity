// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.d;
import com.google.android.gms.dynamic.e;

// Referenced classes of package com.google.android.gms.internal:
//            cg, t, ci, ex, 
//            ba, cl, bd, ev, 
//            v, ce

public final class ch
    implements SafeParcelable
{

    public static final cg CREATOR = new cg();
    public final ev kQ;
    public final String oA;
    public final boolean oB;
    public final String oC;
    public final cl oD;
    public final int oE;
    public final bd oF;
    public final String oG;
    public final v oH;
    public final String ob;
    public final int orientation;
    public final ce ov;
    public final t ow;
    public final ci ox;
    public final ex oy;
    public final ba oz;
    public final int versionCode;

    ch(int i, ce ce, IBinder ibinder, IBinder ibinder1, IBinder ibinder2, IBinder ibinder3, String s, 
            boolean flag, String s1, IBinder ibinder4, int j, int k, String s2, ev ev, 
            IBinder ibinder5, String s3, v v)
    {
        versionCode = i;
        ov = ce;
        ow = (t)e.e(com.google.android.gms.dynamic.d.a.ag(ibinder));
        ox = (ci)e.e(com.google.android.gms.dynamic.d.a.ag(ibinder1));
        oy = (ex)e.e(com.google.android.gms.dynamic.d.a.ag(ibinder2));
        oz = (ba)e.e(com.google.android.gms.dynamic.d.a.ag(ibinder3));
        oA = s;
        oB = flag;
        oC = s1;
        oD = (cl)e.e(com.google.android.gms.dynamic.d.a.ag(ibinder4));
        orientation = j;
        oE = k;
        ob = s2;
        kQ = ev;
        oF = (bd)e.e(com.google.android.gms.dynamic.d.a.ag(ibinder5));
        oG = s3;
        oH = v;
    }

    IBinder aU()
    {
        return e.h(ow).asBinder();
    }

    IBinder aV()
    {
        return e.h(ox).asBinder();
    }

    IBinder aW()
    {
        return e.h(oy).asBinder();
    }

    IBinder aX()
    {
        return e.h(oz).asBinder();
    }

    IBinder aY()
    {
        return e.h(oF).asBinder();
    }

    IBinder aZ()
    {
        return e.h(oD).asBinder();
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        cg.a(this, parcel, i);
    }

}
