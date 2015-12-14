// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.activity;

import android.content.ContentResolver;
import android.database.Cursor;
import android.os.AsyncTask;
import android.widget.RelativeLayout;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.model.tags.TagType;
import com.aviary.android.feather.common.utils.IOUtils;

// Referenced classes of package com.amazon.gallery.framework.kindle.activity:
//            CollectionListActivity

private class <init> extends AsyncTask
{

    final CollectionListActivity this$0;

    protected transient Long doInBackground(Void avoid[])
    {
        Cursor cursor;
        cursor = null;
        avoid = cursor;
        ContentResolver contentresolver = getContentResolver();
        avoid = cursor;
        android.net.Uri uri = com.amazon.gallery.framework.kindle.provider.RI;
        avoid = cursor;
        String s = Integer.toString(TagType.FOLDER.ordinal());
        avoid = cursor;
        cursor = contentresolver.query(uri, new String[] {
            "COUNT(*) AS count"
        }, "type = ?", new String[] {
            s
        }, null);
        if (cursor == null)
        {
            break MISSING_BLOCK_LABEL_98;
        }
        avoid = cursor;
        if (!cursor.moveToFirst())
        {
            break MISSING_BLOCK_LABEL_98;
        }
        avoid = cursor;
        long l = cursor.getLong(0);
        IOUtils.closeSilently(cursor);
        return Long.valueOf(l);
        IOUtils.closeSilently(cursor);
        return Long.valueOf(0L);
        Exception exception;
        exception;
        IOUtils.closeSilently(avoid);
        throw exception;
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected void onPostExecute(Long long1)
    {
        if (!isCancelled() && long1.longValue() > 0L)
        {
            GLogger.v(CollectionListActivity.access$300(), "Showing folders banner", new Object[0]);
            CollectionListActivity.access$400(CollectionListActivity.this).setVisibility(0);
        } else
        {
            GLogger.v(CollectionListActivity.access$300(), "Could not find any folders or task was cancelled, hiding folders banner", new Object[0]);
            CollectionListActivity.access$400(CollectionListActivity.this).setVisibility(8);
        }
        CollectionListActivity.access$502(CollectionListActivity.this, null);
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Long)obj);
    }

    private ()
    {
        this$0 = CollectionListActivity.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
