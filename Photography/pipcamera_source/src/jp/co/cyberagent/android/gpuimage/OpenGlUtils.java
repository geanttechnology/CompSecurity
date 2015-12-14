// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jp.co.cyberagent.android.gpuimage;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.util.Log;
import com.crashlytics.android.Crashlytics;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;

public class OpenGlUtils
{

    private static String a = "OpenGlUtils";

    public static int a(Bitmap bitmap, int i, Direction direction, boolean flag)
    {
        Matrix matrix = new Matrix();
        if (direction == Direction.VERTICAL)
        {
            matrix.preScale(1.0F, -1F);
        } else
        {
            matrix.preScale(-1F, 1.0F);
        }
        direction = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        matrix = new int[1];
        if (i == -1)
        {
            GLES20.glGenTextures(1, matrix, 0);
            GLES20.glBindTexture(3553, matrix[0]);
            GLES20.glTexParameterf(3553, 10240, 9729F);
            GLES20.glTexParameterf(3553, 10241, 9729F);
            GLES20.glTexParameterf(3553, 10242, 33071F);
            GLES20.glTexParameterf(3553, 10243, 33071F);
            GLUtils.texImage2D(3553, 0, direction, 0);
        } else
        {
            GLES20.glBindTexture(3553, i);
            GLUtils.texSubImage2D(3553, 0, 0, 0, direction);
            matrix[0] = i;
        }
        direction.recycle();
        if (flag)
        {
            bitmap.recycle();
        }
        return matrix[0];
    }

    public static int a(Bitmap bitmap, int i, boolean flag)
    {
        int ai[] = new int[1];
        if (i == -1)
        {
            GLES20.glGenTextures(1, ai, 0);
            GLES20.glBindTexture(3553, ai[0]);
            GLES20.glTexParameterf(3553, 10240, 9729F);
            GLES20.glTexParameterf(3553, 10241, 9729F);
            GLES20.glTexParameterf(3553, 10242, 33071F);
            GLES20.glTexParameterf(3553, 10243, 33071F);
            GLUtils.texImage2D(3553, 0, bitmap, 0);
        } else
        {
            GLES20.glBindTexture(3553, i);
            GLUtils.texSubImage2D(3553, 0, 0, 0, bitmap);
            ai[0] = i;
        }
        if (flag)
        {
            bitmap.recycle();
        }
        return ai[0];
    }

    public static int a(Bitmap bitmap, boolean flag)
    {
        int ai[] = new int[1];
        ByteBuffer bytebuffer = ByteBuffer.allocateDirect(bitmap.getWidth() * bitmap.getHeight() * 4);
        bitmap.copyPixelsToBuffer(bytebuffer);
        bytebuffer.position(0);
        GLES20.glGenTextures(1, ai, 0);
        GLES20.glBindTexture(3553, ai[0]);
        GLES20.glTexParameterf(3553, 10240, 9729F);
        GLES20.glTexParameterf(3553, 10241, 9729F);
        GLES20.glTexParameterf(3553, 10242, 33071F);
        GLES20.glTexParameterf(3553, 10243, 33071F);
        GLES20.glTexImage2D(3553, 0, 6408, bitmap.getWidth(), bitmap.getHeight(), 0, 6408, 5121, bytebuffer);
        if (flag)
        {
            bitmap.recycle();
        }
        return ai[0];
    }

    public static int a(String s, int i, String s1)
    {
        int ai[] = new int[1];
        i = GLES20.glCreateShader(i);
        GLES20.glShaderSource(i, s);
        GLES20.glCompileShader(i);
        GLES20.glGetShaderiv(i, 35713, ai, 0);
        Log.i(a, (new StringBuilder()).append("strLanguage = ").append(s1).toString());
        if (ai[0] == 0)
        {
            s = (new StringBuilder()).append("Compilation\n").append(GLES20.glGetShaderInfoLog(i)).toString();
            s = (new StringBuilder()).append(s).append("\n Language : ").append(s1).toString();
            Log.e("Load Shader Failed", s);
            a(s);
            return 0;
        } else
        {
            return i;
        }
    }

