// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.g.c;

import android.content.ContentResolver;
import android.content.Context;
import android.content.UriMatcher;
import android.net.Uri;

// Referenced classes of package com.g.c:
//            z, x

final class f extends z
{

    private static final UriMatcher a;
    private final Context b;

    f(Context context)
    {
        b = context;
    }

    public final boolean a(x x1)
    {
        Uri uri = x1.d;
        return "content".equals(uri.getScheme()) && android.provider.ContactsContract.Contacts.CONTENT_URI.getHost().equals(uri.getHost()) && a.match(x1.d) != -1;
    }

    public final z.a b(x x1)
    {
        Uri uri;
        ContentResolver contentresolver;
        contentresolver = b.getContentResolver();
        uri = x1.d;
        x1 = uri;
        a.match(uri);
        JVM INSTR tableswitch 1 4: default 52
    //                   1 76
    //                   2 133
    //                   3 106
    //                   4 133;
           goto _L1 _L2 _L3 _L4 _L3
_L3:
        break MISSING_BLOCK_LABEL_133;
_L1:
        throw new IllegalStateException((new StringBuilder("Invalid uri: ")).append(uri).toString());
_L2:
        uri = android.provider.ContactsContract.Contacts.lookupContact(contentresolver, uri);
        x1 = uri;
        if (uri != null) goto _L4; else goto _L5
_L5:
        x1 = null;
_L6:
        if (x1 != null)
        {
            return new z.a(x1, u.d.b);
        } else
        {
            return null;
        }
_L4:
        if (android.os.Build.VERSION.SDK_INT < 14)
        {
            x1 = android.provider.ContactsContract.Contacts.openContactPhotoInputStream(contentresolver, x1);
        } else
        {
            x1 = android.provider.ContactsContract.Contacts.openContactPhotoInputStream(contentresolver, x1, true);
        }
          goto _L6
        x1 = contentresolver.openInputStream(uri);
          goto _L6
    }

    static 
    {
        UriMatcher urimatcher = new UriMatcher(-1);
        a = urimatcher;
        urimatcher.addURI("com.android.contacts", "contacts/lookup/*/#", 1);
        a.addURI("com.android.contacts", "contacts/lookup/*", 1);
        a.addURI("com.android.contacts", "contacts/#/photo", 2);
        a.addURI("com.android.contacts", "contacts/#", 3);
        a.addURI("com.android.contacts", "display_photo/#", 4);
    }
}
