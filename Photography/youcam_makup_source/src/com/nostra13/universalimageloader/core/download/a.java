// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.core.download;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.util.Log;
import android.webkit.MimeTypeMap;
import com.nostra13.universalimageloader.b.b;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

// Referenced classes of package com.nostra13.universalimageloader.core.download:
//            ImageDownloader

public class a
    implements ImageDownloader
{

    protected final Context a;
    protected final int b;
    protected final int c;

    public a(Context context)
    {
        this(context, 5000, 20000);
    }

    public a(Context context, int i, int j)
    {
        a = context.getApplicationContext();
        b = i;
        c = j;
    }

    private InputStream a(String s)
    {
        if (android.os.Build.VERSION.SDK_INT >= 8)
        {
            s = ThumbnailUtils.createVideoThumbnail(s, 2);
            if (s != null)
            {
                ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
                s.compress(android.graphics.Bitmap.CompressFormat.PNG, 0, bytearrayoutputstream);
                return new ByteArrayInputStream(bytearrayoutputstream.toByteArray());
            }
        }
        return null;
    }

    private boolean a(Uri uri)
    {
        uri = a.getContentResolver().getType(uri);
        return uri != null && uri.startsWith("video/");
    }

    private boolean b(String s)
    {
        s = MimeTypeMap.getFileExtensionFromUrl(s);
        s = MimeTypeMap.getSingleton().getMimeTypeFromExtension(s);
        return s != null && s.startsWith("video/");
    }

    protected HttpURLConnection a(String s, Object obj)
    {
        s = (HttpURLConnection)(new URL(Uri.encode(s, "@#&=*+-_.,:!?()/~'%"))).openConnection();
        s.setConnectTimeout(b);
        s.setReadTimeout(c);
        return s;
    }

    protected boolean a(HttpURLConnection httpurlconnection)
    {
        return httpurlconnection.getResponseCode() == 200;
    }

    public InputStream a_(String s, Object obj)
    {
        class _cls1
        {

            static final int a[];

            static 
            {
                a = new int[ImageDownloader.Scheme.values().length];
                try
                {
                    a[ImageDownloader.Scheme.a.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    a[com.nostra13.universalimageloader.core.download.ImageDownloader.Scheme.b.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    a[ImageDownloader.Scheme.c.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    a[ImageDownloader.Scheme.d.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    a[ImageDownloader.Scheme.e.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[ImageDownloader.Scheme.f.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[ImageDownloader.Scheme.g.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1.a[ImageDownloader.Scheme.a(s).ordinal()])
        {
        default:
            return g(s, obj);

        case 1: // '\001'
        case 2: // '\002'
            return b(s, obj);

        case 3: // '\003'
            return c(s, obj);

        case 4: // '\004'
            return d(s, obj);

        case 5: // '\005'
            return e(s, obj);

        case 6: // '\006'
            return f(s, obj);
        }
    }

    protected InputStream b(String s, Object obj)
    {
        HttpURLConnection httpurlconnection = a(s, obj);
        for (int i = 0; httpurlconnection.getResponseCode() / 100 == 3 && i < 5; i++)
        {
            httpurlconnection = a(httpurlconnection.getHeaderField("Location"), obj);
        }

        try
        {
            obj = httpurlconnection.getInputStream();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            if (s != null)
            {
                Log.e("UIL", (new StringBuilder()).append("Fail URL = ").append(s).toString());
            }
            com.nostra13.universalimageloader.b.b.a(httpurlconnection.getErrorStream());
            throw new IllegalStateException(((Throwable) (obj)));
        }
        if (!a(httpurlconnection))
        {
            com.nostra13.universalimageloader.b.b.a(((java.io.Closeable) (obj)));
            throw new IOException((new StringBuilder()).append("Image request failed with response code ").append(httpurlconnection.getResponseCode()).toString());
        } else
        {
            return new com.nostra13.universalimageloader.core.assist.a(new BufferedInputStream(((InputStream) (obj)), 32768), httpurlconnection.getContentLength());
        }
    }

    protected InputStream c(String s, Object obj)
    {
        obj = ImageDownloader.Scheme.c.c(s);
        if (b(s))
        {
            return a(((String) (obj)));
        } else
        {
            return new com.nostra13.universalimageloader.core.assist.a(new BufferedInputStream(new FileInputStream(((String) (obj))), 32768), (int)(new File(((String) (obj)))).length());
        }
    }

    protected InputStream d(String s, Object obj)
    {
        obj = a.getContentResolver();
        Uri uri = Uri.parse(s);
        if (a(uri))
        {
            s = android.provider.MediaStore.Video.Thumbnails.getThumbnail(((ContentResolver) (obj)), Long.valueOf(uri.getLastPathSegment()).longValue(), 1, null);
            if (s != null)
            {
                obj = new ByteArrayOutputStream();
                s.compress(android.graphics.Bitmap.CompressFormat.PNG, 0, ((java.io.OutputStream) (obj)));
                return new ByteArrayInputStream(((ByteArrayOutputStream) (obj)).toByteArray());
            }
        } else
        if (s.startsWith("content://com.android.contacts/"))
        {
            return android.provider.ContactsContract.Contacts.openContactPhotoInputStream(((ContentResolver) (obj)), uri);
        }
        return ((ContentResolver) (obj)).openInputStream(uri);
    }

    protected InputStream e(String s, Object obj)
    {
        s = ImageDownloader.Scheme.e.c(s);
        return a.getAssets().open(s);
    }

    protected InputStream f(String s, Object obj)
    {
        int i = Integer.parseInt(ImageDownloader.Scheme.f.c(s));
        return a.getResources().openRawResource(i);
    }

    protected InputStream g(String s, Object obj)
    {
        throw new UnsupportedOperationException(String.format("UIL doesn't support scheme(protocol) by default [%s]. You should implement this support yourself (BaseImageDownloader.getStreamFromOtherSource(...))", new Object[] {
            s
        }));
    }
}
