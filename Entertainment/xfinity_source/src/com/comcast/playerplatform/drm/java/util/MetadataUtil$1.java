// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.drm.java.util;

import com.comcast.playerplatform.util.android.AbstractResponseEventListener;
import java.net.URI;

// Referenced classes of package com.comcast.playerplatform.drm.java.util:
//            MetadataUtil, ThreadManager

static final class val.manifestUri
    implements Runnable
{

    final String val$manifestUri;
    final AbstractResponseEventListener val$responseEventListener;
    final URI val$uri;

    public void run()
    {
        final String manifestString;
        if (val$uri.getScheme() != null)
        {
            break MISSING_BLOCK_LABEL_42;
        }
        manifestString = MetadataUtil.access$000(URI.create("file:/").resolve(val$uri));
_L1:
        ThreadManager.getInstance().executeOnUIThread(new Runnable() {

            final MetadataUtil._cls1 this$0;
            final String val$manifestString;

            public void run()
            {
                responseEventListener.responseReceived(manifestString);
            }

            
            {
                this$0 = MetadataUtil._cls1.this;
                manifestString = s;
                super();
            }
        });
        return;
        try
        {
            manifestString = MetadataUtil.access$000(val$uri);
        }
        catch (Exception exception)
        {
            ThreadManager.getInstance().executeOnUIThread(new Runnable() {

                final MetadataUtil._cls1 this$0;

                public void run()
                {
                    responseEventListener.requestFailed((new StringBuilder()).append("manifest not found:").append(manifestUri).toString());
                }

            
            {
                this$0 = MetadataUtil._cls1.this;
                super();
            }
            });
            return;
        }
          goto _L1
    }

    EventListener(URI uri1, AbstractResponseEventListener abstractresponseeventlistener, String s)
    {
        val$uri = uri1;
        val$responseEventListener = abstractresponseeventlistener;
        val$manifestUri = s;
        super();
    }
}
