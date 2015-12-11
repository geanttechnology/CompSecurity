.class public final Lcom/nostra13/universalimageloader/core/DisplayImageOptions;
.super Ljava/lang/Object;
.source "DisplayImageOptions.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/nostra13/universalimageloader/core/DisplayImageOptions$Builder;
    }
.end annotation


# instance fields
.field private final cacheInMemory:Z

.field private final cacheOnDisc:Z

.field private final decodingOptions:Landroid/graphics/BitmapFactory$Options;

.field private final delayBeforeLoading:I

.field private final displayer:Lcom/nostra13/universalimageloader/core/display/BitmapDisplayer;

.field private final extraForDownloader:Ljava/lang/Object;

.field private final handler:Landroid/os/Handler;

.field private final imageForEmptyUri:I

.field private final imageOnFail:I

.field private final imageScaleType:Lcom/nostra13/universalimageloader/core/assist/ImageScaleType;

.field private final postProcessor:Lcom/nostra13/universalimageloader/core/process/BitmapProcessor;

.field private final preProcessor:Lcom/nostra13/universalimageloader/core/process/BitmapProcessor;

.field private final resetViewBeforeLoading:Z

.field private final stubImage:I


# direct methods
.method private constructor <init>(Lcom/nostra13/universalimageloader/core/DisplayImageOptions$Builder;)V
    .locals 1
    .param p1, "builder"    # Lcom/nostra13/universalimageloader/core/DisplayImageOptions$Builder;

    .prologue
    .line 77
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 78
    # getter for: Lcom/nostra13/universalimageloader/core/DisplayImageOptions$Builder;->stubImage:I
    invoke-static {p1}, Lcom/nostra13/universalimageloader/core/DisplayImageOptions$Builder;->access$0(Lcom/nostra13/universalimageloader/core/DisplayImageOptions$Builder;)I

    move-result v0

    iput v0, p0, Lcom/nostra13/universalimageloader/core/DisplayImageOptions;->stubImage:I

    .line 79
    # getter for: Lcom/nostra13/universalimageloader/core/DisplayImageOptions$Builder;->imageForEmptyUri:I
    invoke-static {p1}, Lcom/nostra13/universalimageloader/core/DisplayImageOptions$Builder;->access$1(Lcom/nostra13/universalimageloader/core/DisplayImageOptions$Builder;)I

    move-result v0

    iput v0, p0, Lcom/nostra13/universalimageloader/core/DisplayImageOptions;->imageForEmptyUri:I

    .line 80
    # getter for: Lcom/nostra13/universalimageloader/core/DisplayImageOptions$Builder;->imageOnFail:I
    invoke-static {p1}, Lcom/nostra13/universalimageloader/core/DisplayImageOptions$Builder;->access$2(Lcom/nostra13/universalimageloader/core/DisplayImageOptions$Builder;)I

    move-result v0

    iput v0, p0, Lcom/nostra13/universalimageloader/core/DisplayImageOptions;->imageOnFail:I

    .line 81
    # getter for: Lcom/nostra13/universalimageloader/core/DisplayImageOptions$Builder;->resetViewBeforeLoading:Z
    invoke-static {p1}, Lcom/nostra13/universalimageloader/core/DisplayImageOptions$Builder;->access$3(Lcom/nostra13/universalimageloader/core/DisplayImageOptions$Builder;)Z

    move-result v0

    iput-boolean v0, p0, Lcom/nostra13/universalimageloader/core/DisplayImageOptions;->resetViewBeforeLoading:Z

    .line 82
    # getter for: Lcom/nostra13/universalimageloader/core/DisplayImageOptions$Builder;->cacheInMemory:Z
    invoke-static {p1}, Lcom/nostra13/universalimageloader/core/DisplayImageOptions$Builder;->access$4(Lcom/nostra13/universalimageloader/core/DisplayImageOptions$Builder;)Z

    move-result v0

    iput-boolean v0, p0, Lcom/nostra13/universalimageloader/core/DisplayImageOptions;->cacheInMemory:Z

    .line 83
    # getter for: Lcom/nostra13/universalimageloader/core/DisplayImageOptions$Builder;->cacheOnDisc:Z
    invoke-static {p1}, Lcom/nostra13/universalimageloader/core/DisplayImageOptions$Builder;->access$5(Lcom/nostra13/universalimageloader/core/DisplayImageOptions$Builder;)Z

    move-result v0

    iput-boolean v0, p0, Lcom/nostra13/universalimageloader/core/DisplayImageOptions;->cacheOnDisc:Z

    .line 84
    # getter for: Lcom/nostra13/universalimageloader/core/DisplayImageOptions$Builder;->imageScaleType:Lcom/nostra13/universalimageloader/core/assist/ImageScaleType;
    invoke-static {p1}, Lcom/nostra13/universalimageloader/core/DisplayImageOptions$Builder;->access$6(Lcom/nostra13/universalimageloader/core/DisplayImageOptions$Builder;)Lcom/nostra13/universalimageloader/core/assist/ImageScaleType;

    move-result-object v0

    iput-object v0, p0, Lcom/nostra13/universalimageloader/core/DisplayImageOptions;->imageScaleType:Lcom/nostra13/universalimageloader/core/assist/ImageScaleType;

    .line 85
    # getter for: Lcom/nostra13/universalimageloader/core/DisplayImageOptions$Builder;->decodingOptions:Landroid/graphics/BitmapFactory$Options;
    invoke-static {p1}, Lcom/nostra13/universalimageloader/core/DisplayImageOptions$Builder;->access$7(Lcom/nostra13/universalimageloader/core/DisplayImageOptions$Builder;)Landroid/graphics/BitmapFactory$Options;

    move-result-object v0

    iput-object v0, p0, Lcom/nostra13/universalimageloader/core/DisplayImageOptions;->decodingOptions:Landroid/graphics/BitmapFactory$Options;

    .line 86
    # getter for: Lcom/nostra13/universalimageloader/core/DisplayImageOptions$Builder;->delayBeforeLoading:I
    invoke-static {p1}, Lcom/nostra13/universalimageloader/core/DisplayImageOptions$Builder;->access$8(Lcom/nostra13/universalimageloader/core/DisplayImageOptions$Builder;)I

    move-result v0

    iput v0, p0, Lcom/nostra13/universalimageloader/core/DisplayImageOptions;->delayBeforeLoading:I

    .line 87
    # getter for: Lcom/nostra13/universalimageloader/core/DisplayImageOptions$Builder;->extraForDownloader:Ljava/lang/Object;
    invoke-static {p1}, Lcom/nostra13/universalimageloader/core/DisplayImageOptions$Builder;->access$9(Lcom/nostra13/universalimageloader/core/DisplayImageOptions$Builder;)Ljava/lang/Object;

    move-result-object v0

    iput-object v0, p0, Lcom/nostra13/universalimageloader/core/DisplayImageOptions;->extraForDownloader:Ljava/lang/Object;

    .line 88
    # getter for: Lcom/nostra13/universalimageloader/core/DisplayImageOptions$Builder;->preProcessor:Lcom/nostra13/universalimageloader/core/process/BitmapProcessor;
    invoke-static {p1}, Lcom/nostra13/universalimageloader/core/DisplayImageOptions$Builder;->access$10(Lcom/nostra13/universalimageloader/core/DisplayImageOptions$Builder;)Lcom/nostra13/universalimageloader/core/process/BitmapProcessor;

    move-result-object v0

    iput-object v0, p0, Lcom/nostra13/universalimageloader/core/DisplayImageOptions;->preProcessor:Lcom/nostra13/universalimageloader/core/process/BitmapProcessor;

    .line 89
    # getter for: Lcom/nostra13/universalimageloader/core/DisplayImageOptions$Builder;->postProcessor:Lcom/nostra13/universalimageloader/core/process/BitmapProcessor;
    invoke-static {p1}, Lcom/nostra13/universalimageloader/core/DisplayImageOptions$Builder;->access$11(Lcom/nostra13/universalimageloader/core/DisplayImageOptions$Builder;)Lcom/nostra13/universalimageloader/core/process/BitmapProcessor;

    move-result-object v0

    iput-object v0, p0, Lcom/nostra13/universalimageloader/core/DisplayImageOptions;->postProcessor:Lcom/nostra13/universalimageloader/core/process/BitmapProcessor;

    .line 90
    # getter for: Lcom/nostra13/universalimageloader/core/DisplayImageOptions$Builder;->displayer:Lcom/nostra13/universalimageloader/core/display/BitmapDisplayer;
    invoke-static {p1}, Lcom/nostra13/universalimageloader/core/DisplayImageOptions$Builder;->access$12(Lcom/nostra13/universalimageloader/core/DisplayImageOptions$Builder;)Lcom/nostra13/universalimageloader/core/display/BitmapDisplayer;

    move-result-object v0

    iput-object v0, p0, Lcom/nostra13/universalimageloader/core/DisplayImageOptions;->displayer:Lcom/nostra13/universalimageloader/core/display/BitmapDisplayer;

    .line 91
    # getter for: Lcom/nostra13/universalimageloader/core/DisplayImageOptions$Builder;->handler:Landroid/os/Handler;
    invoke-static {p1}, Lcom/nostra13/universalimageloader/core/DisplayImageOptions$Builder;->access$13(Lcom/nostra13/universalimageloader/core/DisplayImageOptions$Builder;)Landroid/os/Handler;

    move-result-object v0

    iput-object v0, p0, Lcom/nostra13/universalimageloader/core/DisplayImageOptions;->handler:Landroid/os/Handler;

    .line 92
    return-void
