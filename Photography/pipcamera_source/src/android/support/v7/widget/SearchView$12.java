// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.view.KeyEvent;
import android.widget.TextView;

// Referenced classes of package android.support.v7.widget:
//            SearchView

class a
    implements android.widget.torActionListener
{

    final SearchView a;

    public boolean onEditorAction(TextView textview, int i, KeyEvent keyevent)
    {
        SearchView.access$900(a);
        return true;
    }

    stener(SearchView searchview)
    {
        a = searchview;
        super();
    }
}
