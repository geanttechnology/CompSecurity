// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import com.abtnprojects.ambatana.datasource.api.UploadImageService;
import com.abtnprojects.ambatana.datasource.api.c;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import retrofit.RetrofitError;
import retrofit.mime.TypedFile;
import retrofit.mime.TypedString;

// Referenced classes of package android.support.v7:
//            aqo

public class ds
{
    public static interface a
    {

        public abstract void a(int i);
    }


    private UploadImageService a;
    private boolean b;

    public ds(String s)
    {
        a = c.i(s);
    }

    public List a(String s, List list, a a1)
    {
        ArrayList arraylist;
        Iterator iterator;
        int i;
        if (b)
        {
            return null;
        }
        if (list == null)
        {
            aqo.d("No images to upload", new Object[0]);
            return null;
        }
        b = true;
        arraylist = new ArrayList();
        aqo.a("will upload %d ", new Object[] {
            Integer.valueOf(list.size())
        });
        iterator = list.iterator();
        i = 1;
_L3:
        TypedFile typedfile;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_206;
        }
        list = (File)iterator.next();
        typedfile = new TypedFile("multipart/form-data", list);
        if (list != null)
        {
            break MISSING_BLOCK_LABEL_177;
        }
        list = "null";
_L1:
        int j;
        try
        {
            aqo.a("will upload %s", new Object[] {
                list
            });
            a1.a(i);
            list = a.uploadImage(new TypedString(s), typedfile);
        }
        // Misplaced declaration of an exception variable
        catch (List list)
        {
            aqo.b(list, "error uploading image : url %s", new Object[] {
                list.getUrl()
            });
            continue; /* Loop/switch isn't completed */
        }
        j = i;
        if (list == null)
        {
            break MISSING_BLOCK_LABEL_214;
        }
        arraylist.add(list);
        j = i + 1;
        break MISSING_BLOCK_LABEL_214;
        list = list.getAbsolutePath();
          goto _L1
        b = false;
        return arraylist;
        i = j;
        if (true) goto _L3; else goto _L2
_L2:
    }
}
