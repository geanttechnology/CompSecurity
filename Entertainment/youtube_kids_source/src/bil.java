// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.ConditionVariable;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;

public final class bil
    implements Runnable
{

    private big a;

    public bil(big big1)
    {
        a = big1;
        super();
    }

    public final void run()
    {
        big big1 = a;
        File afile[] = (new File(big1.a)).listFiles(big1.c);
        if (afile != null)
        {
            int j = afile.length;
            for (int i = 0; i < j; i++)
            {
                File file = afile[i];
                big1.b.put(file.getName(), "");
            }

        }
        a.d.open();
    }
}
