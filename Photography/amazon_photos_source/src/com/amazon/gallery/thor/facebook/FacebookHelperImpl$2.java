// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.facebook;

import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.network.exceptions.TerminalException;
import org.json.JSONObject;

// Referenced classes of package com.amazon.gallery.thor.facebook:
//            FacebookHelperImpl

class val.onNoPhotosPermission
    implements com.amazon.gallery.framework.network.tHandler
{

    final FacebookHelperImpl this$0;
    final Runnable val$onHasPhotoPermission;
    final Runnable val$onNoPhotosPermission;

    public void onFailure(TerminalException terminalexception)
    {
        GLogger.w(FacebookHelperImpl.access$100(), "Failed to parse facebook snds permissions json response ", new Object[] {
            terminalexception
        });
        val$onNoPhotosPermission.run();
    }

    public volatile void onSuccess(Object obj)
    {
        onSuccess((JSONObject)obj);
    }

    public void onSuccess(JSONObject jsonobject)
    {
label0:
        {
            if (jsonobject != null)
            {
                if (!FacebookHelperImpl.access$000(FacebookHelperImpl.this, jsonobject))
                {
                    break label0;
                }
                val$onHasPhotoPermission.run();
            }
            return;
        }
        val$onNoPhotosPermission.run();
    }

    alException()
    {
        this$0 = final_facebookhelperimpl;
        val$onHasPhotoPermission = runnable;
        val$onNoPhotosPermission = Runnable.this;
        super();
    }
}
