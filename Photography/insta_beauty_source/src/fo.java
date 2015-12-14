// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.support.v7.widget.SearchView;
import android.view.View;

public class fo
    implements android.view.View.OnLayoutChangeListener
{

    final SearchView a;

    public fo(SearchView searchview)
    {
        a = searchview;
        super();
    }

    public void onLayoutChange(View view, int i, int j, int k, int l, int i1, int j1, 
            int k1, int l1)
    {
        SearchView.access$300(a);
    }
}
