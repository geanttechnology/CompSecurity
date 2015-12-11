// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.cybergarage.upnp;

import java.util.Vector;

// Referenced classes of package org.cybergarage.upnp:
//            Action

public class ActionList extends Vector
{

    public static final String ELEM_NAME = "actionList";

    public ActionList()
    {
    }

    public Action getAction(int i)
    {
        return (Action)get(i);
    }
}
