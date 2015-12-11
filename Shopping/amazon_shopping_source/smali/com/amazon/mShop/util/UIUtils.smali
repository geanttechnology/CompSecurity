.class public Lcom/amazon/mShop/util/UIUtils;
.super Ljava/lang/Object;
.source "UIUtils.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/mShop/util/UIUtils$WebViewURLSpan;,
        Lcom/amazon/mShop/util/UIUtils$WebViewURLSpanFactory;,
        Lcom/amazon/mShop/util/UIUtils$CharacterColor;
    }
.end annotation


# static fields
.field public static final CART_ICON_RES_ID_FOR_COUNT:[I

.field public static final CART_ICON_RES_ID_FOR_COUNT_PLUS:I

.field private static UNSUPPORTED_CHARACTERS:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/Character;",
            "Ljava/util/Map",
            "<",
            "Lcom/amazon/mShop/util/UIUtils$CharacterColor;",
            "Ljava/lang/Integer;",
            ">;>;"
        }
    .end annotation
.end field

.field private static sLastNetworkExceptionAlertTime:J

.field private static volatile sShowingNetFailDialog:Z


# direct methods
.method static constructor <clinit>()V
    .locals 4

    .prologue
    .line 93
    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    sput-object v1, Lcom/amazon/mShop/util/UIUtils;->UNSUPPORTED_CHARACTERS:Ljava/util/Map;

    .line 96
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 97
    .local v0, "rupeeMap":Ljava/util/Map;, "Ljava/util/Map<Lcom/amazon/mShop/util/UIUtils$CharacterColor;Ljava/lang/Integer;>;"
    sget-object v1, Lcom/amazon/mShop/util/UIUtils$CharacterColor;->RED:Lcom/amazon/mShop/util/UIUtils$CharacterColor;

    sget v2, Lcom/amazon/mShop/android/lib/R$drawable;->rupee_red:I

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 98
    sget-object v1, Lcom/amazon/mShop/util/UIUtils$CharacterColor;->DARK_GRAY:Lcom/amazon/mShop/util/UIUtils$CharacterColor;

    sget v2, Lcom/amazon/mShop/android/lib/R$drawable;->rupee_grey:I

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 99
    sget-object v1, Lcom/amazon/mShop/util/UIUtils$CharacterColor;->BLACK:Lcom/amazon/mShop/util/UIUtils$CharacterColor;

    sget v2, Lcom/amazon/mShop/android/lib/R$drawable;->rupee_black:I

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 100
    sget-object v1, Lcom/amazon/mShop/util/UIUtils;->UNSUPPORTED_CHARACTERS:Ljava/util/Map;

    const/16 v2, 0x20b9

    invoke-static {v2}, Ljava/lang/Character;->valueOf(C)Ljava/lang/Character;

    move-result-object v2

    invoke-interface {v1, v2, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 386
    const-wide/16 v1, 0x0

    sput-wide v1, Lcom/amazon/mShop/util/UIUtils;->sLastNetworkExceptionAlertTime:J

    .line 725
    const/16 v1, 0xb

    new-array v1, v1, [I

    const/4 v2, 0x0

    sget v3, Lcom/amazon/mShop/android/lib/R$drawable;->android_menu_cart:I

    aput v3, v1, v2

    const/4 v2, 0x1

    sget v3, Lcom/amazon/mShop/android/lib/R$drawable;->android_menu_cart_new_1:I

    aput v3, v1, v2

    const/4 v2, 0x2

    sget v3, Lcom/amazon/mShop/android/lib/R$drawable;->android_menu_cart_new_2:I

    aput v3, v1, v2

    const/4 v2, 0x3

    sget v3, Lcom/amazon/mShop/android/lib/R$drawable;->android_menu_cart_new_3:I

    aput v3, v1, v2

    const/4 v2, 0x4

    sget v3, Lcom/amazon/mShop/android/lib/R$drawable;->android_menu_cart_new_4:I

    aput v3, v1, v2

    const/4 v2, 0x5

    sget v3, Lcom/amazon/mShop/android/lib/R$drawable;->android_menu_cart_new_5:I

    aput v3, v1, v2

    const/4 v2, 0x6

    sget v3, Lcom/amazon/mShop/android/lib/R$drawable;->android_menu_cart_new_6:I

    aput v3, v1, v2

    const/4 v2, 0x7

    sget v3, Lcom/amazon/mShop/android/lib/R$drawable;->android_menu_cart_new_7:I

    aput v3, v1, v2

    const/16 v2, 0x8

    sget v3, Lcom/amazon/mShop/android/lib/R$drawable;->android_menu_cart_new_8:I

    aput v3, v1, v2

    const/16 v2, 0x9

    sget v3, Lcom/amazon/mShop/android/lib/R$drawable;->android_menu_cart_new_9:I

    aput v3, v1, v2

    const/16 v2, 0xa

    sget v3, Lcom/amazon/mShop/android/lib/R$drawable;->android_menu_cart_new_10:I

    aput v3, v1, v2

    sput-object v1, Lcom/amazon/mShop/util/UIUtils;->CART_ICON_RES_ID_FOR_COUNT:[I

    .line 738
    sget v1, Lcom/amazon/mShop/android/lib/R$drawable;->android_menu_cart_new_10plus:I

    sput v1, Lcom/amazon/mShop/util/UIUtils;->CART_ICON_RES_ID_FOR_COUNT_PLUS:I

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 91
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 779
    return-void
.end method

.method public static addEmbeddedLink(Lcom/amazon/mShop/AmazonActivity;Landroid/text/SpannableString;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 4
    .param p0, "amazonActivity"    # Lcom/amazon/mShop/AmazonActivity;
    .param p1, "ss"    # Landroid/text/SpannableString;
    .param p2, "fullText"    # Ljava/lang/String;
    .param p3, "linkText"    # Ljava/lang/String;
    .param p4, "linkUrl"    # Ljava/lang/String;

    .prologue
    .line 986
    if-eqz p0, :cond_0

    if-eqz p1, :cond_0

    invoke-static {p2}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_0

    invoke-static {p3}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_0

    invoke-static {p4}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 988
    invoke-virtual {p2, p3}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v0

    .line 989
    .local v0, "startIndex":I
    if-gez v0, :cond_1

    .line 1001
    .end local v0    # "startIndex":I
    :cond_0
    :goto_0
    return-void

    .line 992
    .restart local v0    # "startIndex":I
    :cond_1
    new-instance v1, Lcom/amazon/mShop/util/UIUtils$11;

    invoke-direct {v1, p0, p4, p3}, Lcom/amazon/mShop/util/UIUtils$11;-><init>(Lcom/amazon/mShop/AmazonActivity;Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {p3}, Ljava/lang/String;->length()I

    move-result v2

    add-int/2addr v2, v0

    const/16 v3, 0x21

    invoke-virtual {p1, v1, v0, v2, v3}, Landroid/text/SpannableString;->setSpan(Ljava/lang/Object;III)V

    goto :goto_0
.end method

.method public static alert(Landroid/content/Context;)V
    .locals 2
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 450
    const-string/jumbo v0, ""

    const/4 v1, 0x0

    invoke-static {p0, v0, v1}, Lcom/amazon/mShop/util/UIUtils;->alert(Landroid/content/Context;Ljava/lang/String;Landroid/content/DialogInterface$OnDismissListener;)V

    .line 451
    return-void
.end method

.method public static alert(Landroid/content/Context;I)V
    .locals 3
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "messageResourceId"    # I

    .prologue
    .line 454
    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    .line 455
    .local v0, "res":Landroid/content/res/Resources;
    invoke-virtual {v0, p1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x0

    invoke-static {p0, v1, v2}, Lcom/amazon/mShop/util/UIUtils;->alert(Landroid/content/Context;Ljava/lang/String;Landroid/content/DialogInterface$OnDismissListener;)V

    .line 456
    return-void
.end method

.method public static alert(Landroid/content/Context;Lcom/amazon/rio/j2me/client/services/mShop/Notification;)V
    .locals 2
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "notification"    # Lcom/amazon/rio/j2me/client/services/mShop/Notification;

    .prologue
    .line 459
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/Notification;->getTitle()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, "\n\n"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/Notification;->getMessage()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {p0, v0}, Lcom/amazon/mShop/util/UIUtils;->alert(Landroid/content/Context;Ljava/lang/String;)V

    .line 460
    return-void
.end method

.method public static alert(Landroid/content/Context;Ljava/lang/Exception;)V
    .locals 2
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "e"    # Ljava/lang/Exception;

    .prologue
    .line 364
    sget v0, Lcom/amazon/mShop/android/lib/R$bool;->config_reportErrorExceptionMetricsToPmet:I

    invoke-static {p0, v0}, Lcom/amazon/mShop/util/ConfigUtils;->isEnabledForApp(Landroid/content/Context;I)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 365
    invoke-static {p1}, Lcom/amazon/mShop/net/ErrorExceptionMetricsObserver;->logMetric(Ljava/lang/Exception;)V

    .line 369
    :cond_0
    invoke-static {p1}, Lcom/amazon/mShop/util/UIUtils;->isCommonNetworkException(Ljava/lang/Exception;)Z

    move-result v0

    if-nez v0, :cond_1

    instance-of v0, p1, Ljavax/net/ssl/SSLPeerUnverifiedException;

    if-eqz v0, :cond_3

    .line 375
    :cond_1
    invoke-static {}, Lcom/amazon/mShop/util/UIUtils;->shouldShowNetworkExceptionAlert()Z

    move-result v0

    if-eqz v0, :cond_2

    sget-boolean v0, Lcom/amazon/mShop/util/UIUtils;->sShowingNetFailDialog:Z

    if-nez v0, :cond_2

    .line 376
    invoke-static {p0, p1}, Lcom/amazon/mShop/util/UIUtils;->getMessageForException(Landroid/content/Context;Ljava/lang/Exception;)Ljava/lang/String;

    move-result-object v0

    invoke-static {p0, v0}, Lcom/amazon/mShop/util/UIUtils;->info(Landroid/content/Context;Ljava/lang/String;)V

    .line 382
    :cond_2
    :goto_0
    return-void

    .line 381
    :cond_3
    invoke-static {p0, p1}, Lcom/amazon/mShop/util/UIUtils;->getMessageForException(Landroid/content/Context;Ljava/lang/Exception;)Ljava/lang/String;

    move-result-object v0

    const/4 v1, 0x0

    invoke-static {p0, v0, v1}, Lcom/amazon/mShop/util/UIUtils;->alert(Landroid/content/Context;Ljava/lang/String;Landroid/content/DialogInterface$OnDismissListener;)V

    goto :goto_0
.end method

.method public static alert(Landroid/content/Context;Ljava/lang/String;)V
    .locals 1
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "message"    # Ljava/lang/String;

    .prologue
    .line 446
    const/4 v0, 0x0

    invoke-static {p0, p1, v0}, Lcom/amazon/mShop/util/UIUtils;->alert(Landroid/content/Context;Ljava/lang/String;Landroid/content/DialogInterface$OnDismissListener;)V

    .line 447
    return-void
.end method

.method public static alert(Landroid/content/Context;Ljava/lang/String;Landroid/content/DialogInterface$OnDismissListener;)V
    .locals 4
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "message"    # Ljava/lang/String;
    .param p2, "dismissListener"    # Landroid/content/DialogInterface$OnDismissListener;

    .prologue
    .line 424
    invoke-static {p1}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 425
    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    .line 426
    .local v1, "res":Landroid/content/res/Resources;
    sget v2, Lcom/amazon/mShop/android/lib/R$string;->alert_error_service_please_try_again:I

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object p1

    .line 428
    .end local v1    # "res":Landroid/content/res/Resources;
    :cond_0
    move-object v0, p1

    .line 429
    .local v0, "msg":Ljava/lang/String;
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v2

    new-instance v3, Lcom/amazon/mShop/util/UIUtils$2;

    invoke-direct {v3, p0, v0, p2}, Lcom/amazon/mShop/util/UIUtils$2;-><init>(Landroid/content/Context;Ljava/lang/String;Landroid/content/DialogInterface$OnDismissListener;)V

    invoke-interface {v2, v3}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;)V

    .line 443
    return-void
.end method

.method public static badgedIconForCount(Landroid/content/Context;[III)Landroid/graphics/drawable/Drawable;
    .locals 6
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "iconResIdForCount"    # [I
    .param p2, "iconResIdForCountPlus"    # I
    .param p3, "count"    # I

    .prologue
    const/4 v2, 0x0

    .line 692
    if-gez p3, :cond_0

    .line 707
    :goto_0
    return-object v2

    .line 697
    :cond_0
    array-length v3, p1

    add-int/lit8 v3, v3, -0x1

    if-le p3, v3, :cond_1

    .line 698
    move v1, p2

    .line 704
    .local v1, "id":I
    :goto_1
    :try_start_0
    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    invoke-virtual {v3, v1}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;
    :try_end_0
    .catch Landroid/content/res/Resources$NotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v2

    goto :goto_0

    .line 700
    .end local v1    # "id":I
    :cond_1
    aget v1, p1, p3

    .restart local v1    # "id":I
    goto :goto_1

    .line 705
    :catch_0
    move-exception v0

    .line 706
    .local v0, "ex":Landroid/content/res/Resources$NotFoundException;
    const-string/jumbo v3, "Amazon.UIUtils"

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v5, "Failed to find badge icon for drawable id "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0
.end method

.method public static breakLines(Ljava/lang/String;ILandroid/text/TextPaint;I)Ljava/util/List;
    .locals 6
    .param p0, "text"    # Ljava/lang/String;
    .param p1, "maxLines"    # I
    .param p2, "paint"    # Landroid/text/TextPaint;
    .param p3, "drawAreaWidth"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "I",
            "Landroid/text/TextPaint;",
            "I)",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    const/4 v1, 0x0

    const/4 v5, 0x1

    .line 1211
    if-ge p1, v5, :cond_1

    .line 1232
    :cond_0
    return-object v1

    .line 1215
    :cond_1
    invoke-static {p0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v4

    if-nez v4, :cond_0

    .line 1219
    invoke-virtual {p0}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object p0

    .line 1221
    move-object v3, p0

    .line 1222
    .local v3, "stringLeft":Ljava/lang/String;
    const/4 v0, 0x0

    .line 1223
    .local v0, "lineIndex":I
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 1224
    .local v1, "lines":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    :goto_0
    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v4

    if-lez v4, :cond_0

    if-ge v0, p1, :cond_0

    .line 1225
    add-int/lit8 v4, p1, -0x1

    if-ne v0, v4, :cond_2

    move v4, v5

    :goto_1
    invoke-static {v3, v4, p2, p3}, Lcom/amazon/mShop/util/UIUtils;->getOneLineText(Ljava/lang/String;ZLandroid/text/TextPaint;I)Ljava/lang/String;

    move-result-object v2

    .line 1226
    .local v2, "rowString":Ljava/lang/String;
    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v4

    invoke-virtual {v3, v4}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v3

    .line 1227
    invoke-virtual {v2}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v1, v4}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 1228
    invoke-virtual {v3}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v3

    .line 1229
    add-int/lit8 v0, v0, 0x1

    .line 1230
    goto :goto_0

    .line 1225
    .end local v2    # "rowString":Ljava/lang/String;
    :cond_2
    const/4 v4, 0x0

    goto :goto_1
.end method

.method public static closeSoftKeyboard(Landroid/view/View;)V
    .locals 3
    .param p0, "view"    # Landroid/view/View;

    .prologue
    .line 196
    if-nez p0, :cond_1

    .line 204
    :cond_0
    :goto_0
    return-void

    .line 199
    :cond_1
    invoke-virtual {p0}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v1

    const-string/jumbo v2, "input_method"

    invoke-virtual {v1, v2}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/inputmethod/InputMethodManager;

    .line 201
    .local v0, "imm":Landroid/view/inputmethod/InputMethodManager;
    if-eqz v0, :cond_0

    .line 202
    invoke-virtual {p0}, Landroid/view/View;->getWindowToken()Landroid/os/IBinder;

    move-result-object v1

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/view/inputmethod/InputMethodManager;->hideSoftInputFromWindow(Landroid/os/IBinder;I)Z

    goto :goto_0
.end method

.method public static convertBitmapToByteArray(Landroid/graphics/Bitmap;)[B
    .locals 3
    .param p0, "bitmap"    # Landroid/graphics/Bitmap;

    .prologue
    .line 1190
    new-instance v0, Ljava/io/ByteArrayOutputStream;

    invoke-direct {v0}, Ljava/io/ByteArrayOutputStream;-><init>()V

    .line 1191
    .local v0, "stream":Ljava/io/ByteArrayOutputStream;
    sget-object v1, Landroid/graphics/Bitmap$CompressFormat;->JPEG:Landroid/graphics/Bitmap$CompressFormat;

    const/16 v2, 0x64

    invoke-virtual {p0, v1, v2, v0}, Landroid/graphics/Bitmap;->compress(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z

    .line 1192
    invoke-virtual {v0}, Ljava/io/ByteArrayOutputStream;->toByteArray()[B

    move-result-object v1

    return-object v1
.end method

.method public static convertDipToPixel(I)I
    .locals 3
    .param p0, "dip"    # I

    .prologue
    .line 1295
    const/4 v1, 0x1

    const/high16 v2, 0x40000000    # 2.0f

    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    invoke-interface {v0}, Lcom/amazon/mShop/platform/Platform;->getApplicationContext()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v0

    invoke-static {v1, v2, v0}, Landroid/util/TypedValue;->applyDimension(IFLandroid/util/DisplayMetrics;)F

    move-result v0

    invoke-static {v0}, Ljava/lang/Math;->round(F)I

    move-result v0

    return v0
.end method

.method public static convertUnsupportedCharacter(Landroid/content/Context;Ljava/lang/String;Lcom/amazon/mShop/util/UIUtils$CharacterColor;)Ljava/lang/CharSequence;
    .locals 8
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "color"    # Lcom/amazon/mShop/util/UIUtils$CharacterColor;

    .prologue
    .line 1359
    invoke-static {}, Lcom/amazon/mShop/platform/AppLocale;->getInstance()Lcom/amazon/mShop/platform/AppLocale;

    move-result-object v6

    invoke-virtual {v6}, Lcom/amazon/mShop/platform/AppLocale;->getCurrentLocaleName()Ljava/lang/String;

    move-result-object v6

    const-string/jumbo v7, "en_IN"

    invoke-virtual {v6, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_3

    sget v6, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v7, 0xb

    if-ge v6, v7, :cond_3

    .line 1361
    sget-object v6, Lcom/amazon/mShop/util/UIUtils;->UNSUPPORTED_CHARACTERS:Ljava/util/Map;

    invoke-interface {v6}, Ljava/util/Map;->keySet()Ljava/util/Set;

    move-result-object v5

    .line 1362
    .local v5, "unsupportedChars":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/Character;>;"
    new-instance v4, Landroid/text/SpannableString;

    invoke-direct {v4, p1}, Landroid/text/SpannableString;-><init>(Ljava/lang/CharSequence;)V

    .line 1363
    .local v4, "spanStr":Landroid/text/SpannableString;
    const/4 v2, 0x0

    .line 1364
    .local v2, "hasConverted":Z
    const/4 v3, 0x0

    .local v3, "i":I
    :goto_0
    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v6

    if-ge v3, v6, :cond_1

    .line 1365
    invoke-virtual {p1, v3}, Ljava/lang/String;->charAt(I)C

    move-result v0

    .line 1366
    .local v0, "c":C
    invoke-static {v0}, Ljava/lang/Character;->valueOf(C)Ljava/lang/Character;

    move-result-object v6

    invoke-interface {v5, v6}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_0

    .line 1367
    new-instance v1, Landroid/text/style/ImageSpan;

    sget-object v6, Lcom/amazon/mShop/util/UIUtils;->UNSUPPORTED_CHARACTERS:Ljava/util/Map;

    invoke-static {v0}, Ljava/lang/Character;->valueOf(C)Ljava/lang/Character;

    move-result-object v7

    invoke-interface {v6, v7}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/util/Map;

    invoke-interface {v6, p2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/lang/Integer;

    invoke-virtual {v6}, Ljava/lang/Integer;->intValue()I

    move-result v6

    invoke-direct {v1, p0, v6}, Landroid/text/style/ImageSpan;-><init>(Landroid/content/Context;I)V

    .line 1368
    .local v1, "characterImage":Landroid/text/style/ImageSpan;
    add-int/lit8 v6, v3, 0x1

    const/16 v7, 0x12

    invoke-virtual {v4, v1, v3, v6, v7}, Landroid/text/SpannableString;->setSpan(Ljava/lang/Object;III)V

    .line 1369
    const/4 v2, 0x1

    .line 1364
    .end local v1    # "characterImage":Landroid/text/style/ImageSpan;
    :cond_0
    add-int/lit8 v3, v3, 0x1

    goto :goto_0

    .line 1372
    .end local v0    # "c":C
    :cond_1
    if-eqz v2, :cond_2

    .line 1375
    .end local v2    # "hasConverted":Z
    .end local v3    # "i":I
    .end local v4    # "spanStr":Landroid/text/SpannableString;
    .end local v5    # "unsupportedChars":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/Character;>;"
    :goto_1
    return-object v4

    .restart local v2    # "hasConverted":Z
    .restart local v3    # "i":I
    .restart local v4    # "spanStr":Landroid/text/SpannableString;
    .restart local v5    # "unsupportedChars":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/Character;>;"
    :cond_2
    move-object v4, p1

    .line 1372
    goto :goto_1

    .end local v2    # "hasConverted":Z
    .end local v3    # "i":I
    .end local v4    # "spanStr":Landroid/text/SpannableString;
    .end local v5    # "unsupportedChars":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/Character;>;"
    :cond_3
    move-object v4, p1

    .line 1375
    goto :goto_1
.end method

.method public static createErrorBox(Lcom/amazon/mShop/AmazonActivity;Lcom/amazon/mShop/error/AmazonErrorInfo;)Lcom/amazon/mShop/error/AmazonErrorBox;
    .locals 5
    .param p0, "amazonActivity"    # Lcom/amazon/mShop/AmazonActivity;
    .param p1, "errorInfo"    # Lcom/amazon/mShop/error/AmazonErrorInfo;

    .prologue
    const/4 v4, 0x1

    .line 580
    invoke-virtual {p1}, Lcom/amazon/mShop/error/AmazonErrorInfo;->getErrorId()I

    move-result v3

    if-nez v3, :cond_1

    .line 581
    const/4 v1, 0x0

    .line 616
    :cond_0
    :goto_0
    return-object v1

    .line 586
    :cond_1
    new-instance v1, Lcom/amazon/mShop/error/AmazonErrorBox;

    invoke-direct {v1, p0}, Lcom/amazon/mShop/error/AmazonErrorBox;-><init>(Landroid/content/Context;)V

    .line 587
    .local v1, "dialog":Lcom/amazon/mShop/error/AmazonErrorBox;
    new-instance v3, Lcom/amazon/mShop/util/UIUtils$7;

    invoke-direct {v3, p1, p0}, Lcom/amazon/mShop/util/UIUtils$7;-><init>(Lcom/amazon/mShop/error/AmazonErrorInfo;Lcom/amazon/mShop/AmazonActivity;)V

    invoke-virtual {v1, v4, v3}, Lcom/amazon/mShop/error/AmazonErrorBox;->setButtonOnClick(ILandroid/view/View$OnClickListener;)V

    .line 604
    invoke-virtual {p1}, Lcom/amazon/mShop/error/AmazonErrorInfo;->getMessage()Ljava/lang/String;

    move-result-object v2

    .line 605
    .local v2, "message":Ljava/lang/String;
    invoke-static {v2}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_2

    .line 606
    invoke-static {}, Lcom/amazon/mShop/net/NetInfo;->hasNetworkConnection()Z

    move-result v3

    if-eqz v3, :cond_3

    sget v3, Lcom/amazon/mShop/android/lib/R$string;->error_network_fail_access_amazon_message:I

    :goto_1
    invoke-virtual {p0, v3}, Lcom/amazon/mShop/AmazonActivity;->getString(I)Ljava/lang/String;

    move-result-object v2

    .line 609
    :cond_2
    invoke-virtual {p1}, Lcom/amazon/mShop/error/AmazonErrorInfo;->getErrorId()I

    move-result v3

    invoke-static {v2, v3}, Lcom/amazon/mShop/util/UIUtils;->formatErrorMessage(Ljava/lang/String;I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Lcom/amazon/mShop/error/AmazonErrorBox;->setMessage(Ljava/lang/CharSequence;)V

    .line 611
    invoke-virtual {p1}, Lcom/amazon/mShop/error/AmazonErrorInfo;->getActionButtonText()Ljava/lang/String;

    move-result-object v0

    .line 612
    .local v0, "buttonText":Ljava/lang/String;
    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_0

    .line 613
    invoke-virtual {v1, v4, v0}, Lcom/amazon/mShop/error/AmazonErrorBox;->setButtonText(ILjava/lang/CharSequence;)V

    goto :goto_0

    .line 606
    .end local v0    # "buttonText":Ljava/lang/String;
    :cond_3
    sget v3, Lcom/amazon/mShop/android/lib/R$string;->error_network_no_connection_message:I

    goto :goto_1
.end method

.method public static findViewIndex(Landroid/widget/ViewAnimator;Landroid/view/View;)I
    .locals 2
    .param p0, "va"    # Landroid/widget/ViewAnimator;
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 1310
    invoke-virtual {p0}, Landroid/widget/ViewAnimator;->getChildCount()I

    move-result v1

    add-int/lit8 v0, v1, -0x1

    .local v0, "i":I
    :goto_0
    if-ltz v0, :cond_1

    .line 1311
    invoke-virtual {p0, v0}, Landroid/widget/ViewAnimator;->getChildAt(I)Landroid/view/View;

    move-result-object v1

    if-ne p1, v1, :cond_0

    .line 1316
    .end local v0    # "i":I
    :goto_1
    return v0

    .line 1310
    .restart local v0    # "i":I
    :cond_0
    add-int/lit8 v0, v0, -0x1

    goto :goto_0

    .line 1316
    :cond_1
    const/4 v0, -0x1

    goto :goto_1
.end method

.method public static formatErrorMessage(Ljava/lang/String;I)Ljava/lang/String;
    .locals 2
    .param p0, "message"    # Ljava/lang/String;
    .param p1, "errorId"    # I

    .prologue
    .line 630
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, " (CS"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, ")"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static getDeviceDisplayMetrics(Landroid/content/Context;)Landroid/util/DisplayMetrics;
    .locals 3
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 1149
    new-instance v1, Landroid/util/DisplayMetrics;

    invoke-direct {v1}, Landroid/util/DisplayMetrics;-><init>()V

    .line 1150
    .local v1, "m":Landroid/util/DisplayMetrics;
    const-string/jumbo v2, "window"

    invoke-virtual {p0, v2}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/view/WindowManager;

    invoke-interface {v2}, Landroid/view/WindowManager;->getDefaultDisplay()Landroid/view/Display;

    move-result-object v0

    .line 1151
    .local v0, "display":Landroid/view/Display;
    invoke-virtual {v0, v1}, Landroid/view/Display;->getMetrics(Landroid/util/DisplayMetrics;)V

    .line 1152
    return-object v1
.end method

.method public static getDeviceLogicalDPI(Landroid/content/Context;)F
    .locals 3
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 1133
    invoke-static {p0}, Lcom/amazon/mShop/util/UIUtils;->getDeviceDisplayMetrics(Landroid/content/Context;)Landroid/util/DisplayMetrics;

    move-result-object v0

    .line 1135
    .local v0, "m":Landroid/util/DisplayMetrics;
    iget v1, v0, Landroid/util/DisplayMetrics;->density:F

    const/high16 v2, 0x43200000    # 160.0f

    mul-float/2addr v1, v2

    return v1
.end method

.method public static getMessageForException(Landroid/content/Context;Ljava/lang/Exception;)Ljava/lang/String;
    .locals 3
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "e"    # Ljava/lang/Exception;

    .prologue
    .line 320
    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    .line 321
    .local v1, "res":Landroid/content/res/Resources;
    instance-of v2, p1, Ljava/io/EOFException;

    if-eqz v2, :cond_1

    .line 323
    sget v2, Lcom/amazon/mShop/android/lib/R$string;->alert_error_service_please_try_again:I

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 350
    .local v0, "message":Ljava/lang/String;
    :cond_0
    :goto_0
    return-object v0

    .line 324
    .end local v0    # "message":Ljava/lang/String;
    :cond_1
    instance-of v2, p1, Lcom/amazon/rio/j2me/client/trans/HttpException;

    if-eqz v2, :cond_2

    .line 326
    sget v2, Lcom/amazon/mShop/android/lib/R$string;->alert_error_service_please_try_again:I

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    .restart local v0    # "message":Ljava/lang/String;
    goto :goto_0

    .line 327
    .end local v0    # "message":Ljava/lang/String;
    :cond_2
    instance-of v2, p1, Ljava/io/IOException;

    if-eqz v2, :cond_5

    .line 329
    instance-of v2, p1, Ljava/net/SocketTimeoutException;

    if-eqz v2, :cond_3

    .line 330
    sget v2, Lcom/amazon/mShop/android/lib/R$string;->alert_error_network_error_socket_timeout:I

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    .restart local v0    # "message":Ljava/lang/String;
    goto :goto_0

    .line 331
    .end local v0    # "message":Ljava/lang/String;
    :cond_3
    instance-of v2, p1, Ljava/net/UnknownHostException;

    if-eqz v2, :cond_4

    .line 332
    sget v2, Lcom/amazon/mShop/android/lib/R$string;->alert_error_network_error_unknownhost:I

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    .restart local v0    # "message":Ljava/lang/String;
    goto :goto_0

    .line 334
    .end local v0    # "message":Ljava/lang/String;
    :cond_4
    sget v2, Lcom/amazon/mShop/android/lib/R$string;->error_network_fail_access_amazon_message:I

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    .restart local v0    # "message":Ljava/lang/String;
    goto :goto_0

    .line 336
    .end local v0    # "message":Ljava/lang/String;
    :cond_5
    instance-of v2, p1, Lcom/amazon/rio/j2me/client/services/ApplicationException;

    if-eqz v2, :cond_6

    .line 338
    invoke-static {p1}, Lcom/amazon/mShop/util/UIUtils;->getServerMessageForException(Ljava/lang/Exception;)Ljava/lang/String;

    move-result-object v0

    .line 339
    .restart local v0    # "message":Ljava/lang/String;
    if-nez v0, :cond_0

    .line 341
    sget v2, Lcom/amazon/mShop/android/lib/R$string;->alert_error_service_please_try_again:I

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 343
    .end local v0    # "message":Ljava/lang/String;
    :cond_6
    instance-of v2, p1, Ljava/lang/SecurityException;

    if-eqz v2, :cond_7

    .line 345
    sget v2, Lcom/amazon/mShop/android/lib/R$string;->alert_error_client_problem:I

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    .restart local v0    # "message":Ljava/lang/String;
    goto :goto_0

    .line 348
    .end local v0    # "message":Ljava/lang/String;
    :cond_7
    sget v2, Lcom/amazon/mShop/android/lib/R$string;->alert_error_client_problem:I

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    .restart local v0    # "message":Ljava/lang/String;
    goto :goto_0
.end method

.method private static getOneLineText(Ljava/lang/String;ZLandroid/text/TextPaint;I)Ljava/lang/String;
    .locals 6
    .param p0, "text"    # Ljava/lang/String;
    .param p1, "isLastRow"    # Z
    .param p2, "paint"    # Landroid/text/TextPaint;
    .param p3, "DrawAreaWidth"    # I

    .prologue
    const/4 v0, 0x0

    const/4 v5, 0x0

    .line 1254
    const/4 v3, 0x1

    int-to-float v4, p3

    invoke-virtual {p2, p0, v3, v4, v0}, Landroid/text/TextPaint;->breakText(Ljava/lang/String;ZF[F)I

    move-result v1

    .line 1256
    .local v1, "charCount":I
    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v3

    if-ne v1, v3, :cond_0

    .line 1275
    .end local p0    # "text":Ljava/lang/String;
    :goto_0
    return-object p0

    .line 1259
    .restart local p0    # "text":Ljava/lang/String;
    :cond_0
    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v3

    if-ge v1, v3, :cond_3

    .line 1261
    if-eqz p1, :cond_1

    .line 1262
    int-to-float v3, p3

    sget-object v4, Landroid/text/TextUtils$TruncateAt;->END:Landroid/text/TextUtils$TruncateAt;

    invoke-static {p0, p2, v3, v4}, Landroid/text/TextUtils;->ellipsize(Ljava/lang/CharSequence;Landroid/text/TextPaint;FLandroid/text/TextUtils$TruncateAt;)Ljava/lang/CharSequence;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object p0

    goto :goto_0

    .line 1264
    :cond_1
    invoke-virtual {p0, v5, v1}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v0

    .line 1265
    .local v0, "candidate":Ljava/lang/String;
    const-string/jumbo v3, " "

    invoke-virtual {v0, v3}, Ljava/lang/String;->lastIndexOf(Ljava/lang/String;)I

    move-result v2

    .line 1266
    .local v2, "lastIndexOfSpace":I
    const/4 v3, -0x1

    if-ne v2, v3, :cond_2

    move-object p0, v0

    .line 1267
    goto :goto_0

    .line 1269
    :cond_2
    invoke-virtual {v0, v5, v2}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object p0

    goto :goto_0

    .end local v0    # "candidate":Ljava/lang/String;
    .end local v2    # "lastIndexOfSpace":I
    :cond_3
    move-object p0, v0

    .line 1275
    goto :goto_0
.end method

.method public static getPortraitHeight(Landroid/content/Context;)I
    .locals 3
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 1109
    const-string/jumbo v2, "window"

    invoke-virtual {p0, v2}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/view/WindowManager;

    invoke-interface {v2}, Landroid/view/WindowManager;->getDefaultDisplay()Landroid/view/Display;

    move-result-object v0

    .line 1110
    .local v0, "display":Landroid/view/Display;
    invoke-static {p0}, Lcom/amazon/mShop/util/UIUtils;->isPortrait(Landroid/content/Context;)Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-virtual {v0}, Landroid/view/Display;->getHeight()I

    move-result v1

    .line 1111
    .local v1, "portraitHeight":I
    :goto_0
    return v1

    .line 1110
    .end local v1    # "portraitHeight":I
    :cond_0
    invoke-virtual {v0}, Landroid/view/Display;->getWidth()I

    move-result v1

    goto :goto_0
.end method

.method public static getPortraitWidth(Landroid/content/Context;)I
    .locals 3
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 1103
    const-string/jumbo v2, "window"

    invoke-virtual {p0, v2}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/view/WindowManager;

    invoke-interface {v2}, Landroid/view/WindowManager;->getDefaultDisplay()Landroid/view/Display;

    move-result-object v0

    .line 1104
    .local v0, "display":Landroid/view/Display;
    invoke-static {p0}, Lcom/amazon/mShop/util/UIUtils;->isPortrait(Landroid/content/Context;)Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-virtual {v0}, Landroid/view/Display;->getWidth()I

    move-result v1

    .line 1105
    .local v1, "portraitWidth":I
    :goto_0
    return v1

    .line 1104
    .end local v1    # "portraitWidth":I
    :cond_0
    invoke-virtual {v0}, Landroid/view/Display;->getHeight()I

    move-result v1

    goto :goto_0
.end method

.method public static getServerMessageForException(Ljava/lang/Exception;)Ljava/lang/String;
    .locals 3
    .param p0, "e"    # Ljava/lang/Exception;

    .prologue
    .line 298
    instance-of v1, p0, Lcom/amazon/rio/j2me/client/services/ApplicationException;

    if-eqz v1, :cond_1

    move-object v0, p0

    .line 300
    check-cast v0, Lcom/amazon/rio/j2me/client/services/ApplicationException;

    .line 301
    .local v0, "ae":Lcom/amazon/rio/j2me/client/services/ApplicationException;
    sget-object v1, Lcom/amazon/rio/j2me/client/services/ApplicationException;->INTERNAL_ERROR:Ljava/lang/String;

    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/ApplicationException;->getErrorCode()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_0

    sget-object v1, Lcom/amazon/rio/j2me/client/services/ApplicationException;->OPERATION_NO_LONGER_SUPPORTED:Ljava/lang/String;

    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/ApplicationException;->getErrorCode()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 302
    :cond_0
    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/ApplicationException;->getMessage()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_1

    .line 304
    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/ApplicationException;->getMessage()Ljava/lang/String;

    move-result-object v1

    .line 309
    .end local v0    # "ae":Lcom/amazon/rio/j2me/client/services/ApplicationException;
    :goto_0
    return-object v1

    :cond_1
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public static info(Landroid/content/Context;I)V
    .locals 1
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "messageResourceId"    # I

    .prologue
    .line 288
    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0, p1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-static {p0, v0}, Lcom/amazon/mShop/util/UIUtils;->info(Landroid/content/Context;Ljava/lang/String;)V

    .line 289
    return-void
.end method

.method public static info(Landroid/content/Context;Ljava/lang/String;)V
    .locals 2
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "message"    # Ljava/lang/String;

    .prologue
    .line 274
    invoke-static {p1}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 275
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/util/UIUtils$1;

    invoke-direct {v1, p0, p1}, Lcom/amazon/mShop/util/UIUtils$1;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    invoke-interface {v0, v1}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;)V

    .line 285
    :cond_0
    return-void
.end method

.method public static isCommonNetworkException(Ljava/lang/Exception;)Z
    .locals 3
    .param p0, "e"    # Ljava/lang/Exception;

    .prologue
    const/4 v0, 0x0

    .line 407
    if-nez p0, :cond_1

    .line 411
    :cond_0
    :goto_0
    return v0

    :cond_1
    instance-of v1, p0, Lorg/apache/http/conn/ConnectionPoolTimeoutException;

    if-nez v1, :cond_2

    instance-of v1, p0, Ljava/net/SocketTimeoutException;

    if-nez v1, :cond_2

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v1

    const-string/jumbo v2, "android.accounts.NetworkErrorException"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_2

    instance-of v1, p0, Ljava/net/UnknownHostException;

    if-nez v1, :cond_2

    instance-of v1, p0, Ljava/net/SocketException;

    if-nez v1, :cond_2

    instance-of v1, p0, Ljava/net/ConnectException;

    if-eqz v1, :cond_0

    :cond_2
    const/4 v0, 0x1

    goto :goto_0
.end method

.method public static isPortrait(Landroid/content/Context;)Z
    .locals 3
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 1089
    const-string/jumbo v1, "window"

    invoke-virtual {p0, v1}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/view/WindowManager;

    invoke-interface {v1}, Landroid/view/WindowManager;->getDefaultDisplay()Landroid/view/Display;

    move-result-object v0

    .line 1090
    .local v0, "display":Landroid/view/Display;
    invoke-virtual {v0}, Landroid/view/Display;->getHeight()I

    move-result v1

    invoke-virtual {v0}, Landroid/view/Display;->getWidth()I

    move-result v2

    if-le v1, v2, :cond_0

    const/4 v1, 0x1

    :goto_0
    return v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public static setAlpha(Landroid/view/View;F)V
    .locals 2
    .param p0, "view"    # Landroid/view/View;
    .param p1, "alpha"    # F

    .prologue
    .line 1350
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0xb

    if-lt v0, v1, :cond_0

    .line 1351
    invoke-virtual {p0, p1}, Landroid/view/View;->setAlpha(F)V

    .line 1354
    invoke-virtual {p0}, Landroid/view/View;->invalidate()V

    .line 1356
    :cond_0
    return-void
.end method

.method public static setHyperTexts(Landroid/widget/TextView;Lcom/amazon/mShop/AmazonActivity;Ljava/util/List;)V
    .locals 1
    .param p0, "textView"    # Landroid/widget/TextView;
    .param p1, "activity"    # Lcom/amazon/mShop/AmazonActivity;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/widget/TextView;",
            "Lcom/amazon/mShop/AmazonActivity;",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/HyperText;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 832
    .local p2, "hyperTexts":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/HyperText;>;"
    const/4 v0, 0x0

    invoke-static {p0, p1, p2, v0}, Lcom/amazon/mShop/util/UIUtils;->setHyperTexts(Landroid/widget/TextView;Lcom/amazon/mShop/AmazonActivity;Ljava/util/List;Ljava/util/List;)V

    .line 833
    return-void
.end method

.method public static setHyperTexts(Landroid/widget/TextView;Lcom/amazon/mShop/AmazonActivity;Ljava/util/List;Ljava/util/List;)V
    .locals 1
    .param p0, "textView"    # Landroid/widget/TextView;
    .param p1, "activity"    # Lcom/amazon/mShop/AmazonActivity;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/widget/TextView;",
            "Lcom/amazon/mShop/AmazonActivity;",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/HyperText;",
            ">;",
            "Ljava/util/List",
            "<",
            "Ljava/lang/Integer;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 837
    .local p2, "hyperTexts":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/HyperText;>;"
    .local p3, "textBackgroundColors":Ljava/util/List;, "Ljava/util/List<Ljava/lang/Integer;>;"
    new-instance v0, Lcom/amazon/mShop/util/UIUtils$9;

    invoke-direct {v0, p1}, Lcom/amazon/mShop/util/UIUtils$9;-><init>(Lcom/amazon/mShop/AmazonActivity;)V

    invoke-static {p0, v0, p2, p3}, Lcom/amazon/mShop/util/UIUtils;->setHyperTexts(Landroid/widget/TextView;Lcom/amazon/mShop/util/UIUtils$WebViewURLSpanFactory;Ljava/util/List;Ljava/util/List;)V

    .line 843
    return-void
.end method

.method public static setHyperTexts(Landroid/widget/TextView;Lcom/amazon/mShop/util/UIUtils$WebViewURLSpanFactory;Ljava/util/List;Ljava/util/List;)V
    .locals 3
    .param p0, "textView"    # Landroid/widget/TextView;
    .param p1, "factory"    # Lcom/amazon/mShop/util/UIUtils$WebViewURLSpanFactory;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/widget/TextView;",
            "Lcom/amazon/mShop/util/UIUtils$WebViewURLSpanFactory;",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/HyperText;",
            ">;",
            "Ljava/util/List",
            "<",
            "Ljava/lang/Integer;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 851
    .local p2, "hyperTexts":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/HyperText;>;"
    .local p3, "textBackgroundColors":Ljava/util/List;, "Ljava/util/List<Ljava/lang/Integer;>;"
    new-instance v1, Landroid/text/SpannableStringBuilder;

    invoke-direct {v1}, Landroid/text/SpannableStringBuilder;-><init>()V

    .line 852
    .local v1, "spanned":Landroid/text/SpannableStringBuilder;
    invoke-static {p1, v1, p2, p3}, Lcom/amazon/mShop/util/UIUtils;->setSpanFromHyperTexts(Lcom/amazon/mShop/util/UIUtils$WebViewURLSpanFactory;Landroid/text/SpannableStringBuilder;Ljava/util/List;Ljava/util/List;)Z

    move-result v0

    .line 853
    .local v0, "hasLinks":Z
    invoke-virtual {p0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 856
    if-eqz v0, :cond_1

    .line 857
    invoke-virtual {p0}, Landroid/widget/TextView;->getMovementMethod()Landroid/text/method/MovementMethod;

    move-result-object v2

    instance-of v2, v2, Landroid/text/method/LinkMovementMethod;

    if-nez v2, :cond_0

    .line 858
    invoke-static {}, Landroid/text/method/LinkMovementMethod;->getInstance()Landroid/text/method/MovementMethod;

    move-result-object v2

    invoke-virtual {p0, v2}, Landroid/widget/TextView;->setMovementMethod(Landroid/text/method/MovementMethod;)V

    .line 865
    :cond_0
    :goto_0
    return-void

    .line 861
    :cond_1
    invoke-virtual {p0}, Landroid/widget/TextView;->getMovementMethod()Landroid/text/method/MovementMethod;

    move-result-object v2

    instance-of v2, v2, Landroid/text/method/LinkMovementMethod;

    if-eqz v2, :cond_0

    .line 862
    const/4 v2, 0x0

    invoke-virtual {p0, v2}, Landroid/widget/TextView;->setMovementMethod(Landroid/text/method/MovementMethod;)V

    goto :goto_0
.end method

.method public static setImageSpan(Lcom/amazon/mShop/AmazonActivity;Landroid/graphics/Bitmap;Landroid/text/SpannableStringBuilder;I)V
    .locals 4
    .param p0, "activity"    # Lcom/amazon/mShop/AmazonActivity;
    .param p1, "bitmap"    # Landroid/graphics/Bitmap;
    .param p2, "spanned"    # Landroid/text/SpannableStringBuilder;
    .param p3, "verticalAlignment"    # I

    .prologue
    .line 805
    if-eqz p2, :cond_1

    if-eqz p1, :cond_1

    .line 806
    invoke-virtual {p2}, Landroid/text/SpannableStringBuilder;->length()I

    move-result v2

    .line 807
    .local v2, "start":I
    if-eqz v2, :cond_0

    .line 808
    const-string/jumbo v3, " "

    invoke-virtual {p2, v3}, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;

    .line 809
    invoke-virtual {p2}, Landroid/text/SpannableStringBuilder;->length()I

    move-result v2

    .line 814
    :cond_0
    const-string/jumbo v3, "a"

    invoke-virtual {p2, v3}, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;

    .line 815
    invoke-virtual {p2}, Landroid/text/SpannableStringBuilder;->length()I

    move-result v0

    .line 816
    .local v0, "end":I
    new-instance v1, Landroid/text/style/ImageSpan;

    invoke-direct {v1, p0, p1, p3}, Landroid/text/style/ImageSpan;-><init>(Landroid/content/Context;Landroid/graphics/Bitmap;I)V

    .line 817
    .local v1, "imageSpan":Landroid/text/style/ImageSpan;
    const/16 v3, 0x21

    invoke-virtual {p2, v1, v2, v0, v3}, Landroid/text/SpannableStringBuilder;->setSpan(Ljava/lang/Object;III)V

    .line 819
    .end local v0    # "end":I
    .end local v1    # "imageSpan":Landroid/text/style/ImageSpan;
    .end local v2    # "start":I
    :cond_1
    return-void
.end method

.method public static setMaxLength(Landroid/widget/TextView;I)V
    .locals 6
    .param p0, "textView"    # Landroid/widget/TextView;
    .param p1, "maxLength"    # I

    .prologue
    const/4 v5, 0x0

    .line 117
    invoke-virtual {p0}, Landroid/widget/TextView;->getFilters()[Landroid/text/InputFilter;

    move-result-object v3

    .line 120
    .local v3, "oldFilters":[Landroid/text/InputFilter;
    new-instance v1, Landroid/text/InputFilter$LengthFilter;

    invoke-direct {v1, p1}, Landroid/text/InputFilter$LengthFilter;-><init>(I)V

    .line 123
    .local v1, "lengthFilter":Landroid/text/InputFilter$LengthFilter;
    if-eqz v3, :cond_0

    array-length v4, v3

    if-nez v4, :cond_1

    .line 124
    :cond_0
    const/4 v4, 0x1

    new-array v4, v4, [Landroid/text/InputFilter;

    aput-object v1, v4, v5

    invoke-virtual {p0, v4}, Landroid/widget/TextView;->setFilters([Landroid/text/InputFilter;)V

    .line 143
    :goto_0
    return-void

    .line 129
    :cond_1
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_1
    array-length v4, v3

    if-ge v0, v4, :cond_3

    .line 130
    aget-object v4, v3, v0

    instance-of v4, v4, Landroid/text/InputFilter$LengthFilter;

    if-eqz v4, :cond_2

    .line 131
    aput-object v1, v3, v0

    .line 133
    invoke-virtual {p0, v3}, Landroid/widget/TextView;->setFilters([Landroid/text/InputFilter;)V

    goto :goto_0

    .line 129
    :cond_2
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    .line 139
    :cond_3
    array-length v4, v3

    add-int/lit8 v4, v4, 0x1

    new-array v2, v4, [Landroid/text/InputFilter;

    .line 140
    .local v2, "newFilters":[Landroid/text/InputFilter;
    array-length v4, v3

    invoke-static {v3, v5, v2, v5, v4}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 141
    array-length v4, v2

    add-int/lit8 v4, v4, -0x1

    aput-object v1, v2, v4

    .line 142
    invoke-virtual {p0, v2}, Landroid/widget/TextView;->setFilters([Landroid/text/InputFilter;)V

    goto :goto_0
.end method

.method public static setMaxLengthFromRule(Landroid/widget/TextView;I)V
    .locals 3
    .param p0, "textView"    # Landroid/widget/TextView;
    .param p1, "ruleResId"    # I

    .prologue
    .line 154
    invoke-virtual {p0}, Landroid/widget/TextView;->getContext()Landroid/content/Context;

    move-result-object v2

    invoke-virtual {v2, p1}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v1

    .line 155
    .local v1, "rule":Ljava/lang/String;
    invoke-static {v1}, Lcom/amazon/mShop/util/Util;->parseRuleMaxLength(Ljava/lang/String;)I

    move-result v0

    .line 157
    .local v0, "maxLength":I
    if-lez v0, :cond_0

    .line 158
    invoke-static {p0, v0}, Lcom/amazon/mShop/util/UIUtils;->setMaxLength(Landroid/widget/TextView;I)V

    .line 160
    :cond_0
    return-void
.end method

.method public static setSpanFromHyperTexts(Lcom/amazon/mShop/AmazonActivity;Landroid/text/SpannableStringBuilder;Ljava/util/List;Ljava/util/List;)V
    .locals 1
    .param p0, "activity"    # Lcom/amazon/mShop/AmazonActivity;
    .param p1, "spanned"    # Landroid/text/SpannableStringBuilder;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazon/mShop/AmazonActivity;",
            "Landroid/text/SpannableStringBuilder;",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/HyperText;",
            ">;",
            "Ljava/util/List",
            "<",
            "Ljava/lang/Integer;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 869
    .local p2, "hyperTexts":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/HyperText;>;"
    .local p3, "textBackgroundColors":Ljava/util/List;, "Ljava/util/List<Ljava/lang/Integer;>;"
    new-instance v0, Lcom/amazon/mShop/util/UIUtils$10;

    invoke-direct {v0, p0}, Lcom/amazon/mShop/util/UIUtils$10;-><init>(Lcom/amazon/mShop/AmazonActivity;)V

    invoke-static {v0, p1, p2, p3}, Lcom/amazon/mShop/util/UIUtils;->setSpanFromHyperTexts(Lcom/amazon/mShop/util/UIUtils$WebViewURLSpanFactory;Landroid/text/SpannableStringBuilder;Ljava/util/List;Ljava/util/List;)Z

    .line 875
    return-void
.end method

.method public static setSpanFromHyperTexts(Lcom/amazon/mShop/util/UIUtils$WebViewURLSpanFactory;Landroid/text/SpannableStringBuilder;Ljava/util/List;Ljava/util/List;)Z
    .locals 12
    .param p0, "factory"    # Lcom/amazon/mShop/util/UIUtils$WebViewURLSpanFactory;
    .param p1, "spanned"    # Landroid/text/SpannableStringBuilder;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazon/mShop/util/UIUtils$WebViewURLSpanFactory;",
            "Landroid/text/SpannableStringBuilder;",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/HyperText;",
            ">;",
            "Ljava/util/List",
            "<",
            "Ljava/lang/Integer;",
            ">;)Z"
        }
    .end annotation

    .prologue
    .line 882
    .local p2, "hyperTexts":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/HyperText;>;"
    .local p3, "textBackgroundColors":Ljava/util/List;, "Ljava/util/List<Ljava/lang/Integer;>;"
    invoke-interface {p2}, Ljava/util/List;->size()I

    move-result v10

    add-int/lit8 v10, v10, -0x1

    invoke-interface {p2, v10}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Lcom/amazon/rio/j2me/client/services/mShop/HyperText;

    .line 883
    .local v6, "lastHyperText":Lcom/amazon/rio/j2me/client/services/mShop/HyperText;
    const/4 v3, 0x0

    .line 885
    .local v3, "hasLinks":Z
    const/4 v5, 0x0

    .local v5, "i":I
    :goto_0
    invoke-interface {p2}, Ljava/util/List;->size()I

    move-result v10

    if-ge v5, v10, :cond_a

    .line 886
    invoke-interface {p2, v5}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/amazon/rio/j2me/client/services/mShop/HyperText;

    .line 887
    .local v4, "hyperText":Lcom/amazon/rio/j2me/client/services/mShop/HyperText;
    invoke-virtual {p1}, Landroid/text/SpannableStringBuilder;->length()I

    move-result v8

    .line 888
    .local v8, "start":I
    invoke-virtual {v4}, Lcom/amazon/rio/j2me/client/services/mShop/HyperText;->getText()Ljava/lang/String;

    move-result-object v10

    invoke-static {v10}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v10

    if-nez v10, :cond_0

    .line 889
    invoke-virtual {v4}, Lcom/amazon/rio/j2me/client/services/mShop/HyperText;->getText()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {p1, v10}, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;

    .line 892
    :cond_0
    invoke-virtual {v4}, Lcom/amazon/rio/j2me/client/services/mShop/HyperText;->getLineBreak()Z

    move-result v10

    if-eqz v10, :cond_1

    if-eq v6, v4, :cond_1

    .line 893
    const-string/jumbo v10, "\n"

    invoke-virtual {p1, v10}, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;

    .line 896
    :cond_1
    invoke-virtual {p1}, Landroid/text/SpannableStringBuilder;->length()I

    move-result v1

    .line 898
    .local v1, "end":I
    if-ne v8, v1, :cond_3

    .line 885
    :cond_2
    :goto_1
    add-int/lit8 v5, v5, 0x1

    goto :goto_0

    .line 902
    :cond_3
    invoke-virtual {v4}, Lcom/amazon/rio/j2me/client/services/mShop/HyperText;->getAttributes()Lcom/amazon/rio/j2me/client/services/mShop/TextAttributes;

    move-result-object v0

    .line 903
    .local v0, "attributes":Lcom/amazon/rio/j2me/client/services/mShop/TextAttributes;
    if-eqz v0, :cond_2

    .line 904
    const/16 v2, 0x21

    .line 907
    .local v2, "flags":I
    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/mShop/TextAttributes;->getSize()Ljava/lang/Integer;

    move-result-object v10

    if-eqz v10, :cond_4

    .line 908
    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/mShop/TextAttributes;->getSize()Ljava/lang/Integer;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/Integer;->intValue()I

    move-result v10

    packed-switch v10, :pswitch_data_0

    .line 923
    :cond_4
    :goto_2
    :pswitch_0
    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/mShop/TextAttributes;->getStyle()Ljava/lang/Integer;

    move-result-object v10

    if-eqz v10, :cond_5

    .line 924
    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/mShop/TextAttributes;->getStyle()Ljava/lang/Integer;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/Integer;->intValue()I

    move-result v10

    packed-switch v10, :pswitch_data_1

    .line 939
    :cond_5
    :goto_3
    :pswitch_1
    if-eqz p3, :cond_6

    invoke-interface {p3}, Ljava/util/List;->size()I

    move-result v10

    if-le v10, v5, :cond_6

    .line 940
    new-instance v11, Landroid/text/style/BackgroundColorSpan;

    invoke-interface {p3, v5}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v10

    check-cast v10, Ljava/lang/Integer;

    invoke-virtual {v10}, Ljava/lang/Integer;->intValue()I

    move-result v10

    invoke-direct {v11, v10}, Landroid/text/style/BackgroundColorSpan;-><init>(I)V

    const/16 v10, 0x21

    invoke-virtual {p1, v11, v8, v1, v10}, Landroid/text/SpannableStringBuilder;->setSpan(Ljava/lang/Object;III)V

    .line 944
    :cond_6
    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/mShop/TextAttributes;->getColor()Ljava/lang/Integer;

    move-result-object v10

    if-eqz v10, :cond_7

    .line 945
    new-instance v10, Landroid/text/style/ForegroundColorSpan;

    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/mShop/TextAttributes;->getColor()Ljava/lang/Integer;

    move-result-object v11

    invoke-virtual {v11}, Ljava/lang/Integer;->intValue()I

    move-result v11

    invoke-direct {v10, v11}, Landroid/text/style/ForegroundColorSpan;-><init>(I)V

    const/16 v11, 0x21

    invoke-virtual {p1, v10, v8, v1, v11}, Landroid/text/SpannableStringBuilder;->setSpan(Ljava/lang/Object;III)V

    .line 949
    :cond_7
    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/mShop/TextAttributes;->getLinkUrl()Ljava/lang/String;

    move-result-object v9

    .line 950
    .local v9, "url":Ljava/lang/String;
    if-eqz v9, :cond_2

    .line 951
    const/4 v3, 0x1

    .line 953
    const-string/jumbo v10, "open:"

    invoke-virtual {v9, v10}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v10

    if-eqz v10, :cond_8

    .line 955
    new-instance v7, Landroid/text/style/URLSpan;

    const-string/jumbo v10, "open:"

    invoke-virtual {v10}, Ljava/lang/String;->length()I

    move-result v10

    invoke-virtual {v9, v10}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v10

    invoke-direct {v7, v10}, Landroid/text/style/URLSpan;-><init>(Ljava/lang/String;)V

    .line 963
    .local v7, "span":Landroid/text/style/URLSpan;
    :goto_4
    const/16 v10, 0x21

    invoke-virtual {p1, v7, v8, v1, v10}, Landroid/text/SpannableStringBuilder;->setSpan(Ljava/lang/Object;III)V

    goto/16 :goto_1

    .line 910
    .end local v7    # "span":Landroid/text/style/URLSpan;
    .end local v9    # "url":Ljava/lang/String;
    :pswitch_2
    new-instance v10, Landroid/text/style/RelativeSizeSpan;

    const/high16 v11, 0x3f400000    # 0.75f

    invoke-direct {v10, v11}, Landroid/text/style/RelativeSizeSpan;-><init>(F)V

    const/16 v11, 0x21

    invoke-virtual {p1, v10, v8, v1, v11}, Landroid/text/SpannableStringBuilder;->setSpan(Ljava/lang/Object;III)V

    goto :goto_2

    .line 917
    :pswitch_3
    new-instance v10, Landroid/text/style/RelativeSizeSpan;

    const/high16 v11, 0x3fa00000    # 1.25f

    invoke-direct {v10, v11}, Landroid/text/style/RelativeSizeSpan;-><init>(F)V

    const/16 v11, 0x21

    invoke-virtual {p1, v10, v8, v1, v11}, Landroid/text/SpannableStringBuilder;->setSpan(Ljava/lang/Object;III)V

    goto/16 :goto_2

    .line 930
    :pswitch_4
    new-instance v10, Landroid/text/style/StyleSpan;

    const/4 v11, 0x1

    invoke-direct {v10, v11}, Landroid/text/style/StyleSpan;-><init>(I)V

    const/16 v11, 0x21

    invoke-virtual {p1, v10, v8, v1, v11}, Landroid/text/SpannableStringBuilder;->setSpan(Ljava/lang/Object;III)V

    goto/16 :goto_3

    .line 933
    :pswitch_5
    new-instance v10, Landroid/text/style/UnderlineSpan;

    invoke-direct {v10}, Landroid/text/style/UnderlineSpan;-><init>()V

    const/16 v11, 0x21

    invoke-virtual {p1, v10, v8, v1, v11}, Landroid/text/SpannableStringBuilder;->setSpan(Ljava/lang/Object;III)V

    goto/16 :goto_3

    .line 956
    .restart local v9    # "url":Ljava/lang/String;
    :cond_8
    if-eqz p0, :cond_9

    .line 958
    invoke-virtual {v4}, Lcom/amazon/rio/j2me/client/services/mShop/HyperText;->getText()Ljava/lang/String;

    move-result-object v10

    invoke-interface {p0, v9, v10}, Lcom/amazon/mShop/util/UIUtils$WebViewURLSpanFactory;->getURLSpan(Ljava/lang/String;Ljava/lang/String;)Landroid/text/style/URLSpan;

    move-result-object v7

    .restart local v7    # "span":Landroid/text/style/URLSpan;
    goto :goto_4

    .line 961
    .end local v7    # "span":Landroid/text/style/URLSpan;
    :cond_9
    new-instance v7, Landroid/text/style/URLSpan;

    invoke-direct {v7, v9}, Landroid/text/style/URLSpan;-><init>(Ljava/lang/String;)V

    .restart local v7    # "span":Landroid/text/style/URLSpan;
    goto :goto_4

    .line 967
    .end local v0    # "attributes":Lcom/amazon/rio/j2me/client/services/mShop/TextAttributes;
    .end local v1    # "end":I
    .end local v2    # "flags":I
    .end local v4    # "hyperText":Lcom/amazon/rio/j2me/client/services/mShop/HyperText;
    .end local v7    # "span":Landroid/text/style/URLSpan;
    .end local v8    # "start":I
    .end local v9    # "url":Ljava/lang/String;
    :cond_a
    return v3

    .line 908
    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_2
        :pswitch_0
        :pswitch_3
    .end packed-switch

    .line 924
    :pswitch_data_1
    .packed-switch 0x1
        :pswitch_4
        :pswitch_1
        :pswitch_5
    .end packed-switch
.end method

.method private static shouldShowNetworkExceptionAlert()Z
    .locals 4

    .prologue
    .line 392
    invoke-static {}, Landroid/os/SystemClock;->elapsedRealtime()J

    move-result-wide v0

    sget-wide v2, Lcom/amazon/mShop/util/UIUtils;->sLastNetworkExceptionAlertTime:J

    sub-long/2addr v0, v2

    const-wide/16 v2, 0x1770

    cmp-long v0, v0, v2

    if-lez v0, :cond_0

    .line 393
    invoke-static {}, Landroid/os/SystemClock;->elapsedRealtime()J

    move-result-wide v0

    sput-wide v0, Lcom/amazon/mShop/util/UIUtils;->sLastNetworkExceptionAlertTime:J

    .line 394
    const/4 v0, 0x1

    .line 397
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static showSoftKeyboard(Landroid/view/View;)V
    .locals 4
    .param p0, "view"    # Landroid/view/View;

    .prologue
    const/4 v3, 0x2

    .line 213
    if-nez p0, :cond_1

    .line 223
    :cond_0
    :goto_0
    return-void

    .line 216
    :cond_1
    invoke-virtual {p0}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v1

    const-string/jumbo v2, "input_method"

    invoke-virtual {v1, v2}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/inputmethod/InputMethodManager;

    .line 218
    .local v0, "imm":Landroid/view/inputmethod/InputMethodManager;
    if-eqz v0, :cond_0

    .line 221
    invoke-virtual {v0, v3, v3}, Landroid/view/inputmethod/InputMethodManager;->toggleSoftInput(II)V

    goto :goto_0
.end method

.method public static vibrate(Landroid/content/Context;J)V
    .locals 2
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "millis"    # J

    .prologue
    .line 246
    const-string/jumbo v1, "vibrator"

    invoke-virtual {p0, v1}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/os/Vibrator;

    .line 247
    .local v0, "vibrator":Landroid/os/Vibrator;
    if-eqz v0, :cond_0

    .line 248
    invoke-virtual {v0, p1, p2}, Landroid/os/Vibrator;->vibrate(J)V

    .line 250
    :cond_0
    return-void
.end method
