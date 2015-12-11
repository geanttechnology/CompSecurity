// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzb;

// Referenced classes of package android.support.v7:
//            nz, ll

public class oa
    implements com.google.android.gms.ads.formats.NativeAd.Image
{

    private final nz a;
    private final Drawable b;
    private final Uri c;

    public oa(nz nz1)
    {
        Object obj;
        obj = null;
        super();
        a = nz1;
        nz1 = a.zzdr();
        if (nz1 == null)
        {
            break MISSING_BLOCK_LABEL_61;
        }
        nz1 = (Drawable)ll.a(nz1);
_L1:
        b = nz1;
        try
        {
            nz1 = a.getUri();
        }
        // Misplaced declaration of an exception variable
        catch (nz nz1)
        {
            zzb.zzb("Failed to get uri.", nz1);
            nz1 = obj;
        }
        c = nz1;
        return;
        nz1;
        zzb.zzb("Failed to get drawable.", nz1);
        nz1 = null;
          goto _L1
    }

    public Drawable getDrawable()
    {
        return b;
    }

    public Uri getUri()
    {
        return c;
    }
}
