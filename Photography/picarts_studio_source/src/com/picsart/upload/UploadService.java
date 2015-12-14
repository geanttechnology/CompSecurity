// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.upload;

import android.app.IntentService;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.os.HandlerThread;
import android.os.IBinder;
import android.text.TextUtils;
import android.util.Log;
import com.socialin.android.apiv3.controllers.AddPhotoController;
import com.socialin.android.photo.exif.ExifTool;
import com.socialin.android.picsart.upload.UploadItem;
import com.socialin.android.util.FileUtils;
import com.socialin.android.util.w;
import com.socialin.asyncnet.b;
import java.io.File;
import myobfuscated.f.m;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.picsart.upload:
//            d, a, c

public class UploadService extends IntentService
{

    private String a;

    public UploadService()
    {
        super("upload_service_thread");
    }

    private static File a(Context context)
    {
        File file1 = context.getExternalFilesDir(null);
        File file = file1;
        if (file1 == null)
        {
            file = b(context);
        }
        context = new File(file, "upload");
        boolean flag;
        if (context.exists() || context.mkdirs())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            return context;
        } else
        {
            return null;
        }
    }

    private static String a(String s)
    {
        return (new StringBuilder()).append(s).append("_resizedimage").toString();
    }

    private void a()
    {
        Object obj = com.picsart.upload.d.a().b();
        if (obj == null || !((a) (obj)).a() || ((a) (obj)).c())
        {
            if (obj != null && ((a) (obj)).e())
            {
                j(String.valueOf(((a) (obj)).a.j));
            }
            obj = getContentResolver().query(c.a, null, "upload_status=1", null, "created_at ASC limit 1");
            if (obj == null)
            {
                obj = null;
            } else
            {
                obj1 = obj;
                if (((Cursor) (obj)).getCount() == 0)
                {
                    ((Cursor) (obj)).close();
                    obj1 = getContentResolver().query(c.a, null, "upload_status=0", null, "created_at ASC limit 1");
                }
                (new StringBuilder("cursor database count in query = ")).append(((Cursor) (obj1)).getCount());
                if (((Cursor) (obj1)).getCount() == 1)
                {
                    ((Cursor) (obj1)).moveToFirst();
                    obj = UploadItem.a(((Cursor) (obj1)));
                } else
                {
                    obj = null;
                }
                ((Cursor) (obj1)).close();
            }
            Log.e("itemuploader", (new StringBuilder("database item is ")).append(obj).toString());
            if (obj != null)
            {
                if (((UploadItem) (obj)).l() && ((UploadItem) (obj)).k == 1)
                {
                    obj.k = 2;
                    getContentResolver().update(c.a, ((UploadItem) (obj)).a(), (new StringBuilder("_id=")).append(((UploadItem) (obj)).j).toString(), null);
                    Log.e("itemuploader", (new StringBuilder("should not happen case ")).append(((UploadItem) (obj)).f()).toString());
                }
                if (!((UploadItem) (obj)).l() && !((UploadItem) (obj)).k())
                {
                    a a1 = com.picsart.upload.a.a(((UploadItem) (obj)), getApplicationContext());
                    String s = String.valueOf(((UploadItem) (obj)).j);
                    Object obj1;
                    if (((UploadItem) (obj)).i())
                    {
                        obj1 = f(s);
                    } else
                    {
                        obj1 = null;
                    }
                    ((UploadItem) (obj)).c(e(s).getAbsolutePath());
                    a1.a(e(s), ((File) (obj1)), false);
                    com.picsart.upload.d.a().a(a1);
                    if (((UploadItem) (obj)).k == 1)
                    {
                        getContentResolver().update(c.a, ((UploadItem) (obj)).a(), (new StringBuilder("_id=")).append(((UploadItem) (obj)).j).toString(), null);
                    }
                }
            }
        }
    }

    private void a(String s, String s1)
    {
        a a1 = com.picsart.upload.d.a().b();
        if (a1 == null || !a1.a() || a1.c() || !a1.d())
        {
            if (a1 != null && a1.e())
            {
                j(String.valueOf(a1.a.j));
            }
            s1 = getContentResolver().query(c.a, null, "_id=?", new String[] {
                s1
            }, null);
            if (s1 != null && s1.getCount() > 0)
            {
                s1.moveToFirst();
                UploadItem uploaditem = UploadItem.a(s1);
                if (uploaditem != null && !uploaditem.k())
                {
                    a a2 = com.picsart.upload.a.a(uploaditem, getApplicationContext());
                    String s2 = String.valueOf(uploaditem.j);
                    if (uploaditem.i())
                    {
                        s1 = f(s2);
                    } else
                    {
                        s1 = null;
                    }
                    uploaditem.c(e(String.valueOf(uploaditem.j)).getAbsolutePath());
                    a2.d = s;
                    a2.a(e(s2), s1, true);
                    com.picsart.upload.d.a().a(a2);
                    if (uploaditem.k == 1)
                    {
                        getContentResolver().update(c.a, uploaditem.a(), (new StringBuilder("_id=")).append(uploaditem.j).toString(), null);
                    }
                }
            }
        }
    }

    private void a(String s, String s1, String s2)
    {
        int k = m.d(s);
        if (k != 0)
        {
            android.graphics.Bitmap bitmap = w.b(BitmapFactory.decodeFile(s), k);
            byte abyte0[];
            if (FileUtils.d(s) == com.socialin.android.util.FileUtils.ImageFileFormat.JPEG)
            {
                abyte0 = ExifTool.b(s);
            } else
            {
                abyte0 = null;
            }
            if ((new File(s)).delete())
            {
                s1 = w.a(s2, s1, bitmap, getApplicationContext(), android.graphics.Bitmap.CompressFormat.JPEG, false);
                if (FileUtils.d(s) == com.socialin.android.util.FileUtils.ImageFileFormat.JPEG && abyte0 != null)
                {
                    ExifTool.a(s1.getAbsolutePath(), abyte0);
                }
            }
        }
    }

    private static File b(Context context)
    {
        context = new File((new StringBuilder()).append(Environment.getExternalStorageDirectory()).append("/Android/data/").append(context.getPackageName()).append("/files").toString());
        if (!context.exists())
        {
            context.mkdirs();
        }
        return context;
        Exception exception;
        exception;
        context = null;
_L2:
        exception.printStackTrace();
        return context;
        exception;
        if (true) goto _L2; else goto _L1
_L1:
    }

    private boolean b(String s)
    {
        boolean flag = g(s);
        boolean flag1 = i(s);
        boolean flag2 = h(s);
        if (flag && flag1 && flag2)
        {
            return c(s);
        } else
        {
            return false;
        }
    }

    private boolean c(String s)
    {
        int k = getContentResolver().delete(c.a, "_id=?", new String[] {
            s
        });
        Log.e("itemuploader", (new StringBuilder("db deleted rowcount= ")).append(k).toString());
        return k > 0;
    }

    private String d(String s)
    {
        Object obj;
        File file;
        String s1;
        File file1;
        file = a(this);
        if (file == null)
        {
            throw new IllegalStateException("Upload dir does not exists, check that external storage avaliable");
        }
        s1 = a(s);
        file1 = new File(file, s1);
        obj = e(s);
        s = null;
        obj = w.f(((File) (obj)).getAbsolutePath());
        s = ((String) (obj));
_L2:
        w.a(file1, s, android.graphics.Bitmap.CompressFormat.JPEG, this);
        a(file1.getAbsolutePath(), s1, file.getAbsolutePath());
        return file1.getAbsolutePath();
        Exception exception;
        exception;
        exception.printStackTrace();
        if (true) goto _L2; else goto _L1
_L1:
    }

    private File e(String s)
    {
        File file = a(this);
        if (file == null)
        {
            throw new IllegalStateException("Upload dir does not exists, check that external storage avaliable");
        } else
        {
            return new File(file, (new StringBuilder()).append(s).append("_image").toString());
        }
    }

    private File f(String s)
    {
        File file = a(this);
        if (file == null)
        {
            throw new IllegalStateException("Upload dir does not exists, check that external storage avaliable");
        }
        File file1 = new File(file, a(s));
        file = file1;
        if (!file1.exists())
        {
            file = new File(d(s));
        }
        return file;
    }

    private boolean g(String s)
    {
        s = e(s);
        if (s.exists())
        {
            return s.delete();
        } else
        {
            return true;
        }
    }

    private boolean h(String s)
    {
        s = f(s);
        if (s.exists())
        {
            return s.delete();
        } else
        {
            return true;
        }
    }

    private boolean i(String s)
    {
        File file = a(this);
        if (file == null)
        {
            throw new IllegalStateException("Upload dir does not exists, check that external storage avaliable");
        }
        s = (new StringBuilder()).append(s).append("_image_thumb").toString();
        s = new File(file, (new StringBuilder()).append(s).append("_thumb").toString());
        if (s.exists())
        {
            return s.delete();
        } else
        {
            return true;
        }
    }

    private void j(String s)
    {
        g(s);
        h(s);
        b(s);
        i(s);
    }

    public IBinder onBind(Intent intent)
    {
        return null;
    }

    public void onCreate()
    {
        super.onCreate();
    }

    public void onDestroy()
    {
        super.onDestroy();
    }

    protected void onHandleIntent(Intent intent)
    {
        int l;
        int i1;
        l = 0;
        i1 = 0;
        Object obj;
        Object obj1;
        Object obj2;
        obj1 = intent.getAction();
        obj2 = intent.getStringExtra("extra.message");
        obj = com.picsart.upload.d.a().b();
        int k = -1;
        ((String) (obj1)).hashCode();
        JVM INSTR lookupswitch 6: default 1045
    //                   -1327178345: 156
    //                   -1159230236: 124
    //                   -647489930: 172
    //                   -517647605: 140
    //                   -200367356: 92
    //                   -38235473: 108;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7
_L6:
        if (((String) (obj1)).equals("picsart.upload.add.to.queue"))
        {
            k = 0;
        }
          goto _L1
_L7:
        if (((String) (obj1)).equals("picsart.upload.check"))
        {
            k = 1;
        }
          goto _L1
_L3:
        if (((String) (obj1)).equals("picsart.upload.delete"))
        {
            k = 2;
        }
          goto _L1
_L5:
        if (((String) (obj1)).equals("picsart.upload.reset.item"))
        {
            k = 3;
        }
          goto _L1
_L2:
        if (((String) (obj1)).equals("picsart.upload.delete.all"))
        {
            k = 4;
        }
          goto _L1
_L4:
        if (((String) (obj1)).equals("picsart.network.dismiss"))
        {
            k = 5;
        }
          goto _L1
_L22:
        obj1 = UploadItem.a(new JSONObject(((String) (obj2))));
        obj2 = getContentResolver().insert(c.a, ((UploadItem) (obj1)).a());
        a = intent.getExtras().getString("origin");
        obj1.j = ContentUris.parseId(((android.net.Uri) (obj2)));
        intent = String.valueOf(((UploadItem) (obj1)).j);
        String s;
        File file1;
        try
        {
            s = ((UploadItem) (obj1)).b();
            obj2 = a(this);
        }
        // Misplaced declaration of an exception variable
        catch (Intent intent)
        {
            File file;
            try
            {
                c(String.valueOf(((a) (obj)).a.j));
                throw intent;
            }
            // Misplaced declaration of an exception variable
            catch (Intent intent)
            {
                intent.printStackTrace();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Intent intent)
            {
                intent.printStackTrace();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Intent intent)
            {
                intent.printStackTrace();
            }
            return;
        }
        if (obj2 != null) goto _L9; else goto _L8
_L8:
        throw new IllegalStateException("Upload dir does not exists, check that external storage avaliable");
_L9:
        file = new File(s);
        if (!file.exists())
        {
            throw new IllegalStateException((new StringBuilder("Tmp image file does not exists, check that external storage avaliable, path is: ")).append(s).toString());
        }
        s = (new StringBuilder()).append(intent).append("_image").toString();
        file1 = new File(((File) (obj2)), s);
        if (!file.renameTo(file1))
        {
            throw new IllegalStateException((new StringBuilder("can't rename file name from: ")).append(file.getAbsolutePath()).append(" to: ").append(file1.getAbsolutePath()).toString());
        }
        a(file1.getAbsolutePath(), s, ((File) (obj2)).getAbsolutePath());
        file1.getAbsolutePath();
        if (((UploadItem) (obj1)).i())
        {
            d(intent);
        }
        a();
        return;
_L23:
        a();
        return;
_L24:
        if (TextUtils.isEmpty(((CharSequence) (obj2)))) goto _L11; else goto _L10
_L10:
        intent = ((String) (obj2)).split(",");
        l = intent.length;
        k = i1;
_L28:
        if (k >= l) goto _L11; else goto _L12
_L12:
        obj1 = intent[k];
        b(((String) (obj1)));
        if (obj == null) goto _L14; else goto _L13
_L13:
        if (((a) (obj)).a() && ((a) (obj)).a.j == Long.parseLong(((String) (obj1))))
        {
            ((a) (obj)).b();
        }
          goto _L14
_L11:
        a();
        return;
_L25:
        if (TextUtils.isEmpty(((CharSequence) (obj2)))) goto _L16; else goto _L15
_L15:
        intent = ((String) (obj2)).split(",");
        obj = getContentResolver().query(c.a, null, "_id=?", new String[] {
            intent[0]
        }, null);
        if (obj == null) goto _L16; else goto _L17
_L17:
        if (((Cursor) (obj)).getCount() <= 0) goto _L16; else goto _L18
_L18:
        ((Cursor) (obj)).moveToFirst();
        obj1 = UploadItem.a(((Cursor) (obj)));
        ((Cursor) (obj)).close();
        obj1.k = 0;
        k = ((UploadItem) (obj1)).i(intent[1]);
        ((UploadItem) (obj1)).e[k] = 0;
        getContentResolver().update(c.a, ((UploadItem) (obj1)).a(), (new StringBuilder("_id=")).append(((UploadItem) (obj1)).j).toString(), null);
        Thread.sleep(2000L);
        if (!"picsart.resized".equals(intent[1]) && !"picsart".equals(intent[1]))
        {
            a(intent[1], intent[0]);
            return;
        }
        if (((UploadItem) (obj1)).i() && "picsart".equals(intent[1]))
        {
            a(intent[1], intent[0]);
            return;
        }
        a();
        return;
_L26:
        k = getContentResolver().delete(c.a, null, null);
        Log.e("itemuploader", (new StringBuilder("db deleted rowcount= ")).append(k).toString());
        i1 = com.picsart.upload.d.a().c();
        k = l;
_L19:
        if (k >= i1)
        {
            break; /* Loop/switch isn't completed */
        }
        intent = com.picsart.upload.d.a().a(k);
        intent.b();
        intent.a(4);
        ((a) (intent)).b.quit();
        if (((a) (intent)).f != null)
        {
            com.socialin.asyncnet.b.a().a(((a) (intent)).f.getRequestId());
        }
        intent.e = true;
        intent.a(4);
        ((a) (intent)).b.quit();
        com.picsart.upload.d.a().b(k);
        k++;
        if (true) goto _L19; else goto _L16
_L27:
        if (TextUtils.isEmpty(((CharSequence) (obj2)))) goto _L16; else goto _L20
_L20:
        intent = ((String) (obj2)).split(",");
        obj = getContentResolver().query(c.a, null, "_id=?", new String[] {
            intent[0]
        }, null);
        if (obj == null) goto _L16; else goto _L21
_L21:
        if (((Cursor) (obj)).getCount() > 0)
        {
            ((Cursor) (obj)).moveToFirst();
            UploadItem uploaditem = UploadItem.a(((Cursor) (obj)));
            uploaditem.f(intent[1]);
            if (uploaditem.k())
            {
                j(intent[0]);
            }
            ((Cursor) (obj)).close();
            getContentResolver().update(c.a, uploaditem.a(), (new StringBuilder("_id=")).append(uploaditem.j).toString(), null);
            return;
        }
          goto _L16
_L1:
        k;
        JVM INSTR tableswitch 0 5: default 1084
    //                   0 188
    //                   1 485
    //                   2 490
    //                   3 571
    //                   4 777
    //                   5 915;
           goto _L16 _L22 _L23 _L24 _L25 _L26 _L27
_L16:
        return;
_L14:
        k++;
          goto _L28
    }

    public int onStartCommand(Intent intent, int k, int l)
    {
        return super.onStartCommand(intent, k, l);
    }
}
