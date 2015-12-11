.class synthetic Lcom/poshmark/webcommands/CommandCompletionHandler$1;
.super Ljava/lang/Object;
.source "CommandCompletionHandler.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/webcommands/CommandCompletionHandler;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1008
    name = null
.end annotation


# static fields
.field static final synthetic $SwitchMap$com$poshmark$webcommands$CommandCompletionHandler$HandlerType:[I


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    .line 17
    invoke-static {}, Lcom/poshmark/webcommands/CommandCompletionHandler$HandlerType;->values()[Lcom/poshmark/webcommands/CommandCompletionHandler$HandlerType;

    move-result-object v0

    array-length v0, v0

    new-array v0, v0, [I

    sput-object v0, Lcom/poshmark/webcommands/CommandCompletionHandler$1;->$SwitchMap$com$poshmark$webcommands$CommandCompletionHandler$HandlerType:[I

    :try_start_0
    sget-object v0, Lcom/poshmark/webcommands/CommandCompletionHandler$1;->$SwitchMap$com$poshmark$webcommands$CommandCompletionHandler$HandlerType:[I

    sget-object v1, Lcom/poshmark/webcommands/CommandCompletionHandler$HandlerType;->PICTURE:Lcom/poshmark/webcommands/CommandCompletionHandler$HandlerType;

    invoke-virtual {v1}, Lcom/poshmark/webcommands/CommandCompletionHandler$HandlerType;->ordinal()I

    move-result v1

    const/4 v2, 0x1

    aput v2, v0, v1
    :try_end_0
    .catch Ljava/lang/NoSuchFieldError; {:try_start_0 .. :try_end_0} :catch_0

    :goto_0
    return-void

    :catch_0
    move-exception v0

    goto :goto_0
.end method
