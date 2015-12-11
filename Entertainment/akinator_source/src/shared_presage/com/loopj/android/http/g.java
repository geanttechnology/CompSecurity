// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.loopj.android.http;


// Referenced classes of package shared_presage.com.loopj.android.http:
//            e, BaseJsonHttpResponseHandler

final class g
    implements Runnable
{

    final Throwable a;
    final e b;

    g(e e1, Throwable throwable)
    {
        b = e1;
        a = throwable;
        super();
    }

    public final void run()
    {
        b.d.onFailure(b.b, b.c, a, b.a, null);
    }
}
