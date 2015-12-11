// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;
import android.os.Parcelable;

public final class ri
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new rj();
    public final rk a;
    public final bxb b;
    public final boolean c;
    public final bfz d;
    public final buz e;
    public final int f;

    public ri(Parcel parcel)
    {
        ClassLoader classloader = getClass().getClassLoader();
        a = new rk(parcel);
        b = (bxb)parcel.readParcelable(classloader);
        boolean flag;
        if (parcel.readInt() == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        c = flag;
        d = (bfz)parcel.readParcelable(classloader);
        e = (buz)parcel.readParcelable(classloader);
        f = parcel.readInt();
    }

    public ri(rk rk1, bxb bxb1, boolean flag, bfz bfz1, buz buz1, int i)
    {
        a = rk1;
        b = bxb1;
        c = flag;
        d = bfz1;
        e = buz1;
        f = i;
    }

    public final int describeContents()
    {
        return 0;
    }

    public final String toString()
    {
        String s = String.valueOf(Integer.toHexString(System.identityHashCode(this)));
        String s1 = String.valueOf(a);
        String s2 = String.valueOf(b);
        boolean flag = c;
        String s3 = String.valueOf(d);
        String s4 = String.valueOf(e);
        int i = f;
        return (new StringBuilder(String.valueOf(s).length() + 130 + String.valueOf(s1).length() + String.valueOf(s2).length() + String.valueOf(s3).length() + String.valueOf(s4).length())).append("DirectorSavedState{").append(s).append(" contentVideoState=").append(s1).append(" playerResponse=").append(s2).append(" userInitiatedPlayback=").append(flag).append(" adBreak=").append(s3).append(" ad=").append(s4).append(" adStartPositionMillis=").append(i).append("}").toString();
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        boolean flag = true;
        rk rk1 = a;
        if (rk1.a)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
        if (rk1.b)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
        parcel.writeInt(rk1.c);
        parcel.writeString(rk1.d);
        parcel.writeParcelable(rk1.e, 0);
        parcel.writeParcelable(rk1.f, 0);
        parcel.writeParcelable(b, 0);
        if (c)
        {
            i = ((flag) ? 1 : 0);
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
        parcel.writeParcelable(d, 0);
        parcel.writeParcelable(e, 0);
        parcel.writeInt(f);
    }

}
