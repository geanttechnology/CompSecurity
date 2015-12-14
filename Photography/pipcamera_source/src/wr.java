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

public class wr extends BaseImageFilter
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
    protected float u;
    private final int v = 4;

    public wr()
    {
        a("ChannelMixer");
    }

    public void a()
    {
        super.a();
    }

    protected void a(int i)
    {
        a = GLES20.glGetUniformLocation(i, "red");
        b = GLES20.glGetUniformLocation(i, "green");
        c = GLES20.glGetUniformLocation(i, "blue");
        o = GLES20.glGetUniformLocation(i, "gray");
        p = GLES20.glGetUniformLocation(i, "desaturation");
    }

    public void a(int i, int j)
    {
        GLES20.glBindFramebuffer(36160, i);
        GLES20.glUseProgram(c());
        GLES20.glBindTexture(3553, j);
        GLES20.glUniform1i(e, 0);
        GLES20.glUniform1f(f, m);
        GLES20.glUniform1f(g, n);
        FloatBuffer floatbuffer = ByteBuffer.allocateDirect(4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        FloatBuffer floatbuffer1 = ByteBuffer.allocateDirect(4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        FloatBuffer floatbuffer2 = ByteBuffer.allocateDirect(4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        FloatBuffer floatbuffer3 = ByteBuffer.allocateDirect(4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        floatbuffer.put(q);
        floatbuffer1.put(r);
        floatbuffer2.put(s);
        floatbuffer3.put(t);
        GLES20.glUniform3fv(a, 1, floatbuffer);
        GLES20.glUniform3fv(b, 1, floatbuffer1);
        GLES20.glUniform3fv(c, 1, floatbuffer2);
        GLES20.glUniform3fv(o, 1, floatbuffer3);
        GLES20.glUniform1f(p, u);
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
                if (s1.equalsIgnoreCase("red"))
                {
                    q = ((Float)hashmap.get(s1)).floatValue();
                } else
                if (s1.equalsIgnoreCase("green"))
                {
                    r = ((Float)hashmap.get(s1)).floatValue();
                } else
                if (s1.equalsIgnoreCase("blue"))
                {
                    s = ((Float)hashmap.get(s1)).floatValue();
                } else
                if (s1.equalsIgnoreCase("gray"))
                {
                    t = ((Float)hashmap.get(s1)).floatValue();
                } else
                if (s1.equalsIgnoreCase("desaturation"))
                {
                    u = ((Float)hashmap.get(s1)).floatValue();
                }
            }
        }
    }

    public void b(int i)
    {
        a(0, i);
    }
}
