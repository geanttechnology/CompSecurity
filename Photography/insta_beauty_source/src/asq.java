// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class asq
{

    private ArrayList a;

    public asq()
    {
        a = new ArrayList(2);
    }

    protected void a(int i, Object obj)
    {
        ArrayList arraylist = a;
        int j = arraylist.size() - 1;
        while (j >= 0) 
        {
            asr asr1 = (asr)((WeakReference)arraylist.get(j)).get();
            if (asr1 != null)
            {
                asr1.onStatusChange(i, obj);
            } else
            {
                arraylist.remove(j);
            }
            j--;
        }
    }

    public void a(asr asr1)
    {
        asr1 = new WeakReference(asr1);
        a.add(asr1);
    }

    public void b(asr asr1)
    {
        ArrayList arraylist = a;
        for (int i = arraylist.size() - 1; i >= 0; i--)
        {
            if ((asr)((WeakReference)arraylist.get(i)).get() == asr1)
            {
                arraylist.remove(i);
            }
        }

    }
}
