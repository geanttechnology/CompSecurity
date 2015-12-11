.class public abstract Lcom/comcast/cim/android/view/launch/AuthenticatingPreferenceActivity;
.super Landroid/preference/PreferenceActivity;
.source "AuthenticatingPreferenceActivity.java"


# static fields
.field private static final LOG:Lorg/slf4j/Logger;


# instance fields
.field private authStrategy:Lcom/comcast/cim/android/authentication/AuthenticationStrategy;

.field private customLayoutInflaterFactory:Landroid/view/LayoutInflater$Factory;

.field private launchStrategy:Lcom/comcast/cim/android/view/launch/LaunchStrategy;

.field private minVersionCheckCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;
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

.field private minVersionCheckProvider:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor",
            "<",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation
.end field

.field private orientationStrategy:Lcom/comcast/cim/android/view/common/OrientationStrategy;

.field private taskExecutorFactory:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;

.field private versionCode:I


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 30
    const-class v0, Lcom/comcast/cim/android/view/launch/AuthenticatingPreferenceActivity;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    sput-object v0, Lcom/comcast/cim/android/view/launch/AuthenticatingPreferenceActivity;->LOG:Lorg/slf4j/Logger;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 29
    invoke-direct {p0}, Landroid/preference/PreferenceActivity;-><init>()V

    .line 39
    invoke-static {}, Lcom/comcast/cim/container/CALContainer;->getInstance()Lcom/comcast/cim/container/CALContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/CALContainer;->getLaunchStrategy()Lcom/comcast/cim/android/view/launch/LaunchStrategy;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/cim/android/view/launch/AuthenticatingPreferenceActivity;->launchStrategy:Lcom/comcast/cim/android/view/launch/LaunchStrategy;

    .line 40
    invoke-static {}, Lcom/comcast/cim/container/CALContainer;->getInstance()Lcom/comcast/cim/container/CALContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/CALContainer;->getAuthenticationStrategy()Lcom/comcast/cim/android/authentication/AuthenticationStrategy;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/cim/android/view/launch/AuthenticatingPreferenceActivity;->authStrategy:Lcom/comcast/cim/android/authentication/AuthenticationStrategy;

    .line 41
    invoke-static {}, Lcom/comcast/cim/container/CALContainer;->getInstance()Lcom/comcast/cim/container/CALContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/CALContainer;->getDefaultOrientationStrategy()Lcom/comcast/cim/android/view/common/OrientationStrategy;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/cim/android/view/launch/AuthenticatingPreferenceActivity;->orientationStrategy:Lcom/comcast/cim/android/view/common/OrientationStrategy;

    .line 42
    invoke-static {}, Lcom/comcast/cim/container/CALContainer;->getInstance()Lcom/comcast/cim/container/CALContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/CALContainer;->getLayoutInflatorFactory()Landroid/view/LayoutInflater$Factory;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/cim/android/view/launch/AuthenticatingPreferenceActivity;->customLayoutInflaterFactory:Landroid/view/LayoutInflater$Factory;

    .line 44
    invoke-static {}, Lcom/comcast/cim/container/CALContainer;->getInstance()Lcom/comcast/cim/container/CALContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/CALContainer;->getGracefullyDegradingMinVersionCheckCache()Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/cim/android/view/launch/AuthenticatingPreferenceActivity;->minVersionCheckCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    .line 45
    invoke-static {}, Lcom/comcast/cim/container/CALContainer;->getInstance()Lcom/comcast/cim/container/CALContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/CALContainer;->getTaskExecutorFactory()Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/cim/android/view/launch/AuthenticatingPreferenceActivity;->taskExecutorFactory:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;

    .line 48
    invoke-static {}, Lcom/comcast/cim/container/CALContainer;->getInstance()Lcom/comcast/cim/container/CALContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/CALContainer;->getVersionCode()Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    iput v0, p0, Lcom/comcast/cim/android/view/launch/AuthenticatingPreferenceActivity;->versionCode:I

    return-void
.end method

.method static synthetic access$000(Lcom/comcast/cim/android/view/launch/AuthenticatingPreferenceActivity;)I
    .locals 1
    .param p0, "x0"    # Lcom/comcast/cim/android/view/launch/AuthenticatingPreferenceActivity;

    .prologue
    .line 29
    iget v0, p0, Lcom/comcast/cim/android/view/launch/AuthenticatingPreferenceActivity;->versionCode:I

    return v0
