// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.util.e;

import android.app.Dialog;
import android.content.Context;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import com.target.ui.util.q;
import java.lang.ref.WeakReference;

public final class com.target.ui.util.e.a
{
    private static final class a
        implements Runnable
    {

        public static final int POST_DELAY_MS = 50;
        WeakReference contextRef;
        WeakReference viewRef;

        public void run()
        {
            Context context = (Context)contextRef.get();
            View view = (View)viewRef.get();
            if (context == null || view == null)
            {
                return;
            } else
            {
                com.target.ui.util.e.a.a(context).showSoftInput(view, 0);
                return;
            }
        }

        public a(Context context, View view)
        {
            contextRef = new WeakReference(context);
            viewRef = new WeakReference(view);
        }
    }


    private static final String TAG = com/target/ui/util/e/a.getSimpleName();

    private com.target.ui.util.e.a()
    {
    }

    static InputMethodManager a(Context context)
    {
        return b(context);
    }

    public static void a(Dialog dialog)
    {
        a(dialog, 5);
    }

    private static void a(Dialog dialog, int i)
    {
        if (dialog == null)
        {
            q.c(TAG, "Tried to show soft keyboard but dialog is null");
        } else
        {
            dialog = dialog.getWindow();
            if (dialog != null)
            {
                dialog.setSoftInputMode(i);
                return;
            }
        }
    }

    public static void a(DialogFragment dialogfragment)
    {
        if (dialogfragment == null)
        {
            q.c(TAG, "Tried to close soft keyboard but dialog fragment is null");
        } else
        {
            InputMethodManager inputmethodmanager = b(dialogfragment.getActivity());
            dialogfragment = dialogfragment.getDialog().getWindow();
            if (dialogfragment != null)
            {
                inputmethodmanager.hideSoftInputFromWindow(dialogfragment.getDecorView().getWindowToken(), 0);
                return;
            }
        }
    }

    public static void a(Fragment fragment)
    {
        if (fragment == null)
        {
            q.c(TAG, "Tried to close soft keyboard but fragment is null");
        } else
        {
            InputMethodManager inputmethodmanager = b(fragment.getActivity());
            if (fragment.getView() != null)
            {
                inputmethodmanager.hideSoftInputFromWindow(fragment.getView().getWindowToken(), 0);
                return;
            }
        }
    }

    public static void a(View view)
    {
        if (view == null)
        {
            q.c(TAG, "Tried to close soft keyboard but view is null");
        }
        b(view.getContext()).hideSoftInputFromWindow(view.getWindowToken(), 2);
    }

    private static InputMethodManager b(Context context)
    {
        return (InputMethodManager)context.getSystemService("input_method");
    }

    public static void b(View view)
    {
        if (view == null)
        {
            q.a(TAG, "Tried to show keyboard but view was null");
            return;
        } else
        {
            view.postDelayed(new a(view.getContext(), view), 50L);
            return;
        }
    }

    public static void c(View view)
    {
        if (view != null)
        {
            b(view.getContext()).showSoftInput(view, 1);
        }
    }

}
