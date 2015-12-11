// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.supersonicads.sdk.utils;

import android.content.Context;
import android.os.Environment;
import com.supersonicads.sdk.data.SSAFile;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.supersonicads.sdk.utils:
//            SDKUtils, SupersonicSharedPrefHelper, DeviceProperties

public class SupersonicStorageUtils
{

    private static final String SSA_DIRECTORY_NAME = "supersonicads";

    public SupersonicStorageUtils()
    {
    }

    private static JSONObject buildFilesMap(String s, String s1)
    {
        s1 = new File(s, s1);
        s = new JSONObject();
        s1 = s1.listFiles();
        if (s1 == null) goto _L2; else goto _L1
_L1:
        int i;
        int j;
        j = s1.length;
        i = 0;
_L8:
        if (i >= j) goto _L2; else goto _L3
_L3:
        File file = s1[i];
        Object obj = looping(file);
        if (!(obj instanceof JSONArray)) goto _L5; else goto _L4
_L4:
        s.put("files", looping(file));
          goto _L6
_L5:
        try
        {
            if (obj instanceof JSONObject)
            {
                s.put(file.getName(), looping(file));
            }
        }
        catch (JSONException jsonexception)
        {
            jsonexception.printStackTrace();
        }
          goto _L6
_L2:
        return s;
_L6:
        i++;
        if (true) goto _L8; else goto _L7
_L7:
    }

    private static String createRootDirectory(Context context)
    {
        context = getDiskCacheDir(context, "supersonicads");
        if (!context.exists())
        {
            context.mkdir();
        }
        return context.getPath();
    }

    private static void deleteAllFiles(String s)
    {
        s = (new File(s)).listFiles();
        if (s != null)
        {
            int j = s.length;
            int i = 0;
            while (i < j) 
            {
                File file = s[i];
                if (file.isDirectory())
                {
                    deleteAllFiles(file.getAbsolutePath());
                    file.delete();
                } else
                {
                    file.delete();
                }
                i++;
            }
        }
    }

    public static boolean deleteFile(String s, String s1, String s2)
    {
        com/supersonicads/sdk/utils/SupersonicStorageUtils;
        JVM INSTR monitorenter ;
        boolean flag;
        s = new File(s, s1);
        flag = s.exists();
        if (flag) goto _L2; else goto _L1
_L1:
        flag = false;
_L6:
        com/supersonicads/sdk/utils/SupersonicStorageUtils;
        JVM INSTR monitorexit ;
        return flag;
_L2:
        s = s.listFiles();
        if (s == null)
        {
            flag = false;
            continue; /* Loop/switch isn't completed */
        }
        int j = s.length;
        int i = 0;
_L4:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        s1 = s[i];
        if (s1.isFile() && s1.getName().equalsIgnoreCase(s2))
        {
            flag = s1.delete();
            continue; /* Loop/switch isn't completed */
        }
        i++;
        if (true) goto _L4; else goto _L3
_L3:
        flag = false;
        if (true) goto _L6; else goto _L5
_L5:
        s;
        throw s;
    }

    public static boolean deleteFolder(String s, String s1)
    {
        com/supersonicads/sdk/utils/SupersonicStorageUtils;
        JVM INSTR monitorenter ;
        boolean flag = deleteFolderRecursive(new File(s, s1));
        com/supersonicads/sdk/utils/SupersonicStorageUtils;
        JVM INSTR monitorexit ;
        return flag;
        s;
        throw s;
    }

    private static boolean deleteFolderRecursive(File file)
    {
        if (!file.exists())
        {
            return false;
        }
        if (file.isDirectory())
        {
            File afile[] = file.listFiles();
            int j = afile.length;
            for (int i = 0; i < j; i++)
            {
                deleteFolderRecursive(afile[i]);
            }

            return file.delete();
        } else
        {
            return file.delete();
        }
    }

    public static String getCachedFilesMap(String s, String s1)
    {
        s = buildFilesMap(s, s1);
        try
        {
            s.put("path", s1);
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            s1.printStackTrace();
        }
        return s.toString();
    }

    private static File getDiskCacheDir(Context context, String s)
    {
        if (isExternalStorageAvailable())
        {
            if (getExternalCacheDir(context) != null)
            {
                context = getExternalCacheDir(context).getPath();
                return new File((new StringBuilder()).append(context).append(File.separator).append(s).toString());
            } else
            {
                context = getInternalCacheDirPath(context);
                return new File((new StringBuilder()).append(context).append(File.separator).append(s).toString());
            }
        } else
        {
            context = getInternalCacheDirPath(context);
            return new File((new StringBuilder()).append(context).append(File.separator).append(s).toString());
        }
    }

    private static File getExternalCacheDir(Context context)
    {
        return context.getExternalCacheDir();
    }

    private static String getInternalCacheDirPath(Context context)
    {
        Object obj = null;
        File file = context.getCacheDir();
        context = obj;
        if (file != null)
        {
            context = file.getPath();
        }
        return context;
    }

    public static String initializeCacheDirectory(Context context)
    {
        createRootDirectory(context);
        return refreshRootDirectory(context);
    }

    public static boolean isExternalStorageAvailable()
    {
        String s = Environment.getExternalStorageState();
        if ("mounted".equals(s))
        {
            return true;
        }
        return "mounted_ro".equals(s);
    }

