// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.gcm;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.x;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.google.android.gms.gcm:
//            a

public abstract class Task
    implements Parcelable
{
    public static abstract class a
    {

        protected int a;
        protected String b;
        protected String c;
        protected boolean d;
        protected boolean e;
        protected boolean f;
        protected Bundle g;

        protected void b()
        {
            boolean flag;
            if (b != null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            x.b(flag, "Must provide an endpoint for this task by calling setService(ComponentName).");
            com.google.android.gms.gcm.a.a(c);
            if (e)
            {
                Task.b(g);
            }
        }

        public a()
        {
        }
    }


    private final String a;
    private final String b;
    private final boolean c;
    private final boolean d;
    private final int e;
    private final boolean f;
    private final Bundle g;

    Task(Parcel parcel)
    {
        boolean flag1 = true;
        super();
        a = parcel.readString();
        b = parcel.readString();
        boolean flag;
        if (parcel.readInt() == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        c = flag;
        if (parcel.readInt() == 1)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        d = flag;
        e = 2;
        f = false;
        g = null;
    }

    Task(a a1)
    {
        a = a1.b;
        b = a1.c;
        c = a1.d;
        d = a1.e;
        e = a1.a;
        f = a1.f;
        g = a1.g;
    }

    private static boolean a(Object obj)
    {
        return (obj instanceof Integer) || (obj instanceof Long) || (obj instanceof Double) || (obj instanceof String) || (obj instanceof Boolean);
    }

    public static void b(Bundle bundle)
    {
label0:
        {
            if (bundle == null)
            {
                break label0;
            }
            Object obj = Parcel.obtain();
            bundle.writeToParcel(((Parcel) (obj)), 0);
            int i = ((Parcel) (obj)).dataSize();
            if (i > 10240)
            {
                ((Parcel) (obj)).recycle();
                throw new IllegalArgumentException((new StringBuilder()).append("Extras exceeding maximum size(10240 bytes): ").append(i).toString());
            }
            ((Parcel) (obj)).recycle();
            obj = bundle.keySet().iterator();
            do
            {
                if (!((Iterator) (obj)).hasNext())
                {
                    break label0;
                }
            } while (a(bundle.get((String)((Iterator) (obj)).next())));
            throw new IllegalArgumentException("Only the following extra parameter types are supported: Integer, Long, Double, String, and Boolean. ");
        }
    }

    public void a(Bundle bundle)
    {
        bundle.putString("tag", b);
        bundle.putBoolean("update_current", c);
        bundle.putBoolean("persisted", d);
        bundle.putString("service", a);
        bundle.putInt("requiredNetwork", e);
        bundle.putBoolean("requiresCharging", f);
        bundle.putBundle("extras", g);
    }

    public String c()
    {
        return a;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        boolean flag = true;
        parcel.writeString(a);
        parcel.writeString(b);
        if (c)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
        if (d)
        {
            i = ((flag) ? 1 : 0);
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
    }
}
