// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.webcommands;

import android.content.Intent;
import com.poshmark.ui.fragments.MappPageFragment;

// Referenced classes of package com.poshmark.webcommands:
//            CommandCompletionHandler, WebCommand

public class CompleteOfferHandler extends CommandCompletionHandler
{

    public CompleteOfferHandler()
    {
    }

    public void handleCommandResults(MappPageFragment mapppagefragment, WebCommand webcommand, Intent intent)
    {
        if (mapppagefragment instanceof MappPageFragment)
        {
            mapppagefragment.reload();
        }
    }
}
