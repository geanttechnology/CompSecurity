// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaScannerConnection;
import android.media.SoundPool;
import android.net.Uri;
import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;

// Referenced classes of package com.millennialmedia.android:
//            ai, aj, a, MMActivity, 
//            al, an

final class o extends ai
{
    static final class a
        implements android.media.MediaPlayer.OnCompletionListener
    {

        private static a d;
        CopyOnWriteArrayList a;
        CopyOnWriteArrayList b;
        Runnable c = new _cls1(this);
        private WeakReference e;
        private MediaPlayer f;
        private SoundPool g;
        private a h;

        static MediaPlayer a(a a1)
        {
            return a1.f;
        }

        static a a(Context context)
        {
            com/millennialmedia/android/o$a;
            JVM INSTR monitorenter ;
            if (d == null)
            {
                d = new a(context);
            }
            context = d;
            com/millennialmedia/android/o$a;
            JVM INSTR monitorexit ;
            return context;
            context;
            throw context;
        }

        static WeakReference b(a a1)
        {
            return a1.e;
        }

        final aj a(Uri uri, boolean flag)
        {
            this;
            JVM INSTR monitorenter ;
            if (f != null)
            {
                f.release();
                f = null;
            }
            f = MediaPlayer.create((Context)e.get(), uri);
            f.setLooping(flag);
            f.start();
            f.setOnCompletionListener(this);
            an.a(c);
_L1:
            uri = aj.a("Audio playback started");
            this;
            JVM INSTR monitorexit ;
            return uri;
            uri;
            al.a("BridgeMMMedia", "Exception in playAudio method", uri.getCause());
              goto _L1
            uri;
            throw uri;
        }

        final aj a(File file)
        {
            this;
            JVM INSTR monitorenter ;
            try
            {
                if (g == null)
                {
                    g = new SoundPool(4, 3, 0);
                    h = new a.a(this, g) {

                        final a a;

                        public final void a(SoundPool soundpool, int i1)
                        {
                            this;
                            JVM INSTR monitorenter ;
                            if (soundpool == null)
                            {
                                break MISSING_BLOCK_LABEL_67;
                            }
                            Object obj = (Context)a.b(a).get();
                            if (obj == null)
                            {
                                break MISSING_BLOCK_LABEL_67;
                            }
                            obj = (AudioManager)((Context) (obj)).getSystemService("audio");
                            float f1 = ((float)((AudioManager) (obj)).getStreamVolume(3) + 0.0F) / (float)((AudioManager) (obj)).getStreamMaxVolume(3);
                            soundpool.play(i1, f1, f1, 1, 0, 1.0F);
                            this;
                            JVM INSTR monitorexit ;
                            return;
                            soundpool;
                            throw soundpool;
                        }

            
            {
                a = a1;
                super(a1, soundpool);
            }
                    };
                }
                h.a(g.load(file.getAbsolutePath(), 1));
            }
            // Misplaced declaration of an exception variable
            catch (File file) { }
            file = aj.a("Sound playback started");
            this;
            JVM INSTR monitorexit ;
            return file;
            file;
            throw file;
        }

        final boolean a()
        {
            this;
            JVM INSTR monitorenter ;
            if (f == null) goto _L2; else goto _L1
_L1:
            boolean flag = f.isPlaying();
            if (!flag) goto _L2; else goto _L3
_L3:
            flag = true;
_L5:
            this;
            JVM INSTR monitorexit ;
            return flag;
_L2:
            flag = false;
            if (true) goto _L5; else goto _L4
_L4:
            Exception exception;
            exception;
            throw exception;
        }

        final aj b()
        {
            this;
            JVM INSTR monitorenter ;
            aj aj1;
            if (f != null)
            {
                onCompletion(f);
            }
            if (g != null)
            {
                g.release();
                g = null;
            }
            if (h != null)
            {
                h.a();
                h = null;
            }
            aj1 = aj.a("Audio stopped");
            this;
            JVM INSTR monitorexit ;
            return aj1;
            Exception exception;
            exception;
            throw exception;
        }

        public final void onCompletion(MediaPlayer mediaplayer)
        {
            this;
            JVM INSTR monitorenter ;
            if (a != null)
            {
                for (mediaplayer = a.iterator(); mediaplayer.hasNext(); ((android.media.MediaPlayer.OnCompletionListener)mediaplayer.next()).onCompletion(f)) { }
            }
            break MISSING_BLOCK_LABEL_52;
            mediaplayer;
            throw mediaplayer;
            if (f != null)
            {
                f.release();
                f = null;
            }
            this;
            JVM INSTR monitorexit ;
        }

        private a()
        {
        }

        private a(Context context)
        {
            e = new WeakReference(context.getApplicationContext());
        }
    }

