// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.db;

import android.view.View;

// Referenced classes of package myobfuscated.db:
//            a

final class it>
    implements android.view..OnClickListener
{

    private a a;

    public final void onClick(View view)
    {
label0:
        {
            view = a.getView();
            if (view != null)
            {
                view = view.findViewById(0x7f100757);
                if (view.getVisibility() != 0)
                {
                    break label0;
                }
                view.setVisibility(8);
            }
            return;
        }
        view.setVisibility(0);
    }

    ClickListener(a a1)
    {
        a = a1;
        super();
    }
}
