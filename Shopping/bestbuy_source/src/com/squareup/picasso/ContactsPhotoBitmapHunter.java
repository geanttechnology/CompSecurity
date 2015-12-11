// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.picasso;

import android.content.ContentResolver;
import android.content.Context;
import android.content.UriMatcher;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.io.InputStream;

// Referenced classes of package com.squareup.picasso:
//            BitmapHunter, Utils, Request, Picasso, 
//            Dispatcher, Cache, Stats, Action

class ContactsPhotoBitmapHunter extends BitmapHunter
{

    private static final int ID_CONTACT = 3;
    private static final int ID_DISPLAY_PHOTO = 4;
    private static final int ID_LOOKUP = 1;
    private static final int ID_THUMBNAIL = 2;
    private static final UriMatcher matcher;
    final Context context;

    ContactsPhotoBitmapHunter(Context context1, Picasso picasso, Dispatcher dispatcher, Cache cache, Stats stats, Action action)
    {
        super(picasso, dispatcher, cache, stats, action);
        context = context1;
    }

    private Bitmap decodeStream(InputStream inputstream, Request request)
    {
        InputStream inputstream1;
        android.graphics.BitmapFactory.Options options;
        if (inputstream == null)
        {
            return null;
        }
        options = createBitmapOptions(request);
        if (!requiresInSampleSize(options))
        {
            break MISSING_BLOCK_LABEL_50;
        }
        inputstream1 = getInputStream();
        BitmapFactory.decodeStream(inputstream1, null, options);
        Utils.closeQuietly(inputstream1);
        calculateInSampleSize(request.targetWidth, request.targetHeight, options);
        return BitmapFactory.decodeStream(inputstream, null, options);
        inputstream;
        Utils.closeQuietly(inputstream1);
        throw inputstream;
    }

    private InputStream getInputStream()
    {
        ContentResolver contentresolver = context.getContentResolver();
        Uri uri1 = getData().uri;
        Uri uri = uri1;
        switch (matcher.match(uri1))
        {
        default:
            throw new IllegalStateException((new StringBuilder()).append("Invalid uri: ").append(uri1).toString());

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
                return ContactPhotoStreamIcs.get(contentresolver, uri);
            }

        case 2: // '\002'
        case 4: // '\004'
            return contentresolver.openInputStream(uri1);
        }
    }

    Bitmap decode(Request request)
    {
        InputStream inputstream = null;
        InputStream inputstream1 = getInputStream();
        inputstream = inputstream1;
        request = decodeStream(inputstream1, request);
        Utils.closeQuietly(inputstream1);
        return request;
        request;
        Utils.closeQuietly(inputstream);
        throw request;
    }

    Picasso.LoadedFrom getLoadedFrom()
    {
        return Picasso.LoadedFrom.DISK;
    }

    static 
    {
        matcher = new UriMatcher(-1);
        matcher.addURI("com.android.contacts", "contacts/lookup/*/#", 1);
        matcher.addURI("com.android.contacts", "contacts/lookup/*", 1);
        matcher.addURI("com.android.contacts", "contacts/#/photo", 2);
        matcher.addURI("com.android.contacts", "contacts/#", 3);
        matcher.addURI("com.android.contacts", "display_photo/#", 4);
    }

    private class ContactPhotoStreamIcs
    {

        static InputStream get(ContentResolver contentresolver, Uri uri)
        {
            return android.provider.ContactsContract.Contacts.openContactPhotoInputStream(contentresolver, uri, true);
        }

        private ContactPhotoStreamIcs()
        {
        }
    }

}
