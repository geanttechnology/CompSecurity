// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Rect;

public class fn
{

    public static Rect a(Rect rect, Rect rect1)
    {
        float f = (float)rect.width() / (float)rect1.width();
        float f1 = (float)rect.height() / (float)rect1.height();
        if (Math.floor((float)rect1.height() * f) > (double)rect.height())
        {
            int i = (int)Math.floor((float)rect1.width() * f1);
            int k = rect.left;
            k = (rect.width() - i) / 2 + k;
            int i1 = rect.top;
            return new Rect(k, i1, i + k, rect.height() + i1);
        } else
        {
            int j = (int)Math.floor(f * (float)rect1.height());
            int l = rect.left;
            int j1 = rect.top;
            j1 = (rect.height() - j) / 2 + j1;
            return new Rect(l, j1, rect.width() + l, j + j1);
        }
    }
}
