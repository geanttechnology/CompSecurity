// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.codec;

import com.amazon.rio.j2me.client.services.mShop.HomeRequest;
import java.io.DataOutputStream;
import java.io.IOException;

// Referenced classes of package com.amazon.rio.j2me.client.codec:
//            Encoder, DefaultEncoder

public class HomeRequestDefaultEncoder
    implements Encoder
{

    public HomeRequestDefaultEncoder()
    {
    }

    public void encode(HomeRequest homerequest, DataOutputStream dataoutputstream)
        throws IOException
    {
        boolean flag;
        if (homerequest.getApplicationStartCount() == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        dataoutputstream.writeBoolean(flag);
        if (!flag)
        {
            DefaultEncoder.getIntegerInstance(0xffffffff80000000L, 0x7fffffffL).encode(homerequest.getApplicationStartCount(), dataoutputstream);
        }
        if (homerequest.getApplicationStarted() == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        dataoutputstream.writeBoolean(flag);
        if (!flag)
        {
            DefaultEncoder.getBooleanInstance().encode(homerequest.getApplicationStarted(), dataoutputstream);
        }
        if (homerequest.getReturnCartItems() == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        dataoutputstream.writeBoolean(flag);
        if (!flag)
        {
            DefaultEncoder.getBooleanInstance().encode(homerequest.getReturnCartItems(), dataoutputstream);
        }
        if (homerequest.getRemembersOldestPendingDate() == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        dataoutputstream.writeBoolean(flag);
        if (!flag)
        {
            DefaultEncoder.getIntegerInstance(0xffffffff80000000L, 0x7fffffffL).encode(homerequest.getRemembersOldestPendingDate(), dataoutputstream);
        }
        if (homerequest.getCrashInfo() == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        dataoutputstream.writeBoolean(flag);
        if (!flag)
        {
            DefaultEncoder.getStringInstance().encode(homerequest.getCrashInfo(), dataoutputstream);
        }
        if (homerequest.getReturnPromoSlot0() == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        dataoutputstream.writeBoolean(flag);
        if (!flag)
        {
            DefaultEncoder.getBooleanInstance().encode(homerequest.getReturnPromoSlot0(), dataoutputstream);
        }
        if (homerequest.getReturnPromoSlot1() == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        dataoutputstream.writeBoolean(flag);
        if (!flag)
        {
            DefaultEncoder.getBooleanInstance().encode(homerequest.getReturnPromoSlot1(), dataoutputstream);
        }
        if (homerequest.getReturnShoveler0() == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        dataoutputstream.writeBoolean(flag);
        if (!flag)
        {
            DefaultEncoder.getBooleanInstance().encode(homerequest.getReturnShoveler0(), dataoutputstream);
        }
        if (homerequest.getReturnShoveler1() == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        dataoutputstream.writeBoolean(flag);
        if (!flag)
        {
            DefaultEncoder.getBooleanInstance().encode(homerequest.getReturnShoveler1(), dataoutputstream);
        }
    }

    public volatile void encode(Object obj, DataOutputStream dataoutputstream)
        throws IOException
    {
        encode((HomeRequest)obj, dataoutputstream);
    }
}
