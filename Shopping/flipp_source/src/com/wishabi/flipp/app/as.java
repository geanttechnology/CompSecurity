// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.app;

import android.app.LoaderManager;
import android.content.SharedPreferences;
import com.wishabi.flipp.widget.CollectionView;

// Referenced classes of package com.wishabi.flipp.app:
//            FeaturedFragment

final class as
    implements android.content.SharedPreferences.OnSharedPreferenceChangeListener
{

    final FeaturedFragment a;

    as(FeaturedFragment featuredfragment)
    {
        a = featuredfragment;
        super();
    }

    public final void onSharedPreferenceChanged(SharedPreferences sharedpreferences, String s)
    {
        if (!s.equals("postal_code"))
        {
            return;
        } else
        {
            FeaturedFragment.e(a).scrollTo(0, 0);
            a.getLoaderManager().restartLoader(0, null, a);
            return;
        }
    }
}
