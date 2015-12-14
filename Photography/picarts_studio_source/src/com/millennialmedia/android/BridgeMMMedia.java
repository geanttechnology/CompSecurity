// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;

// Referenced classes of package com.millennialmedia.android:
//            MMJSObject, MMLog, MMJSResponse, MMSDK, 
//            AdCache

class BridgeMMMedia extends MMJSObject
{

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

    BridgeMMMedia()
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

    static Object a()
    {
        return m;
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
            break MISSING_BLOCK_LABEL_727;
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
                MMLog.a("BridgeMMMedia", "Error closing file", file);
                return s;
            }
        }
        if (file == null)
        {
            break MISSING_BLOCK_LABEL_291;
        }
        file.recycle();
        ((ByteArrayOutputStream) (obj2)).close();
        return s;
_L2:
        f1 = (float)l1 / (float)i1;
        k1 = Math.round(f1);
          goto _L7
        file;
        MMLog.a("BridgeMMMedia", "Error closing file", file);
        obj = obj1;
          goto _L8
        filenotfoundexception;
        file = null;
        obj = null;
_L15:
        obj2 = file;
        obj1 = obj;
        MMLog.a("BridgeMMMedia", "Can't find file to scale bitmap", filenotfoundexception);
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_365;
        }
        ((FileInputStream) (obj)).close();
        if (file == null)
        {
            break MISSING_BLOCK_LABEL_373;
        }
        file.close();
        obj = null;
          goto _L8
        file;
        MMLog.a("BridgeMMMedia", "Error closing file", file);
        obj = null;
          goto _L8
        file;
        obj = null;
        s = ((String) (obj1));
_L14:
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_411;
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
                MMLog.a("BridgeMMMedia", "Error closing file", s);
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
        MMLog.a("BridgeMMMedia", "Error scaling bitmap", ((Throwable) (obj2)));
        if (obj != null)
        {
            try
            {
                ((Bitmap) (obj)).recycle();
            }
            // Misplaced declaration of an exception variable
            catch (File file)
            {
                MMLog.a("BridgeMMMedia", "Error closing file", file);
                return null;
            }
        }
        if (file == null)
        {
            break MISSING_BLOCK_LABEL_606;
        }
        file.recycle();
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_614;
        }
        s.close();
        return null;
        s;
        obj1 = null;
