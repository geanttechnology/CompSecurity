// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;

public class l extends RuntimeException
{

    public l()
    {
    }

    public l(String s)
    {
        super(s);
    }

    public l(String s, Parcel parcel)
    {
        super((new StringBuilder()).append(s).append(" Parcel: pos=").append(parcel.dataPosition()).append(" size=").append(parcel.dataSize()).toString());
    }

    public l(String s, Exception exception)
    {
        super(s, exception);
    }
}
