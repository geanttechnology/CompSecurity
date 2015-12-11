// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.search;

import com.smule.android.c.aa;
import com.smule.android.network.managers.ak;
import com.smule.android.network.models.ListingV2;
import com.smule.android.network.models.SongV2;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.smule.pianoandroid.search:
//            FuzzySearchIndex

public class c
{

    private static final String a = com/smule/pianoandroid/search/c.getName();

    public c()
    {
    }

    public static void a()
    {
        FuzzySearchIndex fuzzysearchindex = (new FuzzySearchIndex()).a("songbook");
        aa.a(a, "Start building reverse index");
        Object obj = ak.a().e();
        HashMap hashmap = new HashMap(((List) (obj)).size());
        SongV2 songv2;
        for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); hashmap.put(songv2.songId, (new StringBuilder()).append(songv2.title).append(" ").append(songv2.artist).toString()))
        {
            songv2 = ((ListingV2)((Iterator) (obj)).next()).song;
        }

        aa.a(a, "Finished building reverse index");
        fuzzysearchindex.a(hashmap);
    }

}
