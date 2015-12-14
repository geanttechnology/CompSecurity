// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.fotoable.comlib.util.AsyncTask;

public class zx extends AsyncTask
{

    final zu a;

    protected zx(zu zu1)
    {
        a = zu1;
        super();
    }

    protected transient Void a(Object aobj[])
    {
        ((Integer)aobj[0]).intValue();
        JVM INSTR tableswitch 0 3: default 40
    //                   0 42
    //                   1 52
    //                   2 62
    //                   3 72;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        return null;
_L2:
        a.b();
        continue; /* Loop/switch isn't completed */
_L3:
        a.a();
        continue; /* Loop/switch isn't completed */
_L4:
        a.c();
        continue; /* Loop/switch isn't completed */
_L5:
        a.d();
        if (true) goto _L1; else goto _L6
_L6:
    }

    protected Object doInBackground(Object aobj[])
    {
        return a(aobj);
    }
}
