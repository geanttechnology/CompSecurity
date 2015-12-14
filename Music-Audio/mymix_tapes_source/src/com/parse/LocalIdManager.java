// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import java.io.File;
import java.io.IOException;
import java.util.Random;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            Parse

class LocalIdManager
{
    private class MapEntry
    {

        String objectId;
        int retainCount;
        final LocalIdManager this$0;

        private MapEntry()
        {
            this$0 = LocalIdManager.this;
            super();
        }

    }


    private static LocalIdManager defaultInstance;
    private File diskPath;
    private Random random;

    private LocalIdManager()
    {
        diskPath = new File(Parse.getParseDir(), "LocalId");
        diskPath.mkdirs();
        random = new Random();
    }

    public static LocalIdManager getDefaultInstance()
    {
        com/parse/LocalIdManager;
        JVM INSTR monitorenter ;
        LocalIdManager localidmanager;
        if (defaultInstance == null)
        {
            defaultInstance = new LocalIdManager();
        }
        localidmanager = defaultInstance;
        com/parse/LocalIdManager;
        JVM INSTR monitorexit ;
        return localidmanager;
        Exception exception;
        exception;
        throw exception;
    }

    private MapEntry getMapEntry(String s)
    {
        this;
        JVM INSTR monitorenter ;
        if (!isLocalId(s))
        {
            throw new IllegalStateException((new StringBuilder()).append("Tried to get invalid local id: \"").append(s).append("\".").toString());
        }
        break MISSING_BLOCK_LABEL_47;
        s;
        this;
        JVM INSTR monitorexit ;
        throw s;
        JSONObject jsonobject = Parse.getDiskObject(new File(diskPath, s));
        if (jsonobject != null)
        {
            break MISSING_BLOCK_LABEL_81;
        }
        s = new MapEntry();
_L1:
        this;
        JVM INSTR monitorexit ;
        return s;
        s = new MapEntry();
        s.retainCount = jsonobject.optInt("retainCount", 0);
        s.objectId = jsonobject.optString("objectId", null);
          goto _L1
    }

    private boolean isLocalId(String s)
    {
        if (s.startsWith("local_")) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        int i = 6;
label0:
        do
        {
label1:
            {
                if (i >= s.length())
                {
                    break label1;
                }
                char c = s.charAt(i);
                if ((c < '0' || c > '9') && (c < 'a' || c > 'f'))
                {
                    break label0;
                }
                i++;
            }
        } while (true);
        if (true) goto _L1; else goto _L3
_L3:
        return true;
    }

    private void putMapEntry(String s, MapEntry mapentry)
    {
        this;
        JVM INSTR monitorenter ;
        if (!isLocalId(s))
        {
            throw new IllegalStateException((new StringBuilder()).append("Tried to get invalid local id: \"").append(s).append("\".").toString());
        }
        break MISSING_BLOCK_LABEL_47;
        s;
        this;
        JVM INSTR monitorexit ;
        throw s;
        JSONObject jsonobject = new JSONObject();
        jsonobject.put("retainCount", mapentry.retainCount);
        if (mapentry.objectId != null)
        {
            jsonobject.put("objectId", mapentry.objectId);
        }
        s = new File(diskPath, s);
        if (!diskPath.exists())
        {
            diskPath.mkdirs();
        }
        Parse.saveDiskObject(s, jsonobject);
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        throw new IllegalStateException("Error creating local id map entry.", s);
    }

    private void removeMapEntry(String s)
    {
        this;
        JVM INSTR monitorenter ;
        if (!isLocalId(s))
        {
            throw new IllegalStateException((new StringBuilder()).append("Tried to get invalid local id: \"").append(s).append("\".").toString());
        }
        break MISSING_BLOCK_LABEL_47;
        s;
        this;
        JVM INSTR monitorexit ;
        throw s;
        (new File(diskPath, s)).delete();
        this;
        JVM INSTR monitorexit ;
    }

    boolean clear()
        throws IOException
    {
        boolean flag = false;
        this;
        JVM INSTR monitorenter ;
        String as[] = diskPath.list();
        if (as != null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L2:
        int j;
        if (as.length == 0)
        {
            continue; /* Loop/switch isn't completed */
        }
        j = as.length;
        int i = 0;
_L4:
        String s;
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        s = as[i];
        if (!(new File(diskPath, s)).delete())
        {
            throw new IOException((new StringBuilder()).append("Unable to delete file ").append(s).append(" in localId cache.").toString());
        }
        break MISSING_BLOCK_LABEL_98;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        i++;
        if (true) goto _L4; else goto _L3
_L3:
        flag = true;
        if (true) goto _L1; else goto _L5
_L5:
    }

    String createLocalId()
    {
        this;
        JVM INSTR monitorenter ;
        Object obj;
        long l = random.nextLong();
        obj = (new StringBuilder()).append("local_").append(Long.toHexString(l)).toString();
        if (!isLocalId(((String) (obj))))
        {
            throw new IllegalStateException((new StringBuilder()).append("Generated an invalid local id: \"").append(((String) (obj))).append("\". ").append("This should never happen. Contact us at https://parse.com/help").toString());
        }
        break MISSING_BLOCK_LABEL_83;
        obj;
        this;
        JVM INSTR monitorexit ;
        throw obj;
        this;
        JVM INSTR monitorexit ;
        return ((String) (obj));
    }

    String getObjectId(String s)
    {
        this;
        JVM INSTR monitorenter ;
        s = getMapEntry(s).objectId;
        this;
        JVM INSTR monitorexit ;
        return s;
        s;
        throw s;
    }

    void releaseLocalIdOnDisk(String s)
    {
        this;
        JVM INSTR monitorenter ;
        MapEntry mapentry;
        mapentry = getMapEntry(s);
        mapentry.retainCount = mapentry.retainCount - 1;
        if (mapentry.retainCount <= 0) goto _L2; else goto _L1
_L1:
        putMapEntry(s, mapentry);
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        removeMapEntry(s);
        if (true) goto _L4; else goto _L3
_L3:
        s;
        throw s;
    }

    void retainLocalIdOnDisk(String s)
    {
        this;
        JVM INSTR monitorenter ;
        MapEntry mapentry = getMapEntry(s);
        mapentry.retainCount = mapentry.retainCount + 1;
        putMapEntry(s, mapentry);
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

    void setObjectId(String s, String s1)
    {
        this;
        JVM INSTR monitorenter ;
        MapEntry mapentry;
        mapentry = getMapEntry(s);
        if (mapentry.retainCount <= 0)
        {
            break MISSING_BLOCK_LABEL_48;
        }
        if (mapentry.objectId != null)
        {
            throw new IllegalStateException("Tried to set an objectId for a localId that already has one.");
        }
        break MISSING_BLOCK_LABEL_37;
        s;
        this;
        JVM INSTR monitorexit ;
        throw s;
        mapentry.objectId = s1;
        putMapEntry(s, mapentry);
        this;
        JVM INSTR monitorexit ;
    }
}
