// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.dropbox.client2.session;


// Referenced classes of package com.dropbox.client2.session:
//            AppKeyPair

public abstract class Session
{

    public final AppKeyPair a;
    public String b;

    public Session(AppKeyPair appkeypair)
    {
        this(appkeypair, (byte)0);
    }

    private Session(AppKeyPair appkeypair, byte byte0)
    {
        this(appkeypair, AccessType.AUTO);
    }

    private Session(AppKeyPair appkeypair, AccessType accesstype)
    {
        b = null;
        if (appkeypair == null)
        {
            throw new IllegalArgumentException("'appKeyPair' must be non-null");
        }
        if (accesstype == null)
        {
            throw new IllegalArgumentException("'type' must be non-null");
        } else
        {
            a = appkeypair;
            return;
        }
    }

    public final void a(String s)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("'oauth2AccessToken' must be non-null");
        } else
        {
            b = s;
            return;
        }
    }

    /* member class not found */
    class AccessType {}

}
