.class public Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState;
.super Ljava/lang/Object;
.source "ErrorState.java"

# interfaces
.implements Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;


# static fields
.field private static final LOG:Lorg/slf4j/Logger;


# instance fields
.field private final errorMessage:Ljava/lang/String;

.field private final errorThrowable:Ljava/lang/Throwable;

.field private final errorTitle:Ljava/lang/String;

.field private keyguardReciever:Landroid/content/BroadcastReceiver;

.field private final retryState:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;

.field private final shouldPresentUpsellDialog:Z

.field private shown:Z

.field private final stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 36
    const-class v0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    sput-object v0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState;->LOG:Lorg/slf4j/Logger;

    return-void
.end method

.method public constructor <init>(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;Ljava/lang/String;)V
    .locals 2
    .param p1, "stateController"    # Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;
    .param p2, "errorMessage"    # Ljava/lang/String;

    .prologue
    const/4 v1, 0x0

    const/4 v0, 0x0

    .line 78
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 44
    iput-boolean v1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState;->shown:Z

    .line 79
    iput-object p1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    .line 80
    iput-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState;->errorTitle:Ljava/lang/String;

    .line 81
    iput-object p2, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState;->errorMessage:Ljava/lang/String;

    .line 82
    iput-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState;->retryState:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;

    .line 83
    iput-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState;->errorThrowable:Ljava/lang/Throwable;

    .line 84
    iput-boolean v1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState;->shouldPresentUpsellDialog:Z

    .line 85
    return-void
.end method

.method public constructor <init>(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;Ljava/lang/String;Ljava/lang/String;)V
    .locals 2
    .param p1, "stateController"    # Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;
    .param p2, "errorTitle"    # Ljava/lang/String;
    .param p3, "errorMessage"    # Ljava/lang/String;

    .prologue
    const/4 v1, 0x0

    const/4 v0, 0x0

    .line 87
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 44
    iput-boolean v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState;->shown:Z

    .line 88
    iput-object p1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    .line 89
    iput-object p2, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState;->errorTitle:Ljava/lang/String;

    .line 90
    iput-object p3, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState;->errorMessage:Ljava/lang/String;

    .line 91
    iput-object v1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState;->retryState:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;

    .line 92
    iput-object v1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState;->errorThrowable:Ljava/lang/Throwable;

    .line 93
    iput-boolean v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState;->shouldPresentUpsellDialog:Z

    .line 94
    return-void
.end method

.method public constructor <init>(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;Ljava/lang/String;Ljava/lang/String;Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;)V
    .locals 2
    .param p1, "stateController"    # Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;
    .param p2, "errorTitle"    # Ljava/lang/String;
    .param p3, "errorMessage"    # Ljava/lang/String;
    .param p4, "retryState"    # Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;

    .prologue
    const/4 v1, 0x0

    .line 60
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 44
    iput-boolean v1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState;->shown:Z

    .line 61
    iput-object p1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    .line 62
    iput-object p2, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState;->errorTitle:Ljava/lang/String;

    .line 63
    iput-object p3, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState;->errorMessage:Ljava/lang/String;

    .line 64
    iput-object p4, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState;->retryState:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;

    .line 65
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState;->errorThrowable:Ljava/lang/Throwable;

    .line 66
    iput-boolean v1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState;->shouldPresentUpsellDialog:Z

    .line 67
    return-void
.end method

.method public constructor <init>(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;Ljava/lang/Throwable;Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;)V
    .locals 2
    .param p1, "stateController"    # Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;
    .param p2, "errorThrowable"    # Ljava/lang/Throwable;
    .param p3, "retryState"    # Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;

    .prologue
    const/4 v1, 0x0

    const/4 v0, 0x0

    .line 69
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 44
    iput-boolean v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState;->shown:Z

    .line 70
    iput-object p1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    .line 71
    iput-object v1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState;->errorTitle:Ljava/lang/String;

    .line 72
    iput-object v1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState;->errorMessage:Ljava/lang/String;

    .line 73
    iput-object p3, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState;->retryState:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;

    .line 74
    iput-object p2, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState;->errorThrowable:Ljava/lang/Throwable;

    .line 75
    iput-boolean v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState;->shouldPresentUpsellDialog:Z

    .line 76
    return-void
