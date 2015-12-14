// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app.service;

import android.os.AsyncTask;
import com.amazon.gallery.framework.data.dao.ChangeList;
import com.amazon.gallery.framework.model.media.MediaItem;
import com.amazon.gallery.framework.model.media.SyncState;
import com.amazon.gallery.framework.model.tags.TagProperty;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.amazon.gallery.thor.app.service:
//            WhisperUploadManager

class val.changeList extends AsyncTask
{

    final is._cls0 this$1;
    final ChangeList val$changeList;
    final TagProperty val$property;

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient Void doInBackground(Void avoid[])
    {
        if (val$property == TagProperty.AUTO_SAVE || val$property == TagProperty.CLOUD)
        {
            avoid = val$changeList.getChangeListForType(com.amazon.gallery.framework.data.dao.l.changeList);
        } else
        {
            avoid = val$changeList.getChangeListForType(com.amazon.gallery.framework.data.dao.l.changeList);
        }
        if (val$property == TagProperty.AUTO_SAVE)
        {
            if (avoid.size() > 0)
            {
                WhisperUploadManager.access$100(_fld0);
            }
        } else
        {
            avoid = avoid.iterator();
            while (avoid.hasNext()) 
            {
                if (((MediaItem)avoid.next()).getSyncState() == SyncState.PENDING_EDITED)
                {
                    WhisperUploadManager.access$100(_fld0);
                    return null;
                }
            }
        }
        return null;
    }

    ()
    {
        this$1 = final_;
        val$property = tagproperty;
        val$changeList = ChangeList.this;
        super();
    }
}
