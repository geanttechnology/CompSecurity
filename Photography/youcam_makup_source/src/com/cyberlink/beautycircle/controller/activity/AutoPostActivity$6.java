// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.net.Uri;
import android.webkit.MimeTypeMap;
import com.perfectcorp.utility.j;
import java.io.File;
import java.util.ArrayList;
import java.util.Locale;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            AutoPostActivity

class a extends j
{

    final AutoPostActivity a;

    protected volatile Object a(Object obj)
    {
        return a((Void)obj);
    }

    protected ArrayList a(Void void1)
    {
        if (com.cyberlink.beautycircle.controller.activity.AutoPostActivity.j(a) != null) goto _L2; else goto _L1
_L1:
        AutoPostActivity.a(a, new ArrayList());
        File file;
        String s;
        int i;
        int k;
        try
        {
            void1 = (new File(AutoPostActivity.k(a))).listFiles();
            k = void1.length;
        }
        // Misplaced declaration of an exception variable
        catch (Void void1)
        {
            break; /* Loop/switch isn't completed */
        }
        i = 0;
_L3:
        if (i >= k)
        {
            break; /* Loop/switch isn't completed */
        }
        file = void1[i];
        s = MimeTypeMap.getFileExtensionFromUrl(file.getAbsolutePath());
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_142;
        }
        s = MimeTypeMap.getSingleton().getMimeTypeFromExtension(s.toLowerCase(Locale.US));
        if (s.equals("image/jpeg") || s.equals("image/png"))
        {
            com.cyberlink.beautycircle.controller.activity.AutoPostActivity.j(a).add(Uri.parse((new StringBuilder()).append("file://").append(file.getAbsolutePath()).toString()));
        }
        i++;
        continue; /* Loop/switch isn't completed */
        if (true) goto _L3; else goto _L2
_L2:
        return com.cyberlink.beautycircle.controller.activity.AutoPostActivity.j(a);
    }

    (AutoPostActivity autopostactivity)
    {
        a = autopostactivity;
        super();
    }
}
