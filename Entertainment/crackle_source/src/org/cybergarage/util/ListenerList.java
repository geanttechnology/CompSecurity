// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.cybergarage.util;

import java.util.Vector;

public class ListenerList extends Vector
{

    public ListenerList()
    {
    }

    public boolean add(Object obj)
    {
        if (indexOf(obj) >= 0)
        {
            return false;
        } else
        {
            return super.add(obj);
        }
    }
}
