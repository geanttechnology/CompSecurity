// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package jumiomobile:
//            oq, pz, ab, qa, 
//            cs

class ot
    implements oq
{

    private File a;

    public ot(File file)
    {
        a = file;
    }

    private static void a(File file, List list)
    {
        file = new File(file, "tm_results.txt");
        BufferedOutputStream bufferedoutputstream = new BufferedOutputStream(new FileOutputStream(file));
        file = bufferedoutputstream;
        list = list.iterator();
_L2:
        file = bufferedoutputstream;
        if (!list.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        file = bufferedoutputstream;
        pz pz1 = (pz)list.next();
        file = bufferedoutputstream;
        bufferedoutputstream.write((new StringBuilder()).append(pz1.toString()).append("\n").toString().getBytes());
        file = bufferedoutputstream;
        ab.a("TemplateMatcher", pz1.toString());
        if (true) goto _L2; else goto _L1
        list;
_L9:
        file = bufferedoutputstream;
        ab.a(list);
        if (bufferedoutputstream == null)
        {
            break MISSING_BLOCK_LABEL_123;
        }
        bufferedoutputstream.flush();
        bufferedoutputstream.close();
_L4:
        return;
_L1:
        try
        {
            bufferedoutputstream.flush();
            bufferedoutputstream.close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (File file)
        {
            ab.a(file);
        }
        return;
        file;
        ab.a(file);
        return;
        list;
        bufferedoutputstream = null;
_L7:
        file = bufferedoutputstream;
        ab.a(list);
        if (bufferedoutputstream == null) goto _L4; else goto _L3
_L3:
        try
        {
            bufferedoutputstream.flush();
            bufferedoutputstream.close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (File file)
        {
            ab.a(file);
        }
        return;
        list;
        file = null;
_L6:
        if (file != null)
        {
            try
            {
                file.flush();
                file.close();
            }
            // Misplaced declaration of an exception variable
            catch (File file)
            {
                ab.a(file);
            }
        }
        throw list;
        list;
        if (true) goto _L6; else goto _L5
_L5:
        list;
          goto _L7
        list;
        bufferedoutputstream = null;
        if (true) goto _L9; else goto _L8
_L8:
    }

    private boolean a(List list, File file)
    {
        list = list.iterator();
        boolean flag = false;
        do
        {
            if (!list.hasNext())
            {
                break;
            }
            pz pz1 = (pz)list.next();
            if (pz1 instanceof qa)
            {
                android.graphics.Bitmap abitmap[] = ((qa)pz1).d();
                if (abitmap != null)
                {
                    if (abitmap[0] != null)
                    {
                        cs.a(null, abitmap[0], file, "original.jpg", android.graphics.Bitmap.CompressFormat.JPEG, 80);
                    }
                    if (abitmap[1] != null)
                    {
                        cs.a(null, abitmap[1], file, "rectified.jpg", android.graphics.Bitmap.CompressFormat.JPEG, 80);
                    }
                }
                flag = true;
            }
        } while (true);
        return flag;
    }

    public boolean a(List list)
    {
        a(a, list);
        if (!a(list, a))
        {
            ab.e("TemplateMatcher", "No bitmaps were persisted!");
        }
        return true;
    }
}
