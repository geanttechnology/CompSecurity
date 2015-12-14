// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.panel.c;

import android.util.Log;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.database.more.makeup.MakeupItemMetadata;
import com.cyberlink.youcammakeup.database.more.types.CategoryType;
import com.cyberlink.youcammakeup.e;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.a;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.j;
import com.cyberlink.youcammakeup.utility.bn;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.panel.c:
//            x, r

class a
    implements Runnable
{

    final a a;

    public void run()
    {
        int i = 2;
        int j = com.cyberlink.youcammakeup.widgetpool.panel.c.x.a(a.a.a).a(a.a.b());
        if (j == -1)
        {
            com.cyberlink.youcammakeup.widgetpool.panel.c.x.a(a.a.a).a(2, a.a.b());
        } else
        {
            i = j;
        }
        com.cyberlink.youcammakeup.widgetpool.panel.c.x.a(a.a.a, i, true);
    }

    ItemMetadata(ItemMetadata itemmetadata)
    {
        a = itemmetadata;
        super();
    }

    // Unreferenced inner class com/cyberlink/youcammakeup/widgetpool/panel/c/x$6

/* anonymous class */
    class x._cls6
        implements e
    {

        final String a;
        final x b;

        public volatile void a(Object obj)
        {
            a((List)obj);
        }

        public void a(List list)
        {
            list = list.iterator();
            boolean flag = false;
            do
            {
                if (!list.hasNext())
                {
                    break;
                }
                MakeupItemMetadata makeupitemmetadata = (MakeupItemMetadata)list.next();
                Log.e("LookEffectPanel", "[downloadTemplate] complete: ");
                if (makeupitemmetadata.m().equals(a))
                {
                    flag = true;
                    bn.a(CategoryType.a(CategoryType.a), makeupitemmetadata, new x._cls6._cls1(this, makeupitemmetadata));
                }
            } while (true);
            if (!flag)
            {
                Globals.d(x.h(b));
            }
        }

        public void b(Object obj)
        {
            Log.e("LookEffectPanel", (new StringBuilder()).append("[getTemplateMetadata] error: ").append(obj).toString());
            Globals.d(x.h(b));
        }

        public void c(Object obj)
        {
            Log.d("LookEffectPanel", (new StringBuilder()).append("[getTemplateMetadata] cancel: ").append(obj).toString());
            Globals.d(x.h(b));
        }

            
            {
                b = x1;
                a = s;
                super();
            }
    }


    // Unreferenced inner class com/cyberlink/youcammakeup/widgetpool/panel/c/x$6$1

/* anonymous class */
    class x._cls6._cls1
        implements j
    {

        final MakeupItemMetadata a;
        final x._cls6 b;

        public void a(a a1)
        {
        }

        public void a(com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bn bn1)
        {
            Log.e("LookEffectPanel", (new StringBuilder()).append("[downloadTemplate] error: ").append(bn1).toString());
            Globals.d(x.h(b.b));
        }

        public volatile void a(Object obj)
        {
            a((Void)obj);
        }

        public void a(Void void1)
        {
            Globals.c(new x._cls6._cls1._cls1(this));
            Globals.d(x.h(b.b));
        }

        public void b(Object obj)
        {
            a((com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bn)obj);
        }

        public void b(Void void1)
        {
            Log.e("LookEffectPanel", (new StringBuilder()).append("[downloadTemplate] cancel: ").append(void1).toString());
            Globals.d(x.h(b.b));
        }

        public void c(Object obj)
        {
            b((Void)obj);
        }

        public void d(Object obj)
        {
            a((a)obj);
        }

            
            {
                b = _pcls6;
                a = makeupitemmetadata;
                super();
            }
    }

}
