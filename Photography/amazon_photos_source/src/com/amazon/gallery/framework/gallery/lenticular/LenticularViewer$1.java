// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.lenticular;

import android.os.AsyncTask;
import com.amazon.gallery.framework.model.media.OrderedGroupPhoto;
import java.util.List;

// Referenced classes of package com.amazon.gallery.framework.gallery.lenticular:
//            LenticularViewer, GalleryLenticularHelper

class val.lenticular extends AsyncTask
{

    final LenticularViewer this$0;
    final OrderedGroupPhoto val$lenticular;

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient List doInBackground(Void avoid[])
    {
        return LenticularViewer.access$000(LenticularViewer.this).loadFrames(val$lenticular);
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((List)obj);
    }

    protected void onPostExecute(List list)
    {
        if (list != null)
        {
            LenticularViewer.access$100(LenticularViewer.this, list);
        }
    }

    lper()
    {
        this$0 = final_lenticularviewer;
        val$lenticular = OrderedGroupPhoto.this;
        super();
    }
}
