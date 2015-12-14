// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.bt;

import com.socialin.android.dialog.g;
import com.socialin.android.net.e;
import java.util.List;

// Referenced classes of package myobfuscated.bt:
//            i

final class it>
    implements Runnable
{

    private List a;
    private String b;
    private i c;

    public final void run()
    {
        if (i.b(c) != null)
        {
            i.b(c).dismiss();
        }
        if (i.c(c) != null)
        {
            i.c(c).a(a, b, i.d(c));
        }
    }

    .net.e(i j, List list, String s)
    {
        c = j;
        a = list;
        b = s;
        super();
    }
}
