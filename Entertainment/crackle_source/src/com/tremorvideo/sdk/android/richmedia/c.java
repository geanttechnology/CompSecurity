// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.richmedia;

import android.graphics.Bitmap;
import android.util.Log;
import com.tremorvideo.sdk.android.videoad.ad;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.zip.ZipFile;

// Referenced classes of package com.tremorvideo.sdk.android.richmedia:
//            i, e

public class c
{

    public List a;
    private int b;

    public c()
    {
    }

    private Bitmap a(ZipFile zipfile, i j, String s)
    {
        byte abyte0[];
        zipfile = zipfile.getInputStream(zipfile.getEntry(s));
        s = new ByteArrayOutputStream();
        abyte0 = new byte[16384];
_L1:
        int k = zipfile.read(abyte0, 0, abyte0.length);
label0:
        {
            if (k == -1)
            {
                break label0;
            }
            try
            {
                s.write(abyte0, 0, k);
            }
            // Misplaced declaration of an exception variable
            catch (ZipFile zipfile)
            {
                Log.v("", "", zipfile);
                return null;
            }
        }
          goto _L1
        zipfile = j.a(s.toByteArray(), b);
        return zipfile;
    }

    public int a()
    {
        return b;
    }

    public Bitmap a(int j)
    {
        return (Bitmap)a.get(j);
    }

    public void a(ZipFile zipfile, i j, int k, e e1)
    {
        int i1;
        b = k;
        i1 = e1.b();
        a = new ArrayList(i1);
        k = 0;
_L4:
        if (k >= i1)
        {
            break; /* Loop/switch isn't completed */
        }
        StringBuilder stringbuilder;
        int j1;
        j1 = e1.b();
        stringbuilder = new StringBuilder(j1);
        int l = 0;
_L2:
        if (l >= j1)
        {
            break; /* Loop/switch isn't completed */
        }
        stringbuilder.append((char)e1.b());
        l++;
        if (true) goto _L2; else goto _L1
_L1:
        a.add(a(zipfile, j, stringbuilder.toString()));
        ad.a();
        k++;
        if (true) goto _L4; else goto _L3
        zipfile;
        ad.a(zipfile);
_L3:
    }

    public void b()
    {
        for (Iterator iterator = a.iterator(); iterator.hasNext(); ((Bitmap)iterator.next()).recycle()) { }
        a.clear();
    }
}
