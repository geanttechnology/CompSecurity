// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.drm.java.service.workflow;

import com.adobe.ave.drm.DRMManager;
import com.adobe.ave.drm.DRMOperationCompleteCallback;
import com.comcast.playerplatform.drm.java.event.AbstractDrmLicenseEventListener;
import com.comcast.playerplatform.drm.java.util.ThreadManager;
import com.google.common.util.concurrent.SettableFuture;
import java.util.Iterator;
import java.util.Vector;

// Referenced classes of package com.comcast.playerplatform.drm.java.service.workflow:
//            AbstractDRMWorkflow

class this._cls1
    implements Runnable
{

    final icenseAcquiredCallback this$1;

    public void run()
    {
        Object obj = listeners;
        obj;
        JVM INSTR monitorenter ;
        Iterator iterator = listeners.iterator();
_L2:
        AbstractDrmLicenseEventListener abstractdrmlicenseeventlistener;
        do
        {
            if (!iterator.hasNext())
            {
                break MISSING_BLOCK_LABEL_89;
            }
            abstractdrmlicenseeventlistener = (AbstractDrmLicenseEventListener)iterator.next();
        } while (abstractdrmlicenseeventlistener == null);
        abstractdrmlicenseeventlistener.acquiringLicense(manifestUri);
        if (true) goto _L2; else goto _L1
_L1:
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        try
        {
            throw exception;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            drmLicenseFuture.setException(((Throwable) (obj)));
        }
        return;
        obj;
        JVM INSTR monitorexit ;
        drmManager.acquireLicense(drmMetadata, licenseSettings, drmOperationErrorCallback, drmLicenseAcquiredCallback);
        return;
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow$6

/* anonymous class */
    class AbstractDRMWorkflow._cls6
        implements DRMOperationCompleteCallback
    {

        final AbstractDRMWorkflow this$0;

        public void OperationComplete()
        {
            ThreadManager.getInstance().executeOnUIThread(new AbstractDRMWorkflow._cls6._cls1());
        }

            
            {
                this$0 = AbstractDRMWorkflow.this;
                super();
            }
    }

}
