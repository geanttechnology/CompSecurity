// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.app;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ListAdapter;

// Referenced classes of package android.support.v7.app:
//            l, d

public class e extends l
    implements DialogInterface
{
    public static class a
    {

        private final d.a a;
        private int b;

        public Context a()
        {
            return a.a;
        }

        public a a(android.content.DialogInterface.OnKeyListener onkeylistener)
        {
            a.r = onkeylistener;
            return this;
        }

        public a a(Drawable drawable)
        {
            a.d = drawable;
            return this;
        }

        public a a(View view)
        {
            a.g = view;
            return this;
        }

        public a a(ListAdapter listadapter, android.content.DialogInterface.OnClickListener onclicklistener)
        {
            a.t = listadapter;
            a.u = onclicklistener;
            return this;
        }

        public a a(CharSequence charsequence)
        {
            a.f = charsequence;
            return this;
        }

        public e b()
        {
            e e1 = new e(a.a, b, false);
            a.a(e.a(e1));
            e1.setCancelable(a.o);
            if (a.o)
            {
                e1.setCanceledOnTouchOutside(true);
            }
            e1.setOnCancelListener(a.p);
            e1.setOnDismissListener(a.q);
            if (a.r != null)
            {
                e1.setOnKeyListener(a.r);
            }
            return e1;
        }

        public a(Context context)
        {
            this(context, e.a(context, 0));
        }

        public a(Context context, int i)
        {
            a = new d.a(new ContextThemeWrapper(context, e.a(context, i)));
            b = i;
        }
    }


    private d a;

    e(Context context, int i, boolean flag)
    {
        super(context, a(context, i));
        a = new d(getContext(), this, getWindow());
    }

    static int a(Context context, int i)
    {
        if (i >= 0x1000000)
        {
            return i;
        } else
        {
            TypedValue typedvalue = new TypedValue();
            context.getTheme().resolveAttribute(android.support.v7.a.a.a.alertDialogTheme, typedvalue, true);
            return typedvalue.resourceId;
        }
    }

    static d a(e e1)
    {
        return e1.a;
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        a.a();
    }

    public boolean onKeyDown(int i, KeyEvent keyevent)
    {
        if (a.a(i, keyevent))
        {
            return true;
        } else
        {
            return super.onKeyDown(i, keyevent);
        }
    }

    public boolean onKeyUp(int i, KeyEvent keyevent)
    {
        if (a.b(i, keyevent))
        {
            return true;
        } else
        {
            return super.onKeyUp(i, keyevent);
        }
    }

    public void setTitle(CharSequence charsequence)
    {
        super.setTitle(charsequence);
        a.a(charsequence);
    }
}
