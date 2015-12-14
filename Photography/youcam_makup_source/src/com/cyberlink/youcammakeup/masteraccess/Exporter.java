// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.masteraccess;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.location.Location;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.util.Pair;
import android.webkit.MimeTypeMap;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.c;
import com.cyberlink.youcammakeup.database.n;
import com.cyberlink.youcammakeup.database.o;
import com.cyberlink.youcammakeup.database.p;
import com.cyberlink.youcammakeup.database.r;
import com.cyberlink.youcammakeup.jniproxy.UIImageCodecErrorCode;
import com.cyberlink.youcammakeup.jniproxy.UIImageFormat;
import com.cyberlink.youcammakeup.jniproxy.UIImageOrientation;
import com.cyberlink.youcammakeup.jniproxy.ba;
import com.cyberlink.youcammakeup.jniproxy.k;
import com.cyberlink.youcammakeup.jniproxy.v;
import com.cyberlink.youcammakeup.kernelctrl.BeautifierManager;
import com.cyberlink.youcammakeup.kernelctrl.BeautifierTaskInfo;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.BeautifierEditCenter;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.e;
import com.cyberlink.youcammakeup.kernelctrl.f;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.kernelctrl.status.a;
import com.cyberlink.youcammakeup.kernelctrl.viewengine.ImageBufferWrapper;
import com.cyberlink.youcammakeup.kernelctrl.viewengine.ViewEngine;
import com.cyberlink.youcammakeup.kernelctrl.z;
import com.cyberlink.youcammakeup.setting.PhotoQuality;
import com.cyberlink.youcammakeup.utility.aa;
import com.cyberlink.youcammakeup.utility.bb;
import com.cyberlink.youcammakeup.utility.d;
import com.cyberlink.youcammakeup.utility.y;
import com.perfectcorp.utility.h;
import com.pf.common.utility.m;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Referenced classes of package com.cyberlink.youcammakeup.masteraccess:
//            a, c, d, b

public class Exporter
{

    private static SimpleDateFormat a;
    private final p b = com.cyberlink.youcammakeup.c.f();
    private final ViewEngine c = ViewEngine.a();
    private final k d = new k(Globals.d().l());
    private ExecutorService e;

    public Exporter()
    {
        e = Executors.newFixedThreadPool(4);
    }

    public static Uri a(String s)
    {
        return a(s, ((com.cyberlink.youcammakeup.masteraccess.a) (null)));
    }

    public static Uri a(String s, com.cyberlink.youcammakeup.masteraccess.a a1)
    {
        ContentResolver contentresolver = Globals.d().getContentResolver();
        long l1 = System.currentTimeMillis() / 1000L;
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("date_modified", Long.valueOf(l1));
        contentvalues.put("_data", s);
        s = bb.b(s)[1];
        s = MimeTypeMap.getSingleton().getMimeTypeFromExtension(s);
        if (s != null && !s.isEmpty())
        {
            contentvalues.put("mime_type", s);
        }
        if (a1 != null && a1.a)
        {
            s = y.a().c();
            if (s != null)
            {
                com.pf.common.utility.m.b("masteraccess.Exporter", "Insert location");
                contentvalues.put("latitude", Double.valueOf(s.getLatitude()));
                contentvalues.put("longitude", Double.valueOf(s.getLongitude()));
            } else
            {
                com.pf.common.utility.m.b("masteraccess.Exporter", "Location is null");
            }
        }
        try
        {
            s = contentresolver.insert(c.a, contentvalues);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return null;
        }
        return s;
    }

