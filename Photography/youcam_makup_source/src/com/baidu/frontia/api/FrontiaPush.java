// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.baidu.frontia.api;

import android.content.Context;
import com.baidu.android.pushservice.internal.PushManager;
import com.baidu.android.pushservice.internal.PushSettings;
import com.baidu.frontia.FrontiaQuery;
import com.baidu.frontia.base.stat.StatUtils;
import com.baidu.frontia.framework.IModule;
import com.baidu.frontia.module.push.FrontiaPushImpl;
import java.util.List;

public class FrontiaPush
    implements IModule
{

    private static FrontiaPush a = null;
    private FrontiaPushImpl b;
    private Context c;

    private FrontiaPush(Context context)
    {
        c = context;
        b = new FrontiaPushImpl(context);
    }

    public static FrontiaPush newInstance(Context context)
    {
        if (context == null)
        {
            return null;
        }
        if (a != null) goto _L2; else goto _L1
_L1:
        com/baidu/frontia/api/FrontiaPush;
        JVM INSTR monitorenter ;
        if (a == null)
        {
            a = new FrontiaPush(context);
        }
        com/baidu/frontia/api/FrontiaPush;
        JVM INSTR monitorexit ;
_L2:
        return a;
        context;
        com/baidu/frontia/api/FrontiaPush;
        JVM INSTR monitorexit ;
        throw context;
    }

    FrontiaPushImpl a()
    {
        return b;
    }

    public void deleteTags(List list)
    {
        b.deleteTags(list);
    }

    public void describeMessage(String s, FrontiaPushListener.DescribeMessageListener describemessagelistener)
    {
        describemessagelistener = new b(describemessagelistener);
        b.describeMessage(s, describemessagelistener.a());
    }

    public void disableLbs()
    {
        b.disableLbs();
    }

    public void enableLbs()
    {
        b.enableLbs();
    }

    public void init(String s)
    {
        b.init(s);
    }

    public boolean isPushWorking()
    {
        return PushManager.isPushEnabled(c);
    }

    public void listMessage(FrontiaQuery frontiaquery, FrontiaPushListener.ListMessageListener listmessagelistener)
    {
        listmessagelistener = new c(listmessagelistener);
        b.listMessage(frontiaquery.toJSONObject(), listmessagelistener.a());
    }

    public void listTags()
    {
        b.listTags();
    }

    public void pushMessage(FrontiaPushUtil.MessageContent messagecontent, FrontiaPushListener.PushMessageListener pushmessagelistener)
    {
        pushmessagelistener = new d(pushmessagelistener);
        b.pushMessage(messagecontent.a(), pushmessagelistener.a());
    }

    public void pushMessage(FrontiaPushUtil.Trigger trigger, FrontiaPushUtil.MessageContent messagecontent, FrontiaPushListener.PushMessageListener pushmessagelistener)
    {
        pushmessagelistener = new d(pushmessagelistener);
        b.pushMessage(trigger.a(), messagecontent.a(), pushmessagelistener.a());
    }

    public void pushMessage(String s, FrontiaPushUtil.MessageContent messagecontent, FrontiaPushListener.PushMessageListener pushmessagelistener)
    {
        pushmessagelistener = new d(pushmessagelistener);
        b.pushMessage(s, messagecontent.a(), pushmessagelistener.a());
    }

    public void pushMessage(String s, FrontiaPushUtil.Trigger trigger, FrontiaPushUtil.MessageContent messagecontent, FrontiaPushListener.PushMessageListener pushmessagelistener)
    {
        pushmessagelistener = new d(pushmessagelistener);
        b.pushMessage(s, trigger.a(), messagecontent.a(), pushmessagelistener.a());
    }

    public void pushMessage(String s, String s1, FrontiaPushUtil.MessageContent messagecontent, FrontiaPushListener.PushMessageListener pushmessagelistener)
    {
        pushmessagelistener = new d(pushmessagelistener);
        b.pushMessage(s, s1, messagecontent.a(), pushmessagelistener.a());
    }

    public void pushMessage(String s, String s1, FrontiaPushUtil.Trigger trigger, FrontiaPushUtil.MessageContent messagecontent, FrontiaPushListener.PushMessageListener pushmessagelistener)
    {
        pushmessagelistener = new d(pushmessagelistener);
        b.pushMessage(s, s1, trigger.a(), messagecontent.a(), pushmessagelistener.a());
    }

    public void removeMessage(String s, FrontiaPushListener.CommonMessageListener commonmessagelistener)
    {
        commonmessagelistener = new a(commonmessagelistener);
        b.removeMessage(s, commonmessagelistener.a());
    }

    public void replaceMessage(String s, FrontiaPushUtil.Trigger trigger, FrontiaPushUtil.MessageContent messagecontent, FrontiaPushListener.CommonMessageListener commonmessagelistener)
    {
        commonmessagelistener = new a(commonmessagelistener);
        b.replaceMessage(s, trigger.a(), messagecontent.a(), commonmessagelistener.a());
    }

    public void replaceMessage(String s, String s1, FrontiaPushUtil.Trigger trigger, FrontiaPushUtil.MessageContent messagecontent, FrontiaPushListener.CommonMessageListener commonmessagelistener)
    {
        commonmessagelistener = new a(commonmessagelistener);
        b.replaceMessage(s, s1, trigger.a(), messagecontent.a(), commonmessagelistener.a());
    }

    public void replaceMessage(String s, String s1, String s2, FrontiaPushUtil.Trigger trigger, FrontiaPushUtil.MessageContent messagecontent, FrontiaPushListener.CommonMessageListener commonmessagelistener)
    {
        commonmessagelistener = new a(commonmessagelistener);
        b.replaceMessage(s, s1, s2, trigger.a(), messagecontent.a(), commonmessagelistener.a());
    }

    public void resume()
    {
        PushManager.resumeWork(c);
    }

    public void setDebugModeEnabled(boolean flag)
    {
        PushSettings.enableDebugMode(c, flag);
    }

    public void setNotificationBuilder(int i, FrontiaPushUtil.a a1)
    {
        if (a1 != null)
        {
            PushManager.setNotificationBuilder(c, i, a1.a());
        }
    }

    public void setTags(List list)
    {
        b.setTags(list);
    }

    public void start()
    {
        b.start();
    }

    public void start(String s)
    {
        b.start(s);
    }

    public void stop()
    {
        PushManager.stopWork(c);
        StatUtils.insertBehavior(c, "010702", 0, "", "", System.currentTimeMillis());
    }


    private class b
    {

        com.baidu.frontia.module.push.FrontiaPushListenerImpl.DescribeMessageListenerImpl a;
        final FrontiaPush b;
        private FrontiaPushListener.DescribeMessageListener c;

        static FrontiaPushListener.DescribeMessageListener a(b b1)
        {
            return b1.c;
        }

        com.baidu.frontia.module.push.FrontiaPushListenerImpl.DescribeMessageListenerImpl a()
        {
            return a;
        }

        b(FrontiaPushListener.DescribeMessageListener describemessagelistener)
        {
            b = FrontiaPush.this;
            super();
            a = new com.baidu.frontia.module.push.FrontiaPushListenerImpl.DescribeMessageListenerImpl() {

                final b a;

                public void onFailure(int i, String s)
                {
                    if (b.a(a) != null)
                    {
                        b.a(a).onFailure(i, s);
                    }
                }

                public void onSuccess(com.baidu.frontia.module.push.FrontiaPushListenerImpl.DescribeMessageResult describemessageresult)
                {
                    if (b.a(a) != null)
                    {
                        b.a(a).onSuccess(new FrontiaPushListener.DescribeMessageResult(describemessageresult));
                    }
                }

                
                {
                    a = b.this;
                    super();
                }
            };
            c = describemessagelistener;
        }
    }


    private class c
    {

        com.baidu.frontia.module.push.FrontiaPushListenerImpl.ListMessageListenerImpl a;
        final FrontiaPush b;
        private FrontiaPushListener.ListMessageListener c;

        static FrontiaPushListener.ListMessageListener a(c c1)
        {
            return c1.c;
        }

        com.baidu.frontia.module.push.FrontiaPushListenerImpl.ListMessageListenerImpl a()
        {
            return a;
        }

        c(FrontiaPushListener.ListMessageListener listmessagelistener)
        {
            b = FrontiaPush.this;
            super();
            a = new com.baidu.frontia.module.push.FrontiaPushListenerImpl.ListMessageListenerImpl() {

                final c a;

                public void onFailure(int i, String s)
                {
                    if (c.a(a) != null)
                    {
                        c.a(a).onFailure(i, s);
                    }
                }

                public void onSuccess(List list)
                {
                    if (c.a(a) != null)
                    {
                        ArrayList arraylist = new ArrayList();
                        for (int i = 0; i < list.size(); i++)
                        {
                            arraylist.add(new FrontiaPushListener.DescribeMessageResult((com.baidu.frontia.module.push.FrontiaPushListenerImpl.DescribeMessageResult)list.get(i)));
                        }

                        c.a(a).onSuccess(arraylist);
                    }
                }

                
                {
                    a = c.this;
                    super();
                }
            };
            c = listmessagelistener;
        }
    }


    private class d
    {

        com.baidu.frontia.module.push.FrontiaPushListenerImpl.PushMessageListenerImpl a;
        final FrontiaPush b;
        private FrontiaPushListener.PushMessageListener c;

        static FrontiaPushListener.PushMessageListener a(d d1)
        {
            return d1.c;
        }

        com.baidu.frontia.module.push.FrontiaPushListenerImpl.PushMessageListenerImpl a()
        {
            return a;
        }

        d(FrontiaPushListener.PushMessageListener pushmessagelistener)
        {
            b = FrontiaPush.this;
            super();
            a = new com.baidu.frontia.module.push.FrontiaPushListenerImpl.PushMessageListenerImpl() {

                final d a;

                public void onFailure(int i, String s)
                {
                    if (d.a(a) != null)
                    {
                        d.a(a).onFailure(i, s);
                    }
                }

                public void onSuccess(String s)
                {
                    if (d.a(a) != null)
                    {
                        d.a(a).onSuccess(s);
                    }
                }

                
                {
                    a = d.this;
                    super();
                }
            };
            c = pushmessagelistener;
        }
    }


    private class a
    {

        com.baidu.frontia.module.push.FrontiaPushListenerImpl.CommonMessageListenerImpl a;
        final FrontiaPush b;
        private FrontiaPushListener.CommonMessageListener c;

        static FrontiaPushListener.CommonMessageListener a(a a1)
        {
            return a1.c;
        }

        com.baidu.frontia.module.push.FrontiaPushListenerImpl.CommonMessageListenerImpl a()
        {
            return a;
        }

        a(FrontiaPushListener.CommonMessageListener commonmessagelistener)
        {
            b = FrontiaPush.this;
            super();
            a = new com.baidu.frontia.module.push.FrontiaPushListenerImpl.CommonMessageListenerImpl() {

                final a a;

                public void onFailure(int i, String s)
                {
                    if (a.a(a) != null)
                    {
                        a.a(a).onFailure(i, s);
                    }
                }

                public void onSuccess()
                {
                    if (a.a(a) != null)
                    {
                        a.a(a).onSuccess();
                    }
                }

                
                {
                    a = a.this;
                    super();
                }
            };
            c = commonmessagelistener;
        }
    }

}
