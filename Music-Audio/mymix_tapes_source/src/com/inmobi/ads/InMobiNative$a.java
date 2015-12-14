// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.ads;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.inmobi.commons.core.utilities.Logger;
import java.lang.ref.WeakReference;

// Referenced classes of package com.inmobi.ads:
//            InMobiNative, InMobiAdRequestStatus

private static final class nit> extends Handler
{

    private WeakReference a;
    private WeakReference b;

    public void handleMessage(Message message)
    {
        InMobiNative inmobinative;
        tiveAdListener tiveadlistener;
label0:
        {
label1:
            {
label2:
                {
label3:
                    {
label4:
                        {
                            inmobinative = (InMobiNative)b.get();
                            tiveadlistener = (tiveAdListener)a.get();
                            if (inmobinative != null && tiveadlistener != null)
                            {
                                switch (message.what)
                                {
                                default:
                                    Logger.a(com.inmobi.commons.core.utilities.LogLevel.INTERNAL, InMobiNative.access$000(), "Unhandled ad lifecycle event! Ignoring ...");
                                    break;

                                case 1: // '\001'
                                    break label4;

                                case 2: // '\002'
                                    break label3;

                                case 3: // '\003'
                                    break label2;

                                case 4: // '\004'
                                    break label1;

                                case 5: // '\005'
                                    break label0;
                                }
                            }
                            return;
                        }
                        tiveadlistener.onAdLoadSucceeded(inmobinative);
                        return;
                    }
                    tiveadlistener.onAdLoadFailed(inmobinative, (InMobiAdRequestStatus)message.obj);
                    return;
                }
                tiveadlistener.onAdDisplayed(inmobinative);
                return;
            }
            tiveadlistener.onAdDismissed(inmobinative);
            return;
        }
        tiveadlistener.onUserLeftApplication(inmobinative);
    }

    public tiveAdListener(InMobiNative inmobinative, tiveAdListener tiveadlistener)
    {
        super(Looper.getMainLooper());
        b = new WeakReference(inmobinative);
        a = new WeakReference(tiveadlistener);
    }
}
