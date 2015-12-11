// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.os.Bundle;
import android.support.v7.be;
import android.support.v7.bk;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

// Referenced classes of package android.support.v4.view:
//            b, c

public class android.support.v4.view.a
{
    static class a extends d
    {

        public Object a()
        {
            return android.support.v4.view.b.a();
        }

        public Object a(android.support.v4.view.a a1)
        {
            return android.support.v4.view.b.a(new b.a(this, a1) {

                final android.support.v4.view.a a;
                final a b;

                public void a(View view, int i)
                {
                    a.sendAccessibilityEvent(view, i);
                }

                public void a(View view, Object obj)
                {
                    a.onInitializeAccessibilityNodeInfo(view, new be(obj));
                }

                public boolean a(View view, AccessibilityEvent accessibilityevent)
                {
                    return a.dispatchPopulateAccessibilityEvent(view, accessibilityevent);
                }

                public boolean a(ViewGroup viewgroup, View view, AccessibilityEvent accessibilityevent)
                {
                    return a.onRequestSendAccessibilityEvent(viewgroup, view, accessibilityevent);
                }

                public void b(View view, AccessibilityEvent accessibilityevent)
                {
                    a.onInitializeAccessibilityEvent(view, accessibilityevent);
                }

                public void c(View view, AccessibilityEvent accessibilityevent)
                {
                    a.onPopulateAccessibilityEvent(view, accessibilityevent);
                }

                public void d(View view, AccessibilityEvent accessibilityevent)
                {
                    a.sendAccessibilityEventUnchecked(view, accessibilityevent);
                }

            
            {
                b = a1;
                a = a2;
                super();
            }
            });
        }

        public void a(Object obj, View view, int i)
        {
            android.support.v4.view.b.a(obj, view, i);
        }

        public void a(Object obj, View view, be be1)
        {
            android.support.v4.view.b.a(obj, view, be1.a());
        }

        public boolean a(Object obj, View view, AccessibilityEvent accessibilityevent)
        {
            return android.support.v4.view.b.a(obj, view, accessibilityevent);
        }

        public boolean a(Object obj, ViewGroup viewgroup, View view, AccessibilityEvent accessibilityevent)
        {
            return android.support.v4.view.b.a(obj, viewgroup, view, accessibilityevent);
        }

        public void b(Object obj, View view, AccessibilityEvent accessibilityevent)
        {
            android.support.v4.view.b.b(obj, view, accessibilityevent);
        }

        public void c(Object obj, View view, AccessibilityEvent accessibilityevent)
        {
            android.support.v4.view.b.c(obj, view, accessibilityevent);
        }

        public void d(Object obj, View view, AccessibilityEvent accessibilityevent)
        {
            android.support.v4.view.b.d(obj, view, accessibilityevent);
        }

        a()
        {
        }
    }

    static interface b
    {

        public abstract bk a(Object obj, View view);

        public abstract Object a();

        public abstract Object a(android.support.v4.view.a a1);

        public abstract void a(Object obj, View view, int i);

        public abstract void a(Object obj, View view, be be);

        public abstract boolean a(Object obj, View view, int i, Bundle bundle);

        public abstract boolean a(Object obj, View view, AccessibilityEvent accessibilityevent);

        public abstract boolean a(Object obj, ViewGroup viewgroup, View view, AccessibilityEvent accessibilityevent);

        public abstract void b(Object obj, View view, AccessibilityEvent accessibilityevent);

        public abstract void c(Object obj, View view, AccessibilityEvent accessibilityevent);

        public abstract void d(Object obj, View view, AccessibilityEvent accessibilityevent);
    }

    static class c extends a
    {

        public bk a(Object obj, View view)
        {
            obj = android.support.v4.view.c.a(obj, view);
            if (obj != null)
            {
                return new bk(obj);
            } else
            {
                return null;
            }
        }

