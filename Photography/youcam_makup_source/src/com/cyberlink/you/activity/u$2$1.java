// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.activity;

import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import com.cyberlink.you.g;
import com.cyberlink.you.utility.s;
import com.cyberlink.you.utility.u;

// Referenced classes of package com.cyberlink.you.activity:
//            u, v

class b
    implements Runnable
{

    final boolean a;
    final String b;
    final b c;

    public void run()
    {
        if (a && b.equals(u.a(c.c)))
        {
            java.util.List list = s.a().a(b);
            if (list != null)
            {
                u.b(c.c).clear();
                u.b(c.c).addAll(list);
                if (u.a(c.c).equals("New"))
                {
                    g.a().d(true);
                    if (u.a() != null)
                    {
                        u.a().setVisibility(8);
                    }
                }
            }
        }
        u.c(c.c).setVisibility(8);
        Log.v("StickerShopAcitvity", (new StringBuilder()).append("UpdateStickerShopTask ").append(b).append(" done").toString());
    }

    tivity(tivity tivity, boolean flag, String s1)
    {
        c = tivity;
        a = flag;
        b = s1;
        super();
    }

    // Unreferenced inner class com/cyberlink/you/activity/u$2

/* anonymous class */
    class u._cls2
        implements u
    {

        final com.cyberlink.you.activity.u a;

        public void a(String s1, boolean flag)
        {
            if (a.getActivity() == null)
            {
                return;
            } else
            {
                a.getActivity().runOnUiThread(new u._cls2._cls1(this, flag, s1));
                return;
            }
        }

            
            {
                a = u1;
                super();
            }
    }

}
