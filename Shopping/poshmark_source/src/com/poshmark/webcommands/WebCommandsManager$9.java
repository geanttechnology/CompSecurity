// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.webcommands;


// Referenced classes of package com.poshmark.webcommands:
//            WebCommandsManager, WebCommand

class val.command
    implements com.poshmark.utils.
{

    final WebCommandsManager this$0;
    final WebCommand val$command;
    final String val$pageName;

    public void runOnUIThread(Object obj)
    {
        if (WebCommandsManager.access$100(WebCommandsManager.this, val$pageName))
        {
            WebCommandsManager.access$200(WebCommandsManager.this, val$command);
        }
    }

    ()
    {
        this$0 = final_webcommandsmanager;
        val$pageName = s;
        val$command = WebCommand.this;
        super();
    }
}
