.class public Lcom/poshmark/utils/sharing/share_states/EmailShare;
.super Lcom/poshmark/utils/sharing/share_states/ShareState;
.source "EmailShare.java"


# static fields
.field public static id:Ljava/util/UUID;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 19
    invoke-static {}, Ljava/util/UUID;->randomUUID()Ljava/util/UUID;

    move-result-object v0

    sput-object v0, Lcom/poshmark/utils/sharing/share_states/EmailShare;->id:Ljava/util/UUID;

    return-void
.end method

.method public constructor <init>(Lcom/poshmark/utils/sharing/StateCompletionListener;Lcom/poshmark/utils/ShareManager;)V
    .locals 0
    .param p1, "listener"    # Lcom/poshmark/utils/sharing/StateCompletionListener;
    .param p2, "shareManager"    # Lcom/poshmark/utils/ShareManager;

    .prologue
    .line 22
    invoke-direct {p0, p1, p2}, Lcom/poshmark/utils/sharing/share_states/ShareState;-><init>(Lcom/poshmark/utils/sharing/StateCompletionListener;Lcom/poshmark/utils/ShareManager;)V

    .line 23
    return-void
.end method


# virtual methods
.method public executeState()V
    .locals 9

    .prologue
    .line 31
    iget-object v5, p0, Lcom/poshmark/utils/sharing/share_states/EmailShare;->shareManager:Lcom/poshmark/utils/ShareManager;

    invoke-virtual {v5}, Lcom/poshmark/utils/ShareManager;->getShareContent()Lcom/poshmark/utils/sharing/PMShareContent;

    move-result-object v1

    .line 32
    .local v1, "pmContent":Lcom/poshmark/utils/sharing/PMShareContent;
    invoke-virtual {v1}, Lcom/poshmark/utils/sharing/PMShareContent;->getSubject()Ljava/lang/String;

    move-result-object v4

    .line 33
    .local v4, "subject":Ljava/lang/String;
    invoke-virtual {v1}, Lcom/poshmark/utils/sharing/PMShareContent;->getBody()Ljava/lang/String;

    move-result-object v0

    .line 35
    .local v0, "body":Ljava/lang/String;
    new-instance v3, Landroid/content/Intent;

    const-string v5, "android.intent.action.SENDTO"

    const-string v6, "mailto"

    const-string v7, ""

    const/4 v8, 0x0

    invoke-static {v6, v7, v8}, Landroid/net/Uri;->fromParts(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v6

    invoke-direct {v3, v5, v6}, Landroid/content/Intent;-><init>(Ljava/lang/String;Landroid/net/Uri;)V

    .line 36
    .local v3, "sendIntent":Landroid/content/Intent;
    const-string v5, "android.intent.extra.SUBJECT"

    invoke-virtual {v3, v5, v4}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 37
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v5, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v5}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v2

    .line 38
    .local v2, "s":Landroid/text/Spanned;
    const-string v5, "android.intent.extra.TEXT"

    invoke-virtual {v3, v5, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/CharSequence;)Landroid/content/Intent;

    .line 40
    iget-object v5, p0, Lcom/poshmark/utils/sharing/share_states/EmailShare;->shareManager:Lcom/poshmark/utils/ShareManager;

    invoke-virtual {v5}, Lcom/poshmark/utils/ShareManager;->getFragment()Lcom/poshmark/ui/fragments/PMFragment;

    move-result-object v5

    const-string v6, "Send email..."

    invoke-static {v3, v6}, Landroid/content/Intent;->createChooser(Landroid/content/Intent;Ljava/lang/CharSequence;)Landroid/content/Intent;

    move-result-object v6

    const/16 v7, 0xd

    invoke-virtual {v5, v6, v7}, Lcom/poshmark/ui/fragments/PMFragment;->startActivityForResult(Landroid/content/Intent;I)V

    .line 42
    iget-object v5, p0, Lcom/poshmark/utils/sharing/share_states/EmailShare;->shareManager:Lcom/poshmark/utils/ShareManager;

    invoke-virtual {v5}, Lcom/poshmark/utils/ShareManager;->trackShareEvent()V

    .line 43
    iget-object v5, p0, Lcom/poshmark/utils/sharing/share_states/EmailShare;->shareManager:Lcom/poshmark/utils/ShareManager;

    sget-object v6, Lcom/poshmark/utils/ShareManager;->EXTERNAL_SHARE_STATE_INITIALED:Ljava/lang/String;

    invoke-virtual {v5, v6}, Lcom/poshmark/utils/ShareManager;->trackExternalShareOnPM(Ljava/lang/String;)V

    .line 44
    return-void
.end method

.method public getId()Ljava/util/UUID;
    .locals 1

    .prologue
    .line 27
    sget-object v0, Lcom/poshmark/utils/sharing/share_states/EmailShare;->id:Ljava/util/UUID;

    return-object v0
.end method
