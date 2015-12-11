// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import android.os.AsyncTask;

public final class z
{
    public static final class a extends AsyncTask
    {

        private final Runnable a;

        protected final Object doInBackground(Object aobj[])
        {
            a.run();
            return null;
        }

        public a(Runnable runnable)
        {
            a = runnable;
        }
    }

}
