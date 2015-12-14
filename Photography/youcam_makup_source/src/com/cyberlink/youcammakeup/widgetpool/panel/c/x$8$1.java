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
    implements Runnable
{

    final List a;
    final b b;

    public void run()
    {
        x.a(b.b).c();
        x.a(b.b).a(a);
        x.c(b.b).run();
    }

    _cls9(_cls9 _pcls9, List list)
    {
        b = _pcls9;
        a = list;
        super();
    }

    // Unreferenced inner class com/cyberlink/youcammakeup/widgetpool/panel/c/x$8

/* anonymous class */
    class x._cls8
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
                Globals.d(new x._cls8._cls1(this, list));
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

            
            {
                a = x1;
                super();
            }
    }

}
