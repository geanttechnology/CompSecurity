// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.typeahead.handler;

import android.os.Parcel;
import com.google.a.a.e;
import com.target.mothership.common.product.CategoryId;
import com.target.mothership.common.product.EndecaId;
import com.target.mothership.model.typeahead.interfaces.ProductSubSuggestion;
import com.target.mothership.util.k;

public class TGTProductSubSuggestion
    implements ProductSubSuggestion
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTProductSubSuggestion a(Parcel parcel)
        {
            return new TGTProductSubSuggestion(parcel);
        }

        public TGTProductSubSuggestion[] a(int i)
        {
            return new TGTProductSubSuggestion[i];
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
    private CategoryId mCategoryId;
    private EndecaId mEndecaId;
    private String mLabel;

    TGTProductSubSuggestion()
    {
    }

    TGTProductSubSuggestion(Parcel parcel)
    {
        a(parcel);
    }

    public String a()
    {
        return mLabel;
    }

    public void a(Parcel parcel)
    {
        mLabel = parcel.readString();
        mCategoryId = (CategoryId)parcel.readParcelable(com/target/mothership/common/product/CategoryId.getClassLoader());
    }

    public void a(CategoryId categoryid)
    {
        mCategoryId = categoryid;
    }

    public void a(EndecaId endecaid)
    {
        mEndecaId = endecaid;
    }

    public void a(String s)
    {
        mLabel = s;
    }

    public e b()
    {
        return k.a(mCategoryId);
    }

    public e c()
    {
        return k.a(mEndecaId);
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(mLabel);
        parcel.writeParcelable(mCategoryId, 1);
    }

}
