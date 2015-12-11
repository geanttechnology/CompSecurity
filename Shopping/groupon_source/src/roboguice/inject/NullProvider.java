// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package roboguice.inject;

import com.google.inject.Provider;

public class NullProvider
    implements Provider
{

    static NullProvider instance = new NullProvider();

    public NullProvider()
    {
    }

    public static NullProvider instance()
    {
        return instance;
    }

    public Object get()
    {
        return null;
    }

}
