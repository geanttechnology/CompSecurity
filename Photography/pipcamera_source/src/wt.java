// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.opengl.GLES20;
import com.wantu.piprender.renderengine.filters.BaseImageFilter;
import java.nio.IntBuffer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class wt extends BaseImageFilter
{

    protected int a;
    protected int b;
    protected String c;

    public wt()
    {
        a("ColorCurve");
    }

    public void a()
    {
        super.a();
        GLES20.glDeleteTextures(1, IntBuffer.wrap(new int[] {
            b
        }));
    }

    protected void a(int i)
    {
        a = GLES20.glGetUniformLocation(i, "curveTex");
    }

    public void a(int i, int j)
    {
        GLES20.glBindFramebuffer(36160, i);
        GLES20.glUseProgram(c());
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, j);
        GLES20.glActiveTexture(33985);
        GLES20.glBindTexture(3553, b);
        GLES20.glUniform1i(e, 0);
        GLES20.glUniform1f(f, m);
        GLES20.glUniform1f(g, n);
        GLES20.glUniform1i(a, 1);
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
        Iterator iterator = hashmap.keySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            String s = (String)iterator.next();
            if (s.equalsIgnoreCase("mapImageAssetPath"))
            {
                c = (String)hashmap.get(s);
            }
        } while (true);
        b = vu.a(context, c, false);
    }

    public void b(int i)
    {
        a(0, i);
    }
}
