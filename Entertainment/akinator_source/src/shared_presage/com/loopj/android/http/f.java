// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.loopj.android.http;


// Referenced classes of package shared_presage.com.loopj.android.http:
//            e, BaseJsonHttpResponseHandler

final class f
    implements Runnable
{

    final Object a;
    final e b;

    f(e e1, Object obj)
    {
        b = e1;
        a = obj;
        super();
    }

    public final void run()
    {
        b.d.onSuccess(b.b, b.c, b.a, a);
    }
}
