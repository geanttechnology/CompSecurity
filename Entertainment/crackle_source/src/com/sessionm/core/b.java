// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sessionm.core;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import com.sessionm.a.a;
import com.sessionm.net.http.DownloadService;
import com.sessionm.ui.SessionMVideoView;
import com.sessionm.ui.VideoErrorListener;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import org.json.JSONObject;

// Referenced classes of package com.sessionm.core:
//            f, c, i

public class b
    implements com.sessionm.net.http.b, VideoErrorListener
{

    public static final String DATA = "data";
    public static final String SIZE = "size";
    public static final String STATUS = "status";
    private static final String TAG = "SessionM.FileCache";
    public static final String TYPE = "type";
    public static final String URL = "url";
    public static final String aX = "md5";
    private static final String aY = "sm_cached_files";
    private static final String aZ = "com.sessionm.filecache.prefs.file";
    private static final String ba = "com.sessionm.filecache.prefs.urls.file";
    private static final String bb = "com.sessionm.filecache.enabled.key";
    private static final String bc = "smdownload";
    private static final String bd = "SHA-1";
    private static final String be = "ad";
    public static final String bf = "achievement";
    private Context bg;
    private boolean bh;
    private c bi;
    private boolean bj;
    private final List bk = new ArrayList();
    private ExecutorService bl;

    public b(Context context, ExecutorService executorservice)
    {
        bj = false;
        bg = context.getApplicationContext();
        bl = executorservice;
        DownloadService.setListener(this);
        c(bg.getSharedPreferences("com.sessionm.filecache.prefs.file", 0).getBoolean("com.sessionm.filecache.enabled.key", false));
    }

    static Context a(b b1)
    {
        return b1.bg;
    }

    static List b(b b1)
    {
        return b1.bk;
    }

    private File c(String s1)
    {
        if (s1 == null || TextUtils.isEmpty(s1))
        {
            return null;
        } else
        {
            return new File(f(bg), e(s1));
        }
    }

    static void c(b b1)
    {
        b1.n();
    }

    private File d(String s1)
    {
        s1 = String.format(Locale.US, "%s.%s", new Object[] {
            e(s1), "smdownload"
        });
        return new File(f(bg), s1);
    }

    private String e(String s1)
    {
        return com.sessionm.a.a.c(s1, "SHA-1");
    }

    private File f(Context context)
    {
        if (bj)
        {
            return new File(Environment.getExternalStorageDirectory(), "sm_cached_files");
        } else
        {
            return new File(context.getCacheDir(), "sm_cached_files");
        }
    }

    private void n()
    {
        Iterator iterator = bk.iterator();
_L4:
        if (!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        Object obj;
        int j;
        obj = (com.sessionm.b.a)iterator.next();
        j = ((com.sessionm.b.a) (obj)).getInt("status");
        obj = ((com.sessionm.b.a) (obj)).getString("type");
        if (obj == null || !((String) (obj)).equals("achievement") || j == 1) goto _L4; else goto _L3
_L3:
        if (Log.isLoggable("SessionM.FileCache", 3))
        {
            Log.d("SessionM.FileCache", String.format(Locale.US, "Achievement loaded with error: %s", new Object[] {
                Integer.valueOf(j)
            }));
        }
_L6:
        return;
_L2:
        if (Log.isLoggable("SessionM.FileCache", 3))
        {
            Log.d("SessionM.FileCache", "All achievements are successfully loaded. Notifying cache listeners.");
        }
        com.sessionm.core.f.E().an();
        if (bi != null)
        {
            bi.e(this);
            return;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    private void s()
    {
        bl.execute(new Runnable() {

            final b bm;

            public void run()
            {
                android.content.SharedPreferences.Editor editor = com.sessionm.core.b.a(bm).getSharedPreferences("com.sessionm.filecache.prefs.urls.file", 0).edit();
                editor.clear();
                editor.commit();
                com.sessionm.b.a a1;
                for (Iterator iterator = b.b(bm).iterator(); iterator.hasNext(); editor.putString(a1.getString("url"), a1.aI().toString()))
                {
                    a1 = (com.sessionm.b.a)iterator.next();
                }

                editor.commit();
                if (b.b(bm).size() > 0)
                {
                    b.c(bm);
                }
            }

            
            {
                bm = b.this;
                super();
            }
        });
    }

    public void a(c c1)
    {
        bi = c1;
    }

    public void a(DownloadService downloadservice, String s1, int j)
    {
        this;
        JVM INSTR monitorenter ;
        a(s1, j);
        if (j != 1) goto _L2; else goto _L1
_L1:
        downloadservice = c(s1);
        if (!d(s1).renameTo(downloadservice))
        {
            c(true);
        }
_L4:
        if (bi != null)
        {
            bi.d(this);
        }
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (j != 7) goto _L4; else goto _L3
_L3:
        c(true);
          goto _L4
        downloadservice;
        throw downloadservice;
    }

    public void a(String s1, int j)
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = bh;
        if (!flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (Log.isLoggable("SessionM.FileCache", 3))
        {
            Log.d("SessionM.FileCache", String.format(Locale.US, "Setting url status code %s: %s", new Object[] {
                Integer.valueOf(j), s1
            }));
        }
        if (j == 1)
        {
            break MISSING_BLOCK_LABEL_85;
        }
        File file = c(s1);
        if (file.exists() && !file.delete())
        {
            c(true);
        }
        Iterator iterator = bk.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            com.sessionm.b.a a1 = (com.sessionm.b.a)iterator.next();
            if (a1.getString("url").equals(s1))
            {
                a1.put("status", j);
            }
        } while (true);
        break MISSING_BLOCK_LABEL_145;
        s1;
        throw s1;
        s();
          goto _L1
    }

    public void a(com.sessionm.b.a aa[])
    {
        this;
        JVM INSTR monitorenter ;
        if (aa == null) goto _L2; else goto _L1
_L1:
        if (aa.length != 0) goto _L3; else goto _L2
_L2:
        p();
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L3:
        File file;
        file = f(bg);
        if (file.exists() || file.mkdirs())
        {
            break MISSING_BLOCK_LABEL_54;
        }
        c(true);
          goto _L4
        aa;
        throw aa;
label0:
        {
            if (file.isDirectory())
            {
                break label0;
            }
            c(true);
        }
          goto _L4
        File afile[];
        int j1;
        afile = file.listFiles();
        j1 = afile.length;
        int k = 0;
_L8:
        if (k >= j1) goto _L6; else goto _L5
_L5:
        File file1 = afile[k];
        String s2;
        int k1;
        s2 = file1.getName();
        k1 = aa.length;
        int l;
        int i1;
        l = 0;
        i1 = 1;
_L7:
        if (l >= k1)
        {
            break MISSING_BLOCK_LABEL_181;
        }
        String s4 = e(aa[l].getString("url"));
        int j;
        if (s4.equals(s2))
        {
            j = 0;
            break MISSING_BLOCK_LABEL_388;
        }
        j = i1;
        if (!s2.startsWith(s4))
        {
            break MISSING_BLOCK_LABEL_388;
        }
        j = i1;
        if (s2.endsWith("smdownload"))
        {
            j = 0;
        }
        break MISSING_BLOCK_LABEL_388;
        if (i1 == 0)
        {
            break MISSING_BLOCK_LABEL_401;
        }
        if (Log.isLoggable("SessionM.FileCache", 3))
        {
            Log.d("SessionM.FileCache", String.format(Locale.US, "Discarding file not in url list: %s", new Object[] {
                s2
            }));
        }
        if (file1.delete())
        {
            break MISSING_BLOCK_LABEL_401;
        }
        c(true);
          goto _L4
_L6:
        k = aa.length;
        String s1;
        com.sessionm.b.a a1;
        String s3;
        String s5;
        for (j = 0; j >= k; j++)
        {
            break MISSING_BLOCK_LABEL_381;
        }

        a1 = aa[j];
        s3 = a1.getString("url");
        s5 = a1.getString("md5");
        s1 = null;
        if (s5 != null)
        {
            s1 = "MD5";
        }
        l = a1.getInt("size");
        if (!a(s3))
        {
            a1.put("status", 0);
            bk.add(a1);
            DownloadService.start(bg, s3, d(s3).getAbsolutePath(), s5, s1, l);
            if (bi != null)
            {
                bi.a(this, s3);
            }
            break MISSING_BLOCK_LABEL_410;
        }
        a1.put("status", 1);
        bk.add(a1);
        break MISSING_BLOCK_LABEL_410;
        s();
          goto _L4
        l++;
        i1 = j;
          goto _L7
        k++;
          goto _L8
    }

    public boolean a(String s1)
    {
        if (s1 != null && !TextUtils.isEmpty(s1))
        {
            s1 = c(s1);
            if (!m() && s1 != null && s1.exists())
            {
                return true;
            }
        }
        return false;
    }

    public Uri b(String s1)
    {
        if (c(s1) == null)
        {
            return null;
        } else
        {
            return Uri.fromFile(c(s1));
        }
    }

    public void c(boolean flag)
    {
        if (bh == flag)
        {
            return;
        }
        bh = flag;
        android.content.SharedPreferences.Editor editor;
        if (bh)
        {
            DownloadService.setListener(null);
            bk.clear();
            s();
        } else
        {
            DownloadService.setListener(this);
        }
        editor = bg.getSharedPreferences("com.sessionm.filecache.prefs.file", 0).edit();
        editor.putBoolean("com.sessionm.filecache.enabled.key", flag);
        editor.commit();
    }

    public boolean d(int j)
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = a(f(j).getString("url"));
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    public String e(int j)
    {
        this;
        JVM INSTR monitorenter ;
        String s1 = null;
        com.sessionm.b.a a1 = f(j);
        if (a1 == null)
        {
            break MISSING_BLOCK_LABEL_25;
        }
        s1 = f(a1.getString("url"));
        this;
        JVM INSTR monitorexit ;
        return s1;
        Exception exception;
        exception;
        throw exception;
    }

    public com.sessionm.b.a f(int j)
    {
        for (Iterator iterator = bk.iterator(); iterator.hasNext();)
        {
            com.sessionm.b.a a1 = (com.sessionm.b.a)iterator.next();
            if (a1.getInt("id") == j)
            {
                return a1;
            }
        }

        return null;
    }

    public String f(String s1)
    {
        s1 = c(s1);
        if (s1 == null)
        {
            return null;
        }
        ByteArrayOutputStream bytearrayoutputstream;
        try
        {
            s1 = new BufferedInputStream(new FileInputStream(s1));
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            return null;
        }
        bytearrayoutputstream = new ByteArrayOutputStream();
        try
        {
            com.sessionm.core.i.a(s1, bytearrayoutputstream);
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            return null;
        }
        return bytearrayoutputstream.toString();
    }

    public boolean m()
    {
        return bh;
    }

    public com.sessionm.b.a o()
    {
        this;
        JVM INSTR monitorenter ;
        Object obj1 = bk.iterator();
        int j = 0;
_L8:
        Object obj;
        String s1;
        if (!((Iterator) (obj1)).hasNext())
        {
            break MISSING_BLOCK_LABEL_120;
        }
        obj = (com.sessionm.b.a)((Iterator) (obj1)).next();
        s1 = ((com.sessionm.b.a) (obj)).getString("type");
        if (s1 == null) goto _L2; else goto _L1
_L1:
        if (!s1.equalsIgnoreCase("ad") || ((com.sessionm.b.a) (obj)).getInt("status") != 1) goto _L2; else goto _L3
_L3:
        obj1 = obj;
        if (obj == null) goto _L5; else goto _L4
_L4:
        if (!a(((com.sessionm.b.a) (obj)).getString("url"))) goto _L7; else goto _L6
_L6:
        bk.remove(j);
        obj1 = obj;
_L5:
        this;
        JVM INSTR monitorexit ;
        return ((com.sessionm.b.a) (obj1));
_L2:
        j++;
          goto _L8
_L7:
        obj1 = null;
          goto _L5
        obj;
        throw obj;
        obj = null;
          goto _L3
    }

    public boolean onVideoError(SessionMVideoView sessionmvideoview, int j, int k)
    {
        this;
        JVM INSTR monitorenter ;
        a(sessionmvideoview.getUrl(), 3);
        if (bi != null)
        {
            bi.d(this);
        }
        this;
        JVM INSTR monitorexit ;
        return false;
        sessionmvideoview;
        throw sessionmvideoview;
    }

    public void p()
    {
        this;
        JVM INSTR monitorenter ;
        c(false);
        bj = false;
        com.sessionm.core.i.a(f(bg));
        android.content.SharedPreferences.Editor editor = bg.getSharedPreferences("com.sessionm.filecache.prefs.file", 0).edit();
        editor.clear();
        editor.commit();
        bk.clear();
        s();
        if (bi != null)
        {
            bi.d(this);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public com.sessionm.b.a[] q()
    {
        this;
        JVM INSTR monitorenter ;
        com.sessionm.b.a aa[] = (com.sessionm.b.a[])bk.toArray(new com.sessionm.b.a[0]);
        this;
        JVM INSTR monitorexit ;
        return aa;
        Exception exception;
        exception;
        throw exception;
    }

    com.sessionm.b.a[] r()
    {
        SharedPreferences sharedpreferences = bg.getSharedPreferences("com.sessionm.filecache.prefs.urls.file", 0);
        ArrayList arraylist = new ArrayList();
        Iterator iterator = sharedpreferences.getAll().keySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Object obj = sharedpreferences.getString((String)iterator.next(), null);
            if (obj != null)
            {
                obj = com.sessionm.b.a.w(((String) (obj)));
                if (obj != null)
                {
                    arraylist.add(obj);
                }
            }
        } while (true);
        return (com.sessionm.b.a[])arraylist.toArray(new com.sessionm.b.a[0]);
    }

    public int size()
    {
        int j;
        int l;
        j = 0;
        l = 0;
        if (!m()) goto _L2; else goto _L1
_L1:
        int k = l;
_L4:
        return k;
_L2:
        File file = f(bg);
        k = l;
        if (!file.exists())
        {
            continue;
        }
        k = l;
        if (file.listFiles() == null)
        {
            continue;
        }
        File afile[] = file.listFiles();
        int i1 = afile.length;
        l = 0;
        do
        {
            k = j;
            if (l >= i1)
            {
                continue;
            }
            File file1 = afile[l];
            j = (int)((long)j + file1.length());
            l++;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }
}
