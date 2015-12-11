// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.content.res.Resources;
import android.view.View;
import com.smule.android.network.models.SongV2;
import com.smule.pianoandroid.ads.j;
import com.smule.pianoandroid.utils.o;
import com.smule.pianoandroid.utils.q;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            GoodJobActivity

class a
    implements Runnable
{

    final sh a;

    public void run()
    {
        GoodJobActivity.a(a.a, true);
        q.o(GoodJobActivity.d(a.a).songId);
        if (!GoodJobActivity.g(a.a).a(a.a, 0x7f0a0063))
        {
            a.a.setResult(2);
            a.a.finish();
        }
    }

    ( )
    {
        a = ;
        super();
    }

    // Unreferenced inner class com/smule/pianoandroid/magicpiano/GoodJobActivity$3

/* anonymous class */
    class GoodJobActivity._cls3
        implements android.view.View.OnClickListener
    {

        final GoodJobActivity a;

        public void onClick(View view)
        {
            view = new GoodJobActivity._cls3._cls1(this);
            if (GoodJobActivity.h(a))
            {
                o.a(a, view, view, a.getResources().getString(0x7f0c020e), a.getResources().getString(0x7f0c020d));
                return;
            } else
            {
                view.run();
                return;
            }
        }

            
            {
                a = goodjobactivity;
                super();
            }
    }

}
