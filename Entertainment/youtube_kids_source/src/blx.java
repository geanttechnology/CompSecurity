// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.accounts.AuthenticatorException;
import android.content.Context;
import android.util.Pair;
import java.io.IOException;
import java.net.SocketException;
import org.apache.http.client.HttpResponseException;

public class blx
{

    final Context a;
    final bkn b;

    public blx(Context context, bkn bkn1)
    {
        a = (Context)b.a(context);
        b = (bkn)b.a(bkn1);
    }

    public String a(Throwable throwable)
    {
        return (String)b(throwable).first;
    }

    public Pair b(Throwable throwable)
    {
        if (throwable == null)
        {
            return Pair.create(a.getString(0x7f0b00ec), "genericError");
        }
        if (throwable instanceof bmn)
        {
            return ((bmn)throwable).a(a);
        }
        if (throwable instanceof AuthenticatorException)
        {
            return Pair.create(a.getString(0x7f0b00ed), "authenticator");
        }
        if (throwable instanceof SocketException)
        {
            if (b.a())
            {
                return Pair.create(a.getString(0x7f0b00ee), "connection");
            } else
            {
                return Pair.create(a.getString(0x7f0b00ef), "noNetwork");
            }
        }
        if (throwable instanceof HttpResponseException)
        {
            throwable = (HttpResponseException)throwable;
            return a.a(a, throwable);
        }
        if (throwable instanceof mp)
        {
            mp mp1 = (mp)throwable;
            mb mb1 = mp1.a;
            if (mb1 != null && mb1.a > 0)
            {
                int i = mb1.a;
                throwable = (new StringBuilder(21)).append("httpError ").append(i).toString();
                if (mp1.a.a == 403)
                {
                    return Pair.create(a.getString(0x7f0b00e8), throwable);
                } else
                {
                    return Pair.create(a.getString(0x7f0b00e9, new Object[] {
                        Integer.valueOf(mb1.a)
                    }), throwable);
                }
            }
        }
        if (throwable instanceof IOException)
        {
            if (b.a())
            {
                return Pair.create(a.getString(0x7f0b00f0), "genericNetworkError");
            } else
            {
                return Pair.create(a.getString(0x7f0b00ef), "noNetwork");
            }
        } else
        {
            return b(throwable.getCause());
        }
    }
}
