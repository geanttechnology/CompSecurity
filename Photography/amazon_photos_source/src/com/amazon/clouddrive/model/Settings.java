// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.model;


public class Settings
    implements Comparable
{

    private Boolean favorite;
    private Boolean hidden;

    public Settings()
    {
    }

    public int compareTo(Settings settings)
    {
        if (settings != null) goto _L2; else goto _L1
_L1:
        int i = -1;
_L6:
        return i;
_L2:
        Boolean boolean1;
        Boolean boolean2;
        if (settings == this)
        {
            return 0;
        }
        boolean1 = isFavorite();
        boolean2 = settings.isFavorite();
        if (boolean1 == boolean2)
        {
            break; /* Loop/switch isn't completed */
        }
        if (boolean1 == null)
        {
            return -1;
        }
        if (boolean2 == null)
        {
            return 1;
        }
        if (!(boolean1 instanceof Comparable)) goto _L4; else goto _L3
_L3:
        int k;
        k = ((Comparable)boolean1).compareTo(boolean2);
        i = k;
        if (k != 0) goto _L6; else goto _L5
_L5:
        boolean1 = isHidden();
        settings = settings.isHidden();
        if (boolean1 == settings)
        {
            break; /* Loop/switch isn't completed */
        }
        if (boolean1 == null)
        {
            return -1;
        }
        break; /* Loop/switch isn't completed */
_L4:
        if (!boolean1.equals(boolean2))
        {
            i = boolean1.hashCode();
            k = boolean2.hashCode();
            if (i < k)
            {
                return -1;
            }
            if (i > k)
            {
                return 1;
            }
        }
        if (true) goto _L5; else goto _L7
_L7:
        if (settings == null)
        {
            return 1;
        }
        if (!(boolean1 instanceof Comparable)) goto _L9; else goto _L8
_L8:
        k = ((Comparable)boolean1).compareTo(settings);
        i = k;
        if (k != 0) goto _L6; else goto _L10
_L10:
        return 0;
_L9:
        if (!boolean1.equals(settings))
        {
            int j = boolean1.hashCode();
            int l = settings.hashCode();
            if (j < l)
            {
                return -1;
            }
            if (j > l)
            {
                return 1;
            }
        }
        if (true) goto _L10; else goto _L11
_L11:
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((Settings)obj);
    }

    public boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (obj instanceof Settings)
            {
                if (compareTo((Settings)obj) != 0)
                {
                    return false;
                }
            } else
            {
                return false;
            }
        }
        return true;
    }

    public int hashCode()
    {
        int j = 0;
        int i;
        if (isFavorite() == null)
        {
            i = 0;
        } else
        {
            i = isFavorite().hashCode();
        }
        if (isHidden() != null)
        {
            j = isHidden().hashCode();
        }
        return 1 + i + j;
    }

    public Boolean isFavorite()
    {
        return favorite;
    }

    public Boolean isHidden()
    {
        return hidden;
    }

    public void setFavorite(Boolean boolean1)
    {
        favorite = boolean1;
    }

    public void setHidden(Boolean boolean1)
    {
        hidden = boolean1;
    }
}
