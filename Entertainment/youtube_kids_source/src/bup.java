// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class bup
    implements Parcelable, bn
{

    public static final android.os.Parcelable.Creator CREATOR = new buq();
    public static final bup a = new bup();
    private final amx b;
    private List c;

    private bup()
    {
        b = new amx();
    }

    bup(amx amx1)
    {
        b.a(amx1);
        boolean flag;
        if (amx1.a.length > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        b.b(flag);
        b = amx1;
    }

    private List a()
    {
        if (c == null)
        {
            c = new ArrayList();
            amy aamy[] = b.a;
            int j = aamy.length;
            for (int i = 0; i < j; i++)
            {
                amy amy = aamy[i];
                c.add((new buv(amy)).a());
            }

            c = Collections.unmodifiableList(c);
        }
        return c;
    }

    public final int describeContents()
    {
        return 0;
    }

    public final boolean equals(Object obj)
    {
        if (obj != null && getClass().equals(obj.getClass()))
        {
            obj = (bup)obj;
            if (b.a(a(), ((bup) (obj)).a()))
            {
                return true;
            }
        }
        return false;
    }

    public final String toString()
    {
        String s = String.valueOf(a().toString());
        if (s.length() != 0)
        {
            return "Survey ".concat(s);
        } else
        {
            return new String("Survey ");
        }
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        a.a(parcel, b);
    }

    static 
    {
        new bus();
    }
}
