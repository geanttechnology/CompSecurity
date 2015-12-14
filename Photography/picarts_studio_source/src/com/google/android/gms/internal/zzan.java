// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.net.Uri;
import android.view.MotionEvent;

// Referenced classes of package com.google.android.gms.internal:
//            zzao, zzaj

public class zzan
{

    private static final String zznC[] = {
        "/aclk", "/pcs/click"
    };
    private String zznA;
    private String zznB[] = {
        ".doubleclick.net", ".googleadservices.com", ".googlesyndication.com"
    };
    private zzaj zznD;
    private String zzny;
    private String zznz;

    public zzan(zzaj zzaj1)
    {
        zzny = "googleads.g.doubleclick.net";
        zznz = "/pagead/ads";
        zznA = "ad.doubleclick.net";
        zznD = zzaj1;
    }

    private Uri zza(Uri uri, Context context, String s, boolean flag)
    {
        boolean flag1;
        try
        {
            flag1 = zza(uri);
        }
        // Misplaced declaration of an exception variable
        catch (Uri uri)
        {
            throw new zzao("Provided Uri is not in a valid state");
        }
        if (!flag1)
        {
            break MISSING_BLOCK_LABEL_45;
        }
        if (uri.toString().contains("dc_ms="))
        {
            throw new zzao("Parameter already exists: dc_ms");
        }
        break MISSING_BLOCK_LABEL_64;
        if (uri.getQueryParameter("ms") != null)
        {
            throw new zzao("Query parameter already exists: ms");
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_95;
        }
        context = zznD.zzb(context, s);
_L1:
        if (!flag1)
        {
            break MISSING_BLOCK_LABEL_109;
        }
        return zzb(uri, "dc_ms", context);
        context = zznD.zzb(context);
          goto _L1
        uri = zza(uri, "ms", ((String) (context)));
        return uri;
    }

    private Uri zza(Uri uri, String s, String s1)
    {
        String s2 = uri.toString();
        int j = s2.indexOf("&adurl");
        int i = j;
        if (j == -1)
        {
            i = s2.indexOf("?adurl");
        }
        if (i != -1)
        {
            return Uri.parse((new StringBuilder(s2.substring(0, i + 1))).append(s).append("=").append(s1).append("&").append(s2.substring(i + 1)).toString());
        } else
        {
            return uri.buildUpon().appendQueryParameter(s, s1).build();
        }
    }

    private Uri zzb(Uri uri, String s, String s1)
    {
        String s2 = uri.toString();
        int i = s2.indexOf(";adurl");
        if (i != -1)
        {
            return Uri.parse((new StringBuilder(s2.substring(0, i + 1))).append(s).append("=").append(s1).append(";").append(s2.substring(i + 1)).toString());
        } else
        {
            uri = uri.getEncodedPath();
            int j = s2.indexOf(uri);
            return Uri.parse((new StringBuilder(s2.substring(0, uri.length() + j))).append(";").append(s).append("=").append(s1).append(";").append(s2.substring(uri.length() + j)).toString());
        }
    }

    public Uri zza(Uri uri, Context context)
    {
        try
        {
            uri = zza(uri, context, uri.getQueryParameter("ai"), true);
        }
        // Misplaced declaration of an exception variable
        catch (Uri uri)
        {
            throw new zzao("Provided Uri is not in a valid state");
        }
        return uri;
    }

    public void zza(MotionEvent motionevent)
    {
        zznD.zza(motionevent);
    }

    public boolean zza(Uri uri)
    {
        if (uri == null)
        {
            throw new NullPointerException();
        }
        boolean flag;
        try
        {
            flag = uri.getHost().equals(zznA);
        }
        // Misplaced declaration of an exception variable
        catch (Uri uri)
        {
            return false;
        }
        return flag;
    }

    public zzaj zzab()
    {
        return zznD;
    }

    public boolean zzb(Uri uri)
    {
        boolean flag1 = false;
        if (uri == null)
        {
            throw new NullPointerException();
        }
        String as[];
        int i;
        int j;
        boolean flag;
        try
        {
            uri = uri.getHost();
            as = zznB;
            j = as.length;
        }
        // Misplaced declaration of an exception variable
        catch (Uri uri)
        {
            return false;
        }
        i = 0;
        flag = flag1;
        if (i >= j)
        {
            break MISSING_BLOCK_LABEL_58;
        }
        flag = uri.endsWith(as[i]);
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_61;
        }
        flag = true;
        return flag;
        for (i++; false;)
        {
        }

        break MISSING_BLOCK_LABEL_31;
    }

    public boolean zzc(Uri uri)
    {
        boolean flag;
        boolean flag1;
        flag1 = false;
        flag = flag1;
        if (!zzb(uri)) goto _L2; else goto _L1
_L1:
        String as[];
        int i;
        int j;
        as = zznC;
        j = as.length;
        i = 0;
_L7:
        flag = flag1;
        if (i >= j) goto _L2; else goto _L3
_L3:
        String s = as[i];
        if (!uri.getPath().endsWith(s)) goto _L5; else goto _L4
_L4:
        flag = true;
_L2:
        return flag;
_L5:
        i++;
        if (true) goto _L7; else goto _L6
_L6:
    }

}
