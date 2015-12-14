// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appboy.ui.inappmessage;

import android.app.Activity;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import com.appboy.Appboy;
import com.appboy.Constants;
import com.appboy.IAppboyNavigator;
import com.appboy.enums.inappmessage.DismissType;
import com.appboy.enums.inappmessage.SlideFrom;
import com.appboy.ui.c;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicBoolean;
import myobfuscated.f.b;
import myobfuscated.f.d;
import myobfuscated.f.g;
import myobfuscated.f.h;
import myobfuscated.f.j;
import myobfuscated.f.k;
import myobfuscated.f.m;

// Referenced classes of package com.appboy.ui.inappmessage:
//            f, c, d, h, 
//            e

public final class a
{

    static final String a;
    private static volatile a f = null;
    final Stack b = new Stack();
    Activity c;
    public myobfuscated.m.b d;
    AtomicBoolean e;
    private final IAppboyNavigator g = new c();
    private myobfuscated.e.b h;
    private com.appboy.ui.inappmessage.h i;
    private myobfuscated.f.a j;
    private boolean k;
    private myobfuscated.m.b l;
    private myobfuscated.m.a m;
    private f n;
    private f o;
    private f p;
    private f q;
    private com.appboy.ui.inappmessage.c r;
    private final myobfuscated.m.c s = new _cls3();
    private final myobfuscated.m.d t = new _cls4();

    public a()
    {
        e = new AtomicBoolean(false);
        l = new _cls8();
        m = new _cls9();
        n = new _cls10();
        o = new _cls11();
        p = new _cls12();
        q = new _cls13();
        r = new _cls2();
    }

    public static a a()
    {
        if (f != null) goto _L2; else goto _L1
_L1:
        com/appboy/ui/inappmessage/a;
        JVM INSTR monitorenter ;
        if (f == null)
        {
            f = new a();
        }
        com/appboy/ui/inappmessage/a;
        JVM INSTR monitorexit ;
_L2:
        return f;
        Exception exception;
        exception;
        com/appboy/ui/inappmessage/a;
        JVM INSTR monitorexit ;
        throw exception;
    }

    static void a(a a1, b b1)
    {
        (new Thread(new _cls6(b1))).start();
    }

    static boolean a(a a1)
    {
        return a1.k;
    }

    static boolean a(a a1, myobfuscated.f.a a2)
    {
        return a1.a(a2);
    }

    private boolean a(myobfuscated.f.a a1)
    {
        if (c == null)
        {
            myobfuscated.i.a.c(a, "No activity is currently registered to receive in-app messages. Doing nothing.");
        } else
        {
            Object obj;
            if (a1 instanceof k)
            {
                obj = n;
            } else
            if (a1 instanceof j)
            {
                obj = o;
            } else
            if (a1 instanceof g)
            {
                obj = p;
            } else
            if (a1 instanceof h)
            {
                obj = q;
            } else
            {
                obj = null;
            }
            if (obj != null)
            {
                obj = ((f) (obj)).a(c, a1);
                if (obj == null)
                {
                    myobfuscated.i.a.c(a, "The in-app message view returned from the IInAppMessageViewFactory was null. The in-app message will not be displayed and will not be put back on the stack.");
                    e.set(false);
                    return false;
                }
                if (((View) (obj)).getParent() != null)
                {
                    myobfuscated.i.a.c(a, "The in-app message view returned from the IInAppMessageViewFactory already has a parent. This is a sign that the view is being reused. The IInAppMessageViewFactory method createInAppMessageViewmust return a new view without a parent. The in-app message will not be displayed and will not be put back on the stack.");
                    e.set(false);
                    return false;
                }
                Object obj1 = r.a(a1);
                android.view.animation.Animation animation = r.b(a1);
                if (obj instanceof com.appboy.ui.inappmessage.d)
                {
                    com.appboy.ui.inappmessage.d d1 = (com.appboy.ui.inappmessage.d)obj;
                    i = new com.appboy.ui.inappmessage.h(((View) (obj)), a1, s, ((android.view.animation.Animation) (obj1)), animation, d1.c(), d1.b(), d1.a());
                } else
                if (obj instanceof e)
                {
                    e e1 = (e)obj;
                    i = new com.appboy.ui.inappmessage.h(((View) (obj)), a1, s, ((android.view.animation.Animation) (obj1)), animation, e1.c());
                } else
                {
                    i = new com.appboy.ui.inappmessage.h(((View) (obj)), a1, s, ((android.view.animation.Animation) (obj1)), animation, ((View) (obj)));
                }
                a1 = (FrameLayout)c.getWindow().getDecorView().findViewById(0x1020002);
                obj = i;
                ((com.appboy.ui.inappmessage.h) (obj)).c.a(((com.appboy.ui.inappmessage.h) (obj)).b);
                obj1 = new android.widget.FrameLayout.LayoutParams(-1, -2);
                if (((com.appboy.ui.inappmessage.h) (obj)).b instanceof k)
                {
                    int i1;
                    if (((k)((com.appboy.ui.inappmessage.h) (obj)).b).a == SlideFrom.TOP)
                    {
                        i1 = 48;
                    } else
                    {
                        i1 = 80;
                    }
                    obj1.gravity = i1;
                }
                if ((((com.appboy.ui.inappmessage.h) (obj)).b instanceof d) || (((com.appboy.ui.inappmessage.h) (obj)).b instanceof b))
                {
                    ((com.appboy.ui.inappmessage.h) (obj)).a.setFocusableInTouchMode(true);
                    ((com.appboy.ui.inappmessage.h) (obj)).a.requestFocus();
                }
                a1.addView(((com.appboy.ui.inappmessage.h) (obj)).a, ((android.view.ViewGroup.LayoutParams) (obj1)));
                if (((com.appboy.ui.inappmessage.h) (obj)).b.j())
                {
                    ((com.appboy.ui.inappmessage.h) (obj)).a(true);
                } else
                {
                    if (((com.appboy.ui.inappmessage.h) (obj)).b.o() == DismissType.AUTO_DISMISS)
                    {
                        ((com.appboy.ui.inappmessage.h) (obj)).b();
                    }
                    ((com.appboy.ui.inappmessage.h) (obj)).c.a();
                }
                return true;
            }
        }
        return false;
    }

