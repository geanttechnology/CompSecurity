// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.branch.referral;


// Referenced classes of package io.branch.referral:
//            PrefHelper, BranchRemoteInterface

class val.message
    implements Runnable
{

    final PrefHelper this$0;
    final String val$message;
    final String val$tag;

    public void run()
    {
        PrefHelper.access$000(PrefHelper.this).sendLog((new StringBuilder()).append(val$tag).append("\t").append(val$message).toString());
    }

    nterface()
    {
        this$0 = final_prefhelper;
        val$tag = s;
        val$message = String.this;
        super();
    }
}
