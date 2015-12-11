// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.internal.fh;

public final class aah extends aag
{

    private final Context a;

    public aah(Context context, fh fh, aaf aaf)
    {
        super(fh, aaf);
        a = context;
    }

    public void c()
    {
    }

    public aan d()
    {
        Object obj = abi.n();
        obj = new uf(((Bundle) (obj)).getString("gads:sdk_core_location"), ((Bundle) (obj)).getString("gads:sdk_core_experiment_id"), ((Bundle) (obj)).getString("gads:block_autoclicks_experiment_id"), ((Bundle) (obj)).getString("gads:spam_app_context:experiment_id"));
        return aav.a(a, ((uf) (obj)), new vs(), new abc());
    }
}
