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
    private String b;
    private c c;

    public final void onClick(View view)
    {
        myobfuscated.co.c.d(c).a(a, ItemControl.COMMENT_IMAGE, new Object[] {
            b
        });
    }

    .adapter.a(c c1, int i, String s)
    {
        c = c1;
        a = i;
        b = s;
        super();
    }
}
