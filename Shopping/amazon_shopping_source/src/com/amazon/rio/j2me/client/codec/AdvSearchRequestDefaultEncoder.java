// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.codec;

import com.amazon.rio.j2me.client.services.mShop.AdvSearchRequest;
import java.io.DataOutputStream;
import java.io.IOException;

// Referenced classes of package com.amazon.rio.j2me.client.codec:
//            Encoder, DefaultEncoder

public class AdvSearchRequestDefaultEncoder
    implements Encoder
{

    public AdvSearchRequestDefaultEncoder()
    {
    }

    public void encode(AdvSearchRequest advsearchrequest, DataOutputStream dataoutputstream)
        throws IOException
    {
        boolean flag;
        if (advsearchrequest.getQuery() == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        dataoutputstream.writeBoolean(flag);
        if (!flag)
        {
            DefaultEncoder.getStringInstance().encode(advsearchrequest.getQuery(), dataoutputstream);
        }
        if (advsearchrequest.getOffset() == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        dataoutputstream.writeBoolean(flag);
        if (!flag)
        {
            DefaultEncoder.getIntegerInstance(0xffffffff80000000L, 0x7fffffffL).encode(advsearchrequest.getOffset(), dataoutputstream);
        }
        if (advsearchrequest.getCount() == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        dataoutputstream.writeBoolean(flag);
        if (!flag)
        {
            DefaultEncoder.getIntegerInstance(0xffffffff80000000L, 0x7fffffffL).encode(advsearchrequest.getCount(), dataoutputstream);
        }
        if (advsearchrequest.getFilters() == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        dataoutputstream.writeBoolean(flag);
        if (!flag)
        {
            DefaultEncoder.getStringInstance().encode(advsearchrequest.getFilters(), dataoutputstream);
        }
        if (advsearchrequest.getToggleRefinements() == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        dataoutputstream.writeBoolean(flag);
        if (!flag)
        {
            DefaultEncoder.getArrayInstance(DefaultEncoder.getStringInstance()).encode(advsearchrequest.getToggleRefinements(), dataoutputstream);
        }
        if (advsearchrequest.getSortId() == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        dataoutputstream.writeBoolean(flag);
        if (!flag)
        {
            DefaultEncoder.getStringInstance().encode(advsearchrequest.getSortId(), dataoutputstream);
        }
        if (advsearchrequest.getReturnProducts() == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        dataoutputstream.writeBoolean(flag);
        if (!flag)
        {
            DefaultEncoder.getBooleanInstance().encode(advsearchrequest.getReturnProducts(), dataoutputstream);
        }
        if (advsearchrequest.getReturnStubs() == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        dataoutputstream.writeBoolean(flag);
        if (!flag)
        {
            DefaultEncoder.getBooleanInstance().encode(advsearchrequest.getReturnStubs(), dataoutputstream);
        }
        if (advsearchrequest.getReturnRefinements() == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        dataoutputstream.writeBoolean(flag);
        if (!flag)
        {
            DefaultEncoder.getBooleanInstance().encode(advsearchrequest.getReturnRefinements(), dataoutputstream);
        }
        if (advsearchrequest.getReturnCorrections() == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        dataoutputstream.writeBoolean(flag);
        if (!flag)
        {
            DefaultEncoder.getBooleanInstance().encode(advsearchrequest.getReturnCorrections(), dataoutputstream);
        }
        if (advsearchrequest.getIsPrefetch() == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        dataoutputstream.writeBoolean(flag);
        if (!flag)
        {
            DefaultEncoder.getBooleanInstance().encode(advsearchrequest.getIsPrefetch(), dataoutputstream);
        }
        if (advsearchrequest.getClickStreamOrigin() == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        dataoutputstream.writeBoolean(flag);
        if (!flag)
        {
            DefaultEncoder.getStringInstance().encode(advsearchrequest.getClickStreamOrigin(), dataoutputstream);
        }
        if (advsearchrequest.getIncludeAddOnItems() == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        dataoutputstream.writeBoolean(flag);
        if (!flag)
        {
            DefaultEncoder.getBooleanInstance().encode(advsearchrequest.getIncludeAddOnItems(), dataoutputstream);
        }
    }

    public volatile void encode(Object obj, DataOutputStream dataoutputstream)
        throws IOException
    {
        encode((AdvSearchRequest)obj, dataoutputstream);
    }
}
