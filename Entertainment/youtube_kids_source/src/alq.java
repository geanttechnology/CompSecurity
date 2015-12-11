// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;

public final class alq extends ame
{

    public static final android.os.Parcelable.Creator CREATOR = new alr();
    final cgc a;

    public alq(cgc cgc1)
    {
        super(amf.a);
        a = cgc1;
    }

    public final String a()
    {
        return a.c.toString();
    }

    public final String b()
    {
        return a.d;
    }

    public final boolean c()
    {
        return false;
    }

    public final alq e()
    {
        return this;
    }

    public final boolean equals(Object obj)
    {
        if (!super.equals(obj))
        {
            return false;
        } else
        {
            return ((alq)obj).a.equals(a);
        }
    }

    public final int hashCode()
    {
        return (super.hashCode() + 131) * 131 + a.hashCode();
    }

    public final String toString()
    {
        String s = String.valueOf(a);
        return (new StringBuilder(String.valueOf(s).length() + 24)).append("MdxCloudScreen [screen=").append(s).append("]").toString();
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(a, i);
    }

}
