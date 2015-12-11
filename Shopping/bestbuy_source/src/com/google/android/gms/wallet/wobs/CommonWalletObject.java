// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wallet.wobs;

import aed;
import android.os.Parcel;
import ath;
import ati;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;

// Referenced classes of package com.google.android.gms.wallet.wobs:
//            l

public class CommonWalletObject
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new ati();
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public int i;
    public ArrayList j;
    public l k;
    public ArrayList l;
    public String m;
    public String n;
    public ArrayList o;
    public boolean p;
    public ArrayList q;
    public ArrayList r;
    public ArrayList s;
    private final int t;

    CommonWalletObject()
    {
        t = 1;
        j = aed.a();
        l = aed.a();
        o = aed.a();
        q = aed.a();
        r = aed.a();
        s = aed.a();
    }

    public CommonWalletObject(int i1, String s1, String s2, String s3, String s4, String s5, String s6, 
            String s7, String s8, int j1, ArrayList arraylist, l l1, ArrayList arraylist1, String s9, 
            String s10, ArrayList arraylist2, boolean flag, ArrayList arraylist3, ArrayList arraylist4, ArrayList arraylist5)
    {
        t = i1;
        a = s1;
        b = s2;
        c = s3;
        d = s4;
        e = s5;
        f = s6;
        g = s7;
        h = s8;
        i = j1;
        j = arraylist;
        k = l1;
        l = arraylist1;
        m = s9;
        n = s10;
        o = arraylist2;
        p = flag;
        q = arraylist3;
        r = arraylist4;
        s = arraylist5;
    }

    public static ath a()
    {
        CommonWalletObject commonwalletobject = new CommonWalletObject();
        commonwalletobject.getClass();
        return new ath(commonwalletobject);
    }

    public int b()
    {
        return t;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i1)
    {
        ati.a(this, parcel, i1);
    }

}
