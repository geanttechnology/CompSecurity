// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.ContentResolver;
import android.net.Uri;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public final class cqm
    implements crb
{

    private final ContentResolver a;
    private final crb b;

    public cqm(ContentResolver contentresolver, crb crb1)
    {
        a = contentresolver;
        b = crb1;
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
        InputStream inputstream;
        Object obj1;
        Uri uri;
        uri = (Uri)obj;
        obj = uri.getScheme();
        if (obj == null || !((String) (obj)).equals("content"))
        {
            if (b != null)
            {
                b.a(uri, bhv1);
            }
            return;
        }
        obj1 = null;
        obj = null;
        inputstream = null;
        InputStream inputstream1 = a.openInputStream(uri);
        inputstream = inputstream1;
        obj1 = inputstream1;
        obj = inputstream1;
        byte abyte0[] = new byte[4096];
        inputstream = inputstream1;
        obj1 = inputstream1;
        obj = inputstream1;
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
_L2:
        inputstream = inputstream1;
        obj1 = inputstream1;
        obj = inputstream1;
        int i = inputstream1.read(abyte0, 0, 4096);
        if (i < 0)
        {
            break; /* Loop/switch isn't completed */
        }
        inputstream = inputstream1;
        obj1 = inputstream1;
        obj = inputstream1;
        bytearrayoutputstream.write(abyte0, 0, i);
        if (true) goto _L2; else goto _L1
        obj1;
        obj = inputstream;
        bhv1.a(uri, ((Exception) (obj1)));
        a(inputstream);
        return;
_L1:
        inputstream = inputstream1;
        obj1 = inputstream1;
        obj = inputstream1;
        bhv1.a(uri, bytearrayoutputstream.toByteArray());
        a(inputstream1);
        return;
        IOException ioexception;
        ioexception;
        obj = obj1;
        bhv1.a(uri, ioexception);
        a(((InputStream) (obj1)));
        return;
        bhv1;
        a(((InputStream) (obj)));
        throw bhv1;
    }
}
