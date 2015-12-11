// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import com.google.android.gms.e.aj;
import org.json.JSONException;

// Referenced classes of package com.google.android.gms.d:
//            kb, kc, jz

static final class 
    implements kb
{

    public final Object a(byte abyte0[])
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
            abyte0 = jz.a(new String(abyte0));
            aj.d();
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
        return abyte0;
    }

    ()
    {
    }
}
