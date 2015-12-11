// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.util;

import android.content.Context;
import android.content.res.Resources;
import android.os.Environment;
import com.bitstrips.imoji.models.Templates;
import com.crashlytics.android.Crashlytics;
import com.google.common.io.Files;
import com.google.gson.Gson;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class FileUtil
{

    private static final String JSON_TEMPLATES = "templates_v5_header_fallback.json";
    private static File attachmentDirectory;
    private static File imojiDir;
    private final String TAG = "FileUtil";
    private Context context;

    public FileUtil(Context context1)
    {
        context = context1;
        createSaveDirectories();
    }

    private File getBitmojiSaveLocation(boolean flag)
    {
        String s1 = (new SimpleDateFormat("yyyyMMddhhmmss", Locale.US)).format(new Date());
        String s;
        if (flag)
        {
            s = attachmentDirectory.getAbsolutePath();
        } else
        {
            s = imojiDir.getAbsolutePath();
        }
        return new File((new StringBuilder()).append(s).append(File.separator).append("bitmoji-").append(s1).append(".png").toString());
    }

    public void createSaveDirectories()
    {
        imojiDir = new File(Environment.getExternalStorageDirectory(), context.getResources().getString(0x7f06008e));
        if (!imojiDir.exists())
        {
            imojiDir.mkdirs();
        }
        attachmentDirectory = new File((new StringBuilder()).append(context.getExternalFilesDir(Environment.DIRECTORY_PICTURES)).append(File.separator).append("temp").toString());
        if (!attachmentDirectory.exists())
        {
            attachmentDirectory.mkdirs();
        }
        File afile[] = attachmentDirectory.listFiles();
        if (afile != null)
        {
            int j = afile.length;
            int i = 0;
            while (i < j) 
            {
                afile[i].delete();
                i++;
            }
        }
    }

    public Templates readTemplatesFromFile()
    {
        Object obj;
        obj = new File(context.getCacheDir(), "templates_v5_header_fallback.json");
        if (!((File) (obj)).exists())
        {
            break MISSING_BLOCK_LABEL_50;
        }
        obj = (Templates)(new Gson()).fromJson(Files.toString(((File) (obj)), Charset.defaultCharset()), com/bitstrips/imoji/models/Templates);
        return ((Templates) (obj));
        Exception exception;
        exception;
        return null;
    }

    public String saveImoji(String s)
    {
        try
        {
            File file = getBitmojiSaveLocation(false);
            Files.copy(new File(s), file);
            s = file.getAbsolutePath();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return null;
        }
        return s;
    }

    public File saveImojiForAttachment(File file)
    {
        if (attachmentDirectory == null)
        {
            return file;
        }
        File file1 = getBitmojiSaveLocation(true);
        try
        {
            Files.copy(file, file1);
        }
        // Misplaced declaration of an exception variable
        catch (File file)
        {
            file.printStackTrace();
            Crashlytics.logException(file);
        }
        return file1;
    }

    public void saveTemplatesToFile(Templates templates)
    {
        File file = new File(context.getCacheDir(), "templates_v5_header_fallback.json");
        try
        {
            Files.write((new Gson()).toJson(templates), file, Charset.defaultCharset());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Templates templates)
        {
            return;
        }
    }
}
