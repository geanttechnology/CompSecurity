// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.account;

import com.target.mothership.model.d;
import com.target.mothership.model.guest.interfaces.Guest;
import com.target.mothership.model.guest.interfaces.a.c;

// Referenced classes of package com.target.ui.fragment.account:
//            AuthenticateDialog

class this._cls0 extends d
{

    final AuthenticateDialog this$0;

    public String a()
    {
        return AuthenticateDialog.TAG;
    }

    public void a(Guest guest)
    {
        if (AuthenticateDialog.a(AuthenticateDialog.this) == null)
        {
            return;
        }
        if (AuthenticateDialog.b(AuthenticateDialog.this) != null)
        {
            AuthenticateDialog.a(AuthenticateDialog.this, guest, AuthenticateDialog.b(AuthenticateDialog.this));
            return;
        } else
        {
            AuthenticateDialog.a(AuthenticateDialog.this, guest);
            return;
        }
    }

    public void a(c c1)
    {
        if (AuthenticateDialog.a(AuthenticateDialog.this) == null)
        {
            return;
        } else
        {
            AuthenticateDialog.a(AuthenticateDialog.this, c1);
            return;
        }
    }

    public volatile void a(Object obj)
    {
        a((Guest)obj);
    }

    public void b(Object obj)
    {
        a((c)obj);
    }

    _cls9()
    {
        this$0 = AuthenticateDialog.this;
        super();
    }
}
