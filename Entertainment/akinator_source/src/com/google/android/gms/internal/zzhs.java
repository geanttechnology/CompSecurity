// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import java.util.Collections;
import java.util.List;
import org.json.JSONObject;

// Referenced classes of package com.google.android.gms.internal:
//            zziz, zzja, zzee, zzed, 
//            zzen, zzeg

public class zzhs
{
    public static final class zza
    {

        public final int errorCode;
        public final long zzHA;
        public final AdRequestInfoParcel zzHC;
        public final AdResponseParcel zzHD;
        public final JSONObject zzHw;
        public final zzee zzHx;
        public final long zzHz;
        public final AdSizeParcel zzqn;

        public zza(AdRequestInfoParcel adrequestinfoparcel, AdResponseParcel adresponseparcel, zzee zzee, AdSizeParcel adsizeparcel, int i, long l, 
                long l1, JSONObject jsonobject)
        {
            zzHC = adrequestinfoparcel;
            zzHD = adresponseparcel;
            zzHx = zzee;
            zzqn = adsizeparcel;
            errorCode = i;
            zzHz = l;
            zzHA = l1;
            zzHw = jsonobject;
        }
    }


    public final int errorCode;
    public final int orientation;
    public final zziz zzBD;
    public final long zzEJ;
    public final boolean zzEK;
    public final long zzEL;
    public final List zzEM;
    public final String zzEP;
    public final AdRequestParcel zzEn;
    public final String zzEq;
    public final long zzHA;
    public final com.google.android.gms.ads.internal.formats.zzh.zza zzHB;
    public final JSONObject zzHw;
    public final zzee zzHx;
    public final AdSizeParcel zzHy;
    public final long zzHz;
    public final List zzyY;
    public final List zzyZ;
    public final long zzzc;
    public final zzed zzzu;
    public final zzen zzzv;
    public final String zzzw;
    public final zzeg zzzx;

    public zzhs(AdRequestParcel adrequestparcel, zziz zziz1, List list, int i, List list1, List list2, int j, 
            long l, String s, boolean flag, zzed zzed, zzen zzen, String s1, 
            zzee zzee, zzeg zzeg, long l1, AdSizeParcel adsizeparcel, long l2, 
            long l3, long l4, String s2, JSONObject jsonobject, com.google.android.gms.ads.internal.formats.zzh.zza zza1)
    {
        zzEn = adrequestparcel;
        zzBD = zziz1;
        if (list != null)
        {
            adrequestparcel = Collections.unmodifiableList(list);
        } else
        {
            adrequestparcel = null;
        }
        zzyY = adrequestparcel;
        errorCode = i;
        if (list1 != null)
        {
            adrequestparcel = Collections.unmodifiableList(list1);
        } else
        {
            adrequestparcel = null;
        }
        zzyZ = adrequestparcel;
        if (list2 != null)
        {
            adrequestparcel = Collections.unmodifiableList(list2);
        } else
        {
            adrequestparcel = null;
        }
        zzEM = adrequestparcel;
        orientation = j;
        zzzc = l;
        zzEq = s;
        zzEK = flag;
        zzzu = zzed;
        zzzv = zzen;
        zzzw = s1;
        zzHx = zzee;
        zzzx = zzeg;
        zzEL = l1;
        zzHy = adsizeparcel;
        zzEJ = l2;
        zzHz = l3;
        zzHA = l4;
        zzEP = s2;
        zzHw = jsonobject;
        zzHB = zza1;
    }

    public zzhs(zza zza1, zziz zziz1, zzed zzed, zzen zzen, String s, zzeg zzeg, com.google.android.gms.ads.internal.formats.zzh.zza zza2)
    {
        this(zza1.zzHC.zzEn, zziz1, zza1.zzHD.zzyY, zza1.errorCode, zza1.zzHD.zzyZ, zza1.zzHD.zzEM, zza1.zzHD.orientation, zza1.zzHD.zzzc, zza1.zzHC.zzEq, zza1.zzHD.zzEK, zzed, zzen, s, zza1.zzHx, zzeg, zza1.zzHD.zzEL, zza1.zzqn, zza1.zzHD.zzEJ, zza1.zzHz, zza1.zzHA, zza1.zzHD.zzEP, zza1.zzHw, zza2);
    }

    public boolean zzbY()
    {
        if (zzBD == null || zzBD.zzhe() == null)
        {
            return false;
        } else
        {
            return zzBD.zzhe().zzbY();
        }
    }
}
