// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.widget;

import android.database.Cursor;

// Referenced classes of package com.wishabi.flipp.widget:
//            CustomAutoCompleteTextView

final class at
    implements android.widget.SimpleCursorAdapter.CursorToStringConverter
{

    final CustomAutoCompleteTextView a;

    at(CustomAutoCompleteTextView customautocompletetextview)
    {
        a = customautocompletetextview;
        super();
    }

    public final CharSequence convertToString(Cursor cursor)
    {
        return cursor.getString(cursor.getColumnIndex("suggest_intent_query"));
    }
}