    private abstract class a.a
    {

        ArrayList b;
        Timer c;
        SoundPool d;
        final a e;

        final void a()
        {
            this;
            JVM INSTR monitorenter ;
            if (c != null)
            {
                c.cancel();
                c.purge();
            }
            this;
            JVM INSTR monitorexit ;
            return;
            Exception exception;
            exception;
            throw exception;
        }

        final void a(int i1)
        {
            this;
            JVM INSTR monitorenter ;
            b.add(Integer.valueOf(i1));
            if (b.size() == 1)
            {
                c = new Timer();
                c.scheduleAtFixedRate(new TimerTask(this) {

                    final a.a a;

                    public final void run()
                    {
                        ArrayList arraylist = new ArrayList();
                        Iterator iterator = a.b.iterator();
                        do
                        {
                            if (!iterator.hasNext())
                            {
                                break;
                            }
                            Integer integer = (Integer)iterator.next();
                            int i1 = a.d.play(integer.intValue(), 0.0F, 0.0F, 0, 0, 1.0F);
                            if (i1 != 0)
                            {
                                a.d.stop(i1);
                                a.a(a.d, integer.intValue());
                                arraylist.add(integer);
                            }
                        } while (true);
                        a.b.removeAll(arraylist);
                        if (a.b.size() == 0)
                        {
                            a.c.cancel();
                            a.c.purge();
                        }
                    }

            
            {
                a = a1;
                super();
            }
                }, 0L, 100L);
            }
            this;
            JVM INSTR monitorexit ;
            return;
            Exception exception;
            exception;
            throw exception;
        }

        abstract void a(SoundPool soundpool, int i1);

        public a.a(a a1, SoundPool soundpool)
        {
            e = a1;
            super();
            b = new ArrayList();
            d = soundpool;
        }
    }

    static interface a.b
    {

        public abstract void a(int i1);
    }


    private static Object m;
    MediaScannerConnection a;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;
    private String k;
    private String l;

    o()
    {
        d = "isSourceTypeAvailable";
        e = "availableSourceTypes";
        f = "getPicture";
        g = "writeToPhotoLibrary";
        h = "playVideo";
        i = "stopAudio";
        j = "getDeviceVolume";
        k = "playAudio";
        l = "playSound";
    }

    private static Bitmap a(Bitmap bitmap, int i1, int j1, int k1, int l1)
    {
        return Bitmap.createBitmap(bitmap, i1, j1, k1, l1);
    }

