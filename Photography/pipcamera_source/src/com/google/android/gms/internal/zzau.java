// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IInterface;
import com.google.android.gms.auth.AccountChangeEventsRequest;
import com.google.android.gms.auth.AccountChangeEventsResponse;

public interface zzau
    extends IInterface
{

    public abstract Bundle zza(Account account, String s, Bundle bundle);

    public abstract Bundle zza(String s, Bundle bundle);

    public abstract Bundle zza(String s, String s1, Bundle bundle);

    public abstract AccountChangeEventsResponse zza(AccountChangeEventsRequest accountchangeeventsrequest);
}
