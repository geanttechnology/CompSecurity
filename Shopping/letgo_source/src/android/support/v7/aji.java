// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

// Referenced classes of package android.support.v7:
//            ajj, aiq, ajs

public class aji
    implements ajj
{

    protected final Context a;
    protected final int b;
    protected final int c;

    public aji(Context context)
    {
        a = context.getApplicationContext();
        b = 5000;
        c = 20000;
    }

    public aji(Context context, int i, int j)
    {
        a = context.getApplicationContext();
        b = i;
        c = j;
    }

    private boolean a(Uri uri)
    {
        uri = a.getContentResolver().getType(uri);
        if (uri == null)
        {
            return false;
        } else
        {
            return uri.startsWith("video/");
        }
    }

    public InputStream a(String s, Object obj)
        throws IOException
    {
        static class _cls1
        {

            static final int a[];

            static 
            {
                a = new int[ajj.a.values().length];
                try
                {
                    a[ajj.a.a.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    a[ajj.a.b.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    a[ajj.a.c.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    a[ajj.a.d.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    a[ajj.a.e.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[ajj.a.f.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[ajj.a.g.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1.a[ajj.a.a(s).ordinal()])
        {
        default:
            return h(s, obj);

        case 1: // '\001'
        case 2: // '\002'
            return b(s, obj);

        case 3: // '\003'
            return d(s, obj);

        case 4: // '\004'
            return e(s, obj);

        case 5: // '\005'
            return f(s, obj);

        case 6: // '\006'
            return g(s, obj);
        }
    }

    protected InputStream b(String s, Object obj)
        throws IOException
    {
        s = c(s, obj);
        for (int i = 0; s.getResponseCode() / 100 == 3 && i < 5; i++)
        {
            s = c(s.getHeaderField("Location"), obj);
        }

        try
        {
            obj = s.getInputStream();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ajs.a(s.getErrorStream());
            throw obj;
        }
        return new aiq(new BufferedInputStream(((InputStream) (obj)), 32768), s.getContentLength());
    }

    protected HttpURLConnection c(String s, Object obj)
        throws IOException
    {
        s = (HttpURLConnection)(new URL(Uri.encode(s, "@#&=*+-_.,:!?()/~'%"))).openConnection();
        s.setConnectTimeout(b);
        s.setReadTimeout(c);
        return s;
    }

    protected InputStream d(String s, Object obj)
        throws IOException
    {
        s = ajj.a.c.c(s);
        return new aiq(new BufferedInputStream(new FileInputStream(s), 32768), (int)(new File(s)).length());
    }

    protected InputStream e(String s, Object obj)
        throws FileNotFoundException
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

    protected InputStream f(String s, Object obj)
        throws IOException
    {
        s = ajj.a.e.c(s);
        return a.getAssets().open(s);
    }

    protected InputStream g(String s, Object obj)
    {
        int i = Integer.parseInt(ajj.a.f.c(s));
        return a.getResources().openRawResource(i);
    }

    protected InputStream h(String s, Object obj)
        throws IOException
    {
        throw new UnsupportedOperationException(String.format("UIL doesn't support scheme(protocol) by default [%s]. You should implement this support yourself (BaseImageDownloader.getStreamFromOtherSource(...))", new Object[] {
            s
        }));
    }
}
