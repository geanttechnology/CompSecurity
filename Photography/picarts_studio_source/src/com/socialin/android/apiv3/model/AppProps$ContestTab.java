// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3.model;


// Referenced classes of package com.socialin.android.apiv3.model:
//            AppProps

public class order
{

    public boolean hideAfterSubmit;
    public boolean hideBeforeVoting;
    public boolean isVoting;
    public String order;
    final AppProps this$0;
    public String title;

    public (boolean flag, boolean flag1, boolean flag2, String s, String s1)
    {
        this$0 = AppProps.this;
        super();
        hideAfterSubmit = false;
        hideBeforeVoting = false;
        isVoting = flag;
        hideAfterSubmit = flag1;
        hideBeforeVoting = flag2;
        title = s;
        order = s1;
    }
}
