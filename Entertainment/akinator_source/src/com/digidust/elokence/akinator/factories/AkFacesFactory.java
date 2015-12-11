// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.factories;


// Referenced classes of package com.digidust.elokence.akinator.factories:
//            AkPlayerBelongingsFactory

public class AkFacesFactory
{

    private static AkFacesFactory _instance;

    public AkFacesFactory()
    {
    }

    public static AkFacesFactory sharedInstance()
    {
        if (_instance == null)
        {
            _instance = new AkFacesFactory();
        }
        return _instance;
    }

    public boolean deposit(int i)
    {
        return AkPlayerBelongingsFactory.sharedInstance().depositFaces(i);
    }

    public int getBalance()
    {
        return AkPlayerBelongingsFactory.sharedInstance().getFacesBalance();
    }

    public void reset()
    {
        AkPlayerBelongingsFactory.sharedInstance().resetFaces();
    }

    public boolean withdraw()
    {
        return AkPlayerBelongingsFactory.sharedInstance().withdrawFaces();
    }
}
