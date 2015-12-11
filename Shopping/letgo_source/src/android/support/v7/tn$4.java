// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

// Referenced classes of package android.support.v7:
//            tn

static final class <init> extends <init>
{

    final Context a;
    final a b;

    public void zzdG()
    {
        SharedPreferences sharedpreferences = tn.a(a);
        Bundle bundle = new Bundle();
        bundle.putInt("webview_cache_version", sharedpreferences.getInt("webview_cache_version", 0));
        if (b != null)
        {
            b.a(bundle);
        }
    }

    eferences(Context context, eferences eferences)
    {
        a = context;
        b = eferences;
        super(null);
    }
}
