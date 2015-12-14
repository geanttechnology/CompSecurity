// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Process;
import com.fotoable.comlib.util.UgentAsyncTask;
import java.util.concurrent.atomic.AtomicBoolean;

public class aab extends aai
{

    final UgentAsyncTask a;

    public aab(UgentAsyncTask ugentasynctask)
    {
        a = ugentasynctask;
        super(null);
    }

    public Object call()
    {
        UgentAsyncTask.a(a).set(true);
        Process.setThreadPriority(10);
        return UgentAsyncTask.a(a, a.b(b));
    }
}
