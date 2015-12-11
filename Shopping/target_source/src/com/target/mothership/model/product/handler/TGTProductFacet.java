// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.product.handler;

import android.os.Parcel;
import com.target.mothership.model.product.interfaces.ProductFacet;
import com.target.mothership.util.k;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.target.mothership.model.product.handler:
//            TGTProductEntry

public class TGTProductFacet
    implements ProductFacet
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTProductFacet a(Parcel parcel)
        {
            return new TGTProductFacet(parcel);
        }

        public TGTProductFacet[] a(int i)
        {
            return new TGTProductFacet[i];
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
    private List mEntry;

    TGTProductFacet()
    {
    }

    private TGTProductFacet(Parcel parcel)
    {
        mEntry = new ArrayList();
        parcel.readList(mEntry, com/target/mothership/model/product/handler/TGTProductEntry.getClassLoader());
    }


    public List a()
    {
        return k.a(mEntry);
    }

    public void a(List list)
    {
        mEntry = list;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeList(mEntry);
    }

}
