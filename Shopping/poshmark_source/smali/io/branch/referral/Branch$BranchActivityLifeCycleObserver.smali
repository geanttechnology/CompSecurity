.class Lio/branch/referral/Branch$BranchActivityLifeCycleObserver;
.super Ljava/lang/Object;
.source "Branch.java"

# interfaces
.implements Landroid/app/Application$ActivityLifecycleCallbacks;


# annotations
.annotation build Landroid/annotation/TargetApi;
    value = 0xe
.end annotation

.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lio/branch/referral/Branch;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "BranchActivityLifeCycleObserver"
.end annotation


# instance fields
.field private activityCnt_:I

.field final synthetic this$0:Lio/branch/referral/Branch;


# direct methods
.method private constructor <init>(Lio/branch/referral/Branch;)V
    .locals 1

    .prologue
    .line 3035
    iput-object p1, p0, Lio/branch/referral/Branch$BranchActivityLifeCycleObserver;->this$0:Lio/branch/referral/Branch;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 3036
    const/4 v0, 0x0

    iput v0, p0, Lio/branch/referral/Branch$BranchActivityLifeCycleObserver;->activityCnt_:I

    return-void
.end method

.method synthetic constructor <init>(Lio/branch/referral/Branch;Lio/branch/referral/Branch$1;)V
    .locals 0
    .param p1, "x0"    # Lio/branch/referral/Branch;
    .param p2, "x1"    # Lio/branch/referral/Branch$1;

    .prologue
    .line 3035
    invoke-direct {p0, p1}, Lio/branch/referral/Branch$BranchActivityLifeCycleObserver;-><init>(Lio/branch/referral/Branch;)V

    return-void
.end method


# virtual methods
.method public onActivityCreated(Landroid/app/Activity;Landroid/os/Bundle;)V
    .locals 0
    .param p1, "activity"    # Landroid/app/Activity;
    .param p2, "bundle"    # Landroid/os/Bundle;

    .prologue
    .line 3041
    return-void
.end method

.method public onActivityDestroyed(Landroid/app/Activity;)V
    .locals 2
    .param p1, "activity"    # Landroid/app/Activity;

    .prologue
    .line 3093
    iget-object v0, p0, Lio/branch/referral/Branch$BranchActivityLifeCycleObserver;->this$0:Lio/branch/referral/Branch;

    # getter for: Lio/branch/referral/Branch;->currentActivity_:Landroid/app/Activity;
    invoke-static {v0}, Lio/branch/referral/Branch;->access$400(Lio/branch/referral/Branch;)Landroid/app/Activity;

    move-result-object v0

    if-ne v0, p1, :cond_0

    .line 3094
    iget-object v0, p0, Lio/branch/referral/Branch$BranchActivityLifeCycleObserver;->this$0:Lio/branch/referral/Branch;

    const/4 v1, 0x0

    # setter for: Lio/branch/referral/Branch;->currentActivity_:Landroid/app/Activity;
    invoke-static {v0, v1}, Lio/branch/referral/Branch;->access$402(Lio/branch/referral/Branch;Landroid/app/Activity;)Landroid/app/Activity;

    .line 3096
    :cond_0
    return-void
.end method

.method public onActivityPaused(Landroid/app/Activity;)V
    .locals 2
    .param p1, "activity"    # Landroid/app/Activity;

    .prologue
    .line 3071
    iget-object v0, p0, Lio/branch/referral/Branch$BranchActivityLifeCycleObserver;->this$0:Lio/branch/referral/Branch;

    # invokes: Lio/branch/referral/Branch;->clearTouchDebugInternal(Landroid/app/Activity;)V
    invoke-static {v0, p1}, Lio/branch/referral/Branch;->access$1200(Lio/branch/referral/Branch;Landroid/app/Activity;)V

    .line 3073
    iget-object v0, p0, Lio/branch/referral/Branch$BranchActivityLifeCycleObserver;->this$0:Lio/branch/referral/Branch;

    # getter for: Lio/branch/referral/Branch;->shareLinkManager_:Lio/branch/referral/ShareLinkManager;
    invoke-static {v0}, Lio/branch/referral/Branch;->access$1300(Lio/branch/referral/Branch;)Lio/branch/referral/ShareLinkManager;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 3074
    iget-object v0, p0, Lio/branch/referral/Branch$BranchActivityLifeCycleObserver;->this$0:Lio/branch/referral/Branch;

    # getter for: Lio/branch/referral/Branch;->shareLinkManager_:Lio/branch/referral/ShareLinkManager;
    invoke-static {v0}, Lio/branch/referral/Branch;->access$1300(Lio/branch/referral/Branch;)Lio/branch/referral/ShareLinkManager;

    move-result-object v0

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lio/branch/referral/ShareLinkManager;->cancelShareLinkDialog(Z)V

    .line 3076
    :cond_0
    return-void
.end method

