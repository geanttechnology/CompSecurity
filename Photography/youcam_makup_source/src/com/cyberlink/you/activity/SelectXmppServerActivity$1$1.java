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
    implements Runnable
{

    final String a;
    final a b;

    public void run()
    {
        Toast.makeText(b.b.getBaseContext(), a, 0).show();
    }

    ( , String s)
    {
        b = ;
        a = s;
        super();
    }

    // Unreferenced inner class com/cyberlink/you/activity/SelectXmppServerActivity$1

/* anonymous class */
    class SelectXmppServerActivity._cls1
        implements p
    {

        final SelectXmppServerActivity a;

        public void a(String s)
        {
            a.a.post(new SelectXmppServerActivity._cls1._cls1(this, s));
        }

            
            {
                a = selectxmppserveractivity;
                super();
            }
    }

}
