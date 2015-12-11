// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.text.TextUtils;
import com.google.android.gms.internal.fj;
import com.google.android.gms.internal.gs;
import com.google.android.gms.internal.gu;

public class ahn
    implements ahm
{

    private final abe a;
    private final gu b;

    public ahn(abe abe1, gu gu1)
    {
        a = abe1;
        b = gu1;
    }

    public void a(String s)
    {
        acb.a("An auto-clicking creative is blocked");
        android.net.Uri.Builder builder = new android.net.Uri.Builder();
        builder.scheme("https");
        builder.path("//pagead2.googlesyndication.com/pagead/gen_204");
        builder.appendQueryParameter("id", "gmob-apps-blocked-navigation");
        if (!TextUtils.isEmpty(s))
        {
            builder.appendQueryParameter("navigationURL", s);
        }
        if (a != null && a.b != null && !TextUtils.isEmpty(a.b.o))
        {
            builder.appendQueryParameter("debugDialog", a.b.o);
        }
        abq.a(b.getContext(), b.i().b, builder.toString());
    }
}
