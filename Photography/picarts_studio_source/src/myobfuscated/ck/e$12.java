// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.ck;

import android.view.View;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.util.Utils;

// Referenced classes of package myobfuscated.ck:
//            e, c, f

final class t>
    implements android.view.OnClickListener
{

    private e a;

    public final void onClick(View view)
    {
        if (e.a(a).d)
        {
            view = e.d(a);
            AnalyticUtils.getInstance(view).trackLocalAction("effect:apply");
            if (e.a(a).e)
            {
                e.b(a);
                return;
            }
            if (e.h(a) != null)
            {
                if (e.h(a).s())
                {
                    a.o();
                    return;
                } else
                {
                    Utils.b(view, 0x7f0805ca);
                    return;
                }
            }
        }
    }

    util.Utils(e e1)
    {
        a = e1;
        super();
    }
}
