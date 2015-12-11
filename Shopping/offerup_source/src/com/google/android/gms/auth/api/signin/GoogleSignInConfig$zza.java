// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import com.google.android.gms.common.api.Scope;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// Referenced classes of package com.google.android.gms.auth.api.signin:
//            GoogleSignInConfig

public final class 
{

    private Account zzQd;
    private boolean zzTi;
    private boolean zzTj;
    private boolean zzTk;
    private String zzTl;
    private Set zzTm;

    public final GoogleSignInConfig zzmc()
    {
        return new GoogleSignInConfig(zzTm, zzQd, zzTi, zzTj, zzTk, zzTl, null);
    }

    public ()
    {
        zzTm = new HashSet(Arrays.asList(new Scope[] {
            GoogleSignInConfig.zzTg
        }));
    }
}