.end method

.method synthetic constructor <init>(Lcom/nostra13/universalimageloader/core/DisplayImageOptions$Builder;Lcom/nostra13/universalimageloader/core/DisplayImageOptions;)V
    .locals 0

    .prologue
    .line 77
    invoke-direct {p0, p1}, Lcom/nostra13/universalimageloader/core/DisplayImageOptions;-><init>(Lcom/nostra13/universalimageloader/core/DisplayImageOptions$Builder;)V

    return-void
.end method

.method static synthetic access$0(Lcom/nostra13/universalimageloader/core/DisplayImageOptions;)I
    .locals 1

    .prologue
    .line 62
    iget v0, p0, Lcom/nostra13/universalimageloader/core/DisplayImageOptions;->stubImage:I

    return v0
.end method

.method static synthetic access$1(Lcom/nostra13/universalimageloader/core/DisplayImageOptions;)I
    .locals 1

    .prologue
    .line 63
    iget v0, p0, Lcom/nostra13/universalimageloader/core/DisplayImageOptions;->imageForEmptyUri:I

    return v0
.end method

.method static synthetic access$10(Lcom/nostra13/universalimageloader/core/DisplayImageOptions;)Lcom/nostra13/universalimageloader/core/process/BitmapProcessor;
    .locals 1

    .prologue
    .line 72
    iget-object v0, p0, Lcom/nostra13/universalimageloader/core/DisplayImageOptions;->preProcessor:Lcom/nostra13/universalimageloader/core/process/BitmapProcessor;

    return-object v0
