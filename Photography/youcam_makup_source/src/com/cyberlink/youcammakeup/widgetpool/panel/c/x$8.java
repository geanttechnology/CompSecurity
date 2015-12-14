// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.panel.c;

import android.util.Log;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.e;
import java.util.List;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.panel.c:
//            x, r

class a
    implements e
{

    final x a;

    public volatile void a(Object obj)
    {
        a((List)obj);
    }

    public void a(List list)
    {
        Log.d("LookEffectPanel", "getTemplateMetadata complete");
        if (list == null)
        {
            return;
        } else
        {
            Globals.d(new Runnable(list) {

                final List a;
                final x._cls8 b;

                public void run()
                {
                    x.a(b.a).c();
                    x.a(b.a).a(a);
                    x.c(b.a).run();
                }

            
            {
                b = x._cls8.this;
                a = list;
                super();
            }
            });
            return;
        }
    }

    public void b(Object obj)
    {
        Log.e("LookEffectPanel", "getTemplateMetadata error");
        Globals.d(x.c(a));
    }

    public void c(Object obj)
    {
        Log.e("LookEffectPanel", "getTemplateMetadata cancel");
        Globals.d(x.c(a));
    }

    _cls1.a(x x1)
    {
        a = x1;
        super();
    }
}
