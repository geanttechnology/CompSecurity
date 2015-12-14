// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.util.Log;
import java.io.File;

class lang.Object
    implements rv
{

    final oa a;

    public void a(int i)
    {
        File file;
        Log.i("CopyFile", (new StringBuilder()).append("CopyFileFinished..  state ...").append(i).toString());
        file = new File((new StringBuilder()).append(a.c).append(a.b).toString());
        if (!file.exists()) goto _L2; else goto _L1
_L1:
        i;
        JVM INSTR tableswitch 1 1: default 88
    //                   1 124;
           goto _L3 _L4
_L3:
        file.delete();
        if (a.a != null)
        {
            a.a.a();
        }
_L6:
        a.d = null;
        return;
_L4:
        if (a.a != null)
        {
            a.a.a(file);
        }
        continue; /* Loop/switch isn't completed */
_L2:
        if (a.a != null)
        {
            a.a.a();
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    >(oa oa1)
    {
        a = oa1;
        super();
    }
}
