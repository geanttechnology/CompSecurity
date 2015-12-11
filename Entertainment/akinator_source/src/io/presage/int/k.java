// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage.int;

import android.content.Context;
import android.content.SharedPreferences;
import io.presage.Presage;
import io.presage.utils.do.a;
import io.presage.utils.do.do.b;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

// Referenced classes of package io.presage.int:
//            b, g

public final class k extends io.presage.int.b
    implements g
{

    private a a;

    public k(String s)
    {
        super(s);
        a = Presage.getInstance().getWS();
    }

    public final void a(b b1)
    {
        b1 = a().get(c()).toString();
        SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
        long l;
        try
        {
            b1 = simpledateformat.parse(b1);
        }
        // Misplaced declaration of an exception variable
        catch (b b1)
        {
            b1.printStackTrace();
            b1 = null;
        }
        l = 0L;
        if (b1 != null)
        {
            l = ((new Date()).getTime() - b1.getTime()) / 1000L;
        }
        a.a(l);
        b1 = Presage.getInstance().getContext().getSharedPreferences("presage", 0).edit();
        b1.putLong("timestampOffset", l);
        b1.commit();
    }
}
