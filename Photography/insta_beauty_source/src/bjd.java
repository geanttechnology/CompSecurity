// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.net.Uri;
import android.provider.DocumentsContract;
import android.util.Log;
import com.crashlytics.android.Crashlytics;
import com.fotoable.comlib.util.UgentAsyncTask;
import com.instabeauty.application.InstaBeautyApplication;
import java.util.ArrayList;

public class bjd extends UgentAsyncTask
{

    public int a;
    private bje e;
    private ArrayList f;
    private String g;
    private ArrayList h;
    private int i;

    public bjd()
    {
        g = "AsynCropImagsTask";
        a = 612;
        h = new ArrayList();
    }

    public static boolean b(Uri uri)
    {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    public static float c(int j)
    {
        if (j == 6)
        {
            return 90F;
        }
        if (j == 3)
        {
            return 180F;
        }
        return j != 8 ? 0.0F : 270F;
    }

    private ArrayList c(ArrayList arraylist)
    {
        for (int j = 0; j < f.size(); j++)
        {
            arraylist = a((Uri)f.get(j));
            h.add(arraylist);
        }

        return h;
    }

    public static boolean c(Uri uri)
    {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    public static boolean d(Uri uri)
    {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }

    public int a(Context context, Uri uri)
    {
        Object obj;
        int j;
        obj = null;
        j = 1;
        String as[];
        String s;
        if (android.os.Build.VERSION.SDK_INT < 19)
        {
            j = 0;
        }
        if (j == 0)
        {
            break MISSING_BLOCK_LABEL_193;
        }
        if (!DocumentsContract.isDocumentUri(context, uri))
        {
            break MISSING_BLOCK_LABEL_193;
        }
        if (b(uri))
        {
            uri = DocumentsContract.getDocumentId(uri).split(":")[1];
            return a(context, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "_id=?", new String[] {
                uri
            });
        }
        if (c(uri))
        {
            uri = DocumentsContract.getDocumentId(uri);
            return a(context, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(uri).longValue()), null, null);
        }
        if (!d(uri))
        {
            break MISSING_BLOCK_LABEL_209;
        }
        as = DocumentsContract.getDocumentId(uri).split(":");
        s = as[0];
        if (!"image".equals(s)) goto _L2; else goto _L1
_L1:
        uri = android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
_L5:
        return a(context, uri, "_id=?", new String[] {
            as[1]
        });
_L2:
        if (!"video".equals(s)) goto _L4; else goto _L3
_L3:
        uri = android.provider.MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
          goto _L5
_L4:
        uri = obj;
        if (!"audio".equals(s)) goto _L5; else goto _L6
_L6:
        uri = android.provider.MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
          goto _L5
        j = b(context, uri);
        return j;
        context;
        Crashlytics.logException(context);
        return -1;
    }

    public int a(Context context, Uri uri, String s, String as[])
    {
        context = context.getContentResolver().query(uri, new String[] {
            "orientation"
        }, s, as, null);
        if (context == null)
        {
            return -1;
        }
        int j;
        if (!context.moveToFirst())
        {
            break MISSING_BLOCK_LABEL_55;
        }
        j = context.getInt(0);
        context.close();
        return j;
        context.close();
        return -1;
        uri;
        context.close();
        throw uri;
    }

    public Bitmap a(Uri uri)
    {
        Object obj;
        obj = uri.getScheme();
        Log.v(g, (new StringBuilder()).append(g).append(" targetScheme:").append(((String) (obj))).toString());
        if (!((String) (obj)).equalsIgnoreCase("file")) goto _L2; else goto _L1
_L1:
        float f1 = c((new ExifInterface(uri.getPath())).getAttributeInt("Orientation", 1));
        int j = (int)f1;
_L8:
        Log.v("url", uri.toString());
        Log.v("orientation", (new StringBuilder()).append("Orientation : ").append(j).toString());
        obj = yo.a(InstaBeautyApplication.a().b().getContentResolver().openInputStream(uri), InstaBeautyApplication.a().b().getContentResolver().openInputStream(uri), a, a);
        uri = ((Uri) (obj));
        if (((Bitmap) (obj)).getConfig() != android.graphics.Bitmap.Config.ARGB_8888)
        {
            uri = ((Bitmap) (obj)).copy(android.graphics.Bitmap.Config.ARGB_8888, true);
        }
        if (j == -1 || j == 0)
        {
            break MISSING_BLOCK_LABEL_221;
        }
        obj = new Matrix();
        ((Matrix) (obj)).setRotate(j, uri.getWidth(), uri.getHeight());
        uri = Bitmap.createBitmap(uri, 0, 0, uri.getWidth(), uri.getHeight(), ((Matrix) (obj)), true);
        int k;
        k = uri.getWidth();
        j = uri.getHeight();
        if (uri == null)
        {
            break MISSING_BLOCK_LABEL_505;
        }
        if (Math.max(uri.getWidth(), uri.getHeight()) < a)
        {
            break MISSING_BLOCK_LABEL_505;
        }
        f1 = (float)uri.getWidth() / (float)uri.getHeight();
        if (f1 <= 1.0F) goto _L4; else goto _L3
_L3:
        j = k;
        int l;
        if (k > a)
        {
            j = a;
        }
        l = (int)((float)j / f1);
        k = j;
        j = l;
        break MISSING_BLOCK_LABEL_505;
_L11:
        if (k != uri.getWidth()) goto _L6; else goto _L5
_L5:
        l = uri.getHeight();
        if (j != l) goto _L6; else goto _L7
_L7:
        Log.v(g, (new StringBuilder()).append("cropWidth:").append(k).append("cropHeight:").append(j).toString());
        return uri;
        obj;
        j = -1;
          goto _L8
_L2:
        if (((String) (obj)).equalsIgnoreCase("content"))
        {
            if (android.os.Build.VERSION.SDK_INT >= 19)
            {
                j = a(InstaBeautyApplication.a, uri);
            } else
            {
                j = b(InstaBeautyApplication.a().b(), uri);
            }
        } else
        {
            j = -1;
        }
          goto _L8
_L4:
        try
        {
            if (j > a)
            {
                j = a;
            }
            break MISSING_BLOCK_LABEL_564;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj) { }
          goto _L9
_L6:
        obj = Bitmap.createScaledBitmap(uri, k, j, true);
        try
        {
            uri.recycle();
        }
        catch (Exception exception)
        {
            uri = ((Uri) (obj));
            obj = exception;
            continue; /* Loop/switch isn't completed */
        }
        uri = ((Uri) (obj));
          goto _L7
        obj;
        uri = null;
_L9:
        ((Exception) (obj)).printStackTrace();
        return uri;
        obj;
        if (true) goto _L9; else goto _L10
_L10:
        if (k % 2 != 0 || j % 2 != 0)
        {
            int i1 = k;
            if (k % 2 != 0)
            {
                i1 = k - 1;
            }
            k = j;
            if (j % 2 != 0)
            {
                k = j - 1;
            }
            j = k;
            k = i1;
        }
          goto _L11
        k = (int)((float)j * f1);
          goto _L10
    }

    protected transient ArrayList a(ArrayList aarraylist[])
    {
        return c(f);
    }

    protected void a()
    {
        Log.v(g, "start processing");
        if (e != null)
        {
            e.StartProcessing(i);
        }
    }

    public void a(int j)
    {
        i = j;
    }

    public void a(bje bje1)
    {
        e = bje1;
    }

    public void a(ArrayList arraylist)
    {
        f = arraylist;
    }

    protected int b(Context context, Uri uri)
    {
        context = context.getContentResolver().query(uri, new String[] {
            "orientation"
        }, null, null, null);
        if (context == null)
        {
            return -1;
        }
        int j;
        if (!context.moveToFirst())
        {
            break MISSING_BLOCK_LABEL_52;
        }
        j = context.getInt(0);
        context.close();
        return j;
        context.close();
        return -1;
        uri;
        context.close();
        throw uri;
    }

    protected Object b(Object aobj[])
    {
        return a((ArrayList[])aobj);
    }

    public void b(int j)
    {
        a = j;
    }

    protected volatile void b(Object obj)
    {
        b((ArrayList)obj);
    }

    protected void b(ArrayList arraylist)
    {
        Log.v(g, "End processing");
        if (e != null)
        {
            e.DidProcessed(arraylist, i);
        }
    }
}
