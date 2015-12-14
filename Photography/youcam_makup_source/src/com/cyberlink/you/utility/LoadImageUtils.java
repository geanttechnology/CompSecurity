// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.utility;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.os.AsyncTask;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;
import com.cyberlink.you.database.Group;
import com.cyberlink.you.database.StickerPackObj;
import com.cyberlink.you.database.l;
import com.cyberlink.you.database.m;
import com.cyberlink.you.friends.Friend;
import com.cyberlink.you.friends.s;
import com.cyberlink.you.g;
import com.cyberlink.you.n;
import com.cyberlink.you.sticker.EmojiHelper;
import com.cyberlink.you.sticker.StickerObj;
import com.cyberlink.you.widgetpool.common.GifImageView;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.assist.c;
import com.nostra13.universalimageloader.core.e;
import com.nostra13.universalimageloader.core.e.a;
import com.nostra13.universalimageloader.core.f;
import com.rockerhieu.emojicon.emoji.Emojicon;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

// Referenced classes of package com.cyberlink.you.utility:
//            n, d, m, k, 
//            e, l, g

public class LoadImageUtils
{

    public static final Bitmap a;
    public static Executor b = Executors.newFixedThreadPool(1);
    public static final int c;
    private static final s d = g.a().d();
    private static final Bitmap e = null;
    private static Bitmap f = null;

    public static Bitmap a(Context context)
    {
        if (f == null)
        {
            f = BitmapFactory.decodeResource(context.getResources(), n.ic_launcher);
        }
        return f;
    }

    public static Bitmap a(Context context, String s1)
    {
        return a(context, s1, c);
    }

    private static Bitmap a(Context context, String s1, int i)
    {
        com.nostra13.universalimageloader.core.d d1 = (new e()).a(g.d).a(i).c(i).b(i).a(ImageScaleType.e).a();
        context = new c((int)context.getResources().getDimension(0x1050005), (int)context.getResources().getDimension(0x1050006));
        return com.nostra13.universalimageloader.core.f.b().a(s1, context, d1);
    }

    static com.cyberlink.you.utility.m a(ImageView imageview)
    {
        return f(imageview);
    }

    public static void a()
    {
        Log.d("LoadImageUtils", "[stopUIL] Start =======");
        try
        {
            com.nostra13.universalimageloader.core.f.b().e();
            com.cyberlink.you.utility.n.a().e();
        }
        catch (Exception exception)
        {
            Log.d("LoadImageUtils", (new StringBuilder()).append("[stopUIL] Error : ").append(exception.getMessage()).toString());
        }
        Log.d("LoadImageUtils", "[stopUIL] Done =======");
    }

    public static void a(Context context, Group group, ImageView imageview)
    {
        Log.d("LoadImageUtils", "[loadGroupAvatar] start =======");
        if (group == null)
        {
            return;
        } else
        {
            a(context, group.d, imageview, n.u_pic_default_group, true);
            return;
        }
    }

    public static void a(Context context, StickerPackObj stickerpackobj, ImageView imageview, boolean flag, boolean flag1)
    {
        Log.d("LoadImageUtils", "[loadStickerPack] start =======");
        Object obj = null;
        String s3 = "cover";
        String s2 = stickerpackobj.i().b;
        if (!flag1)
        {
            s3 = "thumbnail";
            s2 = stickerpackobj.i().d;
        }
        String s1 = obj;
        if (flag)
        {
            stickerpackobj = new File(com.cyberlink.you.utility.d.a(stickerpackobj.b()));
            if (!stickerpackobj.exists())
            {
                s1 = obj;
                if (stickerpackobj.mkdir())
                {
                    s1 = (new StringBuilder()).append(stickerpackobj).append(File.separator).append(s3).toString();
                }
            } else
            {
                s1 = (new StringBuilder()).append(stickerpackobj).append(File.separator).append(s3).toString();
            }
        }
        a(context, s2, imageview, s1);
    }

    public static void a(Context context, Friend friend, ImageView imageview)
    {
        Log.d("LoadImageUtils", "[loadUserAvatar] start =======");
        if (friend == null)
        {
            return;
        } else
        {
            a(context, friend.b, imageview, c, true);
            return;
        }
    }