.end method

.method static synthetic access$100(Lcom/comcast/cim/android/view/launch/AuthenticatingPreferenceActivity;)Lcom/comcast/cim/android/view/launch/LaunchStrategy;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/cim/android/view/launch/AuthenticatingPreferenceActivity;

    .prologue
    .line 29
    iget-object v0, p0, Lcom/comcast/cim/android/view/launch/AuthenticatingPreferenceActivity;->launchStrategy:Lcom/comcast/cim/android/view/launch/LaunchStrategy;

    return-object v0
.end method

.method private getOrientationStrategy()Lcom/comcast/cim/android/view/common/OrientationStrategy;
    .locals 1

    .prologue
    .line 164
    iget-object v0, p0, Lcom/comcast/cim/android/view/launch/AuthenticatingPreferenceActivity;->orientationStrategy:Lcom/comcast/cim/android/view/common/OrientationStrategy;

    return-object v0
.end method

.method private startActivityForResultWithNoAnimation(Ljava/lang/Class;I)V
    .locals 2
    .param p1, "clazz"    # Ljava/lang/Class;
    .param p2, "requestCode"    # I

    .prologue
    .line 145
    new-instance v0, Landroid/content/Intent;

    invoke-direct {v0, p0, p1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 146
    .local v0, "intent":Landroid/content/Intent;
    const/high16 v1, 0x10000

    invoke-virtual {v0, v1}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 147
    invoke-virtual {p0, v0, p2}, Lcom/comcast/cim/android/view/launch/AuthenticatingPreferenceActivity;->startActivityForResult(Landroid/content/Intent;I)V

    .line 148
    return-void
.end method


# virtual methods
.method public abstract getUserManager()Lcom/comcast/cim/model/user/UserManager;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/comcast/cim/model/user/UserManager",
            "<+",
            "Lcom/comcast/cim/model/user/User;",
            "+",
            "Lcom/comcast/cim/model/user/service/UserSettings;",
            ">;"
        }
    .end annotation
.end method

.method protected isAuthenticated()Z
    .locals 1

    .prologue
    .line 151
    iget-object v0, p0, Lcom/comcast/cim/android/view/launch/AuthenticatingPreferenceActivity;->authStrategy:Lcom/comcast/cim/android/authentication/AuthenticationStrategy;

    invoke-interface {v0}, Lcom/comcast/cim/android/authentication/AuthenticationStrategy;->isAuthenticated()Z

    move-result v0

    return v0
.end method

.method protected onActivityResult(IILandroid/content/Intent;)V
    .locals 2
    .param p1, "requestCode"    # I
    .param p2, "resultCode"    # I
    .param p3, "data"    # Landroid/content/Intent;

    .prologue
    const/16 v1, 0xb71

    .line 169
    invoke-super {p0, p1, p2, p3}, Landroid/preference/PreferenceActivity;->onActivityResult(IILandroid/content/Intent;)V

    .line 171
    const/16 v0, 0xf63

    if-eq p1, v0, :cond_1

    if-eq p1, v1, :cond_1

    .line 197
    :cond_0
    :goto_0
    return-void

    .line 175
    :cond_1
    if-nez p2, :cond_2

    .line 176
    sget-object v0, Lcom/comcast/cim/android/view/launch/AuthenticatingPreferenceActivity;->LOG:Lorg/slf4j/Logger;

    const-string v1, "User cancelled, close shop"

    invoke-interface {v0, v1}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 178
    iget-object v0, p0, Lcom/comcast/cim/android/view/launch/AuthenticatingPreferenceActivity;->launchStrategy:Lcom/comcast/cim/android/view/launch/LaunchStrategy;

    invoke-virtual {v0, p0}, Lcom/comcast/cim/android/view/launch/LaunchStrategy;->exitApp(Landroid/app/Activity;)V

    goto :goto_0

    .line 183
    :cond_2
    if-ne p1, v1, :cond_0

    .line 184
    packed-switch p2, :pswitch_data_0

    goto :goto_0

    .line 187
    :pswitch_0
    iget-object v0, p0, Lcom/comcast/cim/android/view/launch/AuthenticatingPreferenceActivity;->launchStrategy:Lcom/comcast/cim/android/view/launch/LaunchStrategy;

    invoke-virtual {v0, p0}, Lcom/comcast/cim/android/view/launch/LaunchStrategy;->restartAppFlow(Landroid/content/Context;)V

    goto :goto_0

    .line 184
    nop

    :pswitch_data_0
    .packed-switch 0x2
        :pswitch_0
    .end packed-switch
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 51
    invoke-super {p0, p1}, Landroid/preference/PreferenceActivity;->onCreate(Landroid/os/Bundle;)V

    .line 53
    invoke-direct {p0}, Lcom/comcast/cim/android/view/launch/AuthenticatingPreferenceActivity;->getOrientationStrategy()Lcom/comcast/cim/android/view/common/OrientationStrategy;

    move-result-object v1

    invoke-interface {v1}, Lcom/comcast/cim/android/view/common/OrientationStrategy;->getAppropriateOrientation()I

    move-result v1

    invoke-virtual {p0, v1}, Lcom/comcast/cim/android/view/launch/AuthenticatingPreferenceActivity;->setRequestedOrientation(I)V

    .line 55
    invoke-virtual {p0}, Lcom/comcast/cim/android/view/launch/AuthenticatingPreferenceActivity;->getActionBar()Landroid/app/ActionBar;

    move-result-object v0

    .line 56
    .local v0, "actionBar":Landroid/app/ActionBar;
    if-eqz v0, :cond_0

    .line 57
    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/app/ActionBar;->setHomeButtonEnabled(Z)V

    .line 59
    :cond_0
    return-void
