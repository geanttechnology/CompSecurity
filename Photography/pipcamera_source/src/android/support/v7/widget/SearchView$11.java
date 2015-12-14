// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.support.v4.view.KeyEventCompat;
import android.view.KeyEvent;
import android.view.View;

// Referenced classes of package android.support.v7.widget:
//            SearchView

class a
    implements android.view.ener
{

    final SearchView a;

    public boolean onKey(View view, int i, KeyEvent keyevent)
    {
        if (SearchView.access$1500(a) != null)
        {
            if (SearchView.access$1300(a).isPopupShowing() && SearchView.access$1300(a).getListSelection() != -1)
            {
                return SearchView.access$1600(a, view, i, keyevent);
            }
            if (!rchAutoComplete.access._mth1700(SearchView.access$1300(a)) && KeyEventCompat.hasNoModifiers(keyevent) && keyevent.getAction() == 1 && i == 66)
            {
                view.cancelLongPress();
                SearchView.access$1800(a, 0, null, SearchView.access$1300(a).getText().toString());
                return true;
            }
        }
        return false;
    }

    rchAutoComplete(SearchView searchview)
    {
        a = searchview;
        super();
    }
}
