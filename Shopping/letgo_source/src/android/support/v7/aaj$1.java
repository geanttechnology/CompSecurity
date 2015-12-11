// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.c;
import com.google.android.gms.common.d;
import java.io.IOException;

// Referenced classes of package android.support.v7:
//            aaj, abo

class a
    implements a
{

    final aaj a;

    public com.google.android.gms.ads.identifier.isingIdClient.Info a()
    {
        com.google.android.gms.ads.identifier.isingIdClient.Info info;
        try
        {
            info = AdvertisingIdClient.getAdvertisingIdInfo(aaj.a(a));
        }
        catch (IllegalStateException illegalstateexception)
        {
            abo.b("IllegalStateException getting Advertising Id Info");
            return null;
        }
        catch (d d1)
        {
            abo.b("GooglePlayServicesRepairableException getting Advertising Id Info");
            return null;
        }
        catch (IOException ioexception)
        {
            abo.b("IOException getting Ad Id Info");
            return null;
        }
        catch (c c1)
        {
            abo.b("GooglePlayServicesNotAvailableException getting Advertising Id Info");
            return null;
        }
        catch (Exception exception)
        {
            abo.b("Unknown exception. Could not get the Advertising Id Info.");
            return null;
        }
        return info;
    }

    mmon.c(aaj aaj1)
    {
        a = aaj1;
        super();
    }
}
