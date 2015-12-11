// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.app;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.text.TextUtils;
import com.wishabi.flipp.b.a;
import com.wishabi.flipp.b.s;
import com.wishabi.flipp.content.i;
import com.wishabi.flipp.widget.dr;

// Referenced classes of package com.wishabi.flipp.app:
//            SearchFragment

final class ej
    implements dr
{

    final SearchFragment a;

    ej(SearchFragment searchfragment)
    {
        a = searchfragment;
        super();
    }

    public final void a(String s1)
    {
        if (TextUtils.isEmpty(s1))
        {
            return;
        } else
        {
            ContentValues contentvalues = new ContentValues();
            contentvalues.put("name", s1);
            contentvalues.put("position", Integer.valueOf(0));
            contentvalues.put("checked", Integer.valueOf(0));
            contentvalues.put("datetime_updated", Long.valueOf(System.currentTimeMillis()));
            contentvalues.put("shopping_list_id", Integer.valueOf(0));
            a.getActivity().getContentResolver().insert(i.k, contentvalues);
            a.a.a(s1, s.c, -1);
            return;
        }
    }

    public final boolean a()
    {
        SearchFragment.j(a);
        return true;
    }
}
