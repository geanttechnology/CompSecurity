// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Matrix;
import android.opengl.GLES20;
import com.fotoable.fotoproedit.activity.mosaic.MosaicGLSurfaceView;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public class aky
{

    float a[] = {
        -1F, -1F, 1.0F, -1F, -1F, 1.0F, 1.0F, 1.0F
    };
    float b[] = {
        0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F
    };
    float c[];
    public int d;
    private final String e = "attribute vec4 vPosition;attribute vec2 inputTextureCoordinate;varying vec2 textureCoordinate;void main(){gl_Position = vPosition;textureCoordinate = inputTextureCoordinate;}";
    private final String f = "precision mediump float;varying vec2 textureCoordinate;\nuniform sampler2D s_texture;\nuniform int flag;\nvoid main() {vec2 tc = textureCoordinate; tc.y = 1.0 - tc.y;  gl_FragColor = texture2D( s_texture, tc);\n}";
    private FloatBuffer g;
    private FloatBuffer h;
    private int i;
    private int j;
    private final int k = 8;
    private Matrix l;
    private int m;
    private int n;
    private int o;

    public aky()
    {
        c = new float[8];
        n = MosaicGLSurfaceView.loadShader(35633, "attribute vec4 vPosition;attribute vec2 inputTextureCoordinate;varying vec2 textureCoordinate;void main(){gl_Position = vPosition;textureCoordinate = inputTextureCoordinate;}");
        o = MosaicGLSurfaceView.loadShader(35632, "precision mediump float;varying vec2 textureCoordinate;\nuniform sampler2D s_texture;\nuniform int flag;\nvoid main() {vec2 tc = textureCoordinate; tc.y = 1.0 - tc.y;  gl_FragColor = texture2D( s_texture, tc);\n}");
        m = GLES20.glCreateProgram();
        GLES20.glAttachShader(m, n);
        GLES20.glAttachShader(m, o);
        GLES20.glLinkProgram(m);
    }

    public void a()
    {
        GLES20.glDeleteShader(n);
        GLES20.glDeleteShader(o);
        GLES20.glDeleteProgram(m);
    }

    public void a(Matrix matrix)
    {
        l = matrix;
    }

    public void a(float af[])
    {
        a = af;
    }

    public void b()
    {
        GLES20.glUseProgram(m);
        l.mapPoints(c, a);
        ByteBuffer bytebuffer = ByteBuffer.allocateDirect(c.length * 4);
        bytebuffer.order(ByteOrder.nativeOrder());
        g = bytebuffer.asFloatBuffer();
        g.put(c);
        g.position(0);
        bytebuffer = ByteBuffer.allocateDirect(b.length * 4);
        bytebuffer.order(ByteOrder.nativeOrder());
        h = bytebuffer.asFloatBuffer();
        h.put(b);
        h.position(0);
        i = GLES20.glGetAttribLocation(m, "vPosition");
        GLES20.glEnableVertexAttribArray(i);
        GLES20.glVertexAttribPointer(i, 2, 5126, false, 8, g);
        j = GLES20.glGetAttribLocation(m, "inputTextureCoordinate");
        GLES20.glEnableVertexAttribArray(j);
        GLES20.glVertexAttribPointer(j, 2, 5126, false, 8, h);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, d);
        GLES20.glUniform1i(GLES20.glGetAttribLocation(m, "s_texture"), 0);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisableVertexAttribArray(i);
        GLES20.glDisableVertexAttribArray(j);
    }
}
