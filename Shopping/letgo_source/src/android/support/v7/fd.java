// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.widget.ImageView;

// Referenced classes of package android.support.v7:
//            ew, aik, ajl, aij, 
//            ait

public class fd extends ew
{

    private final aij a;
    private final aik b = aik.a();

    public fd(ait ait)
    {
        aij.a a1 = (new aij.a()).a(0x106000d).b(0x7f0200d7).c(0x106000d).a(true).b(true);
        if (ait != null)
        {
            a1.a(ait);
        }
        a = a1.a();
    }

    public void a(String s, ImageView imageview, ew.a a1)
    {
        a1 = new ajl(imageview, false);
        b.a(s, a1, a);
        imageview.setTag(s);
    }
}
