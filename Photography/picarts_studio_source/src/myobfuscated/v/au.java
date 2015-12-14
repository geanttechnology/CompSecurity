// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.v;

import android.net.Uri;
import android.text.TextUtils;
import com.bumptech.glide.load.e;
import java.io.File;

// Referenced classes of package myobfuscated.v:
//            ae, af

public final class au
    implements ae
{

    private final ae a;

    public au(ae ae1)
    {
        a = ae1;
    }

    private static Uri a(String s)
    {
        return Uri.fromFile(new File(s));
    }

    public final af buildLoadData(Object obj, int i, int j, e e)
    {
        String s = (String)obj;
        if (TextUtils.isEmpty(s))
        {
            obj = null;
        } else
        if (s.startsWith("/"))
        {
            obj = a(s);
        } else
        {
            Uri uri = Uri.parse(s);
            obj = uri;
            if (uri.getScheme() == null)
            {
                obj = a(s);
            }
        }
        if (obj == null)
        {
            return null;
        } else
        {
            return a.buildLoadData(obj, i, j, e);
        }
    }

    public final volatile boolean handles(Object obj)
    {
        return true;
    }
}
