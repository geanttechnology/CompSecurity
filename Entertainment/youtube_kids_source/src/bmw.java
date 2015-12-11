// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.util.Base64;
import java.security.SecureRandom;

public final class bmw
{

    private final bml a;
    private volatile SecureRandom b;

    protected bmw()
    {
        a = null;
    }

    public bmw(bml bml1)
    {
        a = (bml)b.a(bml1);
    }

    public final String a(int i)
    {
        byte abyte0[] = new byte[i];
        a().nextBytes(abyte0);
        return Base64.encodeToString(abyte0, 10);
    }

    public final SecureRandom a()
    {
        this;
        JVM INSTR monitorenter ;
        SecureRandom securerandom = b;
        if (securerandom != null)
        {
            break MISSING_BLOCK_LABEL_29;
        }
        Exception exception;
        try
        {
            a.a();
        }
        catch (IllegalStateException illegalstateexception) { }
        b = new SecureRandom();
        securerandom = b;
        this;
        JVM INSTR monitorexit ;
        return securerandom;
        exception;
        throw exception;
    }
}
