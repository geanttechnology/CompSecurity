// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.folders;

import android.os.AsyncTask;
import android.util.Pair;
import com.amazon.gallery.framework.data.dao.mediaitem.MediaItemDao;
import com.amazon.gallery.framework.model.ObjectID;
import com.amazon.gallery.framework.model.tags.Tag;
import com.amazon.mixtape.utils.IdUtils;
import java.util.Map;

// Referenced classes of package com.amazon.gallery.thor.folders:
//            FoldersAdapter, FolderPathLoader

private class viewHolder extends AsyncTask
{

    final FoldersAdapter this$0;
    private final onPostExecute viewHolder;

    protected transient Pair doInBackground(Tag atag[])
    {
        atag = atag[0];
        ObjectID objectid = atag.getObjectId();
        int i = FoldersAdapter.access$000(FoldersAdapter.this).getMediaItemCount(atag);
        FoldersAdapter.access$100(FoldersAdapter.this).put(objectid, Integer.valueOf(i));
        atag = IdUtils.objectIdToNodeId(objectid.getMostSignificantBits(), objectid.getLeastSignificantBits());
        if (!FoldersAdapter.access$200(FoldersAdapter.this).isPathAvailable(atag))
        {
            FoldersAdapter.access$200(FoldersAdapter.this).addFolder(atag);
        }
        return new Pair(Integer.valueOf(i), FoldersAdapter.access$200(FoldersAdapter.this).getPath(atag));
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Tag[])aobj);
    }

    protected void onPostExecute(Pair pair)
    {
        viewHolder.Count(((Integer)pair.first).intValue());
        viewHolder.erPath((String)pair.second);
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Pair)obj);
    }

    public ( )
    {
        this$0 = FoldersAdapter.this;
        super();
        viewHolder = ;
    }
}
