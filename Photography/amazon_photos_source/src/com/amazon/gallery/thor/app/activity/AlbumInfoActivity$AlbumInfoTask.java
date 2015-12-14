// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app.activity;

import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.res.Resources;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.RemoteException;
import android.os.SystemClock;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.amazon.clouddrive.model.ListChildrenRequest;
import com.amazon.clouddrive.model.ListChildrenResponse;
import com.amazon.gallery.foundation.metrics.ComponentProfiler;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.data.dao.tag.TagDao;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.framework.kindle.auth.AuthenticationManager;
import com.amazon.gallery.framework.model.collectionfilter.CollectionFilterType;
import com.amazon.gallery.framework.model.tags.Tag;
import com.amazon.gallery.thor.app.ThorGalleryApplication;
import com.amazon.gallery.thor.cds.CDSUtil;
import com.amazon.gallery.thor.cds.CloudDriveServiceClientManager;
import com.amazon.mixtape.service.MixtapeCloudDriveServiceClient;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

// Referenced classes of package com.amazon.gallery.thor.app.activity:
//            AlbumInfoActivity

private class tag extends AsyncTask
{

    private long count;
    private final String nodeId;
    private final Tag tag;
    final AlbumInfoActivity this$0;

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient List doInBackground(Void avoid[])
    {
        Cursor cursor;
        Object obj;
        Cursor cursor1;
        Cursor cursor2;
        Object obj2;
        ArrayList arraylist;
        Future future;
        android.net.Uri uri;
        avoid = new ListChildrenRequest(nodeId);
        future = AlbumInfoActivity.access$200(AlbumInfoActivity.this).getForegroundCdsClient().listChildrenAsync(avoid, null);
        arraylist = new ArrayList();
        AlbumInfoActivity.access$300(AlbumInfoActivity.this).clear();
        avoid = ((AuthenticationManager)ThorGalleryApplication.getBean(Keys.AUTHENTICATING_MANAGER)).getAccountId();
        uri = com.amazon.mixtape.provider.ude.getContentUri(getResources().getString(0x7f0e02fb), avoid);
        obj = null;
        avoid = null;
        obj2 = null;
        cursor2 = null;
        cursor = cursor2;
        cursor1 = ((Cursor) (obj2));
        Object obj1 = getContentResolver().acquireContentProviderClient(uri);
        avoid = ((Void []) (obj1));
        cursor = cursor2;
        obj = obj1;
        cursor1 = ((Cursor) (obj2));
        cursor2 = ((ContentProviderClient) (obj1)).query(uri, null, "node_id = ? AND event_id IN (SELECT event_id FROM cloud_nodes)", new String[] {
            nodeId
        }, null);
        if (cursor2 == null) goto _L2; else goto _L1
_L1:
        avoid = ((Void []) (obj1));
        cursor = cursor2;
        obj = obj1;
        cursor1 = cursor2;
        int i = cursor2.getColumnIndex("filter_type");
        avoid = ((Void []) (obj1));
        cursor = cursor2;
        obj = obj1;
        cursor1 = cursor2;
        int j = cursor2.getColumnIndex("value");
_L4:
        avoid = ((Void []) (obj1));
        cursor = cursor2;
        obj = obj1;
        cursor1 = cursor2;
        if (!cursor2.moveToNext()) goto _L2; else goto _L3
_L3:
        avoid = ((Void []) (obj1));
        cursor = cursor2;
        obj = obj1;
        cursor1 = cursor2;
        om.amazon.gallery.framework.model.collectionfilter.CollectionFilterType[CollectionFilterType.getTypeFromId(cursor2.getString(i)).ordinal()];
        JVM INSTR tableswitch 1 1: default 521
    //                   1 276;
           goto _L4 _L5
_L5:
        avoid = ((Void []) (obj1));
        cursor = cursor2;
        obj = obj1;
        cursor1 = cursor2;
        obj2 = CDSUtil.getObjectId(cursor2.getString(j));
        avoid = ((Void []) (obj1));
        cursor = cursor2;
        obj = obj1;
        cursor1 = cursor2;
        obj2 = AlbumInfoActivity.access$400(AlbumInfoActivity.this).getTagById(((com.amazon.gallery.framework.model.ObjectID) (obj2)));
        if (obj2 == null) goto _L4; else goto _L6
_L6:
        avoid = ((Void []) (obj1));
        cursor = cursor2;
        obj = obj1;
        cursor1 = cursor2;
        obj2 = ((Tag) (obj2)).getLabel();
        avoid = ((Void []) (obj1));
        cursor = cursor2;
        obj = obj1;
        cursor1 = cursor2;
        AlbumInfoActivity.access$300(AlbumInfoActivity.this).add(obj2);
        avoid = ((Void []) (obj1));
        cursor = cursor2;
        obj = obj1;
        cursor1 = cursor2;
        arraylist.add(AlbumInfoActivity.access$500(AlbumInfoActivity.this, ((String) (obj2))));
          goto _L4
        obj1;
        obj = avoid;
        cursor1 = cursor;
        GLogger.ex(AlbumInfoActivity.access$600(), "Error while querying Mixtape content provider client for collection filters", ((Throwable) (obj1)));
        CDSUtil.closeCursorQuietly(cursor);
        if (avoid != null)
        {
            avoid.release();
        }
_L8:
        count = ((ListChildrenResponse)future.get()).getCount();
        return arraylist;
_L2:
        CDSUtil.closeCursorQuietly(cursor2);
        if (obj1 != null)
        {
            ((ContentProviderClient) (obj1)).release();
        }
        if (true) goto _L8; else goto _L7
_L7:
        avoid;
        CDSUtil.closeCursorQuietly(cursor1);
        if (obj != null)
        {
            ((ContentProviderClient) (obj)).release();
        }
        throw avoid;
        avoid;
_L10:
        GLogger.ex(AlbumInfoActivity.access$600(), "Error occurred performing listChildren operation to get album information", avoid);
        return arraylist;
        avoid;
        if (true) goto _L10; else goto _L9
_L9:
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((List)obj);
    }

