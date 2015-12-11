// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.metrics.clickstream;

import java.util.Map;

// Referenced classes of package com.amazon.client.metrics.clickstream:
//            EventBasedUsageInfo

public static class 
{

    private _type _action;
    private Map _keys;
    private String _prefix;
    private String _suffix;
    private String _type;

    public EventBasedUsageInfo build()
    {
        if (_prefix == null || _prefix.length() == 0)
        {
            throw new IllegalArgumentException("prefix can not be null or empty");
        }
        if (_suffix == null || _suffix.length() == 0)
        {
            throw new IllegalArgumentException("suffix can not be null or empty");
        }
        if (_action == null)
        {
            throw new IllegalArgumentException("action can not be null");
        }
        if (_keys != null && (_keys.containsKey(EventBasedUsageInfo.access$000()) || _keys.containsKey(EventBasedUsageInfo.access$100())))
        {
            throw new IllegalArgumentException("Not null keys can not contain action or type as key");
        } else
        {
            return new EventBasedUsageInfo(_prefix, _suffix, _action, _type, _keys, null);
        }
    }

    public _keys withAction(_keys _pkeys)
    {
        _action = _pkeys;
        return this;
    }

    public _action withKeys(Map map)
    {
        _keys = map;
        return this;
    }

    public _keys withPrefix(String s)
    {
        _prefix = s;
        return this;
    }

    public _prefix withSuffix(String s)
    {
        _suffix = s;
        return this;
    }

    public _suffix withType(String s)
    {
        _type = s;
        return this;
    }

    public ()
    {
    }
}
