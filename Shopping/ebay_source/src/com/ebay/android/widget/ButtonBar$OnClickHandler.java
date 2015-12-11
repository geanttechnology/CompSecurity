// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.android.widget;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

// Referenced classes of package com.ebay.android.widget:
//            ButtonBar

private static final class handlerName
    implements android.view.ickHandler
{

    private Method handler;
    private final String handlerName;

    public void onClick(View view)
    {
        if (handler == null)
        {
            try
            {
                handler = view.getContext().getClass().getMethod(handlerName, new Class[] {
                    android/view/View
                });
            }
            catch (NoSuchMethodException nosuchmethodexception)
            {
                String s;
                if (view.getId() == -1)
                {
                    s = "";
                } else
                {
                    s = (new StringBuilder()).append(" with id '").append(view.getContext().getResources().getResourceEntryName(view.getId())).append("'").toString();
                }
                throw new IllegalStateException((new StringBuilder()).append("Could not find a method ").append(handlerName).append("(View) in the activity ").append(view.getContext().getClass()).append(" for onClick handler on view ").append(view.getClass()).append(s).toString(), nosuchmethodexception);
            }
        }
        try
        {
            handler.invoke(view.getContext(), new Object[] {
                view
            });
            return;
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            throw new IllegalStateException("Could not execute non public method of the activity", view);
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            throw new IllegalStateException("Could not execute method of the activity", view);
        }
    }

    public (String s)
    {
        handler = null;
        handlerName = s;
    }
}
