.class public Lcom/poshmark/utils/sharing/share_states/SMSShare;
.super Lcom/poshmark/utils/sharing/share_states/ShareState;
.source "SMSShare.java"


# static fields
.field public static id:Ljava/util/UUID;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 20
    invoke-static {}, Ljava/util/UUID;->randomUUID()Ljava/util/UUID;

    move-result-object v0

    sput-object v0, Lcom/poshmark/utils/sharing/share_states/SMSShare;->id:Ljava/util/UUID;

    return-void
.end method

.method public constructor <init>(Lcom/poshmark/utils/sharing/StateCompletionListener;Lcom/poshmark/utils/ShareManager;)V
    .locals 0
    .param p1, "listener"    # Lcom/poshmark/utils/sharing/StateCompletionListener;
    .param p2, "shareManager"    # Lcom/poshmark/utils/ShareManager;

    .prologue
    .line 23
    invoke-direct {p0, p1, p2}, Lcom/poshmark/utils/sharing/share_states/ShareState;-><init>(Lcom/poshmark/utils/sharing/StateCompletionListener;Lcom/poshmark/utils/ShareManager;)V

    .line 24
    return-void
.end method


# virtual methods
.method public executeState()V
    .locals 7

    .prologue
    .line 32
    iget-object v5, p0, Lcom/poshmark/utils/sharing/share_states/SMSShare;->shareManager:Lcom/poshmark/utils/ShareManager;

    invoke-virtual {v5}, Lcom/poshmark/utils/ShareManager;->getShareContent()Lcom/poshmark/utils/sharing/PMShareContent;

    move-result-object v2

    .line 33
    .local v2, "pmContent":Lcom/poshmark/utils/sharing/PMShareContent;
    invoke-virtual {v2}, Lcom/poshmark/utils/sharing/PMShareContent;->getShareMessage()Ljava/lang/String;

    move-result-object v1

    .line 34
    .local v1, "message":Ljava/lang/String;
    invoke-virtual {v2}, Lcom/poshmark/utils/sharing/PMShareContent;->getBody()Ljava/lang/String;

    move-result-object v0

    .line 36
    .local v0, "body":Ljava/lang/String;
    new-instance v4, Landroid/content/Intent;

    const-string v5, "android.intent.action.VIEW"

    invoke-direct {v4, v5}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 37
    .local v4, "sendIntent":Landroid/content/Intent;
    const-string v5, "sms:"

    invoke-static {v5}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v5

    invoke-virtual {v4, v5}, Landroid/content/Intent;->setData(Landroid/net/Uri;)Landroid/content/Intent;

    .line 38
    const-string v5, "sms_body"

    invoke-virtual {v4, v5, v1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 39
    const-string v5, "android.intent.extra.SUBJECT"

    invoke-virtual {v4, v5, v1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 40
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v5, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v5}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v3

    .line 41
    .local v3, "s":Landroid/text/Spanned;
    const-string v5, "android.intent.extra.TEXT"

    invoke-virtual {v4, v5, v3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/CharSequence;)Landroid/content/Intent;

    .line 44
    :try_start_0
    iget-object v5, p0, Lcom/poshmark/utils/sharing/share_states/SMSShare;->shareManager:Lcom/poshmark/utils/ShareManager;

    invoke-virtual {v5}, Lcom/poshmark/utils/ShareManager;->getFragment()Lcom/poshmark/ui/fragments/PMFragment;

    move-result-object v5

    const/16 v6, 0xe

    invoke-virtual {v5, v4, v6}, Lcom/poshmark/ui/fragments/PMFragment;->startActivityForResult(Landroid/content/Intent;I)V
    :try_end_0
    .catch Landroid/content/ActivityNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    .line 49
    :goto_0
    iget-object v5, p0, Lcom/poshmark/utils/sharing/share_states/SMSShare;->shareManager:Lcom/poshmark/utils/ShareManager;

    invoke-virtual {v5}, Lcom/poshmark/utils/ShareManager;->trackShareEvent()V

    .line 50
    iget-object v5, p0, Lcom/poshmark/utils/sharing/share_states/SMSShare;->shareManager:Lcom/poshmark/utils/ShareManager;

    sget-object v6, Lcom/poshmark/utils/ShareManager;->EXTERNAL_SHARE_STATE_INITIALED:Ljava/lang/String;

    invoke-virtual {v5, v6}, Lcom/poshmark/utils/ShareManager;->trackExternalShareOnPM(Ljava/lang/String;)V

    .line 51
    return-void

    .line 46
    :catch_0
    move-exception v5

    goto :goto_0
.end method

.method public getId()Ljava/util/UUID;
    .locals 1

    .prologue
    .line 28
    sget-object v0, Lcom/poshmark/utils/sharing/share_states/SMSShare;->id:Ljava/util/UUID;

    return-object v0
.end method
