// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.upload;

import android.content.Context;
import android.text.TextUtils;
import com.socialin.android.apiv3.model.Adress;
import com.socialin.android.facebook.util.FacebookUtils;
import com.socialin.android.facebook.util.a;
import com.socialin.android.picsart.upload.UploadItem;
import com.socialin.android.util.aj;
import io.branch.referral.g;
import io.branch.referral.m;

// Referenced classes of package com.picsart.upload:
//            a

final class 
    implements g
{

    private a a;
    private String b;
    private com.picsart.upload.a c;

    public final void a(String s, m m)
    {
        Object obj;
        String s1;
        String s2;
        int i;
        int j;
        if (!TextUtils.isEmpty(c.a.c()))
        {
            m = (new StringBuilder()).append(c.a.c()).append("\n").toString();
        } else
        {
            m = "";
        }
        obj = (new StringBuilder()).append(m).append(com.picsart.upload.a.d(c).getString(0x7f0805f3)).append(" #PicsArt").toString();
        m = ((m) (obj));
        if (!TextUtils.isEmpty(s))
        {
            m = (new StringBuilder()).append(((String) (obj))).append("\n").append(s).toString();
        }
        obj = a;
        s = c.a.h;
        s1 = c.a.f();
        s2 = b;
        i = c.a.l;
        j = c.a.m;
        if (!FacebookUtils.isSessionValid())
        {
            if (((a) (obj)).a != null)
            {
                ((a) (obj)).a.b();
            }
            return;
        }
        if (s != null)
        {
            s = ((Adress) (s)).venueId;
        } else
        {
            s = null;
        }
        FacebookUtils.postStoryAddPhoto(s1, s2, m, null, i, j, s, ((a) (obj)).b);
    }

    cebook.util.a(com.picsart.upload.a a1, a a2, String s)
    {
        c = a1;
        a = a2;
        b = s;
        super();
    }
}
