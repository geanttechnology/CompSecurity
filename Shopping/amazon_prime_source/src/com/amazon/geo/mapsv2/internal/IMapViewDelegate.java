// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2.internal;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

// Referenced classes of package com.amazon.geo.mapsv2.internal:
//            IObjectDelegate, IMapDelegate, IOnMapReadyCallbackPrimitive, ICoverageGapConfigCallback

public interface IMapViewDelegate
    extends IObjectDelegate
{
    public static final class LifecycleState extends Enum
    {

        private static final LifecycleState $VALUES[];
        public static final LifecycleState CREATED;
        public static final LifecycleState RESUMED;
        public static final LifecycleState UNINITIALIZED;

        public static LifecycleState valueOf(String s)
        {
            return (LifecycleState)Enum.valueOf(com/amazon/geo/mapsv2/internal/IMapViewDelegate$LifecycleState, s);
        }

        public static LifecycleState[] values()
        {
            return (LifecycleState[])$VALUES.clone();
        }

        static 
        {
            UNINITIALIZED = new LifecycleState("UNINITIALIZED", 0);
            CREATED = new LifecycleState("CREATED", 1);
            RESUMED = new LifecycleState("RESUMED", 2);
            $VALUES = (new LifecycleState[] {
                UNINITIALIZED, CREATED, RESUMED
            });
        }

        private LifecycleState(String s, int i)
        {
            super(s, i);
        }
    }


    public abstract Context getContext();

    public abstract IMapDelegate getMap();

    public abstract void getMapAsync(IOnMapReadyCallbackPrimitive ionmapreadycallbackprimitive);

    public abstract View getView();

    public abstract void onCreate(Bundle bundle);

    public abstract void onDestroy();

    public abstract void onDestroyView();

    public abstract void onLowMemory();

    public abstract void onPause();

    public abstract void onResume();

    public abstract void onSaveInstanceState(Bundle bundle);

    public abstract void onViewRecreated();

    public abstract View recreateView(Context context);

    public abstract void resetActivity(Context context);

    public abstract void setCoverageGapConfigCallback(ICoverageGapConfigCallback icoveragegapconfigcallback);
}
