// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.request;

import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.internal.zzhu;
import com.google.android.gms.internal.zzmt;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

// Referenced classes of package com.google.android.gms.ads.internal.request:
//            LargeParcelTeleporter

class zzFg
    implements Runnable
{

    final OutputStream zzFf;
    final byte zzFg[];
    final LargeParcelTeleporter zzFh;

    public void run()
    {
        DataOutputStream dataoutputstream1 = new DataOutputStream(zzFf);
        DataOutputStream dataoutputstream = dataoutputstream1;
        dataoutputstream1.writeInt(zzFg.length);
        dataoutputstream = dataoutputstream1;
        dataoutputstream1.write(zzFg);
        zzmt.zzb(dataoutputstream1);
        return;
        IOException ioexception;
        ioexception;
        dataoutputstream1 = null;
_L4:
        dataoutputstream = dataoutputstream1;
        zzb.zzb("Error transporting the ad response", ioexception);
        dataoutputstream = dataoutputstream1;
        zzp.zzby().zzc(ioexception, true);
        if (dataoutputstream1 == null)
        {
            zzmt.zzb(zzFf);
            return;
        } else
        {
            zzmt.zzb(dataoutputstream1);
            return;
        }
        Exception exception;
        exception;
        dataoutputstream = null;
_L2:
        if (dataoutputstream == null)
        {
            zzmt.zzb(zzFf);
        } else
        {
            zzmt.zzb(dataoutputstream);
        }
        throw exception;
        exception;
        if (true) goto _L2; else goto _L1
_L1:
        ioexception;
        if (true) goto _L4; else goto _L3
_L3:
    }

    I(LargeParcelTeleporter largeparcelteleporter, OutputStream outputstream, byte abyte0[])
    {
        zzFh = largeparcelteleporter;
        zzFf = outputstream;
        zzFg = abyte0;
        super();
    }
}
