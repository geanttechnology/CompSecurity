// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package amazon.communication.connection;


// Referenced classes of package amazon.communication.connection:
//            ConnectionPolicy

public interface ConnectionPolicyBuilder
{

    public abstract ConnectionPolicy build();

    public abstract ConnectionPolicyBuilder setIsClearText(boolean flag)
        throws IllegalAccessException;

    public abstract ConnectionPolicyBuilder setIsLowLatencyNecessary(boolean flag)
        throws IllegalAccessException;

    public abstract ConnectionPolicyBuilder setIsRequestResponseOnly(boolean flag)
        throws IllegalAccessException;

    public abstract ConnectionPolicyBuilder setIsRoamingAllowed(boolean flag)
        throws IllegalAccessException;

    public abstract ConnectionPolicyBuilder setIsShortLived(boolean flag)
        throws IllegalAccessException;
}
