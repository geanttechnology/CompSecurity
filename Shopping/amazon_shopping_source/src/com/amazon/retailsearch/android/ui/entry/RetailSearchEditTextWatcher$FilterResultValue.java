// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.entry;

import android.database.Cursor;

// Referenced classes of package com.amazon.retailsearch.android.ui.entry:
//            RetailSearchEditTextWatcher

private class mSearchTerm
{

    public Cursor mCursor;
    public String mSearchTerm;
    final RetailSearchEditTextWatcher this$0;

    public (Cursor cursor, String s)
    {
        this$0 = RetailSearchEditTextWatcher.this;
        super();
        mCursor = cursor;
        mSearchTerm = s;
    }
}
