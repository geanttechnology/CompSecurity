// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.collages;

import java.util.ArrayList;
import java.util.HashMap;

// Referenced classes of package com.picsart.collages:
//            e, CollageCreatorView, CollageImage

final class d
    implements Runnable
{

    private boolean a;
    private HashMap b;
    private String c;
    private int d;
    private e e;

    public final void run()
    {
        if (com.picsart.collages.e.b(e).d != -1 && com.picsart.collages.e.b(e).b != null && !com.picsart.collages.e.b(e).b.isEmpty())
        {
            CollageCreatorView collagecreatorview = com.picsart.collages.e.b(e);
            boolean flag;
            if (a && b != null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            collagecreatorview.setImageToCell(new CollageImage(flag, c, b, d), com.picsart.collages.e.b(e).d, false, null, true);
        }
    }

    geImage(e e1, boolean flag, HashMap hashmap, String s, int i)
    {
        e = e1;
        a = flag;
        b = hashmap;
        c = s;
        d = i;
        super();
    }
}
