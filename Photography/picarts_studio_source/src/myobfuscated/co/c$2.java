// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.co;

import android.view.View;
import com.picsart.studio.utils.ItemControl;
import com.socialin.android.adapter.a;

// Referenced classes of package myobfuscated.co:
//            c

final class it>
    implements android.view..OnClickListener
{

    private int a;
    private c b;

    public final void onClick(View view)
    {
        c.b(b).a(a, ItemControl.OWNER_IMAGE, new Object[0]);
    }

    .adapter.a(c c1, int i)
    {
        b = c1;
        a = i;
        super();
    }
}
