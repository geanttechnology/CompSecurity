// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collections;
import java.util.List;

// Referenced classes of package com.google.android.gms.internal:
//            cc

public final class cb
    implements SafeParcelable
{

    public static final cc CREATOR = new cc();
    public final int errorCode;
    public final List fK;
    public final List fL;
    public final long fO;
    public final String gL;
    public final List hA;
    public final String hB;
    public final String hw;
    public final long hx;
    public final boolean hy;
    public final long hz;
    public final int orientation;
    public final int versionCode;

    public cb(int i)
    {
        this(2, null, null, null, i, null, -1L, false, -1L, null, -1L, -1, null);
    }

    cb(int i, String s, String s1, List list, int j, List list1, long l, boolean flag, long l1, List list2, long l2, 
            int k, String s2)
    {
        versionCode = i;
        gL = s;
        hw = s1;
        if (list != null)
        {
            s = Collections.unmodifiableList(list);
        } else
        {
            s = null;
        }
        fK = s;
        errorCode = j;
        if (list1 != null)
        {
            s = Collections.unmodifiableList(list1);
        } else
        {
            s = null;
        }
        fL = s;
        hx = l;
        hy = flag;
        hz = l1;
        if (list2 != null)
        {
            s = Collections.unmodifiableList(list2);
        } else
        {
            s = null;
        }
        hA = s;
        fO = l2;
        orientation = k;
        hB = s2;
    }

    public cb(String s, String s1, List list, List list1, long l, boolean flag, 
            long l1, List list2, long l2, int i, String s2)
    {
        this(2, s, s1, list, -2, list1, l, flag, l1, list2, l2, i, s2);
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        cc.a(this, parcel, i);
    }

}
