// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import org.simpleframework.xml.transform.Matcher;
import org.simpleframework.xml.transform.Transform;

class EmptyMatcher
    implements Matcher
{

    EmptyMatcher()
    {
    }

    public Transform match(Class class1)
        throws Exception
    {
        return null;
    }
}
