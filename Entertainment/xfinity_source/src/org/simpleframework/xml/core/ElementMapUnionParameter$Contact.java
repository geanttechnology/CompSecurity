// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import java.lang.reflect.Constructor;
import org.simpleframework.xml.ElementMap;

// Referenced classes of package org.simpleframework.xml.core:
//            ParameterContact, ElementMapUnionParameter

private static class  extends ParameterContact
{

    public String getName()
    {
        return ((ElementMap)label).name();
    }

    public (ElementMap elementmap, Constructor constructor, int i)
    {
        super(elementmap, constructor, i);
    }
}
