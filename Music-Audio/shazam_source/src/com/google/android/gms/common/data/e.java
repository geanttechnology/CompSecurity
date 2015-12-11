// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.data;

import android.database.CursorWindow;
import android.os.Bundle;
import com.google.android.gms.common.internal.v;
import com.google.android.gms.common.internal.w;
import java.util.Arrays;

// Referenced classes of package com.google.android.gms.common.data:
//            DataHolder

public abstract class e
{

    public final DataHolder a;
    public int b;
    private int c;

    public e(DataHolder dataholder, int i)
    {
        a = (DataHolder)w.a(dataholder);
        boolean flag;
        if (i >= 0 && i < a.h)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        w.a(flag);
        b = i;
        c = a.a(b);
    }

    public final int a(String s)
    {
        DataHolder dataholder = a;
        int i = b;
        int j = c;
        dataholder.a(s, i);
        return dataholder.d[j].getInt(i, dataholder.c.getInt(s));
    }

    public final String b(String s)
    {
        return a.a(s, b, c);
    }

    public final byte[] c(String s)
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
            if (v.a(Integer.valueOf(((e) (obj)).b), Integer.valueOf(b)))
            {
                flag = flag1;
                if (v.a(Integer.valueOf(((e) (obj)).c), Integer.valueOf(c)))
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

    public int hashCode()
    {
        return Arrays.hashCode(new Object[] {
            Integer.valueOf(b), Integer.valueOf(c), a
        });
    }
}
