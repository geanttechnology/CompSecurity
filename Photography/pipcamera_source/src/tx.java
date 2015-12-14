// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Point;
import android.graphics.Rect;
import android.util.Log;
import com.wantu.ResourceOnlineLibrary.FileManager;
import com.wantu.model.res.pip.TDFSceneInfo;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import org.json.JSONObject;

public class tx
{

    public static TDFSceneInfo a(JSONObject jsonobject, int i)
    {
        if (jsonobject != null && i != 0) goto _L2; else goto _L1
_L1:
        Object obj = null;
_L6:
        return ((TDFSceneInfo) (obj));
_L2:
        int j;
        if (jsonobject == null)
        {
            break MISSING_BLOCK_LABEL_431;
        }
        TDFSceneInfo tdfsceneinfo;
        try
        {
            tdfsceneinfo = new TDFSceneInfo();
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            return null;
        }
        tdfsceneinfo.folderName = String.format("pip_style_%d", new Object[] {
            Integer.valueOf(i)
        });
        tdfsceneinfo.resId = kv.e(jsonobject, "id");
        tdfsceneinfo.name = kv.a(jsonobject, "name");
        tdfsceneinfo.icon = kv.a(jsonobject, "iconUrl");
        if (jsonobject.has("previewUrl"))
        {
            tdfsceneinfo.previewUrl = kv.a(jsonobject, "previewUrl");
        }
        if (jsonobject.has("price"))
        {
            tdfsceneinfo.price = kv.e(jsonobject, "price");
        }
        if (jsonobject.has("imageCount"))
        {
            tdfsceneinfo.useCount = kv.e(jsonobject, "imageCount");
        }
        if (!jsonobject.has("width"))
        {
            break MISSING_BLOCK_LABEL_424;
        }
        i = kv.e(jsonobject, "width");
_L8:
        if (!jsonobject.has("height")) goto _L4; else goto _L3
_L3:
        j = kv.e(jsonobject, "height");
_L7:
        tdfsceneinfo.sceneSize = new Point(i, j);
        if (jsonobject.has("frame"))
        {
            obj = kv.c(jsonobject, "frame");
            if (((JSONObject) (obj)).has("left") && ((JSONObject) (obj)).has("top") && ((JSONObject) (obj)).has("width") && ((JSONObject) (obj)).has("height"))
            {
                i = kv.e(((JSONObject) (obj)), "left");
                j = kv.e(((JSONObject) (obj)), "top");
                tdfsceneinfo.frameRect = new Rect(i, j, kv.e(((JSONObject) (obj)), "width") + i, kv.e(((JSONObject) (obj)), "height") + j);
            }
            if (((JSONObject) (obj)).has("url"))
            {
                tdfsceneinfo.framePath = kv.a(((JSONObject) (obj)), "url");
            }
        }
        if (jsonobject.has("mask"))
        {
            obj = kv.c(jsonobject, "mask");
            if (((JSONObject) (obj)).has("url"))
            {
                obj = kv.a(((JSONObject) (obj)), "url");
                if (((String) (obj)).compareTo("") != 0)
                {
                    tdfsceneinfo.alphaTexturePath = ((String) (obj));
                }
            }
        }
        if (jsonobject.has("bRetainFirst"))
        {
            tdfsceneinfo.bRetainFirst = kv.d(jsonobject, "bRetainFirst");
        }
        tdfsceneinfo.downloadTime = System.currentTimeMillis();
        if (jsonobject.has("expiredTime"))
        {
            tdfsceneinfo.expiredTime = kv.e(jsonobject, "expiredTime");
        }
        obj = tdfsceneinfo;
        if (!jsonobject.has("shareTag")) goto _L6; else goto _L5
_L5:
        tdfsceneinfo.setShareTag(kv.a(jsonobject, "shareTag"));
        return tdfsceneinfo;
        jsonobject;
        return tdfsceneinfo;
_L4:
        j = 612;
          goto _L7
        i = 612;
          goto _L8
        return null;
    }

    public static TDFSceneInfo a(byte abyte0[], int i)
    {
        if (abyte0 != null && i > 0 && b(abyte0, i))
        {
            abyte0 = FileManager.getInstance().getPipFileCache().a();
            String s = String.format("pip_style_%d", new Object[] {
                Integer.valueOf(i)
            });
            abyte0 = (new StringBuilder()).append(abyte0).append("/").append(s).append("/conf.json").toString();
            if ((new File(abyte0)).exists())
            {
                try
                {
                    abyte0 = a(((String) (abyte0)));
                }
                // Misplaced declaration of an exception variable
                catch (byte abyte0[])
                {
                    abyte0.printStackTrace();
                    abyte0 = null;
                }
                if (abyte0 != null && abyte0.length() > 0)
                {
                    try
                    {
                        abyte0 = new JSONObject(abyte0);
                    }
                    // Misplaced declaration of an exception variable
                    catch (byte abyte0[])
                    {
                        abyte0 = null;
                    }
                } else
                {
                    abyte0 = null;
                }
                if (abyte0 != null)
                {
                    return a(((JSONObject) (abyte0)), i);
                }
            }
        }
        return null;
    }

    public static String a(String s)
    {
        s = new FileReader(s);
        BufferedReader bufferedreader = new BufferedReader(s);
        StringBuffer stringbuffer = new StringBuffer();
        do
        {
            String s1 = bufferedreader.readLine();
            if (s1 != null)
            {
                stringbuffer.append(s1);
            } else
            {
                bufferedreader.close();
                s.close();
                return stringbuffer.toString();
            }
        } while (true);
    }

    private static boolean b(byte abyte0[], int i)
    {
        Object obj = FileManager.getInstance().getPipFileCache().a();
        String s1 = String.format("pip_style_%d", new Object[] {
            Integer.valueOf(i)
        });
        String s = (new StringBuilder()).append(((String) (obj))).append("/").append(s1).append(".zip").toString();
        s1 = (new StringBuilder()).append(((String) (obj))).append("/").append(s1).toString();
        Log.v("TParsePipUtils", (new StringBuilder()).append("TParsePipUtils zipFilePath:").append(s).append(" folderFilePath").append(s1).toString());
        obj = new File(s);
        boolean flag;
        boolean flag1;
        if (!((File) (obj)).exists())
        {
            try
            {
                ((File) (obj)).createNewFile();
            }
            // Misplaced declaration of an exception variable
            catch (byte abyte0[])
            {
                abyte0.printStackTrace();
                return false;
            }
        }
        flag = gc.a(abyte0, s);
        Log.v("TParsePipUtils", (new StringBuilder()).append("TParsePipUtils zipDatatoFile:").append(flag).append("").toString());
        flag1 = flag;
        if (flag)
        {
            try
            {
                gc.a(((File) (obj)), s1);
            }
            // Misplaced declaration of an exception variable
            catch (byte abyte0[])
            {
                flag = false;
            }
            flag1 = flag;
            if (flag)
            {
                flag1 = flag;
                if (((File) (obj)).exists())
                {
                    ((File) (obj)).delete();
                    flag1 = flag;
                }
            }
        }
        return flag1;
    }
}
