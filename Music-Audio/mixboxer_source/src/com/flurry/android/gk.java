// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import android.content.Context;
import android.widget.VideoView;

final class gk extends VideoView
{

    public gk(Context context)
    {
        super(context);
        setFocusable(true);
        setFocusableInTouchMode(true);
    }

    public final void seekTo(int i)
    {
        if (i < getCurrentPosition())
        {
            super.seekTo(i);
        }
    }
}
