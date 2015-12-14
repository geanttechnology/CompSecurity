// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.database;

import android.content.ContentValues;
import android.graphics.Point;
import com.cyberlink.youcammakeup.jniproxy.UIExifColorSpace;
import com.cyberlink.youcammakeup.jniproxy.UIImageOrientation;

// Referenced classes of package com.cyberlink.youcammakeup.database:
//            m

public class r extends m
{

    protected long q;

    protected r(long l, long l1, UIImageOrientation uiimageorientation, String s, long l2, int i, String s1, int j, int k, int i1, String s2, 
            long l3, int j1, UIImageOrientation uiimageorientation1, UIExifColorSpace uiexifcolorspace, UIImageOrientation uiimageorientation2, long l4)
    {
        super(l1, uiimageorientation, s, l2, i, s1, j, k, i1, s2, l3, j1, uiimageorientation1, uiexifcolorspace, uiimageorientation2, l4);
        q = l;
    }

    protected r(long l, m m1)
    {
        super(m1);
        q = l;
    }

    public long t()
    {
        return p;
    }

    public String toString()
    {
        String s = super.toString();
        return (new StringBuilder()).append("ID: ").append(q).append(", ").append(s).toString();
    }

    protected ContentValues v()
    {
        ContentValues contentvalues = super.v();
        contentvalues.put("_id", Long.valueOf(w()));
        return contentvalues;
    }

    public long w()
    {
        return q;
    }

    public int x()
    {
        return k().y;
    }

    public int y()
    {
        return k().x;
    }
}
