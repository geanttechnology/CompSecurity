// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.widget.share;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import com.shazam.model.share.ShareData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.shazam.android.widget.share:
//            c

public final class a
    implements c
{

    private final PackageManager a;
    private final com.shazam.b.a.a b;
    private final com.shazam.b.a.a c;

    public a(PackageManager packagemanager, com.shazam.b.a.a a1, com.shazam.b.a.a a2)
    {
        a = packagemanager;
        b = a1;
        c = a2;
    }

    public final List a(ShareData sharedata)
    {
        sharedata = (Intent)b.a(sharedata);
        Object obj = a.queryIntentActivities(sharedata, 0x10000);
        sharedata = new ArrayList(((List) (obj)).size());
        com.shazam.model.share.ShareDataItem.Builder builder;
        for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); sharedata.add(builder.b()))
        {
            ResolveInfo resolveinfo = (ResolveInfo)((Iterator) (obj)).next();
            ActivityInfo activityinfo = resolveinfo.activityInfo;
            builder = com.shazam.model.share.ShareDataItem.Builder.a();
            builder.title = resolveinfo.loadLabel(a).toString();
            builder.iconUri = (String)c.a(resolveinfo);
            builder.intentPackageName = activityinfo.packageName;
            builder.intentClassName = activityinfo.name;
        }

        return sharedata;
    }
}
