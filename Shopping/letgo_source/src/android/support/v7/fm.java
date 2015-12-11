// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.Context;
import android.os.AsyncTask;
import com.parse.ParseFacebookUtils;
import com.parse.ParseUser;

// Referenced classes of package android.support.v7:
//            iv, dz, ef, ajx, 
//            is, eg

public class fm extends AsyncTask
{

    private final Context a;

    public fm(Context context)
    {
        a = context;
    }

    private void a()
    {
        ParseUser parseuser = ParseUser.getCurrentUser();
        if (ParseFacebookUtils.isLinked(parseuser))
        {
            parseuser.put("loginType", Integer.valueOf(1));
        } else
        {
            parseuser.put("loginType", Integer.valueOf(0));
        }
        ParseUser.logOut();
        iv.a();
        iv.b();
    }

    protected transient Void a(Void avoid[])
    {
        a();
        return null;
    }

    protected void a(Void void1)
    {
        dz.a().a(new ef());
        is.b(a);
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((Void[])aobj);
    }

    protected void onPostExecute(Object obj)
    {
        a((Void)obj);
    }

    protected void onPreExecute()
    {
        dz.a().a(new eg());
    }
}
