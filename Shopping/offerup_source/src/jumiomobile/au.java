// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.graphics.Path;
import android.graphics.Rect;

public class au
{

    public static Path a(Rect rect, int i, int j, int k, int l)
    {
        int i1 = rect.left;
        int j1 = rect.right;
        int k1 = rect.top;
        int l1 = rect.bottom;
        rect = new Path();
        if (i == 0)
        {
            rect.moveTo(i1, k1);
        } else
        {
            rect.moveTo(i1 + i, k1);
        }
        if (j == 0)
        {
            rect.lineTo(j1, k1);
        } else
        {
            rect.lineTo(j1 - i, k1);
            rect.quadTo(j1, k1, j1, k1 + j);
        }
        if (k == 0)
        {
            rect.lineTo(j1, l1);
        } else
        {
            rect.lineTo(j1, l1 - k);
            rect.quadTo(j1, l1, j1 - k, l1);
        }
        if (l == 0)
        {
            rect.lineTo(i1, l1);
        } else
        {
            rect.lineTo(i1 + l, l1);
            rect.quadTo(i1, l1, i1, l1 - l);
        }
        if (i == 0)
        {
            rect.lineTo(i1, k1);
        } else
        {
            rect.lineTo(i1, k1 + i);
            rect.quadTo(i1, k1, i1 + i, k1);
        }
        rect.close();
        return rect;
    }
}
