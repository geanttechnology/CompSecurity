// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.support.v4.widget.CursorAdapter;
import android.support.v7.widget.SearchView;

public class fm
    implements Runnable
{

    final SearchView a;

    public fm(SearchView searchview)
    {
        a = searchview;
        super();
    }

    public void run()
    {
        if (SearchView.access$100(a) != null && (SearchView.access$100(a) instanceof fy))
        {
            SearchView.access$100(a).changeCursor(null);
        }
    }
}
