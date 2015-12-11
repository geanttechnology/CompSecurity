// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.app;

import android.app.Activity;
import android.app.LoaderManager;
import android.content.SharedPreferences;
import com.wishabi.flipp.widget.CollectionView;

// Referenced classes of package com.wishabi.flipp.app:
//            FavoritesFragment

final class ah
    implements android.content.SharedPreferences.OnSharedPreferenceChangeListener
{

    final Activity a;
    final FavoritesFragment b;

    ah(FavoritesFragment favoritesfragment, Activity activity)
    {
        b = favoritesfragment;
        a = activity;
        super();
    }

    public final void onSharedPreferenceChanged(SharedPreferences sharedpreferences, String s)
    {
        if (s.equals("postal_code"))
        {
            FavoritesFragment.a(b).scrollTo(0, 0);
            if (a.getLoaderManager() != null)
            {
                a.getLoaderManager().restartLoader(0, null, b);
                return;
            }
        }
    }
}
