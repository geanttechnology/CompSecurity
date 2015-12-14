// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import android.os.Bundle;
import android.widget.EditText;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.utility.MakeupMode;
import com.facebook.HttpMethod;
import com.facebook.Request;
import com.facebook.Response;
import com.facebook.Session;
import com.facebook.model.GraphPlace;
import com.facebook.model.GraphUser;
import java.util.List;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            FacebookSharingActivity

class nish
    implements Runnable
{

    com.facebook.ebookSharingActivity._cls5.b a;
    final FacebookSharingActivity b;

    public void run()
    {
        int i;
        b.a(MakeupMode.g);
        Object obj;
        Object obj1;
        Bundle bundle;
        Globals globals;
        List list;
        try
        {
            globals = Globals.d();
            String s = FacebookSharingActivity.k(b).getText().toString();
            bundle = new Bundle();
            bundle.putString("message", s);
            bundle.putString("link", FacebookSharingActivity.n(b));
            list = globals.E();
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            FacebookSharingActivity.a(b, 0x7f070694);
            return;
        }
        if (list == null) goto _L2; else goto _L1
_L1:
        if (list.size() <= 0) goto _L2; else goto _L3
_L3:
        obj = "[";
        i = 0;
_L8:
        if (i >= list.size()) goto _L5; else goto _L4
_L4:
        obj1 = (GraphUser)list.get(i);
        obj1 = (new StringBuilder()).append("{\"tag_uid\": \"").append(((GraphUser) (obj1)).getId()).toString();
        obj1 = (new StringBuilder()).append(((String) (obj1))).append("\"}").toString();
        obj1 = (new StringBuilder()).append(((String) (obj))).append(((String) (obj1))).toString();
        obj = obj1;
        if (i < list.size() - 1)
        {
            obj = (new StringBuilder()).append(((String) (obj1))).append(",").toString();
        }
          goto _L6
_L5:
        bundle.putString("tags", (new StringBuilder()).append(((String) (obj))).append("]").toString());
_L2:
        obj = globals.F();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_260;
        }
        bundle.putString("place", ((GraphPlace) (obj)).getId());
        (new Request(Session.getActiveSession(), "feed", bundle, HttpMethod.POST, a)).executeAsync();
        FacebookSharingActivity.a(b, 0x7f070696);
        return;
_L6:
        i++;
        if (true) goto _L8; else goto _L7
_L7:
    }

    _cls1.a(FacebookSharingActivity facebooksharingactivity)
    {
        b = facebooksharingactivity;
        super();
        a = new com.facebook.Request.Callback() {

            final FacebookSharingActivity._cls5 a;

            public void onCompleted(Response response)
            {
                if (response.getError() != null)
                {
                    FacebookSharingActivity.k(a.b).setFocusableInTouchMode(true);
                    FacebookSharingActivity.k(a.b).setFocusable(true);
                    FacebookSharingActivity.b(a.b, true);
                    a.b.i();
                    FacebookSharingActivity.a(a.b, 0x7f070694);
                    return;
                } else
                {
                    a.b.i();
                    FacebookSharingActivity.a(a.b, 0x7f070695);
                    a.b.finish();
                    return;
                }
            }

            
            {
                a = FacebookSharingActivity._cls5.this;
                super();
            }
        };
    }
}
