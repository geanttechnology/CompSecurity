.class Lcom/mixerbox/mixerbox3b/fragments/WebFragment$5;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# instance fields
.field final synthetic this$0:Lcom/mixerbox/mixerbox3b/fragments/WebFragment;


# direct methods
.method constructor <init>(Lcom/mixerbox/mixerbox3b/fragments/WebFragment;)V
    .locals 0

    .prologue
    .line 143
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/fragments/WebFragment$5;->this$0:Lcom/mixerbox/mixerbox3b/fragments/WebFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3

    .prologue
    .line 146
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 147
    const-string v1, "url"

    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/fragments/WebFragment$5;->this$0:Lcom/mixerbox/mixerbox3b/fragments/WebFragment;

    iget-object v2, v2, Lcom/mixerbox/mixerbox3b/fragments/WebFragment;->url:Ljava/lang/String;

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 148
    const-string v1, "action:share_web"

    invoke-static {v1, v0}, Lcom/flurry/android/FlurryAgent;->logEvent(Ljava/lang/String;Ljava/util/Map;)V

    .line 150
    new-instance v0, Landroid/content/Intent;

    const-string v1, "android.intent.action.SEND"

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 151
    const-string v1, "text/plain"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setType(Ljava/lang/String;)Landroid/content/Intent;

    .line 152
    const-string v1, "android.intent.extra.TEXT"

    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/fragments/WebFragment$5;->this$0:Lcom/mixerbox/mixerbox3b/fragments/WebFragment;

    iget-object v2, v2, Lcom/mixerbox/mixerbox3b/fragments/WebFragment;->url:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 153
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/fragments/WebFragment$5;->this$0:Lcom/mixerbox/mixerbox3b/fragments/WebFragment;

    const/4 v2, 0x0

    invoke-static {v0, v2}, Landroid/content/Intent;->createChooser(Landroid/content/Intent;Ljava/lang/CharSequence;)Landroid/content/Intent;

    move-result-object v0

    invoke-virtual {v1, v0}, Lcom/mixerbox/mixerbox3b/fragments/WebFragment;->startActivity(Landroid/content/Intent;)V

    .line 154
    return-void
.end method
