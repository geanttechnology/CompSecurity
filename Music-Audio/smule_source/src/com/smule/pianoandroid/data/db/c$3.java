// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.data.db;

import android.app.Activity;
import com.smule.android.c.aa;
import java.util.Observable;
import java.util.Observer;

// Referenced classes of package com.smule.pianoandroid.data.db:
//            c

class a
    implements Observer
{

    final c a;

    public void update(Observable observable, Object obj)
    {
        aa.c(c.f, "Scores synced");
        if (c.b(a) != null)
        {
            c.b(c.d()).runOnUiThread(new Runnable() {

                final c._cls3 a;

                public void run()
                {
                    a.a.notifyDataSetChanged();
                }

            
            {
                a = c._cls3.this;
                super();
            }
            });
        }
    }

    _cls1.a(c c1)
    {
        a = c1;
        super();
    }
}
