// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.view.View;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.activity:
//            GlobalSearchResult, IntentFactory

class val.searchText
    implements android.view.esult._cls5
{

    final GlobalSearchResult this$0;
    final CharSequence val$clientConsumedTitle;
    final CharSequence val$searchText;

    public void onClick(View view)
    {
        if (!isDeepLinked && !isCategoryCarousel && isFromGlobalSearch)
        {
            setResult(-1);
            finish();
            overridePendingTransition(0, 0);
            return;
        }
        if (Strings.notEmpty(searchTerm))
        {
            view = searchTerm;
        } else
        if (Strings.isEmpty(val$clientConsumedTitle))
        {
            view = val$searchText.toString();
        } else
        {
            view = "";
        }
        if (isCategoryCarousel)
        {
            startActivity(GlobalSearchResult.access$400(GlobalSearchResult.this).newGlobalSearchIntent(searchSourceChannel, view));
            finish();
            return;
        } else
        {
            startActivity(GlobalSearchResult.access$400(GlobalSearchResult.this).newGlobalSearchIntent(getOriginatingNstChannel(), view, isDeepLinked));
            return;
        }
    }

    ()
    {
        this$0 = final_globalsearchresult;
        val$clientConsumedTitle = charsequence;
        val$searchText = CharSequence.this;
        super();
    }
}