    private ba a(Pair pair)
    {
        Object obj;
        com.android.camera.exif.c c1;
        c1 = new com.android.camera.exif.c();
        c1.a(((Double)pair.first).doubleValue(), ((Double)pair.second).doubleValue());
        pair = Bitmap.createBitmap(1, 1, android.graphics.Bitmap.Config.ARGB_8888);
        obj = new ByteArrayOutputStream();
        c1.a(pair, ((java.io.OutputStream) (obj)));
        com.cyberlink.youcammakeup.utility.d.a(((java.io.Closeable) (obj)));
        aa.a(pair);
        pair = ((ByteArrayOutputStream) (obj)).toByteArray();
        obj = new ba();
        Object obj1;
        if (ViewEngine.a().a(pair, ((ba) (obj))))
        {
            return ((ba) (obj));
        } else
        {
            return null;
        }
        obj1;
        com.pf.common.utility.m.b("masteraccess.Exporter", "getGpsMetadata", ((Throwable) (obj1)));
        com.cyberlink.youcammakeup.utility.d.a(((java.io.Closeable) (obj)));
        aa.a(pair);
        return null;
        obj1;
        com.cyberlink.youcammakeup.utility.d.a(((java.io.Closeable) (obj)));
        aa.a(pair);
        throw obj1;
    }

    static ba a(Exporter exporter, Pair pair)
    {
        return exporter.a(pair);
    }

    static k a(Exporter exporter)
    {
        return exporter.d;
    }

    public static String a()
    {
        if (!d())
        {
            z.a("PHOTO_SAVE_PATH", "Local", Globals.d());
        }
        if (z.b("PHOTO_SAVE_PATH", "Local", Globals.d()).equalsIgnoreCase("SD Card"))
        {
            String s = c();
            StringBuilder stringbuilder = new StringBuilder();
            stringbuilder.append(s);
            stringbuilder.append(Globals.c);
            stringbuilder.append("YouCam Makeup");
            return stringbuilder.toString();
        } else
        {
            return l();
        }
    }

    public static void a(int i1)
    {
        File file = new File(Globals.d().getExternalCacheDir(), "Export_temp");
        Calendar calendar = Calendar.getInstance();
        calendar.add(5, i1 * -1);
        long l1 = calendar.getTimeInMillis();
        if (file.exists())
        {
            File afile[] = file.listFiles();
            int j1 = afile.length;
            for (i1 = 0; i1 < j1; i1++)
            {
                File file1 = afile[i1];
                if (file1.isFile() && file1.lastModified() < l1 && !file1.delete())
                {
                    file1.deleteOnExit();
                }
            }

        }
    }

