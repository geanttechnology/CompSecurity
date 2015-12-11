// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.util.image;


public class ImageKey
{

    public final int blurRadius;
    public final boolean blurred;
    public final boolean circularCropped;
    public boolean desaturated;
    public final int height;
    public final boolean requestResize;
    public final String url;
    public final int width;

    public ImageKey(String s)
    {
        this(s, 0, 0, false, false, 0, false);
    }

    public ImageKey(String s, int i, int j, boolean flag)
    {
        this(s, i, j, flag, false, 0, false);
    }

    public ImageKey(String s, int i, int j, boolean flag, boolean flag1, int k, boolean flag2)
    {
        url = s;
        width = i;
        height = j;
        circularCropped = flag;
        if (i > 0 && j > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        requestResize = flag;
        blurred = flag1;
        blurRadius = k;
        desaturated = flag2;
        if (s == null)
        {
            throw new IllegalStateException("Tried to create Image key with null url.");
        } else
        {
            return;
        }
    }

    public ImageKey(String s, boolean flag)
    {
        this(s, 0, 0, flag, false, 0, false);
    }

    public ImageKey(String s, boolean flag, int i, boolean flag1)
    {
        this(s, 0, 0, false, flag, i, flag1);
    }

    public boolean equals(Object obj)
    {
        boolean flag2 = true;
        boolean flag3 = false;
        boolean flag;
        if (this == obj)
        {
            flag = true;
        } else
        {
            flag = flag3;
            if (obj != null)
            {
                flag = flag3;
                if (getClass() == obj.getClass())
                {
                    obj = (ImageKey)obj;
                    flag = flag3;
                    if (height == ((ImageKey) (obj)).height)
                    {
                        flag = flag3;
                        if (width == ((ImageKey) (obj)).width)
                        {
                            flag = flag3;
                            if (blurred == ((ImageKey) (obj)).blurred)
                            {
                                flag = flag3;
                                if (blurRadius == ((ImageKey) (obj)).blurRadius)
                                {
                                    flag = flag3;
                                    if (circularCropped == ((ImageKey) (obj)).circularCropped)
                                    {
                                        flag = flag3;
                                        if (desaturated == ((ImageKey) (obj)).desaturated)
                                        {
                                            if (url != null)
                                            {
                                                return url.equals(((ImageKey) (obj)).url);
                                            }
                                            boolean flag1;
                                            if (((ImageKey) (obj)).url == null)
                                            {
                                                flag1 = flag2;
                                            } else
                                            {
                                                flag1 = false;
                                            }
                                            return flag1;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return flag;
    }

    public int hashCode()
    {
        int l = 1;
        int i;
        int j;
        int k;
        int i1;
        int j1;
        int k1;
        if (url != null)
        {
            i = url.hashCode();
        } else
        {
            i = 0;
        }
        i1 = width;
        j1 = height;
        if (circularCropped)
        {
            j = 1;
        } else
        {
            j = 0;
        }
        if (blurred)
        {
            k = 1;
        } else
        {
            k = 0;
        }
        k1 = blurRadius;
        if (!desaturated)
        {
            l = 0;
        }
        return (((((i * 31 + i1) * 31 + j1) * 31 + j) * 31 + k) * 31 + k1) * 31 + l;
    }
}
