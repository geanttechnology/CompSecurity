// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.account;

import com.target.mothership.model.guest.interfaces.Guest;
import com.target.ui.fragment.common.BaseDialogFragment;

public abstract class BaseAccountDialog extends BaseDialogFragment
{
    public static interface a
        extends e
    {
    }

    public static interface b
        extends f
    {
    }

    public static interface c
    {

        public abstract void a(String s);

        public abstract void b(String s);

        public abstract void n_();
    }

    public static interface d
    {

        public abstract c l();
    }

    public static interface e
        extends c
    {

        public abstract void a(Guest guest);

        public abstract void b(Object obj);

        public abstract void c();
    }

    public static interface f
        extends d
    {

        public abstract e n();
    }


    public BaseAccountDialog()
    {
    }
}
