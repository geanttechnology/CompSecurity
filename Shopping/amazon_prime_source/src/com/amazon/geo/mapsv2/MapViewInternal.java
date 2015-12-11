// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2;

import android.content.Context;
import android.util.AttributeSet;

// Referenced classes of package com.amazon.geo.mapsv2:
//            MapView, AmazonMapOptionsInternal, CoverageGapInitializer

public class MapViewInternal extends MapView
{

    private CoverageGapInitializer mCoverageGapInitializer;

    public MapViewInternal(Context context)
    {
        this(context, null, null, 0);
    }

    public MapViewInternal(Context context, AttributeSet attributeset)
    {
        this(context, null, attributeset, 0);
    }

    public MapViewInternal(Context context, AttributeSet attributeset, int i)
    {
        this(context, AmazonMapOptionsInternal.createFromAttributes(context, attributeset), attributeset, i);
    }

    public MapViewInternal(Context context, AmazonMapOptionsInternal amazonmapoptionsinternal)
    {
        this(context, amazonmapoptionsinternal, null, 0);
    }

    private MapViewInternal(Context context, AmazonMapOptionsInternal amazonmapoptionsinternal, AttributeSet attributeset, int i)
    {
        super(context, amazonmapoptionsinternal.get(), attributeset, i);
        if (amazonmapoptionsinternal.getTileReplacer() != null && amazonmapoptionsinternal.getTileReplacer().booleanValue())
        {
            mCoverageGapInitializer = new CoverageGapInitializer(this);
        }
    }

    void onDestroyInternal()
    {
        if (mCoverageGapInitializer != null)
        {
            mCoverageGapInitializer.cancel();
            mCoverageGapInitializer = null;
        }
    }
}
