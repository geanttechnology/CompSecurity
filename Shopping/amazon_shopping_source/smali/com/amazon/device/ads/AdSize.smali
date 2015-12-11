.class public Lcom/amazon/device/ads/AdSize;
.super Ljava/lang/Object;
.source "AdSize.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/device/ads/AdSize$1;,
        Lcom/amazon/device/ads/AdSize$SizeType;
    }
.end annotation


# static fields
.field private static final LOG_TAG:Ljava/lang/String; = "AdSize"

.field public static final SIZE_1024x50:Lcom/amazon/device/ads/AdSize;

.field public static final SIZE_300x250:Lcom/amazon/device/ads/AdSize;

.field public static final SIZE_300x50:Lcom/amazon/device/ads/AdSize;

.field public static final SIZE_320x50:Lcom/amazon/device/ads/AdSize;

.field public static final SIZE_600x90:Lcom/amazon/device/ads/AdSize;

.field public static final SIZE_728x90:Lcom/amazon/device/ads/AdSize;

.field public static final SIZE_AUTO:Lcom/amazon/device/ads/AdSize;

.field static final SIZE_INTERSTITIAL:Lcom/amazon/device/ads/AdSize;


# instance fields
.field private height:I

.field private type:Lcom/amazon/device/ads/AdSize$SizeType;

.field private width:I


# direct methods
.method static constructor <clinit>()V
    .locals 5

    .prologue
    const/16 v4, 0x12c

    const/16 v3, 0x5a

    const/16 v2, 0x32

    .line 23
    new-instance v0, Lcom/amazon/device/ads/AdSize;

    invoke-direct {v0, v4, v2}, Lcom/amazon/device/ads/AdSize;-><init>(II)V

    sput-object v0, Lcom/amazon/device/ads/AdSize;->SIZE_300x50:Lcom/amazon/device/ads/AdSize;

    .line 27
    new-instance v0, Lcom/amazon/device/ads/AdSize;

    const/16 v1, 0x140

    invoke-direct {v0, v1, v2}, Lcom/amazon/device/ads/AdSize;-><init>(II)V

    sput-object v0, Lcom/amazon/device/ads/AdSize;->SIZE_320x50:Lcom/amazon/device/ads/AdSize;

    .line 31
    new-instance v0, Lcom/amazon/device/ads/AdSize;

    const/16 v1, 0xfa

    invoke-direct {v0, v4, v1}, Lcom/amazon/device/ads/AdSize;-><init>(II)V

    sput-object v0, Lcom/amazon/device/ads/AdSize;->SIZE_300x250:Lcom/amazon/device/ads/AdSize;

    .line 35
    new-instance v0, Lcom/amazon/device/ads/AdSize;

    const/16 v1, 0x258

    invoke-direct {v0, v1, v3}, Lcom/amazon/device/ads/AdSize;-><init>(II)V

    sput-object v0, Lcom/amazon/device/ads/AdSize;->SIZE_600x90:Lcom/amazon/device/ads/AdSize;

    .line 39
    new-instance v0, Lcom/amazon/device/ads/AdSize;

    const/16 v1, 0x2d8

    invoke-direct {v0, v1, v3}, Lcom/amazon/device/ads/AdSize;-><init>(II)V

    sput-object v0, Lcom/amazon/device/ads/AdSize;->SIZE_728x90:Lcom/amazon/device/ads/AdSize;

    .line 43
    new-instance v0, Lcom/amazon/device/ads/AdSize;

    const/16 v1, 0x400

    invoke-direct {v0, v1, v2}, Lcom/amazon/device/ads/AdSize;-><init>(II)V

    sput-object v0, Lcom/amazon/device/ads/AdSize;->SIZE_1024x50:Lcom/amazon/device/ads/AdSize;

    .line 47
    new-instance v0, Lcom/amazon/device/ads/AdSize;

    sget-object v1, Lcom/amazon/device/ads/AdSize$SizeType;->AUTO:Lcom/amazon/device/ads/AdSize$SizeType;

    invoke-direct {v0, v1}, Lcom/amazon/device/ads/AdSize;-><init>(Lcom/amazon/device/ads/AdSize$SizeType;)V

    sput-object v0, Lcom/amazon/device/ads/AdSize;->SIZE_AUTO:Lcom/amazon/device/ads/AdSize;

    .line 51
    new-instance v0, Lcom/amazon/device/ads/AdSize;

    sget-object v1, Lcom/amazon/device/ads/AdSize$SizeType;->INTERSTITIAL:Lcom/amazon/device/ads/AdSize$SizeType;

    invoke-direct {v0, v1}, Lcom/amazon/device/ads/AdSize;-><init>(Lcom/amazon/device/ads/AdSize$SizeType;)V

    sput-object v0, Lcom/amazon/device/ads/AdSize;->SIZE_INTERSTITIAL:Lcom/amazon/device/ads/AdSize;

    return-void
.end method

