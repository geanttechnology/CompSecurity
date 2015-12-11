// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.framework.acf.module;

import android.content.Context;
import android.util.Log;

// Referenced classes of package com.amazon.client.framework.acf.module:
//            PackageVerifier, ModuleLoadException, Module

public class AnyPackageVerifier
    implements PackageVerifier
{

    private final PackageVerifier mVerifiers[];

    public transient AnyPackageVerifier(PackageVerifier apackageverifier[])
    {
        mVerifiers = apackageverifier;
    }

    public void verifyPackage(Context context, String s)
        throws ModuleLoadException
    {
        PackageVerifier apackageverifier[] = mVerifiers;
        int j = apackageverifier.length;
        for (int i = 0; i < j; i++)
        {
            PackageVerifier packageverifier = apackageverifier[i];
            try
            {
                packageverifier.verifyPackage(context, s);
                return;
            }
            catch (ModuleLoadException moduleloadexception)
            {
                if (Log.isLoggable(Module.TAG, 3))
                {
                    Log.d(Module.TAG, String.format("AnyPackageVerifier failure: %s", new Object[] {
                        moduleloadexception
                    }));
                }
            }
        }

        throw new ModuleLoadException(String.format("AnyPackageVerifier was not able to verify package \"%s\" using %s verifier(s).", new Object[] {
            s, Integer.toString(mVerifiers.length)
        }));
    }
}
