// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship.push.iam;


// Referenced classes of package com.urbanairship.push.iam:
//            InAppMessageFragmentFactory, InAppMessageFragment, InAppMessageManager, InAppMessage

class ctory extends InAppMessageFragmentFactory
{

    final InAppMessageManager this$0;

    public InAppMessageFragment createFragment(InAppMessage inappmessage)
    {
        return new InAppMessageFragment();
    }

    ctory()
    {
        this$0 = InAppMessageManager.this;
        super();
    }
}
