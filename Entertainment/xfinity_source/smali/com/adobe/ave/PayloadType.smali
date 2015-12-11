.class public final enum Lcom/adobe/ave/PayloadType;
.super Ljava/lang/Enum;
.source "PayloadType.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/adobe/ave/PayloadType;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/adobe/ave/PayloadType;

.field public static final enum AUDIO:Lcom/adobe/ave/PayloadType;

.field public static final enum DATA:Lcom/adobe/ave/PayloadType;

.field public static final enum MAX:Lcom/adobe/ave/PayloadType;

.field public static final enum UNKNOWN:Lcom/adobe/ave/PayloadType;

.field public static final enum VIDEO:Lcom/adobe/ave/PayloadType;


# instance fields
.field private final value:I


# direct methods
.method static constructor <clinit>()V
    .locals 7

    .prologue
    const/4 v6, 0x4

    const/4 v5, 0x3

    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 29
    new-instance v0, Lcom/adobe/ave/PayloadType;

    const-string v1, "UNKNOWN"

    invoke-direct {v0, v1, v2, v2}, Lcom/adobe/ave/PayloadType;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/adobe/ave/PayloadType;->UNKNOWN:Lcom/adobe/ave/PayloadType;

    .line 34
    new-instance v0, Lcom/adobe/ave/PayloadType;

    const-string v1, "AUDIO"

    invoke-direct {v0, v1, v3, v3}, Lcom/adobe/ave/PayloadType;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/adobe/ave/PayloadType;->AUDIO:Lcom/adobe/ave/PayloadType;

    .line 39
    new-instance v0, Lcom/adobe/ave/PayloadType;

    const-string v1, "VIDEO"

    invoke-direct {v0, v1, v4, v4}, Lcom/adobe/ave/PayloadType;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/adobe/ave/PayloadType;->VIDEO:Lcom/adobe/ave/PayloadType;

    .line 44
    new-instance v0, Lcom/adobe/ave/PayloadType;

    const-string v1, "DATA"

    invoke-direct {v0, v1, v5, v5}, Lcom/adobe/ave/PayloadType;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/adobe/ave/PayloadType;->DATA:Lcom/adobe/ave/PayloadType;

    .line 49
    new-instance v0, Lcom/adobe/ave/PayloadType;

    const-string v1, "MAX"

    invoke-direct {v0, v1, v6, v6}, Lcom/adobe/ave/PayloadType;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/adobe/ave/PayloadType;->MAX:Lcom/adobe/ave/PayloadType;

    .line 24
    const/4 v0, 0x5

    new-array v0, v0, [Lcom/adobe/ave/PayloadType;

    sget-object v1, Lcom/adobe/ave/PayloadType;->UNKNOWN:Lcom/adobe/ave/PayloadType;

    aput-object v1, v0, v2

    sget-object v1, Lcom/adobe/ave/PayloadType;->AUDIO:Lcom/adobe/ave/PayloadType;

    aput-object v1, v0, v3

    sget-object v1, Lcom/adobe/ave/PayloadType;->VIDEO:Lcom/adobe/ave/PayloadType;

    aput-object v1, v0, v4

    sget-object v1, Lcom/adobe/ave/PayloadType;->DATA:Lcom/adobe/ave/PayloadType;

    aput-object v1, v0, v5

    sget-object v1, Lcom/adobe/ave/PayloadType;->MAX:Lcom/adobe/ave/PayloadType;

    aput-object v1, v0, v6

    sput-object v0, Lcom/adobe/ave/PayloadType;->$VALUES:[Lcom/adobe/ave/PayloadType;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;II)V
    .locals 0
    .param p3, "value"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I)V"
        }
    .end annotation

    .prologue
    .line 53
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 54
    iput p3, p0, Lcom/adobe/ave/PayloadType;->value:I

    .line 55
    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/adobe/ave/PayloadType;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 24
    const-class v0, Lcom/adobe/ave/PayloadType;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/adobe/ave/PayloadType;

    return-object v0
.end method

.method public static values()[Lcom/adobe/ave/PayloadType;
    .locals 1

    .prologue
    .line 24
    sget-object v0, Lcom/adobe/ave/PayloadType;->$VALUES:[Lcom/adobe/ave/PayloadType;

    invoke-virtual {v0}, [Lcom/adobe/ave/PayloadType;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/adobe/ave/PayloadType;

    return-object v0
.end method


# virtual methods
.method final getValue()I
    .locals 1

    .prologue
    .line 58
    iget v0, p0, Lcom/adobe/ave/PayloadType;->value:I

    return v0
.end method
