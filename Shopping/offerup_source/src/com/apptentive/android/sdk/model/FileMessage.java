// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apptentive.android.sdk.model;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.webkit.MimeTypeMap;
import com.apptentive.android.sdk.Log;
import com.apptentive.android.sdk.storage.ApptentiveDatabase;
import com.apptentive.android.sdk.storage.FileStore;
import com.apptentive.android.sdk.util.CountingOutputStream;
import com.apptentive.android.sdk.util.ImageUtil;
import com.apptentive.android.sdk.util.Util;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import org.json.JSONException;

// Referenced classes of package com.apptentive.android.sdk.model:
//            Message, StoredFile

public class FileMessage extends Message
{

    private static final String KEY_FILE_NAME = "file_name";
    private static final String KEY_MIME_TYPE = "mime_type";
    private static final int MAX_STORED_IMAGE_EDGE = 1024;

    public FileMessage()
    {
    }

    public FileMessage(String s)
    {
        super(s);
    }

    private String getStoredFileId()
    {
        return (new StringBuilder("apptentive-file-")).append(getNonce()).toString();
    }

    public boolean createStoredFile(Context context, InputStream inputstream, String s)
    {
        File file;
        setMimeType(s);
        file = new File(getStoredFileId());
        CountingOutputStream countingoutputstream = new CountingOutputStream(new BufferedOutputStream(context.openFileOutput(file.getPath(), 0)));
        byte abyte0[] = new byte[2048];
_L3:
        int i = inputstream.read(abyte0, 0, 2048);
        if (i == -1) goto _L2; else goto _L1
_L1:
        countingoutputstream.write(abyte0, 0, i);
          goto _L3
        context;
        inputstream = countingoutputstream;
_L5:
        Util.ensureClosed(inputstream);
        throw context;
_L2:
        Log.d((new StringBuilder("File saved, size = ")).append(countingoutputstream.getBytesWritten() / 1024).append("k").toString(), new Object[0]);
        Util.ensureClosed(countingoutputstream);
        inputstream = new StoredFile();
        inputstream.setId(getStoredFileId());
        inputstream.setLocalFilePath(file.getPath());
        inputstream.setMimeType(s);
        return ApptentiveDatabase.getInstance(context).putStoredFile(inputstream);
        context;
        inputstream = null;
        if (true) goto _L5; else goto _L4
_L4:
    }

    public boolean createStoredFile(Context context, String s)
    {
        Object obj;
        String s1;
        String s2;
        Uri uri;
        uri = Uri.parse(s);
        s2 = context.getContentResolver().getType(uri);
        MimeTypeMap mimetypemap = MimeTypeMap.getSingleton();
        s1 = mimetypemap.getExtensionFromMimeType(s2);
        obj = s1;
        if (s1 == null)
        {
            obj = MimeTypeMap.getFileExtensionFromUrl(s);
        }
        s1 = s2;
        if (s2 == null)
        {
            s1 = s2;
            if (obj != null)
            {
                s1 = mimetypemap.getMimeTypeFromExtension(((String) (obj)));
            }
        }
        setFileName((new StringBuilder()).append(uri.getLastPathSegment()).append(".").append(((String) (obj))).toString());
        setMimeType(s1);
        obj = null;
        s2 = null;
        s = new BufferedInputStream(context.getContentResolver().openInputStream(uri));
        obj = s;
        boolean flag = createStoredFile(context, ((InputStream) (s)), s1);
        Util.ensureClosed(s);
        return flag;
        context;
        s = null;
_L6:
        obj = s;
        Log.e("File not found while storing file.", context, new Object[0]);
        Util.ensureClosed(s);
_L1:
        return false;
        s;
        context = s2;
_L4:
        obj = context;
        Log.a("Error storing image.", s, new Object[0]);
        Util.ensureClosed(context);
          goto _L1
        context;
_L3:
        Util.ensureClosed(((java.io.Closeable) (obj)));
        throw context;
        context;
        if (true) goto _L3; else goto _L2
_L2:
        IOException ioexception;
        ioexception;
        context = s;
        s = ioexception;
          goto _L4
        context;
        if (true) goto _L6; else goto _L5
_L5:
    }

    public boolean createStoredFile(Context context, byte abyte0[], String s)
    {
        Object obj;
        Object obj1;
        obj = null;
        obj1 = null;
        abyte0 = new ByteArrayInputStream(abyte0);
        obj = abyte0;
        boolean flag = createStoredFile(context, ((InputStream) (abyte0)), s);
        Util.ensureClosed(abyte0);
        return flag;
        context;
        abyte0 = null;
_L6:
        obj = abyte0;
        Log.e("File not found while storing file.", context, new Object[0]);
        Util.ensureClosed(abyte0);
        return false;
        abyte0;
        context = obj1;
_L4:
        obj = context;
        Log.a("Error storing file.", abyte0, new Object[0]);
        Util.ensureClosed(context);
        return false;
        context;
_L2:
        Util.ensureClosed(((java.io.Closeable) (obj)));
        throw context;
        context;
        if (true) goto _L2; else goto _L1
_L1:
        s;
        context = abyte0;
        abyte0 = s;
        if (true) goto _L4; else goto _L3
_L3:
        context;
        if (true) goto _L6; else goto _L5
_L5:
    }

