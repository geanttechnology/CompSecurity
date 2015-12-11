// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.an.a;

import com.shazam.a.g;
import com.shazam.android.an.r;
import com.shazam.android.c.a;
import com.shazam.server.response.streaming.StreamingProviderTrackMapping;
import com.shazam.server.response.streaming.StreamingProviderTrackMappings;
import com.shazam.server.response.streaming.rdio.RdioTrackMapping;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class b extends a
{

    private final r a;
    private final g b;
    private final URL c;

    public b(r r1, g g1, URL url)
    {
        super(com/shazam/android/an/a/b, "getRdioTrackIds");
        a = r1;
        b = g1;
        c = url;
    }

    protected volatile Object a(Object aobj[])
    {
        return a((String[])aobj);
    }

    protected transient List a(String as[])
    {
        if (as.length == 0)
        {
            return Collections.emptyList();
        }
        as = com.shazam.b.e.a.a(Arrays.asList(as));
        ArrayList arraylist;
        Iterator iterator;
        as = b.a(c, as);
        if (((StreamingProviderTrackMappings) (as)).streamingProviderTrackMappings == null)
        {
            return Collections.emptyList();
        }
        as = ((StreamingProviderTrackMappings) (as)).streamingProviderTrackMappings;
        arraylist = new ArrayList(as.size());
        iterator = as.iterator();
_L7:
        if (!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        as = (StreamingProviderTrackMapping)iterator.next();
        if (((StreamingProviderTrackMapping) (as)).rdioTrackMapping != null) goto _L4; else goto _L3
_L3:
        as = RdioTrackMapping.EMPTY;
_L5:
        if (a(((RdioTrackMapping) (as))))
        {
            arraylist.add(((RdioTrackMapping) (as)).trackKey);
        }
        continue; /* Loop/switch isn't completed */
_L4:
        as = ((StreamingProviderTrackMapping) (as)).rdioTrackMapping;
        if (true) goto _L5; else goto _L2
_L2:
        return arraylist;
        as;
        return null;
        if (true) goto _L7; else goto _L6
_L6:
    }

    protected boolean a(RdioTrackMapping rdiotrackmapping)
    {
        return com.shazam.b.e.a.c(rdiotrackmapping.trackKey);
    }

    protected void onPostExecute(Object obj)
    {
        obj = (List)obj;
        if (obj != null)
        {
            a.a(((List) (obj)));
            return;
        } else
        {
            a.c();
            return;
        }
    }
}