.method public constructor <init>(II)V
    .locals 0
    .param p1, "width"    # I
    .param p2, "height"    # I

    .prologue
    .line 72
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 73
    invoke-direct {p0, p1, p2}, Lcom/amazon/device/ads/AdSize;->initialize(II)V

    .line 74
    return-void
.end method

.method constructor <init>(Lcom/amazon/device/ads/AdSize$SizeType;)V
    .locals 0
    .param p1, "type"    # Lcom/amazon/device/ads/AdSize$SizeType;

    .prologue
    .line 84
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 85
    iput-object p1, p0, Lcom/amazon/device/ads/AdSize;->type:Lcom/amazon/device/ads/AdSize$SizeType;

    .line 86
    return-void
.end method

.method constructor <init>(Ljava/lang/String;Ljava/lang/String;)V
    .locals 3
    .param p1, "width"    # Ljava/lang/String;
    .param p2, "height"    # Ljava/lang/String;

    .prologue
    const/4 v2, 0x0

    .line 77
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 78
    invoke-static {p1, v2}, Lcom/amazon/device/ads/Utils;->parseInt(Ljava/lang/String;I)I

    move-result v1

    .line 79
    .local v1, "parsedWidth":I
    invoke-static {p2, v2}, Lcom/amazon/device/ads/Utils;->parseInt(Ljava/lang/String;I)I

    move-result v0

    .line 80
    .local v0, "parsedHeight":I
    invoke-direct {p0, v1, v0}, Lcom/amazon/device/ads/AdSize;->initialize(II)V

    .line 81
    return-void
.end method

.method private initialize(II)V
    .locals 2
    .param p1, "width"    # I
    .param p2, "height"    # I

    .prologue
    .line 90
    if-lez p1, :cond_0

    if-gtz p2, :cond_1

    .line 92
    :cond_0
    const-string/jumbo v0, "The width and height must be positive integers."

    .line 93
    .local v0, "msg":Ljava/lang/String;
    const-string/jumbo v1, "AdSize"

    invoke-static {v1, v0}, Lcom/amazon/device/ads/Log;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 94
    new-instance v1, Ljava/lang/IllegalArgumentException;

    invoke-direct {v1, v0}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 97
    .end local v0    # "msg":Ljava/lang/String;
    :cond_1
    iput p1, p0, Lcom/amazon/device/ads/AdSize;->width:I

    .line 98
    iput p2, p0, Lcom/amazon/device/ads/AdSize;->height:I

    .line 99
    sget-object v1, Lcom/amazon/device/ads/AdSize$SizeType;->EXPLICIT:Lcom/amazon/device/ads/AdSize$SizeType;

    iput-object v1, p0, Lcom/amazon/device/ads/AdSize;->type:Lcom/amazon/device/ads/AdSize$SizeType;

    .line 100
    return-void
.end method


# virtual methods
.method public getHeight()I
    .locals 1

    .prologue
    .line 142
    iget v0, p0, Lcom/amazon/device/ads/AdSize;->height:I

    return v0
.end method

.method public getWidth()I
    .locals 1

    .prologue
    .line 133
    iget v0, p0, Lcom/amazon/device/ads/AdSize;->width:I

    return v0
.end method

.method public isAuto()Z
    .locals 2

    .prologue
    .line 151
    iget-object v0, p0, Lcom/amazon/device/ads/AdSize;->type:Lcom/amazon/device/ads/AdSize$SizeType;

    sget-object v1, Lcom/amazon/device/ads/AdSize$SizeType;->AUTO:Lcom/amazon/device/ads/AdSize$SizeType;

    if-ne v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public toString()Ljava/lang/String;
    .locals 6

    .prologue
    .line 110
    const/4 v0, 0x0

    .line 111
    .local v0, "sizeString":Ljava/lang/String;
    sget-object v1, Lcom/amazon/device/ads/AdSize$1;->$SwitchMap$com$amazon$device$ads$AdSize$SizeType:[I

    iget-object v2, p0, Lcom/amazon/device/ads/AdSize;->type:Lcom/amazon/device/ads/AdSize$SizeType;

    invoke-virtual {v2}, Lcom/amazon/device/ads/AdSize$SizeType;->ordinal()I

    move-result v2

    aget v1, v1, v2

    packed-switch v1, :pswitch_data_0

    .line 123
    :goto_0
    return-object v0

    .line 114
    :pswitch_0
    sget-object v1, Ljava/util/Locale;->US:Ljava/util/Locale;

    const-string/jumbo v2, "%dx%d"

    const/4 v3, 0x2

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    iget v5, p0, Lcom/amazon/device/ads/AdSize;->width:I

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    aput-object v5, v3, v4

    const/4 v4, 0x1

    iget v5, p0, Lcom/amazon/device/ads/AdSize;->height:I

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-static {v1, v2, v3}, Ljava/lang/String;->format(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    .line 115
    goto :goto_0

    .line 117
    :pswitch_1
    const-string/jumbo v0, "auto"

    .line 118
    goto :goto_0

    .line 120
    :pswitch_2
    const-string/jumbo v0, "interstitial"

    goto :goto_0

    .line 111
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method
