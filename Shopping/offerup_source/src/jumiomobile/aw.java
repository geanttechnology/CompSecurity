// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.graphics.Bitmap;
import android.util.SparseArray;

public class aw
{

    private SparseArray a;

    public aw()
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

    public boolean a(int i, Bitmap bitmap)
    {
        while (b(i) || i == -1 && bitmap == null) 
        {
            return false;
        }
        a.put(i, bitmap);
        return true;
    }

    public boolean b(int i)
    {
        return a(i) != null;
    }

    public void c(int i)
    {
        if (a(i) != null)
        {
            a(i).recycle();
            a.remove(i);
            System.gc();
        }
    }
}
