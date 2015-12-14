// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.widget.EditText;
import com.perfectcorp.utility.e;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            SearchActivity, s

class a
    implements Runnable
{

    final SearchActivity a;

    public void run()
    {
        if (SearchActivity.b(a) == null)
        {
            return;
        }
        String s1 = SearchActivity.d(a).getText().toString().trim();
        e.b(new Object[] {
            "[QuerySearchSuggestionListRun][", s1, "]"
        });
        if (s1.isEmpty())
        {
            e.b(new Object[] {
                "[QuerySearchSuggestionListRun] Empty; show history."
            });
            SearchActivity.s(a).a();
            return;
        }
        if (s1.length() <= 1)
        {
            e.b(new Object[] {
                "[QuerySearchSuggestionListRun] Length less than ", Integer.valueOf(1), "; Leave the suggestion list untouched."
            });
            return;
        } else
        {
            e.b(new Object[] {
                "[QuerySearchSuggestionListRun] querySuggestionList"
            });
            SearchActivity.s(a).a(s1);
            return;
        }
    }

    (SearchActivity searchactivity)
    {
        a = searchactivity;
        super();
    }
}
