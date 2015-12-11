.class public Lcom/poshmark/utils/PoshLearnManager;
.super Ljava/lang/Object;
.source "PoshLearnManager.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/poshmark/utils/PoshLearnManager$SingletonHolder;
    }
.end annotation


# instance fields
.field private deepLinkLaunchFlag:Z


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 12
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 24
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/poshmark/utils/PoshLearnManager;->deepLinkLaunchFlag:Z

    return-void
.end method

.method public static getInstance()Lcom/poshmark/utils/PoshLearnManager;
    .locals 1

    .prologue
    .line 21
    sget-object v0, Lcom/poshmark/utils/PoshLearnManager$SingletonHolder;->INSTANCE:Lcom/poshmark/utils/PoshLearnManager;

    return-object v0
.end method


# virtual methods
.method public lauchPoshLearn(Landroid/support/v4/app/FragmentManager;)V
    .locals 2
    .param p1, "fragmentManager"    # Landroid/support/v4/app/FragmentManager;

    .prologue
    .line 49
    new-instance v0, Lcom/poshmark/utils/PoshLearnDialog;

    invoke-direct {v0}, Lcom/poshmark/utils/PoshLearnDialog;-><init>()V

    .line 50
    .local v0, "dlg":Lcom/poshmark/utils/PoshLearnDialog;
    const-string v1, "pmLoveDlg"

    invoke-virtual {v0, p1, v1}, Lcom/poshmark/utils/PoshLearnDialog;->show(Landroid/support/v4/app/FragmentManager;Ljava/lang/String;)V

    .line 51
    return-void
.end method

.method public setDeepLinkLaunchFlag(Z)V
    .locals 0
    .param p1, "flag"    # Z

    .prologue
    .line 27
    iput-boolean p1, p0, Lcom/poshmark/utils/PoshLearnManager;->deepLinkLaunchFlag:Z

    .line 28
    return-void
.end method

.method public shouldShowPoshLearnScreen()Z
    .locals 4

    .prologue
    const/4 v2, 0x0

    .line 33
    new-instance v1, Lcom/poshmark/utils/AppInfoCache;

    invoke-direct {v1}, Lcom/poshmark/utils/AppInfoCache;-><init>()V

    .line 34
    .local v1, "infoCache":Lcom/poshmark/utils/AppInfoCache;
    invoke-virtual {v1}, Lcom/poshmark/utils/AppInfoCache;->getCurrentVersion()Ljava/lang/String;

    move-result-object v0

    .line 35
    .local v0, "currentVersion":Ljava/lang/String;
    if-nez v0, :cond_0

    .line 37
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v3

    invoke-virtual {v3}, Lcom/poshmark/application/PMApplicationSession;->isLoggedIn()Z

    move-result v3

    if-eqz v3, :cond_0

    iget-boolean v3, p0, Lcom/poshmark/utils/PoshLearnManager;->deepLinkLaunchFlag:Z

    if-nez v3, :cond_0

    .line 39
    const/4 v2, 0x1

    .line 45
    :cond_0
    return v2
.end method
