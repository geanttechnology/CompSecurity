// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.loopj.android.http;

import org.apache.http.Header;

// Referenced classes of package shared_presage.com.loopj.android.http:
//            TextHttpResponseHandler, h, e

public abstract class BaseJsonHttpResponseHandler extends TextHttpResponseHandler
{

    private static final String LOG_TAG = "BaseJsonHttpResponseHandler";

    public BaseJsonHttpResponseHandler()
    {
        super("UTF-8");
    }

    public BaseJsonHttpResponseHandler(String s)
    {
        super(s);
    }

    public final void onFailure(int i, Throwable throwable, String s)
    {
        super.onFailure(i, throwable, s);
    }

    public void onFailure(int i, Header aheader[], String s, Throwable throwable)
    {
        if (s != null)
        {
            (new Thread(new h(this, s, i, aheader, throwable))).start();
            return;
        } else
        {
            onFailure(i, aheader, throwable, null, null);
            return;
        }
    }

    public final void onFailure(int i, Header aheader[], Throwable throwable, String s)
    {
        super.onFailure(i, aheader, throwable, s);
    }

    public abstract void onFailure(int i, Header aheader[], Throwable throwable, String s, Object obj);

    public final void onFailure(int i, Header aheader[], byte abyte0[], Throwable throwable)
    {
        super.onFailure(i, aheader, abyte0, throwable);
    }

    public final void onFailure(String s, Throwable throwable)
    {
        super.onFailure(s, throwable);
    }

    public final void onFailure(Throwable throwable)
    {
        super.onFailure(throwable);
    }

    public final void onFailure(Throwable throwable, String s)
    {
        super.onFailure(throwable, s);
    }

    public final void onSuccess(int i, String s)
    {
        super.onSuccess(i, s);
    }

    public void onSuccess(int i, Header aheader[], String s)
    {
        if (i != 204)
        {
            (new Thread(new e(this, s, i, aheader))).start();
            return;
        } else
        {
            onSuccess(i, aheader, null, null);
            return;
        }
    }

    public abstract void onSuccess(int i, Header aheader[], String s, Object obj);

    public final void onSuccess(int i, Header aheader[], byte abyte0[])
    {
        super.onSuccess(i, aheader, abyte0);
    }

    public final void onSuccess(String s)
    {
        super.onSuccess(s);
    }

    protected abstract Object parseResponse(String s);
}
