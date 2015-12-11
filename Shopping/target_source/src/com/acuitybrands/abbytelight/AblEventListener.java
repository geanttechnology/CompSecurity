// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.acuitybrands.abbytelight;


// Referenced classes of package com.acuitybrands.abbytelight:
//            AblError, AblLocation, AblAngle

public interface AblEventListener
{

    public abstract void onAblError(AblError ablerror);

    public abstract void onAblPositionUpdate(AblLocation abllocation, AblAngle ablangle);

    public abstract void onAblSiteEnabled(String s, String s1, boolean flag);
}