.end method

.method public onCreateView(Ljava/lang/String;Landroid/content/Context;Landroid/util/AttributeSet;)Landroid/view/View;
    .locals 2
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "context"    # Landroid/content/Context;
    .param p3, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 63
    iget-object v1, p0, Lcom/comcast/cim/android/view/launch/AuthenticatingPreferenceActivity;->customLayoutInflaterFactory:Landroid/view/LayoutInflater$Factory;

    invoke-interface {v1, p1, p2, p3}, Landroid/view/LayoutInflater$Factory;->onCreateView(Ljava/lang/String;Landroid/content/Context;Landroid/util/AttributeSet;)Landroid/view/View;

    move-result-object v0

    .line 64
    .local v0, "view":Landroid/view/View;
    if-eqz v0, :cond_0

    .line 68
    .end local v0    # "view":Landroid/view/View;
    :goto_0
    return-object v0

    .restart local v0    # "view":Landroid/view/View;
    :cond_0
    invoke-super {p0, p1, p2, p3}, Landroid/preference/PreferenceActivity;->onCreateView(Ljava/lang/String;Landroid/content/Context;Landroid/util/AttributeSet;)Landroid/view/View;

    move-result-object v0

    goto :goto_0
.end method

.method protected onPause()V
    .locals 2

    .prologue
    .line 137
    invoke-super {p0}, Landroid/preference/PreferenceActivity;->onPause()V

    .line 138
    invoke-virtual {p0}, Lcom/comcast/cim/android/view/launch/AuthenticatingPreferenceActivity;->getUserManager()Lcom/comcast/cim/model/user/UserManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/model/user/UserManager;->saveUserAsync()V

    .line 139
    iget-object v0, p0, Lcom/comcast/cim/android/view/launch/AuthenticatingPreferenceActivity;->minVersionCheckProvider:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    if-eqz v0, :cond_0

    .line 140
    iget-object v0, p0, Lcom/comcast/cim/android/view/launch/AuthenticatingPreferenceActivity;->minVersionCheckProvider:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    iget-object v1, p0, Lcom/comcast/cim/android/view/launch/AuthenticatingPreferenceActivity;->minVersionCheckListener:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    invoke-interface {v0, v1}, Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;->cancelNotificationsFor(Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;)V

    .line 142
    :cond_0
    return-void
.end method

