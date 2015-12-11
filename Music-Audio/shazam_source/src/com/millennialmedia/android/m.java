// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.Callable;

// Referenced classes of package com.millennialmedia.android:
//            ai, aj, ao, ak, 
//            y, an, al

final class m extends ai
{

    m()
    {
    }

    final aj a(String s, Map map)
    {
        Object obj = null;
        if ("adjustVideo".equals(s))
        {
            map = a(new Callable(map) {

                final Map a;
                final m b;

                public final Object call()
                {
                    ao ao1 = (ao)b.c.get();
                    if (ao1 != null && ao1 != null)
                    {
                        an.a(new ak._cls3(ao1.f(), new y.a(a, ao1.getContext())));
                    }
                    return aj.b("An unknown error occured.");
                }

            
            {
                b = m.this;
                a = map;
                super();
            }
            });
        } else
        {
            if ("insertVideo".equals(s))
            {
                return a(new Callable(map) {

                    final Map a;
                    final m b;

                    public final Object call()
                    {
                        Object obj2 = (ao)b.c.get();
                        if (obj2 == null) goto _L2; else goto _L1
_L1:
                        Object obj1;
                        obj1 = ((ao) (obj2)).f();
                        ((ak) (obj1)).a(new y.a(a, ((ao) (obj2)).getContext()));
                        obj2 = new StringBuilder("usingStreaming=");
                        if (((ak) (obj1)).l == null) goto _L4; else goto _L3
_L3:
                        boolean flag1;
                        obj1 = ((ak) (obj1)).l;
                        boolean flag;
                        if (((y) (obj1)).a != null && ((y) (obj1)).f)
                        {
                            flag = true;
                        } else
                        {
                            flag = false;
                        }
                        if (!flag) goto _L4; else goto _L5
_L5:
                        flag1 = true;
_L6:
                        return aj.a(((StringBuilder) (obj2)).append(flag1).toString());
_L4:
                        flag1 = false;
                        if (true) goto _L6; else goto _L2
_L2:
                        return aj.b("An unknown error occured.");
                    }

            
            {
                b = m.this;
                a = map;
                super();
            }
                });
            }
            if ("pauseVideo".equals(s))
            {
                return a(new Callable() {

                    final m a;

                    public final Object call()
                    {
                        Object obj1 = (ao)a.c.get();
                        if (obj1 != null)
                        {
                            obj1 = ((ao) (obj1)).f();
                            if (obj1 != null)
                            {
                                if (((ak) (obj1)).l != null)
                                {
                                    ((ak) (obj1)).l.pause();
                                }
                                return aj.a("Success.");
                            }
                        }
                        return aj.b("An unknown error occured.");
                    }

            
            {
                a = m.this;
                super();
            }
                });
            }
            if ("playVideo".equals(s))
            {
                return a(new Callable() {

                    final m a;

                    public final Object call()
                    {
                        Object obj1 = (ao)a.c.get();
                        if (obj1 != null)
                        {
                            obj1 = ((ao) (obj1)).f();
                            if (obj1 != null)
                            {
                                if (((ak) (obj1)).l != null)
                                {
                                    ((ak) (obj1)).l.start();
                                }
                                return aj.a("Success.");
                            }
                        }
                        return aj.b("An unknown error occured.");
                    }

            
            {
                a = m.this;
                super();
            }
                });
            }
            if ("removeVideo".equals(s))
            {
                return a(new Callable() {

                    final m a;

                    public final Object call()
                    {
                        Object obj1 = (ao)a.c.get();
                        if (obj1 != null)
                        {
                            obj1 = ((ao) (obj1)).f();
                            if (obj1 != null)
                            {
                                ((ak) (obj1)).d();
                                return aj.a("Success.");
                            }
                        }
                        return aj.b("An unknown error occured.");
                    }

            
            {
                a = m.this;
                super();
            }
                });
            }
            if ("resumeVideo".equals(s))
            {
                return a(new Callable() {

                    final m a;

                    public final Object call()
                    {
                        Object obj1 = (ao)a.c.get();
                        if (obj1 != null)
                        {
                            obj1 = ((ao) (obj1)).f();
                            if (obj1 != null)
                            {
                                if (((ak) (obj1)).l != null)
                                {
                                    obj1 = ((ak) (obj1)).l;
                                    if (((y) (obj1)).a.p != y.a.a.d)
                                    {
                                        al.d();
                                    } else
                                    {
                                        ((y) (obj1)).start();
                                    }
                                }
                                return aj.a("Success.");
                            }
                        }
                        return aj.b("An unknown error occured.");
                    }

            
            {
                a = m.this;
                super();
            }
                });
            }
            if ("setStreamVideoSource".equals(s))
            {
                return a(new Callable(map) {

                    final Map a;
                    final m b;

                    public final Object call()
                    {
                        Object obj1 = (ao)b.c.get();
                        if (obj1 != null)
                        {
                            obj1 = ((ao) (obj1)).f();
                            String s1 = (String)a.get("streamVideoURI");
                            if (obj1 != null && s1 != null)
                            {
                                ((ak) (obj1)).setVideoSource(s1);
                                return aj.a("Success.");
                            }
                        }
                        return aj.b("An unknown error occured.");
                    }

            
            {
                b = m.this;
                a = map;
                super();
            }
                });
            }
            map = obj;
            if ("stopVideo".equals(s))
            {
                return a(new Callable() {

                    final m a;

                    public final Object call()
                    {
                        Object obj1 = (ao)a.c.get();
                        if (obj1 != null)
                        {
                            obj1 = ((ao) (obj1)).f();
                            if (obj1 != null)
                            {
                                if (((ak) (obj1)).l != null)
                                {
                                    ((ak) (obj1)).l.stopPlayback();
                                }
                                return aj.a("Success.");
                            }
                        }
                        return aj.b("An unknown error occured.");
                    }

            
            {
                a = m.this;
                super();
            }
                });
            }
        }
        return map;
    }
}
