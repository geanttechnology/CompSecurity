.class public Lcom/poshmark/utils/DeepLinkLaunchInfo;
.super Ljava/lang/Object;
.source "DeepLinkLaunchInfo.java"


# instance fields
.field public bundle:Landroid/os/Bundle;

.field public data:Ljava/lang/Object;

.field public fragmentClass:Ljava/lang/Class;

.field public switchTabs:Z

.field public tab:I


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 16
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 14
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/poshmark/utils/DeepLinkLaunchInfo;->switchTabs:Z

    .line 18
    return-void
.end method

.method public constructor <init>(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;)V
    .locals 1
    .param p1, "bundle"    # Landroid/os/Bundle;
    .param p2, "fragmentClass"    # Ljava/lang/Class;
    .param p3, "data"    # Ljava/lang/Object;

    .prologue
    .line 19
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 14
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/poshmark/utils/DeepLinkLaunchInfo;->switchTabs:Z

    .line 20
    iput-object p1, p0, Lcom/poshmark/utils/DeepLinkLaunchInfo;->bundle:Landroid/os/Bundle;

    .line 21
    iput-object p2, p0, Lcom/poshmark/utils/DeepLinkLaunchInfo;->fragmentClass:Ljava/lang/Class;

    .line 22
    iput-object p3, p0, Lcom/poshmark/utils/DeepLinkLaunchInfo;->data:Ljava/lang/Object;

    .line 23
    return-void
.end method


# virtual methods
.method public setTabSwitch(I)V
    .locals 1
    .param p1, "tab"    # I

    .prologue
    .line 26
    iput p1, p0, Lcom/poshmark/utils/DeepLinkLaunchInfo;->tab:I

    .line 27
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/poshmark/utils/DeepLinkLaunchInfo;->switchTabs:Z

    .line 28
    return-void
.end method
