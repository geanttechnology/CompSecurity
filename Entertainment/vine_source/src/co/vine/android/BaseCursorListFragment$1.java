// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

// Referenced classes of package co.vine.android:
//            BaseCursorListFragment

class this._cls0
    implements android.widget.stener
{

    final BaseCursorListFragment this$0;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        onListItemClick((ListView)adapterview, view, i, l);
    }

    tener()
    {
        this$0 = BaseCursorListFragment.this;
        super();
    }
}
