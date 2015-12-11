// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.hybrid.ad.interfaces;

import android.location.Location;

// Referenced classes of package tv.freewheel.hybrid.ad.interfaces:
//            IAdContext

public interface IAdManager
{

    public abstract IAdContext newContext();

    public abstract IAdContext newContextWithContext(IAdContext iadcontext);

    public abstract void setLocation(Location location);

    public abstract void setNetwork(int i);

    public abstract void setServer(String s);
}
