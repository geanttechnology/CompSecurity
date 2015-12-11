// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.util.Log;
import com.facebook.FacebookContentProvider;
import com.facebook.h;
import com.facebook.k;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

// Referenced classes of package android.support.v7:
//            kc, kb

public final class jw
{
    public static final class a
    {

        private final UUID a;
        private final String b;
        private final String c;
        private Bitmap d;
        private Uri e;
        private boolean f;
        private boolean g;

        static boolean a(a a1)
        {
            return a1.g;
        }

        static UUID b(a a1)
        {
            return a1.a;
        }

        static String c(a a1)
        {
            return a1.c;
        }

        static Bitmap d(a a1)
        {
            return a1.d;
        }

        static Uri e(a a1)
        {
            return a1.e;
        }

        static boolean f(a a1)
        {
            return a1.f;
        }

        public String a()
        {
            return b;
        }

        private a(UUID uuid, Bitmap bitmap, Uri uri)
        {
            boolean flag;
            flag = true;
            super();
            a = uuid;
            d = bitmap;
            e = uri;
            if (uri == null)
            {
                break MISSING_BLOCK_LABEL_165;
            }
            bitmap = uri.getScheme();
            if (!"content".equalsIgnoreCase(bitmap)) goto _L2; else goto _L1
_L1:
            f = true;
            if (uri.getAuthority() == null || uri.getAuthority().startsWith("media"))
            {
                flag = false;
            }
            g = flag;
_L5:
            if (!g)
            {
                bitmap = null;
            } else
            {
                bitmap = UUID.randomUUID().toString();
            }
            c = bitmap;
            if (!g)
            {
                uuid = e.toString();
            } else
            {
                uuid = FacebookContentProvider.a(k.i(), uuid, c);
            }
            b = uuid;
            return;
_L2:
            if (!"file".equalsIgnoreCase(uri.getScheme())) goto _L4; else goto _L3
_L3:
            g = true;
              goto _L5
_L4:
            if (kb.b(uri)) goto _L5; else goto _L6
_L6:
            throw new h((new StringBuilder()).append("Unsupported scheme for media Uri : ").append(bitmap).toString());
            if (bitmap != null)
            {
                g = true;
            } else
            {
                throw new h("Cannot share media without a bitmap or Uri set");
            }
              goto _L5
        }

    }


    private static final String a = android/support/v7/jw.getName();
    private static File b;

    private jw()
    {
    }

    public static a a(UUID uuid, Bitmap bitmap)
    {
        kc.a(uuid, "callId");
        kc.a(bitmap, "attachmentBitmap");
        return new a(uuid, bitmap, null);
    }

    public static a a(UUID uuid, Uri uri)
    {
        kc.a(uuid, "callId");
        kc.a(uri, "attachmentUri");
        return new a(uuid, null, uri);
    }

    static File a()
    {
        android/support/v7/jw;
        JVM INSTR monitorenter ;
        File file;
        if (b == null)
        {
            b = new File(k.f().getCacheDir(), "com.facebook.NativeAppCallAttachmentStore.files");
        }
        file = b;
        android/support/v7/jw;
        JVM INSTR monitorexit ;
        return file;
        Exception exception;
        exception;
        throw exception;
    }

    public static File a(UUID uuid, String s)
        throws FileNotFoundException
    {
        if (kb.a(s) || uuid == null)
        {
            throw new FileNotFoundException();
        }
        try
        {
            uuid = a(uuid, s, false);
        }
        // Misplaced declaration of an exception variable
        catch (UUID uuid)
        {
            throw new FileNotFoundException();
        }
        return uuid;
    }

    static File a(UUID uuid, String s, boolean flag)
        throws IOException
    {
        uuid = a(uuid, flag);
        if (uuid == null)
        {
            return null;
        }
        try
        {
            uuid = new File(uuid, URLEncoder.encode(s, "UTF-8"));
        }
        // Misplaced declaration of an exception variable
        catch (UUID uuid)
        {
            return null;
        }
        return uuid;
    }

    static File a(UUID uuid, boolean flag)
    {
        if (b == null)
        {
            uuid = null;
        } else
        {
            File file = new File(b, uuid.toString());
            uuid = file;
            if (flag)
            {
                uuid = file;
                if (!file.exists())
                {
                    file.mkdirs();
                    return file;
                }
            }
        }
        return uuid;
    }

    private static void a(Bitmap bitmap, File file)
        throws IOException
    {
        file = new FileOutputStream(file);
        bitmap.compress(android.graphics.Bitmap.CompressFormat.JPEG, 100, file);
        kb.a(file);
        return;
        bitmap;
        kb.a(file);
        throw bitmap;
    }

    private static void a(Uri uri, boolean flag, File file)
        throws IOException
    {
        file = new FileOutputStream(file);
        if (flag)
        {
            break MISSING_BLOCK_LABEL_36;
        }
        uri = new FileInputStream(uri.getPath());
_L1:
        kb.a(uri, file);
        kb.a(file);
        return;
        uri = k.f().getContentResolver().openInputStream(uri);
          goto _L1
        uri;
        kb.a(file);
        throw uri;
    }

    public static void a(Collection collection)
    {
        if (collection != null && collection.size() != 0) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Object obj;
        if (b == null)
        {
            c();
        }
        b();
        obj = new ArrayList();
        collection = collection.iterator();
        do
        {
            if (!collection.hasNext())
            {
                break;
            }
            Object obj1 = (a)collection.next();
            if (!a.a(((a) (obj1))))
            {
                continue;
            }
            File file = a(a.b(((a) (obj1))), a.c(((a) (obj1))), true);
            ((List) (obj)).add(file);
            if (a.d(((a) (obj1))) != null)
            {
                a(a.d(((a) (obj1))), file);
                continue;
            }
            try
            {
                if (a.e(((a) (obj1))) != null)
                {
                    a(a.e(((a) (obj1))), a.f(((a) (obj1))), file);
                }
            }
            // Misplaced declaration of an exception variable
            catch (Collection collection)
            {
                Log.e(a, (new StringBuilder()).append("Got unexpected exception:").append(collection).toString());
                for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext();)
                {
                    obj1 = (File)((Iterator) (obj)).next();
                    try
                    {
                        ((File) (obj1)).delete();
                    }
                    // Misplaced declaration of an exception variable
                    catch (Object obj1) { }
                }

                break MISSING_BLOCK_LABEL_194;
            }
        } while (true);
        if (true) goto _L1; else goto _L3
_L3:
        throw new h(collection);
    }

    public static void a(UUID uuid)
    {
        uuid = a(uuid, false);
        if (uuid != null)
        {
            kb.a(uuid);
        }
    }

    static File b()
    {
        File file = a();
        file.mkdirs();
        return file;
    }

    public static void c()
    {
        kb.a(a());
    }

}
