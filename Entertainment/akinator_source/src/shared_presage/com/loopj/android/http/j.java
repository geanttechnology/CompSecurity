// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.loopj.android.http;


// Referenced classes of package shared_presage.com.loopj.android.http:
//            h, BaseJsonHttpResponseHandler

final class j
    implements Runnable
{

    final h a;

    j(h h1)
    {
        a = h1;
        super();
    }

    public final void run()
    {
        a.e.onFailure(a.b, a.c, a.d, a.a, null);
    }
}
