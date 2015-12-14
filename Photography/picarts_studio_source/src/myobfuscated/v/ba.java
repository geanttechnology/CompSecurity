// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.v;

import android.content.Context;
import android.net.Uri;
import com.bumptech.glide.load.e;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import myobfuscated.ai.b;

// Referenced classes of package myobfuscated.v:
//            ae, af, bc

public final class ba
    implements ae
{

    private static final Set a = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[] {
        "file", "android.resource", "content"
    })));
    private final Context b;
    private final bc c;

    public ba(Context context, bc bc1)
    {
        b = context;
        c = bc1;
    }

    public final af buildLoadData(Object obj, int i, int j, e e)
    {
        obj = (Uri)obj;
        return new af(new b(obj), c.a(b, ((Uri) (obj))));
    }

    public final boolean handles(Object obj)
    {
        obj = (Uri)obj;
        return a.contains(((Uri) (obj)).getScheme());
    }

}
