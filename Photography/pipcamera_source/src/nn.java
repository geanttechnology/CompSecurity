// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class nn
{

    private ArrayList a;

    public nn()
    {
        a = new ArrayList(2);
    }

    protected void a(int i, Object obj)
    {
        ArrayList arraylist = a;
        int j = arraylist.size() - 1;
        while (j >= 0) 
        {
            no no1 = (no)((WeakReference)arraylist.get(j)).get();
            if (no1 != null)
            {
                no1.onStatusChange(i, obj);
            } else
            {
                arraylist.remove(j);
            }
            j--;
        }
    }

    public void a(no no1)
    {
        no1 = new WeakReference(no1);
        a.add(no1);
    }

    public void b(no no1)
    {
        ArrayList arraylist = a;
        for (int i = arraylist.size() - 1; i >= 0; i--)
        {
            if ((no)((WeakReference)arraylist.get(i)).get() == no1)
            {
                arraylist.remove(i);
            }
        }

    }
}
