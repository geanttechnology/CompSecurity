// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package amazon.communication.connection;


public final class Purpose
{

    public static final Purpose REGULAR = new Purpose("Regular");
    private final String mPurpose;

    public Purpose(String s)
    {
        if (s == null || s.trim().isEmpty())
        {
            throw new IllegalArgumentException("purpose must not be empty");
        } else
        {
            mPurpose = s;
            return;
        }
    }

    public boolean equals(Object obj)
    {
        if (obj == this)
        {
            return true;
        }
        if (obj == null || !(obj instanceof Purpose))
        {
            return false;
        } else
        {
            obj = (Purpose)obj;
            return mPurpose.equals(((Purpose) (obj)).mPurpose);
        }
    }

    public String getPurpose()
    {
        return mPurpose;
    }

    public int hashCode()
    {
        return mPurpose.hashCode();
    }

    public String toString()
    {
        return mPurpose;
    }

}
