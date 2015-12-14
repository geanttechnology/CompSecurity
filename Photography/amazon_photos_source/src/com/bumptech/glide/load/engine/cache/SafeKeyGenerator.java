// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.engine.cache;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.util.LruCache;
import com.bumptech.glide.util.Util;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

class SafeKeyGenerator
{

    private final LruCache loadIdToSafeHash = new LruCache(1000);

    SafeKeyGenerator()
    {
    }

    public String getSafeKey(Key key)
    {
        Object obj;
        synchronized (loadIdToSafeHash)
        {
            obj = (String)loadIdToSafeHash.get(key);
        }
        obj1 = obj;
        if (obj != null) goto _L2; else goto _L1
_L1:
        obj1 = MessageDigest.getInstance("SHA-256");
        key.updateDiskCacheKey(((MessageDigest) (obj1)));
        obj1 = Util.sha256BytesToHex(((MessageDigest) (obj1)).digest());
        obj = obj1;
_L4:
        synchronized (loadIdToSafeHash)
        {
            loadIdToSafeHash.put(key, obj);
        }
        obj1 = obj;
_L2:
        return ((String) (obj1));
        key;
        obj1;
        JVM INSTR monitorexit ;
        throw key;
        obj1;
        ((UnsupportedEncodingException) (obj1)).printStackTrace();
        continue; /* Loop/switch isn't completed */
        obj1;
        ((NoSuchAlgorithmException) (obj1)).printStackTrace();
        if (true) goto _L4; else goto _L3
_L3:
        key;
        obj1;
        JVM INSTR monitorexit ;
        throw key;
    }
}
