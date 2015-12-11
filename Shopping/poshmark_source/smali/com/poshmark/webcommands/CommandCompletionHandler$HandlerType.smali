.class final enum Lcom/poshmark/webcommands/CommandCompletionHandler$HandlerType;
.super Ljava/lang/Enum;
.source "CommandCompletionHandler.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/webcommands/CommandCompletionHandler;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4018
    name = "HandlerType"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/poshmark/webcommands/CommandCompletionHandler$HandlerType;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/poshmark/webcommands/CommandCompletionHandler$HandlerType;

.field public static final enum PICTURE:Lcom/poshmark/webcommands/CommandCompletionHandler$HandlerType;

.field public static final enum SIMPLE_CALLBACK:Lcom/poshmark/webcommands/CommandCompletionHandler$HandlerType;

.field public static final enum START_LISTINGS_FLOW:Lcom/poshmark/webcommands/CommandCompletionHandler$HandlerType;


# direct methods
.method static constructor <clinit>()V
    .locals 5

    .prologue
    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 11
    new-instance v0, Lcom/poshmark/webcommands/CommandCompletionHandler$HandlerType;

    const-string v1, "PICTURE"

    invoke-direct {v0, v1, v2}, Lcom/poshmark/webcommands/CommandCompletionHandler$HandlerType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/webcommands/CommandCompletionHandler$HandlerType;->PICTURE:Lcom/poshmark/webcommands/CommandCompletionHandler$HandlerType;

    new-instance v0, Lcom/poshmark/webcommands/CommandCompletionHandler$HandlerType;

    const-string v1, "START_LISTINGS_FLOW"

    invoke-direct {v0, v1, v3}, Lcom/poshmark/webcommands/CommandCompletionHandler$HandlerType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/webcommands/CommandCompletionHandler$HandlerType;->START_LISTINGS_FLOW:Lcom/poshmark/webcommands/CommandCompletionHandler$HandlerType;

    new-instance v0, Lcom/poshmark/webcommands/CommandCompletionHandler$HandlerType;

    const-string v1, "SIMPLE_CALLBACK"

    invoke-direct {v0, v1, v4}, Lcom/poshmark/webcommands/CommandCompletionHandler$HandlerType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/webcommands/CommandCompletionHandler$HandlerType;->SIMPLE_CALLBACK:Lcom/poshmark/webcommands/CommandCompletionHandler$HandlerType;

    const/4 v0, 0x3

    new-array v0, v0, [Lcom/poshmark/webcommands/CommandCompletionHandler$HandlerType;

    sget-object v1, Lcom/poshmark/webcommands/CommandCompletionHandler$HandlerType;->PICTURE:Lcom/poshmark/webcommands/CommandCompletionHandler$HandlerType;

    aput-object v1, v0, v2

    sget-object v1, Lcom/poshmark/webcommands/CommandCompletionHandler$HandlerType;->START_LISTINGS_FLOW:Lcom/poshmark/webcommands/CommandCompletionHandler$HandlerType;

    aput-object v1, v0, v3

    sget-object v1, Lcom/poshmark/webcommands/CommandCompletionHandler$HandlerType;->SIMPLE_CALLBACK:Lcom/poshmark/webcommands/CommandCompletionHandler$HandlerType;

    aput-object v1, v0, v4

    sput-object v0, Lcom/poshmark/webcommands/CommandCompletionHandler$HandlerType;->$VALUES:[Lcom/poshmark/webcommands/CommandCompletionHandler$HandlerType;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;I)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()V"
        }
    .end annotation

    .prologue
    .line 11
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/poshmark/webcommands/CommandCompletionHandler$HandlerType;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 11
    const-class v0, Lcom/poshmark/webcommands/CommandCompletionHandler$HandlerType;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/poshmark/webcommands/CommandCompletionHandler$HandlerType;

    return-object v0
.end method

.method public static values()[Lcom/poshmark/webcommands/CommandCompletionHandler$HandlerType;
    .locals 1

    .prologue
    .line 11
    sget-object v0, Lcom/poshmark/webcommands/CommandCompletionHandler$HandlerType;->$VALUES:[Lcom/poshmark/webcommands/CommandCompletionHandler$HandlerType;

    invoke-virtual {v0}, [Lcom/poshmark/webcommands/CommandCompletionHandler$HandlerType;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/poshmark/webcommands/CommandCompletionHandler$HandlerType;

    return-object v0
.end method
