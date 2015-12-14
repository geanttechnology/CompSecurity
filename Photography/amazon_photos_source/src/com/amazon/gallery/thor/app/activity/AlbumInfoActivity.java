// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app.activity;

import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.SystemClock;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.amazon.clouddrive.model.ListChildrenRequest;
import com.amazon.clouddrive.model.ListChildrenResponse;
import com.amazon.gallery.foundation.metrics.ComponentProfiler;
import com.amazon.gallery.foundation.metrics.Profiler;
import com.amazon.gallery.foundation.utils.IdUtils;
import com.amazon.gallery.foundation.utils.di.BeanAwareActivity;
import com.amazon.gallery.foundation.utils.di.BeanFactory;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.data.dao.tag.TagDao;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.framework.kindle.auth.AuthenticationManager;
import com.amazon.gallery.framework.model.ObjectID;
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
//            AndroidSimpleToolbar, GallerySimpleToolbar, GalleryNavigationSetting

public class AlbumInfoActivity extends BeanAwareActivity
{
    private class AlbumInfoTask extends AsyncTask
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
            future = cloudDriveServiceClientManager.getForegroundCdsClient().listChildrenAsync(avoid, null);
            arraylist = new ArrayList();
            folderNames.clear();
            avoid = ((AuthenticationManager)ThorGalleryApplication.getBean(Keys.AUTHENTICATING_MANAGER)).getAccountId();
            uri = com.amazon.mixtape.provider.CloudNodesContract.NodeQueryInclude.getContentUri(getResources().getString(0x7f0e02fb), avoid);
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
            static class _cls3
            {

                static final int $SwitchMap$com$amazon$gallery$framework$model$collectionfilter$CollectionFilterType[];

                static 
                {
                    $SwitchMap$com$amazon$gallery$framework$model$collectionfilter$CollectionFilterType = new int[CollectionFilterType.values().length];
                    try
                    {
                        $SwitchMap$com$amazon$gallery$framework$model$collectionfilter$CollectionFilterType[CollectionFilterType.FOLDER.ordinal()] = 1;
                    }
                    catch (NoSuchFieldError nosuchfielderror1) { }
                    try
                    {
                        $SwitchMap$com$amazon$gallery$framework$model$collectionfilter$CollectionFilterType[CollectionFilterType.UNKNOWN.ordinal()] = 2;
                    }
                    catch (NoSuchFieldError nosuchfielderror)
                    {
                        return;
                    }
                }
            }

