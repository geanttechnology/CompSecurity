// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.widget;

import android.os.Parcel;
import android.os.Parcelable;

// Referenced classes of package android.support.v7.internal.widget:
//            AbsSpinnerCompat

static class b extends android.view.nnerCompat.SavedState
{

    public static final android.os.pinnerCompat.SavedState.b CREATOR = new android.os.Parcelable.Creator() {

        public AbsSpinnerCompat.SavedState a(Parcel parcel)
        {
            return new AbsSpinnerCompat.SavedState(parcel);
        }

        public AbsSpinnerCompat.SavedState[] a(int i)
        {
            return new AbsSpinnerCompat.SavedState[i];
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
    long a;
    int b;

    public String toString()
    {
        return (new StringBuilder()).append("AbsSpinner.SavedState{").append(Integer.toHexString(System.identityHashCode(this))).append(" selectedId=").append(a).append(" position=").append(b).append("}").toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        super.arcel(parcel, i);
        parcel.writeLong(a);
        parcel.writeInt(b);
    }


    _cls1(Parcel parcel)
    {
        super(parcel);
        a = parcel.readLong();
        b = parcel.readInt();
    }

    b(Parcelable parcelable)
    {
        super(parcelable);
    }
}
