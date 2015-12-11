// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.services;


// Referenced classes of package com.abtnprojects.ambatana.services:
//            AppUpdateService

class c
    implements Runnable
{

    final boolean a;
    final String b;
    final int c;
    final AppUpdateService d;

    public void run()
    {
        AppUpdateService.a(d, a, b, c);
    }

    (AppUpdateService appupdateservice, boolean flag, String s, int i)
    {
        d = appupdateservice;
        a = flag;
        b = s;
        c = i;
        super();
    }
}