    public static boolean isFileCached(String s, SSAFile ssafile)
    {
        com/supersonicads/sdk/utils/SupersonicStorageUtils;
        JVM INSTR monitorenter ;
        s = new File(s, ssafile.getPath());
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_92;
        }
        int j;
        if (s.listFiles() == null)
        {
            break MISSING_BLOCK_LABEL_92;
        }
        s = s.listFiles();
        j = s.length;
        int i = 0;
_L3:
        if (i >= j) goto _L2; else goto _L1
_L1:
        File file = s[i];
        boolean flag;
        if (!file.isFile())
        {
            continue; /* Loop/switch isn't completed */
        }
        flag = file.getName().equalsIgnoreCase(SDKUtils.getFileName(ssafile.getFile()));
        if (!flag)
        {
            continue; /* Loop/switch isn't completed */
        }
        flag = true;
_L4:
        com/supersonicads/sdk/utils/SupersonicStorageUtils;
        JVM INSTR monitorexit ;
        return flag;
          goto _L3
_L2:
        flag = false;
          goto _L4
        s;
        throw s;
    }

    public static boolean isPathExist(String s, String s1)
    {
        return (new File(s, s1)).exists();
    }

    private static Object looping(File file)
    {
        JSONObject jsonobject;
        Object obj;
        jsonobject = new JSONObject();
        obj = new JSONArray();
        if (!file.isFile())
        {
            break MISSING_BLOCK_LABEL_34;
        }
        ((JSONArray) (obj)).put(file.getName());
        return obj;
        File afile[];
        int j;
        afile = file.listFiles();
        j = afile.length;
        int i = 0;
_L10:
        if (i >= j) goto _L2; else goto _L1
_L1:
        File file1 = afile[i];
        if (file1.isDirectory())
        {
            jsonobject.put(file1.getName(), looping(file1));
            break MISSING_BLOCK_LABEL_254;
        }
        ((JSONArray) (obj)).put(file1.getName());
        jsonobject.put("files", obj);
        break MISSING_BLOCK_LABEL_254;
_L4:
        return jsonobject;
_L2:
        if (!file.isDirectory())
        {
            break MISSING_BLOCK_LABEL_143;
        }
        obj = SupersonicSharedPrefHelper.getSupersonicPrefHelper().getCampaignLastUpdate(file.getName());
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_143;
        }
        jsonobject.put("lastUpdateTime", obj);
        obj = file.getName();
        file = null;
        if (!((String) (obj)).equalsIgnoreCase(com.supersonicads.sdk.data.SSAEnums.ProductType.BrandConnect.toString()))
        {
            break; /* Loop/switch isn't completed */
        }
        file = com.supersonicads.sdk.data.SSAEnums.ProductType.BrandConnect;
_L7:
        if (file != null)
        {
            try
            {
                jsonobject.put(SDKUtils.encodeString("applicationUserId"), SDKUtils.encodeString(SupersonicSharedPrefHelper.getSupersonicPrefHelper().getUniqueId(file)));
                jsonobject.put(SDKUtils.encodeString("applicationKey"), SDKUtils.encodeString(SupersonicSharedPrefHelper.getSupersonicPrefHelper().getApplicationKey(file)));
            }
            // Misplaced declaration of an exception variable
            catch (File file)
            {
                file.printStackTrace();
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (!((String) (obj)).equalsIgnoreCase(com.supersonicads.sdk.data.SSAEnums.ProductType.OfferWall.toString())) goto _L6; else goto _L5
_L5:
        file = com.supersonicads.sdk.data.SSAEnums.ProductType.OfferWall;
          goto _L7
_L6:
        if (!((String) (obj)).equalsIgnoreCase(com.supersonicads.sdk.data.SSAEnums.ProductType.Interstitial.toString())) goto _L7; else goto _L8
_L8:
        file = com.supersonicads.sdk.data.SSAEnums.ProductType.Interstitial;
          goto _L7
        i++;
        if (true) goto _L10; else goto _L9
_L9:
    }

    public static String makeDir(String s, String s1)
    {
        s = new File(s, s1);
        if (!s.exists() && !s.mkdirs())
        {
            return null;
        } else
        {
            return s.getPath();
        }
    }

    private static String refreshRootDirectory(Context context)
    {
        String s = SupersonicSharedPrefHelper.getSupersonicPrefHelper().getCurrentSDKVersion();
        String s1 = DeviceProperties.getInstance(context).getSupersonicSdkVersion();
        if (!s.equalsIgnoreCase(s1))
        {
            SupersonicSharedPrefHelper.getSupersonicPrefHelper().setCurrentSDKVersion(s1);
            File file = getExternalCacheDir(context);
            if (file != null)
            {
                deleteAllFiles((new StringBuilder()).append(file.getAbsolutePath()).append(File.separator).append("supersonicads").append(File.separator).toString());
            }
            deleteAllFiles((new StringBuilder()).append(getInternalCacheDirPath(context)).append(File.separator).append("supersonicads").append(File.separator).toString());
            return createRootDirectory(context);
        } else
        {
            return getDiskCacheDir(context, "supersonicads").getPath();
        }
    }
}
