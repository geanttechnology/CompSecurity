// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.support.v4.widget.CursorAdapter;
import do;

// Referenced classes of package android.support.v7.widget:
//            SearchView

class a
    implements Runnable
{

    final SearchView a;

    public void run()
    {
        if (SearchView.access$100(a) != null && (SearchView.access$100(a) instanceof do))
        {
            SearchView.access$100(a).changeCursor(null);
        }
    }

    (SearchView searchview)
    {
        a = searchview;
        super();
    }
}
