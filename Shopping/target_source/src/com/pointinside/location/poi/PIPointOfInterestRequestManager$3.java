// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.location.poi;

import java.util.List;

// Referenced classes of package com.pointinside.location.poi:
//            PIPointOfInterestRequestManager, PIPointOfInterest, PointOfInterestResponseListener

class ILoaderTask extends ILoaderTask
{

    final PIPointOfInterestRequestManager this$0;
    final PointOfInterestResponseListener val$callback;

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((List)obj);
    }

    protected void onPostExecute(List list)
    {
        super.onPostExecute(list);
        if (list != null)
        {
            if (list.size() > 0)
            {
                val$callback.onPointOfInterestRetrieved((PIPointOfInterest)list.get(0));
            }
            return;
        } else
        {
            val$callback.onPointOfInterestRetrieved(null);
            return;
        }
    }

    ILoaderTask()
    {
        this$0 = final_pipointofinterestrequestmanager;
        val$callback = PointOfInterestResponseListener.this;
        super(final_pipointofinterestrequestmanager);
    }
}
