// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.networkmanager.a;

import com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager;
import com.cyberlink.youcammakeup.utility.SkuTemplateUtils;
import java.io.File;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.networkmanager.a:
//            b, e

public class g
    implements b
{

    public g()
    {
    }

    public void a(NetworkManager networkmanager, e e)
    {
    }

    public void a(File file, e e)
    {
        e = ((com.cyberlink.youcammakeup.kernelctrl.sku.g)e).a();
        SkuTemplateUtils.a((new StringBuilder()).append(file.getAbsolutePath()).append(File.separator).toString(), "makeup_template.xml", e, com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType.d);
    }

    public void b(File file, e e)
    {
    }
}
