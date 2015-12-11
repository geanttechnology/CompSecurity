.class public Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate;
.super Ljava/lang/Object;
.source "AuthenticatingActivityDelegate.java"

# interfaces
.implements Lcom/comcast/cim/android/view/launch/AuthenticationLauncher;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate$InternalLifecycleRunner;
    }
.end annotation


# instance fields
.field private final LOG:Lorg/slf4j/Logger;

.field private final activity:Landroid/app/Activity;

.field private alertDialog:Landroid/app/AlertDialog;

.field private final appUpgradeHelper:Lcom/comcast/cim/android/application/AppUpgradeHelper;

.field private final authStrategy:Lcom/comcast/cim/android/authentication/AuthenticationStrategy;

.field private final internalLifecycleRunner:Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate$InternalLifecycleRunner;

.field private final launchStrategy:Lcom/comcast/cim/android/view/launch/LaunchStrategy;

.field private launchingAuthentication:Z

.field private final minVersionCheckCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/taskexecutor/task/Task",
            "<",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation
.end field

.field private minVersionCheckListener:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener",
            "<",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation
.end field

.field private minVersionCheckTaskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor",
            "<",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation
.end field

.field private final taskExecutorFactory:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;

.field private final uiThreadExecutor:Ljava/util/concurrent/Executor;

.field private final userManager:Lcom/comcast/cim/model/user/UserManager;

.field private final versionCode:I


# direct methods
.method public constructor <init>(Landroid/app/Activity;Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate$InternalLifecycleRunner;Lcom/comcast/cim/model/user/UserManager;Lcom/comcast/cim/android/view/launch/LaunchStrategy;Lcom/comcast/cim/android/authentication/AuthenticationStrategy;Lcom/comcast/cim/android/application/AppUpgradeHelper;Ljava/util/concurrent/Executor;Lcom/comcast/cim/cmasl/taskexecutor/task/Task;Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;I)V
    .locals 1
    .param p1, "activity"    # Landroid/app/Activity;
    .param p2, "internalLifecycleRunner"    # Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate$InternalLifecycleRunner;
    .param p3, "userManager"    # Lcom/comcast/cim/model/user/UserManager;
    .param p4, "launchStrategy"    # Lcom/comcast/cim/android/view/launch/LaunchStrategy;
    .param p5, "authStrategy"    # Lcom/comcast/cim/android/authentication/AuthenticationStrategy;
    .param p6, "appUpgradeHelper"    # Lcom/comcast/cim/android/application/AppUpgradeHelper;
    .param p7, "uiThreadExecutor"    # Ljava/util/concurrent/Executor;
    .param p9, "taskExecutorFactory"    # Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;
    .param p10, "versionCode"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/app/Activity;",
            "Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate$InternalLifecycleRunner;",
            "Lcom/comcast/cim/model/user/UserManager;",
            "Lcom/comcast/cim/android/view/launch/LaunchStrategy;",
            "Lcom/comcast/cim/android/authentication/AuthenticationStrategy;",
            "Lcom/comcast/cim/android/application/AppUpgradeHelper;",
            "Ljava/util/concurrent/Executor;",
            "Lcom/comcast/cim/cmasl/taskexecutor/task/Task",
            "<",
            "Ljava/lang/Integer;",
            ">;",
            "Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;",
            "I)V"
        }
    .end annotation

    .prologue
    .line 57
    .local p8, "minVersionCheckCache":Lcom/comcast/cim/cmasl/taskexecutor/task/Task;, "Lcom/comcast/cim/cmasl/taskexecutor/task/Task<Ljava/lang/Integer;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 26
    const-class v0, Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate;->LOG:Lorg/slf4j/Logger;

    .line 58
    iput-object p1, p0, Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate;->activity:Landroid/app/Activity;

    .line 59
    iput-object p2, p0, Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate;->internalLifecycleRunner:Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate$InternalLifecycleRunner;

    .line 60
    iput-object p3, p0, Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate;->userManager:Lcom/comcast/cim/model/user/UserManager;

    .line 61
    iput-object p4, p0, Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate;->launchStrategy:Lcom/comcast/cim/android/view/launch/LaunchStrategy;

    .line 62
    iput-object p5, p0, Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate;->authStrategy:Lcom/comcast/cim/android/authentication/AuthenticationStrategy;

    .line 63
    iput-object p6, p0, Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate;->appUpgradeHelper:Lcom/comcast/cim/android/application/AppUpgradeHelper;

    .line 64
    iput-object p7, p0, Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate;->uiThreadExecutor:Ljava/util/concurrent/Executor;

    .line 65
    iput-object p8, p0, Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate;->minVersionCheckCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    .line 66
    iput-object p9, p0, Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate;->taskExecutorFactory:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;

    .line 67
    iput p10, p0, Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate;->versionCode:I

    .line 68
    return-void
