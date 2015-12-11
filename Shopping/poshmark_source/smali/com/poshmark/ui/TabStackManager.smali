.class public Lcom/poshmark/ui/TabStackManager;
.super Ljava/lang/Object;
.source "TabStackManager.java"


# static fields
.field static g_tabStackManager:Lcom/poshmark/ui/TabStackManager;


# instance fields
.field feedTabStack:Ljava/util/Stack;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Stack",
            "<",
            "Landroid/support/v4/app/Fragment;",
            ">;"
        }
    .end annotation
.end field

.field partyTabStack:Ljava/util/Stack;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Stack",
            "<",
            "Landroid/support/v4/app/Fragment;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 20
    const/4 v0, 0x0

    sput-object v0, Lcom/poshmark/ui/TabStackManager;->g_tabStackManager:Lcom/poshmark/ui/TabStackManager;

    return-void
.end method

.method constructor <init>()V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 29
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 16
    iput-object v0, p0, Lcom/poshmark/ui/TabStackManager;->feedTabStack:Ljava/util/Stack;

    .line 17
    iput-object v0, p0, Lcom/poshmark/ui/TabStackManager;->partyTabStack:Ljava/util/Stack;

    .line 30
    new-instance v0, Ljava/util/Stack;

    invoke-direct {v0}, Ljava/util/Stack;-><init>()V

    iput-object v0, p0, Lcom/poshmark/ui/TabStackManager;->feedTabStack:Ljava/util/Stack;

    .line 31
    new-instance v0, Ljava/util/Stack;

    invoke-direct {v0}, Ljava/util/Stack;-><init>()V

    iput-object v0, p0, Lcom/poshmark/ui/TabStackManager;->partyTabStack:Ljava/util/Stack;

    .line 32
    return-void
.end method

.method public static declared-synchronized GetTabStackManager()Lcom/poshmark/ui/TabStackManager;
    .locals 2

    .prologue
    .line 22
    const-class v1, Lcom/poshmark/ui/TabStackManager;

    monitor-enter v1

    :try_start_0
    sget-object v0, Lcom/poshmark/ui/TabStackManager;->g_tabStackManager:Lcom/poshmark/ui/TabStackManager;

    if-nez v0, :cond_0

    .line 23
    new-instance v0, Lcom/poshmark/ui/TabStackManager;

    invoke-direct {v0}, Lcom/poshmark/ui/TabStackManager;-><init>()V

    sput-object v0, Lcom/poshmark/ui/TabStackManager;->g_tabStackManager:Lcom/poshmark/ui/TabStackManager;

    .line 25
    :cond_0
    sget-object v0, Lcom/poshmark/ui/TabStackManager;->g_tabStackManager:Lcom/poshmark/ui/TabStackManager;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit v1

    return-object v0

    .line 22
    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method


# virtual methods
.method public poshFragmentFromFeedStack()V
    .locals 1

    .prologue
    .line 39
    iget-object v0, p0, Lcom/poshmark/ui/TabStackManager;->feedTabStack:Ljava/util/Stack;

    invoke-virtual {v0}, Ljava/util/Stack;->pop()Ljava/lang/Object;

    .line 40
    return-void
.end method

.method public poshFragmentFromPartyStack()V
    .locals 1

    .prologue
    .line 48
    iget-object v0, p0, Lcom/poshmark/ui/TabStackManager;->partyTabStack:Ljava/util/Stack;

    invoke-virtual {v0}, Ljava/util/Stack;->pop()Ljava/lang/Object;

    .line 49
    return-void
.end method

.method public pushFragmentToFeedStack(Landroid/support/v4/app/Fragment;)V
    .locals 1
    .param p1, "fragment"    # Landroid/support/v4/app/Fragment;

    .prologue
    .line 35
    iget-object v0, p0, Lcom/poshmark/ui/TabStackManager;->feedTabStack:Ljava/util/Stack;

    invoke-virtual {v0, p1}, Ljava/util/Stack;->push(Ljava/lang/Object;)Ljava/lang/Object;

    .line 36
    return-void
.end method

.method public pushFragmentToPartyStack(Landroid/support/v4/app/Fragment;)V
    .locals 1
    .param p1, "fragment"    # Landroid/support/v4/app/Fragment;

    .prologue
    .line 44
    iget-object v0, p0, Lcom/poshmark/ui/TabStackManager;->partyTabStack:Ljava/util/Stack;

    invoke-virtual {v0, p1}, Ljava/util/Stack;->push(Ljava/lang/Object;)Ljava/lang/Object;

    .line 45
    return-void
.end method
