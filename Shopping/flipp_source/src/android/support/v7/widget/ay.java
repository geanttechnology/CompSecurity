// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.util.SparseArray;
import android.util.SparseIntArray;
import java.util.ArrayList;

// Referenced classes of package android.support.v7.widget:
//            bi

public final class ay
{

    SparseArray a;
    int b;
    private SparseIntArray c;

    public ay()
    {
        a = new SparseArray();
        c = new SparseIntArray();
        b = 0;
    }

    final void a()
    {
        b = b + 1;
    }

    public final void a(bi bi1)
    {
        int i = bi1.e;
        ArrayList arraylist1 = (ArrayList)a.get(i);
        ArrayList arraylist = arraylist1;
        if (arraylist1 == null)
        {
            ArrayList arraylist2 = new ArrayList();
            a.put(i, arraylist2);
            arraylist = arraylist2;
            if (c.indexOfKey(i) < 0)
            {
                c.put(i, 5);
                arraylist = arraylist2;
            }
        }
        if (c.get(i) <= arraylist.size())
        {
            return;
        } else
        {
            bi1.o();
            arraylist.add(bi1);
            return;
        }
    }

    final void b()
    {
        b = b - 1;
    }
}
