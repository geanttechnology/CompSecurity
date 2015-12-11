// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.webcommands;

import android.view.View;
import android.widget.Button;
import com.poshmark.ui.fragments.MappPageFragment;
import java.util.Map;

// Referenced classes of package com.poshmark.webcommands:
//            WebCommandsManager, WebCommand

class this._cls0
    implements com.poshmark.utils.
{

    final WebCommandsManager this$0;

    public void runOnUIThread(Object obj)
    {
        fragment.hideAllActionButtons(true);
        obj = (WebCommand)obj;
        Button button = fragment.getNextActionButton();
        String s = (String)((WebCommand) (obj)).parameters.get("title");
        if (s != null)
        {
            button.setText(s);
        }
        button.setTag(obj);
        button.setOnClickListener(new android.view.View.OnClickListener() {

            final WebCommandsManager._cls4 this$1;

            public void onClick(View view)
            {
                ((WebCommand)(WebCommand)view.getTag()).handleCommandResults(fragment, null);
            }

            
            {
                this$1 = WebCommandsManager._cls4.this;
                super();
            }
        });
    }

    _cls1.this._cls1()
    {
        this$0 = WebCommandsManager.this;
        super();
    }
}
