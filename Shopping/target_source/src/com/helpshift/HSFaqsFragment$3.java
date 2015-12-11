// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift;

import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import android.widget.ArrayAdapter;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.helpshift:
//            HSFaqsFragment, l, ab, g

class a extends Handler
{

    final HSFaqsFragment a;

    public void handleMessage(Message message)
    {
        int i = 0;
        boolean flag = false;
        super.handleMessage(message);
        new ArrayList();
        message = (ArrayList)message.obj;
        message = HSFaqsFragment.h(a).a(message);
        HSFaqsFragment.i(a).clear();
        if (message.size() == 1)
        {
            message = HSFaqsFragment.h(a).a(((ab)message.get(0)).a());
            for (i = ((flag) ? 1 : 0); i < message.size(); i++)
            {
                g g1 = (g)message.get(i);
                HSFaqsFragment.i(a).add(new g(g1.e(), g1.b(), "question"));
            }

        } else
        {
            for (; i < message.size(); i++)
            {
                ab ab1 = (ab)message.get(i);
                if (!HSFaqsFragment.h(a).a(ab1))
                {
                    HSFaqsFragment.i(a).add(new g(ab1.b(), ab1.a(), "section"));
                }
            }

        }
        if (HSFaqsFragment.i(a).size() == 0)
        {
            HSFaqsFragment.i(a).add(new g(a.getResources().getString(etString), "0", "empty_status"));
        }
        if (a.isResumed())
        {
            a.a(true);
        }
        HSFaqsFragment.j(a).notifyDataSetChanged();
    }

    (HSFaqsFragment hsfaqsfragment)
    {
        a = hsfaqsfragment;
        super();
    }
}
