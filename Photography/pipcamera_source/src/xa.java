// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.graphics.Color;
import android.opengl.GLES20;
import android.util.Log;
import com.wantu.ResourceOnlineLibrary.EOnlineResType;
import com.wantu.ResourceOnlineLibrary.FileManager;
import com.wantu.piprender.renderengine.filters.BaseImageFilter;
import java.nio.IntBuffer;
import java.util.HashMap;

public class xa extends BaseImageFilter
{

    protected int a;
    protected int b;
    protected int c;
    protected int o;
    protected String p;
    protected int q;
    protected int r;
    protected int s;
    protected int t;
    protected float u;

    public xa()
    {
        s = -1;
        a("ExBlend0");
    }

    public void a()
    {
        super.a();
        if (s == -1 && q != 0)
        {
            GLES20.glDeleteTextures(1, IntBuffer.wrap(new int[] {
                q
            }));
        }
    }

    protected void a(int i)
    {
        a = GLES20.glGetUniformLocation(i, "blendTex");
        b = GLES20.glGetUniformLocation(i, "blendMode");
        o = GLES20.glGetUniformLocation(i, "opacity");
        c = GLES20.glGetUniformLocation(i, "bdColor");
    }

    public void a(int i, int j)
    {
        GLES20.glBindFramebuffer(36160, i);
        GLES20.glUseProgram(c());
        i = j;
        if (s != -1)
        {
            if (s == 0)
            {
                q = j;
                i = h;
            } else
            {
                i = j;
                if (s == 1)
                {
                    q = h;
                    i = j;
                }
            }
        }
        if (q != 0)
        {
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, i);
            GLES20.glActiveTexture(33985);
            GLES20.glBindTexture(3553, q);
            GLES20.glUniform1i(a, 1);
        } else
        {
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, i);
            GLES20.glUniform4f(c, (float)Color.red(r) / 255F, (float)Color.green(r) / 255F, (float)Color.blue(r) / 255F, (float)Color.alpha(r) / 255F);
        }
        GLES20.glUniform1i(e, 0);
        GLES20.glUniform1f(f, m);
        GLES20.glUniform1f(g, n);
        GLES20.glUniform1i(b, t);
        GLES20.glUniform1f(o, u);
        GLES20.glEnableVertexAttribArray(com.wantu.piprender.renderengine.filters.BaseImageFilter.Attribute.RE_ATTRIB_VERTEX.ordinal());
        GLES20.glVertexAttribPointer(com.wantu.piprender.renderengine.filters.BaseImageFilter.Attribute.RE_ATTRIB_VERTEX.ordinal(), 3, 5126, false, 0, this.j);
        GLES20.glEnableVertexAttribArray(com.wantu.piprender.renderengine.filters.BaseImageFilter.Attribute.RE_ATTRIB_TEXTUREPOSITON.ordinal());
        GLES20.glVertexAttribPointer(com.wantu.piprender.renderengine.filters.BaseImageFilter.Attribute.RE_ATTRIB_TEXTUREPOSITON.ordinal(), 2, 5126, false, 0, l);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, 1);
    }

    public void a(Context context, HashMap hashmap)
    {
        if (hashmap == null)
        {
            return;
        }
        if (hashmap.containsKey("blendMode"))
        {
            t = ((Integer)hashmap.get("blendMode")).intValue();
            a((new StringBuilder()).append("ExBlend").append(String.valueOf(t)).toString());
        }
        if (hashmap.containsKey("blendColor"))
        {
            r = ((Integer)hashmap.get("blendColor")).intValue();
        }
        if (hashmap.containsKey("blendImagePath"))
        {
            p = (String)hashmap.get("blendImagePath");
        }
        if (hashmap.containsKey("blendSrcLocation"))
        {
            s = ((Integer)hashmap.get("blendSrcLocation")).intValue();
        }
        if (hashmap.containsKey("opacity"))
        {
            u = ((Float)hashmap.get("opacity")).floatValue();
        } else
        {
            u = 1.0F;
        }
        if (p != null)
        {
            Log.v("ExBlendNetFilter", p);
            q = vu.a(FileManager.getInstance().getOnlineBitmapRes(EOnlineResType.LIGHT_FILTER, p), true);
        }
        super.a(context, hashmap);
    }

    public void b(int i)
    {
        a(0, i);
    }
}
