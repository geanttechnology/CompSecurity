// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.cybergarage.upnp.event;

import java.util.Vector;

// Referenced classes of package org.cybergarage.upnp.event:
//            Property

public class PropertyList extends Vector
{

    public static final String ELEM_NAME = "PropertyList";

    public PropertyList()
    {
    }

    public Property getProperty(int i)
    {
        return (Property)get(i);
    }
}
