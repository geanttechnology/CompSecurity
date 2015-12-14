// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.clgpuimage;

import android.graphics.PointF;
import android.graphics.Rect;
import android.opengl.GLES20;
import java.nio.FloatBuffer;

// Referenced classes of package com.cyberlink.clgpuimage:
//            CLMakeupLiveEyeFilter, h, b, d, 
//            e, f, g

public class c extends CLMakeupLiveEyeFilter
{

    private int aE;
    private int aF;
    private int aG;
    private int aH;

    public c(boolean flag)
    {
        super(flag, b.a(h.a()), (new StringBuilder()).append(b.a(d.a())).append(b.a(com.cyberlink.clgpuimage.e.a())).toString());
    }

    public void a()
    {
        super.a();
        aE = GLES20.glGetUniformLocation(l(), "oriented_target_eye_left_right_corner_to_top_center_square");
        aF = GLES20.glGetUniformLocation(l(), "actual_top_left_right_parabolic");
        aG = GLES20.glGetUniformLocation(l(), "oriented_target_eye_left_right_corner_to_bottom_center_square");
        aH = GLES20.glGetUniformLocation(l(), "actual_bottom_left_right_parabolic");
    }

    protected void e()
    {
        int i;
        int j = 33985;
        int k;
        int j1;
        int k1;
        if (d != -1)
        {
            GLES20.glActiveTexture(33985);
            GLES20.glBindTexture(3553, d);
            GLES20.glUniform1i(e, 1);
            j = 33986;
            j1 = 2;
        } else
        {
            j1 = 1;
        }
        k = j1;
        i = j;
        if (this.i != -1)
        {
            GLES20.glActiveTexture(j);
            GLES20.glBindTexture(3553, this.i);
            GLES20.glUniform1i(this.j, j1);
            k = j1 + 1;
            i = j + 1;
        }
        j = k;
        j1 = i;
        if (o != -1)
        {
            GLES20.glActiveTexture(i);
            GLES20.glBindTexture(3553, o);
            GLES20.glUniform1i(p, k);
            j = k + 1;
            j1 = i + 1;
        }
        k1 = 0;
        i = j;
        j = j1;
        while (k1 < 2) 
        {
            float f1;
            float f2;
            float f3;
            float f4;
            float f5;
            float f6;
            float f7;
            float f8;
            Object obj1;
            Exception exception1;
            PointF pointf;
            int i1;
            if (A[k1] != -1)
            {
                GLES20.glActiveTexture(j);
                GLES20.glBindTexture(3553, A[k1]);
                int l = B[k1];
                j1 = i + 1;
                GLES20.glUniform1i(l, i);
                i = j + 1;
            } else
            {
                j1 = i;
                i = j;
            }
            j = j1;
            i1 = i;
            if (D[k1] != -1)
            {
                GLES20.glActiveTexture(i);
                GLES20.glBindTexture(3553, D[k1]);
                GLES20.glUniform1i(E[k1], j1);
                j = j1 + 1;
                i1 = i + 1;
            }
            k1++;
            i = j;
            j = i1;
        }
        synchronized (al)
        {
            f1 = am.m_environment_darkest_reference_normalized_luma;
            f2 = am.m_environment_brightest_reference_normalized_luma;
            ag = f2;
            ah = f2 - f1;
            h[0] = (f2 - f1) * g[0] + f1;
            h[1] = (f2 - f1) * g[1] + f1;
            h[2] = (f2 - f1) * g[2] + f1;
            n[0] = (f2 - f1) * m[0] + f1;
            n[1] = (f2 - f1) * m[1] + f1;
            n[2] = f1 + (f2 - f1) * m[2];
        }
        GLES20.glUniform3fv(f, 1, FloatBuffer.wrap(h));
        GLES20.glUniform3fv(this.l, 1, FloatBuffer.wrap(n));
        GLES20.glUniform1f(aj, ag);
        GLES20.glUniform1f(ak, ah);
        i = ao;
        if (an)
        {
            f1 = 0.0F;
        } else
        {
            f1 = 1.0F;
        }
        GLES20.glUniform1f(i, f1);
        obj = al;
        obj;
        JVM INSTR monitorenter ;
        b.clear();
        b.put(a(au, am.m_rotation));
        b.position(0);
        GLES20.glVertexAttribPointer(a, 2, 5126, false, 0, b);
        GLES20.glEnableVertexAttribArray(a);
        i = 0;
_L2:
        if (i >= 4)
        {
            break; /* Loop/switch isn't completed */
        }
        s[i].x = t[i].x / (float)u;
        s[i].y = t[i].y / (float)v;
        i++;
        if (true) goto _L2; else goto _L1
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
_L1:
        GLES20.glUniform2f(as, am.m_analyzing_frame_width, am.m_analyzing_frame_height);
        if (u * am.m_analyzing_frame_height <= 0 || v * am.m_analyzing_frame_width <= 0) goto _L4; else goto _L3
_L3:
        f1 = (float)(v * am.m_analyzing_frame_width) / (float)(u * am.m_analyzing_frame_height);
          goto _L5
_L7:
        if (i >= 4)
        {
            break MISSING_BLOCK_LABEL_794;
        }
        obj1 = s[i];
        obj1.y = ((PointF) (obj1)).y * f1;
        i++;
        continue; /* Loop/switch isn't completed */
        GLES20.glUniform1f(L, 1.0F / f1);
        f2 = (s[2].x - s[0].x) / (am.m_oriented_eye_points[2].x - am.m_oriented_eye_points[0].x);
        f3 = Math.max(0.0F, Math.min(1.0F, (((1.0F / f2) * (float)u) / (float)w - 0.35F) / 0.3F));
        GLES20.glUniform1f(ai, f3);
        obj1 = new Rect();
        ((Rect) (obj1)).union(F);
        ((Rect) (obj1)).union(G);
        ((Rect) (obj1)).union(H);
        pointf = new PointF(t[1].x, t[0].y);
        ap[0] = (pointf.x - (float)((Rect) (obj1)).left) / (pointf.x - t[0].x);
        ap[1] = (pointf.y - (float)((Rect) (obj1)).top) / (pointf.y - t[1].y);
        ap[2] = ((float)((Rect) (obj1)).right - pointf.x) / (t[2].x - pointf.x);
        ap[3] = ((float)((Rect) (obj1)).bottom - pointf.y) / (t[3].y - pointf.y);
        f3 = Math.min(Math.max(am.m_oriented_eye_centers[0].x, am.m_oriented_eye_centers[1].x) + ap[0] * (am.m_oriented_eye_points[0].x - Math.max(am.m_oriented_eye_centers[0].x, am.m_oriented_eye_centers[1].x)), am.m_oriented_eye_centers[0].x - (s[1].x - (float)((Rect) (obj1)).left / (float)u) / f2);
        f4 = Math.max(Math.min(am.m_oriented_eye_centers[0].x, am.m_oriented_eye_centers[1].x) + ap[2] * (am.m_oriented_eye_points[2].x - Math.min(am.m_oriented_eye_centers[0].x, am.m_oriented_eye_centers[1].x)), am.m_oriented_eye_centers[0].x + ((float)(((Rect) (obj1)).right / u) - s[1].x) / f2);
        f1 = Math.min(am.m_oriented_eye_centers[0].y + ap[1] * (am.m_oriented_eye_points[1].y - am.m_oriented_eye_centers[0].y), am.m_oriented_eye_centers[0].y - (s[0].y - f1 * ((float)((Rect) (obj1)).top / (float)v)) / f2);
        f5 = am.m_oriented_eye_centers[1].y;
        f6 = ap[3];
        f7 = am.m_oriented_eye_points[3].y;
        f8 = am.m_oriented_eye_centers[1].y;
        GLES20.glUniform4f(aq, f3, f4, f1, f5 + f6 * (f7 - f8));
        GLES20.glUniform1f(M, am.m_target_eye_lower_lid_luma);
        f1 = Math.max(1.0F, Math.min(5F, ((float)Math.pow(Math.max(0.0F, (0.5F - am.m_target_eye_lower_lid_luma) / 0.5F), 0.25D) + 1.0F) * (0.5F / Math.max(am.m_target_eye_lower_lid_luma, 0.001F))));
        GLES20.glUniform1f(ar, f1);
        GLES20.glUniform2f(N, am.m_target_level_orientation_cos, am.m_target_level_orientation_sin);
        GLES20.glUniform2f(O, am.m_oriented_eye_centers[0].x, am.m_oriented_eye_centers[0].y);
        GLES20.glUniform2f(P, am.m_oriented_eye_centers[1].x, am.m_oriented_eye_centers[1].y);
        GLES20.glUniform2f(Q, am.m_oriented_eye_points[0].x, am.m_oriented_eye_points[0].y);
        GLES20.glUniform2f(R, s[0].x - am.m_oriented_eye_points[0].x, s[0].y - am.m_oriented_eye_points[0].y);
        GLES20.glUniform1f(S, f2);
        GLES20.glUniform4f(T, am.m_parabolic_polar_transform_top_left_src_center.x, am.m_parabolic_polar_transform_top_left_src_center.y, am.m_parabolic_polar_transform_top_left_dst_center.x, am.m_parabolic_polar_transform_top_left_dst_center.y);
        GLES20.glUniform4f(U, am.m_parabolic_polar_transform_top_left_src_aligned_coeff[0], am.m_parabolic_polar_transform_top_left_src_aligned_coeff[1], am.m_parabolic_polar_transform_top_left_dst_aligned_coeff[0], am.m_parabolic_polar_transform_top_left_dst_aligned_coeff[1]);
        GLES20.glUniform4f(V, am.m_parabolic_polar_transform_top_right_src_aligned_coeff[0], am.m_parabolic_polar_transform_top_right_src_aligned_coeff[1], am.m_parabolic_polar_transform_top_right_dst_aligned_coeff[0], am.m_parabolic_polar_transform_top_right_dst_aligned_coeff[1]);
        GLES20.glUniform4f(W, am.m_parabolic_polar_transform_bottom_left_src_center.x, am.m_parabolic_polar_transform_bottom_left_src_center.y, am.m_parabolic_polar_transform_bottom_left_dst_center.x, am.m_parabolic_polar_transform_bottom_left_dst_center.y);
        GLES20.glUniform4f(X, am.m_parabolic_polar_transform_bottom_left_src_aligned_coeff[0], am.m_parabolic_polar_transform_bottom_left_src_aligned_coeff[1], am.m_parabolic_polar_transform_bottom_left_dst_aligned_coeff[0], am.m_parabolic_polar_transform_bottom_left_dst_aligned_coeff[1]);
        GLES20.glUniform4f(Y, am.m_parabolic_polar_transform_bottom_right_src_aligned_coeff[0], am.m_parabolic_polar_transform_bottom_right_src_aligned_coeff[1], am.m_parabolic_polar_transform_bottom_right_dst_aligned_coeff[0], am.m_parabolic_polar_transform_bottom_right_dst_aligned_coeff[1]);
        GLES20.glUniform2f(Z, am.m_environment_darkest_reference_normalized_luma, am.m_environment_brightest_reference_normalized_luma);
        f1 = Math.max(0.2F, Math.min(1.0F, ((am.m_parabolic_polar_transform_top_left_src_aligned_coeff[1] * f2) / am.m_parabolic_polar_transform_top_left_dst_aligned_coeff[1]) * 1.2F));
        GLES20.glUniform1f(at, f1);
        f3 = am.m_oriented_eye_centers[0].x - am.m_oriented_eye_points[0].x;
        f2 = am.m_oriented_eye_points[2].x - am.m_oriented_eye_centers[0].x;
        GLES20.glUniform2f(aE, f3 * f3, f2 * f2);
        f1 = am.m_parabolic_polar_transform_top_left_src_aligned_coeff[1] * Math.min(1.0F, am.m_ratio_of_actual_upper_lid_height_to_limited_height);
        f3 = (-1F * f1) / (f3 * f3);
        f2 = (-1F * f1) / (f2 * f2);
        GLES20.glUniform3f(aF, f3, f1, f2);
        f3 = am.m_oriented_eye_centers[1].x - am.m_oriented_eye_points[0].x;
        f2 = am.m_oriented_eye_points[2].x - am.m_oriented_eye_centers[1].x;
        GLES20.glUniform2f(aG, f3 * f3, f2 * f2);
        f1 = am.m_parabolic_polar_transform_bottom_left_src_aligned_coeff[1] * Math.min(1.0F, am.m_ratio_of_actual_lower_lid_height_to_limited_height);
        f3 = (-1F * f1) / (f3 * f3);
        f2 = (-1F * f1) / (f2 * f2);
        GLES20.glUniform3f(aH, f3, f1, f2);
        obj;
        JVM INSTR monitorexit ;
        return;
        exception1;
        obj;
        JVM INSTR monitorexit ;
        throw exception1;
_L4:
        f1 = 1.0F;
_L5:
        i = 0;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public void f()
    {
        a(b.a(h.a()), (new StringBuilder()).append(b.a(com.cyberlink.clgpuimage.f.a())).append(b.a(g.a())).toString());
    }
}
