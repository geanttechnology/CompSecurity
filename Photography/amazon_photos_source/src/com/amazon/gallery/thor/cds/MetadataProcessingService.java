// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.cds;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.data.dao.mediaitem.MediaItemDao;
import com.amazon.gallery.framework.data.dao.tag.TagDao;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.framework.kindle.auth.AuthenticationManager;
import com.amazon.gallery.thor.app.ThorGalleryApplication;
import com.amazon.mixtape.metadata.processing.AccountChangedException;
import com.amazon.mixtape.metadata.processing.MetadataProcessingException;

// Referenced classes of package com.amazon.gallery.thor.cds:
//            ThorEventIdStore, ThorNodeProcessor, MetadataProcessor

public class MetadataProcessingService extends IntentService
{

    private static final String TAG = com/amazon/gallery/thor/cds/MetadataProcessingService.getName();
    private AuthenticationManager authenticationManager;
    private ThorEventIdStore eventIdStore;
    private MediaItemDao mediaItemDao;
    private TagDao tagDao;

    public MetadataProcessingService()
    {
        super(com/amazon/gallery/thor/cds/MetadataProcessingService.getSimpleName());
    }

    public void onCreate()
    {
        super.onCreate();
        authenticationManager = (AuthenticationManager)ThorGalleryApplication.getBean(Keys.AUTHENTICATING_MANAGER);
        mediaItemDao = (MediaItemDao)ThorGalleryApplication.getBean(Keys.MEDIA_ITEM_DAO);
        tagDao = (TagDao)ThorGalleryApplication.getBean(Keys.TAG_DAO);
        eventIdStore = new ThorEventIdStore(this);
    }

    protected void onHandleIntent(Intent intent)
    {
        intent = getApplicationContext();
        ThorNodeProcessor thornodeprocessor = new ThorNodeProcessor(intent, authenticationManager, tagDao, mediaItemDao);
        intent = new MetadataProcessor(intent, intent.getResources().getString(0x7f0e02fb), authenticationManager.getAccountId(), thornodeprocessor, eventIdStore, 1200);
        try
        {
            intent.processMetadata();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Intent intent)
        {
            GLogger.i(TAG, "The account changed while processing the metadata.", new Object[0]);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Intent intent)
        {
            GLogger.ex(TAG, "Failed to migrate data.", intent);
        }
    }

}
