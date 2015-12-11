// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Animation;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

// Referenced classes of package android.support.v7:
//            all, alk, aln

final class alo extends Handler
{

    private static alo a;
    private final Queue b = new LinkedBlockingQueue();

    private alo()
    {
    }

    static alo a()
    {
        android/support/v7/alo;
        JVM INSTR monitorenter ;
        alo alo1;
        if (a == null)
        {
            a = new alo();
        }
        alo1 = a;
        android/support/v7/alo;
        JVM INSTR monitorexit ;
        return alo1;
        Exception exception;
        exception;
        throw exception;
    }

    public static void a(Context context, CharSequence charsequence)
    {
label0:
        {
            if (android.os.Build.VERSION.SDK_INT >= 4)
            {
                AccessibilityManager accessibilitymanager;
                AccessibilityEvent accessibilityevent;
                char c1;
                if (context != null)
                {
                    accessibilitymanager = (AccessibilityManager)context.getSystemService("accessibility");
                } else
                {
                    accessibilitymanager = null;
                }
                if (accessibilitymanager != null && accessibilitymanager.isEnabled())
                {
                    break label0;
                }
            }
            return;
        }
        if (android.os.Build.VERSION.SDK_INT < 16)
        {
            c1 = '\b';
        } else
        {
            c1 = '\u4000';
        }
        accessibilityevent = AccessibilityEvent.obtain(c1);
        accessibilityevent.getText().add(charsequence);
        accessibilityevent.setClassName(android/support/v7/alo.getName());
        accessibilityevent.setPackageName(context.getPackageName());
        accessibilitymanager.sendAccessibilityEvent(accessibilityevent);
    }

    private void a(all all1, int i)
    {
        Message message = obtainMessage(i);
        message.obj = all1;
        sendMessage(message);
    }

    private void a(all all1, int i, long l)
    {
        Message message = obtainMessage(i);
        message.obj = all1;
        sendMessageDelayed(message, l);
    }

    static void a(alo alo1, all all1, int i, long l)
    {
        alo1.a(all1, i, l);
    }

    private void a(android.view.ViewGroup.MarginLayoutParams marginlayoutparams, Activity activity)
    {
        if (android.os.Build.VERSION.SDK_INT >= 19 && (activity.getWindow().getAttributes().flags & 0x4000000) == 0x4000000)
        {
            c(marginlayoutparams, activity);
        }
    }

    private boolean a(ViewGroup viewgroup)
    {
        return (viewgroup instanceof FrameLayout) || (viewgroup instanceof AdapterView) || (viewgroup instanceof RelativeLayout);
    }

    private void b(android.view.ViewGroup.MarginLayoutParams marginlayoutparams, Activity activity)
    {
        if (android.os.Build.VERSION.SDK_INT >= 11 && activity.getWindow().hasFeature(9))
        {
            c(marginlayoutparams, activity);
        }
    }

    private long c(all all1)
    {
        return (long)all1.l().b + all1.c().getDuration() + all1.d().getDuration();
    }

    private void c()
    {
        if (!b.isEmpty())
        {
            all all1 = (all)b.peek();
            if (all1.m() == null)
            {
                b.poll();
            }
            if (!all1.f())
            {
                a(all1, 0xc20074dd);
                if (all1.j() != null)
                {
                    all1.j().a();
                    return;
                }
            } else
            {
                a(all1, 0xc2007, c(all1));
                return;
            }
        }
    }

    private void c(android.view.ViewGroup.MarginLayoutParams marginlayoutparams, Activity activity)
    {
        activity = activity.findViewById(Resources.getSystem().getIdentifier("action_bar_container", "id", "android"));
        if (activity != null)
        {
            marginlayoutparams.topMargin = activity.getBottom();
        }
    }

    private void d()
    {
        removeMessages(0xc20074dd);
        removeMessages(0xc2007);
        removeMessages(0xc2007de1);
    }

    private void d(all all1)
    {
        if (!all1.f()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Object obj;
        View view;
        view = all1.p();
        if (view.getParent() == null)
        {
            Object obj1 = view.getLayoutParams();
            obj = obj1;
            if (obj1 == null)
            {
                obj = new android.view.ViewGroup.MarginLayoutParams(-1, -2);
            }
            if (all1.n() == null)
            {
                break; /* Loop/switch isn't completed */
            }
            obj1 = all1.n();
            if (a(((ViewGroup) (obj1))))
            {
                ((ViewGroup) (obj1)).addView(view, ((android.view.ViewGroup.LayoutParams) (obj)));
            } else
            {
                ((ViewGroup) (obj1)).addView(view, 0, ((android.view.ViewGroup.LayoutParams) (obj)));
            }
        }
_L5:
        view.requestLayout();
        obj = view.getViewTreeObserver();
        if (obj != null)
        {
            ((ViewTreeObserver) (obj)).addOnGlobalLayoutListener(new android.view.ViewTreeObserver.OnGlobalLayoutListener(view, all1) {

                final View a;
                final all b;
                final alo c;

                public void onGlobalLayout()
                {
                    if (android.os.Build.VERSION.SDK_INT < 16)
                    {
                        a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    } else
                    {
                        a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    }
                    if (b.c() != null)
                    {
                        a.startAnimation(b.c());
                        alo.a(b.m(), b.o());
                        if (-1 != b.l().b)
                        {
                            alo.a(c, b, 0xc2007de1, (long)b.l().b + b.c().getDuration());
                        }
                    }
                }

            
            {
                c = alo.this;
                a = view;
                b = all1;
                super();
            }
            });
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
        Activity activity = all1.m();
        if (activity == null || activity.isFinishing()) goto _L1; else goto _L4
_L4:
        a((android.view.ViewGroup.MarginLayoutParams)obj, activity);
        b((android.view.ViewGroup.MarginLayoutParams)obj, activity);
        activity.addContentView(view, ((android.view.ViewGroup.LayoutParams) (obj)));
          goto _L5
    }

    private void e(all all1)
    {
        if (all1.f())
        {
            ViewGroup viewgroup = (ViewGroup)all1.p().getParent();
            if (viewgroup != null)
            {
                viewgroup.removeView(all1.p());
            }
        }
    }

    void a(all all1)
    {
        b.add(all1);
        c();
    }

    void b()
    {
        d();
        for (Iterator iterator = b.iterator(); iterator.hasNext(); e((all)iterator.next())) { }
        b.clear();
    }

    protected void b(all all1)
    {
        View view = all1.p();
        ViewGroup viewgroup = (ViewGroup)view.getParent();
        if (viewgroup != null)
        {
            view.startAnimation(all1.d());
            all all2 = (all)b.poll();
            viewgroup.removeView(view);
            if (all2 != null)
            {
                all2.g();
                all2.h();
                if (all2.j() != null)
                {
                    all2.j().b();
                }
                all2.i();
            }
            a(all1, 0xc2007, all1.d().getDuration());
        }
    }

    public void handleMessage(Message message)
    {
        all all1 = (all)message.obj;
        if (all1 != null)
        {
            switch (message.what)
            {
            default:
                super.handleMessage(message);
                return;

            case 794631: 
                c();
                return;

            case -1040157475: 
                d(all1);
                return;

            case -1040155167: 
                b(all1);
                break;
            }
            if (all1.j() != null)
            {
                all1.j().b();
                return;
            }
        }
    }

    public String toString()
    {
        return (new StringBuilder()).append("Manager{croutonQueue=").append(b).append('}').toString();
    }
}