.method public onActivityResumed(Landroid/app/Activity;)V
    .locals 1
    .param p1, "activity"    # Landroid/app/Activity;

    .prologue
    .line 3062
    iget-object v0, p0, Lio/branch/referral/Branch$BranchActivityLifeCycleObserver;->this$0:Lio/branch/referral/Branch;

    # setter for: Lio/branch/referral/Branch;->currentActivity_:Landroid/app/Activity;
    invoke-static {v0, p1}, Lio/branch/referral/Branch;->access$402(Lio/branch/referral/Branch;Landroid/app/Activity;)Landroid/app/Activity;

    .line 3064
    iget-object v0, p0, Lio/branch/referral/Branch$BranchActivityLifeCycleObserver;->this$0:Lio/branch/referral/Branch;

    # getter for: Lio/branch/referral/Branch;->prefHelper_:Lio/branch/referral/PrefHelper;
    invoke-static {v0}, Lio/branch/referral/Branch;->access$100(Lio/branch/referral/Branch;)Lio/branch/referral/PrefHelper;

    move-result-object v0

    invoke-virtual {v0}, Lio/branch/referral/PrefHelper;->getTouchDebugging()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 3065
    iget-object v0, p0, Lio/branch/referral/Branch$BranchActivityLifeCycleObserver;->this$0:Lio/branch/referral/Branch;

    # invokes: Lio/branch/referral/Branch;->setTouchDebugInternal(Landroid/app/Activity;)V
    invoke-static {v0, p1}, Lio/branch/referral/Branch;->access$1100(Lio/branch/referral/Branch;Landroid/app/Activity;)V

    .line 3067
    :cond_0
    return-void
.end method

.method public onActivitySaveInstanceState(Landroid/app/Activity;Landroid/os/Bundle;)V
    .locals 0
    .param p1, "activity"    # Landroid/app/Activity;
    .param p2, "bundle"    # Landroid/os/Bundle;

    .prologue
    .line 3089
    return-void
.end method

.method public onActivityStarted(Landroid/app/Activity;)V
    .locals 3
    .param p1, "activity"    # Landroid/app/Activity;

    .prologue
    .line 3045
    iget v1, p0, Lio/branch/referral/Branch$BranchActivityLifeCycleObserver;->activityCnt_:I

    const/4 v2, 0x1

    if-ge v1, v2, :cond_2

    .line 3047
    iget-object v1, p0, Lio/branch/referral/Branch$BranchActivityLifeCycleObserver;->this$0:Lio/branch/referral/Branch;

    # getter for: Lio/branch/referral/Branch;->context_:Landroid/content/Context;
    invoke-static {v1}, Lio/branch/referral/Branch;->access$700(Lio/branch/referral/Branch;)Landroid/content/Context;

    move-result-object v1

    invoke-static {v1}, Lio/branch/referral/BranchUtil;->isTestModeEnabled(Landroid/content/Context;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 3049
    iget-object v1, p0, Lio/branch/referral/Branch$BranchActivityLifeCycleObserver;->this$0:Lio/branch/referral/Branch;

    invoke-virtual {v1}, Lio/branch/referral/Branch;->setDebug()V

    .line 3051
    :cond_0
    const/4 v0, 0x0

    .line 3052
    .local v0, "intentData":Landroid/net/Uri;
    invoke-virtual {p1}, Landroid/app/Activity;->getIntent()Landroid/content/Intent;

    move-result-object v1

    if-eqz v1, :cond_1

    .line 3053
    invoke-virtual {p1}, Landroid/app/Activity;->getIntent()Landroid/content/Intent;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/Intent;->getData()Landroid/net/Uri;

    move-result-object v0

    .line 3055
    :cond_1
    iget-object v1, p0, Lio/branch/referral/Branch$BranchActivityLifeCycleObserver;->this$0:Lio/branch/referral/Branch;

    invoke-virtual {v1, v0, p1}, Lio/branch/referral/Branch;->initSessionWithData(Landroid/net/Uri;Landroid/app/Activity;)Z

    .line 3057
    .end local v0    # "intentData":Landroid/net/Uri;
    :cond_2
    iget v1, p0, Lio/branch/referral/Branch$BranchActivityLifeCycleObserver;->activityCnt_:I

    add-int/lit8 v1, v1, 0x1

    iput v1, p0, Lio/branch/referral/Branch$BranchActivityLifeCycleObserver;->activityCnt_:I

    .line 3058
    return-void
.end method

.method public onActivityStopped(Landroid/app/Activity;)V
    .locals 2
    .param p1, "activity"    # Landroid/app/Activity;

    .prologue
    .line 3080
    iget v0, p0, Lio/branch/referral/Branch$BranchActivityLifeCycleObserver;->activityCnt_:I

    add-int/lit8 v0, v0, -0x1

    iput v0, p0, Lio/branch/referral/Branch$BranchActivityLifeCycleObserver;->activityCnt_:I

    .line 3082
    iget v0, p0, Lio/branch/referral/Branch$BranchActivityLifeCycleObserver;->activityCnt_:I

    const/4 v1, 0x1

    if-ge v0, v1, :cond_0

    .line 3083
    iget-object v0, p0, Lio/branch/referral/Branch$BranchActivityLifeCycleObserver;->this$0:Lio/branch/referral/Branch;

    # invokes: Lio/branch/referral/Branch;->closeSessionInternal()V
    invoke-static {v0}, Lio/branch/referral/Branch;->access$1400(Lio/branch/referral/Branch;)V

    .line 3085
    :cond_0
    return-void
.end method
