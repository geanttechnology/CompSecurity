.class public final enum Lcom/amazon/dee/result/bif/ERStatus;
.super Ljava/lang/Enum;
.source "ERStatus.java"


# annotations
.annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnoreProperties;
    ignoreUnknown = true
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amazon/dee/result/bif/ERStatus;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/amazon/dee/result/bif/ERStatus;

.field public static final enum ER_APP_FILLED:Lcom/amazon/dee/result/bif/ERStatus;

.field public static final enum ER_EXCEPTION:Lcom/amazon/dee/result/bif/ERStatus;

.field public static final enum ER_NO_MATCH:Lcom/amazon/dee/result/bif/ERStatus;

.field public static final enum ER_SUCCESS:Lcom/amazon/dee/result/bif/ERStatus;

.field public static final enum ER_TIMEOUT:Lcom/amazon/dee/result/bif/ERStatus;


# direct methods
.method static constructor <clinit>()V
    .locals 7

    .prologue
    const/4 v6, 0x4

    const/4 v5, 0x3

    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 14
    new-instance v0, Lcom/amazon/dee/result/bif/ERStatus;

    const-string/jumbo v1, "ER_EXCEPTION"

    invoke-direct {v0, v1, v2}, Lcom/amazon/dee/result/bif/ERStatus;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/dee/result/bif/ERStatus;->ER_EXCEPTION:Lcom/amazon/dee/result/bif/ERStatus;

    .line 18
    new-instance v0, Lcom/amazon/dee/result/bif/ERStatus;

    const-string/jumbo v1, "ER_TIMEOUT"

    invoke-direct {v0, v1, v3}, Lcom/amazon/dee/result/bif/ERStatus;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/dee/result/bif/ERStatus;->ER_TIMEOUT:Lcom/amazon/dee/result/bif/ERStatus;

    .line 22
    new-instance v0, Lcom/amazon/dee/result/bif/ERStatus;

    const-string/jumbo v1, "ER_NO_MATCH"

    invoke-direct {v0, v1, v4}, Lcom/amazon/dee/result/bif/ERStatus;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/dee/result/bif/ERStatus;->ER_NO_MATCH:Lcom/amazon/dee/result/bif/ERStatus;

    .line 26
    new-instance v0, Lcom/amazon/dee/result/bif/ERStatus;

    const-string/jumbo v1, "ER_SUCCESS"

    invoke-direct {v0, v1, v5}, Lcom/amazon/dee/result/bif/ERStatus;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/dee/result/bif/ERStatus;->ER_SUCCESS:Lcom/amazon/dee/result/bif/ERStatus;

    .line 33
    new-instance v0, Lcom/amazon/dee/result/bif/ERStatus;

    const-string/jumbo v1, "ER_APP_FILLED"

    invoke-direct {v0, v1, v6}, Lcom/amazon/dee/result/bif/ERStatus;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/dee/result/bif/ERStatus;->ER_APP_FILLED:Lcom/amazon/dee/result/bif/ERStatus;

    .line 8
    const/4 v0, 0x5

    new-array v0, v0, [Lcom/amazon/dee/result/bif/ERStatus;

    sget-object v1, Lcom/amazon/dee/result/bif/ERStatus;->ER_EXCEPTION:Lcom/amazon/dee/result/bif/ERStatus;

    aput-object v1, v0, v2

    sget-object v1, Lcom/amazon/dee/result/bif/ERStatus;->ER_TIMEOUT:Lcom/amazon/dee/result/bif/ERStatus;

    aput-object v1, v0, v3

    sget-object v1, Lcom/amazon/dee/result/bif/ERStatus;->ER_NO_MATCH:Lcom/amazon/dee/result/bif/ERStatus;

    aput-object v1, v0, v4

    sget-object v1, Lcom/amazon/dee/result/bif/ERStatus;->ER_SUCCESS:Lcom/amazon/dee/result/bif/ERStatus;

    aput-object v1, v0, v5

    sget-object v1, Lcom/amazon/dee/result/bif/ERStatus;->ER_APP_FILLED:Lcom/amazon/dee/result/bif/ERStatus;

    aput-object v1, v0, v6

    sput-object v0, Lcom/amazon/dee/result/bif/ERStatus;->$VALUES:[Lcom/amazon/dee/result/bif/ERStatus;

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
    .line 9
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/amazon/dee/result/bif/ERStatus;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 8
    const-class v0, Lcom/amazon/dee/result/bif/ERStatus;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amazon/dee/result/bif/ERStatus;

    return-object v0
.end method

.method public static values()[Lcom/amazon/dee/result/bif/ERStatus;
    .locals 1

    .prologue
    .line 8
    sget-object v0, Lcom/amazon/dee/result/bif/ERStatus;->$VALUES:[Lcom/amazon/dee/result/bif/ERStatus;

    invoke-virtual {v0}, [Lcom/amazon/dee/result/bif/ERStatus;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amazon/dee/result/bif/ERStatus;

    return-object v0
.end method