    private void a(long l1, File file, UIImageCodecErrorCode uiimagecodecerrorcode, ImageBufferWrapper imagebufferwrapper, UIImageOrientation uiimageorientation, com.cyberlink.youcammakeup.masteraccess.c c1)
    {
        Globals globals = Globals.d();
        String s = file.getPath();
        file = new android.media.MediaScannerConnection.OnScanCompletedListener(imagebufferwrapper, c1, uiimageorientation, uiimagecodecerrorcode, l1, file) {

            final ImageBufferWrapper a;
            final com.cyberlink.youcammakeup.masteraccess.c b;
            final UIImageOrientation c;
            final UIImageCodecErrorCode d;
            final long e;
            final File f;
            final Exporter g;

            public void onScanCompleted(String s1, Uri uri)
            {
                Object obj;
                long l2;
                obj = com.cyberlink.youcammakeup.c.e();
                uri = com.cyberlink.youcammakeup.c.f();
                s1 = ((n) (obj)).a(s1);
                if (s1 == null)
                {
                    a.m();
                    b.a(new Error(com.cyberlink.youcammakeup.masteraccess.Error.JavaError.e));
                    return;
                }
                obj = ((n) (obj)).a(s1.longValue());
                if (obj == null)
                {
                    a.m();
                    b.a(new Error(Error.JavaError.g));
                    return;
                }
                l2 = uri.f(s1.longValue());
                if (l2 == -1L)
                {
                    a.m();
                    b.a(new Error(com.cyberlink.youcammakeup.masteraccess.Error.JavaError.f));
                    return;
                }
                if (a != null)
                {
                    ViewEngine.a().a(l2, a, c);
                }
                if (a != null)
                {
                    a.m();
                }
_L2:
                s1 = new b(d, e, l2, ((Long) (obj)).longValue(), f);
                b.a(s1);
                return;
                s1;
                if (a != null)
                {
                    a.m();
                }
                if (true) goto _L2; else goto _L1
_L1:
                s1;
                if (a != null)
                {
                    a.m();
                }
                throw s1;
            }

            
            {
                g = Exporter.this;
                a = imagebufferwrapper;
                b = c1;
                c = uiimageorientation;
                d = uiimagecodecerrorcode;
                e = l1;
                f = file;
                super();
            }

            private class Error
            {

                private final JavaError a;
                private final UIImageCodecErrorCode b;

                public JavaError a()
                {
                    return a;
                }

                public UIImageCodecErrorCode b()
                {
                    return b;
                }

                Error(UIImageCodecErrorCode uiimagecodecerrorcode)
                {
                    class JavaError extends Enum
                    {

                        public static final JavaError a;
                        public static final JavaError b;
                        public static final JavaError c;
                        public static final JavaError d;
                        public static final JavaError e;
                        public static final JavaError f;
                        public static final JavaError g;
                        public static final JavaError h;
                        public static final JavaError i;
                        public static final JavaError j;
                        public static final JavaError k;
                        private static final JavaError l[];

                        public static JavaError valueOf(String s)
                        {
                            return (JavaError)Enum.valueOf(com/cyberlink/youcammakeup/masteraccess/Exporter$Error$JavaError, s);
                        }

                        public static JavaError[] values()
                        {
                            return (JavaError[])l.clone();
                        }

                        static 
                        {
                            a = new JavaError("NoError", 0);
                            b = new JavaError("InvalidBuffer", 1);
                            c = new JavaError("MakeDirs", 2);
                            d = new JavaError("PathNotFolder", 3);
                            e = new JavaError("FailedToGetFileId", 4);
                            f = new JavaError("FailedToGetImageId", 5);
                            g = new JavaError("FailedToGetAlbumId", 6);
                            h = new JavaError("ViewEngine", 7);
                            i = new JavaError("UnsupportExportFormat", 8);
                            j = new JavaError("FileNotFound", 9);
                            k = new JavaError("OutOfMemory", 10);
                            l = (new JavaError[] {
                                a, b, c, d, e, f, g, h, i, j, 
                                k
                            });
                        }

                        private JavaError(String s, int i1)
                        {
                            super(s, i1);
                        }
                    }

                    a = com.cyberlink.youcammakeup.masteraccess.JavaError.a;
                    b = uiimagecodecerrorcode;
                }

                Error(JavaError javaerror)
                {
                    a = javaerror;
                    b = UIImageCodecErrorCode.a;
                }
            }

        };
        MediaScannerConnection.scanFile(globals, new String[] {
            s
        }, null, file);
    }

    public static void a(ContentResolver contentresolver, File file)
    {
        file = file.getAbsolutePath();
        file = contentresolver.query(android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[] {
            "_id"
        }, "_data = ?", new String[] {
            file
        }, null);
        if (file.moveToFirst())
        {
            long l1 = file.getLong(file.getColumnIndexOrThrow("_id"));
            contentresolver.delete(ContentUris.withAppendedId(android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI, l1), null, null);
        }
        file.close();
    }

    public static boolean a(com.cyberlink.youcammakeup.masteraccess.c c1, File file)
    {
        if (file.exists()) goto _L2; else goto _L1
_L1:
        if (file.mkdirs())
        {
            break MISSING_BLOCK_LABEL_65;
        }
        if (c1 != null)
        {
            c1.a(new Error(com.cyberlink.youcammakeup.masteraccess.Error.JavaError.c));
        }
_L4:
        return false;
_L2:
        if (file.isDirectory())
        {
            break MISSING_BLOCK_LABEL_65;
        }
        if (c1 == null) goto _L4; else goto _L3
_L3:
        c1.a(new Error(com.cyberlink.youcammakeup.masteraccess.Error.JavaError.d));
        return false;
        return true;
    }

