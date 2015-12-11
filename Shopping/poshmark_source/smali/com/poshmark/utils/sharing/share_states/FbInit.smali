.class public Lcom/poshmark/utils/sharing/share_states/FbInit;
.super Lcom/poshmark/utils/sharing/share_states/ShareState;
.source "FbInit.java"


# static fields
.field public static id:Ljava/util/UUID;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 16
    invoke-static {}, Ljava/util/UUID;->randomUUID()Ljava/util/UUID;

    move-result-object v0

    sput-object v0, Lcom/poshmark/utils/sharing/share_states/FbInit;->id:Ljava/util/UUID;

    return-void
.end method

.method public constructor <init>(Lcom/poshmark/utils/sharing/StateCompletionListener;Lcom/poshmark/utils/ShareManager;)V
    .locals 0
    .param p1, "listener"    # Lcom/poshmark/utils/sharing/StateCompletionListener;
    .param p2, "shareManager"    # Lcom/poshmark/utils/ShareManager;

    .prologue
    .line 19
    invoke-direct {p0, p1, p2}, Lcom/poshmark/utils/sharing/share_states/ShareState;-><init>(Lcom/poshmark/utils/sharing/StateCompletionListener;Lcom/poshmark/utils/ShareManager;)V

    .line 20
    return-void
.end method


# virtual methods
.method public executeState()V
    .locals 4

    .prologue
    const/16 v3, 0x8

    .line 24
    invoke-static {}, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->getInstance()Lcom/poshmark/fb_tmblr_twitter/FbHelper;

    move-result-object v0

    sget-object v1, Lcom/poshmark/fb_tmblr_twitter/FBPermissionStates;->PUBLISH_PERMISSION:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->isPermissionEnabled(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 26
    iget-object v0, p0, Lcom/poshmark/utils/sharing/share_states/FbInit;->listener:Lcom/poshmark/utils/sharing/StateCompletionListener;

    invoke-interface {v0}, Lcom/poshmark/utils/sharing/StateCompletionListener;->stateCompleted()V

    .line 46
    :goto_0
    return-void

    .line 28
    :cond_0
    invoke-static {}, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->getInstance()Lcom/poshmark/fb_tmblr_twitter/FbHelper;

    move-result-object v0

    iget-object v1, p0, Lcom/poshmark/utils/sharing/share_states/FbInit;->shareManager:Lcom/poshmark/utils/ShareManager;

    invoke-virtual {v1}, Lcom/poshmark/utils/ShareManager;->getFragment()Lcom/poshmark/ui/fragments/PMFragment;

    move-result-object v1

    new-instance v2, Lcom/poshmark/utils/sharing/share_states/FbInit$1;

    invoke-direct {v2, p0}, Lcom/poshmark/utils/sharing/share_states/FbInit$1;-><init>(Lcom/poshmark/utils/sharing/share_states/FbInit;)V

    invoke-virtual {v0, v1, v3, v3, v2}, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->link(Lcom/poshmark/ui/fragments/PMFragment;IILcom/poshmark/fb_tmblr_twitter/FBConnectCallback;)V

    goto :goto_0
.end method

.method public getId()Ljava/util/UUID;
    .locals 1

    .prologue
    .line 49
    sget-object v0, Lcom/poshmark/utils/sharing/share_states/FbInit;->id:Ljava/util/UUID;

    return-object v0
.end method
