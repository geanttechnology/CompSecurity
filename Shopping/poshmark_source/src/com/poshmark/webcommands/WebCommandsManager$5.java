// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.webcommands;

import android.content.Intent;
import com.poshmark.ui.fragments.MappPageFragment;
import java.util.Map;

// Referenced classes of package com.poshmark.webcommands:
//            CommandCompletionHandler, WebCommandsManager, WebCommand

class ler extends CommandCompletionHandler
{

    final WebCommandsManager this$0;

    public void handleCommandResults(MappPageFragment mapppagefragment, WebCommand webcommand, Intent intent)
    {
        if (mapppagefragment instanceof MappPageFragment)
        {
            mapppagefragment.fireJSCallback((String)webcommand.parameters.get("callbackMethod"));
        }
    }

    ler()
    {
        this$0 = WebCommandsManager.this;
        super();
    }
}
