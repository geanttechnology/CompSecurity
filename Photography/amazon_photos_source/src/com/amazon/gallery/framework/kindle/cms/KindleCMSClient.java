// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.cms;

import android.content.Context;
import com.amazon.gallery.foundation.utils.apilevel.BuildFlavors;
import com.amazon.gallery.foundation.utils.di.BeanAwareApplication;
import com.amazon.gallery.foundation.utils.di.BeanFactory;
import com.amazon.gallery.foundation.utils.featuremanager.FeatureManager;
import com.amazon.gallery.foundation.utils.featuremanager.Features;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.data.account.AccountChangeListener;
import com.amazon.gallery.framework.data.dao.ChangeList;
import com.amazon.gallery.framework.data.dao.mediaitem.MediaItemDao;
import com.amazon.gallery.framework.data.dao.sqlite.tag.TagSqliteImpl;
import com.amazon.gallery.framework.data.dao.tag.TagDao;
import com.amazon.gallery.framework.data.dao.tag.TagTagTypeObserver;
import com.amazon.gallery.framework.data.store.DiskStore;
import com.amazon.gallery.framework.gallery.view.ViewDescriptor;
import com.amazon.gallery.framework.gallery.view.ViewStateListener;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.framework.kindle.auth.AuthenticationManager;
import com.amazon.gallery.framework.model.ObjectID;
import com.amazon.gallery.framework.model.tags.Tag;
import com.amazon.gallery.framework.model.tags.TagType;
import com.amazon.gallery.framework.network.disk.NetworkStore;
import com.amazon.gallery.framework.network.http.senna.sync.manager.SyncManager;
import com.amazon.gallery.thor.app.FreeTime;
import com.amazon.gallery.thor.di.AppKeys;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.amazon.gallery.framework.kindle.cms:
//            CMSRequestHandler, CMSDB, CMSObjectID, CMSClient, 
//            CMSContainer, MLTItemTracker, CMSImageStore, CMSAsyncTaskRunner, 
//            CMSClientWrapper

