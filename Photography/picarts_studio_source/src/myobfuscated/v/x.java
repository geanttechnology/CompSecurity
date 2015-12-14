// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.v;

import android.text.TextUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package myobfuscated.v:
//            y

public final class x
{

    private static final String b = System.getProperty("http.agent");
    private static final Map c;
    Map a;

    public x()
    {
        a = c;
    }

    static 
    {
        HashMap hashmap = new HashMap(2);
        if (!TextUtils.isEmpty(b))
        {
            hashmap.put("User-Agent", Collections.singletonList(new y(b)));
        }
        hashmap.put("Accept-Encoding", Collections.singletonList(new y("identity")));
        c = Collections.unmodifiableMap(hashmap);
    }
}
