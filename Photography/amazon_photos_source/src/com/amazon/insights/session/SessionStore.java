// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.insights.session;


// Referenced classes of package com.amazon.insights.session:
//            Session

public interface SessionStore
{

    public abstract Session getSession();

    public abstract void storeSession(Session session);
}
