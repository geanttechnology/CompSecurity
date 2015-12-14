// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.clgpuimage;

import android.content.res.AssetManager;
import android.opengl.GLES20;
import android.util.Log;
import com.cyberlink.clgpuimage.a.a;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

// Referenced classes of package com.cyberlink.clgpuimage:
//            u, z, af

public class CLBeautyFilterBasicWithTwoPassBlendSource2 extends u
{

    static String k = "color_effect_table/";
    private boolean A;
    private byte B[];
    private final int C = 256;
    private final int D = 128;
    private final int E = 256;
    private final int F = 1;
    private final int G = 3;
    private int H[];
    private int I;
    private ByteBuffer J;
    protected IBeautyFilter2.FilterType a;
    protected int b;
    protected int c;
    protected int d;
    protected int e;
    protected int f;
    protected int g;
    protected int h;
    protected int i;
    protected int j;
    private final FloatBuffer l;
    private final FloatBuffer m;
    private String n;
    private String o;
    private String p;
    private String q;
    private int r;
    private int s[];
    private int t[];
    private int u;
    private int v;
    private int w;
    private int x;
    private float y;
    private TableMode z;

    public CLBeautyFilterBasicWithTwoPassBlendSource2(String s1, String s2, String s3, String s4, IBeautyFilter2.FilterType filtertype)
    {
        super(s3, s4);
        b = 960;
        c = 720;
        n = s1;
        o = s2;
        p = s3;
        q = s4;
        a = filtertype;
        if (a == com.cyberlink.clgpuimage.IBeautyFilter2.FilterType.a)
        {
            y = 6F;
        } else
        {
            y = 2.0F;
        }
        l = ByteBuffer.allocateDirect(com.cyberlink.clgpuimage.z.a.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        l.put(com.cyberlink.clgpuimage.z.a).position(0);
        m = ByteBuffer.allocateDirect(a.a.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        m.put(a.a).position(0);
        z = com.cyberlink.clgpuimage.TableMode.a;
        A = false;
        B = null;
    }

    private byte a(byte byte0)
    {
        byte0 = (byte)((byte0 & 0xf0) >> 4 | (byte0 & 0xf) << 4);
        byte0 = (byte)((byte0 & 0x33) << 2 | (byte0 & 0xcc) >> 2);
        return (byte)((byte0 & 0x55) << 1 | (byte0 & 0xaa) >> 1);
    }

    static int a(CLBeautyFilterBasicWithTwoPassBlendSource2 clbeautyfilterbasicwithtwopassblendsource2)
    {
        return clbeautyfilterbasicwithtwopassblendsource2.w;
    }

    private void a(byte abyte0[])
    {
        for (int i1 = 0; i1 < abyte0.length; i1++)
        {
            abyte0[i1] = a(abyte0[i1]);
        }

    }

    static int b(CLBeautyFilterBasicWithTwoPassBlendSource2 clbeautyfilterbasicwithtwopassblendsource2)
    {
        return clbeautyfilterbasicwithtwopassblendsource2.x;
    }

    private void e(int i1, int j1)
    {
        s = new int[1];
        t = new int[1];
        GLES20.glGenFramebuffers(1, s, 0);
        GLES20.glGenTextures(1, t, 0);
        GLES20.glBindTexture(3553, t[0]);
        GLES20.glTexImage2D(3553, 0, 6408, i1, j1, 0, 6408, 5121, null);
        GLES20.glTexParameterf(3553, 10240, 9729F);
        GLES20.glTexParameterf(3553, 10241, 9729F);
        GLES20.glTexParameterf(3553, 10242, 33071F);
        GLES20.glTexParameterf(3553, 10243, 33071F);
        GLES20.glBindFramebuffer(36160, s[0]);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, t[0], 0);
        GLES20.glBindTexture(3553, 0);
        GLES20.glBindFramebuffer(36160, 0);
    }

    private void f()
    {
        if (t != null)
        {
            GLES20.glDeleteTextures(t.length, t, 0);
            t = null;
        }
        if (s != null)
        {
            GLES20.glDeleteFramebuffers(s.length, s, 0);
            s = null;
        }
    }

    public void a()
    {
        d = com.cyberlink.clgpuimage.af.a(n, o);
        e = GLES20.glGetAttribLocation(d, "position");
        f = GLES20.glGetUniformLocation(d, "inputImageTexture");
        g = GLES20.glGetAttribLocation(d, "inputTextureCoordinate");
        u = GLES20.glGetUniformLocation(d, "sampling_offset_start");
        v = GLES20.glGetUniformLocation(d, "sampling_step");
        super.a();
        w = GLES20.glGetUniformLocation(l(), "sampling_offset_start");
        x = GLES20.glGetUniformLocation(l(), "sampling_step");
        h = GLES20.glGetUniformLocation(l(), "smooth_strength");
        i = GLES20.glGetUniformLocation(l(), "color_strength");
        j = GLES20.glGetUniformLocation(l(), "fade_strength");
        r = GLES20.glGetUniformLocation(l(), "rootImageTexture");
        if (z != com.cyberlink.clgpuimage.TableMode.a)
        {
            char c1;
            char c2;
            if (z == TableMode.b)
            {
                c1 = '\u0100';
                c2 = '\200';
            } else
            if (z == TableMode.c)
            {
                c1 = '\u0100';
                c2 = '\001';
            } else
            {
                Log.v("Aphrodite Log", "Invalid table_lookup_mode");
                c2 = '\0';
                c1 = '\0';
            }
            H = new int[1];
            GLES20.glGenTextures(1, H, 0);
            GLES20.glBindTexture(3553, H[0]);
            GLES20.glTexParameterf(3553, 10240, 9729F);
            GLES20.glTexParameterf(3553, 10241, 9729F);
            GLES20.glTexParameterf(3553, 10242, 33071F);
            GLES20.glTexParameterf(3553, 10243, 33071F);
            GLES20.glTexImage2D(3553, 0, 6407, c1, c2, 0, 6407, 5121, J);
            I = GLES20.glGetUniformLocation(l(), "mapping_table_texture");
        }
    }

    public void a(int i1, int j1)
    {
        super.a(i1, j1);
        if (s != null)
        {
            f();
        }
        e(i1, j1);
        b(i1, j1);
    }

    public void a(int i1, FloatBuffer floatbuffer, FloatBuffer floatbuffer1)
    {
        IntBuffer intbuffer = IntBuffer.allocate(1024);
        GLES20.glGetIntegerv(36006, intbuffer);
        IntBuffer intbuffer1 = IntBuffer.allocate(4);
        GLES20.glGetIntegerv(2978, intbuffer1);
        GLES20.glUseProgram(d);
        GLES20.glViewport(0, 0, az, aA);
        GLES20.glBindFramebuffer(36160, s[0]);
        floatbuffer.position(0);
        GLES20.glVertexAttribPointer(e, 2, 5126, false, 0, floatbuffer);
        GLES20.glEnableVertexAttribArray(e);
        floatbuffer1.position(0);
        GLES20.glVertexAttribPointer(g, 2, 5126, false, 0, floatbuffer1);
        GLES20.glEnableVertexAttribArray(g);
        if (i1 != -1)
        {
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, i1);
            GLES20.glUniform1i(f, 0);
        }
        float f1 = (float)Math.min(b, c) / 720F;
        if (a == com.cyberlink.clgpuimage.IBeautyFilter2.FilterType.a)
        {
            f1 = (float)Math.max(1.0D, Math.floor(f1 * y));
        } else
        {
            f1 = (float)Math.max(1.0D, f1 * y);
        }
        GLES20.glUniform2f(u, (f1 - 0.5F) / (float)b, 0.0F);
        GLES20.glUniform2f(v, f1 / (float)b, 0.0F);
        d();
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisableVertexAttribArray(e);
        GLES20.glDisableVertexAttribArray(g);
        GLES20.glBindTexture(3553, 0);
        GLES20.glBindFramebuffer(36160, intbuffer.get(0));
        GLES20.glViewport(intbuffer1.get(0), intbuffer1.get(1), intbuffer1.get(2), intbuffer1.get(3));
    }

