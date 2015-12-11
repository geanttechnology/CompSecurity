// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.tagmanager;

import com.google.analytics.containertag.common.FunctionType;
import com.google.analytics.containertag.common.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

// Referenced classes of package com.google.tagmanager:
//            FunctionCallImplementation, Types, Base16, Log

class HashMacro extends FunctionCallImplementation
{

    private static final String ALGORITHM;
    private static final String ARG0;
    private static final String DEFAULT_ALGORITHM = "MD5";
    private static final String DEFAULT_INPUT_FORMAT = "text";
    private static final String ID;
    private static final String INPUT_FORMAT;

    public HashMacro()
    {
        super(ID, new String[] {
            ARG0
        });
    }

    public static String getFunctionId()
    {
        return ID;
    }

    private byte[] hash(String s, byte abyte0[])
        throws NoSuchAlgorithmException
    {
        s = MessageDigest.getInstance(s);
        s.update(abyte0);
        return s.digest();
    }

    public com.google.analytics.midtier.proto.containertag.TypeSystem.Value evaluate(Map map)
    {
        Object obj = (com.google.analytics.midtier.proto.containertag.TypeSystem.Value)map.get(ARG0);
        if (obj == null || obj == Types.getDefaultValue())
        {
            return Types.getDefaultValue();
        }
        String s = Types.valueToString(((com.google.analytics.midtier.proto.containertag.TypeSystem.Value) (obj)));
        obj = (com.google.analytics.midtier.proto.containertag.TypeSystem.Value)map.get(ALGORITHM);
        if (obj == null)
        {
            obj = "MD5";
        } else
        {
            obj = Types.valueToString(((com.google.analytics.midtier.proto.containertag.TypeSystem.Value) (obj)));
        }
        map = (com.google.analytics.midtier.proto.containertag.TypeSystem.Value)map.get(INPUT_FORMAT);
        if (map == null)
        {
            map = "text";
        } else
        {
            map = Types.valueToString(map);
        }
        if ("text".equals(map))
        {
            map = s.getBytes();
        } else
        if ("base16".equals(map))
        {
            map = Base16.decode(s);
        } else
        {
            Log.e((new StringBuilder()).append("Hash: unknown input format: ").append(map).toString());
            return Types.getDefaultValue();
        }
        try
        {
            map = Types.objectToValue(Base16.encode(hash(((String) (obj)), map)));
        }
        // Misplaced declaration of an exception variable
        catch (Map map)
        {
            Log.e((new StringBuilder()).append("Hash: unknown algorithm: ").append(((String) (obj))).toString());
            return Types.getDefaultValue();
        }
        return map;
    }

    public boolean isCacheable()
    {
        return true;
    }

    static 
    {
        ID = FunctionType.HASH.toString();
        ARG0 = Key.ARG0.toString();
        ALGORITHM = Key.ALGORITHM.toString();
        INPUT_FORMAT = Key.INPUT_FORMAT.toString();
    }
}
