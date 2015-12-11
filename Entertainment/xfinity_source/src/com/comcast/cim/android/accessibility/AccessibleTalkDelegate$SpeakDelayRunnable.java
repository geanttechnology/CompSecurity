// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.android.accessibility;


// Referenced classes of package com.comcast.cim.android.accessibility:
//            AccessibleTalkDelegate

private class sayWhat
    implements Runnable
{

    final String sayWhat;
    final AccessibleTalkDelegate this$0;

    public void run()
    {
        speakNow(sayWhat);
    }

    public (String s)
    {
        this$0 = AccessibleTalkDelegate.this;
        super();
        sayWhat = s;
    }
}
