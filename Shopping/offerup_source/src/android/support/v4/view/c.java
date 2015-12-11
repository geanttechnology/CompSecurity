// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.support.v4.view.a.f;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

// Referenced classes of package android.support.v4.view:
//            h, as, a, b, 
//            ar

class c
    implements h
{

    private static Field b;
    private static boolean c;
    private static Field d;
    private static boolean e;
    private static Method f;
    private a a;

    c(b b1, a a1)
    {
        a = a1;
        super();
    }

    static int a(View view)
    {
        if (!c)
        {
            int i;
            try
            {
                Field field = android/view/View.getDeclaredField("mMinWidth");
                b = field;
                field.setAccessible(true);
            }
            catch (NoSuchFieldException nosuchfieldexception) { }
            c = true;
        }
        if (b == null)
        {
            break MISSING_BLOCK_LABEL_50;
        }
        i = ((Integer)b.get(view)).intValue();
        return i;
        view;
        return 0;
    }

    public static MenuItem a(MenuItem menuitem, ar ar)
    {
        return menuitem.setOnActionExpandListener(new as(ar));
    }

    public static void a(ViewGroup viewgroup, boolean flag)
    {
        if (f == null)
        {
            try
            {
                f = android/view/ViewGroup.getDeclaredMethod("setChildrenDrawingOrderEnabled", new Class[] {
                    Boolean.TYPE
                });
            }
            catch (NoSuchMethodException nosuchmethodexception)
            {
                Log.e("ViewCompat", "Unable to find childrenDrawingOrderEnabled", nosuchmethodexception);
            }
            f.setAccessible(true);
        }
        try
        {
            f.invoke(viewgroup, new Object[] {
                Boolean.valueOf(flag)
            });
            return;
        }
        // Misplaced declaration of an exception variable
        catch (ViewGroup viewgroup)
        {
            Log.e("ViewCompat", "Unable to invoke childrenDrawingOrderEnabled", viewgroup);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (ViewGroup viewgroup)
        {
            Log.e("ViewCompat", "Unable to invoke childrenDrawingOrderEnabled", viewgroup);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (ViewGroup viewgroup)
        {
            Log.e("ViewCompat", "Unable to invoke childrenDrawingOrderEnabled", viewgroup);
        }
    }

    public static boolean a(ViewParent viewparent, View view, float f1, float f2)
    {
        boolean flag;
        try
        {
            flag = viewparent.onNestedPreFling(view, f1, f2);
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            Log.e("ViewParentCompat", (new StringBuilder("ViewParent ")).append(viewparent).append(" does not implement interface method onNestedPreFling").toString(), view);
            return false;
        }
        return flag;
    }

    public static boolean a(ViewParent viewparent, View view, float f1, float f2, boolean flag)
    {
        try
        {
            flag = viewparent.onNestedFling(view, f1, f2, flag);
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            Log.e("ViewParentCompat", (new StringBuilder("ViewParent ")).append(viewparent).append(" does not implement interface method onNestedFling").toString(), view);
            return false;
        }
        return flag;
    }

    public static boolean a(ViewParent viewparent, View view, View view1, int i)
    {
        boolean flag;
        try
        {
            flag = viewparent.onStartNestedScroll(view, view1, i);
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            Log.e("ViewParentCompat", (new StringBuilder("ViewParent ")).append(viewparent).append(" does not implement interface method onStartNestedScroll").toString(), view);
            return false;
        }
        return flag;
    }

    static int b(View view)
    {
        if (!e)
        {
            int i;
            try
            {
                Field field = android/view/View.getDeclaredField("mMinHeight");
                d = field;
                field.setAccessible(true);
            }
            catch (NoSuchFieldException nosuchfieldexception) { }
            e = true;
        }
        if (d == null)
        {
            break MISSING_BLOCK_LABEL_50;
        }
        i = ((Integer)d.get(view)).intValue();
        return i;
        view;
        return 0;
    }

    public final void a(View view, int i)
    {
        a.sendAccessibilityEvent(view, i);
    }

    public final void a(View view, Object obj)
    {
        a.onInitializeAccessibilityNodeInfo(view, new f(obj));
    }

    public final boolean a(View view, AccessibilityEvent accessibilityevent)
    {
        return a.dispatchPopulateAccessibilityEvent(view, accessibilityevent);
    }

    public final boolean a(ViewGroup viewgroup, View view, AccessibilityEvent accessibilityevent)
    {
        return a.onRequestSendAccessibilityEvent(viewgroup, view, accessibilityevent);
    }

    public final void b(View view, AccessibilityEvent accessibilityevent)
    {
        a.onInitializeAccessibilityEvent(view, accessibilityevent);
    }

    public final void c(View view, AccessibilityEvent accessibilityevent)
    {
        a.onPopulateAccessibilityEvent(view, accessibilityevent);
    }

    public final void d(View view, AccessibilityEvent accessibilityevent)
    {
        a.sendAccessibilityEventUnchecked(view, accessibilityevent);
    }
}
