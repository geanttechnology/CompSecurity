// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.activities.b;

import android.net.Uri;
import android.support.v4.app.i;
import com.shazam.android.activities.WebActivity;
import com.shazam.android.activities.a.b;
import com.shazam.android.aspects.activities.MiniTaggingActivityAspect;
import com.shazam.android.k.f.j;
import com.shazam.b.e.a;
import com.shazam.model.Tag;
import com.shazam.model.Track;

public final class c
    implements b
{

    private boolean a;
    private final j b;

    public c(j j1)
    {
        b = j1;
    }

    public final boolean a(Tag tag, i k, Uri uri)
    {
        if (com.shazam.b.e.a.a(tag.track.promoFullScreenUrl) || a)
        {
            return false;
        } else
        {
            a = true;
            tag = WebActivity.a(k, tag.track.promoFullScreenUrl, uri, tag.track.id, tag.track.beaconKey, tag.track.campaign);
            MiniTaggingActivityAspect.copyStateFrom(k, tag);
            j.a(j.a(k.getIntent()), tag);
            k.startActivityForResult(tag, 10001);
            return true;
        }
    }
}
