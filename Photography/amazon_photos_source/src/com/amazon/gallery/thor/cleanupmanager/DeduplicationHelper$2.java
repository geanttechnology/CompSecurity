// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.cleanupmanager;

import android.os.AsyncTask;
import com.amazon.gallery.framework.data.dao.Md5Deduplicater;

// Referenced classes of package com.amazon.gallery.thor.cleanupmanager:
//            DeduplicationHelper

class cationObserver extends AsyncTask
{

    final DeduplicationHelper this$0;
    final com.amazon.gallery.framework.data.dao.icationObserver val$deduplicationObserver;

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient Void doInBackground(Void avoid[])
    {
        DeduplicationHelper.access$600(DeduplicationHelper.this).getAllMd5Duplicates(val$deduplicationObserver);
        return null;
    }

    cationObserver()
    {
        this$0 = final_deduplicationhelper;
        val$deduplicationObserver = com.amazon.gallery.framework.data.dao.icationObserver.this;
        super();
    }
}