public class KindleCMSClient
    implements AccountChangeListener, TagTagTypeObserver, ViewStateListener
{

    private static final String TAG = com/amazon/gallery/framework/kindle/cms/KindleCMSClient.getName();
    protected AuthenticationManager authenticationManager;
    protected CMSClient cmsClient;
    protected CMSRequestHandler cmsConnectionCallback;
    protected CMSDB cmsDB;
    protected final Context context;
    protected FreeTime freeTime;
    protected boolean initialized;
    protected SyncManager syncManager;

    public KindleCMSClient(Context context1)
    {
        initialized = false;
        context = context1;
    }

    private Tag findMatchingTagByDBId(Tag tag, Collection collection)
    {
        tag = (TagSqliteImpl)tag;
        for (collection = collection.iterator(); collection.hasNext();)
        {
            Tag tag1 = (Tag)collection.next();
            TagSqliteImpl tagsqliteimpl = (TagSqliteImpl)tag1;
            if (tag.getId() == tagsqliteimpl.getId())
            {
                return tag1;
            }
        }

        return null;
    }

    private CMSObjectID getLatestCMSObjectID()
    {
        Map map = cmsDB.getAlbumsInRecentAlbumsTable(cmsConnectionCallback.getMaxAlbumsInCarousel());
        CMSObjectID cmsobjectid = null;
        Date date = new Date(0L);
        Iterator iterator = map.keySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            CMSObjectID cmsobjectid1 = (CMSObjectID)iterator.next();
            Date date1 = (Date)map.get(cmsobjectid1);
            if (date1.after(date))
            {
                date = date1;
                cmsobjectid = cmsobjectid1;
            }
        } while (true);
        return cmsobjectid;
    }

    private void processModifiedTag(Tag tag, Tag tag1)
    {
        boolean flag1 = false;
        boolean flag = false;
        tag = tag.getObjectId();
        ObjectID objectid = tag1.getObjectId();
        if (!tag.equals(objectid))
        {
            CMSObjectID cmsobjectid = CMSObjectID.getCMSItemID(tag);
            if (cmsConnectionCallback.isAlbumFavorite(cmsobjectid))
            {
                flag = true;
            }
            cmsClient.removeAlbums(false, new ObjectID[] {
                tag
            });
            flag1 = flag;
            if (flag)
            {
                cmsClient.addToFavourite(objectid);
                flag1 = flag;
            }
        }
        if (!flag1)
        {
            cmsClient.addAlbumsAsync(true, true, new Tag[] {
                tag1
            });
        }
        if (updateWhenTagChanges())
        {
            cmsClient.addToCarousel(objectid, true);
        }
    }

    private void refreshCMS(CMSObjectID cmsobjectid, Tag tag)
    {
        CMSContainer cmscontainer = CMSContainer.fromCMSObjectID(cmsobjectid);
        if (cmscontainer != null)
        {
            cmsClient.addContainerCallBackQueueRequest(cmscontainer);
            return;
        }
        if (tag != null)
        {
            cmsobjectid = tag.getObjectId();
        } else
        {
            cmsobjectid = ObjectID.parseString(cmsobjectid.getAlbumId());
        }
        cmsClient.addToCarousel(cmsobjectid, true);
    }

    private boolean updateWhenTagChanges()
    {
        boolean flag1 = false;
        if (!freeTime.isFreeTime()) goto _L2; else goto _L1
_L1:
        boolean flag = true;
_L4:
        return flag;
_L2:
        if (BuildFlavors.isGen5())
        {
            break; /* Loop/switch isn't completed */
        }
        flag = flag1;
        if (!BuildFlavors.isFos4()) goto _L4; else goto _L3
_L3:
        if (!authenticationManager.hasActiveAccount())
        {
            break; /* Loop/switch isn't completed */
        }
        flag = flag1;
        if (!syncManager.isColdBootCompleted()) goto _L4; else goto _L5
_L5:
        return true;
    }

    public void addToFavourite(ObjectID objectid)
    {
        init();
        cmsClient.addToFavourite(objectid);
    }

    public boolean checkIfAlbumIsFavorite(ObjectID objectid)
    {
        init();
        return cmsClient.checkIfAlbumIsFavorite(objectid);
    }

    public void init()
    {
        boolean flag1 = false;
        this;
        JVM INSTR monitorenter ;
        boolean flag = initialized;
        if (!flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        BeanFactory beanfactory;
        MediaItemDao mediaitemdao;
        MLTItemTracker mltitemtracker;
        CMSImageStore cmsimagestore;
        GLogger.i(TAG, "KindleCMSClient is initialized", new Object[0]);
        initialized = true;
        beanfactory = ((BeanAwareApplication)context).getBeanFactory();
        mediaitemdao = (MediaItemDao)beanfactory.getBean(Keys.MEDIA_ITEM_DAO);
        authenticationManager = (AuthenticationManager)beanfactory.getBean(Keys.AUTHENTICATING_MANAGER);
        syncManager = (SyncManager)beanfactory.getBean(Keys.SYNC_MANAGER);
        freeTime = (FreeTime)beanfactory.getBean(AppKeys.THOR_FREE_TIME);
        initCMSClient(authenticationManager);
        cmsDB = new CMSDB();
        cmsDB.initWithContextAndUser(context, authenticationManager.getAccountId());
        mltitemtracker = new MLTItemTracker();
        cmsClient.initWithContextAndCMSDB(context, cmsDB);
        cmsimagestore = new CMSImageStore();
        cmsimagestore.initWithContext(context);
        if (BuildFlavors.isFireOS4OrOlder())
        {
            break MISSING_BLOCK_LABEL_204;
        }
        flag = flag1;
        if (freeTime.isFreeTime())
        {
            break MISSING_BLOCK_LABEL_217;
        }
        flag = flag1;
        if (!BuildFlavors.isDuke())
        {
            flag = true;
        }
        CMSAsyncTaskRunner cmsasynctaskrunner = new CMSAsyncTaskRunner(flag);
        cmsasynctaskrunner.initWithContext(context);
        TagDao tagdao = (TagDao)beanfactory.getBean(Keys.TAG_DAO);
        cmsimagestore.setAsyncTaskRunner(cmsasynctaskrunner);
        cmsClient.setCMSImageStore(cmsimagestore);
        cmsClient.setMLTItemTracker(mltitemtracker);
        cmsClient.setCMSConnectionCallBack(cmsConnectionCallback);
        cmsClient.setTagDao(tagdao);
        cmsClient.setMediaItemDao(mediaitemdao);
        mltitemtracker.setCMSDB(cmsDB);
        mltitemtracker.setCMSClient(cmsClient);
        mltitemtracker.setCMSImageStore(cmsimagestore);
        mltitemtracker.setTagDao(tagdao);
        cmsasynctaskrunner.setMediaItemDao((MediaItemDao)beanfactory.getBean(Keys.MEDIA_ITEM_DAO));
        cmsasynctaskrunner.setDiskStore((DiskStore)beanfactory.getBean(Keys.DISK_STORE));
        cmsasynctaskrunner.setNetworkStore((NetworkStore)beanfactory.getBean(Keys.NETWORK_STORE));
        cmsasynctaskrunner.setAuthenticationManager((AuthenticationManager)beanfactory.getBean(Keys.AUTHENTICATING_MANAGER));
        if (true) goto _L1; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    protected void initCMSClient(AuthenticationManager authenticationmanager)
    {
        cmsClient = new CMSClientWrapper(authenticationmanager);
    }

    public void onAccountDeregistered()
    {
        init();
        cmsClient.onAccountDeregistered();
    }

    public void onAccountRegistered()
    {
        init();
        cmsClient.onAccountRegistered();
    }

    public void onEnterFullScreen()
    {
    }

    public void onExitFullScreen()
    {
    }

    public void onFocusedGained(ViewDescriptor viewdescriptor)
    {
    }

    public void onRotation()
    {
    }

    public void onTagsChanged(TagType tagtype, ChangeList changelist)
    {
        if (FeatureManager.isFeatureEnabled(Features.CMS)) goto _L2; else goto _L1
_L1:
        return;
_L2:
        CMSObjectID cmsobjectid;
        ArrayList arraylist;
        init();
        cmsobjectid = getLatestCMSObjectID();
        tagtype = null;
        arraylist = new ArrayList(changelist.getChangeListForType(com.amazon.gallery.framework.data.dao.ChangeList.ChangeType.ADDED));
        Iterator iterator = changelist.getChangeListForType(com.amazon.gallery.framework.data.dao.ChangeList.ChangeType.REMOVED).iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Tag tag3 = (Tag)iterator.next();
            Tag tag = findMatchingTagByDBId(tag3, arraylist);
            if (tag != null)
            {
                processModifiedTag(tag3, tag);
                arraylist.remove(tag);
                if (cmsobjectid != null && cmsobjectid.getAlbumId().equals(tag3.getObjectId().toString()))
                {
                    tagtype = tag;
                }
            } else
            {
                cmsClient.removeAlbums(true, new ObjectID[] {
                    tag3.getObjectId()
                });
            }
        } while (true);
        Tag tag1;
        for (changelist = changelist.getChangeListForType(com.amazon.gallery.framework.data.dao.ChangeList.ChangeType.MODIFIED).iterator(); changelist.hasNext(); processModifiedTag(tag1, tag1))
        {
            tag1 = (Tag)changelist.next();
        }

        if (!updateWhenTagChanges())
        {
            break; /* Loop/switch isn't completed */
        }
        tagtype = arraylist.iterator();
        while (tagtype.hasNext()) 
        {
            changelist = (Tag)tagtype.next();
            cmsClient.addToCarousel(changelist.getObjectId(), false);
        }
        if (true) goto _L1; else goto _L3
_L3:
        Tag tag2;
        for (changelist = arraylist.iterator(); changelist.hasNext(); cmsClient.addAlbumsAsync(true, false, new Tag[] {
    tag2
}))
        {
            tag2 = (Tag)changelist.next();
        }

        if (cmsobjectid != null)
        {
            refreshCMS(cmsobjectid, tagtype);
            return;
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    public void onViewStateChange(ViewDescriptor viewdescriptor, boolean flag)
    {
        static class _cls1
        {

            static final int $SwitchMap$com$amazon$gallery$framework$gallery$view$ViewDescriptor$CollectionType[];

            static 
            {
                $SwitchMap$com$amazon$gallery$framework$gallery$view$ViewDescriptor$CollectionType = new int[com.amazon.gallery.framework.gallery.view.ViewDescriptor.CollectionType.values().length];
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$gallery$view$ViewDescriptor$CollectionType[com.amazon.gallery.framework.gallery.view.ViewDescriptor.CollectionType.EVERYTHING.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$gallery$view$ViewDescriptor$CollectionType[com.amazon.gallery.framework.gallery.view.ViewDescriptor.CollectionType.MEDIA_PROPERTY.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$gallery$view$ViewDescriptor$CollectionType[com.amazon.gallery.framework.gallery.view.ViewDescriptor.CollectionType.MEDIA_TYPE.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$gallery$view$ViewDescriptor$CollectionType[com.amazon.gallery.framework.gallery.view.ViewDescriptor.CollectionType.DYNAMIC_ALBUM.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$gallery$view$ViewDescriptor$CollectionType[com.amazon.gallery.framework.gallery.view.ViewDescriptor.CollectionType.TAG.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.com.amazon.gallery.framework.gallery.view.ViewDescriptor.CollectionType[viewdescriptor.getCollectionType().ordinal()])
        {
        default:
            GLogger.i(TAG, "Not updating CMS. Unknown CollectionType: %s", new Object[] {
                viewdescriptor.getCollectionType().toString()
            });
            return;

        case 1: // '\001'
        case 2: // '\002'
        case 3: // '\003'
            init();
            viewdescriptor = CMSContainer.fromTypeAndProperty(viewdescriptor.getMediaType(), viewdescriptor.getMediaProperty());
            if (viewdescriptor != null)
            {
                cmsClient.addContainerCallBackQueueRequest(viewdescriptor);
                return;
            } else
            {
                GLogger.i(TAG, "Not updating CMS. Unknown MediaType and MediaProperty", new Object[0]);
                return;
            }

        case 4: // '\004'
        case 5: // '\005'
            init();
            cmsClient.addToCarousel(viewdescriptor.getTag().getObjectId(), false);
            return;
        }
    }

    public void registerCallbacks(CMSRequestHandler.RequestHandlerFactory requesthandlerfactory)
    {
        this;
        JVM INSTR monitorenter ;
        if (requesthandlerfactory != null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (cmsConnectionCallback == null)
        {
            GLogger.v(TAG, "Using default declaration of cms connection callback", new Object[0]);
            if (freeTime == null)
            {
                freeTime = (FreeTime)((BeanAwareApplication)context).getBeanFactory().getBean(AppKeys.THOR_FREE_TIME);
            }
            cmsConnectionCallback = requesthandlerfactory.newInstance(freeTime.isFreeTime());
        }
        cmsConnectionCallback.initWithContext(context);
        if (true) goto _L1; else goto _L3
_L3:
        requesthandlerfactory;
        throw requesthandlerfactory;
    }

}
