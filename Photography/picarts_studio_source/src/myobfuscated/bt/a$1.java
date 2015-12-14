// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.bt;

import android.view.View;
import com.socialin.android.dropbox.a;

// Referenced classes of package myobfuscated.bt:
//            a, c

final class it>
    implements android.view..OnClickListener
{

    private a a;
    private myobfuscated.bt.a b;

    public final void onClick(View view)
    {
        if (a.c)
        {
            myobfuscated.bt.a.a(b).a(a.b);
        } else
        if ("dropboxMethodGet".equals(myobfuscated.bt.a.a(b).a))
        {
            myobfuscated.bt.a.a(b, a);
            return;
        }
    }

    .dropbox.a(myobfuscated.bt.a a1, a a2)
    {
        b = a1;
        a = a2;
        super();
    }
}
