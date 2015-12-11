// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.crashlytics.android.answers;

import android.content.Context;
import c.a.a.a.a.b.l;
import c.a.a.a.a.b.x;
import c.a.a.a.a.b.y;
import java.util.Map;
import java.util.UUID;

// Referenced classes of package com.crashlytics.android.answers:
//            SessionEventMetadata

class SessionMetadataCollector
{

    private final Context context;
    private final x idManager;
    private final String versionCode;
    private final String versionName;

    public SessionMetadataCollector(Context context1, x x1, String s, String s1)
    {
        context = context1;
        idManager = x1;
        versionCode = s;
        versionName = s1;
    }

    public SessionEventMetadata getMetadata()
    {
        Object obj = idManager.g();
        String s = context.getPackageName();
        String s1 = idManager.b();
        String s2 = (String)((Map) (obj)).get(y.d);
        String s3 = (String)((Map) (obj)).get(y.g);
        Boolean boolean1 = idManager.i();
        obj = (String)((Map) (obj)).get(y.c);
        String s4 = l.k(context);
        String s5 = idManager.d();
        String s6 = idManager.e();
        return new SessionEventMetadata(s, UUID.randomUUID().toString(), s1, s2, s3, boolean1, ((String) (obj)), s4, s5, s6, versionCode, versionName);
    }
}
