// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.recorder;

import android.content.Context;
import co.vine.android.util.CrashUtil;
import co.vine.android.util.SystemUtil;
import com.edisonwang.android.slog.SLog;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import org.apache.commons.io.FileUtils;

// Referenced classes of package co.vine.android.recorder:
//            RecordSessionVersion, RecordConfigUtils, RecordSession, RecordSessionMeta, 
//            RecordingFile

public class RecordSessionManager
{
    public static class NotEnoughSpaceException extends IOException
    {

        public NotEnoughSpaceException()
        {
        }
    }

    public static class RecordSessionInfo
        implements Comparable
    {

        public final File folder;
        public final RecordSessionMeta meta;
        public final File thumb;
        public final File video;

        public int compareTo(RecordSessionInfo recordsessioninfo)
        {
            return Long.valueOf(folder.getName()).compareTo(Long.valueOf(recordsessioninfo.folder.getName()));
        }

        public volatile int compareTo(Object obj)
        {
            return compareTo((RecordSessionInfo)obj);
        }

        public RecordSessionInfo(File file, File file1, File file2, RecordSessionMeta recordsessionmeta)
        {
            folder = file;
            thumb = file1;
            video = file2;
            meta = recordsessionmeta;
        }
    }


    public static RecordSessionVersion DEFAULT_VERSION;
    private static final int REQUIRED_SPACE_LIMIT = 0x1400000;
    private static final HashSet sDeletedSessions;
    private final File mDir;
    private final RecordSessionVersion mVersion;

    public RecordSessionManager(Context context, RecordSessionVersion recordsessionversion)
        throws IOException
    {
        File file;
        mVersion = recordsessionversion;
        file = null;
        File file1 = context.getExternalFilesDir(null);
        file = file1;
_L1:
        File file2 = file;
        if (file == null)
        {
            SLog.e("Failed to create drafts in external folder.");
            file2 = context.getFilesDir();
        }
        mDir = new File(file2, recordsessionversion.folder);
        if (mDir.exists() && !mDir.isDirectory())
        {
            FileUtils.forceDelete(mDir);
        }
        FileUtils.forceMkdir(mDir);
        RuntimeException runtimeexception;
        long l;
        try
        {
            l = mDir.getFreeSpace();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return;
        }
        if (l <= 0L || l >= 0x1400000L)
        {
            break MISSING_BLOCK_LABEL_123;
        }
        throw new NotEnoughSpaceException();
        SLog.d("free space left: {}.", Long.valueOf(l));
        return;
        runtimeexception;
          goto _L1
    }

    public static void deleteSession(File file, String s)
        throws IOException
    {
        CrashUtil.log("Session deleted: {}, {}.", new Object[] {
            s, file
        });
        if (sDeletedSessions.size() > 10)
        {
            sDeletedSessions.clear();
        }
        sDeletedSessions.add(file.getAbsolutePath());
        FileUtils.deleteDirectory(file);
    }

    public static RecordSessionVersion getCurrentVersion(Context context)
    {
        return DEFAULT_VERSION;
    }

    public static File getDataFile(File file, boolean flag)
    {
        String s;
        if (flag)
        {
            s = "data.bin";
        } else
        {
            s = "data.temp";
        }
        return new File(file, s);
    }

    public static File getFrameInfoFile(File file)
    {
        return new File(file, "frame.info");
    }

    public static File getMetaFile(File file)
    {
        return new File(file, "meta.bin");
    }

    public static int getNumberOfValidSessions(Context context, RecordSessionVersion recordsessionversion)
        throws IOException
    {
        context = getValidSessions(context, recordsessionversion);
        if (context != null)
        {
            return context.size();
        } else
        {
            return 0;
        }
    }

    public static String getPreviewThumbnailPath(File file)
    {
        return (new File(file, "preview.jpg")).getAbsolutePath();
    }

    public static String getPreviewVideoPath(RecordSessionVersion recordsessionversion, File file)
    {
        return (new File(file, (new StringBuilder()).append("preview").append(recordsessionversion.videoOutputExtension).toString())).getAbsolutePath();
    }

    public static String getSegmentThumbnailPath(File file)
    {
        return (new File(file, "segment.jpg")).getAbsolutePath();
    }

    public static String getSegmentVideoPath(RecordSessionVersion recordsessionversion, File file)
    {
        return (new File(file, (new StringBuilder()).append("segment_").append(System.currentTimeMillis()).append(recordsessionversion.videoOutputExtension).toString())).getAbsolutePath();
    }

    public static String getThumbnailPath(File file)
    {
        return (new File(file, "thumbnail.jpg")).getAbsolutePath();
    }

