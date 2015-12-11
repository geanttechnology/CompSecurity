// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.cast.CastDevice;

public abstract class ame
    implements Parcelable
{

    private final amf a;

    protected ame(amf amf1)
    {
        a = amf1;
    }

    public static final ame a(Bundle bundle)
    {
        CastDevice castdevice = CastDevice.a(bundle);
        if (castdevice != null)
        {
            return new alo(castdevice);
        } else
        {
            return (ame)bundle.getParcelable("screen");
        }
    }

    public abstract String a();

    public abstract String b();

    public abstract boolean c();

    public alo d()
    {
        throw new UnsupportedOperationException();
    }

    public int describeContents()
    {
        return 0;
    }

    public alq e()
    {
        throw new UnsupportedOperationException();
    }

    public boolean equals(Object obj)
    {
        while (obj == null || !getClass().equals(obj.getClass()) || ((ame)obj).a != a) 
        {
            return false;
        }
        return true;
    }

    public als f()
    {
        throw new UnsupportedOperationException();
    }

    public final boolean g()
    {
        return a == amf.a;
    }

    public final boolean h()
    {
        return a == amf.b;
    }

    public int hashCode()
    {
        return a.hashCode();
    }

    public final boolean i()
    {
        return a == amf.c;
    }

    public void writeToParcel(Parcel parcel, int j)
    {
        parcel.writeByte(a.d);
    }
}
