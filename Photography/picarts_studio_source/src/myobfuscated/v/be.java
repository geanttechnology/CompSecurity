// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.v;

import android.net.Uri;
import com.bumptech.glide.load.e;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

// Referenced classes of package myobfuscated.v:
//            ae, t, af

public final class be
    implements ae
{

    private static final Set a = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[] {
        "http", "https"
    })));
    private final ae b;

    public be(ae ae1)
    {
        b = ae1;
    }

    public final af buildLoadData(Object obj, int i, int j, e e)
    {
        obj = new t(((Uri)obj).toString());
        return b.buildLoadData(obj, i, j, e);
    }

    public final boolean handles(Object obj)
    {
        obj = (Uri)obj;
        return a.contains(((Uri) (obj)).getScheme());
    }

}
