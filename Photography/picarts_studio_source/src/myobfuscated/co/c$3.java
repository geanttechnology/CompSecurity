// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.co;

import android.view.View;
import com.picsart.studio.utils.ItemControl;
import com.socialin.android.adapter.a;
import myobfuscated.ct.c;

// Referenced classes of package myobfuscated.co:
//            c

final class nit> extends c
{

    private int b;
    private myobfuscated.co.c c;

    public final void onClick(View view)
    {
        myobfuscated.co.c.c(c).a(b, ItemControl.OWNER_IMAGE, new Object[0]);
    }

    .adapter.a(myobfuscated.co.c c1, int i, int j, int k)
    {
        c = c1;
        b = k;
        super(0xff000000, i, j, 1);
    }
}
