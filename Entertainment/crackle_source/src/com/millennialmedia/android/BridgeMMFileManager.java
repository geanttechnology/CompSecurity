// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.content.Context;
import android.net.Uri;
import android.os.StatFs;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import org.json.JSONArray;

// Referenced classes of package com.millennialmedia.android:
//            MMJSObject, AdCache, HandShake, MMJSResponse, 
//            Base64

class BridgeMMFileManager extends MMJSObject
{

    private File root;

    BridgeMMFileManager()
    {
    }

    private boolean hasCreativeDirectory()
    {
        Object obj = (Context)contextRef.get();
        if (obj != null)
        {
            obj = AdCache.getCacheDirectory(((Context) (obj)));
            root = ((File) (obj));
            if (obj != null)
            {
                return true;
            }
        }
        return false;
    }

    public MMJSResponse cleanupCache(HashMap hashmap)
    {
        boolean flag = false;
        long l = 0xf731400L;
        if (hasCreativeDirectory())
        {
            if (hashmap.containsKey("clear"))
            {
                flag = Boolean.parseBoolean((String)hashmap.get("clear"));
            }
            if (flag)
            {
                l = 0L;
            } else
            {
                hashmap = (Context)contextRef.get();
                if (hashmap != null)
                {
                    l = HandShake.sharedHandShake(hashmap).creativeCacheTimeout;
                }
            }
            try
            {
                AdCache.cleanupDirectory(root, l);
            }
            // Misplaced declaration of an exception variable
            catch (HashMap hashmap) { }
        }
        return null;
    }

    public MMJSResponse downloadFile(HashMap hashmap)
    {
        Context context = (Context)contextRef.get();
        String s = (String)hashmap.get("url");
        if (!TextUtils.isEmpty(s) && context != null)
        {
            if (hashmap.containsKey("path"))
            {
                hashmap = (String)hashmap.get("path");
            } else
            {
                hashmap = Uri.parse((String)hashmap.get("url")).getLastPathSegment();
            }
            if (AdCache.downloadComponentToCache(s, hashmap, context))
            {
                return MMJSResponse.responseWithSuccess(hashmap);
            }
        }
        return null;
    }

    public MMJSResponse getDirectoryContents(HashMap hashmap)
    {
        if (hasCreativeDirectory())
        {
            JSONArray jsonarray;
            int j;
            if (hashmap.containsKey("path"))
            {
                hashmap = new File(root, (String)hashmap.get("path"));
            } else
            {
                hashmap = root;
            }
            jsonarray = new JSONArray();
            hashmap = hashmap.list();
            j = hashmap.length;
            for (int i = 0; i < j; i++)
            {
                jsonarray.put(hashmap[i]);
            }

            hashmap = new MMJSResponse();
            hashmap.result = 1;
            hashmap.response = jsonarray;
            return hashmap;
        } else
        {
            return null;
        }
    }

