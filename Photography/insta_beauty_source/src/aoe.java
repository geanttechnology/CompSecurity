// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.fotoable.ad.FotoAdStrategy;
import com.loopj.android.http.AsyncHttpResponseHandler;
import org.apache.http.Header;

class aoe extends AsyncHttpResponseHandler
{

    final String a;
    final aoc b;

    aoe(aoc aoc1, String s)
    {
        b = aoc1;
        a = s;
        super();
    }

    public void onFailure(int i, Header aheader[], byte abyte0[], Throwable throwable)
    {
        Log.v(aoc.h(), "save image failure.");
    }

    public void onSuccess(int i, Header aheader[], byte abyte0[])
    {
        aoc.a(b, abyte0, a);
        b.a.getSharedPreferences(aoc.a(b), 0).edit().putString(aoc.b(b), FotoAdStrategy.getMadFullInfo()).apply();
        Log.v(aoc.h(), "save image success.");
    }
}
