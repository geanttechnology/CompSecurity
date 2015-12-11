// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.loopj.android.http;

import android.util.Log;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpResponseException;

// Referenced classes of package shared_presage.com.loopj.android.http:
//            AsyncHttpResponseHandler

public class BinaryHttpResponseHandler extends AsyncHttpResponseHandler
{

    private String mAllowedContentTypes[] = {
        "image/jpeg", "image/png"
    };

    public BinaryHttpResponseHandler()
    {
    }

    public BinaryHttpResponseHandler(String as[])
    {
        this();
        mAllowedContentTypes = as;
    }

    public String[] getAllowedContentTypes()
    {
        return mAllowedContentTypes;
    }

    public void onFailure(int i, Header aheader[], byte abyte0[], Throwable throwable)
    {
        onFailure(i, throwable, null);
    }

    public void onSuccess(int i, byte abyte0[])
    {
        onSuccess(abyte0);
    }

    public void onSuccess(int i, Header aheader[], byte abyte0[])
    {
        onSuccess(i, abyte0);
    }

    public void onSuccess(byte abyte0[])
    {
    }

    public final void sendResponseMessage(HttpResponse httpresponse)
    {
        StatusLine statusline;
        Header header;
        String as[];
        int i;
        boolean flag;
        int j;
        flag = false;
        statusline = httpresponse.getStatusLine();
        Header aheader[] = httpresponse.getHeaders("Content-Type");
        if (aheader.length != 1)
        {
            sendFailureMessage(statusline.getStatusCode(), httpresponse.getAllHeaders(), null, new HttpResponseException(statusline.getStatusCode(), "None, or more than one, Content-Type Header found!"));
            return;
        }
        header = aheader[0];
        as = getAllowedContentTypes();
        j = as.length;
        i = 0;
_L2:
        String s;
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        s = as[i];
        boolean flag1 = Pattern.matches(s, header.getValue());
        if (flag1)
        {
            flag = true;
        }
_L3:
        i++;
        if (true) goto _L2; else goto _L1
        PatternSyntaxException patternsyntaxexception;
        patternsyntaxexception;
        Log.e("BinaryHttpResponseHandler", (new StringBuilder("Given pattern is not valid: ")).append(s).toString(), patternsyntaxexception);
          goto _L3
_L1:
        if (!flag)
        {
            sendFailureMessage(statusline.getStatusCode(), httpresponse.getAllHeaders(), null, new HttpResponseException(statusline.getStatusCode(), "Content-Type not allowed!"));
            return;
        } else
        {
            super.sendResponseMessage(httpresponse);
            return;
        }
    }
}
