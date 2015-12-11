.class public Lcom/poshmark/utils/sharing/share_states/PinterestShare;
.super Lcom/poshmark/utils/sharing/share_states/ShareState;
.source "PinterestShare.java"


# static fields
.field public static id:Ljava/util/UUID;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 18
    invoke-static {}, Ljava/util/UUID;->randomUUID()Ljava/util/UUID;

    move-result-object v0

    sput-object v0, Lcom/poshmark/utils/sharing/share_states/PinterestShare;->id:Ljava/util/UUID;

    return-void
.end method

.method public constructor <init>(Lcom/poshmark/utils/sharing/StateCompletionListener;Lcom/poshmark/utils/ShareManager;)V
    .locals 0
    .param p1, "listener"    # Lcom/poshmark/utils/sharing/StateCompletionListener;
    .param p2, "shareManager"    # Lcom/poshmark/utils/ShareManager;

    .prologue
    .line 21
    invoke-direct {p0, p1, p2}, Lcom/poshmark/utils/sharing/share_states/ShareState;-><init>(Lcom/poshmark/utils/sharing/StateCompletionListener;Lcom/poshmark/utils/ShareManager;)V

    .line 22
    return-void
.end method


# virtual methods
.method public executeState()V
    .locals 6

    .prologue
    .line 25
    iget-object v4, p0, Lcom/poshmark/utils/sharing/share_states/PinterestShare;->shareManager:Lcom/poshmark/utils/ShareManager;

    sget-object v5, Lcom/poshmark/utils/ShareManager;->EXTERNAL_SHARE_STATE_INITIALED:Ljava/lang/String;

    invoke-virtual {v4, v5}, Lcom/poshmark/utils/ShareManager;->trackExternalShareOnPM(Ljava/lang/String;)V

    .line 26
    iget-object v4, p0, Lcom/poshmark/utils/sharing/share_states/PinterestShare;->shareManager:Lcom/poshmark/utils/ShareManager;

    invoke-virtual {v4}, Lcom/poshmark/utils/ShareManager;->getFragment()Lcom/poshmark/ui/fragments/PMFragment;

    move-result-object v4

    invoke-virtual {v4}, Lcom/poshmark/ui/fragments/PMFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    .line 27
    .local v0, "activity":Landroid/app/Activity;
    iget-object v4, p0, Lcom/poshmark/utils/sharing/share_states/PinterestShare;->shareManager:Lcom/poshmark/utils/ShareManager;

    invoke-virtual {v4}, Lcom/poshmark/utils/ShareManager;->getShareContent()Lcom/poshmark/utils/sharing/PMShareContent;

    move-result-object v4

    invoke-virtual {v4}, Lcom/poshmark/utils/sharing/PMShareContent;->getShareDescription()Ljava/lang/String;

    move-result-object v1

    .line 28
    .local v1, "description":Ljava/lang/String;
    iget-object v4, p0, Lcom/poshmark/utils/sharing/share_states/PinterestShare;->shareManager:Lcom/poshmark/utils/ShareManager;

    invoke-virtual {v4}, Lcom/poshmark/utils/ShareManager;->getShareContent()Lcom/poshmark/utils/sharing/PMShareContent;

    move-result-object v4

    invoke-virtual {v4}, Lcom/poshmark/utils/sharing/PMShareContent;->getImageUrl()Ljava/lang/String;

    move-result-object v2

    .line 29
    .local v2, "imageUrl":Ljava/lang/String;
    iget-object v4, p0, Lcom/poshmark/utils/sharing/share_states/PinterestShare;->shareManager:Lcom/poshmark/utils/ShareManager;

    invoke-virtual {v4}, Lcom/poshmark/utils/ShareManager;->getShareContent()Lcom/poshmark/utils/sharing/PMShareContent;

    move-result-object v4

    invoke-virtual {v4}, Lcom/poshmark/utils/sharing/PMShareContent;->getShareUrl()Ljava/lang/String;

    move-result-object v3

    .line 30
    .local v3, "url":Ljava/lang/String;
    invoke-static {}, Lcom/poshmark/fb_tmblr_twitter/PinterestHelper;->getInstance()Lcom/poshmark/fb_tmblr_twitter/PinterestHelper;

    move-result-object v4

    invoke-virtual {v4, v1, v3, v2}, Lcom/poshmark/fb_tmblr_twitter/PinterestHelper;->setData(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 31
    invoke-static {}, Lcom/poshmark/fb_tmblr_twitter/PinterestHelper;->getInstance()Lcom/poshmark/fb_tmblr_twitter/PinterestHelper;

    move-result-object v4

    new-instance v5, Lcom/poshmark/utils/sharing/share_states/PinterestShare$1;

    invoke-direct {v5, p0}, Lcom/poshmark/utils/sharing/share_states/PinterestShare$1;-><init>(Lcom/poshmark/utils/sharing/share_states/PinterestShare;)V

    invoke-virtual {v4, v0, v5}, Lcom/poshmark/fb_tmblr_twitter/PinterestHelper;->explicitShare(Landroid/content/Context;Lcom/poshmark/fb_tmblr_twitter/ExtServiceConnectInterface;)V

    .line 44
    return-void
.end method

.method public getId()Ljava/util/UUID;
    .locals 1

    .prologue
    .line 48
    sget-object v0, Lcom/poshmark/utils/sharing/share_states/PinterestShare;->id:Ljava/util/UUID;

    return-object v0
.end method
