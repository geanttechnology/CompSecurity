// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.location.poi;

import java.util.List;

// Referenced classes of package com.pointinside.location.poi:
//            PIPointOfInterestRequestManager, PointsOfInterestResponseListener

class ILoaderTask extends ILoaderTask
{

    final PIPointOfInterestRequestManager this$0;
    final PointsOfInterestResponseListener val$callback;

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((List)obj);
    }

    protected void onPostExecute(List list)
    {
        super.onPostExecute(list);
        val$callback.onPointsOfInterestRetrieved(list);
    }

    ILoaderTask()
    {
        this$0 = final_pipointofinterestrequestmanager;
        val$callback = PointsOfInterestResponseListener.this;
        super(final_pipointofinterestrequestmanager);
    }
}