    public void a(AssetManager assetmanager, String s1, byte abyte0[], TableMode tablemode, boolean flag)
    {
        char c1 = '\u0100';
        z = tablemode;
        A = flag;
        B = abyte0;
        if (tablemode != com.cyberlink.clgpuimage.TableMode.a)
        {
            byte abyte1[];
            int i1;
            if (tablemode == TableMode.b)
            {
                i1 = 128;
            } else
            if (tablemode == TableMode.c)
            {
                i1 = 1;
            } else
            {
                Log.v("Aphrodite Log", "Invalid table_lookup_mode");
                i1 = 0;
                c1 = '\0';
            }
            i1 = i1 * c1 * 3;
            abyte1 = new byte[i1];
            if (abyte0 != null && tablemode == TableMode.c)
            {
                System.arraycopy(abyte0, 0, abyte1, 0, Math.min(i1, abyte0.length));
            } else
            {
                try
                {
                    assetmanager.open(s1).read(abyte1, 0, i1);
                }
                // Misplaced declaration of an exception variable
                catch (AssetManager assetmanager)
                {
                    assetmanager.printStackTrace();
                }
            }
            if (A)
            {
                a(abyte1);
            }
            J = ByteBuffer.allocate(abyte1.length);
            J.put(abyte1, 0, abyte1.length);
            J.position(0);
        }
    }

