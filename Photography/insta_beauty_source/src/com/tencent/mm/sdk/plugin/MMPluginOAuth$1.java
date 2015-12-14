// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.mm.sdk.plugin;


// Referenced classes of package com.tencent.mm.sdk.plugin:
//            MMPluginOAuth

class bD
    implements Runnable
{

    final MMPluginOAuth bD;

    public void run()
    {
        if (MMPluginOAuth.b(bD) != null)
        {
            MMPluginOAuth.b(bD).onResult(bD);
        }
    }

    esult(MMPluginOAuth mmpluginoauth)
    {
        bD = mmpluginoauth;
        super();
    }
}
