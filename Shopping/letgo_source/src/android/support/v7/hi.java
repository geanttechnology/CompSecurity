// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import com.parse.ParseGeoPoint;
import com.parse.ParseUser;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package android.support.v7:
//            gi, iw, iy, aqo

public class hi
    implements gi
{

    public hi()
    {
    }

    private boolean b(ParseUser parseuser)
    {
        if (parseuser != null)
        {
            if (!TextUtils.isEmpty(parseuser = parseuser.getUsername()))
            {
                return parseuser.toLowerCase(Locale.US).startsWith("usercontent");
            }
        }
        return false;
    }

    public void a()
    {
    }

    public void a(Activity activity)
    {
        iw.a().a(activity, "69da28c79cbeb97257bc1232d40dd96a");
    }

    public void a(Application application)
    {
        iw.a().a(application.getApplicationContext(), "69da28c79cbeb97257bc1232d40dd96a").a(application);
        iw.a().a(false);
    }

    public void a(Context context, String s, Map map, ParseUser parseuser)
    {
        context = new JSONObject();
        try
        {
            for (map = map.entrySet().iterator(); map.hasNext(); context.put((String)parseuser.getKey(), parseuser.getValue()))
            {
                parseuser = (java.util.Map.Entry)map.next();
            }

        }
        // Misplaced declaration of an exception variable
        catch (Map map)
        {
            aqo.b(map, "Error parsing tracking json object", new Object[0]);
        }
        iw.a().a(s, context);
    }

    public void a(ParseUser parseuser)
    {
        JSONObject jsonobject;
        iw.a().b(parseuser.getEmail());
        jsonobject = new JSONObject();
        jsonobject.put("user-id", parseuser.getObjectId());
        if (!b(parseuser))
        {
            break MISSING_BLOCK_LABEL_88;
        }
        jsonobject.put("UserType", "Dummy");
_L1:
        parseuser = parseuser.getParseGeoPoint("gpscoords");
        if (parseuser == null)
        {
            break MISSING_BLOCK_LABEL_80;
        }
        jsonobject.put("user-lat", parseuser.getLatitude());
        jsonobject.put("user-lng", parseuser.getLongitude());
        iw.a().b(jsonobject);
        return;
        try
        {
            jsonobject.put("UserType", "Real");
        }
        // Misplaced declaration of an exception variable
        catch (ParseUser parseuser)
        {
            aqo.b(parseuser, "Error adding user property", new Object[0]);
            return;
        }
          goto _L1
    }

    public void b()
    {
        iw.a().b("");
        JSONObject jsonobject = new JSONObject();
        try
        {
            jsonobject.put("user-id", "");
            jsonobject.put("UserType", "");
            jsonobject.put("user-lat", "");
            jsonobject.put("user-lng", "");
            iw.a().b(jsonobject);
            return;
        }
        catch (JSONException jsonexception)
        {
            aqo.b(jsonexception, "Error adding user property", new Object[0]);
        }
    }

    public void b(Activity activity)
    {
    }

    public void b(Context context, String s, Map map, ParseUser parseuser)
    {
        context = new JSONObject();
        try
        {
            for (map = map.entrySet().iterator(); map.hasNext(); context.put((String)parseuser.getKey(), parseuser.getValue()))
            {
                parseuser = (java.util.Map.Entry)map.next();
            }

        }
        // Misplaced declaration of an exception variable
        catch (Map map)
        {
            aqo.b(map, "Error parsing tracking json object", new Object[0]);
        }
        iw.a().a(s, context);
    }

    public void c(Activity activity)
    {
    }

    public void d(Activity activity)
    {
    }

    public void e(Activity activity)
    {
    }

    public void f(Activity activity)
    {
    }
}
