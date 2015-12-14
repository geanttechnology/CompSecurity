// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.dagger;

import com.amazon.gallery.framework.kindle.amazon.SoftkeyBarManagerFactory;
import com.amazon.gallery.gen5.softkeybar.Gen5SoftkeyBarManagerFactory;

public class ThorSoftkeyBarManagerFactory
    implements SoftkeyBarManagerFactory
{

    private final Gen5SoftkeyBarManagerFactory softkeyBarManagerFactory = new Gen5SoftkeyBarManagerFactory();

    public ThorSoftkeyBarManagerFactory()
    {
    }
}