    public static ArrayList getValidSessions(Context context, RecordSessionVersion recordsessionversion)
        throws IOException
    {
        return recordsessionversion.getManager(context).getValidSessions();
    }

    public static String getVideoPath(RecordSessionVersion recordsessionversion, File file)
    {
        return (new File(file, (new StringBuilder()).append("video").append(recordsessionversion.videoOutputExtension).toString())).getAbsolutePath();
    }

    public static boolean isSessionSaved(File file)
    {
        return getMetaFile(file).exists() && getDataFile(file, true).exists();
    }

    public static RecordSession readDataObject(File file)
        throws IOException
    {
        return (RecordSession)readObject(getDataFile(file, true));
    }

    public static RecordSessionMeta readMetaObject(File file)
        throws IOException
    {
        return (RecordSessionMeta)readObject(getMetaFile(file));
    }

    private static Object readObject(File file)
        throws IOException
    {
        try
        {
            if (!file.exists())
            {
                throw new FileNotFoundException((new StringBuilder()).append("File not found: ").append(file.getPath()).toString());
            }
        }
        // Misplaced declaration of an exception variable
        catch (File file)
        {
            throw new IOException("Invalid file found.", file);
        }
        Object obj = new BufferedInputStream(new FileInputStream(file));
        obj = new ObjectInputStream(((java.io.InputStream) (obj)));
        Object obj1 = ((ObjectInput) (obj)).readObject();
        ((ObjectInput) (obj)).close();
        return obj1;
        Exception exception;
        exception;
        ((ObjectInput) (obj)).close();
        throw exception;
        EOFException eofexception;
        eofexception;
        SLog.e("Failed to read a corrupted file.");
        FileUtils.deleteQuietly(file);
        throw eofexception;
    }

    public static boolean wasSessionJustDeleted(File file)
    {
        return sDeletedSessions.contains(file.getAbsolutePath());
    }

    private static void writeData(File file, RecordSession recordsession, boolean flag)
        throws IOException
    {
        writeObject(getDataFile(file, flag), recordsession);
        if (flag)
        {
            FileUtils.deleteQuietly(getDataFile(file, false));
        }
    }

    private static void writeMeta(File file, RecordSessionMeta recordsessionmeta)
        throws IOException
    {
        writeObject(getMetaFile(file), recordsessionmeta);
    }

    private static void writeObject(File file, Object obj)
        throws IOException
    {
        ObjectOutputStream objectoutputstream;
        CrashUtil.log("Writing: {}.", new Object[] {
            file
        });
        SystemUtil.quietlyEnsureParentExists(file);
        objectoutputstream = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
        objectoutputstream.writeObject(obj);
        objectoutputstream.close();
        CrashUtil.log("Closed: {}.", new Object[] {
            file
        });
        return;
        obj;
        objectoutputstream.close();
        CrashUtil.log("Closed: {}.", new Object[] {
            file
        });
        throw obj;
    }

    public static void writeRecordingFile(RecordingFile recordingfile, boolean flag)
        throws IOException
    {
        writeRecordingFile(recordingfile.folder, recordingfile.getSession(), flag);
    }

    public static void writeRecordingFile(File file, RecordSession recordsession, boolean flag)
        throws IOException
    {
        writeData(file, recordsession, flag);
        if (flag)
        {
            writeMeta(file, new RecordSessionMeta(RecordConfigUtils.getTimeStampInNsFromSampleCounted(recordsession.getAudioDataCount()) / 1000));
            FileUtils.deleteQuietly(getDataFile(file, false));
        }
    }

    public void cleanUnusedFolders()
    {
        File afile[];
        int i;
        int j;
        int k;
        int j1;
        j = 0;
        i = 0;
        afile = mDir.listFiles();
        if (afile == null)
        {
            break MISSING_BLOCK_LABEL_188;
        }
        j1 = afile.length;
        k = 0;
_L2:
        File file;
        File afile1[];
        j = i;
        if (k >= j1)
        {
            break MISSING_BLOCK_LABEL_188;
        }
        file = afile[k];
        j = i;
        if (file.isDirectory())
        {
            afile1 = file.listFiles();
            j = i;
            if (afile1 != null)
            {
                if (afile1.length != 0)
                {
                    break; /* Loop/switch isn't completed */
                }
                FileUtils.deleteQuietly(file);
                j = i + 1;
            }
        }
_L3:
        k++;
        i = j;
        if (true) goto _L2; else goto _L1
_L1:
        int l = afile1.length;
        int k1 = afile1.length;
        for (j = 0; j < k1;)
        {
            int i1;
label0:
            {
                File file1 = afile1[j];
                if (!file1.getName().endsWith(".mp4"))
                {
                    i1 = l;
                    if (!file1.getName().endsWith(".mkv"))
                    {
                        break label0;
                    }
                }
                i1 = l - 1;
            }
            j++;
            l = i1;
        }

        if (l == 0)
        {
            FileUtils.deleteQuietly(file);
        }
        j = i + 1;
          goto _L3
        if (true) goto _L2; else goto _L4
_L4:
        SLog.i("{} empty folders deleted.", Integer.valueOf(j));
        return;
    }

