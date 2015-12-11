// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.ContentResolver;
import android.net.Uri;
import java.io.InputStream;

// Referenced classes of package android.support.v7:
//            akk

private static class solver
{

    static InputStream a(ContentResolver contentresolver, Uri uri)
    {
        return android.provider.tsContract.Contacts.openContactPhotoInputStream(contentresolver, uri, true);
    }
}
