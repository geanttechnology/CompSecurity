// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.d.a;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;

// Referenced classes of package com.d.a:
//            b

public class a extends b
{

    private AnimationDrawable m;
    private int n;

    public a(AnimationDrawable animationdrawable)
    {
        m = animationdrawable;
        a = ((BitmapDrawable)m.getFrame(0)).getBitmap();
        n = 0;
        int i = 0;
        do
        {
            if (i >= m.getNumberOfFrames())
            {
                return;
            }
            n = n + m.getDuration(i);
            i++;
        } while (true);
    }

    public boolean a(long l)
    {
        boolean flag;
        boolean flag1;
        flag = false;
        flag1 = super.a(l);
        if (!flag1) goto _L2; else goto _L1
_L1:
        int i;
        long l1;
        long l2 = 0L;
        long l3 = l - this.l;
        l = l3;
        i = ((flag) ? 1 : 0);
        l1 = l2;
        if (l3 > (long)n)
        {
            if (m.isOneShot())
            {
                return false;
            }
            l = l3 % (long)n;
            l1 = l2;
            i = ((flag) ? 1 : 0);
        }
_L6:
        if (i < m.getNumberOfFrames()) goto _L3; else goto _L2
_L2:
        return flag1;
_L3:
        l1 += m.getDuration(i);
        if (l1 <= l)
        {
            break; /* Loop/switch isn't completed */
        }
        a = ((BitmapDrawable)m.getFrame(i)).getBitmap();
        if (true) goto _L2; else goto _L4
_L4:
        i++;
        if (true) goto _L6; else goto _L5
_L5:
    }
}
