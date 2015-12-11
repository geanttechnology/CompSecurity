.class public Lcom/poshmark/webcommands/CompleteOfferHandler;
.super Lcom/poshmark/webcommands/CommandCompletionHandler;
.source "CompleteOfferHandler.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 14
    invoke-direct {p0}, Lcom/poshmark/webcommands/CommandCompletionHandler;-><init>()V

    return-void
.end method


# virtual methods
.method public handleCommandResults(Lcom/poshmark/ui/fragments/MappPageFragment;Lcom/poshmark/webcommands/WebCommand;Landroid/content/Intent;)V
    .locals 1
    .param p1, "fragment"    # Lcom/poshmark/ui/fragments/MappPageFragment;
    .param p2, "command"    # Lcom/poshmark/webcommands/WebCommand;
    .param p3, "data"    # Landroid/content/Intent;

    .prologue
    .line 17
    instance-of v0, p1, Lcom/poshmark/ui/fragments/MappPageFragment;

    if-eqz v0, :cond_0

    .line 18
    invoke-virtual {p1}, Lcom/poshmark/ui/fragments/MappPageFragment;->reload()V

    .line 20
    :cond_0
    return-void
.end method
