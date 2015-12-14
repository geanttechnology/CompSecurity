// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.v;

import android.content.Context;
import android.net.Uri;
import myobfuscated.q.b;
import myobfuscated.q.j;

// Referenced classes of package myobfuscated.v:
//            ag, bc, ba, am, 
//            ae

public final class bb
    implements ag, bc
{

    public bb()
    {
    }

    public final b a(Context context, Uri uri)
    {
        return new j(context, uri);
    }

    public final ae build(Context context, am am)
    {
        return new ba(context, this);
    }
}
