// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.textart;


// Referenced classes of package com.socialin.android.photo.textart:
//            b, TextPreview

final class a
    implements Runnable
{

    private b a;

    public final void run()
    {
        b.f(a, b.c());
        b.a(a).setText(b.a(a).getText());
        b.a(a).invalidate();
    }

    Preview(b b1)
    {
        a = b1;
        super();
    }
}
