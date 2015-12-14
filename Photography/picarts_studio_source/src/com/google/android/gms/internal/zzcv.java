// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.google.android.gms.ads.internal.util.client.zzb;
import java.util.List;

// Referenced classes of package com.google.android.gms.internal:
//            zzcu, zzcn

public class zzcv
    implements NativeCustomTemplateAd
{

    private final zzcu zzxi;

    public zzcv(zzcu zzcu1)
    {
        zzxi = zzcu1;
    }

    public List getAvailableAssetNames()
    {
        List list;
        try
        {
            list = zzxi.getAvailableAssetNames();
        }
        catch (RemoteException remoteexception)
        {
            zzb.zzb("Failed to get available asset names.", remoteexception);
            return null;
        }
        return list;
    }

    public String getCustomTemplateId()
    {
        String s;
        try
        {
            s = zzxi.getCustomTemplateId();
        }
        catch (RemoteException remoteexception)
        {
            zzb.zzb("Failed to get custom template id.", remoteexception);
            return null;
        }
        return s;
    }

    public com.google.android.gms.ads.formats.NativeAd.Image getImage(String s)
    {
        s = zzxi.zzV(s);
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_33;
        }
        s = new zzcn(s);
        return s;
        s;
        zzb.zzb("Failed to get image.", s);
        return null;
    }

    public CharSequence getText(String s)
    {
        try
        {
            s = zzxi.zzU(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            zzb.zzb("Failed to get string.", s);
            return null;
        }
        return s;
    }

    public void performClick(String s)
    {
        try
        {
            zzxi.performClick(s);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            zzb.zzb("Failed to perform click.", s);
        }
    }

    public void recordImpression()
    {
        try
        {
            zzxi.recordImpression();
            return;
        }
        catch (RemoteException remoteexception)
        {
            zzb.zzb("Failed to record impression.", remoteexception);
        }
    }
}
