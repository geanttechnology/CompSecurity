// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mobile.mash.api;

import com.amazon.mobile.mash.error.MASHError;
import com.amazon.mobile.mash.error.OpenFileChooserError;
import java.io.IOException;
import org.apache.cordova.CallbackContext;

// Referenced classes of package com.amazon.mobile.mash.api:
//            MASHFileChooserPlugin

class val.duration
    implements Runnable
{

    final MASHFileChooserPlugin this$0;
    final boolean val$capture;
    final int val$duration;
    final String val$mimeType;

    public void run()
    {
        if (MASHFileChooserPlugin.access$000(MASHFileChooserPlugin.this, val$mimeType))
        {
            MASHFileChooserPlugin.access$100(MASHFileChooserPlugin.this).error(OpenFileChooserError.MIME_TYPE_NOT_SUPPORTED.toJSONObject());
            return;
        }
        Object obj = MASHFileChooserPlugin.access$200(MASHFileChooserPlugin.this, val$mimeType, val$capture, val$duration);
        if (obj == null)
        {
            try
            {
                MASHFileChooserPlugin.access$100(MASHFileChooserPlugin.this).error(MASHError.UNKNOWN.toJSONObejct());
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                MASHFileChooserPlugin.access$100(MASHFileChooserPlugin.this).error(MASHError.PERMISSION_DENIED.toJSONObejct());
            }
            return;
        }
        MASHFileChooserPlugin.access$300(MASHFileChooserPlugin.this, ((android.content.Intent) (obj)), val$duration);
        return;
    }

    ()
    {
        this$0 = final_mashfilechooserplugin;
        val$mimeType = s;
        val$capture = flag;
        val$duration = I.this;
        super();
    }
}
