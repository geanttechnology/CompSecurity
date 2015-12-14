// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.brushlib.input.gesture;

import com.picsart.collages.CollageCreatorView;
import com.picsart.collages.a;
import com.picsart.collages.c;
import java.util.ArrayList;

public class f
{

    public CollageCreatorView a;

    public f(CollageCreatorView collagecreatorview)
    {
        a = collagecreatorview;
        super();
    }

    public void a(float f1, float f2)
    {
        int j = CollageCreatorView.l(a).size();
        int i = 0;
        do
        {
label0:
            {
                a a1;
label1:
                {
                    if (i < j)
                    {
                        a1 = (a)CollageCreatorView.l(a).get(i);
                        if (!a1.a((int)(f1 - CollageCreatorView.d(a)), (int)(f2 - CollageCreatorView.e(a))))
                        {
                            break label0;
                        }
                        CollageCreatorView.b(a, i);
                        CollageCreatorView.a(a, i);
                        if (((a)CollageCreatorView.l(a).get(i)).d != null)
                        {
                            break label1;
                        }
                        CollageCreatorView.E(a).a();
                    }
                    return;
                }
                CollageCreatorView.a(a, a1.d);
                CollageCreatorView.a(a, f1, f2);
                return;
            }
            i++;
        } while (true);
    }
}
