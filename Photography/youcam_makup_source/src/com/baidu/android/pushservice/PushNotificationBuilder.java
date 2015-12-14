// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.baidu.android.pushservice;

import android.app.Notification;
import android.content.Context;
import android.net.Uri;
import com.baidu.android.pushservice.apiproxy.BridgePushNotificationBuilder;

// Referenced classes of package com.baidu.android.pushservice:
//            LoadExecutor

public abstract class PushNotificationBuilder
{

    private boolean a;
    protected BridgePushNotificationBuilder mInstance;

    public PushNotificationBuilder(Context context)
    {
        a = false;
        mInstance = null;
        (new Thread(context) {

            final PushNotificationBuilder a;
            private final Context b;

            public void run()
            {
                PushNotificationBuilder pushnotificationbuilder = a;
                boolean flag;
                if (LoadExecutor.loadPush(b))
                {
                    flag = false;
                } else
                {
                    flag = true;
                }
                PushNotificationBuilder.a(pushnotificationbuilder, flag);
            }

            
            {
                a = PushNotificationBuilder.this;
                b = context;
                super();
            }
        }).start();
    }

    public PushNotificationBuilder(Context context, BridgePushNotificationBuilder bridgepushnotificationbuilder)
    {
        a = false;
        mInstance = null;
        mInstance = bridgepushnotificationbuilder;
    }

    private void a(int i)
    {
        long l = i;
        try
        {
            Thread.sleep(l);
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }

    static void a(PushNotificationBuilder pushnotificationbuilder, int i)
    {
        pushnotificationbuilder.a(i);
    }

    static void a(PushNotificationBuilder pushnotificationbuilder, boolean flag)
    {
        pushnotificationbuilder.a = flag;
    }

    static boolean a(PushNotificationBuilder pushnotificationbuilder)
    {
        return pushnotificationbuilder.a;
    }

    public abstract Notification construct(Context context);

    public BridgePushNotificationBuilder getInner()
    {
        return mInstance;
    }

    public void setNotificationDefaults(int i)
    {
        (new Thread(i) {

            final PushNotificationBuilder a;
            private final int b;

            public void run()
            {
                do
                {
                    if (a.mInstance != null || PushNotificationBuilder.a(a))
                    {
                        if (PushNotificationBuilder.a(a))
                        {
                            return;
                        } else
                        {
                            a.mInstance.setNotificationDefaults(b);
                            return;
                        }
                    }
                    PushNotificationBuilder.a(a, 50);
                } while (true);
            }

            
            {
                a = PushNotificationBuilder.this;
                b = i;
                super();
            }
        }).start();
    }

    public void setNotificationFlags(int i)
    {
        (new Thread(i) {

            final PushNotificationBuilder a;
            private final int b;

            public void run()
            {
                do
                {
                    if (a.mInstance != null || PushNotificationBuilder.a(a))
                    {
                        if (PushNotificationBuilder.a(a))
                        {
                            return;
                        } else
                        {
                            a.mInstance.setNotificationFlags(b);
                            return;
                        }
                    }
                    PushNotificationBuilder.a(a, 50);
                } while (true);
            }

            
            {
                a = PushNotificationBuilder.this;
                b = i;
                super();
            }
        }).start();
    }

    public void setNotificationSound(Uri uri)
    {
        (new Thread(uri) {

            final PushNotificationBuilder a;
            private final Uri b;

            public void run()
            {
                do
                {
                    if (a.mInstance != null || PushNotificationBuilder.a(a))
                    {
                        if (PushNotificationBuilder.a(a))
                        {
                            return;
                        } else
                        {
                            a.mInstance.setNotificationSound(b);
                            return;
                        }
                    }
                    PushNotificationBuilder.a(a, 50);
                } while (true);
            }

            
            {
                a = PushNotificationBuilder.this;
                b = uri;
                super();
            }
        }).start();
    }

    public void setNotificationText(String s)
    {
        (new Thread(s) {

            final PushNotificationBuilder a;
            private final String b;

            public void run()
            {
                do
                {
                    if (a.mInstance != null || PushNotificationBuilder.a(a))
                    {
                        if (PushNotificationBuilder.a(a))
                        {
                            return;
                        } else
                        {
                            a.mInstance.setNotificationText(b);
                            return;
                        }
                    }
                    PushNotificationBuilder.a(a, 50);
                } while (true);
            }

            
            {
                a = PushNotificationBuilder.this;
                b = s;
                super();
            }
        }).start();
    }

    public void setNotificationTitle(String s)
    {
        (new Thread(s) {

            final PushNotificationBuilder a;
            private final String b;

            public void run()
            {
                do
                {
                    if (a.mInstance != null || PushNotificationBuilder.a(a))
                    {
                        if (PushNotificationBuilder.a(a))
                        {
                            return;
                        } else
                        {
                            a.mInstance.setNotificationTitle(b);
                            return;
                        }
                    }
                    PushNotificationBuilder.a(a, 50);
                } while (true);
            }

            
            {
                a = PushNotificationBuilder.this;
                b = s;
                super();
            }
        }).start();
    }

    public void setNotificationVibrate(long al[])
    {
        (new Thread(al) {

            final PushNotificationBuilder a;
            private final long b[];

            public void run()
            {
                do
                {
                    if (a.mInstance != null || PushNotificationBuilder.a(a))
                    {
                        if (PushNotificationBuilder.a(a))
                        {
                            return;
                        } else
                        {
                            a.mInstance.setNotificationVibrate(b);
                            return;
                        }
                    }
                    PushNotificationBuilder.a(a, 50);
                } while (true);
            }

            
            {
                a = PushNotificationBuilder.this;
                b = al;
                super();
            }
        }).start();
    }

    public void setStatusbarIcon(int i)
    {
        (new Thread(i) {

            final PushNotificationBuilder a;
            private final int b;

            public void run()
            {
                do
                {
                    if (a.mInstance != null || PushNotificationBuilder.a(a))
                    {
                        if (PushNotificationBuilder.a(a))
                        {
                            return;
                        } else
                        {
                            a.mInstance.setStatusbarIcon(b);
                            return;
                        }
                    }
                    PushNotificationBuilder.a(a, 50);
                } while (true);
            }

            
            {
                a = PushNotificationBuilder.this;
                b = i;
                super();
            }
        }).start();
    }
}
