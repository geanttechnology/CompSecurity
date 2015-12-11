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

class val.okCallback
    implements android.content.Listener
{

    final val.okCallback this$1;
    final String val$okCallback;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        fragment.fireJSCallback((new StringBuilder()).append(val$okCallback).append("()").toString());
    }

    l.command()
    {
        this$1 = final_command;
        val$okCallback = String.this;
        super();
    }

    // Unreferenced inner class com/poshmark/webcommands/WebCommandsManager$2

/* anonymous class */
    class WebCommandsManager._cls2
        implements com.poshmark.utils.UIThreadTask.Callback
    {

        final WebCommandsManager this$0;
        final WebCommand val$command;

        public void runOnUIThread(Object obj)
        {
            String s2;
            String s3;
label0:
            {
                s2 = Uri.decode((String)command.parameters.get("title"));
                s3 = Uri.decode((String)command.parameters.get("message"));
                String s = (String)command.parameters.get("cancelButtonTitle");
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
            String s1 = (String)command.parameters.get("okButtonTitle");
            String s4 = (String)command.parameters.get("alertOkCallbackMethodName");
            final String cancelCallback = (String)command.parameters.get("alertCancelCallbackMethodName");
            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(parentActivity);
            builder.setTitle(s2);
            builder.setMessage(s3);
            builder.setCancelable(false);
            if (s1 != null && s1.length() > 0)
            {
                builder.setPositiveButton(s1, s4. new WebCommandsManager._cls2._cls1());
            }
            if (((String) (obj)).length() > 0)
            {
                builder.setNegativeButton(((CharSequence) (obj)), new WebCommandsManager._cls2._cls2());
            }
            builder.create().show();
        }

            
            {
                this$0 = final_webcommandsmanager;
                command = WebCommand.this;
                super();
            }

        // Unreferenced inner class com/poshmark/webcommands/WebCommandsManager$2$2

/* anonymous class */
        class WebCommandsManager._cls2._cls2
            implements android.content.DialogInterface.OnClickListener
        {

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
        }

    }

}
