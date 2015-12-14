// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.v;

import android.content.res.AssetManager;
import android.net.Uri;
import com.bumptech.glide.load.e;
import java.util.List;
import myobfuscated.ai.b;

// Referenced classes of package myobfuscated.v:
//            ae, af, b

public final class a
    implements ae
{

    private static final int a = 22;
    private final AssetManager b;
    private final myobfuscated.v.b c;

    public a(AssetManager assetmanager, myobfuscated.v.b b1)
    {
        b = assetmanager;
        c = b1;
    }

    public final af buildLoadData(Object obj, int i, int j, e e)
    {
        obj = (Uri)obj;
        e = ((Uri) (obj)).toString().substring(22);
        return new af(new b(obj), c.a(b, e));
    }

    public final boolean handles(Object obj)
    {
        boolean flag1 = false;
        obj = (Uri)obj;
        boolean flag = flag1;
        if ("file".equals(((Uri) (obj)).getScheme()))
        {
            flag = flag1;
            if (!((Uri) (obj)).getPathSegments().isEmpty())
            {
                flag = flag1;
                if ("android_asset".equals(((Uri) (obj)).getPathSegments().get(0)))
                {
                    flag = true;
                }
            }
        }
        return flag;
    }

}
