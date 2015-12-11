// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.webcommands;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.poshmark.ui.fragments.MappPageFragment;

// Referenced classes of package com.poshmark.webcommands:
//            CommandCompletionHandler, WebCommand

public class StartListingFlowCompletionHandler extends CommandCompletionHandler
{

    public StartListingFlowCompletionHandler()
    {
        type = CommandCompletionHandler.HandlerType.START_LISTINGS_FLOW;
    }

    public void handleCommandResults(MappPageFragment mapppagefragment, WebCommand webcommand, Intent intent)
    {
        mapppagefragment = (Uri)intent.getExtras().getParcelable("IMAGE_FILE_URI");
    }
}
