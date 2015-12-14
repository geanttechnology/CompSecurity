// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.folders;

import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.framework.kindle.auth.AuthenticationManager;
import com.amazon.gallery.framework.model.ObjectID;
import com.amazon.gallery.framework.model.collectionfilter.CollectionFilterType;
import com.amazon.gallery.thor.app.ThorGalleryApplication;
import com.amazon.mixtape.utils.IdUtils;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

// Referenced classes of package com.amazon.gallery.thor.folders:
//            FoldersAdapter

public class FolderToAlbumMapper
    implements android.support.v4.app.LoaderManager.LoaderCallbacks
{

    private static final String QUERY_INCLUDE_PROJECTION[] = {
        "node_id", "value", "event_id"
    };
    private static final String QUERY_INCLUDE_SELECTION;
    private static final String TAG = com/amazon/gallery/thor/folders/FolderToAlbumMapper.getSimpleName();
    private final int LOADER_ID = hashCode();
    private final FragmentActivity activity;
    private FoldersAdapter foldersAdapter;
    private Multimap mapping;
    private final Uri queryIncludeUri;

    public FolderToAlbumMapper(FragmentActivity fragmentactivity)
    {
        mapping = HashMultimap.create();
        activity = fragmentactivity;
        fragmentactivity = ((AuthenticationManager)ThorGalleryApplication.getBean(Keys.AUTHENTICATING_MANAGER)).getAccountId();
        queryIncludeUri = com.amazon.mixtape.provider.CloudNodesContract.NodeQueryInclude.getContentUri(activity.getResources().getString(0x7f0e02fb), fragmentactivity);
    }

    private void buildMapping(Cursor cursor)
    {
        HashMultimap hashmultimap = HashMultimap.create();
        if (cursor != null)
        {
            int i = cursor.getColumnIndex("node_id");
            int j = cursor.getColumnIndex("value");
            for (; cursor.moveToNext(); hashmultimap.put(cursor.getString(j), cursor.getString(i))) { }
        }
        mapping = hashmultimap;
    }

    public boolean contains(ObjectID objectid)
    {
        if (mapping == null)
        {
            return true;
        } else
        {
            return mapping.containsKey(IdUtils.objectIdToNodeId(objectid.getMostSignificantBits(), objectid.getLeastSignificantBits()));
        }
    }

    public void init(FoldersAdapter foldersadapter)
    {
        foldersAdapter = foldersadapter;
        activity.getSupportLoaderManager().initLoader(LOADER_ID, null, this);
    }

    public Loader onCreateLoader(int i, Bundle bundle)
    {
        return new CursorLoader(activity, queryIncludeUri, QUERY_INCLUDE_PROJECTION, QUERY_INCLUDE_SELECTION, null, null);
    }

    public void onLoadFinished(Loader loader, Cursor cursor)
    {
        buildMapping(cursor);
        foldersAdapter.notifyDataSetChanged();
    }

    public volatile void onLoadFinished(Loader loader, Object obj)
    {
        onLoadFinished(loader, (Cursor)obj);
    }

    public void onLoaderReset(Loader loader)
    {
    }

    static 
    {
        QUERY_INCLUDE_SELECTION = (new StringBuilder()).append("filter_type = \"").append(CollectionFilterType.FOLDER.getTypeId()).append("\" ").append("AND ").append("node_id").append(" IN (").append("SELECT ").append("node_id").append(" FROM ").append("cloud_nodes").append(" WHERE ").append("status").append(" = \"").append("AVAILABLE").append("\" ").append("OR ").append("status").append(" = \"").append("PENDING").append("\" )").toString();
    }
}