    public static String b()
    {
        return l();
    }

    private void b(long l1, boolean flag, com.cyberlink.youcammakeup.masteraccess.c c1)
    {
        com.cyberlink.youcammakeup.kernelctrl.viewengine.c c2 = new com.cyberlink.youcammakeup.kernelctrl.viewengine.c(com.cyberlink.youcammakeup.kernelctrl.viewengine.ViewEngine.TaskRole.a);
        com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.DevelopSetting developsetting = com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.e.a().a(Long.valueOf(l1), Boolean.valueOf(true));
        c1 = new com.cyberlink.youcammakeup.masteraccess.d(c1, l1, flag);
        c.a(l1, 1.0D, developsetting, c2, c1);
    }

    public static String c()
    {
        Object obj = Globals.d().getApplicationContext();
        if (android.os.Build.VERSION.SDK_INT == 19)
        {
            obj = null;
        } else
        {
            String s = m();
            com.pf.common.utility.m.b("SDCARD", (new StringBuilder()).append("[Exporter] - secondaryStorage: ").append(s).toString());
            if (s != null)
            {
                if (android.os.Build.VERSION.SDK_INT > 19)
                {
                    obj = com.perfectcorp.utility.h.a(new String[] {
                        s, Environment.DIRECTORY_DCIM
                    });
                    com.pf.common.utility.m.b("SDCARD", (new StringBuilder()).append("[Exporter] - android version higher than kitkat with path: ").append(((String) (obj))).toString());
                    return ((String) (obj));
                }
                com.pf.common.utility.m.b("SDCARD", "[Exporter] - android version lower than kitkat");
                Object obj1 = ((Context) (obj)).getExternalFilesDir(null);
                obj = s;
                if (obj1 != null)
                {
                    obj1 = ((File) (obj1)).getAbsolutePath();
                    int i1 = ((String) (obj1)).indexOf("/Android");
                    obj = s;
                    if (i1 != -1)
                    {
                        return (new StringBuilder()).append(s).append(((String) (obj1)).substring(i1)).toString();
                    }
                }
            } else
            {
                return null;
            }
        }
        return ((String) (obj));
    }

    private void c(long l1, boolean flag, com.cyberlink.youcammakeup.masteraccess.c c1)
    {
        BeautifierManager beautifiermanager = BeautifierManager.a();
        beautifiermanager.c(new f(c1, beautifiermanager, l1, flag) {

            final com.cyberlink.youcammakeup.masteraccess.c a;
            final BeautifierManager b;
            final long c;
            final boolean d;
            final Exporter e;

            public void a(BeautifierTaskInfo beautifiertaskinfo)
            {
                if (!beautifiertaskinfo.a())
                {
                    a.a(new Error(com.cyberlink.youcammakeup.masteraccess.Error.JavaError.k));
                    return;
                } else
                {
                    b.i();
                    beautifiertaskinfo = b.g();
                    e.a(c, beautifiertaskinfo, d, a);
                    return;
                }
            }

            
            {
                e = Exporter.this;
                a = c1;
                b = beautifiermanager;
                c = l1;
                d = flag;
                super();
            }
        });
        beautifiermanager.a(BeautifierEditCenter.a().d(), false, false);
    }

