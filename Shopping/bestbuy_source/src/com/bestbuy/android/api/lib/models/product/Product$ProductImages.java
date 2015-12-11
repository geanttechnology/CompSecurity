// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.product;

import java.io.Serializable;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class carrierLogoImage
    implements Serializable
{

    private static final long serialVersionUID = 1L;
    private String accessoriesImage;
    private String alternateViewsImage;
    private String angleImage;
    private String backViewImage;
    private String carrierLogoImage;
    private String energyGuideImage;
    private ArrayList galleryImages;
    private String image;
    private String largeFrontImage;
    private String largeImage;
    private String leftViewImage;
    private String mediumImage;
    private String primaryImage;
    private String remoteControlImage;
    private String rightViewImage;
    private String spin360Url;
    private String thumbnailImage;
    private String topViewImage;

    public static carrierLogoImage loadCBAPIImageData(JSONObject jsonobject)
    {
        carrierLogoImage carrierlogoimage;
label0:
        {
label1:
            {
                carrierlogoimage = new <init>();
                if (jsonobject == null)
                {
                    break label0;
                }
                JSONObject jsonobject1 = jsonobject.optJSONObject("primaryImage");
                if (jsonobject1 != null)
                {
                    carrierlogoimage.primaryImage = jsonobject1.optString("url", "");
                }
                jsonobject1 = jsonobject.optJSONObject("energyGuideImage");
                if (jsonobject1 != null)
                {
                    carrierlogoimage.energyGuideImage = jsonobject1.optString("url", "");
                }
                jsonobject1 = jsonobject.optJSONObject("backImage");
                if (jsonobject1 != null)
                {
                    carrierlogoimage.backViewImage = jsonobject1.optString("url", "");
                }
                JSONArray jsonarray = jsonobject.optJSONArray("galleryImages");
                carrierlogoimage.galleryImages = new ArrayList();
                if (jsonarray == null)
                {
                    break label1;
                }
                for (int i = 0; i < jsonarray.length(); i++)
                {
                    String s;
label2:
                    {
                        JSONObject jsonobject3 = jsonarray.optJSONObject(i);
                        String s1 = jsonobject3.optString("url", "");
                        if (s1 != null)
                        {
                            s = s1;
                            if (!s1.isEmpty())
                            {
                                break label2;
                            }
                        }
                        s1 = jsonobject3.optString("height", "");
                        s = s1;
                        if (Integer.parseInt(s1) > 500)
                        {
                            s = "500";
                        }
                        String s2 = jsonobject3.optString("width", "");
                        s1 = s2;
                        if (Integer.parseInt(s2) > 500)
                        {
                            s1 = "500";
                        }
                        s = (new StringBuilder()).append("http://pisces.bbystatic.com/image2/").append(jsonobject3.optString("path", "")).append(";canvasHeight=").append(s).append(";canvasWidth=").append(s1).toString();
                    }
                    carrierlogoimage.galleryImages.add(s);
                }

            }
            JSONObject jsonobject2 = jsonobject.optJSONObject("alternateLogoImage");
            if (jsonobject2 != null)
            {
                carrierlogoimage.alternateViewsImage = jsonobject2.optString("url", "");
            }
            jsonobject = jsonobject.optJSONObject("carrierLogoImage");
            if (jsonobject != null)
            {
                carrierlogoimage.carrierLogoImage = jsonobject.optString("url", "");
            }
        }
        return carrierlogoimage;
    }

    public static carrierLogoImage loadImageData(JSONObject jsonobject)
    {
        carrierLogoImage carrierlogoimage = new <init>();
        carrierlogoimage.image = jsonobject.optString("image");
        carrierlogoimage.thumbnailImage = jsonobject.optString("thumbnailImage");
        carrierlogoimage.largeImage = jsonobject.optString("largeImage");
        carrierlogoimage.mediumImage = jsonobject.optString("mediumImage");
        carrierlogoimage.largeFrontImage = jsonobject.optString("largeFrontImage");
        carrierlogoimage.topViewImage = jsonobject.optString("topViewImage");
        carrierlogoimage.rightViewImage = jsonobject.optString("rightViewImage");
        carrierlogoimage.leftViewImage = jsonobject.optString("leftViewImage");
        carrierlogoimage.backViewImage = jsonobject.optString("backViewImage");
        carrierlogoimage.angleImage = jsonobject.optString("angleImage");
        carrierlogoimage.alternateViewsImage = jsonobject.optString("alternateViewsImage");
        carrierlogoimage.accessoriesImage = jsonobject.optString("accessoriesImage");
        carrierlogoimage.energyGuideImage = jsonobject.optString("energyGuideImage");
        carrierlogoimage.remoteControlImage = jsonobject.optString("remoteControlImage");
        carrierlogoimage.spin360Url = jsonobject.optString("spin360Url");
        return carrierlogoimage;
    }

    public static spin360Url loadPandaAPIImageData(JSONObject jsonobject)
    {
        spin360Url spin360url = new <init>();
        if (jsonobject == null)
        {
            break MISSING_BLOCK_LABEL_58;
        }
        JSONObject jsonobject1;
        try
        {
            jsonobject1 = jsonobject.optJSONObject("primaryImage");
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            jsonobject.printStackTrace();
            return spin360url;
        }
        if (jsonobject1 == null)
        {
            break MISSING_BLOCK_LABEL_35;
        }
        spin360url.primaryImage = jsonobject1.optString("url", "");
        jsonobject = jsonobject.optJSONObject("listImage");
        if (jsonobject == null)
        {
            break MISSING_BLOCK_LABEL_58;
        }
        spin360url.thumbnailImage = jsonobject.optString("url", "");
        return spin360url;
    }

    public String getAccessoriesImage()
    {
        return accessoriesImage;
    }

    public String getAlternateViewsImage()
    {
        return alternateViewsImage;
    }

    public String getAngleImage()
    {
        return angleImage;
    }

    public String getBackViewImage()
    {
        return backViewImage;
    }

    public String getCarrierLogoImage()
    {
        return carrierLogoImage;
    }

    public String getEnergyGuideImage()
    {
        return energyGuideImage;
    }

    public ArrayList getGalleryImages()
    {
        return galleryImages;
    }

    public String getImage()
    {
        return image;
    }

    public String getLargeFrontImage()
    {
        return largeFrontImage;
    }

    public String getLargeImage()
    {
        return largeImage;
    }

    public String getLeftViewImage()
    {
        return leftViewImage;
    }

    public String getMediumImage()
    {
        return mediumImage;
    }

    public String getPrimaryImage()
    {
        return primaryImage;
    }

    public String getRemoteControlImage()
    {
        return remoteControlImage;
    }

    public String getRightViewImage()
    {
        return rightViewImage;
    }

    public String getSpin360Url()
    {
        return spin360Url;
    }

    public String getThumbnailImage()
    {
        return thumbnailImage;
    }

    public String getTopViewImage()
    {
        return topViewImage;
    }


/*
    static String access$302( , String s)
    {
        .image = s;
        return s;
    }

*/


/*
    static String access$402(image image1, String s)
    {
        image1.primaryImage = s;
        return s;
    }

*/

    public primaryImage()
    {
        image = "";
        thumbnailImage = "";
        largeImage = "";
        mediumImage = "";
        largeFrontImage = "";
        topViewImage = "";
        rightViewImage = "";
        leftViewImage = "";
        backViewImage = "";
        angleImage = "";
        alternateViewsImage = "";
        accessoriesImage = "";
        energyGuideImage = "";
        remoteControlImage = "";
        spin360Url = "";
        primaryImage = "";
        carrierLogoImage = "";
    }
}
