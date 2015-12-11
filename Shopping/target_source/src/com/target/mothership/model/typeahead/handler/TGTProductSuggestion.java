// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.typeahead.handler;

import android.os.Parcel;
import com.target.mothership.model.typeahead.interfaces.ProductSuggestion;
import com.target.mothership.util.k;
import java.util.List;

// Referenced classes of package com.target.mothership.model.typeahead.handler:
//            TGTProductSubSuggestion

public class TGTProductSuggestion
    implements ProductSuggestion
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTProductSuggestion a(Parcel parcel)
        {
            return new TGTProductSuggestion(parcel);
        }

        public TGTProductSuggestion[] a(int i)
        {
            return new TGTProductSuggestion[i];
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
    private List mSubSuggestion;
    private String mSuggestion;

    TGTProductSuggestion()
    {
    }

    TGTProductSuggestion(Parcel parcel)
    {
        a(parcel);
    }

    public String a()
    {
        return mSuggestion;
    }

    public void a(Parcel parcel)
    {
        mSuggestion = parcel.readString();
        parcel.readTypedList(mSubSuggestion, TGTProductSubSuggestion.CREATOR);
    }

    public void a(String s)
    {
        mSuggestion = s;
    }

    public void a(List list)
    {
        mSubSuggestion = list;
    }

    public List b()
    {
        return k.a(mSubSuggestion);
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(mSuggestion);
        parcel.writeList(mSubSuggestion);
    }

}
