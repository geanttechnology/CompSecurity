// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.branch.referral;

import android.content.Context;
import org.json.JSONObject;

// Referenced classes of package io.branch.referral:
//            ServerRequest

abstract class ServerRequestInitSession extends ServerRequest
{

    public ServerRequestInitSession(Context context, String s)
    {
        super(context, s);
    }

    protected ServerRequestInitSession(String s, JSONObject jsonobject, Context context)
    {
        super(s, jsonobject, context);
    }

    public abstract boolean hasCallBack();
}
