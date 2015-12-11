.class public abstract Lcom/comcast/cim/android/view/launch/AuthenticatingActivity;
.super Lcom/comcast/cim/android/view/common/BaseActivity;
.source "AuthenticatingActivity.java"

# interfaces
.implements Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate$InternalLifecycleRunner;
.implements Lcom/comcast/cim/android/view/launch/AuthenticationLauncher;


# instance fields
.field private final LOG:Lorg/slf4j/Logger;

.field authenticatingActivityDelegate:Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 12
    invoke-direct {p0}, Lcom/comcast/cim/android/view/common/BaseActivity;-><init>()V

    .line 14
    const-class v0, Lcom/comcast/cim/android/view/launch/AuthenticatingActivity;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/cim/android/view/launch/AuthenticatingActivity;->LOG:Lorg/slf4j/Logger;

    .line 16
    invoke-static {}, Lcom/comcast/cim/container/CALContainer;->getInstance()Lcom/comcast/cim/container/CALContainer;

    move-result-object v0

    invoke-virtual {v0, p0, p0}, Lcom/comcast/cim/container/CALContainer;->getAuthenticatingActivityDelegate(Landroid/app/Activity;Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate$InternalLifecycleRunner;)Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/cim/android/view/launch/AuthenticatingActivity;->authenticatingActivityDelegate:Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate;

    return-void
.end method


# virtual methods
.method protected abstract getUserManager()Lcom/comcast/cim/model/user/UserManager;
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

.method protected onActivityResult(IILandroid/content/Intent;)V
    .locals 1
    .param p1, "requestCode"    # I
    .param p2, "resultCode"    # I
    .param p3, "data"    # Landroid/content/Intent;

    .prologue
    .line 55
    invoke-super {p0, p1, p2, p3}, Lcom/comcast/cim/android/view/common/BaseActivity;->onActivityResult(IILandroid/content/Intent;)V

    .line 56
    iget-object v0, p0, Lcom/comcast/cim/android/view/launch/AuthenticatingActivity;->authenticatingActivityDelegate:Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate;

    invoke-virtual {v0, p1, p2, p3}, Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate;->onActivityResult(IILandroid/content/Intent;)V

    .line 57
    return-void
.end method

.method protected onPause()V
    .locals 2

    .prologue
    .line 46
    invoke-super {p0}, Lcom/comcast/cim/android/view/common/BaseActivity;->onPause()V

    .line 47
    iget-object v0, p0, Lcom/comcast/cim/android/view/launch/AuthenticatingActivity;->LOG:Lorg/slf4j/Logger;

    const-string v1, "onPause"

    invoke-interface {v0, v1}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 48
    iget-object v0, p0, Lcom/comcast/cim/android/view/launch/AuthenticatingActivity;->authenticatingActivityDelegate:Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate;

    invoke-virtual {v0}, Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate;->onPause()V

    .line 49
    return-void
.end method

.method public final onResume()V
    .locals 2

    .prologue
    .line 32
    invoke-super {p0}, Lcom/comcast/cim/android/view/common/BaseActivity;->onResume()V

    .line 33
    iget-object v0, p0, Lcom/comcast/cim/android/view/launch/AuthenticatingActivity;->LOG:Lorg/slf4j/Logger;

    const-string v1, "onResume"

    invoke-interface {v0, v1}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 34
    iget-object v0, p0, Lcom/comcast/cim/android/view/launch/AuthenticatingActivity;->authenticatingActivityDelegate:Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate;

    invoke-virtual {v0}, Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate;->onResume()V

    .line 35
    return-void
.end method

.method public onResumeInternal()V
    .locals 0

    .prologue
    .line 42
    return-void
.end method

.method public final onStart()V
    .locals 2

    .prologue
    .line 19
    invoke-super {p0}, Lcom/comcast/cim/android/view/common/BaseActivity;->onStart()V

    .line 20
    iget-object v0, p0, Lcom/comcast/cim/android/view/launch/AuthenticatingActivity;->LOG:Lorg/slf4j/Logger;

    const-string v1, "onStart"

    invoke-interface {v0, v1}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 21
    iget-object v0, p0, Lcom/comcast/cim/android/view/launch/AuthenticatingActivity;->authenticatingActivityDelegate:Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate;

    invoke-virtual {v0}, Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate;->onStart()V

    .line 22
    return-void
.end method

.method public onStartInternal()V
    .locals 0

    .prologue
    .line 29
    return-void
.end method
