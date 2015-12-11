// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model;

import java.io.Serializable;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;

public final class MerlinId
    implements Serializable
{
    public static final class Namespace extends Enum
    {

        private static final Namespace $VALUES[];
        public static final Namespace Movie;
        public static final Namespace TvEpisode;
        public static final Namespace TvSeries;

        public static Namespace valueOf(String s)
        {
            return (Namespace)Enum.valueOf(com/xfinity/playerlib/model/MerlinId$Namespace, s);
        }

        public static Namespace[] values()
        {
            return (Namespace[])$VALUES.clone();
        }

        public String getBundleKey()
        {
            return (new StringBuilder()).append("EXTRA_MERLIN_ID_").append(name()).toString();
        }

        static 
        {
            Movie = new Namespace("Movie", 0);
            TvSeries = new Namespace("TvSeries", 1);
            TvEpisode = new Namespace("TvEpisode", 2);
            $VALUES = (new Namespace[] {
                Movie, TvSeries, TvEpisode
            });
        }

        private Namespace(String s, int i)
        {
            super(s, i);
        }
    }


    private final Namespace namespace;
    private final long simpleId;

    public MerlinId(Namespace namespace1, Long long1)
    {
        Validate.notNull(namespace1);
        namespace = namespace1;
        simpleId = long1.longValue();
    }

    public MerlinId(String s)
    {
        Validate.notNull(s);
        s = StringUtils.split(s, "-");
        if (s.length != 2)
        {
            throw new IllegalArgumentException("ID should be in the form namespace-longID (f.e. TvSeries-12345)");
        } else
        {
            namespace = Namespace.valueOf(s[0]);
            simpleId = Long.parseLong(s[1]);
            return;
        }
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (obj == null || getClass() != obj.getClass())
            {
                return false;
            }
            obj = (MerlinId)obj;
            if (simpleId != ((MerlinId) (obj)).simpleId || namespace != ((MerlinId) (obj)).namespace)
            {
                return false;
            }
        }
        return true;
    }

    public String getAsLegacyBobid()
    {
        return getNamespacedId();
    }

    public Namespace getNamespace()
    {
        return namespace;
    }

    public String getNamespacedId()
    {
        return (new StringBuilder()).append(namespace.toString()).append("-").append(simpleId).toString();
    }

    public Long getSimpleId()
    {
        return Long.valueOf(simpleId);
    }

    public int hashCode()
    {
        return namespace.hashCode() * 31 + (int)simpleId;
    }

    public String toString()
    {
        return getNamespacedId();
    }
}
