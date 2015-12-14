// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app.service;

import android.os.AsyncTask;
import com.amazon.gallery.framework.data.dao.ChangeList;
import com.amazon.gallery.framework.data.dao.mediaitem.MediaTagPropertyObserver;
import com.amazon.gallery.framework.model.media.MediaItem;
import com.amazon.gallery.framework.model.media.SyncState;
import com.amazon.gallery.framework.model.tags.TagProperty;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.amazon.gallery.thor.app.service:
//            WhisperUploadManager

private class <init>
    implements MediaTagPropertyObserver
{

    final WhisperUploadManager this$0;

    public void onMediaItemCollectionChanged(final TagProperty property, final ChangeList changeList)
    {
        if (property == TagProperty.AUTO_SAVE || property == TagProperty.CLOUD || property == TagProperty.LOCAL)
        {
            (new AsyncTask() {

                final WhisperUploadManager.MediaTagPropertyObserverImpl this$1;
                final ChangeList val$changeList;
                final TagProperty val$property;

                protected volatile Object doInBackground(Object aobj[])
                {
                    return doInBackground((Void[])aobj);
                }

                protected transient Void doInBackground(Void avoid[])
                {
                    if (property == TagProperty.AUTO_SAVE || property == TagProperty.CLOUD)
                    {
                        avoid = changeList.getChangeListForType(com.amazon.gallery.framework.data.dao.ChangeList.ChangeType.ADDED);
                    } else
                    {
                        avoid = changeList.getChangeListForType(com.amazon.gallery.framework.data.dao.ChangeList.ChangeType.MODIFIED);
                    }
                    if (property == TagProperty.AUTO_SAVE)
                    {
                        if (avoid.size() > 0)
                        {
                            WhisperUploadManager.access$100(this$0);
                        }
                    } else
                    {
                        avoid = avoid.iterator();
                        while (avoid.hasNext()) 
                        {
                            if (((MediaItem)avoid.next()).getSyncState() == SyncState.PENDING_EDITED)
                            {
                                WhisperUploadManager.access$100(this$0);
                                return null;
                            }
                        }
                    }
                    return null;
                }

            
            {
                this$1 = WhisperUploadManager.MediaTagPropertyObserverImpl.this;
                property = tagproperty;
                changeList = changelist;
                super();
            }
            }).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
    }

    private _cls1.val.changeList()
    {
        this$0 = WhisperUploadManager.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
