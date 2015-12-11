.class public abstract Lcom/poshmark/utils/sharing/share_states/ShareState;
.super Ljava/lang/Object;
.source "ShareState.java"


# instance fields
.field listener:Lcom/poshmark/utils/sharing/StateCompletionListener;

.field shareManager:Lcom/poshmark/utils/ShareManager;


# direct methods
.method public constructor <init>(Lcom/poshmark/utils/sharing/StateCompletionListener;Lcom/poshmark/utils/ShareManager;)V
    .locals 0
    .param p1, "listener"    # Lcom/poshmark/utils/sharing/StateCompletionListener;
    .param p2, "shareManager"    # Lcom/poshmark/utils/ShareManager;

    .prologue
    .line 18
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 19
    iput-object p1, p0, Lcom/poshmark/utils/sharing/share_states/ShareState;->listener:Lcom/poshmark/utils/sharing/StateCompletionListener;

    .line 20
    iput-object p2, p0, Lcom/poshmark/utils/sharing/share_states/ShareState;->shareManager:Lcom/poshmark/utils/ShareManager;

    .line 21
    return-void
.end method


# virtual methods
.method public executeState()V
    .locals 0

    .prologue
    .line 22
    return-void
.end method

.method public abstract getId()Ljava/util/UUID;
.end method
