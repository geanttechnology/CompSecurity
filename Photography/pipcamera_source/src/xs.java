// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.opengl.GLES20;
import com.wantu.piprender.renderengine.filters.BaseImageFilter;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class xs extends BaseImageFilter
{

    protected int a;
    protected int b;
    protected int c;
    protected int o;
    protected float p;
    protected float q;
    protected float r;
    protected float s;
    private final int t = 4;

    public xs()
    {
        a("Sepia");
    }

    public void a()
    {
        super.a();
    }

    protected void a(int i)
    {
        a = GLES20.glGetUniformLocation(i, "desaturation");
        b = GLES20.glGetUniformLocation(i, "toned");
        c = GLES20.glGetUniformLocation(i, "lightColor");
        o = GLES20.glGetUniformLocation(i, "darkColor");
    }

    public void a(int i, int j)
    {
        GLES20.glBindFramebuffer(36160, i);
        GLES20.glUseProgram(c());
        GLES20.glBindTexture(3553, j);
        GLES20.glUniform1i(e, 0);
        GLES20.glUniform1f(f, m);
        GLES20.glUniform1f(g, n);
        GLES20.glUniform1f(a, p);
        GLES20.glUniform1f(b, q);
        FloatBuffer floatbuffer = ByteBuffer.allocateDirect(4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        FloatBuffer floatbuffer1 = ByteBuffer.allocateDirect(4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        floatbuffer.put(r);
        floatbuffer1.put(s);
        GLES20.glUniform3fv(c, 1, floatbuffer);
        GLES20.glUniform3fv(o, 1, floatbuffer1);
        GLES20.glEnableVertexAttribArray(com.wantu.piprender.renderengine.filters.BaseImageFilter.Attribute.RE_ATTRIB_VERTEX.ordinal());
        GLES20.glVertexAttribPointer(com.wantu.piprender.renderengine.filters.BaseImageFilter.Attribute.RE_ATTRIB_VERTEX.ordinal(), 3, 5126, false, 0, this.j);
        GLES20.glEnableVertexAttribArray(com.wantu.piprender.renderengine.filters.BaseImageFilter.Attribute.RE_ATTRIB_TEXTUREPOSITON.ordinal());
        GLES20.glVertexAttribPointer(com.wantu.piprender.renderengine.filters.BaseImageFilter.Attribute.RE_ATTRIB_TEXTUREPOSITON.ordinal(), 2, 5126, false, 0, l);
        GLES20.glDrawArrays(5, 0, 4);
    }

    public void a(Context context, HashMap hashmap)
    {
        super.a(context, hashmap);
        context = hashmap.keySet().iterator();
        do
        {
            if (!context.hasNext())
            {
                break;
            }
            String s1 = (String)context.next();
            if (s1.equalsIgnoreCase("desaturation"))
            {
                p = ((Float)hashmap.get(s1)).floatValue();
            } else
            if (s1.equalsIgnoreCase("toning"))
            {
                q = ((Float)hashmap.get(s1)).floatValue();
            } else
            if (s1.equalsIgnoreCase("paperToneColor"))
            {
                r = ((Float)hashmap.get(s1)).floatValue();
            } else
            if (s1.equalsIgnoreCase("stainToneColor"))
            {
                s = ((Float)hashmap.get(s1)).floatValue();
            }
        } while (true);
    }

    public void b(int i)
    {
        a(0, i);
    }
}
