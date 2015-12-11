// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.signin;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.internal.h;
import com.google.android.gms.signin.internal.i;
import java.util.concurrent.Executors;

// Referenced classes of package com.google.android.gms.signin:
//            b, e

static final class rnal.i extends com.google.android.gms.common.api..i
{

    public com.google.android.gms.common.api..h a(Context context, Looper looper, h h, Object obj, com.google.android.gms.common.api..h h1, com.google.android.gms.common.api..h h2)
    {
        return a(context, looper, h, (com.google.android.gms.common.api.b)obj, h1, h2);
    }

    public i a(Context context, Looper looper, h h, com.google.android.gms.common.api.b b1, com.google.android.gms.common.api.b b2, com.google.android.gms.common.api.b b3)
    {
        return new i(context, looper, false, h, e.a, b2, b3, Executors.newSingleThreadExecutor());
    }

    rnal.i()
    {
    }
}
