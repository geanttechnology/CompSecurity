// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package netswipe;

import android.graphics.Bitmap;
import android.util.SparseArray;

public class da
{

    private SparseArray a;

    public da()
    {
        a = new SparseArray();
    }

    public Bitmap a(int i)
    {
        return (Bitmap)a.get(i);
    }

    public void a()
    {
        for (int i = 0; i < a.size(); i++)
        {
            if (a.valueAt(i) != null)
            {
                ((Bitmap)a.valueAt(i)).recycle();
                a.setValueAt(i, null);
            }
        }

        a.clear();
        System.gc();
    }

    public void a(int i, Bitmap bitmap)
    {
        if (i != -1)
        {
            a.put(i, bitmap);
        }
    }

    public boolean b(int i)
    {
        return a(i) != null;
    }
}
