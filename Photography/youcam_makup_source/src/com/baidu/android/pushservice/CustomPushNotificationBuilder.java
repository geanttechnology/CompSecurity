// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.baidu.android.pushservice;

import android.app.Notification;
import android.content.Context;
import android.net.Uri;
import com.baidu.android.pushservice.apiproxy.BridgeCustomPushNotificationBuilder;
import com.baidu.android.pushservice.apiproxy.BridgePushNotificationBuilder;

// Referenced classes of package com.baidu.android.pushservice:
//            PushNotificationBuilder, LoadExecutor

public class CustomPushNotificationBuilder extends PushNotificationBuilder
{

    private boolean a;

    public CustomPushNotificationBuilder(Context context, int i, int j, int k, int l)
    {
        super(context);
        a = false;
        if (LoadExecutor.isPushLibLoaded(context))
        {
            mInstance = new BridgeCustomPushNotificationBuilder(i, j, k, l);
            return;
        } else
        {
            (new Thread(context, i, j, k, l) {

                final CustomPushNotificationBuilder a;
                private final Context b;
                private final int c;
                private final int d;
                private final int e;
                private final int f;

                public void run()
                {
                    if (!LoadExecutor.loadPush(b))
                    {
                        CustomPushNotificationBuilder.a(a, true);
                        return;
                    } else
                    {
                        a.mInstance = new BridgeCustomPushNotificationBuilder(c, d, e, f);
                        return;
                    }
                }

            
            {
                a = CustomPushNotificationBuilder.this;
                b = context;
                c = i;
                d = j;
                e = k;
                f = l;
                super();
            }
            }).start();
            return;
        }
    }

