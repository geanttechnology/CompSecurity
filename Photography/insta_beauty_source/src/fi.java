// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.support.v7.widget.SearchView;
import android.view.View;
import android.widget.AdapterView;

public class fi
    implements android.widget.AdapterView.OnItemClickListener
{

    final SearchView a;

    public fi(SearchView searchview)
    {
        a = searchview;
        super();
    }

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        SearchView.access$1900(a, i, 0, null);
    }
}
