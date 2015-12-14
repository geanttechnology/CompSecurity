// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.support.v7.widget.SearchView;
import android.view.View;

public class fn
    implements android.view.View.OnFocusChangeListener
{

    final SearchView a;

    public fn(SearchView searchview)
    {
        a = searchview;
        super();
    }

    public void onFocusChange(View view, boolean flag)
    {
        if (SearchView.access$200(a) != null)
        {
            SearchView.access$200(a).onFocusChange(a, flag);
        }
    }
}