_L11:
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_652;
        }
        ((Bitmap) (obj)).recycle();
        if (file == null)
        {
            break MISSING_BLOCK_LABEL_660;
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
                MMLog.a("BridgeMMMedia", "Error closing file", file);
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

    private boolean c()
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

    private boolean d()
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

    final MMJSResponse a(String s, Map map)
    {
        MMJSResponse mmjsresponse = null;
        if (d.equals(s))
        {
            mmjsresponse = isSourceTypeAvailable(map);
        } else
        {
            if (e.equals(s))
            {
                return availableSourceTypes(map);
            }
            if (f.equals(s))
            {
                return getPicture(map);
            }
            if (g.equals(s))
            {
                return writeToPhotoLibrary(map);
            }
            if (h.equals(s))
            {
                return playVideo(map);
            }
            if (i.equals(s))
            {
                return stopAudio(map);
            }
            if (j.equals(s))
            {
                return getDeviceVolume(map);
            }
            if (k.equals(s))
            {
                return playAudio(map);
            }
            if (l.equals(s))
            {
                return playSound(map);
            }
        }
        return mmjsresponse;
    }

    public MMJSResponse availableSourceTypes(Map map)
    {
        map = new JSONArray();
        if (c())
        {
            map.put("Camera");
        }
        if (d())
        {
            map.put("Photo Library");
        }
        MMJSResponse mmjsresponse = new MMJSResponse();
        mmjsresponse.c = 1;
        mmjsresponse.d = map;
        return mmjsresponse;
    }

    public MMJSResponse getDeviceVolume(Map map)
    {
        map = (Context)b.get();
        if (map != null)
        {
            int i1 = MMSDK.h(map);
            map = MMJSResponse.a();
            map.d = Integer.valueOf(i1);
            return map;
        } else
        {
            return MMJSResponse.b("no volume available");
        }
    }

    public MMJSResponse getPicture(Map map)
    {
        this;
        JVM INSTR monitorenter ;
        Object obj;
        Context context;
        String s;
        Object obj2;
        String s1;
        context = (Context)b.get();
        s = (String)map.get("sourceType");
        obj2 = (String)map.get("constrainHeight");
        s1 = (String)map.get("constrainWidth");
        obj = (String)map.get("contentMode");
        map = ((Map) (obj));
        if (obj == null)
        {
            map = "";
        }
          goto _L1
_L4:
        map = MMJSResponse.b("Missing constrainHeight and/or constrainWidth");
_L2:
        this;
        JVM INSTR monitorexit ;
        return map;
_L5:
        int i1;
        int j1;
        i1 = (int)Float.parseFloat(((String) (obj2)));
        j1 = (int)Float.parseFloat(s1);
        if (i1 * j1 <= 0x57e40)
        {
            break MISSING_BLOCK_LABEL_128;
        }
        map = MMJSResponse.b("constrainHeight * constrainWidth > 360000");
          goto _L2
        if (context == null || s == null)
        {
            break MISSING_BLOCK_LABEL_356;
        }
        boolean flag;
        obj = new File(AdCache.g(context), (new StringBuilder("tmp_mm_")).append(String.valueOf(System.currentTimeMillis())).append(".jpg").toString());
        if (s.equalsIgnoreCase("Camera") && c())
        {
            break MISSING_BLOCK_LABEL_228;
        }
        if (!s.equalsIgnoreCase("Photo Library") && !s.equalsIgnoreCase("PhotoLibrary"))
        {
            break MISSING_BLOCK_LABEL_356;
        }
        flag = d();
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_356;
        }
        obj2 = new Object();
        m = obj2;
        obj2;
        JVM INSTR monitorenter ;
        Utils.IntentUtils.a(context, ((File) (obj)), s);
        m.wait();
        obj2;
        JVM INSTR monitorexit ;
        m = null;
_L3:
        byte abyte0[];
        if (!((File) (obj)).exists() || ((File) (obj)).length() <= 0L)
        {
            break MISSING_BLOCK_LABEL_356;
        }
        abyte0 = a(((File) (obj)), j1, i1, map);
        ((File) (obj)).delete();
        if (abyte0 == null)
        {
            break MISSING_BLOCK_LABEL_356;
        }
        map = new MMJSResponse();
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
        MMLog.a("BridgeMMMedia", "Error with pickerActivity synchronization", ((Throwable) (obj1)));
        m = null;
          goto _L3
        map;
        m = null;
        throw map;
        map = null;
          goto _L2
_L1:
        if (obj2 != null && s1 != null) goto _L5; else goto _L4
    }

    public MMJSResponse isSourceTypeAvailable(Map map)
    {
        map = (String)map.get("sourceType");
        if (map != null)
        {
            if (map.equalsIgnoreCase("Camera") && c())
            {
                return MMJSResponse.a("true");
            }
            if (map.equalsIgnoreCase("Photo Library") && d())
            {
                return MMJSResponse.a("true");
            }
        }
        return MMJSResponse.b("false");
    }

    public MMJSResponse playAudio(Map map)
    {
        Object obj1 = (Context)b.get();
        Object obj = (String)map.get("path");
        if (obj1 != null && obj != null)
        {
            obj1 = Audio.a(((Context) (obj1)));
            if (obj1 == null)
            {
                return null;
            }
            if (((Audio) (obj1)).a())
            {
                return MMJSResponse.b("Audio already playing.");
            }
            if (((String) (obj)).startsWith("http"))
            {
                return ((Audio) (obj1)).a(Uri.parse(((String) (obj))), Boolean.parseBoolean((String)map.get("repeat")));
            }
            obj = AdCache.a(((String) (obj)));
            if (((File) (obj)).exists())
            {
                return ((Audio) (obj1)).a(Uri.fromFile(((File) (obj))), Boolean.parseBoolean((String)map.get("repeat")));
            }
        }
        return null;
    }

    public MMJSResponse playSound(Map map)
    {
        if (b == null)
        {
            return null;
        }
        Context context = (Context)b.get();
        map = (String)map.get("path");
        if (context != null && map != null)
        {
            map = AdCache.a(map);
            if (map.exists())
            {
                Audio audio = Audio.a((Context)b.get());
                if (audio != null)
                {
                    return audio.a(map);
                }
            }
        }
        return null;
    }

    public MMJSResponse playVideo(Map map)
    {
        Context context = (Context)b.get();
        map = (String)map.get("path");
        if (context != null && map != null)
        {
            if (map.startsWith("http"))
            {
                Utils.IntentUtils.a(context, map);
                return MMJSResponse.a(map);
            }
            map = AdCache.a(map);
            if (map.exists())
            {
                Utils.IntentUtils.a(context, map);
                return MMJSResponse.a(map.getName());
            }
        }
        return null;
    }

    public MMJSResponse stopAudio(Map map)
    {
        if (b != null)
        {
            map = Audio.a((Context)b.get());
            if (map != null)
            {
                return map.b();
            }
        }
        return null;
    }

    public MMJSResponse writeToPhotoLibrary(Map map)
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
        if (!s.equals("http") || AdCache.a(map.toString(), "Pictures", ((String) (obj)))) goto _L5; else goto _L6
