// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.drm.java.util;

import com.comcast.playerplatform.util.android.AbstractResponseEventListener;
import java.net.URI;

// Referenced classes of package com.comcast.playerplatform.drm.java.util:
//            MetadataUtil, ThreadManager

class this._cls0
    implements Runnable
{

    final l.manifestUri this$0;

    public void run()
    {
        responseEventListener.requestFailed((new StringBuilder()).append("manifest not found:").append(manifestUri).toString());
    }

    l.manifestUri()
    {
        this$0 = this._cls0.this;
        super();
    }

    // Unreferenced inner class com/comcast/playerplatform/drm/java/util/MetadataUtil$1

/* anonymous class */
    static final class MetadataUtil._cls1
        implements Runnable
    {

        final String val$manifestUri;
        final AbstractResponseEventListener val$responseEventListener;
        final URI val$uri;

        public void run()
        {
            final String manifestString;
            if (uri.getScheme() != null)
            {
                break MISSING_BLOCK_LABEL_42;
            }
            manifestString = MetadataUtil.access$000(URI.create("file:/").resolve(uri));
_L1:
            ThreadManager.getInstance().executeOnUIThread(new MetadataUtil._cls1._cls1());
            return;
            try
            {
                manifestString = MetadataUtil.access$000(uri);
            }
            catch (Exception exception)
            {
                ThreadManager.getInstance().executeOnUIThread(new MetadataUtil._cls1._cls2());
                return;
            }
              goto _L1
        }

            
            {
                uri = uri1;
                responseEventListener = abstractresponseeventlistener;
                manifestUri = s;
                super();
            }

        // Unreferenced inner class com/comcast/playerplatform/drm/java/util/MetadataUtil$1$1

/* anonymous class */
        class MetadataUtil._cls1._cls1
            implements Runnable
        {

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
        }

    }

}
