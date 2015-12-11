// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship.push.iam;


// Referenced classes of package com.urbanairship.push.iam:
//            InAppMessage, InAppMessageFragment

public abstract class InAppMessageFragmentFactory
{

    public InAppMessageFragmentFactory()
    {
    }

    public abstract InAppMessageFragment createFragment(InAppMessage inappmessage);
}
