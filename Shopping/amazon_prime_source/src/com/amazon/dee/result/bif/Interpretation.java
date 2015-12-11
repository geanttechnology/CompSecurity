// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.dee.result.bif;

import com.google.common.base.Objects;

// Referenced classes of package com.amazon.dee.result.bif:
//            Intent

public class Interpretation
{

    private String mDomain;
    private Intent mIntent;

    public Interpretation()
    {
    }

    public Interpretation(String s, Intent intent)
    {
        mDomain = s;
        mIntent = intent;
    }

    public boolean equals(Object obj)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (obj instanceof Interpretation)
        {
            obj = (Interpretation)obj;
            flag = flag1;
            if (Objects.equal(mDomain, ((Interpretation) (obj)).mDomain))
            {
                flag = flag1;
                if (Objects.equal(mIntent, ((Interpretation) (obj)).mIntent))
                {
                    flag = true;
                }
            }
        }
        return flag;
    }

    public final String getDomain()
    {
        return mDomain;
    }

    public final Intent getIntent()
    {
        return mIntent;
    }

    public int hashCode()
    {
        return Objects.hashCode(new Object[] {
            mDomain, mIntent
        });
    }

    public final void setDomain(String s)
    {
        mDomain = s;
    }

    public final void setIntent(Intent intent)
    {
        mIntent = intent;
    }
}
