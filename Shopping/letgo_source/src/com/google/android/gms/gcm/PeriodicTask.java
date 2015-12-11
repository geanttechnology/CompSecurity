// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.gcm;

import android.os.Bundle;
import android.os.Parcel;

// Referenced classes of package com.google.android.gms.gcm:
//            Task

public class PeriodicTask extends Task
{
    public static class a extends Task.a
    {

        private long h;
        private long i;

        static long a(a a1)
        {
            return a1.h;
        }

        static long b(a a1)
        {
            return a1.i;
        }

        public a a(int j)
        {
            a = j;
            return this;
        }

        public a a(long l)
        {
            h = l;
            return this;
        }

        public a a(Class class1)
        {
            b = class1.getName();
            return this;
        }

        public a a(String s)
        {
            c = s;
            return this;
        }

        public a a(boolean flag)
        {
            f = flag;
            return this;
        }

        public PeriodicTask a()
        {
            b();
            return new PeriodicTask(this);
        }

        public a b(long l)
        {
            i = l;
            return this;
        }

        public a b(boolean flag)
        {
            e = flag;
            return this;
        }

        protected void b()
        {
            super.b();
            if (h == -1L)
            {
                throw new IllegalArgumentException("Must call setPeriod(long) to establish an execution interval for this periodic task.");
            }
            if (i == -1L)
            {
                i = (long)((float)h * 0.1F);
            }
        }

        public a c(boolean flag)
        {
            d = flag;
            return this;
        }

        public a()
        {
            h = -1L;
            i = -1L;
            e = true;
        }
    }


    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public PeriodicTask a(Parcel parcel)
        {
            return new PeriodicTask(parcel);
        }

        public PeriodicTask[] a(int i)
        {
            return new PeriodicTask[i];
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
    protected long a;
    protected long b;

    private PeriodicTask(Parcel parcel)
    {
        super(parcel);
        a = -1L;
        b = -1L;
        a = parcel.readLong();
        b = parcel.readLong();
    }


    private PeriodicTask(a a1)
    {
        super(a1);
        a = -1L;
        b = -1L;
        a = a.a(a1);
        b = a.b(a1);
    }


    public long a()
    {
        return a;
    }

    public void a(Bundle bundle)
    {
        super.a(bundle);
        bundle.putLong("period", a);
        bundle.putLong("period_flex", b);
    }

    public long b()
    {
        return b;
    }

    public String toString()
    {
        return (new StringBuilder()).append(super.toString()).append(" ").append("period=").append(a()).append(" ").append("flex=").append(b()).toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        super.writeToParcel(parcel, i);
        parcel.writeLong(a);
        parcel.writeLong(b);
    }

}
