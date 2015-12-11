// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Writer;

// Referenced classes of package com.tapjoy.internal:
//            bs

public final class bt
    implements Parcelable, bs
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public final Object createFromParcel(Parcel parcel)
        {
            return new bt(parcel.readString());
        }

        public final volatile Object[] newArray(int i)
        {
            return new bt[i];
        }

    };
    public final String a;

    public bt(String s)
    {
        a = s;
    }

    public final void a(Writer writer)
    {
        writer.write(a);
    }

    public final int describeContents()
    {
        return 0;
    }

    public final boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj instanceof bt)
        {
            obj = (bt)obj;
            return a.equals(((bt) (obj)).a);
        } else
        {
            return false;
        }
    }

    public final int hashCode()
    {
        return a.hashCode();
    }

    public final String toString()
    {
        return a;
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(a);
    }

}
