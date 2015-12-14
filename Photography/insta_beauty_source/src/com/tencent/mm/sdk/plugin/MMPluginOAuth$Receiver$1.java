// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.mm.sdk.plugin;


// Referenced classes of package com.tencent.mm.sdk.plugin:
//            MMPluginOAuth

class bG
    implements Runnable
{

    final MMPluginOAuth bF;
    final String bG;
    final bG bH;

    public void run()
    {
        MMPluginOAuth.a(bF, bG);
    }

    ( , MMPluginOAuth mmpluginoauth, String s)
    {
        bH = ;
        bF = mmpluginoauth;
        bG = s;
        super();
    }
}
