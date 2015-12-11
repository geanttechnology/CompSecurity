.class public abstract Lcom/poshmark/webcommands/CommandCompletionHandler;
.super Ljava/lang/Object;
.source "CommandCompletionHandler.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/poshmark/webcommands/CommandCompletionHandler$1;,
        Lcom/poshmark/webcommands/CommandCompletionHandler$HandlerType;
    }
.end annotation


# instance fields
.field type:Lcom/poshmark/webcommands/CommandCompletionHandler$HandlerType;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 10
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 12
    sget-object v0, Lcom/poshmark/webcommands/CommandCompletionHandler$HandlerType;->SIMPLE_CALLBACK:Lcom/poshmark/webcommands/CommandCompletionHandler$HandlerType;

    iput-object v0, p0, Lcom/poshmark/webcommands/CommandCompletionHandler;->type:Lcom/poshmark/webcommands/CommandCompletionHandler$HandlerType;

    return-void
.end method

.method static factory(Lcom/poshmark/webcommands/CommandCompletionHandler$HandlerType;)Lcom/poshmark/webcommands/CommandCompletionHandler;
    .locals 2
    .param p0, "type"    # Lcom/poshmark/webcommands/CommandCompletionHandler$HandlerType;

    .prologue
    .line 17
    sget-object v0, Lcom/poshmark/webcommands/CommandCompletionHandler$1;->$SwitchMap$com$poshmark$webcommands$CommandCompletionHandler$HandlerType:[I

    invoke-virtual {p0}, Lcom/poshmark/webcommands/CommandCompletionHandler$HandlerType;->ordinal()I

    move-result v1

    aget v0, v0, v1

    packed-switch v0, :pswitch_data_0

    .line 21
    const/4 v0, 0x0

    :goto_0
    return-object v0

    .line 19
    :pswitch_0
    new-instance v0, Lcom/poshmark/webcommands/TakePictureCompletionHandler;

    invoke-direct {v0}, Lcom/poshmark/webcommands/TakePictureCompletionHandler;-><init>()V

    goto :goto_0

    .line 17
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
    .end packed-switch
.end method


# virtual methods
.method public handleCommandResults(Lcom/poshmark/ui/fragments/MappPageFragment;Lcom/poshmark/webcommands/WebCommand;Landroid/content/Intent;)V
    .locals 0
    .param p1, "fragment"    # Lcom/poshmark/ui/fragments/MappPageFragment;
    .param p2, "command"    # Lcom/poshmark/webcommands/WebCommand;
    .param p3, "data"    # Landroid/content/Intent;

    .prologue
    .line 14
    return-void
.end method
