// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import java.io.IOException;
import java.io.InputStream;

public class blj
{

    public static int a(Context context, String s, boolean flag)
    {
        int ai[];
        ai = new int[1];
        GLES20.glGenTextures(1, ai, 0);
        android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
        options.inScaled = false;
        options.inPreferredConfig = android.graphics.Bitmap.Config.ARGB_8888;
        InputStream inputstream;
        try
        {
            inputstream = context.getAssets().open(s);
            s = BitmapFactory.decodeStream(inputstream, null, options);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
            throw new RuntimeException("Error loading texture.");
        }
        context = s;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_108;
        }
        context = new Matrix();
        context.setScale(1.0F, -1F, (float)s.getWidth() / 2.0F, (float)s.getHeight() / 2.0F);
        context = Bitmap.createBitmap(s, 0, 0, s.getWidth(), s.getHeight(), context, true);
        s.recycle();
        inputstream.close();
        GLES20.glBindTexture(3553, ai[0]);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_181;
        }
        GLUtils.texImage2D(3553, 0, context, 0);
        context.recycle();
        if (ai[0] == 0)
        {
            throw new RuntimeException("Error loading texture.");
        } else
        {
            return ai[0];
        }
    }

    public static int a(Bitmap bitmap)
    {
        int ai[] = new int[1];
        GLES20.glGenTextures(1, ai, 0);
        if (ai[0] != 0)
        {
            GLES20.glBindTexture(3553, ai[0]);
            GLES20.glTexParameteri(3553, 10241, 9729);
            GLES20.glTexParameteri(3553, 10240, 9729);
            GLES20.glTexParameteri(3553, 10242, 33071);
            GLES20.glTexParameteri(3553, 10243, 33071);
            GLUtils.texImage2D(3553, 0, bitmap, 0);
        }
        if (ai[0] == 0)
        {
            throw new RuntimeException("Error loading texture.");
        } else
        {
            return ai[0];
        }
    }

    public static int a(Bitmap bitmap, boolean flag)
    {
        if (flag)
        {
            Object obj = new Matrix();
            ((Matrix) (obj)).setScale(1.0F, -1F, (float)bitmap.getWidth() / 2.0F, (float)bitmap.getHeight() / 2.0F);
            obj = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), ((Matrix) (obj)), true);
            bitmap.recycle();
            return a(((Bitmap) (obj)));
        } else
        {
            return a(bitmap);
        }
    }

    public static void a(Bitmap bitmap, int i)
    {
        if (i != 0)
        {
            GLES20.glBindTexture(3553, i);
            GLES20.glTexParameteri(3553, 10241, 9729);
            GLES20.glTexParameteri(3553, 10240, 9729);
            GLES20.glTexParameteri(3553, 10242, 33071);
            GLES20.glTexParameteri(3553, 10243, 33071);
            GLUtils.texImage2D(3553, 0, bitmap, 0);
        }
    }
}
