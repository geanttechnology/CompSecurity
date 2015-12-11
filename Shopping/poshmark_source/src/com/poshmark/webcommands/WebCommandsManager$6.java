// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.webcommands;

import com.poshmark.ui.fragments.MappPageFragment;

// Referenced classes of package com.poshmark.webcommands:
//            WebCommandsManager

class val.disableNavigation
    implements com.poshmark.utils.
{

    final WebCommandsManager this$0;
    final boolean val$disableNavigation;
    final String val$message;

    public void runOnUIThread(Object obj)
    {
        fragment.showProgressDialogWithMessage(val$message, val$disableNavigation);
    }

    ()
    {
        this$0 = final_webcommandsmanager;
        val$message = s;
        val$disableNavigation = Z.this;
        super();
    }
}
