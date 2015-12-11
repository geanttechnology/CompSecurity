.class Lcom/poshmark/ui/fragments/MappPageFragment$JSInterface$1;
.super Ljava/lang/Object;
.source "MappPageFragment.java"

# interfaces
.implements Lcom/poshmark/utils/UIThreadTask$Callback;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/MappPageFragment$JSInterface;->executeCommand(Ljava/lang/String;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/poshmark/ui/fragments/MappPageFragment$JSInterface;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/MappPageFragment$JSInterface;)V
    .locals 0

    .prologue
    .line 407
    iput-object p1, p0, Lcom/poshmark/ui/fragments/MappPageFragment$JSInterface$1;->this$1:Lcom/poshmark/ui/fragments/MappPageFragment$JSInterface;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public runOnUIThread(Ljava/lang/Object;)V
    .locals 2
    .param p1, "data"    # Ljava/lang/Object;

    .prologue
    .line 410
    iget-object v0, p0, Lcom/poshmark/ui/fragments/MappPageFragment$JSInterface$1;->this$1:Lcom/poshmark/ui/fragments/MappPageFragment$JSInterface;

    iget-object v0, v0, Lcom/poshmark/ui/fragments/MappPageFragment$JSInterface;->this$0:Lcom/poshmark/ui/fragments/MappPageFragment;

    iget-object v0, v0, Lcom/poshmark/ui/fragments/MappPageFragment;->webView:Landroid/webkit/WebView;

    const-string v1, "javascript:gp_command.queue.ready=true;"

    invoke-virtual {v0, v1}, Landroid/webkit/WebView;->loadUrl(Ljava/lang/String;)V

    .line 411
    return-void
.end method
