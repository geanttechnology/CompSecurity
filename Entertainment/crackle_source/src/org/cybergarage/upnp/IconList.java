// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.cybergarage.upnp;

import java.util.Vector;

// Referenced classes of package org.cybergarage.upnp:
//            Icon

public class IconList extends Vector
{

    public static final String ELEM_NAME = "iconList";

    public IconList()
    {
    }

    public Icon getIcon(int i)
    {
        return (Icon)get(i);
    }
}
