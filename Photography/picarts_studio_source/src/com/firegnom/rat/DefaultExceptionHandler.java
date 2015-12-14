// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.firegnom.rat;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.database.sqlite.SQLiteDiskIOException;
import android.database.sqlite.SQLiteException;
import android.os.Process;
import com.flurry.android.FlurryAgent;
import com.socialin.android.d;

public class DefaultExceptionHandler
    implements Thread.UncaughtExceptionHandler
{

    private Class a;
    private Context context;

    public DefaultExceptionHandler(Context context1, Class class1)
    {
        context = context1;
        a = class1;
    }

    public void postProcessException(Throwable throwable)
    {
        if ((throwable instanceof SQLiteDatabaseCorruptException) || (throwable instanceof SQLiteDiskIOException) || (throwable instanceof SQLiteException))
        {
            context.deleteDatabase("webview.db");
            context.deleteDatabase("webviewCache.db");
        }
    }

    public void uncaughtException(Thread thread, Throwable throwable)
    {
        if (thread.getName().startsWith("AdWorker"))
        {
            d.b("ADMOB", new Object[] {
                "AdWorker thread thrown an exception.", throwable
            });
            return;
        } else
        {
            postProcessException(throwable);
            throwable.printStackTrace();
            FlurryAgent.onError("uncaught", throwable.getMessage(), throwable);
            thread = new Intent(context, a);
            thread.putExtra("EXCEPTION", throwable);
            thread.setFlags(0x10000000);
            context.startActivity(thread);
            Process.killProcess(Process.myPid());
            return;
        }
    }
}
