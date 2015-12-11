// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;
import android.os.Parcelable;

public final class als extends ame
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new alt();
    public final cgw a;

    public als(cgw cgw1)
    {
        super(amf.b);
        a = cgw1;
    }

    public final String a()
    {
        return a.g.toString();
    }

    public final String b()
    {
        return a.c;
    }

    public final boolean c()
    {
        return true;
    }

    public final boolean equals(Object obj)
    {
        if (!super.equals(obj))
        {
            return false;
        } else
        {
            return ((als)obj).a.equals(a);
        }
    }

    public final als f()
    {
        return this;
    }

    public final int hashCode()
    {
        return (super.hashCode() + 131) * 131 + a.hashCode();
    }

    public final String toString()
    {
        String s = String.valueOf(a);
        return (new StringBuilder(String.valueOf(s).length() + 23)).append("MdxDialScreen [device=").append(s).append("]").toString();
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(a, i);
    }

}