    public static boolean d()
    {
        Object obj;
        obj = c();
        com.pf.common.utility.m.b("SDCARD", (new StringBuilder()).append("[Exporter] - path: ").append(((String) (obj))).toString());
        if (obj != null && !((String) (obj)).isEmpty()) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        obj = com.perfectcorp.utility.h.a(new String[] {
            obj, "YouCam Makeup"
        });
        com.pf.common.utility.m.b("SDCARD", (new StringBuilder()).append("[Exporter] - saveFolder: ").append(((String) (obj))).toString());
        if (!a(((com.cyberlink.youcammakeup.masteraccess.c) (null)), new File(((String) (obj)))))
        {
            com.pf.common.utility.m.b("SDCARD", "[Exporter] - can't make file folder");
            return false;
        }
        obj = com.perfectcorp.utility.h.a(new String[] {
            obj, "YouCam Makeup.temp"
        });
        com.pf.common.utility.m.b("SDCARD", (new StringBuilder()).append("[Exporter] - tempPath: ").append(((String) (obj))).toString());
        File file = new File(((String) (obj)));
        if (file.exists())
        {
            file.delete();
        }
        FileOutputStream fileoutputstream = new FileOutputStream(((String) (obj)));
        fileoutputstream.write(String.valueOf(System.currentTimeMillis()).getBytes());
        fileoutputstream.close();
        obj = new File(((String) (obj)));
        Object obj1;
        if (((File) (obj)).exists())
        {
            ((File) (obj)).delete();
            return true;
        } else
        {
            return true;
        }
        obj1;
        ((Exception) (obj1)).printStackTrace();
        obj = new File(((String) (obj)));
        if (!((File) (obj)).exists()) goto _L1; else goto _L3
_L3:
        ((File) (obj)).delete();
        return false;
        obj1;
        obj = new File(((String) (obj)));
        if (((File) (obj)).exists())
        {
            ((File) (obj)).delete();
        }
        throw obj1;
    }