    public static int a(String s, String s1)
    {
        return a(s, s1, "");
    }

    public static int a(String s, String s1, String s2)
    {
        int ai[] = new int[1];
        int i = a(s, 35633, s2);
        if (i == 0)
        {
            Log.e("Load Program", "Vertex Shader Failed");
            return 0;
        }
        int j = a(s1, 35632, s2);
        if (j == 0)
        {
            Log.e("Load Program", "Fragment Shader Failed");
            return 0;
        }
        int k = GLES20.glCreateProgram();
        GLES20.glAttachShader(k, i);
        GLES20.glAttachShader(k, j);
        GLES20.glLinkProgram(k);
        GLES20.glGetProgramiv(k, 35714, ai, 0);
        if (ai[0] <= 0)
        {
            Log.d("Load Program", "Linking Failed");
            a("Linking Failed");
            return 0;
        } else
        {
            GLES20.glDeleteShader(i);
            GLES20.glDeleteShader(j);
            return k;
        }
    }

    public static int a(IntBuffer intbuffer, android.hardware.Camera.Size size, int i)
    {
        int ai[] = new int[1];
        if (i == -1)
        {
            GLES20.glGenTextures(1, ai, 0);
            GLES20.glBindTexture(3553, ai[0]);
            GLES20.glTexParameterf(3553, 10240, 9729F);
            GLES20.glTexParameterf(3553, 10241, 9729F);
            GLES20.glTexParameterf(3553, 10242, 33071F);
            GLES20.glTexParameterf(3553, 10243, 33071F);
            GLES20.glTexImage2D(3553, 0, 6408, size.width, size.height, 0, 6408, 5121, intbuffer);
        } else
        {
            GLES20.glBindTexture(3553, i);
            GLES20.glTexSubImage2D(3553, 0, 0, 0, size.width, size.height, 6408, 5121, intbuffer);
            ai[0] = i;
        }
        return ai[0];
    }

    public static GPURenderType a()
    {
        return GPURenderType.GPUImageRender_YUV420SP;
    }

    private static void a(String s)
    {
        try
        {
            throw new ShaderLoadException(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
        }
        Crashlytics.logException(s);
    }


    private class Direction extends Enum
    {

        private static final Direction $VALUES[];
        public static final Direction HORIZONTAL;
        public static final Direction VERTICAL;

        public static Direction valueOf(String s)
        {
            return (Direction)Enum.valueOf(jp/co/cyberagent/android/gpuimage/OpenGlUtils$Direction, s);
        }

        public static Direction[] values()
        {
            return (Direction[])$VALUES.clone();
        }

        static 
        {
            VERTICAL = new Direction("VERTICAL", 0);
            HORIZONTAL = new Direction("HORIZONTAL", 1);
            $VALUES = (new Direction[] {
                VERTICAL, HORIZONTAL
            });
        }

        private Direction(String s, int i)
        {
            super(s, i);
        }
    }


    private class GPURenderType extends Enum
    {

        private static final GPURenderType $VALUES[];
        public static final GPURenderType GPUImageRender_RGB;
        public static final GPURenderType GPUImageRender_YUV420SP;

        public static GPURenderType valueOf(String s)
        {
            return (GPURenderType)Enum.valueOf(jp/co/cyberagent/android/gpuimage/OpenGlUtils$GPURenderType, s);
        }

        public static GPURenderType[] values()
        {
            return (GPURenderType[])$VALUES.clone();
        }

        static 
        {
            GPUImageRender_YUV420SP = new GPURenderType("GPUImageRender_YUV420SP", 0);
            GPUImageRender_RGB = new GPURenderType("GPUImageRender_RGB", 1);
            $VALUES = (new GPURenderType[] {
                GPUImageRender_YUV420SP, GPUImageRender_RGB
            });
        }

        private GPURenderType(String s, int i)
        {
            super(s, i);
        }
    }


    private class ShaderLoadException extends Exception
    {

        public ShaderLoadException(String s)
        {
            super(s);
        }
    }

}
