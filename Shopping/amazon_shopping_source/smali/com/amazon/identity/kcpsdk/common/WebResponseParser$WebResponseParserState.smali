.class final enum Lcom/amazon/identity/kcpsdk/common/WebResponseParser$WebResponseParserState;
.super Ljava/lang/Enum;
.source "WebResponseParser.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/identity/kcpsdk/common/WebResponseParser;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x401a
    name = "WebResponseParserState"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amazon/identity/kcpsdk/common/WebResponseParser$WebResponseParserState;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/amazon/identity/kcpsdk/common/WebResponseParser$WebResponseParserState;

.field public static final enum Before_Parse:Lcom/amazon/identity/kcpsdk/common/WebResponseParser$WebResponseParserState;

.field public static final enum Begin_Parse:Lcom/amazon/identity/kcpsdk/common/WebResponseParser$WebResponseParserState;

.field public static final enum Completed:Lcom/amazon/identity/kcpsdk/common/WebResponseParser$WebResponseParserState;

.field public static final enum Parsing:Lcom/amazon/identity/kcpsdk/common/WebResponseParser$WebResponseParserState;


# direct methods
.method static constructor <clinit>()V
    .locals 6

    .prologue
    const/4 v5, 0x3

    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 14
    new-instance v0, Lcom/amazon/identity/kcpsdk/common/WebResponseParser$WebResponseParserState;

    const-string/jumbo v1, "Before_Parse"

    invoke-direct {v0, v1, v2}, Lcom/amazon/identity/kcpsdk/common/WebResponseParser$WebResponseParserState;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/identity/kcpsdk/common/WebResponseParser$WebResponseParserState;->Before_Parse:Lcom/amazon/identity/kcpsdk/common/WebResponseParser$WebResponseParserState;

    .line 15
    new-instance v0, Lcom/amazon/identity/kcpsdk/common/WebResponseParser$WebResponseParserState;

    const-string/jumbo v1, "Begin_Parse"

    invoke-direct {v0, v1, v3}, Lcom/amazon/identity/kcpsdk/common/WebResponseParser$WebResponseParserState;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/identity/kcpsdk/common/WebResponseParser$WebResponseParserState;->Begin_Parse:Lcom/amazon/identity/kcpsdk/common/WebResponseParser$WebResponseParserState;

    .line 16
    new-instance v0, Lcom/amazon/identity/kcpsdk/common/WebResponseParser$WebResponseParserState;

    const-string/jumbo v1, "Parsing"

    invoke-direct {v0, v1, v4}, Lcom/amazon/identity/kcpsdk/common/WebResponseParser$WebResponseParserState;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/identity/kcpsdk/common/WebResponseParser$WebResponseParserState;->Parsing:Lcom/amazon/identity/kcpsdk/common/WebResponseParser$WebResponseParserState;

    .line 17
    new-instance v0, Lcom/amazon/identity/kcpsdk/common/WebResponseParser$WebResponseParserState;

    const-string/jumbo v1, "Completed"

    invoke-direct {v0, v1, v5}, Lcom/amazon/identity/kcpsdk/common/WebResponseParser$WebResponseParserState;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/identity/kcpsdk/common/WebResponseParser$WebResponseParserState;->Completed:Lcom/amazon/identity/kcpsdk/common/WebResponseParser$WebResponseParserState;

    .line 12
    const/4 v0, 0x4

    new-array v0, v0, [Lcom/amazon/identity/kcpsdk/common/WebResponseParser$WebResponseParserState;

    sget-object v1, Lcom/amazon/identity/kcpsdk/common/WebResponseParser$WebResponseParserState;->Before_Parse:Lcom/amazon/identity/kcpsdk/common/WebResponseParser$WebResponseParserState;

    aput-object v1, v0, v2

    sget-object v1, Lcom/amazon/identity/kcpsdk/common/WebResponseParser$WebResponseParserState;->Begin_Parse:Lcom/amazon/identity/kcpsdk/common/WebResponseParser$WebResponseParserState;

    aput-object v1, v0, v3

    sget-object v1, Lcom/amazon/identity/kcpsdk/common/WebResponseParser$WebResponseParserState;->Parsing:Lcom/amazon/identity/kcpsdk/common/WebResponseParser$WebResponseParserState;

    aput-object v1, v0, v4

    sget-object v1, Lcom/amazon/identity/kcpsdk/common/WebResponseParser$WebResponseParserState;->Completed:Lcom/amazon/identity/kcpsdk/common/WebResponseParser$WebResponseParserState;

    aput-object v1, v0, v5

    sput-object v0, Lcom/amazon/identity/kcpsdk/common/WebResponseParser$WebResponseParserState;->$VALUES:[Lcom/amazon/identity/kcpsdk/common/WebResponseParser$WebResponseParserState;

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
    .line 12
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/amazon/identity/kcpsdk/common/WebResponseParser$WebResponseParserState;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 12
    const-class v0, Lcom/amazon/identity/kcpsdk/common/WebResponseParser$WebResponseParserState;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amazon/identity/kcpsdk/common/WebResponseParser$WebResponseParserState;

    return-object v0
.end method

.method public static values()[Lcom/amazon/identity/kcpsdk/common/WebResponseParser$WebResponseParserState;
    .locals 1

    .prologue
    .line 12
    sget-object v0, Lcom/amazon/identity/kcpsdk/common/WebResponseParser$WebResponseParserState;->$VALUES:[Lcom/amazon/identity/kcpsdk/common/WebResponseParser$WebResponseParserState;

    invoke-virtual {v0}, [Lcom/amazon/identity/kcpsdk/common/WebResponseParser$WebResponseParserState;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amazon/identity/kcpsdk/common/WebResponseParser$WebResponseParserState;

    return-object v0
.end method
