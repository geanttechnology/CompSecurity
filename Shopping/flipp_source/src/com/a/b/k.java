// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.b;

import android.content.ContentResolver;
import android.content.Context;
import android.content.UriMatcher;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.io.InputStream;

// Referenced classes of package com.a.b:
//            d, ao, ba, aj, 
//            ad, n, h, as, 
//            a

final class k extends d
{

    private static final UriMatcher p;
    final Context o;

    k(Context context, ad ad, n n, h h, as as, a a1)
    {
        super(ad, n, h, as, a1);
        o = context;
    }

    private Bitmap a(InputStream inputstream, ao ao1)
    {
        if (inputstream == null)
        {
            return null;
        }
        if (!ao1.a()) goto _L2; else goto _L1
_L1:
        android.graphics.BitmapFactory.Options options;
        InputStream inputstream1;
        options = new android.graphics.BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        inputstream1 = c();
        BitmapFactory.decodeStream(inputstream1, null, options);
        ba.a(inputstream1);
        a(ao1.d, ao1.e, options);
        ao1 = options;
_L4:
        return BitmapFactory.decodeStream(inputstream, null, ao1);
        inputstream;
        ba.a(inputstream1);
        throw inputstream;
_L2:
        ao1 = null;
        if (true) goto _L4; else goto _L3
_L3:
    }

    private InputStream c()
    {
        ContentResolver contentresolver = o.getContentResolver();
        android.net.Uri uri1 = super.g.a;
        android.net.Uri uri = uri1;
        switch (p.match(uri1))
        {
        default:
            throw new IllegalStateException((new StringBuilder("Invalid uri: ")).append(uri1).toString());

        case 1: // '\001'
            uri1 = android.provider.ContactsContract.Contacts.lookupContact(contentresolver, uri1);
            uri = uri1;
            if (uri1 == null)
            {
                return null;
            }
            // fall through

        case 3: // '\003'
            if (android.os.Build.VERSION.SDK_INT < 14)
            {
                return android.provider.ContactsContract.Contacts.openContactPhotoInputStream(contentresolver, uri);
            } else
            {
                return android.provider.ContactsContract.Contacts.openContactPhotoInputStream(contentresolver, uri, true);
            }

        case 2: // '\002'
        case 4: // '\004'
            return contentresolver.openInputStream(uri1);
        }
    }

    final Bitmap a(ao ao1)
    {
        InputStream inputstream = null;
        InputStream inputstream1 = c();
        inputstream = inputstream1;
        ao1 = a(inputstream1, ao1);
        ba.a(inputstream1);
        return ao1;
        ao1;
        ba.a(inputstream);
        throw ao1;
    }

    final aj a()
    {
        return aj.b;
    }

    static 
    {
        UriMatcher urimatcher = new UriMatcher(-1);
        p = urimatcher;
        urimatcher.addURI("com.android.contacts", "contacts/lookup/*/#", 1);
        p.addURI("com.android.contacts", "contacts/lookup/*", 1);
        p.addURI("com.android.contacts", "contacts/#/photo", 2);
        p.addURI("com.android.contacts", "contacts/#", 3);
        p.addURI("com.android.contacts", "display_photo/#", 4);
    }
}
