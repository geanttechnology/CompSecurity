// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public final class clp
    implements arb
{

    final clr a;
    private final String b;
    private final clj c;
    private final String d;
    private final Handler e;
    private boolean f;

    public clp(String s, clj clj1, String s1, Handler handler, clr clr1)
    {
        b = (String)b.a(s);
        c = (clj)b.a(clj1);
        d = s1;
        e = (Handler)b.a(handler);
        a = (clr)b.a(clr1);
        f = false;
    }

    public final byte[] a(android.media.MediaDrm.KeyRequest keyrequest)
    {
        String s1 = keyrequest.getDefaultUrl();
        String s = s1;
        if (TextUtils.isEmpty(s1))
        {
            s = b;
        }
        keyrequest = c.a(Uri.parse(s), keyrequest.getData(), d);
        if (((cln) (keyrequest)).c.containsKey("Authorized-Format-Types") && Arrays.asList(((String)((cln) (keyrequest)).c.get("Authorized-Format-Types")).split(",")).contains("HD") && !f)
        {
            e.post(new clq(this));
            f = true;
        }
        return ((cln) (keyrequest)).b;
    }

    public final byte[] a(android.media.MediaDrm.ProvisionRequest provisionrequest)
    {
        Uri uri = Uri.parse(provisionrequest.getDefaultUrl());
        provisionrequest = new String(provisionrequest.getData());
        provisionrequest = uri.buildUpon().appendQueryParameter("signedRequest", provisionrequest).build();
        return c.a(provisionrequest);
    }
}
