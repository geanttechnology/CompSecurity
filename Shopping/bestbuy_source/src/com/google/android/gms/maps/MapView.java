// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps;

import aiu;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

// Referenced classes of package com.google.android.gms.maps:
//            GoogleMapOptions

public class MapView extends FrameLayout
{

    private final aiu a;

    public MapView(Context context)
    {
        super(context);
        a = new aiu(this, context, null);
    }

    public MapView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a = new aiu(this, context, GoogleMapOptions.a(context, attributeset));
    }

    public MapView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        a = new aiu(this, context, GoogleMapOptions.a(context, attributeset));
    }
}
