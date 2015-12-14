// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.fragment;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.widget.ListAdapter;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.foundation.utils.messaging.GlobalMessagingBus;
import com.amazon.gallery.foundation.utils.messaging.InvalidateDataEvent;
import com.amazon.gallery.framework.data.dao.MediaItemSortType;
import com.amazon.gallery.framework.data.dao.SortOrder;
import com.amazon.gallery.framework.data.dao.mediaitem.MediaItemDao;
import com.amazon.gallery.framework.gallery.view.ViewDescriptor;
import com.amazon.gallery.framework.gallery.widget.MediaItemCursorAdapter;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.framework.kindle.provider.MediaContentConfiguration;
import com.amazon.gallery.thor.app.ThorGalleryApplication;
import com.amazon.gallery.thor.app.activity.MediaContentConfigurationHolder;
import com.amazon.gallery.thor.app.ui.UiReadyExecutor;

// Referenced classes of package com.amazon.gallery.framework.kindle.fragment:
//            BaseFragment, StateFragment

public abstract class AdapterFragment extends BaseFragment
    implements android.support.v4.app.LoaderManager.LoaderCallbacks
{

    private static final String TAG = com/amazon/gallery/framework/kindle/fragment/AdapterFragment.getName();
    protected MediaContentConfiguration contentConfiguration;
    protected UiReadyExecutor executor;
    protected MediaItemCursorAdapter mMediaItemCursorAdapter;

    public AdapterFragment()
    {
    }

    protected void createMediaItemCursorAdapter()
    {
        mMediaItemCursorAdapter = new MediaItemCursorAdapter(getActivity(), null);
        mMediaItemCursorAdapter.setMediaItemDao((MediaItemDao)getApplicationBean(Keys.MEDIA_ITEM_DAO));
    }

    public ListAdapter getAdapter()
    {
        return mMediaItemCursorAdapter;
    }

    public abstract int getFirstVisiblePosition();

    public int getMediaItemIndex(int i)
    {
        return i;
    }

    protected Bundle getPreloadArgs()
    {
        Bundle bundle = new Bundle();
        bundle.putBoolean("preload", true);
        bundle.putInt("preload_limit", 50);
        return bundle;
    }

    protected boolean isPreload(Loader loader)
    {
        return ((CursorLoader)loader).getUri().getQueryParameter("limit") != null;
    }

    protected abstract boolean isValidFragment();

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        executor = (UiReadyExecutor)ThorGalleryApplication.getBean(Keys.UI_READY_EXECUTOR);
        executor.onLoaderInitialized();
        getLoaderManager().initLoader(0x7f0c0007, getPreloadArgs(), this);
    }

    public Loader onCreateLoader(int i, Bundle bundle)
    {
        Object obj1 = null;
        if (contentConfiguration == null)
        {
            GLogger.e(TAG, "error, no content configuration set for fragment!", new Object[0]);
            return null;
        }
        Uri uri = contentConfiguration.getContentUri();
        Object obj = uri;
        if (bundle != null)
        {
            obj = uri;
            if (bundle.getBoolean("preload"))
            {
                if (mMediaItemCursorAdapter != null)
                {
                    mMediaItemCursorAdapter.changeCursor(null);
                }
                obj = uri.buildUpon();
                ((android.net.Uri.Builder) (obj)).appendQueryParameter("limit", String.valueOf(bundle.getInt("preload_limit")));
                i = bundle.getInt("preload_offset", -1);
                if (i != -1)
                {
                    ((android.net.Uri.Builder) (obj)).appendQueryParameter("offset", String.valueOf(i));
                }
                obj = ((android.net.Uri.Builder) (obj)).build();
                contentConfiguration.toViewDescriptor().setPreload(true);
            }
        }
        bundle = obj1;
        if (contentConfiguration.getSortType() != null)
        {
            bundle = contentConfiguration.getSortType().getSortOrder().getOrderByString();
        }
        return new CursorLoader(getActivity(), ((Uri) (obj)), contentConfiguration.getProjection(), contentConfiguration.getSelection(), contentConfiguration.getSelectionArgs(), bundle);
    }

    protected void onDataInvalidated(boolean flag)
    {
        if (flag && getActivity() != null && isAdded())
        {
            getActivity().runOnUiThread(new Runnable() {

                final AdapterFragment this$0;

                public void run()
                {
                    Bundle bundle = null;
                    if (contentConfiguration.toViewDescriptor().hasCollectionTypeChanged())
                    {
                        bundle = getPreloadArgs();
                    }
                    getLoaderManager().restartLoader(0x7f0c0007, bundle, AdapterFragment.this);
                }

            
            {
                this$0 = AdapterFragment.this;
                super();
            }
            });
        }
    }

    public void onLoadFinished(Loader loader, Cursor cursor)
    {
        if (mMediaItemCursorAdapter == null)
        {
            return;
        }
        if (cursor != null && getActivity().getIntent().hasExtra("com.amazon.camera.extras.URIs"))
        {
            GLogger.d(TAG, "Setting notification uri to point to mediaItems", new Object[0]);
            cursor.setNotificationUri(getActivity().getContentResolver(), com.amazon.gallery.framework.kindle.provider.GalleryInternalContentProvider.MediaItem.CONTENT_URI);
        }
        mMediaItemCursorAdapter.changeCursor(cursor);
        ViewDescriptor viewdescriptor = contentConfiguration.toViewDescriptor();
        int i;
        boolean flag;
        if (cursor == null)
        {
            i = 0;
        } else
        {
            i = cursor.getCount();
        }
        viewdescriptor.setCollectionSize(i);
        flag = isPreload(loader);
        if (cursor != null && flag)
        {
            getLoaderManager().restartLoader(0x7f0c0007, null, this);
        } else
        {
            viewdescriptor.setPreload(false);
        }
        if (isValidFragment() && !flag)
        {
            updateNavigationBar(viewdescriptor);
        }
        GlobalMessagingBus.post(new InvalidateDataEvent());
        executor.onLoadFinished();
    }

    public volatile void onLoadFinished(Loader loader, Object obj)
    {
        onLoadFinished(loader, (Cursor)obj);
    }

    public void onLoaderReset(Loader loader)
    {
    }

    protected void onRestoreState(Bundle bundle)
    {
        if (contentConfiguration == null)
        {
            MediaContentConfiguration mediacontentconfiguration1 = StateFragment.getAndRegisterInstance(getActivity()).getContentConfiguration();
            MediaContentConfiguration mediacontentconfiguration = mediacontentconfiguration1;
            if (mediacontentconfiguration1 == null)
            {
                mediacontentconfiguration = mediacontentconfiguration1;
                if (getActivity() instanceof MediaContentConfigurationHolder)
                {
                    mediacontentconfiguration = ((MediaContentConfigurationHolder)getActivity()).getMediaContentConfiguration();
                }
            }
            if (mediacontentconfiguration != null)
            {
                contentConfiguration = mediacontentconfiguration;
            }
        }
        if (bundle != null)
        {
            getArguments().putInt("START_POSITION", bundle.getInt("START_POSITION"));
        }
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        saveScrollState(bundle);
        super.onSaveInstanceState(bundle);
    }

    protected void saveScrollState(Bundle bundle)
    {
        int i = getFirstVisiblePosition();
        bundle.putInt("START_POSITION", i);
        contentConfiguration.toViewDescriptor().setFocusedIndex(i);
    }

    public void setContentConfiguration(MediaContentConfiguration mediacontentconfiguration)
    {
        contentConfiguration = mediacontentconfiguration;
    }

}