    public MMJSResponse getFileContents(HashMap hashmap)
    {
        if (!hasCreativeDirectory()) goto _L2; else goto _L1
_L1:
        Object obj;
        Object obj1;
        obj = null;
        obj1 = null;
        if (!hashmap.containsKey("path")) goto _L2; else goto _L3
_L3:
        File file;
        file = new File(root, (String)hashmap.get("path"));
        hashmap = new FileInputStream(file);
        obj = new byte[(int)file.length()];
        hashmap.read(((byte []) (obj)));
        if (hashmap == null)
        {
            break MISSING_BLOCK_LABEL_75;
        }
        hashmap.close();
        hashmap = ((HashMap) (obj));
_L4:
        if (hashmap != null)
        {
            obj = new MMJSResponse();
            obj.result = 1;
            obj.dataResponse = hashmap;
            return ((MMJSResponse) (obj));
        }
          goto _L2
        hashmap;
        hashmap = ((HashMap) (obj));
          goto _L4
        hashmap;
        obj = obj1;
_L8:
        obj1 = null;
        hashmap = obj1;
        if (obj == null) goto _L4; else goto _L5
_L5:
        ((FileInputStream) (obj)).close();
        hashmap = obj1;
          goto _L4
        hashmap;
        hashmap = obj1;
          goto _L4
        hashmap;
_L7:
        if (obj != null)
        {
            try
            {
                ((FileInputStream) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj) { }
        }
        throw hashmap;
_L2:
        return null;
        Exception exception1;
        exception1;
        obj = hashmap;
        hashmap = exception1;
        if (true) goto _L7; else goto _L6
_L6:
        Exception exception;
        exception;
        exception = hashmap;
          goto _L8
    }

    public MMJSResponse getFreeDiskSpace(HashMap hashmap)
    {
        if (hasCreativeDirectory())
        {
            hashmap = new MMJSResponse();
            hashmap.result = 1;
            StatFs statfs = new StatFs(root.getAbsolutePath());
            hashmap.response = new Long((long)statfs.getAvailableBlocks() * (long)statfs.getBlockSize());
            return hashmap;
        } else
        {
            return null;
        }
    }

    public MMJSResponse getMimeType(HashMap hashmap)
    {
        if (hasCreativeDirectory())
        {
            hashmap = ((String)hashmap.get("path")).split("\\.");
            hashmap = MimeTypeMap.getSingleton().getMimeTypeFromExtension(hashmap[hashmap.length - 1]);
            if (hashmap != null)
            {
                MMJSResponse mmjsresponse = new MMJSResponse();
                mmjsresponse.result = 1;
                mmjsresponse.response = hashmap;
                return mmjsresponse;
            }
        }
        return null;
    }

    public MMJSResponse moveFile(HashMap hashmap)
    {
        if (!hasCreativeDirectory())
        {
            break MISSING_BLOCK_LABEL_74;
        }
        String s;
        s = (String)hashmap.get("fromPath");
        hashmap = (String)hashmap.get("toPath");
        if (s == null || hashmap == null)
        {
            break MISSING_BLOCK_LABEL_74;
        }
        if (!(new File(root, s)).renameTo(new File(root, hashmap)))
        {
            break MISSING_BLOCK_LABEL_74;
        }
        hashmap = MMJSResponse.responseWithSuccess("File moved successfully");
        return hashmap;
        hashmap;
        return null;
    }

    public MMJSResponse removeAtPath(HashMap hashmap)
    {
        if (!hasCreativeDirectory())
        {
            break MISSING_BLOCK_LABEL_48;
        }
        hashmap = (String)hashmap.get("path");
        if (hashmap == null)
        {
            break MISSING_BLOCK_LABEL_48;
        }
        if (!(new File(root, hashmap)).delete())
        {
            break MISSING_BLOCK_LABEL_48;
        }
        hashmap = MMJSResponse.responseWithSuccess("File removed successfully");
        return hashmap;
        hashmap;
        return null;
    }

    public MMJSResponse writeData(HashMap hashmap)
    {
        if (!hasCreativeDirectory()) goto _L2; else goto _L1
_L1:
        Object obj;
        Object obj1;
        boolean flag1;
        obj = null;
        obj1 = null;
        flag1 = false;
        if (!hashmap.containsKey("path") || !hashmap.containsKey("data")) goto _L2; else goto _L3
_L3:
        byte abyte0[];
        File file = new File(root, (String)hashmap.get("path"));
        abyte0 = Base64.decode((String)hashmap.get("data"));
        hashmap = new FileOutputStream(file);
        hashmap.write(abyte0);
        boolean flag;
        flag = true;
        if (hashmap != null)
        {
            try
            {
                hashmap.close();
            }
            // Misplaced declaration of an exception variable
            catch (HashMap hashmap) { }
        }
_L5:
        if (flag)
        {
            return MMJSResponse.responseWithSuccess("File written successfully");
        }
          goto _L2
        hashmap;
        hashmap = obj1;
_L8:
        flag = flag1;
        if (hashmap == null) goto _L5; else goto _L4
_L4:
        hashmap.close();
        flag = flag1;
          goto _L5
        hashmap;
        flag = flag1;
          goto _L5
        hashmap;
_L7:
        if (obj != null)
        {
            try
            {
                ((FileOutputStream) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj) { }
        }
        throw hashmap;
_L2:
        return null;
        Exception exception1;
        exception1;
        obj = hashmap;
        hashmap = exception1;
        if (true) goto _L7; else goto _L6
_L6:
        Exception exception;
        exception;
          goto _L8
    }
}