    private aj a(Map map)
    {
        this;
        JVM INSTR monitorenter ;
        Object obj;
        Context context;
        String s;
        Object obj2;
        Object obj3;
        context = (Context)b.get();
        s = (String)map.get("sourceType");
        obj2 = (String)map.get("constrainHeight");
        obj3 = (String)map.get("constrainWidth");
        obj = (String)map.get("contentMode");
        map = ((Map) (obj));
        if (obj == null)
        {
            map = "";
        }
          goto _L1
_L4:
        map = aj.b("Missing constrainHeight and/or constrainWidth");
_L2:
        this;
        JVM INSTR monitorexit ;
        return map;
_L5:
        int i1;
        int j1;
        i1 = (int)Float.parseFloat(((String) (obj2)));
        j1 = (int)Float.parseFloat(((String) (obj3)));
        if (i1 * j1 <= 0x57e40)
        {
            break MISSING_BLOCK_LABEL_121;
        }
        map = aj.b("constrainHeight * constrainWidth > 360000");
          goto _L2
        if (context == null || s == null)
        {
            break MISSING_BLOCK_LABEL_384;
        }
        boolean flag;
        obj = new File(com.millennialmedia.android.a.f(context), (new StringBuilder("tmp_mm_")).append(String.valueOf(System.currentTimeMillis())).append(".jpg").toString());
        if (s.equalsIgnoreCase("Camera") && a())
        {
            break MISSING_BLOCK_LABEL_216;
        }
        if (!s.equalsIgnoreCase("Photo Library") && !s.equalsIgnoreCase("PhotoLibrary"))
        {
            break MISSING_BLOCK_LABEL_384;
        }
        flag = c();
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_384;
        }
        obj2 = new Object();
        m = obj2;
        obj2;
        JVM INSTR monitorenter ;
        obj3 = new Intent(context, com/millennialmedia/android/MMActivity);
        ((Intent) (obj3)).setData(Uri.fromFile(((File) (obj))));
        ((Intent) (obj3)).putExtra("type", s);
        ((Intent) (obj3)).putExtra("class", "com.millennialmedia.android.BridgeMMMedia$PickerActivity");
        au.b.b(context, ((Intent) (obj3)));
        m.wait();
        obj2;
        JVM INSTR monitorexit ;
        m = null;
_L3:
        byte abyte0[];
        if (!((File) (obj)).exists() || ((File) (obj)).length() <= 0L)
        {
            break MISSING_BLOCK_LABEL_384;
        }
        abyte0 = a(((File) (obj)), j1, i1, ((String) (map)));
        ((File) (obj)).delete();
        if (abyte0 == null)
        {
            break MISSING_BLOCK_LABEL_384;
        }
        map = new aj();
        map.c = 1;
        map.e = abyte0;
          goto _L2
        map;
        throw map;
        Object obj1;
        obj1;
        obj2;
        JVM INSTR monitorexit ;
        throw obj1;
        obj1;
        al.a("BridgeMMMedia", "Error with pickerActivity synchronization", ((Throwable) (obj1)));
        m = null;
          goto _L3
        map;
        m = null;
        throw map;
        map = null;
          goto _L2
_L1:
        if (obj2 != null && obj3 != null) goto _L5; else goto _L4
    }

    private boolean a()
    {
        Context context = (Context)b.get();
        if (context != null && context.getPackageManager().checkPermission("android.permission.CAMERA", context.getPackageName()) == 0)
        {
            Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
            return context.getPackageManager().queryIntentActivities(intent, 0x10000).size() > 0;
        } else
        {
            return false;
        }
    }

    private static final byte[] a(File file, int i1, int j1, String s)
    {
        Object obj1 = null;
        Object obj = new FileInputStream(file);
        Object obj3;
        int k1;
        int l1;
        obj3 = new android.graphics.BitmapFactory.Options();
        obj3.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(((java.io.InputStream) (obj)), null, ((android.graphics.BitmapFactory.Options) (obj3)));
        k1 = ((android.graphics.BitmapFactory.Options) (obj3)).outHeight;
        l1 = ((android.graphics.BitmapFactory.Options) (obj3)).outWidth;
        if (k1 <= j1 && l1 <= i1)
        {
            break MISSING_BLOCK_LABEL_738;
        }
        if (l1 <= k1) goto _L2; else goto _L1
_L1:
        k1 = Math.round((float)k1 / (float)j1);
_L7:
        file = new FileInputStream(file);
        Object obj2;
        obj2 = file;
        obj1 = obj;
        obj3.inJustDecodeBounds = false;
        obj2 = file;
        obj1 = obj;
        obj3.inSampleSize = k1;
        obj2 = file;
        obj1 = obj;
        obj3 = BitmapFactory.decodeStream(file, null, ((android.graphics.BitmapFactory.Options) (obj3)));
        obj1 = obj3;
        ((FileInputStream) (obj)).close();
        file.close();
        obj = obj1;
_L8:
        if (obj == null) goto _L4; else goto _L3
_L3:
        FileNotFoundException filenotfoundexception;
        float f1 = (float)i1 / (float)((Bitmap) (obj)).getWidth();
        float f2 = (float)j1 / (float)((Bitmap) (obj)).getHeight();
        if (s.equals("Center"))
        {
            f1 = (((Bitmap) (obj)).getWidth() - i1) / 2;
            f2 = (((Bitmap) (obj)).getHeight() - j1) / 2;
            file = a(((Bitmap) (obj)), (int)f1, (int)f2, i1, j1);
        } else
        if (s.equals("ScaleToAspectFit"))
        {
            f1 = Math.min(f1, f2);
            file = Bitmap.createScaledBitmap(((Bitmap) (obj)), (int)((float)((Bitmap) (obj)).getWidth() * f1), (int)(f1 * (float)((Bitmap) (obj)).getHeight()), true);
        } else
        if (s.equals("ScaleToAspectFill"))
        {
            f1 = Math.max(f1, f2);
            file = a(Bitmap.createScaledBitmap(((Bitmap) (obj)), (int)((float)((Bitmap) (obj)).getWidth() * f1), (int)(f1 * (float)((Bitmap) (obj)).getHeight()), true), 0, 0, i1, j1);
        } else
        {
            file = Bitmap.createScaledBitmap(((Bitmap) (obj)), i1, j1, true);
        }
        obj2 = new ByteArrayOutputStream();
        obj1 = obj2;
        if (!s.equals("")) goto _L6; else goto _L5
_L5:
        obj1 = obj2;
        ((Bitmap) (obj)).compress(android.graphics.Bitmap.CompressFormat.JPEG, 100, ((java.io.OutputStream) (obj2)));
_L9:
        obj1 = obj2;
        s = ((ByteArrayOutputStream) (obj2)).toByteArray();
        if (obj != null)
        {
            try
            {
                ((Bitmap) (obj)).recycle();
            }
            // Misplaced declaration of an exception variable
            catch (File file)
            {
                al.a("BridgeMMMedia", "Error closing file", file);
                return s;
            }
        }
        if (file == null)
        {
            break MISSING_BLOCK_LABEL_292;
        }
        file.recycle();
        ((ByteArrayOutputStream) (obj2)).close();
        return s;
_L2:
        f1 = (float)l1 / (float)i1;
        k1 = Math.round(f1);
          goto _L7
        file;
        al.a("BridgeMMMedia", "Error closing file", file);
        obj = obj1;
          goto _L8
        filenotfoundexception;
        file = null;
        obj = null;
_L15:
        obj2 = file;
        obj1 = obj;
        al.a("BridgeMMMedia", "Can't find file to scale bitmap", filenotfoundexception);
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_368;
        }
        ((FileInputStream) (obj)).close();
        if (file == null)
        {
            break MISSING_BLOCK_LABEL_376;
        }
        file.close();
        obj = null;
          goto _L8
        file;
        al.a("BridgeMMMedia", "Error closing file", file);
        obj = null;
          goto _L8
        file;
        obj = null;
        s = ((String) (obj1));
