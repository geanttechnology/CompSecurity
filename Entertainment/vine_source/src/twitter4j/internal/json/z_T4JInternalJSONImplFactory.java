// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package twitter4j.internal.json;

import twitter4j.conf.Configuration;

// Referenced classes of package twitter4j.internal.json:
//            z_T4JInternalFactory

public class z_T4JInternalJSONImplFactory
    implements z_T4JInternalFactory
{

    private static final long serialVersionUID = 0x4868b7d54ca3e042L;
    private Configuration conf;

    public z_T4JInternalJSONImplFactory(Configuration configuration)
    {
        conf = configuration;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (!(obj instanceof z_T4JInternalJSONImplFactory))
            {
                return false;
            }
            obj = (z_T4JInternalJSONImplFactory)obj;
            if (conf == null ? ((z_T4JInternalJSONImplFactory) (obj)).conf != null : !conf.equals(((z_T4JInternalJSONImplFactory) (obj)).conf))
            {
                return false;
            }
        }
        return true;
    }

    public int hashCode()
    {
        if (conf != null)
        {
            return conf.hashCode();
        } else
        {
            return 0;
        }
    }

    public String toString()
    {
        return (new StringBuilder()).append("JSONImplFactory{conf=").append(conf).append('}').toString();
    }
}
