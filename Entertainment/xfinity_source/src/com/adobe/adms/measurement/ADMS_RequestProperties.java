// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adobe.adms.measurement;

import java.util.Hashtable;

final class ADMS_RequestProperties
{

    private Hashtable _headers;
    private String _url;

    protected ADMS_RequestProperties(String s)
    {
        _headers = new Hashtable();
        s = s.split("\t");
        if (s.length > 0 && s[0].length() > 0)
        {
            _url = s[0];
        }
        int i = 1;
        do
        {
            if (i >= s.length || i + 1 > s.length)
            {
                return;
            }
            String s1 = s[i];
            String s2 = s[i + 1];
            if (s1.trim().length() > 0 && s2.trim().length() > 0)
            {
                _headers.put(s1, s2);
            }
            i += 2;
        } while (true);
    }

    protected Hashtable getHeaders()
    {
        return _headers;
    }

    protected String getUrl()
    {
        return _url;
    }
}