_L14:
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_415;
        }
        ((FileInputStream) (obj)).close();
        if (s != null)
        {
            try
            {
                s.close();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                al.a("BridgeMMMedia", "Error closing file", s);
            }
        }
        throw file;
_L6:
        obj1 = obj2;
        file.compress(android.graphics.Bitmap.CompressFormat.JPEG, 100, ((java.io.OutputStream) (obj2)));
          goto _L9
        obj1;
        s = ((String) (obj2));
        obj2 = obj1;
_L13:
        obj1 = s;
        al.a("BridgeMMMedia", "Error scaling bitmap", ((Throwable) (obj2)));
        if (obj != null)
        {
            try
            {
                ((Bitmap) (obj)).recycle();
            }
            // Misplaced declaration of an exception variable
            catch (File file)
            {
                al.a("BridgeMMMedia", "Error closing file", file);
                return null;
            }
        }
        if (file == null)
        {
            break MISSING_BLOCK_LABEL_614;
        }
        file.recycle();
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_622;
        }
        s.close();
        return null;
        s;
        obj1 = null;
_L11:
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_662;
        }
        ((Bitmap) (obj)).recycle();
        if (file == null)
        {
            break MISSING_BLOCK_LABEL_670;
        }
        file.recycle();
        if (obj1 != null)
        {
            try
            {
                ((ByteArrayOutputStream) (obj1)).close();
            }
            // Misplaced declaration of an exception variable
            catch (File file)
            {
                al.a("BridgeMMMedia", "Error closing file", file);
            }
        }
        throw s;
        s;
        if (true) goto _L11; else goto _L10