    static Activity b(a a1)
    {
        return a1.c;
    }

    static AtomicBoolean c(a a1)
    {
        return a1.e;
    }

    static String d()
    {
        return a;
    }

    static myobfuscated.m.b d(a a1)
    {
        return a1.c();
    }

    static myobfuscated.m.d e(a a1)
    {
        return a1.t;
    }

    static com.appboy.ui.inappmessage.h f(a a1)
    {
        a1.i = null;
        return null;
    }

    static IAppboyNavigator g(a a1)
    {
        IAppboyNavigator iappboynavigator = Appboy.getInstance(a1.c).getAppboyNavigator();
        if (iappboynavigator != null)
        {
            return iappboynavigator;
        } else
        {
            return a1.g;
        }
    }

    static myobfuscated.m.a h(a a1)
    {
        return a1.m;
    }

    public final void a(Activity activity)
    {
        c = activity;
        k = myobfuscated.n.b.a(activity.getApplicationContext());
        if (j != null)
        {
            j.q();
            a(j);
            j = null;
        }
        h = new _cls7();
        Appboy.getInstance(activity).subscribeToNewInAppMessages(h);
    }

    public final void a(boolean flag)
    {
        com.appboy.ui.inappmessage.h h1 = i;
        if (h1 != null)
        {
            myobfuscated.f.a a1 = h1.b;
            if (a1 != null)
            {
                a1.a(flag);
            }
            h1.a();
        }
    }

    public final void b()
    {
        Object obj = i;
        if (obj != null)
        {
            myobfuscated.m.c c1 = ((com.appboy.ui.inappmessage.h) (obj)).c;
            obj = ((com.appboy.ui.inappmessage.h) (obj)).b;
            c1.c();
        }
        a(true);
    }

    public final void b(Activity activity)
    {
        if (i != null)
        {
            myobfuscated.f.m.a(i.a);
            if (i.d)
            {
                com.appboy.ui.inappmessage.h h1 = i;
                h1.c.b(h1.b);
                j = null;
            } else
            {
                j = i.b;
            }
            i = null;
        } else
        {
            j = null;
        }
        Appboy.getInstance(activity).removeSingleSubscription(h, myobfuscated/e/c);
        c = null;
    }

    final myobfuscated.m.b c()
    {
        if (d != null)
        {
            return d;
        } else
        {
            return l;
        }
    }

    static 
    {
        a = String.format("%s.%s", new Object[] {
            Constants.APPBOY_LOG_TAG_PREFIX, com/appboy/ui/inappmessage/a.getName()
        });
    }

    /* member class not found */
    class _cls8 {}


    /* member class not found */
    class _cls9 {}


    /* member class not found */
    class _cls10 {}


    /* member class not found */
    class _cls11 {}


    /* member class not found */
    class _cls12 {}


    /* member class not found */
    class _cls13 {}


    /* member class not found */
    class _cls2 {}


    /* member class not found */
    class _cls3 {}


    /* member class not found */
    class _cls4 {}


    /* member class not found */
    class _cls6 {}


    /* member class not found */
    class _cls7 {}

}
