// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.ftue;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.amazon.gallery.framework.data.dao.sqlite.mediastore.MediaStoreSyncProvider;
import com.amazon.gallery.framework.kindle.ui.NoContentOverlay;

// Referenced classes of package com.amazon.gallery.framework.kindle.ftue:
//            LoadingContentViewFragment

public class FTUELoadingContentFragment extends LoadingContentViewFragment
{

    private MediaStoreSyncProvider mediaStoreSyncProvider;
    private NoContentOverlay noContentOverlay;
    private final android.content.SharedPreferences.OnSharedPreferenceChangeListener sharedPreferenceChangeListener = new android.content.SharedPreferences.OnSharedPreferenceChangeListener() {

        final FTUELoadingContentFragment this$0;

        public void onSharedPreferenceChanged(SharedPreferences sharedpreferences, String s)
        {
            if ("coldBootStatus".equals(s) && sharedpreferences.getBoolean(s, false))
            {
                refreshNoContentOverlay();
            }
        }

            
            {
                this$0 = FTUELoadingContentFragment.this;
                super();
            }
    };
    private SharedPreferences sharedPreferences;
    private final com.amazon.gallery.framework.data.dao.sqlite.mediastore.MediaStoreSyncProvider.SyncCompletedListener syncCompletedListener = new com.amazon.gallery.framework.data.dao.sqlite.mediastore.MediaStoreSyncProvider.SyncCompletedListener() {

        final FTUELoadingContentFragment this$0;

        public void onSyncCompleted()
        {
            refreshNoContentOverlay();
        }

            
            {
                this$0 = FTUELoadingContentFragment.this;
                super();
            }
    };

    public FTUELoadingContentFragment()
    {
    }

    private void attachListener()
    {
        sharedPreferences = getActivity().getSharedPreferences("galleryKindleSharedPrefs", 0);
        sharedPreferences.registerOnSharedPreferenceChangeListener(sharedPreferenceChangeListener);
        mediaStoreSyncProvider.addSyncCompletedListener(syncCompletedListener);
    }

    private void refreshNoContentOverlay()
    {
        noContentOverlay.scheduleRefresh();
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = super.onCreateView(layoutinflater, viewgroup, bundle);
        if (layoutinflater == null)
        {
            return null;
        } else
        {
            attachListener();
            return layoutinflater;
        }
    }

    public void onDestroyView()
    {
        super.onDestroyView();
        mediaStoreSyncProvider.removeSyncCompletedListener(syncCompletedListener);
        sharedPreferences.unregisterOnSharedPreferenceChangeListener(sharedPreferenceChangeListener);
    }

    public void setMediaStoreSyncProvider(MediaStoreSyncProvider mediastoresyncprovider)
    {
        mediaStoreSyncProvider = mediastoresyncprovider;
    }

    public void setNoContentOverlay(NoContentOverlay nocontentoverlay)
    {
        noContentOverlay = nocontentoverlay;
    }

}
