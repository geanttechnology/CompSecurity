// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.support.v7.widget.SearchView;

public class fp
    implements android.view.ViewTreeObserver.OnGlobalLayoutListener
{

    final SearchView a;

    public fp(SearchView searchview)
    {
        a = searchview;
        super();
    }

    public void onGlobalLayout()
    {
        SearchView.access$300(a);
    }
}
