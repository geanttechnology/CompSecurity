// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

class zzgx
{

    private final String zzBY;
    private int zzDv;
    private String zzF;
    private final List zzGl;
    private final List zzGm;
    private final String zzGn;
    private final String zzGo;
    private final String zzGp;
    private final String zzGq;
    private final boolean zzGr;

    public zzgx(int i, Map map)
    {
        zzF = (String)map.get("url");
        zzGo = (String)map.get("base_uri");
        zzGp = (String)map.get("post_parameters");
        zzGr = parseBoolean((String)map.get("drt_include"));
        zzGn = (String)map.get("activation_overlay_url");
        zzGm = zzat((String)map.get("check_packages"));
        zzBY = (String)map.get("request_id");
        zzGq = (String)map.get("type");
        zzGl = zzat((String)map.get("errors"));
        zzDv = i;
    }

    private static boolean parseBoolean(String s)
    {
        return s != null && (s.equals("1") || s.equals("true"));
    }

    private List zzat(String s)
    {
        if (s == null)
        {
            return null;
        } else
        {
            return Arrays.asList(s.split(","));
        }
    }

    public int getErrorCode()
    {
        return zzDv;
    }

    public String getRequestId()
    {
        return zzBY;
    }

    public String getType()
    {
        return zzGq;
    }

    public String getUrl()
    {
        return zzF;
    }

    public void setUrl(String s)
    {
        zzF = s;
    }

    public List zzfU()
    {
        return zzGl;
    }

    public String zzfV()
    {
        return zzGp;
    }

    public boolean zzfW()
    {
        return zzGr;
    }
}
