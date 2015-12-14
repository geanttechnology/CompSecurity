// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.dialogs;

import android.animation.Animator;
import android.graphics.Bitmap;
import android.widget.ImageView;
import com.cyberlink.youcammakeup.utility.ch;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.dialogs:
//            FaceSwitcherDialog

class d extends ch
{

    final smissType a;
    final int b;
    final ImageView c;
    final Bitmap d;
    final FaceSwitcherDialog e;

    public void onAnimationEnd(Animator animator)
    {
        e.a(a, b);
        c.setImageBitmap(null);
        d.recycle();
    }

    smissType(FaceSwitcherDialog faceswitcherdialog, smissType smisstype, int i, ImageView imageview, Bitmap bitmap)
    {
        e = faceswitcherdialog;
        a = smisstype;
        b = i;
        c = imageview;
        d = bitmap;
        super();
    }
}