.end method

.method static synthetic access$11(Lcom/nostra13/universalimageloader/core/DisplayImageOptions;)Lcom/nostra13/universalimageloader/core/process/BitmapProcessor;
    .locals 1

    .prologue
    .line 73
    iget-object v0, p0, Lcom/nostra13/universalimageloader/core/DisplayImageOptions;->postProcessor:Lcom/nostra13/universalimageloader/core/process/BitmapProcessor;

    return-object v0
.end method

.method static synthetic access$12(Lcom/nostra13/universalimageloader/core/DisplayImageOptions;)Lcom/nostra13/universalimageloader/core/display/BitmapDisplayer;
    .locals 1

    .prologue
    .line 74
    iget-object v0, p0, Lcom/nostra13/universalimageloader/core/DisplayImageOptions;->displayer:Lcom/nostra13/universalimageloader/core/display/BitmapDisplayer;

    return-object v0
.end method

.method static synthetic access$13(Lcom/nostra13/universalimageloader/core/DisplayImageOptions;)Landroid/os/Handler;
    .locals 1

    .prologue
    .line 75
    iget-object v0, p0, Lcom/nostra13/universalimageloader/core/DisplayImageOptions;->handler:Landroid/os/Handler;

    return-object v0
.end method

.method static synthetic access$2(Lcom/nostra13/universalimageloader/core/DisplayImageOptions;)I
    .locals 1

    .prologue
    .line 64
    iget v0, p0, Lcom/nostra13/universalimageloader/core/DisplayImageOptions;->imageOnFail:I

    return v0
.end method

