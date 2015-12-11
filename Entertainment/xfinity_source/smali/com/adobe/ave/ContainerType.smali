.class public final enum Lcom/adobe/ave/ContainerType;
.super Ljava/lang/Enum;
.source "ContainerType.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/adobe/ave/ContainerType;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/adobe/ave/ContainerType;

.field public static final enum F4M:Lcom/adobe/ave/ContainerType;

.field public static final enum FLV:Lcom/adobe/ave/ContainerType;

.field public static final enum HLS:Lcom/adobe/ave/ContainerType;

.field public static final enum MAX_TYPES:Lcom/adobe/ave/ContainerType;

.field public static final enum MP4:Lcom/adobe/ave/ContainerType;

.field public static final enum UNDEFINED:Lcom/adobe/ave/ContainerType;


# instance fields
.field private final value:I


# direct methods
.method static constructor <clinit>()V
    .locals 9

    .prologue
    const/4 v8, 0x4

    const/4 v7, 0x3

    const/4 v6, 0x2

    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 29
    new-instance v0, Lcom/adobe/ave/ContainerType;

    const-string v1, "UNDEFINED"

    invoke-direct {v0, v1, v4, v4}, Lcom/adobe/ave/ContainerType;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/adobe/ave/ContainerType;->UNDEFINED:Lcom/adobe/ave/ContainerType;

    .line 34
    new-instance v0, Lcom/adobe/ave/ContainerType;

    const-string v1, "FLV"

    invoke-direct {v0, v1, v5, v5}, Lcom/adobe/ave/ContainerType;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/adobe/ave/ContainerType;->FLV:Lcom/adobe/ave/ContainerType;

    .line 43
    new-instance v0, Lcom/adobe/ave/ContainerType;

    const-string v1, "F4M"

    invoke-direct {v0, v1, v6, v6}, Lcom/adobe/ave/ContainerType;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/adobe/ave/ContainerType;->F4M:Lcom/adobe/ave/ContainerType;

    .line 48
    new-instance v0, Lcom/adobe/ave/ContainerType;

    const-string v1, "HLS"

    invoke-direct {v0, v1, v7, v7}, Lcom/adobe/ave/ContainerType;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/adobe/ave/ContainerType;->HLS:Lcom/adobe/ave/ContainerType;

    .line 53
    new-instance v0, Lcom/adobe/ave/ContainerType;

    const-string v1, "MP4"

    invoke-direct {v0, v1, v8, v8}, Lcom/adobe/ave/ContainerType;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/adobe/ave/ContainerType;->MP4:Lcom/adobe/ave/ContainerType;

    .line 58
    new-instance v0, Lcom/adobe/ave/ContainerType;

    const-string v1, "MAX_TYPES"

    const/4 v2, 0x5

    const/4 v3, 0x5

    invoke-direct {v0, v1, v2, v3}, Lcom/adobe/ave/ContainerType;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/adobe/ave/ContainerType;->MAX_TYPES:Lcom/adobe/ave/ContainerType;

    .line 24
    const/4 v0, 0x6

    new-array v0, v0, [Lcom/adobe/ave/ContainerType;

    sget-object v1, Lcom/adobe/ave/ContainerType;->UNDEFINED:Lcom/adobe/ave/ContainerType;

    aput-object v1, v0, v4

    sget-object v1, Lcom/adobe/ave/ContainerType;->FLV:Lcom/adobe/ave/ContainerType;

    aput-object v1, v0, v5

    sget-object v1, Lcom/adobe/ave/ContainerType;->F4M:Lcom/adobe/ave/ContainerType;

    aput-object v1, v0, v6

    sget-object v1, Lcom/adobe/ave/ContainerType;->HLS:Lcom/adobe/ave/ContainerType;

    aput-object v1, v0, v7

    sget-object v1, Lcom/adobe/ave/ContainerType;->MP4:Lcom/adobe/ave/ContainerType;

    aput-object v1, v0, v8

    const/4 v1, 0x5

    sget-object v2, Lcom/adobe/ave/ContainerType;->MAX_TYPES:Lcom/adobe/ave/ContainerType;

    aput-object v2, v0, v1

    sput-object v0, Lcom/adobe/ave/ContainerType;->$VALUES:[Lcom/adobe/ave/ContainerType;

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
    .line 62
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 63
    iput p3, p0, Lcom/adobe/ave/ContainerType;->value:I

    .line 64
    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/adobe/ave/ContainerType;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 24
    const-class v0, Lcom/adobe/ave/ContainerType;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/adobe/ave/ContainerType;

    return-object v0
.end method

.method public static values()[Lcom/adobe/ave/ContainerType;
    .locals 1

    .prologue
    .line 24
    sget-object v0, Lcom/adobe/ave/ContainerType;->$VALUES:[Lcom/adobe/ave/ContainerType;

    invoke-virtual {v0}, [Lcom/adobe/ave/ContainerType;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/adobe/ave/ContainerType;

    return-object v0
.end method


# virtual methods
.method final getValue()I
    .locals 1

    .prologue
    .line 67
    iget v0, p0, Lcom/adobe/ave/ContainerType;->value:I

    return v0
.end method
