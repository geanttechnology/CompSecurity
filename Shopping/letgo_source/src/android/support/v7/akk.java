// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.ContentResolver;
import android.content.Context;
import android.content.UriMatcher;
import android.net.Uri;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

// Referenced classes of package android.support.v7:
//            ald, alb

class akk extends ald
{
    private static class a
    {

        static InputStream a(ContentResolver contentresolver, Uri uri)
        {
            return android.provider.ContactsContract.Contacts.openContactPhotoInputStream(contentresolver, uri, true);
        }
    }


    private static final UriMatcher b;
    final Context a;

    akk(Context context)
    {
        a = context;
    }

    private InputStream b(alb alb1)
        throws IOException
    {
        ContentResolver contentresolver = a.getContentResolver();
        Uri uri = alb1.d;
        alb1 = uri;
        switch (b.match(uri))
        {
        default:
            throw new IllegalStateException((new StringBuilder()).append("Invalid uri: ").append(uri).toString());

        case 1: // '\001'
            uri = android.provider.ContactsContract.Contacts.lookupContact(contentresolver, uri);
            alb1 = uri;
            if (uri == null)
            {
                return null;
            }
            // fall through

        case 3: // '\003'
            if (android.os.Build.VERSION.SDK_INT < 14)
            {
                return android.provider.ContactsContract.Contacts.openContactPhotoInputStream(contentresolver, alb1);
            } else
            {
                return a.a(contentresolver, alb1);
            }

        case 2: // '\002'
        case 4: // '\004'
            return contentresolver.openInputStream(uri);
        }
    }

    public ald.a a(alb alb1, int i)
        throws IOException
    {
        return new ald.a(b(alb1), aky.d.b);
    }

    public boolean a(alb alb1)
    {
        alb1 = alb1.d;
        return "content".equals(alb1.getScheme()) && android.provider.ContactsContract.Contacts.CONTENT_URI.getHost().equals(alb1.getHost()) && !alb1.getPathSegments().contains("photo");
    }

    static 
    {
        b = new UriMatcher(-1);
        b.addURI("com.android.contacts", "contacts/lookup/*/#", 1);
        b.addURI("com.android.contacts", "contacts/lookup/*", 1);
        b.addURI("com.android.contacts", "contacts/#/photo", 2);
        b.addURI("com.android.contacts", "contacts/#", 3);
        b.addURI("com.android.contacts", "display_photo/#", 4);
    }
}
