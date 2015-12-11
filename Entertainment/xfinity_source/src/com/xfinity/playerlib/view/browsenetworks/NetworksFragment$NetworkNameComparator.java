// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.browsenetworks;

import com.xfinity.playerlib.model.tags.Network;
import java.util.Comparator;

// Referenced classes of package com.xfinity.playerlib.view.browsenetworks:
//            NetworksFragment

public static class 
    implements Comparator
{

    public int compare(Network network, Network network1)
    {
        return network.getName().compareToIgnoreCase(network1.getName());
    }

    public volatile int compare(Object obj, Object obj1)
    {
        return compare((Network)obj, (Network)obj1);
    }

    public ()
    {
    }
}
