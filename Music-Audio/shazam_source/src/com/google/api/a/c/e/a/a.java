// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.api.a.c.e.a;

import com.google.api.a.c.e.d;
import com.google.api.a.d.r;
import com.google.api.a.d.v;
import com.google.api.a.e.c;
import com.google.api.a.e.e;
import com.google.api.a.g.u;
import java.util.Arrays;
import java.util.Collections;

public abstract class com.google.api.a.c.e.a.a extends com.google.api.a.c.e.a
{
    public static abstract class a extends com.google.api.a.c.e.a
    {

        public abstract com.google.api.a.c.e.a.a build();

        public volatile com.google.api.a.c.e.a build()
        {
            return build();
        }

        public final c getJsonFactory()
        {
            return getObjectParser().a;
        }

        public final e getObjectParser()
        {
            return (e)super.getObjectParser();
        }

        public volatile u getObjectParser()
        {
            return getObjectParser();
        }

        public volatile com.google.api.a.c.e.a setApplicationName(String s)
        {
            return setApplicationName(s);
        }

        public a setApplicationName(String s)
        {
            return (a)super.setApplicationName(s);
        }

        public volatile com.google.api.a.c.e.a setGoogleClientRequestInitializer(d d)
        {
            return setGoogleClientRequestInitializer(d);
        }

        public a setGoogleClientRequestInitializer(d d)
        {
            return (a)super.setGoogleClientRequestInitializer(d);
        }

        public volatile com.google.api.a.c.e.a setHttpRequestInitializer(r r)
        {
            return setHttpRequestInitializer(r);
        }

        public a setHttpRequestInitializer(r r)
        {
            return (a)super.setHttpRequestInitializer(r);
        }

        public volatile com.google.api.a.c.e.a setRootUrl(String s)
        {
            return setRootUrl(s);
        }

        public a setRootUrl(String s)
        {
            return (a)super.setRootUrl(s);
        }

        public volatile com.google.api.a.c.e.a setServicePath(String s)
        {
            return setServicePath(s);
        }

        public a setServicePath(String s)
        {
            return (a)super.setServicePath(s);
        }

        public volatile com.google.api.a.c.e.a setSuppressAllChecks(boolean flag)
        {
            return setSuppressAllChecks(flag);
        }

        public a setSuppressAllChecks(boolean flag)
        {
            return (a)super.setSuppressAllChecks(flag);
        }

        public volatile com.google.api.a.c.e.a setSuppressPatternChecks(boolean flag)
        {
            return setSuppressPatternChecks(flag);
        }

        public a setSuppressPatternChecks(boolean flag)
        {
            return (a)super.setSuppressPatternChecks(flag);
        }

        public volatile com.google.api.a.c.e.a setSuppressRequiredParameterChecks(boolean flag)
        {
            return setSuppressRequiredParameterChecks(flag);
        }

        public a setSuppressRequiredParameterChecks(boolean flag)
        {
            return (a)super.setSuppressRequiredParameterChecks(flag);
        }

        public a(v v, c c, String s, String s1, r r, boolean flag)
        {
            com.google.api.a.e.e.a a1 = new com.google.api.a.e.e.a(c);
            if (flag)
            {
                c = Arrays.asList(new String[] {
                    "data", "error"
                });
            } else
            {
                c = Collections.emptySet();
            }
            a1.b = c;
            super(v, s, s1, a1.a(), r);
        }
    }


    public com.google.api.a.c.e.a.a(a a1)
    {
        super(a1);
    }

    public final c getJsonFactory()
    {
        return getObjectParser().a;
    }

    public e getObjectParser()
    {
        return (e)super.getObjectParser();
    }

    public volatile u getObjectParser()
    {
        return getObjectParser();
    }
}
