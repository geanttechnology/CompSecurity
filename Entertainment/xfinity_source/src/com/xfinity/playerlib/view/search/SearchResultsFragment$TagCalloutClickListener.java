// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.search;

import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import com.xfinity.playerlib.model.tags.Tag;
import org.apache.commons.lang3.StringUtils;

// Referenced classes of package com.xfinity.playerlib.view.search:
//            SearchResultsFragment

private abstract class tagMatch
    implements android.view.CalloutClickListener
{

    private final Tag tagMatch;
    final SearchResultsFragment this$0;

    public void onClick(View view)
    {
        onTagSelected(tagMatch);
        String s1 = tagMatch.getName();
        view = SearchResultsFragment.access$2000(SearchResultsFragment.this).getEditableText();
        String s = view.toString();
        int i = StringUtils.indexOfIgnoreCase(s, s1);
        s1 = StringUtils.normalizeSpace(s.replace(s.substring(i, i + s1.length()), ""));
        SearchResultsFragment.access$900(SearchResultsFragment.this).setVisibility(8);
        view.replace(0, s.length(), s1);
        SearchResultsFragment.access$2000(SearchResultsFragment.this).setSelection(s1.length());
    }

    protected abstract void onTagSelected(Tag tag);

    public (Tag tag)
    {
        this$0 = SearchResultsFragment.this;
        super();
        tagMatch = tag;
    }
}
