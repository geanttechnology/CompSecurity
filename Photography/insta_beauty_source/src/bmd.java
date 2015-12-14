// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.opengl.GLES20;
import com.instabeauty.application.InstaBeautyApplication;
import com.wantu.piprender.renderengine.filters.BaseImageFilter;
import java.nio.IntBuffer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class bmd extends BaseImageFilter
{

    protected int a;
    protected int b;
    protected int c;
    protected int o;
    protected int p;
    protected int q;
    protected String r;
    protected String s;
    protected int t;
    protected float u;

    public bmd()
    {
        a("BlendColor");
    }

    public void a()
    {
        super.a();
        GLES20.glDeleteTextures(1, IntBuffer.wrap(new int[] {
            p, q
        }));
    }

    protected void a(int i)
    {
        a = GLES20.glGetUniformLocation(i, "curveTex");
        b = GLES20.glGetUniformLocation(i, "texture");
        c = GLES20.glGetUniformLocation(i, "blendAlpha");
        o = GLES20.glGetUniformLocation(i, "blendMode");
    }

    public void a(int i, int j)
    {
        GLES20.glBindFramebuffer(36160, i);
        GLES20.glUseProgram(c());
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, j);
        GLES20.glActiveTexture(33985);
        GLES20.glBindTexture(3553, p);
        GLES20.glActiveTexture(33986);
        GLES20.glBindTexture(3553, q);
        GLES20.glUniform1i(e, 0);
        GLES20.glUniform1f(f, m);
        GLES20.glUniform1f(g, n);
        GLES20.glUniform1i(a, 1);
        GLES20.glUniform1f(a, 2.0F);
        GLES20.glUniform1f(c, u);
        GLES20.glUniform1f(o, t);
        GLES20.glEnableVertexAttribArray(com.wantu.piprender.renderengine.filters.BaseImageFilter.Attribute.RE_ATTRIB_VERTEX.ordinal());
        GLES20.glVertexAttribPointer(com.wantu.piprender.renderengine.filters.BaseImageFilter.Attribute.RE_ATTRIB_VERTEX.ordinal(), 3, 5126, false, 0, this.j);
        GLES20.glEnableVertexAttribArray(com.wantu.piprender.renderengine.filters.BaseImageFilter.Attribute.RE_ATTRIB_TEXTUREPOSITON.ordinal());
        GLES20.glVertexAttribPointer(com.wantu.piprender.renderengine.filters.BaseImageFilter.Attribute.RE_ATTRIB_TEXTUREPOSITON.ordinal(), 2, 5126, false, 0, l);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, 0);
    }

    public void a(Context context, HashMap hashmap)
    {
        super.a(context, hashmap);
        if (hashmap == null)
        {
            return;
        }
        context = hashmap.keySet().iterator();
        do
        {
            if (!context.hasNext())
            {
                break;
            }
            String s1 = (String)context.next();
            if (s1.equalsIgnoreCase("curImageAssetPath"))
            {
                r = (String)hashmap.get(s1);
            } else
            if (s1.equalsIgnoreCase("blendImageAssetPath"))
            {
                s = (String)hashmap.get(s1);
            } else
            if (s1.equalsIgnoreCase("blendType"))
            {
                t = ((Integer)hashmap.get(s1)).intValue();
            } else
            if (s1.equalsIgnoreCase("alpha"))
            {
                u = ((Float)hashmap.get(s1)).floatValue();
            }
        } while (true);
        p = blj.a(InstaBeautyApplication.a().b(), r, false);
        q = blj.a(InstaBeautyApplication.a().b(), s, false);
    }

    public void b(int i)
    {
        a(0, i);
    }
}
