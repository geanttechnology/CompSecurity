// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.boldchat.visitor.api;

import com.boldchat.visitor.api.internal.RPCMethod;
import com.boldchat.visitor.api.internal.ResultListener;
import com.boldchat.visitor.api.json.JSONObject;
import java.io.IOException;
import java.util.ArrayList;

// Referenced classes of package com.boldchat.visitor.api:
//            Chat

class this._cls1
    implements ResultListener
{

    final is._cls0 this$1;

    public void failure(int i, String s, JSONObject jsonobject)
    {
        Chat.access$2908(_fld0);
        synchronized (Chat.access$100(_fld0))
        {
            Chat.access$100(_fld0).add(0, pMethod);
        }
        (new Thread(Chat.access$202(_fld0, new nit>(_fld0, null)))).start();
        return;
        jsonobject;
        s;
        JVM INSTR monitorexit ;
        throw jsonobject;
    }

    public void failure(IOException ioexception)
    {
        failure(-1, ioexception.getMessage(), null);
    }

    public void success(JSONObject jsonobject)
    {
        Chat.access$2902(_fld0, 0L);
        pMethod.getListener().success(jsonobject);
        (new Thread(Chat.access$202(_fld0, new nit>(_fld0, null)))).start();
    }

    ener()
    {
        this$1 = this._cls1.this;
        super();
    }
}
