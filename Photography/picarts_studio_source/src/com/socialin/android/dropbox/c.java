// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.dropbox;

import android.content.SharedPreferences;
import com.socialin.android.util.aj;
import com.socialin.asyncnet.Request;
import com.socialin.asyncnet.b;
import com.socialin.asyncnet.d;
import org.json.JSONObject;

// Referenced classes of package com.socialin.android.dropbox:
//            DropboxUploadRemote

final class c
    implements d
{

    private aj a;
    private DropboxUploadRemote b;

    public c(DropboxUploadRemote dropboxuploadremote, aj aj1)
    {
        b = dropboxuploadremote;
        super();
        a = aj1;
    }

    private static boolean a(String s)
    {
        for (int i = 0; i < 5; i++)
        {
            if (s.endsWith((new String[] {
    "jpeg", "jpg", "JPG", "PNG", "png"
})[i]))
            {
                return true;
            }
        }

        return false;
    }

    public final volatile void onCancelRequest(Object obj, Request request)
    {
    }

    public final void onFailure(Exception exception, Request request)
    {
        if (a != null)
        {
            a.b();
        }
    }

    public final transient void onProgressUpdate(Integer ainteger[])
    {
    }

    public final void onSuccess(Object obj, Request request)
    {
        obj = (String)obj;
        obj = new JSONObject(((String) (obj)));
        com.socialin.android.d.b(DropboxUploadRemote.TAG, new Object[] {
            (new StringBuilder("remote upload json : ")).append(((JSONObject) (obj)).toString(3)).toString()
        });
        if (((JSONObject) (obj)).has("error"))
        {
            if (a != null)
            {
                a.b();
                return;
            }
            break MISSING_BLOCK_LABEL_212;
        }
        try
        {
            if (a != null)
            {
                a.a();
            }
            obj = ((JSONObject) (obj)).getString("path");
            if (!a(((String) (obj))))
            {
                request = (new StringBuilder()).append(((String) (obj))).append(".jpg").toString();
                String s = DropboxUploadRemote.access$000(b).getString("oauth2AccessToken", null);
                Request request1 = new Request("https://api.dropbox.com/1/fileops/move", null, "POST");
                request1.c();
                request1.a("root", "dropbox");
                request1.a("from_path", ((String) (obj)));
                request1.a("to_path", request);
                request1.a("access_token", s);
                com.socialin.asyncnet.b.a().a(request1, null);
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            com.socialin.android.d.a(DropboxUploadRemote.TAG, ((Throwable) (obj)));
        }
    }
}
