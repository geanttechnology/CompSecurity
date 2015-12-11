// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.os.Bundle;
import android.support.v4.view.a.f;
import android.support.v4.view.a.q;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import java.lang.reflect.Field;

// Referenced classes of package android.support.v4.view:
//            af, ag, a

class d
{

    private static Field a;
    private static boolean b;

    d()
    {
    }

    static void a(LayoutInflater layoutinflater, ag ag)
    {
        android.view.LayoutInflater.Factory factory;
        if (ag != null)
        {
            ag = new af(ag);
        } else
        {
            ag = null;
        }
        layoutinflater.setFactory2(ag);
        factory = layoutinflater.getFactory();
        if (factory instanceof android.view.LayoutInflater.Factory2)
        {
            a(layoutinflater, (android.view.LayoutInflater.Factory2)factory);
            return;
        } else
        {
            a(layoutinflater, ((android.view.LayoutInflater.Factory2) (ag)));
            return;
        }
    }

    static void a(LayoutInflater layoutinflater, android.view.LayoutInflater.Factory2 factory2)
    {
        if (!b)
        {
            try
            {
                Field field = android/view/LayoutInflater.getDeclaredField("mFactory2");
                a = field;
                field.setAccessible(true);
            }
            catch (NoSuchFieldException nosuchfieldexception)
            {
                Log.e("LayoutInflaterCompatHC", (new StringBuilder("forceSetFactory2 Could not find field 'mFactory2' on class ")).append(android/view/LayoutInflater.getName()).append("; inflation may have unexpected results.").toString(), nosuchfieldexception);
            }
            b = true;
        }
        if (a == null)
        {
            break MISSING_BLOCK_LABEL_41;
        }
        a.set(layoutinflater, factory2);
        return;
        factory2;
        Log.e("LayoutInflaterCompatHC", (new StringBuilder("forceSetFactory2 could not set the Factory2 on LayoutInflater ")).append(layoutinflater).append("; inflation may have unexpected results.").toString(), factory2);
        return;
    }

    public q a(Object obj, View view)
    {
        return null;
    }

    public Object a()
    {
        return null;
    }

    public Object a(a a1)
    {
        return null;
    }

    public void a(Object obj, View view, int i)
    {
    }

    public void a(Object obj, View view, f f)
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
}
