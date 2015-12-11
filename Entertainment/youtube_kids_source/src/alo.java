// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;
import com.google.android.gms.cast.CastDevice;

public final class alo extends ame
{

    public static final android.os.Parcelable.Creator CREATOR = new alp();
    final CastDevice a;

    public alo(CastDevice castdevice)
    {
        super(amf.c);
        a = castdevice;
    }

    public final String a()
    {
        return a.b;
    }

    public final String b()
    {
        return a.d;
    }

    public final boolean c()
    {
        return true;
    }

    public final alo d()
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
            return ((alo)obj).a.equals(a);
        }
    }

    public final int hashCode()
    {
        return (super.hashCode() + 131) * 131 + a.hashCode();
    }

    public final String toString()
    {
        String s = String.valueOf(a);
        return (new StringBuilder(String.valueOf(s).length() + 23)).append("MdxCastScreen [device=").append(s).append("]").toString();
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(a, i);
    }

}
