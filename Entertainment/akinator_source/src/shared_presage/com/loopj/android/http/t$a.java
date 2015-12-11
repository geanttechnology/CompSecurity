// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.loopj.android.http;

import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

// Referenced classes of package shared_presage.com.loopj.android.http:
//            t

private final class a
{

    public File a;
    public byte b[];
    final t c;

    private byte[] a(String s, String s1, String s2)
    {
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        try
        {
            bytearrayoutputstream.write(t.a(c));
            t t1 = c;
            bytearrayoutputstream.write(t.b(s, s1));
            s = c;
            bytearrayoutputstream.write(t.a(s2));
            bytearrayoutputstream.write(t.a());
            bytearrayoutputstream.write(t.b());
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Log.e("SimpleMultipartEntity", "createHeader ByteArrayOutputStream exception", s);
        }
        return bytearrayoutputstream.toByteArray();
    }

    public (t t1, String s, File file, String s1)
    {
        c = t1;
        super();
        b = a(s, file.getName(), s1);
        a = file;
    }
}
