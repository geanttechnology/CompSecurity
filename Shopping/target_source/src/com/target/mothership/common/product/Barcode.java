// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.common.product;

import android.os.Parcel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.target.mothership.common.product:
//            ProductIdentifier

public class Barcode extends ProductIdentifier
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public Barcode a(Parcel parcel)
        {
            return new Barcode(parcel);
        }

        public Barcode[] a(int i)
        {
            return new Barcode[i];
        }

        public Object createFromParcel(Parcel parcel)
        {
            return a(parcel);
        }

        public Object[] newArray(int i)
        {
            return a(i);
        }

    };

    public Barcode(Parcel parcel)
    {
        super(parcel);
    }

    public Barcode(String s)
    {
        super(s);
    }

    public ProductIdentifier.a a()
    {
        return ProductIdentifier.a.BARCODE;
    }

    public List a(List list)
    {
        ArrayList arraylist = new ArrayList(list.size());
        for (list = list.iterator(); list.hasNext(); arraylist.add(new Barcode((String)list.next()))) { }
        return arraylist;
    }

}
