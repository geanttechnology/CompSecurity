// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.net.Uri;
import android.util.DisplayMetrics;
import android.util.Log;
import java.util.Date;

public class nr extends nm
{

    private String a;
    private mu b;

    public nr(mu mu1)
    {
        a = "MediaStoreFileOperation";
        b = mu1;
    }

    public int a()
    {
        return b.f();
    }

    public Bitmap a(Context context, int l, int i1)
    {
        float f;
        android.graphics.BitmapFactory.Options options;
        int j1;
        long l1;
        f = context.getResources().getDisplayMetrics().density;
        options = new android.graphics.BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        options.inSampleSize = ev.a(options, l, l);
        b(context);
        a(context);
        j1 = a();
        Log.v(a, (new StringBuilder()).append(a).append(" orientation :").append(j1).toString());
        l1 = Long.parseLong(b.c());
        if (!context.getSharedPreferences("isNewphotoAlbumStyle", 0).getBoolean("needRefresh", false)) goto _L2; else goto _L1
_L1:
        String as[] = new String[1];
        as[0] = "_data";
        Object obj = context.getContentResolver().query(i(), as, null, null, null);
        Bitmap bitmap;
        Object obj1;
        if (obj != null && ((Cursor) (obj)).getCount() > 0)
        {
            ((Cursor) (obj)).moveToFirst();
            String s = ((Cursor) (obj)).getString(((Cursor) (obj)).getColumnIndex(as[0]));
            ((Cursor) (obj)).close();
            if (gb.f())
            {
                if (ew.m(context) > ew.a);
            }
            obj = ev.a(s, l, i1, true);
        } else
        {
            obj = null;
        }
        bitmap = ((Bitmap) (obj));
        if (obj == null) goto _L4; else goto _L3
_L3:
        context = ((Context) (obj));
        if (j1 != -1)
        {
            context = ((Context) (obj));
            if (j1 != 0)
            {
                context = new Matrix();
                context.setRotate(j1, ((Bitmap) (obj)).getWidth(), ((Bitmap) (obj)).getHeight());
                context = Bitmap.createBitmap(((Bitmap) (obj)), 0, 0, ((Bitmap) (obj)).getWidth(), ((Bitmap) (obj)).getHeight(), context, true);
                ((Bitmap) (obj)).recycle();
            }
        }
_L6:
        return context;
_L2:
        bitmap = null;
_L4:
        if (gb.f())
        {
            obj = bitmap;
            if (ew.m(context) > ew.a)
            {
                break; /* Loop/switch isn't completed */
            }
        }
        obj1 = bitmap;
        if ((float)l <= 160F * f)
        {
            obj1 = bitmap;
            if ((float)i1 <= 160F * f)
            {
                obj1 = bitmap;
                if (l1 >= 0L)
                {
                    obj = android.provider.MediaStore.Images.Thumbnails.getThumbnail(context.getContentResolver(), l1, 3, null);
                    obj1 = obj;
                    if (obj != null)
                    {
                        context = ((Context) (obj));
                        if (j1 != -1)
                        {
                            context = ((Context) (obj));
                            if (j1 != 0)
                            {
                                context = new Matrix();
                                context.setRotate(j1, ((Bitmap) (obj)).getWidth(), ((Bitmap) (obj)).getHeight());
                                context = Bitmap.createBitmap(((Bitmap) (obj)), 0, 0, ((Bitmap) (obj)).getWidth(), ((Bitmap) (obj)).getHeight(), context, true);
                                ((Bitmap) (obj)).recycle();
                                return context;
                            }
                        }
                        continue; /* Loop/switch isn't completed */
                    }
                }
            }
        }
        obj = obj1;
        if ((float)l > 360F * f)
        {
            break; /* Loop/switch isn't completed */
        }
        obj = obj1;
        if ((float)i1 > 640F * f)
        {
            break; /* Loop/switch isn't completed */
        }
        obj = obj1;
        if (l1 < 0L)
        {
            break; /* Loop/switch isn't completed */
        }
        bitmap = android.provider.MediaStore.Images.Thumbnails.getThumbnail(context.getContentResolver(), l1, 1, options);
        obj = bitmap;
        if (bitmap == null)
        {
            break; /* Loop/switch isn't completed */
        }
        context = bitmap;
        if (j1 != -1)
        {
            context = bitmap;
            if (j1 != 0)
            {
                context = new Matrix();
                context.setRotate(j1, bitmap.getWidth(), bitmap.getHeight());
                context = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), context, true);
                bitmap.recycle();
                return context;
            }
        }
        if (true) goto _L6; else goto _L5
_L5:
        bitmap = new String[1];
        bitmap[0] = "_data";
        context = context.getContentResolver().query(i(), bitmap, null, null, null);
        if (context != null && context.getCount() > 0)
        {
            context.moveToFirst();
            obj = context.getString(context.getColumnIndex(bitmap[0]));
            context.close();
            obj = ev.a(((String) (obj)), l, i1, true);
        }
        context = ((Context) (obj));
        if (obj != null)
        {
            context = ((Context) (obj));
            if (j1 != -1)
            {
                context = ((Context) (obj));
                if (j1 != 0)
                {
                    context = new Matrix();
                    context.setRotate(j1, ((Bitmap) (obj)).getWidth(), ((Bitmap) (obj)).getHeight());
                    context = Bitmap.createBitmap(((Bitmap) (obj)), 0, 0, ((Bitmap) (obj)).getWidth(), ((Bitmap) (obj)).getHeight(), context, true);
                    ((Bitmap) (obj)).recycle();
                    return context;
                }
            }
        }
        if (true) goto _L6; else goto _L7
_L7:
    }

    public Uri a(Context context)
    {
        return b.h();
    }

    public long b()
    {
        return Long.parseLong(b.c());
    }

    public Uri b(Context context)
    {
        if (context == null)
        {
            return null;
        } else
        {
            return b.e();
        }
    }

    public Bitmap c(Context context)
    {
        Object obj = null;
        Uri uri = b(context);
        if (uri != null)
        {
            context = android.provider.MediaStore.Images.Media.getBitmap(context.getContentResolver(), uri);
        } else
        {
            String as[] = new String[1];
            as[0] = "_data";
            Cursor cursor = context.getContentResolver().query(i(), as, null, null, null);
            context = obj;
            if (cursor != null)
            {
                context = obj;
                if (cursor.getCount() > 0)
                {
                    cursor.moveToFirst();
                    context = cursor.getString(cursor.getColumnIndex(as[0]));
                    cursor.close();
                    return ev.a(context, 90, 90, true);
                }
            }
        }
        return context;
    }

    public Uri i()
    {
        return b.d();
    }

    public String j()
    {
        return b.d().toString();
    }

    public Date k()
    {
        return b.g();
    }
}