    protected void onPostExecute(List list)
    {
        AlbumInfoActivity.access$000(AlbumInfoActivity.this).setVisibility(8);
        AlbumInfoActivity.access$100(AlbumInfoActivity.this).setVisibility(0);
        AlbumInfoActivity.access$700(AlbumInfoActivity.this).setText(tag.getLabel());
        AlbumInfoActivity.access$800(AlbumInfoActivity.this).setText(String.valueOf(count));
        Object obj = DateFormat.getDateInstance(1, Locale.getDefault());
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(tag.getDateCreatedMs());
        obj = ((DateFormat) (obj)).format(calendar.getTime());
        AlbumInfoActivity.access$900(AlbumInfoActivity.this).setText(((CharSequence) (obj)));
        if (!list.isEmpty())
        {
            AlbumInfoActivity.access$1000(AlbumInfoActivity.this).setVisibility(0);
            View view;
            for (list = list.iterator(); list.hasNext(); AlbumInfoActivity.access$1100(AlbumInfoActivity.this).addView(view))
            {
                view = (View)list.next();
            }

        }
        long l = SystemClock.uptimeMillis();
        long l1 = AlbumInfoActivity.access$1200(AlbumInfoActivity.this);
        AlbumInfoActivity.access$1300(AlbumInfoActivity.this).trackTimer(com.amazon.gallery.thor.albums..ViewAlbumInfoTime, l - l1);
    }

    protected void onPreExecute()
    {
        AlbumInfoActivity.access$000(AlbumInfoActivity.this).setVisibility(0);
        AlbumInfoActivity.access$100(AlbumInfoActivity.this).setVisibility(8);
    }

    public ype(Tag tag1, String s)
    {
        this$0 = AlbumInfoActivity.this;
        super();
        nodeId = s;
        tag = tag1;
    }
}
