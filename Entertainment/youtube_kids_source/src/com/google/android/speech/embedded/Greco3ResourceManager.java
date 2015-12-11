// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.speech.embedded;

import a;
import android.util.Log;
import com.google.speech.recognizer.ResourceManager;
import java.io.File;
import java.io.IOException;

// Referenced classes of package com.google.android.speech.embedded:
//            Greco3Mode

public class Greco3ResourceManager extends ResourceManager
{

    private static final String TAG = "VS.G3ResourceManager";

    public Greco3ResourceManager()
    {
    }

    public static Greco3ResourceManager create(String s, String as[])
    {
        Greco3ResourceManager greco3resourcemanager = new Greco3ResourceManager();
        File file = new File(s);
        int i;
        if (Greco3Mode.isAsciiConfiguration(file))
        {
            i = greco3resourcemanager.initFromFile(s, as);
        } else
        {
            byte abyte0[] = getFileBytes(file);
            if (abyte0 == null)
            {
                Log.e("VS.G3ResourceManager", (new StringBuilder("Error reading g3 config file: ")).append(s).toString());
                return null;
            }
            i = greco3resourcemanager.initFromProto(abyte0, as);
        }
        if (i == 0)
        {
            return greco3resourcemanager;
        } else
        {
            Log.e("VS.G3ResourceManager", (new StringBuilder("Failed to bring up g3, Status code: ")).append(i).toString());
            return null;
        }
    }

    private static byte[] getFileBytes(File file)
    {
        try
        {
            file = a.a(file);
        }
        // Misplaced declaration of an exception variable
        catch (File file)
        {
            return null;
        }
        return file;
    }
}
