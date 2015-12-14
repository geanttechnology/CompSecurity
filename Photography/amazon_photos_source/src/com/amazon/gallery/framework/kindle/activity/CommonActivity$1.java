// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.activity;

import android.os.AsyncTask;
import com.amazon.gallery.framework.data.dao.sqlite.mediastore.MediaStoreSyncProvider;
import com.amazon.gallery.framework.kindle.Keys;

// Referenced classes of package com.amazon.gallery.framework.kindle.activity:
//            CommonActivity

class this._cls0 extends AsyncTask
{

    final CommonActivity this$0;

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient Void doInBackground(Void avoid[])
    {
        ((MediaStoreSyncProvider)getApplicationBean(Keys.MEDIA_STORE_SYNC_PROVIDER)).syncMediaStoreAsync();
        return null;
    }

    toreSyncProvider()
    {
        this$0 = CommonActivity.this;
        super();
    }
}
