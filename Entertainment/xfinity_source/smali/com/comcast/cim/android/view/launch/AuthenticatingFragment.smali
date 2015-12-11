.class public abstract Lcom/comcast/cim/android/view/launch/AuthenticatingFragment;
.super Landroid/app/Fragment;
.source "AuthenticatingFragment.java"

# interfaces
.implements Lcom/comcast/cim/android/view/launch/AuthenticatingFragmentDelegate$InternalLifecycleRunner;


# instance fields
.field protected final LOG:Lorg/slf4j/Logger;

.field private authenticatingFragmentDelegate:Lcom/comcast/cim/android/view/launch/AuthenticatingFragmentDelegate;

.field protected handler:Landroid/os/Handler;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 11
    invoke-direct {p0}, Landroid/app/Fragment;-><init>()V

    .line 13
    const-class v0, Lcom/comcast/cim/android/view/launch/AuthenticatingFragment;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/cim/android/view/launch/AuthenticatingFragment;->LOG:Lorg/slf4j/Logger;

    .line 15
    invoke-static {}, Lcom/comcast/cim/container/CALContainer;->getInstance()Lcom/comcast/cim/container/CALContainer;

    move-result-object v0

    invoke-virtual {v0, p0}, Lcom/comcast/cim/container/CALContainer;->getAuthenticatingFragmentDelegate(Lcom/comcast/cim/android/view/launch/AuthenticatingFragmentDelegate$InternalLifecycleRunner;)Lcom/comcast/cim/android/view/launch/AuthenticatingFragmentDelegate;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/cim/android/view/launch/AuthenticatingFragment;->authenticatingFragmentDelegate:Lcom/comcast/cim/android/view/launch/AuthenticatingFragmentDelegate;

    .line 17
    new-instance v0, Landroid/os/Handler;

    invoke-direct {v0}, Landroid/os/Handler;-><init>()V

    iput-object v0, p0, Lcom/comcast/cim/android/view/launch/AuthenticatingFragment;->handler:Landroid/os/Handler;

    return-void
.end method


# virtual methods
.method public onAttach(Landroid/app/Activity;)V
    .locals 1
    .param p1, "activity"    # Landroid/app/Activity;

    .prologue
    .line 21
    invoke-super {p0, p1}, Landroid/app/Fragment;->onAttach(Landroid/app/Activity;)V

    .line 22
    iget-object v0, p0, Lcom/comcast/cim/android/view/launch/AuthenticatingFragment;->authenticatingFragmentDelegate:Lcom/comcast/cim/android/view/launch/AuthenticatingFragmentDelegate;

    invoke-virtual {v0, p1}, Lcom/comcast/cim/android/view/launch/AuthenticatingFragmentDelegate;->onAttach(Landroid/app/Activity;)V

    .line 23
    return-void
.end method

.method public final onResume()V
    .locals 2

    .prologue
    .line 41
    invoke-super {p0}, Landroid/app/Fragment;->onResume()V

    .line 42
    iget-object v0, p0, Lcom/comcast/cim/android/view/launch/AuthenticatingFragment;->LOG:Lorg/slf4j/Logger;

    const-string v1, "onResume"

    invoke-interface {v0, v1}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 43
    iget-object v0, p0, Lcom/comcast/cim/android/view/launch/AuthenticatingFragment;->authenticatingFragmentDelegate:Lcom/comcast/cim/android/view/launch/AuthenticatingFragmentDelegate;

    invoke-virtual {v0}, Lcom/comcast/cim/android/view/launch/AuthenticatingFragmentDelegate;->onResume()V

    .line 44
    return-void
.end method

.method public onResumeInternal()V
    .locals 0

    .prologue
    .line 52
    return-void
.end method

.method public final onStart()V
    .locals 2

    .prologue
    .line 27
    invoke-super {p0}, Landroid/app/Fragment;->onStart()V

    .line 28
    iget-object v0, p0, Lcom/comcast/cim/android/view/launch/AuthenticatingFragment;->LOG:Lorg/slf4j/Logger;

    const-string v1, "onStart"

    invoke-interface {v0, v1}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 29
    iget-object v0, p0, Lcom/comcast/cim/android/view/launch/AuthenticatingFragment;->authenticatingFragmentDelegate:Lcom/comcast/cim/android/view/launch/AuthenticatingFragmentDelegate;

    invoke-virtual {v0}, Lcom/comcast/cim/android/view/launch/AuthenticatingFragmentDelegate;->onStart()V

    .line 30
    return-void
.end method

.method public onStartInternal()V
    .locals 0

    .prologue
    .line 37
    return-void
.end method

.method protected safeSetVisibility(Landroid/view/View;I)V
    .locals 0
    .param p1, "view"    # Landroid/view/View;
    .param p2, "visibility"    # I

    .prologue
    .line 55
    if-eqz p1, :cond_0

    .line 56
    invoke-virtual {p1, p2}, Landroid/view/View;->setVisibility(I)V

    .line 58
    :cond_0
    return-void
.end method
