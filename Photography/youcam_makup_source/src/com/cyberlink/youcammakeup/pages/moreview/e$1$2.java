// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.pages.moreview;

import android.app.Activity;
import android.widget.Toast;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.database.more.a.b;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.be;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bg;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bn;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

// Referenced classes of package com.cyberlink.youcammakeup.pages.moreview:
//            e

class b
    implements Runnable
{

    final be a;
    final Activity b;
    final ager.task.be c;

    public void run()
    {
        Collection collection;
label0:
        {
            if (a != null)
            {
                collection = a.b();
                if (collection.size() != 0)
                {
                    break label0;
                }
                e.a(c.c, false);
                if (c.c.getCount() == 0)
                {
                    e.a(c.c, Toast.makeText(b, 0x7f070518, 0));
                    e.a(c.c).setGravity(17, 0, 0);
                    e.a(c.c).show();
                }
            }
            return;
        }
        Iterator iterator = collection.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            b b1 = (b)iterator.next();
            Long long1 = Long.valueOf(b1.a());
            if (long1 != null && com.cyberlink.youcammakeup.pages.moreview.e.b(c.c) != null && !com.cyberlink.youcammakeup.pages.moreview.e.b(c.c).containsKey(long1))
            {
                com.cyberlink.youcammakeup.pages.moreview.e.b(c.c).put(long1, b1);
            }
        } while (true);
        e.a(c.c, e.c(c.c) + collection.size() + 1);
        c.c.addAll(collection);
    }

    ager.task.be(ager.task.be be1, be be2, Activity activity)
    {
        c = be1;
        a = be2;
        b = activity;
        super();
    }

    // Unreferenced inner class com/cyberlink/youcammakeup/pages/moreview/e$1

/* anonymous class */
    class e._cls1
        implements bg
    {

        final e a;

        public void a(be be1)
        {
            Activity activity = Globals.d().a(com.cyberlink.youcammakeup.Globals.ActivityType.k);
            if (activity == null)
            {
                return;
            } else
            {
                activity.runOnUiThread(new e._cls1._cls2(this, be1, activity));
                return;
            }
        }

        public void a(bn bn1)
        {
            if (bn1 == null);
            Activity activity = Globals.d().a(com.cyberlink.youcammakeup.Globals.ActivityType.k);
            if (activity == null)
            {
                return;
            } else
            {
                activity.runOnUiThread(new e._cls1._cls1(bn1));
                return;
            }
        }

        public volatile void a(Object obj)
        {
            a((be)obj);
        }

        public void a(Void void1)
        {
        }

        public void b(Object obj)
        {
            a((bn)obj);
        }

        public void c(Object obj)
        {
            a((Void)obj);
        }

            
            {
                a = e1;
                super();
            }

        // Unreferenced inner class com/cyberlink/youcammakeup/pages/moreview/e$1$1

/* anonymous class */
        class e._cls1._cls1
            implements Runnable
        {

            final bn a;
            final e._cls1 b;

            public void run()
            {
                e.a(b.a, NetworkManager.a(a.a()));
            }

                    
                    {
                        b = e._cls1.this;
                        a = bn1;
                        super();
                    }
        }

    }

}
