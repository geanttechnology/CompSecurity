// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.support.v7.widget.SearchView;
import android.view.View;
import android.widget.AdapterView;

public class fj
    implements android.widget.AdapterView.OnItemSelectedListener
{

    final SearchView a;

    public fj(SearchView searchview)
    {
        a = searchview;
        super();
    }

    public void onItemSelected(AdapterView adapterview, View view, int i, long l)
    {
        SearchView.access$2000(a, i);
    }

    public void onNothingSelected(AdapterView adapterview)
    {
    }
}
