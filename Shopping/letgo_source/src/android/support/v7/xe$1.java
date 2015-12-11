// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import org.json.JSONException;

// Referenced classes of package android.support.v7:
//            xd, xe, xb, abo

static final class 
    implements xd
{

    public Object a(byte abyte0[])
        throws 
    {
        if (abyte0 == null)
        {
            throw new <init>("Cannot parse a null byte[]");
        }
        if (abyte0.length == 0)
        {
            throw new <init>("Cannot parse a 0 length byte[]");
        }
        try
        {
            abyte0 = xb.a(new String(abyte0));
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            throw new <init>("The resource data is corrupted. The container cannot be extracted from the binary data");
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            throw new <init>("The resource data is invalid. The container cannot be extracted from the binary data");
        }
        if (abyte0 == null)
        {
            break MISSING_BLOCK_LABEL_50;
        }
        abo.d("The container was successfully parsed from the resource");
        return abyte0;
    }

    ()
    {
    }
}
