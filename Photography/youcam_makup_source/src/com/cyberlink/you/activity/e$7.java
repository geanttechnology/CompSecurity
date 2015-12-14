// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.activity;

import android.view.View;
import com.cyberlink.you.database.MessageObj;

// Referenced classes of package com.cyberlink.you.activity:
//            e

class a
    implements android.view..OnClickListener
{

    final e a;

    public void onClick(View view)
    {
        view = (Integer)view.getTag();
        if (view != null)
        {
            int i = view.intValue();
            view = a.b(i);
            if (view != null && view.g() != null)
            {
                try
                {
                    long l = Long.valueOf(view.i()).longValue();
                    e.b(a, l);
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (View view)
                {
                    return;
                }
            }
        }
    }

    (e e1)
    {
        a = e1;
        super();
    }
}
