// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.os.Bundle;
import android.support.v4.view.a.b;
import android.support.v4.view.a.c;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

// Referenced classes of package android.support.v4.view:
//            a

static final class _cls1.a extends _cls1.a
{

    public final c a(Object obj, View view)
    {
        obj = ((android.view..AccessibilityDelegate)obj).getAccessibilityNodeProvider(view);
        if (obj != null)
        {
            return new c(obj);
        } else
        {
            return null;
        }
    }

    public final Object a(a a1)
    {
        return new <init>(new c.a(a1) {

            final a a;
            final a.c b;

            public final Object a(View view)
            {
                view = android.support.v4.view.a.a(view);
                if (view != null)
                {
                    return ((c) (view)).a;
                } else
                {
                    return null;
                }
            }

            public final void a(View view, int i)
            {
                android.support.v4.view.a.a(view, i);
            }

            public final void a(View view, Object obj)
            {
                a.a(view, new b(obj));
            }

            public final boolean a(View view, int i, Bundle bundle)
            {
                return a.a(view, i, bundle);
            }

            public final boolean a(View view, AccessibilityEvent accessibilityevent)
            {
                return b(view, accessibilityevent);
            }

            public final boolean a(ViewGroup viewgroup, View view, AccessibilityEvent accessibilityevent)
            {
                return android.support.v4.view.a.a(viewgroup, view, accessibilityevent);
            }

            public final void b(View view, AccessibilityEvent accessibilityevent)
            {
                a.d(view, accessibilityevent);
            }

            public final void c(View view, AccessibilityEvent accessibilityevent)
            {
                c(view, accessibilityevent);
            }

            public final void d(View view, AccessibilityEvent accessibilityevent)
            {
                android.support.v4.view.a.a(view, accessibilityevent);
            }

            
            {
                b = a.c.this;
                a = a1;
                super();
            }
        });
    }

    public final boolean a(Object obj, View view, int i, Bundle bundle)
    {
        return ((android.view..AccessibilityDelegate)obj).performAccessibilityAction(view, i, bundle);
    }

    _cls1.a()
    {
    }
}
