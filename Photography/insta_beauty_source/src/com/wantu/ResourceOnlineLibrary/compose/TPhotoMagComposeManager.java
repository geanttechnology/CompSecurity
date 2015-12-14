// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.ResourceOnlineLibrary.compose;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.RectF;
import android.util.Log;
import aqx;
import axw;
import bde;
import bdg;
import bgd;
import bgv;
import bhd;
import bhe;
import bhf;
import bhg;
import bhh;
import bhi;
import bhj;
import bhk;
import bio;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.instabeauty.application.InstaBeautyApplication;
import com.instamag.activity.library.model.TResTypeManager;
import com.instamag.common.CollageType;
import com.wantu.ResourceOnlineLibrary.EOnlineResType;
import com.wantu.ResourceOnlineLibrary.FileManager;
import com.wantu.activity.link.model.TPhotoLinkComposeInfo;
import com.wantu.model.res.EResType;
import com.wantu.model.res.TResInfo;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.wantu.ResourceOnlineLibrary.compose:
//            TPhotoComposeInfo, TPhotoMaskInfo, TDecorateInfo, InstaMagType

public class TPhotoMagComposeManager extends bgv
{

    public static String MagCommonlyUsedInfoItems = "MagCommonlyUsedInfoItems";
    public static String MagDeleteAndHideResIds = "MagDeleteAndHideResIds";
    public static String TAG = "TPhotoMagComposeManager";
    public static int UITextAlignmentCenter = 17;
    public static int UITextAlignmentLeft = 3;
    public static int UITextAlignmentRight = 5;
    List _commonlyUsedItems;
    List _linkstyleInfoArray;
    public List _styleInfoArray;
    public boolean isNeedSaveToFile;

    public TPhotoMagComposeManager()
    {
        boolean flag1;
        flag1 = true;
        super();
        _styleInfoArray = new ArrayList();
        _linkstyleInfoArray = new ArrayList();
        _commonlyUsedItems = new ArrayList();
        isNeedSaveToFile = false;
        unarchive();
        preInstall();
        deleteOldLocalRes();
        if (aqx.a(InstaBeautyApplication.a, "TphotoMagComposeManager", "addNewLocalInfo", false)) goto _L2; else goto _L1
_L1:
        List list;
        list = getNewLocalAddedInfo();
        Log.v("newlocaladdinfos", (new StringBuilder()).append("size").append(list.size()).toString());
        if (list == null || list.size() <= 0) goto _L2; else goto _L3
_L3:
        boolean flag;
        for (int i = 0; i < list.size(); i++)
        {
            addAndReplace((TPhotoComposeInfo)list.get(i));
        }

        aqx.b(InstaBeautyApplication.a, "TphotoMagComposeManager", "addNewLocalInfo", true);
        flag = true;
_L5:
        if (isShouldInitTypeIds())
        {
            initLocalInfosType();
            flag = true;
        }
        if (TResTypeManager.instance().needUpdate)
        {
            updateAllComposeInfosType();
            TResTypeManager.instance().needUpdate = false;
            flag = flag1;
        }
        if (flag)
        {
            asynArchive();
        }
        return;
_L2:
        flag = false;
        if (true) goto _L5; else goto _L4
_L4:
    }

    private RectF CGRectMake(float f, float f1, float f2, float f3)
    {
        return new RectF(f, f1, f2 + f, f3 + f1);
    }

    private void deleteOldLocalRes()
    {
        if (!aqx.a(InstaBeautyApplication.a, (new StringBuilder()).append(TAG).append("_delete").toString(), true)) goto _L2; else goto _L1
_L1:
        String as[];
        int i;
        aqx.b(InstaBeautyApplication.a, (new StringBuilder()).append(TAG).append("_delete").toString(), false);
        as = "18,7,30,31,8,9,11,12,13,14,15,16,19,20,22,23,24,25,37,32,33,26,27,28,29,35,34,36,38,39,40,101,104,102,100,103,105,154,155,158,163,168,169,173,180,186,201,203,213,215,225,229,247,254,255,266,280,281,307,308,331,332,357,377,382,390,397,406,407,408,409,412,413,414,420,421,423,424,426,427,431,432,433,434,435,442,446,448,451,453,454,455,457,459,463,464,467,469,470,471,473,474,475,476,482,483,484,485,486,487,492,494,496,497,498,499,500,501,502,503,504,505,506,507,509,510,511,512,513,514,515,516,518,519,520,521,522,523,524,525,526,527,529,530,535,536,537,538,540,541,542,543,545,546,547,553,554,557,558,559,560,561,562,563,565,567,568,569,570,571,573,575,576,577,578,579,580,581,582,583,584,585,586,587,588,589,590,591,592,593,594,595,604,605,606,607,609,610,611,612,613,614,616,617,622,623,624,626,628,629,630,631,634,635,636,638,639,640,641,642,643,644,645,646,632".split(",");
        i = 0;
_L4:
        if (i < as.length)
        {
            int k = Integer.parseInt(as[i]);
            int j = 0;
            do
            {
label0:
                {
                    if (j < _styleInfoArray.size())
                    {
                        TPhotoComposeInfo tphotocomposeinfo = (TPhotoComposeInfo)_styleInfoArray.get(j);
                        if (tphotocomposeinfo.resId != k)
                        {
                            break label0;
                        }
                        _styleInfoArray.remove(tphotocomposeinfo);
                    }
                    i++;
                    continue; /* Loop/switch isn't completed */
                }
                j++;
            } while (true);
        }
_L2:
        return;
        if (true) goto _L4; else goto _L3
_L3:
    }

    private List getAllCommonlyUsedInfos()
    {
        ArrayList arraylist = new ArrayList();
        String s = getDeleteAndHideInfoIds();
        if (_commonlyUsedItems != null && _commonlyUsedItems.size() > 0)
        {
            for (int i = 0; i < _commonlyUsedItems.size(); i++)
            {
                TPhotoComposeInfo tphotocomposeinfo = getComposeInfoByResId(((bde)_commonlyUsedItems.get(i)).a);
                if (tphotocomposeinfo != null && !s.contains(tphotocomposeinfo.getDeleteTag()))
                {
                    arraylist.add(tphotocomposeinfo);
                }
            }

        }
        return arraylist;
    }

    private boolean isValidate(TPhotoComposeInfo tphotocomposeinfo)
    {
        boolean flag = true;
        if (tphotocomposeinfo == null)
        {
            return false;
        }
        if (tphotocomposeinfo.icon == null || tphotocomposeinfo.icon.length() == 0 || tphotocomposeinfo.resId == 0 || tphotocomposeinfo.imageCount == 0)
        {
            flag = false;
        }
        return flag;
    }

