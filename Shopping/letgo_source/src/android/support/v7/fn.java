// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import com.abtnprojects.ambatana.models.LetgoAddress;
import com.abtnprojects.ambatana.models.SignUpUserInfoBitmap;
import com.abtnprojects.ambatana.ui.signup.j;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseUser;
import java.io.ByteArrayOutputStream;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

// Referenced classes of package android.support.v7:
//            aqo, iv, io, df, 
//            cz

public class fn extends AsyncTask
{

    private final WeakReference a;
    private final SignUpUserInfoBitmap b;
    private final LetgoAddress c;
    private final WeakReference d;

    public fn(j j1, SignUpUserInfoBitmap signupuserinfobitmap, LetgoAddress letgoaddress, Context context)
    {
        a = new WeakReference(j1);
        b = signupuserinfobitmap;
        c = letgoaddress;
        d = new WeakReference(context);
    }

    private boolean a()
    {
        Object obj = ParseUser.getCurrentUser();
        Object obj1 = b.getUserEmail();
        ((ParseUser) (obj)).setUsername(((String) (obj1)));
        ((ParseUser) (obj)).setPassword(b.getUserPassword());
        ((ParseUser) (obj)).setEmail(((String) (obj1)));
        ((ParseUser) (obj)).put("username_public", b.getUserNamePublic());
        ((ParseUser) (obj)).put("loginType", Integer.valueOf(0));
        try
        {
            ((ParseUser) (obj)).signUp();
        }
        catch (ParseException parseexception)
        {
            aqo.b(parseexception, "Signup exception", new Object[0]);
            b();
            return false;
        }
        catch (IllegalArgumentException illegalargumentexception)
        {
            aqo.b(illegalargumentexception, "Signup exception", new Object[0]);
            b();
            return false;
        }
        obj1 = ParseUser.getCurrentUser();
        aqo.b("Current user is %s", new Object[] {
            ((ParseUser) (obj1)).getUsername()
        });
        obj = b.getUserAvatar();
        if (obj != null)
        {
            Object obj2 = new ByteArrayOutputStream();
            ((Bitmap) (obj)).compress(android.graphics.Bitmap.CompressFormat.JPEG, 50, ((java.io.OutputStream) (obj2)));
            byte abyte0[] = ((ByteArrayOutputStream) (obj2)).toByteArray();
            abyte0 = new ParseFile((new StringBuilder()).append(((ParseUser) (obj1)).getObjectId()).append(".jpg").toString(), abyte0);
            try
            {
                abyte0.save();
            }
            catch (ParseException parseexception2)
            {
                aqo.b(parseexception2, "Adding photo exception", new Object[0]);
            }
            ((ParseUser) (obj1)).put("avatar", abyte0);
            try
            {
                ((ParseUser) (obj1)).save();
            }
            catch (ParseException parseexception1)
            {
                aqo.b(parseexception1, "Saving avatar exception", new Object[0]);
            }
            ((Bitmap) (obj)).recycle();
        }
        return true;
    }

    private void b()
    {
        ParseUser.logOut();
        iv.b();
    }

    protected transient Boolean a(Void avoid[])
    {
        avoid = null;
        boolean flag = a();
        if (flag)
        {
            if (c != null)
            {
                io.a(c);
            } else
            {
                JSONObject jsonobject = (new df(null)).a();
                LetgoAddress letgoaddress = LetgoAddress.obtainFromJson(jsonobject, "UserLocationByIp");
                if (letgoaddress != null)
                {
                    io.a(letgoaddress);
                } else
                {
                    if (jsonobject != null)
                    {
                        avoid = jsonobject.toString();
                    }
                    aqo.b(new cz((new StringBuilder()).append("Unable to resolve location by ip: json : ").append(avoid).toString()), "failed location by ip", new Object[0]);
                }
            }
        }
        return Boolean.valueOf(flag);
    }

    protected void a(Boolean boolean1)
    {
        if (a != null && a.get() != null && d.get() != null)
        {
            ((j)a.get()).a(boolean1, (Context)d.get());
        }
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((Void[])aobj);
    }

    protected void onPostExecute(Object obj)
    {
        a((Boolean)obj);
    }
}
