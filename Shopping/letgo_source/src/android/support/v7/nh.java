// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import java.util.Collections;
import java.util.List;

// Referenced classes of package android.support.v7:
//            ni

public class nh
    implements ni
{

    public nh()
    {
    }

    public List a(AdRequestInfoParcel adrequestinfoparcel)
    {
        if (adrequestinfoparcel.zzDR == null)
        {
            return Collections.emptyList();
        } else
        {
            return adrequestinfoparcel.zzDR;
        }
    }
}
