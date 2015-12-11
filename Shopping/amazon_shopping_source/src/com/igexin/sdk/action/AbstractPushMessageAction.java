// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.igexin.sdk.action;

import com.igexin.sdk.bean.BaseBean;
import com.igexin.sdk.bean.PushMessageBean;
import org.json.JSONObject;

public interface AbstractPushMessageAction
{

    public abstract boolean executeAction(PushMessageBean pushmessagebean, BaseBean basebean);

    public abstract BaseBean parseAction(JSONObject jsonobject);

    public abstract com.igexin.sdk.Consts.ActionPrepareState prepareExecuteAction(PushMessageBean pushmessagebean, BaseBean basebean);
}
