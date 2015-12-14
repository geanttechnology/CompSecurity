// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.support.v7.widget.SearchView;
import android.view.inputmethod.InputMethodManager;

public class fh
    implements Runnable
{

    final SearchView a;

    public fh(SearchView searchview)
    {
        a = searchview;
        super();
    }

    public void run()
    {
        InputMethodManager inputmethodmanager = (InputMethodManager)a.getContext().getSystemService("input_method");
        if (inputmethodmanager != null)
        {
            SearchView.HIDDEN_METHOD_INVOKER.a(inputmethodmanager, a, 0);
        }
    }
}
