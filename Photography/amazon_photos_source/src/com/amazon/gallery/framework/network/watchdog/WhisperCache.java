// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.watchdog;

import android.app.IntentService;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.data.dao.mediaitem.MediaItemDao;
import com.amazon.gallery.framework.data.store.DiskStore;
import com.amazon.gallery.framework.kindle.auth.AuthenticationManager;
import com.amazon.gallery.framework.model.media.GroupType;
import com.amazon.gallery.framework.model.media.MediaItemCollection;
import com.amazon.gallery.framework.network.NetworkExecutor;
import com.amazon.gallery.framework.network.connectivity.NetworkConnectivity;
import com.amazon.gallery.framework.network.disk.NetworkStore;
import com.amazon.gallery.framework.network.download.GalleryDownloadManager;
import java.util.NoSuchElementException;

public class WhisperCache extends IntentService
{

    private static final String TAG = com/amazon/gallery/framework/network/watchdog/WhisperCache.getName();
    private AuthenticationManager authenticationManager;
    protected DiskStore diskStore;
    private final int fetchFullLimit;
    private final int fetchThumbnailLimit;
    private final int fullSizeToCache;
    private GalleryDownloadManager galleryDownloadManager;
    private boolean initialized;
    protected MediaItemDao mediaItemDao;
    protected NetworkExecutor networkExecutor;
    protected NetworkConnectivity networkManager;
    protected NetworkStore networkStore;
    private final int thumbnailSizeToCache;

    public WhisperCache(int i, int j, int k, int l)
    {
        super("WhisperCache");
        initialized = false;
        thumbnailSizeToCache = i;
        fullSizeToCache = j;
        fetchThumbnailLimit = k;
        fetchFullLimit = l;
    }

    private void cachePhotos()
    {
        if (!hasAmazonAccount())
        {
            GLogger.i(TAG, "No account set up, nothing to pre-cache", new Object[0]);
            return;
        }
        if (!networkManager.isNetworkAccessAllowed(com.amazon.gallery.framework.network.connectivity.NetworkConnectivity.NetworkOperationType.PREFETCH_BACKGROUND))
        {
            GLogger.i(TAG, "Network isn't available for background pre-cache", new Object[0]);
            return;
        }
        if (galleryDownloadManager.hasIncompleteDownloads())
        {
            GLogger.i(TAG, "Download manager has incomplete downloads, won't add more in pre-cache", new Object[0]);
            return;
        }
        String s = getAmazonAccount();
        if (s != null)
        {
            GLogger.i(TAG, "WhisperCache starting", new Object[0]);
            MediaItemCollection mediaitemcollection = mediaItemDao.getAllItems();
            MediaItemCollection mediaitemcollection1 = mediaItemDao.getItemsByGroupType(GroupType.LENTICULAR);
            MediaItemCollection mediaitemcollection2 = mediaItemDao.getItemsByMimeType("image/gif");
            fetchPhotos(s, mediaitemcollection, thumbnailSizeToCache, getThumbnailLimit(), getImmediateThumbnailLimit());
            fetchPhotos(s, mediaitemcollection, fullSizeToCache, getFullSizeLimit(), getImmediateFullSizeLimit());
            fetchOriginals(s, mediaitemcollection1, getFullSizeLimit(), getLeticularFetchNowLimit());
            fetchOriginals(s, mediaitemcollection2, getFullSizeLimit(), getOriginalsFetchNowLimit());
            return;
        } else
        {
            GLogger.w(TAG, "Thought we had an account but it's null, what?", new Object[0]);
            return;
        }
    }

    void fetchOriginals(String s, MediaItemCollection mediaitemcollection, int i, int j)
    {
        if (!s.equals(getAmazonAccount()))
        {
            GLogger.i(TAG, "Active account changed; cancelling prefetch tasks", new Object[0]);
            return;
        }
        try
        {
            GLogger.i(TAG, "Request pre-fetch for originals", new Object[0]);
            galleryDownloadManager.cacheMediaItemOriginals(mediaitemcollection.getMediaItems(), diskStore, i, j);
            GLogger.i(TAG, "Request pre-fetch for originals is completed", new Object[0]);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            GLogger.ex(TAG, "NoSuchElementException while caching media items", s);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            GLogger.ex(TAG, "IndexOutOfBoundsException while caching media items", s);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            GLogger.ex(TAG, "InterruptedException while caching media items", s);
        }
        return;
    }

    void fetchPhotos(String s, MediaItemCollection mediaitemcollection, int i, int j, int k)
    {
        if (!s.equals(getAmazonAccount()))
        {
            GLogger.i(TAG, "Active account changed; cancelling prefetch tasks", new Object[0]);
            return;
        }
        try
        {
            GLogger.i(TAG, "Request pre-fetch for %d px assets", new Object[] {
                Integer.valueOf(i)
            });
            galleryDownloadManager.cacheMediaItems(mediaitemcollection.getMediaItems(), i, i, diskStore, j, k);
            GLogger.i(TAG, "Request pre-fetch for %d px assets is completed", new Object[] {
                Integer.valueOf(i)
            });
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            GLogger.ex(TAG, "NoSuchElementException while caching media items", s);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            GLogger.ex(TAG, "IndexOutOfBoundsException while caching media items", s);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            GLogger.ex(TAG, "InterruptedException while caching media items", s);
        }
        return;
    }

    String getAmazonAccount()
    {
        return authenticationManager.getAccountId();
    }

    protected int getFullSizeLimit()
    {
        return fetchFullLimit;
    }

    protected int getImmediateFullSizeLimit()
    {
        return 0;
    }

    protected int getImmediateThumbnailLimit()
    {
        return 20;
    }

    protected int getLeticularFetchNowLimit()
    {
        return 0;
    }

    protected int getOriginalsFetchNowLimit()
    {
        return 0;
    }

    protected int getThumbnailLimit()
    {
        return fetchThumbnailLimit;
    }

    boolean hasAmazonAccount()
    {
        return authenticationManager.hasActiveAccount();
    }

    public void init(NetworkExecutor networkexecutor, NetworkConnectivity networkconnectivity, DiskStore diskstore, NetworkStore networkstore, MediaItemDao mediaitemdao, AuthenticationManager authenticationmanager, GalleryDownloadManager gallerydownloadmanager)
    {
        networkExecutor = networkexecutor;
        networkManager = networkconnectivity;
        diskStore = diskstore;
        networkStore = networkstore;
        mediaItemDao = mediaitemdao;
        authenticationManager = authenticationmanager;
        galleryDownloadManager = gallerydownloadmanager;
        if (gallerydownloadmanager != null)
        {
            initialized = true;
        }
    }

    public void onDestroy()
    {
        GLogger.i(TAG, "WhisperCache service shutdown", new Object[0]);
        super.onDestroy();
    }

    protected void onHandleIntent(Intent intent)
    {
        if (!initialized)
        {
            GLogger.w(TAG, "WhisperCache not initialized but trying to start. Abandoned.", new Object[0]);
            return;
        }
        if (!whisperCacheIsOn())
        {
            GLogger.i(TAG, "WhisperCache is disabled by setting, won't run.", new Object[0]);
            return;
        } else
        {
            cachePhotos();
            return;
        }
    }

    boolean whisperCacheIsOn()
    {
        return PreferenceManager.getDefaultSharedPreferences(this).getBoolean("whispercache_settings_key", true);
    }

}
