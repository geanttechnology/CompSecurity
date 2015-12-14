// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.cds;

import android.content.ContentValues;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.text.TextUtils;
import com.amazon.gallery.framework.aspect.AviaryCdsAspect;
import com.aviary.android.feather.cds.json.CdsContentParser;
import com.aviary.android.feather.common.log.LoggerFactory;
import com.aviary.android.feather.common.utils.DateTimeUtils;
import com.aviary.android.feather.common.utils.IOUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;
import junit.framework.AssertionFailedError;
import org.aspectj.lang.JoinPoint;
import org.aspectj.runtime.internal.AroundClosure;
import org.aspectj.runtime.internal.Conversions;
import org.aspectj.runtime.reflect.Factory;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.aviary.android.feather.cds:
//            CdsUtils, CdsDatabaseHelper

final class AviaryCdsDefaultContentLoader
{

    private static final String ASSET_BASE_URL;
    private static final String DEFAULT_EFFECTS_JSON = "{\"packType\":\"effect\",\"displayName\":\"Original\",\"displayDescription\":\"Get started with this free pack of essential effects for beautiful, everyday photography.\",\"icon\":\"file:///android_asset/aviary/cdsv2/assets/images.largeIcon.be9be7e9-745f-4234-a84b-b0e043618328.300.jpg\",\"iconVersion\":\"10e000b71ff1fc07b275f460783850f7\",\"author\":\"Aviary\",\"authorHyperlink\":null,\"socialMediaString\":null,\"previewURL\":\"/cdsv2/assets/com.aviary.effectpack.04/zips.androidPreviewPhoneXXHiRes.4e8edf7f-538b-4afa-bb63-3f5327b51436.zip\",\"previewVersion\":\"29318948dc1b06497c6887fbd1dc0f7f\",\"contentURL\":\"file:///android_asset/aviary/cdsv2/assets/zips.effectJSON.235ff3a1-fdd8-4d16-b625-517945f61c82.zip\",\"contentVersion\":\"b74040f3396d01906ff02a346dfd4f21\",\"isFree\":true,\"pcnPriceTier\":0,\"identifier\":\"com.aviary.effectpack.04\",\"featureImageURL\":\"/cdsv2/testcontent/com.aviary.effectpack.04/images.androidFeatureImage.81f193b2-d02c-4dba-8811-31a77b359fbb.980.jpg\",\"featureImageVersion\":\"0\",\"detailImageURL\":\"/cdsv2/testcontent/com.aviary.effectpack.04/images.androidDetailImage.dff72372-7f7e-4bc1-aa98-88ac17fb5457.1080.jpg\",\"detailImageVersion\":\"0\",\"items\":[{\"identifier\":\"default5\",\"displayName\":\"Clyde\"},{\"identifier\":\"default10\",\"displayName\":\"Avenue\"},{\"identifier\":\"default2\",\"displayName\":\"Haas\"},{\"identifier\":\"default9\",\"displayName\":\"Arizona\"},{\"identifier\":\"default11\",\"displayName\":\"Lucky\"},{\"identifier\":\"default1\",\"displayName\":\"Dean\"},{\"identifier\":\"default8\",\"displayName\":\"Keylime\"},{\"identifier\":\"default3\",\"displayName\":\"Boardwalk\"},{\"identifier\":\"default7\",\"displayName\":\"Sentosa\"},{\"identifier\":\"default13\",\"displayName\":\"Sage\"},{\"identifier\":\"default6\",\"displayName\":\"Metropolis\"},{\"identifier\":\"default12\",\"displayName\":\"Cruz\"}],\"versionKey\":\"53a0643f5920039d84000167\",\"v\":1404419997941,\"code\":0,\"status\":\"Ok\"}";
    private static final String DEFAULT_FRAMES_JSON = "{\"packType\":\"frame\",\"displayName\":\"Original\",\"displayDescription\":\"A collection of beautiful, versatile frames to get you started with Aviary.\",\"icon\":\"file:///android_asset/aviary/cdsv2/assets/images.largeIcon.7b749c3b-f657-4c39-8919-9f065caef753.300.png\",\"iconVersion\":\"4c1240a2312b16c113b5704fd277a4d7\",\"author\":\"Aviary\",\"authorHyperlink\":null,\"socialMediaString\":null,\"shopBackgroundColor\":\"#1c2027\",\"featureImageURL\":\"/cdsv2/assets/com.aviary.frame.53ced8b78abeb3083b001e4a/images.androidFeatureImage.31ad3bc8-af49-4a00-9445-1463854ad589.980.jpg\",\"featureImageVersion\":\"edfa3dcb2a52de25edc38e3349920cc3\",\"detailImageURL\":\"file:///android_asset/aviary/cdsv2/assets/images.androidDetailImage.9cf957a7-be64-4dbb-818b-63ba2854dec9.1080.jpg\",\"detailImageVersion\":\"0a1f306453a963546067379785c9828b\",\"previewURL\":\"file:///android_asset/aviary/cdsv2/assets/zips.androidPreviewHiRes.783ecc43-f4fa-4818-9a87-97b1c84f68ee.zip\",\"previewVersion\":\"546b8a102022342dc2d2dc000a90a5a0\",\"contentURL\":\"/cdsv2/assets/com.aviary.frame.53ced8b78abeb3083b001e4a/zips.contentAndroidHiRes.51b9118e-1527-4a42-bea9-856adff83db3.zip\",\"contentVersion\":\"3820dfc8be90338a24fbf5abdb3c07a9\",\"isFree\":true,\"pcnPriceTier\":2,\"identifier\":\"com.aviary.frame.53ced8b78abeb3083b001e4a\",\"items\":[{\"identifier\":\"original-Aura\",\"displayName\":\"Aura\",\"options\":{\"width\":0.5}},{\"identifier\":\"original-Borde\",\"displayName\":\"Borde\",\"options\":{\"width\":0.5}},{\"identifier\":\"original-Lumen\",\"displayName\":\"Lumen\",\"options\":{\"width\":0.3}},{\"identifier\":\"original-Noir\",\"displayName\":\"Noir\",\"options\":{\"width\":0.35}},{\"identifier\":\"original-Stella\",\"displayName\":\"Stella\",\"options\":{\"width\":0.35}},{\"identifier\":\"original-Notte\",\"displayName\":\"Notte\",\"options\":{\"width\":0.35}},{\"identifier\":\"original-Vela\",\"displayName\":\"Vela\",\"options\":{\"width\":0.35}},{\"identifier\":\"original-Capa\",\"displayName\":\"Capa\",\"options\":{\"width\":0.35}},{\"identifier\":\"original-Sole\",\"displayName\":\"Sole\",\"options\":{\"width\":0.4}},{\"identifier\":\"original-Luna\",\"displayName\":\"Luna\",\"options\":{\"width\":0.4}},{\"identifier\":\"original-Fino\",\"displayName\":\"Fino\",\"options\":{\"width\":0.5}},{\"identifier\":\"original-Rima\",\"displayName\":\"Rima\",\"options\":{\"width\":0.5}}],\"versionKey\":\"53cedd7e8abeb3083b001fc1\",\"v\":1411160596064,\"assetsBaseURL\":\"http://assets.aviary.com\",\"code\":0,\"status\":\"Ok\"}";
    private static final String DEFAULT_OVERLAYS_JSON = "{\"packType\":\"overlay\",\"displayName\":\"Original\",\"displayDescription\":\"The original overlay pack.\",\"icon\":\"file:///android_asset/aviary/cdsv2/assets/images.largeIcon.7ca38498-e0e7-448e-b80a-f1666798d100.300.png\",\"iconVersion\":\"4f5885e76982129580ba42c72937c6a4\",\"author\":\"Aviary\",\"authorHyperlink\":null,\"socialMediaString\":null,\"shopBackgroundColor\":\"#DDDDDD\",\"featureImageURL\":\"/cdsv2/assets/com.aviary.overlay.5410c5590c677e6c6a0000be/images.androidFeatureImage.4bfea2f8-ad1a-4d2a-a954-5b59c7b08dc1.980.jpg\",\"featureImageVersion\":\"b0affe82806fbb5ccb91aad6757e313f\",\"detailImageURL\":\"file:///android_asset/aviary/cdsv2/assets/images.androidDetailImage.87ea0744-5ddb-47f6-8253-728f4215d77e.1080.jpg\",\"detailImageVersion\":\"9c21fdce8f7932f1db0385dc6d898dba\",\"previewURL\":\"file:///android_asset/aviary/cdsv2/assets/zips.androidPreviewHiRes.e4d720d7-dc74-4a74-9ea9-b34d6537a547.zip\",\"previewVersion\":\"5925c1155df807830d49b0ced53beffd\",\"contentURL\":\"/cdsv2/assets/com.aviary.overlay.5410c5590c677e6c6a0000be/zips.contentAndroidHiRes.b2ec3b46-e39f-49fc-a117-3873f18c5fc8.zip\",\"contentVersion\":\"c262130f5614ca1066c4f3397f331bf6\",\"isFree\":true,\"pcnPriceTier\":2,\"identifier\":\"com.aviary.overlay.5410c5590c677e6c6a0000be\",\"items\":[{\"identifier\":\"circle-black\",\"displayName\":\"Radius\"},{\"identifier\":\"circle-white\",\"displayName\":\"Hole\"},{\"identifier\":\"cross-black\",\"displayName\":\"Cross\"},{\"identifier\":\"cross-white\",\"displayName\":\"Plus\"},{\"identifier\":\"hexagon-black\",\"displayName\":\"Hex\"},{\"identifier\":\"hexagon-white\",\"displayName\":\"hexagon-white\"},{\"identifier\":\"line-black\",\"displayName\":\"Vert1\"},{\"identifier\":\"line-white\",\"displayName\":\"Vert2\"},{\"identifier\":\"line2-black\",\"displayName\":\"Horace\"},{\"identifier\":\"line2-white\",\"displayName\":\"White Out\"},{\"identifier\":\"square-black\",\"displayName\":\"Square\"},{\"identifier\":\"square-white\",\"displayName\":\"Box\"},{\"identifier\":\"blue\",\"displayName\":\"Blue\"}],\"versionKey\":\"5429b4e60ea3724a030003dc\",\"v\":1412106604749,\"assetsBaseURL\":\"http://testassets.aviary.com.s3.amazonaws.com\",\"code\":0,\"status\":\"Ok\"}";
    private static final String DEFAULT_STICKERS_JSON = "{\"packType\":\"sticker\",\"displayName\":\"Original\",\"displayDescription\":\"Decorate all of your photos with this fun and totally free pack of hats, eyewear, neckwear, speech bubbles, shapes and more!\",\"icon\":\"file:///android_asset/aviary/cdsv2/assets/images.largeIcon.593086a0-76eb-44a5-9285-2459e4660bd8.300.png\",\"iconVersion\":\"94e5bb72e131575b612a49c68c95bbd3\",\"author\":\"Aviary\",\"authorHyperlink\":null,\"socialMediaString\":null,\"shopBackgroundColor\":\"#1c2027\",\"featureImageURL\":\"/cdsv2/assets/com.aviary.sticker.53d185cc6b76fe302f001cde/images.androidFeatureImage.faedc45c-e914-4bd4-95f7-5ebeccb781be.980.jpg\",\"featureImageVersion\":\"e8c8e313e8c7f73563d412749f961a80\",\"detailImageURL\":\"file:///android_asset/aviary/cdsv2/assets/images.androidDetailImage.9cdb2f88-b089-458a-9f23-76400c261b0b.1080.jpg\",\"detailImageVersion\":\"81a734b8cdc31dcb8dcd5663cd382645\",\"previewURL\":\"file:///android_asset/aviary/cdsv2/assets/zips.androidPreviewHiRes.733886ea-16cc-4292-8af7-6b3c78caa187.zip\",\"previewVersion\":\"b21916443b1bdcb699e6f99bab5bea6c\",\"contentURL\":\"/cdsv2/assets/com.aviary.sticker.53d185cc6b76fe302f001cde/zips.contentAndroidHiRes.0137fe97-9900-480e-bacc-51ed4128ca46.zip\",\"contentVersion\":\"2139119ea57de6f295d5ae2274ba8c14\",\"isFree\":true,\"pcnPriceTier\":2,\"identifier\":\"com.aviary.sticker.53d185cc6b76fe302f001cde\",\"items\":[{\"identifier\":\"original-bolt\",\"displayName\":\"Original Bolt\"},{\"identifier\":\"original-money\",\"displayName\":\"Original Money\"},{\"identifier\":\"original-mustache\",\"displayName\":\"Original Mustache\"},{\"identifier\":\"original-arrow\",\"displayName\":\"Original Arrow\"},{\"identifier\":\"original-arrowcross\",\"displayName\":\"Original Arrowcross\"},{\"identifier\":\"original-beauty\",\"displayName\":\"Original Beauty\"},{\"identifier\":\"original-circle\",\"displayName\":\"Original Circle\"},{\"identifier\":\"original-circlestripe\",\"displayName\":\"Original Circlestripe\"},{\"identifier\":\"original-embellishment\",\"displayName\":\"Original Embellishment\"},{\"identifier\":\"original-eyelashL\",\"displayName\":\"Original EyelashL\"},{\"identifier\":\"original-eyelashR\",\"displayName\":\"Original EyelashR\"},{\"identifier\":\"original-glasses\",\"displayName\":\"Original Glasses\"},{\"identifier\":\"original-hand1\",\"displayName\":\"Original Hand1\"},{\"identifier\":\"original-hand2\",\"displayName\":\"Original Hand2\"},{\"identifier\":\"original-hexagon\",\"displayName\":\"Original Hexagon\"},{\"identifier\":\"original-kitchen\",\"displayName\":\"Original Kitchen\"},{\"identifier\":\"original-lips\",\"displayName\":\"Original Lips\"},{\"identifier\":\"original-love\",\"displayName\":\"Original Love\"},{\"identifier\":\"original-skull\",\"displayName\":\"Original Skull\"},{\"identifier\":\"original-sombrero\",\"displayName\":\"Original Sombrero\"},{\"identifier\":\"original-square\",\"displayName\":\"Original Square\"},{\"identifier\":\"original-stars\",\"displayName\":\"Original Stars\"},{\"identifier\":\"original-truth\",\"displayName\":\"Original Truth\"},{\"identifier\":\"original-wreath\",\"displayName\":\"Original Wreath\"}],\"versionKey\":\"53dfa8b965374ff32600025e\",\"v\":1411160277221,\"assetsBaseURL\":\"http://assets.aviary.com\",\"code\":0,\"status\":\"Ok\"}";
    private static final com.aviary.android.feather.common.log.LoggerFactory.Logger LOGGER;
    private static final org.aspectj.lang.JoinPoint.StaticPart ajc$tjp_0;
    private Context mContext;

