.class Lcom/poshmark/ui/fragments/MappPageFragment$7;
.super Landroid/webkit/WebChromeClient;
.source "MappPageFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/MappPageFragment;->setupWebClient()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/MappPageFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/MappPageFragment;)V
    .locals 0

    .prologue
    .line 340
    iput-object p1, p0, Lcom/poshmark/ui/fragments/MappPageFragment$7;->this$0:Lcom/poshmark/ui/fragments/MappPageFragment;

    invoke-direct {p0}, Landroid/webkit/WebChromeClient;-><init>()V

    return-void
.end method


# virtual methods
.method public onConsoleMessage(Landroid/webkit/ConsoleMessage;)Z
    .locals 3
    .param p1, "cm"    # Landroid/webkit/ConsoleMessage;

    .prologue
    .line 343
    const-string v0, "MyApplication"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p1}, Landroid/webkit/ConsoleMessage;->message()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " -- From line "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p1}, Landroid/webkit/ConsoleMessage;->lineNumber()I

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " of "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p1}, Landroid/webkit/ConsoleMessage;->sourceId()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 346
    const/4 v0, 0x1

    return v0
.end method

.method public onReceivedTitle(Landroid/webkit/WebView;Ljava/lang/String;)V
    .locals 2
    .param p1, "view"    # Landroid/webkit/WebView;
    .param p2, "pageTitle"    # Ljava/lang/String;

    .prologue
    .line 351
    invoke-super {p0, p1, p2}, Landroid/webkit/WebChromeClient;->onReceivedTitle(Landroid/webkit/WebView;Ljava/lang/String;)V

    .line 352
    if-eqz p2, :cond_0

    invoke-virtual {p2}, Ljava/lang/String;->length()I

    move-result v0

    if-lez v0, :cond_0

    .line 353
    iget-object v0, p0, Lcom/poshmark/ui/fragments/MappPageFragment$7;->this$0:Lcom/poshmark/ui/fragments/MappPageFragment;

    iget-object v0, v0, Lcom/poshmark/ui/fragments/MappPageFragment;->title:Ljava/lang/String;

    if-nez v0, :cond_0

    .line 354
    iget-object v0, p0, Lcom/poshmark/ui/fragments/MappPageFragment$7;->this$0:Lcom/poshmark/ui/fragments/MappPageFragment;

    iput-object p2, v0, Lcom/poshmark/ui/fragments/MappPageFragment;->title:Ljava/lang/String;

    .line 355
    iget-object v0, p0, Lcom/poshmark/ui/fragments/MappPageFragment$7;->this$0:Lcom/poshmark/ui/fragments/MappPageFragment;

    invoke-virtual {v0}, Lcom/poshmark/ui/fragments/MappPageFragment;->getUserVisibleHint()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 356
    iget-object v0, p0, Lcom/poshmark/ui/fragments/MappPageFragment$7;->this$0:Lcom/poshmark/ui/fragments/MappPageFragment;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/MappPageFragment$7;->this$0:Lcom/poshmark/ui/fragments/MappPageFragment;

    iget-object v1, v1, Lcom/poshmark/ui/fragments/MappPageFragment;->title:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/fragments/MappPageFragment;->setTitle(Ljava/lang/String;)V

    .line 361
    :cond_0
    return-void
.end method
