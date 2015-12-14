// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.service.net;

import android.content.Context;
import com.fotoable.comlib.util.AsyncTask;

public class ShareAsyncTask extends AsyncTask
{

    private Context a;
    private Target b;
    private Type c;

    public ShareAsyncTask(Context context, Target target, Type type)
    {
        a = context;
        b = target;
        c = type;
    }

    protected transient String a(String as[])
    {
        return null;
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((String[])aobj);
    }
}
