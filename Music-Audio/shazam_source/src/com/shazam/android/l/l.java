// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.l;

import android.content.Intent;
import com.shazam.android.analytics.TaggingOrigin;
import com.shazam.b.a.a;

public final class l
    implements a
{

    public l()
    {
    }

    public final Object a(Object obj)
    {
        Object obj1 = (Intent)obj;
        com.shazam.android.analytics.TaggedBeaconData.Builder builder;
        if (obj1 == null)
        {
            builder = com.shazam.android.analytics.TaggedBeaconData.Builder.taggedBeaconData();
            obj = TaggingOrigin.UNKNOWN;
        } else
        {
            obj = ((Intent) (obj1)).getStringExtra("origin");
            builder = com.shazam.android.analytics.TaggedBeaconData.Builder.taggedBeaconData();
            obj1 = ((Intent) (obj1)).getStringExtra("android.intent.extra.REFERRER_NAME");
            boolean flag;
            if (com.shazam.b.e.a.c(((String) (obj1))) && ((String) (obj1)).startsWith("android-app://com.google.android.googlequicksearchbox"))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                obj = TaggingOrigin.VOICE_ACTION;
            } else
            {
                obj = TaggingOrigin.fromString(((String) (obj)));
            }
        }
        return builder.withTaggingOrigin(((TaggingOrigin) (obj))).build();
    }
}
