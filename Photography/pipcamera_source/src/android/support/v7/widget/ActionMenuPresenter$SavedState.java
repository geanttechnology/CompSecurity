// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.os.Parcel;
import android.os.Parcelable;

class a
    implements Parcelable
{

    public static final android.os.ter.SavedState.a CREATOR = new android.os.Parcelable.Creator() {

        public ActionMenuPresenter.SavedState a(Parcel parcel)
        {
            return new ActionMenuPresenter.SavedState(parcel);
        }

        public ActionMenuPresenter.SavedState[] a(int i)
        {
            return new ActionMenuPresenter.SavedState[i];
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
    public int a;

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeInt(a);
    }


    _cls1()
    {
    }

    _cls1(Parcel parcel)
    {
        a = parcel.readInt();
    }
}