    private void preInstallLandTemplate()
    {
        TPhotoComposeInfo tphotocomposeinfo = new TPhotoComposeInfo();
        tphotocomposeinfo.resId = 35;
        tphotocomposeinfo.backgroundColor = -1;
        tphotocomposeinfo.icon = "MRes/im_land_8/im_land_8_sm.jpg";
        tphotocomposeinfo.name = "InstaMag";
        tphotocomposeinfo.imageCount = 3;
        tphotocomposeinfo.typeId = TResTypeManager.KRES_SIMPLE;
        tphotocomposeinfo.price = 0;
        tphotocomposeinfo.previewUrl = "";
        tphotocomposeinfo.width = 320F;
        tphotocomposeinfo.height = 214F;
        tphotocomposeinfo.isHFlip = true;
        tphotocomposeinfo.isVFlip = true;
        ArrayList arraylist = new ArrayList();
        Object obj = new TPhotoMaskInfo();
        obj.backgroundFrame = CGRectMake(0.0F, 0.0F, 320F, 214F);
        obj.innerFrame = CGRectMake(0.0F, 0.0F, 320F, 214F);
        obj.foregroundColor = Color.argb(127, 255, 255, 255);
        obj.foregroundFrame = CGRectMake(0.0F, 209F, 320F, 3F);
        arraylist.add(obj);
        obj = new TPhotoMaskInfo();
        obj.backgroundFrame = CGRectMake(230F, 7F, 83F, 83F);
        obj.innerFrame = CGRectMake(4F, 4F, 75F, 75F);
        obj.backgroundColor = -1;
        obj.isBackgroundShadow = true;
        arraylist.add(obj);
        obj = new TPhotoMaskInfo();
        obj.backgroundFrame = CGRectMake(230F, 97F, 83F, 73F);
        obj.innerFrame = CGRectMake(4F, 4F, 75F, 65F);
        obj.backgroundColor = -1;
        obj.isBackgroundShadow = true;
        arraylist.add(obj);
        tphotocomposeinfo.photoMaskInfoArray = arraylist;
        arraylist = new ArrayList();
        obj = new TDecorateInfo();
        obj.frame = CGRectMake(5F, 10F, 162.5F, 43.5F);
        obj.type = 1;
        obj.imagePath = "MRes/im_land_8/im_land_8_dec1.png";
        obj.movable = false;
        obj.editable = false;
        arraylist.add(obj);
        obj = new TDecorateInfo();
        obj.frame = CGRectMake(230F, 174F, 82F, 13.5F);
        obj.type = 1;
        obj.imagePath = "MRes/im_land_8/im_land_8_dec2.png";
        obj.movable = false;
        obj.editable = false;
        arraylist.add(obj);
        tphotocomposeinfo.decorateInfoArray = arraylist;
        addAndReplace(tphotocomposeinfo);
        tphotocomposeinfo = new TPhotoComposeInfo();
        tphotocomposeinfo.resId = 34;
        tphotocomposeinfo.backgroundColor = 0xff000000;
        tphotocomposeinfo.icon = "MRes/im_land_2/im_land_2_sm.jpg";
        tphotocomposeinfo.name = "Flowers";
        tphotocomposeinfo.imageCount = 4;
        tphotocomposeinfo.typeId = TResTypeManager.KRES_SIMPLE;
        tphotocomposeinfo.price = 0;
        tphotocomposeinfo.previewUrl = "";
        tphotocomposeinfo.width = 320F;
        tphotocomposeinfo.height = 214F;
        tphotocomposeinfo.isHFlip = true;
        tphotocomposeinfo.isVFlip = true;
        arraylist = new ArrayList();
        obj = new TPhotoMaskInfo();
        obj.backgroundFrame = CGRectMake(180F, 7F, 133F, 86F);
        obj.innerFrame = CGRectMake(0.0F, 0.0F, 133F, 86F);
        arraylist.add(obj);
        obj = new TPhotoMaskInfo();
        obj.backgroundFrame = CGRectMake(8F, 116F, 140F, 82F);
        obj.innerFrame = CGRectMake(0.0F, 0.0F, 140F, 82F);
        arraylist.add(obj);
        obj = new TPhotoMaskInfo();
        obj.backgroundFrame = CGRectMake(155F, 100F, 158F, 98F);
        obj.innerFrame = CGRectMake(0.0F, 0.0F, 158F, 98F);
        arraylist.add(obj);
        obj = new TPhotoMaskInfo();
        obj.backgroundFrame = CGRectMake(0.0F, 0.0F, 182F, 115F);
        obj.innerFrame = CGRectMake(8F, 7F, 167F, 102F);
        obj.backgroundColor = 0xff000000;
        arraylist.add(obj);
        tphotocomposeinfo.photoMaskInfoArray = arraylist;
        arraylist = new ArrayList();
        obj = new TDecorateInfo();
        obj.frame = CGRectMake(6F, 199F, 57F, 14F);
        obj.rotation = 0.0F;
        obj.type = 1;
        obj.imagePath = "MRes/common/icon_logo_white.png";
        obj.movable = true;
        arraylist.add(obj);
        obj = new TDecorateInfo();
        obj.frame = CGRectMake(254F, 200F, 60F, 13F);
        obj.rotation = 0.0F;
        obj.type = 8;
        obj.movable = false;
        obj.editable = true;
        obj.text = "";
        obj.textColor = -1;
        obj.textAlignment = UITextAlignmentRight;
        obj.fontMaxCount = 18;
        obj.fontSize = 10;
        obj.isBold = false;
        obj.isShadow = false;
        arraylist.add(obj);
        tphotocomposeinfo.decorateInfoArray = arraylist;
        addAndReplace(tphotocomposeinfo);
        tphotocomposeinfo = new TPhotoComposeInfo();
        tphotocomposeinfo.resId = 36;
        tphotocomposeinfo.backgoundImagePath = "MRes/im_land_10/im_land_10_bg.jpg";
        tphotocomposeinfo.icon = "MRes/im_land_10/im_land_10_sm.png";
        tphotocomposeinfo.name = "Bali";
        tphotocomposeinfo.imageCount = 3;
        tphotocomposeinfo.typeId = TResTypeManager.KRES_SIMPLE;
        tphotocomposeinfo.width = 320F;
        tphotocomposeinfo.height = 214F;
        tphotocomposeinfo.isHFlip = true;
        tphotocomposeinfo.isVFlip = true;
        arraylist = new ArrayList();
        obj = new TPhotoMaskInfo();
        obj.backgroundFrame = CGRectMake(0.0F, 0.0F, 320F, 142F);
        obj.innerFrame = CGRectMake(0.0F, 0.0F, 320F, 142F);
        arraylist.add(obj);
        obj = new TPhotoMaskInfo();
        obj.backgroundFrame = CGRectMake(3F, 103F, 107F, 107F);
        obj.innerFrame = CGRectMake(3F, 3F, 101F, 101F);
        obj.backgroundColor = 0xff000000;
        arraylist.add(obj);
        obj = new TPhotoMaskInfo();
        obj.backgroundFrame = CGRectMake(210F, 103F, 107F, 107F);
        obj.innerFrame = CGRectMake(3F, 3F, 101F, 101F);
        obj.backgroundColor = 0xff000000;
        arraylist.add(obj);
        tphotocomposeinfo.photoMaskInfoArray = arraylist;
        arraylist = new ArrayList();
        obj = new TDecorateInfo();
        obj.frame = CGRectMake(152F, 146F, 55F, 14F);
        obj.rotation = 0.0F;
        obj.type = 1;
        obj.imagePath = "MRes/instamag_style_4//d1.png";
        obj.movable = false;
        arraylist.add(obj);
        obj = new TDecorateInfo();
        obj.frame = CGRectMake(112F, 155F, 96F, 25F);
        obj.rotation = 0.0F;
        obj.type = 9;
        obj.movable = false;
        obj.editable = true;
        obj.text = "Bali";
        obj.textColor = -1;
        obj.textAlignment = UITextAlignmentRight;
        obj.fontMaxCount = 30;
        obj.fontSize = 18;
        obj.isBold = true;
        obj.isShadow = false;
        arraylist.add(obj);
        obj = new TDecorateInfo();
        obj.frame = CGRectMake(112F, 178F, 96F, 20F);
        obj.rotation = 0.0F;
        obj.type = 10;
        obj.movable = false;
        obj.editable = true;
        obj.text = "Indonesia";
        obj.textColor = -1;
        obj.textAlignment = UITextAlignmentRight;
        obj.fontMaxCount = 30;
        obj.fontSize = 14;
        obj.isBold = true;
        obj.isShadow = false;
        arraylist.add(obj);
        obj = new TDecorateInfo();
        obj.frame = CGRectMake(112F, 196F, 96F, 18F);
        obj.rotation = 0.0F;
        obj.type = 8;
        obj.movable = false;
        obj.editable = true;
        obj.text = "";
        obj.textColor = -1;
        obj.textAlignment = UITextAlignmentRight;
        obj.fontMaxCount = 18;
        obj.fontSize = 10;
        obj.isBold = false;
        obj.isShadow = false;
        arraylist.add(obj);
        tphotocomposeinfo.decorateInfoArray = arraylist;
        addAndReplace(tphotocomposeinfo);
        tphotocomposeinfo = new TPhotoComposeInfo();
        tphotocomposeinfo.resId = 38;
        tphotocomposeinfo.backgoundImagePath = "MRes/im_land_11/im_land_11_bg.jpg";
        tphotocomposeinfo.icon = "MRes/im_land_11/im_land_11_sm.png";
        tphotocomposeinfo.name = "Clear";
        tphotocomposeinfo.imageCount = 4;
        tphotocomposeinfo.typeId = TResTypeManager.KRES_SIMPLE;
        tphotocomposeinfo.price = 0;
        tphotocomposeinfo.previewUrl = "";
        tphotocomposeinfo.width = 320F;
        tphotocomposeinfo.height = 214F;
        tphotocomposeinfo.isHFlip = false;
        tphotocomposeinfo.isVFlip = true;
        arraylist = new ArrayList();
        obj = new TPhotoMaskInfo();
        obj.backgroundFrame = CGRectMake(10F, 83F, 106F, 120F);
        obj.innerFrame = CGRectMake(0.0F, 0.0F, 106F, 120F);
        arraylist.add(obj);
        obj = new TPhotoMaskInfo();
        obj.backgroundFrame = CGRectMake(120F, 34F, 80F, 83F);
        obj.innerFrame = CGRectMake(0.0F, 0.0F, 80F, 83F);
        arraylist.add(obj);
        obj = new TPhotoMaskInfo();
        obj.backgroundFrame = CGRectMake(120F, 120F, 80F, 83F);
        obj.innerFrame = CGRectMake(0.0F, 0.0F, 80F, 83F);
        arraylist.add(obj);
        obj = new TPhotoMaskInfo();
        obj.backgroundFrame = CGRectMake(204F, 83F, 106F, 120F);
        obj.innerFrame = CGRectMake(0.0F, 0.0F, 106F, 120F);
        arraylist.add(obj);
        tphotocomposeinfo.photoMaskInfoArray = arraylist;
        arraylist = new ArrayList();
        obj = new TDecorateInfo();
        obj.frame = CGRectMake(10F, 12F, 180F, 21F);
        obj.rotation = 0.0F;
        obj.type = 5;
        obj.movable = true;
        obj.editable = true;
        obj.text = "San Francisco";
        obj.textColor = Color.argb(255, 134, 101, 84);
        obj.textAlignment = UITextAlignmentLeft;
        obj.fontMaxCount = 30;
        obj.fontSize = 16;
        obj.isBold = false;
        obj.isShadow = false;
        arraylist.add(obj);
        obj = new TDecorateInfo();
        obj.frame = CGRectMake(232F, 1.0F, 80F, 14F);
        obj.rotation = 0.0F;
        obj.type = 8;
        obj.movable = false;
        obj.editable = false;
        obj.text = "";
        obj.textColor = 0xff888888;
        obj.textAlignment = UITextAlignmentRight;
        obj.fontMaxCount = 20;
        obj.fontSize = 8;
        obj.isBold = false;
        obj.isShadow = false;
        arraylist.add(obj);
        tphotocomposeinfo.decorateInfoArray = arraylist;
        addAndReplace(tphotocomposeinfo);
        tphotocomposeinfo = new TPhotoComposeInfo();
        tphotocomposeinfo.resId = 39;
        tphotocomposeinfo.backgroundColor = 0xff000000;
        tphotocomposeinfo.icon = "MRes/im_land_12/im_land_12_sm.png";
        tphotocomposeinfo.name = "Soul In Travel";
        tphotocomposeinfo.imageCount = 4;
        tphotocomposeinfo.typeId = TResTypeManager.KRES_SIMPLE;
        tphotocomposeinfo.price = 0;
        tphotocomposeinfo.previewUrl = "";
        tphotocomposeinfo.width = 320F;
        tphotocomposeinfo.height = 214F;
        tphotocomposeinfo.isHFlip = true;
        tphotocomposeinfo.isVFlip = true;
        arraylist = new ArrayList();
        obj = new TPhotoMaskInfo();
        obj.backgroundFrame = CGRectMake(0.0F, 0.0F, 223F, 214F);
        obj.innerFrame = CGRectMake(0.0F, 0.0F, 223F, 214F);
        arraylist.add(obj);
        obj = new TPhotoMaskInfo();
        obj.backgroundFrame = CGRectMake(227F, 0.0F, 93F, 105F);
        obj.innerFrame = CGRectMake(0.0F, 0.0F, 93F, 105F);
        obj.backgroundColor = 0;
        arraylist.add(obj);
        obj = new TPhotoMaskInfo();
        obj.backgroundFrame = CGRectMake(227F, 109F, 93F, 115F);
        obj.innerFrame = CGRectMake(0.0F, 0.0F, 93F, 115F);
        obj.backgroundColor = 0;
        arraylist.add(obj);
        obj = new TPhotoMaskInfo();
        obj.backgroundFrame = CGRectMake(6F, 6F, 75F, 94F);
        obj.innerFrame = CGRectMake(4F, 4F, 67F, 86F);
        obj.backgroundColor = -1;
        arraylist.add(obj);
        tphotocomposeinfo.photoMaskInfoArray = arraylist;
        arraylist = new ArrayList();
        obj = new TDecorateInfo();
        obj.frame = CGRectMake(6F, 172F, 190F, 36F);
        obj.rotation = 0.0F;
        obj.type = 2;
        obj.movable = true;
        obj.editable = true;
        obj.backgroundColor = 0;
        obj.text = "Soul in Travel";
        obj.textColor = -1;
        obj.textAlignment = UITextAlignmentLeft;
        obj.fontMaxCount = 30;
        obj.fontSize = 32;
        obj.isBold = true;
        obj.isShadow = true;
        arraylist.add(obj);
        obj = new TDecorateInfo();
        obj.frame = CGRectMake(86F, 5F, 105F, 30F);
        obj.rotation = 0.0F;
        obj.type = 9;
        obj.movable = true;
        obj.editable = true;
        obj.text = "Angkor Wat";
        obj.textColor = -1;
        obj.textAlignment = UITextAlignmentLeft;
        obj.fontMaxCount = 30;
        obj.fontSize = 22;
        obj.isBold = true;
        obj.isShadow = true;
        arraylist.add(obj);
        obj = new TDecorateInfo();
        obj.frame = CGRectMake(86F, 27F, 105F, 25F);
        obj.rotation = 0.0F;
        obj.type = 10;
        obj.movable = true;
        obj.editable = true;
        obj.text = "Cambodia";
        obj.textColor = -1;
        obj.textAlignment = UITextAlignmentLeft;
        obj.fontMaxCount = 30;
        obj.fontSize = 16;
        obj.isBold = false;
        obj.isShadow = true;
        arraylist.add(obj);
        obj = new TDecorateInfo();
        obj.frame = CGRectMake(6F, 104F, 66F, 16F);
        obj.rotation = 0.0F;
        obj.type = 1;
        obj.imagePath = "MRes/common/icon_logo_white.png";
        obj.movable = true;
        arraylist.add(obj);
        tphotocomposeinfo.decorateInfoArray = arraylist;
        addAndReplace(tphotocomposeinfo);
        tphotocomposeinfo = new TPhotoComposeInfo();
        tphotocomposeinfo.resId = 40;
        tphotocomposeinfo.backgoundImagePath = "MRes/gw_land_12/bg.jpg";
        tphotocomposeinfo.icon = "MRes/gw_land_12/12_gw_land_sm.jpg";
        tphotocomposeinfo.name = "Photos Wall";
        tphotocomposeinfo.imageCount = 4;
        tphotocomposeinfo.typeId = TResTypeManager.KRES_OBJECTS;
        tphotocomposeinfo.price = 0;
        tphotocomposeinfo.previewUrl = "";
        tphotocomposeinfo.width = 320F;
        tphotocomposeinfo.height = 214F;
        tphotocomposeinfo.isHFlip = true;
        tphotocomposeinfo.isVFlip = false;
        arraylist = new ArrayList();
        obj = new TPhotoMaskInfo();
        obj.backgroundFrame = CGRectMake(11F, 11F, 84.5F, 84.5F);
        obj.innerFrame = CGRectMake(17F, 16F, 50F, 51F);
        obj.backgroundImagePath = "MRes/gw_land_12/fb01.png";
        arraylist.add(obj);
        obj = new TPhotoMaskInfo();
        obj.backgroundFrame = CGRectMake(100F, 60F, 113.5F, 113.5F);
        obj.innerFrame = CGRectMake(21F, 21F, 71F, 70F);
        obj.backgroundImagePath = "MRes/gw_land_12/fb02.png";
        arraylist.add(obj);
        obj = new TPhotoMaskInfo();
        obj.backgroundFrame = CGRectMake(220F, 28F, 76F, 75F);
        obj.innerFrame = CGRectMake(15F, 14F, 45F, 46F);
        obj.backgroundImagePath = "MRes/gw_land_12/fb03.png";
        arraylist.add(obj);
        obj = new TPhotoMaskInfo();
        obj.backgroundFrame = CGRectMake(220F, 113F, 89F, 89F);
        obj.innerFrame = CGRectMake(17F, 17F, 55F, 55F);
        obj.backgroundImagePath = "MRes/gw_land_12/fb04.png";
        arraylist.add(obj);
        tphotocomposeinfo.photoMaskInfoArray = arraylist;
        tphotocomposeinfo.decorateInfoArray = new ArrayList();
        addAndReplace(tphotocomposeinfo);
    }

