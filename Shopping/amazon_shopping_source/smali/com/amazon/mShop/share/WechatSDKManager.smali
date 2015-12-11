.class public Lcom/amazon/mShop/share/WechatSDKManager;
.super Ljava/lang/Object;
.source "WechatSDKManager.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/mShop/share/WechatSDKManager$1;,
        Lcom/amazon/mShop/share/WechatSDKManager$WechatMessageParams;,
        Lcom/amazon/mShop/share/WechatSDKManager$SendResponseTask;,
        Lcom/amazon/mShop/share/WechatSDKManager$SendRequestTask;
    }
.end annotation


# static fields
.field private static sPendingTransaction:Ljava/lang/String;

.field private static sWXapi:Lcom/tencent/mm/sdk/openapi/IWXAPI;

.field private static sWechatLauncherInfo:Lcom/amazon/mShop/share/SharableAppInfo;


# direct methods
.method static constructor <clinit>()V
    .locals 7

    .prologue
    const/4 v1, 0x0

    .line 38
    sput-object v1, Lcom/amazon/mShop/share/WechatSDKManager;->sPendingTransaction:Ljava/lang/String;

    .line 47
    new-instance v0, Lcom/amazon/mShop/share/SharableAppInfo;

    invoke-static {}, Lcom/amazon/mShop/share/SocialAppConfig;->getWechatPackageName()Ljava/lang/String;

    move-result-object v3

    const-string/jumbo v4, "we_upd_awd_wl"

    invoke-static {}, Lcom/amazon/mShop/share/SocialAppConfig;->getDefaultPriority()I

    move-result v5

    move-object v2, v1

    move-object v6, v1

    invoke-direct/range {v0 .. v6}, Lcom/amazon/mShop/share/SharableAppInfo;-><init>(Ljava/lang/CharSequence;Landroid/graphics/drawable/Drawable;Ljava/lang/String;Ljava/lang/String;ILandroid/content/pm/ResolveInfo;)V

    sput-object v0, Lcom/amazon/mShop/share/WechatSDKManager;->sWechatLauncherInfo:Lcom/amazon/mShop/share/SharableAppInfo;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 36
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 347
    return-void
.end method

