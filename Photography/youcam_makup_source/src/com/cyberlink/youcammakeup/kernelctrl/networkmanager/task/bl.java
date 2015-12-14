// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.networkmanager.task;

import com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.networkmanager.task:
//            bk

public class bl extends bk
{

    public bl(NetworkManager networkmanager, Collection collection)
    {
        super(networkmanager, collection);
    }

    protected String b()
    {
        return NetworkManager.o();
    }

    protected List c()
    {
        ArrayList arraylist = new ArrayList();
        for (Iterator iterator = a.iterator(); iterator.hasNext(); arraylist.add(new BasicNameValuePair("mkIds", String.valueOf((Long)iterator.next())))) { }
        return arraylist;
    }
}
