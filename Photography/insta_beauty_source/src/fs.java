// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.support.v7.widget.SearchView;
import android.view.KeyEvent;
import android.widget.TextView;

public class fs
    implements android.widget.TextView.OnEditorActionListener
{

    final SearchView a;

    public fs(SearchView searchview)
    {
        a = searchview;
        super();
    }

    public boolean onEditorAction(TextView textview, int i, KeyEvent keyevent)
    {
        SearchView.access$900(a);
        return true;
    }
}
