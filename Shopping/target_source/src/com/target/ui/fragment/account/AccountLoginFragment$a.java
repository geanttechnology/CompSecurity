// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.account;


// Referenced classes of package com.target.ui.fragment.account:
//            AccountLoginFragment

private class <init>
    implements com.target.ui.view.account.View.a
{

    private String account;
    private boolean isValid;
    private String password;
    final AccountLoginFragment this$0;

    static boolean a(.a a1)
    {
        return a1.isValid;
    }

    static String b(isValid isvalid)
    {
        return isvalid.account;
    }

    static String c(account account1)
    {
        return account1.password;
    }

    public void a()
    {
        isValid = false;
    }

    public void a(String s, String s1)
    {
        account = s;
        password = s1;
        isValid = true;
    }

    private .a()
    {
        this$0 = AccountLoginFragment.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
