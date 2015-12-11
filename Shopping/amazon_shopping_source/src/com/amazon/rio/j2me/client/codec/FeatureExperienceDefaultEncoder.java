// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.codec;

import com.amazon.rio.j2me.client.services.mShop.FeatureExperience;
import java.io.DataOutputStream;
import java.io.IOException;

// Referenced classes of package com.amazon.rio.j2me.client.codec:
//            Encoder, DefaultEncoder

public class FeatureExperienceDefaultEncoder
    implements Encoder
{

    public FeatureExperienceDefaultEncoder()
    {
    }

    public void encode(FeatureExperience featureexperience, DataOutputStream dataoutputstream)
        throws IOException
    {
        boolean flag;
        if (featureexperience.getFeatureName() == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        dataoutputstream.writeBoolean(flag);
        if (!flag)
        {
            DefaultEncoder.getStringInstance().encode(featureexperience.getFeatureName(), dataoutputstream);
        }
        if (featureexperience.getTreatment() == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        dataoutputstream.writeBoolean(flag);
        if (!flag)
        {
            DefaultEncoder.getStringInstance().encode(featureexperience.getTreatment(), dataoutputstream);
        }
        if (featureexperience.getCacheStamp() == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        dataoutputstream.writeBoolean(flag);
        if (!flag)
        {
            DefaultEncoder.getIntegerInstance(0xffffffff80000000L, 0x7fffffffL).encode(featureexperience.getCacheStamp(), dataoutputstream);
        }
    }

    public volatile void encode(Object obj, DataOutputStream dataoutputstream)
        throws IOException
    {
        encode((FeatureExperience)obj, dataoutputstream);
    }
}
