// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.library.filters;

import com.aviary.android.feather.headless.filters.NativeFilter;
import com.aviary.android.feather.headless.moa.MoaAction;
import com.aviary.android.feather.headless.moa.MoaActionList;

public class OverlayFilter extends NativeFilter
{

    OverlayFilter()
    {
        super(new String[] {
            "overlay"
        });
    }

    OverlayFilter(String s, String s1)
    {
        super(new String[] {
            "overlay"
        });
        setSourceDir(s);
        setUrl(s1);
    }

    public final String getSourceDir()
    {
        return (String)getActions().get(0).getValue("source", "");
    }

    public final String getUrl()
    {
        return (String)getActions().get(0).getValue("url", "");
    }

    public void setSourceDir(String s)
    {
        getActions().get(0).setValue("source", s);
    }

    public void setUrl(String s)
    {
        getActions().get(0).setValue("url", s);
    }
}
