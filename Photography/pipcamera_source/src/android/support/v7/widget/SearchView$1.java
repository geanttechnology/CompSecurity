// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.content.Context;
import android.view.inputmethod.InputMethodManager;
import dj;

// Referenced classes of package android.support.v7.widget:
//            SearchView

class a
    implements Runnable
{

    final SearchView a;

    public void run()
    {
        InputMethodManager inputmethodmanager = (InputMethodManager)a.getContext().getSystemService("input_method");
        if (inputmethodmanager != null)
        {
            SearchView.HIDDEN_METHOD_INVOKER.a(inputmethodmanager, a, 0);
        }
    }

    ager(SearchView searchview)
    {
        a = searchview;
        super();
    }
}
