// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.tagmanager;


// Referenced classes of package com.google.tagmanager:
//            Container

public static interface pe
{

    public abstract void containerRefreshBegin(Container container, pe pe);

    public abstract void containerRefreshFailure(Container container, pe pe, ilure ilure);

    public abstract void containerRefreshSuccess(Container container, pe pe);
}
