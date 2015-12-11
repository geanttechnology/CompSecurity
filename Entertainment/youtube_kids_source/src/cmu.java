// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.opengl.GLES20;
import android.os.Looper;

public final class cmu
    implements cmr
{

    private int a;
    private int b;
    private int c;
    private int d;
    private int e;
    private final cmw f;
    private final float g[] = new float[16];

    public cmu(Context context)
    {
        f = new cmw(context);
        f.a();
        d = 16;
        e = 9;
        b = -1;
        c = -1;
    }

    private static void a(String s, int i)
    {
        int j = GLES20.glGetError();
        if (j != 0 || i == -1)
        {
            bmo.b((new StringBuilder(String.valueOf(s).length() + 21)).append(s).append(": glError ").append(j).toString());
            throw new RuntimeException((new StringBuilder(String.valueOf(s).length() + 21)).append(s).append(": glError ").append(j).toString());
        } else
        {
            return;
        }
    }

    public final String a()
    {
        return "attribute vec4 aVertPos;varying vec4 pos;void main() {gl_Position = aVertPos;pos = aVertPos;}";
    }

    public final void a(int i)
    {
        b = GLES20.glGetUniformLocation(i, "uFovX");
        a("glGetUniformLocation uFovX", b);
        c = GLES20.glGetUniformLocation(i, "uFovY");
        a("glGetUniformLocation uFovY", c);
        a = GLES20.glGetUniformLocation(i, "uRotation");
        a("glGetUniformLocation uRotation", a);
    }

    public final void a(int i, int j)
    {
        if (i != 0 && j != 0)
        {
            d = i;
            e = j;
        }
    }

    public final void a(boolean flag)
    {
        f.a(flag);
    }

    public final String b()
    {
        return "#extension GL_OES_EGL_image_external : require\n#define INV_PI 0.3183\nprecision mediump float;varying vec4 pos;uniform samplerExternalOES sTexture;uniform mat4 uRotation;uniform float uFovX;uniform float uFovY;void main() {  vec3 ray = vec3(pos.x * uFovX, pos.y * uFovY, -1);  ray = (uRotation * vec4(ray, 1.0)).xyz;  ray = normalize(ray);  vec2 texCrd = vec2(0.5 - atan(ray.x, ray.z) * INV_PI * 0.5, acos(ray.y) * INV_PI);  gl_FragColor = vec4(texture2D(sTexture, texCrd).xyz, 1.0);}";
    }

    public final void b(int i, int j)
    {
        cmw cmw1 = f;
        float f1 = ((float)(-i) * 3.141593F) / (float)d;
        synchronized (cmw1.a)
        {
            cmw1.g = f1 + cmw1.g;
            cmw1.k = true;
        }
        cmw1 = f;
        f1 = ((float)(-j) * 3.141593F) / (float)e;
        synchronized (cmw1.a)
        {
            cmw1.e = f1 + cmw1.e;
            cmw1.k = true;
        }
        return;
        exception;
        af;
        JVM INSTR monitorexit ;
        throw exception;
        exception1;
        af;
        JVM INSTR monitorexit ;
        throw exception1;
    }

    public final void c()
    {
        f.a(g);
        GLES20.glUniformMatrix4fv(a, 1, false, g, 0);
        if (d > e)
        {
            GLES20.glUniform1f(c, (float)Math.tan(0.34999999403953552D));
            GLES20.glUniform1f(b, (float)Math.tan(((float)d * 0.35F) / (float)e));
            return;
        } else
        {
            GLES20.glUniform1f(b, (float)Math.tan(0.34999999403953552D));
            GLES20.glUniform1f(c, (float)Math.tan(((float)e * 0.35F) / (float)d));
            return;
        }
    }

    public final void d()
    {
        cmw cmw1 = f;
        if (cmw1.c)
        {
            cmw1.b(false);
            cmw1.b.quit();
            cmw1.b = null;
            cmw1.d = null;
            cmw1.c = false;
        }
    }

    public final boolean e()
    {
        return false;
    }
}
