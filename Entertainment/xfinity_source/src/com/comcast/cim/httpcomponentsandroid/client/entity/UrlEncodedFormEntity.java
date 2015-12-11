// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid.client.entity;

import com.comcast.cim.httpcomponentsandroid.client.utils.URLEncodedUtils;
import com.comcast.cim.httpcomponentsandroid.entity.StringEntity;
import java.io.UnsupportedEncodingException;
import java.util.List;

public class UrlEncodedFormEntity extends StringEntity
{

    public UrlEncodedFormEntity(List list, String s)
        throws UnsupportedEncodingException
    {
        super(URLEncodedUtils.format(list, s), s);
        list = (new StringBuilder()).append("application/x-www-form-urlencoded; charset=");
        if (s == null)
        {
            s = "ISO-8859-1";
        }
        setContentType(list.append(s).toString());
    }
}
