// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.medialets.advertising;


// Referenced classes of package com.medialets.advertising:
//            DataSource

final class af
    implements Runnable
{

    private DataSource a;

    af(DataSource datasource)
    {
        a = datasource;
        super();
    }

    public final void run()
    {
        DataSource.a(a);
    }
}
