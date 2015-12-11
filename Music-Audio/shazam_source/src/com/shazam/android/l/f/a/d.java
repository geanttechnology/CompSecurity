// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.l.f.a;

import android.content.Context;
import android.content.Intent;
import com.shazam.android.activities.modules.VideoActivity;
import com.shazam.b.a.a;
import com.shazam.model.Action;
import com.shazam.model.availability.YouTubeAvailability;

public final class d
    implements a
{

    private final Context a;
    private final YouTubeAvailability b;

    public d(Context context, YouTubeAvailability youtubeavailability)
    {
        a = context;
        b = youtubeavailability;
    }

    public final Object a(Object obj)
    {
        obj = (Action)obj;
        if (b.a())
        {
            if (!com.shazam.b.e.a.a(((String) (obj = ((Action) (obj)).href))))
            {
                Intent intent = new Intent(a, com/shazam/android/activities/modules/VideoActivity);
                intent.putExtra("extraUrl", ((String) (obj)));
                return intent;
            }
        }
        return null;
    }
}