_L10:
        obj2;
        s = null;
        if (true) goto _L13; else goto _L12
_L12:
        file;
        s = ((String) (obj1));
          goto _L14
        file;
        s = ((String) (obj2));
        obj = obj1;
          goto _L14
        filenotfoundexception;
        file = null;
          goto _L15
        filenotfoundexception;
          goto _L15
_L4:
        return null;
        k1 = 1;
          goto _L7
    }

    private aj b(Map map)
    {
        this;
        JVM INSTR monitorenter ;
        Object obj;
        String s;
        obj = (Context)b.get();
        s = (String)map.get("path");
        if (obj == null) goto _L2; else goto _L1
_L1:
        if (TextUtils.isEmpty(s)) goto _L2; else goto _L3
_L3:
        map = Uri.parse((String)map.get("path"));
        obj = map.getLastPathSegment();
        s = map.getScheme();
        if (s == null) goto _L5; else goto _L4
_L4:
        if (!s.equals("http") || com.millennialmedia.android.a.a(map.toString(), "Pictures", ((String) (obj)))) goto _L5; else goto _L6
_L6:
        map = aj.b("Failed to download");
_L8:
        this;
        JVM INSTR monitorexit ;
        return map;
_L5:
        map = com.millennialmedia.android.a.a("Pictures", map.getLastPathSegment(), Boolean.valueOf(true));
        if (!map.exists())
        {
            map = aj.b((new StringBuilder("No file at ")).append(map.getAbsolutePath()).toString());
            continue; /* Loop/switch isn't completed */
        }
        map = map.getAbsolutePath();
        obj = (Context)b.get();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_209;
        }
        a = new MediaScannerConnection(((Context) (obj)).getApplicationContext(), new android.media.MediaScannerConnection.MediaScannerConnectionClient(map) {

            final String a;
            final o b;

            public final void onMediaScannerConnected()
            {
                if (b.a != null)
                {
                    b.a.scanFile(a, null);
                }
            }

            public final void onScanCompleted(String s1, Uri uri)
            {
                if (uri == null)
                {
                    al.b();
                }
                b.a.disconnect();
            }

            
            {
                b = o.this;
                a = s;
                super();
            }
        });
        if (a != null)
        {
            a.connect();
        }
        if (!com.millennialmedia.android.a.a())
        {
            map = aj.b("Storage not mounted, cannot add image to photo library photo library");
            continue; /* Loop/switch isn't completed */
        }
        map = aj.a("Image saved to photo library");
        continue; /* Loop/switch isn't completed */
_L2:
        map = null;
        if (true) goto _L8; else goto _L7
