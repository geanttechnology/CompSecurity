.class public Lcom/comcast/cim/utils/UIUtil;
.super Ljava/lang/Object;
.source "UIUtil.java"


# static fields
.field private static final TAG:Ljava/lang/String;


# instance fields
.field private final internetConnection:Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 19
    const-class v0, Lcom/comcast/cim/utils/UIUtil;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/comcast/cim/utils/UIUtil;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;)V
    .locals 0
    .param p1, "internetConnection"    # Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;

    .prologue
    .line 23
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 24
    iput-object p1, p0, Lcom/comcast/cim/utils/UIUtil;->internetConnection:Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;

    .line 25
    return-void
.end method


# virtual methods
.method public ensureConnectivityBeforeExecuting(Landroid/content/Context;Ljava/lang/Runnable;)V
    .locals 5
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "runnable"    # Ljava/lang/Runnable;

    .prologue
    .line 64
    invoke-static {p1}, Lorg/apache/commons/lang3/Validate;->notNull(Ljava/lang/Object;)Ljava/lang/Object;

    .line 65
    invoke-static {p2}, Lorg/apache/commons/lang3/Validate;->notNull(Ljava/lang/Object;)Ljava/lang/Object;

    .line 67
    iget-object v2, p0, Lcom/comcast/cim/utils/UIUtil;->internetConnection:Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;

    invoke-virtual {v2}, Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;->isConnected()Z

    move-result v2

    if-nez v2, :cond_0

    .line 69
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 70
    .local v0, "args":Landroid/os/Bundle;
    const-string v2, "description"

    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    sget v4, Lcom/comcast/cim/android/R$string;->ALERT_INTERNET_UNREACHABLE:I

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 72
    const-string v2, "errorDlgRetryable"

    invoke-static {v2}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->newInstance(Ljava/lang/String;)Lcom/comcast/cim/android/view/common/CALDialogFragment;

    move-result-object v1

    .line 73
    .local v1, "dialog":Lcom/comcast/cim/android/view/common/CALDialogFragment;
    new-instance v2, Lcom/comcast/cim/utils/UIUtil$1;

    invoke-direct {v2, p0, p1, p2}, Lcom/comcast/cim/utils/UIUtil$1;-><init>(Lcom/comcast/cim/utils/UIUtil;Landroid/content/Context;Ljava/lang/Runnable;)V

    invoke-virtual {v1, v2}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->setTryAgainListener(Lcom/comcast/cim/android/view/common/CALDialogFragment$TryAgainListener;)V

    .line 80
    invoke-virtual {v1, v0}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->addArguments(Landroid/os/Bundle;)V

    .line 81
    check-cast p1, Landroid/app/Activity;

    .end local p1    # "context":Landroid/content/Context;
    invoke-virtual {p1}, Landroid/app/Activity;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v2

    const-string v3, "caldialogfragment"

    invoke-virtual {v1, v2, v3}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->show(Landroid/app/FragmentManager;Ljava/lang/String;)V

    .line 85
    .end local v0    # "args":Landroid/os/Bundle;
    .end local v1    # "dialog":Lcom/comcast/cim/android/view/common/CALDialogFragment;
    :goto_0
    return-void

    .line 83
    .restart local p1    # "context":Landroid/content/Context;
    :cond_0
    invoke-interface {p2}, Ljava/lang/Runnable;->run()V

    goto :goto_0
.end method

.method public tryToShowDialog(Ljava/lang/Runnable;)V
    .locals 1
    .param p1, "showDialogRunnable"    # Ljava/lang/Runnable;

    .prologue
    .line 104
    :try_start_0
    invoke-interface {p1}, Ljava/lang/Runnable;->run()V
    :try_end_0
    .catch Landroid/view/WindowManager$BadTokenException; {:try_start_0 .. :try_end_0} :catch_0

    .line 108
    :goto_0
    return-void

    .line 105
    :catch_0
    move-exception v0

    goto :goto_0
.end method
