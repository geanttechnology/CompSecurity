// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.widget.EditText;
import android.widget.RatingBar;
import com.cyberlink.beautycircle.model.ProductComment;
import com.perfectcorp.utility.e;
import com.perfectcorp.utility.m;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            ProductReviewActivity

class a extends m
{

    final ProductReviewActivity a;

    protected void a(int i)
    {
        a.l();
        e.e(new Object[] {
            "NetworkProduct.listComment: ", Integer.valueOf(i)
        });
    }

    protected void a(com.cyberlink.beautycircle.model.mmentResult mmentresult)
    {
        a.l();
        if (mmentresult == null || mmentresult.userComment == null)
        {
            return;
        } else
        {
            ProductReviewActivity.a(a, true);
            ProductReviewActivity.a(a).setText(mmentresult.userComment.comment);
            ProductReviewActivity.b(a).setRating(mmentresult.userComment.rating);
            return;
        }
    }

    protected void b(Object obj)
    {
        a((com.cyberlink.beautycircle.model.mmentResult)obj);
    }

    (ProductReviewActivity productreviewactivity)
    {
        a = productreviewactivity;
        super();
    }
}
