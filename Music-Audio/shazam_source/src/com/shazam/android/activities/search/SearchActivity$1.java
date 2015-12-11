// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.activities.search;

import com.shazam.model.search.SearchSection;
import java.util.HashMap;

// Referenced classes of package com.shazam.android.activities.search:
//            SearchActivity

final class put extends HashMap
{

    final SearchActivity a;

    (SearchActivity searchactivity)
    {
        a = searchactivity;
        super();
        put(SearchSection.TOP_RESULT, Integer.valueOf(0x7f090109));
        put(SearchSection.SONGS, Integer.valueOf(0x7f090108));
        put(SearchSection.ARTISTS, Integer.valueOf(0x7f090101));
        put(SearchSection.RECENT_SEARCHES, Integer.valueOf(0x7f090107));
    }
}