.method static synthetic access$3(Lcom/nostra13/universalimageloader/core/DisplayImageOptions;)Z
    .locals 1

    .prologue
    .line 65
    iget-boolean v0, p0, Lcom/nostra13/universalimageloader/core/DisplayImageOptions;->resetViewBeforeLoading:Z

    return v0
.end method

.method static synthetic access$4(Lcom/nostra13/universalimageloader/core/DisplayImageOptions;)Z
    .locals 1

    .prologue
    .line 66
    iget-boolean v0, p0, Lcom/nostra13/universalimageloader/core/DisplayImageOptions;->cacheInMemory:Z

    return v0
.end method

.method static synthetic access$5(Lcom/nostra13/universalimageloader/core/DisplayImageOptions;)Z
    .locals 1

    .prologue
    .line 67
    iget-boolean v0, p0, Lcom/nostra13/universalimageloader/core/DisplayImageOptions;->cacheOnDisc:Z

    return v0
.end method

.method static synthetic access$6(Lcom/nostra13/universalimageloader/core/DisplayImageOptions;)Lcom/nostra13/universalimageloader/core/assist/ImageScaleType;
    .locals 1

    .prologue
    .line 68
    iget-object v0, p0, Lcom/nostra13/universalimageloader/core/DisplayImageOptions;->imageScaleType:Lcom/nostra13/universalimageloader/core/assist/ImageScaleType;

    return-object v0
.end method

.method static synthetic access$7(Lcom/nostra13/universalimageloader/core/DisplayImageOptions;)Landroid/graphics/BitmapFactory$Options;
    .locals 1

    .prologue
    .line 69
    iget-object v0, p0, Lcom/nostra13/universalimageloader/core/DisplayImageOptions;->decodingOptions:Landroid/graphics/BitmapFactory$Options;

    return-object v0
.end method

.method static synthetic access$8(Lcom/nostra13/universalimageloader/core/DisplayImageOptions;)I
    .locals 1

    .prologue
    .line 70
    iget v0, p0, Lcom/nostra13/universalimageloader/core/DisplayImageOptions;->delayBeforeLoading:I

    return v0
.end method

