// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mixtape.provider;

import android.net.Uri;

// Referenced classes of package com.amazon.mixtape.provider:
//            CloudNodesContract

public static final class 
{

    public static Uri getContentUri(String s, String s1)
    {
        return CloudNodesContract.access$000(s, s1, "account_metadata_states");
    }
}
