// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.c.a.b.d;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

// Referenced classes of package com.c.a.b.d:
//            b, c

public class a
    implements b
{

    protected final Context a;
    protected final int b = 5000;
    protected final int c = 20000;

    public a(Context context)
    {
        a = context.getApplicationContext();
    }

    public InputStream a(String s, Object obj)
    {
        class _cls1
        {

            static final int a[];

            static 
            {
                a = new int[com.c.a.b.d.c.values().length];
                try
                {
                    a[c.a.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    a[c.b.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    a[c.c.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    a[c.d.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    a[c.e.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[c.f.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[c.g.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1.a[com.c.a.b.d.c.a(s).ordinal()])
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
    {
        s = c(s, obj);
        for (int i = 0; s.getResponseCode() / 100 == 3 && i < 5; i++)
        {
            s = c(s.getHeaderField("Location"), obj);
        }

        return new BufferedInputStream(s.getInputStream(), 32768);
    }

    protected HttpURLConnection c(String s, Object obj)
    {
        s = (HttpURLConnection)(new URL(Uri.encode(s, "@#&=*+-_.,:!?()/~'%"))).openConnection();
        s.setConnectTimeout(b);
        s.setReadTimeout(c);
        return s;
    }

    protected InputStream d(String s, Object obj)
    {
        return new BufferedInputStream(new FileInputStream(c.c.c(s)), 32768);
    }

    protected InputStream e(String s, Object obj)
    {
        return a.getContentResolver().openInputStream(Uri.parse(s));
    }

    protected InputStream f(String s, Object obj)
    {
        s = c.e.c(s);
        return a.getAssets().open(s);
    }

    protected InputStream g(String s, Object obj)
    {
        int i = Integer.parseInt(c.f.c(s));
        s = ((BitmapDrawable)a.getResources().getDrawable(i)).getBitmap();
        obj = new ByteArrayOutputStream();
        s.compress(android.graphics.Bitmap.CompressFormat.PNG, 0, ((java.io.OutputStream) (obj)));
        return new ByteArrayInputStream(((ByteArrayOutputStream) (obj)).toByteArray());
    }

    protected InputStream h(String s, Object obj)
    {
        throw new UnsupportedOperationException(String.format("UIL doesn't support scheme(protocol) by default [%s]. You should implement this support yourself (BaseImageDownloader.getStreamFromOtherSource(...))", new Object[] {
            s
        }));
    }
}
