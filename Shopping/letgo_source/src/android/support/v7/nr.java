// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.client.zzb;

// Referenced classes of package android.support.v7:
//            no, nq

public class nr
{

    public nr()
    {
    }

    public nq a(no no1)
    {
        if (no1 == null)
        {
            throw new IllegalArgumentException("CSI configuration can't be null. ");
        }
        if (!no1.a())
        {
            zzb.v("CsiReporterFactory: CSI is not enabled. No CSI reporter created.");
            return null;
        }
        if (no1.c() == null)
        {
            throw new IllegalArgumentException("Context can't be null. Please set up context in CsiConfiguration.");
        }
        if (TextUtils.isEmpty(no1.d()))
        {
            throw new IllegalArgumentException("AfmaVersion can't be null or empty. Please set up afmaVersion in CsiConfiguration.");
        } else
        {
            return new nq(no1.c(), no1.d(), no1.b(), no1.e());
        }
    }
}
