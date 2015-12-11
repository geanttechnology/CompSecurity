// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

// Referenced classes of package com.groupon.view:
//            DefaultValueSpinner

protected static class getView
    implements InvocationHandler
{

    private Method getView;
    private SpinnerAdapter obj;
    private CharSequence prompt;

    public static SpinnerAdapter newInstance(SpinnerAdapter spinneradapter, CharSequence charsequence)
    {
        ClassLoader classloader = spinneradapter.getClass().getClassLoader();
        spinneradapter = new <init>(spinneradapter, charsequence);
        return (SpinnerAdapter)Proxy.newProxyInstance(classloader, new Class[] {
            android/widget/SpinnerAdapter
        }, spinneradapter);
    }

    protected View getView(int i, View view, ViewGroup viewgroup)
    {
        if (i < 0)
        {
            view = (TextView)obj.getView(0, view, viewgroup);
            view.setText(prompt);
            view.setTextColor(viewgroup.getContext().getResources().getColor(0x7f0e0133));
            return view;
        } else
        {
            return obj.getView(i, view, viewgroup);
        }
    }

    public Object invoke(Object obj1, Method method, Object aobj[])
        throws Throwable
    {
        try
        {
            if (method.equals(getView) && ((Integer)(Integer)aobj[0]).intValue() < 0)
            {
                return getView(((Integer)aobj[0]).intValue(), (View)aobj[1], (ViewGroup)aobj[2]);
            }
            obj1 = method.invoke(obj, aobj);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            throw ((InvocationTargetException) (obj1)).getTargetException();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            throw new RuntimeException(((Throwable) (obj1)));
        }
        return obj1;
    }

    private (SpinnerAdapter spinneradapter, CharSequence charsequence)
    {
        obj = spinneradapter;
        prompt = charsequence;
        try
        {
            getView = android/widget/SpinnerAdapter.getMethod("getView", new Class[] {
                Integer.TYPE, android/view/View, android/view/ViewGroup
            });
            return;
        }
        // Misplaced declaration of an exception variable
        catch (SpinnerAdapter spinneradapter)
        {
            throw new RuntimeException(spinneradapter);
        }
    }
}
