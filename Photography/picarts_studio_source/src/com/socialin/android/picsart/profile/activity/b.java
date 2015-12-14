// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.picsart.profile.activity;

import android.content.Context;
import android.widget.ImageView;
import com.socialin.android.net.d;
import myobfuscated.cd.a;

// Referenced classes of package com.socialin.android.picsart.profile.activity:
//            BlogActivity, a

final class b extends d
{

    private ImageView a;
    private com.socialin.android.apiv3.model.BlogsResponse.Blog b;
    private String c;
    private BlogActivity d;

    public b(BlogActivity blogactivity, ImageView imageview, com.socialin.android.apiv3.model.BlogsResponse.Blog blog, String s)
    {
        d = blogactivity;
        super();
        a = imageview;
        b = blog;
        c = s;
    }

    protected final Integer a(String as[])
    {
        int i = super.a(as).intValue();
        if (i == 1 || i == 2)
        {
            return Integer.valueOf(com.socialin.android.picsart.profile.activity.BlogActivity.a(c, a, b));
        } else
        {
            return Integer.valueOf(i);
        }
    }

    protected final Object doInBackground(Object aobj[])
    {
        return a((String[])aobj);
    }

    protected final void onPostExecute(Object obj)
    {
        obj = (Integer)obj;
        super.onPostExecute(obj);
        if (b.bitmap != null && (((Integer) (obj)).intValue() == 1 || ((Integer) (obj)).intValue() == 2))
        {
            myobfuscated.b.a.setDrawable(a, new a(a.getContext().getResources(), b.bitmap));
        }
        if (BlogActivity.e(d) != null)
        {
            BlogActivity.e(d).notifyDataSetChanged();
        }
    }
}
