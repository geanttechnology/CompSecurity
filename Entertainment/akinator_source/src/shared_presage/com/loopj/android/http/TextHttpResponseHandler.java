// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.loopj.android.http;

import android.util.Log;
import java.io.UnsupportedEncodingException;
import org.apache.http.Header;

// Referenced classes of package shared_presage.com.loopj.android.http:
//            AsyncHttpResponseHandler

public class TextHttpResponseHandler extends AsyncHttpResponseHandler
{

    private static final String LOG_TAG = "TextHttpResponseHandler";

    public TextHttpResponseHandler()
    {
        this("UTF-8");
    }

    public TextHttpResponseHandler(String s)
    {
        setCharset(s);
    }

    public void onFailure(int i, Header aheader[], String s, Throwable throwable)
    {
        onFailure(s, throwable);
    }

    public void onFailure(int i, Header aheader[], byte abyte0[], Throwable throwable)
    {
        if (abyte0 != null)
        {
            break MISSING_BLOCK_LABEL_16;
        }
        abyte0 = null;
_L1:
        try
        {
            onFailure(i, aheader, ((String) (abyte0)), throwable);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            Log.v("TextHttpResponseHandler", "String encoding failed, calling onFailure(int, Header[], String, Throwable)");
        }
        break MISSING_BLOCK_LABEL_41;
        abyte0 = new String(abyte0, getCharset());
          goto _L1
        onFailure(0, aheader, ((String) (null)), ((Throwable) (abyte0)));
        return;
    }

    public void onFailure(String s, Throwable throwable)
    {
    }

    public void onSuccess(int i, Header aheader[], String s)
    {
        onSuccess(i, s);
    }

    public void onSuccess(int i, Header aheader[], byte abyte0[])
    {
        if (abyte0 != null)
        {
            break MISSING_BLOCK_LABEL_14;
        }
        abyte0 = null;
_L1:
        try
        {
            onSuccess(i, aheader, ((String) (abyte0)));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            Log.v("TextHttpResponseHandler", "String encoding failed, calling onFailure(int, Header[], String, Throwable)");
        }
        break MISSING_BLOCK_LABEL_39;
        abyte0 = new String(abyte0, getCharset());
          goto _L1
        onFailure(0, aheader, ((String) (null)), abyte0);
        return;
    }
}