    public static void a(Context context, StickerObj stickerobj, ImageView imageview)
    {
        a(context, stickerobj.f(), imageview, ((String) (null)));
    }

    public static void a(Context context, StickerObj stickerobj, ImageView imageview, boolean flag)
    {
        Object obj;
        String s1;
        String s2;
        Log.d("LoadImageUtils", "[loadAnimPNG] start =======");
        if (stickerobj == null)
        {
            return;
        }
        stickerobj.l();
        s1 = (new StringBuilder()).append(com.cyberlink.you.utility.d.a(stickerobj.c())).append(File.separator).toString();
        obj = new File(s1);
        if (!((File) (obj)).exists())
        {
            ((File) (obj)).mkdir();
        }
        s2 = (new StringBuilder()).append(s1).append(String.valueOf(stickerobj.b())).toString();
        obj = new File(s2);
        if (!((File) (obj)).exists() || !((File) (obj)).isDirectory()) goto _L2; else goto _L1
_L1:
        Object obj1;
        obj1 = stickerobj.n();
        obj = null;
        if (obj1 == null || ((List) (obj1)).isEmpty()) goto _L4; else goto _L3
_L3:
        obj = new AnimationDrawable();
        ((AnimationDrawable) (obj)).setOneShot(false);
        obj1 = ((List) (obj1)).iterator();
_L7:
        Object obj2;
        if (!((Iterator) (obj1)).hasNext())
        {
            break MISSING_BLOCK_LABEL_344;
        }
        obj2 = (String)((Iterator) (obj1)).next();
        obj2 = d.a((new StringBuilder()).append(s2).append(File.separator).append(((String) (obj2))).toString());
        if (obj2 != null) goto _L6; else goto _L5
_L5:
        boolean flag1 = false;
_L8:
        if (flag1)
        {
            imageview.setImageDrawable(((android.graphics.drawable.Drawable) (obj)));
            ((AnimationDrawable) (obj)).start();
            return;
        } else
        {
            stickerobj = new com.cyberlink.you.utility.m(stickerobj, s2, s1, imageview, flag);
            imageview.setImageDrawable(new k(context.getResources(), e, stickerobj));
            stickerobj.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[0]);
            return;
        }
_L6:
        ((AnimationDrawable) (obj)).addFrame(new BitmapDrawable(context.getResources(), ((Bitmap) (obj2))), stickerobj.o());
          goto _L7
_L4:
        flag1 = false;
          goto _L8
_L2:
        b(context, stickerobj, s2, s1, imageview, flag, 3);
        return;
        flag1 = true;
          goto _L8
    }

    static void a(Context context, StickerObj stickerobj, String s1, String s2, ImageView imageview, boolean flag, int i)
    {
        b(context, stickerobj, s1, s2, imageview, flag, i);
    }

    public static void a(Context context, StickerObj stickerobj, boolean flag, ImageView imageview, boolean flag1)
    {
        Log.d("LoadImageUtils", "[loadSticker] start =======");
        if (stickerobj == null)
        {
            return;
        }
        Object obj1 = (new StringBuilder()).append(String.valueOf(stickerobj.c())).append(String.valueOf(stickerobj.b())).toString();
        Object obj = obj1;
        if (flag)
        {
            obj = (new StringBuilder()).append(((String) (obj1))).append("_thumbnail").toString();
        }
        Object obj2;
        if (flag)
        {
            obj1 = stickerobj.i();
        } else
        {
            obj1 = stickerobj.g();
        }
        obj2 = d.a(((String) (obj1)));
        if (obj2 != null)
        {
            imageview.setImageBitmap(((Bitmap) (obj2)));
            return;
        }
        if (!((String) (obj1)).equals("_"))
        {
            obj2 = d.a(((String) (obj)));
            if (obj2 != null)
            {
                imageview.setImageBitmap(((Bitmap) (obj2)));
                return;
            }
        }
        obj2 = new File(((String) (obj1)));
        class LoadBitmapTask.SrcType extends Enum
        {

            public static final LoadBitmapTask.SrcType a;
            private static final LoadBitmapTask.SrcType b[];

            public static LoadBitmapTask.SrcType valueOf(String s1)
            {
                return (LoadBitmapTask.SrcType)Enum.valueOf(com/cyberlink/you/utility/LoadImageUtils$LoadBitmapTask$SrcType, s1);
            }

            public static LoadBitmapTask.SrcType[] values()
            {
                return (LoadBitmapTask.SrcType[])b.clone();
            }

            static 
            {
                a = new LoadBitmapTask.SrcType("Sticker", 0);
                b = (new LoadBitmapTask.SrcType[] {
                    a
                });
            }

            private LoadBitmapTask.SrcType(String s1, int i)
            {
                super(s1, i);
            }
        }

        if (((File) (obj2)).getPath().equals("_") || !((File) (obj2)).exists())
        {
            obj1 = new File(com.cyberlink.you.utility.d.a(stickerobj.c()));
            if (!((File) (obj1)).exists())
            {
                ((File) (obj1)).mkdir();
            }
            if (flag)
            {
                obj1 = (new StringBuilder()).append(obj1).append(File.separator).append(Long.toString(stickerobj.b())).append("_thumbnail").toString();
            } else
            {
                obj1 = (new StringBuilder()).append(obj1).append(File.separator).append(Long.toString(stickerobj.b())).toString();
            }
            obj = new LoadBitmapTask(((String) (obj)), ((String) (obj1)), imageview, com.cyberlink.you.utility.LoadBitmapTask.SrcType.a, false, true);
            imageview.setImageDrawable(new k(context.getResources(), e, ((LoadBitmapTask) (obj))));
            if (flag)
            {
                imageview = stickerobj.h();
            } else
            {
                imageview = stickerobj.f();
            }
            (new com.cyberlink.you.utility.e()).a(context, imageview, ((String) (obj1)), new com.cyberlink.you.utility.g(flag, stickerobj, ((LoadBitmapTask) (obj))) {

                final boolean a;
                final StickerObj b;
                final LoadBitmapTask c;

                public void a()
                {
                    Log.d("LoadImageUtils", "download fail");
                }

                public void a(int i)
                {
                    Log.d("LoadImageUtils", (new StringBuilder()).append("download progress=").append(String.valueOf(i)).toString());
                }

                public void a(String s1)
                {
                    Log.d("LoadImageUtils", "download success");
                    if (a)
                    {
                        b.b(s1);
                    } else
                    {
                        b.a(s1);
                    }
                    com.cyberlink.you.e.h().a(b.b(), b);
                    if (!c.getStatus().equals(android.os.AsyncTask.Status.RUNNING) && !c.getStatus().equals(android.os.AsyncTask.Status.FINISHED))
                    {
                        c.execute(new Object[0]);
                    }
                }

            
            {
                a = flag;
                b = stickerobj;
                c = loadbitmaptask;
                super();
            }
            });
            return;
        } else
        {
            stickerobj = new LoadBitmapTask(((String) (obj)), ((String) (obj1)), imageview, com.cyberlink.you.utility.LoadBitmapTask.SrcType.a, false, true);
            imageview.setImageDrawable(new k(context.getResources(), e, stickerobj));
            stickerobj.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[0]);
            return;
        }
    }

    public static void a(Context context, Emojicon emojicon, ImageView imageview)
    {
        Log.d("LoadImageUtils", "[loadEmojicon] start =======");
        String s1 = String.valueOf(emojicon.getEmoji());
        Bitmap bitmap = d.a(s1);
        if (bitmap != null)
        {
            imageview.setImageBitmap(bitmap);
            return;
        } else
        {
            (new AsyncTask(context, emojicon, imageview, s1) {

                final Context a;
                final Emojicon b;
                final ImageView c;
                final String d;

                protected transient Bitmap a(Void avoid[])
                {
                    return EmojiHelper.a(a, b);
                }

                protected void a(Bitmap bitmap1)
                {
                    if (bitmap1 != null)
                    {
                        c.setImageBitmap(bitmap1);
                        LoadImageUtils.b().a(d, bitmap1);
                    }
                }

                protected Object doInBackground(Object aobj[])
                {
                    return a((Void[])aobj);
                }

                protected void onPostExecute(Object obj)
                {
                    a((Bitmap)obj);
                }

            
            {
                a = context;
                b = emojicon;
                c = imageview;
                d = s1;
                super();
            }
            }).execute(new Void[0]);
            return;
        }
    }

    public static void a(Context context, String s1, ImageView imageview, int i, boolean flag)
    {
        Log.d("LoadImageUtils", "[loadAvatar] start =======");
        com.nostra13.universalimageloader.core.f.b().a(imageview);
        if (s1 == null || s1.isEmpty() || s1.equals("null"))
        {
            imageview.setImageResource(i);
            Log.d("LoadImageUtils", "[loadAvatar] null url !!! use default Avatar...");
            return;
        }
        if (flag)
        {
            context = com.nostra13.universalimageloader.core.f.b().c();
            if (context != null)
            {
                context = com.nostra13.universalimageloader.b.e.a(s1, context);
                if (context.size() > 0)
                {
                    context = (Bitmap)context.get(0);
                } else
                {
                    context = null;
                }
                if (context != null && !context.isRecycled())
                {
                    Log.d("LoadImageUtils", "[loadAvatar] found Avatar in cache ###");
                    imageview.setImageBitmap(context);
                    return;
                }
            }
        }
        context = (new e()).a(g.d).a(i).c(i).a();
        com.nostra13.universalimageloader.core.f.b().a(s1, imageview, context, new com.nostra13.universalimageloader.core.d.c() {

            public void a(String s2, View view, Bitmap bitmap)
            {
                Log.d("LoadImageUtils", (new StringBuilder()).append("[loadAvatar] loadedImage width=").append(bitmap.getWidth()).append(" height=").append(bitmap.getHeight()).toString());
            }

        });
    }

    public static void a(Context context, String s1, ImageView imageview, String s2)
    {
        Bitmap bitmap;
        Log.d("LoadImageUtils", "[loadNetworkSticker] start =======");
        bitmap = d.a(s1);
        if (bitmap != null)
        {
            try
            {
                imageview.setImageBitmap(bitmap);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                context.printStackTrace();
            }
            break MISSING_BLOCK_LABEL_53;
        }
        if (!c(s1, imageview))
        {
            Log.d("LoadImageUtils", "[loadNetworkSticker] work already in progress!!");
            return;
        }
        break MISSING_BLOCK_LABEL_54;
        return;
        s1 = new com.cyberlink.you.utility.l(s1, imageview, s2);
        imageview.setImageDrawable(new k(context.getResources(), null, s1));
        s1.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[0]);
        return;
    }

    static void a(Context context, String s1, String s2, String s3, ImageView imageview, com.cyberlink.you.utility.m m1)
    {
        b(context, s1, s2, s3, imageview, m1);
    }

    public static void a(String s1, ImageView imageview)
    {
        Log.d("LoadImageUtils", "[loadURLImage] start =======");
        com.nostra13.universalimageloader.core.f.b().a(imageview);
        com.nostra13.universalimageloader.core.d d1 = (new e()).a(g.d).c(n.u_doc_thumbnail_default).a();
        com.nostra13.universalimageloader.core.f.b().a(s1, imageview, d1);
    }

    public static void a(String s1, GifImageView gifimageview, String s2)
    {
        Log.d("LoadImageUtils", "[loadGif] start =======");
        if (s1 == null)
        {
            Log.d("LoadImageUtils", "[loadGif] url is null");
            return;
        }
        if (gifimageview == null)
        {
            Log.d("LoadImageUtils", "[loadGif] gifView is null");
            return;
        } else
        {
            (new AsyncTask() {

                private String a;
                private GifImageView b;
                private String c;

                public transient ByteArrayOutputStream a(Object aobj[])
                {
                    Thread.currentThread().setName("loadGif AsyncTask");
                    a = (String)aobj[0];
                    b = (GifImageView)aobj[1];
                    c = (String)aobj[2];
                    aobj = null;
                    Object obj = (new URL(a)).openConnection().getInputStream();
                    aobj = ((Object []) (obj));
_L3:
                    byte abyte0[];
                    abyte0 = new byte[1024];
                    obj = new ByteArrayOutputStream();
                    if (aobj == null)
                    {
                        break MISSING_BLOCK_LABEL_113;
                    }
_L1:
                    int i = ((InputStream) (aobj)).read(abyte0);
                    if (i == -1)
                    {
                        break MISSING_BLOCK_LABEL_113;
                    }
                    ((ByteArrayOutputStream) (obj)).write(abyte0, 0, i);
                      goto _L1
                    aobj;
                    Log.d("LoadImageUtils", Log.getStackTraceString(((Throwable) (aobj))));
                    return ((ByteArrayOutputStream) (obj));
                    Object obj1;
                    obj1;
                    Log.d("LoadImageUtils", Log.getStackTraceString(((Throwable) (obj1))));
                    continue; /* Loop/switch isn't completed */
                    obj1;
                    Log.d("LoadImageUtils", Log.getStackTraceString(((Throwable) (obj1))));
                    if (true) goto _L3; else goto _L2
_L2:
                }

                protected void a(ByteArrayOutputStream bytearrayoutputstream)
                {
                    b.setGifImage(bytearrayoutputstream);
                    if (c.isEmpty() || (new File(c)).exists()) goto _L2; else goto _L1
_L1:
                    FileOutputStream fileoutputstream = new FileOutputStream(c);
                    bytearrayoutputstream.writeTo(fileoutputstream);
                    bytearrayoutputstream = fileoutputstream;
_L5:
                    if (bytearrayoutputstream == null) goto _L2; else goto _L3
_L3:
                    bytearrayoutputstream.close();
_L2:
                    return;
                    IOException ioexception;
                    ioexception;
                    bytearrayoutputstream = null;
_L6:
                    Log.d("LoadImageUtils", Log.getStackTraceString(ioexception));
                    if (true) goto _L5; else goto _L4
_L4:
                    bytearrayoutputstream;
                    Log.d("LoadImageUtils", Log.getStackTraceString(bytearrayoutputstream));
                    return;
                    ioexception;
                    bytearrayoutputstream = fileoutputstream;
                      goto _L6
                }

                public Object doInBackground(Object aobj[])
                {
                    return a(aobj);
                }

                protected void onPostExecute(Object obj)
                {
                    a((ByteArrayOutputStream)obj);
                }

            }).execute(new Object[] {
                s1, gifimageview, s2
            });
            return;
        }
    }

    static boolean a(String s1, String s2, String s3, String s4)
    {
        return b(s1, s2, s3, s4);
    }

    static s b()
    {
        return d;
    }

    static LoadBitmapTask b(ImageView imageview)
    {
        return d(imageview);
    }

    private static void b(Context context, StickerObj stickerobj, String s1, String s2, ImageView imageview, boolean flag, int i)
    {
        String s3 = (new StringBuilder()).append(s1).append(".tmp").toString();
        s1 = new com.cyberlink.you.utility.m(stickerobj, s1, s2, imageview, flag, i);
        context = new k(context.getResources(), e, s1);
        if (imageview != null)
        {
            imageview.setImageDrawable(context);
        }
        (new AsyncTask(stickerobj, s3, s2, imageview, s1) {

            final StickerObj a;
            final String b;
            final String c;
            final ImageView d;
            final com.cyberlink.you.utility.m e;

            protected transient Pair a(Void avoid[])
            {
                avoid = com.cyberlink.you.e.i().a(a.c());
                boolean flag1;
                if (avoid != null && avoid.j().equals(com.cyberlink.you.database.StickerPackObj.Status.b))
                {
                    flag1 = com.cyberlink.you.utility.LoadImageUtils.a(b, c, String.valueOf(a.c()), String.valueOf(a.b()));
                } else
                {
                    flag1 = true;
                }
                return Pair.create(Boolean.valueOf(flag1), avoid);
            }

            protected void a(Pair pair)
            {
                g.a();
                Context context1 = g.I().getApplicationContext();
                if (((Boolean)pair.first).booleanValue())
                {
                    com.cyberlink.you.utility.LoadImageUtils.a(context1, a.f(), b, c, d, e);
                    return;
                } else
                {
                    e.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[0]);
                    return;
                }
            }

            protected Object doInBackground(Object aobj[])
            {
                return a((Void[])aobj);
            }

            protected void onPostExecute(Object obj)
            {
                a((Pair)obj);
            }

            
            {
                a = stickerobj;
                b = s1;
                c = s2;
                d = imageview;
                e = m1;
                super();
            }
        }).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    private static void b(Context context, String s1, String s2, String s3, ImageView imageview, com.cyberlink.you.utility.m m1)
    {
        (new com.cyberlink.you.utility.e()).a(context, s1, s2, new com.cyberlink.you.utility.g(s3, m1) {

            final String a;
            final com.cyberlink.you.utility.m b;

            public void a()
            {
                Log.d("LoadImageUtils", "download fail");
            }

            public void a(int i)
            {
                Log.d("LoadImageUtils", (new StringBuilder()).append("download progress=").append(i).toString());
            }

            public void a(String s4)
            {
                Log.d("LoadImageUtils", (new StringBuilder()).append("download success=").append(s4).toString());
                com.cyberlink.you.utility.d.b(s4, a);
                s4 = new File(s4);
                if (s4.exists())
                {
                    s4.delete();
                }
                b.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[0]);
            }

            
            {
                a = s1;
                b = m1;
                super();
            }
        });
    }

    public static void b(String s1, ImageView imageview)
    {
        Log.d("LoadImageUtils", "[loadURLImage] start =======");
        com.nostra13.universalimageloader.core.f.b().a(imageview);
        int i = imageview.getLayoutParams().width;
        int j = imageview.getLayoutParams().height;
        com.nostra13.universalimageloader.core.d d1 = (new e()).a(g.d).c(n.u_doc_thumbnail_default).a(new a(i, j) {

            final int a;
            final int b;

            public Bitmap a(Bitmap bitmap)
            {
                if (bitmap != null)
                {
                    return com.cyberlink.you.pages.photoimport.a.a.a(g.a(), bitmap, a / 10, a / 10, 0.0F, 0.0F, a, b);
                } else
                {
                    return null;
                }
            }

            
            {
                a = i;
                b = j;
                super();
            }
        }).a();
        com.nostra13.universalimageloader.core.f.b().a(s1, imageview, d1);
    }

    private static boolean b(String s1, String s2, String s3, String s4)
    {
        boolean flag;
        s4 = (new StringBuilder()).append("data").append(File.separator).append("StickerPack").append(File.separator).append(s3).append(File.separator).append(s4).toString();
        flag = false;
        AssetManager assetmanager;
        g.a();
        assetmanager = g.I().getApplicationContext().getAssets();
        if (assetmanager == null)
        {
            return false;
        }
        s3 = new File(s1);
        if (s3.exists() && s3.isDirectory())
        {
            com.cyberlink.you.utility.d.a(s3);
        }
        if (!s3.exists())
        {
            s4 = assetmanager.open(s4);
            s3 = new FileOutputStream(s3);
            com.cyberlink.you.utility.d.a(s4, s3);
            s4.close();
            s3.flush();
            s3.close();
        }
        com.cyberlink.you.utility.d.b(s1, s2);
        s1 = new File(s1);
        if (!s1.exists())
        {
            break MISSING_BLOCK_LABEL_175;
        }
        s1.delete();
        return false;
        s1;
        flag = true;
        return flag;
    }

    static com.cyberlink.you.utility.l c(ImageView imageview)
    {
        return e(imageview);
    }

    public static boolean c(String s1, ImageView imageview)
    {
        LoadBitmapTask loadbitmaptask;
        com.cyberlink.you.utility.l l1;
        boolean flag;
        flag = false;
        loadbitmaptask = d(imageview);
        l1 = e(imageview);
        imageview = f(imageview);
        if (loadbitmaptask == null) goto _L2; else goto _L1
_L1:
        imageview = loadbitmaptask.a;
        if (imageview != null && imageview.equals(s1)) goto _L4; else goto _L3
_L3:
        Log.d("LoadImageUtils", "[cancelPotentialWork] previous LoadBitmapTask cancelled .... ");
        loadbitmaptask.cancel(true);
_L8:
        flag = true;
_L4:
        return flag;
_L2:
        if (l1 == null)
        {
            break; /* Loop/switch isn't completed */
        }
        imageview = com.cyberlink.you.utility.l.a(l1);
        if (imageview == null || !imageview.equals(s1))
        {
            Log.d("LoadImageUtils", "[cancelPotentialWork] previous LoadNetworkStickerTask cancelled .... ");
            l1.cancel(true);
            continue; /* Loop/switch isn't completed */
        }
        if (true) goto _L4; else goto _L5
_L5:
        if (imageview == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        StickerObj stickerobj = ((com.cyberlink.you.utility.m) (imageview)).a;
        long l2;
        try
        {
            l2 = Long.valueOf(s1).longValue();
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            s1.printStackTrace();
            l2 = 0L;
        }
        if (stickerobj != null && stickerobj.c() == l2) goto _L4; else goto _L6
_L6:
        Log.d("LoadImageUtils", "[cancelPotentialWork] previous loadAnimPNGTask cancelled .... ");
        imageview.cancel(true);
        if (true) goto _L8; else goto _L7
_L7:
    }

    private static LoadBitmapTask d(ImageView imageview)
    {
        if (imageview != null)
        {
            imageview = imageview.getDrawable();
            if (imageview instanceof k)
            {
                return ((k)imageview).a();
            }
        }
        return null;
    }

    private static com.cyberlink.you.utility.l e(ImageView imageview)
    {
        if (imageview != null)
        {
            imageview = imageview.getDrawable();
            if (imageview instanceof k)
            {
                return ((k)imageview).b();
            }
        }
        return null;
    }

    private static com.cyberlink.you.utility.m f(ImageView imageview)
    {
        if (imageview != null)
        {
            imageview = imageview.getDrawable();
            if (imageview instanceof k)
            {
                return ((k)imageview).c();
            }
        }
        return null;
    }

    static 
    {
        g.a();
        a = BitmapFactory.decodeResource(g.I().getResources(), n.u_doc_thumbnail_default);
        c = n.u_pic_default;
    }

    private class LoadBitmapTask extends AsyncTask
    {

        public String a;
        private WeakReference b;
        private boolean c;

        public transient Bitmap a(Object aobj[])
        {
            Thread.currentThread().setName("LoadBitmapTask AsyncTask");
            if (a == null || !(new File(a)).exists())
            {
                aobj = null;
            } else
            {
                Bitmap bitmap = LoadImageUtils.b().a(a);
                aobj = bitmap;
                if (bitmap == null)
                {
                    boolean flag;
                    if (!c)
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    return com.cyberlink.you.pages.photoimport.a.a.a(a, flag, -1);
                }
            }
            return ((Bitmap) (aobj));
        }

        protected void a(Bitmap bitmap)
        {
            if (isCancelled())
            {
                bitmap = null;
            }
            while (bitmap == null || b == null) 
            {
                return;
            }
            ImageView imageview = (ImageView)b.get();
            if (this == LoadImageUtils.b(imageview) && imageview != null)
            {
                imageview.setImageBitmap(bitmap);
            }
            LoadImageUtils.b().a(a, bitmap);
        }

        public Object doInBackground(Object aobj[])
        {
            return a(aobj);
        }

        protected void onPostExecute(Object obj)
        {
            a((Bitmap)obj);
        }

        public LoadBitmapTask(String s1, String s2, ImageView imageview, SrcType srctype, boolean flag, boolean flag1)
        {
            a = s2;
            b = new WeakReference(imageview);
            c = flag1;
        }
    }

}
