// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.cu;

import com.pinterest.pinit.b;
import com.socialin.android.d;

// Referenced classes of package myobfuscated.cu:
//            a

final class b extends b
{

    private a a;

    public final void a()
    {
        super.a();
        d.a(myobfuscated.cu.a.a(a), "PinItListener.onStart");
    }

    public final void a(Exception exception)
    {
        super.a(exception);
        d.b(myobfuscated.cu.a.a(a), "PinItListener.onException", exception);
    }

    public final void a(boolean flag)
    {
        super.a(flag);
        d.a(myobfuscated.cu.a.a(a), "PinItListener.onComplete");
    }

    .d(a a1)
    {
        a = a1;
        super();
    }
}
