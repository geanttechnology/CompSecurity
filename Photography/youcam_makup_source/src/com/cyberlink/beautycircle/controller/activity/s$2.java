// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.content.SharedPreferences;
import com.cyberlink.beautycircle.Globals;
import com.perfectcorp.utility.j;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            s

class a extends j
{

    final s a;

    protected volatile Object a(Object obj)
    {
        return a((String)obj);
    }

    protected Void a(String s1)
    {
        Globals.D().edit().putString((new StringBuilder()).append("LOCAL_RECENT_KEYWORDS_").append(s1).toString(), "{\"totalSize\":0,\"results\":[]}").commit();
        return null;
    }

    (s s1)
    {
        a = s1;
        super();
    }
}
