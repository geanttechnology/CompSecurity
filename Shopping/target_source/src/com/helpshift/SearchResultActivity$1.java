// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import com.helpshift.i.e;
import java.util.ArrayList;

// Referenced classes of package com.helpshift:
//            SearchResultActivity, g, HSQuestion

class a
    implements android.widget.Listener
{

    final ArrayList a;
    final SearchResultActivity b;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        adapterview = (g)a.get(i - 1);
        view = new Intent(b, com/helpshift/HSQuestion);
        view.putExtra("questionPublishId", adapterview.b());
        view.putExtra("searchTerms", adapterview.j());
        view.putExtra("questionFlow", "showSearchOnNewConversationFlow");
        view.putExtra("showInFullScreen", e.a(b));
        b.startActivityForResult(view, 32699);
    }

    kListener(SearchResultActivity searchresultactivity, ArrayList arraylist)
    {
        b = searchresultactivity;
        a = arraylist;
        super();
    }
}
