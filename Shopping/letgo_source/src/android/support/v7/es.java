// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import com.abtnprojects.ambatana.models.LetgoAddress;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseUser;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;

// Referenced classes of package android.support.v7:
//            df, aqo

public class es
{

    public es()
    {
    }

    LetgoAddress a()
        throws MalformedURLException, JSONException
    {
        return LetgoAddress.obtainFromJson((new df(null)).a(), "UserLocationByIp");
    }

    Void a(JSONArray jsonarray)
    {
        if (jsonarray == null)
        {
            return null;
        }
        Object obj = new URL("http://api.letgo.com?data=");
        DefaultHttpClient defaulthttpclient = new DefaultHttpClient();
        obj = new HttpPost(((URL) (obj)).toURI());
        ((HttpPost) (obj)).setEntity(new StringEntity(jsonarray.toString(), "UTF-8"));
        ((HttpPost) (obj)).setHeader("Content-Type", "application/json");
        ((HttpPost) (obj)).setHeader("Accept-Encoding", "application/json");
        ((HttpPost) (obj)).setHeader("Accept-Language", "en-US");
        aqo.a("Response status line: %s", new Object[] {
            defaulthttpclient.execute(((org.apache.http.client.methods.HttpUriRequest) (obj))).getStatusLine()
        });
        return null;
        jsonarray;
_L2:
        aqo.b(jsonarray, "sendFriendsToApi", new Object[0]);
        return null;
        jsonarray;
        aqo.b(jsonarray, "sendFriendsToApi", new Object[0]);
        return null;
        jsonarray;
        continue; /* Loop/switch isn't completed */
        jsonarray;
        continue; /* Loop/switch isn't completed */
        jsonarray;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public boolean a(ParseFile parsefile)
    {
        if (parsefile == null)
        {
            return false;
        }
        try
        {
            parsefile.save();
        }
        // Misplaced declaration of an exception variable
        catch (ParseFile parsefile)
        {
            aqo.b(parsefile, "error saving photo ParseFile", new Object[0]);
            return false;
        }
        return true;
    }

    public boolean a(ParseUser parseuser)
    {
        if (parseuser == null)
        {
            return false;
        }
        try
        {
            parseuser.save();
        }
        catch (ParseException parseexception)
        {
            if (parseuser == null)
            {
                parseuser = null;
            } else
            {
                parseuser = parseuser.getObjectId();
            }
            aqo.b(parseexception, "updateUserDataAfterFacebookLogin : code : %d, userId : %s", new Object[] {
                Integer.valueOf(parseexception.getCode()), parseuser
            });
            return false;
        }
        return true;
    }
}
