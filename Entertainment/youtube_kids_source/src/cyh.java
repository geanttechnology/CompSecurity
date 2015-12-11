// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.util.SparseArray;
import java.util.ArrayList;
import java.util.List;

public final class cyh
    implements cpu
{

    private final SparseArray a = new SparseArray();

    public cyh()
    {
    }

    public cxx a(int i)
    {
        cxx cxx2 = (cxx)a.get(i);
        cxx cxx1 = cxx2;
        if (cxx2 == null)
        {
            cxx1 = new cxx(i);
            a.put(i, cxx1);
        }
        return cxx1;
    }

    public final cyh a(int i, String s, int j, int k)
    {
        a(i).a.a(s, j, k);
        return this;
    }

    public final Object b()
    {
        ArrayList arraylist = new ArrayList();
        for (int i = 0; i < a.size(); i++)
        {
            arraylist.add(((cxx)a.valueAt(i)).a());
        }

        return new cyg(arraylist);
    }
}