_L6:
        map = MMJSResponse.b("Failed to download");
_L8:
        this;
        JVM INSTR monitorexit ;
        return map;
_L5:
        map = AdCache.a("Pictures", map.getLastPathSegment());
        if (!map.exists())
        {
            map = MMJSResponse.b((new StringBuilder("No file at ")).append(map.getAbsolutePath()).toString());
            continue; /* Loop/switch isn't completed */
        }
        map = map.getAbsolutePath();
        obj = (Context)b.get();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_205;
        }
        a = new MediaScannerConnection(((Context) (obj)).getApplicationContext(), new android.media.MediaScannerConnection.MediaScannerConnectionClient(map) {

            private String a;
            private BridgeMMMedia b;

            public void onMediaScannerConnected()
            {
                if (b.a != null)
                {
                    b.a.scanFile(a, null);
                }
            }

            public void onScanCompleted(String s1, Uri uri)
            {
                if (uri == null)
                {
                    MMLog.b("BridgeMMMedia", (new StringBuilder("Failed to scan ")).append(s1).toString());
                }
            }

            
            {
                b = BridgeMMMedia.this;
                a = s;
                super();
            }
        });
        if (a != null)
        {
            a.connect();
        }
        if (!AdCache.b())
        {
            map = MMJSResponse.b("Storage not mounted, cannot add image to photo library photo library");
            continue; /* Loop/switch isn't completed */
        }
        map = MMJSResponse.a("Image saved to photo library");
        continue; /* Loop/switch isn't completed */
_L2:
        map = null;
        if (true) goto _L8; else goto _L7
