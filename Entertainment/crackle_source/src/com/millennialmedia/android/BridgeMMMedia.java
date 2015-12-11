// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaScannerConnection;
import android.media.SoundPool;
import android.net.Uri;
import android.os.Bundle;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.ref.WeakReference;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONArray;

// Referenced classes of package com.millennialmedia.android:
//            MMJSObject, MMJSResponse, AdCache, BridgeMMFileManager, 
//            MMBaseActivity

class BridgeMMMedia extends MMJSObject
{
    static class Audio
    {

        private static final int MAX_SOUNDS = 4;
        private static Audio sharedInstance;
        private OnLoadCompleteListener completionListener;
        private WeakReference contextRef;
        private MediaPlayer mediaPlayer;
        private SoundPool soundPool;

        static Audio sharedAudio(Context context)
        {
            com/millennialmedia/android/BridgeMMMedia$Audio;
            JVM INSTR monitorenter ;
            if (sharedInstance == null)
            {
                sharedInstance = new Audio(context);
            }
            context = sharedInstance;
            com/millennialmedia/android/BridgeMMMedia$Audio;
            JVM INSTR monitorexit ;
            return context;
            context;
            throw context;
        }

        boolean isPlaying()
        {
            this;
            JVM INSTR monitorenter ;
            if (mediaPlayer == null) goto _L2; else goto _L1
_L1:
            boolean flag = mediaPlayer.isPlaying();
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

        MMJSResponse playAudio(Uri uri, boolean flag)
        {
            this;
            JVM INSTR monitorenter ;
            if (mediaPlayer != null)
            {
                mediaPlayer.release();
                mediaPlayer = null;
            }
            mediaPlayer = MediaPlayer.create((Context)contextRef.get(), uri);
            mediaPlayer.setLooping(flag);
            mediaPlayer.start();
            mediaPlayer.setOnCompletionListener(new android.media.MediaPlayer.OnCompletionListener() {

                final Audio this$0;

                public void onCompletion(MediaPlayer mediaplayer)
                {
                    this;
                    JVM INSTR monitorenter ;
                    if (mediaPlayer != null)
                    {
                        mediaPlayer.release();
                        mediaPlayer = null;
                    }
                    this;
                    JVM INSTR monitorexit ;
                    return;
                    mediaplayer;
                    throw mediaplayer;
                }

            
            {
                this$0 = Audio.this;
                super();
            }
            });
_L1:
            uri = MMJSResponse.responseWithSuccess("Audio playback started");
            this;
            JVM INSTR monitorexit ;
            return uri;
            uri;
            MMSDK.Log.e(uri.getCause());
              goto _L1
            uri;
            throw uri;
        }

        MMJSResponse playSound(File file)
        {
            this;
            JVM INSTR monitorenter ;
            try
            {
                if (soundPool == null)
                {
                    soundPool = new SoundPool(4, 3, 0);
                    completionListener = new Audio.OnLoadCompleteListener(soundPool) {

                        final Audio this$0;

                        public void onLoadComplete(SoundPool soundpool, int i, int j)
                        {
                            this;
                            JVM INSTR monitorenter ;
                            if (soundpool == null)
                            {
                                break MISSING_BLOCK_LABEL_61;
                            }
                            AudioManager audiomanager = (AudioManager)((Context)contextRef.get()).getSystemService("audio");
                            float f = ((float)audiomanager.getStreamVolume(3) + 0.0F) / (float)audiomanager.getStreamMaxVolume(3);
                            soundpool.play(i, f, f, 1, 0, 1.0F);
                            this;
                            JVM INSTR monitorexit ;
                            return;
                            soundpool;
                            throw soundpool;
                        }

            
            {
                this$0 = Audio.this;
                super(soundpool);
            }
                    };
                }
                completionListener.testSample(soundPool.load(file.getAbsolutePath(), 1));
            }
            // Misplaced declaration of an exception variable
            catch (File file) { }
            file = MMJSResponse.responseWithSuccess("Sound playback started");
            this;
            JVM INSTR monitorexit ;
            return file;
            file;
            throw file;
        }

        MMJSResponse stop()
        {
            this;
            JVM INSTR monitorenter ;
            MMJSResponse mmjsresponse;
            if (mediaPlayer != null)
            {
                mediaPlayer.release();
                mediaPlayer = null;
            }
            if (soundPool != null)
            {
                soundPool.release();
                soundPool = null;
            }
            if (completionListener != null)
            {
                completionListener.release();
                completionListener = null;
            }
            mmjsresponse = MMJSResponse.responseWithSuccess("Audio stopped");
            this;
            JVM INSTR monitorexit ;
            return mmjsresponse;
            Exception exception;
            exception;
            throw exception;
        }



/*
        static MediaPlayer access$102(Audio audio, MediaPlayer mediaplayer)
        {
            audio.mediaPlayer = mediaplayer;
            return mediaplayer;
        }

*/


        private Audio()
        {
        }

        private Audio(Context context)
        {
            contextRef = new WeakReference(context.getApplicationContext());
        }
    }

