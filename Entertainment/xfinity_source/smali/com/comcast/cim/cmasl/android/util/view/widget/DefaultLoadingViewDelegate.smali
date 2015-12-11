.class public Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;
.super Ljava/lang/Object;
.source "DefaultLoadingViewDelegate.java"

# interfaces
.implements Lcom/comcast/cim/cmasl/android/util/view/widget/LoadingViewDelegate;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate$NetworkReceiver;,
        Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate$ReadyListener;
    }
.end annotation


# static fields
.field private static final LOG:Lorg/slf4j/Logger;


# instance fields
.field private activity:Landroid/app/Activity;

.field private final bodyContainer:Landroid/view/ViewGroup;

.field protected firstTimeLoadStarted:Z

.field private final internetConnection:Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;

.field private final loadingIndicator:Lcom/comcast/cim/cmasl/android/util/view/widget/LoadingIndicator;

.field protected loadingInfoText:Landroid/widget/TextView;

.field protected loadingProgressBar:Landroid/widget/ProgressBar;

.field protected loadingRetryButton:Landroid/widget/Button;

.field protected networkReceiver:Landroid/content/BroadcastReceiver;

.field private readyListener:Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate$ReadyListener;

.field protected receiverRegistered:Z

.field protected resourcesLoaded:Z


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 26
    const-class v0, Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    sput-object v0, Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;->LOG:Lorg/slf4j/Logger;

    return-void
.end method

.method public constructor <init>(Landroid/app/Activity;Landroid/view/ViewGroup;Lcom/comcast/cim/cmasl/android/util/view/widget/LoadingIndicator;Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate$ReadyListener;)V
    .locals 1
    .param p1, "activity"    # Landroid/app/Activity;
    .param p2, "bodyContainer"    # Landroid/view/ViewGroup;
    .param p3, "loadingIndicator"    # Lcom/comcast/cim/cmasl/android/util/view/widget/LoadingIndicator;
    .param p4, "internetConnection"    # Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;
    .param p5, "readyListener"    # Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate$ReadyListener;

    .prologue
    .line 73
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 40
    new-instance v0, Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate$NetworkReceiver;

    invoke-direct {v0, p0}, Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate$NetworkReceiver;-><init>(Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;)V

    iput-object v0, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;->networkReceiver:Landroid/content/BroadcastReceiver;

    .line 74
    iput-object p1, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;->activity:Landroid/app/Activity;

    .line 75
    iput-object p3, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;->loadingIndicator:Lcom/comcast/cim/cmasl/android/util/view/widget/LoadingIndicator;

    .line 76
    iput-object p2, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;->bodyContainer:Landroid/view/ViewGroup;

    .line 77
    iput-object p5, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;->readyListener:Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate$ReadyListener;

    .line 78
    iput-object p4, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;->internetConnection:Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;

    .line 80
    invoke-virtual {p0}, Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;->setup()V

    .line 81
    return-void
.end method

.method static synthetic access$000()Lorg/slf4j/Logger;
    .locals 1

    .prologue
    .line 25
    sget-object v0, Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;->LOG:Lorg/slf4j/Logger;

    return-object v0
.end method


# virtual methods
.method public firstTimeLoadStarted()Z
    .locals 1

    .prologue
    .line 171
    iget-boolean v0, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;->firstTimeLoadStarted:Z

    return v0
.end method

.method public onLoadingFailed()V
    .locals 1

    .prologue
    .line 149
    sget v0, Lcom/comcast/cim/cmasl/android/util/R$string;->loading_exception:I

    invoke-virtual {p0, v0}, Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;->onLoadingFailed(I)V

    .line 150
    return-void
.end method

.method public onLoadingFailed(I)V
    .locals 4
    .param p1, "messageResId"    # I

    .prologue
    const/4 v3, 0x0

    .line 153
    iget-boolean v0, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;->resourcesLoaded:Z

    if-nez v0, :cond_0

    .line 154
    iget-object v0, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;->internetConnection:Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;

    invoke-virtual {v0}, Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;->isConnected()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 155
    iget-object v0, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;->loadingInfoText:Landroid/widget/TextView;

    iget-object v1, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;->activity:Landroid/app/Activity;

    invoke-virtual {v1}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1, p1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 156
    iget-object v0, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;->loadingInfoText:Landroid/widget/TextView;

    invoke-virtual {v0, v3}, Landroid/widget/TextView;->setVisibility(I)V

    .line 157
    iget-object v0, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;->loadingRetryButton:Landroid/widget/Button;

    invoke-virtual {v0, v3}, Landroid/widget/Button;->setVisibility(I)V

    .line 158
    iget-object v0, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;->loadingProgressBar:Landroid/widget/ProgressBar;

    const/4 v1, 0x4

    invoke-virtual {v0, v1}, Landroid/widget/ProgressBar;->setVisibility(I)V

    .line 164
    :cond_0
    :goto_0
    return-void

    .line 160
    :cond_1
    iget-object v0, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;->loadingInfoText:Landroid/widget/TextView;

    iget-object v1, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;->activity:Landroid/app/Activity;

    invoke-virtual {v1}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    sget v2, Lcom/comcast/cim/cmasl/android/util/R$string;->waiting_for_internet:I

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 161
    iget-object v0, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;->loadingInfoText:Landroid/widget/TextView;

    invoke-virtual {v0, v3}, Landroid/widget/TextView;->setVisibility(I)V

    goto :goto_0
.end method