.method static synthetic access$200(Landroid/content/Context;Landroid/content/Intent;Z)Lcom/tencent/mm/sdk/modelmsg/WXMediaMessage;
    .locals 1
    .param p0, "x0"    # Landroid/content/Context;
    .param p1, "x1"    # Landroid/content/Intent;
    .param p2, "x2"    # Z

    .prologue
    .line 36
    invoke-static {p0, p1, p2}, Lcom/amazon/mShop/share/WechatSDKManager;->buildMessage(Landroid/content/Context;Landroid/content/Intent;Z)Lcom/tencent/mm/sdk/modelmsg/WXMediaMessage;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$300(Landroid/content/Intent;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Landroid/content/Intent;

    .prologue
    .line 36
    invoke-static {p0}, Lcom/amazon/mShop/share/WechatSDKManager;->buildTransaction(Landroid/content/Intent;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$400()Ljava/lang/String;
    .locals 1

    .prologue
    .line 36
    sget-object v0, Lcom/amazon/mShop/share/WechatSDKManager;->sPendingTransaction:Ljava/lang/String;

    return-object v0
.end method

.method private static buildMessage(Landroid/content/Context;Landroid/content/Intent;Z)Lcom/tencent/mm/sdk/modelmsg/WXMediaMessage;
    .locals 11
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "shareIntent"    # Landroid/content/Intent;
    .param p2, "shareToFriend"    # Z

    .prologue
    const/4 v2, 0x0

    .line 175
    const-string/jumbo v9, "android.intent.extra.TEXT"

    invoke-virtual {p1, v9}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    .line 176
    .local v7, "shareContent":Ljava/lang/String;
    const-string/jumbo v9, "android.intent.extra.SUBJECT"

    invoke-virtual {p1, v9}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    .line 177
    .local v5, "productSubject":Ljava/lang/String;
    invoke-static {v7}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v9

    if-nez v9, :cond_0

    invoke-static {v5}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v9

    if-eqz v9, :cond_1

    .line 208
    :cond_0
    :goto_0
    return-object v2

    .line 181
    :cond_1
    const-string/jumbo v9, "(http|https)://\\S*"

    invoke-static {v9}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;)Ljava/util/regex/Pattern;

    move-result-object v8

    .line 182
    .local v8, "shareUrlPattern":Ljava/util/regex/Pattern;
    invoke-virtual {v8, v7}, Ljava/util/regex/Pattern;->matcher(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;

    move-result-object v1

    .line 183
    .local v1, "matcher":Ljava/util/regex/Matcher;
    invoke-virtual {v1}, Ljava/util/regex/Matcher;->find()Z

    move-result v9

    if-eqz v9, :cond_0

    .line 186
    const/4 v9, 0x0

    invoke-virtual {v1}, Ljava/util/regex/Matcher;->start()I

    move-result v10

    invoke-virtual {v7, v9, v10}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v4

    .line 187
    .local v4, "productDescription":Ljava/lang/String;
    invoke-virtual {v1}, Ljava/util/regex/Matcher;->start()I

    move-result v9

    invoke-virtual {v1}, Ljava/util/regex/Matcher;->end()I

    move-result v10

    invoke-virtual {v7, v9, v10}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v6

    .line 191
    .local v6, "productUrl":Ljava/lang/String;
    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v9

    sget v10, Lcom/amazon/mShop/android/lib/R$string;->sharing_sms_heading:I

    invoke-virtual {v9, v10}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 192
    .local v0, "dpShareHeading":Ljava/lang/String;
    invoke-virtual {v7, v0}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v9

    if-eqz v9, :cond_2

    .line 193
    const-string/jumbo v9, ""

    invoke-virtual {v4, v0, v9}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v4

    .line 196
    :cond_2
    new-instance v3, Lcom/tencent/mm/sdk/modelmsg/WXWebpageObject;

    invoke-direct {v3, v6}, Lcom/tencent/mm/sdk/modelmsg/WXWebpageObject;-><init>(Ljava/lang/String;)V

    .line 197
    .local v3, "mediaObject":Lcom/tencent/mm/sdk/modelmsg/WXWebpageObject;
    new-instance v2, Lcom/tencent/mm/sdk/modelmsg/WXMediaMessage;

    invoke-direct {v2, v3}, Lcom/tencent/mm/sdk/modelmsg/WXMediaMessage;-><init>(Lcom/tencent/mm/sdk/modelmsg/WXMediaMessage$IMediaObject;)V

    .line 198
    .local v2, "mediaMessage":Lcom/tencent/mm/sdk/modelmsg/WXMediaMessage;
    if-eqz p2, :cond_3

    .line 199
    iput-object v5, v2, Lcom/tencent/mm/sdk/modelmsg/WXMediaMessage;->title:Ljava/lang/String;

    .line 206
    :goto_1
    iput-object v4, v2, Lcom/tencent/mm/sdk/modelmsg/WXMediaMessage;->description:Ljava/lang/String;

    .line 207
    invoke-static {p0, p1}, Lcom/amazon/mShop/share/WechatSDKManager;->processThumbnail(Landroid/content/Context;Landroid/content/Intent;)Landroid/graphics/Bitmap;

    move-result-object v9

    invoke-virtual {v2, v9}, Lcom/tencent/mm/sdk/modelmsg/WXMediaMessage;->setThumbImage(Landroid/graphics/Bitmap;)V

    goto :goto_0

    .line 204
    :cond_3
    iput-object v4, v2, Lcom/tencent/mm/sdk/modelmsg/WXMediaMessage;->title:Ljava/lang/String;

    goto :goto_1
.end method

.method private static buildTransaction(Landroid/content/Intent;)Ljava/lang/String;
    .locals 4
    .param p0, "shareIntent"    # Landroid/content/Intent;

    .prologue
    .line 212
    const-string/jumbo v1, "android.intent.extra.TEXT"

    invoke-virtual {p0, v1}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 213
    .local v0, "shareContent":Ljava/lang/String;
    if-nez v0, :cond_0

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v1

    invoke-static {v1, v2}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v1

    :goto_0
    return-object v1

    :cond_0
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    invoke-virtual {v1, v2, v3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    goto :goto_0
.end method

.method public static clearPendingTransaction()V
    .locals 1

    .prologue
    .line 86
    const/4 v0, 0x0

    sput-object v0, Lcom/amazon/mShop/share/WechatSDKManager;->sPendingTransaction:Ljava/lang/String;

    .line 87
    return-void
.end method

.method public static getAPIHandle(Landroid/content/Context;)Lcom/tencent/mm/sdk/openapi/IWXAPI;
    .locals 2
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 149
    sget-object v0, Lcom/amazon/mShop/share/WechatSDKManager;->sWXapi:Lcom/tencent/mm/sdk/openapi/IWXAPI;

    if-nez v0, :cond_0

    .line 150
    const-string/jumbo v0, "wx58ea2d5aab116b83"

    const/4 v1, 0x1

    invoke-static {p0, v0, v1}, Lcom/tencent/mm/sdk/openapi/WXAPIFactory;->createWXAPI(Landroid/content/Context;Ljava/lang/String;Z)Lcom/tencent/mm/sdk/openapi/IWXAPI;

    move-result-object v0

    sput-object v0, Lcom/amazon/mShop/share/WechatSDKManager;->sWXapi:Lcom/tencent/mm/sdk/openapi/IWXAPI;

    .line 151
    sget-object v0, Lcom/amazon/mShop/share/WechatSDKManager;->sWXapi:Lcom/tencent/mm/sdk/openapi/IWXAPI;

    if-eqz v0, :cond_0

    .line 152
    sget-object v0, Lcom/amazon/mShop/share/WechatSDKManager;->sWXapi:Lcom/tencent/mm/sdk/openapi/IWXAPI;

    const-string/jumbo v1, "wx58ea2d5aab116b83"

    invoke-interface {v0, v1}, Lcom/tencent/mm/sdk/openapi/IWXAPI;->registerApp(Ljava/lang/String;)Z

    .line 155
    :cond_0
    sget-object v0, Lcom/amazon/mShop/share/WechatSDKManager;->sWXapi:Lcom/tencent/mm/sdk/openapi/IWXAPI;

    return-object v0
.end method

.method public static getIconLaunchReftag()Ljava/lang/String;
    .locals 1

    .prologue
    .line 171
    const-string/jumbo v0, "we_an_il"

    return-object v0
.end method

.method public static getWechatLauncherInfo()Lcom/amazon/mShop/share/SharableAppInfo;
    .locals 1

    .prologue
    .line 163
    sget-object v0, Lcom/amazon/mShop/share/WechatSDKManager;->sWechatLauncherInfo:Lcom/amazon/mShop/share/SharableAppInfo;

    return-object v0
.end method

.method public static hasPendingTransaction()Z
    .locals 1

    .prologue
    .line 71
    sget-object v0, Lcom/amazon/mShop/share/WechatSDKManager;->sPendingTransaction:Ljava/lang/String;

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private static paddingThumbnail(Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
    .locals 10
    .param p0, "srcThumbnail"    # Landroid/graphics/Bitmap;

    .prologue
    const/4 v9, 0x0

    const/4 v8, 0x0

    const/16 v7, 0xc8

    const/16 v6, 0xff

    .line 253
    invoke-virtual {p0}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v2

    .line 254
    .local v2, "height":I
    invoke-virtual {p0}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v4

    .line 255
    .local v4, "width":I
    const/4 v1, 0x0

    .line 257
    .local v1, "dstThumbnail":Landroid/graphics/Bitmap;
    if-ne v2, v4, :cond_1

    .line 258
    move-object v1, p0

    .line 275
    :goto_0
    invoke-virtual {v1}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v5

    if-le v5, v7, :cond_0

    .line 276
    const/4 v5, 0x0

    invoke-static {v1, v7, v7, v5}, Landroid/graphics/Bitmap;->createScaledBitmap(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;

    move-result-object v1

    .line 278
    .end local v1    # "dstThumbnail":Landroid/graphics/Bitmap;
    :cond_0
    return-object v1

    .line 259
    .restart local v1    # "dstThumbnail":Landroid/graphics/Bitmap;
    :cond_1
    if-le v2, v4, :cond_2

    .line 260
    sub-int v3, v2, v4

    .line 261
    .local v3, "padding":I
    sget-object v5, Landroid/graphics/Bitmap$Config;->ARGB_8888:Landroid/graphics/Bitmap$Config;

    invoke-static {v2, v2, v5}, Landroid/graphics/Bitmap;->createBitmap(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;

    move-result-object v1

    .line 262
    new-instance v0, Landroid/graphics/Canvas;

    invoke-direct {v0, v1}, Landroid/graphics/Canvas;-><init>(Landroid/graphics/Bitmap;)V

    .line 264
    .local v0, "canvas":Landroid/graphics/Canvas;
    invoke-virtual {v0, v6, v6, v6, v6}, Landroid/graphics/Canvas;->drawARGB(IIII)V

    .line 265
    div-int/lit8 v5, v3, 0x2

    int-to-float v5, v5

    invoke-virtual {v0, p0, v5, v8, v9}, Landroid/graphics/Canvas;->drawBitmap(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V

    goto :goto_0

    .line 267
    .end local v0    # "canvas":Landroid/graphics/Canvas;
    .end local v3    # "padding":I
    :cond_2
    sub-int v3, v4, v2

    .line 268
    .restart local v3    # "padding":I
    sget-object v5, Landroid/graphics/Bitmap$Config;->ARGB_8888:Landroid/graphics/Bitmap$Config;

    invoke-static {v4, v4, v5}, Landroid/graphics/Bitmap;->createBitmap(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;

    move-result-object v1

    .line 269
    new-instance v0, Landroid/graphics/Canvas;

    invoke-direct {v0, v1}, Landroid/graphics/Canvas;-><init>(Landroid/graphics/Bitmap;)V

    .line 271
    .restart local v0    # "canvas":Landroid/graphics/Canvas;
    invoke-virtual {v0, v6, v6, v6, v6}, Landroid/graphics/Canvas;->drawARGB(IIII)V

    .line 272
    div-int/lit8 v5, v3, 0x2

    int-to-float v5, v5

    invoke-virtual {v0, p0, v8, v5, v9}, Landroid/graphics/Canvas;->drawBitmap(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V

    goto :goto_0
.end method

.method private static processThumbnail(Landroid/content/Context;Landroid/content/Intent;)Landroid/graphics/Bitmap;
    .locals 11
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "shareIntent"    # Landroid/content/Intent;

    .prologue
    const/16 v10, 0x32

    .line 217
    const/4 v4, 0x0

    .line 219
    .local v4, "productThumbnail":Landroid/graphics/Bitmap;
    const-string/jumbo v8, "mShop.android.intent.extra.THUMBNAIL"

    invoke-virtual {p1, v8}, Landroid/content/Intent;->hasExtra(Ljava/lang/String;)Z

    move-result v8

    if-eqz v8, :cond_1

    .line 220
    const-string/jumbo v8, "mShop.android.intent.extra.THUMBNAIL"

    invoke-virtual {p1, v8}, Landroid/content/Intent;->getByteArrayExtra(Ljava/lang/String;)[B

    move-result-object v6

    .line 221
    .local v6, "thumbnailBuffer":[B
    if-eqz v6, :cond_0

    .line 223
    const/4 v8, 0x0

    :try_start_0
    array-length v9, v6

    invoke-static {v6, v8, v9}, Landroid/graphics/BitmapFactory;->decodeByteArray([BII)Landroid/graphics/Bitmap;

    move-result-object v5

    .line 224
    .local v5, "thumbnailBitmap":Landroid/graphics/Bitmap;
    invoke-static {v5}, Lcom/amazon/mShop/share/WechatSDKManager;->paddingThumbnail(Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
    :try_end_0
    .catch Ljava/lang/OutOfMemoryError; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v4

    .line 249
    .end local v5    # "thumbnailBitmap":Landroid/graphics/Bitmap;
    .end local v6    # "thumbnailBuffer":[B
    :cond_0
    :goto_0
    return-object v4

    .line 225
    .restart local v6    # "thumbnailBuffer":[B
    :catch_0
    move-exception v3

    .line 228
    .local v3, "oome":Ljava/lang/OutOfMemoryError;
    invoke-static {v10}, Lcom/amazon/mShop/net/LRUCache;->reduceByPercent(I)V

    goto :goto_0

    .line 231
    .end local v3    # "oome":Ljava/lang/OutOfMemoryError;
    .end local v6    # "thumbnailBuffer":[B
    :cond_1
    const-string/jumbo v8, "imgUrl"

    invoke-virtual {p1, v8}, Landroid/content/Intent;->hasExtra(Ljava/lang/String;)Z

    move-result v8

    if-eqz v8, :cond_0

    .line 232
    const-string/jumbo v8, "imgUrl"

    invoke-virtual {p1, v8}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    .line 234
    .local v7, "urlString":Ljava/lang/String;
    :try_start_1
    new-instance v1, Ljava/net/URL;

    invoke-direct {v1, v7}, Ljava/net/URL;-><init>(Ljava/lang/String;)V

    .line 235
    .local v1, "imageUrl":Ljava/net/URL;
    invoke-virtual {v1}, Ljava/net/URL;->openConnection()Ljava/net/URLConnection;

    move-result-object v2

    .line 236
    .local v2, "imageUrlConnection":Ljava/net/URLConnection;
    const/16 v8, 0x3e8

    invoke-virtual {v2, v8}, Ljava/net/URLConnection;->setConnectTimeout(I)V

    .line 237
    const/16 v8, 0xbb8

    invoke-virtual {v2, v8}, Ljava/net/URLConnection;->setReadTimeout(I)V

    .line 238
    invoke-virtual {v2}, Ljava/net/URLConnection;->getInputStream()Ljava/io/InputStream;

    move-result-object v8

    invoke-static {v8}, Landroid/graphics/BitmapFactory;->decodeStream(Ljava/io/InputStream;)Landroid/graphics/Bitmap;

    move-result-object v5

    .line 239
    .restart local v5    # "thumbnailBitmap":Landroid/graphics/Bitmap;
    if-eqz v5, :cond_0

    .line 240
    invoke-static {v5}, Lcom/amazon/mShop/share/WechatSDKManager;->paddingThumbnail(Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
    :try_end_1
    .catch Ljava/lang/Throwable; {:try_start_1 .. :try_end_1} :catch_1

    move-result-object v4

    goto :goto_0

    .line 242
    .end local v1    # "imageUrl":Ljava/net/URL;
    .end local v2    # "imageUrlConnection":Ljava/net/URLConnection;
    .end local v5    # "thumbnailBitmap":Landroid/graphics/Bitmap;
    :catch_1
    move-exception v0

    .line 243
    .local v0, "e":Ljava/lang/Throwable;
    instance-of v8, v0, Ljava/lang/OutOfMemoryError;

    if-eqz v8, :cond_2

    .line 244
    invoke-static {v10}, Lcom/amazon/mShop/net/LRUCache;->reduceByPercent(I)V

    .line 246
    :cond_2
    const-string/jumbo v8, "WechatSDKManager"

    new-instance v9, Ljava/lang/StringBuilder;

    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v10, "Failed to load product thumbnail from url, "

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v0}, Ljava/lang/Throwable;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-static {v8, v9}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0
.end method

.method public static sendRequest(Landroid/content/Context;Landroid/content/Intent;Ljava/lang/String;)Z
    .locals 6
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "shareIntent"    # Landroid/content/Intent;
    .param p2, "packageName"    # Ljava/lang/String;

    .prologue
    const/4 v5, 0x0

    .line 111
    invoke-static {}, Lcom/amazon/mShop/share/SocialAppConfig;->getWechatPackageName()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {p2, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    .line 112
    .local v2, "shareToFriend":Z
    new-instance v3, Lcom/amazon/mShop/share/WechatSDKManager$WechatMessageParams;

    invoke-direct {v3, p0, p1, v2}, Lcom/amazon/mShop/share/WechatSDKManager$WechatMessageParams;-><init>(Landroid/content/Context;Landroid/content/Intent;Z)V

    .line 113
    .local v3, "taskParams":Lcom/amazon/mShop/share/WechatSDKManager$WechatMessageParams;
    new-instance v1, Lcom/amazon/mShop/share/WechatSDKManager$SendRequestTask;

    const/4 v4, 0x0

    invoke-direct {v1, v4}, Lcom/amazon/mShop/share/WechatSDKManager$SendRequestTask;-><init>(Lcom/amazon/mShop/share/WechatSDKManager$1;)V

    .line 114
    .local v1, "sendRequestTask":Lcom/amazon/mShop/share/WechatSDKManager$SendRequestTask;
    const/4 v4, 0x1

    new-array v4, v4, [Lcom/amazon/mShop/share/WechatSDKManager$WechatMessageParams;

    aput-object v3, v4, v5

    invoke-virtual {v1, v4}, Lcom/amazon/mShop/share/WechatSDKManager$SendRequestTask;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 118
    :try_start_0
    invoke-virtual {v1}, Lcom/amazon/mShop/share/WechatSDKManager$SendRequestTask;->get()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/Boolean;

    invoke-virtual {v4}, Ljava/lang/Boolean;->booleanValue()Z
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result v4

    .line 120
    :goto_0
    return v4

    .line 119
    :catch_0
    move-exception v0

    .local v0, "ex":Ljava/lang/Exception;
    move v4, v5

    .line 120
    goto :goto_0
.end method

.method public static sendResponse(Landroid/content/Context;Landroid/content/Intent;)Z
    .locals 6
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "shareIntent"    # Landroid/content/Intent;

    .prologue
    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 131
    new-instance v2, Lcom/amazon/mShop/share/WechatSDKManager$WechatMessageParams;

    invoke-direct {v2, p0, p1, v5}, Lcom/amazon/mShop/share/WechatSDKManager$WechatMessageParams;-><init>(Landroid/content/Context;Landroid/content/Intent;Z)V

    .line 132
    .local v2, "taskParams":Lcom/amazon/mShop/share/WechatSDKManager$WechatMessageParams;
    new-instance v1, Lcom/amazon/mShop/share/WechatSDKManager$SendResponseTask;

    const/4 v3, 0x0

    invoke-direct {v1, v3}, Lcom/amazon/mShop/share/WechatSDKManager$SendResponseTask;-><init>(Lcom/amazon/mShop/share/WechatSDKManager$1;)V

    .line 133
    .local v1, "sendResponseTask":Lcom/amazon/mShop/share/WechatSDKManager$SendResponseTask;
    new-array v3, v5, [Lcom/amazon/mShop/share/WechatSDKManager$WechatMessageParams;

    aput-object v2, v3, v4

    invoke-virtual {v1, v3}, Lcom/amazon/mShop/share/WechatSDKManager$SendResponseTask;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 137
    :try_start_0
    invoke-virtual {v1}, Lcom/amazon/mShop/share/WechatSDKManager$SendResponseTask;->get()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/Boolean;

    invoke-virtual {v3}, Ljava/lang/Boolean;->booleanValue()Z
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result v3

    .line 139
    :goto_0
    return v3

    .line 138
    :catch_0
    move-exception v0

    .local v0, "ex":Ljava/lang/Exception;
    move v3, v4

    .line 139
    goto :goto_0
.end method

.method public static setPendingTransaction(Ljava/lang/String;)V
    .locals 0
    .param p0, "transaction"    # Ljava/lang/String;

    .prologue
    .line 79
    sput-object p0, Lcom/amazon/mShop/share/WechatSDKManager;->sPendingTransaction:Ljava/lang/String;

    .line 80
    return-void
.end method

.method public static timelineSupported(Landroid/content/Context;)Z
    .locals 4
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    const/4 v2, 0x0

    .line 95
    invoke-static {p0}, Lcom/amazon/mShop/share/WechatSDKManager;->getAPIHandle(Landroid/content/Context;)Lcom/tencent/mm/sdk/openapi/IWXAPI;

    move-result-object v0

    .line 96
    .local v0, "sdkHandle":Lcom/tencent/mm/sdk/openapi/IWXAPI;
    if-nez v0, :cond_1

    .line 100
    :cond_0
    :goto_0
    return v2

    .line 99
    :cond_1
    invoke-interface {v0}, Lcom/tencent/mm/sdk/openapi/IWXAPI;->getWXAppSupportAPI()I

    move-result v1

    .line 100
    .local v1, "wxSdkVersion":I
    const v3, 0x21020001

    if-lt v1, v3, :cond_0

    const/4 v2, 0x1

    goto :goto_0
.end method
