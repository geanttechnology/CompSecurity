.class public final enum Lcom/amazon/dee/result/bif/ScoreSource;
.super Ljava/lang/Enum;
.source "ScoreSource.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amazon/dee/result/bif/ScoreSource;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/amazon/dee/result/bif/ScoreSource;

.field public static final enum ASR:Lcom/amazon/dee/result/bif/ScoreSource;

.field public static final enum SLU:Lcom/amazon/dee/result/bif/ScoreSource;


# direct methods
.method static constructor <clinit>()V
    .locals 4

    .prologue
    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 9
    new-instance v0, Lcom/amazon/dee/result/bif/ScoreSource;

    const-string/jumbo v1, "ASR"

    invoke-direct {v0, v1, v2}, Lcom/amazon/dee/result/bif/ScoreSource;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/dee/result/bif/ScoreSource;->ASR:Lcom/amazon/dee/result/bif/ScoreSource;

    .line 10
    new-instance v0, Lcom/amazon/dee/result/bif/ScoreSource;

    const-string/jumbo v1, "SLU"

    invoke-direct {v0, v1, v3}, Lcom/amazon/dee/result/bif/ScoreSource;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/dee/result/bif/ScoreSource;->SLU:Lcom/amazon/dee/result/bif/ScoreSource;

    .line 7
    const/4 v0, 0x2

    new-array v0, v0, [Lcom/amazon/dee/result/bif/ScoreSource;

    sget-object v1, Lcom/amazon/dee/result/bif/ScoreSource;->ASR:Lcom/amazon/dee/result/bif/ScoreSource;

    aput-object v1, v0, v2

    sget-object v1, Lcom/amazon/dee/result/bif/ScoreSource;->SLU:Lcom/amazon/dee/result/bif/ScoreSource;

    aput-object v1, v0, v3

    sput-object v0, Lcom/amazon/dee/result/bif/ScoreSource;->$VALUES:[Lcom/amazon/dee/result/bif/ScoreSource;

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
    .line 7
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/amazon/dee/result/bif/ScoreSource;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 7
    const-class v0, Lcom/amazon/dee/result/bif/ScoreSource;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amazon/dee/result/bif/ScoreSource;

    return-object v0
.end method

.method public static values()[Lcom/amazon/dee/result/bif/ScoreSource;
    .locals 1

    .prologue
    .line 7
    sget-object v0, Lcom/amazon/dee/result/bif/ScoreSource;->$VALUES:[Lcom/amazon/dee/result/bif/ScoreSource;

    invoke-virtual {v0}, [Lcom/amazon/dee/result/bif/ScoreSource;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amazon/dee/result/bif/ScoreSource;

    return-object v0
.end method
