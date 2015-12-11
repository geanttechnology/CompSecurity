// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2;

import android.os.Bundle;

// Referenced classes of package com.amazon.geo.mapsv2:
//            MapFragment, AmazonMapOptionsInternal, AmazonMapOptions, CoverageGapInitializer

public class MapFragmentInternal extends MapFragment
{

    private CoverageGapInitializer mCoverageGapInitializer;

    public MapFragmentInternal()
    {
    }

    public static MapFragmentInternal newInstance(AmazonMapOptionsInternal amazonmapoptionsinternal)
    {
        MapFragmentInternal mapfragmentinternal = new MapFragmentInternal();
        Bundle bundle = new Bundle();
        bundle.putParcelable("MapOptions", amazonmapoptionsinternal.get());
        mapfragmentinternal.setArguments(bundle);
        return mapfragmentinternal;
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        bundle = getArguments();
        if (bundle == null)
        {
            bundle = null;
        } else
        {
            bundle = (AmazonMapOptions)bundle.getParcelable("MapOptions");
        }
        if (bundle.getTileReplacer() != null && bundle.getTileReplacer().booleanValue())
        {
            mCoverageGapInitializer = new CoverageGapInitializer(this);
        }
    }

    public void onDestroy()
    {
        super.onDestroy();
        if (mCoverageGapInitializer != null)
        {
            mCoverageGapInitializer.cancel();
            mCoverageGapInitializer = null;
        }
    }
}