_L7:
        map;
        throw map;
    }

    private class Audio
        implements android.media.MediaPlayer.OnCompletionListener
    {

        private static Audio c;
        CopyOnWriteArrayList a;
        CopyOnWriteArrayList b;
        private WeakReference d;
        private MediaPlayer e;
        private SoundPool f;
        private OnLoadCompleteListener g;
        private Runnable h = new Runnable() {

            private Audio a;

            public void run()
            {
                if (Audio.a(a) != null)
                {
                    if (Audio.a(a).isPlaying())
                    {
                        int i1 = Audio.a(a).getCurrentPosition();
                        if (a.b != null)
                        {
                            class PeriodicListener
                            {

                                public abstract void onUpdate(int j1);
                            }

                            for (Iterator iterator = a.b.iterator(); iterator.hasNext(); ((PeriodicListener)iterator.next()).onUpdate(i1)) { }
                        }
                    }
                    MMSDK.a(this, 500L);
                }
            }

                
                {
                    a = Audio.this;
                    super();
                }
        };

        static MediaPlayer a(Audio audio)
        {
            return audio.e;
        }

        static Audio a(Context context)
        {
            com/millennialmedia/android/BridgeMMMedia$Audio;
            JVM INSTR monitorenter ;
            if (c == null)
            {
                c = new Audio(context);
            }
            context = c;
            com/millennialmedia/android/BridgeMMMedia$Audio;
            JVM INSTR monitorexit ;
            return context;
            context;
            throw context;
        }

        static WeakReference b(Audio audio)
        {
            return audio.d;
        }

        final MMJSResponse a(Uri uri, boolean flag)
        {
            this;
            JVM INSTR monitorenter ;
            if (e != null)
            {
                e.release();
                e = null;
            }
            e = MediaPlayer.create((Context)d.get(), uri);
            e.setLooping(flag);
            e.start();
            e.setOnCompletionListener(this);
            MMSDK.a(h);
_L1:
            uri = MMJSResponse.a("Audio playback started");
            this;
            JVM INSTR monitorexit ;
            return uri;
            uri;
            MMLog.a("BridgeMMMedia", "Exception in playAudio method", uri.getCause());
              goto _L1
            uri;
            throw uri;
        }

        final MMJSResponse a(File file)
        {
            this;
            JVM INSTR monitorenter ;
            try
            {
                if (f == null)
                {
                    f = new SoundPool(4, 3, 0);
                    g = new OnLoadCompleteListener(f) {

                        private Audio a;

                        public void onLoadComplete(SoundPool soundpool, int i1, int j1)
                        {
                            this;
                            JVM INSTR monitorenter ;
                            if (soundpool == null)
                            {
                                break MISSING_BLOCK_LABEL_70;
                            }
                            Object obj = (Context)Audio.b(a).get();
                            if (obj == null)
                            {
                                break MISSING_BLOCK_LABEL_70;
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
                    a = Audio.this;
                    class OnLoadCompleteListener
                    {

                        private ArrayList a;
                        private Timer b;
                        private SoundPool c;

                        static ArrayList a(OnLoadCompleteListener onloadcompletelistener)
                        {
                            return onloadcompletelistener.a;
                        }

                        static SoundPool b(OnLoadCompleteListener onloadcompletelistener)
                        {
                            return onloadcompletelistener.c;
                        }

                        static Timer c(OnLoadCompleteListener onloadcompletelistener)
                        {
                            return onloadcompletelistener.b;
                        }

                        final void a()
                        {
                            this;
                            JVM INSTR monitorenter ;
                            if (b != null)
                            {
                                b.cancel();
                                b.purge();
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
                            a.add(Integer.valueOf(i1));
                            if (a.size() == 1)
                            {
                                b = new Timer();
                                b.scheduleAtFixedRate(new TimerTask() {

                                    private OnLoadCompleteListener a;

                                    public void run()
                                    {
                                        ArrayList arraylist = new ArrayList();
                                        Iterator iterator = OnLoadCompleteListener.a(a).iterator();
                                        do
                                        {
                                            if (!iterator.hasNext())
                                            {
                                                break;
                                            }
                                            Integer integer = (Integer)iterator.next();
                                            int j1 = OnLoadCompleteListener.b(a).play(integer.intValue(), 0.0F, 0.0F, 0, 0, 1.0F);
                                            if (j1 != 0)
                                            {
                                                OnLoadCompleteListener.b(a).stop(j1);
                                                a.onLoadComplete(OnLoadCompleteListener.b(a), integer.intValue(), 0);
                                                arraylist.add(integer);
                                            }
                                        } while (true);
                                        OnLoadCompleteListener.a(a).removeAll(arraylist);
                                        if (OnLoadCompleteListener.a(a).size() == 0)
                                        {
                                            OnLoadCompleteListener.c(a).cancel();
                                            OnLoadCompleteListener.c(a).purge();
                                        }
                                    }

                                
                                {
                                    a = OnLoadCompleteListener.this;
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

                        abstract void onLoadComplete(SoundPool soundpool1, int i1, int j1);

                            public OnLoadCompleteListener(SoundPool soundpool)
                            {
                                a = new ArrayList();
                                c = soundpool;
                            }
                    }

                    super(soundpool);
                }
                    };
                }
                g.a(f.load(file.getAbsolutePath(), 1));
            }
            // Misplaced declaration of an exception variable
            catch (File file) { }
            file = MMJSResponse.a("Sound playback started");
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
            if (e == null) goto _L2; else goto _L1
_L1:
            boolean flag = e.isPlaying();
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

        final MMJSResponse b()
        {
            this;
            JVM INSTR monitorenter ;
            MMJSResponse mmjsresponse;
            if (e != null)
            {
                onCompletion(e);
            }
            if (f != null)
            {
                f.release();
                f = null;
            }
            if (g != null)
            {
                g.a();
                g = null;
            }
            mmjsresponse = MMJSResponse.a("Audio stopped");
            this;
            JVM INSTR monitorexit ;
            return mmjsresponse;
            Exception exception;
            exception;
            throw exception;
        }

        public void onCompletion(MediaPlayer mediaplayer)
        {
            this;
            JVM INSTR monitorenter ;
            if (a != null)
            {
                for (mediaplayer = a.iterator(); mediaplayer.hasNext(); ((android.media.MediaPlayer.OnCompletionListener)mediaplayer.next()).onCompletion(e)) { }
            }
            break MISSING_BLOCK_LABEL_52;
            mediaplayer;
            throw mediaplayer;
            if (e != null)
            {
                e.release();
                e = null;
            }
            this;
            JVM INSTR monitorexit ;
        }

        private Audio()
        {
        }

        private Audio(Context context)
        {
            d = new WeakReference(context.getApplicationContext());
        }
    }

}
