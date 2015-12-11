// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage.actions;

import android.content.Context;
import android.os.AsyncTask;
import io.presage.utils.i;

public abstract class NewAction
{
    final class a extends AsyncTask
    {

        final NewAction a;
        private NewAction b;

        protected final Object doInBackground(Object aobj[])
        {
            return b.execute();
        }

        protected final volatile void onPostExecute(Object obj)
        {
            obj = (String)obj;
            b.onPostExecute(((String) (obj)));
        }

        public a(NewAction newaction1)
        {
            a = NewAction.this;
            super();
            b = newaction1;
        }
    }


    protected Context b;

    public NewAction(Context context)
    {
        b = context;
    }

    public abstract String execute();

    public final void executeInBackground()
    {
        (new a(this)).executeOnExecutor(i.a(), new String[0]);
    }

    protected void onPostExecute(String s)
    {
    }
}