    public void deleteStoredFile(Context context)
    {
        ApptentiveDatabase.getInstance(context).deleteStoredFile(getStoredFileId());
    }

    public String getFileName()
    {
        String s;
        try
        {
            s = getString("file_name");
        }
        catch (JSONException jsonexception)
        {
            return null;
        }
        return s;
    }

    public String getMimeType()
    {
        String s;
        try
        {
            s = getString("mime_type");
        }
        catch (JSONException jsonexception)
        {
            return null;
        }
        return s;
    }

    public StoredFile getStoredFile(Context context)
    {
        return ApptentiveDatabase.getInstance(context).getStoredFile(getStoredFileId());
    }

    protected void initType()
    {
        setType(Message.Type.FileMessage);
    }

    public boolean internalCreateStoredImage(Context context, String s)
    {
        Object obj;
        Uri uri;
        File file;
        obj = null;
        uri = Uri.parse(s);
        s = context.getContentResolver().getType(uri);
        String s1 = MimeTypeMap.getSingleton().getExtensionFromMimeType(s);
        setFileName((new StringBuilder()).append(uri.getLastPathSegment()).append(".").append(s1).toString());
        setMimeType(s);
        file = new File(getStoredFileId());
        s = new BufferedInputStream(context.getContentResolver().openInputStream(uri));
        Object obj1;
        Object obj2;
        Exception exception;
        Bitmap bitmap;
        try
        {
            obj = new CountingOutputStream(new BufferedOutputStream(context.openFileOutput(file.getPath(), 0)));
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            context = null;
            continue; /* Loop/switch isn't completed */
        }
        // Misplaced declaration of an exception variable
        catch (Exception exception)
        {
            context = null;
            continue; /* Loop/switch isn't completed */
        }
        finally
        {
            context = null;
        }
        obj2 = obj;
        obj1 = s;
        System.gc();
        obj2 = obj;
        obj1 = s;
        bitmap = ImageUtil.createScaledBitmapFromStream(s, 1024, 1024, null);
        obj2 = obj;
        obj1 = s;
        bitmap.compress(android.graphics.Bitmap.CompressFormat.JPEG, 95, ((java.io.OutputStream) (obj)));
        obj2 = obj;
        obj1 = s;
        ((CountingOutputStream) (obj)).flush();
        obj2 = obj;
        obj1 = s;
        Log.d((new StringBuilder("Bitmap saved, size = ")).append(((CountingOutputStream) (obj)).getBytesWritten() / 1024).append("k").toString(), new Object[0]);
        obj2 = obj;
        obj1 = s;
        bitmap.recycle();
        obj2 = obj;
        obj1 = s;
        System.gc();
        Util.ensureClosed(s);
        Util.ensureClosed(((java.io.Closeable) (obj)));
        s = new StoredFile();
        s.setId(getStoredFileId());
        s.setOriginalUri(uri.toString());
        s.setLocalFilePath(file.getPath());
        s.setMimeType("image/jpeg");
        return ApptentiveDatabase.getInstance(context).putStoredFile(s);
        obj1;
        context = null;
        s = ((String) (obj));
_L6:
        Log.e("File not found while storing image.", ((Throwable) (obj1)), new Object[0]);
        Util.ensureClosed(s);
        Util.ensureClosed(context);
        return false;
        exception;
        context = null;
        s = null;
_L4:
        obj2 = context;
        obj1 = s;
        Log.a("Error storing image.", exception, new Object[0]);
        Util.ensureClosed(s);
        Util.ensureClosed(context);
        return false;
        obj;
        context = null;
        s = null;
_L2:
        Util.ensureClosed(s);
        Util.ensureClosed(context);
        throw obj;
        obj;
        context = ((Context) (obj2));
        s = ((String) (obj1));
        continue; /* Loop/switch isn't completed */
        obj;
        if (true) goto _L2; else goto _L1
_L1:
        exception;
        context = ((Context) (obj));
        if (true) goto _L4; else goto _L3
        obj1;
        context = ((Context) (obj));
        if (true) goto _L6; else goto _L5
_L5:
    }

    public String marshallForSending()
    {
        return toString();
    }

    public void setFileName(String s)
    {
        try
        {
            put("file_name", s);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Log.e("Unable to set file name.", new Object[0]);
        }
    }

    public void setMimeType(String s)
    {
        try
        {
            put("mime_type", s);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Log.e("Unable to set mime type.", new Object[0]);
        }
    }
}
