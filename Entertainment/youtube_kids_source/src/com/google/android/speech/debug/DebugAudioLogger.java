// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.speech.debug;

import a;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.widget.Toast;
import com.google.android.speech.SpeechSettings;
import com.google.android.speech.embedded.Greco3Grammar;
import com.google.android.speech.test.TestPlatformLog;
import emp;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

// Referenced classes of package com.google.android.speech.debug:
//            CopyInputStream

public class DebugAudioLogger
{

    private static final boolean DEBUG_LOG_ALL_AUDIO = false;
    private static final String DEBUG_OUTPUT_DIR = "debug";
    private static final String LOGS_ZIP_FILE_NAME = "logs.zip";
    private static final String TAG = "VS.DebugLogger";

    public DebugAudioLogger()
    {
    }

    public static void clearAllLoggedData(Context context)
    {
        int i = 0;
        File file = context.getDir("debug", 0);
        File afile[] = file.listFiles();
        for (int j = afile.length; i < j; i++)
        {
            afile[i].delete();
        }

        file.delete();
        (new File(context.getExternalCacheDir(), "logs.zip")).delete();
    }

    public static void maybeDumpGrammar(String s, Greco3Grammar greco3grammar, Context context, SpeechSettings speechsettings)
    {
        if (!shouldLog(speechsettings))
        {
            break MISSING_BLOCK_LABEL_56;
        }
        context = context.getDir("debug", 0);
        a.a(s, new File(context, (new StringBuilder("grammar-")).append(greco3grammar.name()).append(".txt").toString()), Charset.forName("UTF-8"));
        return;
        s;
    }

    public static InputStream maybeWrapInLogStream(InputStream inputstream, Context context, SpeechSettings speechsettings)
    {
        Object obj = inputstream;
        if (shouldLog(speechsettings))
        {
            speechsettings = (new StringBuilder("mic-")).append(System.currentTimeMillis()).append(".pcm").toString();
            context = (new File(context.getDir("debug", 0), speechsettings)).getAbsolutePath();
            TestPlatformLog.logAudioPath(context);
            try
            {
                obj = new CopyInputStream(inputstream, new BufferedOutputStream(new FileOutputStream(context), 0xea600));
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                Log.e("VS.DebugLogger", "Error opening audio log file.", context);
                return inputstream;
            }
        }
        return ((InputStream) (obj));
    }

    public static void sendLoggedAudio(Context context)
    {
        File file1 = context.getDir("debug", 0);
        File file = new File(context.getExternalCacheDir(), "logs.zip");
        if (writeZipFile(context, file, file1.listFiles()))
        {
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("text/plain");
            intent.putExtra("android.intent.extra.SUBJECT", "Debug logged audio + grammar");
            intent.putExtra("android.intent.extra.STREAM", Uri.fromFile(file));
            context.startActivity(intent);
            showToast(context, "Don't forget to turn off debug logging once your email has been sent.");
        }
    }

    private static boolean shouldLog(SpeechSettings speechsettings)
    {
        return speechsettings.isDebugAudioLoggingEnabled();
    }

    private static void showToast(Context context, String s)
    {
        Toast.makeText(context, s, 4000).show();
    }

    private static boolean writeZipFile(Context context, File file, File afile[])
    {
        FileInputStream fileinputstream;
        FileInputStream fileinputstream1;
        File file1;
        Object obj1;
        byte abyte0[];
        fileinputstream1 = null;
        fileinputstream = null;
        file1 = null;
        obj1 = null;
        if (afile == null || afile.length == 0)
        {
            showToast(context, "No logged audio or grammar files");
            return false;
        }
        abyte0 = new byte[4096];
        Object obj = new ZipOutputStream(new FileOutputStream(file));
        file = obj1;
        fileinputstream = file1;
        int j = afile.length;
        int i;
        i = 0;
        file = null;
_L5:
        if (i >= j) goto _L2; else goto _L1
_L1:
        file1 = afile[i];
        fileinputstream1 = new FileInputStream(file1);
        file = fileinputstream1;
        fileinputstream = fileinputstream1;
        ((ZipOutputStream) (obj)).putNextEntry(new ZipEntry(file1.getName()));
_L4:
        file = fileinputstream1;
        fileinputstream = fileinputstream1;
        int k = fileinputstream1.read(abyte0);
        if (k <= 0)
        {
            break; /* Loop/switch isn't completed */
        }
        file = fileinputstream1;
        fileinputstream = fileinputstream1;
        ((ZipOutputStream) (obj)).write(abyte0, 0, k);
        if (true) goto _L4; else goto _L3
        afile;
        afile = ((File []) (obj));
_L8:
        showToast(context, "Failure creating Zip file");
        emp.a(afile);
        emp.a(file);
        return false;
_L3:
        file = fileinputstream1;
        fileinputstream = fileinputstream1;
        ((ZipOutputStream) (obj)).closeEntry();
        file = fileinputstream1;
        fileinputstream = fileinputstream1;
        fileinputstream1.close();
        i++;
        file = fileinputstream1;
          goto _L5
_L2:
        ((ZipOutputStream) (obj)).close();
        emp.a(((java.io.Closeable) (obj)));
        emp.a(file);
        return true;
        context;
        obj = null;
        file = fileinputstream;
_L7:
        emp.a(((java.io.Closeable) (obj)));
        emp.a(file);
        throw context;
        context;
        file = fileinputstream;
        continue; /* Loop/switch isn't completed */
        context;
        continue; /* Loop/switch isn't completed */
        context;
        obj = afile;
        if (true) goto _L7; else goto _L6
_L6:
        file;
        afile = null;
        file = fileinputstream1;
          goto _L8
        afile;
        afile = ((File []) (obj));
          goto _L8
    }
}