    private void removeByResId(int i)
    {
        List list = _styleInfoArray;
        list;
        JVM INSTR monitorenter ;
        if (_styleInfoArray == null || _styleInfoArray.size() <= 0) goto _L2; else goto _L1
_L1:
        int j = 0;
_L7:
        if (j >= _styleInfoArray.size()) goto _L2; else goto _L3
_L3:
        TPhotoComposeInfo tphotocomposeinfo = (TPhotoComposeInfo)_styleInfoArray.get(j);
        if (tphotocomposeinfo.resId != i) goto _L5; else goto _L4
_L4:
        _styleInfoArray.remove(tphotocomposeinfo);
_L2:
        list;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        list;
        JVM INSTR monitorexit ;
        throw exception;
_L5:
        j++;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public List AllInfos()
    {
        ArrayList arraylist = new ArrayList();
        if (_styleInfoArray.size() == 0)
        {
            preInstall();
        }
        for (Iterator iterator = _styleInfoArray.iterator(); iterator.hasNext(); arraylist.add((TPhotoComposeInfo)iterator.next())) { }
        for (Iterator iterator1 = _linkstyleInfoArray.iterator(); iterator1.hasNext(); arraylist.add((TPhotoComposeInfo)iterator1.next())) { }
        return arraylist;
    }

    public void MagInfoDownloadFinished(TPhotoComposeInfo tphotocomposeinfo)
    {
        if (tphotocomposeinfo != null)
        {
            String s = getDeleteAndHideInfoIds();
            if (s.contains(tphotocomposeinfo.getDeleteTag()))
            {
                s = s.replace(tphotocomposeinfo.getDeleteTag(), ",");
                if (s != null)
                {
                    aqx.a(InstaBeautyApplication.a, TAG, MagDeleteAndHideResIds, s);
                }
            }
            tphotocomposeinfo.setResType(EResType.NETWORK);
            if (isExistedByResId(tphotocomposeinfo.resId))
            {
                removeByResId(tphotocomposeinfo.resId);
            }
            if (isValidate(tphotocomposeinfo))
            {
                addFront(tphotocomposeinfo);
                Intent intent = new Intent("ACTION_MATERIAL_ADDED");
                intent.putExtra("TYPE_MATERIAL", bgv.getStringByResType(EOnlineResType.MAG_MASK_INFO));
                intent.putExtra("INSTAMAG_TYPE", TPhotoComposeInfo.getInstaMagType(tphotocomposeinfo).ordinal());
                intent.putExtra("INSTAMAG_RESID", tphotocomposeinfo.resId);
                intent.putExtra("INSTAMAG_IMAGE_COUNT", tphotocomposeinfo.imageCount);
                InstaBeautyApplication.a.sendBroadcast(intent);
                return;
            }
        }
    }

    public void add(TPhotoComposeInfo tphotocomposeinfo)
    {
        synchronized (_styleInfoArray)
        {
            _styleInfoArray.add(tphotocomposeinfo);
        }
        return;
        tphotocomposeinfo;
        list;
        JVM INSTR monitorexit ;
        throw tphotocomposeinfo;
    }

    public void addAndReplace(TPhotoComposeInfo tphotocomposeinfo)
    {
        if (tphotocomposeinfo == null)
        {
            return;
        }
        if (!isExistedByResId(tphotocomposeinfo.resId))
        {
            _styleInfoArray.add(tphotocomposeinfo);
            return;
        } else
        {
            replace(tphotocomposeinfo);
            return;
        }
    }

    public void addFront(TPhotoComposeInfo tphotocomposeinfo)
    {
        synchronized (_styleInfoArray)
        {
            _styleInfoArray.add(0, tphotocomposeinfo);
        }
        return;
        tphotocomposeinfo;
        list;
        JVM INSTR monitorexit ;
        throw tphotocomposeinfo;
    }

    public void addInfoToCommonlyUsed(TPhotoComposeInfo tphotocomposeinfo)
    {
        Iterator iterator;
        boolean flag;
        flag = false;
        iterator = _commonlyUsedItems.iterator();
_L4:
        if (!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        bde bde1 = (bde)iterator.next();
        if (bde1.a != tphotocomposeinfo.resId) goto _L4; else goto _L3
_L3:
        int i = bde1.b;
_L8:
        if (bde1 != null)
        {
            _commonlyUsedItems.remove(bde1);
        }
        _commonlyUsedItems.add(0, new bde(tphotocomposeinfo.resId, i + 1));
        Collections.sort(_commonlyUsedItems, new bhj(this));
        if (_commonlyUsedItems == null || _commonlyUsedItems.size() <= 0)
        {
            break MISSING_BLOCK_LABEL_227;
        }
        JSONObject jsonobject;
        try
        {
            tphotocomposeinfo = new JSONArray();
        }
        // Misplaced declaration of an exception variable
        catch (TPhotoComposeInfo tphotocomposeinfo)
        {
            return;
        }
        i = ((flag) ? 1 : 0);
_L6:
        if (i >= _commonlyUsedItems.size())
        {
            break; /* Loop/switch isn't completed */
        }
        bde1 = (bde)_commonlyUsedItems.get(i);
        jsonobject = new JSONObject();
        jsonobject.put("infoResId", bde1.a);
        jsonobject.put("usedCount", bde1.b);
        tphotocomposeinfo.put(jsonobject);
        i++;
        if (true) goto _L6; else goto _L5
_L5:
        aqx.a(InstaBeautyApplication.a, TAG, MagCommonlyUsedInfoItems, tphotocomposeinfo.toString());
        return;
_L2:
        bde1 = null;
        i = 0;
        if (true) goto _L8; else goto _L7
_L7:
    }

    public List allItem()
    {
        if (_styleInfoArray.size() == 0)
        {
            preInstall();
        }
        return _styleInfoArray;
    }

    public void asynArchive()
    {
        isNeedSaveToFile = false;
        bhk;
        JVM INSTR monitorenter ;
        (new bhk(this, new ArrayList(_styleInfoArray))).execute(new Void[0]);
        bhk;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        bhk;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public boolean checkResInfoNameWithTypeId(String s, int i)
    {
        return s.contains(String.format(",%d", new Object[] {
            Integer.valueOf(i)
        }));
    }

    public void deleteInfo(TResInfo tresinfo)
    {
        int i = 0;
        do
        {
label0:
            {
                if (i < _styleInfoArray.size())
                {
                    Object obj = (TPhotoComposeInfo)_styleInfoArray.get(i);
                    if (((TPhotoComposeInfo) (obj)).getResType() != EResType.NETWORK || tresinfo.resId != ((TPhotoComposeInfo) (obj)).resId)
                    {
                        break label0;
                    }
                    _styleInfoArray.remove(obj);
                    deleteResByInfo((TPhotoComposeInfo)tresinfo);
                    obj = new Intent("ACTION_MATERIAL_REMOVE");
                    ((Intent) (obj)).putExtra("TYPE_MATERIAL", bgv.getStringByResType(EOnlineResType.MAG_MASK_INFO));
                    ((Intent) (obj)).putExtra("INSTAMAG_RESID", tresinfo.resId);
                    InstaBeautyApplication.a().b().sendBroadcast(((Intent) (obj)));
                }
                return;
            }
            i++;
        } while (true);
    }

    public void deleteResByInfo(TPhotoComposeInfo tphotocomposeinfo)
    {
        boolean flag = false;
        if (tphotocomposeinfo.getResType() != EResType.NETWORK) goto _L2; else goto _L1
_L1:
        String s = FileManager.getInstance().getInstaMagFileCache().a();
        if (tphotocomposeinfo.folderName == null || tphotocomposeinfo.folderName.length() <= 0) goto _L4; else goto _L3
_L3:
        tphotocomposeinfo = new File((new StringBuilder()).append(s).append("/").append(tphotocomposeinfo.folderName).toString());
        if (tphotocomposeinfo.exists())
        {
            axw.a(tphotocomposeinfo);
        }
_L2:
        return;
_L4:
        int i = tphotocomposeinfo.icon.lastIndexOf("/");
        String s1 = tphotocomposeinfo.icon.substring(i + 1);
        FileManager.getInstance().deleteOnlineBitmapRes(EOnlineResType.MAG_MASK_INFO, s1);
        if (tphotocomposeinfo.photoMaskInfoArray != null && tphotocomposeinfo.photoMaskInfoArray.size() > 0)
        {
            for (int j = 0; j < tphotocomposeinfo.photoMaskInfoArray.size(); j++)
            {
                ((TPhotoMaskInfo)tphotocomposeinfo.photoMaskInfoArray.get(j)).deleteFromCache();
            }

        }
        if (tphotocomposeinfo.decorateInfoArray != null && tphotocomposeinfo.decorateInfoArray.size() > 0)
        {
            int k = ((flag) ? 1 : 0);
            while (k < tphotocomposeinfo.decorateInfoArray.size()) 
            {
                ((TDecorateInfo)tphotocomposeinfo.decorateInfoArray.get(k)).deleteFromCache();
                k++;
            }
        }
        if (true) goto _L2; else goto _L5
_L5:
    }

    public List getAllLinkComposeInfo()
    {
        if (_linkstyleInfoArray.size() != 0);
        return _linkstyleInfoArray;
    }

    public List getAllOnlineInfos()
    {
        String s = getDeleteAndHideInfoIds();
        ArrayList arraylist = new ArrayList();
        for (int i = 0; i < _styleInfoArray.size(); i++)
        {
            TPhotoComposeInfo tphotocomposeinfo = (TPhotoComposeInfo)_styleInfoArray.get(i);
            if ((tphotocomposeinfo.isOnline || tphotocomposeinfo.getResType() == EResType.NETWORK) && !s.contains(tphotocomposeinfo.getDeleteTag()))
            {
                arraylist.add(tphotocomposeinfo);
            }
        }

        return arraylist;
    }

    public List getCommonlyUsedInfos()
    {
        ArrayList arraylist = new ArrayList();
        List list = getAllCommonlyUsedInfos();
        if (list.size() > 0)
        {
            for (int i = 0; i < list.size(); i++)
            {
                arraylist.add((TPhotoComposeInfo)list.get(i));
            }

        }
        return arraylist;
    }

    public List getCommonlyUsedInfos(int i)
    {
        ArrayList arraylist = new ArrayList();
        List list = getCommonlyUsedInfos();
        if (list.size() > 0)
        {
            for (int j = 0; j < list.size(); j++)
            {
                TPhotoComposeInfo tphotocomposeinfo = (TPhotoComposeInfo)list.get(j);
                if (tphotocomposeinfo.imageCount == i)
                {
                    arraylist.add(tphotocomposeinfo);
                }
            }

        }
        return arraylist;
    }

    public List getCommonlyUsedInfosByCollageType(CollageType collagetype)
    {
        collagetype = new ArrayList();
        List list = getAllCommonlyUsedInfos();
        if (list.size() > 0)
        {
            for (int i = 0; i < list.size(); i++)
            {
                collagetype.add((TPhotoComposeInfo)list.get(i));
            }

        }
        return collagetype;
    }

    public List getCommonlyUsedInfosByCollageTypeResType(CollageType collagetype, bdg bdg1)
    {
        ArrayList arraylist = new ArrayList();
        collagetype = getCommonlyUsedInfosByCollageType(collagetype);
        if (collagetype.size() > 0)
        {
            for (int i = 0; i < collagetype.size(); i++)
            {
                TPhotoComposeInfo tphotocomposeinfo = (TPhotoComposeInfo)collagetype.get(i);
                if (tphotocomposeinfo.typeId == bdg1.a)
                {
                    arraylist.add(tphotocomposeinfo);
                }
            }

        }
        return arraylist;
    }

    public List getCommonlyUsedInfosByCollageTypeResTypeMagType(CollageType collagetype, bdg bdg1, InstaMagType instamagtype)
    {
        ArrayList arraylist = new ArrayList();
        collagetype = getCommonlyUsedInfosByCollageTypeResType(collagetype, bdg1);
        if (collagetype.size() > 0)
        {
            for (int i = 0; i < collagetype.size(); i++)
            {
                bdg1 = (TPhotoComposeInfo)collagetype.get(i);
                if (TPhotoComposeInfo.getInstaMagType(bdg1) == instamagtype)
                {
                    arraylist.add(bdg1);
                }
            }

        }
        return arraylist;
    }

    public TPhotoComposeInfo getComposeInfoByResId(int i)
    {
        if (_styleInfoArray != null && _styleInfoArray.size() > 0)
        {
            for (int j = 0; j < _styleInfoArray.size(); j++)
            {
                TPhotoComposeInfo tphotocomposeinfo = (TPhotoComposeInfo)_styleInfoArray.get(j);
                if (tphotocomposeinfo.resId == i || tphotocomposeinfo.rid == i)
                {
                    return tphotocomposeinfo;
                }
            }

        }
        return null;
    }

    public String getDeleteAndHideInfoIds()
    {
        String s1 = aqx.b(InstaBeautyApplication.a, TAG, MagDeleteAndHideResIds);
        String s = s1;
        if (s1 == null)
        {
            s = ",";
        }
        return s;
    }

    public List getDownloadedComposeInfos(CollageType collagetype)
    {
        collagetype = getDeleteAndHideInfoIds();
        ArrayList arraylist = new ArrayList();
        for (int i = 0; i < _styleInfoArray.size(); i++)
        {
            TPhotoComposeInfo tphotocomposeinfo = (TPhotoComposeInfo)_styleInfoArray.get(i);
            if ((tphotocomposeinfo.isOnline || tphotocomposeinfo.getResType() == EResType.NETWORK) && !collagetype.contains(tphotocomposeinfo.getDeleteTag()))
            {
                arraylist.add(tphotocomposeinfo);
            }
        }

        Collections.sort(arraylist, new bhg(this));
        return arraylist;
    }

    public List getInfoTypesByImageCount(int i)
    {
        boolean flag = false;
        ArrayList arraylist = new ArrayList();
        ArrayList arraylist1 = new ArrayList();
        String s = getDeleteAndHideInfoIds();
        for (int j = 0; j < _styleInfoArray.size(); j++)
        {
            TPhotoComposeInfo tphotocomposeinfo = (TPhotoComposeInfo)_styleInfoArray.get(j);
            if (tphotocomposeinfo.imageCount != i || s.contains(tphotocomposeinfo.getDeleteTag()))
            {
                continue;
            }
            if (tphotocomposeinfo.typeId == 0)
            {
                tphotocomposeinfo.typeId = TResTypeManager.KRES_OTHERTYPE;
            }
            if (!arraylist1.contains(Integer.valueOf(tphotocomposeinfo.typeId)))
            {
                arraylist1.add(Integer.valueOf(tphotocomposeinfo.typeId));
            }
        }

        if (arraylist1 != null && arraylist1.size() > 0)
        {
            Collections.sort(arraylist1, new bhi(this));
            for (i = ((flag) ? 1 : 0); i < arraylist1.size(); i++)
            {
                Object obj = (Integer)arraylist1.get(i);
                obj = TResTypeManager.instance().getResTypeById(((Integer) (obj)).intValue());
                if (obj != null && !arraylist.contains(obj))
                {
                    arraylist.add(obj);
                }
            }

        }
        return arraylist;
    }

    public List getInfoTypesSortByInfos(List list)
    {
        boolean flag = false;
        ArrayList arraylist = new ArrayList();
        ArrayList arraylist1 = new ArrayList();
        int i = 0;
        while (i < list.size()) 
        {
            TPhotoComposeInfo tphotocomposeinfo = (TPhotoComposeInfo)list.get(i);
            if (!(tphotocomposeinfo instanceof TPhotoLinkComposeInfo))
            {
                if (tphotocomposeinfo.typeId == 0)
                {
                    tphotocomposeinfo.typeId = TResTypeManager.KRES_OTHERTYPE;
                }
                if (!arraylist1.contains(Integer.valueOf(tphotocomposeinfo.typeId)))
                {
                    arraylist1.add(Integer.valueOf(tphotocomposeinfo.typeId));
                }
            } else
            if (!arraylist1.contains(Integer.valueOf(TResTypeManager.KRES_OTHERTYPE)))
            {
                arraylist1.add(Integer.valueOf(TResTypeManager.KRES_OTHERTYPE));
            }
            i++;
        }
        if (arraylist1 != null && arraylist1.size() > 0)
        {
            Collections.sort(arraylist1, new bhh(this));
            for (int j = ((flag) ? 1 : 0); j < arraylist1.size(); j++)
            {
                list = (Integer)arraylist1.get(j);
                list = TResTypeManager.instance().getResTypeById(list.intValue());
                if (list != null && !arraylist.contains(list))
                {
                    arraylist.add(list);
                }
            }

        }
        return arraylist;
    }

    public List getInfosByImageCount(int i)
    {
        ArrayList arraylist = new ArrayList();
        String s = getDeleteAndHideInfoIds();
        for (int j = 0; j < _styleInfoArray.size(); j++)
        {
            TPhotoComposeInfo tphotocomposeinfo = (TPhotoComposeInfo)_styleInfoArray.get(j);
            if (tphotocomposeinfo.imageCount == i && !s.contains(tphotocomposeinfo.getDeleteTag()))
            {
                arraylist.add(tphotocomposeinfo);
            }
        }

        return arraylist;
    }

    public List getInfosByImageCountAndCollageType(int i)
    {
        return getInfosByImageCount(i);
    }

    public List getInfosByImageCountAndMagType(int i, InstaMagType instamagtype)
    {
        ArrayList arraylist = new ArrayList();
        String s = getDeleteAndHideInfoIds();
        for (int j = 0; j < _styleInfoArray.size(); j++)
        {
            TPhotoComposeInfo tphotocomposeinfo = (TPhotoComposeInfo)_styleInfoArray.get(j);
            if (tphotocomposeinfo.imageCount == i && tphotocomposeinfo.magType() == instamagtype && !s.contains(tphotocomposeinfo.getDeleteTag()))
            {
                arraylist.add(tphotocomposeinfo);
            }
        }

        return arraylist;
    }

    public List getInfosByImageCountTypeId(int i, int j)
    {
        ArrayList arraylist = new ArrayList();
        String s = getDeleteAndHideInfoIds();
        for (int k = 0; k < _styleInfoArray.size(); k++)
        {
            TPhotoComposeInfo tphotocomposeinfo = (TPhotoComposeInfo)_styleInfoArray.get(k);
            if (tphotocomposeinfo.imageCount == i && tphotocomposeinfo.typeId == j && !s.contains(tphotocomposeinfo.getDeleteTag()))
            {
                arraylist.add(tphotocomposeinfo);
            }
        }

        return arraylist;
    }

    public TPhotoLinkComposeInfo getLinkComposeInfoByIndex(int i)
    {
        if (_linkstyleInfoArray.size() != 0);
        if (i < _linkstyleInfoArray.size())
        {
            return (TPhotoLinkComposeInfo)_linkstyleInfoArray.get(i);
        } else
        {
            return null;
        }
    }

    public TPhotoLinkComposeInfo getLinkComposeInfoByResId(int i)
    {
        if (_linkstyleInfoArray.size() != 0);
        if (_linkstyleInfoArray != null && _linkstyleInfoArray.size() > 0)
        {
            for (int j = 0; j < _linkstyleInfoArray.size(); j++)
            {
                TPhotoLinkComposeInfo tphotolinkcomposeinfo = (TPhotoLinkComposeInfo)_linkstyleInfoArray.get(j);
                if (tphotolinkcomposeinfo.resId == i)
                {
                    return tphotolinkcomposeinfo;
                }
            }

        }
        return null;
    }

    public int getLinkComposeInfoCount()
    {
        if (_linkstyleInfoArray.size() != 0);
        return _linkstyleInfoArray.size();
    }

    public List getLinkComposeInfos()
    {
        ArrayList arraylist = new ArrayList();
        for (Iterator iterator = _linkstyleInfoArray.iterator(); iterator.hasNext(); arraylist.add((TPhotoLinkComposeInfo)iterator.next())) { }
        return arraylist;
    }

    public List getLocalComposeInfos(CollageType collagetype)
    {
        collagetype = getDeleteAndHideInfoIds();
        ArrayList arraylist = new ArrayList();
        for (int i = 0; i < _styleInfoArray.size(); i++)
        {
            TPhotoComposeInfo tphotocomposeinfo = (TPhotoComposeInfo)_styleInfoArray.get(i);
            if (!tphotocomposeinfo.isOnline && !collagetype.contains(tphotocomposeinfo.getDeleteTag()))
            {
                arraylist.add(tphotocomposeinfo);
            }
        }

        Collections.sort(arraylist, new bhf(this));
        return arraylist;
    }

    public List getNewLocalAddedInfo()
    {
        ArrayList arraylist = new ArrayList();
        Object obj = FileManager.getInstance().unarachiveAssetAddtionInstaMagStyles();
        if (obj != null)
        {
            obj = (String)obj;
            Gson gson = new Gson();
            try
            {
                obj = (List)gson.fromJson(((String) (obj)), (new bhe(this)).getType());
            }
            catch (JsonSyntaxException jsonsyntaxexception)
            {
                return arraylist;
            }
            return ((List) (obj));
        } else
        {
            return arraylist;
        }
    }

    public void initLinkCollageData()
    {
        TPhotoLinkComposeInfo tphotolinkcomposeinfo = new TPhotoLinkComposeInfo();
        tphotolinkcomposeinfo.resId = 101;
        tphotolinkcomposeinfo.backgroundColor = -1;
        tphotolinkcomposeinfo.icon = "MRes/link2/im_strip_thumb_sm.png";
        tphotolinkcomposeinfo.name = "Paris";
        tphotolinkcomposeinfo.imageCount = 9;
        tphotolinkcomposeinfo.typeId = TResTypeManager.KRES_OTHERTYPE;
        tphotolinkcomposeinfo.previewUrl = "";
        tphotolinkcomposeinfo.width = 320F;
        tphotolinkcomposeinfo.height = 960F;
        tphotolinkcomposeinfo.headerInfo = bio.a("LinkHeader2", 0);
        tphotolinkcomposeinfo.footerInfo = bio.a("LinkFooter2", 0);
        tphotolinkcomposeinfo.bodyInfoArray = new ArrayList();
        tphotolinkcomposeinfo.bodyInfoArray.add(bio.a("LinkBodySingle2", 1));
        tphotolinkcomposeinfo.bodyInfoArray.add(bio.a("LinkBodyDouble2", 2));
        _linkstyleInfoArray.add(tphotolinkcomposeinfo);
        tphotolinkcomposeinfo = new TPhotoLinkComposeInfo();
        tphotolinkcomposeinfo.resId = 104;
        tphotolinkcomposeinfo.backgroundColor = -1;
        tphotolinkcomposeinfo.icon = "MRes/link5/pinjie06_sm.png";
        tphotolinkcomposeinfo.name = "Hometown";
        tphotolinkcomposeinfo.imageCount = 9;
        tphotolinkcomposeinfo.typeId = TResTypeManager.KRES_OTHERTYPE;
        tphotolinkcomposeinfo.previewUrl = "";
        tphotolinkcomposeinfo.width = 320F;
        tphotolinkcomposeinfo.height = 960F;
        tphotolinkcomposeinfo.headerInfo = bio.a("LinkHeader5", 0);
        tphotolinkcomposeinfo.footerInfo = bio.a("LinkFooter5", 0);
        tphotolinkcomposeinfo.bodyInfoArray = new ArrayList();
        tphotolinkcomposeinfo.bodyInfoArray.add(bio.a("LinkBodySingle5", 1));
        tphotolinkcomposeinfo.bodyInfoArray.add(bio.a("LinkBodyRight5", 1));
        _linkstyleInfoArray.add(tphotolinkcomposeinfo);
        tphotolinkcomposeinfo = new TPhotoLinkComposeInfo();
        tphotolinkcomposeinfo.resId = 102;
        tphotolinkcomposeinfo.backgoundImagePath = "MRes/link3/im_strip_3_bg.png";
        tphotolinkcomposeinfo.icon = "MRes/link3/im_strip_3_thumb_sm.png";
        tphotolinkcomposeinfo.name = "Journal";
        tphotolinkcomposeinfo.imageCount = 9;
        tphotolinkcomposeinfo.typeId = TResTypeManager.KRES_OTHERTYPE;
        tphotolinkcomposeinfo.previewUrl = "";
        tphotolinkcomposeinfo.width = 320F;
        tphotolinkcomposeinfo.height = 960F;
        tphotolinkcomposeinfo.headerInfo = bio.a("LinkHeader3", 0);
        tphotolinkcomposeinfo.footerInfo = bio.a("LinkFooter3", 0);
        tphotolinkcomposeinfo.bodyInfoArray = new ArrayList();
        tphotolinkcomposeinfo.bodyInfoArray.add(bio.a("LinkBodySingle3", 1));
        _linkstyleInfoArray.add(tphotolinkcomposeinfo);
        tphotolinkcomposeinfo = new TPhotoLinkComposeInfo();
        tphotolinkcomposeinfo.resId = 100;
        tphotolinkcomposeinfo.backgoundImagePath = "MRes/link1/bg.jpg";
        tphotolinkcomposeinfo.icon = "MRes/link1/pinjie01_sm.png";
        tphotolinkcomposeinfo.name = "Diary";
        tphotolinkcomposeinfo.imageCount = 9;
        tphotolinkcomposeinfo.typeId = TResTypeManager.KRES_OTHERTYPE;
        tphotolinkcomposeinfo.previewUrl = "";
        tphotolinkcomposeinfo.width = 320F;
        tphotolinkcomposeinfo.height = 960F;
        tphotolinkcomposeinfo.headerInfo = bio.a("LinkHeader1", 0);
        tphotolinkcomposeinfo.footerInfo = bio.a("LinkFooter1", 0);
        tphotolinkcomposeinfo.bodyInfoArray = new ArrayList();
        tphotolinkcomposeinfo.bodyInfoArray.add(bio.a("LinkBodySingle1", 1));
        tphotolinkcomposeinfo.bodyInfoArray.add(bio.a("LinkBodyDouble1", 2));
        _linkstyleInfoArray.add(tphotolinkcomposeinfo);
        tphotolinkcomposeinfo = new TPhotoLinkComposeInfo();
        tphotolinkcomposeinfo.resId = 103;
        tphotolinkcomposeinfo.backgoundImagePath = "MRes/link4/bg.jpg";
        tphotolinkcomposeinfo.icon = "MRes/link4/pinjie05_sm.png";
        tphotolinkcomposeinfo.name = "Happy Time";
        tphotolinkcomposeinfo.imageCount = 9;
        tphotolinkcomposeinfo.typeId = TResTypeManager.KRES_OTHERTYPE;
        tphotolinkcomposeinfo.previewUrl = "";
        tphotolinkcomposeinfo.width = 320F;
        tphotolinkcomposeinfo.height = 960F;
        tphotolinkcomposeinfo.headerInfo = bio.a("LinkHeader4", 0);
        tphotolinkcomposeinfo.footerInfo = bio.a("LinkFooter4", 0);
        tphotolinkcomposeinfo.bodyInfoArray = new ArrayList();
        tphotolinkcomposeinfo.bodyInfoArray.add(bio.a("LinkBodySingle4", 1));
        _linkstyleInfoArray.add(tphotolinkcomposeinfo);
        tphotolinkcomposeinfo = new TPhotoLinkComposeInfo();
        tphotolinkcomposeinfo.resId = 105;
        tphotolinkcomposeinfo.backgoundImagePath = "MRes/link6/bg.jpg";
        tphotolinkcomposeinfo.icon = "MRes/link6/pinjie07-sm.png";
        tphotolinkcomposeinfo.name = "My Family";
        tphotolinkcomposeinfo.imageCount = 9;
        tphotolinkcomposeinfo.typeId = TResTypeManager.KRES_OTHERTYPE;
        tphotolinkcomposeinfo.previewUrl = "";
        tphotolinkcomposeinfo.width = 320F;
        tphotolinkcomposeinfo.height = 960F;
        tphotolinkcomposeinfo.headerInfo = bio.a("LinkHeader6", 0);
        tphotolinkcomposeinfo.footerInfo = bio.a("LinkFooter6", 0);
        tphotolinkcomposeinfo.bodyInfoArray = new ArrayList();
        tphotolinkcomposeinfo.bodyInfoArray.add(bio.a("LinkBodySingle6", 1));
        _linkstyleInfoArray.add(tphotolinkcomposeinfo);
    }

    public void initLocalInfosType()
    {
        int i = TResTypeManager.KRES_MINIMAL;
        int j = TResTypeManager.KRES_SIMPLE;
        String s1 = (new StringBuilder()).append(",493,155,162,163,168,169,172,173,174,177,186,193,194,203,204,206,207,210,212,213,215,216,221,223,224,230,241,242,243,247,249,250,253,254,257,259,264,271,276,280,282,283,284,290,294,296,297,310,312,313,316,317,327,329,337,346,352,354,357,361,370,372,377,379,381,382,383,390,392,397,403,406,407,408,409,412,413,414,417,418,419,423,424,425,426,427,428,429,431,433,434,435,440,442,446,449,450,457,459,460,462,464,467,469,470,471,473,474,475,476,482,483,484,486,487,490,491,495,497,500,504,505,506,507,509,510,514,516,522,523,530,537,539,540,541,542,543,545,547,549,552,561,563,565,570,573,574,575,576,579,580,595,606,607,618,624,626,628,629,630,631,632,637,638,639,640,641,642,643,645,646,656,657,660,670,671,673,675,676,677,683,684,685,686,691,692,694,697,699,700,703,706,707,708,710,715,717,718,738,739,740,741,742,743,744,750,754,755,759,761,784,794,798,799,800,801,803,809,810,811,833,835,838,839,843,864,865,873,875,890,901,902,904,907,910,919,924,931,936,937,938,942,945,946,950,975,977,979,980,983,985,987,1000,1002,1021,1026,1029,1030,1034,1038,1042,1043,1063,1066,1067,1070,1071,1076,1103,1104,1123,1134,1141,1143,1164,1170,1171,1172,1175,1177,1180,1188,1190,1191,1192,1204,1207,1221,1222,1223,1225,1226,1229,1230,1233,1236,1240,1241,1242,1245,1246,1247,1249,1250,1251,1252,1256,1258,1259,1260,1261,1262,1263,1266,1268,1269,1270,1271,1272,1273,1274,1280,1284,1287,1288,1289,1290,1291,1293,1295,1298,1299,1300,1302,1305,1306,1307,1308,1309,1312,1313,1316,1317,1318,1323,1326,1328,1329,1335,1358,1359,1362,1363,1364,1366,1375,1376,1377,1381,1384,1386,1387,1388,1389,1390,1391,1393,1394,1395,1396,1397,1399,1402,1403,1406,1408,1409,1414,1415,1416,1422,1424,1425,1428,1429,1432,1433,1434,1435,1436,1437,1439,1440,1441,1443,1444,1445,1447,1448,1449,").append("30,13,14,23,32,28,31,15,21,22,33,25,35,19,8,36,7,9,10,20,24,37,26,11,27,29,38,34,27,39,18,").toString();
        int k = TResTypeManager.KRES_CREATIVE;
        String s2 = (new StringBuilder()).append(",255,258,281,307,308,323,324,388,389,421,448,451,452,494,496,546,553,559,617,622,623,649,653,655,674,719,756,762,763,765,767,780,792,963,1027,1028,1036,1052,1064,1133,1139,1152,1182,1184,1189,1193,1198,1201,1203,1205,1206,1234,1235,1238,1243,1244,1257,1264,1275,1277,1278,1279,1281,1285,1286,1296,1303,1304,1310,1311,1314,1315,1319,1320,1321,1327,1333,1336,1337,1338,1339,1340,1342,1344,1345,1348,1349,1350,1351,1352,1354,1355,1356,1383,1401,1417,1418,1419,1420,1430,").append("12,").toString();
        int l = TResTypeManager.KRES_OBJECTS;
        String s3 = (new StringBuilder()).append(",178,180,191,225,227,246,252,260,262,266,268,269,320,326,331,332,334,339,362,420,432,463,485,492,498,521,524,526,554,603,634,698,714,716,737,747,748,749,789,812,813,903,905,908,932,951,1018,1065,1173,1174,1194,1195,1196,1200,1228,1237,1239,1254,1255,1283,1292,1322,1324,1341,1347,1367,1368,1369,1400,1410,").append("40,").toString();
        int i1 = TResTypeManager.KRES_ARTISTIC;
        int j1 = TResTypeManager.KRES_HOLIDAYS;
        int k1 = TResTypeManager.KRES_3D;
        int l1 = TResTypeManager.KRES_PIP;
        int i2 = TResTypeManager.KRES_OTHERTYPE;
        String s = "";
        for (Iterator iterator = _styleInfoArray.iterator(); iterator.hasNext();)
        {
            TPhotoComposeInfo tphotocomposeinfo = (TPhotoComposeInfo)iterator.next();
            String s4 = String.format(",%d,", new Object[] {
                Integer.valueOf(tphotocomposeinfo.resId)
            });
            if (",614,933,154,447,202,1677,1573,1537,1580,1605,1604,1607,157,158,197,229,367,453,501,515,519,525,527,532,538,557,568,569,581,584,586,591,593,635,695,757,758,874,766,1426,1472,1484,1486,1488,1498,1503,1522,1527,1546,199,201,415,454,499,502,503,511,518,520,529,534,536,558,571,577,582,587,589,592,604,612,616,636,644,658,949,1231,1265,1483,1489,1542,455,472,513,535,560,578,583,585,588,590,594,605,609,610,611,613,659,752,753,1197,1360,1411,1482,1485,1525,1623,1633,1636,1638,1639,1640,199,367,1595,591,1584,".contains(s4))
            {
                tphotocomposeinfo.typeId = i;
            } else
            if (s1.contains(s4))
            {
                tphotocomposeinfo.typeId = j;
            } else
            if (s2.contains(s4))
            {
                tphotocomposeinfo.typeId = k;
            } else
            if (s3.contains(s4))
            {
                tphotocomposeinfo.typeId = l;
            } else
            if ("".contains(s4))
            {
                tphotocomposeinfo.typeId = i1;
            } else
            if (",267,551,663,664,679,680,681,688,690,702,711,712,721,722,723,724,725,726,727,728,729,731,732,733,734,736,804,840,841,842,863,876,941,967,1009,1013,1024,1183,1232,1282,1330,1331,1332,1334,1370,1371,1372,1373,1378,1379,1382,1385,1392,1398,1404,1405,1407,1412,".contains(s4))
            {
                tphotocomposeinfo.typeId = j1;
            } else
            if (",562,567,802,805,806,807,816,818,822,823,826,827,828,829,830,846,849,851,853,854,855,".contains(s4))
            {
                tphotocomposeinfo.typeId = k1;
            } else
            if (",1032,1033,1044,1045,1046,1051,1054,1055,1058,1059,1060,1072,1075,1077,1078,1079,1083,1084,1085,1087,1089,1090,1091,1092,1093,1094,1095,1096,1099,1100,1101,1105,1107,1108,1109,1110,1111,1112,1113,1114,1115,1116,1117,1118,1119,1120,1121,1122,1124,1125,1126,1127,1128,1129,1130,1132,1135,1136,1137,1138,1166,1167,1168,1176,1179,1181,1380,1438,1442,1451,1731,1550,1547,1536,".contains(s4))
            {
                tphotocomposeinfo.typeId = l1;
            } else
            if (",1208,1209,1210,1211,1212,1213,1214,1215,1216,1217,1218,1219,1220,".contains(s4))
            {
                tphotocomposeinfo.typeId = i2;
            } else
            {
                s = (new StringBuilder()).append(s).append(",").append(tphotocomposeinfo.resId).toString();
                tphotocomposeinfo.typeId = TResTypeManager.KRES_OTHERTYPE;
            }
        }

        Log.i("notypeIds :", s);
    }

    public boolean isExistedByResId(int i)
    {
        boolean flag;
        boolean flag1;
        flag1 = false;
        flag = flag1;
        if (_styleInfoArray == null) goto _L2; else goto _L1
_L1:
        flag = flag1;
        if (_styleInfoArray.size() <= 0) goto _L2; else goto _L3
_L3:
        int j = 0;
_L8:
        flag = flag1;
        if (j >= _styleInfoArray.size()) goto _L2; else goto _L4
_L4:
        if (((TPhotoComposeInfo)_styleInfoArray.get(j)).resId != i) goto _L6; else goto _L5
_L5:
        flag = true;
_L2:
        return flag;
_L6:
        j++;
        if (true) goto _L8; else goto _L7
_L7:
    }

    public boolean isShouldInitTypeIds()
    {
        boolean flag = aqx.a(InstaBeautyApplication.a, TAG, true);
        if (flag)
        {
            aqx.b(InstaBeautyApplication.a, TAG, false);
        }
        return flag;
    }

    public List netMaterials()
    {
        ArrayList arraylist = new ArrayList();
        Iterator iterator = _styleInfoArray.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            TPhotoComposeInfo tphotocomposeinfo = (TPhotoComposeInfo)iterator.next();
            if (tphotocomposeinfo.getResType() == EResType.NETWORK)
            {
                arraylist.add(tphotocomposeinfo);
            }
        } while (true);
        return arraylist;
    }

    public void preInstall()
    {
        TPhotoComposeInfo tphotocomposeinfo = new TPhotoComposeInfo();
        tphotocomposeinfo.resId = 21;
        tphotocomposeinfo.backgroundColor = -1;
        tphotocomposeinfo.icon = "MRes/im_fashion_4/im_fashion_4_sm.jpg";
        tphotocomposeinfo.name = "Simplicity";
        tphotocomposeinfo.imageCount = 2;
        tphotocomposeinfo.typeId = TResTypeManager.KRES_SIMPLE;
        tphotocomposeinfo.price = 0;
        tphotocomposeinfo.previewUrl = "";
        tphotocomposeinfo.isHFlip = false;
        tphotocomposeinfo.isVFlip = true;
        ArrayList arraylist = new ArrayList();
        Object obj = new TPhotoMaskInfo();
        obj.backgroundFrame = CGRectMake(0.0F, 0.0F, 267F, 360F);
        obj.innerFrame = CGRectMake(0.0F, 0.0F, 267F, 360F);
        arraylist.add(obj);
        obj = new TPhotoMaskInfo();
        obj.backgroundFrame = CGRectMake(150F, 275F, 174.5F, 206F);
        obj.innerFrame = CGRectMake(8F, 8F, 166F, 186.5F);
        obj.maskImagePath = "MRes/im_fashion_4/im_fashion_4_mask.png";
        obj.backgroundImagePath = "MRes/im_fashion_4/im_fashion_4_maskbg.png";
        arraylist.add(obj);
        tphotocomposeinfo.photoMaskInfoArray = arraylist;
        arraylist = new ArrayList();
        obj = new TDecorateInfo();
        obj.frame = CGRectMake(132F, 13F, 131F, 35F);
        obj.type = 2;
        obj.textColor = -1;
        obj.textAlignment = UITextAlignmentCenter;
        obj.fontMaxCount = 15;
        obj.fontSize = 30;
        obj.text = "Simplicity";
        obj.isBold = true;
        obj.movable = true;
        obj.editable = true;
        arraylist.add(obj);
        obj = new TDecorateInfo();
        obj.frame = CGRectMake(10F, 420F, 137F, 30F);
        obj.type = 2;
        obj.textColor = Color.argb(255, 125, 88, 78);
        obj.textAlignment = UITextAlignmentRight;
        obj.fontMaxCount = 10;
        obj.fontSize = 10;
        obj.text = "\"Simplicity is the ultimate sophistication.\"\u2015 Leonardo da Vinci";
        obj.isBold = false;
        obj.movable = true;
        obj.editable = true;
        obj.lines = 2;
        arraylist.add(obj);
        obj = new TDecorateInfo();
        obj.frame = CGRectMake(5F, 340F, 66F, 16F);
        obj.rotation = 0.0F;
        obj.type = 1;
        obj.imagePath = "MRes/common/icon_logo_white.png";
        obj.movable = true;
        arraylist.add(obj);
        tphotocomposeinfo.decorateInfoArray = arraylist;
        addAndReplace(tphotocomposeinfo);
        tphotocomposeinfo = new TPhotoComposeInfo();
        tphotocomposeinfo.resId = 10;
        tphotocomposeinfo.backgroundColor = 0xff000000;
        tphotocomposeinfo.icon = "MRes/instamag_style_6/instamag_style_6_thumbnail.jpg";
        tphotocomposeinfo.name = "Hawaii";
        tphotocomposeinfo.imageCount = 4;
        tphotocomposeinfo.typeId = TResTypeManager.KRES_SIMPLE;
        tphotocomposeinfo.price = 0;
        tphotocomposeinfo.previewUrl = "";
        tphotocomposeinfo.isHFlip = false;
        tphotocomposeinfo.isVFlip = false;
        arraylist = new ArrayList();
        obj = new TPhotoMaskInfo();
        obj.backgroundFrame = CGRectMake(0.0F, 0.0F, 160F, 240F);
        obj.innerFrame = CGRectMake(0.0F, 0.0F, 160F, 240F);
        arraylist.add(obj);
        obj = new TPhotoMaskInfo();
        obj.backgroundFrame = CGRectMake(160F, 0.0F, 160F, 240F);
        obj.innerFrame = CGRectMake(0.0F, 0.0F, 160F, 240F);
        obj.backgroundColor = 0xff000000;
        arraylist.add(obj);
        obj = new TPhotoMaskInfo();
        obj.backgroundFrame = CGRectMake(0.0F, 240F, 160F, 240F);
        obj.innerFrame = CGRectMake(0.0F, 0.0F, 160F, 240F);
        obj.backgroundColor = 0xff000000;
        arraylist.add(obj);
        obj = new TPhotoMaskInfo();
        obj.backgroundFrame = CGRectMake(160F, 240F, 160F, 240F);
        obj.innerFrame = CGRectMake(0.0F, 0.0F, 160F, 240F);
        obj.backgroundColor = 0xff000000;
        arraylist.add(obj);
        tphotocomposeinfo.photoMaskInfoArray = arraylist;
        arraylist = new ArrayList();
        obj = new TDecorateInfo();
        obj.frame = CGRectMake(0.0F, 206F, 320F, 68F);
        obj.type = 2;
        obj.text = "";
        obj.backgroundColor = Color.argb(127, 255, 255, 255);
        obj.movable = false;
        obj.editable = false;
        arraylist.add(obj);
        obj = new TDecorateInfo();
        obj.frame = CGRectMake(0.0F, 206F, 320F, 34F);
        obj.rotation = 0.0F;
        obj.type = 5;
        obj.movable = true;
        obj.editable = true;
        obj.backgroundColor = 0;
        obj.text = "Hawaii,USA";
        obj.textColor = -1;
        obj.textAlignment = UITextAlignmentCenter;
        obj.fontMaxCount = 30;
        obj.fontSize = 24;
        obj.isBold = true;
        obj.isShadow = true;
        arraylist.add(obj);
        obj = new TDecorateInfo();
        obj.frame = CGRectMake(0.0F, 240F, 320F, 34F);
        obj.rotation = 0.0F;
        obj.type = 8;
        obj.movable = true;
        obj.editable = true;
        obj.text = "";
        obj.textColor = -1;
        obj.textAlignment = UITextAlignmentCenter;
        obj.fontMaxCount = 18;
        obj.fontSize = 18;
        obj.isBold = false;
        obj.isShadow = true;
        arraylist.add(obj);
        obj = new TDecorateInfo();
        obj.frame = CGRectMake(127F, 459F, 66F, 16F);
        obj.rotation = 0.0F;
        obj.type = 1;
        obj.imagePath = "MRes/common/icon_logo_white.png";
        obj.movable = true;
        arraylist.add(obj);
        tphotocomposeinfo.decorateInfoArray = arraylist;
        addAndReplace(tphotocomposeinfo);
        tphotocomposeinfo = new TPhotoComposeInfo();
        tphotocomposeinfo.resId = 14;
        tphotocomposeinfo.backgroundColor = 0xff000000;
        tphotocomposeinfo.icon = "MRes/instamag_style_8/instamag_style_8_thumbnail.jpg";
        tphotocomposeinfo.name = "Incredible";
        tphotocomposeinfo.imageCount = 1;
        tphotocomposeinfo.typeId = TResTypeManager.KRES_SIMPLE;
        tphotocomposeinfo.price = 0;
        tphotocomposeinfo.previewUrl = "";
        tphotocomposeinfo.isHFlip = false;
        tphotocomposeinfo.isVFlip = false;
        arraylist = new ArrayList();
        obj = new TPhotoMaskInfo();
        obj.backgroundFrame = CGRectMake(5F, 5F, 310F, 470F);
        obj.innerFrame = CGRectMake(0.0F, 0.0F, 310F, 470F);
        obj.filterName = "";
        arraylist.add(obj);
        tphotocomposeinfo.photoMaskInfoArray = arraylist;
        arraylist = new ArrayList();
        obj = new TDecorateInfo();
        obj.frame = CGRectMake(0.0F, 5F, 310F, 78F);
        obj.rotation = 0.0F;
        obj.type = 2;
        obj.text = "Incredible";
        obj.textAlignment = UITextAlignmentCenter;
        obj.textColor = -1;
        obj.fontFamily = "PTSans-CaptionBold";
        obj.fontSize = 56;
        obj.fontMaxCount = 15;
        obj.movable = true;
        obj.editable = true;
        obj.isShadow = true;
        obj.isBold = true;
        arraylist.add(obj);
        obj = new TDecorateInfo();
        obj.frame = CGRectMake(0.0F, 65F, 290F, 40F);
        obj.rotation = 0.0F;
        obj.type = 5;
        obj.text = "Taiwan";
        obj.textAlignment = UITextAlignmentRight;
        obj.textColor = -1;
        obj.fontFamily = "";
        obj.fontSize = 18;
        obj.fontMaxCount = 15;
        obj.movable = true;
        obj.editable = true;
        obj.isShadow = true;
        obj.isBold = true;
        arraylist.add(obj);
        obj = new TDecorateInfo();
        obj.frame = CGRectMake(15F, 210F, 290F, 40F);
        obj.rotation = 0.0F;
        obj.type = 2;
        obj.text = "Unique Style";
        obj.textAlignment = UITextAlignmentLeft;
        obj.textColor = Color.argb(255, 144, 101, 61);
        obj.fontFamily = "";
        obj.fontSize = 16;
        obj.fontMaxCount = 15;
        obj.movable = true;
        obj.editable = true;
        obj.isShadow = true;
        obj.isBold = true;
        arraylist.add(obj);
        obj = new TDecorateInfo();
        obj.frame = CGRectMake(15F, 235F, 290F, 40F);
        obj.rotation = 0.0F;
        obj.type = 8;
        obj.textAlignment = UITextAlignmentLeft;
        obj.textColor = -1;
        obj.fontFamily = "";
        obj.fontSize = 30;
        obj.fontMaxCount = 15;
        obj.movable = true;
        obj.editable = true;
        obj.isShadow = true;
        obj.isBold = true;
        arraylist.add(obj);
        obj = new TDecorateInfo();
        obj.frame = CGRectMake(15F, 450F, 66F, 16F);
        obj.rotation = 0.0F;
        obj.type = 1;
        obj.imagePath = "MRes/common/icon_logo_white.png";
        obj.movable = true;
        arraylist.add(obj);
        tphotocomposeinfo.decorateInfoArray = arraylist;
        addAndReplace(tphotocomposeinfo);
        tphotocomposeinfo = new TPhotoComposeInfo();
        tphotocomposeinfo.resId = 22;
        tphotocomposeinfo.backgroundColor = -1;
        tphotocomposeinfo.icon = "MRes/im_travel_1/im_travel_1_sm.jpg";
        tphotocomposeinfo.name = "Nature";
        tphotocomposeinfo.imageCount = 2;
        tphotocomposeinfo.typeId = TResTypeManager.KRES_SIMPLE;
        tphotocomposeinfo.price = 0;
        tphotocomposeinfo.previewUrl = "";
        tphotocomposeinfo.isHFlip = true;
        tphotocomposeinfo.isVFlip = true;
        arraylist = new ArrayList();
        obj = new TPhotoMaskInfo();
        obj.backgroundFrame = CGRectMake(0.0F, 22F, 320F, 210F);
        obj.innerFrame = CGRectMake(0.0F, 0.0F, 320F, 210F);
        arraylist.add(obj);
        obj = new TPhotoMaskInfo();
        obj.backgroundFrame = CGRectMake(0.0F, 248F, 320F, 210F);
        obj.innerFrame = CGRectMake(0.0F, 0.0F, 320F, 210F);
        arraylist.add(obj);
        tphotocomposeinfo.photoMaskInfoArray = arraylist;
        arraylist = new ArrayList();
        obj = new TDecorateInfo();
        obj.frame = CGRectMake(4F, 33F, 140F, 20F);
        obj.type = 2;
        obj.textColor = -1;
        obj.textAlignment = UITextAlignmentLeft;
        obj.fontMaxCount = 20;
        obj.fontSize = 14;
        obj.text = "BACKPACKING";
        obj.isBold = false;
        obj.movable = true;
        obj.editable = true;
        arraylist.add(obj);
        obj = new TDecorateInfo();
        obj.frame = CGRectMake(4F, 50F, 175F, 30F);
        obj.rotation = 0.0F;
        obj.type = 9;
        obj.movable = true;
        obj.editable = true;
        obj.text = "Jiuzhaigou Valley";
        obj.textColor = -1;
        obj.textAlignment = UITextAlignmentLeft;
        obj.fontMaxCount = 30;
        obj.fontSize = 24;
        obj.isBold = true;
        obj.isShadow = false;
        arraylist.add(obj);
        obj = new TDecorateInfo();
        obj.frame = CGRectMake(4F, 75F, 111F, 25F);
        obj.rotation = 0.0F;
        obj.type = 10;
        obj.movable = true;
        obj.editable = true;
        obj.text = "China";
        obj.textColor = -1;
        obj.textAlignment = UITextAlignmentLeft;
        obj.fontMaxCount = 30;
        obj.fontSize = 16;
        obj.isBold = true;
        obj.isShadow = false;
        arraylist.add(obj);
        obj = new TDecorateInfo();
        obj.frame = CGRectMake(177F, 255F, 130F, 50F);
        obj.type = 2;
        obj.textColor = -1;
        obj.textAlignment = UITextAlignmentRight;
        obj.fontMaxCount = 40;
        obj.fontSize = 8;
        obj.text = "\" The world is a book and those who do not travel read only one page.\" \u2013 St. Augustine";
        obj.isBold = false;
        obj.movable = true;
        obj.editable = true;
        obj.lines = 2;
        arraylist.add(obj);
        obj = new TDecorateInfo();
        obj.frame = CGRectMake(250F, 461F, 66F, 16F);
        obj.rotation = 0.0F;
        obj.type = 1;
        obj.imagePath = "MRes/common/icon_logo_dark.png";
        obj.movable = true;
        arraylist.add(obj);
        tphotocomposeinfo.decorateInfoArray = arraylist;
        addAndReplace(tphotocomposeinfo);
    }

    public void removeAllDownloadInfo()
    {
        aqx.a(InstaBeautyApplication.a, TAG, MagDeleteAndHideResIds);
        Object obj = getAllOnlineInfos();
        if (obj != null && ((List) (obj)).size() > 0)
        {
            for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); removeOnlineInfo((TPhotoComposeInfo)((Iterator) (obj)).next())) { }
        }
    }

