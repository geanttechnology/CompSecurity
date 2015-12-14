// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.ads;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.inmobi.commons.core.utilities.Logger;
import java.lang.ref.WeakReference;
import java.util.Map;

// Referenced classes of package com.inmobi.ads:
//            InMobiBanner, InMobiAdRequestStatus

private static final class nit> extends Handler
{

    private WeakReference a;
    private WeakReference b;

    public void a(nnerAdListener nneradlistener)
    {
        a = new WeakReference(nneradlistener);
    }

    public void handleMessage(Message message)
    {
        Object obj;
        InMobiBanner inmobibanner;
        nnerAdListener nneradlistener;
label0:
        {
label1:
            {
                Map map;
label2:
                {
label3:
                    {
label4:
                        {
label5:
                            {
label6:
                                {
                                    obj = null;
                                    map = null;
                                    inmobibanner = (InMobiBanner)b.get();
                                    nneradlistener = (nnerAdListener)a.get();
                                    if (inmobibanner != null && nneradlistener != null)
                                    {
                                        switch (message.what)
                                        {
                                        default:
                                            Logger.a(com.inmobi.commons.core.utilities.LogLevel.INTERNAL, InMobiBanner.access$300(), "Unhandled ad lifecycle event! Ignoring ...");
                                            break;

                                        case 1: // '\001'
                                            break label6;

                                        case 2: // '\002'
                                            break label5;

                                        case 3: // '\003'
                                            break label4;

                                        case 4: // '\004'
                                            break label3;

                                        case 5: // '\005'
                                            break label2;

                                        case 6: // '\006'
                                            break label1;

                                        case 7: // '\007'
                                            break label0;
                                        }
                                    }
                                    return;
                                }
                                nneradlistener.onAdLoadSucceeded(inmobibanner);
                                return;
                            }
                            nneradlistener.onAdLoadFailed(inmobibanner, (InMobiAdRequestStatus)message.obj);
                            return;
                        }
                        nneradlistener.onAdDisplayed(inmobibanner);
                        return;
                    }
                    nneradlistener.onAdDismissed(inmobibanner);
                    return;
                }
                if (message.obj != null)
                {
                    map = (Map)message.obj;
                }
                nneradlistener.onAdInteraction(inmobibanner, map);
                return;
            }
            nneradlistener.onUserLeftApplication(inmobibanner);
            return;
        }
        Map map1 = obj;
        if (message.obj != null)
        {
            map1 = (Map)message.obj;
        }
        nneradlistener.onAdRewardActionCompleted(inmobibanner, map1);
    }

    public nnerAdListener(InMobiBanner inmobibanner, nnerAdListener nneradlistener)
    {
        super(Looper.getMainLooper());
        b = new WeakReference(inmobibanner);
        a = new WeakReference(nneradlistener);
    }
}
