// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.lingala.zip4j.crypto.PBKDF2;


// Referenced classes of package net.lingala.zip4j.crypto.PBKDF2:
//            BinTools, PBKDF2Parameters

class PBKDF2HexFormatter
{

    PBKDF2HexFormatter()
    {
    }

    public boolean fromString(PBKDF2Parameters pbkdf2parameters, String s)
    {
        if (pbkdf2parameters == null || s == null)
        {
            return true;
        }
        Object aobj[] = s.split(":");
        if (aobj == null || aobj.length != 3)
        {
            return true;
        } else
        {
            s = BinTools.hex2bin(aobj[0]);
            int i = Integer.parseInt(aobj[1]);
            aobj = BinTools.hex2bin(aobj[2]);
            pbkdf2parameters.setSalt(s);
            pbkdf2parameters.setIterationCount(i);
            pbkdf2parameters.setDerivedKey(((byte []) (aobj)));
            return false;
        }
    }

    public String toString(PBKDF2Parameters pbkdf2parameters)
    {
        return BinTools.bin2hex(pbkdf2parameters.getSalt()) + ":" + String.valueOf(pbkdf2parameters.getIterationCount()) + ":" + BinTools.bin2hex(pbkdf2parameters.getDerivedKey());
    }
}
