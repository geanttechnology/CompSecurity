// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.tagmanager;


// Referenced classes of package com.google.tagmanager:
//            Container, LoadCallback

static interface 
{

    public abstract void close();

    public abstract void loadAfterDelay(long l, String s);

    public abstract void setCtfeURLPathAndQuery(String s);

    public abstract void setLoadCallback(LoadCallback loadcallback);
}
