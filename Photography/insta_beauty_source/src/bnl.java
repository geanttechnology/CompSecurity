// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.GLES20;
import com.wantu.piprender.renderengine.filters.BaseImageFilter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.IntBuffer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class bnl extends BaseImageFilter
{

    protected int a;
    protected int b;
    protected int c;
    protected int o;
    protected String p;
    protected int q;
    protected int r;

    public bnl()
    {
        q = 1;
        r = 0;
        a("SkinTone");
    }

    public void a()
    {
        super.a();
        GLES20.glDeleteTextures(1, IntBuffer.wrap(new int[] {
            o
        }));
    }

    protected void a(int i)
    {
        a = GLES20.glGetUniformLocation(i, "curveTex");
        b = GLES20.glGetUniformLocation(i, "yCoord");
        c = GLES20.glGetUniformLocation(i, "yContrastCoord");
    }

    public void a(int i, int j)
    {
        GLES20.glBindFramebuffer(36160, i);
        GLES20.glUseProgram(c());
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, j);
        GLES20.glUniform1i(e, 0);
        GLES20.glActiveTexture(33985);
        GLES20.glBindTexture(3553, o);
        GLES20.glUniform1i(a, 1);
        GLES20.glUniform1f(f, m);
        GLES20.glUniform1f(g, n);
        if (q < r)
        {
            GLES20.glUniform1f(b, (float)((double)q - 0.5D) / (float)r);
            GLES20.glUniform1f(c, (float)((double)r - 0.5D) / (float)r);
        } else
        {
            GLES20.glUniform1f(b, 0.5F / (float)r);
            GLES20.glUniform1f(c, (float)((double)r - 0.5D) / (float)r);
        }
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
            Object obj = (String)iterator.next();
            if (((String) (obj)).equalsIgnoreCase("mapImageAssetPath"))
            {
                p = (String)hashmap.get(obj);
                if (p != null)
                {
                    try
                    {
                        obj = context.getAssets().open(p);
                        Bitmap bitmap = BitmapFactory.decodeStream(((InputStream) (obj)), null, new android.graphics.BitmapFactory.Options());
                        ((InputStream) (obj)).close();
                        r = bitmap.getHeight();
                        bitmap.recycle();
                    }
                    // Misplaced declaration of an exception variable
                    catch (Context context)
                    {
                        context.printStackTrace();
                        throw new RuntimeException("Error loading texture.");
                    }
                }
            } else
            if (((String) (obj)).equalsIgnoreCase("index"))
            {
                q = ((Integer)hashmap.get(obj)).intValue();
            }
        } while (true);
        o = blj.a(context, p, false);
    }

    public void b(int i)
    {
        a(0, i);
    }
}
