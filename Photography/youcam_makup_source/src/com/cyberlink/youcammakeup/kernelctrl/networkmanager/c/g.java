// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.networkmanager.c;

import com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.k;
import java.io.File;
import java.net.URI;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.networkmanager.c:
//            b

class g extends k
{

    public g(b b1)
    {
        super(b1.a, "PromotionInfo", URI.create(b1.e));
    }

    public static String e()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(NetworkManager.c());
        stringbuilder.append(File.separator);
        stringbuilder.append("PromotionInfo");
        stringbuilder.append(File.separator);
        stringbuilder.append("thumbnail");
        stringbuilder.append(File.separator);
        return stringbuilder.toString();
    }
}
