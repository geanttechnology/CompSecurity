// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.auth.api;

import android.os.Bundle;
import com.google.android.gms.auth.api.credentials.PasswordSpecification;

public final class ation
    implements com.google.android.gms.common.api.ion
{

    private final String zzRY;
    private final PasswordSpecification zzRZ;

    public final Bundle zzly()
    {
        Bundle bundle = new Bundle();
        bundle.putString("consumer_package", zzRY);
        bundle.putParcelable("password_specification", zzRZ);
        return bundle;
    }
}