    public static String e()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(Globals.d().getFilesDir());
        stringbuilder.append(Globals.c);
        stringbuilder.append("My Looks");
        return stringbuilder.toString();
    }

    public static String f()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(Globals.d().getFilesDir());
        stringbuilder.append(Globals.c);
        stringbuilder.append("wigThumb");
        return stringbuilder.toString();
    }

    public static String g()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(Environment.getExternalStorageDirectory());
        stringbuilder.append(Globals.c);
        stringbuilder.append(Environment.DIRECTORY_DCIM);
        stringbuilder.append(Globals.c);
        stringbuilder.append("YouCam Makeup");
        stringbuilder.append(Globals.c);
        stringbuilder.append("YouCam Makeup Sample");
        return stringbuilder.toString();
    }

    public static String h()
    {
        return p();
    }

    public static String i()
    {
        String s = o().format(Long.valueOf(System.currentTimeMillis()));
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(b());
        stringbuilder.append(Globals.c);
        stringbuilder.append(s);
        stringbuilder.append(".jpg");
        return stringbuilder.toString();
    }

    public static String j()
    {
        String s = o().format(Long.valueOf(System.currentTimeMillis()));
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(e());
        stringbuilder.append(Globals.c);
        stringbuilder.append(s);
        stringbuilder.append(".jpg");
        return stringbuilder.toString();
    }

    static String k()
    {
        return p();
    }

    private static String l()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(Environment.getExternalStorageDirectory());
        stringbuilder.append(Globals.c);
        stringbuilder.append(Environment.DIRECTORY_DCIM);
        stringbuilder.append(Globals.c);
        stringbuilder.append("YouCam Makeup");
        return stringbuilder.toString();
    }

    private static String m()
    {
        String s = System.getenv("SECONDARY_STORAGE");
        if (s != null && !s.isEmpty())
        {
            String as[] = s.split(":");
            int j1 = as.length;
            for (int i1 = 0; i1 < j1; i1++)
            {
                String s1 = as[i1];
                File file1 = new File(s1);
                if (file1.exists() && file1.isDirectory() && file1.canWrite())
                {
                    return s1;
                }
            }

        }
        for (Iterator iterator = n().iterator(); iterator.hasNext();)
        {
            File file = (File)iterator.next();
            if (!file.getAbsolutePath().equals("/mnt/sdcard") && !file.getAbsolutePath().equals(Environment.getExternalStoragePublicDirectory("").getAbsolutePath()) && file.getAbsolutePath().toLowerCase(Locale.US).contains("sd") && file.exists() && file.canRead())
            {
                return file.getAbsolutePath();
            }
        }

        return null;
    }

    private static Set n()
    {
        HashSet hashset = new HashSet();
        Object obj1 = new Scanner(new File("/proc/mounts"));
_L4:
        Object obj = obj1;
        if (!((Scanner) (obj1)).hasNext()) goto _L2; else goto _L1
_L1:
        obj = obj1;
        String s = ((Scanner) (obj1)).nextLine();
        obj = obj1;
        if (!s.startsWith("/dev/block/vold/")) goto _L4; else goto _L3
_L3:
        obj = obj1;
        hashset.add(new File(s.split(" ")[1]));
          goto _L4
        Exception exception;
        exception;
_L10:
        obj = obj1;
        exception.printStackTrace();
        if (obj1 != null)
        {
            ((Scanner) (obj1)).close();
        }
_L6:
        return hashset;
_L2:
        if (obj1 == null) goto _L6; else goto _L5
_L5:
        ((Scanner) (obj1)).close();
        return hashset;
        obj1;
        obj = null;
_L8:
        if (obj != null)
        {
            ((Scanner) (obj)).close();
        }
        throw obj1;
        obj1;
        if (true) goto _L8; else goto _L7
_L7:
        exception;
        obj1 = null;
        if (true) goto _L10; else goto _L9
_L9:
    }

    private static SimpleDateFormat o()
    {
        if (a == null)
        {
            a = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss-SSS", Locale.US);
        }
        return a;
    }

    private static String p()
    {
        String s = o().format(Long.valueOf(System.currentTimeMillis()));
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(a());
        stringbuilder.append(Globals.c);
        stringbuilder.append(s);
        stringbuilder.append(".jpg");
        return stringbuilder.toString();
    }

    public void a(long l1, ImageBufferWrapper imagebufferwrapper, boolean flag, com.cyberlink.youcammakeup.masteraccess.c c1)
    {
        o o1 = b.b(l1);
        if (imagebufferwrapper == null)
        {
            if (c1 != null)
            {
                c1.a(new Error(Error.JavaError.b));
            }
        } else
        if (o1 == null)
        {
            if (c1 != null)
            {
                c1.a(new Error(Error.JavaError.j));
                return;
            }
        } else
        {
            (new AsyncTask(flag, c1, imagebufferwrapper, l1, o1) {

                final boolean a;
                final com.cyberlink.youcammakeup.masteraccess.c b;
                final ImageBufferWrapper c;
                final long d;
                final o e;
                final Exporter f;

                protected transient Void a(Void avoid[])
                {
                    File file;
                    Object obj;
                    v v1;
                    String s;
                    if (a)
                    {
                        file = new File(Globals.d().getExternalCacheDir(), "Export_temp");
                    } else
                    {
                        file = new File(com.cyberlink.youcammakeup.masteraccess.Exporter.a());
                    }
                    if (!com.cyberlink.youcammakeup.masteraccess.Exporter.a(b, file))
                    {
                        return null;
                    }
                    obj = c.j();
                    ba ba1;
                    if (StatusManager.j().f(d) != null)
                    {
                        avoid = StatusManager.j().f(d).d;
                    } else
                    {
                        avoid = com.cyberlink.youcammakeup.c.f().c(d);
                        if (avoid != null)
                        {
                            avoid = avoid.d();
                        } else
                        {
                            avoid = UIImageOrientation.b;
                        }
                    }
                    v1 = new v();
                    v1.a(UIImageFormat.b);
                    v1.a(avoid);
                    v1.a(94);
                    s = e.b();
                    ba1 = new ba();
                    com.cyberlink.youcammakeup.masteraccess.Exporter.a(f).a(s, ba1);
                    s = com.cyberlink.youcammakeup.masteraccess.Exporter.h();
                    if (!a) goto _L2; else goto _L1
_L1:
                    bb.a(file);
                    file = File.createTempFile(s, ".jpg", file);
                    file.deleteOnExit();
_L3:
                    obj = com.cyberlink.youcammakeup.masteraccess.Exporter.a(f).a(file.getPath(), ((com.cyberlink.youcammakeup.jniproxy.d) (obj)), v1, ba1);
                    if (obj != UIImageCodecErrorCode.a)
                    {
                        c.m();
                        b.a(new Error(((UIImageCodecErrorCode) (obj))));
                    }
                    BeautifierManager.a().h();
                    if (!a)
                    {
                        break MISSING_BLOCK_LABEL_362;
                    }
                    c.m();
                    b.a(new b(((UIImageCodecErrorCode) (obj)), -1L, -1L, -1L, file));
_L4:
                    return null;
_L2:
                    if (v1.b() == UIImageFormat.b)
                    {
                        break MISSING_BLOCK_LABEL_341;
                    }
                    b.a(new Error(Error.JavaError.i));
                    return null;
                    file = new File(s);
                      goto _L3
                    try
                    {
                        f.a(d, file, ((UIImageCodecErrorCode) (obj)), c, avoid, null, b);
                    }
                    // Misplaced declaration of an exception variable
                    catch (Void avoid[])
                    {
                        avoid.printStackTrace();
                    }
                      goto _L4
                }

                protected Object doInBackground(Object aobj[])
                {
                    return a((Void[])aobj);
                }

            
            {
                f = Exporter.this;
                a = flag;
                b = c1;
                c = imagebufferwrapper;
                d = l1;
                e = o1;
                super();
            }
            }).executeOnExecutor(e, new Void[0]);
            return;
        }
    }

    public void a(long l1, File file, UIImageCodecErrorCode uiimagecodecerrorcode, ImageBufferWrapper imagebufferwrapper, UIImageOrientation uiimageorientation, com.cyberlink.youcammakeup.masteraccess.a a1, 
            com.cyberlink.youcammakeup.masteraccess.c c1)
    {
        a1 = a(file.getAbsolutePath(), a1);
        if (a1 == null)
        {
            a1 = com.cyberlink.youcammakeup.c.e().a(file.getPath());
        } else
        {
            a1 = com.cyberlink.youcammakeup.c.e().a(a1);
        }
        Long long1;
        long l2;
        if (a1 != null)
        {
            if ((long1 = com.cyberlink.youcammakeup.c.e().a(a1.longValue())) != null && (l2 = com.cyberlink.youcammakeup.c.f().f(a1.longValue())) != -1L)
            {
                if (imagebufferwrapper != null)
                {
                    imagebufferwrapper.m();
                }
                c1.a(new b(uiimagecodecerrorcode, l1, l2, long1.longValue(), file));
                return;
            }
        }
        a(l1, file, uiimagecodecerrorcode, imagebufferwrapper, uiimageorientation, c1);
    }

    public void a(long l1, boolean flag, com.cyberlink.youcammakeup.masteraccess.c c1)
    {
        a(3);
        if (PhotoQuality.a(l1))
        {
            c(l1, flag, c1);
            return;
        } else
        {
            b(l1, flag, c1);
            return;
        }
    }

    public void a(UIImageOrientation uiimageorientation, ImageBufferWrapper imagebufferwrapper, boolean flag, com.cyberlink.youcammakeup.masteraccess.c c1)
    {
        (new AsyncTask(c1, imagebufferwrapper, uiimageorientation, flag) {

            final com.cyberlink.youcammakeup.masteraccess.c a;
            final ImageBufferWrapper b;
            final UIImageOrientation c;
            final boolean d;
            final Exporter e;

            protected transient Void a(Void avoid[])
            {
                for (avoid = new File(com.cyberlink.youcammakeup.masteraccess.Exporter.a()); !com.cyberlink.youcammakeup.masteraccess.Exporter.a(a, avoid) || b == null;)
                {
                    return null;
                }

                Object obj1 = b.j();
                v v1 = new v();
                v1.a(UIImageFormat.b);
                v1.a(c);
                v1.a(94);
                File file = new File(com.cyberlink.youcammakeup.masteraccess.Exporter.k());
                if (d)
                {
                    Pair pair = y.a().b();
                    Object obj;
                    if (pair != y.a)
                    {
                        obj = com.cyberlink.youcammakeup.masteraccess.Exporter.a(e, pair);
                        if (obj != null)
                        {
                            avoid = new com.cyberlink.youcammakeup.masteraccess.a();
                            avoid.a = true;
                            avoid.b = ((Double)pair.first).doubleValue();
                            avoid.c = ((Double)pair.second).doubleValue();
                        } else
                        {
                            avoid = null;
                        }
                    } else
                    {
                        obj = null;
                        avoid = null;
                    }
                    obj1 = com.cyberlink.youcammakeup.masteraccess.Exporter.a(e).a(file.getPath(), ((com.cyberlink.youcammakeup.jniproxy.d) (obj1)), v1, ((ba) (obj)));
                    obj = avoid;
                    avoid = ((Void []) (obj1));
                } else
                {
                    avoid = com.cyberlink.youcammakeup.masteraccess.Exporter.a(e).a(file.getPath(), ((com.cyberlink.youcammakeup.jniproxy.d) (obj1)), v1, null);
                    obj = null;
                }
                if (avoid != UIImageCodecErrorCode.a)
                {
                    b.m();
                    a.a(new Error(avoid));
                }
                e.a(-1L, file, avoid, b, c, ((com.cyberlink.youcammakeup.masteraccess.a) (obj)), a);
                return null;
            }

            protected Object doInBackground(Object aobj[])
            {
                return a((Void[])aobj);
            }

            
            {
                e = Exporter.this;
                a = c1;
                b = imagebufferwrapper;
                c = uiimageorientation;
                d = flag;
                super();
            }
        }).executeOnExecutor(e, new Void[0]);
    }

    public void a(ba ba1, UIImageOrientation uiimageorientation, ImageBufferWrapper imagebufferwrapper, String s, com.cyberlink.youcammakeup.masteraccess.c c1)
    {
        (new AsyncTask(s, c1, imagebufferwrapper, uiimageorientation, ba1) {

            final String a;
            final com.cyberlink.youcammakeup.masteraccess.c b;
            final ImageBufferWrapper c;
            final UIImageOrientation d;
            final ba e;
            final Exporter f;

            protected transient Void a(Void avoid[])
            {
                avoid = (new File(a)).getParentFile();
                if (avoid != null && !com.cyberlink.youcammakeup.masteraccess.Exporter.a(b, avoid))
                {
                    return null;
                }
                Object obj = c.j();
                v v1 = new v();
                v1.a(UIImageFormat.b);
                v1.a(d);
                v1.a(94);
                avoid = new File(a);
                obj = com.cyberlink.youcammakeup.masteraccess.Exporter.a(f).a(avoid.getPath(), ((com.cyberlink.youcammakeup.jniproxy.d) (obj)), v1, e);
                if (obj != UIImageCodecErrorCode.a)
                {
                    c.m();
                    b.a(new Error(((UIImageCodecErrorCode) (obj))));
                }
                b.a(new b(((UIImageCodecErrorCode) (obj)), -1L, -1L, -1L, avoid));
                return null;
            }

            protected Object doInBackground(Object aobj[])
            {
                return a((Void[])aobj);
            }

            
            {
                f = Exporter.this;
                a = s;
                b = c1;
                c = imagebufferwrapper;
                d = uiimageorientation;
                e = ba1;
                super();
            }
        }).executeOnExecutor(e, new Void[0]);
    }
}
