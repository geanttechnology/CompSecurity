// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.utils;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.util.Log;
import com.b.a.a.g;

// Referenced classes of package com.offerup.android.utils:
//            s, t, o, q, 
//            p, r

public final class n
{

    private static String a = "DialogHelper";

    public static void a(Activity activity, long l)
    {
        android.app.AlertDialog.Builder builder = c(activity);
        builder.setTitle("Unable to Send Message");
        builder.setMessage("You have previously blocked this user.");
        builder.setNegativeButton("Cancel", new s());
        builder.setPositiveButton("View Profile", new t(activity, l));
        a(builder);
    }

    public static void a(android.app.AlertDialog.Builder builder)
    {
        if (builder == null)
        {
            break MISSING_BLOCK_LABEL_9;
        }
        builder.show();
        return;
        builder;
        g.c(a, Log.getStackTraceString(builder));
        return;
    }

    public static void a(Dialog dialog)
    {
        if (dialog == null)
        {
            break MISSING_BLOCK_LABEL_15;
        }
        if (dialog.isShowing())
        {
            dialog.dismiss();
        }
        return;
        dialog;
        g.a(a, dialog);
        return;
    }

    public static void a(Context context)
    {
        android.app.AlertDialog.Builder builder = c(context);
        builder.setTitle(context.getString(0x7f09017d));
        builder.setMessage(context.getString(0x7f09017b));
        builder.setNeutralButton("OK", new o());
        a(builder);
    }

    public static void a(Context context, int i, int j)
    {
        a(context, context.getString(i), context.getString(j));
    }

    public static void a(Context context, int i, String s1)
    {
        a(context, context.getString(0x7f090132), s1);
    }

    public static void a(Context context, String s1, String s2)
    {
        context = c(context);
        context.setTitle(s1);
        context.setMessage(s2);
        context.setNeutralButton("OK", new q());
        a(((android.app.AlertDialog.Builder) (context)));
    }

    public static android.app.AlertDialog.Builder b(Context context)
    {
        android.app.AlertDialog.Builder builder = c(context);
        builder.setTitle(context.getString(0x7f090178));
        builder.setMessage(context.getString(0x7f090176));
        builder.setNegativeButton("Cancel", new p());
        return builder;
    }

    public static android.app.AlertDialog.Builder b(Context context, String s1, String s2)
    {
        context = c(context);
        context.setTitle(s1);
        context.setMessage(s2);
        context.setNegativeButton("Cancel", new r());
        return context;
    }

    public static android.app.AlertDialog.Builder c(Context context)
    {
        try
        {
            context = new android.app.AlertDialog.Builder(context, 4);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            g.a(a, context);
            return null;
        }
        return context;
    }

}
