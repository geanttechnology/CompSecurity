// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.ca;

import android.content.Intent;
import com.socialin.asyncnet.Request;
import org.json.JSONObject;

// Referenced classes of package myobfuscated.ca:
//            a, b

final class d
    implements com.socialin.asyncnet.d
{

    private a a;

    private d(a a1)
    {
        a = a1;
        super();
    }

    d(a a1, byte byte0)
    {
        this(a1);
    }

    public final volatile void onCancelRequest(Object obj, Request request)
    {
    }

    public final void onFailure(Exception exception, Request request)
    {
        myobfuscated.ca.a.a(a, "aouth2 get access_token problem.");
    }

    public final transient void onProgressUpdate(Integer ainteger[])
    {
    }

    public final void onSuccess(Object obj, Request request)
    {
        obj = (String)obj;
        obj = new JSONObject(((String) (obj)));
        if (!((JSONObject) (obj)).has("access_token"))
        {
            break MISSING_BLOCK_LABEL_134;
        }
        if (myobfuscated.ca.a.j(a) != null)
        {
            myobfuscated.ca.a.j(a).a(((JSONObject) (obj)).toString());
            return;
        }
        try
        {
            request = new Intent();
            request.putExtra("oauth2ResultJson", ((JSONObject) (obj)).toString());
            request.putExtra("oauth2AccessToken", ((JSONObject) (obj)).getString("access_token"));
            request.putExtra("oauth2RefreshToken", ((JSONObject) (obj)).optString("refresh_token"));
            request.putExtra("oauth2TokenExpiresIn", ((JSONObject) (obj)).optLong("expires_in"));
            myobfuscated.ca.a.a(a, request);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            com.socialin.android.d.b(myobfuscated.ca.a.a(), new Object[] {
                obj
            });
        }
        return;
        if (myobfuscated.ca.a.j(a) != null)
        {
            myobfuscated.ca.a.j(a).a(((JSONObject) (obj)).toString());
            return;
        }
        myobfuscated.ca.a.a(a, "aouth2 get access_token problem.");
        return;
    }
}
