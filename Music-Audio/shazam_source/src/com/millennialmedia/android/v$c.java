// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import java.util.List;

// Referenced classes of package com.millennialmedia.android:
//            v

private final class b
{

    String a;
    int b;
    final v c;

    final boolean a(Context context)
    {
        Intent intent;
        if (a.contains("://"))
        {
            intent = new Intent("android.intent.action.VIEW", Uri.parse(a));
        } else
        {
            intent = new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder()).append(a).append("://").toString()));
        }
        return context.getPackageManager().queryIntentActivities(intent, 0x10000).size() > 0;
    }

    r(v v1)
    {
        c = v1;
        super();
    }

    c(v v1, String s, int i)
    {
        c = v1;
        super();
        a = s;
        b = i;
    }
}
