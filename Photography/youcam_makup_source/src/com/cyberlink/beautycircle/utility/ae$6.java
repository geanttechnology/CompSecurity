// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.utility;

import android.graphics.Bitmap;
import android.net.Uri;
import com.cyberlink.beautycircle.Globals;
import com.perfectcorp.utility.ImageUtils;
import com.perfectcorp.utility.j;
import com.tencent.mm.sdk.openapi.WXMediaMessage;
import com.tencent.mm.sdk.openapi.WXWebpageObject;
import com.tencent.mm.sdk.openapi.k;

// Referenced classes of package com.cyberlink.beautycircle.utility:
//            ae

class e extends j
{

    final Uri a;
    final String b;
    final String c;
    final String d;
    final boolean e;
    final ae f;

    protected k a(Void void1)
    {
        Object obj;
        try
        {
            void1 = ImageUtils.a(Globals.n(), a);
        }
        // Misplaced declaration of an exception variable
        catch (Void void1)
        {
            void1.printStackTrace();
            return null;
        }
        if (void1 == null)
        {
            break MISSING_BLOCK_LABEL_131;
        }
        void1 = Bitmap.createScaledBitmap(void1, ae.c, ae.c, true);
_L1:
        obj = new WXWebpageObject();
        obj.webpageUrl = b;
        obj = new WXMediaMessage(((com.tencent.mm.sdk.openapi.r) (obj)));
        obj.title = c;
        obj.description = d;
        if (void1 == null)
        {
            break MISSING_BLOCK_LABEL_77;
        }
        ((WXMediaMessage) (obj)).setThumbImage(void1);
        void1 = new k();
        void1.a = ae.a(f, "appdata");
        void1.b = ((WXMediaMessage) (obj));
        if (e)
        {
            break MISSING_BLOCK_LABEL_117;
        }
        void1.c = 0;
        return void1;
        void1.c = 1;
        return void1;
        void1 = null;
          goto _L1
    }

    protected volatile Object a(Object obj)
    {
        return a((Void)obj);
    }

    e(ae ae1, Uri uri, String s, String s1, String s2, boolean flag)
    {
        f = ae1;
        a = uri;
        b = s;
        c = s1;
        d = s2;
        e = flag;
        super();
    }
}
