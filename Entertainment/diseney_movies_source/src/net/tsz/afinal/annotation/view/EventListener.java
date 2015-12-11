// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.tsz.afinal.annotation.view;

import android.view.View;
import android.widget.AdapterView;
import java.lang.reflect.Method;
import net.tsz.afinal.exception.ViewException;

public class EventListener
    implements android.view.View.OnClickListener, android.view.View.OnLongClickListener, android.widget.AdapterView.OnItemClickListener, android.widget.AdapterView.OnItemSelectedListener, android.widget.AdapterView.OnItemLongClickListener
{

    private String clickMethod;
    private Object handler;
    private String itemClickMethod;
    private String itemLongClickMehtod;
    private String itemSelectMethod;
    private String longClickMethod;
    private String nothingSelectedMethod;

    public EventListener(Object obj)
    {
        handler = obj;
    }

    private static transient Object invokeClickMethod(Object obj, String s, Object aobj[])
    {
        if (obj == null)
        {
            return null;
        }
        Method method;
        try
        {
            method = obj.getClass().getDeclaredMethod(s, new Class[] {
                android/view/View
            });
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ((Exception) (obj)).printStackTrace();
            return null;
        }
        if (method == null)
        {
            break MISSING_BLOCK_LABEL_35;
        }
        return method.invoke(obj, aobj);
        throw new ViewException((new StringBuilder("no such method:")).append(s).toString());
    }

    private static transient Object invokeItemClickMethod(Object obj, String s, Object aobj[])
    {
        if (obj == null)
        {
            return null;
        }
        Method method;
        try
        {
            method = obj.getClass().getDeclaredMethod(s, new Class[] {
                android/widget/AdapterView, android/view/View, Integer.TYPE, Long.TYPE
            });
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ((Exception) (obj)).printStackTrace();
            return null;
        }
        if (method == null)
        {
            break MISSING_BLOCK_LABEL_52;
        }
        return method.invoke(obj, aobj);
        throw new ViewException((new StringBuilder("no such method:")).append(s).toString());
    }

    private static transient boolean invokeItemLongClickMethod(Object obj, String s, Object aobj[])
    {
        if (obj == null)
        {
            throw new ViewException("invokeItemLongClickMethod: handler is null :");
        }
        Method method = obj.getClass().getDeclaredMethod(s, new Class[] {
            android/widget/AdapterView, android/view/View, Integer.TYPE, Long.TYPE
        });
        if (method == null) goto _L2; else goto _L1
_L1:
        obj = method.invoke(obj, aobj);
        if (obj != null) goto _L4; else goto _L3
_L3:
        boolean flag = false;
_L5:
        return Boolean.valueOf(flag).booleanValue();
_L4:
        flag = Boolean.valueOf(obj.toString()).booleanValue();
        if (true) goto _L5; else goto _L2
_L2:
        try
        {
            throw new ViewException((new StringBuilder("no such method:")).append(s).toString());
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ((Exception) (obj)).printStackTrace();
        }
        return false;
    }

    private static transient Object invokeItemSelectMethod(Object obj, String s, Object aobj[])
    {
        if (obj == null)
        {
            return null;
        }
        Method method;
        try
        {
            method = obj.getClass().getDeclaredMethod(s, new Class[] {
                android/widget/AdapterView, android/view/View, Integer.TYPE, Long.TYPE
            });
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ((Exception) (obj)).printStackTrace();
            return null;
        }
        if (method == null)
        {
            break MISSING_BLOCK_LABEL_52;
        }
        return method.invoke(obj, aobj);
        throw new ViewException((new StringBuilder("no such method:")).append(s).toString());
    }

    private static transient boolean invokeLongClickMethod(Object obj, String s, Object aobj[])
    {
        if (obj != null) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        Method method;
        try
        {
            method = obj.getClass().getDeclaredMethod(s, new Class[] {
                android/view/View
            });
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ((Exception) (obj)).printStackTrace();
            return false;
        }
        if (method == null)
        {
            break MISSING_BLOCK_LABEL_50;
        }
        obj = method.invoke(obj, aobj);
        if (obj == null) goto _L1; else goto _L3
_L3:
        return Boolean.valueOf(obj.toString()).booleanValue();
        throw new ViewException((new StringBuilder("no such method:")).append(s).toString());
    }

    private static transient Object invokeNoSelectMethod(Object obj, String s, Object aobj[])
    {
        if (obj == null)
        {
            return null;
        }
        Method method;
        try
        {
            method = obj.getClass().getDeclaredMethod(s, new Class[] {
                android/widget/AdapterView
            });
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ((Exception) (obj)).printStackTrace();
            return null;
        }
        if (method == null)
        {
            break MISSING_BLOCK_LABEL_35;
        }
        return method.invoke(obj, aobj);
        throw new ViewException((new StringBuilder("no such method:")).append(s).toString());
    }

    public EventListener click(String s)
    {
        clickMethod = s;
        return this;
    }

    public EventListener itemClick(String s)
    {
        itemClickMethod = s;
        return this;
    }

    public EventListener itemLongClick(String s)
    {
        itemLongClickMehtod = s;
        return this;
    }

    public EventListener longClick(String s)
    {
        longClickMethod = s;
        return this;
    }

    public EventListener noSelect(String s)
    {
        nothingSelectedMethod = s;
        return this;
    }

    public void onClick(View view)
    {
        invokeClickMethod(handler, clickMethod, new Object[] {
            view
        });
    }

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        invokeItemClickMethod(handler, itemClickMethod, new Object[] {
            adapterview, view, Integer.valueOf(i), Long.valueOf(l)
        });
    }

    public boolean onItemLongClick(AdapterView adapterview, View view, int i, long l)
    {
        return invokeItemLongClickMethod(handler, itemLongClickMehtod, new Object[] {
            adapterview, view, Integer.valueOf(i), Long.valueOf(l)
        });
    }

    public void onItemSelected(AdapterView adapterview, View view, int i, long l)
    {
        invokeItemSelectMethod(handler, itemSelectMethod, new Object[] {
            adapterview, view, Integer.valueOf(i), Long.valueOf(l)
        });
    }

    public boolean onLongClick(View view)
    {
        return invokeLongClickMethod(handler, longClickMethod, new Object[] {
            view
        });
    }

    public void onNothingSelected(AdapterView adapterview)
    {
        invokeNoSelectMethod(handler, nothingSelectedMethod, new Object[] {
            adapterview
        });
    }

    public EventListener select(String s)
    {
        itemSelectMethod = s;
        return this;
    }
}
