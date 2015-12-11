// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package crittercism.android;

import java.io.OutputStream;
import org.json.JSONArray;

// Referenced classes of package crittercism.android:
//            bg, dm, bu, dg

public final class bt extends bg
{

    public static final bt a = new bt("session_start");
    private String b;
    private String c;
    private String d;

    public bt(String s)
    {
        this(s, dm.a.a());
    }

    private bt(String s, String s1)
    {
        d = bu.a.a();
        String s2 = s;
        if (s.length() > 140)
        {
            s2 = s.substring(0, 140);
        }
        b = s2;
        c = s1;
    }

    public final void a(OutputStream outputstream)
    {
        Object obj = new JSONArray();
        ((JSONArray) (obj)).put(b);
        ((JSONArray) (obj)).put(c);
        obj = ((JSONArray) (obj)).toString();
        (new StringBuilder("BREADCRUMB WRITING ")).append(((String) (obj)));
        dg.b();
        outputstream.write(((String) (obj)).getBytes());
    }

    public final String e()
    {
        return d;
    }

}
