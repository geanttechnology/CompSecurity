// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.webcommands;

import com.poshmark.ui.PMActivity;
import com.poshmark.ui.fragments.MappPageFragment;
import java.util.Map;

// Referenced classes of package com.poshmark.webcommands:
//            WebCommandsManager, WebCommand

class val.command
    implements com.poshmark.utils.
{

    final WebCommandsManager this$0;
    final WebCommand val$command;
    final int val$pageCount;

    public void runOnUIThread(Object obj)
    {
        parentActivity.popTopNFragments(val$pageCount, true);
        obj = WebCommandsManager.access$000(WebCommandsManager.this);
        if (obj != null && val$command.parameters.containsKey("callbackMethod"))
        {
            ((MappPageFragment) (obj)).fireJSCallback((String)val$command.parameters.get("callbackMethod"));
        }
    }

    ()
    {
        this$0 = final_webcommandsmanager;
        val$pageCount = i;
        val$command = WebCommand.this;
        super();
    }
}
