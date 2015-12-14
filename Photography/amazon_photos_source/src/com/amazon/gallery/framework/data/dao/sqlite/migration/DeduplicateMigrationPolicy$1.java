// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao.sqlite.migration;

import android.os.AsyncTask;

// Referenced classes of package com.amazon.gallery.framework.data.dao.sqlite.migration:
//            DeduplicateMigrationPolicy

class this._cls0 extends AsyncTask
{

    final DeduplicateMigrationPolicy this$0;

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected Void doInBackground(Void avoid[])
    {
        DeduplicateMigrationPolicy.access$000(DeduplicateMigrationPolicy.this);
        DeduplicateMigrationPolicy.access$200(DeduplicateMigrationPolicy.this, android.provider.NAL_CONTENT_URI, DeduplicateMigrationPolicy.access$100());
        DeduplicateMigrationPolicy.access$200(DeduplicateMigrationPolicy.this, android.provider.AL_CONTENT_URI, DeduplicateMigrationPolicy.access$100());
        return null;
    }

    Y()
    {
        this$0 = DeduplicateMigrationPolicy.this;
        super();
    }
}
