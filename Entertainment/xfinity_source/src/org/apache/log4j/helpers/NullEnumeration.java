// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.log4j.helpers;

import java.util.Enumeration;
import java.util.NoSuchElementException;

public class NullEnumeration
    implements Enumeration
{

    private static final NullEnumeration instance = new NullEnumeration();

    private NullEnumeration()
    {
    }

    public static NullEnumeration getInstance()
    {
        return instance;
    }

    public boolean hasMoreElements()
    {
        return false;
    }

    public Object nextElement()
    {
        throw new NoSuchElementException();
    }

}
