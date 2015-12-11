// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift;

import android.os.Bundle;
import android.support.v4.app.f;
import android.view.View;
import com.helpshift.i.s;

// Referenced classes of package com.helpshift:
//            HSReviewFragment

public final class HSReview extends f
{

    public HSReview()
    {
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(new View(this));
        s.a(this);
        bundle = f();
        (new HSReviewFragment()).show(bundle, "hs__review_dialog");
    }
}
