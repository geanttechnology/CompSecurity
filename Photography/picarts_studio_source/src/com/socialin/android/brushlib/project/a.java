// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.brushlib.project;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.os.Environment;
import com.picsart.studio.PicsartContext;
import com.socialin.android.brushlib.layer.BlendMode;
import com.socialin.android.brushlib.state.LayerMetaInfo;
import com.socialin.android.brushlib.state.Snapshot;
import com.socialin.android.brushlib.util.b;
import com.socialin.android.photo.exception.InvalidIndexFileException;
import com.socialin.android.util.FileUtils;
import com.socialin.android.util.w;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import myobfuscated.br.d;

// Referenced classes of package com.socialin.android.brushlib.project:
//            Project, c

public class a
{

    public static final String a = (new StringBuilder()).append(Environment.getExternalStorageDirectory()).append("/PicsArt/").toString();
    public static final String b = (new StringBuilder()).append(Environment.getExternalStorageDirectory()).append("/PicsArt/drawing/").toString();
    public static final String c = (new StringBuilder()).append(b).append("tracked/").toString();
    public static final String d = (new StringBuilder()).append(b).append("untracked/").toString();
    private static final String e = com/socialin/android/brushlib/project/a.getSimpleName();
    private static final Comparator f = new Comparator() {

        private static Snapshot a(File file)
        {
            List list = FileUtils.e(new File(file, "INDEX"));
            if (list.size() != 2)
            {
                return null;
            } else
            {
                return myobfuscated.br.d.a(new File(file, (String)list.get(0)));
            }
        }

        public final int compare(Object obj, Object obj1)
        {
            obj = (Project)obj;
            obj1 = (Project)obj1;
            obj = a(((Project) (obj)).getRootFolder());
            obj1 = a(((Project) (obj1)).getRootFolder());
            if (obj != null && obj1 != null)
            {
                if (((Snapshot) (obj)).creationDate > ((Snapshot) (obj1)).creationDate)
                {
                    return -1;
                }
                if (((Snapshot) (obj)).creationDate < ((Snapshot) (obj1)).creationDate)
                {
                    return 1;
                }
            }
            return 0;
        }

    };
    private static ExecutorService g = Executors.newSingleThreadExecutor();

    public a()
    {
    }

    public static Project a(Project project, String s)
    {
        s = new Project(new File(c, s), false);
        FileUtils.a(project.getRootFolder(), s.getRootFolder());
        return s;
    }

    public static List a()
    {
        boolean flag = false;
        Object obj = new FileFilter() {

            public final boolean accept(File file2)
            {
                return file2.isDirectory() && (new File(file2, "INDEX")).exists();
            }

        };
        File file = new File(c);
        File afile1[] = (new File(b)).listFiles(((FileFilter) (obj)));
        if (afile1 != null)
        {
            int l = afile1.length;
            for (int i = 0; i < l; i++)
            {
                File file1 = afile1[i];
                file1.renameTo(new File(file, file1.getName()));
            }

        }
        file = new File(c);
        afile1 = new File(d);
        FileFilter filefilter = new FileFilter() {

            public final boolean accept(File file2)
            {
                return file2.isDirectory() && (new File(file2, "INDEX")).exists();
            }

        };
        File afile[] = file.listFiles(filefilter);
        afile1 = afile1.listFiles(filefilter);
        if (afile != null && afile1 != null)
        {
            ArrayList arraylist = new ArrayList();
            int i1 = afile.length;
            for (int j = 0; j < i1; j++)
            {
                Project project1 = new Project(afile[j], false);
                if (project1.isValid())
                {
                    arraylist.add(project1);
                }
            }

            i1 = afile1.length;
            for (int k = ((flag) ? 1 : 0); k < i1; k++)
            {
                Project project = new Project(afile1[k], true);
                if (project.isValid())
                {
                    arraylist.add(project);
                }
            }

            Collections.sort(arraylist, f);
            return arraylist;
        } else
        {
            return Collections.emptyList();
        }
    }

    public static void a(Project project, c c1)
    {
        g.execute(new Runnable(project, c1) {

            private Project a;
            private c b;

            public final void run()
            {
                File afile[] = a.getRootFolder().listFiles();
                if (afile != null)
                {
                    int j = afile.length;
                    int i = 0;
                    while (i < j) 
                    {
                        File file = afile[i];
                        String s = file.getName();
                        if (b != null && !b.a(s))
                        {
                            if (file.isFile())
                            {
                                file.delete();
                            } else
                            if (file.isDirectory())
                            {
                                FileUtils.b(file);
                            }
                        }
                        i++;
                    }
                }
            }

            
            {
                a = project;
                b = c1;
                super();
            }
        });
    }