.method public final onResume()V
    .locals 2

    .prologue
    .line 91
    invoke-super {p0}, Landroid/preference/PreferenceActivity;->onResume()V

    .line 92
    sget-object v0, Lcom/comcast/cim/android/view/launch/AuthenticatingPreferenceActivity;->LOG:Lorg/slf4j/Logger;

    const-string v1, "onResume"

    invoke-interface {v0, v1}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 94
    sget-object v0, Lcom/comcast/cim/android/view/launch/AuthenticatingPreferenceActivity;->LOG:Lorg/slf4j/Logger;

    const-string v1, "Check to see if we need to update the user or have them sign-in"

    invoke-interface {v0, v1}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 95
    invoke-virtual {p0}, Lcom/comcast/cim/android/view/launch/AuthenticatingPreferenceActivity;->isFinishing()Z

    move-result v0

    if-nez v0, :cond_0

    invoke-virtual {p0}, Lcom/comcast/cim/android/view/launch/AuthenticatingPreferenceActivity;->isAuthenticated()Z

    move-result v0

    if-nez v0, :cond_0

    .line 96
    iget-object v0, p0, Lcom/comcast/cim/android/view/launch/AuthenticatingPreferenceActivity;->authStrategy:Lcom/comcast/cim/android/authentication/AuthenticationStrategy;

    invoke-interface {v0}, Lcom/comcast/cim/android/authentication/AuthenticationStrategy;->getAuthenticationActivityClass()Ljava/lang/Class;

    move-result-object v0

    const/16 v1, 0xb71

    invoke-direct {p0, v0, v1}, Lcom/comcast/cim/android/view/launch/AuthenticatingPreferenceActivity;->startActivityForResultWithNoAnimation(Ljava/lang/Class;I)V

    .line 133
    :goto_0
    return-void

    .line 100
    :cond_0
    invoke-virtual {p0}, Lcom/comcast/cim/android/view/launch/AuthenticatingPreferenceActivity;->onResumeInternal()V

    .line 102
    iget-object v0, p0, Lcom/comcast/cim/android/view/launch/AuthenticatingPreferenceActivity;->taskExecutorFactory:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;

    iget-object v1, p0, Lcom/comcast/cim/android/view/launch/AuthenticatingPreferenceActivity;->minVersionCheckCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    invoke-virtual {v0, v1}, Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;->create(Lcom/comcast/cim/cmasl/taskexecutor/task/Task;)Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/cim/android/view/launch/AuthenticatingPreferenceActivity;->minVersionCheckProvider:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    .line 103
    new-instance v0, Lcom/comcast/cim/android/view/launch/AuthenticatingPreferenceActivity$1;

    invoke-direct {v0, p0}, Lcom/comcast/cim/android/view/launch/AuthenticatingPreferenceActivity$1;-><init>(Lcom/comcast/cim/android/view/launch/AuthenticatingPreferenceActivity;)V

    iput-object v0, p0, Lcom/comcast/cim/android/view/launch/AuthenticatingPreferenceActivity;->minVersionCheckListener:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    .line 132
    iget-object v0, p0, Lcom/comcast/cim/android/view/launch/AuthenticatingPreferenceActivity;->minVersionCheckProvider:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    iget-object v1, p0, Lcom/comcast/cim/android/view/launch/AuthenticatingPreferenceActivity;->minVersionCheckListener:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    invoke-interface {v0, v1}, Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;->execute(Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;)Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    goto :goto_0
.end method

.method protected onResumeInternal()V
    .locals 0

    .prologue
    .line 161
    return-void
.end method

.method public final onStart()V
    .locals 2

    .prologue
    .line 72
    invoke-super {p0}, Landroid/preference/PreferenceActivity;->onStart()V

    .line 73
    sget-object v0, Lcom/comcast/cim/android/view/launch/AuthenticatingPreferenceActivity;->LOG:Lorg/slf4j/Logger;

    const-string v1, "onStart"

    invoke-interface {v0, v1}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 75
    sget-object v0, Lcom/comcast/cim/android/view/launch/AuthenticatingPreferenceActivity;->LOG:Lorg/slf4j/Logger;

    const-string v1, "Check to see if we need to update the user or have them sign-in"

    invoke-interface {v0, v1}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 76
    invoke-virtual {p0}, Lcom/comcast/cim/android/view/launch/AuthenticatingPreferenceActivity;->isFinishing()Z

    move-result v0

    if-nez v0, :cond_0

    invoke-virtual {p0}, Lcom/comcast/cim/android/view/launch/AuthenticatingPreferenceActivity;->isAuthenticated()Z

    move-result v0

    if-nez v0, :cond_0

    .line 81
    :goto_0
    return-void

    .line 80
    :cond_0
    invoke-virtual {p0}, Lcom/comcast/cim/android/view/launch/AuthenticatingPreferenceActivity;->onStartInternal()V

    goto :goto_0
.end method

.method protected onStartInternal()V
    .locals 0

    .prologue
    .line 88
    return-void
.end method
