// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.data;

import android.database.CursorWindow;
import android.net.Uri;
import android.os.Bundle;
import com.google.android.gms.internal.gw;
import com.google.android.gms.internal.ha;
import java.util.Arrays;

// Referenced classes of package com.google.android.gms.common.data:
//            DataHolder

public abstract class e
{

    public final DataHolder a;
    public final int b;
    private final int c;

    public e(DataHolder dataholder, int i)
    {
        a = (DataHolder)ha.a(dataholder);
        boolean flag;
        if (i >= 0 && i < dataholder.h)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        ha.a(flag);
        b = i;
        c = dataholder.a(b);
    }

    public final long a(String s)
    {
        DataHolder dataholder = a;
        int i = b;
        int j = c;
        dataholder.a(s, i);
        return dataholder.d[j].getLong(i, dataholder.c.getInt(s));
    }

    public final int b(String s)
    {
        DataHolder dataholder = a;
        int i = b;
        int j = c;
        dataholder.a(s, i);
        return dataholder.d[j].getInt(i, dataholder.c.getInt(s));
    }

    public final boolean c(String s)
    {
        DataHolder dataholder = a;
        int i = b;
        int j = c;
        dataholder.a(s, i);
        return Long.valueOf(dataholder.d[j].getLong(i, dataholder.c.getInt(s))).longValue() == 1L;
    }

    public final String d(String s)
    {
        return a.a(s, b, c);
    }

    public final byte[] e(String s)
    {
        DataHolder dataholder = a;
        int i = b;
        int j = c;
        dataholder.a(s, i);
        return dataholder.d[j].getBlob(i, dataholder.c.getInt(s));
    }

    public boolean equals(Object obj)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (obj instanceof e)
        {
            obj = (e)obj;
            flag = flag1;
            if (gw.a(Integer.valueOf(((e) (obj)).b), Integer.valueOf(b)))
            {
                flag = flag1;
                if (gw.a(Integer.valueOf(((e) (obj)).c), Integer.valueOf(c)))
                {
                    flag = flag1;
                    if (((e) (obj)).a == a)
                    {
                        flag = true;
                    }
                }
            }
        }
        return flag;
    }

    public final Uri f(String s)
    {
        s = a.a(s, b, c);
        if (s == null)
        {
            return null;
        } else
        {
            return Uri.parse(s);
        }
    }

    public final boolean g(String s)
    {
        DataHolder dataholder = a;
        int i = b;
        int j = c;
        dataholder.a(s, i);
        return dataholder.d[j].isNull(i, dataholder.c.getInt(s));
    }

    public int hashCode()
    {
        return Arrays.hashCode(new Object[] {
            Integer.valueOf(b), Integer.valueOf(c), a
        });
    }
}
