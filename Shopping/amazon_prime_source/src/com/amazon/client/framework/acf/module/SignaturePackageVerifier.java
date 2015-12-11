// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.framework.acf.module;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;

// Referenced classes of package com.amazon.client.framework.acf.module:
//            PackageVerifier, ModuleLoadException

public class SignaturePackageVerifier
    implements PackageVerifier
{

    private final String mRequiredPublicSignatures[];

    public SignaturePackageVerifier(String as[])
    {
        mRequiredPublicSignatures = as;
    }

    public void verifyPackage(Context context, String s)
        throws ModuleLoadException
    {
        boolean flag = false;
        context = context.getPackageManager();
        int i;
        try
        {
            context = context.getPackageInfo(s, 64);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new ModuleLoadException(context);
        }
        i = 0;
label0:
        do
        {
            if (i < ((PackageInfo) (context)).signatures.length && !flag)
            {
                Signature signature = ((PackageInfo) (context)).signatures[i];
                String as[] = mRequiredPublicSignatures;
                int k = as.length;
                int j = 0;
                do
                {
label1:
                    {
                        boolean flag1 = flag;
                        if (j < k)
                        {
                            String s1 = as[j];
                            if (!signature.toCharsString().equals(s1))
                            {
                                break label1;
                            }
                            flag1 = true;
                        }
                        i++;
                        flag = flag1;
                        continue label0;
                    }
                    j++;
                } while (true);
            }
            if (!flag)
            {
                throw new ModuleLoadException(String.format("Map engine package %s was not signed with a known key. Refusing to load.", new Object[] {
                    s
                }));
            }
            return;
        } while (true);
    }
}
