// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.altbeacon.beacon.service;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;
import org.altbeacon.beacon.c.c;

// Referenced classes of package org.altbeacon.beacon.service:
//            BeaconService, StartRMData, a

static class a extends Handler
{

    private final WeakReference a;

    public void handleMessage(Message message)
    {
        BeaconService beaconservice;
        StartRMData startrmdata;
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
                            beaconservice = (BeaconService)a.get();
                            startrmdata = (StartRMData)message.obj;
                            if (beaconservice != null)
                            {
                                switch (message.what)
                                {
                                default:
                                    super.handleMessage(message);
                                    break;

                                case 2: // '\002'
                                    break label4;

                                case 3: // '\003'
                                    break label3;

                                case 4: // '\004'
                                    break label2;

                                case 5: // '\005'
                                    break label1;

                                case 6: // '\006'
                                    break label0;
                                }
                            }
                            return;
                        }
                        c.b("BeaconService", "start ranging received", new Object[0]);
                        beaconservice.a(startrmdata.c(), new a(startrmdata.d()));
                        beaconservice.a(startrmdata.a(), startrmdata.b(), startrmdata.e());
                        return;
                    }
                    c.b("BeaconService", "stop ranging received", new Object[0]);
                    beaconservice.a(startrmdata.c());
                    beaconservice.a(startrmdata.a(), startrmdata.b(), startrmdata.e());
                    return;
                }
                c.b("BeaconService", "start monitoring received", new Object[0]);
                beaconservice.b(startrmdata.c(), new a(startrmdata.d()));
                beaconservice.a(startrmdata.a(), startrmdata.b(), startrmdata.e());
                return;
            }
            c.b("BeaconService", "stop monitoring received", new Object[0]);
            beaconservice.b(startrmdata.c());
            beaconservice.a(startrmdata.a(), startrmdata.b(), startrmdata.e());
            return;
        }
        c.b("BeaconService", "set scan intervals received", new Object[0]);
        beaconservice.a(startrmdata.a(), startrmdata.b(), startrmdata.e());
    }

    (BeaconService beaconservice)
    {
        a = new WeakReference(beaconservice);
    }
}
