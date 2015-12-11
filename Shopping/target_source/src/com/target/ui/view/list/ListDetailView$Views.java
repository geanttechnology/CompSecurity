// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.list;

import android.view.View;
import android.widget.ImageView;
import com.target.ui.view.RecyclerViewScroll;
import com.target.ui.view.TargetImeEditText;
import com.target.ui.view.a;

// Referenced classes of package com.target.ui.view.list:
//            ListDetailView, ListItemSuggestionsView

static class ew extends a
{

    View addItemBlockingView;
    TargetImeEditText addItemEditText;
    View clearTextView;
    View itemsMaskView;
    ListItemSuggestionsView listItemSuggestionView;
    View mListDetailView;
    View progressBar;
    RecyclerViewScroll recyclerView;
    ImageView scanImageView;

    public ew(View view)
    {
        super(view);
    }
}