    public void removeInfoFromLibrary(TPhotoComposeInfo tphotocomposeinfo)
    {
        String s1 = getDeleteAndHideInfoIds();
        String s = s1;
        if (!s1.contains(tphotocomposeinfo.getDeleteTag()))
        {
            s = String.format("%s%d,", new Object[] {
                s1, Integer.valueOf(tphotocomposeinfo.resId)
            });
        }
        if (s != null)
        {
            aqx.a(InstaBeautyApplication.a, TAG, MagDeleteAndHideResIds, s);
        }
        if (tphotocomposeinfo.getResType() != EResType.NETWORK || !isExistedByResId(tphotocomposeinfo.resId))
        {
            return;
        } else
        {
            deleteInfo(tphotocomposeinfo);
            return;
        }
    }

    public void removeOnlineInfo(TPhotoComposeInfo tphotocomposeinfo)
    {
        int i = 0;
        do
        {
label0:
            {
                if (i < _styleInfoArray.size())
                {
                    TPhotoComposeInfo tphotocomposeinfo1 = (TPhotoComposeInfo)_styleInfoArray.get(i);
                    if (tphotocomposeinfo1.getResType() != EResType.NETWORK && !tphotocomposeinfo1.isOnline || tphotocomposeinfo.resId != tphotocomposeinfo1.resId)
                    {
                        break label0;
                    }
                    _styleInfoArray.remove(tphotocomposeinfo1);
                    i = tphotocomposeinfo.icon.lastIndexOf("/");
                    tphotocomposeinfo = tphotocomposeinfo.icon.substring(i + 1);
                    FileManager.getInstance().deleteOnlineBitmapRes(EOnlineResType.MAG_MASK_INFO, tphotocomposeinfo);
                }
                return;
            }
            i++;
        } while (true);
    }

