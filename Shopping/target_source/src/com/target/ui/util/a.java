// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.util;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import java.util.List;

// Referenced classes of package com.target.ui.util:
//            ai, j

public class a
{

    public static void a(Context context, View view, CharSequence charsequence)
    {
        if (!b(context))
        {
            return;
        } else
        {
            c(context, view, charsequence);
            return;
        }
    }

    public static void a(Context context, View view, CharSequence charsequence, long l)
    {
        (new Handler()).postDelayed(new Runnable(context, view, charsequence) {

            final Context val$context;
            final CharSequence val$message;
            final View val$view;

            public void run()
            {
                a.b(context, view, message);
            }

            
            {
                context = context1;
                view = view1;
                message = charsequence;
                super();
            }
        }, l);
    }

    private static void a(Context context, CharSequence charsequence)
    {
        if (charsequence == null || !b(context))
        {
            return;
        } else
        {
            ai.a(context, charsequence);
            return;
        }
    }

    public static boolean a(Context context)
    {
        return ((AccessibilityManager)context.getSystemService("accessibility")).isEnabled();
    }

    static void b(Context context, View view, CharSequence charsequence)
    {
        c(context, view, charsequence);
    }

    private static boolean b(Context context)
    {
        context = (AccessibilityManager)context.getSystemService("accessibility");
        int i;
        try
        {
            context = context.getEnabledAccessibilityServiceList(1);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return false;
        }
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_33;
        }
        i = context.size();
        if (i > 0)
        {
            return true;
        }
        return false;
    }

    private static void c(Context context, View view, CharSequence charsequence)
    {
        if (j.a())
        {
            view.announceForAccessibility(charsequence);
            return;
        } else
        {
            a(context, charsequence);
            return;
        }
    }
}
