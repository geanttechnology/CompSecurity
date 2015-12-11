// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.loopj.android.http;


// Referenced classes of package shared_presage.com.loopj.android.http:
//            h, BaseJsonHttpResponseHandler

final class i
    implements Runnable
{

    final Object a;
    final h b;

    i(h h1, Object obj)
    {
        b = h1;
        a = obj;
        super();
    }

    public final void run()
    {
        b.e.onFailure(b.b, b.c, b.d, b.a, a);
    }
}
