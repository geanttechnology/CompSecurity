// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.widget;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import android.widget.FilterQueryProvider;

// Referenced classes of package com.wishabi.flipp.widget:
//            CustomAutoCompleteTextView

final class as
    implements FilterQueryProvider
{

    final CustomAutoCompleteTextView a;

    as(CustomAutoCompleteTextView customautocompletetextview)
    {
        a = customautocompletetextview;
        super();
    }

    public final Cursor runQuery(CharSequence charsequence)
    {
        if (TextUtils.isEmpty(charsequence))
        {
            return null;
        } else
        {
            charsequence = (new android.net.Uri.Builder()).scheme("content").authority("com.wishabi.flipp.content.SearchTerm").appendEncodedPath("item").appendPath("search_suggest_query").appendPath(charsequence.toString()).build();
            return a.getContext().getContentResolver().query(charsequence, null, null, null, null);
        }
    }
}
