.class public Lcom/amazon/mShop/search/image/SnapItActivity;
.super Lcom/amazon/mShop/AmazonActivity;
.source "SnapItActivity.java"


# static fields
.field private static sLastPhotoCaptured:[B

.field private static sLastknownOrientation:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 12
    invoke-direct {p0}, Lcom/amazon/mShop/AmazonActivity;-><init>()V

    return-void
.end method

.method static clearLastPhotoCaptured()V
    .locals 1

    .prologue
    .line 85
    const/4 v0, 0x0

    sput-object v0, Lcom/amazon/mShop/search/image/SnapItActivity;->sLastPhotoCaptured:[B

    .line 86
    const/4 v0, -0x1

    sput v0, Lcom/amazon/mShop/search/image/SnapItActivity;->sLastknownOrientation:I

    .line 87
    return-void
.end method

.method static getLastKnownOrientation()I
    .locals 1

    .prologue
    .line 94
    sget v0, Lcom/amazon/mShop/search/image/SnapItActivity;->sLastknownOrientation:I

    return v0
.end method

.method static getLastPhotoCapturedOriginal()[B
    .locals 1

    .prologue
    .line 90
    sget-object v0, Lcom/amazon/mShop/search/image/SnapItActivity;->sLastPhotoCaptured:[B

    return-object v0
.end method

.method static setLastPhotoCaptured([B)V
    .locals 0
    .param p0, "jpegData"    # [B

    .prologue
    .line 80
    sput-object p0, Lcom/amazon/mShop/search/image/SnapItActivity;->sLastPhotoCaptured:[B

    .line 81
    return-void
.end method

.method static setLastPhotoCaptured([BI)V
    .locals 0
    .param p0, "jpegData"    # [B
    .param p1, "orientation"    # I

    .prologue
    .line 73
    sput-object p0, Lcom/amazon/mShop/search/image/SnapItActivity;->sLastPhotoCaptured:[B

    .line 74
    sput p1, Lcom/amazon/mShop/search/image/SnapItActivity;->sLastknownOrientation:I

    .line 75
    return-void
.end method

.method private startPreview()V
    .locals 2

    .prologue
    .line 68
    new-instance v0, Landroid/content/Intent;

    const-class v1, Lcom/amazon/mShop/search/image/SnapItPhotoPreviewActivity;

    invoke-direct {v0, p0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 69
    .local v0, "intent":Landroid/content/Intent;
    const/16 v1, 0xc

    invoke-virtual {p0, v0, v1}, Lcom/amazon/mShop/search/image/SnapItActivity;->startActivityForResult(Landroid/content/Intent;I)V

    .line 70
    return-void
.end method

.method private startSnapItCapture()V
    .locals 2

    .prologue
    .line 62
    new-instance v0, Landroid/content/Intent;

    const-class v1, Lcom/amazon/mShop/search/image/SnapItPhotoCaptureActivity;

    invoke-direct {v0, p0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 63
    .local v0, "intent":Landroid/content/Intent;
    const/16 v1, 0xb

    invoke-virtual {p0, v0, v1}, Lcom/amazon/mShop/search/image/SnapItActivity;->startActivityForResult(Landroid/content/Intent;I)V

    .line 64
    return-void
.end method


# virtual methods
.method protected onActivityResult(IILandroid/content/Intent;)V
    .locals 4
    .param p1, "requestCode"    # I
    .param p2, "resultCode"    # I
    .param p3, "data"    # Landroid/content/Intent;

    .prologue
    const/16 v3, 0x3eb

    const/16 v2, 0xb

    const/4 v1, 0x0

    .line 32
    if-ne v2, p1, :cond_1

    const/16 v0, 0x3e9

    if-ne v0, p2, :cond_1

    .line 34
    invoke-direct {p0}, Lcom/amazon/mShop/search/image/SnapItActivity;->startPreview()V

    .line 57
    :cond_0
    :goto_0
    return-void

    .line 35
    :cond_1
    if-ne v2, p1, :cond_2

    if-nez p2, :cond_2

    .line 36
    invoke-virtual {p0, v1}, Lcom/amazon/mShop/search/image/SnapItActivity;->setResult(I)V

    .line 37
    invoke-static {}, Lcom/amazon/mShop/search/image/SnapItActivity;->clearLastPhotoCaptured()V

    .line 38
    invoke-virtual {p0}, Lcom/amazon/mShop/search/image/SnapItActivity;->finish()V

    goto :goto_0

    .line 39
    :cond_2
    const/16 v0, 0xc

    if-ne v0, p1, :cond_0

    .line 41
    const/16 v0, 0x3ea

    if-ne v0, p2, :cond_3

    .line 43
    invoke-static {}, Lcom/amazon/mShop/search/image/SnapItActivity;->clearLastPhotoCaptured()V

    .line 44
    invoke-direct {p0}, Lcom/amazon/mShop/search/image/SnapItActivity;->startSnapItCapture()V

    goto :goto_0

    .line 45
    :cond_3
    if-ne v3, p2, :cond_4

    .line 47
    invoke-virtual {p0, v3}, Lcom/amazon/mShop/search/image/SnapItActivity;->setResult(I)V

    .line 48
    invoke-virtual {p0}, Lcom/amazon/mShop/search/image/SnapItActivity;->finish()V

    goto :goto_0

    .line 51
    :cond_4
    invoke-static {}, Lcom/amazon/mShop/search/image/SnapItActivity;->clearLastPhotoCaptured()V

    .line 52
    invoke-virtual {p0, v1}, Lcom/amazon/mShop/search/image/SnapItActivity;->setResult(I)V

    .line 53
    invoke-virtual {p0}, Lcom/amazon/mShop/search/image/SnapItActivity;->finish()V

    goto :goto_0
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 0
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 20
    invoke-super {p0, p1}, Lcom/amazon/mShop/AmazonActivity;->onCreate(Landroid/os/Bundle;)V

    .line 21
    invoke-direct {p0}, Lcom/amazon/mShop/search/image/SnapItActivity;->startSnapItCapture()V

    .line 22
    return-void
.end method

.method protected onStart()V
    .locals 0

    .prologue
    .line 26
    invoke-super {p0}, Lcom/amazon/mShop/AmazonActivity;->onStart()V

    .line 27
    return-void
.end method
