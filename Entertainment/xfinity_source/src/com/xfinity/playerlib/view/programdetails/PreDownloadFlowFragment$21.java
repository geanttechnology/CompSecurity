// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.programdetails;

import com.comcast.cim.cmasl.taskexecutor.executor.TaskExecutor;
import com.comcast.cim.model.parentalcontrols.ParentalControlsSettings;
import org.slf4j.Logger;

// Referenced classes of package com.xfinity.playerlib.view.programdetails:
//            PreDownloadFlowFragment

class ryingExecutionListener extends ryingExecutionListener
{

    final PreDownloadFlowFragment this$0;

    public void onPostExecute(ParentalControlsSettings parentalcontrolssettings)
    {
        PreDownloadFlowFragment.access$100(PreDownloadFlowFragment.this).debug("Parental control settings fetched");
        com.comcast.cim.model.parentalcontrols.ParentalControlsPin parentalcontrolspin = parentalcontrolssettings.getParentalPin();
        if (parentalcontrolspin != null && PreDownloadFlowFragment.access$3400(PreDownloadFlowFragment.this, parentalcontrolssettings, PreDownloadFlowFragment.access$3300(PreDownloadFlowFragment.this)))
        {
            PreDownloadFlowFragment.access$100(PreDownloadFlowFragment.this).debug("Prompting for pin");
            PreDownloadFlowFragment.access$3500(PreDownloadFlowFragment.this, parentalcontrolspin);
            return;
        } else
        {
            PreDownloadFlowFragment.access$100(PreDownloadFlowFragment.this).debug("Pin not set or not required for video");
            PreDownloadFlowFragment.access$3600(PreDownloadFlowFragment.this);
            return;
        }
    }

    public volatile void onPostExecute(Object obj)
    {
        onPostExecute((ParentalControlsSettings)obj);
    }

    ryingExecutionListener(TaskExecutor taskexecutor)
    {
        this$0 = PreDownloadFlowFragment.this;
        super(PreDownloadFlowFragment.this, taskexecutor);
    }
}
