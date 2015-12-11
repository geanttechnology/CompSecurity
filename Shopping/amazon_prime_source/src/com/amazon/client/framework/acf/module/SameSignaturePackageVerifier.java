// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.framework.acf.module;

import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;
import java.text.MessageFormat;

// Referenced classes of package com.amazon.client.framework.acf.module:
//            PackageVerifier, ModuleLoadException

public class SameSignaturePackageVerifier
    implements PackageVerifier
{

    public SameSignaturePackageVerifier()
    {
    }

    public void verifyPackage(Context context, String s)
        throws ModuleLoadException
    {
        context.getPackageManager().checkSignatures(context.getPackageName(), s);
        JVM INSTR tableswitch -4 1: default 52
    //                   -4 72
    //                   -3 62
    //                   -2 62
    //                   -1 62
    //                   0 110
    //                   1 110;
           goto _L1 _L2 _L3 _L3 _L3 _L4 _L4
_L1:
        throw new ModuleLoadException("Signature check failed - reasons unknown.");
_L3:
        throw new ModuleLoadException("Cannot load a module with a different signature.");
_L2:
        Context context1 = context.getApplicationContext();
        if (context1 == context || context1.getPackageName().equals(context.getPackageName())) goto _L6; else goto _L5
_L5:
        Log.i("Module", "Parent context is not application. Trying to verify against application context.");
        verifyPackage(context1, s);
_L4:
        return;
_L6:
        Log.v("Module", MessageFormat.format("Package {0} not found.", new Object[] {
            s
        }));
        throw new ModuleLoadException(MessageFormat.format("Package {0} not found.", new Object[] {
            s
        }));
    }
}
