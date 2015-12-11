// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.webcommands;

import com.poshmark.ui.PMActivity;
import com.poshmark.ui.fragments.MappPageFragment;

// Referenced classes of package com.poshmark.webcommands:
//            WebCommandsManager

class val.pageName
    implements com.poshmark.utils.er._cls10
{

    final WebCommandsManager this$0;
    final String val$pageName;

    public void runOnUIThread(Object obj)
    {
        WebCommandsManager.access$100(WebCommandsManager.this, val$pageName);
        obj = parentActivity.getVisibleFragment();
        if (obj != null && (obj instanceof MappPageFragment))
        {
            ((MappPageFragment)obj).reload();
        }
    }

    ()
    {
        this$0 = final_webcommandsmanager;
        val$pageName = String.this;
        super();
    }
}
