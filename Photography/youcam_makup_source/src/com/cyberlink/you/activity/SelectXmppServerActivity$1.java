// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.activity;

import android.widget.ListView;
import android.widget.Toast;
import com.cyberlink.you.chat.p;

// Referenced classes of package com.cyberlink.you.activity:
//            SelectXmppServerActivity

class a
    implements p
{

    final SelectXmppServerActivity a;

    public void a(String s)
    {
        a.a.post(new Runnable(s) {

            final String a;
            final SelectXmppServerActivity._cls1 b;

            public void run()
            {
                Toast.makeText(b.a.getBaseContext(), a, 0).show();
            }

            
            {
                b = SelectXmppServerActivity._cls1.this;
                a = s;
                super();
            }
        });
    }

    _cls1.a(SelectXmppServerActivity selectxmppserveractivity)
    {
        a = selectxmppserveractivity;
        super();
    }
}
