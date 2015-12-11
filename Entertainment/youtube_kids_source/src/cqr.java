// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.Uri;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public final class cqr
    implements crb
{

    private final crb a;

    public cqr(crb crb1)
    {
        a = crb1;
    }

    private static void a(InputStream inputstream)
    {
        if (inputstream == null)
        {
            return;
        }
        try
        {
            inputstream.close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            return;
        }
    }

    public final void a(Object obj, bhv bhv1)
    {
        Uri uri;
        int i;
        i = 0;
        uri = (Uri)obj;
        if (!uri.getScheme().equals("file")) goto _L2; else goto _L1
_L1:
        File file;
        obj = uri.getPath();
        file = new File(((String) (obj)));
        if (!file.exists()) goto _L4; else goto _L3
_L3:
        BufferedInputStream bufferedinputstream = new BufferedInputStream(new FileInputStream(file), 4096);
        obj = bufferedinputstream;
        int k = (int)file.length();
        obj = bufferedinputstream;
        byte abyte0[] = new byte[k];
        int j = 0;
_L6:
        if (j < 0 || i >= k)
        {
            break; /* Loop/switch isn't completed */
        }
        i += j;
        obj = bufferedinputstream;
        j = bufferedinputstream.read(abyte0, i, k - i);
        if (true) goto _L6; else goto _L5
_L5:
        if (i != k) goto _L8; else goto _L7
_L7:
        obj = bufferedinputstream;
        bhv1.a(uri, abyte0);
_L9:
        a(((InputStream) (bufferedinputstream)));
_L11:
        return;
_L8:
        obj = bufferedinputstream;
        bhv1.a(uri, new IOException("Number of bytes read doesn't match file length."));
          goto _L9
        Object obj1;
        obj1;
_L14:
        obj = bufferedinputstream;
        bhv1.a(uri, ((Exception) (obj1)));
        a(((InputStream) (bufferedinputstream)));
        return;
        obj1;
        bufferedinputstream = null;
_L13:
        obj = bufferedinputstream;
        bhv1.a(uri, ((Exception) (obj1)));
        a(((InputStream) (bufferedinputstream)));
        return;
        bhv1;
        obj = null;
_L12:
        a(((InputStream) (obj)));
        throw bhv1;
_L4:
        bhv1.a(uri, new FileNotFoundException(((String) (obj))));
        return;
_L2:
        if (a == null) goto _L11; else goto _L10
_L10:
        a.a(uri, bhv1);
        return;
        bhv1;
          goto _L12
        obj1;
          goto _L13
        obj1;
        bufferedinputstream = null;
          goto _L14
    }
}
