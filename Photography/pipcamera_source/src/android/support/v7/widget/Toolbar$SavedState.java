// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.os.Parcel;
import android.os.Parcelable;

class b extends android.view.
{

    public static final android.os.bar.SavedState.b CREATOR = new android.os.Parcelable.Creator() {

        public Toolbar.SavedState a(Parcel parcel)
        {
            return new Toolbar.SavedState(parcel);
        }

        public Toolbar.SavedState[] a(int i)
        {
            return new Toolbar.SavedState[i];
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
    public boolean b;

    public void writeToParcel(Parcel parcel, int i)
    {
        super.writeToParcel(parcel, i);
        parcel.writeInt(a);
        if (b)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
    }


    public _cls1(Parcel parcel)
    {
        super(parcel);
        a = parcel.readInt();
        boolean flag;
        if (parcel.readInt() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        b = flag;
    }

    public b(Parcelable parcelable)
    {
        super(parcelable);
    }
}