    public File createFolderForSession()
        throws IOException
    {
        File file = new File(mDir, String.valueOf(System.currentTimeMillis()));
        FileUtils.forceMkdir(file);
        return file;
    }

    public HashMap getCrashedSession()
        throws IOException
    {
        Iterator iterator = getFolders().iterator();
_L2:
        File file;
        File file1;
        if (!iterator.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        file = (File)iterator.next();
        file1 = getDataFile(file, false);
        if (!file1.exists())
        {
            continue; /* Loop/switch isn't completed */
        }
        HashMap hashmap;
        hashmap = new HashMap();
        hashmap.put((RecordSession)readObject(file1), file);
        return hashmap;
        IOException ioexception;
        ioexception;
        SLog.e("Failed to read session object.", ioexception);
        if (true) goto _L2; else goto _L1
_L1:
        return null;
    }

    public File getFolderFromName(String s)
    {
        if (s != null)
        {
            return new File(mDir, s);
        } else
        {
            return null;
        }
    }

    public ArrayList getFolders()
        throws IOException
    {
        ArrayList arraylist;
        File afile[];
        int i;
        int k;
        arraylist = new ArrayList();
        afile = mDir.listFiles();
        if (afile == null)
        {
            throw new IOException("This should never happen.");
        }
        k = afile.length;
        i = 0;
_L12:
        if (i >= k) goto _L2; else goto _L1
_L1:
        File file = afile[i];
        if (!file.isDirectory()) goto _L4; else goto _L3
_L3:
        File afile1[] = file.listFiles();
        if (afile1 == null) goto _L4; else goto _L5
_L5:
        int j;
        boolean flag1;
        int l;
        flag1 = false;
        l = afile1.length;
        j = 0;
_L10:
        boolean flag = flag1;
        if (j >= l) goto _L7; else goto _L6
_L6:
        if (!afile1[j].getName().endsWith(mVersion.videoOutputExtension)) goto _L9; else goto _L8
_L8:
        arraylist.add(file);
        flag = true;
_L7:
        if (!flag)
        {
            arraylist.add(file);
        }
_L4:
        i++;
        continue; /* Loop/switch isn't completed */
_L9:
        j++;
        if (true) goto _L10; else goto _L2
_L2:
        return arraylist;
        if (true) goto _L12; else goto _L11
_L11:
    }

    public ArrayList getValidSessions()
        throws IOException
    {
        ArrayList arraylist;
        Object obj;
        obj = getFolders();
        arraylist = new ArrayList(((ArrayList) (obj)).size());
        obj = ((ArrayList) (obj)).iterator();
_L2:
        Object obj1;
        if (!((Iterator) (obj)).hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        obj1 = (File)((Iterator) (obj)).next();
        if (!getMetaFile(((File) (obj1))).exists())
        {
            continue; /* Loop/switch isn't completed */
        }
        File file = new File(getThumbnailPath(((File) (obj1))));
        File file1 = new File(getVideoPath(mVersion, ((File) (obj1))));
        File file2 = getDataFile(((File) (obj1)), true);
        File file3 = getDataFile(((File) (obj1)), false);
        RecordSessionMeta recordsessionmeta = readMetaObject(((File) (obj1)));
        if (file.exists() && file1.exists() && (file2.exists() || file3.exists()))
        {
            arraylist.add(new RecordSessionInfo(((File) (obj1)), file, file1, recordsessionmeta));
            continue; /* Loop/switch isn't completed */
        }
        try
        {
            SLog.e("Invalid session found: {}.", ((File) (obj1)).getAbsolutePath());
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            CrashUtil.logException(((Throwable) (obj1)));
        }
        if (true) goto _L2; else goto _L1
_L1:
        Collections.sort(arraylist);
        return arraylist;
    }

    static 
    {
        DEFAULT_VERSION = RecordSessionVersion.SW_WEBM;
        if (DEFAULT_VERSION == RecordSessionVersion.HW && !RecordConfigUtils.HW_ENABLED)
        {
            throw new IllegalStateException("Invalidate version type, HW Encoding is off.");
        }
        if (DEFAULT_VERSION != RecordSessionVersion.HW && !RecordConfigUtils.SW_ENABLED)
        {
            throw new IllegalStateException("Invalidate version type, HW Encoding is on.");
        } else
        {
            sDeletedSessions = new HashSet();
        }
    }
}
