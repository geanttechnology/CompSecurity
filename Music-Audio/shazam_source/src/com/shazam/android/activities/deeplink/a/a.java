// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.activities.deeplink.a;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import com.shazam.android.k.f.j;
import com.shazam.model.analytics.ScreenOrigin;
import com.shazam.model.analytics.event.DefinedEventParameterKey;

// Referenced classes of package com.shazam.android.activities.deeplink.a:
//            b

public final class a
    implements b
{

    private final j b = new j();
    private final Class c;

    public a(Class class1)
    {
        c = class1;
    }

    public final void a(Uri uri, Activity activity)
    {
        Intent intent = new Intent(activity, c);
        intent.setData(uri);
        com.shazam.android.k.f.i.a a1 = new com.shazam.android.k.f.i.a();
        com.shazam.model.analytics.AnalyticsInfo.Builder builder = com.shazam.model.analytics.AnalyticsInfo.Builder.a();
        DefinedEventParameterKey definedeventparameterkey = DefinedEventParameterKey.SCREEN_ORIGIN;
        uri = uri.getQueryParameter("screenorigin");
        if (!com.shazam.b.e.a.c(uri))
        {
            uri = ScreenOrigin.HTTP_DEEPLINK.value;
        }
        a1.a = builder.a(definedeventparameterkey, uri).b();
        j.a(a1.a(), intent);
        activity.startActivity(intent);
    }
}