    public void b()
    {
        super.b();
        b(b, c);
    }

    protected void b(int i1, int j1)
    {
        if (i1 <= 0 || j1 <= 0)
        {
            return;
        }
        b = i1;
        c = j1;
        float f1 = (float)Math.min(b, c) / 720F;
        if (a == com.cyberlink.clgpuimage.IBeautyFilter2.FilterType.a)
        {
            f1 = (float)Math.max(1.0D, Math.floor(f1 * y));
        } else
        {
            f1 = (float)Math.max(1.0D, f1 * y);
        }
        a(new Runnable(f1 - 0.5F, f1) {

            final float a;
            final float b;
            final CLBeautyFilterBasicWithTwoPassBlendSource2 c;

            public void run()
            {
                c.a(com.cyberlink.clgpuimage.CLBeautyFilterBasicWithTwoPassBlendSource2.a(c), new float[] {
                    0.0F, a / (float)c.c
                });
                c.a(CLBeautyFilterBasicWithTwoPassBlendSource2.b(c), new float[] {
                    0.0F, b / (float)c.c
                });
            }

            
            {
                c = CLBeautyFilterBasicWithTwoPassBlendSource2.this;
                a = f1;
                b = f2;
                super();
            }
        });
    }

    public void b(int i1, FloatBuffer floatbuffer, FloatBuffer floatbuffer1)
    {
        if (i() && s != null && t != null)
        {
            a(i1, l, m);
            GLES20.glUseProgram(av);
            d_();
            if (i())
            {
                floatbuffer.position(0);
                GLES20.glVertexAttribPointer(aw, 2, 5126, false, 0, floatbuffer);
                GLES20.glEnableVertexAttribArray(aw);
                floatbuffer1.position(0);
                GLES20.glVertexAttribPointer(ay, 2, 5126, false, 0, floatbuffer1);
                GLES20.glEnableVertexAttribArray(ay);
                if (t[0] != -1)
                {
                    GLES20.glActiveTexture(33987);
                    GLES20.glBindTexture(3553, t[0]);
                    GLES20.glUniform1i(ax, 3);
                }
                if (i1 != -1)
                {
                    GLES20.glActiveTexture(33984);
                    GLES20.glBindTexture(3553, i1);
                    GLES20.glUniform1i(r, 0);
                }
                if (z != com.cyberlink.clgpuimage.TableMode.a && H[0] != -1)
                {
                    GLES20.glActiveTexture(33988);
                    GLES20.glBindTexture(3553, H[0]);
                    GLES20.glUniform1i(I, 4);
                }
                c_();
                GLES20.glDrawArrays(5, 0, 4);
                GLES20.glDisableVertexAttribArray(aw);
                GLES20.glDisableVertexAttribArray(ay);
                GLES20.glBindTexture(3553, 0);
                return;
            }
        }
    }

    public void c()
    {
        f();
        GLES20.glDeleteProgram(d);
        if (z != com.cyberlink.clgpuimage.TableMode.a)
        {
            GLES20.glDeleteTextures(H.length, H, 0);
        }
        super.c();
    }

    protected void c_()
    {
    }

    protected void d()
    {
    }


    private class TableMode extends Enum
    {

        public static final TableMode a;
        public static final TableMode b;
        public static final TableMode c;
        private static final TableMode d[];

        public static TableMode valueOf(String s1)
        {
            return (TableMode)Enum.valueOf(com/cyberlink/clgpuimage/CLBeautyFilterBasicWithTwoPassBlendSource2$TableMode, s1);
        }

        public static TableMode[] values()
        {
            return (TableMode[])d.clone();
        }

        static 
        {
            a = new TableMode("TABLE_NONE", 0);
            b = new TableMode("TABLE_3D", 1);
            c = new TableMode("TABLE_1D", 2);
            d = (new TableMode[] {
                a, b, c
            });
        }

        private TableMode(String s1, int i1)
        {
            super(s1, i1);
        }
    }

}
