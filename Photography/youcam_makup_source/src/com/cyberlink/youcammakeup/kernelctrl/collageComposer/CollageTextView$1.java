// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.collageComposer;


// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.collageComposer:
//            c, CollageTextView, CollageTextPainter

class a
    implements c
{

    final CollageTextView a;

    public void a(long l)
    {
        if (CollageTextView.a(a) != null)
        {
            CollageTextView.a(a).a(l);
            a.postInvalidate();
        }
    }

    (CollageTextView collagetextview)
    {
        a = collagetextview;
        super();
    }
}
