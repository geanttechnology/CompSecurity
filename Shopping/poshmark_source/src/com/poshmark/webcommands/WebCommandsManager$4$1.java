// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.webcommands;

import android.view.View;
import android.widget.Button;
import com.poshmark.ui.fragments.MappPageFragment;
import java.util.Map;

// Referenced classes of package com.poshmark.webcommands:
//            WebCommand, WebCommandsManager

class this._cls1
    implements android.view.Manager._cls4._cls1
{

    final ment this$1;

    public void onClick(View view)
    {
        ((WebCommand)(WebCommand)view.getTag()).handleCommandResults(fragment, null);
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/poshmark/webcommands/WebCommandsManager$4

/* anonymous class */
    class WebCommandsManager._cls4
        implements com.poshmark.utils.UIThreadTask.Callback
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
            button.setOnClickListener(new WebCommandsManager._cls4._cls1());
        }

            
            {
                this$0 = WebCommandsManager.this;
                super();
            }
    }

}
