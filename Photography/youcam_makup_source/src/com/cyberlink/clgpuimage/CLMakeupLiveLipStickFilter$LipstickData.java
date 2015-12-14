// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.clgpuimage;


public class m_level_map
{

    public int m_background_image_height;
    public int m_background_image_width;
    public byte m_blend_weight[];
    public float m_environment_brightest_reference_normalized_luma;
    public float m_environment_darkest_reference_normalized_luma;
    public int m_force_bright_threshold;
    public float m_gloss_contrast_scale;
    public int m_gloss_contrast_shift;
    public boolean m_is_flipped;
    public byte m_level_map[];
    public int m_mask_height;
    public int m_mask_width;
    public byte m_mouth_mask_data[];
    public byte m_reflection_data[];
    public int m_roi_height;
    public int m_roi_width;
    public int m_roi_x;
    public int m_roi_y;
    public int m_rotation;

    public void AllocByteArray(int i, int j)
    {
        if (m_mask_width != i || m_mask_height != j)
        {
            m_mask_width = i;
            m_mask_height = j;
            m_mouth_mask_data = new byte[i * j];
            m_reflection_data = new byte[i * j];
        }
    }

    public void Copy(m_reflection_data m_reflection_data1)
    {
        if (m_reflection_data1.m_mask_width != 0 && m_reflection_data1.m_mask_height != 0)
        {
            m_mouth_mask_data = (byte[])m_reflection_data1.m_mouth_mask_data.clone();
            m_reflection_data = (byte[])m_reflection_data1.m_reflection_data.clone();
        }
        m_mask_width = m_reflection_data1.m_mask_width;
        m_mask_height = m_reflection_data1.m_mask_height;
        m_roi_x = m_reflection_data1.m_roi_x;
        m_roi_y = m_reflection_data1.m_roi_y;
        m_roi_width = m_reflection_data1.m_roi_width;
        m_roi_height = m_reflection_data1.m_roi_height;
        m_background_image_width = m_reflection_data1.m_background_image_width;
        m_background_image_height = m_reflection_data1.m_background_image_height;
        m_gloss_contrast_scale = m_reflection_data1.m_gloss_contrast_scale;
        m_gloss_contrast_shift = m_reflection_data1.m_gloss_contrast_shift;
        m_force_bright_threshold = m_reflection_data1.m_force_bright_threshold;
        m_blend_weight = (byte[])m_reflection_data1.m_blend_weight.clone();
        m_level_map = (byte[])m_reflection_data1.m_level_map.clone();
        m_environment_darkest_reference_normalized_luma = m_reflection_data1.m_environment_darkest_reference_normalized_luma;
        m_environment_brightest_reference_normalized_luma = m_reflection_data1.m_environment_brightest_reference_normalized_luma;
        m_rotation = m_reflection_data1.m_rotation;
        m_is_flipped = m_reflection_data1.m_is_flipped;
    }

    public ()
    {
        m_blend_weight = new byte[256];
        m_level_map = new byte[256];
    }
}
