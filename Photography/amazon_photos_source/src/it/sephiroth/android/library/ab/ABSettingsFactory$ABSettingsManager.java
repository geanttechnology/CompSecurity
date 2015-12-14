// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package it.sephiroth.android.library.ab;

import java.util.UUID;

// Referenced classes of package it.sephiroth.android.library.ab:
//            ABSettingsFactory

static abstract class I
{

    protected static final String DIR_NAME = "ab";
    protected static final String FILE_NAME = ".alpha-beta";
    protected static final String PREF_NAME = "alphabeta";

    protected final UUID generateNew()
    {
        return UUID.randomUUID();
    }

    public abstract String getUUID();

    I()
    {
    }
}
