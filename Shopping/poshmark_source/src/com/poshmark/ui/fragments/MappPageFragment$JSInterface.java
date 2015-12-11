// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.content.Context;
import android.webkit.WebView;
import com.poshmark.ui.PMActivity;
import com.poshmark.utils.UIThreadTask;
import com.poshmark.webcommands.WebCommandsManager;

// Referenced classes of package com.poshmark.ui.fragments:
//            MappPageFragment

public class mContext
{

    Context mContext;
    final MappPageFragment this$0;

    public void executeCommand(String s)
    {
        commandsManager.launchWebCommand(s);
        s = new UIThreadTask((PMActivity)getActivity());
        s.setCallback(new com.poshmark.utils.UIThreadTask.Callback() {

            final MappPageFragment.JSInterface this$1;

            public void runOnUIThread(Object obj)
            {
                webView.loadUrl("javascript:gp_command.queue.ready=true;");
            }

            
            {
                this$1 = MappPageFragment.JSInterface.this;
                super();
            }
        });
        s.execute(null);
    }

    _cls1.this._cls1(Context context)
    {
        this$0 = MappPageFragment.this;
        super();
        mContext = context;
    }
}
