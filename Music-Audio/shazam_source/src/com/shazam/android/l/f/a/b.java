// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.l.f.a;

import android.content.Context;
import com.shazam.android.activities.VideoPlayerActivity;
import com.shazam.b.a.a;
import com.shazam.model.Action;

public final class b
    implements a
{

    private final Context a;

    public b(Context context)
    {
        a = context;
    }

    public final Object a(Object obj)
    {
        obj = (Action)obj;
        return VideoPlayerActivity.a(a, (new android.net.Uri.Builder()).path(((Action) (obj)).href).build(), "", "", "");
    }
}
