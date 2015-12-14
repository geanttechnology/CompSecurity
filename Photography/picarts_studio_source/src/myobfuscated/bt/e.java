// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.bt;

import android.app.Activity;
import android.text.TextUtils;
import com.socialin.android.util.Utils;
import com.socialin.asyncnet.Request;
import com.socialin.asyncnet.d;
import myobfuscated.f.m;
import org.json.JSONObject;

// Referenced classes of package myobfuscated.bt:
//            c

final class e
    implements d
{

    private c a;

    private e(c c1)
    {
        a = c1;
        super();
    }

    e(c c1, byte byte0)
    {
        this(c1);
    }

    public final volatile void onCancelRequest(Object obj, Request request)
    {
    }

    public final void onFailure(Exception exception, Request request)
    {
        exception = exception.getMessage();
        request = a.getActivity();
        if (request != null && !request.isFinishing())
        {
            m.b(request, c.c(a));
            if (!TextUtils.isEmpty(exception))
            {
                Utils.c(a.getActivity(), exception);
            }
            request.setResult(0);
            request.finish();
        }
    }

    public final transient void onProgressUpdate(Integer ainteger[])
    {
    }

    public final void onSuccess(Object obj, Request request)
    {
        request = (String)obj;
        obj = a.getActivity();
        if (obj == null || ((Activity) (obj)).isFinishing())
        {
            break MISSING_BLOCK_LABEL_98;
        }
        m.b(((Activity) (obj)), c.c(a));
        request = new JSONObject(request);
        if (request.has("error"))
        {
            Utils.c(a.getActivity(), request.getString("error"));
            ((Activity) (obj)).setResult(0);
            ((Activity) (obj)).finish();
            return;
        }
        try
        {
            ((Activity) (obj)).setResult(-1);
            ((Activity) (obj)).finish();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            com.socialin.android.d.a(c.c(), ((Throwable) (obj)));
        }
    }
}
