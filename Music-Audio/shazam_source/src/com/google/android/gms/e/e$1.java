// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.e;

import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.c;
import com.google.android.gms.common.d;
import java.io.IOException;

// Referenced classes of package com.google.android.gms.e:
//            e, aj

final class a
    implements a
{

    final e a;

    public final com.google.android.gms.ads.identifier.rtisingIdClient.Info a()
    {
        com.google.android.gms.ads.identifier.rtisingIdClient.Info info;
        try
        {
            info = AdvertisingIdClient.getAdvertisingIdInfo(e.a(a));
        }
        catch (IllegalStateException illegalstateexception)
        {
            aj.a();
            return null;
        }
        catch (d d1)
        {
            aj.a();
            return null;
        }
        catch (IOException ioexception)
        {
            aj.a();
            return null;
        }
        catch (c c1)
        {
            aj.a();
            return null;
        }
        catch (Exception exception)
        {
            aj.a();
            return null;
        }
        return info;
    }

    .c(e e1)
    {
        a = e1;
        super();
    }
}
