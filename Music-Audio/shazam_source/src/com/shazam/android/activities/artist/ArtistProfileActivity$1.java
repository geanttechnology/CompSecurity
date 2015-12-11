// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.activities.artist;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;

// Referenced classes of package com.shazam.android.activities.artist:
//            ArtistProfileActivity

final class a extends ViewOutlineProvider
{

    final ArtistProfileActivity a;

    public final void getOutline(View view, Outline outline)
    {
        outline.setRect(-50, -500, view.getWidth() + 50, view.getHeight());
    }

    (ArtistProfileActivity artistprofileactivity)
    {
        a = artistprofileactivity;
        super();
    }
}
