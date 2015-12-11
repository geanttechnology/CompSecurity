.class public Lcom/poshmark/utils/sharing/share_states/ShareToFollowersInit;
.super Lcom/poshmark/utils/sharing/share_states/ShareState;
.source "ShareToFollowersInit.java"


# static fields
.field public static id:Ljava/util/UUID;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 13
    invoke-static {}, Ljava/util/UUID;->randomUUID()Ljava/util/UUID;

    move-result-object v0

    sput-object v0, Lcom/poshmark/utils/sharing/share_states/ShareToFollowersInit;->id:Ljava/util/UUID;

    return-void
.end method

.method public constructor <init>(Lcom/poshmark/utils/sharing/StateCompletionListener;Lcom/poshmark/utils/ShareManager;)V
    .locals 0
    .param p1, "listener"    # Lcom/poshmark/utils/sharing/StateCompletionListener;
    .param p2, "shareManager"    # Lcom/poshmark/utils/ShareManager;

    .prologue
    .line 16
    invoke-direct {p0, p1, p2}, Lcom/poshmark/utils/sharing/share_states/ShareState;-><init>(Lcom/poshmark/utils/sharing/StateCompletionListener;Lcom/poshmark/utils/ShareManager;)V

    .line 17
    return-void
.end method


# virtual methods
.method public executeState()V
    .locals 1

    .prologue
    .line 20
    iget-object v0, p0, Lcom/poshmark/utils/sharing/share_states/ShareToFollowersInit;->listener:Lcom/poshmark/utils/sharing/StateCompletionListener;

    invoke-interface {v0}, Lcom/poshmark/utils/sharing/StateCompletionListener;->stateCompleted()V

    .line 21
    return-void
.end method

.method public getId()Ljava/util/UUID;
    .locals 1

    .prologue
    .line 25
    sget-object v0, Lcom/poshmark/utils/sharing/share_states/ShareToFollowersInit;->id:Ljava/util/UUID;

    return-object v0
.end method
