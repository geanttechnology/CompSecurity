// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.bt;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;
import com.socialin.android.oauth2.a;
import com.socialin.android.util.Utils;
import com.socialin.asyncnet.Request;
import com.socialin.asyncnet.d;
import org.json.JSONObject;

// Referenced classes of package myobfuscated.bt:
//            c

final class g
    implements d
{

    private c a;

    private g(c c1)
    {
        a = c1;
        super();
    }

    g(c c1, byte byte0)
    {
        this(c1);
    }

    public final volatile void onCancelRequest(Object obj, Request request)
    {
    }

    public final void onFailure(Exception exception, Request request)
    {
        Utils.c(a.getActivity(), exception.getMessage());
        com.socialin.android.oauth2.a.a(myobfuscated.bt.c.a(a));
        a.a();
    }

    public final transient void onProgressUpdate(Integer ainteger[])
    {
    }

    public final void onSuccess(Object obj, Request request)
    {
        obj = (String)obj;
        request = new JSONObject(((String) (obj)));
        if (request.has("error"))
        {
            Utils.c(a.getActivity(), request.getString("error"));
            a.getActivity().finish();
            return;
        }
        View view;
        obj = a;
        request = request.getString("display_name");
        view = ((c) (obj)).getView();
        if (!((c) (obj)).b() && view != null)
        {
            try
            {
                view.findViewById(0x7f1003df).setVisibility(0);
                view.findViewById(0x7f1003e6).setVisibility(0);
                ((TextView)view.findViewById(0x7f1003e0)).setText(request);
                if ("dropboxMethodPost".equals(((c) (obj)).a))
                {
                    view.findViewById(0x7f1003e8).setVisibility(0);
                }
                ((c) (obj)).a("/");
                ((c) (obj)).getActivity().invalidateOptionsMenu();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                com.socialin.android.d.a(c.c(), ((Throwable) (obj)));
            }
        }
        return;
    }
}