    public void replace(TPhotoComposeInfo tphotocomposeinfo)
    {
        if (tphotocomposeinfo != null && _styleInfoArray != null && _styleInfoArray.size() > 0)
        {
            int i = 0;
            while (i < _styleInfoArray.size()) 
            {
                if (((TPhotoComposeInfo)_styleInfoArray.get(i)).resId == tphotocomposeinfo.resId)
                {
                    _styleInfoArray.set(i, tphotocomposeinfo);
                    return;
                }
                i++;
            }
        }
    }

    public void unarchive()
    {
        Object obj = FileManager.getInstance().unarchiveFilterManger(EOnlineResType.MAG_MASK_INFO);
        if (obj == null) goto _L2; else goto _L1
_L1:
        Gson gson;
        obj = (String)obj;
        gson = new Gson();
        _styleInfoArray = (List)gson.fromJson(((String) (obj)), (new bhd(this)).getType());
        obj = new ArrayList();
        int i = 0;
_L10:
        if (i >= _styleInfoArray.size()) goto _L4; else goto _L3
_L3:
        TPhotoComposeInfo tphotocomposeinfo = (TPhotoComposeInfo)_styleInfoArray.get(i);
        if (tphotocomposeinfo.icon == null || tphotocomposeinfo.icon != null && tphotocomposeinfo.icon.length() == 0)
        {
            ((List) (obj)).add(tphotocomposeinfo);
        }
          goto _L5
_L4:
        if (obj == null) goto _L2; else goto _L6
_L6:
        if (((List) (obj)).size() <= 0) goto _L2; else goto _L7
_L7:
        i = 0;
_L8:
        if (i >= ((List) (obj)).size())
        {
            break; /* Loop/switch isn't completed */
        }
        _styleInfoArray.remove(((List) (obj)).get(i));
        i++;
        if (true) goto _L8; else goto _L2
        JsonSyntaxException jsonsyntaxexception;
        jsonsyntaxexception;
        FileManager.getInstance().deleteArchiveFilterManger(EOnlineResType.MAG_MASK_INFO);
        aqx.b(InstaBeautyApplication.a, "TphotoMagComposeManager", "addNewLocalInfo", false);
_L2:
        return;
_L5:
        i++;
        if (true) goto _L10; else goto _L9
_L9:
    }

