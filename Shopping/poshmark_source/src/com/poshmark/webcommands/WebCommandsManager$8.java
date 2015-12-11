// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.webcommands;

import com.poshmark.ui.fragments.MappPageFragment;
import java.util.Map;

// Referenced classes of package com.poshmark.webcommands:
//            WebCommandsManager, WebCommand

class val.contactsJson
    implements com.poshmark.utils.
{

    final WebCommandsManager this$0;
    final WebCommand val$command;
    final String val$contactsJson;

    public void runOnUIThread(Object obj)
    {
        fragment.fireJSCallback((new StringBuilder()).append((String)val$command.parameters.get("callback")).append("(").append(val$contactsJson).append(",").append(WebCommandsManager.JAVASCRIPT_NULL).append(")").toString());
    }

    ()
    {
        this$0 = final_webcommandsmanager;
        val$command = webcommand;
        val$contactsJson = String.this;
        super();
    }
}
