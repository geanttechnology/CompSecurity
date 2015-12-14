// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.clgpuimage;

import android.graphics.PointF;

// Referenced classes of package com.cyberlink.clgpuimage:
//            a, CLMakeupLiveBlushFilter

public class m_right_blush_roi
{

    public PointF m_center;
    public float m_cos_val;
    public float m_environment_brightest_reference_normalized_luma;
    public float m_environment_darkest_reference_normalized_luma;
    public boolean m_is_flipped;
    public a m_left_blush_roi;
    public a m_right_blush_roi;
    public int m_rotation;
    public float m_sin_val;

    public void ComputeData(PointF pointf, PointF pointf1, PointF pointf2, PointF pointf3, PointF pointf4, PointF pointf5, PointF pointf6, 
            PointF pointf7, PointF pointf8, PointF pointf9)
    {
        double d = Math.atan2(pointf9.y - pointf4.y, pointf9.x - pointf4.x);
        m_cos_val = (float)Math.cos(-d);
        m_sin_val = (float)Math.sin(-d);
        m_center.x = (pointf1.x + pointf6.x) * 0.5F;
        m_center.y = (pointf1.y + pointf6.y) * 0.5F;
        m_left_blush_roi.c();
        m_left_blush_roi.a(CLMakeupLiveBlushFilter.a(m_cos_val, m_sin_val, m_center, pointf));
        m_left_blush_roi.a(CLMakeupLiveBlushFilter.a(m_cos_val, m_sin_val, m_center, pointf1));
        m_left_blush_roi.a(CLMakeupLiveBlushFilter.a(m_cos_val, m_sin_val, m_center, pointf2));
        m_left_blush_roi.a(CLMakeupLiveBlushFilter.a(m_cos_val, m_sin_val, m_center, pointf3));
        m_left_blush_roi.a(CLMakeupLiveBlushFilter.a(m_cos_val, m_sin_val, m_center, pointf4));
        m_right_blush_roi.c();
        m_right_blush_roi.a(CLMakeupLiveBlushFilter.a(m_cos_val, m_sin_val, m_center, pointf5));
        m_right_blush_roi.a(CLMakeupLiveBlushFilter.a(m_cos_val, m_sin_val, m_center, pointf6));
        m_right_blush_roi.a(CLMakeupLiveBlushFilter.a(m_cos_val, m_sin_val, m_center, pointf7));
        m_right_blush_roi.a(CLMakeupLiveBlushFilter.a(m_cos_val, m_sin_val, m_center, pointf8));
        m_right_blush_roi.a(CLMakeupLiveBlushFilter.a(m_cos_val, m_sin_val, m_center, pointf9));
    }

    public void Copy(m_center m_center1)
    {
        m_cos_val = m_center1.m_cos_val;
        m_sin_val = m_center1.m_sin_val;
        m_center.x = m_center1.m_center.x;
        m_center.y = m_center1.m_center.y;
        m_left_blush_roi.a = m_center1.m_left_blush_roi.a;
        m_left_blush_roi.c = m_center1.m_left_blush_roi.c;
        m_left_blush_roi.b = m_center1.m_left_blush_roi.b;
        m_left_blush_roi.d = m_center1.m_left_blush_roi.d;
        m_right_blush_roi.a = m_center1.m_right_blush_roi.a;
        m_right_blush_roi.c = m_center1.m_right_blush_roi.c;
        m_right_blush_roi.b = m_center1.m_right_blush_roi.b;
        m_right_blush_roi.d = m_center1.m_right_blush_roi.d;
        m_environment_darkest_reference_normalized_luma = m_center1.m_environment_darkest_reference_normalized_luma;
        m_environment_brightest_reference_normalized_luma = m_center1.m_environment_brightest_reference_normalized_luma;
        m_rotation = m_center1.m_rotation;
        m_is_flipped = m_center1.m_is_flipped;
    }

    public void SetBlushFeaturePts(PointF pointf, PointF pointf1, PointF pointf2, PointF pointf3, PointF pointf4, PointF pointf5, PointF pointf6, 
            PointF pointf7, PointF pointf8, PointF pointf9)
    {
        ComputeData(CLMakeupLiveBlushFilter.a(pointf), CLMakeupLiveBlushFilter.a(pointf1), CLMakeupLiveBlushFilter.a(pointf2), CLMakeupLiveBlushFilter.a(pointf3), CLMakeupLiveBlushFilter.a(pointf4), CLMakeupLiveBlushFilter.a(pointf5), CLMakeupLiveBlushFilter.a(pointf6), CLMakeupLiveBlushFilter.a(pointf7), CLMakeupLiveBlushFilter.a(pointf8), CLMakeupLiveBlushFilter.a(pointf9));
    }

    public ()
    {
        m_center = new PointF();
        m_left_blush_roi = new a();
        m_right_blush_roi = new a();
    }
}
