// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2;

import android.os.Bundle;

// Referenced classes of package com.amazon.geo.mapsv2:
//            SupportMapFragment, AmazonMapOptionsInternal, AmazonMapOptions, CoverageGapInitializer

public class SupportMapFragmentInternal extends SupportMapFragment
{

    private CoverageGapInitializer mCoverageGapInitializer;

    public SupportMapFragmentInternal()
    {
    }

    public static SupportMapFragmentInternal newInstance(AmazonMapOptionsInternal amazonmapoptionsinternal)
    {
        SupportMapFragmentInternal supportmapfragmentinternal = new SupportMapFragmentInternal();
        Bundle bundle = new Bundle();
        bundle.putParcelable("MapOptions", amazonmapoptionsinternal.get());
        supportmapfragmentinternal.setArguments(bundle);
        return supportmapfragmentinternal;
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
