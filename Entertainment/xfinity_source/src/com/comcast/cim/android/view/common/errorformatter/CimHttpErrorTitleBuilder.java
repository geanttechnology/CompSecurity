// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.android.view.common.errorformatter;

import com.comcast.cim.cmasl.http.exceptions.CimHttpException;

public class CimHttpErrorTitleBuilder
{

    public CimHttpErrorTitleBuilder()
    {
    }

    public String buildTitle(String s, CimHttpException cimhttpexception)
    {
        return (new StringBuilder()).append(s).append(getTitleSuffixForThrowable(cimhttpexception)).toString();
    }

    public String getTitleSuffixForThrowable(CimHttpException cimhttpexception)
    {
        return String.format(" :: %d", new Object[] {
            Integer.valueOf(cimhttpexception.getStatusCodeForDisplay())
        });
    }
}
