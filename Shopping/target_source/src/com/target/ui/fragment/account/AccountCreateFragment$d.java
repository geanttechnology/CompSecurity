// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.account;


// Referenced classes of package com.target.ui.fragment.account:
//            AccountCreateFragment

private final class <init>
    implements com.target.ui.view.account.iew.a
{

    boolean isValid;
    String password;
    final AccountCreateFragment this$0;

    public void a()
    {
        isValid = false;
    }

    public void a(String s)
    {
        isValid = true;
        password = s;
    }

    private a()
    {
        this$0 = AccountCreateFragment.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
