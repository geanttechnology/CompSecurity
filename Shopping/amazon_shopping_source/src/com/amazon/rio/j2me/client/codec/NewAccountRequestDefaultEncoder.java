// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.codec;

import com.amazon.rio.j2me.client.services.mShop.NewAccountRequest;
import java.io.DataOutputStream;
import java.io.IOException;

// Referenced classes of package com.amazon.rio.j2me.client.codec:
//            Encoder, DefaultEncoder, DateDefaultEncoder

public class NewAccountRequestDefaultEncoder
    implements Encoder
{

    public NewAccountRequestDefaultEncoder()
    {
    }

    public void encode(NewAccountRequest newaccountrequest, DataOutputStream dataoutputstream)
        throws IOException
    {
        DefaultEncoder.getStringInstance().encode(newaccountrequest.getFullName(), dataoutputstream);
        DefaultEncoder.getStringInstance().encode(newaccountrequest.getEmail(), dataoutputstream);
        DefaultEncoder.getStringInstance().encode(newaccountrequest.getPassword(), dataoutputstream);
        boolean flag;
        if (newaccountrequest.getPronunciation() == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        dataoutputstream.writeBoolean(flag);
        if (!flag)
        {
            DefaultEncoder.getStringInstance().encode(newaccountrequest.getPronunciation(), dataoutputstream);
        }
        if (newaccountrequest.getCaptchaId() == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        dataoutputstream.writeBoolean(flag);
        if (!flag)
        {
            DefaultEncoder.getStringInstance().encode(newaccountrequest.getCaptchaId(), dataoutputstream);
        }
        if (newaccountrequest.getCaptchaResponse() == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        dataoutputstream.writeBoolean(flag);
        if (!flag)
        {
            DefaultEncoder.getStringInstance().encode(newaccountrequest.getCaptchaResponse(), dataoutputstream);
        }
        if (newaccountrequest.getForceMase() == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        dataoutputstream.writeBoolean(flag);
        if (!flag)
        {
            DefaultEncoder.getBooleanInstance().encode(newaccountrequest.getForceMase(), dataoutputstream);
        }
        if (newaccountrequest.getDob() == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        dataoutputstream.writeBoolean(flag);
        if (!flag)
        {
            (new DateDefaultEncoder()).encode(newaccountrequest.getDob(), dataoutputstream);
        }
    }

    public volatile void encode(Object obj, DataOutputStream dataoutputstream)
        throws IOException
    {
        encode((NewAccountRequest)obj, dataoutputstream);
    }
}
