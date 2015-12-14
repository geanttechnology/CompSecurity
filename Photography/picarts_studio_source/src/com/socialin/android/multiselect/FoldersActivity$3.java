// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.multiselect;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import java.util.List;

// Referenced classes of package com.socialin.android.multiselect:
//            FoldersActivity, ItemsActivity, b, a

final class a
    implements android.widget.ClickListener
{

    private FoldersActivity a;

    public final void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        adapterview = new Intent(a.getApplicationContext(), com/socialin/android/multiselect/ItemsActivity);
        adapterview.putExtra("folder", ((a)FoldersActivity.a(a).getItem(i)).d);
        int j = FoldersActivity.b(a).size();
        view = new String[FoldersActivity.c(a)];
        for (i = 0; i < j; i++)
        {
            view[i] = (String)FoldersActivity.b(a).get(i);
        }

        adapterview.putExtra("selectedItemsArray", view);
        adapterview.putExtra("selectedItemsCount", j);
        adapterview.putExtra("itemsCount", FoldersActivity.d(a));
        a.startActivityForResult(adapterview, 1000);
    }

    (FoldersActivity foldersactivity)
    {
        a = foldersactivity;
        super();
    }
}