            _cls3..SwitchMap.com.amazon.gallery.framework.model.collectionfilter.CollectionFilterType[CollectionFilterType.getTypeFromId(cursor2.getString(i)).ordinal()];
            JVM INSTR tableswitch 1 1: default 521
        //                       1 276;
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
            obj2 = tagDao.getTagById(((ObjectID) (obj2)));
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
            folderNames.add(obj2);
            avoid = ((Void []) (obj1));
            cursor = cursor2;
            obj = obj1;
            cursor1 = cursor2;
            arraylist.add(createFolderRow(((String) (obj2))));
              goto _L4
            obj1;
            obj = avoid;
            cursor1 = cursor;
            GLogger.ex(AlbumInfoActivity.TAG, "Error while querying Mixtape content provider client for collection filters", ((Throwable) (obj1)));
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
            GLogger.ex(AlbumInfoActivity.TAG, "Error occurred performing listChildren operation to get album information", avoid);
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
            progress.setVisibility(8);
            content.setVisibility(0);
            albumName.setText(tag.getLabel());
            albumSize.setText(String.valueOf(count));
            Object obj = DateFormat.getDateInstance(1, Locale.getDefault());
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(tag.getDateCreatedMs());
            obj = ((DateFormat) (obj)).format(calendar.getTime());
            albumDateCreated.setText(((CharSequence) (obj)));
            if (!list.isEmpty())
            {
                propertiesContainer.setVisibility(0);
                View view;
                for (list = list.iterator(); list.hasNext(); propertiesTable.addView(view))
                {
                    view = (View)list.next();
                }

            }
            long l = SystemClock.uptimeMillis();
            long l1 = startDurationMs;
            profiler.trackTimer(com.amazon.gallery.thor.albums.AlbumsMetricsHelper.MetricsEvent.ViewAlbumInfoTime, l - l1);
        }

        protected void onPreExecute()
        {
            progress.setVisibility(0);
            content.setVisibility(8);
        }

        public AlbumInfoTask(Tag tag1, String s)
        {
            this$0 = AlbumInfoActivity.this;
            super();
            nodeId = s;
            tag = tag1;
        }
    }


    private static final String TAG = com/amazon/gallery/thor/app/activity/AlbumInfoActivity.getName();
    private TextView albumDateCreated;
    private TextView albumName;
    private TextView albumSize;
    private CloudDriveServiceClientManager cloudDriveServiceClientManager;
    private View content;
    private ArrayList folderNames;
    private ComponentProfiler profiler;
    private View progress;
    private View propertiesContainer;
    private LinearLayout propertiesTable;
    private long startDurationMs;
    private TagDao tagDao;

    public AlbumInfoActivity()
    {
        super(new BeanFactory() {

        });
    }

    public AlbumInfoActivity(BeanFactory beanfactory)
    {
        super(beanfactory);
    }

    private View createFolderRow(String s)
    {
        View view = LayoutInflater.from(this).inflate(0x7f03001c, null);
        ((TextView)view.findViewById(0x7f0c0091)).setText(getString(0x7f0e0029, new Object[] {
            s
        }));
        return view;
    }

    private void initHeaderBar()
    {
        AndroidSimpleToolbar androidsimpletoolbar = new AndroidSimpleToolbar((Toolbar)findViewById(0x7f0c0085).findViewById(0x7f0c0086));
        androidsimpletoolbar.setTitle(getResources().getString(0x7f0e0026));
        androidsimpletoolbar.setNavigationSetting(GalleryNavigationSetting.BACK);
        androidsimpletoolbar.setNavigationOnClickListener(new android.view.View.OnClickListener() {

            final AlbumInfoActivity this$0;

            public void onClick(View view)
            {
                finish();
            }

            
            {
                this$0 = AlbumInfoActivity.this;
                super();
            }
        });
    }

    private void setupViews()
    {
        progress = findViewById(0x7f0c008f);
        content = findViewById(0x7f0c0087);
        albumName = (TextView)findViewById(0x7f0c0084);
        albumSize = (TextView)findViewById(0x7f0c008c);
        albumDateCreated = (TextView)findViewById(0x7f0c008a);
        propertiesTable = (LinearLayout)findViewById(0x7f0c008e);
        propertiesContainer = findViewById(0x7f0c008d);
    }

    public void onCreate(Bundle bundle)
    {
label0:
        {
            super.onCreate(bundle);
            startDurationMs = SystemClock.uptimeMillis();
            setContentView(0x7f03001b);
            setupViews();
            initHeaderBar();
            profiler = new ComponentProfiler((Profiler)getApplicationBean(Keys.PROFILER), "AlbumsMetrics");
            folderNames = new ArrayList();
            tagDao = (TagDao)ThorGalleryApplication.getBean(Keys.TAG_DAO);
            cloudDriveServiceClientManager = (CloudDriveServiceClientManager)ThorGalleryApplication.getBean(Keys.CLOUD_DRIVE_SERVICE_CLIENT_MANAGER);
            if (bundle == null)
            {
                bundle = getIntent().getStringExtra("mediaTagId");
                bundle = tagDao.getTagById(ObjectID.parseString(bundle));
                if (bundle != null)
                {
                    break label0;
                }
                GLogger.i(TAG, "Tag was null, cannot show album info", new Object[0]);
            }
            return;
        }
        ObjectID objectid = bundle.getObjectId();
        (new AlbumInfoTask(bundle, IdUtils.objectIdToNodeId(objectid.getMostSignificantBits(), objectid.getLeastSignificantBits()))).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    public void onRestoreInstanceState(Bundle bundle)
    {
        super.onRestoreInstanceState(bundle);
        albumName.setText(bundle.getString("album_name"));
        albumDateCreated.setText(bundle.getString("album_date"));
        albumSize.setText(bundle.getString("album_size"));
        folderNames = bundle.getStringArrayList("folders");
        if (folderNames != null && !folderNames.isEmpty())
        {
            propertiesContainer.setVisibility(0);
            String s;
            for (bundle = folderNames.iterator(); bundle.hasNext(); propertiesTable.addView(createFolderRow(s)))
            {
                s = (String)bundle.next();
            }

        }
        progress.setVisibility(8);
        content.setVisibility(0);
    }

    public void onResume()
    {
        super.onResume();
        profiler.trackEvent(com.amazon.gallery.thor.albums.AlbumsMetricsHelper.MetricsEvent.ViewAlbumInfo);
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        bundle.putString("album_name", albumName.getText().toString());
        bundle.putString("album_date", albumDateCreated.getText().toString());
        bundle.putString("album_size", albumSize.getText().toString());
        bundle.putStringArrayList("folders", folderNames);
        super.onSaveInstanceState(bundle);
    }















}