    public void updateAllComposeInfosType()
    {
        for (Iterator iterator = TResTypeManager.instance().getAllTypeList().iterator(); iterator.hasNext();)
        {
            bdg bdg1 = (bdg)iterator.next();
            if (bdg1 != null && bdg1.e != null && bdg1.e.length() > 0)
            {
                Iterator iterator1 = _styleInfoArray.iterator();
                while (iterator1.hasNext()) 
                {
                    TPhotoComposeInfo tphotocomposeinfo = (TPhotoComposeInfo)iterator1.next();
                    String s = String.format(",%d,", new Object[] {
                        Integer.valueOf(tphotocomposeinfo.resId)
                    });
                    if (bdg1.e.contains(s))
                    {
                        tphotocomposeinfo.typeId = bdg1.a;
                    }
                }
            }
        }

    }

    public void updateUseCountByResId(int i, int j)
    {
        if (_styleInfoArray == null || _styleInfoArray.size() <= 0) goto _L2; else goto _L1
_L1:
        int k = 0;
_L7:
        if (k >= _styleInfoArray.size()) goto _L2; else goto _L3
_L3:
        Object obj = (TPhotoComposeInfo)_styleInfoArray.get(k);
        if (((TPhotoComposeInfo) (obj)).resId != i) goto _L5; else goto _L4
_L4:
        obj.useCount = j;
        obj = new Intent("ACTION_MATERIAL_CHANGE");
        ((Intent) (obj)).putExtra("TYPE_MATERIAL", bgv.getStringByResType(EOnlineResType.MAG_MASK_INFO));
        InstaBeautyApplication.a().getApplicationContext().sendBroadcast(((Intent) (obj)));
_L2:
        return;
_L5:
        k++;
        if (true) goto _L7; else goto _L6
_L6:
    }

}
