// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps;

import ajc;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

public class StreetViewPanoramaView extends FrameLayout
{

    private final ajc a;

    public StreetViewPanoramaView(Context context)
    {
        super(context);
        a = new ajc(this, context, null);
    }

    public StreetViewPanoramaView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a = new ajc(this, context, null);
    }

    public StreetViewPanoramaView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        a = new ajc(this, context, null);
    }
}
