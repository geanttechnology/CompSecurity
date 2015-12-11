// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package roboguice.util;


// Referenced classes of package roboguice.util:
//            AndroidCallable, SafeAsyncTask

public class this._cls0 extends AndroidCallable
{

    final SafeAsyncTask this$0;

    public Object doInBackground()
        throws Exception
    {
        return call();
    }

    public void onException(Exception exception)
    {
        SafeAsyncTask.this.onException(exception);
    }

    public void onFinally()
    {
        SafeAsyncTask.this.onFinally();
    }

    public void onPreCall()
    {
        try
        {
            onPreExecute();
            return;
        }
        catch (Exception exception)
        {
            throw new RuntimeException(exception);
        }
    }

    public void onSuccess(Object obj)
    {
        try
        {
            SafeAsyncTask.this.onSuccess(obj);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new RuntimeException(((Throwable) (obj)));
        }
    }

    public ()
    {
        this$0 = SafeAsyncTask.this;
        super();
    }
}
