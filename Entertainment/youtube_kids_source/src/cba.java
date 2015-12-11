// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.Uri;
import java.util.HashMap;
import java.util.Map;

public final class cba
    implements crb
{

    private final crb a;

    cba(crb crb1, int i)
    {
        b.a(crb1);
        a = new cbb(crb1, 50);
    }

    static Uri a(Uri uri, int i, int j)
    {
        HashMap hashmap = new HashMap();
        hashmap.put("start-index", String.valueOf(i));
        hashmap.put("max-results", String.valueOf(j));
        return a.a(uri, hashmap);
    }

    public final void a(Object obj, bhv bhv)
    {
        obj = (bzi)obj;
        a.a(obj, new cbd(bhv));
    }
}