        public Object a(android.support.v4.view.a a1)
        {
            return android.support.v4.view.c.a(new c.a(this, a1) {

                final android.support.v4.view.a a;
                final c b;

                public Object a(View view)
                {
                    view = a.getAccessibilityNodeProvider(view);
                    if (view != null)
                    {
                        return view.a();
                    } else
                    {
                        return null;
                    }
                }

                public void a(View view, int i)
                {
                    a.sendAccessibilityEvent(view, i);
                }

                public void a(View view, Object obj)
                {
                    a.onInitializeAccessibilityNodeInfo(view, new be(obj));
                }

                public boolean a(View view, int i, Bundle bundle)
                {
                    return a.performAccessibilityAction(view, i, bundle);
                }

                public boolean a(View view, AccessibilityEvent accessibilityevent)
                {
                    return a.dispatchPopulateAccessibilityEvent(view, accessibilityevent);
                }

                public boolean a(ViewGroup viewgroup, View view, AccessibilityEvent accessibilityevent)
                {
                    return a.onRequestSendAccessibilityEvent(viewgroup, view, accessibilityevent);
                }

                public void b(View view, AccessibilityEvent accessibilityevent)
                {
                    a.onInitializeAccessibilityEvent(view, accessibilityevent);
                }

                public void c(View view, AccessibilityEvent accessibilityevent)
                {
                    a.onPopulateAccessibilityEvent(view, accessibilityevent);
                }

                public void d(View view, AccessibilityEvent accessibilityevent)
                {
                    a.sendAccessibilityEventUnchecked(view, accessibilityevent);
                }

            
            {
                b = c1;
                a = a1;
                super();
            }
            });
        }

        public boolean a(Object obj, View view, int i, Bundle bundle)
        {
            return android.support.v4.view.c.a(obj, view, i, bundle);
        }

        c()
        {
        }
    }

    static class d
        implements b
    {

        public bk a(Object obj, View view)
        {
            return null;
        }

        public Object a()
        {
            return null;
        }

        public Object a(android.support.v4.view.a a1)
        {
            return null;
        }

        public void a(Object obj, View view, int i)
        {
        }

        public void a(Object obj, View view, be be)
        {
        }

        public boolean a(Object obj, View view, int i, Bundle bundle)
        {
            return false;
        }

        public boolean a(Object obj, View view, AccessibilityEvent accessibilityevent)
        {
            return false;
        }

        public boolean a(Object obj, ViewGroup viewgroup, View view, AccessibilityEvent accessibilityevent)
        {
            return true;
        }

        public void b(Object obj, View view, AccessibilityEvent accessibilityevent)
        {
        }

        public void c(Object obj, View view, AccessibilityEvent accessibilityevent)
        {
        }

        public void d(Object obj, View view, AccessibilityEvent accessibilityevent)
        {
        }

        d()
        {
        }
    }


    private static final Object DEFAULT_DELEGATE;
    private static final b IMPL;
    final Object mBridge;

    public android.support.v4.view.a()
    {
        mBridge = IMPL.a(this);
    }

    public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityevent)
    {
        return IMPL.a(DEFAULT_DELEGATE, view, accessibilityevent);
    }

    public bk getAccessibilityNodeProvider(View view)
    {
        return IMPL.a(DEFAULT_DELEGATE, view);
    }

    Object getBridge()
    {
        return mBridge;
    }

    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityevent)
    {
        IMPL.b(DEFAULT_DELEGATE, view, accessibilityevent);
    }

    public void onInitializeAccessibilityNodeInfo(View view, be be)
    {
        IMPL.a(DEFAULT_DELEGATE, view, be);
    }

    public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityevent)
    {
        IMPL.c(DEFAULT_DELEGATE, view, accessibilityevent);
    }

    public boolean onRequestSendAccessibilityEvent(ViewGroup viewgroup, View view, AccessibilityEvent accessibilityevent)
    {
        return IMPL.a(DEFAULT_DELEGATE, viewgroup, view, accessibilityevent);
    }

    public boolean performAccessibilityAction(View view, int i, Bundle bundle)
    {
        return IMPL.a(DEFAULT_DELEGATE, view, i, bundle);
    }

    public void sendAccessibilityEvent(View view, int i)
    {
        IMPL.a(DEFAULT_DELEGATE, view, i);
    }

    public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityevent)
    {
        IMPL.d(DEFAULT_DELEGATE, view, accessibilityevent);
    }

    static 
    {
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            IMPL = new c();
        } else
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            IMPL = new a();
        } else
        {
            IMPL = new d();
        }
        DEFAULT_DELEGATE = IMPL.a();
    }
}
