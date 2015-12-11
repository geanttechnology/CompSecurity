.class Lcom/aio/downloader/mydownload/MyApplcation$AnimateFirstDisplayListener;
.super Lcom/nostra13/universalimageloader/core/assist/SimpleImageLoadingListener;
.source "MyApplcation.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/mydownload/MyApplcation;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "AnimateFirstDisplayListener"
.end annotation


# static fields
.field private static synthetic $SWITCH_TABLE$com$nostra13$universalimageloader$core$assist$FailReason$FailType:[I

.field static final displayedImages:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static synthetic $SWITCH_TABLE$com$nostra13$universalimageloader$core$assist$FailReason$FailType()[I
    .locals 3

    .prologue
    .line 201
    sget-object v0, Lcom/aio/downloader/mydownload/MyApplcation$AnimateFirstDisplayListener;->$SWITCH_TABLE$com$nostra13$universalimageloader$core$assist$FailReason$FailType:[I

    if-eqz v0, :cond_0

    :goto_0
    return-object v0

    :cond_0
    invoke-static {}, Lcom/nostra13/universalimageloader/core/assist/FailReason$FailType;->values()[Lcom/nostra13/universalimageloader/core/assist/FailReason$FailType;

    move-result-object v0

    array-length v0, v0

    new-array v0, v0, [I

    :try_start_0
    sget-object v1, Lcom/nostra13/universalimageloader/core/assist/FailReason$FailType;->DECODING_ERROR:Lcom/nostra13/universalimageloader/core/assist/FailReason$FailType;

    invoke-virtual {v1}, Lcom/nostra13/universalimageloader/core/assist/FailReason$FailType;->ordinal()I

    move-result v1

    const/4 v2, 0x2

    aput v2, v0, v1
    :try_end_0
    .catch Ljava/lang/NoSuchFieldError; {:try_start_0 .. :try_end_0} :catch_4

    :goto_1
    :try_start_1
    sget-object v1, Lcom/nostra13/universalimageloader/core/assist/FailReason$FailType;->IO_ERROR:Lcom/nostra13/universalimageloader/core/assist/FailReason$FailType;

    invoke-virtual {v1}, Lcom/nostra13/universalimageloader/core/assist/FailReason$FailType;->ordinal()I

    move-result v1

    const/4 v2, 0x1

    aput v2, v0, v1
    :try_end_1
    .catch Ljava/lang/NoSuchFieldError; {:try_start_1 .. :try_end_1} :catch_3

    :goto_2
    :try_start_2
    sget-object v1, Lcom/nostra13/universalimageloader/core/assist/FailReason$FailType;->NETWORK_DENIED:Lcom/nostra13/universalimageloader/core/assist/FailReason$FailType;

    invoke-virtual {v1}, Lcom/nostra13/universalimageloader/core/assist/FailReason$FailType;->ordinal()I

    move-result v1

    const/4 v2, 0x3

    aput v2, v0, v1
    :try_end_2
    .catch Ljava/lang/NoSuchFieldError; {:try_start_2 .. :try_end_2} :catch_2

    :goto_3
    :try_start_3
    sget-object v1, Lcom/nostra13/universalimageloader/core/assist/FailReason$FailType;->OUT_OF_MEMORY:Lcom/nostra13/universalimageloader/core/assist/FailReason$FailType;

    invoke-virtual {v1}, Lcom/nostra13/universalimageloader/core/assist/FailReason$FailType;->ordinal()I

    move-result v1

    const/4 v2, 0x4

    aput v2, v0, v1
    :try_end_3
    .catch Ljava/lang/NoSuchFieldError; {:try_start_3 .. :try_end_3} :catch_1

    :goto_4
    :try_start_4
    sget-object v1, Lcom/nostra13/universalimageloader/core/assist/FailReason$FailType;->UNKNOWN:Lcom/nostra13/universalimageloader/core/assist/FailReason$FailType;

    invoke-virtual {v1}, Lcom/nostra13/universalimageloader/core/assist/FailReason$FailType;->ordinal()I

    move-result v1

    const/4 v2, 0x5

    aput v2, v0, v1
    :try_end_4
    .catch Ljava/lang/NoSuchFieldError; {:try_start_4 .. :try_end_4} :catch_0

    :goto_5
    sput-object v0, Lcom/aio/downloader/mydownload/MyApplcation$AnimateFirstDisplayListener;->$SWITCH_TABLE$com$nostra13$universalimageloader$core$assist$FailReason$FailType:[I

    goto :goto_0

    :catch_0
    move-exception v1

    goto :goto_5

    :catch_1
    move-exception v1

    goto :goto_4

    :catch_2
    move-exception v1

    goto :goto_3

    :catch_3
    move-exception v1

    goto :goto_2

    :catch_4
    move-exception v1

    goto :goto_1
.end method

.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 204
    new-instance v0, Ljava/util/LinkedList;

    invoke-direct {v0}, Ljava/util/LinkedList;-><init>()V

    invoke-static {v0}, Ljava/util/Collections;->synchronizedList(Ljava/util/List;)Ljava/util/List;

    move-result-object v0

    .line 203
    sput-object v0, Lcom/aio/downloader/mydownload/MyApplcation$AnimateFirstDisplayListener;->displayedImages:Ljava/util/List;

    .line 204
    return-void
.end method

.method private constructor <init>()V
    .locals 0

    .prologue
    .line 201
    invoke-direct {p0}, Lcom/nostra13/universalimageloader/core/assist/SimpleImageLoadingListener;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/aio/downloader/mydownload/MyApplcation$AnimateFirstDisplayListener;)V
    .locals 0

    .prologue
    .line 201
    invoke-direct {p0}, Lcom/aio/downloader/mydownload/MyApplcation$AnimateFirstDisplayListener;-><init>()V

    return-void
.end method


# virtual methods
.method public onLoadingComplete(Ljava/lang/String;Landroid/view/View;Landroid/graphics/Bitmap;)V
    .locals 3
    .param p1, "imageUri"    # Ljava/lang/String;
    .param p2, "view"    # Landroid/view/View;
    .param p3, "loadedImage"    # Landroid/graphics/Bitmap;

    .prologue
    .line 246
    if-eqz p3, :cond_0

    move-object v1, p2

    .line 247
    check-cast v1, Landroid/widget/ImageView;

    .line 248
    .local v1, "imageView":Landroid/widget/ImageView;
    sget-object v2, Lcom/aio/downloader/mydownload/MyApplcation$AnimateFirstDisplayListener;->displayedImages:Ljava/util/List;

    invoke-interface {v2, p1}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_1

    const/4 v0, 0x0

    .line 249
    .local v0, "firstDisplay":Z
    :goto_0
    if-eqz v0, :cond_0

    .line 250
    const/16 v2, 0x1f4

    invoke-static {v1, v2}, Lcom/nostra13/universalimageloader/core/display/FadeInBitmapDisplayer;->animate(Landroid/widget/ImageView;I)V

    .line 251
    sget-object v2, Lcom/aio/downloader/mydownload/MyApplcation$AnimateFirstDisplayListener;->displayedImages:Ljava/util/List;

    invoke-interface {v2, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 254
    .end local v0    # "firstDisplay":Z
    .end local v1    # "imageView":Landroid/widget/ImageView;
    :cond_0
    return-void

    .line 248
    .restart local v1    # "imageView":Landroid/widget/ImageView;
    :cond_1
    const/4 v0, 0x1

    goto :goto_0
.end method

.method public onLoadingFailed(Ljava/lang/String;Landroid/view/View;Lcom/nostra13/universalimageloader/core/assist/FailReason;)V
    .locals 2
    .param p1, "imageUri"    # Ljava/lang/String;
    .param p2, "view"    # Landroid/view/View;
    .param p3, "failReason"    # Lcom/nostra13/universalimageloader/core/assist/FailReason;

    .prologue
    .line 210
    invoke-super {p0, p1, p2, p3}, Lcom/nostra13/universalimageloader/core/assist/SimpleImageLoadingListener;->onLoadingFailed(Ljava/lang/String;Landroid/view/View;Lcom/nostra13/universalimageloader/core/assist/FailReason;)V

    .line 212
    invoke-static {}, Lcom/aio/downloader/mydownload/MyApplcation$AnimateFirstDisplayListener;->$SWITCH_TABLE$com$nostra13$universalimageloader$core$assist$FailReason$FailType()[I

    move-result-object v0

    invoke-virtual {p3}, Lcom/nostra13/universalimageloader/core/assist/FailReason;->getType()Lcom/nostra13/universalimageloader/core/assist/FailReason$FailType;

    move-result-object v1

    invoke-virtual {v1}, Lcom/nostra13/universalimageloader/core/assist/FailReason$FailType;->ordinal()I

    move-result v1

    aget v0, v0, v1

    packed-switch v0, :pswitch_data_0

    .line 241
    :goto_0
    :pswitch_0
    return-void

    .line 223
    :pswitch_1
    const-string v0, "qwerf"

    const-string v1, "OUT_OF_MEMORY"

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0

    .line 212
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method
