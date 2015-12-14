// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;

public final class g extends ProgressDialog
{

    private View a;
    private Dialog b;
    private android.content.DialogInterface.OnCancelListener c;
    private Message d;
    private Context e;
    private android.content.DialogInterface.OnDismissListener f;
    private boolean g;
    private boolean h;

    public g(Context context)
    {
        this(context, 0x7f0c0187);
    }

    private g(Context context, int i)
    {
        super(context, i);
        a = null;
        b = null;
        c = null;
        d = null;
        e = null;
        f = null;
        g = true;
        h = true;
        a(context);
    }

    private static g a(Context context, CharSequence charsequence, boolean flag, boolean flag1)
    {
        context = new g(context);
        context.setMessage(charsequence);
        context.setCancelable(flag1);
        context.setOnCancelListener(null);
        context.setIndeterminate(flag);
        context.show();
        return context;
    }

    public static g a(Context context, String s, String s1)
    {
        return a(context, ((CharSequence) (s1)), false, false);
    }

    public static g a(Context context, String s, boolean flag)
    {
        return a(context, ((CharSequence) (s)), flag, true);
    }

    private void a(Context context)
    {
        LayoutInflater layoutinflater = LayoutInflater.from(context);
        e = context;
        a = layoutinflater.inflate(0x7f03009a, null);
    }

    public final void cancel()
    {
        if (b != null)
        {
            b.cancel();
        }
    }

    public final void dismiss()
    {
        if (b != null)
        {
            b.dismiss();
        }
    }

    public final boolean isShowing()
    {
        if (b == null)
        {
            return false;
        } else
        {
            return b.isShowing();
        }
    }

    public final void setCancelable(boolean flag)
    {
        if (b != null)
        {
            b.setCancelable(flag);
        }
        g = flag;
    }

    public final void setCanceledOnTouchOutside(boolean flag)
    {
        if (b != null)
        {
            b.setCanceledOnTouchOutside(flag);
        }
        h = flag;
    }

    public final void setDismissMessage(Message message)
    {
        d = message;
    }

    public final void setMessage(CharSequence charsequence)
    {
    }

    public final void setOnCancelListener(android.content.DialogInterface.OnCancelListener oncancellistener)
    {
        if (b != null)
        {
            b.setOnCancelListener(oncancellistener);
        }
        c = oncancellistener;
    }

    public final void setOnDismissListener(android.content.DialogInterface.OnDismissListener ondismisslistener)
    {
        if (b != null)
        {
            b.setOnDismissListener(ondismisslistener);
        }
        f = ondismisslistener;
    }

    public final void show()
    {
        if (b != null && b.isShowing())
        {
            boolean flag;
            if (e == null || (e instanceof Activity) && ((Activity)e).isFinishing())
            {
                flag = false;
            } else
            {
                flag = true;
            }
            if (flag)
            {
                return;
            }
        }
        a(e);
        b = new Dialog(e, 0x7f0c0187);
        b.getWindow().clearFlags(2);
        if (c != null)
        {
            b.setOnCancelListener(c);
        }
        if (d != null)
        {
            b.setDismissMessage(d);
        }
        if (f != null)
        {
            b.setOnDismissListener(f);
        }
        b.setContentView(a);
        b.setCancelable(g);
        b.setCanceledOnTouchOutside(h);
        b.show();
    }
}