.method public onLoadingFinished()V
    .locals 2

    .prologue
    .line 134
    iget-object v0, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;->loadingIndicator:Lcom/comcast/cim/cmasl/android/util/view/widget/LoadingIndicator;

    if-eqz v0, :cond_0

    .line 135
    iget-object v0, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;->loadingIndicator:Lcom/comcast/cim/cmasl/android/util/view/widget/LoadingIndicator;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Lcom/comcast/cim/cmasl/android/util/view/widget/LoadingIndicator;->setVisibility(I)V

    .line 136
    iget-object v0, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;->bodyContainer:Landroid/view/ViewGroup;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->setVisibility(I)V

    .line 139
    :cond_0
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;->resourcesLoaded:Z

    .line 140
    return-void
.end method

.method public onLoadingStarted()V
    .locals 2

    .prologue
    .line 127
    iget-object v0, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;->loadingIndicator:Lcom/comcast/cim/cmasl/android/util/view/widget/LoadingIndicator;

    if-eqz v0, :cond_0

    .line 128
    iget-object v0, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;->loadingIndicator:Lcom/comcast/cim/cmasl/android/util/view/widget/LoadingIndicator;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/comcast/cim/cmasl/android/util/view/widget/LoadingIndicator;->setVisibility(I)V

    .line 129
    iget-object v0, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;->bodyContainer:Landroid/view/ViewGroup;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->setVisibility(I)V

    .line 131
    :cond_0
    return-void
.end method

.method public onStart()V
    .locals 3

    .prologue
    .line 84
    new-instance v0, Landroid/content/IntentFilter;

    invoke-direct {v0}, Landroid/content/IntentFilter;-><init>()V

    .line 85
    .local v0, "filter":Landroid/content/IntentFilter;
    const-string v1, "android.net.conn.CONNECTIVITY_CHANGE"

    invoke-virtual {v0, v1}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 88
    iget-object v1, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;->activity:Landroid/app/Activity;

    iget-object v2, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;->networkReceiver:Landroid/content/BroadcastReceiver;

    invoke-virtual {v1, v2, v0}, Landroid/app/Activity;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 89
    const/4 v1, 0x1

    iput-boolean v1, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;->receiverRegistered:Z

    .line 90
    return-void
.end method

.method public onStop()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 93
    iput-boolean v2, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;->firstTimeLoadStarted:Z

    .line 95
    iget-boolean v0, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;->receiverRegistered:Z

    if-eqz v0, :cond_0

    .line 96
    iget-object v0, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;->activity:Landroid/app/Activity;

    iget-object v1, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;->networkReceiver:Landroid/content/BroadcastReceiver;

    invoke-virtual {v0, v1}, Landroid/app/Activity;->unregisterReceiver(Landroid/content/BroadcastReceiver;)V

    .line 97
    iput-boolean v2, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;->receiverRegistered:Z

    .line 99
    :cond_0
    return-void
.end method

.method public resourcesLoaded()Z
    .locals 1

    .prologue
    .line 167
    iget-boolean v0, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;->resourcesLoaded:Z

    return v0
.end method

.method public setNetworkReceiver(Landroid/content/BroadcastReceiver;)V
    .locals 0
    .param p1, "networkReceiver"    # Landroid/content/BroadcastReceiver;

    .prologue
    .line 175
    iput-object p1, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;->networkReceiver:Landroid/content/BroadcastReceiver;

    .line 176
    return-void
.end method

.method public setup()V
    .locals 2

    .prologue
    .line 112
    iget-object v0, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;->loadingIndicator:Lcom/comcast/cim/cmasl/android/util/view/widget/LoadingIndicator;

    sget v1, Lcom/comcast/cim/cmasl/android/util/R$id;->loading_info_text:I

    invoke-virtual {v0, v1}, Lcom/comcast/cim/cmasl/android/util/view/widget/LoadingIndicator;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;->loadingInfoText:Landroid/widget/TextView;

    .line 113
    iget-object v0, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;->loadingIndicator:Lcom/comcast/cim/cmasl/android/util/view/widget/LoadingIndicator;

    sget v1, Lcom/comcast/cim/cmasl/android/util/R$id;->loading_retry_button:I

    invoke-virtual {v0, v1}, Lcom/comcast/cim/cmasl/android/util/view/widget/LoadingIndicator;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    iput-object v0, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;->loadingRetryButton:Landroid/widget/Button;

    .line 114
    iget-object v0, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;->loadingRetryButton:Landroid/widget/Button;

    new-instance v1, Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate$1;

    invoke-direct {v1, p0}, Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate$1;-><init>(Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;)V

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 123
    iget-object v0, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;->loadingIndicator:Lcom/comcast/cim/cmasl/android/util/view/widget/LoadingIndicator;

    sget v1, Lcom/comcast/cim/cmasl/android/util/R$id;->loading_progressbar:I

    invoke-virtual {v0, v1}, Lcom/comcast/cim/cmasl/android/util/view/widget/LoadingIndicator;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ProgressBar;

    iput-object v0, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;->loadingProgressBar:Landroid/widget/ProgressBar;

    .line 124
    return-void
.end method

.method public startLoading()V
    .locals 1

    .prologue
    .line 107
    invoke-virtual {p0}, Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;->onLoadingStarted()V

    .line 108
    iget-object v0, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;->readyListener:Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate$ReadyListener;

    invoke-interface {v0}, Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate$ReadyListener;->onReady()V

    .line 109
    return-void
.end method
