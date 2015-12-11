// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.webcommands;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.net.Uri;
import com.poshmark.ui.PMActivity;
import com.poshmark.ui.fragments.MappPageFragment;
import java.util.Map;

// Referenced classes of package com.poshmark.webcommands:
//            WebCommandsManager, WebCommand

class val.command
    implements com.poshmark.utils.
{

    final WebCommandsManager this$0;
    final WebCommand val$command;

    public void runOnUIThread(Object obj)
    {
        String s2;
        String s3;
label0:
        {
            s2 = Uri.decode((String)val$command.parameters.get("title"));
            s3 = Uri.decode((String)val$command.parameters.get("message"));
            String s = (String)val$command.parameters.get("cancelButtonTitle");
            if (s != null)
            {
                obj = s;
                if (s.length() != 0)
                {
                    break label0;
                }
            }
            obj = parentActivity.getString(0x7f0601e1);
        }
        String s1 = (String)val$command.parameters.get("okButtonTitle");
        final String okCallback = (String)val$command.parameters.get("alertOkCallbackMethodName");
        final String cancelCallback = (String)val$command.parameters.get("alertCancelCallbackMethodName");
        android.app.nClickListener nclicklistener = new android.app.init>(parentActivity);
        nclicklistener.etTitle(s2);
        nclicklistener.etMessage(s3);
        nclicklistener.etCancelable(false);
        if (s1 != null && s1.length() > 0)
        {
            nclicklistener.etPositiveButton(s1, new android.content.DialogInterface.OnClickListener() {

                final WebCommandsManager._cls2 this$1;
                final String val$okCallback;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    fragment.fireJSCallback((new StringBuilder()).append(okCallback).append("()").toString());
                }

            
            {
                this$1 = WebCommandsManager._cls2.this;
                okCallback = s;
                super();
            }
            });
        }
        if (((String) (obj)).length() > 0)
        {
            nclicklistener.etNegativeButton(((CharSequence) (obj)), new android.content.DialogInterface.OnClickListener() {

                final WebCommandsManager._cls2 this$1;
                final String val$cancelCallback;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    fragment.fireJSCallback((new StringBuilder()).append(cancelCallback).append("()").toString());
                }

            
            {
                this$1 = WebCommandsManager._cls2.this;
                cancelCallback = s;
                super();
            }
            });
        }
        nclicklistener.reate().show();
    }

    _cls2.val.cancelCallback()
    {
        this$0 = final_webcommandsmanager;
        val$command = WebCommand.this;
        super();
    }
}
