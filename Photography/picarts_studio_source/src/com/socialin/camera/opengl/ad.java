// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.camera.opengl;

import android.opengl.GLES20;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public final class ad
{

    private HashMap a;
    private HashMap b;
    private HashMap c;

    public ad()
    {
        a = new HashMap();
        b = new HashMap();
        c = new HashMap();
    }

    public final void a(int i)
    {
        float f;
        String s;
        for (Iterator iterator = a.keySet().iterator(); iterator.hasNext(); GLES20.glUniform1f(GLES20.glGetUniformLocation(i, s), f))
        {
            s = (String)iterator.next();
            f = ((Float)a.get(s)).floatValue();
        }

        String s1;
        float af[];
        for (Iterator iterator1 = b.keySet().iterator(); iterator1.hasNext(); GLES20.glUniform2fv(GLES20.glGetUniformLocation(i, s1), 1, af, 0))
        {
            s1 = (String)iterator1.next();
            af = (float[])b.get(s1);
        }

        String s2;
        Integer integer;
        for (Iterator iterator2 = c.keySet().iterator(); iterator2.hasNext(); GLES20.glUniform1i(GLES20.glGetUniformLocation(i, s2), integer.intValue()))
        {
            s2 = (String)iterator2.next();
            integer = (Integer)c.get(s2);
        }

    }

    public final void a(String s, Float float1)
    {
        a.put(s, float1);
    }

    public final void a(String s, Integer integer)
    {
        c.put(s, integer);
    }
}
