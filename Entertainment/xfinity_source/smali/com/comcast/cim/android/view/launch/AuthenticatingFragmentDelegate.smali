.class public Lcom/comcast/cim/android/view/launch/AuthenticatingFragmentDelegate;
.super Ljava/lang/Object;
.source "AuthenticatingFragmentDelegate.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/comcast/cim/android/view/launch/AuthenticatingFragmentDelegate$InternalLifecycleRunner;
    }
.end annotation


# instance fields
.field protected final LOG:Lorg/slf4j/Logger;

.field private authLauncher:Lcom/comcast/cim/android/view/launch/AuthenticationLauncher;

.field private final authStrategy:Lcom/comcast/cim/android/authentication/AuthenticationStrategy;

.field private final internalLifecycleRunner:Lcom/comcast/cim/android/view/launch/AuthenticatingFragmentDelegate$InternalLifecycleRunner;


# direct methods
.method public constructor <init>(Lcom/comcast/cim/android/view/launch/AuthenticatingFragmentDelegate$InternalLifecycleRunner;Lcom/comcast/cim/android/authentication/AuthenticationStrategy;)V
    .locals 1
    .param p1, "internalLifecycleRunner"    # Lcom/comcast/cim/android/view/launch/AuthenticatingFragmentDelegate$InternalLifecycleRunner;
    .param p2, "authStrategy"    # Lcom/comcast/cim/android/authentication/AuthenticationStrategy;

    .prologue
    .line 16
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 9
    const-class v0, Lcom/comcast/cim/android/view/launch/AuthenticatingFragmentDelegate;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/cim/android/view/launch/AuthenticatingFragmentDelegate;->LOG:Lorg/slf4j/Logger;

    .line 17
    iput-object p1, p0, Lcom/comcast/cim/android/view/launch/AuthenticatingFragmentDelegate;->internalLifecycleRunner:Lcom/comcast/cim/android/view/launch/AuthenticatingFragmentDelegate$InternalLifecycleRunner;

    .line 18
    iput-object p2, p0, Lcom/comcast/cim/android/view/launch/AuthenticatingFragmentDelegate;->authStrategy:Lcom/comcast/cim/android/authentication/AuthenticationStrategy;

    .line 19
    return-void
.end method


# virtual methods
.method public onAttach(Landroid/app/Activity;)V
    .locals 3
    .param p1, "activity"    # Landroid/app/Activity;

    .prologue
    .line 23
    :try_start_0
    check-cast p1, Lcom/comcast/cim/android/view/launch/AuthenticationLauncher;

    .end local p1    # "activity":Landroid/app/Activity;
    iput-object p1, p0, Lcom/comcast/cim/android/view/launch/AuthenticatingFragmentDelegate;->authLauncher:Lcom/comcast/cim/android/view/launch/AuthenticationLauncher;
    :try_end_0
    .catch Ljava/lang/ClassCastException; {:try_start_0 .. :try_end_0} :catch_0

    .line 27
    return-void

    .line 24
    :catch_0
    move-exception v0

    .line 25
    .local v0, "e":Ljava/lang/ClassCastException;
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string v2, "Cannot be attached to an activity that does not implement AuthenticationLauncher."

    invoke-direct {v1, v2, v0}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v1
.end method

.method public onResume()V
    .locals 2

    .prologue
    .line 38
    iget-object v0, p0, Lcom/comcast/cim/android/view/launch/AuthenticatingFragmentDelegate;->authStrategy:Lcom/comcast/cim/android/authentication/AuthenticationStrategy;

    invoke-interface {v0}, Lcom/comcast/cim/android/authentication/AuthenticationStrategy;->isAuthenticated()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 39
    iget-object v0, p0, Lcom/comcast/cim/android/view/launch/AuthenticatingFragmentDelegate;->internalLifecycleRunner:Lcom/comcast/cim/android/view/launch/AuthenticatingFragmentDelegate$InternalLifecycleRunner;

    invoke-interface {v0}, Lcom/comcast/cim/android/view/launch/AuthenticatingFragmentDelegate$InternalLifecycleRunner;->onResumeInternal()V

    .line 43
    :goto_0
    return-void

    .line 41
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/android/view/launch/AuthenticatingFragmentDelegate;->LOG:Lorg/slf4j/Logger;

    const-string v1, "Skipping onResumeInternal because we are not authenticated"

    invoke-interface {v0, v1}, Lorg/slf4j/Logger;->warn(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public onStart()V
    .locals 2

    .prologue
    .line 30
    iget-object v0, p0, Lcom/comcast/cim/android/view/launch/AuthenticatingFragmentDelegate;->authStrategy:Lcom/comcast/cim/android/authentication/AuthenticationStrategy;

    invoke-interface {v0}, Lcom/comcast/cim/android/authentication/AuthenticationStrategy;->isAuthenticated()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 31
    iget-object v0, p0, Lcom/comcast/cim/android/view/launch/AuthenticatingFragmentDelegate;->internalLifecycleRunner:Lcom/comcast/cim/android/view/launch/AuthenticatingFragmentDelegate$InternalLifecycleRunner;

    invoke-interface {v0}, Lcom/comcast/cim/android/view/launch/AuthenticatingFragmentDelegate$InternalLifecycleRunner;->onStartInternal()V

    .line 35
    :goto_0
    return-void

    .line 33
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/android/view/launch/AuthenticatingFragmentDelegate;->LOG:Lorg/slf4j/Logger;

    const-string v1, "Skipping onStartInternal because we are not authenticated"

    invoke-interface {v0, v1}, Lorg/slf4j/Logger;->warn(Ljava/lang/String;)V

    goto :goto_0
.end method