    public AviaryCdsDefaultContentLoader(Context context)
    {
        mContext = context;
    }

    private static void ajc$preClinit()
    {
        Factory factory = new Factory("AviaryCdsDefaultContentLoader.java", com/aviary/android/feather/cds/AviaryCdsDefaultContentLoader);
        ajc$tjp_0 = factory.makeSJP("method-execution", factory.makeMethodSig("2", "loadPackContent", "com.aviary.android.feather.cds.AviaryCdsDefaultContentLoader", "android.database.sqlite.SQLiteDatabase:org.json.JSONObject:boolean", "db:jsonObject:includeContent", "org.json.JSONException:java.io.IOException:java.lang.AssertionError", "void"), 244);
    }

    private void extractContent(SQLiteDatabase sqlitedatabase, String s, String s1, long l, String s2)
        throws AssertionError, android.content.res.Resources.NotFoundException, IOException
    {
        boolean flag;
        LOGGER.info("extractContent: %s", new Object[] {
            s1
        });
        if (!s.startsWith("file:///android_asset/"))
        {
            LOGGER.warn("not a local file. skipping");
            return;
        }
        s2 = mContext.getResources().getAssets();
        s = s.substring("file:///android_asset/".length());
        LOGGER.verbose("filePath: %s", new Object[] {
            s
        });
        s = s2.open(s);
        int i;
        if (s != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assert.assertTrue(flag);
        LOGGER.info((new StringBuilder()).append("Extracting ").append(s1).toString());
        s1 = new File((new StringBuilder()).append(mContext.getFilesDir()).append("/").append(CdsUtils.getPackItemsContentPath(s1)).toString());
        s1.mkdirs();
        Assert.assertTrue("failed to create output dir", s1.isDirectory());
        s1.setReadable(true, false);
        IOUtils.unzip(s, s1);
        IOUtils.closeSilently(s);
        i = updateContentPath(sqlitedatabase, l, s1.getAbsolutePath());
        LOGGER.log((new StringBuilder()).append("updateContentPath result: ").append(i).toString());
        if (i > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assert.assertTrue(flag);
        return;
        sqlitedatabase;
        IOUtils.closeSilently(s);
        throw sqlitedatabase;
    }

    private void extractIcon(SQLiteDatabase sqlitedatabase, String s, String s1, long l)
        throws IOException, AssertionError, android.content.res.Resources.NotFoundException
    {
        boolean flag;
        LOGGER.info("extractIcon: %s", new Object[] {
            s1
        });
        Object obj1 = mContext.getResources().getAssets();
        Assert.assertTrue("Not a local file", s.startsWith("file:///android_asset/"));
        String s2 = s.substring("file:///android_asset/".length());
        Object obj = Uri.parse(s);
        LOGGER.verbose("filePath: %s", new Object[] {
            s2
        });
        s = ((AssetManager) (obj1)).open(s2);
        if (s != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assert.assertTrue(flag);
        s1 = (new StringBuilder()).append(mContext.getFilesDir()).append("/").append(CdsUtils.getPackIconPath(s1)).toString();
        obj1 = new File(s1);
        ((File) (obj1)).mkdirs();
        Assert.assertTrue(((File) (obj1)).isDirectory());
        obj = new File((new StringBuilder()).append(s1).append("/").append(((Uri) (obj)).getLastPathSegment()).append(".png").toString());
        LOGGER.log((new StringBuilder()).append("iconFilePath: ").append(((File) (obj)).getAbsolutePath()).toString());
        s1 = new FileOutputStream(((File) (obj)), true);
        IOUtils.copyFile(s, s1);
        IOUtils.closeSilently(s1);
        IOUtils.closeSilently(s);
        if (updateIconPath(sqlitedatabase, l, ((File) (obj)).getAbsolutePath(), 0) > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assert.assertTrue(flag);
        return;
        sqlitedatabase;
        IOUtils.closeSilently(s1);
        IOUtils.closeSilently(s);
        throw sqlitedatabase;
    }

    private long insertNewPackContentAndItems(SQLiteDatabase sqlitedatabase, ContentValues acontentvalues[])
    {
        long l;
        long l1;
        boolean flag;
        if (acontentvalues != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assert.assertTrue(flag);
        if (acontentvalues.length > 2)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assert.assertTrue(flag);
        LOGGER.log((new StringBuilder()).append("insert pack, content and items: ").append(acontentvalues.length).toString());
        l1 = CdsDatabaseHelper.insertValues("packs_table", acontentvalues[0], sqlitedatabase);
        if (l1 >= 0L) goto _L2; else goto _L1
_L1:
        LOGGER.error((new StringBuilder()).append("packId=").append(l1).toString());
        l = -1L;
_L4:
        return l;
_L2:
        ContentValues contentvalues = acontentvalues[1];
        contentvalues.put("content_packId", Long.valueOf(l1));
        l = CdsDatabaseHelper.insertValues("content_table", contentvalues, sqlitedatabase);
        if (l < 0L)
        {
            LOGGER.error((new StringBuilder()).append("rowId=").append(l).toString());
            return -1L;
        }
        int i = 2;
        do
        {
            l = l1;
            if (i >= acontentvalues.length)
            {
                continue;
            }
            ContentValues contentvalues1 = acontentvalues[i];
            contentvalues1.put("item_packId", Long.valueOf(l1));
            l = CdsDatabaseHelper.insertValues("items_table", contentvalues1, sqlitedatabase);
            if (l < 0L)
            {
                LOGGER.error((new StringBuilder()).append("itemId=").append(l).toString());
                return -1L;
            }
            i++;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void loadPackContent(SQLiteDatabase sqlitedatabase, JSONObject jsonobject, boolean flag)
        throws JSONException, IOException, AssertionError
    {
        JoinPoint joinpoint = Factory.makeJP(ajc$tjp_0, this, this, new Object[] {
            sqlitedatabase, jsonobject, Conversions.booleanObject(flag)
        });
        AviaryCdsAspect.aspectOf().invokeLoadPackMethod((new AjcClosure1(new Object[] {
            this, sqlitedatabase, jsonobject, Conversions.booleanObject(flag), joinpoint
        })).linkClosureAndJoinPoint(0x11010));
    }

    static final void loadPackContent_aroundBody0(AviaryCdsDefaultContentLoader aviarycdsdefaultcontentloader, SQLiteDatabase sqlitedatabase, JSONObject jsonobject, boolean flag, JoinPoint joinpoint)
    {
        LOGGER.info("loadPackContent");
        CdsContentParser cdscontentparser = new CdsContentParser();
        if (cdscontentparser.parse(jsonobject) != 0)
        {
            throw new AssertionFailedError(cdscontentparser.getStatus());
        }
        String s = cdscontentparser.getIdentifier();
        String s1 = cdscontentparser.getPackType();
        LOGGER.info("loadPackContent: %s", new Object[] {
            s1
        });
        ArrayList arraylist = new ArrayList();
        jsonobject = new ContentValues();
        jsonobject.put("pack_identifier", s);
        jsonobject.put("pack_type", s1);
        jsonobject.put("pack_versionKey", cdscontentparser.getVersionKey());
        jsonobject.put("pack_visible", Integer.valueOf(1));
        jsonobject.put("pack_displayOrder", Integer.valueOf(0));
        arraylist.add(jsonobject);
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("content_displayName", cdscontentparser.getDisplayName());
        contentvalues.put("content_displayDescription", cdscontentparser.getDisplayDescription());
        jsonobject = cdscontentparser.getContentURL();
        int i;
        if (jsonobject.startsWith("file://"))
        {
            contentvalues.put("content_contentURL", jsonobject);
        } else
        {
            contentvalues.put("content_contentURL", (new StringBuilder()).append(ASSET_BASE_URL).append(jsonobject).toString());
        }
        contentvalues.put("content_contentVersion", cdscontentparser.getContentVersion());
        contentvalues.put("content_iconUrl", (new StringBuilder()).append(ASSET_BASE_URL).append(cdscontentparser.getIconURL()).toString());
        contentvalues.put("content_iconVersion", cdscontentparser.getIconVersion());
        if (cdscontentparser.isFree())
        {
            i = 1;
        } else
        {
            i = 0;
        }
        contentvalues.put("content_isFree", Integer.valueOf(i));
        contentvalues.put("content_shopBackgroundColor", cdscontentparser.getShopBackgroundColor());
        contentvalues.put("content_author", cdscontentparser.getAuthor());
        contentvalues.put("content_authorHyperlink", cdscontentparser.getAuthorHyperlink());
        contentvalues.put("content_socialMediaString", cdscontentparser.getSocialMediaString());
        contentvalues.put("content_numItems", Integer.valueOf(cdscontentparser.getItems().size()));
        if (TextUtils.isEmpty(cdscontentparser.getFeatureImageURL()))
        {
            jsonobject = "";
        } else
        {
            jsonobject = (new StringBuilder()).append(ASSET_BASE_URL).append(cdscontentparser.getFeatureImageURL()).toString();
        }
        contentvalues.put("content_featureImageURL", jsonobject);
        contentvalues.put("content_featureImageVersion", cdscontentparser.getFeatureImageVersion());
        jsonobject = cdscontentparser.getPreviewURL();
        if (!TextUtils.isEmpty(jsonobject) && jsonobject.startsWith("file://"))
        {
            contentvalues.put("content_previewURL", jsonobject);
        } else
        {
            contentvalues.put("content_previewURL", (new StringBuilder()).append(ASSET_BASE_URL).append(jsonobject).toString());
        }
        contentvalues.put("content_previewVersion", cdscontentparser.getPreviewVersion());
        joinpoint = cdscontentparser.getDetailImageURL();
        if (!TextUtils.isEmpty(joinpoint))
        {
            jsonobject = joinpoint;
            if (joinpoint.startsWith("/"))
            {
                jsonobject = (new StringBuilder()).append(ASSET_BASE_URL).append(joinpoint).toString();
            }
        } else
        {
            jsonobject = "";
        }
        contentvalues.put("content_detailImageURL", jsonobject);
        contentvalues.put("content_detailImageVersion", cdscontentparser.getDetailImageURL());
        if (flag)
        {
            contentvalues.put("content_purchased", Integer.valueOf(1));
        }
        arraylist.add(contentvalues);
        jsonobject = cdscontentparser.getItems();
        for (i = 0; i < jsonobject.size(); i++)
        {
            joinpoint = (com.aviary.android.feather.cds.json.CdsContentParser.ContentItem)jsonobject.get(i);
            contentvalues = new ContentValues();
            contentvalues.put("item_identifier", joinpoint.getIdentifier());
            contentvalues.put("item_displayName", joinpoint.getDisplayName());
            if (joinpoint.getOptions() != null)
            {
                contentvalues.put("item_options", joinpoint.getOptions());
            }
            arraylist.add(contentvalues);
        }

        long l = aviarycdsdefaultcontentloader.insertNewPackContentAndItems(sqlitedatabase, (ContentValues[])arraylist.toArray(new ContentValues[arraylist.size()]));
        LOGGER.log("added pack: %d", new Object[] {
            Long.valueOf(l)
        });
        boolean flag1;
        if (l > -1L)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        Assert.assertTrue(flag1);
        aviarycdsdefaultcontentloader.extractIcon(sqlitedatabase, cdscontentparser.getIconURL(), s, l);
        if (flag)
        {
            aviarycdsdefaultcontentloader.extractContent(sqlitedatabase, cdscontentparser.getContentURL(), s, l, s1);
        }
    }

    private void updateManifestVersion(SQLiteDatabase sqlitedatabase, String s, String s1)
        throws AssertionError
    {
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("version_versionKey", s);
        contentvalues.put("version_assetsBaseURL", s1);
        boolean flag;
        if (sqlitedatabase.insert("version_table", null, contentvalues) > -1L)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assert.assertTrue(flag);
    }

    public Cursor getPackByIdentifier(SQLiteDatabase sqlitedatabase, String s, String as[])
    {
        SQLiteQueryBuilder sqlitequerybuilder = new SQLiteQueryBuilder();
        sqlitequerybuilder.setTables("packs_table");
        return sqlitequerybuilder.query(sqlitedatabase, as, "pack_identifier=?", new String[] {
            s
        }, null, null, null);
    }

    public boolean loadDefaultContent(SQLiteDatabase sqlitedatabase)
    {
        Cursor cursor;
        cursor = sqlitedatabase.query("version_table", new String[] {
            "version_id"
        }, null, null, null, null, null, "1");
        if (cursor == null)
        {
            break MISSING_BLOCK_LABEL_60;
        }
        if (cursor.getCount() <= 0)
        {
            break MISSING_BLOCK_LABEL_56;
        }
        LOGGER.warn("database is not empty");
        IOUtils.closeSilently(cursor);
        return false;
        IOUtils.closeSilently(cursor);
        if (sqlitedatabase.isReadOnly())
        {
            LOGGER.warn("Failed to load default content because db is readOnly.");
            return false;
        }
        break MISSING_BLOCK_LABEL_87;
        sqlitedatabase;
        IOUtils.closeSilently(cursor);
        throw sqlitedatabase;
        sqlitedatabase.beginTransaction();
        LOGGER.log("Beginning load default content transaction");
        loadPackContent(sqlitedatabase, new JSONObject("{\"packType\":\"effect\",\"displayName\":\"Original\",\"displayDescription\":\"Get started with this free pack of essential effects for beautiful, everyday photography.\",\"icon\":\"file:///android_asset/aviary/cdsv2/assets/images.largeIcon.be9be7e9-745f-4234-a84b-b0e043618328.300.jpg\",\"iconVersion\":\"10e000b71ff1fc07b275f460783850f7\",\"author\":\"Aviary\",\"authorHyperlink\":null,\"socialMediaString\":null,\"previewURL\":\"/cdsv2/assets/com.aviary.effectpack.04/zips.androidPreviewPhoneXXHiRes.4e8edf7f-538b-4afa-bb63-3f5327b51436.zip\",\"previewVersion\":\"29318948dc1b06497c6887fbd1dc0f7f\",\"contentURL\":\"file:///android_asset/aviary/cdsv2/assets/zips.effectJSON.235ff3a1-fdd8-4d16-b625-517945f61c82.zip\",\"contentVersion\":\"b74040f3396d01906ff02a346dfd4f21\",\"isFree\":true,\"pcnPriceTier\":0,\"identifier\":\"com.aviary.effectpack.04\",\"featureImageURL\":\"/cdsv2/testcontent/com.aviary.effectpack.04/images.androidFeatureImage.81f193b2-d02c-4dba-8811-31a77b359fbb.980.jpg\",\"featureImageVersion\":\"0\",\"detailImageURL\":\"/cdsv2/testcontent/com.aviary.effectpack.04/images.androidDetailImage.dff72372-7f7e-4bc1-aa98-88ac17fb5457.1080.jpg\",\"detailImageVersion\":\"0\",\"items\":[{\"identifier\":\"default5\",\"displayName\":\"Clyde\"},{\"identifier\":\"default10\",\"displayName\":\"Avenue\"},{\"identifier\":\"default2\",\"displayName\":\"Haas\"},{\"identifier\":\"default9\",\"displayName\":\"Arizona\"},{\"identifier\":\"default11\",\"displayName\":\"Lucky\"},{\"identifier\":\"default1\",\"displayName\":\"Dean\"},{\"identifier\":\"default8\",\"displayName\":\"Keylime\"},{\"identifier\":\"default3\",\"displayName\":\"Boardwalk\"},{\"identifier\":\"default7\",\"displayName\":\"Sentosa\"},{\"identifier\":\"default13\",\"displayName\":\"Sage\"},{\"identifier\":\"default6\",\"displayName\":\"Metropolis\"},{\"identifier\":\"default12\",\"displayName\":\"Cruz\"}],\"versionKey\":\"53a0643f5920039d84000167\",\"v\":1404419997941,\"code\":0,\"status\":\"Ok\"}"), true);
        loadPackContent(sqlitedatabase, new JSONObject("{\"packType\":\"sticker\",\"displayName\":\"Original\",\"displayDescription\":\"Decorate all of your photos with this fun and totally free pack of hats, eyewear, neckwear, speech bubbles, shapes and more!\",\"icon\":\"file:///android_asset/aviary/cdsv2/assets/images.largeIcon.593086a0-76eb-44a5-9285-2459e4660bd8.300.png\",\"iconVersion\":\"94e5bb72e131575b612a49c68c95bbd3\",\"author\":\"Aviary\",\"authorHyperlink\":null,\"socialMediaString\":null,\"shopBackgroundColor\":\"#1c2027\",\"featureImageURL\":\"/cdsv2/assets/com.aviary.sticker.53d185cc6b76fe302f001cde/images.androidFeatureImage.faedc45c-e914-4bd4-95f7-5ebeccb781be.980.jpg\",\"featureImageVersion\":\"e8c8e313e8c7f73563d412749f961a80\",\"detailImageURL\":\"file:///android_asset/aviary/cdsv2/assets/images.androidDetailImage.9cdb2f88-b089-458a-9f23-76400c261b0b.1080.jpg\",\"detailImageVersion\":\"81a734b8cdc31dcb8dcd5663cd382645\",\"previewURL\":\"file:///android_asset/aviary/cdsv2/assets/zips.androidPreviewHiRes.733886ea-16cc-4292-8af7-6b3c78caa187.zip\",\"previewVersion\":\"b21916443b1bdcb699e6f99bab5bea6c\",\"contentURL\":\"/cdsv2/assets/com.aviary.sticker.53d185cc6b76fe302f001cde/zips.contentAndroidHiRes.0137fe97-9900-480e-bacc-51ed4128ca46.zip\",\"contentVersion\":\"2139119ea57de6f295d5ae2274ba8c14\",\"isFree\":true,\"pcnPriceTier\":2,\"identifier\":\"com.aviary.sticker.53d185cc6b76fe302f001cde\",\"items\":[{\"identifier\":\"original-bolt\",\"displayName\":\"Original Bolt\"},{\"identifier\":\"original-money\",\"displayName\":\"Original Money\"},{\"identifier\":\"original-mustache\",\"displayName\":\"Original Mustache\"},{\"identifier\":\"original-arrow\",\"displayName\":\"Original Arrow\"},{\"identifier\":\"original-arrowcross\",\"displayName\":\"Original Arrowcross\"},{\"identifier\":\"original-beauty\",\"displayName\":\"Original Beauty\"},{\"identifier\":\"original-circle\",\"displayName\":\"Original Circle\"},{\"identifier\":\"original-circlestripe\",\"displayName\":\"Original Circlestripe\"},{\"identifier\":\"original-embellishment\",\"displayName\":\"Original Embellishment\"},{\"identifier\":\"original-eyelashL\",\"displayName\":\"Original EyelashL\"},{\"identifier\":\"original-eyelashR\",\"displayName\":\"Original EyelashR\"},{\"identifier\":\"original-glasses\",\"displayName\":\"Original Glasses\"},{\"identifier\":\"original-hand1\",\"displayName\":\"Original Hand1\"},{\"identifier\":\"original-hand2\",\"displayName\":\"Original Hand2\"},{\"identifier\":\"original-hexagon\",\"displayName\":\"Original Hexagon\"},{\"identifier\":\"original-kitchen\",\"displayName\":\"Original Kitchen\"},{\"identifier\":\"original-lips\",\"displayName\":\"Original Lips\"},{\"identifier\":\"original-love\",\"displayName\":\"Original Love\"},{\"identifier\":\"original-skull\",\"displayName\":\"Original Skull\"},{\"identifier\":\"original-sombrero\",\"displayName\":\"Original Sombrero\"},{\"identifier\":\"original-square\",\"displayName\":\"Original Square\"},{\"identifier\":\"original-stars\",\"displayName\":\"Original Stars\"},{\"identifier\":\"original-truth\",\"displayName\":\"Original Truth\"},{\"identifier\":\"original-wreath\",\"displayName\":\"Original Wreath\"}],\"versionKey\":\"53dfa8b965374ff32600025e\",\"v\":1411160277221,\"assetsBaseURL\":\"http://assets.aviary.com\",\"code\":0,\"status\":\"Ok\"}"), false);
        loadPackContent(sqlitedatabase, new JSONObject("{\"packType\":\"frame\",\"displayName\":\"Original\",\"displayDescription\":\"A collection of beautiful, versatile frames to get you started with Aviary.\",\"icon\":\"file:///android_asset/aviary/cdsv2/assets/images.largeIcon.7b749c3b-f657-4c39-8919-9f065caef753.300.png\",\"iconVersion\":\"4c1240a2312b16c113b5704fd277a4d7\",\"author\":\"Aviary\",\"authorHyperlink\":null,\"socialMediaString\":null,\"shopBackgroundColor\":\"#1c2027\",\"featureImageURL\":\"/cdsv2/assets/com.aviary.frame.53ced8b78abeb3083b001e4a/images.androidFeatureImage.31ad3bc8-af49-4a00-9445-1463854ad589.980.jpg\",\"featureImageVersion\":\"edfa3dcb2a52de25edc38e3349920cc3\",\"detailImageURL\":\"file:///android_asset/aviary/cdsv2/assets/images.androidDetailImage.9cf957a7-be64-4dbb-818b-63ba2854dec9.1080.jpg\",\"detailImageVersion\":\"0a1f306453a963546067379785c9828b\",\"previewURL\":\"file:///android_asset/aviary/cdsv2/assets/zips.androidPreviewHiRes.783ecc43-f4fa-4818-9a87-97b1c84f68ee.zip\",\"previewVersion\":\"546b8a102022342dc2d2dc000a90a5a0\",\"contentURL\":\"/cdsv2/assets/com.aviary.frame.53ced8b78abeb3083b001e4a/zips.contentAndroidHiRes.51b9118e-1527-4a42-bea9-856adff83db3.zip\",\"contentVersion\":\"3820dfc8be90338a24fbf5abdb3c07a9\",\"isFree\":true,\"pcnPriceTier\":2,\"identifier\":\"com.aviary.frame.53ced8b78abeb3083b001e4a\",\"items\":[{\"identifier\":\"original-Aura\",\"displayName\":\"Aura\",\"options\":{\"width\":0.5}},{\"identifier\":\"original-Borde\",\"displayName\":\"Borde\",\"options\":{\"width\":0.5}},{\"identifier\":\"original-Lumen\",\"displayName\":\"Lumen\",\"options\":{\"width\":0.3}},{\"identifier\":\"original-Noir\",\"displayName\":\"Noir\",\"options\":{\"width\":0.35}},{\"identifier\":\"original-Stella\",\"displayName\":\"Stella\",\"options\":{\"width\":0.35}},{\"identifier\":\"original-Notte\",\"displayName\":\"Notte\",\"options\":{\"width\":0.35}},{\"identifier\":\"original-Vela\",\"displayName\":\"Vela\",\"options\":{\"width\":0.35}},{\"identifier\":\"original-Capa\",\"displayName\":\"Capa\",\"options\":{\"width\":0.35}},{\"identifier\":\"original-Sole\",\"displayName\":\"Sole\",\"options\":{\"width\":0.4}},{\"identifier\":\"original-Luna\",\"displayName\":\"Luna\",\"options\":{\"width\":0.4}},{\"identifier\":\"original-Fino\",\"displayName\":\"Fino\",\"options\":{\"width\":0.5}},{\"identifier\":\"original-Rima\",\"displayName\":\"Rima\",\"options\":{\"width\":0.5}}],\"versionKey\":\"53cedd7e8abeb3083b001fc1\",\"v\":1411160596064,\"assetsBaseURL\":\"http://assets.aviary.com\",\"code\":0,\"status\":\"Ok\"}"), false);
        loadPackContent(sqlitedatabase, new JSONObject("{\"packType\":\"overlay\",\"displayName\":\"Original\",\"displayDescription\":\"The original overlay pack.\",\"icon\":\"file:///android_asset/aviary/cdsv2/assets/images.largeIcon.7ca38498-e0e7-448e-b80a-f1666798d100.300.png\",\"iconVersion\":\"4f5885e76982129580ba42c72937c6a4\",\"author\":\"Aviary\",\"authorHyperlink\":null,\"socialMediaString\":null,\"shopBackgroundColor\":\"#DDDDDD\",\"featureImageURL\":\"/cdsv2/assets/com.aviary.overlay.5410c5590c677e6c6a0000be/images.androidFeatureImage.4bfea2f8-ad1a-4d2a-a954-5b59c7b08dc1.980.jpg\",\"featureImageVersion\":\"b0affe82806fbb5ccb91aad6757e313f\",\"detailImageURL\":\"file:///android_asset/aviary/cdsv2/assets/images.androidDetailImage.87ea0744-5ddb-47f6-8253-728f4215d77e.1080.jpg\",\"detailImageVersion\":\"9c21fdce8f7932f1db0385dc6d898dba\",\"previewURL\":\"file:///android_asset/aviary/cdsv2/assets/zips.androidPreviewHiRes.e4d720d7-dc74-4a74-9ea9-b34d6537a547.zip\",\"previewVersion\":\"5925c1155df807830d49b0ced53beffd\",\"contentURL\":\"/cdsv2/assets/com.aviary.overlay.5410c5590c677e6c6a0000be/zips.contentAndroidHiRes.b2ec3b46-e39f-49fc-a117-3873f18c5fc8.zip\",\"contentVersion\":\"c262130f5614ca1066c4f3397f331bf6\",\"isFree\":true,\"pcnPriceTier\":2,\"identifier\":\"com.aviary.overlay.5410c5590c677e6c6a0000be\",\"items\":[{\"identifier\":\"circle-black\",\"displayName\":\"Radius\"},{\"identifier\":\"circle-white\",\"displayName\":\"Hole\"},{\"identifier\":\"cross-black\",\"displayName\":\"Cross\"},{\"identifier\":\"cross-white\",\"displayName\":\"Plus\"},{\"identifier\":\"hexagon-black\",\"displayName\":\"Hex\"},{\"identifier\":\"hexagon-white\",\"displayName\":\"hexagon-white\"},{\"identifier\":\"line-black\",\"displayName\":\"Vert1\"},{\"identifier\":\"line-white\",\"displayName\":\"Vert2\"},{\"identifier\":\"line2-black\",\"displayName\":\"Horace\"},{\"identifier\":\"line2-white\",\"displayName\":\"White Out\"},{\"identifier\":\"square-black\",\"displayName\":\"Square\"},{\"identifier\":\"square-white\",\"displayName\":\"Box\"},{\"identifier\":\"blue\",\"displayName\":\"Blue\"}],\"versionKey\":\"5429b4e60ea3724a030003dc\",\"v\":1412106604749,\"assetsBaseURL\":\"http://testassets.aviary.com.s3.amazonaws.com\",\"code\":0,\"status\":\"Ok\"}"), false);
        updateManifestVersion(sqlitedatabase, "0", ASSET_BASE_URL);
        sqlitedatabase.setTransactionSuccessful();
        LOGGER.log("finally");
        sqlitedatabase.endTransaction();
        LOGGER.log("Load default content success");
        return true;
        Object obj;
        obj;
        ((Throwable) (obj)).printStackTrace();
        LOGGER.warn("Error in JSON parsing.");
        LOGGER.log("finally");
        sqlitedatabase.endTransaction();
        return false;
        obj;
        LOGGER.log("finally");
        sqlitedatabase.endTransaction();
        throw obj;
    }

    public int updateContentPath(SQLiteDatabase sqlitedatabase, long l, String s)
    {
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("content_contentPath", s);
        contentvalues.put("content_installDate", DateTimeUtils.toSqlDateTime(System.currentTimeMillis()));
        return sqlitedatabase.update("content_table", contentvalues, "content_packId=?", new String[] {
            String.valueOf(l)
        });
    }

    public int updateIconPath(SQLiteDatabase sqlitedatabase, long l, String s, int i)
    {
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("content_iconPath", s);
        contentvalues.put("content_iconNeedDownload", Integer.valueOf(i));
        return sqlitedatabase.update("content_table", contentvalues, "content_packId=?", new String[] {
            String.valueOf(l)
        });
    }

    static 
    {
        ajc$preClinit();
        LOGGER = LoggerFactory.getLogger("AviaryCdsDefaultContentLoader", com.aviary.android.feather.common.log.LoggerFactory.LoggerType.ConsoleLoggerType);
        String s;
        if ("alpha".equals("production"))
        {
            s = "http://testassets.aviary.com.s3.amazonaws.com";
        } else
        {
            s = "http://assets.aviary.com";
        }
        ASSET_BASE_URL = s;
    }

    private class AjcClosure1 extends AroundClosure
    {

        public Object run(Object aobj[])
        {
            aobj = super.state;
            AviaryCdsDefaultContentLoader.loadPackContent_aroundBody0((AviaryCdsDefaultContentLoader)aobj[0], (SQLiteDatabase)aobj[1], (JSONObject)aobj[2], Conversions.booleanValue(aobj[3]), (JoinPoint)aobj[4]);
            return null;
        }

        public AjcClosure1(Object aobj[])
        {
            super(aobj);
        }
    }

}
