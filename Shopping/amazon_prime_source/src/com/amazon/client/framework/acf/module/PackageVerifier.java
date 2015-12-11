// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.framework.acf.module;

import android.content.Context;

// Referenced classes of package com.amazon.client.framework.acf.module:
//            ModuleLoadException

public interface PackageVerifier
{

    public abstract void verifyPackage(Context context, String s)
        throws ModuleLoadException;
}
