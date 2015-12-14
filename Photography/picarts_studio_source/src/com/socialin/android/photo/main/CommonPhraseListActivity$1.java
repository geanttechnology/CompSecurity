// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.main;

import android.content.Intent;
import android.database.Cursor;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import com.socialin.android.apiv3.util.AnalyticUtils;

// Referenced classes of package com.socialin.android.photo.main:
//            CommonPhraseListActivity

final class a
    implements android.widget.ener
{

    private CommonPhraseListActivity a;

    public final void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        adapterview = ((AdapterView) (CommonPhraseListActivity.a(a).getItem(i)));
        if (adapterview != null && (adapterview instanceof Cursor) && ((Cursor)adapterview).moveToPosition(i))
        {
            adapterview = (Cursor)adapterview;
            view = new Intent();
            view.putExtra("text", adapterview.getString(adapterview.getColumnIndex("addtext_addedtext")));
            a.setResult(-1, view);
            CommonPhraseListActivity.b(a).setAdapter(null);
            a.finish();
            AnalyticUtils.getInstance(a).trackLocalAction("commonPhrase:done");
            adapterview.close();
        }
    }

    (CommonPhraseListActivity commonphraselistactivity)
    {
        a = commonphraselistactivity;
        super();
    }
}
