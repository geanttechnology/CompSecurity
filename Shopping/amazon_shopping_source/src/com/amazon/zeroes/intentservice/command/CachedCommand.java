// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.zeroes.intentservice.command;

import android.text.TextUtils;
import com.amazon.zeroes.intentservice.persistence.ZeroesCache;

// Referenced classes of package com.amazon.zeroes.intentservice.command:
//            ZeroesCommand

public class CachedCommand
    implements ZeroesCommand
{
    public static class ConversionException extends Exception
    {

        public ConversionException()
        {
        }
    }

    public static interface Converter
    {

        public abstract Object fromString(String s)
            throws ConversionException;

        public abstract String toString(Object obj);
    }


    private final ZeroesCache cache;
    private final long cacheItemAge;
    private final String cacheItemName;
    private final ZeroesCommand command;
    private final Converter converter;

    public CachedCommand(String s, long l, ZeroesCache zeroescache, ZeroesCommand zeroescommand, Converter converter1)
    {
        if (TextUtils.isEmpty(s))
        {
            throw new UnsupportedOperationException("cacheItemName must not be empty");
        }
        if (zeroescache == null)
        {
            throw new NullPointerException("cache must not be null");
        }
        if (zeroescommand == null)
        {
            throw new NullPointerException("command must not be null");
        }
        if (converter1 == null)
        {
            throw new NullPointerException("converter must not be null");
        } else
        {
            cacheItemName = s;
            cacheItemAge = l;
            cache = zeroescache;
            command = zeroescommand;
            converter = converter1;
            return;
        }
    }

    public Object perform()
    {
        Object obj = cache.get(cacheItemName);
        if (obj == null) goto _L2; else goto _L1
_L1:
        obj = converter.fromString(((String) (obj)));
_L4:
        return obj;
        obj;
        cache.invalidate(cacheItemName);
_L2:
        Object obj1 = command.perform();
        obj = obj1;
        if (obj1 != null)
        {
            cache.put(cacheItemName, converter.toString(obj1), cacheItemAge);
            return obj1;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }
}
