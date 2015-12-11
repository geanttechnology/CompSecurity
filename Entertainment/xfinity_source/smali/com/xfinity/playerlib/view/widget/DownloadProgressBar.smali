.class public Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;
.super Landroid/widget/RelativeLayout;
.source "DownloadProgressBar.java"


# instance fields
.field protected final LOG:Lorg/slf4j/Logger;

.field private cancelDownloadBtn:Landroid/widget/ImageButton;

.field private downloadProgressBar:Landroid/widget/ProgressBar;

.field private downloadProgressText:Landroid/widget/TextView;

.field private downloadSizeText:Landroid/widget/TextView;

.field private hotwireDownloadBtn:Landroid/widget/ImageButton;

.field private inflator:Landroid/view/LayoutInflater;

.field private retryDownloadBtn:Landroid/widget/ImageButton;

.field showHotwireButton:Z

.field showSize:Z


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    const/4 v1, 0x1

    .line 42
    invoke-direct {p0, p1}, Landroid/widget/RelativeLayout;-><init>(Landroid/content/Context;)V

    .line 27
    const-class v0, Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;->LOG:Lorg/slf4j/Logger;

    .line 38
    iput-boolean v1, p0, Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;->showSize:Z

    .line 39
    iput-boolean v1, p0, Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;->showHotwireButton:Z

    .line 43
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;->initialize(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 44
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    const/4 v1, 0x1

    .line 47
    invoke-direct {p0, p1, p2}, Landroid/widget/RelativeLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 27
    const-class v0, Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;->LOG:Lorg/slf4j/Logger;

    .line 38
    iput-boolean v1, p0, Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;->showSize:Z

    .line 39
    iput-boolean v1, p0, Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;->showHotwireButton:Z

    .line 48
    invoke-direct {p0, p1, p2}, Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;->initialize(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 49
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;
    .param p3, "defStyle"    # I

    .prologue
    const/4 v1, 0x1

    .line 52
    invoke-direct {p0, p1, p2, p3}, Landroid/widget/RelativeLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 27
    const-class v0, Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;->LOG:Lorg/slf4j/Logger;

    .line 38
    iput-boolean v1, p0, Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;->showSize:Z

    .line 39
    iput-boolean v1, p0, Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;->showHotwireButton:Z

    .line 53
    invoke-direct {p0, p1, p2}, Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;->initialize(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 54
    return-void
.end method

.method static synthetic access$000(Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;)Landroid/widget/ProgressBar;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;

    .prologue
    .line 26
    iget-object v0, p0, Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;->downloadProgressBar:Landroid/widget/ProgressBar;

    return-object v0
.end method

.method static synthetic access$100(Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;)Landroid/widget/TextView;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;

    .prologue
    .line 26
    iget-object v0, p0, Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;->downloadProgressText:Landroid/widget/TextView;

    return-object v0
.end method

.method static synthetic access$200(Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;)Landroid/widget/TextView;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;

    .prologue
    .line 26
    iget-object v0, p0, Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;->downloadSizeText:Landroid/widget/TextView;

    return-object v0
.end method

.method private initialize(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 5
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    const/4 v4, 0x1

    .line 57
    if-eqz p2, :cond_0

    .line 58
    sget-object v2, Lcom/xfinity/playerlib/R$styleable;->com_xfinity_playerlib_view_widget_DownloadProgressBar:[I

    invoke-virtual {p1, p2, v2}, Landroid/content/Context;->obtainStyledAttributes(Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;

    move-result-object v0

    .line 59
    .local v0, "a":Landroid/content/res/TypedArray;
    sget v2, Lcom/xfinity/playerlib/R$styleable;->com_xfinity_playerlib_view_widget_DownloadProgressBar_showSize:I

    invoke-virtual {v0, v2, v4}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v2

    iput-boolean v2, p0, Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;->showSize:Z

    .line 60
    sget v2, Lcom/xfinity/playerlib/R$styleable;->com_xfinity_playerlib_view_widget_DownloadProgressBar_showHotwireButton:I

    invoke-virtual {v0, v2, v4}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v2

    iput-boolean v2, p0, Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;->showHotwireButton:Z

    .line 61
    invoke-virtual {v0}, Landroid/content/res/TypedArray;->recycle()V

    .line 64
    .end local v0    # "a":Landroid/content/res/TypedArray;
    :cond_0
    const-string v2, "layout_inflater"

    invoke-virtual {p1, v2}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/view/LayoutInflater;

    iput-object v2, p0, Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;->inflator:Landroid/view/LayoutInflater;

    .line 65
    iget-object v2, p0, Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;->inflator:Landroid/view/LayoutInflater;

    sget v3, Lcom/xfinity/playerlib/R$layout;->download_progress:I

    invoke-virtual {v2, v3, p0, v4}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/view/ViewGroup;

    .line 67
    .local v1, "layout":Landroid/view/ViewGroup;
    sget v2, Lcom/xfinity/playerlib/R$id;->download_progress_text:I

    invoke-virtual {v1, v2}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/TextView;

    iput-object v2, p0, Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;->downloadProgressText:Landroid/widget/TextView;

    .line 68
    sget v2, Lcom/xfinity/playerlib/R$id;->download_progress_bar:I

    invoke-virtual {v1, v2}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/ProgressBar;

    iput-object v2, p0, Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;->downloadProgressBar:Landroid/widget/ProgressBar;

    .line 69
    sget v2, Lcom/xfinity/playerlib/R$id;->download_size_text:I

    invoke-virtual {v1, v2}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/TextView;

    iput-object v2, p0, Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;->downloadSizeText:Landroid/widget/TextView;

    .line 70
    sget v2, Lcom/xfinity/playerlib/R$id;->cancel_download_button:I

    invoke-virtual {v1, v2}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/ImageButton;

    iput-object v2, p0, Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;->cancelDownloadBtn:Landroid/widget/ImageButton;

    .line 71
    sget v2, Lcom/xfinity/playerlib/R$id;->hotwire_download_button:I

    invoke-virtual {v1, v2}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/ImageButton;

    iput-object v2, p0, Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;->hotwireDownloadBtn:Landroid/widget/ImageButton;

    .line 72
    sget v2, Lcom/xfinity/playerlib/R$id;->retry_download_button:I

    invoke-virtual {v1, v2}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/ImageButton;

    iput-object v2, p0, Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;->retryDownloadBtn:Landroid/widget/ImageButton;

    .line 74
    iget-boolean v2, p0, Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;->showSize:Z

    if-nez v2, :cond_1

    .line 75
    iget-object v2, p0, Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;->downloadSizeText:Landroid/widget/TextView;

    const/16 v3, 0x8

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setVisibility(I)V

    .line 77
    :cond_1
    return-void
.end method

.method private setProgressText(I)V
    .locals 2
    .param p1, "resourceId"    # I

    .prologue
    .line 207
    iget-object v0, p0, Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;->downloadProgressText:Landroid/widget/TextView;

    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1, p1}, Landroid/content/res/Resources;->getText(I)Ljava/lang/CharSequence;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 208
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;->requestLayout()V

    .line 209
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;->getViewTreeObserver()Landroid/view/ViewTreeObserver;

    move-result-object v0

    new-instance v1, Lcom/xfinity/playerlib/view/widget/DownloadProgressBar$1;

    invoke-direct {v1, p0}, Lcom/xfinity/playerlib/view/widget/DownloadProgressBar$1;-><init>(Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;)V

    invoke-virtual {v0, v1}, Landroid/view/ViewTreeObserver;->addOnGlobalLayoutListener(Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;)V

    .line 234
    return-void
.end method


# virtual methods
.method public setButtonsEnable(Z)V
    .locals 1
    .param p1, "enabled"    # Z

    .prologue
    .line 92
    iget-object v0, p0, Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;->cancelDownloadBtn:Landroid/widget/ImageButton;

    invoke-virtual {v0, p1}, Landroid/widget/ImageButton;->setEnabled(Z)V

    .line 94
    iget-boolean v0, p0, Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;->showHotwireButton:Z

    if-eqz v0, :cond_0

    .line 95
    iget-object v0, p0, Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;->hotwireDownloadBtn:Landroid/widget/ImageButton;

    invoke-virtual {v0, p1}, Landroid/widget/ImageButton;->setEnabled(Z)V

    .line 96
    iget-object v0, p0, Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;->retryDownloadBtn:Landroid/widget/ImageButton;

    invoke-virtual {v0, p1}, Landroid/widget/ImageButton;->setEnabled(Z)V

    .line 98
    :cond_0
    return-void
.end method

.method public setOnCancelListener(Landroid/view/View$OnClickListener;)V
    .locals 1
    .param p1, "onClickListener"    # Landroid/view/View$OnClickListener;

    .prologue
    .line 80
    iget-object v0, p0, Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;->cancelDownloadBtn:Landroid/widget/ImageButton;

    invoke-virtual {v0, p1}, Landroid/widget/ImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 81
    return-void
.end method

.method public setOnHotwireDownloadClickListener(Landroid/view/View$OnClickListener;)V
    .locals 1
    .param p1, "onClickListener"    # Landroid/view/View$OnClickListener;

    .prologue
    .line 84
    iget-object v0, p0, Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;->hotwireDownloadBtn:Landroid/widget/ImageButton;

    invoke-virtual {v0, p1}, Landroid/widget/ImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 85
    return-void
.end method

.method public setOnRetryDownloadClickListener(Landroid/view/View$OnClickListener;)V
    .locals 1
    .param p1, "onClickListener"    # Landroid/view/View$OnClickListener;

    .prologue
    .line 88
    iget-object v0, p0, Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;->retryDownloadBtn:Landroid/widget/ImageButton;

    invoke-virtual {v0, p1}, Landroid/widget/ImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 89
    return-void
.end method

.method public setProgress(Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;)V
    .locals 11
    .param p1, "file"    # Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;
    .param p2, "downloadManager"    # Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;
    .param p3, "internetConnection"    # Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;

    .prologue
    .line 102
    const/4 v2, 0x0

    .line 104
    .local v2, "isDownloading":Z
    iget-object v5, p0, Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;->downloadSizeText:Landroid/widget/TextView;

    sget-object v6, Ljava/util/Locale;->US:Ljava/util/Locale;

    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;->getContext()Landroid/content/Context;

    move-result-object v7

    invoke-virtual {v7}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v7

    sget v8, Lcom/xfinity/playerlib/R$string;->download_MB_text:I

    invoke-virtual {v7, v8}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v7

    const/4 v8, 0x1

    new-array v8, v8, [Ljava/lang/Object;

    const/4 v9, 0x0

    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;->getExpectedFileSizeInMb()I

    move-result v10

    invoke-static {v10}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v10

    aput-object v10, v8, v9

    invoke-static {v6, v7, v8}, Ljava/lang/String;->format(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 105
    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;->getAsset()Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    move-result-object v5

    invoke-interface {v5}, Lcom/penthera/virtuososdk/client/IVirtuosoAsset;->downloadStatus()Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    move-result-object v4

    .line 106
    .local v4, "status":Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;
    sget-object v1, Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;->kVDE_Errors:Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    .line 108
    .local v1, "engineStatus":Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;
    :try_start_0
    invoke-virtual {p2}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;->getDownloadEngineStatus()Lcom/penthera/virtuososdk/client/IVirtuosoDownloadEngineStatus;

    move-result-object v5

    invoke-interface {v5}, Lcom/penthera/virtuososdk/client/IVirtuosoDownloadEngineStatus;->status()Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;
    :try_end_0
    .catch Lcom/comcast/cim/downloads/DownloadServiceException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    .line 113
    :goto_0
    sget-object v5, Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;->kVDE_Paused:Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    invoke-virtual {v1, v5}, Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_1

    .line 114
    sget v5, Lcom/xfinity/playerlib/R$string;->state_paused_text:I

    invoke-direct {p0, v5}, Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;->setProgressText(I)V

    .line 116
    iget-boolean v5, p0, Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;->showHotwireButton:Z

    if-eqz v5, :cond_0

    .line 117
    iget-object v5, p0, Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;->hotwireDownloadBtn:Landroid/widget/ImageButton;

    const/4 v6, 0x4

    invoke-virtual {v5, v6}, Landroid/widget/ImageButton;->setVisibility(I)V

    .line 118
    iget-object v5, p0, Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;->retryDownloadBtn:Landroid/widget/ImageButton;

    const/16 v6, 0x8

    invoke-virtual {v5, v6}, Landroid/widget/ImageButton;->setVisibility(I)V

    .line 121
    :cond_0
    iget-object v5, p0, Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;->cancelDownloadBtn:Landroid/widget/ImageButton;

    const/4 v6, 0x0

    invoke-virtual {v5, v6}, Landroid/widget/ImageButton;->setVisibility(I)V

    .line 191
    :goto_1
    if-eqz p1, :cond_f

    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;->getPercentComplete()I

    move-result v5

    const/4 v6, 0x1

    if-le v5, v6, :cond_f

    .line 192
    iget-object v5, p0, Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;->downloadProgressBar:Landroid/widget/ProgressBar;

    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;->getPercentComplete()I

    move-result v6

    invoke-virtual {v5, v6}, Landroid/widget/ProgressBar;->setProgress(I)V

    .line 198
    :goto_2
    iget-object v5, p0, Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;->downloadProgressBar:Landroid/widget/ProgressBar;

    invoke-virtual {v5, v2}, Landroid/widget/ProgressBar;->setEnabled(Z)V

    .line 201
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;->getContext()Landroid/content/Context;

    move-result-object v5

    sget v6, Lcom/xfinity/playerlib/R$string;->content_description_file_size_megabytes:I

    const/4 v7, 0x1

    new-array v7, v7, [Ljava/lang/Object;

    const/4 v8, 0x0

    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;->getExpectedFileSizeInMb()I

    move-result v9

    invoke-static {v9}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v9

    aput-object v9, v7, v8

    invoke-virtual {v5, v6, v7}, Landroid/content/Context;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    .line 203
    .local v3, "stateText":Ljava/lang/String;
    iget-object v5, p0, Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;->downloadProgressText:Landroid/widget/TextView;

    invoke-virtual {v5, v3}, Landroid/widget/TextView;->setContentDescription(Ljava/lang/CharSequence;)V

    .line 204
    return-void

    .line 109
    .end local v3    # "stateText":Ljava/lang/String;
    :catch_0
    move-exception v0

    .line 110
    .local v0, "e":Lcom/comcast/cim/downloads/DownloadServiceException;
    iget-object v5, p0, Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;->LOG:Lorg/slf4j/Logger;

    invoke-virtual {v0}, Lcom/comcast/cim/downloads/DownloadServiceException;->getMessage()Ljava/lang/String;

    move-result-object v6

    invoke-interface {v5, v6, v0}, Lorg/slf4j/Logger;->error(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0

    .line 122
    .end local v0    # "e":Lcom/comcast/cim/downloads/DownloadServiceException;
    :cond_1
    sget-object v5, Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;->kVDE_Blocked:Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    invoke-virtual {v1, v5}, Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-nez v5, :cond_2

    sget-object v5, Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;->kVDE_Errors:Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    invoke-virtual {v1, v5}, Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_8

    .line 123
    :cond_2
    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;->getAsset()Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    move-result-object v5

    invoke-interface {v5}, Lcom/penthera/virtuososdk/client/IVirtuosoAsset;->downloadStatus()Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    move-result-object v5

    sget-object v6, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->kVDE_Download_Pending:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    if-ne v5, v6, :cond_4

    .line 124
    sget v5, Lcom/xfinity/playerlib/R$string;->state_interrupted_text:I

    invoke-direct {p0, v5}, Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;->setProgressText(I)V

    .line 126
    iget-boolean v5, p0, Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;->showHotwireButton:Z

    if-eqz v5, :cond_3

    .line 127
    iget-object v5, p0, Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;->hotwireDownloadBtn:Landroid/widget/ImageButton;

    const/4 v6, 0x4

    invoke-virtual {v5, v6}, Landroid/widget/ImageButton;->setVisibility(I)V

    .line 128
    iget-object v5, p0, Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;->retryDownloadBtn:Landroid/widget/ImageButton;

    const/16 v6, 0x8

    invoke-virtual {v5, v6}, Landroid/widget/ImageButton;->setVisibility(I)V

    .line 130
    :cond_3
    iget-object v5, p0, Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;->cancelDownloadBtn:Landroid/widget/ImageButton;

    const/4 v6, 0x0

    invoke-virtual {v5, v6}, Landroid/widget/ImageButton;->setVisibility(I)V

    goto :goto_1

    .line 136
    :cond_4
    sget-object v5, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->kVDE_Download_File_Mime_Mismatch:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    if-eq v4, v5, :cond_5

    sget-object v5, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->kVDE_Download_File_Size_Mismatch:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    if-eq v4, v5, :cond_5

    sget-object v5, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->kVDE_Download_Reachability_Error:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    if-eq v4, v5, :cond_5

    sget-object v5, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->kVDE_Download_Network_Error:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    if-ne v4, v5, :cond_7

    .line 140
    invoke-virtual {p3}, Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;->isConnectedOnWiFi()Z

    move-result v5

    if-eqz v5, :cond_7

    .line 141
    :cond_5
    sget v5, Lcom/xfinity/playerlib/R$string;->state_error_text:I

    invoke-direct {p0, v5}, Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;->setProgressText(I)V

    .line 143
    iget-boolean v5, p0, Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;->showHotwireButton:Z

    if-eqz v5, :cond_6

    .line 144
    iget-object v5, p0, Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;->retryDownloadBtn:Landroid/widget/ImageButton;

    const/4 v6, 0x0

    invoke-virtual {v5, v6}, Landroid/widget/ImageButton;->setVisibility(I)V

    .line 145
    iget-object v5, p0, Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;->hotwireDownloadBtn:Landroid/widget/ImageButton;

    const/16 v6, 0x8

    invoke-virtual {v5, v6}, Landroid/widget/ImageButton;->setVisibility(I)V

    .line 155
    :cond_6
    :goto_3
    iget-object v5, p0, Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;->cancelDownloadBtn:Landroid/widget/ImageButton;

    const/4 v6, 0x0

    invoke-virtual {v5, v6}, Landroid/widget/ImageButton;->setVisibility(I)V

    goto/16 :goto_1

    .line 148
    :cond_7
    sget v5, Lcom/xfinity/playerlib/R$string;->state_interrupted_text:I

    invoke-direct {p0, v5}, Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;->setProgressText(I)V

    .line 150
    iget-boolean v5, p0, Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;->showHotwireButton:Z

    if-eqz v5, :cond_6

    .line 151
    iget-object v5, p0, Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;->hotwireDownloadBtn:Landroid/widget/ImageButton;

    const/4 v6, 0x4

    invoke-virtual {v5, v6}, Landroid/widget/ImageButton;->setVisibility(I)V

    .line 152
    iget-object v5, p0, Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;->retryDownloadBtn:Landroid/widget/ImageButton;

    const/16 v6, 0x8

    invoke-virtual {v5, v6}, Landroid/widget/ImageButton;->setVisibility(I)V

    goto :goto_3

    .line 158
    :cond_8
    sget-object v5, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->kVDE_Downloading:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    if-ne v4, v5, :cond_a

    .line 159
    sget v5, Lcom/xfinity/playerlib/R$string;->state_downloading_text:I

    invoke-direct {p0, v5}, Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;->setProgressText(I)V

    .line 161
    iget-boolean v5, p0, Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;->showHotwireButton:Z

    if-eqz v5, :cond_9

    .line 162
    iget-object v5, p0, Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;->hotwireDownloadBtn:Landroid/widget/ImageButton;

    const/4 v6, 0x4

    invoke-virtual {v5, v6}, Landroid/widget/ImageButton;->setVisibility(I)V

    .line 163
    iget-object v5, p0, Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;->retryDownloadBtn:Landroid/widget/ImageButton;

    const/16 v6, 0x8

    invoke-virtual {v5, v6}, Landroid/widget/ImageButton;->setVisibility(I)V

    .line 165
    :cond_9
    iget-object v5, p0, Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;->cancelDownloadBtn:Landroid/widget/ImageButton;

    const/4 v6, 0x0

    invoke-virtual {v5, v6}, Landroid/widget/ImageButton;->setVisibility(I)V

    .line 166
    const/4 v2, 0x1

    goto/16 :goto_1

    .line 167
    :cond_a
    sget-object v5, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->kVDE_Download_Pending:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    if-eq v4, v5, :cond_b

    sget-object v5, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->kVDE_Download_File_Mime_Mismatch:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    if-eq v4, v5, :cond_b

    sget-object v5, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->kVDE_Download_File_Size_Mismatch:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    if-ne v4, v5, :cond_d

    .line 172
    :cond_b
    sget v5, Lcom/xfinity/playerlib/R$string;->state_waiting_text:I

    invoke-direct {p0, v5}, Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;->setProgressText(I)V

    .line 174
    iget-boolean v5, p0, Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;->showHotwireButton:Z

    if-eqz v5, :cond_c

    .line 175
    iget-object v5, p0, Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;->hotwireDownloadBtn:Landroid/widget/ImageButton;

    const/4 v6, 0x0

    invoke-virtual {v5, v6}, Landroid/widget/ImageButton;->setVisibility(I)V

    .line 176
    iget-object v5, p0, Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;->retryDownloadBtn:Landroid/widget/ImageButton;

    const/16 v6, 0x8

    invoke-virtual {v5, v6}, Landroid/widget/ImageButton;->setVisibility(I)V

    .line 179
    :cond_c
    iget-object v5, p0, Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;->cancelDownloadBtn:Landroid/widget/ImageButton;

    const/4 v6, 0x0

    invoke-virtual {v5, v6}, Landroid/widget/ImageButton;->setVisibility(I)V

    goto/16 :goto_1

    .line 181
    :cond_d
    sget v5, Lcom/xfinity/playerlib/R$string;->state_interrupted_text:I

    invoke-direct {p0, v5}, Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;->setProgressText(I)V

    .line 182
    iget-boolean v5, p0, Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;->showHotwireButton:Z

    if-eqz v5, :cond_e

    .line 183
    iget-object v5, p0, Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;->hotwireDownloadBtn:Landroid/widget/ImageButton;

    const/4 v6, 0x4

    invoke-virtual {v5, v6}, Landroid/widget/ImageButton;->setVisibility(I)V

    .line 184
    iget-object v5, p0, Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;->retryDownloadBtn:Landroid/widget/ImageButton;

    const/16 v6, 0x8

    invoke-virtual {v5, v6}, Landroid/widget/ImageButton;->setVisibility(I)V

    .line 187
    :cond_e
    iget-object v5, p0, Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;->cancelDownloadBtn:Landroid/widget/ImageButton;

    const/4 v6, 0x0

    invoke-virtual {v5, v6}, Landroid/widget/ImageButton;->setVisibility(I)V

    goto/16 :goto_1

    .line 195
    :cond_f
    iget-object v6, p0, Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;->downloadProgressBar:Landroid/widget/ProgressBar;

    if-eqz v2, :cond_10

    const/4 v5, 0x1

    :goto_4
    invoke-virtual {v6, v5}, Landroid/widget/ProgressBar;->setProgress(I)V

    goto/16 :goto_2

    :cond_10
    const/4 v5, 0x0

    goto :goto_4
.end method