_L7:
        map;
        throw map;
    }

    private boolean c()
    {
        Context context = (Context)b.get();
        if (context != null)
        {
            Intent intent = new Intent();
            intent.setType("image/*");
            intent.setAction("android.intent.action.GET_CONTENT");
            return context.getPackageManager().queryIntentActivities(intent, 0x10000).size() > 0;
        } else
        {
            return false;
        }
    }

    final aj a(String s, Map map)
    {
        Object obj = null;
        if (!d.equals(s)) goto _L2; else goto _L1
_L1:
        s = (String)map.get("sourceType");
        if (s == null) goto _L4; else goto _L3
_L3:
        if (!s.equalsIgnoreCase("Camera") || !a()) goto _L6; else goto _L5
_L5:
        s = aj.a("true");
_L24:
        String s1 = s;
_L15:
        return s1;
_L6:
        if (s.equalsIgnoreCase("Photo Library") && c())
        {
            s = aj.a("true");
            continue; /* Loop/switch isn't completed */
        }
_L4:
        s = aj.b("false");
        continue; /* Loop/switch isn't completed */
_L2:
        if (e.equals(s))
        {
            s = new JSONArray();
            if (a())
            {
                s.put("Camera");
            }
            if (c())
            {
                s.put("Photo Library");
            }
            map = new aj();
            map.c = 1;
            map.d = s;
            return map;
        }
        if (f.equals(s))
        {
            return a(map);
        }
        if (g.equals(s))
        {
            return b(map);
        }
        if (!h.equals(s)) goto _L8; else goto _L7
_L7:
        s = (Context)b.get();
        map = (String)map.get("path");
        if (s == null || map == null) goto _L10; else goto _L9
_L9:
        if (!map.startsWith("http")) goto _L12; else goto _L11
_L11:
        au.b.a(s, Uri.parse(map));
        s = aj.a(map);
_L13:
        return s;
_L12:
        map = com.millennialmedia.android.a.a(map);
        if (map.exists())
        {
            au.b.a(s, Uri.fromFile(map));
            s = aj.a(map.getName());
            continue; /* Loop/switch isn't completed */
        }
_L10:
        s = null;
        if (true) goto _L13; else goto _L8
_L8:
        if (!i.equals(s))
        {
            break; /* Loop/switch isn't completed */
        }
        s1 = obj;
        if (b != null)
        {
            s = a.a((Context)b.get());
            s1 = obj;
            if (s != null)
            {
                return s.b();
            }
        }
        if (true) goto _L15; else goto _L14
_L14:
        if (j.equals(s))
        {
            s = (Context)b.get();
            if (s != null)
            {
                int i1 = an.i(s);
                s = aj.a("Success.");
                s.d = Integer.valueOf(i1);
            } else
            {
                s = aj.b("no volume available");
            }
            return s;
        }
        if (!k.equals(s))
        {
            break; /* Loop/switch isn't completed */
        }
        Object obj1 = (Context)b.get();
        s = (String)map.get("path");
        s1 = obj;
        if (obj1 != null)
        {
            s1 = obj;
            if (s != null)
            {
                obj1 = a.a(((Context) (obj1)));
                s1 = obj;
                if (obj1 != null)
                {
                    if (((a) (obj1)).a())
                    {
                        return aj.b("Audio already playing.");
                    }
                    if (s.startsWith("http"))
                    {
                        return ((a) (obj1)).a(Uri.parse(s), Boolean.parseBoolean((String)map.get("repeat")));
                    }
                    s = com.millennialmedia.android.a.a(s);
                    s1 = obj;
                    if (s.exists())
                    {
                        return ((a) (obj1)).a(Uri.fromFile(s), Boolean.parseBoolean((String)map.get("repeat")));
                    }
                }
            }
        }
        if (true) goto _L15; else goto _L16
_L16:
        s1 = obj;
        if (!l.equals(s)) goto _L15; else goto _L17
_L17:
        s1 = obj;
        if (b == null) goto _L15; else goto _L18
_L18:
        s = (Context)b.get();
        map = (String)map.get("path");
        s1 = obj;
        if (s == null) goto _L15; else goto _L19
_L19:
        s1 = obj;
        if (map == null) goto _L15; else goto _L20
_L20:
        s = com.millennialmedia.android.a.a(map);
        s1 = obj;
        if (!s.exists()) goto _L15; else goto _L21
_L21:
        map = a.a((Context)b.get());
        s1 = obj;
        if (map == null) goto _L15; else goto _L22
_L22:
        return map.a(s);
        if (true) goto _L24; else goto _L23
_L23:
    }

    // Unreferenced inner class com/millennialmedia/android/o$a$1

/* anonymous class */
    final class a._cls1
        implements Runnable
    {

        final a a;

        public final void run()
        {
            if (a.a(a) != null)
            {
                if (a.a(a).isPlaying())
                {
                    int i1 = a.a(a).getCurrentPosition();
                    if (a.b != null)
                    {
                        for (Iterator iterator = a.b.iterator(); iterator.hasNext(); ((a.b)iterator.next()).a(i1)) { }
                    }
                }
                an.a(this, 500L);
            }
        }

            
            {
                a = a1;
                super();
            }
    }

}
