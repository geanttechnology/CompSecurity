// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.picasso;

import android.content.ContentResolver;
import android.net.Uri;
import java.io.InputStream;

// Referenced classes of package com.squareup.picasso:
//            ContactsPhotoBitmapHunter

private static class 
{

    static InputStream get(ContentResolver contentresolver, Uri uri)
    {
        return android.provider.tream(contentresolver, uri, true);
    }

    private ()
    {
    }
}
