// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.util.client.zzb;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.google.android.gms.internal:
//            zziz

public class zzfh
{

    private final String zzAK;
    private final zziz zzoM;

    public zzfh(zziz zziz1)
    {
        this(zziz1, "");
    }

    public zzfh(zziz zziz1, String s)
    {
        zzoM = zziz1;
        zzAK = s;
    }

    public void zza(int i, int j, int k, int l, float f, int i1)
    {
        try
        {
            JSONObject jsonobject = (new JSONObject()).put("width", i).put("height", j).put("maxSizeWidth", k).put("maxSizeHeight", l).put("density", f).put("rotation", i1);
            zzoM.zzb("onScreenInfoChanged", jsonobject);
            return;
        }
        catch (JSONException jsonexception)
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzb("Error occured while obtaining screen information.", jsonexception);
        }
    }

    public void zzak(String s)
    {
        try
        {
            s = (new JSONObject()).put("message", s).put("action", zzAK);
            zzoM.zzb("onError", s);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzb("Error occurred while dispatching error event.", s);
        }
    }

    public void zzal(String s)
    {
        try
        {
            s = (new JSONObject()).put("js", s);
            zzoM.zzb("onReadyEventReceived", s);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzb("Error occured while dispatching ready Event.", s);
        }
    }

    public void zzam(String s)
    {
        try
        {
            s = (new JSONObject()).put("state", s);
            zzoM.zzb("onStateChanged", s);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzb("Error occured while dispatching state change.", s);
        }
    }

    public void zzb(int i, int j, int k, int l)
    {
        try
        {
            JSONObject jsonobject = (new JSONObject()).put("x", i).put("y", j).put("width", k).put("height", l);
            zzoM.zzb("onSizeChanged", jsonobject);
            return;
        }
        catch (JSONException jsonexception)
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzb("Error occured while dispatching size change.", jsonexception);
        }
    }

    public void zzc(int i, int j, int k, int l)
    {
        try
        {
            JSONObject jsonobject = (new JSONObject()).put("x", i).put("y", j).put("width", k).put("height", l);
            zzoM.zzb("onDefaultPositionReceived", jsonobject);
            return;
        }
        catch (JSONException jsonexception)
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzb("Error occured while dispatching default position.", jsonexception);
        }
    }
}