    public CustomPushNotificationBuilder(Context context, BridgeCustomPushNotificationBuilder bridgecustompushnotificationbuilder)
    {
        super(context);
        a = false;
        mInstance = bridgecustompushnotificationbuilder;
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

    static void a(CustomPushNotificationBuilder custompushnotificationbuilder, int i)
    {
        custompushnotificationbuilder.a(i);
    }

    static void a(CustomPushNotificationBuilder custompushnotificationbuilder, boolean flag)
    {
        custompushnotificationbuilder.a = flag;
    }

    static boolean a(CustomPushNotificationBuilder custompushnotificationbuilder)
    {
        return custompushnotificationbuilder.a;
    }

    public Notification construct(Context context)
    {
        if (!LoadExecutor.loadPush(context))
        {
            return null;
        } else
        {
            return mInstance.construct(context);
        }
    }

    public BridgeCustomPushNotificationBuilder getInner()
    {
        do
        {
            if (mInstance != null || a)
            {
                if (a)
                {
                    return null;
                } else
                {
                    return (BridgeCustomPushNotificationBuilder)mInstance;
                }
            }
            a(50);
        } while (true);
    }

    public volatile BridgePushNotificationBuilder getInner()
    {
        return getInner();
    }

    public void setLayoutDrawable(int i)
    {
        if (mInstance != null)
        {
            ((BridgeCustomPushNotificationBuilder)mInstance).setLayoutDrawable(i);
            return;
        } else
        {
            (new Thread(i) {

                final CustomPushNotificationBuilder a;
                private final int b;

                public void run()
                {
                    do
                    {
                        if (a.mInstance != null || CustomPushNotificationBuilder.a(a))
                        {
                            if (CustomPushNotificationBuilder.a(a))
                            {
                                return;
                            } else
                            {
                                ((BridgeCustomPushNotificationBuilder)a.mInstance).setLayoutDrawable(b);
                                return;
                            }
                        }
                        CustomPushNotificationBuilder.a(a, 50);
                    } while (true);
                }

            
            {
                a = CustomPushNotificationBuilder.this;
                b = i;
                super();
            }
            }).start();
            return;
        }
    }

    public void setNotificationDefaults(int i)
    {
        if (mInstance != null)
        {
            mInstance.setNotificationDefaults(i);
            return;
        } else
        {
            (new Thread(i) {

                final CustomPushNotificationBuilder a;
                private final int b;

                public void run()
                {
                    do
                    {
                        if (a.mInstance != null || CustomPushNotificationBuilder.a(a))
                        {
                            if (CustomPushNotificationBuilder.a(a))
                            {
                                return;
                            } else
                            {
                                a.mInstance.setNotificationDefaults(b);
                                return;
                            }
                        }
                        CustomPushNotificationBuilder.a(a, 50);
                    } while (true);
                }

            
            {
                a = CustomPushNotificationBuilder.this;
                b = i;
                super();
            }
            }).start();
            return;
        }
    }

    public void setNotificationFlags(int i)
    {
        if (mInstance != null)
        {
            mInstance.setNotificationFlags(i);
            return;
        } else
        {
            (new Thread(i) {

                final CustomPushNotificationBuilder a;
                private final int b;

                public void run()
                {
                    do
                    {
                        if (a.mInstance != null || CustomPushNotificationBuilder.a(a))
                        {
                            if (CustomPushNotificationBuilder.a(a))
                            {
                                return;
                            } else
                            {
                                a.mInstance.setNotificationFlags(b);
                                return;
                            }
                        }
                        CustomPushNotificationBuilder.a(a, 50);
                    } while (true);
                }

            
            {
                a = CustomPushNotificationBuilder.this;
                b = i;
                super();
            }
            }).start();
            return;
        }
    }

    public void setNotificationSound(Uri uri)
    {
        if (mInstance != null)
        {
            mInstance.setNotificationSound(uri);
            return;
        } else
        {
            (new Thread(uri) {

                final CustomPushNotificationBuilder a;
                private final Uri b;

                public void run()
                {
                    do
                    {
                        if (a.mInstance != null || CustomPushNotificationBuilder.a(a))
                        {
                            if (CustomPushNotificationBuilder.a(a))
                            {
                                return;
                            } else
                            {
                                a.mInstance.setNotificationSound(b);
                                return;
                            }
                        }
                        CustomPushNotificationBuilder.a(a, 50);
                    } while (true);
                }

            
            {
                a = CustomPushNotificationBuilder.this;
                b = uri;
                super();
            }
            }).start();
            return;
        }
    }

    public void setNotificationText(String s)
    {
        if (mInstance != null)
        {
            mInstance.setNotificationText(s);
            return;
        } else
        {
            (new Thread(s) {

                final CustomPushNotificationBuilder a;
                private final String b;

                public void run()
                {
                    do
                    {
                        if (a.mInstance != null || CustomPushNotificationBuilder.a(a))
                        {
                            if (CustomPushNotificationBuilder.a(a))
                            {
                                return;
                            } else
                            {
                                a.mInstance.setNotificationText(b);
                                return;
                            }
                        }
                        CustomPushNotificationBuilder.a(a, 50);
                    } while (true);
                }

            
            {
                a = CustomPushNotificationBuilder.this;
                b = s;
                super();
            }
            }).start();
            return;
        }
    }

    public void setNotificationTitle(String s)
    {
        if (mInstance != null)
        {
            mInstance.setNotificationTitle(s);
            return;
        } else
        {
            (new Thread(s) {

                final CustomPushNotificationBuilder a;
                private final String b;

                public void run()
                {
                    do
                    {
                        if (a.mInstance != null || CustomPushNotificationBuilder.a(a))
                        {
                            if (CustomPushNotificationBuilder.a(a))
                            {
                                return;
                            } else
                            {
                                a.mInstance.setNotificationTitle(b);
                                return;
                            }
                        }
                        CustomPushNotificationBuilder.a(a, 50);
                    } while (true);
                }

            
            {
                a = CustomPushNotificationBuilder.this;
                b = s;
                super();
            }
            }).start();
            return;
        }
    }

    public void setNotificationVibrate(long al[])
    {
        if (mInstance != null)
        {
            mInstance.setNotificationVibrate(al);
            return;
        } else
        {
            (new Thread(al) {

                final CustomPushNotificationBuilder a;
                private final long b[];

                public void run()
                {
                    do
                    {
                        if (a.mInstance != null || CustomPushNotificationBuilder.a(a))
                        {
                            if (CustomPushNotificationBuilder.a(a))
                            {
                                return;
                            } else
                            {
                                a.mInstance.setNotificationVibrate(b);
                                return;
                            }
                        }
                        CustomPushNotificationBuilder.a(a, 50);
                    } while (true);
                }

            
            {
                a = CustomPushNotificationBuilder.this;
                b = al;
                super();
            }
            }).start();
            return;
        }
    }

    public void setStatusbarIcon(int i)
    {
        if (mInstance != null)
        {
            mInstance.setStatusbarIcon(i);
            return;
        } else
        {
            (new Thread(i) {

                final CustomPushNotificationBuilder a;
                private final int b;

                public void run()
                {
                    do
                    {
                        if (a.mInstance != null || CustomPushNotificationBuilder.a(a))
                        {
                            if (CustomPushNotificationBuilder.a(a))
                            {
                                return;
                            } else
                            {
                                a.mInstance.setStatusbarIcon(b);
                                return;
                            }
                        }
                        CustomPushNotificationBuilder.a(a, 50);
                    } while (true);
                }

            
            {
                a = CustomPushNotificationBuilder.this;
                b = i;
                super();
            }
            }).start();
            return;
        }
    }
}
