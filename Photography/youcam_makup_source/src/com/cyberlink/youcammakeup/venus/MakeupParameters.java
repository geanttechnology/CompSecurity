// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.venus;

import android.graphics.PointF;

// Referenced classes of package com.cyberlink.youcammakeup.venus:
//            CommonShare

public class MakeupParameters
{

    public int anti_shine_intensity;
    public PointF basic_eye_points[];
    public PointF basic_eyebrow_points[];
    public int double_eyelids_color;
    public int double_eyelids_intensity;
    public String double_eyelids_model_path;
    public PointF double_eyelids_model_points[];
    public boolean enable_anti_shine;
    public boolean enable_auto_spot_removal;
    public boolean enable_double_eyelids;
    public boolean enable_eyebrow;
    public boolean enable_eyebrow_tattoo;
    public boolean enable_eyelash;
    public boolean enable_eyeliner;
    public boolean enable_eyeshadow;
    public boolean enable_face_contour;
    public boolean enable_face_tattoo;
    public boolean enable_lipstick;
    public boolean enable_nose_enhancement;
    public boolean enable_skin_smooth;
    public boolean enable_skin_whitening;
    public String eyebrow_binary_mask_path;
    public int eyebrow_color;
    public int eyebrow_color_index;
    public int eyebrow_hidden_intensity;
    public int eyebrow_intensity;
    public int eyebrow_model_index;
    public String eyebrow_model_path;
    public PointF eyebrow_model_points[];
    public int eyebrow_tattoo_intensity[];
    public String eyebrow_tattoo_model_path[];
    public PointF eyebrow_tattoo_points[][];
    public int eyebrow_thickness;
    public int eyelash_color;
    public int eyelash_intensity;
    public int eyelash_model_count;
    public String eyelash_model_path;
    public PointF eyelash_model_points[];
    public int eyeliner_color;
    public int eyeliner_intensity;
    public int eyeliner_model_count;
    public String eyeliner_model_path;
    public PointF eyeliner_model_points[];
    public int eyeshadow_color;
    public int eyeshadow_intensity;
    public int eyeshadow_model_count;
    public String eyeshadow_model_path;
    public PointF eyeshadow_model_points[];
    public int face_contour_intensity;
    public String face_tattoo_model_path;
    public boolean is_mouth_open;
    public int lipstick_color;
    public int lipstick_intensity;
    public int lipstick_level_default;
    public int lipstick_level_max;
    public int lipstick_type;
    protected String model_dir;
    public int nose_enhancement_intensity;
    public int skin_smooth_intensity;
    public int skin_whitening_intensity;

    public MakeupParameters()
    {
        model_dir = (new StringBuilder()).append(CommonShare.openTempFolder()).append("/FaceBeautify").toString();
        enable_auto_spot_removal = false;
        enable_anti_shine = false;
        anti_shine_intensity = 35;
        enable_skin_smooth = false;
        skin_smooth_intensity = 35;
        enable_face_contour = false;
        face_contour_intensity = 35;
        enable_skin_whitening = false;
        skin_whitening_intensity = 35;
        enable_nose_enhancement = false;
        nose_enhancement_intensity = 50;
        enable_eyebrow = false;
        eyebrow_model_index = 0;
        eyebrow_model_path = (new StringBuilder()).append(model_dir).append("/eyebrow_model.png").toString();
        eyebrow_binary_mask_path = (new StringBuilder()).append(model_dir).append("/eyebrow_model_mask.png").toString();
        eyebrow_model_points = new PointF[3];
        basic_eyebrow_points = new PointF[3];
        basic_eye_points = new PointF[3];
        eyebrow_intensity = 50;
        eyebrow_color_index = 0;
        eyebrow_color = 0;
        eyebrow_thickness = 50;
        eyebrow_hidden_intensity = 0;
        enable_eyeshadow = false;
        eyeshadow_model_path = (new StringBuilder()).append(model_dir).append("/eyeshadow_model.png").toString();
        eyeshadow_model_points = new PointF[4];
        eyeshadow_model_count = 0;
        eyeshadow_intensity = 0;
        eyeshadow_color = 0;
        enable_double_eyelids = false;
        double_eyelids_model_path = (new StringBuilder()).append(model_dir).append("/double_eyelids_model.png").toString();
        double_eyelids_model_points = new PointF[4];
        double_eyelids_intensity = 0;
        double_eyelids_color = 0;
        enable_eyeliner = false;
        eyeliner_model_path = (new StringBuilder()).append(model_dir).append("/eyeliner_model.png").toString();
        eyeliner_model_points = new PointF[4];
        eyeliner_model_count = 0;
        eyeliner_intensity = 0;
        eyeliner_color = 0;
        enable_eyelash = false;
        eyelash_model_path = (new StringBuilder()).append(model_dir).append("/eyelash_model.png").toString();
        eyelash_model_points = new PointF[4];
        eyelash_model_count = 0;
        eyelash_intensity = 0;
        eyelash_color = 0;
        enable_lipstick = false;
        lipstick_type = 0;
        lipstick_color = 0;
        lipstick_level_max = 100;
        lipstick_level_default = 50;
        is_mouth_open = false;
        lipstick_intensity = 50;
        enable_eyebrow_tattoo = false;
        eyebrow_tattoo_model_path = (new String[] {
            (new StringBuilder()).append(model_dir).append("/eyebrow_tattoo_model_left.png").toString(), (new StringBuilder()).append(model_dir).append("/eyebrow_tattoo_model_right.png").toString()
        });
        eyebrow_tattoo_points = new PointF[2][];
        eyebrow_tattoo_intensity = new int[2];
        enable_face_tattoo = false;
        face_tattoo_model_path = (new StringBuilder()).append(model_dir).append("/face_tattoo_model.png").toString();
        for (int i = 0; i < 3; i++)
        {
            eyebrow_model_points[i] = new PointF();
            basic_eyebrow_points[i] = new PointF();
            basic_eye_points[i] = new PointF();
        }

        for (int j = 0; j < 4; j++)
        {
            eyeshadow_model_points[j] = new PointF();
            eyeliner_model_points[j] = new PointF();
            eyelash_model_points[j] = new PointF();
            double_eyelids_model_points[j] = new PointF();
        }

        for (int k = 0; k < 2; k++)
        {
            eyebrow_tattoo_points[k] = new PointF[3];
            for (int l = 0; l < 3; l++)
            {
                eyebrow_tattoo_points[k][l] = new PointF();
            }

        }

    }
}
