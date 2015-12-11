.class public Lcom/poshmark/webcommands/WebCommand;
.super Ljava/lang/Object;
.source "WebCommand.java"

# interfaces
.implements Lcom/poshmark/utils/PMSerializer;


# instance fields
.field commandHashCode:I

.field commandName:Ljava/lang/String;

.field transient completionHandler:Lcom/poshmark/webcommands/CommandCompletionHandler;

.field dictionary:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field handlerType:Lcom/poshmark/webcommands/CommandCompletionHandler$HandlerType;

.field js_callback:Ljava/lang/String;

.field parameters:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 2

    .prologue
    .line 29
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 34
    new-instance v0, Ljava/util/Random;

    invoke-direct {v0}, Ljava/util/Random;-><init>()V

    .line 35
    .local v0, "generator":Ljava/util/Random;
    const v1, 0xffff

    invoke-virtual {v0, v1}, Ljava/util/Random;->nextInt(I)I

    move-result v1

    iput v1, p0, Lcom/poshmark/webcommands/WebCommand;->commandHashCode:I

    .line 36
    return-void
.end method


# virtual methods
.method public commandHashCode()I
    .locals 1

    .prologue
    .line 49
    iget v0, p0, Lcom/poshmark/webcommands/WebCommand;->commandHashCode:I

    return v0
.end method

.method public handleCommandResults(Lcom/poshmark/ui/fragments/MappPageFragment;Landroid/content/Intent;)V
    .locals 1
    .param p1, "fragment"    # Lcom/poshmark/ui/fragments/MappPageFragment;
    .param p2, "data"    # Landroid/content/Intent;

    .prologue
    .line 43
    iget-object v0, p0, Lcom/poshmark/webcommands/WebCommand;->completionHandler:Lcom/poshmark/webcommands/CommandCompletionHandler;

    if-eqz v0, :cond_0

    .line 44
    iget-object v0, p0, Lcom/poshmark/webcommands/WebCommand;->completionHandler:Lcom/poshmark/webcommands/CommandCompletionHandler;

    invoke-virtual {v0, p1, p0, p2}, Lcom/poshmark/webcommands/CommandCompletionHandler;->handleCommandResults(Lcom/poshmark/ui/fragments/MappPageFragment;Lcom/poshmark/webcommands/WebCommand;Landroid/content/Intent;)V

    .line 46
    :cond_0
    return-void
.end method

.method public serialize()Ljava/lang/String;
    .locals 5

    .prologue
    .line 54
    new-instance v0, Lcom/google/gson/GsonBuilder;

    invoke-direct {v0}, Lcom/google/gson/GsonBuilder;-><init>()V

    .line 55
    .local v0, "b":Lcom/google/gson/GsonBuilder;
    invoke-virtual {v0}, Lcom/google/gson/GsonBuilder;->create()Lcom/google/gson/Gson;

    move-result-object v1

    .line 57
    .local v1, "gson":Lcom/google/gson/Gson;
    const-class v3, Lcom/poshmark/webcommands/WebCommand;

    instance-of v4, v1, Lcom/google/gson/Gson;

    if-nez v4, :cond_0

    invoke-virtual {v1, p0, v3}, Lcom/google/gson/Gson;->toJson(Ljava/lang/Object;Ljava/lang/reflect/Type;)Ljava/lang/String;

    move-result-object v2

    .line 59
    .end local v1    # "gson":Lcom/google/gson/Gson;
    .local v2, "str":Ljava/lang/String;
    :goto_0
    return-object v2

    .line 57
    .end local v2    # "str":Ljava/lang/String;
    .restart local v1    # "gson":Lcom/google/gson/Gson;
    :cond_0
    check-cast v1, Lcom/google/gson/Gson;

    .end local v1    # "gson":Lcom/google/gson/Gson;
    invoke-static {v1, p0, v3}, Lcom/newrelic/agent/android/instrumentation/GsonInstrumentation;->toJson(Lcom/google/gson/Gson;Ljava/lang/Object;Ljava/lang/reflect/Type;)Ljava/lang/String;

    move-result-object v2

    goto :goto_0
.end method

.method public setCommandCompletionHandler(Lcom/poshmark/webcommands/CommandCompletionHandler;)V
    .locals 1
    .param p1, "handler"    # Lcom/poshmark/webcommands/CommandCompletionHandler;

    .prologue
    .line 38
    iput-object p1, p0, Lcom/poshmark/webcommands/WebCommand;->completionHandler:Lcom/poshmark/webcommands/CommandCompletionHandler;

    .line 39
    iget-object v0, p1, Lcom/poshmark/webcommands/CommandCompletionHandler;->type:Lcom/poshmark/webcommands/CommandCompletionHandler$HandlerType;

    iput-object v0, p0, Lcom/poshmark/webcommands/WebCommand;->handlerType:Lcom/poshmark/webcommands/CommandCompletionHandler$HandlerType;

    .line 40
    return-void
.end method