.end method

.method private constructor <init>(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;ZLjava/lang/Throwable;)V
    .locals 2
    .param p1, "stateController"    # Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;
    .param p2, "shouldPresentUpsellDialog"    # Z
    .param p3, "errorThrowable"    # Ljava/lang/Throwable;

    .prologue
    const/4 v1, 0x0

    .line 51
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 44
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState;->shown:Z

    .line 52
    iput-object p1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    .line 53
    iput-object v1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState;->errorTitle:Ljava/lang/String;

    .line 54
    iput-object v1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState;->errorMessage:Ljava/lang/String;

    .line 55
    iput-object v1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState;->retryState:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;

    .line 56
    iput-object p3, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState;->errorThrowable:Ljava/lang/Throwable;

    .line 57
    iput-boolean p2, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState;->shouldPresentUpsellDialog:Z

    .line 58
    return-void
.end method

.method static synthetic access$000(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState;)V
    .locals 0
    .param p0, "x0"    # Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState;

    .prologue
    .line 35
    invoke-direct {p0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState;->showError()V

    return-void
.end method

.method static synthetic access$100(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState;)V
    .locals 0
    .param p0, "x0"    # Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState;

    .prologue
    .line 35
    invoke-direct {p0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState;->unregisterKeyguardReceiver()V

    return-void
.end method

.method static synthetic access$200(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState;)Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState;

    .prologue
    .line 35
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    return-object v0
.end method

.method static synthetic access$300(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState;)Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState;

    .prologue
    .line 35
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState;->retryState:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;

    return-object v0
.end method

.method private addCancelListener(Lcom/comcast/cim/android/view/common/CALDialogFragment;)V
    .locals 1
    .param p1, "errorDialog"    # Lcom/comcast/cim/android/view/common/CALDialogFragment;

    .prologue
    .line 569
    new-instance v0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState$5;

    invoke-direct {v0, p0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState$5;-><init>(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState;)V

    invoke-virtual {p1, v0}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->setOnCancelListener(Landroid/content/DialogInterface$OnCancelListener;)V

    .line 575
    return-void
.end method

.method public static newUpsellErrorState(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;Ljava/lang/Exception;)Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState;
    .locals 2
    .param p0, "stateController"    # Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;
    .param p1, "errorThrowable"    # Ljava/lang/Exception;

    .prologue
    .line 48
    new-instance v0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState;

    const/4 v1, 0x1

    invoke-direct {v0, p0, v1, p1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState;-><init>(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;ZLjava/lang/Throwable;)V

    return-object v0
.end method

.method private showError()V
    .locals 8

    .prologue
    .line 509
    iget-object v5, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v5}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getActivityContext()Landroid/app/Activity;

    move-result-object v0

    .line 511
    .local v0, "activity":Landroid/app/Activity;
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 513
    .local v1, "args":Landroid/os/Bundle;
    iget-boolean v5, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState;->shouldPresentUpsellDialog:Z

    if-eqz v5, :cond_0

    .line 514
    sget-object v5, Lcom/xfinity/playerlib/view/common/UpsellDialog$UpsellType;->PLAY_FROM_PLAYER:Lcom/xfinity/playerlib/view/common/UpsellDialog$UpsellType;

    iget-object v6, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v6}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getVideoFacade()Lcom/xfinity/playerlib/model/consumable/VideoFacade;

    move-result-object v6

    iget-object v7, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState;->errorThrowable:Ljava/lang/Throwable;

    invoke-static {v5, v6, v7}, Lcom/xfinity/playerlib/view/common/UpsellDialog;->newInstance(Lcom/xfinity/playerlib/view/common/UpsellDialog$UpsellType;Lcom/xfinity/playerlib/model/consumable/VideoFacade;Ljava/lang/Throwable;)Lcom/xfinity/playerlib/view/common/UpsellDialog;

    move-result-object v2

    .line 515
    .local v2, "errorDialog":Lcom/comcast/cim/android/view/common/CALDialogFragment;
    new-instance v5, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState$2;

    invoke-direct {v5, p0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState$2;-><init>(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState;)V

    invoke-virtual {v2, v5}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->setOnDismissListener(Landroid/content/DialogInterface$OnDismissListener;)V

    .line 552
    :goto_0
    :try_start_0
    invoke-virtual {v0}, Landroid/app/Activity;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v5

    const-string v6, "caldialogfragment"

    invoke-virtual {v2, v5, v6}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->show(Landroid/app/FragmentManager;Ljava/lang/String;)V

    .line 553
    const/4 v5, 0x1

    iput-boolean v5, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState;->shown:Z
    :try_end_0
    .catch Ljava/lang/IllegalStateException; {:try_start_0 .. :try_end_0} :catch_0

    .line 559
    :goto_1
    return-void

    .line 521
    .end local v2    # "errorDialog":Lcom/comcast/cim/android/view/common/CALDialogFragment;
    :cond_0
    iget-object v5, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState;->errorThrowable:Ljava/lang/Throwable;

    if-nez v5, :cond_3

    .line 522
    iget-object v5, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState;->retryState:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;

    if-eqz v5, :cond_2

    .line 523
    const-string v5, "errorDlgRetryable"

    invoke-static {v5}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->newInstance(Ljava/lang/String;)Lcom/comcast/cim/android/view/common/CALDialogFragment;

    move-result-object v2

    .line 524
    .restart local v2    # "errorDialog":Lcom/comcast/cim/android/view/common/CALDialogFragment;
    new-instance v5, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState$3;

    invoke-direct {v5, p0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState$3;-><init>(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState;)V

    invoke-virtual {v2, v5}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->setTryAgainListener(Lcom/comcast/cim/android/view/common/CALDialogFragment$TryAgainListener;)V

    .line 533
    :goto_2
    const-string v5, "description"

    iget-object v6, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState;->errorMessage:Ljava/lang/String;

    invoke-virtual {v1, v5, v6}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 534
    iget-object v5, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState;->errorTitle:Ljava/lang/String;

    if-eqz v5, :cond_1

    .line 535
    const-string v5, "title"

    iget-object v6, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState;->errorTitle:Ljava/lang/String;

    invoke-virtual {v1, v5, v6}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 537
    :cond_1
    invoke-virtual {v2, v1}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->addArguments(Landroid/os/Bundle;)V

    .line 538
    invoke-direct {p0, v2}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState;->addCancelListener(Lcom/comcast/cim/android/view/common/CALDialogFragment;)V

    goto :goto_0

    .line 531
    .end local v2    # "errorDialog":Lcom/comcast/cim/android/view/common/CALDialogFragment;
    :cond_2
    const-string v5, "errorDlg"

    invoke-static {v5}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->newInstance(Ljava/lang/String;)Lcom/comcast/cim/android/view/common/CALDialogFragment;

    move-result-object v2

    .restart local v2    # "errorDialog":Lcom/comcast/cim/android/view/common/CALDialogFragment;
    goto :goto_2

    .line 540
    .end local v2    # "errorDialog":Lcom/comcast/cim/android/view/common/CALDialogFragment;
    :cond_3
    iget-object v5, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v5}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getErrorDialogFactory()Lcom/comcast/cim/android/view/common/ErrorDialogFactory;

    move-result-object v3

    .line 541
    .local v3, "errorDialogFactory":Lcom/comcast/cim/android/view/common/ErrorDialogFactory;
    iget-object v5, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    iget-object v6, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState;->errorThrowable:Ljava/lang/Throwable;

    invoke-virtual {v5, v6}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->formatError(Ljava/lang/Throwable;)Lcom/comcast/cim/android/view/common/errorformatter/FormattedError;

    move-result-object v4

    .line 542
    .local v4, "formattedError":Lcom/comcast/cim/android/view/common/errorformatter/FormattedError;
    iget-object v5, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState;->errorThrowable:Ljava/lang/Throwable;

    new-instance v6, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState$4;

    invoke-direct {v6, p0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState$4;-><init>(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState;)V

    invoke-virtual {v3, v5, v4, v6}, Lcom/comcast/cim/android/view/common/ErrorDialogFactory;->createErrorDialogForThrowable(Ljava/lang/Throwable;Lcom/comcast/cim/android/view/common/errorformatter/FormattedError;Lcom/comcast/cim/android/view/common/CALDialogFragment$TryAgainListener;)Lcom/comcast/cim/android/view/common/CALDialogFragment;

    move-result-object v2

    .line 548
    .restart local v2    # "errorDialog":Lcom/comcast/cim/android/view/common/CALDialogFragment;
    invoke-direct {p0, v2}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState;->addCancelListener(Lcom/comcast/cim/android/view/common/CALDialogFragment;)V

    goto :goto_0

    .line 554
    .end local v3    # "errorDialogFactory":Lcom/comcast/cim/android/view/common/ErrorDialogFactory;
    .end local v4    # "formattedError":Lcom/comcast/cim/android/view/common/errorformatter/FormattedError;
    :catch_0
    move-exception v5

    goto :goto_1
.end method

.method private declared-synchronized unregisterKeyguardReceiver()V
    .locals 2

    .prologue
    .line 562
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState;->keyguardReciever:Landroid/content/BroadcastReceiver;

    if-eqz v0, :cond_0

    .line 563
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getActivityContext()Landroid/app/Activity;

    move-result-object v0

    iget-object v1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState;->keyguardReciever:Landroid/content/BroadcastReceiver;

    invoke-virtual {v0, v1}, Landroid/app/Activity;->unregisterReceiver(Landroid/content/BroadcastReceiver;)V

    .line 564
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState;->keyguardReciever:Landroid/content/BroadcastReceiver;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 566
    :cond_0
    monitor-exit p0

    return-void

    .line 562
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method


# virtual methods
.method public adBreakComplete(Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;)V
    .locals 0
    .param p1, "adBreak"    # Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;

    .prologue
    .line 419
    return-void
.end method

.method public adBreakStart(Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;)V
    .locals 0
    .param p1, "adBreak"    # Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;
    .param p2, "ad"    # Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;

    .prologue
    .line 414
    return-void
.end method

.method public adComplete(J)V
    .locals 0
    .param p1, "id"    # J

    .prologue
    .line 434
    return-void
.end method

.method public adProgress(Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;IJ)V
    .locals 0
    .param p1, "adBreak"    # Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;
    .param p2, "ad"    # Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;
    .param p3, "progress"    # I
    .param p4, "timeRemaining"    # J

    .prologue
    .line 429
    return-void
.end method

.method public adStart(Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;)V
    .locals 0
    .param p1, "ad"    # Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;

    .prologue
    .line 424
    return-void
.end method

.method public emergencyAlertCompleted(Ljava/lang/String;)V
    .locals 0
    .param p1, "identifier"    # Ljava/lang/String;

    .prologue
    .line 329
    return-void
.end method

.method public emergencyAlertFailed(Ljava/lang/String;)V
    .locals 0
    .param p1, "message"    # Ljava/lang/String;

    .prologue
    .line 339
    return-void
.end method

.method public emergencyAlertStarted(Ljava/lang/String;)V
    .locals 0
    .param p1, "identifier"    # Ljava/lang/String;

    .prologue
    .line 334
    return-void
.end method

.method public getStateName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 112
    const-string v0, "ErrorState"

    return-object v0
.end method

.method public onAMSContinueException(Ljava/lang/Exception;)V
    .locals 0
    .param p1, "e"    # Ljava/lang/Exception;

    .prologue
    .line 506
    return-void
.end method

.method public onAcquiringLicense(Ljava/lang/String;)V
    .locals 0
    .param p1, "manifestUri"    # Ljava/lang/String;

    .prologue
    .line 404
    return-void
.end method

.method public onActivityPaused()V
    .locals 0

    .prologue
    .line 469
    return-void
.end method

.method public onActivityResumed()V
    .locals 5

    .prologue
    .line 473
    iget-boolean v1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState;->shown:Z

    if-nez v1, :cond_0

    .line 474
    iget-object v1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getActivityContext()Landroid/app/Activity;

    move-result-object v1

    const-string v2, "keyguard"

    invoke-virtual {v1, v2}, Landroid/app/Activity;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/app/KeyguardManager;

    .line 475
    .local v0, "keyguardManager":Landroid/app/KeyguardManager;
    invoke-virtual {v0}, Landroid/app/KeyguardManager;->inKeyguardRestrictedInputMode()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 477
    invoke-direct {p0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState;->unregisterKeyguardReceiver()V

    .line 479
    new-instance v1, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState$1;

    invoke-direct {v1, p0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState$1;-><init>(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState;)V

    iput-object v1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState;->keyguardReciever:Landroid/content/BroadcastReceiver;

    .line 491
    iget-object v1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getActivityContext()Landroid/app/Activity;

    move-result-object v1

    iget-object v2, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState;->keyguardReciever:Landroid/content/BroadcastReceiver;

    new-instance v3, Landroid/content/IntentFilter;

    const-string v4, "android.intent.action.USER_PRESENT"

    invoke-direct {v3, v4}, Landroid/content/IntentFilter;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, v2, v3}, Landroid/app/Activity;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 496
    .end local v0    # "keyguardManager":Landroid/app/KeyguardManager;
    :cond_0
    :goto_0
    return-void

    .line 493
    .restart local v0    # "keyguardManager":Landroid/app/KeyguardManager;
    :cond_1
    invoke-direct {p0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState;->showError()V

    goto :goto_0
.end method

.method public onAmsAuthenticationException(Ljava/lang/Exception;)V
    .locals 0
    .param p1, "e"    # Ljava/lang/Exception;

    .prologue
    .line 264
    return-void
.end method

.method public onAmsAuthenticationSuccess()V
    .locals 0

    .prologue
    .line 269
    return-void
.end method

.method public onAmsPinRequired()V
    .locals 0

    .prologue
    .line 259
    return-void
.end method

.method public onBabyGuideButton()V
    .locals 0

    .prologue
    .line 139
    return-void
.end method

.method public onBackButton()V
    .locals 0

    .prologue
    .line 189
    return-void
.end method

.method public onBitrateChanged(JLjava/lang/String;II)V
    .locals 0
    .param p1, "bitrate"    # J
    .param p3, "changeReason"    # Ljava/lang/String;
    .param p4, "videoHeight"    # I
    .param p5, "videoWidth"    # I

    .prologue
    .line 294
    return-void
.end method

.method public onBufferComplete()V
    .locals 0

    .prologue
    .line 304
    return-void
.end method

.method public onBufferStart()V
    .locals 0

    .prologue
    .line 299
    return-void
.end method

.method public onCCButton()V
    .locals 0

    .prologue
    .line 129
    return-void
.end method

.method public onConfigurationLoaded()V
    .locals 0

    .prologue
    .line 234
    return-void
.end method

.method public onConnectivityChanged()V
    .locals 0

    .prologue
    .line 449
    return-void
.end method

.method public onDrmComplete(Ljava/lang/String;Ljava/util/Date;Ljava/util/Date;)V
    .locals 0
    .param p1, "manifestUri"    # Ljava/lang/String;
    .param p2, "licenseStart"    # Ljava/util/Date;
    .param p3, "licenseEnd"    # Ljava/util/Date;

    .prologue
    .line 409
    return-void
.end method

.method public onDrmMetaDataAvailable(Lcom/adobe/ave/drm/DRMManager;Lcom/adobe/ave/drm/DRMMetadata;)V
    .locals 0
    .param p1, "drmManager"    # Lcom/adobe/ave/drm/DRMManager;
    .param p2, "drmMetadata"    # Lcom/adobe/ave/drm/DRMMetadata;

    .prologue
    .line 389
    return-void
.end method

.method public onDroppedFPSChanged(J)V
    .locals 0
    .param p1, "droppedFPS"    # J

    .prologue
    .line 319
    return-void
.end method

.method public onDurationChanged(J)V
    .locals 0
    .param p1, "duration"    # J

    .prologue
    .line 324
    return-void
.end method

.method public onFavoriteItemDetailSelected(Lcom/xfinity/playerlib/model/VideoFavorite;)V
    .locals 0
    .param p1, "favorite"    # Lcom/xfinity/playerlib/model/VideoFavorite;

    .prologue
    .line 184
    return-void
.end method

.method public onFavoritesButton()V
    .locals 0

    .prologue
    .line 149
    return-void
.end method

.method public onFpsChanged(J)V
    .locals 0
    .param p1, "FPS"    # J

    .prologue
    .line 344
    return-void
.end method

.method public onFragmentDestroyed()V
    .locals 3

    .prologue
    .line 500
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    new-instance v1, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/DestroyedState;

    iget-object v2, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-direct {v1, v2}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/DestroyedState;-><init>(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;)V

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->transitionToState(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;)V

    .line 501
    return-void
.end method

.method public onHeadsetButtonEvent(I)V
    .locals 0
    .param p1, "keyEventCode"    # I

    .prologue
    .line 459
    return-void
.end method

.method public onHeadsetNoiseDetected()V
    .locals 0

    .prologue
    .line 464
    return-void
.end method

.method public onHistoryButton()V
    .locals 0

    .prologue
    .line 144
    return-void
.end method

.method public onHistoryItemDetailSelected(Lcom/xfinity/playerlib/bookmarks/VideoBookmark;)V
    .locals 0
    .param p1, "bookmark"    # Lcom/xfinity/playerlib/bookmarks/VideoBookmark;

    .prologue
    .line 179
    return-void
.end method

.method public onLiveStreamFetched(Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;)V
    .locals 0
    .param p1, "liveStream"    # Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;

    .prologue
    .line 254
    return-void
.end method

.method public onLiveStreamPlaySelected(Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;)V
    .locals 0
    .param p1, "liveStream"    # Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;

    .prologue
    .line 164
    return-void
.end method

.method public onLiveStreamPlaySelected(Ljava/lang/String;)V
    .locals 0
    .param p1, "streamId"    # Ljava/lang/String;

    .prologue
    .line 169
    return-void
.end method

.method public onMediaEnded()V
    .locals 0

    .prologue
    .line 349
    return-void
.end method

.method public onMediaFailed(Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "code"    # Ljava/lang/String;
    .param p2, "description"    # Ljava/lang/String;

    .prologue
    .line 354
    return-void
.end method

.method public onMediaOpened(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;JJDZ)V
    .locals 0
    .param p1, "type"    # Ljava/lang/String;
    .param p2, "mediaType"    # Ljava/lang/String;
    .param p3, "playbackSpeeds"    # Ljava/util/List;
    .param p4, "availableAudioLanguages"    # Ljava/util/List;
    .param p5, "width"    # J
    .param p7, "height"    # J
    .param p9, "openingLatency"    # D
    .param p11, "hasCC"    # Z

    .prologue
    .line 359
    return-void
.end method

.method public onMediaProgress(JDJJI)V
    .locals 0
    .param p1, "position"    # J
    .param p3, "playbackSpeed"    # D
    .param p5, "startPosition"    # J
    .param p7, "endPosition"    # J
    .param p9, "updateInterval"    # I

    .prologue
    .line 364
    return-void
.end method

.method public onMediaWarning(Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "code"    # Ljava/lang/String;
    .param p2, "description"    # Ljava/lang/String;

    .prologue
    .line 369
    return-void
.end method

.method public onNewVideoPlayOrResumeSelected(Lcom/xfinity/playerlib/bookmarks/VideoBookmark;)V
    .locals 0
    .param p1, "bookmark"    # Lcom/xfinity/playerlib/bookmarks/VideoBookmark;

    .prologue
    .line 159
    return-void
.end method

.method public onNewVideoPlayOrResumeSelected(Lcom/xfinity/playerlib/model/consumable/VideoFacade;Lcom/xfinity/playerlib/model/consumable/Watchable;)V
    .locals 0
    .param p1, "video"    # Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    .param p2, "watchable"    # Lcom/xfinity/playerlib/model/consumable/Watchable;

    .prologue
    .line 154
    return-void
.end method

.method public onNumberOfAlternativeAudioStreamsChanged(I)V
    .locals 0
    .param p1, "numberOfAlternativeAudioStreams"    # I

    .prologue
    .line 374
    return-void
.end method

.method public onOfflineDRMComplete(Ljava/lang/String;Ljava/util/Date;Ljava/util/Date;Ljava/lang/String;)V
    .locals 0
    .param p1, "manifestUri"    # Ljava/lang/String;
    .param p2, "licenseStart"    # Ljava/util/Date;
    .param p3, "licenseEnd"    # Ljava/util/Date;
    .param p4, "policyId"    # Ljava/lang/String;

    .prologue
    .line 394
    return-void
.end method

.method public onOfflineDRMFailure(Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "code"    # Ljava/lang/String;
    .param p2, "description"    # Ljava/lang/String;

    .prologue
    .line 399
    return-void
.end method

.method public onPauseButton()V
    .locals 0

    .prologue
    .line 199
    return-void
.end method

.method public onPinCanceled()V
    .locals 0

    .prologue
    .line 289
    return-void
.end method

.method public onPlayButton()V
    .locals 0

    .prologue
    .line 194
    return-void
.end method

.method public onPlayStateChanged(Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;)V
    .locals 0
    .param p1, "status"    # Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    .prologue
    .line 384
    return-void
.end method

.method public onPlaybackSpeedChanged(D)V
    .locals 0
    .param p1, "speed"    # D

    .prologue
    .line 379
    return-void
.end method

.method public onPlayerSurfaceCreated(Landroid/view/SurfaceHolder;)V
    .locals 0
    .param p1, "surfaceHolder"    # Landroid/view/SurfaceHolder;

    .prologue
    .line 239
    return-void
.end method

.method public onSAPButton()V
    .locals 0

    .prologue
    .line 134
    return-void
.end method

.method public onScreenTouch()V
    .locals 0

    .prologue
    .line 124
    return-void
.end method

.method public onSeekRequest(J)V
    .locals 0
    .param p1, "position"    # J

    .prologue
    .line 204
    return-void
.end method

.method public onSeriesWatchableDetailSelected(Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;)V
    .locals 0
    .param p1, "seriesWatchable"    # Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;

    .prologue
    .line 174
    return-void
.end method

.method public onTimelineUpdated()V
    .locals 0

    .prologue
    .line 229
    return-void
.end method

.method public onUserMovedSeekBar(I)V
    .locals 0
    .param p1, "progress"    # I

    .prologue
    .line 219
    return-void
.end method

.method public onUserSeekEnded(Z)V
    .locals 0
    .param p1, "willSeek"    # Z

    .prologue
    .line 214
    return-void
.end method

.method public onUserSeekStarted()V
    .locals 0

    .prologue
    .line 209
    return-void
.end method

.method public onValidatePin(Ljava/lang/String;Lcom/comcast/cim/android/view/common/PinKeypadFragment$PinValidationCompletedListener;)V
    .locals 0
    .param p1, "pinInput"    # Ljava/lang/String;
    .param p2, "validationListener"    # Lcom/comcast/cim/android/view/common/PinKeypadFragment$PinValidationCompletedListener;

    .prologue
    .line 284
    return-void
.end method

.method public onVideoFetchFailed()V
    .locals 0

    .prologue
    .line 244
    return-void
.end method

.method public onVideoFetched(Lcom/xfinity/playerlib/model/consumable/VideoFacade;Lcom/xfinity/playerlib/model/consumable/Watchable;)V
    .locals 0
    .param p1, "video"    # Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    .param p2, "watchable"    # Lcom/xfinity/playerlib/model/consumable/Watchable;

    .prologue
    .line 249
    return-void
.end method

.method public onVideoSeekComplete()V
    .locals 0

    .prologue
    .line 314
    return-void
.end method

.method public onVideoSeekStart()V
    .locals 0

    .prologue
    .line 309
    return-void
.end method

.method public onVolumeChanged()V
    .locals 0

    .prologue
    .line 224
    return-void
.end method

.method public run()V
    .locals 0

    .prologue
    .line 118
    invoke-direct {p0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState;->showError()V

    .line 119
    return-void
.end method

.method public transitionToState(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;)V
    .locals 3
    .param p1, "state"    # Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;

    .prologue
    .line 99
    invoke-direct {p0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState;->unregisterKeyguardReceiver()V

    .line 101
    instance-of v0, p1, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/QuitState;

    if-nez v0, :cond_0

    instance-of v0, p1, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/DestroyedState;

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState;->retryState:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;

    .line 103
    invoke-virtual {v0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/Class;->isAssignableFrom(Ljava/lang/Class;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 104
    :cond_0
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0, p1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->setState(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;)V

    .line 108
    return-void

    .line 106
    :cond_1
    new-instance v0, Ljava/lang/IllegalStateException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Illegal State Change: From "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState;->getStateName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " to "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-interface {p1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;->getStateName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0
.end method
