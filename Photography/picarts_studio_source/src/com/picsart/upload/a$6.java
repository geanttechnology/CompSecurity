// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.upload;

import android.text.TextUtils;
import com.socialin.android.picsart.upload.UploadItem;
import com.socialin.android.util.an;
import io.branch.referral.g;
import io.branch.referral.m;

// Referenced classes of package com.picsart.upload:
//            a, b

final class 
    implements g
{

    final b a;
    final a b;

    public final void a(String s, m m)
    {
        if (TextUtils.isEmpty(s))
        {
            if (b.a.e() != null)
            {
                s = (new StringBuilder("http://picsart.com/i/")).append(b.a.e()).toString();
            } else
            {
                s = null;
            }
        }
        (new an(s) {

            private String a;
            private a._cls6 b;

            protected final Object doInBackground(Object aobj[])
            {
                com.picsart.upload.a.a(b.b, b.a, a);
                return Boolean.valueOf(true);
            }

            
            {
                b = a._cls6.this;
                a = s;
                super();
            }
        }).a(new Void[0]);
    }

    il.an(a a1, b b1)
    {
        b = a1;
        a = b1;
        super();
    }
}
