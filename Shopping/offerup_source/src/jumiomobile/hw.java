// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.graphics.Point;
import android.graphics.Rect;

public class hw
{

    private Point a[];
    private int b;
    private int c;

    public hw(Point apoint[], int i, int j)
    {
        a = apoint;
        b(j);
        a(i);
    }

    public Rect a()
    {
        if (a == null || a.length < 4)
        {
            return new Rect(0, 0, b, c);
        }
        int i;
        int j;
        int k;
        int l;
        int j1;
        if (a[0].x < a[1].x)
        {
            i = a[0].x;
        } else
        {
            i = a[1].x;
        }
        if (a[1].y < a[2].y)
        {
            k = a[1].y;
        } else
        {
            k = a[2].y;
        }
        if (a[3].x > a[2].x)
        {
            j = a[3].x;
        } else
        {
            j = a[2].x;
        }
        if (a[0].y > a[3].y)
        {
            l = a[0].y;
        } else
        {
            l = a[3].y;
        }
        if (l < k)
        {
            int i1 = k;
            k = l;
            l = i1;
        }
        if (i > j)
        {
            j1 = j;
            j = i;
        } else
        {
            j1 = i;
        }
        return new Rect(j1, k, j, l);
    }

    public void a(int i)
    {
        b = i;
    }

    public void b(int i)
    {
        c = i;
    }
}