    private abstract class Audio.OnLoadCompleteListener
    {

        private static final int TEST_PERIOD_MS = 100;
        private ArrayList sampleIds;
        private SoundPool soundPool;
        final Audio this$0;
        private Timer timer;

        abstract void onLoadComplete(SoundPool soundpool, int i, int j);

        void release()
        {
            this;
            JVM INSTR monitorenter ;
            if (timer != null)
            {
                timer.cancel();
                timer.purge();
            }
            this;
            JVM INSTR monitorexit ;
            return;
            Exception exception;
            exception;
            throw exception;
        }

        void testSample(int i)
        {
            this;
            JVM INSTR monitorenter ;
            sampleIds.add(Integer.valueOf(i));
            if (sampleIds.size() == 1)
            {
                timer = new Timer();
                timer.scheduleAtFixedRate(new TimerTask() {

                    final Audio.OnLoadCompleteListener this$1;

                    public void run()
                    {
                        ArrayList arraylist = new ArrayList();
                        Iterator iterator = sampleIds.iterator();
                        do
                        {
                            if (!iterator.hasNext())
                            {
                                break;
                            }
                            Integer integer = (Integer)iterator.next();
                            int i = soundPool.play(integer.intValue(), 0.0F, 0.0F, 0, 0, 1.0F);
                            if (i != 0)
                            {
                                soundPool.stop(i);
                                onLoadComplete(soundPool, integer.intValue(), 0);
                                arraylist.add(integer);
                            }
                        } while (true);
                        sampleIds.removeAll(arraylist);
                        if (sampleIds.size() == 0)
                        {
                            timer.cancel();
                            timer.purge();
                        }
                    }

            
            {
                this$1 = Audio.OnLoadCompleteListener.this;
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




        public Audio.OnLoadCompleteListener(SoundPool soundpool)
        {
            this$0 = Audio.this;
            super();
            sampleIds = new ArrayList();
            soundPool = soundpool;
        }
    }

    static class PickerActivity extends MMBaseActivity
    {

        private Uri fileUri;
        boolean hasRequestedPic;

        protected void onActivityResult(int i, int j, Intent intent)
        {
            super.onActivityResult(i, j, intent);
            if (intent == null) goto _L2; else goto _L1
_L1:
            Object obj1;
            Exception exception1;
            Object obj2;
            Object obj4;
            Object obj5;
            obj = null;
            obj5 = null;
            obj2 = null;
            exception1 = null;
            obj1 = null;
            obj4 = null;
            Uri uri = intent.getData();
            if (uri != null) goto _L4; else goto _L3
_L3:
            if (intent.getExtras() == null) goto _L2; else goto _L5
_L5:
            obj1 = (Bitmap)intent.getExtras().get("data");
            intent = new File(getIntent().getData().getPath());
            obj = new ByteArrayOutputStream();
            ((Bitmap) (obj1)).compress(android.graphics.Bitmap.CompressFormat.PNG, 0, ((OutputStream) (obj)));
            obj = new ByteArrayInputStream(((ByteArrayOutputStream) (obj)).toByteArray());
            intent = new FileOutputStream(intent);
            obj1 = new byte[1024];
_L8:
            i = ((ByteArrayInputStream) (obj)).read(((byte []) (obj1)));
            if (i <= 0) goto _L7; else goto _L6
_L6:
            intent.write(((byte []) (obj1)), 0, i);
              goto _L8
            obj;
_L27:
            if (true) goto _L10; else goto _L9
_L9:
            Exception exception;
            try
            {
                throw new NullPointerException();
            }
            // Misplaced declaration of an exception variable
            catch (Intent intent) { }
              goto _L2
_L10:
            if (intent == null) goto _L2; else goto _L11
_L11:
            intent.close();
_L2:
            synchronized (BridgeMMMedia.pickerActivityObject)
            {
                BridgeMMMedia.pickerActivityObject.notify();
            }
            finish();
            return;
_L7:
            if (true) goto _L13; else goto _L12
_L12:
            try
            {
                throw new NullPointerException();
            }
            // Misplaced declaration of an exception variable
            catch (Intent intent) { }
              goto _L2
_L13:
            if (intent == null) goto _L2; else goto _L14
_L14:
            intent.close();
              goto _L2
            intent;
            obj = obj2;
_L25:
            if (false)
            {
                Object obj3;
                try
                {
                    throw new NullPointerException();
                }
                // Misplaced declaration of an exception variable
                catch (Object obj) { }
                break MISSING_BLOCK_LABEL_251;
            }
            if (obj == null)
            {
                break MISSING_BLOCK_LABEL_251;
            }
            ((OutputStream) (obj)).close();
            try
            {
                throw intent;
            }
            // Misplaced declaration of an exception variable
            catch (Intent intent)
            {
                MMSDK.Log.e((new StringBuilder()).append("Error with picture: ").append(intent.getMessage()).toString());
            }
              goto _L2
_L4:
            if (uri == null) goto _L2; else goto _L15
_L15:
            intent = getContentResolver();
            if (intent == null) goto _L2; else goto _L16
_L16:
            obj3 = intent.query(uri, new String[] {
                "_data"
            }, null, null, null);
            if (obj3 == null) goto _L2; else goto _L17
_L17:
            i = ((Cursor) (obj3)).getColumnIndex("_data");
            if (i == -1) goto _L2; else goto _L18
_L18:
            ((Cursor) (obj3)).moveToFirst();
            intent = new File(((Cursor) (obj3)).getString(i));
            ((Cursor) (obj3)).close();
            obj3 = new File(getIntent().getData().getPath());
            intent = new FileInputStream(intent);
            obj = new FileOutputStream(((File) (obj3)));
            obj1 = new byte[1024];
_L21:
            i = intent.read(((byte []) (obj1)));
            if (i <= 0) goto _L20; else goto _L19
_L19:
            ((OutputStream) (obj)).write(((byte []) (obj1)), 0, i);
              goto _L21
            obj1;
_L24:
            if (intent == null)
            {
                break MISSING_BLOCK_LABEL_446;
            }
            intent.close();
            if (obj != null)
            {
                try
                {
                    ((OutputStream) (obj)).close();
                }
                // Misplaced declaration of an exception variable
                catch (Intent intent) { }
            }
              goto _L2
_L20:
            if (intent == null)
            {
                break MISSING_BLOCK_LABEL_471;
            }
            intent.close();
            if (obj != null)
            {
                try
                {
                    ((OutputStream) (obj)).close();
                }
                // Misplaced declaration of an exception variable
                catch (Intent intent) { }
            }
              goto _L2
            intent;
_L23:
            if (obj == null)
            {
                break MISSING_BLOCK_LABEL_499;
            }
            ((InputStream) (obj)).close();
            if (obj1 != null)
            {
                try
                {
                    ((OutputStream) (obj1)).close();
                }
                // Misplaced declaration of an exception variable
                catch (Object obj) { }
            }
            throw intent;
            intent;
            obj;
            JVM INSTR monitorexit ;
            throw intent;
            exception1;
            obj = intent;
            intent = exception1;
            continue; /* Loop/switch isn't completed */
            exception1;
            obj1 = obj;
            obj = intent;
            intent = exception1;
            if (true) goto _L23; else goto _L22
_L22:
            intent;
            intent = obj5;
            obj = exception1;
              goto _L24
            obj;
            obj = exception1;
              goto _L24
            exception;
            obj = intent;
            intent = exception;
              goto _L25
            intent;
            intent = obj4;
            if (true) goto _L27; else goto _L26
_L26:
        }

        public void onCreate(Bundle bundle)
        {
label0:
            {
                super.onCreate(bundle);
                if (getLastNonConfigurationInstance() != null)
                {
                    hasRequestedPic = ((Bundle)getLastNonConfigurationInstance()).getBoolean("hasRequestedPic");
                }
                if (!hasRequestedPic)
                {
                    if (!getIntent().getStringExtra("type").equalsIgnoreCase("Camera"))
                    {
                        break label0;
                    }
                    bundle = new Intent("android.media.action.IMAGE_CAPTURE");
                    fileUri = getIntent().getData();
                    bundle.putExtra("return-data", true);
                    hasRequestedPic = true;
                    startActivityForResult(bundle, 0);
                }
                return;
            }
            bundle = new Intent();
            bundle.setType("image/*");
            bundle.setAction("android.intent.action.GET_CONTENT");
            hasRequestedPic = true;
            startActivityForResult(bundle, 0);
        }

        public Object onRetainNonConfigurationInstance()
        {
            super.onRetainNonConfigurationInstance();
            Bundle bundle = new Bundle();
            bundle.putBoolean("hasRequestedPic", hasRequestedPic);
            return bundle;
        }

        PickerActivity()
        {
            hasRequestedPic = false;
        }
    }


    private static final String PATH = "path";
    private static final String PICTURES = "Pictures";
    private static Object pickerActivityObject;
    MediaScannerConnection mediaScanner;

    BridgeMMMedia()
    {
    }

    private static Bitmap centerOfImage(Bitmap bitmap, int i, int j)
    {
        float f = (bitmap.getWidth() - i) / 2;
        float f1 = (bitmap.getHeight() - j) / 2;
        return cropImage(bitmap, (int)f, (int)f1, i, j);
    }

    private static Bitmap cropImage(Bitmap bitmap, int i, int j, int k, int l)
    {
        return Bitmap.createBitmap(bitmap, i, j, k, l);
    }

    private boolean isCameraAvailable()
    {
        boolean flag1 = false;
        Context context = (Context)contextRef.get();
        boolean flag = flag1;
        if (context != null)
        {
            flag = flag1;
            if (context.getPackageManager().checkPermission("android.permission.CAMERA", context.getPackageName()) == 0)
            {
                Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                flag = flag1;
                if (context.getPackageManager().queryIntentActivities(intent, 0x10000).size() > 0)
                {
                    flag = true;
                }
            }
        }
        return flag;
    }

    private boolean isPictureChooserAvailable()
    {
        boolean flag1 = false;
        Context context = (Context)contextRef.get();
        boolean flag = flag1;
        if (context != null)
        {
            Intent intent = new Intent();
            intent.setType("image/*");
            intent.setAction("android.intent.action.GET_CONTENT");
            flag = flag1;
            if (context.getPackageManager().queryIntentActivities(intent, 0x10000).size() > 0)
            {
                flag = true;
            }
        }
        return flag;
    }

    private boolean moveFile(File file, File file1)
    {
        try
        {
            file = (new FileInputStream(file)).getChannel();
            file1.createNewFile();
            file1 = (new FileOutputStream(file1)).getChannel();
            file.transferTo(0L, file.size(), file1);
        }
        // Misplaced declaration of an exception variable
        catch (File file)
        {
            file.printStackTrace();
            return false;
        }
        return true;
    }

    private static Bitmap resizeImage(Bitmap bitmap, int i, int j, int k)
    {
        return Bitmap.createScaledBitmap(bitmap, i, j, true);
    }

    static Bitmap resizeImage(Bitmap bitmap, String s, int i, int j, int k)
    {
        float f = (float)i / (float)bitmap.getWidth();
        float f1 = (float)j / (float)bitmap.getHeight();
        if (s.equals("Center"))
        {
            return centerOfImage(bitmap, i, j);
        }
        if (s.equals("ScaleToAspectFit"))
        {
            f = Math.min(f, f1);
            return resizeImage(bitmap, (int)((float)bitmap.getWidth() * f), (int)((float)bitmap.getHeight() * f), k);
        }
        if (s.equals("ScaleToAspectFill"))
        {
            f = Math.max(f, f1);
            return cropImage(resizeImage(bitmap, (int)((float)bitmap.getWidth() * f), (int)((float)bitmap.getHeight() * f), k), 0, 0, i, j);
        } else
        {
            return resizeImage(bitmap, i, j, k);
        }
    }

    private static final byte[] scaleBitmapToBytes(File file, int i, int j, String s)
    {
        Object obj1;
        Object obj2;
        Bitmap bitmap;
        android.graphics.BitmapFactory.Options options;
        Object obj3;
        options = null;
        obj3 = null;
        obj1 = null;
        bitmap = null;
        obj2 = null;
        Object obj = new FileInputStream(file);
        int l;
        int i1;
        options = new android.graphics.BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(((InputStream) (obj)), null, options);
        l = options.outHeight;
        i1 = options.outWidth;
        int k = 1;
        if (l <= j && i1 <= i) goto _L2; else goto _L1
_L1:
        if (i1 <= l) goto _L4; else goto _L3
_L3:
        k = Math.round((float)l / (float)j);
_L2:
        file = new FileInputStream(file);
        options.inJustDecodeBounds = false;
        options.inSampleSize = k;
        obj1 = BitmapFactory.decodeStream(file, null, options);
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_137;
        }
        ((FileInputStream) (obj)).close();
        if (file == null)
        {
            break MISSING_BLOCK_LABEL_145;
        }
        file.close();
        obj = obj1;
_L10:
        file = null;
        if (obj == null) goto _L6; else goto _L5
_L5:
        bitmap = resizeImage(((Bitmap) (obj)), s, i, j, 1);
        file = null;
        obj2 = null;
        obj1 = new ByteArrayOutputStream();
        if (!s.equals("")) goto _L8; else goto _L7
_L7:
        ((Bitmap) (obj)).compress(android.graphics.Bitmap.CompressFormat.JPEG, 100, ((OutputStream) (obj1)));
_L12:
        s = ((ByteArrayOutputStream) (obj1)).toByteArray();
        float f;
        if (obj != null)
        {
            try
            {
                ((Bitmap) (obj)).recycle();
            }
            // Misplaced declaration of an exception variable
            catch (File file)
            {
                file.printStackTrace();
                return s;
            }
        }
        if (bitmap == null)
        {
            break MISSING_BLOCK_LABEL_229;
        }
        bitmap.recycle();
        file = s;
        if (obj1 == null) goto _L6; else goto _L9
_L9:
        ((ByteArrayOutputStream) (obj1)).close();
        file = s;
_L6:
        return file;
_L4:
        f = (float)i1 / (float)i;
        k = Math.round(f);
          goto _L2
        file;
        obj = obj1;
          goto _L10
        file;
        obj1 = bitmap;
        file = obj3;
_L18:
        if (file == null)
        {
            break MISSING_BLOCK_LABEL_287;
        }
        file.close();
        obj = obj2;
        if (obj1 == null) goto _L10; else goto _L11
_L11:
        ((FileInputStream) (obj1)).close();
        obj = obj2;
          goto _L10
        file;
        obj = obj2;
          goto _L10
        s;
        obj = obj1;
        file = options;
_L17:
        if (file == null)
        {
            break MISSING_BLOCK_LABEL_332;
        }
        file.close();
        if (obj != null)
        {
            try
            {
                ((FileInputStream) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (File file) { }
        }
        throw s;
_L8:
        bitmap.compress(android.graphics.Bitmap.CompressFormat.JPEG, 100, ((OutputStream) (obj1)));
          goto _L12
        file;
        s = ((String) (obj1));
        obj1 = file;
_L16:
        obj2 = null;
        file = s;
        ((Exception) (obj1)).printStackTrace();
        if (obj != null)
        {
            try
            {
                ((Bitmap) (obj)).recycle();
            }
            // Misplaced declaration of an exception variable
            catch (File file)
            {
                file.printStackTrace();
                return null;
            }
        }
        if (bitmap == null)
        {
            break MISSING_BLOCK_LABEL_397;
        }
        bitmap.recycle();
        file = obj2;
        if (s == null) goto _L6; else goto _L13
_L13:
        s.close();
        return null;
        s;
_L15:
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_435;
        }
        ((Bitmap) (obj)).recycle();
        if (bitmap == null)
        {
            break MISSING_BLOCK_LABEL_445;
        }
        bitmap.recycle();
        if (file != null)
        {
            try
            {
                file.close();
            }
            // Misplaced declaration of an exception variable
            catch (File file)
            {
                file.printStackTrace();
            }
        }
        throw s;
        s;
        file = ((File) (obj1));
        if (true) goto _L15; else goto _L14
_L14:
        obj1;
        s = obj2;
          goto _L16
        s;
        file = ((File) (obj));
        obj = obj1;
          goto _L17
        obj1;
        s = file;
        file = ((File) (obj));
        obj = s;
        s = ((String) (obj1));
          goto _L17
        file;
        file = ((File) (obj));
        obj1 = bitmap;
          goto _L18
        FileNotFoundException filenotfoundexception;
        filenotfoundexception;
        filenotfoundexception = file;
        file = ((File) (obj));
          goto _L18
    }

    private void scanMedia(final String path)
    {
        Context context = (Context)contextRef.get();
        if (context != null)
        {
            mediaScanner = new MediaScannerConnection(context.getApplicationContext(), new android.media.MediaScannerConnection.MediaScannerConnectionClient() {

                final BridgeMMMedia this$0;
                final String val$path;

                public void onMediaScannerConnected()
                {
                    if (mediaScanner != null)
                    {
                        mediaScanner.scanFile(path, null);
                    }
                }

                public void onScanCompleted(String s, Uri uri)
                {
                    if (uri == null)
                    {
                        MMSDK.Log.d((new StringBuilder()).append("Failed to scan ").append(s).toString());
                    }
                }

            
            {
                this$0 = BridgeMMMedia.this;
                path = s;
                super();
            }
            });
            if (mediaScanner != null)
            {
                mediaScanner.connect();
            }
        }
    }

    public MMJSResponse availableSourceTypes(HashMap hashmap)
    {
        hashmap = new JSONArray();
        if (isCameraAvailable())
        {
            hashmap.put("Camera");
        }
        if (isPictureChooserAvailable())
        {
            hashmap.put("Photo Library");
        }
        MMJSResponse mmjsresponse = new MMJSResponse();
        mmjsresponse.result = 1;
        mmjsresponse.response = hashmap;
        return mmjsresponse;
    }

    public MMJSResponse getPicture(HashMap hashmap)
    {
        this;
        JVM INSTR monitorenter ;
        Object obj;
        Context context;
        String s;
        String s1;
        context = (Context)contextRef.get();
        s = (String)hashmap.get("sourceType");
        obj1 = (String)hashmap.get("constrainHeight");
        s1 = (String)hashmap.get("constrainWidth");
        obj = (String)hashmap.get("contentMode");
        hashmap = ((HashMap) (obj));
        if (obj == null)
        {
            hashmap = "";
        }
          goto _L1
_L4:
        hashmap = MMJSResponse.responseWithError("Missing constrainHeight and/or constrainWidth");
_L2:
        this;
        JVM INSTR monitorexit ;
        return hashmap;
_L5:
        int i;
        int j;
        i = (int)Float.parseFloat(((String) (obj1)));
        j = (int)Float.parseFloat(s1);
        if (i * j <= 0x57e40)
        {
            break MISSING_BLOCK_LABEL_120;
        }
        hashmap = MMJSResponse.responseWithError("constrainHeight * constrainWidth > 360000");
          goto _L2
        if (context == null || s == null)
        {
            break MISSING_BLOCK_LABEL_351;
        }
        boolean flag;
        obj = new File(AdCache.getCacheDirectory(context), (new StringBuilder()).append("tmp_mm_").append(String.valueOf(System.currentTimeMillis())).append(".jpg").toString());
        if (s.equalsIgnoreCase("Camera") && isCameraAvailable())
        {
            break MISSING_BLOCK_LABEL_223;
        }
        if (!s.equalsIgnoreCase("Photo Library") && !s.equalsIgnoreCase("PhotoLibrary"))
        {
            break MISSING_BLOCK_LABEL_351;
        }
        flag = isPictureChooserAvailable();
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_351;
        }
        pickerActivityObject = new Object();
        synchronized (pickerActivityObject)
        {
            Utils.IntentUtils.startPickerActivity(context, ((File) (obj)), s);
            pickerActivityObject.wait();
        }
        pickerActivityObject = null;
_L3:
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_351;
        }
        byte abyte0[];
        if (!((File) (obj)).exists() || ((File) (obj)).length() <= 0L)
        {
            break MISSING_BLOCK_LABEL_351;
        }
        abyte0 = scaleBitmapToBytes(((File) (obj)), j, i, hashmap);
        ((File) (obj)).delete();
        if (abyte0 == null)
        {
            break MISSING_BLOCK_LABEL_351;
        }
        hashmap = new MMJSResponse();
        hashmap.result = 1;
        hashmap.dataResponse = abyte0;
          goto _L2
        hashmap;
        throw hashmap;
        exception;
        obj1;
        JVM INSTR monitorexit ;
        throw exception;
        Exception exception1;
        exception1;
        exception1.printStackTrace();
        pickerActivityObject = null;
          goto _L3
        hashmap;
        pickerActivityObject = null;
        throw hashmap;
        hashmap = null;
          goto _L2
_L1:
        if (obj1 != null && s1 != null) goto _L5; else goto _L4
    }

    public MMJSResponse isSourceTypeAvailable(HashMap hashmap)
    {
        hashmap = (String)hashmap.get("sourceType");
        if (hashmap != null)
        {
            if (hashmap.equalsIgnoreCase("Camera") && isCameraAvailable())
            {
                return MMJSResponse.responseWithSuccess("true");
            }
            if (hashmap.equalsIgnoreCase("Photo Library") && isPictureChooserAvailable())
            {
                return MMJSResponse.responseWithSuccess("true");
            }
        }
        return MMJSResponse.responseWithError("false");
    }

    public MMJSResponse playAudio(HashMap hashmap)
    {
        Context context = (Context)contextRef.get();
        Object obj = (String)hashmap.get("path");
        if (context != null && obj != null)
        {
            if (Audio.sharedAudio(context).isPlaying())
            {
                return MMJSResponse.responseWithError("Audio already playing.");
            }
            if (((String) (obj)).startsWith("http"))
            {
                return Audio.sharedAudio(context).playAudio(Uri.parse(((String) (obj))), Boolean.parseBoolean((String)hashmap.get("repeat")));
            }
            obj = AdCache.getDownloadFile(context, ((String) (obj)));
            if (((File) (obj)).exists())
            {
                return Audio.sharedAudio(context).playAudio(Uri.fromFile(((File) (obj))), Boolean.parseBoolean((String)hashmap.get("repeat")));
            }
        }
        return null;
    }

    public MMJSResponse playSound(HashMap hashmap)
    {
        Context context = (Context)contextRef.get();
        hashmap = (String)hashmap.get("path");
        if (context != null && hashmap != null)
        {
            hashmap = AdCache.getDownloadFile(context, hashmap);
            if (hashmap.exists())
            {
                return Audio.sharedAudio((Context)contextRef.get()).playSound(hashmap);
            }
        }
        return null;
    }

    public MMJSResponse playVideo(HashMap hashmap)
    {
        Context context = (Context)contextRef.get();
        hashmap = (String)hashmap.get("path");
        if (context != null && hashmap != null)
        {
            if (hashmap.startsWith("http"))
            {
                Utils.IntentUtils.startVideoPlayerActivityWithData(context, hashmap);
                return MMJSResponse.responseWithSuccess(hashmap);
            }
            hashmap = AdCache.getDownloadFile(context, hashmap);
            if (hashmap.exists())
            {
                Utils.IntentUtils.startVideoPlayerActivityWithData(context, hashmap);
                return MMJSResponse.responseWithSuccess(hashmap.getName());
            }
        }
        return null;
    }

    public MMJSResponse stopAudio(HashMap hashmap)
    {
        return Audio.sharedAudio((Context)contextRef.get()).stop();
    }

    public MMJSResponse writeToPhotoLibrary(HashMap hashmap)
    {
        this;
        JVM INSTR monitorenter ;
        File file;
        Context context;
        Uri uri;
        Object obj;
        context = (Context)contextRef.get();
        uri = Uri.parse((String)hashmap.get("path"));
        file = new File((new StringBuilder()).append(AdCache.getCacheDirectory(context).getAbsolutePath()).append(File.separator).append("Pictures").append(File.separator).append(uri.getLastPathSegment()).toString());
        obj = uri.getScheme();
        if (obj == null) goto _L2; else goto _L1
_L1:
        if (!((String) (obj)).equals("http")) goto _L2; else goto _L3
_L3:
        hashmap.put("url", uri.toString());
        hashmap.put("path", uri.getLastPathSegment());
        obj = new BridgeMMFileManager();
        ((BridgeMMFileManager) (obj)).setContext(context);
        if (((BridgeMMFileManager) (obj)).downloadFile(hashmap) != null) goto _L2; else goto _L4
_L4:
        hashmap = MMJSResponse.responseWithError("Failed to download");
_L10:
        this;
        JVM INSTR monitorexit ;
        return hashmap;
_L2:
        hashmap = AdCache.getDownloadFile(context, uri.getLastPathSegment());
        if (!hashmap.exists())
        {
            hashmap = MMJSResponse.responseWithError((new StringBuilder()).append("No file at ").append(hashmap.getAbsolutePath()).toString());
            continue; /* Loop/switch isn't completed */
        }
        if (!moveFile(hashmap, file)) goto _L6; else goto _L5
_L5:
        hashmap = file.getAbsolutePath();
_L8:
        scanMedia(hashmap);
        hashmap = MMJSResponse.responseWithSuccess("Image saved to photo library");
        continue; /* Loop/switch isn't completed */
_L6:
        hashmap = hashmap.getAbsolutePath();
        if (true) goto _L8; else goto _L7
_L7:
        hashmap;
        throw hashmap;
        if (true) goto _L10; else goto _L9
_L9:
    }

}
