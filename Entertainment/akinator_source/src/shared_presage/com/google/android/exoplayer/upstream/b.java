// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.android.exoplayer.upstream;

import android.text.TextUtils;
import shared_presage.com.google.android.exoplayer.util.Predicate;
import shared_presage.com.google.android.exoplayer.util.Util;

final class b
    implements Predicate
{

    b()
    {
    }

    public final boolean evaluate(Object obj)
    {
        obj = Util.toLowerInvariant((String)obj);
        return !TextUtils.isEmpty(((CharSequence) (obj))) && (!((String) (obj)).contains("text") || ((String) (obj)).contains("text/vtt")) && !((String) (obj)).contains("html") && !((String) (obj)).contains("xml");
    }
}