.end method

.method static synthetic access$000(Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate;)Landroid/app/Activity;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate;

    .prologue
    .line 25
    iget-object v0, p0, Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate;->activity:Landroid/app/Activity;

    return-object v0
.end method

.method static synthetic access$100(Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate;)I
    .locals 1
    .param p0, "x0"    # Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate;

    .prologue
    .line 25
    iget v0, p0, Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate;->versionCode:I

    return v0
.end method

.method static synthetic access$200(Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate;)Lorg/slf4j/Logger;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate;

    .prologue
    .line 25
    iget-object v0, p0, Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate;->LOG:Lorg/slf4j/Logger;

    return-object v0
.end method

.method static synthetic access$300(Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate;)Lcom/comcast/cim/android/view/launch/LaunchStrategy;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate;

    .prologue
    .line 25
    iget-object v0, p0, Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate;->launchStrategy:Lcom/comcast/cim/android/view/launch/LaunchStrategy;

    return-object v0
.end method

.method private startActivityForResultWithNoAnimation(Ljava/lang/Class;I)V
    .locals 2
    .param p1, "clazz"    # Ljava/lang/Class;
    .param p2, "requestCode"    # I

    .prologue
    .line 83
    new-instance v0, Landroid/content/Intent;

    iget-object v1, p0, Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate;->activity:Landroid/app/Activity;

    invoke-direct {v0, v1, p1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 84
    .local v0, "intent":Landroid/content/Intent;
    const/high16 v1, 0x10000

    invoke-virtual {v0, v1}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 85
    iget-object v1, p0, Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate;->activity:Landroid/app/Activity;

    invoke-virtual {v1, v0, p2}, Landroid/app/Activity;->startActivityForResult(Landroid/content/Intent;I)V

    .line 86
    return-void
.end method


# virtual methods
.method public checkForUserUpgrade()V
    .locals 6

    .prologue
    const/4 v5, 0x0

    .line 94
    :try_start_0
    iget-object v1, p0, Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate;->appUpgradeHelper:Lcom/comcast/cim/android/application/AppUpgradeHelper;

    invoke-interface {v1}, Lcom/comcast/cim/android/application/AppUpgradeHelper;->onUserLoadedOrSignedIn()V

    .line 95
    iget-object v1, p0, Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate;->internalLifecycleRunner:Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate$InternalLifecycleRunner;

    invoke-interface {v1}, Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate$InternalLifecycleRunner;->onResumeInternal()V
    :try_end_0
    .catch Lcom/comcast/cim/exception/CimUpgradeException; {:try_start_0 .. :try_end_0} :catch_0

    .line 117
    :goto_0
    return-void

    .line 96
    :catch_0
    move-exception v0

    .line 98
    .local v0, "e":Lcom/comcast/cim/exception/CimUpgradeException;
    new-instance v1, Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate$1;

    iget-object v2, p0, Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate;->activity:Landroid/app/Activity;

    invoke-direct {v1, p0, v2}, Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate$1;-><init>(Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate;Landroid/content/Context;)V

    iput-object v1, p0, Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate;->alertDialog:Landroid/app/AlertDialog;

    .line 105
    iget-object v1, p0, Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate;->alertDialog:Landroid/app/AlertDialog;

    iget-object v2, p0, Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate;->activity:Landroid/app/Activity;

    invoke-virtual {v2}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    sget v3, Lcom/comcast/cim/android/R$string;->failed_upgrade:I

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/app/AlertDialog;->setMessage(Ljava/lang/CharSequence;)V

    .line 107
    iget-object v1, p0, Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate;->alertDialog:Landroid/app/AlertDialog;

    const/4 v2, -0x3

    const-string v3, "Exit"

    new-instance v4, Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate$2;

    invoke-direct {v4, p0}, Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate$2;-><init>(Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate;)V

    invoke-virtual {v1, v2, v3, v4}, Landroid/app/AlertDialog;->setButton(ILjava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)V

    .line 113
    iget-object v1, p0, Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate;->alertDialog:Landroid/app/AlertDialog;

    invoke-virtual {v1, v5}, Landroid/app/AlertDialog;->setCancelable(Z)V

    .line 114
    iget-object v1, p0, Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate;->alertDialog:Landroid/app/AlertDialog;

    invoke-virtual {v1, v5}, Landroid/app/AlertDialog;->setCanceledOnTouchOutside(Z)V

    .line 115
    iget-object v1, p0, Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate;->alertDialog:Landroid/app/AlertDialog;

    invoke-virtual {v1}, Landroid/app/AlertDialog;->show()V

    goto :goto_0
.end method

.method public doMinVersionCheck()V
    .locals 2

    .prologue
    .line 120
    iget-object v0, p0, Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate;->taskExecutorFactory:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;

    iget-object v1, p0, Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate;->minVersionCheckCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    invoke-virtual {v0, v1}, Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;->create(Lcom/comcast/cim/cmasl/taskexecutor/task/Task;)Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate;->minVersionCheckTaskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    .line 121
    new-instance v0, Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate$3;

    invoke-direct {v0, p0}, Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate$3;-><init>(Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate;)V

    iput-object v0, p0, Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate;->minVersionCheckListener:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    .line 147
    iget-object v0, p0, Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate;->minVersionCheckTaskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    iget-object v1, p0, Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate;->minVersionCheckListener:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    invoke-interface {v0, v1}, Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;->execute(Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;)Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    .line 148
    return-void
.end method

.method public isAuthenticated()Z
    .locals 1

    .prologue
    .line 151
    iget-object v0, p0, Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate;->authStrategy:Lcom/comcast/cim/android/authentication/AuthenticationStrategy;

    invoke-interface {v0}, Lcom/comcast/cim/android/authentication/AuthenticationStrategy;->isAuthenticated()Z

    move-result v0

    return v0
.end method

.method public launchAuthentication()V
    .locals 2

    .prologue
    .line 89
    iget-object v0, p0, Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate;->authStrategy:Lcom/comcast/cim/android/authentication/AuthenticationStrategy;

    invoke-interface {v0}, Lcom/comcast/cim/android/authentication/AuthenticationStrategy;->getAuthenticationActivityClass()Ljava/lang/Class;

    move-result-object v0

    const/16 v1, 0xb71

    invoke-direct {p0, v0, v1}, Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate;->startActivityForResultWithNoAnimation(Ljava/lang/Class;I)V

    .line 90
    return-void
.end method

.method public onActivityResult(IILandroid/content/Intent;)V
    .locals 2
    .param p1, "requestCode"    # I
    .param p2, "resultCode"    # I
    .param p3, "data"    # Landroid/content/Intent;

    .prologue
    const/16 v1, 0xb71

    .line 188
    const/16 v0, 0xf63

    if-eq p1, v0, :cond_1

    if-eq p1, v1, :cond_1

    .line 214
    :cond_0
    :goto_0
    return-void

    .line 192
    :cond_1
    if-nez p2, :cond_2

    .line 193
    iget-object v0, p0, Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate;->LOG:Lorg/slf4j/Logger;

    const-string v1, "User cancelled, close shop"

    invoke-interface {v0, v1}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 195
    iget-object v0, p0, Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate;->launchStrategy:Lcom/comcast/cim/android/view/launch/LaunchStrategy;

    iget-object v1, p0, Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate;->activity:Landroid/app/Activity;

    invoke-virtual {v0, v1}, Lcom/comcast/cim/android/view/launch/LaunchStrategy;->exitApp(Landroid/app/Activity;)V

    goto :goto_0

    .line 200
    :cond_2
    if-ne p1, v1, :cond_0

    .line 201
    packed-switch p2, :pswitch_data_0

    goto :goto_0

    .line 204
    :pswitch_0
    iget-object v0, p0, Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate;->launchStrategy:Lcom/comcast/cim/android/view/launch/LaunchStrategy;

    iget-object v1, p0, Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate;->activity:Landroid/app/Activity;

    invoke-virtual {v0, v1}, Lcom/comcast/cim/android/view/launch/LaunchStrategy;->restartAppFlow(Landroid/content/Context;)V

    goto :goto_0

    .line 201
    :pswitch_data_0
    .packed-switch 0x2
        :pswitch_0
    .end packed-switch
.end method

.method public onPause()V
    .locals 2

    .prologue
    .line 177
    iget-object v0, p0, Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate;->userManager:Lcom/comcast/cim/model/user/UserManager;

    invoke-virtual {v0}, Lcom/comcast/cim/model/user/UserManager;->saveUserAsync()V

    .line 178
    iget-object v0, p0, Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate;->alertDialog:Landroid/app/AlertDialog;

    if-eqz v0, :cond_0

    .line 179
    iget-object v0, p0, Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate;->alertDialog:Landroid/app/AlertDialog;

    invoke-virtual {v0}, Landroid/app/AlertDialog;->dismiss()V

    .line 180
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate;->alertDialog:Landroid/app/AlertDialog;

    .line 182
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate;->minVersionCheckTaskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    if-eqz v0, :cond_1

    .line 183
    iget-object v0, p0, Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate;->minVersionCheckTaskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    iget-object v1, p0, Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate;->minVersionCheckListener:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    invoke-interface {v0, v1}, Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;->cancelNotificationsFor(Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;)V

    .line 185
    :cond_1
    return-void
.end method

.method public onResume()V
    .locals 2

    .prologue
    .line 155
    iget-object v0, p0, Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate;->LOG:Lorg/slf4j/Logger;

    const-string v1, "onResume: Check the minimum version and whether we need to update the user or have them sign-in"

    invoke-interface {v0, v1}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 156
    invoke-virtual {p0}, Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate;->doMinVersionCheck()V

    .line 157
    iget-boolean v0, p0, Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate;->launchingAuthentication:Z

    if-eqz v0, :cond_0

    .line 159
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate;->launchingAuthentication:Z

    .line 174
    :goto_0
    return-void

    .line 161
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate;->activity:Landroid/app/Activity;

    invoke-virtual {v0}, Landroid/app/Activity;->isFinishing()Z

    move-result v0

    if-nez v0, :cond_1

    invoke-virtual {p0}, Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate;->isAuthenticated()Z

    move-result v0

    if-nez v0, :cond_1

    .line 162
    invoke-virtual {p0}, Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate;->launchAuthentication()V

    goto :goto_0

    .line 167
    :cond_1
    iget-object v0, p0, Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate;->uiThreadExecutor:Ljava/util/concurrent/Executor;

    new-instance v1, Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate$4;

    invoke-direct {v1, p0}, Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate$4;-><init>(Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate;)V

    invoke-interface {v0, v1}, Ljava/util/concurrent/Executor;->execute(Ljava/lang/Runnable;)V

    .line 173
    iget-object v0, p0, Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate;->LOG:Lorg/slf4j/Logger;

    const-string v1, "onResume: We are finishing or not authenticated, call through to onResumeInternal"

    invoke-interface {v0, v1}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public onStart()V
    .locals 2

    .prologue
    .line 71
    iget-object v0, p0, Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate;->LOG:Lorg/slf4j/Logger;

    const-string v1, "onStart: Check to see if we need to update the user or have them authenticate"

    invoke-interface {v0, v1}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 72
    iget-object v0, p0, Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate;->activity:Landroid/app/Activity;

    invoke-virtual {v0}, Landroid/app/Activity;->isFinishing()Z

    move-result v0

    if-nez v0, :cond_0

    invoke-virtual {p0}, Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate;->isAuthenticated()Z

    move-result v0

    if-nez v0, :cond_0

    .line 73
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate;->launchingAuthentication:Z

    .line 74
    invoke-virtual {p0}, Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate;->launchAuthentication()V

    .line 80
    :goto_0
    return-void

    .line 78
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate;->internalLifecycleRunner:Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate$InternalLifecycleRunner;

    invoke-interface {v0}, Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate$InternalLifecycleRunner;->onStartInternal()V

    goto :goto_0
.end method
