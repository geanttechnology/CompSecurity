// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.tsz.afinal.http.entityhandler;

import android.text.TextUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.http.HttpEntity;

// Referenced classes of package net.tsz.afinal.http.entityhandler:
//            EntityCallBack

public class FileEntityHandler
{

    private boolean mStop;

    public FileEntityHandler()
    {
        mStop = false;
    }

    public Object handleEntity(HttpEntity httpentity, EntityCallBack entitycallback, String s, boolean flag)
        throws IOException
    {
        if (!TextUtils.isEmpty(s) && s.trim().length() != 0) goto _L2; else goto _L1
_L1:
        File file = null;
_L4:
        return file;
_L2:
        int i;
        long l;
        long l1;
        File file1 = new File(s);
        if (!file1.exists())
        {
            file1.createNewFile();
        }
        file = file1;
        if (mStop)
        {
            continue; /* Loop/switch isn't completed */
        }
        l = 0L;
        InputStream inputstream;
        if (flag)
        {
            l = file1.length();
            s = new FileOutputStream(s, true);
        } else
        {
            s = new FileOutputStream(s);
        }
        file = file1;
        if (mStop)
        {
            continue; /* Loop/switch isn't completed */
        }
        inputstream = httpentity.getContent();
        l1 = httpentity.getContentLength() + l;
        file = file1;
        if (l >= l1)
        {
            continue; /* Loop/switch isn't completed */
        }
        file = file1;
        if (mStop)
        {
            continue; /* Loop/switch isn't completed */
        }
        httpentity = new byte[1024];
_L5:
label0:
        {
            if (!mStop && l < l1)
            {
                i = inputstream.read(httpentity, 0, 1024);
                if (i > 0)
                {
                    break label0;
                }
            }
            entitycallback.callBack(l1, l, true);
            file = file1;
            if (mStop)
            {
                file = file1;
                if (l < l1)
                {
                    throw new IOException("user stop download thread");
                }
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
        s.write(httpentity, 0, i);
        l += i;
        entitycallback.callBack(l1, l, false);
          goto _L5
        if (true) goto _L4; else goto _L6
_L6:
    }

    public boolean isStop()
    {
        return mStop;
    }

    public void setStop(boolean flag)
    {
        mStop = flag;
    }
}
