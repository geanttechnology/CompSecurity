// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.boldchat.visitor.api.internal;

import com.boldchat.visitor.api.json.JSONObject;
import java.io.IOException;

// Referenced classes of package com.boldchat.visitor.api.internal:
//            ResultListener, VisitorWebSocket, VisitorMessageListener

class this._cls1
    implements ResultListener
{

    final is._cls0 this$1;

    public void failure(int i, String s, JSONObject jsonobject)
    {
        getVisitorMessageListener().onClose(-100, s, false, _fld0);
    }

    public void failure(IOException ioexception)
    {
        VisitorMessageListener visitormessagelistener = getVisitorMessageListener();
        if (ioexception.getLocalizedMessage() != null)
        {
            ioexception = ioexception.getLocalizedMessage();
        } else
        {
            ioexception = ioexception.getMessage();
        }
        visitormessagelistener.onClose(-100, ioexception, false, _fld0);
    }

    public void success(JSONObject jsonobject)
    {
        connectedOnce = true;
        getVisitorMessageListener().onOpen(_fld0);
    }

    ()
    {
        this$1 = this._cls1.this;
        super();
    }
}
