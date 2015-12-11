.class public Lcom/poshmark/utils/sharing/share_states/Finish;
.super Lcom/poshmark/utils/sharing/share_states/ShareState;
.source "Finish.java"


# static fields
.field public static id:Ljava/util/UUID;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 12
    invoke-static {}, Ljava/util/UUID;->randomUUID()Ljava/util/UUID;

    move-result-object v0

    sput-object v0, Lcom/poshmark/utils/sharing/share_states/Finish;->id:Ljava/util/UUID;

    return-void
.end method

.method public constructor <init>(Lcom/poshmark/utils/sharing/StateCompletionListener;Lcom/poshmark/utils/ShareManager;)V
    .locals 0
    .param p1, "listener"    # Lcom/poshmark/utils/sharing/StateCompletionListener;
    .param p2, "shareManager"    # Lcom/poshmark/utils/ShareManager;

    .prologue
    .line 15
    invoke-direct {p0, p1, p2}, Lcom/poshmark/utils/sharing/share_states/ShareState;-><init>(Lcom/poshmark/utils/sharing/StateCompletionListener;Lcom/poshmark/utils/ShareManager;)V

    .line 16
    return-void
.end method


# virtual methods
.method public executeState()V
    .locals 2

    .prologue
    .line 20
    iget-object v0, p0, Lcom/poshmark/utils/sharing/share_states/Finish;->shareManager:Lcom/poshmark/utils/ShareManager;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/poshmark/utils/ShareManager;->setShareContent(Lcom/poshmark/utils/sharing/ServerShareMessages;)V

    .line 21
    return-void
.end method

.method public getId()Ljava/util/UUID;
    .locals 1

    .prologue
    .line 24
    sget-object v0, Lcom/poshmark/utils/sharing/share_states/Finish;->id:Ljava/util/UUID;

    return-object v0
.end method
