// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.collages;

import java.util.ArrayList;

// Referenced classes of package com.picsart.collages:
//            e, CollageCreatorView, a, CollageImage, 
//            b

final class a
    implements Runnable
{

    private String a[];
    private e b;

    public final void run()
    {
        ArrayList arraylist = e.b(b).b;
        int k = arraylist.size();
        int l = a.length;
        int i;
        int j;
        if (e.b(b).d != -1 && e.b(b).b != null && e.b(b).b.size() > 0 && e.b(b).e().d == null)
        {
            CollageImage collageimage = new CollageImage(false, a[0], null, e.r(b)[0]);
            e.b(b).setImageToCell(collageimage, e.b(b).d, false, null, true);
            e.s(b).a();
            i = 1;
        } else
        {
            i = 0;
        }
        for (j = 0; j < k && i < l; j++)
        {
            a a1 = (a)arraylist.get(j);
            if (a1.d == null && !a1.v && e.b(b).d != j)
            {
                e.b(b).setImageToCell(new CollageImage(false, a[i], null, e.r(b)[i]), j, false, null, true);
                i++;
            }
        }

    }

    geImage(e e1, String as[])
    {
        b = e1;
        a = as;
        super();
    }
}