    public static void a(File file, int i)
    {
        Bitmap bitmap;
        File file1;
        Canvas canvas1;
        Bitmap bitmap1;
        ByteBuffer bytebuffer;
        Paint paint1;
        Iterator iterator;
        int j;
        int k;
        List list = FileUtils.e(new File(file, "INDEX"));
        if (list.size() != 2)
        {
            throw new InvalidIndexFileException("Index file must contain 2 lines");
        }
        Snapshot snapshot = myobfuscated.br.d.a(new File(file, (String)list.get(0)));
        if (snapshot == null)
        {
            throw new InvalidIndexFileException("Current snapshot cannot be read");
        }
        list = snapshot.layerInfoList;
        file1 = new File(file, (new StringBuilder()).append(snapshot.key).append(".thumb").toString());
        j = ((LayerMetaInfo)list.get(0)).width;
        k = ((LayerMetaInfo)list.get(0)).height;
        bitmap = Bitmap.createBitmap(j, k, android.graphics.Bitmap.Config.ARGB_8888);
        canvas1 = new Canvas(bitmap);
        bitmap1 = Bitmap.createBitmap(j, k, android.graphics.Bitmap.Config.ARGB_8888);
        bytebuffer = myobfuscated.br.d.a(bitmap1.getRowBytes() * bitmap1.getHeight());
        paint1 = new Paint(2);
        iterator = list.iterator();
_L6:
        Object obj;
        Object obj1;
        Object obj2;
        Object obj3;
        LayerMetaInfo layermetainfo;
        if (!iterator.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        layermetainfo = (LayerMetaInfo)iterator.next();
        obj3 = null;
        obj = null;
        obj2 = obj;
        obj1 = obj3;
        if (!layermetainfo.currentBufferKey.equals(layermetainfo.origBufferKey)) goto _L2; else goto _L1
_L1:
        obj2 = obj;
        obj1 = obj3;
        obj = new RandomAccessFile(new File(new File(file, "orig-buffers"), layermetainfo.currentBufferKey), "r");
_L4:
        obj2 = obj;
        obj1 = obj;
        bytebuffer.rewind();
        obj2 = obj;
        obj1 = obj;
        myobfuscated.br.d.b(bytebuffer, ((RandomAccessFile) (obj)));
        obj2 = obj;
        obj1 = obj;
        bytebuffer.rewind();
        obj2 = obj;
        obj1 = obj;
        bitmap1.copyPixelsFromBuffer(bytebuffer);
        obj2 = obj;
        obj1 = obj;
        if (!layermetainfo.isVisible)
        {
            break MISSING_BLOCK_LABEL_418;
        }
        obj2 = obj;
        obj1 = obj;
        paint1.setXfermode(layermetainfo.getBlendMode().getXfermode());
        obj2 = obj;
        obj1 = obj;
        paint1.setAlpha(layermetainfo.opacity);
        obj2 = obj;
        obj1 = obj;
        canvas1.drawBitmap(bitmap1, 0.0F, 0.0F, paint1);
        try
        {
            ((RandomAccessFile) (obj)).close();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            com.socialin.android.d.b(e, new Object[] {
                (new StringBuilder("Got unexpected exception: ")).append(((IOException) (obj)).getMessage()).toString()
            });
        }
        continue; /* Loop/switch isn't completed */
_L2:
        obj2 = obj;
        obj1 = obj3;
        obj = new RandomAccessFile(new File(file, layermetainfo.currentBufferKey), "r");
        if (true) goto _L4; else goto _L3
_L3:
        FileNotFoundException filenotfoundexception;
        filenotfoundexception;
        obj1 = obj2;
        com.socialin.android.d.b(e, new Object[] {
            (new StringBuilder("Got unexpected exception: ")).append(filenotfoundexception.getMessage()).toString()
        });
        if (obj2 != null)
        {
            try
            {
                ((RandomAccessFile) (obj2)).close();
            }
            catch (IOException ioexception)
            {
                com.socialin.android.d.b(e, new Object[] {
                    (new StringBuilder("Got unexpected exception: ")).append(ioexception.getMessage()).toString()
                });
            }
        }
        if (true) goto _L6; else goto _L5
        file;
        if (obj1 != null)
        {
            try
            {
                ((RandomAccessFile) (obj1)).close();
            }
            catch (IOException ioexception1)
            {
                com.socialin.android.d.b(e, new Object[] {
                    (new StringBuilder("Got unexpected exception: ")).append(ioexception1.getMessage()).toString()
                });
            }
        }
        throw file;
_L5:
        myobfuscated.br.d.a(bytebuffer);
        bitmap1.recycle();
        float f1 = (float)i / (float)Math.min(j, k);
        if (j != i || k != i)
        {
            Paint paint = new Paint(2);
            file = Bitmap.createBitmap(i, i, android.graphics.Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(file);
            canvas.scale(f1, f1);
            canvas.translate(((float)i / f1 - (float)j) / 2.0F, ((float)i / f1 - (float)k) / 2.0F);
            canvas.drawBitmap(bitmap, 0.0F, 0.0F, paint);
            bitmap.recycle();
        } else
        {
            file = bitmap;
        }
        com.socialin.android.brushlib.util.b.a(file, file1.getPath());
        file.recycle();
        return;
    }

    public static boolean a(File file)
    {
        List list = FileUtils.e(new File(file, "INDEX"));
        if (list.size() != 2)
        {
            return false;
        }
        file = myobfuscated.br.d.a(new File(file, (String)list.get(0)));
        if (file == null)
        {
            return false;
        }
        if (((Snapshot) (file)).layerInfoList.size() > PicsartContext.a.getMaxDrawingLayersCount())
        {
            return false;
        }
        int i = ((LayerMetaInfo)((Snapshot) (file)).layerInfoList.get(0)).width;
        return ((LayerMetaInfo)((Snapshot) (file)).layerInfoList.get(0)).height * i <= PicsartContext.a();
    }

    public static PointF b(File file)
    {
        file = myobfuscated.br.d.a(new File(file, (String)FileUtils.e(new File(file, "INDEX")).get(0)));
        if (file != null)
        {
            return new PointF(((LayerMetaInfo)((Snapshot) (file)).layerInfoList.get(0)).width, ((LayerMetaInfo)((Snapshot) (file)).layerInfoList.get(0)).height);
        } else
        {
            return null;
        }
    }

    public static void b()
    {
        g.execute(new Runnable() {

            public final void run()
            {
                File afile[] = (new File(com.socialin.android.brushlib.project.a.d)).listFiles();
                if (afile != null)
                {
                    int j = afile.length;
                    int i = 0;
                    while (i < j) 
                    {
                        File file = afile[i];
                        if (file.isFile())
                        {
                            file.delete();
                        } else
                        if (file.isDirectory())
                        {
                            FileUtils.b(file);
                        }
                        i++;
                    }
                }
            }

        });
    }

    public static boolean b(Project project, String s)
    {
        boolean flag = false;
        s = new File(c, s);
        if (!s.getParentFile().exists())
        {
            s.getParentFile().mkdirs();
        }
        if (project.getRootFolder().renameTo(s))
        {
            project.setProjectRoot(s);
            project.setDraft(false);
            flag = true;
        }
        return flag;
    }

    public static Bitmap c(File file)
    {
        Object obj = FileUtils.e(new File(file, "INDEX"));
        if (((List) (obj)).size() != 2)
        {
            throw new InvalidIndexFileException("Index file must contain 2 lines");
        }
        obj = myobfuscated.br.d.a(new File(file, (String)((List) (obj)).get(0)));
        if (obj != null)
        {
            file = new File(file, (new StringBuilder()).append(((Snapshot) (obj)).key).append(".thumb").toString());
            if (file.exists())
            {
                return BitmapFactory.decodeFile(file.getAbsolutePath());
            } else
            {
                return null;
            }
        } else
        {
            return null;
        }
    }

    public static boolean d(File file)
    {
        Object obj = FileUtils.e(new File(file, "INDEX"));
        if (((List) (obj)).size() != 2)
        {
            throw new InvalidIndexFileException("Index file must contain 2 lines");
        }
        obj = (String)((List) (obj)).get(0);
        file = new File(file, (new StringBuilder()).append(((String) (obj))).append(".thumb").toString());
        if (file.exists())
        {
            return w.e(file.getAbsolutePath());
        } else
        {
            return false;
        }
    }

    static 
    {
        (new StringBuilder()).append(a).append("video/");
        (new StringBuilder()).append(a).append("exportDrawing/");
        (new File(c)).mkdirs();
        (new File(d)).mkdirs();
    }
}