.method static synthetic access$9(Lcom/nostra13/universalimageloader/core/DisplayImageOptions;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 71
    iget-object v0, p0, Lcom/nostra13/universalimageloader/core/DisplayImageOptions;->extraForDownloader:Ljava/lang/Object;

    return-object v0
.end method

.method public static createSimple()Lcom/nostra13/universalimageloader/core/DisplayImageOptions;
    .locals 1

    .prologue
    .line 366
    new-instance v0, Lcom/nostra13/universalimageloader/core/DisplayImageOptions$Builder;

    invoke-direct {v0}, Lcom/nostra13/universalimageloader/core/DisplayImageOptions$Builder;-><init>()V

    invoke-virtual {v0}, Lcom/nostra13/universalimageloader/core/DisplayImageOptions$Builder;->build()Lcom/nostra13/universalimageloader/core/DisplayImageOptions;

    move-result-object v0

    return-object v0
.end method


# virtual methods
.method public getDecodingOptions()Landroid/graphics/BitmapFactory$Options;
    .locals 1

    .prologue
    .line 147
    iget-object v0, p0, Lcom/nostra13/universalimageloader/core/DisplayImageOptions;->decodingOptions:Landroid/graphics/BitmapFactory$Options;

    return-object v0
.end method

.method public getDelayBeforeLoading()I
    .locals 1

    .prologue
    .line 151
    iget v0, p0, Lcom/nostra13/universalimageloader/core/DisplayImageOptions;->delayBeforeLoading:I

    return v0
.end method

.method public getDisplayer()Lcom/nostra13/universalimageloader/core/display/BitmapDisplayer;
    .locals 1

    .prologue
    .line 167
    iget-object v0, p0, Lcom/nostra13/universalimageloader/core/DisplayImageOptions;->displayer:Lcom/nostra13/universalimageloader/core/display/BitmapDisplayer;

    return-object v0
.end method

.method public getExtraForDownloader()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 155
    iget-object v0, p0, Lcom/nostra13/universalimageloader/core/DisplayImageOptions;->extraForDownloader:Ljava/lang/Object;

    return-object v0
.end method

.method public getHandler()Landroid/os/Handler;
    .locals 1

    .prologue
    .line 171
    iget-object v0, p0, Lcom/nostra13/universalimageloader/core/DisplayImageOptions;->handler:Landroid/os/Handler;

    if-nez v0, :cond_0

    new-instance v0, Landroid/os/Handler;

    invoke-direct {v0}, Landroid/os/Handler;-><init>()V

    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/nostra13/universalimageloader/core/DisplayImageOptions;->handler:Landroid/os/Handler;

    goto :goto_0
.end method

.method public getImageForEmptyUri()I
    .locals 1

    .prologue
    .line 123
    iget v0, p0, Lcom/nostra13/universalimageloader/core/DisplayImageOptions;->imageForEmptyUri:I

    return v0
.end method

.method public getImageOnFail()I
    .locals 1

    .prologue
    .line 127
    iget v0, p0, Lcom/nostra13/universalimageloader/core/DisplayImageOptions;->imageOnFail:I

    return v0
.end method

.method public getImageScaleType()Lcom/nostra13/universalimageloader/core/assist/ImageScaleType;
    .locals 1

    .prologue
    .line 143
    iget-object v0, p0, Lcom/nostra13/universalimageloader/core/DisplayImageOptions;->imageScaleType:Lcom/nostra13/universalimageloader/core/assist/ImageScaleType;

    return-object v0
.end method

.method public getPostProcessor()Lcom/nostra13/universalimageloader/core/process/BitmapProcessor;
    .locals 1

    .prologue
    .line 163
    iget-object v0, p0, Lcom/nostra13/universalimageloader/core/DisplayImageOptions;->postProcessor:Lcom/nostra13/universalimageloader/core/process/BitmapProcessor;

    return-object v0
.end method

.method public getPreProcessor()Lcom/nostra13/universalimageloader/core/process/BitmapProcessor;
    .locals 1

    .prologue
    .line 159
    iget-object v0, p0, Lcom/nostra13/universalimageloader/core/DisplayImageOptions;->preProcessor:Lcom/nostra13/universalimageloader/core/process/BitmapProcessor;

    return-object v0
.end method

.method public getStubImage()I
    .locals 1

    .prologue
    .line 119
    iget v0, p0, Lcom/nostra13/universalimageloader/core/DisplayImageOptions;->stubImage:I

    return v0
.end method

.method public isCacheInMemory()Z
    .locals 1

    .prologue
    .line 135
    iget-boolean v0, p0, Lcom/nostra13/universalimageloader/core/DisplayImageOptions;->cacheInMemory:Z

    return v0
.end method

.method public isCacheOnDisc()Z
    .locals 1

    .prologue
    .line 139
    iget-boolean v0, p0, Lcom/nostra13/universalimageloader/core/DisplayImageOptions;->cacheOnDisc:Z

    return v0
.end method

.method public isResetViewBeforeLoading()Z
    .locals 1

    .prologue
    .line 131
    iget-boolean v0, p0, Lcom/nostra13/universalimageloader/core/DisplayImageOptions;->resetViewBeforeLoading:Z

    return v0
.end method

.method public shouldDelayBeforeLoading()Z
    .locals 1

    .prologue
    .line 115
    iget v0, p0, Lcom/nostra13/universalimageloader/core/DisplayImageOptions;->delayBeforeLoading:I

    if-lez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public shouldPostProcess()Z
    .locals 1

    .prologue
    .line 111
    iget-object v0, p0, Lcom/nostra13/universalimageloader/core/DisplayImageOptions;->postProcessor:Lcom/nostra13/universalimageloader/core/process/BitmapProcessor;

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public shouldPreProcess()Z
    .locals 1

    .prologue
    .line 107
    iget-object v0, p0, Lcom/nostra13/universalimageloader/core/DisplayImageOptions;->preProcessor:Lcom/nostra13/universalimageloader/core/process/BitmapProcessor;

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public shouldShowImageForEmptyUri()Z
    .locals 1

    .prologue
    .line 99
    iget v0, p0, Lcom/nostra13/universalimageloader/core/DisplayImageOptions;->imageForEmptyUri:I

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public shouldShowImageOnFail()Z
    .locals 1

    .prologue
    .line 103
    iget v0, p0, Lcom/nostra13/universalimageloader/core/DisplayImageOptions;->imageOnFail:I

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public shouldShowStubImage()Z
    .locals 1

    .prologue
    .line 95
    iget v0, p0, Lcom/nostra13/universalimageloader/core/DisplayImageOptions;->stubImage:I

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method
