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

        private long g;
        private long h;

        static long a(a a1)
        {
            return a1.g;
        }

        static long b(a a1)
        {
            return a1.h;
        }

        public a a(int i)
        {
            a = i;
            return this;
        }

        public a a(long l)
        {
            g = l;
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

        protected void a()
        {
            super.a();
            if (g == -1L)
            {
                throw new IllegalArgumentException("Must call setPeriod(long) to establish an execution interval for this periodic task.");
            }
            if (h == -1L)
            {
                h = (long)((float)g * 0.1F);
            }
        }

        public a b(long l)
        {
            h = l;
            return this;
        }

        public a b(boolean flag)
        {
            e = flag;
            return this;
        }

        public PeriodicTask b()
        {
            a();
            return new PeriodicTask(this, null);
        }

        public a c(boolean flag)
        {
            d = flag;
            return this;
        }

        public a()
        {
            g = -1L;
            h = -1L;
            e = true;
        }
    }


    public static final android.os.Parcelable.Creator CREATOR = new _cls1();
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

    PeriodicTask(Parcel parcel, _cls1 _pcls1)
    {
        this(parcel);
    }

    private PeriodicTask(a a1)
    {
        super(a1);
        a = -1L;
        b = -1L;
        a = a.a(a1);
        b = a.b(a1);
    }

    PeriodicTask(a a1, _cls1 _pcls1)
    {
        this(a1);
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


    /* member class not found */
    class _cls1 {}

}
