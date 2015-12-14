// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.opengl.GLES20;
import com.wantu.piprender.renderengine.filters.BaseImageFilter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class xd extends BaseImageFilter
{

    protected int a;
    protected int b;
    protected int c;
    protected int o;
    protected int p;
    protected float q;
    protected float r;
    protected float s;
    protected float t;
    protected Boolean u;

    public xd()
    {
        a("FilmGrain");
    }

    public void a()
    {
        super.a();
    }

    protected void a(int i)
    {
        a = GLES20.glGetUniformLocation(i, "time");
        b = GLES20.glGetUniformLocation(i, "grayscale");
        c = GLES20.glGetUniformLocation(i, "nIntensity");
        o = GLES20.glGetUniformLocation(i, "sIntensity");
        p = GLES20.glGetUniformLocation(i, "sCount");
    }

    public void a(int i, int j)
    {
        boolean flag = true;
        GLES20.glBindFramebuffer(36160, i);
        GLES20.glUseProgram(c());
        GLES20.glBindTexture(3553, j);
        GLES20.glUniform1i(e, 0);
        GLES20.glUniform1f(f, m);
        GLES20.glUniform1f(g, n);
        GLES20.glUniform1f(a, q);
        if (u.booleanValue())
        {
            i = ((flag) ? 1 : 0);
        } else
        {
            i = 0;
        }
        GLES20.glUniform1i(b, i);
        GLES20.glUniform1f(c, r);
        GLES20.glUniform1f(o, s);
        GLES20.glUniform1f(p, t);
        GLES20.glEnableVertexAttribArray(com.wantu.piprender.renderengine.filters.BaseImageFilter.Attribute.RE_ATTRIB_VERTEX.ordinal());
        GLES20.glVertexAttribPointer(com.wantu.piprender.renderengine.filters.BaseImageFilter.Attribute.RE_ATTRIB_VERTEX.ordinal(), 3, 5126, false, 0, this.j);
        GLES20.glEnableVertexAttribArray(com.wantu.piprender.renderengine.filters.BaseImageFilter.Attribute.RE_ATTRIB_TEXTUREPOSITON.ordinal());
        GLES20.glVertexAttribPointer(com.wantu.piprender.renderengine.filters.BaseImageFilter.Attribute.RE_ATTRIB_TEXTUREPOSITON.ordinal(), 2, 5126, false, 0, l);
        GLES20.glDrawArrays(5, 0, 4);
    }

    public void a(Context context, HashMap hashmap)
    {
        super.a(context, hashmap);
        if (hashmap != null)
        {
            context = hashmap.keySet().iterator();
            while (context.hasNext()) 
            {
                String s1 = (String)context.next();
                if (s1.equalsIgnoreCase("time"))
                {
                    q = ((Float)hashmap.get(s1)).floatValue();
                } else
                if (s1.equalsIgnoreCase("nIntensity"))
                {
                    r = ((Float)hashmap.get(s1)).floatValue();
                } else
                if (s1.equalsIgnoreCase("sCount"))
                {
                    t = ((Float)hashmap.get(s1)).floatValue();
                } else
                if (s1.equalsIgnoreCase("sIntensity"))
                {
                    s = ((Float)hashmap.get(s1)).floatValue();
                } else
                if (s1.equalsIgnoreCase("bGrayscale"))
                {
                    u = (Boolean)hashmap.get(s1);
                }
            }
        }
    }

    public void b(int i)
    {
        a(0, i);
    }
}
