// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.activity;

import android.os.AsyncTask;
import com.amazon.gallery.foundation.utils.TimeTracker;
import com.amazon.gallery.framework.gallery.widget.GridStatus;
import com.amazon.gallery.framework.gallery.widget.TagListAdapter;
import com.amazon.gallery.thor.widget.AppCompatProgressDialog;
import java.util.List;

// Referenced classes of package com.amazon.gallery.framework.kindle.activity:
//            CollectionListActivity

private abstract class <init> extends AsyncTask
{

    private AppCompatProgressDialog blockingPopup;
    final CollectionListActivity this$0;

    public void hideProgress()
    {
        if (blockingPopup != null)
        {
            blockingPopup.dismiss();
        }
    }

    protected final void onCancelled()
    {
        statusTracker.setForceShow(false);
        hideProgress();
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((List)obj);
    }

    protected final void onPostExecute(List list)
    {
        TimeTracker.log("loadTags.onPostExecute");
        listAdapter.setTags(list);
        statusTracker.setForceShow(false);
        hideProgress();
    }

    protected final void onPreExecute()
    {
        TimeTracker.log("loadTags.onPreExecute");
        statusTracker.setForceShow(true);
    }

    protected transient void onProgressUpdate(Integer ainteger[])
    {
        int i = ainteger[0].intValue();
        int j = ainteger[1].intValue();
        if (blockingPopup == null)
        {
            blockingPopup = (new com.amazon.gallery.thor.widget.lbumAsyncTask.blockingPopup(CollectionListActivity.this))._mth0(com.amazon.gallery.thor.widget.TAL).e(false).e(j).e();
        }
        blockingPopup.updateProgress(i);
    }

    protected volatile void onProgressUpdate(Object aobj[])
    {
        onProgressUpdate((Integer[])aobj);
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
