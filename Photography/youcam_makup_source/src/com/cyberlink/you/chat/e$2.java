// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.chat;

import android.view.View;
import android.widget.TextView;
import com.cyberlink.you.database.Group;
import com.cyberlink.you.n;

// Referenced classes of package com.cyberlink.you.chat:
//            e, UnreadCountManager, f

class b
    implements Runnable
{

    final Group a;
    final f b;
    final e c;

    public void run()
    {
        int i = UnreadCountManager.b().b(a.c);
        if (i > 0)
        {
            if (i > 99)
            {
                b.e.setText("N");
            } else
            {
                b.e.setText(String.valueOf(i));
            }
            b.e.setVisibility(0);
            b.j.setVisibility(8);
            b.k.setVisibility(0);
            b.e.setBackgroundResource(n.u_chat_unread);
            return;
        } else
        {
            b.k.setVisibility(4);
            return;
        }
    }

    Group(e e1, Group group, f f1)
    {
        c = e1;
        a = group;
        b = f1;
        super();
    }
}
